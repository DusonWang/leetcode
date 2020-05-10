package com.leetcode.offer.code;

/**
 * ���Ǵ�һ����ĸ���ϵ�λ��?(0, 0)?�������������Ӧ���ַ�Ϊ?board[0][0]��
 * <p>
 * �ڱ������ĸ��Ϊboard = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]��������ʾ��
 * <p>
 * <p>
 * <p>
 * ���ǿ��԰������ָ������ж���
 * <p>
 * ���������ڣ�'U'?��ζ�Ž����ǵ�λ������һ�У�
 * ���������ڣ�'D'?��ζ�Ž����ǵ�λ������һ�У�
 * ���������ڣ�'L'?��ζ�Ž����ǵ�λ������һ�У�
 * ���������ڣ�'R'?��ζ�Ž����ǵ�λ������һ�У�
 * '!'?��������ǵ�ǰλ�� (r, c) ���ַ�?board[r][c]?��ӵ����С�
 * ��ע�⣬��ĸ����ֻ��������ĸ��λ�á���
 * <p>
 * ����ָ�����У�����С���ж������ô𰸺�Ŀ��?target?��ͬ������Է����κδ��Ŀ���·����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = "leet"
 * �����"DDR!UURRR!!DDD!"
 * ʾ�� 2��
 * <p>
 * ���룺target = "code"
 * �����"RR!DDRR!UUL!R!"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= target.length <= 100
 * target?������СдӢ����ĸ��
 * ͨ������3,206�ύ����8,007
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/alphabet-board-path
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        for (int x = 0, y = 0, i = 0; i < target.length(); i++) {
            int temp = target.charAt(i) - 'a';
            if (i > 0 && target.charAt(i) == target.charAt(i - 1)) {
                ans.append("!");
            } else {
                int nx = temp / 5;
                int ny = temp % 5;
                if (ny < y) {
                    for (int z = 0; z < y - ny; z++) {
                        ans.append("L");
                    }
                }
                if (nx < x) {
                    for (int z = 0; z < x - nx; z++) {
                        ans.append("U");
                    }
                }
                if (nx > x) {
                    for (int z = 0; z < nx - x; z++) {
                        ans.append("D");
                    }
                }
                if (ny > y) {
                    for (int z = 0; z < ny - y; z++) {
                        ans.append("R");
                    }
                }
                ans.append("!");
                x = nx;
                y = ny;
            }
        }
        return ans.toString();
    }
}
