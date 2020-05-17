package com.leetcode.offer.code;

/**
 * @author duson
 * ħ�������� ������A[0...n-1]�У�����ν��ħ����������������A[i] = i������һ�������������飬��дһ�ַ����ҳ�ħ�����������еĻ���������A���ҳ�һ��ħ�����������û�У��򷵻�-1�����ж��ħ����������������ֵ��С��һ����
 * <p>
 * ʾ��1:
 * <p>
 * ���룺nums = [0, 2, 3, 4, 5]
 * �����0
 * ˵��: 0�±��Ԫ��Ϊ0
 * ʾ��2:
 * <p>
 * ���룺nums = [1, 1, 1]
 * �����1
 * ��ʾ:
 * <p>
 * nums������[1, 1000000]֮��
 * ͨ������4,145�ύ����6,447
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/magic-index-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindMagicIndex {

    public int findMagicIndex2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }

    private int res = -1;

    public int findMagicIndex(int[] nums) {
        bi(nums, 0, nums.length - 1);
        return res;
    }

    public void bi(int[] nums, int l, int r) {
        if (l > r) {
            return;
        }
        int mid = (l + r) / 2;
        if (nums[mid] == mid) {
            res = mid;
        }
        bi(nums, l, mid - 1);
        if (res == -1) {
            bi(nums, mid + 1, r);
        }
    }
}
