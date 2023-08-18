///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                AnimalActivities.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * Class contains methods that relate to the activies of the animals.
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames.
 */
public class AnimalActivities {

    private final static int NUM_ANIMALS = 6;
    private final static int SPACING = 17;
    private final static String LEFT = "Left";
    private final static String RIGHT = "Right";  

    /**
     * Method simulates two animals fighting. Takes in two animal objects and
     * returns 0 if they tied, 1 if animal1 won and 2 if animal 2 won.
     * 
     * @param animal1 Animal object to be included in the 'fight'
     * @param animal2 Animal object to be included in the 'fight'
     * @return int representing which animal won (0 for tie, 1 for animal 1, 
     * and 2 for animal 2)
     */
    public static int fight(Animal animal1, Animal animal2) {
        boolean animal1WasPoisoned = false;
        boolean animal2WasPoisoned = false;
        
        if (animal1 instanceof Snake) {
            Snake newanimal1 = (Snake) animal1;
            animal2WasPoisoned = newanimal1.poisonAnimal();
        } else if (animal1 instanceof Frog) {
            Frog newanimal1 = (Frog) animal1;
            animal2WasPoisoned = newanimal1.poisonAnimal();
        }

        if (animal2 instanceof Snake) {
            animal1WasPoisoned = ((Snake)animal2).poisonAnimal();
        } else if (animal2 instanceof Frog) {
            Frog newanimal2 = (Frog) animal2;
            animal1WasPoisoned = ((Frog)animal2).poisonAnimal();
        }

        
        int roundNum = 0;
        while (animal1.getHealth() > 0 && animal2.getHealth() > 0) {
            printRound(roundNum);
            printBothAnimals(animal1, animal2);
            printAttack(LEFT, animal1.attack(animal2));
            printAttack(RIGHT, animal2.attack(animal1));
            roundNum++;
        }
        printFinalStats(animal1, animal2, animal1WasPoisoned || 
            animal2WasPoisoned);
        
        if (animal1.getHealth() <= 0) {
            if (animal2.getHealth() <= 0 || animal2WasPoisoned) {
                printTieGame();
                return 0;
            } else {
                //Downcasts winner to its animal type to perform its subsequent
                //eat method
                if (animal2 instanceof Lion) {
                    ((Lion)animal2).eatAnimal(animal1);
                } else if (animal2 instanceof Tiger) {
                    ((Tiger)animal2).eatAnimal(animal1);
                } else if (animal2 instanceof Elephant) {
                    ((Elephant)animal2).eatPlant();
                } else if (animal2 instanceof Rhino) {
                    ((Rhino)animal2).eatPlant();
                } else if (animal2 instanceof Snake) {
                    ((Snake)animal2).eatAnimal(animal1);
                } else {
                    ((Frog)animal2).eatAnimal(animal1);
                }
                printWinner(RIGHT);
                return 2;
            }
        } else {
            if (animal1WasPoisoned) {
                printTieGame();
                return 0;
            } else {
                //Downcasts winner to its animal type to perform its subsequent
                //eat method
                if (animal1 instanceof Lion) {
                    ((Lion)animal1).eatAnimal(animal2);
                } else if (animal1 instanceof Tiger) {
                    ((Tiger)animal1).eatAnimal(animal2);
                } else if (animal1 instanceof Elephant) {
                    ((Elephant)animal1).eatPlant();
                } else if (animal1 instanceof Rhino) {
                    ((Rhino)animal1).eatPlant();
                } else if (animal1 instanceof Snake) {
                    ((Snake)animal1).eatAnimal(animal2);
                } else {
                    ((Frog)animal1).eatAnimal(animal2);
                }
                printWinner(LEFT);
                return 1;
            }
        }
    }

