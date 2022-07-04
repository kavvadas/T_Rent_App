package gr.aueb.sweng22.team11.dao;

import java.util.ArrayList;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.User;

public interface OwnerDao {

    boolean verify(Credentials credentials);

    void save(OwnerAccount owner);

    OwnerAccount findByTitle(String title);

    OwnerAccount findByCredentials(Credentials credentials);

    ArrayList<OwnerAccount> findAll();

    void delete(OwnerAccount owner);


    boolean exists(Credentials credentials);

    boolean credentialsUsed(Credentials credentials, User user);

    boolean titleUsed(String title,User user);


    void deleteAll();
}
