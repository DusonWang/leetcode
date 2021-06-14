package code.code;

/**
 * ����һ����ά��������ranges����������left��right��ÿ��ranges[i] = [starti, endi]��ʾһ����starti��endi�ı����䡣
 * <p>
 * ���������[left, right]��ÿ����������ranges������һ�����串�ǣ���ô���㷵��true�����򷵻�false��
 * <p>
 * ��֪���� ranges[i] = [starti, endi] ��������� x ���� starti <= x <= endi����ô���ǳ�����x�������ˡ�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * �����true
 * ���ͣ�2 �� 5 ��ÿ���������������ˣ�
 * - 2 ����һ�����串�ǡ�
 * - 3 �� 4 ���ڶ������串�ǡ�
 * - 5 �����������串�ǡ�
 * ʾ�� 2��
 * <p>
 * ���룺ranges = [[1,10],[10,20]], left = 21, right = 21
 * �����false
 * ���ͣ�21 û�б��κ�һ�����串�ǡ�
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * ͨ������2,137�ύ����3,728
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsCovered {

    public boolean isCovered(int[][] ranges, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            for (int[] r : ranges) {
                if (i >= r[0] && i <= r[1]) {
                    count++;
                    break;
                }
            }
        }
        return count == right - left + 1;
    }

}
