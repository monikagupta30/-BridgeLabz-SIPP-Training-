import java.util.regex.*;

public class IPAddressValidator {
    public static boolean isValidIPv4(String ip) {
        // Regex for validating IPv4 address (0-255 in each octet)
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}"
                     + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);

        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] testIPs = {
            "192.168.0.1",   
            "255.255.255.255", //  Valid
            "256.100.50.0",  //  Invalid (256 out of range)
            "192.168.1",     //  Invalid (missing octet)
            "192.168.1.300", //  Invalid (300 out of range)
            "0.0.0.0"        
        };

        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }
}
