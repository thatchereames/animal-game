///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Rhino.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class represents an Animal that is an Rhino
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames
 */
public class Rhino extends Animal implements Herbivore{
    Random random = new Random();

    /**
     * No arg contructor that creates an instance of Rhino with 0 age, 0 
     * health, and 0 strength
     */
    public Rhino() {}

    /**
     * Contructor that creates an instance of Rhino with the specified age,
     * health and strength
     * 
     * @param age int representing the age of the Rhino
     * @param health int representing the health of the Rhino
     * @param strenght int representing the strength of the Rhino
     */
    public Rhino(int age, int health, int strength){
        super(age, health, strength);
    }

    /**
     * Method that simulates the Rhino sleeping. Adds 10 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 15);
    }
    
    /**
     * Simulates the Rhino eating a plant. Adds a random amount between 0 
     * and 25 to the strength
     */
    @Override
    public void eatPlant() { 
        setStrength(getStrength() + random.nextInt(26));
    }
}