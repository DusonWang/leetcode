package code.code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author duson
 * ����һ���������� arr ��һ������ k ������Ҫ��������ǡ���Ƴ� k ��Ԫ�أ����ҳ��Ƴ��������в�ͬ������������Ŀ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺arr = [5,5,4], k = 1
 * �����1
 * ���ͣ��Ƴ� 1 �� 4 ��������ֻʣ�� 5 һ��������
 * ʾ�� 2��
 * <p>
 * ���룺arr = [4,3,1,1,3,3,2], k = 3
 * �����2
 * ���ͣ����Ƴ� 4��2 ��Ȼ�����Ƴ����� 1 �е����� 1 ���������� 3 �е����� 1 �������ʣ�� 1 �� 3 ����������
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= arr.length?<= 10^5
 * 1 <= arr[i] <= 10^9
 * 0 <= k?<= arr.length
 * ͨ������3,321�ύ����6,508
 * ����ʵ������������������⣿
 * <p>
 * <p>
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/least-number-of-unique-integers-after-k-removals
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class FindLeastNumOfUniqueInts {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<Integer> list = new ArrayList<>();
        int repeat = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                list.add(repeat);
                repeat = 1;
            } else {
                repeat++;
            }
        }
        list.add(repeat);
        Collections.sort(list);
        int count = list.size();
        for (int i = 0; i < list.size() && k > 0; i++) {
            if (list.get(i) > k) {
                break;
            }
            count--;
            k = k - list.get(i);
        }
        return count;
    }
}
