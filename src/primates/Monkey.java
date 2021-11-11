package primates;

/**
 * Monkey with all it's details. There can be many species of monkeys
 * but they all have same details.
 * A monkey must have a,
 * <ul>
 * <li> Name
 * <li> Gender
 * <li> Size
 * <li> Favorite food
 * <li> Weight
 * <li> Age
 * </ul>
 */
public interface Monkey {

  /**
   * The name of the monkey.
   * @return Name of monkey as String.
   */
  public String getMonkeyName();
  
  /**
   * The Gender of the monkey.
   * @return Gender of monkey as String.
   */
  public String getSex();
  
  /**
   * The amount of space occupied by a monkey based on size.
   * <ul>
   * <li> Small monkeys take 1 square meter area.
   * <li> Medium monkeys take 5 square meter area.
   * <li> Large monkeys take 10 square meter area.
   * </ul>
   * 
   * @return The square meter occupied by the monkey.
   */
  public int getSize();
  
  /**
   * The amount of food a monkey needs based on size.
   * 
   * <ul>
   * <li> Small monkeys needs 100gms.
   * <li> Medium monkeys needs 250gms.
   * <li> Large monkeys needs 500gms.
   * </ul>
   * 
   * @return Quantity of food needed by a monkey.
   */
  public int getFoodBySize();
  
  /**
   * Various food favorites of monkeys.
   * Favorite food of a particular monkey is extracted from a fixed number of food items.
   * This is achieved using ENUMS.
   * 
   * @return Favorite food of a monkey in the form of a string.
   */
  public String getFoodTypeString();
  
  /**
   * The weight of a monkey.
   * 
   * @return An integer value for t@Override
  he weight of the monkey.
   */
  public int getWeight();
  
  /**
   * The age of a monkey.
   * 
   * @return An integer value for the age of the monkey.
   */
  public int getAge();
  
  /**
   * Favorite food of a particular monkey is extracted from a fixed number of food items.
   * This is achieved using ENUMS.
   * 
   * @returnFavorite food of a monkey in the form of a ENUM.
   */
  public foodType getFoodType();
}
