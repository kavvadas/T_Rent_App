package gr.aueb.sweng22.team11.dao;

import gr.aueb.sweng22.team11.domain.User;

public interface LoginDao {

    void setUser(User user);

    User getUser();

    void clear();
}
 