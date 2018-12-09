package application.bills;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Component
public class BillRepository {
    private List<Bill> bills;

    public BillRepository() {
        bills = new ArrayList<>();
        Bill bill1 = new Bill(0, 24.9, "Water", java.sql.Date.valueOf("2019-01-20"), "Unpaid", "City Council");
        Bill bill2 = new Bill(1,22.9, "Internet", java.sql.Date.valueOf("2018-12-15"), "Unpaid", "Spark");
        Bill bill3 = new Bill(2,25.9, "Electricity", Date.valueOf("2018-12-20"), "Unpaid", "Contact Energy");
        bills.add(bill1);
        bills.add(bill2);
        bills.add(bill3);
    }

    public List<Bill> save(Bill bill) {
        bill.setId(bills.size());
        bill.setStatus(bill.getStatus() == null ? "Unpaid" : bill.getStatus());

        bills.add(bill);
        return bills;
    }

    public List<Bill> getBills() {
        return bills;
    }
}
