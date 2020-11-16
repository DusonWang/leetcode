package code.code;

/**
 * @author duson
 * ���һ���㷨���ж�����Ƿ�Ӯ�˾�����Ϸ��������һ�� N x N ���������̣����ַ�" "��"X"��"O"��ɣ������ַ�" "����һ����λ��
 * <p>
 * �����Ǿ�����Ϸ�Ĺ���
 * <p>
 * ����������ַ������λ��" "���С�
 * ��һ��������Ƿ��ַ�"O"���ҵڶ���������Ƿ��ַ�"X"��
 * "X"��"O"ֻ��������ڿ�λ�У���������ѷ����ַ���λ�ý�����䡣
 * ����N����ͬ���ҷǿգ����ַ�����κ��С��л�Խ���ʱ����Ϸ��������Ӧ���ַ�����һ�ʤ��
 * ������λ�÷ǿ�ʱ��Ҳ��Ϊ��Ϸ������
 * �����Ϸ��������Ҳ������ٷ����ַ���
 * �����Ϸ���ڻ�ʤ�ߣ��ͷ��ظ���Ϸ�Ļ�ʤ��ʹ�õ��ַ���"X"��"O"���������Ϸ��ƽ�ֽ������򷵻� "Draw"������Ի����ж�����Ϸδ���������򷵻� "Pending"��
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺 board = ["O X"," XO","X O"]
 * ����� "X"
 * ʾ�� 2��
 * <p>
 * ���룺 board = ["OOX","XXO","OXO"]
 * ����� "Draw"
 * ���ͣ� û����һ�ʤ�Ҳ����ڿ�λ
 * ʾ�� 3��
 * <p>
 * ���룺 board = ["OOX","XXO","OX "]
 * ����� "Pending"
 * ���ͣ� û����һ�ʤ���Դ��ڿ�λ
 * ��ʾ��
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * ����һ����ѭ���������
 * ͨ������783�ύ����1,608
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Tictactoe3 {

    public String tictactoe(String[] board) {
        int n = board.length;
        boolean hasEmpty = false;
        int[] rowX = new int[n];
        int[] colX = new int[n];
        int[] rowO = new int[n];
        int[] colO = new int[n];
        int leftX = 0, rightX = 0, leftO = 0, rightO = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c == 'X') {
                    rowX[i]++;
                    colX[j]++;
                    if (i == j) {
                        leftX++;
                    }
                    if (i + j == n - 1) {
                        rightX++;
                    }
                } else if (c == 'O') {
                    rowO[i]++;
                    colO[j]++;
                    if (i == j) {
                        leftO++;
                    }
                    if (i + j == n - 1) {
                        rightO++;
                    }
                } else {
                    hasEmpty = true;
                }
            }
        }
        if (leftX == n || rightX == n) {
            return "X";
        }
        if (leftO == n || rightO == n) {
            return "O";
        }
        for (int i = 0; i < n; i++) {
            if (rowX[i] == n || colX[i] == n) {
                return "X";
            }
            if (rowO[i] == n || colO[i] == n) {
                return "O";
            }
        }
        return hasEmpty ? "Pending" : "Draw";
    }
}
