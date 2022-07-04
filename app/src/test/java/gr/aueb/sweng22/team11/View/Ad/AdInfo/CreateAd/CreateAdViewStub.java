package gr.aueb.sweng22.team11.View.Ad.AdInfo.CreateAd;

import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.Owner.CreateAd.CreateAdView;
import org.junit.runner.Description;

import java.util.ArrayList;

public class CreateAdViewStub implements CreateAdView {

    String street = "street",postcode ="postcode",region = "region",rent = "rent",comment = "comment";

    ArrayList<Appointment> appointments = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();





    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public String getRegion() {
        return region;
    }

    @Override
    public String getRent() {
        return rent;
    }

    @Override
    public String getComment() {
        return comment;
    }

    @Override
    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    @Override
    public ArrayList<String> getDescription() {
        return description;
    }

    @Override
    public void setStreet(String street) {

    }

    @Override
    public void setPostcode(String postcode) {

    }

    @Override
    public void setRegion(String region) {

    }

    @Override
    public void setRent(String rent) {

    }

    @Override
    public void setComment(String comment) {

    }

    @Override
    public void setAppointments(ArrayList<Appointment> appointments) {

    }

    @Override
    public void showPop(CreateAdView view, String mess) {

    }

    @Override
    public void toOwnerPage(String title) {

    }

    @Override
    public void toAdPage(String comment, String title) {

    }
}
