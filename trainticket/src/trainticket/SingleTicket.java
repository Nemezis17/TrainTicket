package trainticket;

import java.io.Serializable;

public class SingleTicket extends Ticket implements Serializable {
    private int rides; // hanyszor hasznalható

    public SingleTicket(Train t1, int seatnumber, boolean discount, TrainRoute route) {
        super(t1, seatnumber, discount, route);
        rides = 1;
    }

    @Override
    public boolean isValid() {
        if(rides>0){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public double getPrice() {
        if(discount){
            return t1.getStationdistance() * 10;
        }
        else{
            return (t1.getStationdistance() * 10)*0.5f;
        }
    }

    @Override
    public boolean use() {
        if(isValid()){
            rides--;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "hasznalhato meg / osszes hasznalat=" + rides + "/1" + "\n"
                + "ervenyes=" + isValid();
    }
}
