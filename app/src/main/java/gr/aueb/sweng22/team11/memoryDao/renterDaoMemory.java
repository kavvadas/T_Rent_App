package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.RentAccount;
import gr.aueb.sweng22.team11.domain.User;

public class renterDaoMemory implements RenterDao {

    protected static ArrayList<RentAccount> renters = new ArrayList<>();

    @Override
    public boolean verify(Credentials credentials) {
        for(RentAccount renters:renters){
            if(renters.getCredentials().equals(credentials)){
                return true;
            }
        }
        return false;
    }
    @Override
    public void save(RentAccount renter) {
        renters.add(renter);
    }

    @Override
    public RentAccount findByCredentials(Credentials credentials) {
        for(RentAccount renter:renters){
            if(renter.getCredentials().equals(credentials))
                return renter;
        }
        return null;
    }

    @Override
    public RentAccount findByNickname(String nickname) {
        for(RentAccount renter:renters){
            if(renter.getNickname().equals(nickname))
                return renter;
        }
        return null;
    }

    @Override
    public ArrayList<RentAccount> findAll() {
        return renters;
    }

    @Override
    public void delete(RentAccount renter) {
        renters.remove(renter);
    }

    @Override
    public boolean exists(Credentials credentials) {
        for(RentAccount renter:renters){
            if(renter.getCredentials().getUsername().equals(credentials.getUsername()))
                return true;
        }
        return false;
    }

    @Override
    public boolean credentialsUsed(Credentials credentials, User user) {
        RentAccount renter = findByCredentials(credentials);
        return !(renter == null || renter.equals(user));
    }

    @Override
    public boolean nicknameAlreadyUsed(String nickname, User user) {
        RentAccount renter = findByNickname(nickname);
        return !(renter == null || renter.equals(user));
    }

    @Override
    public void deleteAll() {
        renters = new ArrayList<>();
    }
}
