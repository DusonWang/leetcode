package code.code;

import java.util.Arrays;
import java.util.Comparator;

/**
 * һ�� ����?ָ����һ�����еĵ����õ����ո������������ҿ�ͷ�ͽ�βû���κοո�ÿ�����ʶ�ֻ����Сд���дӢ����ĸ��
 * <p>
 * ���ǿ��Ը�һ��������� �� 1 ��ʼ�ĵ���λ������ �����ҽ����������е���?����˳��?��
 * <p>
 * �ȷ�˵������?"This is a sentence"?���Ա�����˳��õ�?"sentence4 a3 is2 This1"?����?"is2 sentence4 This1 a3"?��
 * ����һ�� ����˳��?�ľ���?s?���������ĵ��ʲ�����?9?�����������¹��첢�õ�ԭ��˳��ľ��ӡ�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺s = "is2 sentence4 This1 a3"
 * �����"This is a sentence"
 * ���ͣ��� s �еĵ��ʰ��ճ�ʼλ�����򣬵õ� "This1 is2 a3 sentence4" ��Ȼ��ɾ�����֡�
 * ʾ�� 2��
 * <p>
 * ���룺s = "Myself2 Me1 I4 and3"
 * �����"Me Myself and I"
 * ���ͣ��� s �еĵ��ʰ��ճ�ʼλ�����򣬵õ� "Me1 Myself2 and3 I4" ��Ȼ��ɾ�����֡�
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 2 <= s.length <= 200
 * s?ֻ����Сд�ʹ�дӢ����ĸ���ո��Լ���?1?��?9?�����֡�
 * s?�е�����ĿΪ?1?��?9?����
 * s?�еĵ����ɵ����ո�ָ���
 * s?�������κ�ǰ�����ߺ�׺�ո�
 * ͨ������2,348�ύ����2,914
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/sorting-the-sentence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class SortSentence {

    public String sortSentence(String s) {
        String[] a = s.split(" ");
        Arrays.sort(a, Comparator.comparingInt(o -> o.charAt(o.length() - 1)));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i], 0, a[i].length() - 1);
            if (i < a.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
