package application.bills;

public enum BillStatus {
    UNPAID("Unpaid"),
    PAID("Paid");

    private final String displayStatus;

    BillStatus(String displayStatus) {
        this.displayStatus = displayStatus;
    }

    @Override
    public String toString() {
        return this.displayStatus;
    }
}
