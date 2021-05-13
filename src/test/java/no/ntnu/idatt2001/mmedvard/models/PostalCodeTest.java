package no.ntnu.idatt2001.mmedvard.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostalCodeTest {

    @Test
    public void constructor_nullPostalCode_throws(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode(null,"Sandnessjøen","1820","Alstahaug","G"));
    }


    @Test
    public void constructor_nullPostalOffice_throws(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803",null,"1820","Alstahaug","G"));
    }

    @Test
    public void constructor_nullMunicipalityNumber_throws(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen",null,"Alstahaug","G"));
    }

    @Test
    public void constructor_nullMunicipalityName_throws(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen","1820",null,"G"));
    }

    @Test
    public void constructor_nullCategory_throws(){
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen","1820","Alstahaug",null));
    }


    @Test
    void setPostalCode() {
    }

    @Test
    void setPostOffice() {
    }

    @Test
    void setMunicipalityNumber() {
    }

    @Test
    void setMunicipalityName() {
    }

    @Test
    void setCategory() {
    }

    @Test
    void getPostalCode() {
    }

    @Test
    void getPostOffice() {
    }

    @Test
    void getMunicipalityNumber() {
    }

    @Test
    void getMunicipalityName() {
    }

    @Test
    void getCategory() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }

    @Test
    void testToString() {
    }
}