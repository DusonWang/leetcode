package code.code;

import java.util.Arrays;

/**
 * �б�� ���ͣ�XOR sum��ָ������Ԫ�ؽ��а�λ XOR ����Ľ��������б��н���һ��Ԫ�أ���ô�� ���� �͵��ڸ�Ԫ�ء�
 * <p>
 * ���磬[1,2,3,4] �� ���� ���� 1 XOR 2 XOR 3 XOR 4 = 4 ���� [3] �� ���� ���� 3 ��
 * ���������±� �� 0 ��ʼ ���������� arr1 �� arr2 ����������ɷǸ�������ɡ�
 * <p>
 * ����ÿ��?(i, j) ���ԣ�����һ���� arr1[i] AND arr2[j]����λ AND ���㣩�����ɵ��б����� 0 <= i < arr1.length �� 0 <= j < arr2.length ��
 * <p>
 * ���������б�� ���� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr1 = [1,2,3], arr2 = [6,5]
 * �����0
 * ���ͣ��б� = [1 AND 6, 1 AND 5, 2 AND 6, 2 AND 5, 3 AND 6, 3 AND 5] = [0,1,2,0,2,1] ��
 * ���� = 0 XOR 1 XOR 2 XOR 0 XOR 2 XOR 1 = 0 ��
 * ʾ�� 2��
 * <p>
 * ���룺arr1 = [12], arr2 = [4]
 * �����4
 * ���ͣ��б� = [12 AND 4] = [4] ������ = 4 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr1.length, arr2.length <= 105
 * 0 <= arr1[i], arr2[j] <= 109
 * ͨ������3,269�ύ����6,577
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/find-xor-sum-of-all-pairs-bitwise-and
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetXORSum {

    public int getXORSum(int[] arr1, int[] arr2) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i : arr1) {
            sum1 ^= i;
        }
        for (int i : arr2) {
            sum2 ^= i;
        }
        return sum1 & sum2;
    }

    public static void main(String[] args) {
        GetXORSum getXORSum = new GetXORSum();
        System.out.println(getXORSum.getXORSum(new int[]{1, 2, 3}, new int[]{6, 5}));
    }
}
