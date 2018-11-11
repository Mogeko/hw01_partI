import java.util.Scanner;

class Player {
    private String[][] mapInfo; // 用于存放地图信息
    private Scanner keyboard = new Scanner(System.in); // 用于接收用户输入
    private Scanner userXY; // 用于从用户输入中读取用户座标

    public Player(Maze maze){
        mapInfo = maze.getMap();
    }

    public void play(){
        while(true){
            System.out.print("Enter a cell (row and colum; zeros to exit): ");
            // 读取一行用户输入
            String userInput = keyboard.nextLine();
            // 读取用户座标
            userXY = new Scanner(userInput);
            int x = 0; int y = 0;
            // 读取用户座标 x
            // 当用户座标 x 不存在时跳出本循环
            if (userXY.hasNextInt()) {
                x = userXY.nextInt();
            } else {
                continue;
            }
            // 读取用户座标 y
            // 当用户座标 y 不存在时跳出本循环
            if (userXY.hasNextInt()) {
                y = userXY.nextInt();
            } else {
                continue;
            }

            // Play
            if (isQuit(x, y)) {
                // 退出
                System.out.println("Goodbye");
                userXY.close();
                keyboard.close();
                break;
            } else if (isOverflow(x, y)) {
                // 溢出
                System.out.println("(" + x + ", " + y + ") is out of the maze");
                userXY.close();
            } else if (isTreasure(x, y)) {
                // 获得宝箱
                System.out.println("(" + x + ", " + y + ") is a treasure");
                userXY.close();
            } else if (isObstacle(x, y)) {
                // 撞墙
                System.out.println("(" + x + ", " + y + ") is within an obstacle");
                userXY.close();
            } else {
                // 空格子
                System.out.println("(" + x + ", " + y + ") is an empty cell");
                userXY.close();
            }
        }
    }

    // 判断是否为退出信号
    private boolean isQuit(int x, int y){
        if (x == 0 && y == 0){
            return true;
        } else {
            return false;
        }
    }

    // 判断是否溢出
    private boolean isOverflow(int x, int y){
        if ((x <= 0) || (y <= 0) || (x >= mapInfo.length-1) || (y >= mapInfo[0].length-1)) {
            return true;
        } else {
            return false;
        }
    }

    // 判断是否得到宝箱
    private boolean isTreasure(int x, int y){
        if ("$".equals(mapInfo[x][y])){
            return true;
        } else {
            return false;
        }
    }

    // 判断是否撞墙
    private boolean isObstacle(int x, int y){
        if ("*".equals(mapInfo[x][y])){
            return true;
        } else {
            return false;
        }
    }
}