package application.bills;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private double amount;

    private String type;

    private Date dueDate;

    private String status;

    private String provider;

    public Bill(){}

    public Bill(double amount, String type, Date dueDate, String status, String provider) {
        this.amount = amount;
        this.type = type;
        this.dueDate = dueDate;
        this.status = status;
        this.provider = provider;
    }

//    public int getId() {
//        return id;
//    }

//    public void setId(int id) {
//        this.id = id;
//    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    @Override
    public String toString() {
        return "id:" + " type:"+getType() + " amount :" + getAmount();
    }
}
