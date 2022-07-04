package gr.aueb.sweng22.team11.domain;

import java.util.ArrayList;

public class House {

    private String street; //οδός
    private String postcode;//ΤΚ
    private String region;//Περιοχή
    private ArrayList<String> description;
    private String rent;//τιμή μηνιαίου ενοικίου


    public House(){
        this.street = "";
        this.postcode = "";
        this.region = "";
        this.rent = "0";
    }


    public House(String street, String postcode, String region, String rent, ArrayList<String> description){
        this.street = street;
        this.postcode = postcode;
        this.region = region;
        this.rent = rent;
        this.description = description;
    }

    //setters && getters

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
}
