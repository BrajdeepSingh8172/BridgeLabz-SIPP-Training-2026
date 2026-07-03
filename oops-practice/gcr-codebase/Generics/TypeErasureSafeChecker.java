import java.util.ArrayList;
import java.util.List;

public class TypeErasureSafeChecker<T> {
    private Class<T> typeToken;

    public TypeErasureSafeChecker(Class<T> typeToken) {
        this.typeToken = typeToken;
    }

    public boolean isInstance(Object obj) {
        return typeToken.isInstance(obj);
    }

    public static void main(String[] args) {
        TypeErasureSafeChecker<String> stringChecker = new TypeErasureSafeChecker<>(String.class);
        
        Object testStr = "Hello World";
        Object testInt = 123;

        System.out.println("Is testStr an instance of String? " + stringChecker.isInstance(testStr));
        System.out.println("Is testInt an instance of String? " + stringChecker.isInstance(testInt));

        List<String> stringList = new ArrayList<>();
        System.out.println("Runtime class of generic list: " + stringList.getClass().getName());
    }
}