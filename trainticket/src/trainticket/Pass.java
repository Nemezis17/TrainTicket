package trainticket;

import java.io.Serializable;

public class Pass extends Ticket implements Serializable {
    public Pass(Train t1, int seatnumber, boolean discount, TrainRoute route) {
        super(t1, seatnumber, discount, route);
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public double getPrice() {
        return t1.getStationdistance()*100;
    }

    @Override
    public boolean use() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "\n"
                + "hasznalhato=" + "korlatlanul" + "\n"
                + "ervenyes=" + isValid();
    }
}
