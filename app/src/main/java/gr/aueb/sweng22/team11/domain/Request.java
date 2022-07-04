package gr.aueb.sweng22.team11.domain;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.Random;

public class Request{

    private RentAccount renter;
    private LocalDate DateSent;
    public boolean pending,accepted;
    private Appointment appointment;
    private Integer id;



    @RequiresApi(api = Build.VERSION_CODES.O)
    public Request(RentAccount renter, Appointment appointment){
        this.DateSent = LocalDate.now();
        this.pending = true;
        this.renter = renter;
        this.appointment = appointment;
        this.id = new Random().nextInt(15000);
    }

    public Request() {}

    public RentAccount getRenter() {
        return renter;
    }

    public void setRenter(RentAccount renter) {
        this.renter = renter;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public LocalDate getDateSent() {
        return DateSent;
    }

    public boolean isPending() {
        return pending;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public Integer getId() {
        return this.id;
    }

    public void setAccepted(boolean accepted) {
        if(pending){
            this.accepted=accepted;
            pending=false;
        }
    }
}
