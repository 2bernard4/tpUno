package bernardoChiletto.models;

import bernardoChiletto.interfaces.Drink;
import bernardoChiletto.interfaces.Pee;

public class Spartan extends Human {
    public static final int MAX_BLADDER = 60;

    Integer extraPeeTolerance;


    public Spartan(String name, Integer age, Integer weight, Pee pee, Drink drink, Integer extraTolerance) {
        super(name, age, weight, pee, drink);
        this.extraPeeTolerance = extraTolerance;
    }

    public void pee(){
        bladder += (pee.pee() - extraPeeTolerance);
    }

    public Integer getExtraPeeTolerance() {
        return extraPeeTolerance;
    }

    public void setExtraPeeTolerance(Integer extraPeeTolerance) {
        this.extraPeeTolerance = extraPeeTolerance;
    }

    @Override
    public String toString() {
        return "Spartan|" + super.toString() + " |Extra Pee Tolerance=" + extraPeeTolerance + '|';
    }
}
