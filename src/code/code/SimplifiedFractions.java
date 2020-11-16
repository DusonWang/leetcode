package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����һ������?n?�����㷵������ 0 �� 1 ֮�䣨������ 0 �� 1�������ĸС�ڵ���??n?�� ���?����?������������ ����?˳�򷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺n = 2
 * �����["1/2"]
 * ���ͣ�"1/2" ��Ψһһ����ĸС�ڵ��� 2 ����������
 * ʾ�� 2��
 * <p>
 * ���룺n = 3
 * �����["1/2","1/3","2/3"]
 * ʾ�� 3��
 * <p>
 * ���룺n = 4
 * �����["1/2","1/3","1/4","2/3","3/4"]
 * ���ͣ�"2/4" ��������������Ϊ�����Ի���Ϊ "1/2" ��
 * ʾ�� 4��
 * <p>
 * ���룺n = 1
 * �����[]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 100
 * ͨ������2,089�ύ����3,513
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/simplified-fractions
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SimplifiedFractions {

    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            for (int j = i - 1; j > 0; j--) {
                if (!isMaxCommonDivisor(i, j) || j == 1) {
                    result.add(j + "/" + i);
                }
            }
        }
        return result;
    }

    private boolean isMaxCommonDivisor(int i, int j) {
        if (i < j) {
            int temp = i;
            i = j;
            j = temp;
        }
        if (j == 1) {
            return false;
        }
        if (i % j == 0) {
            return true;
        } else {
            return isMaxCommonDivisor(j, i % j);
        }
    }
}
