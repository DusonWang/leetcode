package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * @author duson
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * <p>
 * ?
 * <p>
 * ʾ�� 1:
 * <p>
 * ����: [10,2]
 * ���: "102"
 * ʾ��?2:
 * <p>
 * ����: [3,30,34,5,9]
 * ���: "3033459"
 * ?
 * <p>
 * ��ʾ:
 * <p>
 * 0 < nums.length <= 100
 * ˵��:
 * <p>
 * ���������ܷǳ�����������Ҫ����һ���ַ�������������
 * ƴ�����������ֿ��ܻ���ǰ�� 0�����������Ҫȥ��ǰ�� 0
 * ͨ������11,200�ύ����20,110
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class MinNumber {

    public String minNumber(int[] nums) {
        List<String> strList = new ArrayList<>();
        for (int num : nums) {
            strList.add(String.valueOf(num));
        }
        strList.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuilder sb = new StringBuilder();
        for (String str : strList) {
            sb.append(str);
        }
        return sb.toString();
    }
}
