package code.code;

/**
 * С�����������ڴ������� numExchange ���վ�ƿ���Զһ�һƿ�¾ơ��㹺���� numBottles ƿ�ơ�
 * <p>
 * ����ȵ��˾�ƿ�еľƣ���ô��ƿ�ͻ��ɿյġ�
 * <p>
 * ������� ��� �ܺȵ�����ƿ�ơ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺numBottles = 9, numExchange = 3
 * �����13
 * ���ͣ�������� 3 ���վ�ƿ�һ� 1 ƿ�ơ�
 * ��������ܺȵ� 9 + 3 + 1 = 13 ƿ�ơ�
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺numBottles = 15, numExchange = 4
 * �����19
 * ���ͣ�������� 4 ���վ�ƿ�һ� 1 ƿ�ơ�
 * ��������ܺȵ� 15 + 3 + 1 = 19 ƿ�ơ�
 * ʾ�� 3��
 * <p>
 * ���룺numBottles = 5, numExchange = 5
 * �����6
 * ʾ�� 4��
 * <p>
 * ���룺numBottles = 2, numExchange = 3
 * �����2
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <=?numBottles <= 100
 * 2 <=?numExchange <= 100
 * ͨ������20,864�ύ����30,906
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/water-bottles
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumWaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int bottle = numBottles;
        int ans = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            ++ans;
            ++bottle;
        }
        return ans;
    }
}
