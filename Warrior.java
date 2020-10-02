public class Warrior extends Human {
    private String swordName;

    public Warrior(String name) {
        super(name, 125);
        swordName = "Basic sword";
        setHealth(150);
        gainGold(10000);
    }
    public Warrior(String name, String swordName) {
        super(name, 125);
        this.swordName = swordName;
        setHealth(150);
        gainGold(10000);
    }

    @Override
    public void attack(Human opponent) {
        System.out.println("Attacking " + opponent.getName() + " with " + swordName);
        super.attack(opponent);
    }

    @Override
    public void selfHeal(double additionalHealth) {
        //Warriors heal for 2 times the additional health
        super.selfHeal(2 * additionalHealth);
    }


}