public class Driver {
    public static void main(String[] args) {
        BuzzCard eHuang = new BuzzCard(300, 50.0, 30.0);
        System.out.println(eHuang.toString());
        System.out.println(eHuang.getMealSwipes());
        System.out.println(eHuang.getDiningDollars());
        System.out.println(eHuang.getBuzzFunds());
        eHuang.setMealSwipes(500);
        eHuang.setDiningDollars(30.0);
        eHuang.setBuzzFunds(1.0);
        System.out.println(eHuang.getMealSwipes());
        System.out.println(eHuang.getDiningDollars());
        System.out.println(eHuang.getBuzzFunds());
       
        Student eva = new Student(eHuang, 9031, "evaHuang");
        System.out.println(eva.toString());
        System.out.println(eva.getCard());
        System.out.println(eva.getId());
        System.out.println(eva.getName());

        eva.buyBrittainMealSwipes(BrittainItem.BUFFET);
        eva.buyBrittainBuzzFunds(BrittainItem.BUFFET);
        eva.buyBurdellsBuzzFunds(BurdellsItem.HEADPHONES);
        eva.buySubwayBuzzFunds(SubwayItem.CHIPS);

        System.out.println(eHuang.getMealSwipes());
        System.out.println(eHuang.getBuzzFunds());

    }
}
