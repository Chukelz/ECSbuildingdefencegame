package bugs;

public class ConcurrentModificationBug extends Bug {

  public ConcurrentModificationBug(String name, int level, int initialSteps) {
    super(name, level, initialSteps, 20, 4);
    // initialises the parameters for the concurrent modification bug constructor
  }
}
