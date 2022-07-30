package students;

import building.Building;

import java.util.ArrayList;
import java.util.Random;

public class Team {
  int currentKnowledgePoints;
  ArrayList<Student> students = new ArrayList<Student>();
  int newStudentCost;

  public Team(int initialKnowledgePoints) {
    this.currentKnowledgePoints = initialKnowledgePoints;
    this.newStudentCost = 100;
    ArrayList<Student> students = new ArrayList<Student>();
    // initialises the parameters of the team
  }

  public int getKnowledgePoints() {
    return this.currentKnowledgePoints;
    // returns the teams current knowledge points
  }

  public Student[] getStudents() {
    return students.toArray(new Student[students.size()]);
    // returns an array of all the students on the team
  }

  public int studentsAct(Building building) {
    int total = 0;
    for (int i = 0; i < students.size(); i++) {
      total = total + students.get(i).defence(building);
      // makes each student defend the building and updates total as the knowledge points are gained
    }
    currentKnowledgePoints = currentKnowledgePoints + total;
    return currentKnowledgePoints;
    // updates and returns the teams current knowledge points
  }

  public int getNewStudentCost() {
    return this.newStudentCost;
    // returns the cost of recruiting a new student
  }

  public void recruitNewStudent() throws Exception {
    if (currentKnowledgePoints >= newStudentCost) {
      int rand = new Random().nextInt(101);
      if (rand <= (25)) {
        students.add(new AiStudent(1));
      }
      if (rand > 25 && rand <= 50) {
        students.add(new CsStudent(1));
      }
      if (rand > 50 && rand <= 75) {
        students.add(new CyberStudent(1));
      }
      if (rand > 75 && rand <= 100) {
        students.add(new SeStudent(1));
      }
      currentKnowledgePoints = currentKnowledgePoints - newStudentCost;
      newStudentCost = newStudentCost + 10;
      // uses a 25% probability for each to determine which student to add
      // updates the new student cost and the teams knowledge points
    } else {
      throw new Exception("Not Sufficient Knowledge Points");
    }
  }

  public void upgrade(Student student) throws Exception {
    if (currentKnowledgePoints >= student.upgradeCost()) {
      student.setLevel(student.getLevel() + 1);
      currentKnowledgePoints = (int) (currentKnowledgePoints - student.upgradeCost());
      // upgrades the students level and updates the current knowledge points
    } else {
      throw new Exception("Not Sufficient Knowledge Points");
    }
  }
}
