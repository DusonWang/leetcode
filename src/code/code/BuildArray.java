package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����һ��Ŀ������ target ��һ������ n��ÿ�ε�������Ҫ��? list = {1,2,3..., n} �������ȡһ�����֡�
 * <p>
 * ��ʹ����������������Ŀ������ target ��
 * <p>
 * Push���� list �ж�ȡһ����Ԫ�أ� ���������������С�
 * Pop��ɾ�������е����һ��Ԫ�ء�
 * ���Ŀ�����鹹����ɣ���ֹͣ��ȡ����Ԫ�ء�
 * ��Ŀ���ݱ�֤Ŀ�������ϸ����������ֻ���� 1 �� n ֮������֡�
 * <p>
 * �뷵�ع���Ŀ���������õĲ������С�
 * <p>
 * ��Ŀ���ݱ�֤����Ψһ�ġ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺target = [1,3], n = 3
 * �����["Push","Push","Pop","Push"]
 * ���ͣ�
 * ��ȡ 1 ���Զ��������� -> [1]
 * ��ȡ 2 ���Զ��������飬Ȼ��ɾ���� -> [1]
 * ��ȡ 3 ���Զ��������� -> [1,3]
 * ʾ�� 2��
 * <p>
 * ���룺target = [1,2,3], n = 3
 * �����["Push","Push","Push"]
 * ʾ�� 3��
 * <p>
 * ���룺target = [1,2], n = 4
 * �����["Push","Push"]
 * ���ͣ�ֻ��Ҫ��ȡǰ 2 �����־Ϳ���ֹͣ��
 * ʾ�� 4��
 * <p>
 * ���룺target = [2,3,4], n = 4
 * �����["Push","Pop","Push","Push","Push"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= target.length <= 100
 * 1 <= target[i]?<= 100
 * 1 <= n <= 100
 * target ���ϸ������
 * ͨ������4,224�ύ����6,557
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/build-an-array-with-stack-operations
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class BuildArray {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int j = 1;
        for (int value : target) {
            while (value > j) {
                result.add("Push");
                result.add("Pop");
                j++;
            }
            result.add("Push");
            j++;
        }
        return result;
    }
}
