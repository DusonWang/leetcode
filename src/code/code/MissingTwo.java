package code.code;

/**
 * ����һ�����飬������ 1 �� N ���е�������������ȱ���������֡������� O(N) ʱ����ֻ�� O(1) �Ŀռ��ҵ�������
 * <p>
 * ������˳�򷵻����������־��ɡ�
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [1]
 * ���: [2,3]
 * ʾ�� 2:
 * <p>
 * ����: [2,3]
 * ���: [1,4]
 * ��ʾ��
 * <p>
 * nums.length <=?30000
 * ͨ������1,545�ύ����2,819
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/missing-two-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MissingTwo {

    public int[] missingTwo(int[] nums) {
        int[] res = new int[2];
        int cnt = nums.length + 2;
        int ans = 0;
        for (int num : nums) {
            ans += num;
        }
        int sum = (1 + cnt) * cnt / 2;
        int tmp = sum - ans;
        int half = tmp / 2;
        int first = 0;
        for (int num : nums) {
            if (num <= half) {
                first += num;
            }
        }
        res[0] = (1 + half) * half / 2 - first;
        res[1] = tmp - res[0];
        return res;
    }
}
