package code.code;

/**
 * ������ռ�ȳ���һ���Ԫ�س�֮Ϊ��ҪԪ�ء�����һ�� ���� ���飬�ҳ����е���ҪԪ�ء���û�У����� -1 �������ʱ�临�Ӷ�Ϊ O(N) ���ռ临�Ӷ�Ϊ O(1) �Ľ��������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[1,2,5,9,5,9,5,5,5]
 * �����5
 * ʾ�� 2��
 * <p>
 * ���룺[3,2]
 * �����-1
 * ʾ�� 3��
 * <p>
 * ���룺[2,2,1,1,1,2,2]
 * �����2
 * ͨ������49,372�ύ����88,362
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-majority-element-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MajorityElement3 {

    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        int len = nums.length;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        int k = 0;
        for (int num : nums) {
            if (num == candidate) {
                k++;
            }
        }
        return k > len / 2 ? candidate : -1;
    }

    public static void main(String[] args) {
        MajorityElement3 majorityElement3 = new MajorityElement3();
        System.out.println(majorityElement3.majorityElement(new int[]{1, 2, 3}));
        System.out.println(majorityElement3.majorityElement(new int[]{1, 2, 5, 9, 5, 9, 5, 5, 5}));
        System.out.println(majorityElement3.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));

    }
}
