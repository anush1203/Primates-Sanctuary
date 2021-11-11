package sanctuary;

import primates.Monkey;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * An Enclosure is a space in the sanctuary that can house only one type of species.
 */
public class Enclosure implements IEnclosures {

  private int sizeOfEnclosure;
  private String enclosureLocation;
  private List<Monkey> monkeysInEnclosure;

  /**
   * Initializing the Enclosure class.
   * 
   * @param sizeOfEnclosure The size of enclosure is the size in square feet.
   * @param enclosureLocation This is the location of the enclosure in the sanctuary.
   */
  public Enclosure(int sizeOfEnclosure, String enclosureLocation) throws IllegalArgumentException {
    super();

    this.sizeOfEnclosure = sizeOfEnclosure;
    this.enclosureLocation = enclosureLocation;
    monkeysInEnclosure = new ArrayList<>();
  }

  @Override
  public String getSpecies() {
    return this.monkeysInEnclosure.get(0).getClass().getSimpleName();
  }

  private boolean addMonkeyInEnclosureHelper(Monkey m) {
    int monkeySpace = m.getSize();

    if (this.sizeOfEnclosure > m.getSize()) {
      if (this.monkeysInEnclosure.size() == 0) {
        monkeysInEnclosure.add(m);
        this.sizeOfEnclosure = this.sizeOfEnclosure - monkeySpace;
        return true;
      } else if (this.monkeysInEnclosure.get(0).getClass() == m.getClass()) {
        // System.out.printf("added %s \n",m.getMonkeyName());
        monkeysInEnclosure.add(m);
        this.sizeOfEnclosure = this.sizeOfEnclosure - monkeySpace;
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean sendMonkeyForMedicalAttention(Monkey m, Sanctuary s) {
    for (IIsolations i : s.getIsolations()) {
      if (this.monkeysInEnclosure.contains(m) && i.provideMedicalAttention(m)) {
        this.monkeysInEnclosure.remove(m);
        return true;
      }
    }
    return false;
  }

  @Override
  public boolean addMonkeyInEnclosure(Monkey m) {
    return this.addMonkeyInEnclosureHelper(m);
  }

  @Override
  public String printSign() {
    String print = "";
    StringBuilder sb = new StringBuilder();
    Collections.sort(monkeysInEnclosure, (a, b) -> a.getMonkeyName().compareTo(b.getMonkeyName()));
    for (Monkey a : monkeysInEnclosure) {

      print = String.format("Monkey Name: %s, Gender: %s, Favorite Food: %s", a.getMonkeyName(),
          a.getSex(), a.getFoodType());
      sb.append(print + "\n");
    }
    return sb.toString();
  }

  @Override
  public int getCapacity() {
    return this.sizeOfEnclosure;
  }

  @Override
  public String getEnclosureLocation() {
    return this.enclosureLocation;
  }

  @Override
  public List<Monkey> getMonkey() {
    return this.monkeysInEnclosure;
  }
}
