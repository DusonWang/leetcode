package com.leetcode.offer.code;

/**
 * @author duson
 * ��Խ�������д���򣬽���ĳ������������λ��ż��λ������ʹ�ý��ٵ�ָ�Ҳ����˵��λ0��λ1������λ2��λ3�������Դ����ƣ���
 * <p>
 * ʾ��1:
 * <p>
 * ���룺num = 2������0b10��
 * ��� 1 (���� 0b01)
 * ʾ��2:
 * <p>
 * ���룺num = 3
 * �����3
 * ��ʾ:
 * <p>
 * num�ķ�Χ��[0, 2^30 - 1]֮�䣬���ᷢ�����������
 * ͨ������2,073�ύ����3,059
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/exchange-lcci
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ExchangeBits {

    public int exchangeBits(int num) {
        int odd = num & 0x55555555;
        int even = num & 0xaaaaaaaa;
        odd = odd << 1;
        even = even >>> 1;
        return odd | even;
    }
}
