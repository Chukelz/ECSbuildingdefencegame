package building;

import bugs.Bug;

import java.util.ArrayList;

public class Building {
  public int constructionPoints;
  public int topFloor;
  ArrayList<Bug> bugs = new ArrayList<Bug>();

  public Building(int topFloor, int constructionPoints) {
    this.topFloor = topFloor;
    this.constructionPoints = constructionPoints;
    this.bugs = bugs;
    // initialises the parameters for the building constructor
  }

  public int getTopFloor() {
    return this.topFloor;
    // returns the top floor of the building
  }

  public int getConstructionPoints() {
    return this.constructionPoints;
    // returns the current construction points of the building
  }

  public Bug[] getAllBugs() {
    ArrayList<Bug> AliveBugs = new ArrayList<Bug>();
    ArrayList<Bug> AliveBugsSort1 = new ArrayList<Bug>();
    ArrayList<Bug> AliveBugsFinal = new ArrayList<Bug>();

    for (int i = 0; i < bugs.size(); i++) {
      if (bugs.get(i).getCurrentHp() > 0 && bugs.get(i).getCurrentFloor() != -1) {
        AliveBugs.add(bugs.get(i));
      }
      // adds bugs to the alive bugs arraylist if they are in the building and have positive hp
    }
    Bug[] empty = new Bug[0];
    if (AliveBugs.size() > 0) {
      int MF = AliveBugs.get(0).getCurrentFloor();
      for (int a = 1; a < AliveBugs.size(); a++) {
        if (AliveBugs.get(a).getCurrentFloor() > MF) {
          MF = AliveBugs.get(a).getCurrentFloor();
        }
        // loops over all the elements to find the maximum current floor(MF)
      }
      int MS = AliveBugs.get(0).getCurrentSteps();
      for (int b = 1; b < AliveBugs.size(); b++) {
        if (AliveBugs.get(b).getCurrentSteps() > MS) {
          MS = AliveBugs.get(b).getCurrentSteps();
        }
        // loops over all the elements to find the maximum current steps(MS)
      }

      for (int j = MF; j > -1; j--) {
        for (int c = 0; c < AliveBugs.size(); c++) {
          if (AliveBugs.get(c).getCurrentFloor() == j) {
            AliveBugsSort1.add(AliveBugs.get(c));
          }
          // loops over the floors and adds the bugs on the highest floor to AliveBugsSort1
        }
        for (int d = 0; d <= MS; d++) {
          for (int e = 0; e < AliveBugsSort1.size(); e++) {
            if (AliveBugsSort1.get(e).getCurrentSteps() == d) {
              AliveBugsFinal.add(AliveBugsSort1.get(e));
            }
          }
          // loops over the steps and adds the bugs on this floor to AliveBugsFinal in order of
          // steps
        }
        AliveBugsSort1.clear();
        // clears AliveBugsSort1 to avoid multiple additions
      }

      return AliveBugsFinal.toArray(new Bug[AliveBugsFinal.size()]);
      // returns all the bugs in the building
    } else {
      return empty;
    }
  }

  public int addBug(Bug bug) {
    if (bugs.contains(bug)) {
      return -1;
    } else {
      bugs.add(bug);
      return bugs.size();
    }
    // adds bug to the building and returns -1 if the building already contains the bug
  }

  public void removeBug(Bug bug) {
    bugs.remove(bug);
    // removes bugs from the building
  }

  public void bugsMove() {
    if (constructionPoints != 0) {
      for (int i = 0; i < bugs.size(); i++) {
        bugs.get(i).move();
        // get all the bugs in the building to move
      }
      for (int i = 0; i < bugs.size(); i++) {
        if (bugs.get(i).getCurrentFloor() == topFloor && bugs.get(i).getBaseSteps() == 4) {
          constructionPoints = constructionPoints - 2;
          removeBug(bugs.get(i));
          // removes the bug when it gets to the top floor and subtracts the corresponding
          // construction points
          if (constructionPoints <= 0) {
            constructionPoints = 0;
            System.out.println("BUILDING DESTROYED BY BUGS");
          }
          if (constructionPoints == 0) {
            break;
          }
        }
      }
      for (int i = 0; i < bugs.size(); i++) {
        if (bugs.get(i).getCurrentFloor() == topFloor && bugs.get(i).getBaseSteps() == 6) {
          constructionPoints = constructionPoints - 4;
          removeBug(bugs.get(i));
          // removes the bug when it gets to the top floor and subtracts the corresponding
          // construction points
          if (constructionPoints <= 0) {
            constructionPoints = 0;
            System.out.println("BUILDING DESTROYED BY BUGS");
          }
          if (constructionPoints == 0) {
            break;
          }
        }
      }
      for (int i = 0; i < bugs.size(); i++) {
        if (bugs.get(i).getCurrentFloor() == topFloor && bugs.get(i).getBaseSteps() == 2) {
          constructionPoints = constructionPoints - 1;
          removeBug(bugs.get(i));
          // removes the bug when it gets to the top floor and subtracts the corresponding
          // construction points
          if (constructionPoints <= 0) {
            constructionPoints = 0;
            System.out.println("BUILDING DESTROYED BY BUGS");
          }
          if (constructionPoints == 0) {
            break;
          }
        }
      }
    }
  }
}
