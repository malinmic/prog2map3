package no.ntnu.idatt2001.mmedvard.models;


/**
 * Class representing an object of postal code with details about postal code, post office, municipality number, municipality name and category.
 */

public class PostalCode {

    public String postalCode;
    public String postOffice;
    public String municipalityNumber;
    public String municipalityName;
    public String category;


    /**
     * Constructs new postal code
     * @param postalCode postal code
     * @param postOffice post office name
     * @param municipalityNumber municipality number
     * @param municipalityName municipality name
     * @param category category
     */
    public PostalCode(String postalCode, String postOffice, String municipalityNumber, String municipalityName, String category){
        this.postalCode = postalCode;
        this.postOffice = postOffice;
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.category = category;
    }


    public PostalCode() {

    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setPostOffice(String postOffice) {
        this.postOffice = postOffice;
    }

    public void setMunicipalityNumber(String municipalityNumber) {
        this.municipalityNumber = municipalityNumber;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getPostOffice() {
        return postOffice;
    }

    public String getMunicipalityNumber() {
        return municipalityNumber;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public String getCategory() {
        return category;
    }



    /**
     * equals method to check if one postOffice is the same as another
     * @param otherPostalCode object
     * @return true if equal
     */
    public boolean equals(Object otherPostalCode){
        if(otherPostalCode instanceof PostalCode){
            PostalCode other = (PostalCode) otherPostalCode;
            return postalCode.equals(other.getPostalCode());
        }else{
            return false;
        }
    }


    /**
     * hashCode method to generate hashCode from the postal code
     * @return hashCode
     */
    public int hashCode(){
        return postalCode.hashCode();
    }


    /**
     * toString to get information about a postal code
     * @return String of all postal code fields
     */
    public String toString(){
        return "Postal Code: " + postalCode + "\nPost Office: " +
                postOffice + "\nMunicipality number: " + municipalityNumber +
                "\nMunicipality name: " + municipalityName + "\nCategory: " + category;
    }

}
