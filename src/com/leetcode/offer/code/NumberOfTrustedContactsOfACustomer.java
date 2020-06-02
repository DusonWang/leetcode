package com.leetcode.offer.code;

/**
 * @author duson
 * �˿ͱ�Customers
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | customer_id   | int     |
 * | customer_name | varchar |
 * | email         | varchar |
 * +---------------+---------+
 * customer_id �����ű��������
 * �˱��ÿһ�а�����ĳ�����̵�˿͵������͵����ʼ���
 * ?
 * <p>
 * ��ϵ��ʽ��Contacts
 * <p>
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | user_id       | id      |
 * | contact_name  | varchar |
 * | contact_email | varchar |
 * +---------------+---------+
 * (user_id, contact_email) �����ű��������
 * �˱��ÿһ�б�ʾ���Ϊ use_id �Ĺ˿͵�ĳλ��ϵ�˵������͵����ʼ���
 * �˱����ÿλ�˿͵���ϵ����Ϣ�����˿͵���ϵ�˲�һ�������ڹ˿ͱ��С�
 * ?
 * <p>
 * ��Ʊ��Invoices
 * <p>
 * +--------------+---------+
 * | Column Name  | Type    |
 * +--------------+---------+
 * | invoice_id   | int     |
 * | price        | int     |
 * | user_id      | int     |
 * +--------------+---------+
 * invoice_id �����ű��������
 * �˱��ÿһ�зֱ��ʾ���Ϊ use_id �Ĺ˿�ӵ����һ�ű��Ϊ invoice_id���۸�Ϊ price �ķ�Ʊ��
 * ?
 * <p>
 * Ϊÿ�ŷ�Ʊ invoice_id ��дһ��SQL��ѯ�Բ����������ݣ�
 * <p>
 * customer_name���뷢Ʊ��صĹ˿����ơ�
 * price����Ʊ�ļ۸�
 * contacts_cnt���ù˿͵���ϵ��������
 * trusted_contacts_cnt��������ϵ�˵����������Ǹù˿͵���ϵ�������̵�˿͵���ϵ������������������ϵ�˵ĵ����ʼ������ڿͻ����У���
 * ����ѯ�Ľ������?invoice_id?����
 * <p>
 * ��ѯ����ĸ�ʽ��������ʾ��
 * <p>
 * Customers table:
 * +-------------+---------------+--------------------+
 * | customer_id | customer_name | email              |
 * +-------------+---------------+--------------------+
 * | 1           | Alice         | alice@leetcode.com |
 * | 2           | Bob           | bob@leetcode.com   |
 * | 13          | John          | john@leetcode.com  |
 * | 6           | Alex          | alex@leetcode.com  |
 * +-------------+---------------+--------------------+
 * Contacts table:
 * +-------------+--------------+--------------------+
 * | user_id     | contact_name | contact_email      |
 * +-------------+--------------+--------------------+
 * | 1           | Bob          | bob@leetcode.com   |
 * | 1           | John         | john@leetcode.com  |
 * | 1           | Jal          | jal@leetcode.com   |
 * | 2           | Omar         | omar@leetcode.com  |
 * | 2           | Meir         | meir@leetcode.com  |
 * | 6           | Alice        | alice@leetcode.com |
 * +-------------+--------------+--------------------+
 * Invoices table:
 * +------------+-------+---------+
 * | invoice_id | price | user_id |
 * +------------+-------+---------+
 * | 77         | 100   | 1       |
 * | 88         | 200   | 1       |
 * | 99         | 300   | 2       |
 * | 66         | 400   | 2       |
 * | 55         | 500   | 13      |
 * | 44         | 60    | 6       |
 * +------------+-------+---------+
 * Result table:
 * +------------+---------------+-------+--------------+----------------------+
 * | invoice_id | customer_name | price | contacts_cnt | trusted_contacts_cnt |
 * +------------+---------------+-------+--------------+----------------------+
 * | 44         | Alex          | 60    | 1            | 1                    |
 * | 55         | John          | 500   | 0            | 0                    |
 * | 66         | Bob           | 400   | 2            | 0                    |
 * | 77         | Alice         | 100   | 3            | 2                    |
 * | 88         | Alice         | 200   | 3            | 2                    |
 * | 99         | Bob           | 300   | 2            | 0                    |
 * +------------+---------------+-------+--------------+----------------------+
 * Alice ����λ��ϵ�ˣ�������λ(Bob �� John)�ǿ�����ϵ�ˡ�
 * Bob ����λ��ϵ��, �����е��κ�һλ�����ǿ�����ϵ�ˡ�
 * Alex ֻ��һλ��ϵ��(Alice)������һλ������ϵ�ˡ�
 * John û���κ���ϵ�ˡ�
 * ͨ������562�ύ����823
 * ����ʵ������������������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/number-of-trusted-contacts-of-a-customer
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class NumberOfTrustedContactsOfACustomer {

    //select i.invoice_id, c1.customer_name, i.price,
    //    count(ct.contact_name) contacts_cnt ,
    //    count(c2.customer_name) trusted_contacts_cnt
    //from invoices i join customers c1 on i.user_id=c1.customer_id
    //    left join contacts ct on i.user_id=ct.user_id
    //    left join customers c2 on ct.contact_email=c2.email
    //group by i.invoice_id
    //order by i.invoice_id
}
