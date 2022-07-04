package gr.aueb.sweng22.team11.memoryDao;

import java.util.ArrayList;

import gr.aueb.sweng22.team11.dao.AdDao;
import gr.aueb.sweng22.team11.domain.Ad;
import gr.aueb.sweng22.team11.domain.OwnerAccount;

public class adDaoMemory implements AdDao {

    protected static ArrayList<Ad> ads = new ArrayList<>();

    @Override
    public void save(Ad ad) {
        ads.add(ad);
    }

    @Override
    public Ad findByStreet(String street) {
        for(Ad ad:ads){
            if(ad.getHouse().getStreet().equals(street))
                return ad;
        }
        return null;
    }

    @Override
    public Ad findByComment(String comment) {
        for(Ad ad:ads) {
            if (ad.getComment().equals(comment))
                return ad;
        }
        return null;
    }

    @Override
    public ArrayList<Ad> findByRegion(String region) {
        ArrayList<Ad> results = new ArrayList<>();
        for(Ad ad:ads){
            if(ad.getHouse().getRegion().equals(region))
                results.add(ad);
        }
        return results;
    }

    @Override
    public ArrayList<Ad> findByOwner(OwnerAccount owner) {
        ArrayList<Ad> results = new ArrayList<>();
        for(Ad ad:ads){
            for(Ad ownerAd:owner.getAds()){
                if(ad.equals(ownerAd))
                    results.add(ad);
            }
        }
        return results;
    }

    @Override
    public ArrayList<Ad> findAll() {
        return ads;
    }

    @Override
    public void delete(Ad ad) {
        ads.remove(ad);
    }

    @Override
    public void deleteAll() {
        ads = new ArrayList<>();
    }

    @Override
    public boolean streetIsUsed(String street, Ad ad) {
        Ad adExists = findByStreet(street);
        return !(adExists == null || adExists.equals(ad));
    }

}
