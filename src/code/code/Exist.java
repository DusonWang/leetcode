package code.code;

/**
 * @author duson
 * <p>
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true.
 * 给定 word = "SEE", 返回 true.
 * 给定 word = "ABCB", 返回 false.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Exist {

//    private boolean[][] marked;
//    private int m;
//    private int n;
//    private String word;
//    private char[][] board;
//    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
//
//    public boolean exist(char[][] board, String word) {
//        m = board.length;
//        if (m == 0) {
//            return false;
//        }
//        n = board[0].length;
//        marked = new boolean[m][n];
//        this.word = word;
//        this.board = board;
//
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (dfs(i, j, 0)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean dfs(int i, int j, int start) {
//        if (start == word.length() - 1) {
//            return board[i][j] == word.charAt(start);
//        }
//        if (board[i][j] == word.charAt(start)) {
//            marked[i][j] = true;
//            for (int k = 0; k < 4; k++) {
//                int nx = i + direction[k][0];
//                int ny = j + direction[k][1];
//                if ((nx >= 0 && nx < m && ny >= 0 && ny < n) && !marked[nx][ny]) {
//                    if (dfs(nx, ny, start + 1)) {
//                        return true;
//                    }
//                }
//            }
//            marked[i][j] = false;
//        }
//        return false;
//    }

    public boolean exist(char[][] board, String word) {
        final int m = board.length;
        final int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }

        if (visited[x][y]) {
            return false;
        }

        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        visited[x][y] = true;

        boolean ret = dfs(board, word, index + 1, x - 1, y, visited) ||
                dfs(board, word, index + 1, x + 1, y, visited) ||
                dfs(board, word, index + 1, x, y - 1, visited) ||
                dfs(board, word, index + 1, x, y + 1, visited);
        visited[x][y] = false;
        return ret;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";
        Exist solution = new Exist();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }
}
