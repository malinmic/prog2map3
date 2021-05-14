package no.ntnu.idatt2001.mmedvard.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostalCodeTest {

    @Test
    public void constructor_nullPostalCode_throws() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode(null,"Sandnessjøen","1820","Alstahaug","G"));
    }

    @Test
    public void constructor_nullPostalOffice_throws() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803",null,"1820","Alstahaug","G"));
    }

    @Test
    public void constructor_nullMunicipalityNumber_throws() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen",null,"Alstahaug","G"));
    }

    @Test
    public void constructor_nullMunicipalityName_throws() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen","1820",null,"G"));
    }

    @Test
    public void constructor_nullCategory_throws() {
        Assertions.assertThrows(IllegalArgumentException.class,()-> new PostalCode("8803","Sandnessjøen","1820","Alstahaug",null));
    }





    @Test
    void setPostalCode_legalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        post.setPostalCode("8800");

        Assertions.assertEquals("8800",post.getPostalCode());
    }

    @Test
    void setPostalCode_illegalField_throws() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setPostalCode(null));
    }

    @Test
    void setPostalCode_EmptyPostalCode_throws() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setPostalCode(" "));
    }





    @Test
    void setPostOffice_legalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        post.setPostOffice("Kattem");

        Assertions.assertEquals("Kattem",post.getPostOffice());
    }

    @Test
    void setPostOffice_illegalField_throws() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setPostOffice(null));
    }

    @Test
    void setPostOffice_EmptyPostOffice_throws(){
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setPostalCode(" "));
    }





    @Test
    void setMunicipalityNumber_legalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        post.setMunicipalityNumber("1800");

        Assertions.assertEquals("1800", post.getMunicipalityNumber());
    }

    @Test
    void setMunicipalityNumber_illegalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setMunicipalityNumber(null));

    }

    @Test
    void setMunicipalityNumber_EmptyMunicipalityNumber_throws(){
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setMunicipalityNumber(" "));
    }





    @Test
    void setMunicipalityName_legalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        post.setMunicipalityName("Trondheim");

        Assertions.assertEquals("Trondheim", post.getMunicipalityName());

    }

    @Test
    void setMunicipalityName_illegalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setMunicipalityName(null));
    }

    @Test
    void setMunicipalityName_EmptyMunicipalityName_throws(){
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setMunicipalityName(" "));
    }





    @Test
    void setCategory_legalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        post.setCategory("P");

        Assertions.assertEquals("P", post.getCategory());
    }

    @Test
    void setCategory_illegalField_sets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setCategory(null));
    }

    @Test
    void setCategory_EmptyCategory_throws(){
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertThrows(IllegalArgumentException.class, () -> post.setCategory(" "));
    }




    @Test
    void getPostalCode_gets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertEquals("8803",post.getPostalCode());
    }


    @Test
    void getPostOffice_gets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertEquals("Sandnessjøen",post.getPostOffice());
    }


    @Test
    void getMunicipalityNumber_gets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertEquals("1820",post.getMunicipalityNumber());
    }


    @Test
    void getMunicipalityName_gets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertEquals("Alstahaug",post.getMunicipalityName());
    }

    @Test
    void getCategory_gets() {
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertEquals("G",post.getCategory());
    }



    @Test
    void testEquals_notEqual_returnsFalse() {
        PostalCode post1 = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");
        PostalCode post2 = new PostalCode("8800","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertFalse(post1.equals(post2));
    }

    @Test
    void testEquals_equal_returnsTrue(){
        PostalCode post1 = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");
        PostalCode post2 = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertTrue(post1.equals(post2));
    }
}