package code.code;

/**
 * ����һ���� ��ͬ ������ɵ��������� arr ��һ������ k ��
 * <p>
 * ÿ�غ���Ϸ���������ǰ����Ԫ�أ��� arr[0] �� arr[1] ��֮����С��Ƚ� arr[0] �� arr[1] �Ĵ�С���ϴ����������ȡ����һ�غϵ�ʤ����������λ�� 0 ����С���������������ĩβ����һ������Ӯ�� k �������غ�ʱ����Ϸ���������������Ǳ����� Ӯ�� ��
 * <p>
 * ����Ӯ�ñ�����������
 * <p>
 * ��Ŀ���� ��֤ ��Ϸ����Ӯ�ҡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [2,1,3,5,4,6,7], k = 2
 * �����5
 * ���ͣ�һ��һ�±�����Ϸÿ�غϵ������
 * <p>
 * ��˽����� 4 �غϱ��������� 5 ��Ӯ�ң���Ϊ����ʤ 2 �غϡ�
 * ʾ�� 2��
 * <p>
 * ���룺arr = [3,2,1], k = 10
 * �����3
 * ���ͣ�3 ������ǰ 10 ���غ���������ʤ��
 * ʾ�� 3��
 * <p>
 * ���룺arr = [1,9,8,2,3,7,6,4,5], k = 7
 * �����9
 * ʾ�� 4��
 * <p>
 * ���룺arr = [1,11,22,33,44,55,66,77,88,99], k = 1000000000
 * �����99
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^6
 * arr ���������� ������ͬ ��
 * 1 <= k <= 10^9
 * ͨ������12,579�ύ����27,878
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-the-winner-of-an-array-game
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetWinner {

    public int getWinner(int[] arr, int k) {
        int prev = Math.max(arr[0], arr[1]);
        if (k == 1) {
            return prev;
        }
        int consecutive = 1;
        int maxNum = prev;
        int length = arr.length;
        for (int i = 2; i < length; i++) {
            int curr = arr[i];
            if (prev > curr) {
                consecutive++;
                if (consecutive == k) {
                    return prev;
                }
            } else {
                prev = curr;
                consecutive = 1;
            }
            maxNum = Math.max(maxNum, curr);
        }
        return maxNum;
    }
}
