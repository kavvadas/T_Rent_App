package gr.aueb.sweng22.team11.dao;

import java.util.ArrayList;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.Request;

public interface RequestDao {

    void save(Request request);

    ArrayList<Request> findAll();

    ArrayList<Request> findByOwner(OwnerAccount owner);

    ArrayList<Request> findByAd(Ad ad);

    Request findByOwnerAppoint(String appoint,String nickname);

    void delete(Request request);

    void deleteAll();
}
