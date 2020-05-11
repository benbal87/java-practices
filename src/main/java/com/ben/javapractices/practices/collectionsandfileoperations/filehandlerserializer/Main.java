package com.ben.javapractices.practices.collectionsandfileoperations.filehandlerserializer;

import com.ben.javapractices.utils.Util;

class Main {

    public static void main(String[] args) {
        String resourcePath = Util.getResourcePath();
        String textFileName =
            resourcePath + "test_files/file_handler_serializer/people.txt"; // file the objects are created from
        String objectFileName =
            resourcePath
            + "test_files/file_handler_serializer/personObjects.ser"; // file the objects are write to and then
        // read from
        Language language = Language.HUN;

        PersonDisplay personDisplay = new PersonDisplay(language);
        personDisplay.displayPersons(textFileName, objectFileName);
    }

}
