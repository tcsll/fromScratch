// package test4;
// import java.util.Properties;
// import java.util.concurrent.TimeUnit;
//
//
//
// import test4.javaapi.producer.Producer;
// import test4.producer.KeyedMessage;
// import test4.producer.ProducerConfig;
//
// import test4.serializer.StringEncoder;
//
// public class kafkaProducer extends Thread{
//
//     private String topic;
//
//     public kafkaProducer(String topic){
//         super();
//         this.topic = topic;
//     }
//
//
//     @Override
//     public void run() {
//         Producer producer = createProducer();
//         int i=0;
//         while(true){
//             producer.send(new KeyedMessage<Integer, String>(topic, "message: mlgbcaonima" + i++));
//             try {
//                 TimeUnit.SECONDS.sleep(1);
//             } catch (InterruptedException e) {
//                 e.printStackTrace();
//             }
//         }
//     }
//
//     private Producer createProducer() {
//         Properties properties = new Properties();
//         properties.put("zookeeper.connect", "jbeq-host1:2181,jbeq-host2:2181,jbeq-host3:2181/kafka");//声明zk
//         properties.put("serializer.class", StringEncoder.class.getName());
//         properties.put("metadata.broker.list", "jbeq-host3:9092");// 声明kafka broker
//         return new Producer<Integer, String>(new ProducerConfig(properties));
//     }
//
//
//     public static void main(String[] args) {
//         new kafkaProducer("hhh").start();// 使用kafka集群中创建好的主题 test
//
//     }
//
// }