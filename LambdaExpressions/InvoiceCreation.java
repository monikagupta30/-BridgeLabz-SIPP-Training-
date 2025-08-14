import java.util.*;
import java.util.stream.Collectors;

class Invoice {
    String transactionId;

    // Constructor
    public Invoice(String transactionId) {
        this.transactionId = transactionId;
    }

    @Override
    public String toString() {
        return "Invoice{transactionId='" + transactionId + "'}";
    }
}

public class InvoiceCreation {
    public static void main(String[] args) {
        List<String> transactionIds = Arrays.asList(
            "TXN001", "TXN002", "TXN003"
        );

        System.out.println(" Generated Invoices:");

        // Using constructor reference
        List<Invoice> invoices = transactionIds.stream()
                                               .map(Invoice::new)  // Constructor reference
                                               .collect(Collectors.toList());

        invoices.forEach(System.out::println);
    }
}
