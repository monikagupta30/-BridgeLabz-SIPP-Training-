import java.time.LocalDate;
import java.util.*;

public class InsurancePolicySystem {

    // Main storage: policy number -> policy
    private Map<String, Policy> policyMap = new HashMap<>();

    // Insertion order: policy number -> policy
    private LinkedHashMap<String, Policy> insertionOrderMap = new LinkedHashMap<>();

    // Sorted by expiry: expiry date -> list of policies
    private TreeMap<LocalDate, List<Policy>> expiryMap = new TreeMap<>();

    // Add a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.policyNumber, policy);
        insertionOrderMap.put(policy.policyNumber, policy);
        expiryMap.computeIfAbsent(policy.expiryDate, k -> new ArrayList<>()).add(policy);
    }

    // Retrieve by policy number
    public Policy getPolicyByNumber(String number) {
        return policyMap.get(number);
    }

    // List policies expiring in next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        LocalDate now = LocalDate.now();
        LocalDate within30Days = now.plusDays(30);
        NavigableMap<LocalDate, List<Policy>> subMap = expiryMap.subMap(now, true, within30Days, true);
        List<Policy> soonExpiring = new ArrayList<>();
        for (List<Policy> list : subMap.values()) {
            soonExpiring.addAll(list);
        }
        return soonExpiring;
    }

    // List policies for a given policyholder
    public List<Policy> getPoliciesByHolder(String holderName) {
        List<Policy> result = new ArrayList<>();
        for (Policy p : policyMap.values()) {
            if (p.holderName.equalsIgnoreCase(holderName)) {
                result.add(p);
            }
        }
        return result;
    }

    // Remove all expired policies
    public void removeExpiredPolicies() {
        LocalDate now = LocalDate.now();
        NavigableMap<LocalDate, List<Policy>> expiredMap = expiryMap.headMap(now, false);
        for (List<Policy> expiredList : expiredMap.values()) {
            for (Policy p : expiredList) {
                policyMap.remove(p.policyNumber);
                insertionOrderMap.remove(p.policyNumber);
            }
        }
        expiredMap.clear(); // Remove from TreeMap
    }

    // Display all policies in insertion order
    public void displayAllPolicies() {
        System.out.println("\n All Policies (in insertion order):");
        for (Policy p : insertionOrderMap.values()) {
            System.out.println(p);
        }
    }

    // Sample usage
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10)));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40)));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().plusDays(5)));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().minusDays(2))); // expired

        system.displayAllPolicies();

        // Retrieve by number
        System.out.println("\n Retrieve P002: " + system.getPolicyByNumber("P002"));

        // Policies expiring soon
        System.out.println("\n Policies expiring in next 30 days:");
        for (Policy p : system.getPoliciesExpiringSoon()) {
            System.out.println(p);
        }

        // Policies for Alice
        System.out.println("\n Policies for Alice:");
        for (Policy p : system.getPoliciesByHolder("Alice")) {
            System.out.println(p);
        }

        // Remove expired policies
        system.removeExpiredPolicies();
        System.out.println("\n After removing expired policies:");
        system.displayAllPolicies();
    }
}

// Policy class
class Policy {
    String policyNumber;
    String holderName;
    LocalDate expiryDate;

    public Policy(String policyNumber, String holderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.holderName = holderName;
        this.expiryDate = expiryDate;
    }

    public String toString() {
        return String.format("Policy[%s, %s, Expires: %s]", policyNumber, holderName, expiryDate);
    }
}
