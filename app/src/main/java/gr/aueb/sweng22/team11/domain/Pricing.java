package gr.aueb.sweng22.team11.domain;
public class Pricing {

    private int price; //ποσό που πρέπει να πληρώσει ο ιδιοκτήτης
    private boolean hasToBePaid; //έλεγχος για το αν πρέπει να πληρώσει
    private boolean paid ; //εξασφάλιση ότι το τίμημα έχει πληρωθεί

    Pricing(){}

    Pricing(int price)
    {
        this.price = price;
        this.hasToBePaid = false;
        this.paid =false ;

    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getIsPaid(){
        return paid;
    }
    public void  setIsPaid(){
        paid = true;
    }

    public void setHasToBePaid(){hasToBePaid = true;}
    public boolean getHasToBePaid(){return this.hasToBePaid;}


}

