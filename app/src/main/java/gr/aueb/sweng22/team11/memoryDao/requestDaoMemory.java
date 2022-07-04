package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.RequestDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.OwnerAccount;
import gr.aueb.sweng22.team11.domain.Request;

public class requestDaoMemory implements RequestDao {

    protected static ArrayList<Request> requests = new ArrayList<>();

    @Override
    public void save(Request request) {
        requests.add(request);
    }
    @Override
    public ArrayList<Request> findAll(){
        return requests;
    }

    @Override
    public ArrayList<Request> findByOwner(OwnerAccount owner) {
        ArrayList<Request> results = new ArrayList<>();
        for(Ad ad:owner.getAds()){
            results.addAll(ad.getRequests());
        }
        return results;
    }

    @Override
    public ArrayList<Request> findByAd(Ad ad) {
        ArrayList<Request> results = new ArrayList<>();
        for(Request request:ad.getRequests()){
            results.add(request);
        }
        return results;
    }

    @Override
    public Request findByOwnerAppoint(String appoint, String nickname) {
        for(Request request:requests){
            String appointment = request.getAppointment().getDate().toString()+" "+request.getAppointment().getTime().toString();
            if(request.getRenter().getNickname().equals(nickname)) {
                if (appointment.equals(appointment)) {
                    return request;
                }
            }
        }
        return null;
    }


    @Override
    public void delete(Request request) {
        requests.remove(request);
    }

    @Override
    public void deleteAll() {
        requests = new ArrayList<>();
    }
}
