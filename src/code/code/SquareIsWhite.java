package code.code;

/**
 * ����һ������?coordinates?������һ���ַ�������ʾ��������������һ�����ӵ����ꡣ��ͼ�ǹ�����������ʾ��ͼ��
 * <p>
 * <p>
 * <p>
 * ����������ӵ���ɫ�ǰ�ɫ�����㷵��?true������Ǻ�ɫ���뷵��?false?��
 * <p>
 * ��������һ�������������������һ�����ڵĸ��ӡ������һ���ַ�����ĸ���ڶ����ַ������֡�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺coordinates = "a1"
 * �����false
 * ���ͣ�����ͼ������ʾ��"a1" ����ĸ����Ǻ�ɫ�ģ����Է��� false ��
 * ʾ�� 2��
 * <p>
 * ���룺coordinates = "h3"
 * �����true
 * ���ͣ�����ͼ������ʾ��"h3" ����ĸ����ǰ�ɫ�ģ����Է��� true ��
 * ʾ�� 3��
 * <p>
 * ���룺coordinates = "c7"
 * �����false
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 * ͨ������5,267�ύ����6,603
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/determine-color-of-a-chessboard-square
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SquareIsWhite {

    public boolean squareIsWhite(String coordinates) {
        char[] a = coordinates.toCharArray();
        int x = a[0] - 'a';
        int y = a[1] - '0';
        return x % 2 == 0 && y % 2 == 0 || x % 2 == 1 && y % 2 == 1;
    }
}
