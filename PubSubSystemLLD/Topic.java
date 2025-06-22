package PubSubSystemLLD;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Topic {
    private String name;
    private List<Subscriber> subscribers;

    public Topic(String name) {
        this.name=name;
        subscribers=new CopyOnWriteArrayList<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void broadcast(Message message) {
        for (Subscriber subscriber: subscribers)
            Dispatcher.dispatch(subscriber, message);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(List<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }
}
