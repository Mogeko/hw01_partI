import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class Maze {
    private String filePath; // 配置文件目录
    private Map map = new Map(); // 创建地图
    private Treasure treasure; // 创建宝箱类
    private Obstacle obstacle; // 创建障碍物类

    public static void main(String[] args) {

        // 创建迷宫
        Maze maze = new Maze();
        // 输出迷宫
        maze.getMaze();

        // 创建玩家
        Player player = new Player(maze);
        // Play
        player.play();
    }

    {
        // 输入命令，获取filePlan
        Scanner keyboard = new Scanner(System.in);
        while (true) {
            System.out.print("Please enter the grid file name: ");
            String fileName = keyboard.nextLine();
            if ("plan1.txt".equals(fileName)) {
                filePath = "../config/plan1.txt";
                break;
            } else if ("plan2.txt".equals(fileName)) {
                filePath = "../config/plan2.txt";
                break;
            } else {
                System.out.println("Error!! This is not a useful configuration file.");
            }
        }
        System.out.println();
    }

    // 初始化，从文件读取信息
    public Maze(){
        Scanner scFile = null;
        try {
            scFile = new Scanner(new File(filePath));
            // 调用方法处理读取到的信息
            setMaze(scFile);
        } catch (FileNotFoundException e) {
            // 未读取到配置文件
            // e.printStackTrace();
            System.out.println("Error!! Could not find file '" + filePath.substring(10, 19) + "'.");
            System.exit(1);
        } catch (NoSuchElementException e) {
            // 配置文件出错
            // e.printStackTrace();
            System.out.println("Error!! Configuration file error.");
            System.out.println("Please check your configuration file: " + filePath.substring(10, 19));
            System.exit(1);
        }
    }

    private void setMaze(Scanner scFile){
        boolean isMap = true; // 控制处理的是否是 Map 信息
        Scanner scan; // 用于从文件中读取信息

        // 处理信息
        while (scFile.hasNextLine()) {
            // 处理 Map 的信息
            if (isMap) {
                scan = new Scanner(scFile.nextLine());
                map.setMap(scan.nextInt(), scan.nextInt());
                scan.close();
                isMap = false;
            } else {
                scan = new Scanner(scFile.nextLine());
                String flag = scan.next();

                // 处理宝箱的信息
                if ("$".equals(flag)) {
                    treasure = new Treasure("$", scan.nextInt(), scan.nextInt());
                    treasure.getTreasure(map);
                    scan.close();
                }

                // 处理障碍物的信息
                if ("*".equals(flag)) {
                    obstacle = new Obstacle("*", scan.nextInt(), scan.nextInt(), scan.nextInt(), scan.nextInt());
                    obstacle.getObstacle(map);
                    scan.close();
                }
            }
        }
        scFile.close();
    }

    // 输出处理好的 Maze
    public void getMaze(){
        // 输出结果
        for (String[] temp : map.getMap()) {
            for (String mapXY : temp) {
                System.out.print(mapXY);
            }
            System.out.print("\n");
        }
        System.out.println();
    }

    // 获取地图信息
    public String[][] getMap(){
        return map.getMap();
    }
}