package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectHandler {

    public void serializePersonObjects(String textFileName, String objectFileName) {
        TextRead textRead = new TextRead();
        List<Person> personObjectList = textRead.objectFactory(textFileName);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(objectFileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Person person : personObjectList) {
                objectOutputStream.writeObject(person);
            }

            objectOutputStream.close();

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public List<Person> deserializePeronObjects(String fileName) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        List<Person> personObjectList = new ArrayList<Person>();

        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);

            Boolean bool = true;

            while (bool) {
                try {
                    Person personObject = (Person) objectInputStream.readObject();
                    personObjectList.add(personObject);
                } catch (EOFException e) {
                    bool = false;
                }
            }

            objectInputStream.close();

        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return personObjectList;
    }

}
