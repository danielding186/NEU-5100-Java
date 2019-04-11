package dto;

import java.util.ArrayList;


public class SpecialManager {
    private static final SpecialManager instance = new SpecialManager();

    private ArrayList<Special> specials;

    private SpecialManager() {
        specials = DummySpecials.getInstance().getDummySepcials();
    }


    public static SpecialManager getInstance(){
        return instance;
    }


    public Special getSepcial(int index) {
        return this.getCurrentSpecials().get(index);
    }

    public ArrayList<Special> getCurrentSpecials() {
        return specials;
    }


    public int totalCount() {
        return specials.size();
    }


    public boolean addSpecial(Special sp) {
        if (sp == null) {
            System.out.println("AddSpecial Null");
            return false;
        }

        specials.add(sp);
        DummySpecials.getInstance().saveSepcials(specials);
        return true;
    }

    public boolean updateSpecial(Special special) {
        if (special == null)
            return false;

        DummySpecials.getInstance().saveSepcials(specials);
        return true;
    }

    public boolean deleteSpecial(Special sp) {
        if (sp == null)
            return false;

        specials.remove(sp);
        DummySpecials.getInstance().saveSepcials(specials);
        return true;
    }
}
