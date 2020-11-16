package code.code;

import java.util.Arrays;

/**
 * @author duson
 * ���˿����������5���ƣ��ж��ǲ���һ��˳�ӣ�����5�����ǲ��������ġ�2��10Ϊ���ֱ���AΪ1��JΪ11��QΪ12��KΪ13������С��Ϊ 0 �����Կ����������֡�A ������Ϊ 14��
 * <p>
 * ?
 * <p>
 * ʾ��?1:
 * <p>
 * ����: [1,2,3,4,5]
 * ���: True
 * ?
 * <p>
 * ʾ��?2:
 * <p>
 * ����: [0,0,1,2,5]
 * ���: True
 * ?
 * <p>
 * ���ƣ�
 * <p>
 * ���鳤��Ϊ 5?
 * <p>
 * �������ȡֵΪ [0, 13] .
 * <p>
 * ͨ������10,652�ύ����24,749
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsStraight {

    public boolean isStraight(int[] nums) {
        int joker = 0;
        Arrays.sort(nums);
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }
}
