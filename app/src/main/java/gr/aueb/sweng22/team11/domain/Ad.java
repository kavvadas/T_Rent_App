package gr.aueb.sweng22.team11.domain;
import java.time.LocalDate;
import java.util.ArrayList;
import static java.time.temporal.ChronoUnit.DAYS;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class Ad { //αγγελία που κατασκευάζει ο ιδιοκτήτης

    private OwnerAccount owner; //ο ιδιοκτήτης που φτιάχνει την αγγελία
    private House house; //το σπίτι το οποίο περιέχεται στην αγγελία
    private ArrayList<Request> requests ; //λίστα αιτημάτων που στέλνουν ενοικιαστές που ενδιαφέρονται για τη συγκεκριμένη αγγελία
    private LocalDate dateCreated; //ημερομηνία που αναφέρει πότε δημιούργησε ο ιδιοκτήτης την αγγελία
    private String comment; //πρόσθετα σχόλια που μπορεί να θέλει να γράψει ο ιδιοκτήτης
    private ArrayList<Appointment> appointments = new ArrayList<>(); //λίστα με όλες τις ημερομηνίες που οι ενοικιαστές μπορούν να κλείσουν ραντεβού με τον ιδιοκτήτη
    private Pricing price; //τίμημα που πρέπει να πληρωθεί από τον ιδιοκτήτη εάν ενδιαφερόμενοι > 50 ή η αγγελία είναι διαθέσιμη για πάνω από έναν μήνα
    private ArrayList<Appointment> appointmentsWithRenter ;



    public Ad(){} //default κατασκευαστής. Όταν καλείται δημιουργείται μία νέα αγγελία στην οποία μέσω των setters πρέπει να ορίσουμε τις τιμές που θα έχει


    @RequiresApi(api = Build.VERSION_CODES.O)
    public Ad(House house, ArrayList<Appointment> appointments, String comment) {
        this.house = house; //πρέπει να έχουμε ήδη φτιάξει κατοικία
        this.dateCreated = LocalDate.now(); //η ημερομηνία θα είναι η μέρα που το κατασκευάζουμε
        this.comment = comment; //έχουμε ήδη γράψει το σχόλιο
        this.appointments = appointments; //τα ραντεβού που θα έχει επιλέξει ο ιδιοκτήτης
        this.requests = new ArrayList<>(); //όταν φτιάχνεται μία αγγελία η λίστα αιτημάτων πρέπει να είναι κενή
        this.appointmentsWithRenter = new ArrayList<>();
    }
    //κατασκευαστής με τη χρήση ήδη έτοιμων τιμών

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void checkForPricing() //έλεγχος για την δημιουργία τιμήματος για την αγγελία
    {
        long noOfDaysBetween = DAYS.between(LocalDate.now(), this.dateCreated); //πλήθος ημερών μεταξύ της στιγμής δημιουργίας και της σημερινής ημερομηνίας

        if((this.getRequests().size() > 50) || noOfDaysBetween > 30) //αν μία από τις δύο συνθήκες ισχύουν το τίμημα πρέπει να πληρωθεί
        {
            this.getPrice().setHasToBePaid(); //ορισμός boolean για το αν πρέπει να πληρωθεί σε true
        }
    }


    public void acceptRequest(Request request,int position){ //όταν ο ενοικιαστής στέλνει αίτημα για μία αγγελία και το αποδέχεται ο ενοικιαστής
        if(!this.getRequests().contains(request)||request==null){
            return;
            //αρχικά ελέγχουμε εάν το αίτημα βρίσκεται ήδη στη λίστα ή δεν έχει τιμή
        }
        request.setAccepted(true);
        request.getRenter().addAppointment(request.getAppointment()); //στα ραντεβού που ενδιαφέρεται ο ενοικιαστής αποθηκεύουμε την ημερομηνία που επέλεξε για τη συγκεκριμένη αγγελία
        this.getRequests().remove(request); //αφαιρούμε το αίτημα που έστειλε ο ενοικιαστής από τη λίστα αιτημάτων της συγκεκριμένης αγγελίας καθώς δεν έχει λόγο ύπαρξης για τον ιδιοκτήτη

    }
    public void rejectRequest(Request request,int position){
        if(!this.getRequests().contains(request)||request==null){
            return;
        }
        request.setAccepted(false);
        this.getRequests().remove(position); //αντίστοιχα, εάν ο ιδιοκτήτης απορρίψει το αίτημα ενός ενοικιαστή, το αφαιρούμε από τη λίστα αιτημάτων

    }
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void addRenterRequest(RentAccount renter, Appointment appointment){ //προσθήκη στη λίστα αιτημάτων αγγελίας
        if(renter == null || appointment == null){
            return;
        }
        requests.add(new Request(renter,appointment));
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public ArrayList<Request> getRequests() {
        return requests;
    }

    public void setDateCreated(LocalDate d){this.dateCreated = d;}

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void setAppointments(ArrayList<Appointment> appointments){
        this.appointments = appointments;
    }


    public ArrayList<Appointment> getAppointmentsWithRenter() {
        return appointmentsWithRenter;
    }

    public void addAppointmentsWithRenter(Appointment appointment) {
        appointmentsWithRenter.add(appointment);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPrice(Pricing p)
    {
        this.price = p;
    }

    public Pricing getPrice()
    {
        return this.price;
    }

    public void setOwner(OwnerAccount owner){this.owner = owner;}

    public OwnerAccount getOwner(){return owner;}


}
