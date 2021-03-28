package code.code;

/**
 * ��������������n �� start ��
 * <p>
 * ���� nums ����Ϊ��nums[i] = start + 2*i���±�� 0 ��ʼ���� n == nums.length ��
 * <p>
 * �뷵�� nums ������Ԫ�ذ�λ���XOR����õ��Ľ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 5, start = 0
 * �����8
 * ���ͣ����� nums Ϊ [0, 2, 4, 6, 8]������ (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 ��
 * "^" Ϊ��λ��� XOR �������
 * ʾ�� 2��
 * <p>
 * ���룺n = 4, start = 3
 * �����8
 * ���ͣ����� nums Ϊ [3, 5, 7, 9]������ (3 ^ 5 ^ 7 ^ 9) = 8.
 * ʾ�� 3��
 * <p>
 * ���룺n = 1, start = 7
 * �����7
 * ʾ�� 4��
 * <p>
 * ���룺n = 10, start = 5
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 * ͨ������30,607�ύ����36,364
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/xor-operation-in-an-array easy
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class XorOperation {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }

}
