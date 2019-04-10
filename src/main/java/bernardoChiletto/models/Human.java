package bernardoChiletto.models;

import bernardoChiletto.interfaces.Drink;
import bernardoChiletto.interfaces.Pee;

public class Human {
    private String name;
    private Integer age;
    private Integer weight;
    Pee pee;
    Drink drink;
    Integer bladder;
    Integer drinks;

    public Human(String name, Integer age, Integer weight, Pee pee, Drink drink) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.pee = pee;
        this.drink = drink;
        this.bladder = 0;
        this.drinks = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Pee getPee() {
        return pee;
    }

    public void setPee(Pee pee) {
        this.pee = pee;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Integer getBladder() {
        return bladder;
    }


    public Integer getDrinks() {
        return drinks;
    }

    public void setBladder(Integer bladder) {
        this.bladder = bladder;
    }

    public void setDrinks(Integer drinks) {
        this.drinks = drinks;
    }

    public void drink(){
        drinks += drink.drink();
    }

    public void pee(){
        bladder += pee.pee();
    }


    @Override
    public String toString() {
        return  "Name='" + name + '\'' +
                ", Age=" + age +
                ", Weight=" + weight;
    }
}
