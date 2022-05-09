package trainticket;

public class Train {
    private int trainid; // vonatszám
    private int vagonid; // kocsiszám
    private int seatnumber; // hely
    private String from; // indulási állomás
    private String to; // érkezési állomás

    public Train(int trainid, int vagonid, int seatnumber, String from, String to) {
        this.trainid = trainid;
        this.vagonid = vagonid;
        this.seatnumber = seatnumber;
        this.from = from;
        this.to = to;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }

    public int getVagonid() {
        return vagonid;
    }

    public void setVagonid(int vagonid) {
        this.vagonid = vagonid;
    }

    public int getSeatnumber() {
        return seatnumber;
    }

    public void setSeatnumber(int seatnumber) {
        this.seatnumber = seatnumber;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
