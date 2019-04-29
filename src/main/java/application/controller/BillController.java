package application;

import application.bills.Bill;
import application.bills.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class BillController {

    @Autowired
    private BillRepository billRepository;

    @RequestMapping("/bills")
    public List<Bill> getBills() {
        return billRepository.getBills();
    }

    @PostMapping("/addBill")
    List<Bill> newBill(@RequestBody Bill newBill) {
        return billRepository.save(newBill);
    }
}