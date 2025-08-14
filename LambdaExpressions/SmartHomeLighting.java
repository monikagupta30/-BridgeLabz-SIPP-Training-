@FunctionalInterface
interface LightAction {
    void execute();
}

public class SmartHomeLighting {
    public static void main(String[] args) {

        // Defining light patterns using Lambda Expressions
        LightAction motionTrigger = () -> System.out.println(" Lights ON - Motion detected in the hallway!");
        LightAction timeTrigger = () -> System.out.println(" Dim lights to warm tone - Evening mode activated!");
        LightAction voiceCommand = () -> System.out.println("🎤 Voice command recognized - Lights set to party mode!");

        // Simulating triggers
        activateLights("motion", motionTrigger);
        activateLights("time", timeTrigger);
        activateLights("voice", voiceCommand);
    }

    // Generic method to activate lights based on trigger
    private static void activateLights(String triggerType, LightAction action) {
        System.out.println("Trigger: " + triggerType);
        action.execute();
        System.out.println("-----------------------------");
    }
}
