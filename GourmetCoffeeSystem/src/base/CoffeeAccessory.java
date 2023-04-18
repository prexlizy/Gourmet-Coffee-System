package base;
import java.util.*;
public class CoffeeAccessory {
    static String code = "";
    static String description = "";
    static Double price = 0.00;

    public static String getCode() {
        return code;
    }

    public static String getDescription() {
        return description;
    }

    public static double getPrice() {
        return price;
    }

    public void setCode(String newCode) {
        code = newCode;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setPrice(double newPrice) {
        price = newPrice;
    }
}