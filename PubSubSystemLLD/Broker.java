package PubSubSystemLLD;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Broker {
    private Map<String, Topic> topics;

    public Broker() {
        topics=new ConcurrentHashMap<>();
    }

    public void createTopic(String topicName) {
        topics.putIfAbsent(topicName, new Topic(topicName));
    }

    public void subscribe(String topicName, Subscriber subscriber) {
        Topic topic=topics.get(topicName);
        if (topic==null)
            throw new IllegalArgumentException("Not topic found with given topic name");
        topic.addSubscriber(subscriber);
    }

    public void unsubscribe(String topicName, Subscriber subscriber) {
        Topic topic=topics.get(topicName);
        if (topic==null)
            throw new IllegalArgumentException("Not topic found with given topic name");
        topic.removeSubscriber(subscriber);
    }

    public void publish(String topicName, Message message) {
        Topic topic=topics.get(topicName);
        if (topic==null)
            throw new IllegalArgumentException("Not topic found with given topic name");
        topic.broadcast(message);
    }
}
