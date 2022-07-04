package gr.aueb.sweng22.team11.domain;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

public class OwnerAccount extends User{
    private String title;

    private ArrayList <Ad> ads = new ArrayList<>(); //λίστα αγγελιών που έχει δημιουργήσει

    public OwnerAccount(){
        super();
    }



    public OwnerAccount(String title, String name, String last, String phone, String email, LocalDate date, Credentials credentials){
        super(name,last,phone,email,date,credentials);
        this.title = title;
    }
    public House createHouse(String street, String postcode,String region, String rent) //μέθοδος για τη κατασκευή της κατοικίας
    {
        House input = new House();

        if(street != null && postcode != null && region != null && rent != null)
        {
            input.setStreet(street);
            input.setPostcode(postcode);
            input.setRegion(region);
            input.setRent(rent);
        }
        return input;
    }

    public void createAndSaveAd(Ad ad){ //όταν ο ιδιοκτήτης φτιάξει όλα τα στοιχεία της αγγελίας του, αποθηκεύεται στη λίστα αγγελιών του
        if(ad==null){
            return;
        }
        ad.setOwner(this);
        ads.add(ad);

    }

    public void removeAd(Ad ad){ //αντίστοιχα αφαιρούμε από τη λίστα
        if(ad == null){
            return;
        }
        if(!ads.contains(ad)){
            return;
        }
        ads.remove(ad);
    }


    @RequiresApi(api = Build.VERSION_CODES.O)
    public void payDebt(Ad ad){
        /*if(!ad.checkForPricing()) {
            return;
        }*/
        if(!ad.getPrice().getIsPaid()){
           ad.getPrice().setIsPaid();
        }
    }

    public ArrayList<Ad> getAds() {
        return ads;
    }

    public String toString(){
        return "Owner{"+
                "username='" + this.getCredentials().getUsername() + '\'' +
                "}";
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean equals(Object other) {
        if (other == this)
            return true;

        if (other == null)
            return false;

        if (other instanceof OwnerAccount) {
            OwnerAccount otherOwner = (OwnerAccount) other;
            if (ads.equals(otherOwner.ads) && otherOwner.ads != null)
                return true;
        }
        return false;
    }
}
