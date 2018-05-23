/**
 * Represents a student who owns a BuzzCard, has an ID, and a name.
 * The student can also buy different items from multiple locations.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class Student {

    private String name;
    private BuzzCard card;
    private int id;

    /**
     * Creates a Student.
     *
     * @param aCard the BuzzCard that student holds
     * @param anId the id of the student
     * @param aName the name of the student
     */

    public Student(BuzzCard aCard, int anId, String aName) {
        this.card = aCard;
        this.name = aName;
        this.id = anId;
    }

    /**
     * @return the BuzzCard's information
     */

    public BuzzCard getCard() {
        return card;
    }

    /**
     * @return the name of the student
     */

    public String getName() {
        return name;
    }

    /**
     * @return the id of the studnet
     */

    public int getId() {
        return id;
    }


    /**
     * Shop at Brittain using mealswipes.
     * @param item the item of choice at Brittain
     */

    public void buyBrittainMealSwipes(BrittainItem item) {
        if (item.getMealSwipes() > card.getMealSwipes()) {
            System.out.print("You do not have the amount to buy this item :(");
        } else {
            card.setMealSwipes(card.getMealSwipes() - item.getMealSwipes());
        }
    }

    /**
     * Shop at Brittain using BuzzFunds.
     * @param item the item of choice at Brittain
     */

    public void buyBrittainBuzzFunds(BrittainItem item) {
        if (item.getBuzzFunds() > card.getBuzzFunds()) {
            System.out.print("You do not have the amount to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }

    /**
     * Shop at Burdells using BuzzFunds.
     * @param item the item of choice at Burdells
     */

    public void buyBurdellsBuzzFunds(BurdellsItem item) {
        if (item.getBuzzFunds() > card.getBuzzFunds()) {
            System.out.print("You do not have the amount to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }

    /**
     * Shop at Subway using dining dollars.
     * @param item the item of choice at Subway
     */

    public void buySubwayDiningDollars(SubwayItem item) {
        if (item.getDiningDollars() > card.getDiningDollars()) {
            System.out.print("You do not have the amount to buy this item :(");
        } else {
            card.setDiningDollars(card.getDiningDollars()
                - item.getDiningDollars());
        }
    }

    /**
     * Shop at Subway using BuzzFunds.
     * @param item the item of choice at Subway
     */

    public void buySubwayBuzzFunds(SubwayItem item) {
        if (item.getBuzzFunds() > card.getBuzzFunds()) {
            System.out.print("You do not have the amount to buy this item :(");
        } else {
            card.setBuzzFunds(card.getBuzzFunds() - item.getBuzzFunds());
        }
    }

    /**
     * @return the information related to the student
     */

    public String toString() {
        return ("Student named " + name + " with ID: " + id + " "
            + card.toString());
    }

}
