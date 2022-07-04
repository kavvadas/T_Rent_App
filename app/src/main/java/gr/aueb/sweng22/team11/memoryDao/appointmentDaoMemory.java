package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;
import java.util.Locale;

import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.RentAccount;

public class appointmentDaoMemory implements AppointmentDao {

    ArrayList<Appointment> appointments = new ArrayList<>();

    @Override
    public void save(Appointment appointment) {
        appointments.add(appointment);
    }

    @Override
    public ArrayList<Appointment> findByAd(Ad ad) {
        ArrayList<Appointment> results = new ArrayList<>();
        for(Appointment appointment:ad.getAppointmentsWithRenter())
            results.add(appointment);
        return results;
    }

    @Override
    public ArrayList<Appointment> findByRenter(RentAccount renter) {
        ArrayList<Appointment> results = new ArrayList<>();
        for(Appointment appointment:renter.getAppointment())
            results.add(appointment);
        return results;
    }

    @Override
    public void delete(Appointment appointment) {
        appointments.remove(appointment);
    }

    @Override
    public void deleteAll() {
        appointments = new ArrayList<>();
    }
}
