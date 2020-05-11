package com.ben.javapractices.practices.collectionsandfileoperations.mp3tag;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ID3Tag {

    private String title;

    private String artist;

    private String album;

    private int year;

    private String comment;

    private int genre;

    private ID3Tag() {
    }

    private static byte[] readXBytes(byte[] byteArray, int startingPosition, int endingPosition) {
        byte[] resultArray = new byte[endingPosition - startingPosition];
        if (endingPosition - startingPosition >= 0) {
            System.arraycopy(byteArray, startingPosition, resultArray, 0, endingPosition - startingPosition);
        }
        return resultArray;
    }

    static ID3Tag parse(File file) {
        byte[] last128 = tail(file);
        byte[] baTitle = readXBytes(last128, 3, 33);
        String title = new String(baTitle);
        ID3Tag tag = new ID3Tag();
        tag.setTitle(title);
        return tag;
    }

    private static byte[] tail(File file) {
        try {
            RandomAccessFile fileHandler = new RandomAccessFile(file, "r");
            long fileLength = fileHandler.length() - 1;
            byte[] buffer = new byte[128];

            for (int i = 0; i < buffer.length; i++) {
                fileHandler.seek(fileLength - 127 + i);
                buffer[i] = fileHandler.readByte();
            }
            fileHandler.close();
            return buffer;
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ID3Tag tag1 = ID3Tag.parse(new File("music.mp3"));
        ID3Tag tag2 = ID3Tag.parse(new File("music.mp3"));
        ID3Tag tag3 = ID3Tag.parse(new File("music.mp3"));
        ID3Tag tag4 = ID3Tag.parse(new File("music.mp3"));
        ID3Tag tag5 = ID3Tag.parse(new File("music.mp3"));
        List<ID3Tag> tagsList = new ArrayList<ID3Tag>();
        tagsList.add(tag1);
        tagsList.add(tag2);
        tagsList.add(tag3);
        tagsList.add(tag4);
        tagsList.add(tag5);
        int i = tagsList.indexOf(tag4);
        System.out.println(i);
    }

    @Override
    public boolean equals(Object object) {
        ID3Tag tag = (ID3Tag) object;
        return ((title == null && tag.title == null) || title.equals(tag.title))
               && ((artist == null && tag.artist == null) || artist.equals(tag.artist))
               && ((album == null && tag.album == null) || album.equals(tag.album)) && (year == tag.year)
               && ((comment == null && tag.comment == null) || comment.equals(tag.comment)) && (genre == tag.genre);
    }

    @Override
    public int hashCode() {
        return -1;
    }

    @Override
    public String toString() {
        return "Artist: " + (artist == null ? "NULL" : artist).trim() + "\tAlbum: " + album + "\tTitle: "
               + title.trim();
    }

}
