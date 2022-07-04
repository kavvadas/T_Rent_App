package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.domain.Credentials;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.User;

public class ownerDaoMemory implements OwnerDao {

    protected static ArrayList<OwnerAccount> owners = new ArrayList<>();

    @Override
    public boolean verify(Credentials credentials) {
        for(OwnerAccount owners:owners){
            if(owners.getCredentials().equals(credentials)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(OwnerAccount owner) {
        owners.add(owner);
    }

    @Override
    public OwnerAccount findByTitle(String title) {
        for(OwnerAccount owner:owners){
            if(owner.getTitle().equals(title))
                return owner;
        }
        return null;
    }

    @Override
    public OwnerAccount findByCredentials(Credentials credentials) {
        for(OwnerAccount owner:owners){
            if(owner.getCredentials().equals(credentials))
                return owner;
        }
        return null;
    }

    @Override
    public ArrayList<OwnerAccount> findAll() {
        return owners;
    }

    @Override
    public void delete(OwnerAccount owner) {
        owners.remove(owner);
    }

    @Override
    public boolean exists(Credentials credentials) {
        for(OwnerAccount owner:owners){
            if(owner.getCredentials().getUsername().equals(credentials.getUsername()))
                return true;
        }
        return false;
    }

    @Override
    public boolean credentialsUsed(Credentials credentials, User user) {
        OwnerAccount owner = findByCredentials(credentials);
        return !(owner == null || owner.equals(user));
    }

    @Override
    public boolean titleUsed(String title, User user) {
        OwnerAccount owner = findByTitle(title);
        return !(owner == null || owner.equals(user));
    }

    @Override
    public void deleteAll() {
        owners = new ArrayList<>();
    }
}
