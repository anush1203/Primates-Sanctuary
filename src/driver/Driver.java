package driver;

import primates.Drill;
import primates.Howler;
import primates.Monkey;
import primates.Saki;
import primates.Size;
import primates.Spider;
import primates.foodType;
import sanctuary.Enclosure;
import sanctuary.IEnclosures;
import sanctuary.IIsolations;
import sanctuary.Isolation;
import sanctuary.JungleFriendsPrimate;
import sanctuary.Sanctuary;

/**
 * A Driver is a method that is accessible to the user/ client. A client must not have access to any
 * of the inside working of the model. Therefore here we provide an opportunity for the user to play
 * around with the sanctuary.
 */
public class Driver {

  /**
   * The main method where all the user related activities take place.
   * 
   * @param args ""
   */
  public static void main(String[] args) {

    // Create monkeys of different species.
    Monkey jack = new Drill("Jack", "m", "small", 10, 4, foodType.LEAVES);

    Monkey phill = new Howler("Phill", "m", "medium", 10, 4, foodType.FRUITS);
    Monkey chill = new Howler("Chill", "m", "large", 10, 4, foodType.EGGS);
    Monkey kill = new Howler("Kill", "m", "large", 10, 4, foodType.EGGS);
    Monkey shrill = new Howler("Shrill", "m", "medium", 10, 4, foodType.FRUITS);

    Monkey sill = new Spider("Sill", "m", "large", 10, 4, foodType.EGGS);

    Monkey dill = new Saki("Dill", "m", "large", 10, 4, foodType.EGGS);

    // Create an isolation.
    IIsolations iso1 = new Isolation(10, "AnushIsolation", "Isolation1");

    // Adding all monkeys to isolation iso1.
    iso1.addMonkeyToIsolation(jack);
    iso1.addMonkeyToIsolation(phill);
    iso1.addMonkeyToIsolation(chill);
    iso1.addMonkeyToIsolation(sill);
    iso1.addMonkeyToIsolation(dill);
    iso1.addMonkeyToIsolation(kill);
    iso1.addMonkeyToIsolation(shrill);

    System.out.println("-----------------Monkeys In the Isolation---------------------\n");
    System.out.println(iso1.printMonkeysInIsolation());


    // Create enclosures.
    IEnclosures enc1 = new Enclosure(100, "AnushEnclosure");
    IEnclosures enc2 = new Enclosure(100, "AdithyaEnclosure");

    // Create a sanctuary.
    Sanctuary jfp = new JungleFriendsPrimate("JungleFriendsPrimate", 10, 3);

    // Add isolation and enclosures to the sanctuary.
    jfp.addIsolation(iso1);
    jfp.addEnclosure(enc1);
    jfp.addEnclosure(enc2);

    // Move monkeys of same type to a enclosure by checking for conditions.
    iso1.moveMonkeyToEnclosure(phill, jfp);
    iso1.moveMonkeyToEnclosure(chill, jfp);
    iso1.moveMonkeyToEnclosure(kill, jfp);

    // Move a different species of monkey from the isolation to a new enclosure.
    iso1.moveMonkeyToEnclosure(jack, jfp);

    // Print sign for a specific enclosure.
    System.out.println("-------------Print Sign - Monkeys in enclosure enc1:-------------\n");
    // Printing enc1 sign to see monkeys have moved
    System.out.println(enc1.printSign());

    // Sending a monkey from enc1 to an isolation for medical attention
    enc1.sendMonkeyForMedicalAttention(phill, jfp);
    System.out.println("------------Phill sent to isolation for medical care---------\n");
    // Printing all monkey locations to see where they are present after transfer.
    // From the printed sign above we can see monkey phill was moved to enclosure
    // Now below we can see monkey phill moved back to isolation for medical care.
    System.out.println(
        "------------monkey locations in the sanctuary after transfer for medical care---------\n");
    System.out.println(jfp.printMonkeys());

    // Extending the size of sanctuary.
    // Number of isolations is 12 because we added iso1 and also incremented it by 1.
    jfp.extendSanctuarySize();
    System.out.println("----------------Sanctuary size after increasing-----------------\n");
    System.out.println("Number of isolations :" + jfp.getNumberOfIsolations());
    System.out.println("Number of enclosures :" + jfp.getNumberOfEnclosures() + "\n");


    // Monkeys in isolation iso1 after moving monkeys to enclosures.
    System.out.println("-------------Monkeys In the Isolation (after moving to "
        + "enclosures)-----------" + "---------\n");
    System.out.println(iso1.printMonkeysInIsolation());


    // Species in the sanctuary in alphabetical order.
    System.out.println("------------Species in the sanctuary---------------\n");
    System.out.println(jfp.printSpecies() + "\n");


    // Look Up a particular species location in the sanctuary
    System.out.println("------------Look for Species location in the sanctuary---------------\n");
    System.out.println(jfp.lookUp("Howler") + "\n");

    // Look Up a particular species location that is not in any isolation or enclosure
    System.out.println("------------Look for Species location that is not in any "
        + "isolation or enclosure---------------\n");
    System.out.println(jfp.lookUp("Tamarin") + "\n");

    // Print sign for a specific enclosure.
    System.out.println("-------------Print Sign - Monkeys in enclosure enc1:-------------\n");
    System.out.println(enc1.printSign());


    System.out.println("------------Print Sign - Monkeys in enclosure enc2:--------------\n");
    System.out.println(enc2.printSign());

    // Print all monkeys in a sanctuary.
    System.out.println("------------Monkeys in the sanctuary (Monkey Names)---------------\n");
    System.out.println(jfp.printMonkeys() + "\n");


    // Shopping List for all the monkeys in the sanctuary
    System.out.println("------------Shopping List---------------\n");
    System.out.println(jfp.shoppingList());


    // Checking if capacity gets updated
    System.out.println("------------Checking if size of enclosure gets updated---------------\n");
    System.out.println("Space left in the enclosure is: " + enc1.getCapacity());

    System.out.println(Size.SMALL.getSize());
  }


}
