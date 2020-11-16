package code.code;

/**
 * @author duson
 * ���ſ��� �ų�һ�У�ÿ�ſ��ƶ���һ����Ӧ�ĵ������������������� cardPoints ������
 * <p>
 * ÿ���ж�������Դ��еĿ�ͷ����ĩβ��һ�ſ��ƣ���������������� k �ſ��ơ�
 * <p>
 * ��ĵ����������õ����е����п��Ƶĵ���֮�͡�
 * <p>
 * ����һ���������� cardPoints ������ k�����㷵�ؿ��Ի�õ���������
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺cardPoints = [1,2,3,4,5,6,1], k = 3
 * �����12
 * ���ͣ���һ���ж��������������ƣ���ĵ������� 1 �����ǣ��������ұߵĿ��ƽ��������Ŀɻ�õ��������Ų��������ұߵ������ƣ����յ���Ϊ 1 + 6 + 5 = 12 ��
 * ʾ�� 2��
 * <p>
 * ���룺cardPoints = [2,2,2], k = 2
 * �����4
 * ���ͣ����������������ſ��ƣ��ɻ�õĵ������� 4 ��
 * ʾ�� 3��
 * <p>
 * ���룺cardPoints = [9,7,7,9,7,7,9], k = 7
 * �����55
 * ���ͣ�������������п��ƣ����Ի�õĵ���Ϊ���п��Ƶĵ���֮�͡�
 * ʾ�� 4��
 * <p>
 * ���룺cardPoints = [1,1000,1], k = 1
 * �����1
 * ���ͣ����޷��õ��м����ſ��ƣ����Կ��Ի�õ�������Ϊ 1 ��
 * ʾ�� 5��
 * <p>
 * ���룺cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * �����202
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * ͨ������3,195�ύ����8,167
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/maximum-points-you-can-obtain-from-cards
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MaxScore2 {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length, scoreR = 0, scoreL = 0;
        for(int i = 0; i < k; i++) {
            scoreL += cardPoints[i];
        }
        int res = scoreL;
        for(int l = 1; l <= k; l++){
            scoreL -= cardPoints[k - l];
            scoreR += cardPoints[n - l];
            res = Math.max(res, scoreR + scoreL);
        }
        return res;
    }
}
