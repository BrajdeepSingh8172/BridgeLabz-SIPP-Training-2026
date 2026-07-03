import java.util.ArrayList;
import java.util.List;

interface MealPlan {
    String getPlanDetails();
}

class VegetarianMeal implements MealPlan {
    public String getPlanDetails() {
        return "Vegetarian Plan: High fibers, plant-based dairy, legumes.";
    }
}

class KetoMeal implements MealPlan {
    public String getPlanDetails() {
        return "Keto Plan: High healthy fats, moderate proteins, low carbohydrates.";
    }
}

class Meal<T extends MealPlan> {
    private T plan;
    private String subscriberName;

    public Meal(String subscriberName, T plan) {
        this.subscriberName = subscriberName;
        this.plan = plan;
    }

    public T getPlan() {
        return plan;
    }

    public String getSubscriberName() {
        return subscriberName;
    }
}

public class MealPlanGenerator {
    public static <T extends MealPlan> void validateAndGenerate(Meal<T> meal) {
        if (meal == null || meal.getPlan() == null) {
            System.out.println("Invalid meal configuration detected.");
            return;
        }
        System.out.println("Generating personalized profile for " + meal.getSubscriberName() + "...");
        System.out.println("Configuration Status: VALID");
        System.out.println("Details: " + meal.getPlan().getPlanDetails());
        System.out.println();
    }

    public static void main(String[] args) {
        Meal<VegetarianMeal> client1 = new Meal<>("Alice", new VegetarianMeal());
        Meal<KetoMeal> client2 = new Meal<>("Bob", new KetoMeal());

        validateAndGenerate(client1);
        validateAndGenerate(client2);
    }
}