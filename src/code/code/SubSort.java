package code.code;

/**
 * ����һ���������飬��дһ���������ҳ�����m��n��ֻҪ����������[m,n]��Ԫ���ź������������������ġ�ע�⣺n-m������С��Ҳ����˵���ҳ�����������������С���������ֵΪ[m,n]����������������m��n��������������������ģ����뷵��[-1,-1]��
 * <p>
 * ʾ����
 * <p>
 * ���룺 [1,2,4,7,10,11,7,12,6,7,16,18,19]
 * ����� [3,9]
 * ��ʾ��
 * <p>
 * 0 <= len(array) <= 1000000
 * ͨ������2,468�ύ����5,807
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sub-sort-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SubSort {

    public int[] subSort(int[] array) {
        if (array == null || array.length == 0) {
            return new int[]{-1, -1};
        }
        int last = -1, first = -1;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = array.length;
        for (int i = 0; i < len; i++) {
            if (array[i] < max) {
                last = i;
            } else {
                max = array[i];
            }
            if (array[len - 1 - i] > min) {
                first = len - 1 - i;
            } else {
                min = array[len - 1 - i];
            }
        }
        return new int[]{first, last};
    }
}
