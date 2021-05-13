package no.ntnu.idatt2001.mmedvard.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileManagerTest {

    @Test
    void importFromFile_imports() {

        try{
            Assertions.assertEquals(List.of(new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G")),FileManager.importFromFile(new File("src/test/java/no/ntnu/idatt2001/mmedvard/resources/TestPostalCode.txt")));
        } catch (IOException exception) {
            Assertions.fail();
        }
    }





}