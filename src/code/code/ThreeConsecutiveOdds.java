package code.code;

/**
 * ����һ���������� arr�������ж��������Ƿ������������Ԫ�ض��������������������ڣ��뷵�� true �����򣬷��� false ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [2,6,4,1]
 * �����false
 * ���ͣ���������������Ԫ�ض��������������
 * ʾ�� 2��
 * <p>
 * ���룺arr = [1,2,34,3,4,5,7,23,12]
 * �����true
 * ���ͣ�������������Ԫ�ض���������������� [5,7,23] ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length <= 1000
 * 1 <= arr[i] <= 1000
 * ͨ������18,507�ύ����28,099
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/three-consecutive-odds
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ThreeConsecutiveOdds {

    public boolean threeConsecutiveOdds(int[] arr) {
        int cnt = 0;
        for (int a : arr) {
            if (a % 2 == 1) {
                cnt++;
                if (cnt == 3) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }

}
