///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Frog.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class represents an Animal that is an Frog
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames
 */
public class Frog extends Animal implements Carnivore, Poisonous { 
    Random random = new Random();

    /**
     * No arg contructor that creates an instance of Frog with 0 age, 0 
     * health, and 0 strength
     */
    public Frog() {}

    /**
     * Contructor that creates an instance of Frog with the specified age,
     * health and strength
     * 
     * @param age int representing the age of the Frog
     * @param health int representing the health of the Frog
     * @param strenght int representing the strength of the Frog
     */
    public Frog(int age, int health, int strength){
        super(age, health, strength);
    }

    /**
     * Method that simulates the Frog sleeping. Adds 10 to the strength
     */
    @Override
    public void sleep() {
        setStrength(getStrength() + 10);
    }
    
    /**
     * Method simulates the Frog eating a bug around the dead animal. The bug 
     * is worth a quarter of the dead animal's strength. Adds one fourth of the
     * strength of the inputed Animal to the strength of the Frog
     * 
     * @param animal Animal that is 'eaten' by the Frog
     */
    @Override
    public void eatAnimal(Animal animal) {
        setStrength(getStrength() + (animal.getStrength() / 4));
    }

    /**
     * Method simulates the Frog poisoning another animal that is only
     * effective 40% of the time. Returns true if the animal was poisoned
     */
    public boolean poisonAnimal() {
        double odds = random.nextDouble();
        return odds <= 0.2;
    }
}