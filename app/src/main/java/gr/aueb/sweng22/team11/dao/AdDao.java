package gr.aueb.sweng22.team11.dao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.RentAccount;

public interface AdDao {

    void save(Ad ad);

    Ad findByStreet(String street);

    Ad findByComment(String comment);

    ArrayList<Ad> findByRegion(String region);

    ArrayList<Ad> findByOwner(OwnerAccount owner);

    ArrayList<Ad> findAll();

    void delete(Ad ad);

    void deleteAll();

    boolean streetIsUsed(String street, Ad ad);
}
