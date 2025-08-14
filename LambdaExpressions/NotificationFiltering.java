import java.util.*;
import java.util.function.Predicate;

class Alert {
    String type;      // e.g., "Critical", "Normal", "Info"
    String ward;      // e.g., "ICU", "General", "Pediatrics"
    String message;

    public Alert(String type, String ward, String message) {
        this.type = type;
        this.ward = ward;
        this.message = message;
    }

    @Override
    public String toString() {
        return "[" + type + " - " + ward + "] " + message;
    }
}

public class NotificationFiltering {
    public static void main(String[] args) {
        List<Alert> alerts = Arrays.asList(
            new Alert("Critical", "ICU", "Patient heart rate abnormal!"),
            new Alert("Normal", "General", "Patient checkup scheduled."),
            new Alert("Critical", "Pediatrics", "Child needs urgent care."),
            new Alert("Info", "ICU", "Daily cleaning completed."),
            new Alert("Normal", "ICU", "Vitals stable.")
        );

        // Predicate for Critical alerts only
        Predicate<Alert> criticalOnly = alert -> alert.type.equalsIgnoreCase("Critical");

        // Predicate for ICU alerts only
        Predicate<Alert> icuOnly = alert -> alert.ward.equalsIgnoreCase("ICU");

        // Predicate for Critical ICU alerts
        Predicate<Alert> criticalICU = criticalOnly.and(icuOnly);

        System.out.println("\n Critical Alerts:");
        alerts.stream().filter(criticalOnly).forEach(System.out::println);

        System.out.println("\n ICU Alerts:");
        alerts.stream().filter(icuOnly).forEach(System.out::println);

        System.out.println("\n Critical ICU Alerts:");
        alerts.stream().filter(criticalICU).forEach(System.out::println);
    }
}
