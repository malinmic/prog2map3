package no.ntnu.idatt2001.mmedvard.models;

import java.util.Collection;
import java.util.ArrayList;


public class PostalCodeRegistry {

    private ArrayList<PostalCode> postalCodeArrayList;


    public PostalCodeRegistry(){

        postalCodeArrayList = new ArrayList<>();
    }


    public Collection<PostalCode> getPostalCodeArrayList() {

        return this.postalCodeArrayList;
    }


    public boolean addPostalCode(PostalCode newPostalCode){

        if(postalCodeArrayList.add(newPostalCode)){
            return true;
        }

        return false;
    }
}
