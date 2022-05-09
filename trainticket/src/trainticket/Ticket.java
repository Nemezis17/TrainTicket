package trainticket;

public abstract class Ticket {
    protected Train t1;
    protected int seatnumber;
    protected boolean discount;
    protected TrainRoute route;

    public Ticket(Train t1, int seatnumber, boolean discount, TrainRoute route) {
        this.t1 = t1;
        this.seatnumber = seatnumber;
        this.discount = discount;
        this.route = route;
    }

    public abstract boolean isValid();

    public abstract double getPrice();

    public abstract boolean use();

    @Override
    public String toString() {
        return "Jegy adatai: \n"
                + "vonatszam=" + t1.getTrainid() + ",kocsiszam=" + t1.getVagonid() + ",hely=" + t1.getSeatnumber() + "\n"
                + "ar=" + getPrice() + "\n"
                + "indulasi allomas=" + route.getArrivalstation() + ", indulasi ido=" + route.getArrivaltime() + "\n"
                + "erkezesi allomas=" + route.getDeparturestation() + ", erkezesi ido=" + route.getDeparturetime() + "\n";
    }
}
