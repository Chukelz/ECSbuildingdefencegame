package students;

import building.Building;

public interface Student {

  int upgradeCost();

  int getLevel();

  void setLevel(int amount);

  int getKnowledgePointsGain();

  int defence(Building building);
}
