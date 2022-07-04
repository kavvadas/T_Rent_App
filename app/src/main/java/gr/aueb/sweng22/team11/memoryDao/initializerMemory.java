package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.dao.AppointmentDao;
import gr.aueb.sweng22.team11.dao.Initializer;
import gr.aueb.sweng22.team11.dao.OwnerDao;
import gr.aueb.sweng22.team11.dao.RenterDao;
import gr.aueb.sweng22.team11.dao.RequestDao;

public class initializerMemory extends Initializer {
    @Override
    protected void erase() {
        getAdDao().deleteAll();
        getAppointmentDao().deleteAll();
        getOwnerDao().deleteAll();
        getRenterDao().deleteAll();
        getRequestDao().deleteAll();
    }

    @Override
    public AdDao getAdDao() {
        return new adDaoMemory();
    }

    @Override
    public AppointmentDao getAppointmentDao() {
        return new appointmentDaoMemory();
    }

    @Override
    public OwnerDao getOwnerDao() {
        return new ownerDaoMemory();
    }

    @Override
    public RenterDao getRenterDao() {
        return new renterDaoMemory();
    }

    @Override
    public RequestDao getRequestDao() {
        return new requestDaoMemory();
    }
}
