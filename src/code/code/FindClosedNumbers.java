package code.code;

/**
 * ��һ����������һ�����������ҳ���������Ʊ��ʽ��1�ĸ�����ͬ�Ҵ�С��ӽ�������������һ���Դ�һ����С����
 * <p>
 * ʾ��1:
 * <p>
 * ���룺num = 2������0b10��
 * �����[4, 1] ���ߣ�[0b100, 0b1]��
 * ʾ��2:
 * <p>
 * ���룺num = 1
 * �����[2, -1]
 * ��ʾ:
 * <p>
 * num�ķ�Χ��[1, 2147483647]֮�䣻
 * ����Ҳ���ǰһ�����ߺ�һ��������������������ô��� -1��
 * ͨ������945�ύ����2,282
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/closed-number-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * @author duson
 */
public class FindClosedNumbers {

    public int[] findClosedNumbers(int num) {
        int little = num - 1;
        int bigger = num + 1;
        int binNums = Integer.bitCount(num);
        while (Integer.bitCount(little) != binNums && little > 0) {
            little--;
        }
        while (Integer.bitCount(bigger) != binNums && bigger > 0) {
            bigger++;
        }
        return new int[]{bigger > 0 ? bigger : -1, little > 0 ? little : -1};
    }
}
