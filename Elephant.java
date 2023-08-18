///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Elephant.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class represents an Animal that is an Elephant
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames
 */
public class Elephant extends Animal implements Herbivore{
    Random random = new Random();

    /**
     * No arg contructor that creates an instance of Elephant with 0 age, 0 
     * health, and 0 strength
     */
    public Elephant() {}

    /**
     * Contructor that creates an instance of Elephant with the specified age,
     * health and strength
     * 
     * @param age int representing the age of the Elephant
     * @param health int representing the health of the Elephant
     * @param strenght int representing the strength of the Elephant
     */
    public Elephant(int age, int health, int strength){
        super(age, health, strength);
    }

    /**
     * Method that simulates the Elephant sleeping. Adds 10 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 10);
    }
    
    /**
     * Simulates the elephant eating a plant. Adds a random amount between 0 
     * and 40 to the strength
     */
    @Override
    public void eatPlant() { 
        setStrength(getStrength() + random.nextInt(41));
    }
}