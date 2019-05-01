package application;

import application.bills.Bill;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class BillRepository {
    private List<Bill> bills;

    public BillRepository() {
        bills = new ArrayList<>();
//        Bill bill1 = new Bill(0, 24.9, "Water", java.sql.Date.valueOf("2019-01-20"), "Unpaid", "City Council");
//        Bill bill2 = new Bill(1,22.9, "Internet", java.sql.Date.valueOf("2018-12-15"), "Unpaid", "Spark");
//        Bill bill3 = new Bill(2,25.9, "Electricity", Date.valueOf("2018-12-20"), "Unpaid", "Contact Energy");
//        bills.add(bill1);
//        bills.add(bill2);
//        bills.add(bill3);
    }

    public List<Bill> save(Bill bill) {
//        bill.setId(bills.size());
        bill.setStatus(bill.getStatus() == null ? "Unpaid" : bill.getStatus());

        bills.add(bill);

        Collections.sort(bills, Comparator.comparing(Bill::getDueDate));
        return bills;
    }

    public List<Bill> getBills() {
        return bills;
    }

    /**
     * Delete the bill by given id
     * @param id
     * @return the status of removing
     */
    public boolean deleteBill(String ids) {
        String[] idsArray = ids.split(",");
        System.out.print(ids);
//        return bills.removeIf((Bill bill) -> Arrays.stream(idsArray).anyMatch(String.valueOf(bill.getId())::equals));
        return false;
    }

    public static void main(String[] args) {
        BillRepository billRepository = new BillRepository();
        billRepository.deleteBill("0,2");
        System.out.print(billRepository.getBills());
    }
}
