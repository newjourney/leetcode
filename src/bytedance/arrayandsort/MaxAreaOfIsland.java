package bytedance.arrayandsort;

/**
 * 695. 岛屿最大面积
 * 典型的深度优先搜索算法
 * 
 * @author xingkai.zhang
 */
public class MaxAreaOfIsland {

    public static int method1(int[][] grid) {
        int maxX = grid.length;
        int maxY = grid[0].length;
        boolean[][] visited = new boolean[maxX][maxY];
        int ret = 0;
        for (int x = 0; x < maxX; x++) {
            for (int y = 0; y < maxY; y++) {
                ret = Math.max(ret, area(x, y, grid, visited, maxX, maxY));
            }
        }
        return ret;
    }

    private static int area(int x, int y, int[][] grid, boolean[][] visited, int maxX, int maxY) {
        if (x < 0 || x >= maxX || y < 0 || y >= maxY || grid[x][y] == 0 || visited[x][y])
            return 0;
        visited[x][y] = true;
        return area(x - 1, y, grid, visited, maxX, maxY) //
                + area(x + 1, y, grid, visited, maxX, maxY) //
                + area(x, y - 1, grid, visited, maxX, maxY) //
                + area(x, y + 1, grid, visited, maxX, maxY) //
                + 1;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { new int[] { 1, 1, 0, 0, 0 }, 
                                     new int[] { 1, 1, 0, 0, 0 },
                                     new int[] { 0, 0, 0, 1, 1 }, 
                                     new int[] { 0, 0, 0, 1, 1 }
        };
        System.out.println(method1(grid));
    }

}
