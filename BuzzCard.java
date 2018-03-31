/**
 * Represents BuzzCard that contains information about meal swipes,
 * dining dollars, and buzzfunds.
 *
 * @author ehuang42
 * @version 9.0.1
 */


public class BuzzCard {

    private int mealSwipes;
    private double diningDollars;
    private double buzzFunds;


    /**
     * Creates a BuzzCard.
     *
     * @param meal the initial mealswipes
     * @param buzz the initial buzzfunds
     * @param dining the initial dining dollars
     */

    public BuzzCard(int meal, double dining, double buzz) {
        this.mealSwipes = meal;
        this.diningDollars = dining;
        this.buzzFunds = buzz;
    }

    /**
     * @return the number of mealswipes
     */

    public int getMealSwipes() {
        return mealSwipes;
    }

    /**
     * @return the number of dining dollars
     */

    public double getDiningDollars() {
        return diningDollars;
    }

    /**
     * @return the number of BuzzFunds
     */

    public double getBuzzFunds() {
        return buzzFunds;
    }

    /**
     * @param mealSwipes the number of new meal swipes
     */

    public void setMealSwipes(int mealSwipes) {
        this.mealSwipes = mealSwipes;
    }

    /**
     * @param diningDollars the number of new dining dollars
     */

    public void setDiningDollars(double diningDollars) {
        this.diningDollars = diningDollars;
    }

    /**
     * @param buzzFunds the number of new BuzzFunds
     */

    public void setBuzzFunds(double buzzFunds) {
        this.buzzFunds = buzzFunds;
    }

    /**
     * @return the information stored in BuzzCard
     */

    public String toString() {
        String result = "Buzzcard balance with Dining Dollars: "
            + diningDollars + ", BuzzFunds: " + buzzFunds + ", Meal Swipes: "
            + mealSwipes;
        return result;
    }
}