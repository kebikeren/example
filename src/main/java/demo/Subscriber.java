package demo;

/**
 * @Classname Subscriber
 * @Description TODO
 * @Date 2021-11-02
 * @Created by kebikeren
 */
public class Subscriber {
    private Integer id;

    public void update(Event event) {
        String msg = String.format("subcriber %s receive publisher %d message: %s", this.id, event.getPublisher().getId(), event.getMessage());
        System.out.println(msg);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
