package bugs;

public class NullPointerBug extends Bug {

  public NullPointerBug(String name, int level, int initialSteps) {
    super(name, level, initialSteps, 10, 2);
    // initialises the parameters for the null pointer bug constructor
  }
}
