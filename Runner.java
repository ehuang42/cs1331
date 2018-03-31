public class Runner {
    public static void main(String[] args) {
        Fighter monica = new Fighter("Monica", 1);
        Fighter janice = new Fighter("Janice", 2);
        Wizard ross = new Wizard("Ross", 5);
        Cleric rachel = new Cleric("Rachel", 6);
        Rogue gunther = new Rogue("Gunther" , 3);


        //System.out.println(monica.toString());
        //System.out.println(janice.toString());
        //System.out.println(ross.toString());
        //System.out.println(rachel.toString());
        //System.out.println(gunther.toString());


        //monica.attack(janice);
        //System.out.println(monica.getHealth());
        //System.out.println(janice.getHealth());
        //monica.attack(janice);

        // Testing Wizard Class: levelUp();
        // System.out.println(ross.toString());
        // ross.levelUp();
        // System.out.println(ross.getLevel());
        // System.out.println(ross.toString());
        // System.out.println(ross.getHealth());


        // Testing Fighter Class: levelUp();
        // System.out.println(monica.toString());
        // monica.levelUp();
        // System.out.println(monica.getLevel());
        // System.out.println(monica.toString());
        // System.out.println(monica.getHealth());

        // // Testing Wizard Class: levelUp();
        // System.out.println(janice.toString());
        // System.out.println(janice.getHealth());
        // janice.levelUp();
        // System.out.println(janice.getLevel());
        // System.out.println(janice.toString());
        // System.out.println(janice.getHealth());

        // Testing Cleric Class: levelUp();
        // System.out.println(rachel.toString());
        // System.out.println(rachel.getHealth());
        // rachel.levelUp();
        // System.out.println(rachel.getLevel());
        // System.out.println(rachel.toString());
        // System.out.println(rachel.getHealth());
        System.out.println(rachel.getHealth());
        System.out.println(monica.getHealth());
        ross.multiAttack(monica, rachel);
        System.out.println(rachel.getHealth());
        System.out.println(monica.getHealth());


        //System.out.println(monica.getHealth());

    }
}