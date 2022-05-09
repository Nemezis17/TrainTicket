package trainticket;

public class TrainRoute {
    private String departurestation; // indul�si �llom�s
    private String departuretime; // indul�si id�
    private String arrivalstation; // �rkez�si �llom�s
    private String arrivaltime; // �rkez�si id�
    public TrainRoute(String departurestation, String departuretime, String arrivalstation, String arrivaltime) {
        this.departurestation = departurestation;
        this.departuretime = departuretime;
        this.arrivalstation = arrivalstation;
        this.arrivaltime = arrivaltime;
    }

    public String getDeparturestation() {
        return departurestation;
    }

    public void setDeparturestation(String departurestation) {
        this.departurestation = departurestation;
    }

    public String getDeparturetime() {
        return departuretime;
    }

    public void setDeparturetime(String departuretime) {
        this.departuretime = departuretime;
    }

    public String getArrivalstation() {
        return arrivalstation;
    }

    public void setArrivalstation(String arrivalstation) {
        this.arrivalstation = arrivalstation;
    }

    public String getArrivaltime() {
        return arrivaltime;
    }

    public void setArrivaltime(String arrivaltime) {
        this.arrivaltime = arrivaltime;
    }

    @Override
    public String toString() {
        return "- " + getArrivalstation() + "," + getArrivaltime() + " - " + getDeparturestation() + "," + getDeparturetime();
    }
}
