package code.code;

/**
 * ����һ������������ɵ����� nums ��
 * <p>
 * �������е� ���Լ�� ����Ϊ���������������Ĺ���Լ���е����������
 * <p>
 * ���磬���� [4,6,16] �����Լ���� 2 ��
 * �����һ�� ������ ������һ�����У�����ͨ��ɾ�������е�ĳЩԪ�أ����߲�ɾ�����õ���
 * <p>
 * ���磬[2,5,10] �� [1,2,1,2,4,1,5,10] ��һ�������С�
 * ���㲢���� nums ������ �ǿ� �������� ��ͬ ���Լ���� ��Ŀ ��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * ���룺nums = [6,10,3]
 * �����5
 * ���ͣ���ͼ��ʾ�����еķǿ�����������Ե����Լ����
 * ��ͬ�����Լ��Ϊ 6 ��10 ��3 ��2 �� 1 ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [5,15,40,5,6]
 * �����7
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 105
 * ͨ������2,106�ύ����5,923
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-different-subsequences-gcds
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CountDifferentSubsequenceGCDs {

    public int countDifferentSubsequenceGCDs(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        boolean[] present = new boolean[200001];
        for (int num : nums) {
            max = Math.max(max, num);
            present[num] = true;
        }
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (present[i]) {
                count++;
                continue;
            }
            int tmp = 0;
            for (int j = i; j <= max; j += i) {
                if (present[j]) {
                    tmp = gcd(tmp, j);
                }
                if (tmp == i) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
