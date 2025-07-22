import java.util.*;

// === MealPlan Interface ===
interface MealPlan {
    String getMealName();
    String getNutritionalInfo();
}

// === Subtypes of MealPlan ===
class VegetarianMeal implements MealPlan {
    private String mealName;

    public VegetarianMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String getNutritionalInfo() {
        return "Rich in Fiber and Plant Protein";
    }

    @Override
    public String toString() {
        return mealName + " [Vegetarian] - " + getNutritionalInfo();
    }
}

class VeganMeal implements MealPlan {
    private String mealName;

    public VeganMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String getNutritionalInfo() {
        return "100% Plant-Based, No Animal Products";
    }

    @Override
    public String toString() {
        return mealName + " [Vegan] - " + getNutritionalInfo();
    }
}

class KetoMeal implements MealPlan {
    private String mealName;

    public KetoMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String getNutritionalInfo() {
        return "High Fat, Low Carb, Moderate Protein";
    }

    @Override
    public String toString() {
        return mealName + " [Keto] - " + getNutritionalInfo();
    }
}

class HighProteinMeal implements MealPlan {
    private String mealName;

    public HighProteinMeal(String mealName) {
        this.mealName = mealName;
    }

    @Override
    public String getMealName() {
        return mealName;
    }

    @Override
    public String getNutritionalInfo() {
        return "High in Protein for Muscle Building";
    }

    @Override
    public String toString() {
        return mealName + " [High-Protein] - " + getNutritionalInfo();
    }
}

// === Generic Meal Class ===
class Meal<T extends MealPlan> {
    private T mealType;

    public Meal(T mealType) {
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    public void displayMeal() {
        System.out.println(mealType.toString());
    }
}

// === Utility Class with Generic Method ===
class MealPlanGenerator {
    public static <T extends MealPlan> Meal<T> generateMealPlan(T mealType) {
        System.out.println("Generating personalized meal plan for: " + mealType.getMealName());
        return new Meal<>(mealType);
    }

    public static <T extends MealPlan> boolean validateMealPlan(T mealType) {
        System.out.println("Validating: " + mealType.getMealName());
        return mealType.getMealName() != null && !mealType.getMealName().isEmpty();
    }
}

// === Main Class ===
public class PersonalizedMealPlanner {
    public static void main(String[] args) {
        // Create different meal types
        VegetarianMeal vegMeal = new VegetarianMeal("Grilled Paneer Salad");
        VeganMeal veganMeal = new VeganMeal("Quinoa & Chickpea Bowl");
        KetoMeal ketoMeal = new KetoMeal("Avocado Chicken Wrap");
        HighProteinMeal hpMeal = new HighProteinMeal("Egg White Omelette");

        // Generate and display personalized meal plans
        System.out.println("=== Personalized Meal Plans ===");

        generateAndDisplay(vegMeal);
        generateAndDisplay(veganMeal);
        generateAndDisplay(ketoMeal);
        generateAndDisplay(hpMeal);
    }

    // Generic method to validate and display meal
    public static <T extends MealPlan> void generateAndDisplay(T plan) {
        if (MealPlanGenerator.validateMealPlan(plan)) {
            Meal<T> meal = MealPlanGenerator.generateMealPlan(plan);
            meal.displayMeal();
            System.out.println();
        } else {
            System.out.println("Invalid Meal Plan for: " + plan.getMealName());
        }
    }
}
