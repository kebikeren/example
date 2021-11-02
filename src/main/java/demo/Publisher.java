package demo;

/**
 * @Classname Publisher
 * @Description TODO
 * @Date 2021-11-02
 * @Created by kebikeren
 */
public class Publisher {
    private MessageContainer container;
    private Integer id;

    public Publisher(MessageContainer container) {
        this.container = container;
    }

    public void publish(Object o) {
        this.container.addEvent(new Event(this, o));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
