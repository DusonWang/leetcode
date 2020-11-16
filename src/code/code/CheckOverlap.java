package code.code;

/**
 * @author duson
 * ����һ���� (radius, x_center, y_center) ��ʾ��Բ��һ����������ƽ�еľ��� (x1, y1, x2, y2)������?(x1, y1) �Ǿ������½ǵ����꣬(x2, y2) �����Ͻǵ����ꡣ
 *
 * ���Բ�;������ص��Ĳ��֣����㷵�� True �����򷵻� False?��
 *
 * ���仰˵���������Ƿ� ���� ��?(xi, yi) ��������Բ��Ҳ�ھ����ϣ����߶����������ڱ߽��ϵ��������
 *
 * ?
 *
 * ʾ�� 1��
 *
 *
 *
 * ���룺radius = 1, x_center = 0, y_center = 0, x1 = 1, y1 = -1, x2 = 3, y2 = 1
 * �����true
 * ���ͣ�Բ�;����й����� (1,0)
 * ʾ�� 2��
 *
 *
 *
 * ���룺radius = 1, x_center = 0, y_center = 0, x1 = -1, y1 = 0, x2 = 0, y2 = 1
 * �����true
 * ʾ�� 3��
 *
 *
 *
 * ���룺radius = 1, x_center = 1, y_center = 1, x1 = -3, y1 = -3, x2 = 3, y2 = 3
 * �����true
 * ʾ�� 4��
 *
 * ���룺radius = 1, x_center = 1, y_center = 1, x1 = 1, y1 = -3, x2 = 2, y2 = -1
 * �����false
 * ?
 *
 * ��ʾ��
 *
 * 1 <= radius <= 2000
 * -10^4 <= x_center, y_center, x1, y1, x2, y2 <= 10^4
 * x1 < x2
 * y1 < y2
 * ͨ������1,596�ύ����4,518
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/circle-and-rectangle-overlapping
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CheckOverlap {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int xi_min, yi_min;
        if (x1 < x_center && x2 > x_center) {
            xi_min = 0;
        } else {
            xi_min = Math.min(Math.abs(x1 - x_center), Math.abs(x2 - x_center));
        }
        if (y1 < y_center && y2 > y_center) {
            yi_min = 0;
        } else {
            yi_min = Math.min(Math.abs(y1 - y_center), Math.abs(y2 - y_center));
        }
        return Math.pow(xi_min, 2) + Math.pow(yi_min, 2) <= Math.pow(radius, 2);
    }
}
