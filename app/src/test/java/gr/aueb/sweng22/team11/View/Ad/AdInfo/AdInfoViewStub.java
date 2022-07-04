package gr.aueb.sweng22.team11.View.Ad.AdInfo;

import gr.aueb.sweng22.team11.view.Ad.AdInfo.AdInfoView;

public class AdInfoViewStub implements AdInfoView {
    String street = "papandreou 12" ,region = "Athens",
            postcode = "18120" , rent = "1000",
            comment ="comment", title = "PAOSK";

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public void setPostcode(String postcode) {
        this.postcode=postcode;

    }

    @Override
    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public void setRent(String rent) {
        this.rent = rent;

    }

    @Override
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public void startEditAd(String comment) {

    }

    @Override
    public void startDeleteAd(String title) {

    }
}
