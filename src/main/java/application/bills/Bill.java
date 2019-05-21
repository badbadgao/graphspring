package application.bills;


import javax.persistence.*;
import java.sql.Date;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private double amount;

    @Column(nullable = false, length = 32)
    private String type;

    private Date dueDate;

    private Date paidDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 32)
    private BillStatus status;

    @Column(nullable = false, length = 32)
    private String provider;

    @Column(columnDefinition = "TINYINT(1) default 0")
    private boolean retired;

    public Bill(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public Date getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(Date paidDate) {
        this.paidDate = paidDate;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    @Override
    public String toString() {
        return "id:" + " type:"+getType() + " amount :" + getAmount();
    }
}
