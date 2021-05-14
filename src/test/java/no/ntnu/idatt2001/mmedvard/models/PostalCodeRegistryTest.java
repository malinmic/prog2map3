package no.ntnu.idatt2001.mmedvard.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PostalCodeRegistryTest {

    @Test
    void getPostalCodeArrayList_gets() {
        PostalCodeRegistry postalCodeRegistry = new PostalCodeRegistry();

        Assertions.assertEquals(new ArrayList<PostalCode>(), postalCodeRegistry.getPostalCodeArrayList());
    }

    @Test
    void addPostalCode_legalPostalCode_addsPostalCode() {
        PostalCodeRegistry postalCodeRegistry = new PostalCodeRegistry();
        PostalCode post = new PostalCode("8803","Sandnessjøen","1820","Alstahaug","G");

        Assertions.assertTrue(postalCodeRegistry.addPostalCode(post));
    }


}