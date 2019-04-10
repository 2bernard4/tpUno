package bernardoChiletto.interfaces;

import bernardoChiletto.interfaces.Pee;

import java.util.Random;

public class PeeVikingImp implements Pee {
    Random r = new Random();;

    @Override
    public int pee() {
        return r.nextInt(15 - 1) + 1;
    }
}
