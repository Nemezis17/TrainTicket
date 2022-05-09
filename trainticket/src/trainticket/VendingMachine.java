package trainticket;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private List<Train> trains;
    private static Scanner scanner = new Scanner(System.in);

    public VendingMachine(){
        this.trains = new ArrayList<Train>();
        try{
            readfromfile();
        }
        catch (IOException exception){
            System.out.println("Vonatok nem tolthetok be");
        }
        catch (ClassNotFoundException exceptio){
            System.out.println("Vonatok nem tolthetok be");
        }
    }

    public void printMenu(){
        System.out.println("Irj be a valasztott funkcio sorszamat:");
        System.out.println("\t1) Menetrend megtekintese");
        System.out.println("\t2) Vonat hozzaadasa");
        System.out.println("\t3) Vonat torlese");
        System.out.println("\t4) Jegy vasarlas");
        System.out.println("\t5) Jarat hozzaadas");
        System.out.println("\t6) Jarat torles");
        System.out.println("Kilepes: exit");

        String line = scanner.next();
        if(line.equals("1")){
            printscheludemenu();
        }
        else if(line.equals("2")){
            printaddtrainmenu();
        }
        else if(line.equals("3")){
            printdeletetrainmenu();
        }
        else if(line.equals("4")){
            // jegy vasarlas
        }
        else if(line.equals("5")){
            printaddroutemenu();
        }
        else if(line.equals("6")){
            printdeleteroutemenu();
        }
        else if(line.equals("exit")){
            System.exit(0);
        }
        else {
            System.out.println("Ervenytelen menu.");
            System.exit(0);
        }
    }

    public void printaddroutemenu(){
        System.out.println("Adja meg a vonat sorszamat amelyikhez uj jaratot szeretne hozzaadni:");
        for(int i=0; i<trains.size();i++){
            Train t = trains.get(i);
            System.out.println("\t" + i + ")" + t.toString());
        }
        int vonatindex = Integer.parseInt(scanner.next());
        if(vonatindex>=trains.size()){
            System.out.println("Tul nagy index");
            return;
        }

        Train t = trains.get(vonatindex);
        List<TrainRoute> routes = t.getSchelude();
        System.out.println("Jelenlegi jaratok:");
        for(int i=0; i< routes.size();i++){
            TrainRoute r = routes.get(i);
            System.out.println("\t- " + r.toString());
        }

        System.out.println();
        System.out.println("Adja meg a jarat adatai a kovetkezo formatumban ,-vel elvalasztva:");
        System.out.println("indulo allomas neve, indulas ideje, erkezo allomas neve, erkezes ideje");
        System.out.println("      Budapest             12:00        Nagykanizsa         14:00");

        String line = scanner.next();
        ArrayList<String> routedata = new ArrayList<String>(Arrays.asList(line.split(",")));
        String departurestation = routedata.get(0);
        String departuretime = routedata.get(1);
        String arrivalstation = routedata.get(2);
        String arrivaltime = routedata.get(3);
        addroute(t, departurestation, departuretime, arrivalstation, arrivaltime);
    }

    public void addroute(Train t, String departurestation, String departuretime, String arrivalstation, String arrivaltime){
        TrainRoute route = new TrainRoute(departurestation, departuretime, arrivalstation, arrivaltime);
        t.addRoute(route);
    }

    public void printdeleteroutemenu(){
        System.out.println("Adja meg a vonat sorszamat amelyiktol torolni szeretne jaratot:");
        for(int i=0; i<trains.size();i++){
            Train t = trains.get(i);
            System.out.println("\t" + i + ")" + t.toString());
        }
        int vonatindex = Integer.parseInt(scanner.next());
        if(vonatindex>=trains.size()){
            System.out.println("Tul nagy index");
            return;
        }

        Train t = trains.get(vonatindex);
        List<TrainRoute> routes = t.getSchelude();
        System.out.println("Jelenlegi jaratok:");
        for(int i=0; i< routes.size();i++){
            TrainRoute r = routes.get(i);
            System.out.println("\t- " + r.toString());
        }


    }

    public void printdeletetrainmenu(){
        System.out.println("Adja meg a torolni kivant vonat azonositojat:");
        for(int i=0; i<trains.size();i++){
            Train t = trains.get(i);
            System.out.println("\t" + t.toString());
        }
        String line = scanner.next();
        int trainid= Integer.parseInt(line);
        deletetrain(trainid);
    }

    public void printaddtrainmenu(){
        System.out.println("Adja meg a vonat adatait a kovetkezo formatumban ,-vel elvalasztva:");
        System.out.println("vonat azonosito,vagonok szama,ulohelyek szama,egyik vegallomas,masik vegallomas,allomasok kozotti tavolsag km-ben");
        System.out.println("      123              10               200          Budapest        Nagykanizsa                    214");
        System.out.println();
        String line = scanner.next();
        ArrayList<String> traindata = new ArrayList<String>(Arrays.asList(line.split(",")));
        int trainid = Integer.parseInt(traindata.get(0));
        int vagonnumber = Integer.parseInt(traindata.get(1));
        int seatnumber = Integer.parseInt(traindata.get(2));
        String from = traindata.get(3);
        String to = traindata.get(4);
        int distance = Integer.parseInt(traindata.get(5));
        addTrain(trainid, vagonnumber, seatnumber, from, to, distance);
    }

    public void printscheludemenu() {
        System.out.println("Válassza ki melyik vonat menetrendjet szeretne megtekinteni:");
        for(int i=0; i<trains.size();i++){
            System.out.println("\t" + i + ")" + trains.get(i));
        }
        String line = scanner.next();
        try{
            int index=Integer.parseInt(line);
            if(index>=trains.size()){
                System.out.println("Tul nagy index.");
            }
            Train train = trains.get(index);
            List<TrainRoute> routes = train.getSchelude();
            System.out.println("Vonathoz tartozo jaratok:");
            for(int i=0;i<routes.size();i++){
                System.out.println("\t- " + routes.get(i).toString());
            }
        }
        catch (Exception exception){
            System.out.println("Rossz formatum." + exception);
        }

    }

    public void deletetrain(int trainid){
        Train t1 = null;
        for(int i=0; i<trains.size();i++){
            Train t = trains.get(i);
            if(t.getTrainid()==trainid){
                t1 = t;
                break;
            }
        }
        if(t1==null){
            System.out.println("Torles nem sikerult");
            return;
        }
        else{
            trains.remove(t1);
            savetofile();
            System.out.println("Vonat torolve");
        }
    }

    public boolean istrainexist(int trainid){
        for(int i=0; i<trains.size();i++){
            Train t = trains.get(i);
            if(t.getTrainid()==trainid){
                return true;
            }
        }
        return false;
    }

    public void addTrain(int trainid, int vagonnumber, int seatnumber, String from, String to, int stationdistance){
        boolean trainexist = istrainexist(trainid);
        if(trainexist){
            return;
        }
        Train t1 = new Train(trainid, vagonnumber, seatnumber, from, to, stationdistance);
        trains.add(t1);
        savetofile();
        System.out.println("Vonat hozzaadva");
    }

    public void readfromfile() throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream("trains.txt");
        ObjectInputStream o = new ObjectInputStream(f);
        trains = (ArrayList<Train>) o.readObject();
        o.close();
    }

    public void savetofile() {
        try{
            FileOutputStream f = new FileOutputStream("trains.txt");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(trains);
            o.close();
        }
        catch (IOException exception){
            System.out.println("Hiba tortent mentes kozben.");
        }
    }
}
