package primates;


/**
 * A specific set of sizes that can be alloted to a monkey. 
 * Values available are:
 * <ul>
 * <li> small
 * <li> medium
 * <li> large
 * </ul>
 */
public enum Size {

  SMALL("small"),
  MEDIUM("medium"),
  LARGE("large");
  
  String size;
  
  private Size(String size) {
    this.size = size;
  }
  
  public String getSize() {
    return this.size;
  }
}
