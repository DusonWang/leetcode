package code.code;

/**
 * @author duson
 * һ�� N?x N�� board?����?0?��?1?���?��ÿ���ƶ����������⽻�����л������е�λ�á�
 * <p>
 * �������������Ϊ �����̡� �������С�ƶ������������̡� ��ָ����һ������������ĸ������ֵ���뱾��ͬ�ľ�����������ڿ��еı任����� -1��
 * <p>
 * ʾ��:
 * ����: board = [[0,1,1,0],[0,1,1,0],[1,0,0,1],[1,0,0,1]]
 * ���: 2
 * ����:
 * һ�ֿ��еı任��ʽ���£������ң�
 * <p>
 * 0110     1010     1010
 * 0110 --> 1010 --> 0101
 * 1001     0101     1010
 * 1001     0101     0101
 * <p>
 * ��һ���ƶ������˵�һ�к͵ڶ��С�
 * �ڶ����ƶ������˵ڶ��к͵����С�
 * <p>
 * <p>
 * ����: board = [[0, 1], [1, 0]]
 * ���: 0
 * ����:
 * ע�����Ͻǵĸ�ֵΪ0ʱҲ�ǺϷ������̣��磺
 * <p>
 * 01
 * 10
 * <p>
 * Ҳ�ǺϷ�������.
 * <p>
 * ����: board = [[1, 0], [1, 0]]
 * ���: -1
 * ����:
 * ����ı任������ʹ��������Ϊ�Ϸ������̡�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * board?�Ƿ������������ķ�Χ��[2, 30]��
 * board[i][j]?��ֻ����?0��?1��
 * ͨ������649�ύ����1,587
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/transform-to-chessboard
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MovesToChessboard {

    public int movesToChessboard(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return -1;
        }
        int n = board.length;
        for (int[] ints : board) {
            for (int j = 0; j < n; ++j) {
                if ((board[0][0] ^ ints[0] ^ board[0][j] ^ ints[j]) == 1) {
                    return -1;
                }
            }
        }
        int rowSum = 0;
        int colSum = 0;
        int rowSwap = 0;
        int colSwap = 0;
        for (int i = 0; i < n; ++i) {
            rowSum += board[0][i];
            colSum += board[i][0];
            if (board[i][0] == i % 2) {
                ++rowSwap;
            }
            if (board[0][i] == i % 2) {
                ++colSwap;
            }
        }
        if (n / 2 > rowSum || n / 2 > (n - rowSum) ||
                n / 2 > colSum || n / 2 > (n - colSum)) {
            return -1;
        }
        if (n % 2 == 0) {
            rowSwap = Math.min(rowSwap, n - rowSwap);
            colSwap = Math.min(colSwap, n - colSwap);
        } else {
            if (colSwap % 2 == 1) {
                colSwap = n - colSwap;
            }
            if (rowSwap % 2 == 1) {
                rowSwap = n - rowSwap;
            }
        }
        return (rowSwap + colSwap) / 2;
    }
}
