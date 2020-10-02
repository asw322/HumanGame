public class FireArcher extends Archer {
    private double firePower = 1;

    public FireArcher(String name) {
        super(name);

    }

    @Override
    public void attack(Human opponent) {
        System.out.println("Attacking " + opponent.getName() + " with fire arrows");
        opponent.decreaseHealth(attackPower + firePower);
    }

    @Override
    public void selfHeal(double additionalHealth) {
        //archers heal for 1/2 the amount of the additional health
        System.out.println("super health = " + super.getHealth());
        super.selfHeal(1/2 * additionalHealth);
        System.out.println("super health = " + super.getHealth());
    }
}