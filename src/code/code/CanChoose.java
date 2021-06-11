package code.code;

/**
 * ����һ������Ϊ n�Ķ�ά��������groups��ͬʱ����һ����������nums��
 * <p>
 * ���Ƿ���Դ� nums��ѡ�� n�� ���ཻ �������飬ʹ�õ� i���������� groups[i]���±�� 0��ʼ����ȫ��ͬ�������i > 0����ô��(i-1)���������� nums�г��ֵ�λ���ڵ� i��������ǰ�档��Ҳ����˵����Щ�������� nums�г��ֵ�˳����Ҫ�� groups ˳����ͬ��
 * <p>
 * ���������ҳ������� n �������飬���㷵��true �����򷵻�false��
 * <p>
 * ����������±�Ϊ k��Ԫ�� nums[k]���ڲ�ֹһ�������飬�ͳ���Щ�������� ���ཻ �ġ�������ָ����ԭ����������Ԫ����ɵ�һ�����С�
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
 * �����true
 * ���ͣ�����Էֱ��� nums ��ѡ���� 0 �������� [1,-1,0,1,-1,-1,3,-2,0] �͵� 1 �������� [1,-1,0,1,-1,-1,3,-2,0] ��
 * �������������ǲ��ཻ�ģ���Ϊ����û���κι�ͬ��Ԫ�ء�
 * ʾ�� 2��
 * <p>
 * ���룺groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
 * �����false
 * ���ͣ�ѡ�������� [1,2,3,4,10,-2] �� [1,2,3,4,10,-2] �ǲ���ȷ�ģ���Ϊ���ǳ��ֵ�˳���� groups ��˳��ͬ��
 * [10,-2] ��������� [1,2,3,4] ֮ǰ��
 * ʾ�� 3��
 * <p>
 * ���룺groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
 * �����false
 * ���ͣ�ѡ�������� [7,7,1,2,3,4,7,7] �� [7,7,1,2,3,4,7,7] �ǲ���ȷ�ģ���Ϊ���ǲ��ǲ��ཻ�����顣
 * ������һ����ͬ��Ԫ�� nums[4] ���±�� 0 ��ʼ����
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * groups.length == n
 * 1 <= n <= 103
 * 1 <= groups[i].length, sum(groups[i].length) <= 103
 * 1 <= nums.length <= 103
 * -107 <= groups[i][j], nums[k] <= 107
 * ͨ������2,002�ύ����4,213
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/form-array-by-concatenating-subarrays-of-another-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanChoose {

    public boolean canChoose(int[][] groups, int[] nums) {
        int i = 0;
        int j = 0;
        while (i < nums.length && j < groups.length) {
            int k = 0;
            while (i + k < nums.length
                    && k < groups[j].length
                    && nums[i + k] == groups[j][k]) {
                k++;
            }
            if (k == groups[j].length) {
                j++;
                i += k;
            } else {
                i++;
            }
        }
        return j == groups.length;
    }

    private int kmp(int[] arr, int[] arr2, int s) {
        int[] next = new int[arr.length];
        next[0] = -1;
        int i = 0;
        int j = 1;
        while (j < arr.length - 1) {
            if (i == -1 || arr[i] == arr[j]) {
                next[++j] = ++i;
            } else {
                i = next[i];
            }
        }
        i = 0;
        j = s;
        while (i < arr.length && j < arr2.length) {
            if (i == -1 || arr[i] == arr2[j]) {
                i++;
                j++;
            } else {
                i = next[i];
            }
        }
        return i >= arr.length ? j : -1;
    }

    public boolean canChoose2(int[][] groups, int[] nums) {
        int n = groups.length;
        for (int i = 0, j = 0; i < n; i++) {
            j = kmp(groups[i], nums, j);
            if (j == -1) {
                return false;
            }
        }
        return true;
    }
}
