package gr.aueb.sweng22.team11.domain;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;

public class RentAccount extends User{
    private String nickname;
    private ArrayList<Ad> favorites = new ArrayList<>();
    private ArrayList<Ad> adsInterested = new ArrayList<>();
    private ArrayList<Appointment> appointments ;
    public RentAccount(String s, String s1, String s2, String s3, LocalDate localDate, Credentials c){
        super();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public RentAccount(String nickname, String name, String last, String phone, String email, LocalDate date, Credentials credentials){
        super(name, last, phone, email, date, credentials);
        this.nickname = nickname;
        this.appointments = new ArrayList<>();
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void sendRequest(Ad ad, Appointment appointment) {
        if(adsInterested.contains(ad)||ad == null){
            return;
        }else
            adsInterested.add(ad);
            ad.addRenterRequest(this,appointment);
    }


    public void addFavorites(Ad ad) {

        if(ad != null)
        {
            favorites.add(ad);
        }

    }

    public void removeFavorites(Ad ad) {
        if (favorites.contains(ad) && ad != null)
            favorites.remove(ad);

    }



    public ArrayList<Ad> getFavorites() {
        return favorites;
    }


    public ArrayList<Ad> getAdsInterested() {
        return adsInterested;

    }


    public ArrayList<Appointment> getAppointment() {
        return appointments;
    }
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }





}

