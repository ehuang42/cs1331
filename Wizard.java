
/**
 * Represents Wizard character in the game.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public class Wizard extends Character {


    /**
     * Creates a Wizard character with name and randomly generated stats.
     *
     * @param aName the character's name
     * @param aSeed the seed random object takes in
     */

    public Wizard(String aName, int aSeed) {
        super(aName, aSeed);
    }


    /**
     * Creates a Wizard character with name, level, dexterity, strength,
     * intelligence, and wisdom.
     *
     * @param aName the character's name
     * @param aLevel the level the character is currently on
     * @param aStrength the strength of the character
     * @param aDexterity the dexterity of the character
     * @param anIntelligence the intelligence of the character
     * @param aWisdom the wisdom of the character
     */

    public Wizard(String aName, int aLevel,
                     int aStrength, int aDexterity,
                     int anIntelligence, int aWisdom) {
        super(aName, aLevel, aStrength, aDexterity, anIntelligence, aWisdom);
    }

    /**
     * Attack the target and reduce the stats of it
     * @param c the character which is the target
     */

    public void attack(Character c) {
        if (c.getIsDead()) {
            System.out.println("Cannot attack a dead character");
        } else {
            c.setHealth(c.getHealth() - 6 - getWisdom());
        }
    }

    /**
     * Raise the level of the character by 1 and reset related stats
     */

    public void levelUp() {
        setLevel(getLevel() + 1);
        setHealth(getLevel() * 5);
        setDexterity(getDexterity() + 1);
        setStrength(getStrength() + 1);
        setWisdom(getWisdom() + 1);
        setIntelligence(getIntelligence() + 2);
    }

    /**
    * Attack multiple characters
    * @param c the targeted character list
    */
    public void multiAttack(Character ... c) {
        for (Character aChar : c) {
            if (aChar.getIsDead()) {
                System.out.println("Cannot damage a dead character");
            } else {
                aChar.setHealth(aChar.getHealth() - 2 - getIntelligence());
            }
        }
    }

    /**
     * Present the character's basic info
     * @return the character's basic information
     */

    @Override
    public String toString() {
        return "Level " + getLevel() + " fighter named " + getName() + " with "
            + getStrength() + " strength, " + getDexterity() + " dexterity, "
                + getIntelligence() + " intelligence, and " + getWisdom()
                    + " wisdom.";
    }
}