package code.code;

/**
 * @author duson
 * 表1: Person
 * <p>
 * +-------------+---------+
 * | 列名         | 类型     |
 * +-------------+---------+
 * | PersonId    | int     |
 * | FirstName   | varchar |
 * | LastName    | varchar |
 * +-------------+---------+
 * PersonId 是上表主键
 * 表2: Address
 * <p>
 * +-------------+---------+
 * | 列名         | 类型    |
 * +-------------+---------+
 * | AddressId   | int     |
 * | PersonId    | int     |
 * | City        | varchar |
 * | State       | varchar |
 * +-------------+---------+
 * AddressId 是上表主键
 *  
 * <p>
 * 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息：
 * <p>
 *  
 * <p>
 * FirstName, LastName, City, State
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combine-two-tables
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombineTwoTables {

//    # Write your MySQL query statement below
//    select
//    a.FirstName,a.LastName,b.City,b.State
//    from Person a
//    left join Address b
//    on a.PersonId=b.PersonId
}
