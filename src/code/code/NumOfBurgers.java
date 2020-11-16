package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ʥ���Ԥ�ȿ�ʼ�����������Ƴ���ȫ�µĺ����ײ͡�Ϊ�˱����˷�ԭ�ϣ�����������ƶ����ʵ������ƻ���
 * <p>
 * ������������?tomatoSlices?��?cheeseSlices���ֱ��ʾ����Ƭ������Ƭ����Ŀ����ͬ������ԭ�ϴ������£�
 * <p>
 * ���ްԺ�����4 Ƭ���Ѻ� 1 Ƭ����
 * С�ʱ���2 Ƭ���Ѻ�?1 Ƭ����
 * ������?[total_jumbo, total_small]��[���ްԺ���������С�ʱ�����]���ĸ�ʽ����ǡ��������������ʹ��ʣ�µķ���Ƭ?tomatoSlices?������Ƭ?cheeseSlices?����������?0��
 * <p>
 * ����޷�ʹʣ�µķ���Ƭ?tomatoSlices?������Ƭ?cheeseSlices?������Ϊ?0�����뷵��?[]��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺tomatoSlices = 16, cheeseSlices = 7
 * �����[1,6]
 * ���ͣ����� 1 �����ްԺ����� 6 ��С�ʱ���Ҫ 4*1 + 2*6 = 16 Ƭ���Ѻ� 1 + 6 = 7 Ƭ���ҡ�����ʣ��ԭ�ϡ�
 * ʾ�� 2��
 * <p>
 * ���룺tomatoSlices = 17, cheeseSlices = 4
 * �����[]
 * ���ͣ�ֻ����С�ʱ��;��ްԺ����޷��ù�ȫ��ԭ�ϡ�
 * ʾ�� 3��
 * <p>
 * ���룺tomatoSlices = 4, cheeseSlices = 17
 * �����[]
 * ���ͣ����� 1 �����ްԺ�����ʣ�� 16 Ƭ���ң����� 2 ��С�ʱ���ʣ�� 15 Ƭ���ҡ�
 * ʾ�� 4��
 * <p>
 * ���룺tomatoSlices = 0, cheeseSlices = 0
 * �����[0,0]
 * ʾ�� 5��
 * <p>
 * ���룺tomatoSlices = 2, cheeseSlices = 1
 * �����[0,1]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= tomatoSlices <= 10^7
 * 0 <= cheeseSlices <= 10^7
 * ͨ������3,396�ύ����6,894
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-burgers-with-no-waste-of-ingredients
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumOfBurgers {

    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> result = new ArrayList<>();
        if (tomatoSlices % 2 == 1 || tomatoSlices < cheeseSlices * 2 || tomatoSlices > cheeseSlices * 4) {
            return result;
        }
        int totalJumboTomato = cheeseSlices * 4;
        int smallBurger = (totalJumboTomato - tomatoSlices) / 2;
        result.add(cheeseSlices - smallBurger);
        result.add(smallBurger);
        return result;
    }
}
