package trainticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Train {
    private int trainid; // vonatszám
    private int vagonid; // kocsiszám
    private int seatnumber; // hely
    private String from; // indulási állomás
    private String to; // érkezési állomás

    public int getStationdistance() {
        return stationdistance;
    }

    public void setStationdistance(int stationdistance) {
        this.stationdistance = stationdistance;
    }

    public List<TrainRoute> getSchelude() {
        return schelude;
    }

    public void setSchelude(List<TrainRoute> schelude) {
        this.schelude = schelude;
    }

    private int stationdistance; // távolság az állomások között
    private List<TrainRoute> schelude = new ArrayList<TrainRoute>(); // menetrend

    public void addRoute(TrainRoute r1) {
        // ha rossz az indulo allomas
        if(!r1.getDeparturestation().equals(from)||r1.getDeparturestation().equals(to)){
            return;
        }
        // ha rossz az erkezo allomas
        if(!r1.getArrivalstation().equals(from)||!r1.getArrivalstation().equals(to)){
            return;
        }
        // ha ugyanaz az indulo es erkezo allomas
        if(r1.getDeparturestation().equals(r1.getArrivalstation())){
            return;
        }
        schelude.add(r1);
    }

    public void removeRoute(int id) {
        // ha tul nagy az id akkor ne legyen tulindexeles
        if(id>=schelude.size()){
            return;
        }
        schelude.remove(id);
    }

    public Train(int trainid, int vagonid, int seatnumber, String from, String to, int stationdistance) {
        this.trainid = trainid;
        this.vagonid = vagonid;
        this.seatnumber = seatnumber;
        this.from = from;
        this.to = to;
        this.stationdistance = stationdistance;
    }

    @Override
    public String toString() {
        String adatok = "vonatid=" + trainid + "," + "vagonid=" + vagonid + "ulohely=" + seatnumber + "\n";
        adatok+="menetrend=";
        for(int i=0;i<schelude.size();i++){
            adatok+="\n\t"+schelude.get(i).toString();
        }
        return adatok;
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
