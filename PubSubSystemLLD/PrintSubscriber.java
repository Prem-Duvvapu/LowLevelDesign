package PubSubSystemLLD;

public class PrintSubscriber implements Subscriber {
    private String name;

    public PrintSubscriber(String name) {
        this.name=name;
    }

    @Override
    public void consume(Message message) {
        System.out.println("Subscriber "+name+" received the message: "+message.getPayload());
    }
}
