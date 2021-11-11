package sanctuary;

import primates.Monkey;

import java.util.List;

/**
 * There can be many isolations in a particular sanctuary itself.
 * Some new ones might want new functionalities with the existing ones.
 * To avoid errors and to maintain a standard we have created this interface.
 * This will provide a standard structure.
 */
public interface IIsolations {

  /**
   * Adding a particular monkey to the isolation.
   * 
   * @param m The monkey to be added into the isolation.
   */
  public boolean addMonkeyToIsolation(Monkey m);

  /**
   * Providing medical attention to a particular monkey.
   * 
   * @param m Monkey which needs medical care.
   * 
   * @return A string indication the monkey has been treated.
   */
  public boolean provideMedicalAttention(Monkey m);

  /**
   * Move a monkey from the isolation to an enclosure.
   * Before moving we check if there is enough space and if there are same species 
   * in the enclosure.
   * 
   * @param m Monkey to move to the enclosure.
   * @param s Sanctuary to which we need to move it.
   */
  public boolean moveMonkeyToEnclosure(Monkey m, Sanctuary s);

  /**
   * A list of all the species in the isolation.
   * 
   * @return list of species.
   */
  public List<String> getSpeciesInIsolation();

  /**
   * A list of all the monkeys in the isolation.
   * 
   * @return list of monkeys.
   */
  public String printMonkeysInIsolation();

  /**
   * The isolation name which is given when the isolation is created.
   * 
   * @return Isolation name.
   */
  public String getIsolationName();
  
  /**
   * The isolation location which is given when the isolation is created.
   * 
   * @return Isolation location
   */
  public String getIsolationLocation();

  /**
   * List of all monkey objects in the isolation.
   * 
   * @return monkey objects.
   */
  public List<Monkey> getMonkey();

  /**
   * Prints all the monkeys present in a particular isolation.
   * I use this to check if monkeys are added correctly.
   * 
   * @return All monkey names in the isolation as a string.
   */
  public List<String> getMonkeyNamesInIsolation();

}
