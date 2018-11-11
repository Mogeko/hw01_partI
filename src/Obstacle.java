class Obstacle {
    private String obstacle; // 这是一个障碍物
    private int x1, y1, x2, y2; // 障碍物的横纵座标
    private String[][] mapInfo; // 储存地图信息

    public Obstacle(String flag, int x1, int y1, int x2, int y2){
        this.obstacle = flag;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    // 根据横纵座标将障碍物放到地图里
    public void getObstacle(Map map){
        mapInfo = map.getMap();
        for (int i = 0; i <= x2; i++) {
            for (int j = 0; j <= y2; j++) {
                if (i >= x1 && j >= y1) {
                    mapInfo[i][j] = obstacle;
                }
            }
        }
    }
}