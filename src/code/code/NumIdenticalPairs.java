package code.code;

/**
 * ����һ���������� nums ��
 * <p>
 * ���һ������ (i,j) ���� nums[i] == nums[j] �� i < j ���Ϳ�����Ϊ����һ�� ������ ��
 * <p>
 * ���غ����Ե���Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,3,1,1,3]
 * �����4
 * ���ͣ��� 4 ������ԣ��ֱ��� (0,3), (0,4), (3,4), (2,5) ���±�� 0 ��ʼ
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,1,1,1]
 * �����6
 * ���ͣ������е�ÿ�����ֶ��Ǻ�����
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,2,3]
 * �����0
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * ͨ������50,388�ύ����59,308
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-good-pairs
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumIdenticalPairs {

    public int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[j] == nums[i]) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
