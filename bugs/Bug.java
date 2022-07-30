package bugs;

import static java.lang.Math.round;

public class Bug {
  public int currentHp;
  protected String name;
  protected int baseHp;
  protected int baseSteps;
  protected int level;
  protected int currentFloor;
  protected int currentSteps;
  Bug(String name, int level, int baseHp, int baseSteps) {
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
  }

  Bug(String name, int level, int initialSteps, int baseHp, int baseSteps) {
    this.currentHp = (int) round(baseHp * Math.pow(level, 1.5));
    this.currentSteps = initialSteps;
    this.name = name;
    this.baseHp = baseHp;
    this.baseSteps = baseSteps;
    this.level = level;
    this.currentFloor = -1;
    // initialises the parameters for the bug constructor
  }

  public String getName() {
    return name;
    // returns the name of the bug
  }

  public int getBaseSteps() {
    return this.baseSteps;
    // returns the base steps of the bug
  }

  public int getLevel() {
    return this.level;
    // returns the level of the bug
  }

  public int getCurrentHp() {
    return this.currentHp;
    // returns the bugs current hp
  }

  public int getCurrentSteps() {
    return this.currentSteps;
    // returns the bugs current steps
  }

  public int getCurrentFloor() {
    return this.currentFloor;
    // returns the bugs current floor
  }

  public void move() {
    if (currentSteps == 0) {
      currentFloor = currentFloor + 1;
      currentSteps = baseSteps - 1;
      System.out.println(name + " bug has moved to floor: " + currentFloor);
      // moves the bug up a floor when its currentSteps left is 0
    } else {
      currentSteps = currentSteps - 1;
      // moves the bug closer to the next floor
    }
  }

  public void damage(int amount) {
    if (currentHp > amount) {
      currentHp = currentHp - amount;
    } else if (currentHp <= amount) {
      currentHp = 0;
      // makes the bugs current HP 0 if it is damaged by more than the current HP
    }
    // damages the bug by a particular amount

  }

  public void slowDown(int steps) {
    currentSteps = currentSteps + steps;
    // slows down the bug by increasing its steps
  }
}
