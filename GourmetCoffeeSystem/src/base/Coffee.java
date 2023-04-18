package base;


public class Coffee extends CoffeeAccessory {
    static String countryoforigin = "";
    static String roast = "";
    static String flavor = "";
    static String aroma = "";
    static String acidity = "";
    static String body = "";
    static String smallCharge ="";
//get
    public static String getOrigin(){
        return countryoforigin;
    }
    public static String getRoast(){
        return roast;
    }
    public static String getFlavor(){
        return flavor;
    }
    public static String getSmallCharge(){
        return smallCharge;
    }
    public static String getAroma(){
        return aroma;
    }
    public static String getAcidity(){
        return acidity;
    }
    public static String getBody(){
        return body;
    }
    //set
    public static void setOrigin(String newOrigin){
        countryoforigin = newOrigin;
    }
    public static void setRoast(String newRoast){
        roast = newRoast;
    }
    public static void setFlavor(String newFlavour){
        flavor= newFlavour;
    }
    public static void setSmallCharge(String newSmallCharge){
        smallCharge = newSmallCharge;
    }
    public static void setAroma(String newAroma){
        aroma = newAroma;
    }
    public static void setAcidity(String newAcidity){
        acidity = newAcidity;
    }
    public static void setBody(String newBody){
        body = newBody;
        ;
    }




}
