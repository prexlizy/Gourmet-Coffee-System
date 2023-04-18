package base;



public class CoffeeBrewer extends CoffeeAccessory{
    static String model = "";
    static String waterSupply = "";
    static int capacity =0;
    //get
    public static String getModel(){
        return model;
    }
    public static String getWaterSupply(){
        return waterSupply;
    }
    public static int getCapacity(){
        return capacity;
    }
    //set
    public static void setModel(String newModel){
        model=newModel;
    }
    public static void setWaterSupply(String newWaterSupply){
        waterSupply = newWaterSupply;
    }
    public static void setCapacity(int newCapacity){
        capacity= newCapacity;
    }
}

