package bernardoChiletto;

import bernardoChiletto.bdd.Jbdc;
import bernardoChiletto.interfaces.DrinkSpartanImp;
import bernardoChiletto.interfaces.DrinkVikingImp;
import bernardoChiletto.interfaces.PeeSpartanImp;
import bernardoChiletto.interfaces.PeeVikingImp;
import bernardoChiletto.models.Human;
import bernardoChiletto.models.Spartan;
import bernardoChiletto.models.Viking;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        List<Human> spartans = Arrays.asList(new Spartan("bernardo", 18, 68, new PeeSpartanImp(), new DrinkSpartanImp(), 3),
                new Spartan("Agustin", 21, 70, new PeeSpartanImp(), new DrinkSpartanImp(), 2),
                new Spartan("Pancho", 32, 80, new PeeSpartanImp(), new DrinkSpartanImp(), 4),
                new Spartan("More", 15, 69, new PeeSpartanImp(), new DrinkSpartanImp(), 5));

        List<Human> vikings = Arrays.asList(new Viking("burro", 18, 68, new PeeVikingImp(), new DrinkVikingImp(), 2),
                new Viking("tomas", 40, 72, new PeeVikingImp(), new DrinkVikingImp(), 5),
                new Viking("napo", 32, 50, new PeeVikingImp(), new DrinkVikingImp(), 3),
                new Viking("muji", 22, 84, new PeeVikingImp(), new DrinkVikingImp(), 4));

        Jbdc jbdc = new Jbdc();

        Human owner = new Human("German", 30, 84, new PeeSpartanImp(), new DrinkVikingImp());
        String winner = "";

        //IMPAR
        List<Human> orderedSpartans = (spartans.stream()
                .sorted(Comparator.comparing(Human::getWeight))
                .collect(Collectors.toList()));

        List<Human> orderedVikings = (vikings.stream()
                .sorted(Comparator.comparing(Human::getWeight))
                .collect(Collectors.toList()));


        //PRESENTACION
        System.out.println(String.format("---|SPARTANS|--- %s", orderedSpartans));
        System.out.println(String.format("---|VIKINGS|--- %s", orderedVikings));


        //ENFRENTAMIENTO
        Optional<Human> spartan = orderedSpartans.stream().findFirst();
        Optional<Human> viking = orderedVikings.stream().findFirst();

        System.out.println(String.format("\n🍻🍻🍻|SPARTAN|🍻🍻🍻 %s", spartan.get().toString()));
        System.out.println("🍺🍻🍺|VS|🍺🍻🍺");
        System.out.println(String.format("🍻🍻🍻|VIKING|🍻🍻🍻 %s ", viking.get().toString()));

        while (viking.get().getBladder() <= Viking.MAX_BLADDER){
            viking.get().pee();
            viking.get().drink();
        }

        while (spartan.get().getBladder() <= Spartan.MAX_BLADDER){
            spartan.get().pee();
            spartan.get().drink();
        }


        //SE VERIFICA QUIEN TOMO MAS, SI SE EMPATA TSE TERMINA ACA
        if (viking.get().getDrinks() > spartan.get().getDrinks()){
            System.out.println("\nVIKINGS WIN!!!! 🍺🍺🍺🍺");
            System.out.println(String.format("VIKINGS: %s", viking.get().getDrinks()));
            System.out.println(String.format("SPARTANS: %s", spartan.get().getDrinks()));
            jbdc.insertBdd(viking);
            winner = "vikings";
        }else if (viking.get().getDrinks() < spartan.get().getDrinks()){
            System.out.println("\nSPARTANS WIN!!!! 🍺🍺🍺🍺");
            System.out.println(String.format("VIKINGS: %s", viking.get().getDrinks()));
            System.out.println(String.format("SPARTANS: %s", spartan.get().getDrinks()));
            jbdc.insertBdd(spartan);
            winner = "spartans";
        }else{
            System.out.println("ITS A TIE, EVERYONE IS A LOSER");
            System.out.println(String.format("VIKINGS: %s", viking.get().getDrinks()));
            System.out.println(String.format("SPARTANS: %s", spartan.get().getDrinks()));
            winner = "tie";
        }


        //SI NO EMPATO EL GANADOR SE RENUEVA Y VA CONTRA EL DUENIO
        if (!winner.equals("tie")) {
            System.out.println("\n\nBUT WAIT THE OWNER OF THE BAR HALF VIKING AND HALF SPARTAN IS HERE TO BATTLE!!");

            if (winner.equals("spartans")) {
                spartan.get().setBladder(0);
                spartan.get().setDrinks(0);

                System.out.println(String.format("\n🍻🍻🍻|SPARTAN|🍻🍻🍻 %s", spartan.get().toString()));
                System.out.println("🍺🍻🍺|VS|🍺🍻🍺");
                System.out.println(String.format("🍻🍻🍻|OWNER|🍻🍻🍻 %s ", owner.toString()));

                while (owner.getBladder() <= 60) {
                    owner.pee();
                    owner.drink();
                }

                while (spartan.get().getBladder() <= Spartan.MAX_BLADDER) {
                    spartan.get().pee();
                    spartan.get().drink();
                }

                if (owner.getDrinks() > spartan.get().getDrinks()) {
                    System.out.println("\nOWNER WIN!!!! 🍺🍺🍺🍺");
                    System.out.println(String.format("SPARTANS: %s", spartan.get().getDrinks()));
                    System.out.println(String.format("OWNER: %s", owner.getDrinks()));
                } else {
                    System.out.println("\nSPARTANS WIN!!!! 🍺🍺🍺🍺");
                    System.out.println(String.format("SPARTANS: %s", spartan.get().getDrinks()));
                    System.out.println(String.format("OWNER: %s", owner.getDrinks()));
                }
            } else {
                viking.get().setBladder(0);
                viking.get().setDrinks(0);

                System.out.println(String.format("\n🍻🍻🍻|VIKINGS|🍻🍻🍻 %s", viking.get().toString()));
                System.out.println("🍺🍻🍺|VS|🍺🍻🍺");
                System.out.println(String.format("🍻🍻🍻|OWNER|🍻🍻🍻 %s ", owner.toString()));

                while (viking.get().getBladder() <= Viking.MAX_BLADDER) {
                    viking.get().pee();
                    viking.get().drink();
                }

                while (owner.getBladder() <= Spartan.MAX_BLADDER) {
                    owner.pee();
                    owner.drink();
                }

                if (owner.getDrinks() > viking.get().getDrinks()) {
                    System.out.println("\nOWNER WIN!!!! 🍺🍺🍺🍺");
                    System.out.println(String.format("VIKINGS: %s", viking.get().getDrinks()));
                    System.out.println(String.format("OWNER: %s", owner.getDrinks()));
                } else {
                    System.out.println("\nVIKINGS WIN!!!! 🍺🍺🍺🍺");
                    System.out.println(String.format("VIKINGS: %s", viking.get().getDrinks()));
                    System.out.println(String.format("OWNER: %s", owner.getDrinks()));
                }
            }
        }
    }
}
