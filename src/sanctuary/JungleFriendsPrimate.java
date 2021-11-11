package sanctuary;

import primates.Monkey;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


/**
 * An implementation of a sanctuary. This sanctuary has many isolations and enclosures. It houses
 * many species. It also displays species, monkeys in this sanctuary. It also checks if a species is
 * present or not.
 */
public class JungleFriendsPrimate implements Sanctuary {

  private String sanctuaryName;
  private int numberOfIsolations;
  private int numberOfEnclosures;
  private List<IIsolations> isolationsInSanctuary;
  private List<IEnclosures> enclosuresInSanctuary;
  private List<Monkey> allMonkeyObjectsInSanctuary;
  private TreeMap<String, String> speciesAndLocation;
  private TreeMap<String, String> nameAndLocation;

  /**
   * Constructing a sanctuary.
   * 
   * @param sanctuaryName Name of the sanctuary.
   * @param numberOfIsolations number of isolations in the sanctuary.
   * @param numberOfEnclosures number of enclosures in the sanctuary.
   */
  public JungleFriendsPrimate(String sanctuaryName, int numberOfIsolations,
      int numberOfEnclosures) throws IllegalArgumentException {
    
    this.sanctuaryName = sanctuaryName;
    this.numberOfIsolations = numberOfIsolations;
    this.numberOfEnclosures = numberOfEnclosures;

    isolationsInSanctuary = new ArrayList<IIsolations>();
    enclosuresInSanctuary = new ArrayList<IEnclosures>();
    allMonkeyObjectsInSanctuary = new ArrayList<Monkey>();
    speciesAndLocation = new TreeMap<String, String>();
    nameAndLocation = new TreeMap<String, String>();
  }

  @Override
  public String getSanctuaryName() {
    return this.sanctuaryName;
  }

  @Override
  public int getNumberOfIsolations() {
    return this.numberOfIsolations;
  }

  @Override
  public int getNumberOfEnclosures() {
    return this.numberOfEnclosures;
  }

  @Override
  public List<IIsolations> getIsolations() {
    return this.isolationsInSanctuary;
  }

  @Override
  public List<IEnclosures> getEnclosure() {
    return this.enclosuresInSanctuary;
  }

  @Override
  public void extendSanctuarySize() {
    this.numberOfIsolations++;
    this.numberOfEnclosures++;
  }

  @Override
  public boolean addIsolation(IIsolations i) {
    this.isolationsInSanctuary.add(i);
    numberOfIsolations++;
    return true;
  }

  @Override
  public boolean addEnclosure(IEnclosures e) {
    this.enclosuresInSanctuary.add(e);
    numberOfEnclosures++;
    return true;
  }

  private TreeMap<String, String> getAllSpeciesAndLocations() {
    for (IIsolations i : this.isolationsInSanctuary) {
      for (Monkey m : i.getMonkey()) {
        this.speciesAndLocation.put("species in isolation: " + m.getClass().getSimpleName(),
            String.format("Location: " + i.getIsolationLocation() + "\n"));
      }
    }
    for (IEnclosures e : this.enclosuresInSanctuary) {
      for (Monkey m : e.getMonkey()) {
        this.speciesAndLocation.put("species in encosure: " + m.getClass().getSimpleName(),
            String.format("Location: " + e.getEnclosureLocation() + "\n"));
      }
    }
    return this.speciesAndLocation;
  }
  
  @Override
  public String printSpecies() {
    this.getAllSpeciesAndLocations();
    return speciesAndLocation.toString();
  }

  private TreeMap<String, String> getAllMonkeyNamesAndLocation() {
    for (IIsolations i : this.isolationsInSanctuary) {
      for (Monkey m : i.getMonkey()) {
        this.nameAndLocation.put(m.getMonkeyName(),
            String.format("Location: " + i.getIsolationLocation() + "\n"));
      }
    }
    for (IEnclosures e : this.enclosuresInSanctuary) {
      for (Monkey m : e.getMonkey()) {
        this.nameAndLocation.put(m.getMonkeyName(),
            String.format("Location: " + e.getEnclosureLocation() + "\n"));
      }
    }
    return this.nameAndLocation;
  }
  
  @Override
  public String printMonkeys() {
    this.getAllMonkeyNamesAndLocation();
    return this.nameAndLocation.toString();
  }

  private List<Monkey> getAllSpeciesForShopping() {
    for (IIsolations i : this.isolationsInSanctuary) {
      this.allMonkeyObjectsInSanctuary.addAll(i.getMonkey());
    }
    for (IEnclosures e : this.enclosuresInSanctuary) {
      this.allMonkeyObjectsInSanctuary.addAll(e.getMonkey());
    }

    return this.allMonkeyObjectsInSanctuary;
  }
  
  @Override
  public String shoppingList() {
    int countEggs = 0;
    int countFruits = 0;
    int countInsects = 0;
    int countLeaves = 0;
    int countNuts = 0;
    int countSeeds = 0;
    int countSaps = 0;
    StringBuilder sb = new StringBuilder();
    this.getAllSpeciesForShopping();
    String shoppingList = "";
    sb.append("Shopping list is.....\n");
    for (Monkey m : this.allMonkeyObjectsInSanctuary) {

      if (m.getFoodTypeString().contains("Eggs")) {
        countEggs += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Fruits")) {
        countFruits += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Insects")) {
        countInsects += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Leaves")) {
        countLeaves += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Nuts")) {
        countNuts += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Seeds")) {
        countSeeds += m.getFoodBySize();
      } else if (m.getFoodTypeString().contains("Treesap")) {
        countSaps += m.getFoodBySize();
      }

    }

    shoppingList = String.format(
        "Eggs : %d\n" + "Fruits : %d\n" + "Insects : %d\n" + "Leaves : %d\n" + "Nuts : %d\n"
            + "Seeds : %d\n" + "TreeSaps : %d\n",
        countEggs, countFruits, countInsects, countLeaves, countNuts, countSeeds, countSaps);
    return shoppingList;
  }

  private boolean helperLookupFail(String s) {
    for (IEnclosures i : enclosuresInSanctuary) {
      if ((i.getSpecies().contains(s))) {
        return false;
      }
    }
    for (IIsolations i : isolationsInSanctuary) {
      if (i.getSpeciesInIsolation().contains(s)) {
        return false;
      }
    }
    return true;
  }

  @Override
  public String lookUp(String s) {
    String lookUpSpecies = "";
    StringBuilder sb = new StringBuilder();
    for (IEnclosures i : enclosuresInSanctuary) {
      if (i.getSpecies().contains(s)) {
        lookUpSpecies = String.format(i.getEnclosureLocation());
        sb.append("\n" + lookUpSpecies + "\n");
      }
    }
    for (IIsolations i : isolationsInSanctuary) {
      if (i.getSpeciesInIsolation().contains(s)) {
        lookUpSpecies = String.format(i.getIsolationLocation());
        sb.append("\n" + lookUpSpecies + "\n");
      }
    }

    if (helperLookupFail(s)) {
      sb.append("OOPS!! The Species " + s + " is neither in any enclosures nor in any isolations");
    }

    return sb.toString();
  }
}
