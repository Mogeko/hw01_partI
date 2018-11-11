class Map {
    private String[][] info; // 地图的大小

    public void setMap(int x, int y){
        info = new String[x+2][y+2];

        setEdge("+", "-", "|");
        setFloor(" ");
    }

    // 获取地图信息
    public String[][] getMap(){
        return info;
    }

    // 为地图添加边框
    private void setEdge(String point, String sideX, String sideY){
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++){
                // 设置顶点
                if ((i == 0 && j == 0) || (i == 0 && j == info[i].length-1) || (i == info.length-1 && j == 0) || (i == info.length-1 && j == info[i].length-1)){
                    info[i][j] = point;
                } else {
                    // 设置横边
                    if (i == 0 || i == info.length-1){
                        info[i][j] = sideX;
                    }
                    // 设置竖边
                    if (j == 0 || j == info[i].length-1){
                        info[i][j] = sideY;
                    }
                }
            }
        }
    }

    // 为地图修地板
    private void setFloor(String floor){
        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                if (i != 0 && j != 0 && i != info.length-1 && j != info[i].length-1) {
                    info[i][j] = floor;
                }
            }
        }
    }
}