package bernardoChiletto.models;

import bernardoChiletto.interfaces.Drink;
import bernardoChiletto.interfaces.Pee;

public class Viking extends Human {
    public static final int MAX_BLADDER = 40;

    private Integer profesionalDrinker;


    public Viking(String name, Integer age, Integer weight, Pee pee, Drink drink, Integer profesionalDrinker) {
        super(name, age, weight, pee, drink);
        this.profesionalDrinker = profesionalDrinker;
    }

    public Integer getProfesionalDrinker() {
        return profesionalDrinker;
    }

    public void setProfesionalDrinker(Integer profesionalDrinker) {
        this.profesionalDrinker = profesionalDrinker;
    }

    public void drink(){
        drinks += (drink.drink() + profesionalDrinker);
    }

    @Override
    public String toString() {
        return "Spartan|" + super.toString() + " |Extra Profesional Drinker=" + profesionalDrinker + '|';
    }
}
