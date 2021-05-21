package code.code;

/**
 * ����һ���������� arr?������ɾ��һ�������飨����Ϊ�գ���ʹ�� arr?��ʣ�µ�Ԫ���� �ǵݼ� �ġ�
 * <p>
 * һ��������ָ����ԭ������������һ�������С�
 * <p>
 * ���㷵��������ĿҪ������������ĳ��ȡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [1,2,3,10,4,2,3,5]
 * �����3
 * ���ͣ�������Ҫɾ��������������� [10,4,2] ������Ϊ 3 ��ʣ��Ԫ���γɷǵݼ����� [1,2,3,3,5] ��
 * ��һ����ȷ�Ľ�Ϊɾ�������� [3,10,4] ��
 * ʾ�� 2��
 * <p>
 * ���룺arr = [5,4,3,2,1]
 * �����4
 * ���ͣ������������ϸ�ݼ��ģ�����ֻ�ܱ���һ��Ԫ�ء�����������Ҫɾ������Ϊ 4 �������飬Ҫôɾ�� [5,4,3,2]��Ҫôɾ�� [4,3,2,1]��
 * ʾ�� 3��
 * <p>
 * ���룺arr = [1,2,3]
 * �����0
 * ���ͣ������Ѿ��Ƿǵݼ����ˣ����ǲ���Ҫɾ���κ�Ԫ�ء�
 * ʾ�� 4��
 * <p>
 * ���룺arr = [1]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 10^5
 * 0 <= arr[i] <= 10^9
 * ͨ������4,041�ύ����12,658
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindLengthOfShortestSubarray {

    public int findLengthOfShortestSubarray(int[] arr) {
        int left = 0;
        while (left + 1 < arr.length && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == arr.length - 1) {
            return 0;
        }
        int right = arr.length - 1;
        while (right > left && arr[right - 1] <= arr[right]) {
            right--;
        }
        int result = Math.min(arr.length - left - 1, right);
        int i = 0;
        int j = right;
        while (i <= left && j < arr.length) {
            if (arr[j] >= arr[i]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
