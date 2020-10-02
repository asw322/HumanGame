public class Archer extends Human {
    private String bowName;
    private int arrows;
    private double speed;

    public Archer(String name) {
        super(name, 8);
        speed = 10;
        findArrows();
        gainGold(10000);
        setHealth(100);
    }
    public Archer(String name, int arrows) {
        super(name, 8);
        speed = 10;
        arrows = 20;
        gainGold(10000);
        setHealth(100);
    }
    public Archer(String name, String bowName) {
        super(name, 8);
        this.bowName = bowName;
        if(this.bowName == "Moonbow") {
            addAttackPower(8);
        }
        else if(this.bowName == "Kingsbow") {
            addAttackPower(25-8);
        }
        arrows = 20;
    }

    private void findArrows() {
        System.out.println("Looking for arrows");
    }

    @Override
    public void selfHeal(double additionalHealth) {
        //archers heal for 1/2 the amount of the additional health
        super.selfHeal(1/2 * additionalHealth);
    }
}