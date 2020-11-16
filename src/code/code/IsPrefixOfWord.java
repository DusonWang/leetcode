package code.code;

/**
 * ����һ���ַ��� sentence ��Ϊ���Ӳ�ָ��������Ϊ searchWord �����о����������� �����ո� �ָ��ĵ�����ɡ�
 * <p>
 * ����������� searchWord �Ƿ�Ϊ���� sentence �����ⵥ�ʵ�ǰ׺��
 * <p>
 * ���?searchWord ��ĳһ�����ʵ�ǰ׺���򷵻ؾ���?sentence �иõ�������Ӧ���±꣨�±�� 1 ��ʼ����
 * ��� searchWord �Ƕ�����ʵ�ǰ׺���򷵻�ƥ��ĵ�һ�����ʵ��±꣨��С�±꣩��
 * ��� searchWord �����κε��ʵ�ǰ׺���򷵻� -1 ��
 * �ַ��� S �� ��ǰ׺���� S ���κ�ǰ���������ַ�����
 * <p>
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺sentence = "i love eating burger", searchWord = "burg"
 * �����4
 * ���ͣ�"burg" �� "burger" ��ǰ׺���� "burger" �Ǿ����е� 4 �����ʡ�
 * ʾ�� 2��
 * <p>
 * ���룺sentence = "this problem is an easy problem", searchWord = "pro"
 * �����2
 * ���ͣ�"pro" �� "problem" ��ǰ׺���� "problem" �Ǿ����е� 2 ��Ҳ�ǵ� 6 �����ʣ�����Ӧ�÷�����С�±� 2 ��
 * ʾ�� 3��
 * <p>
 * ���룺sentence = "i am tired", searchWord = "you"
 * �����-1
 * ���ͣ�"you" ���Ǿ������κε��ʵ�ǰ׺��
 * ʾ�� 4��
 * <p>
 * ���룺sentence = "i use triple pillow", searchWord = "pill"
 * �����4
 * ʾ�� 5��
 * <p>
 * ���룺sentence = "hello from the other side", searchWord = "they"
 * �����-1
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= sentence.length <= 100
 * 1 <= searchWord.length <= 10
 * sentence ��СдӢ����ĸ�Ϳո���ɡ�
 * searchWord ��СдӢ����ĸ��ɡ�
 * ǰ׺���ǽ��ܸ����ڴʸ������أ��м䲻�ܲ��������ɷ֣���������λ���ǹ̶��ġ���-λ�ڴʸ�֮ǰ���������� ǰ׺_�ٶȰٿ� ��
 * ͨ������2,827�ύ����4,562
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/check-if-a-word-occurs-as-a-prefix-of-any-word-in-a-sentence
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class IsPrefixOfWord {

    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] tmps = sentence.split(" ");
        for (int i = 0; i < tmps.length; i++) {
            if (tmps[i].startsWith(searchWord)) {
                return i;
            }
        }
        return -1;
    }
}
