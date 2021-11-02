package test;

import demo.MessageContainer;
import demo.Publisher;
import demo.Subscriber;
import org.junit.Test;

/**
 * @Classname MessageTest
 * @Description TODO
 * @Date 2021-11-02
 * @Created by kebikeren
 */
public class MessageTest {
    @Test
    public void message() {
        MessageContainer container = new MessageContainer();
        container.start();

        Publisher publisher = container.newPublisher();
        Publisher publisher2 = container.newPublisher();
        Publisher publisher3 = container.newPublisher();

        Subscriber subscriber = container.newSubscriber();
        Subscriber subscriber2 = container.newSubscriber();

        publisher.publish("1");
        publisher.publish("2");
        publisher2.publish("3");

        container.waitConsume();
    }
}
