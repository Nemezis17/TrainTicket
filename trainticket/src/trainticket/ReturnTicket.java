package trainticket;

import java.io.Serializable;

public class ReturnTicket extends Ticket implements Serializable {
    private int rides;
    public ReturnTicket(Train t1, int seatnumber, boolean discount, TrainRoute route) {
        super(t1, seatnumber, discount, route);
        rides = 2;
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
        return 0;
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
                + "hasznalhato meg / osszes hasznalat=" + rides + "/2" + "\n"
                + "ervenyes=" + isValid();
    }
}
