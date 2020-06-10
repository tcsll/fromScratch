// package test5;
//
// import java.util.ArrayList;
// import java.util.List;
//
// /**
//  * @author ：shill
//  * @date ：Created in 2020/4/7 14:52
//  * @description :
//  * 实现智能停车场
//  * 1) 停车场中有三个停车位。
//  * 2) 车辆可以实现停车(假定停车时间为10秒)和离开停车位的动作。
//  * 3) 使用多线程模拟实现多辆车停车。停车成功显示:xxx号车成功停止在xxx号停车位；如果该停车位已满则停车失败。
//  */
// public class CarParkingTest {
//     static Object park1;
//     static Object park2;
//     static Object park3;
//
//     public static void main(String[] args) {
//         park1=new Object();
//         park2=new Object();
//         park3=new Object();
//         List<Object> parks=new ArrayList<>();
//         parks.add(park1);
//         parks.add(park2);
//         parks.add(park3);
//
//     }
//
//     class Car(){
//
//     }
//
//
//
//
//     static class car implements Runnable {
//         Car c;
//         Park p;
//
//         public Parkcar(Car c, Park p) {
//             this.c = c;
//             this.p = p;
//         }
//
//         public void run() {
//             // TODO Auto-generated method stub
//             while (true) {
//                 int i=0;
//                 for (i = 0; i < p.park.length; i++) {
//
//                     if (c.parking == false) {
//                         //	synchronized (p) {
//
//
//                         if (p.park[i] == false) {
//                             System.out.println((i + 1) + "车位已有停车");
//                             continue;
//                         } else {
//                             System.out.println("有停车位" + (i + 1));
//                             System.out.println("车" + c.getNumber() + "停在了"+ (i + 1) + "号车位上");
//                             p.park[i] = false;
//                             c.setPosition(i + 1);
//                             c.setParking(true);
//
//                         }
//
//                     }
//                 }
//
//                 if(i==p.park.length+1){System.out.println("车位已满,"+c.number+"车等待...");}
//
//
//                 try {
//                     Thread.sleep(5000);
//                 } catch (InterruptedException e) {
//                     // TODO Auto-generated catch block
//                     e.printStackTrace();
//                 }
//
//
//                 System.out.println("车" + c.getNumber() + "离开了"+ c.getPosition() + "号车位");
//                 p.park[i] = true;
//                 break;
//                 //	}
//
//
//
//
//
//             }
//         }
//     }
// }
