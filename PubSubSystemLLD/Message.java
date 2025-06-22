package PubSubSystemLLD;

public class Message {
    private String payload;

    public Message(String payload) {
        this.payload=payload;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
