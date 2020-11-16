package code.code;

/**
 * ����һ���ַ��� croakOfFrogs������ʾ��ͬ���ܷ��������������ַ��� "croak" ������ϡ�����ͬһʱ������ж�ֻ�����������죬����?croakOfFrogs �л��϶�� ��croak�� �����㷵��ģ���ַ����������������費ͬ���ܵ�������Ŀ��
 * <p>
 * ע�⣺Ҫ�뷢������ "croak"�����ܱ��� ���� ��� ��c��, ��r��, ��o��, ��a��, ��k�� �� 5 ����ĸ�����û�����ȫ�������ĸ����ô���Ͳ��ᷢ��������
 * <p>
 * ����ַ��� croakOfFrogs ������������Ч�� "croak" �ַ���϶��ɣ��뷵�� -1 ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺croakOfFrogs = "croakcroak"
 * �����1
 * ���ͣ�һֻ���� �����ɡ� ����
 * ʾ�� 2��
 * <p>
 * ���룺croakOfFrogs = "crcoakroak"
 * �����2
 * ���ͣ�������Ҫ��ֻ���ܣ������ɡ� ���ú����ע
 * ��һֻ���� "crcoakroak"
 * �ڶ�ֻ���� "crcoakroak"
 * ʾ�� 3��
 * <p>
 * ���룺croakOfFrogs = "croakcrook"
 * �����-1
 * ���ͣ��������ַ������� "croak" ����Ч��ϡ�
 * ʾ�� 4��
 * <p>
 * ���룺croakOfFrogs = "croakcroa"
 * �����-1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <=?croakOfFrogs.length <= 10^5
 * �ַ����е��ַ�ֻ�� 'c', 'r', 'o', 'a' ���� 'k'
 * ͨ������3,914�ύ����10,582
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-frogs-croaking
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinNumberOfFrogs {

    public int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        char[] chars = croakOfFrogs.toCharArray();
        int res = 0;
        for (char aChar : chars) {
            if (aChar == 'c') {
                if (k > 0) {
                    k--;
                } else {
                    res++;
                }
                c++;
            } else if (aChar == 'r') {
                c--;
                r++;
            } else if (aChar == 'o') {
                r--;
                o++;
            } else if (aChar == 'a') {
                o--;
                a++;
            } else if (aChar == 'k') {
                a--;
                k++;
            }
            if (c < 0 || r < 0 || o < 0 || a < 0) {
                break;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return res;
    }
}
