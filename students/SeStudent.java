package students;

import bugs.Bug;
import building.Building;

import static java.lang.Math.round;

public class SeStudent implements Student {
  public int Level;
  public int Attack;
  public int Delay;
  public int UpgradeCost;
  public int KnowledgePoints;
  public int counter;

  public SeStudent(int Level) {
    this.Level = Level;
    this.Attack = 5;
    this.Delay = 6;
    this.UpgradeCost = (int) (100 * Math.pow(2, Level));
    this.KnowledgePoints = KnowledgePoints;
    this.counter = 1;
    // initialises the parameters of the student constructor
  }

  public int getLevel() {
    return this.Level;
    // returns the current level of the student
  }

  public void setLevel(int amount) {
    this.Level = amount;
    // sets the value of the level to a specific amount
  }

  public int upgradeCost() {
    return this.UpgradeCost;
    // returns the students current upgrade cost
  }

  public int getKnowledgePointsGain() {
    return this.KnowledgePoints;
    // returns the knowledge points gained by removing a bug
  }

  public int defence(Building building) {
    this.KnowledgePoints = 0;
    int normalAttack = (int) round(Attack * Math.pow(Level, 1.2));
    Bug[] allBugs = building.getAllBugs();
    // initialises the normal attack the students and the array of all bugs in the building
    if (allBugs.length > 0) {
      if (counter % Delay != 0) {
        allBugs[0].damage(normalAttack);
        // does a normal attack when the delay is not yet done
      }
      if (counter % Delay == 0) {
        if (allBugs.length > 0) {
          allBugs[0].slowDown(2);
        }
        if (allBugs.length > 1) {
          allBugs[1].slowDown(2);
        }
        if (allBugs.length > 2) {
          allBugs[2].slowDown(2);
        }
        if (allBugs.length > 3) {
          allBugs[3].slowDown(2);
        }
        if (allBugs.length > 4) {
          allBugs[4].slowDown(2);
        }
        // performs the special attack when the delay is over
      }
      for (int i = 0; i < allBugs.length; i++) {
        if (allBugs[i].getCurrentHp() == 0) {
          KnowledgePoints = (allBugs[i].getLevel() * 20);
          building.removeBug(allBugs[i]);
          System.out.println(allBugs[i].getName() + " has been removed");
          // loops over all the bugs and updates the knowledge points gain if its hp = 0
          // removes the bug and tells the user the bug has been removed
        }
      }
      counter = counter + 1;
      // upgrades the counter
    }
    return KnowledgePoints;
  }
}
