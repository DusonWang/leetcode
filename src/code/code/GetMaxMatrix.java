package code.code;

import java.util.Arrays;

/**
 * ����һ������������������ 0 ��ɵ� N �� M?���󣬱�д�����ҳ�Ԫ���ܺ������Ӿ���
 * <p>
 * ����һ������ [r1, c1, r2, c2]������ r1, c1 �ֱ�����Ӿ������Ͻǵ��кź��кţ�r2, c2 �ֱ�������½ǵ��кź��кš����ж�������������Ӿ��󣬷�������һ�����ɡ�
 * <p>
 * ע�⣺�����������ԭ�������Ķ�
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * [
 * ?  [-1,0],
 * ?  [0,-1]
 * ]
 * �����[0,1,0,1]
 * ���ͣ������б�ֵ�Ԫ�ؼ�Ϊ�������ʾ�ľ���
 * ?
 * <p>
 * ˵����
 * <p>
 * 1 <= matrix.length, matrix[0].length <= 200
 * ͨ������6,435�ύ����12,537
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/max-submatrix-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GetMaxMatrix {

    public int[] getSubArrayMaxSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        int x1 = 0;
        int x2 = 0;
        int begin = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cur == 0) {
                begin = i;
            }
            cur += nums[i];
            if (cur > max) {
                x2 = i;
                x1 = begin;
                max = cur;
            }
            cur = Math.max(cur, 0);
        }
        return new int[]{max, x1, x2};
    }

    public int[] getMaxMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] sum = new int[cols];
        int max = Integer.MIN_VALUE;
        int x = 0;
        int y = 0;
        int x1 = 0;
        int x2 = 0;
        for (int i = 0; i < rows; i++) {
            Arrays.fill(sum, 0);
            for (int j = i; j < rows; j++) {
                for (int col = 0; col < cols; col++) {
                    sum[col] += matrix[j][col];
                }
                int[] flags = getSubArrayMaxSum(sum);
                if (max < flags[0]) {
                    x = i;
                    x1 = j;
                    y = flags[1];
                    x2 = flags[2];
                    max = flags[0];
                }
            }
        }
        return new int[]{x, y, x1, x2};
    }

    public static void main(String[] args) {
        GetMaxMatrix getMaxMatrix = new GetMaxMatrix();
        System.out.println(Arrays.toString(getMaxMatrix.getMaxMatrix(new int[][]{{-1, 0}, {0, -1}})));
    }
}
