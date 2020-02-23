package com.leetcode.offer.code;

/**
 * @author duson
 * 病毒扩散得很快，现在你的任务是尽可能地通过安装防火墙来隔离病毒。
 * <p>
 * 假设世界由二维矩阵组成，0 表示该区域未感染病毒，而 1 表示该区域已感染病毒。可以在任意 2 个四方向相邻单元之间的共享边界上安装一个防火墙（并且只有一个防火墙）。
 * <p>
 * 每天晚上，病毒会从被感染区域向相邻未感染区域扩散，除非被防火墙隔离。现由于资源有限，每天你只能安装一系列防火墙来隔离其中一个被病毒感染的区域（一个区域或连续的一片区域），且该感染区域对未感染区域的威胁最大且保证唯一。
 * <p>
 * 你需要努力使得最后有部分区域不被病毒感染，如果可以成功，那么返回需要使用的防火墙个数; 如果无法实现，则返回在世界被病毒全部感染时已安装的防火墙个数。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: grid =
 * [[0,1,0,0,0,0,0,1],
 * [0,1,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,1],
 * [0,0,0,0,0,0,0,0]]
 * 输出: 10
 * 说明:
 * 一共有两块被病毒感染的区域: 从左往右第一块需要 5 个防火墙，同时若该区域不隔离，晚上将感染 5 个未感染区域（即被威胁的未感染区域个数为 5）;
 * 第二块需要 4 个防火墙，同理被威胁的未感染区域个数是 4。因此，第一天先隔离左边的感染区域，经过一晚后，病毒传播后世界如下:
 * [[0,1,0,0,0,0,1,1],
 * [0,1,0,0,0,0,1,1],
 * [0,0,0,0,0,0,1,1],
 * [0,0,0,0,0,0,0,1]]
 * 第二题，只剩下一块未隔离的被感染的连续区域，此时需要安装 5 个防火墙，且安装完毕后病毒隔离任务完成。
 * 示例 2：
 * <p>
 * 输入: grid =
 * [[1,1,1],
 * [1,0,1],
 * [1,1,1]]
 * 输出: 4
 * 说明:
 * 此时只需要安装 4 面防火墙，就有一小区域可以幸存，不被病毒感染。
 * 注意不需要在世界边界建立防火墙。
 *  
 * <p>
 * 示例 3:
 * <p>
 * 输入: grid =
 * [[1,1,1,0,0,0,0,0,0],
 * [1,0,1,0,1,1,1,1,1],
 * [1,1,1,0,0,0,0,0,0]]
 * 输出: 13
 * 说明:
 * 在隔离右边感染区域后，隔离左边病毒区域只需要 2 个防火墙了。
 *  
 * <p>
 * 说明:
 * <p>
 * grid 的行数和列数范围是 [1, 50]。
 *  grid[i][j] 只包含 0 或 1 。
 * 题目保证每次选取感染区域进行隔离时，一定存在唯一一个对未感染区域的威胁最大的区域。
 *  
 * <p>
 * 通过次数348提交次数726
 * 在真实的面试中遇到过这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contain-virus
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ContainVirus {

    public int containVirus(int[][] grid) {
        int result = 0;
        while (true) {
            int walls = process(grid);
            if (walls == 0) {
                break;
            }
            result += walls;
        }
        return result;
    }

    //对整个场景进行业务逻辑梳理
    private int process(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // cnt 是最大面积，ans是对应的墙
        int cnt = 0, res = 0, color = -1, row = -1, col = -1;
        //用一个数组来装当前这个点的状态
        int[][] stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0) {
                    Wall wall = new Wall();
                    wall.walls = 0;
                    int maxArea = getMaxAreaDfs(grid, stateArray, i, j, color, wall);
                    if (maxArea > cnt) {
                        cnt = maxArea;
                        res = wall.walls;
                        row = i;
                        col = j;
                    }
                    color--;
                }
            }
        }
        //修墙，将目标区域设置为未活动
        buildWall(grid, row, col);
        //另一块传播病毒
        //spread(grid,stateArray,row,col);
        stateArray = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && stateArray[i][j] == 0) {
                    spread(grid, stateArray, i, j);
                }
            }
        }
        return res;

    }

    private void spread(int[][] grid, int[][] stateArray, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || stateArray[row][col] == 1) {
            return;
        }
        if (grid[row][col] == 0) {
            grid[row][col] = 1;
            stateArray[row][col] = 1;
        } else if (grid[row][col] == 1) {
            stateArray[row][col] = 1;
            int[] dir = {-1, 0, 1, 0, -1};
            for (int i = 0; i < 4; i++) {
                spread(grid, stateArray, row + dir[i], col + dir[i + 1]);
            }
        }
    }

    private void buildWall(int[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1) {
            return;
        }
        //设置为不活动
        grid[row][col] = -1;
        int[] dir = {-1, 0, 1, 0, -1};
        //DFS
        for (int i = 0; i < 4; i++) {
            buildWall(grid, row + dir[i], col + dir[i + 1]);
        }
    }

    private int getMaxAreaDfs(int[][] grid, int[][] stateArray, int row, int col, int color, Wall wall) {
        int rows = grid.length;
        int cols = grid[0].length;
        int res = 0;
        //异常排除
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return 0;
        }
        //0不是病毒
        if (grid[row][col] == 0) {
            wall.walls++;
            //第二次进入
            if (stateArray[row][col] == color) {
                return 0;
            }
            //第一次进入
            stateArray[row][col] = color;
            return 1;
        }
        // 不是grid[i][j]==1 or 0
        if (stateArray[row][col] == 1 || grid[row][col] != 1) {
            return 0;
        }
        //grid[i][j]==1
        stateArray[row][col] = 1;
        //前后左右,再来一次，直到出现不再是1的结果。DFS的思想。
        int[] dir = {-1, 0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            res += getMaxAreaDfs(grid, stateArray, row + dir[i], col + dir[i + 1], color, wall);
        }
        return res;
    }

    static class Wall {
        public int walls;

    }
}
