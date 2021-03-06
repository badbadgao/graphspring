package application;

import application.bills.Bill;
import application.bills.BillStatus;
import application.constant.ResultCode;
import ch.qos.logback.core.encoder.EchoEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
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

@Transactional
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
        String querySql = "SELECT b FROM Bill b where b.retired = false";
        Query query = manager.createQuery(querySql);
        return query.getResultList();
    }

    @PostMapping("/bill")
    public @ResponseBody List<Bill> newBill(@RequestBody Bill newBill) {
        Calendar currentTime = Calendar.getInstance();
        Date now = new Date((currentTime.getTime()).getTime());
        newBill.setStatus(BillStatus.UNPAID);
        billDAORepository.save(newBill);
        return getBills();
    }

    @PutMapping("/bill/{id}")
    public @ResponseBody List<Bill> payBill(@PathVariable(value="id") Integer billId) {
        Bill bill = billDAORepository.findById(billId)
                .orElseThrow(() -> new ResourceAccessException("Bill not found"));
        bill.setStatus(BillStatus.PAID);
        Calendar currentTime = Calendar.getInstance();
        Date now = new Date((currentTime.getTime()).getTime());
        bill.setPaidDate(now);
        billDAORepository.save(bill);
        return getBills();
    }

    @DeleteMapping("/bill")
    public List<Bill> deleteBill(@RequestParam("ids") String ids) throws Exception {
        String querySql = "UPDATE Bill b SET b.retired = true where b.id IN :ids";
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