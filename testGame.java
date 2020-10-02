//FIX ME: makeMovement method
//FIX ME: initX and initY and x2 and y2 of matrix in Board.move() and Board.attack()
//Display the information after attack
//Create Heal method
//create a counter system that counter how many actions each player

import java.util.*;

public class testGame {
    public static Board board;
    private static final Scanner console = new Scanner(System.in);

    public static HashMap<String, Human> wizardMap = new HashMap<String, Human>();
    public static HashMap<String, Human> archerMap = new HashMap<String, Human>();
    public static HashMap<String, Human> firearcherMap = new HashMap<String, Human>();
    public static HashMap<String, Human> warriorMap = new HashMap<String, Human>();

    public static HashMap<String, String> accounts = new HashMap<String, String>();

    private static Human currentHuman = null;

    private static int counter = 0;

    private static void init() {
        board = new Board();
        actionCaller();
    }

    private static void actionCaller() {
        System.out.println("Enter action: \n1: Create a new character and new user\n2: Create a new character and experienced user\n3: Make an action");
        System.out.println();
        int action = console.nextInt();

        if(action == 1) {
            createCharacter();
        }
        else if(action == 2) {
            //create createExperiencedCharacter method
        }
        else if(action == 3) {
            makeMovement();
        }
        else {
            System.out.println("INVALID ACTION");
            init();
        }
    }

    private static void createCharacter() {
        System.out.println("Enter action: \n1: Create wizard\n2: Create warrior\n3: Create Archer");
        System.out.println();
        int action = console.nextInt();
        System.out.print("Enter a character name (24 character max): ");
        System.out.println();
        String name = console.next();
        boolean b = checkName(name);

        System.out.print("Enter a password (20 character max): ");
        String pass = console.next();
        boolean c = checkPass(pass);

        if(action == 1 && (b == true && c == true)) {
            Wizard myWizard = new Wizard(name);
            wizardMap.put(name, myWizard);
            board.createLocation(myWizard);
            accounts.put(name, pass);
        }
        else if(action == 2 && (b == true && c == true)) {
            Warrior myWarrior = new Warrior(name);
            warriorMap.put(name, myWarrior);
            board.createLocation(myWarrior);
            accounts.put(name, pass);
        }
        else if(action == 3 && (b == true && c == true)) {
            Archer myArcher = new Archer(name);
            archerMap.put(name, myArcher);
            board.createLocation(myArcher);
            accounts.put(name, pass);
        }
        else {
            System.out.println("INVALID ACTION");
            createCharacter();
        }

        actionCaller();
    }

    private static void makeMovement() {
        if(currentHuman == null) {
            logIn();
        }
        if(counter == 0) {
            showStats();
            counter++;
        }

        System.out.println("What would you like to do?");
        System.out.println("1: Move\n2: Attack\n3: Heal\n0: Exit");
        int action = console.nextInt();

        if(action == 1) {
            move();
            makeMovement();
        }
        else if(action == 2) {
            attack();
            makeMovement();
        }
        else if(action == 3) {
            heal();
            makeMovement();
        }
        else if(action == 0) {
            System.out.println("Exitting.. ");
        }
        else {
            System.out.println("INVALID ACTION");
            makeMovement();
        }
    }

    private static void move() {
        System.out.println("Where would you like to move?");
        System.out.print("X: ");
        int x = console.nextInt();
        System.out.print("Y: ");
        int y = console.nextInt();
        board.move(currentHuman, x, y);
    }
    private static void attack() {
        //Can only attack those who are 5 distance away from you
        System.out.println("\nWhere would you like to attack?");
        System.out.print("X: ");
        int x = console.nextInt();
        System.out.print("Y: ");
        int y = console.nextInt();
        board.attack(currentHuman, x, y);
    }
    private static void heal() {
        System.out.println("Healing " + currentHuman.getName() + " by " + currentHuman.healAmount);
        currentHuman.selfHeal(currentHuman.healAmount);
    }

    public static void logIn() {
        System.out.print("Log in \nUsername: ");
        String name = console.next();

        if(findUser(name)) {
            System.out.print("Password: ");
            String pass = console.next();

            if(accounts.get(name).equals(pass)) {
                System.out.println("Login success");
                currentHuman = getHuman(name);
            }
            else {
                System.out.println("Login Error incorrect password");
                logIn();
            }
        }
        else {
            System.out.println("Login Error incorrect character name");
            logIn();
        }
    }

    private static void showStats() {
        System.out.println("Character: " + currentHuman.getName() + "\nHealth: " + currentHuman.getHealth() + "HP" + "\nGold: " + currentHuman.getGold());
    }

    private static boolean findUser(String name) {
        if(accounts.get(name) != null) {
            return true;
        }
        return false;
    }

    private static Human getHuman(String name) {
        if(wizardMap.get(name) != null) {
            return wizardMap.get(name);
        }
        else if(archerMap.get(name) != null) {
            return archerMap.get(name);
        }
        else if(firearcherMap.get(name) != null) {
            return firearcherMap.get(name);
        }
        else if(warriorMap.get(name) != null) {
            return warriorMap.get(name);
        }
        return null;
    }

    public static boolean checkName(String name) {
        if(name.length() < 24 && name.matches("[a-zA-Z]+")) {
            return true;
        }
        else {
            System.out.println("NAME INVALID");
        }
        return false;
    }

    private static boolean checkPass(String pass) {
        if(pass.length() < 20) {
            return true;
        }
        else {
            System.out.println("PASSWORD INVALID");
        }
        return false;
    }

    public static void main(String[] args) {
        init();


//        Wizard alan = new Wizard("Sensitivity");
//        board.createLocation(alan);
//
//        Warrior david = new Warrior("MexDave", "Sunsword");
//        board.createLocation(david);
//
//        board.print();
//
//        board.move(alan, 3, 4);
//        board.move(david, 5, 5);
//
//        board.print();


//        System.out.println(alan.getHealth());
//        david.attack(alan);
//        System.out.println(alan.getHealth());
//        System.out.println(david.getGold());


//        System.out.println(david.getHealth());
//        david.selfHeal(100);
//        System.out.println(david.getHealth());
//
//
//        System.out.println("Alan health: " + alan.getHealth());
//        alan.selfHeal(100);
//        System.out.println("Alan health: " + alan.getHealth());



    }
}