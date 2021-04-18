package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ���ַ��� text �����ַ��������ɱ��ո��Χ�ĵ�����ɡ�ÿ��������һ�����߶��СдӢ����ĸ��ɣ�������������֮�����ٴ���һ���ո���Ŀ����������֤ text ���ٰ���һ������ ��
 * <p>
 * �����������пո�ʹÿ�����ڵ���֮��Ŀո���Ŀ�� ��� ���������� ��� ����Ŀ�������������ƽ���������пո��� ������Ŀո�������ַ���ĩβ ����Ҳ��ζ�ŷ��ص��ַ���Ӧ����ԭ text �ַ����ĳ�����ȡ�
 * <p>
 * ���� �������пո����ַ��� ��
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺text = "  this   is  a sentence "
 * �����"this   is   a   sentence"
 * ���ͣ��ܹ��� 9 ���ո�� 4 �����ʡ����Խ� 9 ���ո�ƽ�����䵽���ڵ���֮�䣬���ڵ��ʼ�ո���Ϊ��9 / (4-1) = 3 ����
 * ʾ�� 2��
 * <p>
 * ���룺text = " practice   makes   perfect"
 * �����"practice   makes   perfect "
 * ���ͣ��ܹ��� 7 ���ո�� 3 �����ʡ�7 / (3-1) = 3 ���ո���� 1 ������Ŀո񡣶���Ŀո���Ҫ�����ַ�����ĩβ��
 * ʾ�� 3��
 * <p>
 * ���룺text = "hello   world"
 * �����"hello   world"
 * ʾ�� 4��
 * <p>
 * ���룺text = "  walks  udp package   into  bar a"
 * �����"walks  udp  package  into  bar  a "
 * ʾ�� 5��
 * <p>
 * ���룺text = "a"
 * �����"a"
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= text.length <= 100
 * text ��СдӢ����ĸ�� ' ' ���
 * text �����ٰ���һ������
 * ͨ������6,365�ύ����14,302
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/rearrange-spaces-between-words
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ReorderSpaces {

    public List<String> words = new ArrayList<>();

    public String reorderSpaces(String text) {
        int totalSpaces = getTotalSpaces(text);
        int totalWords = words.size();
        int spaceBetweenEach = totalWords == 1 ? 0 : totalSpaces / (totalWords - 1);
        int spaceAtEnd = totalWords == 1 ? totalSpaces : totalSpaces % (totalWords - 1);
        String spaceString = getSpace(spaceBetweenEach);
        String endSpaceString = getSpace(spaceAtEnd);
        StringBuilder sb = new StringBuilder();
        for (int i = 0, wordsSize = words.size(); i < wordsSize; i++) {
            String word = words.get(i);
            sb.append(word);
            if (i != wordsSize - 1) {
                sb.append(spaceString);
            }
        }
        sb.append(endSpaceString);
        return sb.toString();
    }

    private String getSpace(int spaceCount) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < spaceCount; i++) {
            result.append(" ");
        }
        return result.toString();
    }

    private int getTotalSpaces(String text) {
        int totalSpaces = 0;
        boolean isWord = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                isWord = true;
                sb.append(ch);
            } else {
                totalSpaces++;
                if (isWord) {
                    isWord = false;
                    words.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        if (isWord) {
            words.add(sb.toString());
        }
        return totalSpaces;
    }
}
