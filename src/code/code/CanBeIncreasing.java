package code.code;

/**
 * ����һ���±�� 0��ʼ����������nums�����ǡ��ɾ��һ��Ԫ�غ������ϸ��������ô���㷵��true�����򷵻�false��������鱾���Ѿ����ϸ�����ģ�����Ҳ����true��
 * <p>
 * ����nums�� �ϸ�����Ķ���Ϊ�����������±��1 <= i < nums.length������nums[i - 1] < nums[i]��
 * <p>
 * <p>
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [1,2,10,5,7]
 * �����true
 * ���ͣ��� nums ��ɾ���±� 2 ���� 10 ���õ� [1,2,5,7] ��
 * [1,2,5,7] ���ϸ�����ģ����Է��� true ��
 * ʾ�� 2��
 * <p>
 * ���룺nums = [2,3,1,2]
 * �����false
 * ���ͣ�
 * [3,1,2] ��ɾ���±� 0 ��Ԫ�غ�õ��Ľ����
 * [2,1,2] ��ɾ���±� 1 ��Ԫ�غ�õ��Ľ����
 * [2,3,2] ��ɾ���±� 2 ��Ԫ�غ�õ��Ľ����
 * [2,3,1] ��ɾ���±� 3 ��Ԫ�غ�õ��Ľ����
 * û���κν���������ϸ�����ģ����Է��� false ��
 * ʾ�� 3��
 * <p>
 * ���룺nums = [1,1,1]
 * �����false
 * ���ͣ�ɾ������Ԫ�غ�Ľ������ [1,1] ��
 * [1,1] �����ϸ�����ģ����Է��� false ��
 * ʾ�� 4��
 * <p>
 * ���룺nums = [1,2,3]
 * �����true
 * ���ͣ�[1,2,3] �Ѿ����ϸ�����ģ����Է��� true ��
 * <p>
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * ͨ������3,412�ύ����10,204
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/remove-one-element-to-make-the-array-strictly-increasing
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CanBeIncreasing {

    public boolean canBeIncreasing(int[] nums) {
        int mismatch = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1]) {
                if (i > 0) {
                    if (nums[i + 1] > nums[i - 1]) {
                        //
                    } else {
                        nums[i + 1] = nums[i];
                    }
                }
                mismatch++;
            }
        }
        return mismatch <= 1;
    }

    public static void main(String[] args) {
        CanBeIncreasing canBeIncreasing = new CanBeIncreasing();
        System.out.println(canBeIncreasing.canBeIncreasing(new int[]{1, 2, 10, 5, 7}));
        System.out.println(canBeIncreasing.canBeIncreasing(new int[]{2, 3, 1, 2}));
    }
}
