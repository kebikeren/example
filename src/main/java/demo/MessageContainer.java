package demo;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class MessageContainer {
    private BlockingDeque<Event> messages = new LinkedBlockingDeque<>(); //存消息
    private BlockingDeque<Subscriber> subcribers = new LinkedBlockingDeque<>(); //存订阅者
    private AtomicInteger pubIdGenerator = new AtomicInteger(0);
    private AtomicInteger subIdGenerator = new AtomicInteger(0);
    private Thread t;

    public void start() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Event event = messages.take();
                        Subscriber subscriber = subcribers.take();
                        subscriber.update(event);
                        subcribers.addLast(subscriber);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    public void waitConsume() {
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Publisher newPublisher() {
        int id = pubIdGenerator.incrementAndGet();
        Publisher publisher = new Publisher(this);
        publisher.setId(id);

        return publisher;
    }

    public Subscriber newSubscriber() {
        Subscriber subscriber = new Subscriber();
        subcribers.addLast(subscriber);
        int id = subIdGenerator.incrementAndGet();
        subscriber.setId(id);

        return subscriber;
    }

    public void addEvent(Event event) {
        messages.addLast(event);
    }
}
