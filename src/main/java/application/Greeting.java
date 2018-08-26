package application;

import javax.persistence.*;

@Entity
@Table(name="greeting")
public class Greeting {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;

    private String message;

    public Greeting(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public Greeting() {

    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
