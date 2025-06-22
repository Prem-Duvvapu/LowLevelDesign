package PubSubSystemLLD;

public class Publisher {
    private String id;
    private Broker broker;

    public Publisher(String id, Broker brokder) {
        this.id=id;
        this.broker=brokder;
    }

    public void publish(String topicName, String payload) {
        broker.publish(topicName, new Message(payload));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Broker getBroker() {
        return broker;
    }

    public void setBroker(Broker broker) {
        this.broker = broker;
    }
}
