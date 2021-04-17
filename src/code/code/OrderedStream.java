package code.code;

import java.util.ArrayList;
import java.util.List;

/**
 * �� n �� (id, value) �ԣ����� id �� 1 �� n ֮���һ��������value ��һ���ַ����������� id ��ͬ������?(id, value) �ԡ�
 * <p>
 * ���һ�������� ���� ˳���ȡ n?��?(id, value)?�ԣ����ڶ�ε���ʱ �� id ������˳�� ����һЩֵ��
 * <p>
 * ʵ�� OrderedStream �ࣺ
 * <p>
 * OrderedStream(int n) ����һ���ܽ��� n ��ֵ������������ǰָ�� ptr ��Ϊ 1 ��
 * String[] insert(int id, String value) �����д洢�µ� (id, value) �ԡ��洢��
 * ������洢�� id = ptr �� (id, value) �ԣ����ҳ��� id = ptr ��ʼ�� � id ������������ ���� ��˳�� ��������Щ id ������ֵ���б�Ȼ�󣬽� ptr ����Ϊ����Ǹ�? id + 1?��
 * ���򣬷���һ�����б�
 * <p>
 * ?
 * <p>
 * ʾ����
 * <p>
 * <p>
 * <p>
 * ����
 * ["OrderedStream", "insert", "insert", "insert", "insert", "insert"]
 * [[5], [3, "ccccc"], [1, "aaaaa"], [2, "bbbbb"], [5, "eeeee"], [4, "ddddd"]]
 * ���
 * [null, [], ["aaaaa"], ["bbbbb", "ccccc"], [], ["ddddd", "eeeee"]]
 * <p>
 * ����
 * OrderedStream os= new OrderedStream(5);
 * os.insert(3, "ccccc"); // ���� (3, "ccccc")������ []
 * os.insert(1, "aaaaa"); // ���� (1, "aaaaa")������ ["aaaaa"]
 * os.insert(2, "bbbbb"); // ���� (2, "bbbbb")������ ["bbbbb", "ccccc"]
 * os.insert(5, "eeeee"); // ���� (5, "eeeee")������ []
 * os.insert(4, "ddddd"); // ���� (4, "ddddd")������ ["ddddd", "eeeee"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= n <= 1000
 * 1 <= id <= n
 * value.length == 5
 * value ����Сд��ĸ���
 * ÿ�ε��� insert ����ʹ��һ��Ψһ�� id
 * ǡ�õ��� n �� insert
 * ͨ������6,410�ύ����8,161
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-an-ordered-stream
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class OrderedStream {

    private String[] stream;
    private int ptr = 0;

    public OrderedStream(int n) {
        stream = new String[n];
    }

    public List<String> insert(int id, String value) {
        stream[id - 1] = value;
        List<String> list = new ArrayList<>();
        for (int i = ptr; i < stream.length; i++) {
            if (stream[i] == null) {
                break;
            } else {
                ptr++;
                list.add(stream[i]);
            }
        }
        return list;
    }
}

/**
 * Your OrderedStream object will be instantiated and called as such:
 * OrderedStream obj = new OrderedStream(n);
 * List<String> param_1 = obj.insert(idKey,value);
 */