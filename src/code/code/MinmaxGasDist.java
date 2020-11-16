package code.code;

/**
 * @author duson
 * ����������һ��ˮƽ�����ϣ��б� stations?����ʾ��������վ��λ�ã�����վ�ֱ���?stations[0], stations[1], ..., stations[N-1]?��λ���ϣ����� N = stations.length��
 * <p>
 * ��������ϣ������ K ���µļ���վ��ʹ��������������վ�ľ��� D �����ܵ���С�����㷵��?D ���ܵ���Сֵ��
 * <p>
 * ʾ����
 * <p>
 * ���룺stations = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10], K = 9
 * �����0.500000
 * ע��
 * <p>
 * stations.length?���ڷ�Χ?[10, 2000]?�ڵ�����
 * stations[i] ���ڷ�Χ?[0, 10^8]?�ڵ�����
 * K ���ڷ�Χ?[1, 10^6]?�ڵ�����
 * ��?10^-6?���ڵ���ȷֵ�ᱻ��Ϊ��ȷ�Ĵ�
 * ͨ������412�ύ����738
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/minimize-max-distance-to-gas-station
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinmaxGasDist {

    public double minmaxGasDist(int[] stations, int k) {
        double lo = 0, hi = 1e8;
        while (hi - lo > 1e-6) {
            double mi = (lo + hi) / 2.0;
            if (possible(mi, stations, k)) {
                hi = mi;
            } else {
                lo = mi;
            }
        }
        return lo;
    }

    private boolean possible(double d, int[] stations, int k) {
        int used = 0;
        for (int i = 0; i < stations.length - 1; ++i) {
            used += (int) ((stations[i + 1] - stations[i]) / d);
        }
        return used <= k;
    }
}
