package gr.aueb.sweng22.team11.View.Renter.RenterCreateRequest;

import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.view.Renter.RenterCreateRequest.RenterCreateRequestView;

import java.util.ArrayList;

public class RenterRequestViewStub implements RenterCreateRequestView {
    @Override
    public void setTitle(String title) {

    }

    @Override
    public void setOwner(String owner) {

    }

    @Override
    public void setRegion(String region) {

    }

    @Override
    public void setStreet(String street) {

    }

    @Override
    public void setPostcode(String postcode) {

    }

    @Override
    public void setRent(String rent) {

    }

    @Override
    public void setAppointments(ArrayList<Appointment> appointments) {

    }

    @Override
    public ArrayList<String> getChosenAppointment() {
        return null;
    }

    @Override
    public void startRequest(String nickname) {

    }
}
