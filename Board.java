public class Board {
    private static int x1,y1,x2,y2;
    private static Human[][] map;

    public Board() {
        System.out.println("Created a 10 by 10 board. Welcome to the game");
        System.out.println();
        createBoard();
    }

    public static void createBoard() {
        map = new Human[10][10];
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                map[i][j] = null;
            }
        }
    }

    public void move(Human human, int x2, int y2) {
        int initX = -1, initY = -1; //instantiates the coordinate of the user

        //iterates through map to find user and store coordinates
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null && human.getName() == map[i][j].getName()) {
                    initX = j;
                    initY = i;
                }
            }
        }

//        System.out.println("X = " + initX + " Y = " + initY);

        System.out.println(map[initX][initY].getName() + " at: (" + initX + ", " + initY + ")");

        boolean b = checkMovement(initX, initY, x2, y2); //calls checkMovement method to see if movement is valid

        if(b == true) {
            double distance = Math.sqrt((y2 - initY) * (y2 - initY) + (x2 - initX) * (x2 - initX));

            if(distance <= 100) {
                Human temp = map[initY][initX];
                map[initY][initX] = null;
                map[y2][x2] = temp;
                System.out.println(map[y2][x2].getName() + " has been moved to (" + x2 + ", " + y2 + ")");
            }

        }
        else {
            System.out.println("movement invalid");
        }
    }

    public void attack(Human human, int x2, int y2) {
        int initX = -1, initY = -1; //instantiates the coordinate of the user

        //iterates through map to find user and store coordinates
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] != null && human.getName() == map[i][j].getName()) {
                    initX = j;
                    initY = i;
                }
            }
        }

        System.out.println(map[initY][initX].getName() + " at: (" + initX + ", " + initY + ")");

        boolean b = checkAttack(initX, initY, x2, y2); //calls checkMovement method to see if movement is valid

        if(b == true) {
            double distance = Math.sqrt((y2 - initY) * (y2 - initY) + (x2 - initX) * (x2 - initX));

            if(distance <= 10) {
                map[initY][initX].attack(map[y2][x2]);
            }

        }
        else {
            System.out.println("Miss");
        }
    }

    public boolean checkMovement(int x1, int y1, int x2, int y2) {
        if(x2 <= 10 && x2 <= 10) {
            if(y2 >= 0 && y2 <= 10) {
                if(map[y2][x2] == null) {
                    return true;
                }
            } return false;
        } return false;
    }

    public boolean checkAttack(int x1, int y1, int x2, int y2) {
        if(x2 <= 10 && x2 <= 10) {
            if(y2 >= 0 && y2 <= 10) {
                if(map[y2][x2] != null) {
                    return true;
                }
            } return false;
        } return false;
    }


    public void print() {
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == null) {
                    System.out.print(map[i][j] + " ");
                }
                else {
                    System.out.print(map[i][j].toString() + " ");
                }
            }
            System.out.println();
        }
    }

    public static void createLocation(Human character) {
        boolean b = true;

        while(b == true) {
            x1 = (int) (Math.random() * 10);
            y1 = (int) (Math.random() * 10);
            x2 = (int) (Math.random() * 10);
            y2 = (int) (Math.random() * 10);

            if(map[x1][y1] == null) {
                System.out.println("Character at: (" + x1 + ", " + y1 + ")");
                map[x1][y1] = character;
                b = false;
            }
        }
    }
}