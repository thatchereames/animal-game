///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Animal.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

import java.util.Random;

/**
 * This class represents an animal.
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames.
 */
public class Animal {
    private int age;
    private int health;
    private int strength;
    private Random random = new Random();

    /**
     * No-arg constructor that creates an instance of Animal with age set to 0,
     * health set to 0, and strength set to 0
     */
    public Animal() {
        this.age = 0;
        this.health = 0;
        this.strength = 0;
    }

    /**
     * Constructor that creates an instance of Animal with the specified age, 
     * health and strength amounts
     * 
     * @param age int representing the age of animal
     * @param health int representing the health of the animal
     * @param strength int representing the strength of animal
     */
    public Animal(int age, int health, int strength) {
        this.age = age;
        this.health = health;
        this.strength = strength;
    }

    /**
     * Returns the age of the animal
     * 
     * @return int representing the age of the animal
     */
    public int getAge() {
        return this.age;
    }

    /**
     * Returns the health of the animal
     * 
     * @return int representing the health of the animal
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns the strength of the animal
     * 
     * @return int representing the strength of the animal
     */
    public int getStrength() {
        return this.strength;
    }

    /**
     * Sets the health of the animal to the specified value
     * 
     * @param age int representing the health of the animal to be set
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Sets the strength of the animal to the specified value
     * 
     * @param age int representing the strength of the animal to be set
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Returns true if the animal is of the same species as the inputted animal
     * 
     * @return boolean representing if they are the same species
     */
    public boolean sameSpecies(Animal animal) {
        return this.getClass().getName().equals(animal.getClass().getName());
    }

    /**
     * Method makes the current animal 'attack' the inputed one. This decreases 
     * the health of the inputted animal by a random amount between 1 and the 
     * strength of the current animal.
     * 
     * @param animal Inputed Animal to be 'attacked'
     * @return int representing the 'attack' strength (amount the health was 
     * decreased by)
     */
    public int attack(Animal animal) {
        if (this.getStrength() > 0) {
            int attackAmount = (random.nextInt(this.getStrength()) + 1);
            animal.setHealth(animal.getHealth() - attackAmount);
            return attackAmount;
        } else {
            return 0;
        }
    }

    /**
     * Returns the information held in Animal as a String
     * 
     * @return String representing the Animal
     */
    @Override
    public String toString() {
        return "(" + getClass().getName() + ")" + " age: " + getAge() + 
            "; health: " + getHealth() + "; strength: " + getStrength();
    }

    /**
     * Methods to be overriden by subclasses
     */
    public void sleep() {}
}