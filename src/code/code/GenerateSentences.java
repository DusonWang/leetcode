package code.code;

import java.util.*;

/**
 * @author duson
 * ����һ������ʱ�?synonyms ��һ������?text?��?synonyms ������һЩ����ʶ� ������Խ�����?text ��ÿ�����������Ľ�������滻��
 * <p>
 * �����ҳ������ý�����滻��ľ��ӣ���?�ֵ�������?�󷵻ء�
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * synonyms = [["happy","joy"],["sad","sorrow"],["joy","cheerful"]],
 * text = "I am happy today but was sad yesterday"
 * �����
 * ["I am cheerful today but was sad yesterday",
 * "I am cheerful today but was sorrow yesterday",
 * "I am happy today but was sad yesterday",
 * "I am happy today but was sorrow yesterday",
 * "I am joy today but was sad yesterday",
 * "I am joy today but was sorrow yesterday"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <=?synonyms.length <= 10
 * synonyms[i].length == 2
 * synonyms[0] != synonyms[1]
 * ���е��ʽ�����Ӣ����ĸ���ҳ������Ϊ?10 ��
 * text?������?10 �����ʣ��ҵ��ʼ��õ����ո�ָ�����
 * ͨ������725�ύ����1,289
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/synonymous-sentences
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class GenerateSentences {

    private final Map<String, HashSet<String>> dicMap = new HashMap<>();
    private DSU dsu;

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        List<String> result = new ArrayList<>();
        if (null == synonyms) {
            result.add(text);
            return result;
        }
        if (text == null || text.length() == 0) {
            return result;
        }
        dsu = new DSU(synonyms);
        for (List<String> stringList : synonyms) {
            String str1 = stringList.get(0);
            String str2 = stringList.get(1);
            dsu.union(str1, str2);
        }
        for (List<String> stringList : synonyms) {
            String parent = dsu.find(stringList.get(0));
            dicMap.putIfAbsent(parent, new HashSet<>());
            dicMap.get(parent).add(stringList.get(0));
            dicMap.get(parent).add(stringList.get(1));
        }
        String[] sentenceArray = text.split(" ");
        dfs(result, sentenceArray, 0, "");
        result.sort(String::compareTo);
        return result;
    }

    private void dfs(List<String> result, String[] sentenceArray, int index, String sentence) {
        if (index == sentenceArray.length) {
            result.add(sentence.trim());
            return;
        }
        if (!dsu.parent.containsKey(sentenceArray[index])) {
            dfs(result, sentenceArray, index + 1, sentence + " " + sentenceArray[index]);
        } else {
            String tempParent = dsu.find(sentenceArray[index]);
            HashSet<String> allWords = dicMap.get(tempParent);
            for (String word : allWords) {
                dfs(result, sentenceArray, index + 1, sentence + " " + word);
            }
        }
    }

    static class DSU {
        Map<String, String> parent;

        DSU(List<List<String>> synonyms) {
            parent = new HashMap<>();
            init(synonyms);
        }

        public void init(List<List<String>> synonyms) {
            for (List<String> stringList : synonyms) {
                for (String str : stringList) {
                    parent.put(str, str);
                }
            }
        }

        public void union(String x, String y) {
            String parent1 = find(x);
            String parent2 = find(y);
            if (parent1.equals(parent2)) {
                return;
            }
            parent.put(y, parent1);
        }

        public String find(String x) {
            if (parent.get(x).equals(x)) {
                return x;
            }
            parent.put(x, find(parent.get(x)));
            return parent.get(x);
        }
    }
}
