package code.code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * ��Ĺ��������������������к���һ��ʼ���ǿյġ����� n?�����������ʱ������� n?�������ǿյģ���ô���ͻ�װ��ˮ��������������ᷢ����ˮ�����Ŀ���Ǳ�������һ������������ˮ��
 * <p>
 * ����һ����������?rains?�����У�
 * <p>
 * rains[i] > 0?��ʾ�� i?��ʱ���� rains[i]?�����������ꡣ
 * rains[i] == 0?��ʾ�� i?��û�к��������꣬�����ѡ�� һ��?������ ���?���������ˮ��
 * �뷵��һ������?ans?�����㣺
 * <p>
 * ans.length == rains.length
 * ���?rains[i] > 0 ����ôans[i] == -1?��
 * ���?rains[i] == 0?��ans[i]?�����?i?��ѡ���ɵĺ�����
 * ����ж��ֿ��н⣬�뷵�������е� ����һ��?�����û�취��ֹ��ˮ���뷵��һ�� �յ�����?��
 * <p>
 * ��ע�⣬�����ѡ����һ��װ��ˮ�ĺ�����������һ���յĺ������������ѡ����һ���յĺ�������ô�����·����������뿴ʾ�� 4����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺rains = [1,2,3,4]
 * �����[-1,-1,-1,-1]
 * ���ͣ���һ���װ��ˮ�ĺ������� [1]
 * �ڶ����װ��ˮ�ĺ������� [1,2]
 * �������װ��ˮ�ĺ������� [1,2,3]
 * �������װ��ˮ�ĺ������� [1,2,3,4]
 * û����һ������Գ���κκ�����ˮ��Ҳû�к����ᷢ����ˮ��
 * ʾ�� 2��
 * <p>
 * ���룺rains = [1,2,0,0,2,1]
 * �����[-1,-1,2,1,-1,-1]
 * ���ͣ���һ���װ��ˮ�ĺ������� [1]
 * �ڶ����װ��ˮ�ĺ������� [1,2]
 * ����������ǳ�ɺ��� 2 ������ʣ��װ��ˮ�ĺ������� [1]
 * ����������ǳ�ɺ��� 1 ��������ʱû��װ��ˮ�ĺ����ˡ�
 * �������װ��ˮ�ĺ������� [2]��
 * �������װ��ˮ�ĺ������� [1,2]��
 * ���Կ�������������²����к�ˮ������ͬʱ�� [-1,-1,1,2,-1,-1] Ҳ����һ�����е�û�к�ˮ�ķ�����
 * ʾ�� 3��
 * <p>
 * ���룺rains = [1,2,0,1,2]
 * �����[]
 * ���ͣ��ڶ����װ��ˮ�ĺ������� [1,2]�����ǿ����ڵ�������һ��������ˮ��
 * ��������󣬺��� 1 �� 2 �����ٴ����꣬���Բ������ǵ��������ĸ�������ˮ����һ���������ᷢ����ˮ��
 * ʾ�� 4��
 * <p>
 * ���룺rains = [69,0,0,0,69]
 * �����[-1,69,1,1,-1]
 * ���ͣ��κ����� [-1,69,x,y,-1], [-1,x,69,y,-1] ���� [-1,x,y,69,-1] ���ǿ��еĽ⣬���� 1 <= x,y <= 10^9
 * ʾ�� 5��
 * <p>
 * ���룺rains = [10,20,20]
 * �����[]
 * ���ͣ����ں��� 20 �������� 2 ����꣬����û��û�а취��ֹ��ˮ��
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= rains.length <= 10^5
 * 0 <= rains[i] <= 10^9
 * ͨ������5,483�ύ����24,795
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/avoid-flood-in-the-city
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class AvoidFlood {

    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> drain = new TreeSet<>();
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        for (int i = 0; i < rains.length; i++) {
            int lake = rains[i];
            if (full.containsKey(lake)) {
                Integer key = drain.ceiling(full.get(lake));
                if (key == null) {
                    return new int[]{};
                }
                res[key] = lake;
                drain.remove(key);
            }
            if (lake == 0) {
                drain.add(i);
            } else {
                full.put(lake, i);
                res[i] = -1;
            }
        }
        return res;
    }

//    public int[] avoidFlood2(int[] rains) {
//        int[] ans = new int[rains.length];
//        int[] noRains = new int[rains.length];
//        int noRainsDays = 0;
//        for (int i = 0; i < rains.length; i++) {
//            if (rains[i] == 0) {
//                noRains[noRainsDays++] = i;
//            }
//        }
//        // ����Ϊkey , ����Ϊvalue
//        Map<Integer, Integer> map = new HashMap<>(rains.length);
//        // ��ǰ�����ϴ����굽�������֮���Ƿ���ڲ�������û��йˮ������������,������洢������noRains�����ж�Ӧ���±�
//        int indexNoRainsArr = -1;
//        int minIndex = 0;
//        for (int i = 0; i < rains.length; i++) {
//            if (rains[i] == 0) {
//                continue;
//            }
//            ans[i] = -1;
//            if (map.containsKey(rains[i])) {
//                int oldRainDay = map.get(rains[i]);
//                for (int j = minIndex; j < noRainsDays; j++) {
//                    if (oldRainDay < noRains[j] && i > noRains[j]) {
//                        indexNoRainsArr = j;
//                        break;
//                    }
//                }
//                if (indexNoRainsArr >= minIndex) {
//                    // ��û��������������Ӧ�ĵ�ˮ����
//                    ans[noRains[indexNoRainsArr]] = rains[i];
//                    // ����ǰû���������ʶ�ɵ�ˮ��
//                    noRains[indexNoRainsArr] = -1;
//                    // �����±�
//                    if (indexNoRainsArr == minIndex) {
//                        minIndex++;
//                    }
//                    indexNoRainsArr = -1;
//                } else {
//                    return new int[0];
//                }
//            }
//            // ����ú���û���¹��꣬��������������¸ú����������ʱ��
//            map.put(rains[i], i);
//        }
//        for (int i = 0; i < noRainsDays; i++) {
//            if (noRains[i] != -1) {
//                ans[noRains[i]] = 1;
//            }
//        }
//        return ans;
//    }
}
