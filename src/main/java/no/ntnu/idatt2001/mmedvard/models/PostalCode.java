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

        if(postalCode == null || postalCode.trim().isEmpty()){
            throw new IllegalArgumentException("Postal Code cannot be null");
        }

        if(postOffice == null || postOffice.trim().isEmpty()){
            throw new IllegalArgumentException("Post Office cannot be null");
        }

        if(municipalityNumber == null || municipalityNumber.trim().isEmpty()){
            throw new IllegalArgumentException("Municipality number cannot be null");
        }

        if(municipalityName == null || municipalityName.trim().isEmpty()){
            throw new IllegalArgumentException("Municipality name cannot be null");
        }

        if(category == null || category.trim().isEmpty()){
            throw new IllegalArgumentException("Category cannot be null");
        }

        this.postalCode = postalCode;
        this.postOffice = postOffice;
        this.municipalityNumber = municipalityNumber;
        this.municipalityName = municipalityName;
        this.category = category;
    }


    /**
     * set Postal Code
     * @param postalCode postal code
     */
    public void setPostalCode(String postalCode) {

        if(postalCode == null || postalCode.trim().length() == 0) {
            throw new IllegalArgumentException("Postal Code cannot be null");
        }

        this.postalCode = postalCode;
    }


    /**
     * set Post Office
     * @param postOffice post office
     */
    public void setPostOffice(String postOffice) {

        if(postOffice == null || postOffice.trim().length() == 0) {
            throw new IllegalArgumentException("Post Office cannot be null");
        }

        this.postOffice = postOffice;
    }


    /**
     * set Municipality number
     * @param municipalityNumber municipality number
     */
    public void setMunicipalityNumber(String municipalityNumber) {

        if(municipalityNumber == null || municipalityNumber.trim().length() == 0) {
            throw new IllegalArgumentException("Municipality number cannot be null");
        }

        this.municipalityNumber = municipalityNumber;
    }

    /**
     * set Municipality name
     * @param municipalityName municipality name
     */
    public void setMunicipalityName(String municipalityName) {

        if(municipalityName == null || municipalityName.trim().length() == 0) {
            throw new IllegalArgumentException("Municipality name cannot be null");
        }

        this.municipalityName = municipalityName;
    }


    /**
     * set Category
     * @param category category
     */
    public void setCategory(String category) {

        if(category == null || category.trim().length() == 0) {
            throw new IllegalArgumentException("Category cannot be null");
        }

        this.category = category;
    }


    /**
     * gets the postal code
     * @return String postal code
     */
    public String getPostalCode() {
        return postalCode;
    }


    /**
     * gets post office
     * @return String post office
     */
    public String getPostOffice() {
        return postOffice;
    }


    /**
     * gets municipality number
     * @return String municipality number
     */
    public String getMunicipalityNumber() {
        return municipalityNumber;
    }


    /**
     * gets municipality name
     * @return String municipality name
     */
    public String getMunicipalityName() {
        return municipalityName;
    }


    /**
     * gets category
     * @return String category
     */
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
