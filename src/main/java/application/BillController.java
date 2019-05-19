package application;

import application.bills.Bill;
import application.bills.BillStatus;
import application.constant.ResultCode;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@SuppressWarnings("unused")
public class BillController {
    @PersistenceContext
    private EntityManager manager;

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private BillDAORepository billDAORepository;

    @RequestMapping("/bills")
    public List<Bill> getBills() {
        return (List<Bill>) billDAORepository.findAll();
    }

    @PostMapping("/bill")
    public @ResponseBody List<Bill> newBill(@RequestBody Bill newBill) {
        Calendar currentTime = Calendar.getInstance();
        Date now = new Date((currentTime.getTime()).getTime());
        newBill.setStatus(BillStatus.UNPAID);
        billDAORepository.save(newBill);
        return billDAORepository.findAll();
    }

    @PutMapping("/bill/{id}")
    public Bill payBill(@PathVariable(value="id") Integer billId) {
        Bill bill = billDAORepository.findById(billId)
                .orElseThrow(() -> new ResourceAccessException("Bill not found"));
<<<<<<< Updated upstream
        bill.setStatus("Paid");
        return billDAORepository.save(bill);
=======
        bill.setStatus(BillStatus.PAID);
        billDAORepository.save(bill);
        return billDAORepository.findAll();
>>>>>>> Stashed changes
    }

    @Transactional
    @DeleteMapping("/bill")
    public List<Bill> deleteBill(@RequestParam("ids") String ids) throws Exception {
        String querySql = "DELETE FROM Bill b where b.id IN :ids";
        Query query = manager.createNativeQuery(querySql);
        query.setParameter("ids", Arrays.asList(ids.split(",")));
        int resultCode = query.executeUpdate();
        System.out.println(ids);
        System.out.println(resultCode);
        if(resultCode != ResultCode.FAILED) {
            return getBills();
        }
        else {
            throw new Exception("Failed to delete ");
        }
    }
}