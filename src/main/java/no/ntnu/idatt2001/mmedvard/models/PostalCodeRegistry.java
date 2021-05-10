package no.ntnu.idatt2001.mmedvard.models;

import java.util.ArrayList;
import java.util.Collection;

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