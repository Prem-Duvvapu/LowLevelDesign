package PubSubSystemLLD;

public class Demo {
    public static void main(String[] args) {
        //Create Broker
        Broker broker=new Broker();

        //Create Topics
        broker.createTopic("topic-1");
        broker.createTopic("topic-2");

        //Create publishers
        Publisher publisher1=new Publisher("1",broker);
        Publisher publisher2=new Publisher("2",broker);

        //Create subscribers
        Subscriber subscriber1=new PrintSubscriber("PrintSubscriber1");
        Subscriber subscriber2=new LogSubscriber("LogSubscriber1");

        //Subscribe to topics
        broker.subscribe("topic-1",subscriber1);
        broker.subscribe("topic-2",subscriber1);
        broker.subscribe("topic-1",subscriber2);

        //Publish messages
        publisher1.publish("topic-1","Message1 from Publisher1 for topic1");
        publisher2.publish("topic-2","Message1 from Publisher2 for topic2");

        broker.unsubscribe("topic-1",subscriber1);

        try {
            Thread.sleep(100);
            Dispatcher.shutdown();
        } catch (Exception e) {
            System.out.println("Error shutting down dispatcher: "+e.getMessage());
        }
    }
}
