package gr.aueb.sweng22.team11.domain;
import java.time.LocalDate;
import java.time.LocalTime;

public class Appointment {

    private LocalDate DateDesired;
    private LocalTime TimeOfMeetingDesired;
    private Boolean available;

    public Appointment(){
        DateDesired = null;
        TimeOfMeetingDesired = null;
        this.available = false;
    }


    public Appointment(LocalDate date, LocalTime time){
        this.DateDesired = date;
        this.TimeOfMeetingDesired = time;
        this.available = false;

    }

    public LocalDate getDate(){
        return DateDesired;
    }

    public void setDate(LocalDate dateDesired) {
        DateDesired = dateDesired;
    }

    public LocalTime getTime() {
        return TimeOfMeetingDesired;
    }

    public void setTime(LocalTime timeOfMeetingDesired) {
        TimeOfMeetingDesired = timeOfMeetingDesired;
    }
    public Boolean getAvailable(){return available;}

    public void setTaken(){

        if(this.available==false){
            this.available = true;
        }
        return;
    }
    @Override
    public String toString(){
        return(getDate().toString()+" "+getTime().toString());
    }
}
