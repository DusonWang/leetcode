package code.code;

/**
 * �����һ��ͣ�������һ��ͣ��ϵͳ��ͣ�����ܹ������ֲ�ͬ��С�ĳ�λ�����к�С��ÿ�ֳߴ�ֱ��й̶���Ŀ�ĳ�λ��
 * <p>
 * ����ʵ��?ParkingSystem?�ࣺ
 * <p>
 * ParkingSystem(int big, int medium, int small)?��ʼ��?ParkingSystem?�࣬���������ֱ��Ӧÿ��ͣ��λ����Ŀ��
 * bool addCar(int carType)?����Ƿ���?carType?��Ӧ��ͣ��λ��?carType?���������ͣ����У�С���ֱ�������?1��?2?��?3?��ʾ��һ����ֻ��ͣ��??carType?��Ӧ�ߴ��ͣ��λ�С����û�пճ�λ���뷵��?false?�����򽫸ó�ͣ�복λ������?true?��
 * ?
 * <p>
 * ʾ�� 1��
 * <p>
 * ���룺
 * ["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
 * [[1, 1, 0], [1], [2], [3], [1]]
 * �����
 * [null, true, true, false, false]
 * <p>
 * ���ͣ�
 * ParkingSystem parkingSystem = new ParkingSystem(1, 1, 0);
 * parkingSystem.addCar(1); // ���� true ����Ϊ�� 1 ���յĴ�λ
 * parkingSystem.addCar(2); // ���� true ����Ϊ�� 1 ���յ��г�λ
 * parkingSystem.addCar(3); // ���� false ����Ϊû�пյ�С��λ
 * parkingSystem.addCar(1); // ���� false ����Ϊû�пյĴ�λ��Ψһһ����λ�Ѿ���ռ����
 * ?
 * <p>
 * ��ʾ��
 * <p>
 * 0 <= big, medium, small <= 1000
 * carType?ȡֵΪ?1��?2?��?3
 * �������?addCar?����?1000?��
 * ͨ������51,782�ύ����61,119
 * ��������������Ƹ���������⣿
 * <p>
 * ��Դ�����ۣ�LeetCode��
 * ���ӣ�https://leetcode-cn.com/problems/design-parking-system
 * ����Ȩ������������С���ҵת������ϵ�ٷ���Ȩ������ҵת����ע��������
 */
public class ParkingSystem {

    private final int[] cars = new int[4];

    public ParkingSystem(int big, int medium, int small) {
        cars[1] = big;
        cars[2] = medium;
        cars[3] = small;
    }

    public boolean addCar(int carType) {
        return cars[carType]-- > 0;
    }

    public static void main(String[] args) {
        ParkingSystem parkingSystem = new ParkingSystem(1,1,0);
        System.out.println(parkingSystem.addCar(1));
        System.out.println(parkingSystem.addCar(2));
        System.out.println(parkingSystem.addCar(3));
        System.out.println(parkingSystem.addCar(1));
    }
}
