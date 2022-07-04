package gr.aueb.sweng22.team11.dao;
import android.os.Build;

import androidx.annotation.RequiresApi;

import gr.aueb.sweng22.team11.R;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.House;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.Request;
import gr.aueb.sweng22.team11.memoryDao.loginDaoMemory;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import gr.aueb.sweng22.team11.domain.RentAccount;

public abstract class Initializer {

    protected abstract void erase();

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void prepare(){
        erase();
        AdDao adDao = getAdDao();
        AppointmentDao appointmentDao = getAppointmentDao();
        OwnerDao ownerDao = getOwnerDao();
        RenterDao renterDao = getRenterDao();
        RequestDao requestDao = getRequestDao();

        ArrayList<RentAccount> renters = new ArrayList<>();

        new loginDaoMemory().clear();
        //create 5 renters
        for(int i=0;i<5;i++){
            RentAccount renter = new RentAccount("elabye"+i,"Marios","Papageorge","6983******","papamarios@aueb.gr", LocalDate.parse("2001-05-01"),new Credentials("Marios"+i,"1234567"));
            renters.add(renter);
            renterDao.save(renter);
        }
        RentAccount testRenter = new RentAccount("EIMAIEGW","Mefgfd","ItsME","6931********","kavvadas@aueb.gr",LocalDate.parse("2001-03-22"),new Credentials("itsME","7654321"));
        renters.add(testRenter);
        renterDao.save(testRenter);

        //create an owner
        OwnerAccount owner = new OwnerAccount("PapadakisHotels","Giwrgos","Papadakis","698312****","papadakisHotels@gmail.com",LocalDate.parse("1970-02-10"),new Credentials("papadakis", "papadakis1"));
        ownerDao.save(owner);

        ArrayList<Appointment> appointments = new ArrayList<>();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Appointment a = new Appointment(LocalDate.parse("12/12/2023",dateTimeFormatter), LocalTime.NOON);
        Appointment a1 = new Appointment(LocalDate.parse("13/12/2023",dateTimeFormatter), LocalTime.NOON);


        appointments.add(a1);
        appointmentDao.save(a1);
        appointments.add(a);
        appointmentDao.save(a);





        //an owner creates and saves ads
        ArrayList<String> description = new ArrayList<>();
        description.add("2 Bathrooms");
        description.add("1 kitchen");
        description.add("2 bedrooms");
        Ad ad = new Ad(new House("Basileiou", "14323", "Argyroupoli", "350",description),appointments,"efkoloxrhma");
        owner.createAndSaveAd(ad);
        Ad ad1 = new Ad(new House("Papandreou","12312","Athens","250",description),appointments,"kalatapame");
        owner.createAndSaveAd(ad1);
        Ad ad2 = new Ad(new House("Papandreou Andrea","12312","Athens","150",description),appointments,"kalatapame123");
        owner.createAndSaveAd(ad2);
        adDao.save(ad);
        adDao.save(ad1);
        adDao.save(ad2);

        //send requests to an ad found by the street
        Request request = new Request(testRenter,a);
        requestDao.save(request);
        ad.addRenterRequest(testRenter,a);

        Request request1 = new Request(testRenter,a1);
        requestDao.save(request1);
        ad.addRenterRequest(testRenter,a1);




    }

    public abstract AdDao getAdDao();

    public abstract AppointmentDao getAppointmentDao();

    public abstract OwnerDao getOwnerDao();

    public abstract RenterDao getRenterDao();

    public abstract RequestDao getRequestDao();


}
