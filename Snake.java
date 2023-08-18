///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Snake.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class represents an Animal that is an Snake
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames
 */
public class Snake extends Animal implements Carnivore, Poisonous { 
    Random random = new Random();

    /**
     * No arg contructor that creates an instance of Snake with 0 age, 0 
     * health, and 0 strength
     */
    public Snake() {}

    /**
     * Contructor that creates an instance of Snake with the specified age,
     * health and strength
     * 
     * @param age int representing the age of the Snake
     * @param health int representing the health of the Snake
     * @param strenght int representing the strength of the Snake
     */
    public Snake(int age, int health, int strength){
        super(age, health, strength);
    }

    /**
     * Method that simulates the Snake sleeping. Adds 15 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 15);
    }
    
    /**
     * Method simulates the Snake eating the inputed animal. Adds all the 
     * strength of the inputed Animal to the strength of the Snake
     * 
     * @param animal Animal that is 'eaten' by the Snake
     */
    @Override
    public void eatAnimal(Animal animal) {
        setStrength(getStrength() + animal.getStrength());
    }

    /**
     * Method simulates the Snake poisoning another animal that is only
     * effective 40% of the time. Returns true if the animal was poisoned
     */
    public boolean poisonAnimal() {
        double odds = random.nextDouble();
        return odds <= 0.4;
    }
}