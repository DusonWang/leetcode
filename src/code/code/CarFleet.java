package code.code;

import java.util.Arrays;

/**
 * N ?��������һ������ʻ��λ��?target?Ӣ��֮��Ĺ�ͬĿ�ĵء�
 * <p>
 * ÿ����?i?�Ժ㶨���ٶ�?speed[i]?��Ӣ��/Сʱ�����ӳ�ʼλ��?position[i]?��Ӣ� �س���ʻ��Ŀ�ĵء�
 * <p>
 * һ������Զ���ᳬ��ǰ�����һ��������������׷��ȥ������ǰ������ͬ���ٶȽ�������ʻ��
 * <p>
 * ��ʱ�����ǻ������������֮��ľ��룬Ҳ����˵�����Ǳ��ٶ�������ͬ��λ�á�
 * <p>
 * ����?��һЩ����ʻ����ͬλ�á�������ͬ�ٶȵĳ���ɵķǿռ��ϡ�ע�⣬һ����Ҳ������һ�����ӡ�
 * <p>
 * ����һ������Ŀ�ĵزŸ�����һ�����ӣ�������Ȼ�ᱻ������ͬһ�����ӡ�
 * <p>
 * ?
 * <p>
 * ���ж��ٳ��ӵ���Ŀ�ĵ�?
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
 * �����3
 * ���ͣ�
 * �� 10 �� 8 ��ʼ�ĳ������һ�����ӣ������� 12 ��������
 * �� 0 ����ʼ�ĳ��޷�׷�����������������Լ�����һ�����ӡ�
 * �� 5 �� 3 ��ʼ�ĳ������һ�����ӣ������� 6 ��������
 * ��ע�⣬�ڵ���Ŀ�ĵ�֮ǰû����������������Щ���ӣ����Դ��� 3��
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= N <= 10 ^ 4
 * 0 < target?<= 10 ^ 6
 * 0 <?speed[i] <= 10 ^ 6
 * 0 <= position[i] < target
 * ���г��ĳ�ʼλ�ø�����ͬ��
 * ͨ������8,400�ύ����22,447
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/car-fleet
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        if (position == null || position.length == 0) {
            return 0;
        }
        int[] temp = new int[target];
        for (int i = 0; i < position.length; i++) {
            temp[position[i]] = speed[i];
        }
        double[] time = new double[position.length];
        Arrays.sort(position);
        for (int i = 0; i < time.length; i++) {
            int n = position.length - 1 - i;
            time[i] = (target - position[n]) / (1.0 * temp[position[n]]);
        }

        int ans = 1;
        for (int i = 0; i < time.length - 1; i++) {
            if (time[i] >= time[i + 1]) {
                time[i + 1] = time[i];
            } else {
                ans++;
            }
        }
        return ans;
    }
}
