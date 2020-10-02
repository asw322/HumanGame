import java.util.*;
public class Human {
    //Create data fields for name, health, experience, and attackpower
    protected String name;
    protected double health;
    protected double max_health;
    protected long experience;
    protected double attackPower;
    protected double speed;
    protected double gold;
    protected double healAmount;



    public Human(String name) {
        this.healAmount = 50;
        this.name = name;
        gold = 0;
    }
    public Human(String name, double attackPower) {
        this.healAmount = 50 + 0.2 * attackPower;
        this.name = name;
        this.attackPower = attackPower;
        gold = 0;
    }


    public long gainExperience(long experience) {
        this.experience += experience;
        return this.experience;
    }
    public long addAttackPower(long attackPower) {
        this.attackPower += attackPower;
        return attackPower;
    }
    public double heal(long additionalHealth) {
        health += additionalHealth;
        return this.health;
    }


    public void gainGold(double gold) {
        this.gold += gold;
    }
    public void loseGold(double gold) {
        this.gold -= gold;
    }


    public void selfHeal(double additionalHealth) {
        if(this.health + additionalHealth < this.max_health) {
            this.health += additionalHealth;
        }
        else {
            System.out.println("at max heatlh");
            this.health = this.max_health;
        }
    }

    public void attack(Human opponent) {
        opponent.decreaseHealth(attackPower);

        if(opponent.getHealth() < 0) {
            playerDie(opponent);
            transferGold(opponent);
        }
    }
    public void decreaseHealth(double attackPower) {
        health -= attackPower;
    }
    public void jump() {
        System.out.println("Jumped Up");
    }


    private void playerDie(Human opponent) {
        System.out.println("Player: " + opponent.getName() + " has fallen");
        System.out.println("Tranferring " + opponent.getGold() + " gold");
    }

    //Transfer half the gold to the winner
    private void transferGold(Human opponent) {
        System.out.println("Tranferring " + opponent.getGold() / 2 + " gold to " + name);
        gainGold(opponent.getGold() / 2);
        opponent.loseGold(opponent.getGold() / 2);
    }


    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public double getGold() {
        return gold;
    }

    public void setHealth(double health) {
        if(max_health == 0) {
            this.health = health;
            this.max_health = health;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}