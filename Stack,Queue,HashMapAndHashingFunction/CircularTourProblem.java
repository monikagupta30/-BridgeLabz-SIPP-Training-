public class CircularTourProblem {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }
    }

    // Returns the starting pump index or -1 if not possible
    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0;
        int surplus = 0;
        int deficit = 0;

        for (int i = 0; i < n; i++) {
            surplus += pumps[i].petrol - pumps[i].distance;

            if (surplus < 0) {
                // Failed to reach next pump, move start to next
                start = i + 1;
                deficit += surplus;
                surplus = 0;
            }
        }

        return (surplus + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(6, 4),
            new PetrolPump(3, 6),
            new PetrolPump(7, 3)
        };

        int start = findStartingPoint(pumps);
        if (start != -1)
            System.out.println("Start at petrol pump index: " + start);
        else
            System.out.println("No possible tour.");
    }
}
