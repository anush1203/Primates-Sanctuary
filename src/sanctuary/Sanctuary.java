package sanctuary;

import java.util.List;

/**
 * Sanctuary is a place which contains many specially created locations
 * that store animals based on certain conditions.
 * We can have n number of sanctuaries with similar structure.
 * Therefore an interface for sanctuary provides us a blueprint that we can follow
 * to make many sanctuaries in a standard manner.
 */
public interface Sanctuary {
  
  /**
   * Provides us with the name of the sanctuary.
   *  
   * @return Sanctuary name in String format.
   */
  public String getSanctuaryName();
  
  /**
   * Provides us the current number of isolations in a sanctuary.
   * 
   * @return Number of isolations.
   */
  public int getNumberOfIsolations();
  
  /**
   * Provides us the current number of enclosures in a sanctuary.
   * 
   * @return Number of enclosures.
   */
  public int getNumberOfEnclosures();
  
  /**
   * A list of all the isolations that have been added to a sanctuary.
   * This method is essential and made public because we might need to 
   * Iterate through all the isolations and check or add a monkey.
   * 
   * @return list of objects of isolations.
   */
  public List<IIsolations> getIsolations();
  
  /**
   * A list of all the enclosures that have been added to a sanctuary.
   * This method is essential and made public because we might need to 
   * Iterate through all the enclosures and check or add a monkey.
   * 
   * @return list of objects of isolations.
   */
  public List<IEnclosures> getEnclosure();
  
  /**
   * Increase the size of the sanctuary.
   * This is done by increasing the number of isolations and number of enclosures 
   * by 1.
   */
  public void extendSanctuarySize();
  
  /**
   * Adding the isolations we create into a sanctuary.
   * This is because an isolation is part of a sanctuary.
   * 
   * @param i Takes isolation objects as a parameter.
   * 
   * @return True if isolation successfully added.
   */
  public boolean addIsolation(IIsolations i);
  
  /**
   * Adding the enclosures we create into a sanctuary.
   * This is because an enclosure is part of a sanctuary.
   * 
   * @param e Takes enclosure objects as a parameter.
   * 
   * @return True if enclosure successfully added.
   */
  public boolean addEnclosure(IEnclosures e);
  
  /**
   * Print all the species and their location in the sanctuary in alphabetical order.
   * 
   * @return Alphabetically ordered string of species along with their location. 
   */
  public String printSpecies();
  
  /**
   * Print all the monkeys and their location in the sanctuary in alphabetical order.
   * 
   * @return Alphabetically ordered string of monkeys along with their location. 
   */
  public String printMonkeys();
  
  /**
   * A list of favorite foods and in what quantity it is required.
   * 
   * @return A list of food with quantity.
   */
  public String shoppingList();
  
  /**
   * Look for a particular species in the sanctuary. 
   * If no such species report it.
   * 
   * @param s Takes species as string input.
   * 
   * @return The locations of a species in the sanctuary.
   */
  public String lookUp(String s);
  
}
