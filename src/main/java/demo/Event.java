package demo;

/**
 * @Classname Event
 * @Description TODO
 * @Date 2021-11-02
 * @Created by kebikeren
 */
public class Event {
    public Event(Publisher publisher, Object message) {
        this.publisher = publisher;
        this.message = message;
    }

    private Publisher publisher;
    private Object message;

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}
