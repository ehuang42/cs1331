import java.util.Random;

/**
 * Represents characters in DnD game.
 *
 * @author ehuang42
 * @version 9.0.1
 */

public abstract class Character {
    private String name;
    private int level;
    private int strength;
    private int dexterity;
    private int intelligence;
    private int wisdom;
    private int health;
    private boolean isDead;

    /**
     * Creates a character with name and randomly generated stats.
     *
     * @param aName the character's name
     * @param aSeed the seed random object takes in
     */

    public Character(String aName, int aSeed) {
        //implement this constructor using constructor delegation
        this(aName, 1, 0, 0, 0, 0);
        Random rn = new Random();
        rn.setSeed(aSeed);
        this.strength = rn.nextInt(6) + 1;
        this.dexterity = rn.nextInt(6) + 1;
        this.intelligence = rn.nextInt(6) + 1;
        this.wisdom = rn.nextInt(6) + 1;
    }

    /**
     * Creates a character with name, level, dexterity, strength, intelligence,
     * and wisdom.
     *
     * @param name the character's name
     * @param level the level the character is currently on
     * @param strength the strength of the character
     * @param dexterity the dexterity of the character
     * @param intelligence the intelligence of the character
     * @param wisdom the wisdom of the character
     */

    public Character(String name, int level,
                     int strength, int dexterity,
                     int intelligence, int wisdom) {
        //implement this constructor
        this.name = name;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.health = 5 * this.level;
        if (this.health < 0) {
            this.isDead = true;
            this.health = 0;
        } else {
            this.isDead = false;
        }
    }

    /**
     * @return this character's name
     */

    public String getName() {
        //implement this method
        return name;
    }

    /**
     * @return this character's level
     */

    public int getLevel() {
        //implement this method
        return level;
    }

    /**
     * Set level for the character
     * @param level the input level to set up the character
     */

    public void setLevel(int level) {
        //implement this method
        this.level = level;
    }

    /**
     * @return this character's strength
     */

    public int getStrength() {
        //implement this method
        return strength;
    }

    /**
     * Set strength for the character
     * @param strength the input strength to set up the character
     */

    public void setStrength(int strength) {
        //implement this method
        this.strength = strength;
    }

    /**
     * @return this character's dexterity
     */

    public int getDexterity() {
        //implement this method
        return dexterity;
    }

    /**
     * Set dexterity for the character
     * @param dexterity the input dexterity to set up the character
     */

    public void setDexterity(int dexterity) {
        //implement this method
        this.dexterity = dexterity;
    }

    /**
     * @return this character's intelligence
     */

    public int getIntelligence() {
        //implement this method
        return intelligence;
    }

    /**
     * Set intelligence for the character
     * @param intelligence the input intelligence to set up the character
     */

    public void setIntelligence(int intelligence) {
        //implement this method
        this.intelligence = intelligence;
    }

    /**
     * @return this character's wisdom
     */

    public int getWisdom() {
        //implement this method
        return wisdom;
    }

    /**
     * Set wisdom for the character
     * @param wisdom the input wisdom to set up the character
     */

    public void setWisdom(int wisdom) {
        //implement this method
        this.wisdom = wisdom;
    }

    /**
     * @return this character's health
     */

    public int getHealth() {
        //implement this method
        return health;
    }

    /**
     * Set health for the character
     * @param health the input health to set up the character
     */

    public void setHealth(int health) {
        //implement this method
        if (health < 0) {
            this.health = 0;
            setIsDead(true);
        } else {
            this.health = health;
        }
    }
    /**
     * @return whether this character's dead or not
     */

    public boolean getIsDead() {
        //implement this method
        return isDead;
    }

    /**
     * Set isDead condition for the character
     * @param isDead the input isDead condition to set up the character
     */

    public void setIsDead(boolean isDead) {
        //implement this method
        this.isDead = isDead;

    }

    /**
     * Raise the level of the character by 1 and reset related stats
     */

    public abstract void levelUp();

    /**
     * Attack the target and reduce the stats of it
     * @param c the character which is the target
     */

    public abstract void attack(Character c);

    /**
     * Present the character's basic info
     * @return the character's basic information
     */

    public abstract String toString();

}
