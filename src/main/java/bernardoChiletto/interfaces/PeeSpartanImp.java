package bernardoChiletto.interfaces;

import bernardoChiletto.interfaces.Pee;
import java.util.Random;

public class PeeSpartanImp implements Pee {
    Random r = new Random();

    @Override
    public int pee() {
        return r.nextInt(10 - 1) + 1;
    }
}

