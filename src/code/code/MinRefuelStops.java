package code.code;

/**
 * @author duson
 * ������������ʻ��Ŀ�ĵأ���Ŀ�ĵ�λ�ڳ���λ�ö��� target?Ӣ�ﴦ��
 * <p>
 * ��;�м���վ��ÿ��?station[i]?����һ������վ����λ�ڳ���λ�ö���?station[i][0]?Ӣ�ﴦ��������?station[i][1]?�����͡�
 * <p>
 * ����������������������޵ģ����������?startFuel?��ȼ�ϡ���ÿ��ʻ 1 Ӣ��ͻ��õ� 1 �����͡�
 * <p>
 * �������������վʱ��������ͣ�������ͣ����������ʹӼ���վת�Ƶ������С�
 * <p>
 * Ϊ�˵���Ŀ�ĵأ���������Ҫ����ͼ��ʹ����Ƕ��٣�����޷�����Ŀ�ĵأ��򷵻� -1 ��
 * <p>
 * ע�⣺��������������վʱʣ��ȼ��Ϊ 0������Ȼ������������͡������������Ŀ�ĵ�ʱʣ��ȼ��Ϊ 0����Ȼ��Ϊ���Ѿ�����Ŀ�ĵء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = 1, startFuel = 1, stations = []
 * �����0
 * ���ͣ����ǿ����ڲ����͵�����µ���Ŀ�ĵء�
 * ʾ�� 2��
 * <p>
 * ���룺target = 100, startFuel = 1, stations = [[10,100]]
 * �����-1
 * ���ͣ������޷��ִ�Ŀ�ĵأ������޷������һ������վ��
 * ʾ�� 3��
 * <p>
 * ���룺target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * �����2
 * ���ͣ�
 * ���ǳ���ʱ�� 10 ��ȼ�ϡ�
 * ���ǿ������������ 10 Ӣ�ﴦ�ļ���վ������ 10 ��ȼ�ϡ������ʹ� 0 ���ӵ� 60 ����
 * Ȼ�����Ǵ� 10 Ӣ�ﴦ�ļ���վ���� 60 Ӣ�ﴦ�ļ���վ������ 50 ��ȼ�ϣ���
 * �������ʹ� 10 ���ӵ� 50 ����Ȼ�����ǿ����ִ�Ŀ�ĵء�
 * ������;��1��������վͣ�������Է��� 2 ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 * ͨ������3,700�ύ����12,211
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimum-number-of-refueling-stops
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinRefuelStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int alreadyGo = 0;
        alreadyGo += startFuel;
        int res = 0;
        boolean[] isStationUsed = new boolean[stations.length];
        while (alreadyGo < target) {
            int maxPos = 0;
            int maxFuel = -1;
            boolean isAddFuel = false;
            for (int i = 0; i < stations.length && stations[i][0] <= alreadyGo; i++) {
                if (!isStationUsed[i] && stations[i][1] > maxFuel) {
                    maxFuel = stations[i][1];
                    maxPos = i;
                    isAddFuel = true;
                }
            }
            if (!isAddFuel) {
                return -1;
            }
            isStationUsed[maxPos] = true;
            alreadyGo += stations[maxPos][1];
            res++;
        }
        return res;
    }
}
