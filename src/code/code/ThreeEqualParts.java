package code.code;

import java.util.Arrays;

/**
 * ����һ���� 0 �� 1 ��ɵ�����?A��������ֳ� 3?���ǿյĲ��֣�ʹ��������Щ���ֱ�ʾ��ͬ�Ķ�����ֵ��
 * <p>
 * ��������������뷵���κ�?[i, j]������ i+1 < j������һ����
 * <p>
 * A[0], A[1], ..., A[i]?��ɵ�һ���֣�
 * A[i+1], A[i+2], ..., A[j-1]?��Ϊ�ڶ����֣�
 * A[j], A[j+1], ..., A[A.length - 1] �ǵ������֡�
 * ��������������ʾ�Ķ�����ֵ��ȡ�
 * ����޷��������ͷ���?[-1, -1]��
 * <p>
 * ע�⣬�ڿ���ÿ����������ʾ�Ķ�����ʱ��Ӧ�����俴��һ�����塣���磬[1,1,0]?��ʾʮ�����е�?6����������?3�����⣬ǰ����Ҳ�Ǳ�����ģ�����?[0,1,1] ��?[1,1]?��ʾ��ͬ��ֵ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺[1,0,1,0,1]
 * �����[0,3]
 * ʾ�� 2��
 * <p>
 * �����[1,1,0,1,1]
 * �����[-1,-1]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 3 <= A.length <= 30000
 * A[i] == 0?��?A[i] == 1
 * ?
 * <p>
 * ͨ������3,005�ύ����9,173
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/three-equal-parts
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ThreeEqualParts {

    public int[] threeEqualParts(int[] aa) {
        int[] res = new int[]{-1, -1};
        int numOf1 = 0;
        for (int a : aa) {
            if (a == 1) {
                numOf1++;
            }
        }
        if (numOf1 == 0) {
            return new int[]{0, 2};
        }
        if (numOf1 % 3 != 0) {
            return res;
        }
        int partLength = numOf1 / 3;
        int index0 = -1;
        int index1 = -1;
        int index2 = -1;
        numOf1 = 0;
        for (int i = 0; i < aa.length; i++) {
            if (aa[i] == 1) {
                numOf1++;
                if (numOf1 == 1) {
                    index0 = i;
                } else if (numOf1 == partLength + 1) {
                    index1 = i;
                } else if (numOf1 == 2 * partLength + 1) {
                    index2 = i;
                }
            }
        }
        while (index2 < aa.length) {
            if (aa[index2] == aa[index0] && aa[index2] == aa[index1]) {
                index2++;
                index1++;
                index0++;
            } else {
                return res;
            }
        }
        return new int[]{index0 - 1, index1};
    }

    public static void main(String[] args) {
        ThreeEqualParts threeEqualParts = new ThreeEqualParts();
        System.out.println(Arrays.toString(threeEqualParts.threeEqualParts(new int[]{1, 0, 1, 0, 1})));
    }
}
