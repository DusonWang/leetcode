package code.code;

import java.util.Arrays;

/**
 * ����һ�� �� 0 ��ʼ������ nums���±�Ҳ�� 0 ��ʼ�������㹹��һ�� ͬ������ ������ ans �����У�����ÿ�� i��0 <= i < nums.length���������� ans[i] = nums[nums[i]] �����ع����õ����� ans ��
 * <p>
 * �� 0 ��ʼ������ nums ��һ���� 0 ��nums.length - 1��0 �� nums.length - 1 Ҳ�������ڣ��Ĳ�ͬ������ɵ����顣
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [0,2,1,5,3,4]
 * �����[0,1,2,4,5,3]
 * ���ͣ����� ans �������£�
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * = [0,1,2,4,5,3]
 * ʾ�� 2��
 * <p>
 * ���룺nums = [5,0,1,2,3,4]
 * �����[4,5,0,1,2,3]
 * ���ͣ����� ans �������£�
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 * = [4,5,0,1,2,3]
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * nums �е�Ԫ�� ������ͬ
 * ͨ������5,634�ύ����5,872
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/build-array-from-permutation
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BuildArray2 {

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        BuildArray2 buildArray2 = new BuildArray2();
        System.out.println(Arrays.toString(buildArray2.buildArray(new int[]{0, 2, 1, 5, 3, 4})));
    }
}
