package sanctuary;

import primates.Monkey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Isolation is a specific type of place in the sanctuary which has several cages. Each cage can
 * contain a maximum of 1 monkey. An isolation can have any type of species.
 */
public class Isolation implements IIsolations {

  private int count = 0;
  private int numberOfCages;
  private String isolationName;
  private String isolationLocation;
  private List<Monkey> monkeysInIsolation;
  private List<String> speciesInIsolation;
  private List<String> monkeyNamesInIsolation;

  /**
   * Constructing an isolation with specific details.
   * 
   * @param numberOfCages The number of cages in the isolation.
   * @param isolationName Name of the isolation.
   * @param isolationLocation Where is the isolation located.
   */
  public Isolation(int numberOfCages, String isolationName, String isolationLocation)
      throws IllegalArgumentException {

    this.numberOfCages = numberOfCages;
    this.isolationName = isolationName;  
    this.isolationLocation = isolationLocation;

    monkeysInIsolation = new ArrayList<Monkey>();
    speciesInIsolation = new ArrayList<String>();
    monkeyNamesInIsolation = new ArrayList<String>();
  }

  private boolean addMonkeyToIsolationHelper(Monkey m) {
    if (count != numberOfCages) {
      monkeysInIsolation.add(m);
      count++;
      return true;
    }
    return false;
  }

  @Override
  public boolean addMonkeyToIsolation(Monkey m) {
    return addMonkeyToIsolationHelper(m);
  }

  @Override
  public boolean provideMedicalAttention(Monkey m) {
    if (!monkeysInIsolation.contains(m)) {
      if (count != numberOfCages) {
        monkeysInIsolation.add(m);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean moveMonkeyToEnclosure(Monkey m, Sanctuary s) {
    for (IEnclosures e : s.getEnclosure()) {
      if (this.monkeysInIsolation.contains(m) && e.addMonkeyInEnclosure(m)) {
        monkeysInIsolation.remove(m);
        return true;
      }
    }
    return false;
  }

  @Override
  public List<String> getSpeciesInIsolation() {
    for (Monkey m : this.monkeysInIsolation) {
      speciesInIsolation.add(m.getClass().getSimpleName());
    }
    return speciesInIsolation;
  }


  @Override
  public List<String> getMonkeyNamesInIsolation() {
    for (Monkey m : this.monkeysInIsolation) {
      monkeyNamesInIsolation.add(m.getMonkeyName());
    }
    return monkeyNamesInIsolation;
  }

  @Override
  public String printMonkeysInIsolation() {
    String printMonkeysInIsolation = "";
    StringBuilder sb = new StringBuilder();

    Collections.sort(monkeysInIsolation, (a, b) -> a.getMonkeyName().compareTo(b.getMonkeyName()));

    for (Monkey i : monkeysInIsolation) {
      printMonkeysInIsolation = String.format("Monkey Name: %s", i.getMonkeyName());

      sb.append(printMonkeysInIsolation + "\n");
    }
    return sb.toString();
  }

  @Override
  public String getIsolationName() {
    return this.isolationName;
  }

  @Override
  public String getIsolationLocation() {
    return this.isolationLocation;
  }

  @Override
  public List<Monkey> getMonkey() {
    return this.monkeysInIsolation;
  }
}
