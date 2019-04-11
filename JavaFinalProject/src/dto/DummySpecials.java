package dto;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.text.*;

public class DummySpecials {

    private static final String filename = "dummySepcials.txt";
    private static final DummySpecials instance = new DummySpecials();

    private DummySpecials() {}

    public static DummySpecials getInstance(){
        return instance;
    }

    public ArrayList<Special> getDummySepcials() {

        if (true)
            return getMemorySepcials();


        File dummyFile = new File(filename);
        if (dummyFile.exists() == false) {
            System.out.println("getMemorySepcials Success");
            return getMemorySepcials();
        }

        ArrayList<Special> specials = new ArrayList<>();

        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (filename);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            Special sp = (Special) in.readObject();
            while (sp != null) {
                specials.add(sp);
                sp = (Special) in.readObject();
            }

            in.close();
            file.close();
            System.out.println("getDummySepcials Success: Count=" + specials.size());

        } catch (IOException ex) {
            System.out.println("getDummySepcials " + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException getDummySepcials " + ex);
        }

        return specials;
    }

    public void saveSepcials(ArrayList<Special> specials) {

        try {
            FileOutputStream file = new FileOutputStream
                    (filename);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            for (Special sp: specials)
                out.writeObject(sp);

            out.writeObject(null);

            out.close();
            file.close();

            System.out.println("saveSepcials Success");
        } catch (IOException ex) {
            System.out.println("saveSepcials Error" + ex);
        }
    }

    private <T> T getRomdomIdx(T... myArray) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(myArray.length);
        return myArray[randomIndex];
    }

    private ArrayList<String> getDates() {

        Random generator = new Random();

        String startDate = null;
        String endDate =  null;

        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd");

        Calendar Cal= Calendar.getInstance();
        Cal.setTime(date);
        Cal.add(Calendar.DAY_OF_WEEK,generator.nextInt(20)-generator.nextInt(15));
        startDate = formatter.format(Cal.getTime());

        Integer [] days = {7, 10, 30, 60};
        int dayDiff = getRomdomIdx(days);
        Cal.add(Calendar.DAY_OF_WEEK, dayDiff);
        endDate = formatter.format(Cal.getTime());

        ArrayList<String> dates = new ArrayList<String>();
        dates.add(startDate);
        dates.add(endDate);
        return dates;
    }

    private ArrayList<Special> getMemorySepcials() {
        ArrayList<Special> specials = new ArrayList<Special>();


        String titles[] = {"College Graduate Program", "Military Programs", "Service Specials", "Loyalty Offer", };
        String desps[] = {"We\'re tracking 13 brands offering Black Friday deals for buying or leasing a car. The best involve Black Friday lease deals, 0% financing and Supplier Pricing. We\'ll be updating this page as the latest offers are announced.\n\nHere, we\'re focusing on actual holiday offers and not regular deals you can get any other time of year. So far, we\'re seeing solid savings from top brands on cars, SUVs and trucks of just about every shape and size.\n\nThese are national offers unless noted otherwise.\n\nLatest Updates: \nAdded $1,000 unadvertised incentive on 2019 Honda Pilot, $500 Amazon card from Ford"};

        VehicleCriterion vc1 = new VehicleCriterion( "Porsche", "911",
                "1999", "2000", 10000, 20000);
        vc1.addType("SUV");


        VehicleCriterion vc2 = new VehicleCriterion( "BMW","X1","1996","2000",100000,2000000);
        vc2.addType("SUV");

        VehicleCriterion vcs[] = {vc1, vc2};

        Discount discount1 = new Discount(true, 3000);
        Discount discount2 = new Discount(false, 0.15f);
        Discount discounts[] = {discount1, discount2};

        int spID = 1;
        int num = 90;

        for (int i = 1; i <= num; i++)
        {
            ArrayList<String> dates = getDates();

            Special special1 = new Special(i+"",
                    "2333",
                    dates.get(0),
                    dates.get(1),
                    (String)this.getRomdomIdx(titles)+" "+i,
                    (String)this.getRomdomIdx(desps),
                    (Discount)this.getRomdomIdx(discounts),
                    (VehicleCriterion)this.getRomdomIdx(vcs));
            specials.add(special1);
        }


        return specials;
    }

    public static void main(String[] args) {
        DummySpecials dummySpecials = DummySpecials.getInstance();
       // dummySpecials.saveSepcials(dummySpecials.getMemorySepcials());
        System.out.println(dummySpecials.getDummySepcials());

    }
}




