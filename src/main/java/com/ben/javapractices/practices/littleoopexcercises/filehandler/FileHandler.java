package com.ben.javapractices.practices.littleoopexcercises.filehandler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class FileHandler {

    private FileOutputStream stream;

    FileHandler(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        stream = new FileOutputStream(file);
    }

    void writeData(int data) throws IOException {
        stream.write(data);
    }

    void closeFile() throws IOException {
        stream.close();
    }

}
