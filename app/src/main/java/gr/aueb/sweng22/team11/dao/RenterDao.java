package gr.aueb.sweng22.team11.dao;

import java.util.ArrayList;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.User;

public interface RenterDao {

    boolean verify(Credentials credentials);

    void save(RentAccount renter);

    RentAccount findByCredentials(Credentials credentials);

    RentAccount findByNickname(String nickname);

    ArrayList<RentAccount> findAll();

    void delete(RentAccount renter);

    boolean exists(Credentials credentials);

    boolean credentialsUsed(Credentials credentials, User user);

    boolean nicknameAlreadyUsed(String nickname, User user);

    void deleteAll();

}
