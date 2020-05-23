package com.leetcode.offer.code;

/**
 *?Customers?��
 *
 * +---------------------+---------+
 * | Column Name         | Type    |
 * +---------------------+---------+
 * | customer_id         | int     |
 * | customer_name       | varchar |
 * +---------------------+---------+
 * customer_id �����ű��������
 * customer_name �ǹ˿͵����ơ�
 * ?
 *
 * Orders?��
 *
 * +---------------+---------+
 * | Column Name   | Type    |
 * +---------------+---------+
 * | order_id      | int     |
 * | customer_id   | int     |
 * | product_name  | varchar |
 * +---------------+---------+
 * order_id �����ű��������
 * customer_id �ǹ�������Ϊ "product_name" ��Ʒ�˿͵�id��
 * ?
 *
 * ������� SQL ��ѯ�����湺���˲�Ʒ A �Ͳ�Ʒ B ȴû�й����Ʒ C �Ĺ˿͵� ID �������� customer_id ��?customer_name �������ǽ����ڴ˽��Ϊ�����Ƽ���Ʒ C ��
 * �����صĲ�ѯ�����Ҫ����?customer_id ����
 *
 * ?
 *
 * ��ѯ�����������ʾ��
 *
 * Customers table:
 * +-------------+---------------+
 * | customer_id | customer_name |
 * +-------------+---------------+
 * | 1           | Daniel        |
 * | 2           | Diana         |
 * | 3           | Elizabeth     |
 * | 4           | Jhon          |
 * +-------------+---------------+
 *
 * Orders table:
 * +------------+--------------+---------------+
 * | order_id   | customer_id  | product_name  |
 * +------------+--------------+---------------+
 * | 10         |     1        |     A         |
 * | 20         |     1        |     B         |
 * | 30         |     1        |     D         |
 * | 40         |     1        |     C         |
 * | 50         |     2        |     A         |
 * | 60         |     3        |     A         |
 * | 70         |     3        |     B         |
 * | 80         |     3        |     D         |
 * | 90         |     4        |     C         |
 * +------------+--------------+---------------+
 *
 * Result table:
 * +-------------+---------------+
 * | customer_id | customer_name |
 * +-------------+---------------+
 * | 3           | Elizabeth     |
 * +-------------+---------------+
 * ֻ�� customer_id Ϊ 3 �Ĺ˿͹����˲�Ʒ A �Ͳ�Ʒ B ��ȴû�й����Ʒ C ��
 * ͨ������493�ύ����621
 * ����ʵ������������������⣿
 *
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/customers-who-bought-products-a-and-b-but-not-c
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 * */
public class Customerswhoboughtproductsaandbbutnotc {

    //select
    //    t1.customer_id,
    //    t2.customer_name
    //from
    //    Orders t1
    //left join Customers t2
    //on t1.customer_id=t2.customer_id
    //group by t1.customer_id, t2.customer_name
    //having
    //    sum(if(product_name='A',1,0)) >0 and
    //    sum(if(product_name='B',1,0)) >0 and
    //    sum(if(product_name='C',1,0)) =0
    //order by
    //    t1.customer_id,
    //    t2.customer_name

}
