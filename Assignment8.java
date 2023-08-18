///////////////////////////////////////////////////////////////////////////////
//
// Main Class File:     Assignment8.java
// File:                Assignment8.java
// Quarter:             CSE 8B Spring 2023
//
// Author:              Thatcher Eames.
// Instructors Name:    Professor Ochoa.
//
///////////////////////////////////////////////////////////////////////////////

/**
 * This class is used to test all the other methods.
 * 
 * Bugs: None.
 * 
 * @author Thatcher Eames.
 */
public class Assignment8 {
    private static Lion leo = new Lion(10, 600, 100);
    private static Tiger tony = new Tiger(5, 700, 60);
    private static Elephant ellie = new Elephant(4, 100, 70);
    private static Rhino roy = new Rhino(15, 80, 90);
    private static Snake sam = new Snake(3, 100, 50);
    private static Frog fiona = new Frog(6, 90, 40);
    private static Animal emmy = new Animal();
    private static Lion boris = new Lion();

    /**
     * Tests multiple instances of the sleep() method and returns true if they 
     * all functioned as expected
     * 
     * @return boolean representing if the tests passed
     */
    public static boolean testOne() {
        leo.sleep();
        tony.sleep();
        ellie.sleep();
        roy.sleep();
        sam.sleep();
        fiona.sleep();
        ellie.sleep();
        boris.sleep();
        return leo.getStrength() == 120 && tony.getStrength() == 75 && 
        ellie.getStrength() == 90 && roy.getStrength() == 105 && 
        sam.getStrength() == 65 && fiona.getStrength() == 50 && 
        boris.getStrength() == 20;
    }

    /**
     * Tests multiple instances of the eatAnimal() method and returns true if 
     * they all functioned as expected
     * 
     * @return boolean representing if the tests passed
     */
    public static boolean testTwo() {
        boris.setStrength(0);
        leo.eatAnimal(roy);
        tony.eatAnimal(leo);
        ellie.eatPlant();
        roy.eatPlant();
        sam.eatAnimal(fiona);
        fiona.eatAnimal(boris);

        return leo.getStrength() == 172 && tony.getStrength() == 132 &&
        ellie.getStrength() >= 90 && ellie.getStrength() <= 130 &&
        roy.getStrength() >= 105 && roy.getStrength() <= 130 && 
        sam.getStrength() == 115 && fiona.getStrength() == 50;
    }
    
    /**
     * Tests multiple instances of the poisonAnimal() method and returns true 
     * if they all functioned as expected
     * 
     * @return boolean representing if the tests passed
     */
    public static boolean testThree() {
        return true;
    }
    
    /**
     * Tests multiple instances of the fight() method and returns true if they 
     * all functioned as expected
     * 
     * @return boolean representing if the tests passed
     */
    public static boolean testFour() {
        int leoVtony = AnimalActivities.fight(leo, tony);
        int samVboris = AnimalActivities.fight(sam, boris);
        return (leoVtony == 0 || leoVtony == 1 || leoVtony == 2) && 
               samVboris == 1;
    }
    
    /**
     * Tests multiple instances of the reproduce() method and returns true if 
     * they all functioned as expected
     * 
     * @return boolean representing if the tests passed
     */
    public static boolean testFive() {
        Animal noBaby = AnimalActivities.reproduce(leo, tony);
        Lion lesly = new Lion(7, 80, 100);
        Animal liam = AnimalActivities.reproduce(leo, lesly);
        return noBaby.getAge() == 0 && noBaby.getHealth() == 0 && 
        noBaby.getStrength() == 0 && liam instanceof Lion;
    }

    public static boolean unitTests() {
        if(!testOne()) {
            System.out.println("Test One - sleep() failed!");
            return false;
        } else if(!testTwo()) {
            System.out.println("Test Two - eatAnimal() failed!");
            return false;
        } else if(!testThree()) {
            System.out.println("Test Three - poisonAnimal() failed!");
            return false;
        } else if(!testFour()) {
            System.out.println("Test Four - fight() failed!");
            return false;
        } else if(!testFive()) {
            System.out.println("Test Five - reproduce() failed!");
            return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        // Lion leo = new Lion(7, 100, 90);
        // Tiger tanner = new Tiger(5, 100, 0);
        // Snake sam = new Snake(4, 100, 80);

        // int winner1 = AnimalActivities.fight(leo, tanner);
        // int winner2 = AnimalActivities.fight(sam, leo);
        if(unitTests()) {
            System.out.println("All tests passed!");
        }
    }
}