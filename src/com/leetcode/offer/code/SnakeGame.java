package com.leetcode.offer.code;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author duson
 * 请你设计一个 贪吃蛇游戏，该游戏将会在一个 屏幕尺寸 = 宽度 x 高度 的屏幕上运行。如果你不熟悉这个游戏，可以 点击这里 在线试玩。
 * <p>
 * 起初时，蛇在左上角的 (0, 0) 位置，身体长度为 1 个单位。
 * <p>
 * 你将会被给出一个 (行, 列) 形式的食物位置序列。当蛇吃到食物时，身子的长度会增加 1 个单位，得分也会 +1。
 * <p>
 * 食物不会同时出现，会按列表的顺序逐一显示在屏幕上。比方讲，第一个食物被蛇吃掉后，第二个食物才会出现。
 * <p>
 * 当一个食物在屏幕上出现时，它被保证不能出现在被蛇身体占据的格子里。
 * <p>
 * 对于每个 move() 操作，你需要返回当前得分或 -1（表示蛇与自己身体或墙相撞，意味游戏结束）。
 * <p>
 * 示例：
 * <p>
 * 给定 width = 3, height = 2, 食物序列为 food = [[1,2],[0,1]]。
 * <p>
 * Snake snake = new Snake(width, height, food);
 * <p>
 * 初始时，蛇的位置在 (0,0) 且第一个食物在 (1,2)。
 * <p>
 * |S| | |
 * | | |F|
 * <p>
 * snake.move("R"); -> 函数返回 0
 * <p>
 * | |S| |
 * | | |F|
 * <p>
 * snake.move("D"); -> 函数返回 0
 * <p>
 * | | | |
 * | |S|F|
 * <p>
 * snake.move("R"); -> 函数返回 1 (蛇吃掉了第一个食物，同时第二个食物出现在位置 (0,1))
 * <p>
 * | |F| |
 * | |S|S|
 * <p>
 * snake.move("U"); -> 函数返回 1
 * <p>
 * | |F|S|
 * | | |S|
 * <p>
 * snake.move("L"); -> 函数返回 2 (蛇吃掉了第二个食物)
 * <p>
 * | |S|S|
 * | | |S|
 * <p>
 * snake.move("U"); -> 函数返回 -1 (蛇与边界相撞，游戏结束)
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-snake-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SnakeGame {

    private Set<String> board = new HashSet<>();
    private int[][] food;
    private int eat = 0;
    private LinkedList<Position> snake = new LinkedList<>();
    private int width, height;

    private boolean eat(int y, int x) {
        if (eat >= food.length
                || food[eat][0] < 0
                || food[eat][0] >= height
                || food[eat][1] < 0
                || food[eat][1] >= width) {
            return false;
        }
        return y == food[eat][0] && x == food[eat][1];
    }

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.food = food;
        Position head = new Position(0, 0);
        this.snake.add(head);
        board.add(head.toString());
        this.height = height;
        this.width = width;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        Position head = snake.getFirst();
        Position next = new Position(head.y, head.x);
        if ("U".equals(direction)) {
            next.y--;
        } else if ("D".equals(direction)) {
            next.y++;
        } else if ("L".equals(direction)) {
            next.x--;
        } else if ("R".equals(direction)) {
            next.x++;
        } else {
            return -1;
        }
        if (next.y < 0 || next.y >= height || next.x < 0 || next.x >= width) {
            return -1;
        }
        String ns = next.toString();
        if (eat(next.y, next.x)) {
            snake.addFirst(next);
            board.add(ns);
            eat++;
            return eat;
        }
        Position tail = snake.getLast();
        board.remove(tail.toString());
        snake.removeLast();
        if (board.contains(ns)) {
            return -1;
        }
        snake.addFirst(next);
        board.add(ns);
        return eat;
    }

    static class Position {
        private int y, x;

        public Position(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public String toString() {
            return y + "," + x;
        }
    }
    /**
     * Your SnakeGame object will be instantiated and called as such:
     * SnakeGame obj = new SnakeGame(width, height, food);
     * int param_1 = obj.move(direction);
     */
}


