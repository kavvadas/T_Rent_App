package gr.aueb.sweng22.team11.memoryDao;

import gr.aueb.sweng22.team11.dao.LoginDao;
import gr.aueb.sweng22.team11.domain.User;

public class loginDaoMemory implements LoginDao {

    private static User user = null;

    public loginDaoMemory(){}

    @Override
    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getUser() {
        return user;
    }

    @Override
    public void clear() {
        user = null;
    }
}
