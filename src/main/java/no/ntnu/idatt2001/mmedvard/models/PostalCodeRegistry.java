package no.ntnu.idatt2001.mmedvard.models;

import java.util.Collection;
import java.util.ArrayList;


/**
 * Class containing a list of postal codes
 */
public class PostalCodeRegistry {

    private ArrayList<PostalCode> postalCodeArrayList;


    /**
     * Constructor that makes the list of postal codes
     */
    public PostalCodeRegistry(){

        postalCodeArrayList = new ArrayList<>();
    }


    /**
     * Gets the list of postal codes
     * @return the list of postal codes
     */
    public Collection<PostalCode> getPostalCodeArrayList() {

        return this.postalCodeArrayList;
    }


    /**
     * Adds postal code to the registry
     * @param newPostalCode postal code
     * @return true if postal code was added
     */
    public boolean addPostalCode(PostalCode newPostalCode){

        if(postalCodeArrayList.add(newPostalCode)){
            return true;
        }

        return false;
    }
}
