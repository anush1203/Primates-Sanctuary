package sanctuary;

import primates.Monkey;

import java.util.List;

/**
 * Enclosure is a special place in the sanctuary which can house only 
 * one type of species.
 * The number of monkeys is limited by the size of the sanctuary and 
 * the size of the animals already in the enclosure.
 */
public interface IEnclosures {

  /**
   * A method that gets the species that is being housed in the enclosure.
   * 
   * @return Species type.
   */
  public String getSpecies();

  /**
   * Printing all the monkeys and their sex and favorite food in the enclosure.
   * 
   * @return A string displaying all the monkeys with their gender and favorite food.
   */
  public String printSign();

  /**
   * Remaining space in the enclosure.
   * 
   * @return Square feet of area remaining.
   */
  public int getCapacity();

  /**
   * The Location of an enclosure in the sanctuary.
   * 
   * @return A string value of the location of the enclosure.
   */
  public String getEnclosureLocation();

  /**
   * Get all the monkey objects present in the enclosure.
   * 
   * @return List of monkey objects.
   */
  public List<Monkey> getMonkey();
  
  /**
   * Adding a monkey to the enclosure. It is protected as we do not want the user to have access to
   * adding monkeys to enclosure directly. All though this method is required in all enclosures we
   * can not add it to the interface as interface can have only public as access modifiers.
   * 
   * @param m A monkey that is to be added.
   */
  public boolean addMonkeyInEnclosure(Monkey m);

  /**
   * This allows us to send a monkey that needs medical attention to an isolation.
   * 
   * @param m Monkey that needs to be transfered.
   * @param s To the isolations in sanctuary s.
   * 
   * @return If monkey is successfully treated return true, else false.
   */
  boolean sendMonkeyForMedicalAttention(Monkey m, Sanctuary s);
}
