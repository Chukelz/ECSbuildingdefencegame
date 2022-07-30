import building.Building;
import students.Student;
import students.Team;

import java.util.Arrays;
import java.util.Random;

public class Battle {
  Team team;
  Building building;
  int counter;

  Battle(Team team, Building building) {
    this.team = team;
    this.building = building;
    this.counter = 0;
    // initialises the parameters of the battle
  }

  public void manageTeam() throws Exception {
    Student[] allStudents = team.getStudents();
    int rand = new Random().nextInt(allStudents.length);
    int GTKP = team.getKnowledgePoints();
    int GNSC = team.getNewStudentCost();
    int UC = (int) allStudents[rand].upgradeCost();

    if (GTKP < (GNSC + UC) && GTKP >= UC) {
      team.upgrade(allStudents[rand]);
      System.out.println(
          "You upgraded " + allStudents[rand] + " to level " + allStudents[rand].getLevel());
      // upgrades a random student if the knowledge points is greater than upgrade cost and more
      // than
      // the upgrade cost plus the new student cost
    }

    if (GTKP >= (GNSC + UC)) {
      team.recruitNewStudent();
      team.upgrade(allStudents[rand]);
      System.out.println(
          "You recruited a new student and upgraded "
              + allStudents[rand]
              + " to level "
              + allStudents[rand].getLevel());
      // upgrades a random student and recruits a student
      // if the knowledge points is greater than upgrade cost and new student cost
    }

    if (GTKP < (GNSC) + UC && GTKP < UC && GTKP >= GNSC) {
      team.recruitNewStudent();
      System.out.println("You recruited a new student");
      // recruits a student if the knowledge points is only greater than the new student cost
    }
  }

  public void step() throws Exception {
    if (building.getConstructionPoints() != 0) {
      if (counter == 0) {
        team.recruitNewStudent();
        // only recruits a new student the first time its run
      }
      System.out.println("Managing team...");
      manageTeam();
      // manages the team
      System.out.println("Bugs are moving...");
      building.bugsMove();
      // make all the bugs move
      if (building.getConstructionPoints() != 0) {
        System.out.println("Students are trying to defend the building...");
        team.studentsAct(building);
        // students try to defend the building
        System.out.println("Team Knowledge Points: " + team.getKnowledgePoints());
        System.out.println("Current recruiting cost: " + team.getNewStudentCost());
        System.out.println("Students Present: " + Arrays.toString(team.getStudents()));
        System.out.println("Buildings Construction Points: " + building.getConstructionPoints());
        System.out.println(
            "Bugs present in the building: " + Arrays.toString(building.getAllBugs()));
        // prints out important game state information
        counter = counter + 1;
        // updates the counter
      }
    }
  }
}
