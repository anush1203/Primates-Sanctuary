package primates;

/**
 * All the valid food types are available here.
 * A user can input only these values as food type for a monkey.
 * Food type can also be determined in the form of a string using the getter in the ENUM.
 */
public enum foodType {

  EGGS("Eggs"),
  FRUITS("Fruits"),
  INSECTS("Insects"),
  LEAVES("Leaves"),
  NUTS("Nuts"),
  SEEDS("Seeds"),
  TREESAP("Treesap");
  
  String food;
  
  private foodType(String food) {
    this.food = food;
  }
  
  public String getFood() {
    return this.food;
  }
}
