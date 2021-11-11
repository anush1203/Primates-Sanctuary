package primates;

/**
 * A particular species of monkeys called Howler that extends the Abstract Monkey class. Checks if
 * the inputs given to the monkey are valid.
 */
public final class Howler extends AbstractMonkey {

  /**
   * Assigning the monkey all its details.
   * 
   * @param monkeyName Name of the monkey.
   * @param sex Gender of the monkey.
   * @param size String value for the size of the monkey.
   * @param weight Integer value for the weight of the monkey.
   * @param age Integer value for the age of the monkey.
   * @param favFood favorite food of a monkey using the foodType ENUM.
   */
  public Howler(String monkeyName, String sex, String size, int weight, int age, foodType favFood)
      throws IllegalArgumentException {
    this.monkeyName = monkeyName;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.favFood = favFood;
    
    if (this.monkeyName == null || this.sex == null || this.size == null || this.favFood == null) {
      throw new IllegalArgumentException("Input all values");
    }

    if (!this.sex.equals("m") && !this.sex.equals("f")) {
      throw new IllegalArgumentException("Sex can only be one of the following: m or f");
    }

    if (!this.size.equals("small") && !this.size.equals("medium") && !this.size.equals("large")) {
      throw new IllegalArgumentException(
          "Size can only be one of the following: small, medium, large");
    }

    if (this.weight < 1 || this.age < 1) {
      throw new IllegalArgumentException("OOPS!!weight and age has to be greater than 0.");
    }
    
  }
}
