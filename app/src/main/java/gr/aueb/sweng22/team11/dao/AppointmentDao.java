package gr.aueb.sweng22.team11.dao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.RentAccount;

public interface AppointmentDao {
    void save(Appointment appointment);

    ArrayList<Appointment> findByAd(Ad ad);

    ArrayList<Appointment> findByRenter(RentAccount renter);



    void delete(Appointment appointment);

    void deleteAll();
}
