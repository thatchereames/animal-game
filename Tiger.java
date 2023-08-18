///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Tiger.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class represents an Animal that is a Tiger
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames.
 */
public class Tiger extends Animal implements Carnivore{
    /**
     * No arg contructor that creates an intance of Tiger with age 0, health 0,
     * and strength 0
     */
    public Tiger() {}

    /**
     * Constructor that creates an instance of Tiger with the specified age,
     * health, and strength
     * 
     * @param age int represeting the age of the tiger
     * @param health int representing the health of the tiger
     * @param strength int representing the strength of the tiger
     */
    public Tiger(int age, int health, int strength) {
        super(age, health, strength);
    }

    /**
     * Method that simulates the Tiger sleeping. Adds 15 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 15);
    }

    /**
     * Method simulates the Tiger eating the inputed animal. Adds half the 
     * strength of the inputed to the strength of the tiger
     * 
     * @param animal Animal that is 'eaten' by the tiger
     */
    @Override
    public void eatAnimal(Animal animal) {
        setStrength(getStrength() + (animal.getStrength() / 3));
    }
}