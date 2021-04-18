package code.code;

import java.util.HashSet;

/**
 * ����һ���ַ��� path������ path[i] ��ֵ������ 'N'��'S'��'E' ���� 'W'���ֱ��ʾ�򱱡����ϡ��򶫡������ƶ�һ����λ��
 * <p>
 * �����˴Ӷ�άƽ���ϵ�ԭ�� (0, 0) ����ʼ�������� path ��ָʾ��·�����ߡ�
 * <p>
 * ���·�����κ�λ���ϳ����ཻ�������Ҳ�����ߵ�֮ǰ�Ѿ��߹���λ�ã��뷵�� True �����򣬷��� False ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * <p>
 * <p>
 * ���룺path = "NES"
 * �����false
 * ���ͣ���·��û�����κ�λ���ཻ��
 * ʾ�� 2��
 * <p>
 * <p>
 * <p>
 * ���룺path = "NESWW"
 * �����true
 * ���ͣ���·������ԭ�����Ρ�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= path.length <= 10^4
 * path ���� {'N', 'S', 'E', 'W} �е��ַ����
 * ͨ������8,970�ύ����16,511
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/path-crossing
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsPathCrossing {

    public boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String first = x + "," + y;
        set.add(first);
        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y += 1;
            } else if (c == 'S') {
                y -= 1;
            } else if (c == 'E') {
                x += 1;
            } else if (c == 'W') {
                x -= 1;
            }
            String temp = x + "," + y;
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
        }
        return false;
    }
}
