package com.ben.javapractices.utils.filedatecorrection;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileTime;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.apache.commons.io.FilenameUtils;

import lombok.experimental.UtilityClass;

/*
 * This class corrects the creation dates all of the files under a directory in all depths.
 * The creation date acquired from the name of the file's parent directory.
 */
@UtilityClass
public class FileDateCorrectionUtil {

    private final HashMap<LocalDateTime, List<File>> fileMap = new HashMap<>();

    private int NUMBER_OF_FILES_TO_BE_PROCESSED = 0;

    private int NUMBER_OF_FILES_PROCESSED = 0;

    private final File LOG_FILE = new File("C:\\Users\\"
                                           + System.getProperty("user.name")
                                           + "\\Downloads\\"
                                           + LocalDate.now()
                                           + "-file-date-correction-util.log");

    private final int ROUND_DECIMAL_PLACES = 1;

    private final String ZONE_ID = "Europe/Budapest";

    private final int CREATION_HOUR = 8;

    private final int CREATION_MINUTES = 0;

//    private final String[] EXIFTOOL_ALLOWED_FILE_EXTENSIONS = {"jpg"};

    private final String[] ALLOWED_FILE_EXTENSIONS_FOR_RENAMING =
        { "jpg", "jpg", "mp4", "avi", "mov", "mpg", "gif", "wav" };

    void correctFileDates(String directoryPath) {
        getFiles(directoryPath);

        try {
            for (LocalDateTime creationDate : fileMap.keySet()) {
                for (File file : fileMap.get(creationDate)) {
                    logToFile(file.getName());

                    setFileCreationDate(file, creationDate);

                    NUMBER_OF_FILES_PROCESSED++;

                    float process = (float) NUMBER_OF_FILES_PROCESSED * 100 / NUMBER_OF_FILES_TO_BE_PROCESSED;

                    System.out.println(round(process) + " %");
                }
            }
        } catch (IOException iOException) {
            iOException.printStackTrace();
            logToFile(iOException.toString());
        }
    }

    private float round(float process) {
        BigDecimal bigDecimal = new BigDecimal(Float.toString(process));
        bigDecimal = bigDecimal.setScale(ROUND_DECIMAL_PLACES, RoundingMode.HALF_UP);
        return bigDecimal.floatValue();
    }

    private void getFiles(String workingDirectory) {
        boolean isFirstFileInDirectory = true;
        LocalDateTime fileCreationDate = LocalDateTime.now();

        File[] filesInWorkingDirectory = Objects.requireNonNull(new File(workingDirectory).listFiles());
        List<File> fileList = new ArrayList<>();

        for (File file : filesInWorkingDirectory) {
            if (!file.isDirectory()) {
                if (isExtensionAllowed(file)) {
                    if (isFirstFileInDirectory) {
                        fileCreationDate = getFileCreationDateFromParentDirectoryName(file.getParentFile().getName());
                        isFirstFileInDirectory = false;
                    }

                    List<File> fileMapEntry = fileMap.get(fileCreationDate);
                    if (fileMapEntry != null) {
                        fileMapEntry.add(file);
                    } else {
                        fileList.add(file);
                        fileMap.put(fileCreationDate, fileList);
                    }

                    NUMBER_OF_FILES_TO_BE_PROCESSED++;
                }
            } else {
                workingDirectory = file.getAbsolutePath();
                getFiles(workingDirectory);
            }
        }
    }

    private LocalDateTime getFileCreationDateFromParentDirectoryName(String parentDirectoryName) {
        String[] creationDateString = parentDirectoryName.split(" ")[0].split("-");

        int creationYear = Integer.parseInt(creationDateString[0]);
        int creationMonth = creationDateString.length > 1 ? (creationDateString[1].length() <= 2
            ? Integer.parseInt(creationDateString[1])
            : 1) : 1;
        int creationDay = creationDateString.length == 3 ? Integer.parseInt(creationDateString[2]) : 1;

        return LocalDateTime.of(creationYear, creationMonth, creationDay, CREATION_HOUR, CREATION_MINUTES);
    }

    private void setFileCreationDate(File file, LocalDateTime creationDate) throws IOException {
        ZonedDateTime zonedDateTime = creationDate.atZone(ZoneId.of(ZONE_ID));
        long creationDateInMillis = zonedDateTime.toInstant().toEpochMilli();

        BasicFileAttributeView attributes =
            Files.getFileAttributeView(Paths.get(file.getAbsolutePath()), BasicFileAttributeView.class);
        FileTime time = FileTime.fromMillis(creationDateInMillis);
        attributes.setTimes(time, time, time);
    }

    /*
        private void removeAllExifTagMetaData(File file) {
            if (isExtensionAllowed(file, EXIFTOOL_ALLOWED_FILE_EXTENSIONS)) {
                try {
                    String command = "exiftool -all= -overwrite_original \"" + file.getAbsolutePath() + "\"";

                    Runtime.getRuntime().exec(command);

                    Process process = Runtime.getRuntime().exec(command);
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String outputLine;
                    while ((outputLine = reader.readLine()) != null) {
                        logToFile(outputLine);
                    }
                } catch (IOException iOException) {
                    iOException.printStackTrace();

                    logToFile(iOException.toString());
                }
            }
        }
*/
    private boolean isExtensionAllowed(File file) {
        String fileExtension = FilenameUtils.getExtension(file.getAbsolutePath());

        for (String allowedExtension : FileDateCorrectionUtil.ALLOWED_FILE_EXTENSIONS_FOR_RENAMING) {
            if (allowedExtension.equals(fileExtension)) {
                return true;
            }
        }

        return false;
    }

    private void logToFile(String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
            bufferedWriter.write(content + "\n");
        } catch (IOException iOException) {
            iOException.printStackTrace();

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(LOG_FILE, true))) {
                bufferedWriter.write(iOException.toString());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }
    }

}
