public class Wizard extends Human {
    private String staffName;
    private int mana = 100;

    public Wizard(String name) {
        super(name, 10);
        gainGold(10000);
        setHealth(100);

        staffName = "Basic staff";
    }
    public Wizard(String name, String staffName) {
        super(name, 10);
        gainGold(10000);
        setHealth(100);
        this.staffName = staffName;
        if(this.staffName == "Light staff") {
            addAttackPower(2);
        }
        else if(this.staffName == "Dark staff") {
            addAttackPower(5);
        }
    }

    public void attack(Human opponent) {
        System.out.println("Attacking " + opponent.getName() + " with " + staffName);
        opponent.decreaseHealth(attackPower);
    }

    @Override
    public void selfHeal(double additionalHealth) {
        //Wizards heal for 2/3 the amount of the additional health
        super.selfHeal(2 / 3 * additionalHealth);
    }

}