package application;

import application.bills.Bill;
import application.bills.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@CrossOrigin
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private BillRepository billRepository;

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting("Hi", "wei");
    }

    @RequestMapping("/bills")
    public List<Bill> getBills() {
        return billRepository.getBills();
    }

    @PostMapping("/addBill")
    List<Bill> newBill(@RequestBody Bill newBill) {
        System.out.print("addbill");
        System.out.print(newBill.toString());
        return billRepository.save(newBill);
    }
}


