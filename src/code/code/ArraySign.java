package code.code;

/**
 * ��֪����?signFunc(x) ������� x �����������ض�ֵ��
 * <p>
 * ��� x ������������ 1 ��
 * ��� x �Ǹ��������� -1 ��
 * ��� x �ǵ��� 0 ������ 0 ��
 * ����һ���������� nums ���� product Ϊ���� nums ������Ԫ��ֵ�ĳ˻���
 * <p>
 * ���� signFunc(product) ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺nums = [-1,-2,-3,-4,3,2,1]
 * �����1
 * ���ͣ�����������ֵ�ĳ˻��� 144 ���� signFunc(144) = 1
 * ʾ�� 2��
 * <p>
 * ���룺nums = [1,5,0,2,-3]
 * �����0
 * ���ͣ�����������ֵ�ĳ˻��� 0 ���� signFunc(0) = 0
 * ʾ�� 3��
 * <p>
 * ���룺nums = [-1,1,-1,1,-1]
 * �����-1
 * ���ͣ�����������ֵ�ĳ˻��� -1 ���� signFunc(-1) = -1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= nums.length <= 1000
 * -100 <= nums[i] <= 100
 * ͨ������10,867�ύ����10,012
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sign-of-the-product-of-an-array
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ArraySign {

    public int arraySign(int[] nums) {
        int neg = 0;
        for (int num : nums) {
            if (num < 0) {
                neg ^= 1;
            } else if (num == 0) {
                return 0;
            }
        }
        return neg == 0 ? 1 : -1;
    }
}
