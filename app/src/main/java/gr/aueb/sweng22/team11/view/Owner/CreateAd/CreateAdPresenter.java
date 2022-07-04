package gr.aueb.sweng22.team11.view.Owner.CreateAd;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.Appointment;
import gr.aueb.sweng22.team11.domain.House;
import gr.aueb.sweng22.team11.domain.OwnerAccount;

public class CreateAdPresenter {
    private  CreateAdView view;
    private OwnerDao ownerDao;
    private OwnerAccount owner;
    private AdDao adDao;
    private Ad adExists;

    /**
     * Default Constructor
     */
    public CreateAdPresenter(){}

    /**
     * sets the info of an already created ad in dao
     * @param comment comment of the ad
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void savedInfo(String comment){
        adExists = adDao.findByComment(comment);
        if(adExists == null)
            return;
        view.setComment(adExists.getComment());
        view.setPostcode(adExists.getHouse().getPostcode());
        view.setRegion(adExists.getHouse().getRegion());
        view.setRent(adExists.getHouse().getRent());
        view.setStreet(adExists.getHouse().getStreet());
        view.setAppointments(adExists.getAppointments());
    }

    /**
     * creates or modifies an ad depends if it exists or not in the adDao
     * @param title title of the ad
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void handleAdData(String title){
        owner = ownerDao.findByTitle(title);
        String street = view.getStreet();
        String region = view.getRegion();
        String postcode = view.getPostcode();
        String rent = view.getRent();
        String comment = view.getComment();
        ArrayList<String> description = view.getDescription();
        ArrayList<Appointment> appointments = view.getAppointments();


        if(!checkStreet(street))
        {
            view.showPop(view, "Please fill house's address properly");
        }
        else if(!checkPostcode(postcode))
        {
            view.showPop(view, "Please fill postcode");
        }
        else if(!checkRegion(region))
        {
            view.showPop(view, "Please fill region");
        }
        else if(!checkRent(rent))
        {
            view.showPop(view, "Rent must be number only");
        }
        else if(!checkComment(comment))
        {
            view.showPop(view, "Please give some house Info");
        }
        else if(!checkAppointments(appointments))
        {
            view.showPop(view, "You have to choose at least one hour and one day");
        }

        else {

            if (adExists == null) {
                Ad ad = new Ad(new House(street, postcode, region, rent, description), appointments, comment);
                adDao.save(ad);
                owner.createAndSaveAd(ad);
                view.toOwnerPage(owner.getTitle());
            } else {
                adExists.setComment(comment);
                adExists.getHouse().setStreet(street);
                adExists.getHouse().setRegion(region);
                adExists.getHouse().setPostcode(postcode);
                adExists.getHouse().setRent(rent);
                adExists.setAppointments(appointments);
                view.toAdPage(comment, title);
            }
        }

    }

    /**
     * @param val the street we want to check
     * @return false if the street is not valid,else true
     */
    private boolean checkStreet(String val)
    {


        String[] words = val. split(" ");

        if(words.length != 2)
        {
            return false;
        }
        else
        {
            if(words[0].matches("[a-zA-Z]+"))
            {
                return words[1].matches("[0-9]+");
            }

        }
        return false;
    }

    /**
     * @param val the postcode we want to check
     * @return false if the postcode is not valid,else true
     */
    private boolean checkPostcode(String val)
    {
        if(val.isEmpty())
        {
            return  false;
        }
        return true;
    }
    /**
     * @param val the region we want to check
     * @return false if the region is not valid,else true
     */
    private boolean checkRegion(String val)
    {
        if(val.isEmpty())
        {
            return  false;
        }
        return true;
    }
    /**
     * @param val the rent we want to check
     * @return false if the rent is not valid,else true
     */
    private boolean checkRent(String val)
    {
        return val.matches("[0-9]+");
    }
    /**
     * @param val the comment we want to check
     * @return false if the comment is not valid,else true
     */
    private boolean checkComment(String val)
    {
        if(val.isEmpty())
        {
            return  false;
        }
        return true;
    }
    /**
     * @param appointments the appointments we want to check
     * @return true if the appointments are not empty,else false
     */
    private boolean checkAppointments(ArrayList<Appointment> appointments)
    {
        return !appointments.isEmpty();

    }
    /**
     * set the ownerDao
     * @param ownerDao the new ownerDao
     */
    public void setOwnerDao(OwnerDao ownerDao) {
        this.ownerDao = ownerDao;
    }

    /**
     * set the adDao
     * @param adDao the new adDao
     */
    public void setAdDao(AdDao adDao){this.adDao = adDao;}

    /**
     * set a new view
     * @param view the new view
     */
    public void setView(CreateAdView view){this.view = view;}

    /**
     * clear the view
     */
    public void clearView(){this.view = null;}


}
