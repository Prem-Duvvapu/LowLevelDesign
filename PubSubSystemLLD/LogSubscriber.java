package PubSubSystemLLD;

public class LogSubscriber implements Subscriber {
    private String name;

    public LogSubscriber(String name) {
        this.name=name;
    }

    @Override
    public void consume(Message message) {
        System.out.println("[LOG] Subscriber "+name+" received the message: "+message.getPayload());
    }
}
