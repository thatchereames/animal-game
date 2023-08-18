///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Lion.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class represents a lion.
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames.
 */
public class Lion extends Animal implements Carnivore {
    
    /**
     * No arg contructor that creates an instance of Lion with 0 age, 0 health,
     * and 0 strength
     */
    public Lion() {}

    /**
     * Contructor that creates an instance of Lion with the specified age,
     * health and strength
     * 
     * @param age int representing the age of the Lion
     * @param health int representing the health of the Lion
     * @param strenght int representing the strength of the Lion
     */
    public Lion(int age, int health, int strength){
        super(age, health, strength);
    }
    /**
     * Method that simulates the Lion sleeping. Adds 20 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 20);
    }
    
    /**
     * Method simulates the Lion eating the inputed animal. Adds half the 
     * strength of the inputed to the strength of the lion
     * 
     * @param animal Animal that is 'eaten' by the lion
     */
    @Override
    public void eatAnimal(Animal animal) {
        setStrength(getStrength() + (animal.getStrength() / 2));
    }
}