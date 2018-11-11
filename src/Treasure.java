class Treasure {
    private String treasure; // 这是一个宝箱
    private int x, y; // 宝箱的横纵座标
    private String[][] mapInfo; // 存储地图信息

    public Treasure(String flag, int x, int y){
        this.treasure = flag;
        this.x = x;
        this.y = y;
    }

    // 根据横纵座标将宝箱放到地图里
    public void getTreasure(Map map){
        mapInfo = map.getMap();
        for (int i = 0; i < x+1; i++) {
            for (int j = 0; j < y+1; j++) {
                if (i == x && j == y) {
                    mapInfo[x][y] = treasure;
                }
            }
        }
    }
}