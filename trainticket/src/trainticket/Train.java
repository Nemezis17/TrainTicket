package trainticket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Train implements Serializable {
    private int trainid; // vonatszám
    private int vagoncount; // kocsiszám
    private int seatnumber; // hely
    private String from; // indulási állomás
    private String to; // érkezési állomás
    private int stationdistance; // távolság az állomások között
    private final List<TrainRoute> schelude = new ArrayList<TrainRoute>(); // menetrend

    public int getStationdistance() {
        return stationdistance;
    }

    public void setStationdistance(int stationdistance) {
        this.stationdistance = stationdistance;
    }

    public List<TrainRoute> getSchelude() {
        return schelude;
    }


    public void addRoute(TrainRoute r1) {
        // ha rossz az indulo allomas
        if(!r1.getDeparturestation().equals(from)||!r1.getDeparturestation().equals(to)){
            System.out.println("Ervenytelen kiindulo allomas");
            return;
        }
        // ha rossz az erkezo allomas
        if(!r1.getArrivalstation().equals(from)||!r1.getArrivalstation().equals(to)){
            System.out.println("Ervenytelen vegallomas allomas");
            return;
        }
        // ha ugyanaz az indulo es erkezo allomas
        if(r1.getDeparturestation().equals(r1.getArrivalstation())){
            System.out.println("Nem lehet ugyanaz a kiindulo es a vegallomas");
            return;
        }
        schelude.add(r1);
        System.out.println("Uj jarat hozzaadva");
    }

    public void removeRoute(int id) {
        // ha tul nagy az id akkor ne legyen tulindexeles
        if(id>=schelude.size()){
            System.out.println("Tul nagy index");
            return;
        }
        schelude.remove(id);
        System.out.println("Jarat torolve");
    }

    public Train(int trainid, int vagoncount, int seatnumber, String from, String to, int stationdistance) {
        this.trainid = trainid;
        this.vagoncount = vagoncount;
        this.seatnumber = seatnumber;
        this.from = from;
        this.to = to;
        this.stationdistance = stationdistance;
    }

    @Override
    public String toString() {
        return  "vonatid=" + trainid + ", kocsik szama=" + vagoncount + ", ulohelyek szama=" + seatnumber + ", egyik vegallomas=" + from + ", masik vegallomas=" + to + "allomasok kozotti tavolsag=" + stationdistance;
    }

    public int getTrainid() {
        return trainid;
    }

    public void setTrainid(int trainid) {
        this.trainid = trainid;
    }

    public int getVagoncount() {
        return vagoncount;
    }

    public void setVagoncount(int vagoncount) {
        this.vagoncount = vagoncount;
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
