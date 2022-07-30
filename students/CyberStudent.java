package students;

import bugs.Bug;
import building.Building;

import java.util.Random;

import static java.lang.Math.round;

public class CyberStudent implements Student {
  public int Level;
  public int Attack;
  public int Delay;
  public int UpgradeCost;
  public int KnowledgePoints;
  public int counter;

  public CyberStudent(int Level) {
    this.Level = Level;
    this.Attack = 7;
    this.Delay = 8;
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
        if (Level <= 30) {
          if (new Random().nextInt(101) <= (Level + 20)) {
            // generates a random number between 1 and a 100 and uses it to do my probability
            allBugs[0].damage(allBugs[0].getCurrentHp());
          } else {
            allBugs[0].damage(2 * normalAttack);
          }
        }
        if (Level > 30) {
          if (new Random().nextInt(101) <= (50)) {
            allBugs[0].damage(allBugs[0].getCurrentHp());
          } else {
            allBugs[0].damage(2 * normalAttack);
          }
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
      // updates the counter
    }
    return KnowledgePoints;
  }
}
