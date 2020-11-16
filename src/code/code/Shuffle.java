package code.code;

/**
 * @author duson
 * ����һ������ nums ���������� 2n ��Ԫ�أ��� [x1,x2,...,xn,y1,y2,...,yn] �ĸ�ʽ���С�
 * <p>
 * ���㽫���鰴 [x1,y1,x2,y2,...,xn,yn] ��ʽ�������У��������ź�����顣
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [2,5,1,3,4,7], n = 3
 * �����[2,3,5,4,1,7]
 * ���ͣ����� x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 �����Դ�Ϊ [2,3,5,4,1,7]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,2,3,4,4,3,2,1], n = 4
 * �����[1,4,2,3,3,2,4,1]
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,2,2], n = 2
 * �����[1,2,1,2]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * ͨ������4,397�ύ����4,861
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shuffle-the-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] nums2 = new int[nums.length];
        int m = 0;
        for (int i = 0; i < nums.length; i += 2, m++) {
            nums2[i] = nums[m];
        }
        for (int i = 1; i < nums.length; i += 2, m++) {
            nums2[i] = nums[m];
        }
        return nums2;
    }
}
