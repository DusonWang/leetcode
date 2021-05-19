package code.code;

import java.util.*;

/**
 * һ��������ס�Ź��������ĺ����ǡ����������ǵȵȡ�ÿһ��ʱ��㣬�����ͥ�����˳���Ҳ����������
 * <p>
 * ���������һ����ȷ�涨�Ļ�λ�̳�˳�򣬵�һ�̳������ǹ����Լ������Ƕ���ݹ麯��?Successor(x, curOrder)?������һ����?x?�͵�ǰ�ļ̳�˳�򣬸ú������� x?����һ�̳��ˡ�
 * <p>
 * Successor(x, curOrder):
 * ��� x û�к��ӻ������� x �ĺ��Ӷ��� curOrder �У�
 * ��� x �ǹ�������ô���� null
 * ���򣬷��� Successor(x �ĸ���, curOrder)
 * ���򣬷��� x ���� curOrder �����곤�ĺ���
 * �ȷ�˵�����������ɹ��������ĺ���?Alice �� Bob ��Alice �� Bob?�곤���� Alice �ĺ���?Jack ��ɡ�
 * <p>
 * һ��ʼ��?curOrder?Ϊ?["king"].
 * ����?Successor(king, curOrder)?������ Alice ���������ǽ� Alice ���� curOrder?�У��õ�?["king", "Alice"]?��
 * ����?Successor(Alice, curOrder)?������ Jack ���������ǽ� Jack ����?curOrder?�У��õ�?["king", "Alice", "Jack"]?��
 * ����?Successor(Jack, curOrder)?������ Bob ���������ǽ� Bob ����?curOrder?�У��õ�?["king", "Alice", "Jack", "Bob"]?��
 * ����?Successor(Bob, curOrder)?������?null?�����յõ��̳�˳��Ϊ?["king", "Alice", "Jack", "Bob"]?��
 * ͨ�����ϵĺ��������������ܵõ�һ��Ψһ�ļ̳�˳��
 * <p>
 * ����ʵ��?ThroneInheritance?�ࣺ
 * <p>
 * ThroneInheritance(string kingName) ��ʼ��һ��?ThroneInheritance?��Ķ��󡣹�����������Ϊ���캯���Ĳ������롣
 * void birth(string parentName, string childName)?��ʾ?parentName?��ӵ����һ����Ϊ?childName?�ĺ��ӡ�
 * void death(string name)?��ʾ��Ϊ?name?����������һ���˵���������Ӱ��?Successor?������Ҳ����Ӱ�쵱ǰ�ļ̳�˳�������ֻ������˱��Ϊ����״̬��
 * string[] getInheritanceOrder()?���� ��ȥ?������Ա�ĵ�ǰ�̳�˳���б�
 * ?
 * <p>
 * ʾ����
 * <p>
 * ���룺
 * ["ThroneInheritance", "birth", "birth", "birth", "birth", "birth", "birth", "getInheritanceOrder", "death", "getInheritanceOrder"]
 * [["king"], ["king", "andy"], ["king", "bob"], ["king", "catherine"], ["andy", "matthew"], ["bob", "alex"], ["bob", "asha"], [null], ["bob"], [null]]
 * �����
 * [null, null, null, null, null, null, null, ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"], null, ["king", "andy", "matthew", "alex", "asha", "catherine"]]
 * <p>
 * ���ͣ�
 * ThroneInheritance t= new ThroneInheritance("king"); // �̳�˳��king
 * t.birth("king", "andy"); // �̳�˳��king > andy
 * t.birth("king", "bob"); // �̳�˳��king > andy > bob
 * t.birth("king", "catherine"); // �̳�˳��king > andy > bob > catherine
 * t.birth("andy", "matthew"); // �̳�˳��king > andy > matthew > bob > catherine
 * t.birth("bob", "alex"); // �̳�˳��king > andy > matthew > bob > alex > catherine
 * t.birth("bob", "asha"); // �̳�˳��king > andy > matthew > bob > alex > asha > catherine
 * t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "bob", "alex", "asha", "catherine"]
 * t.death("bob"); // �̳�˳��king > andy > matthew > bob���Ѿ�ȥ����> alex > asha > catherine
 * t.getInheritanceOrder(); // ���� ["king", "andy", "matthew", "alex", "asha", "catherine"]
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 1 <= kingName.length, parentName.length, childName.length, name.length <= 15
 * kingName��parentName��?childName?��?name?������СдӢ����ĸ��
 * ���еĲ���?childName ��?kingName?������ͬ��
 * ����?death?�����е��������� name?Ҫô�ǹ�����Ҫô���Ѿ������˵���Ա���֡�
 * ÿ�ε��� birth(parentName, childName) ʱ��������������֤ parentName ��Ӧ����Ա�ǻ��ŵġ�
 * ������?105?��birth ��?death?��
 * ������?10?��?getInheritanceOrder?��
 * ͨ������3,077�ύ����6,061
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/throne-inheritance
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ThroneInheritance {

    private final String kingName;
    private final Map<String, List<String>> relationMap = new HashMap<>();
    private final Set<String> deathSet = new HashSet<>();

    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        relationMap.put(kingName, null);
    }

    public void birth(String parentName, String childName) {
        if (relationMap.get(parentName) == null) {
            List<String> list = new ArrayList<>();
            list.add(childName);
            relationMap.put(parentName, list);
        } else {
            relationMap.get(parentName).add(childName);
        }
        relationMap.put(childName, null);
    }

    public void death(String name) {
        deathSet.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        successor(res, kingName);
        return res;

    }

    public void successor(List<String> res, String name) {
        List<String> children = relationMap.get(name);
        if (!deathSet.contains(name)) {
            res.add(name);
        }
        if (children == null) {
            return;
        }
        for (String child : children) {
            successor(res, child);
        }
    }
}
