package primates;

/**
 * An abstract class that implements all the method in the Monkey interface. There can be many
 * species of monkeys but they will have same data fields. Therefore a new species can extend this
 * abstract class and use these methods.
 */
public abstract class AbstractMonkey implements Monkey {

  protected String monkeyName;
  protected String sex;
  protected String size;
  protected int weight;
  protected int age;
  protected foodType favFood;
  protected String monkeyLocation;

  @Override 
  public String getMonkeyName() {
    return monkeyName;
  }

  @Override
  public String getSex() {
    return sex;
  }

  @Override
  public int getSize() {
    if (this.size == Size.SMALL.size) {
      return 1;
    }
    if (this.size == Size.MEDIUM.size) {
      return 5;
    }
    if (this.size == Size.LARGE.size) {
      return 10;
    }
    return 0;
  }
  
  @Override
  public int getFoodBySize() {
    if (this.size == Size.SMALL.size) {
      return 100;
    }
    if (this.size == Size.MEDIUM.size) {
      return 250;
    }
    if (this.size == Size.LARGE.size) {
      return 500;
    }
    return 0;
  }


  @Override
  public String getFoodTypeString() {
    return favFood.getFood();
  }

  @Override
  public int getWeight() {
    return weight;
  }

  @Override
  public int getAge() {
    return age;
  }

  @Override
  public foodType getFoodType() {
    return favFood;
  }
}