    /**
     * Method simulates two Animals reproducing. If the animals are not of age 
     * 5 or older or are not of the same species, returns a blank Animal. If 
     * the conditions are met, the Animal returned will be the baby, age 0,
     * health 100, strength half the average strength of the parents
     * 
     * @param animal1 Animal representing the first parent
     * @param animal2 Animal representing the second parent
     */
    public static Animal reproduce(Animal animal1, Animal animal2) {
        if (animal1.getAge() >= 5 && animal2.getAge() >= 5) {
            if (animal1.sameSpecies(animal2)) {
                int babyStrength = (animal1.getStrength() + 
                    animal2.getStrength()) / 2;
                if (animal1 instanceof Lion) {
                    return new Lion(0, 100, babyStrength);
                } else if (animal1 instanceof Tiger) {
                    return new Tiger(0, 100, babyStrength);
                } else if (animal1 instanceof Elephant) {
                    return new Elephant(0, 100, babyStrength);
                } else if (animal1 instanceof Rhino) {
                    return new Rhino(0, 100, babyStrength);
                } else if (animal1 instanceof Snake) {
                    return new Snake(0, 100, babyStrength);
                } else {
                    return new Frog(0, 100, babyStrength);
                }
            } else {
                return new Animal();
            }
        } else {
            return new Animal();
        }
    }

    /** Below are helper methods to make fight() work */

    /**
     * Use this method in fight() to display the stats of both the animals
     * together
     * 
     * @param animal1 Animal on the left side to display stats
     * @param animal2 Animal on the right side to display stats
     */
    public static void printBothAnimals(Animal animal1, Animal animal2) {
        int ageSpacing = calcSpacing(Integer.toString(animal1.getAge()));
        int healthSpacing = calcSpacing(Integer.toString(animal1.getHealth()));
        int strSpacing = calcSpacing(Integer.toString(animal1.getStrength()));
        int animalSpacing = calcSpacing(animal1.getClass().getName());
        String str = "(" + animal1.getClass().getName() + ")"  + 
            " ".repeat(animalSpacing) + "(" + animal2.getClass().getName() + 
            ")\n" + "----------" + "         " + "----------\n" +
            "A: " + animal1.getAge() + " ".repeat(ageSpacing) +
            "A: " + animal2.getAge() + "\n" +
            "H: " + animal1.getHealth() + " ".repeat(healthSpacing) +
            "H: " + animal2.getHealth() + "\n" +
            "S: " + animal1.getStrength() + " ".repeat(strSpacing) +
            "S: " + animal2.getStrength() + "\n";
        System.out.println(str);
    }
    
    /**
     * Helper method for printBothAnimals()
     * 
     * @param str String on the left - used to calculate spacing
     * @return An int describing how many spaces to put between strings
     */
    public static int calcSpacing(String str) {
        int totalWidth = SPACING;
        int str1Width = str.length();
        int spacing = (totalWidth - str1Width);
        if (spacing < 0) {
            return 0; 
        }
        return spacing;
    }

    /**
     * Use this method in fight() to display the current round.
     * 
     * @param round An int of the round (should start at 0)
     */
    public static void printRound(int round) {
        System.out.println();
        System.out.println("Round " + round + ":");
    }

    /**
     * Use this method in fight() to display the damage each round.
     *
     * @param side The side of the Animal that invoked the attack().
     * @param damage The int (damage) returned from an attack() call
     */
    public static void printAttack(String side, int damage) {
        System.out.println(side + " does " + damage + " damage!");
    }

    /**
     * Use this method in fight() to display final stats and poison status.
     *
     * @param (animal1) Left animal
     * @param (animal2) Right animal
     * @param (poisoned) If either animal was poisoned
     */
    public static void printFinalStats(Animal animal1, Animal animal2, boolean 
                                        poisoned) {
        System.out.println();
        printBothAnimals(animal1, animal2);
        if (poisoned) {
            System.out.println("An animal was poisoned.");
        }
    }

    /**
     * Use this method in fight() to display a tie game.
     */
    public static void printTieGame() {
        System.out.println("-------GAME OVER-------");
        System.out.println("TIE: Both animals died!");
    }

    /**
     * Use this method in fight() to display the winner.
     * @param (side) The side of the Animal that won.
     */
    public static void printWinner(String side) {
        System.out.println("-------GAME OVER-------");
        System.out.println(side + " animal wins!");
    }
}