package base;

public class Coffee extends CoffeeAccessory {
    static String origin = "";
    static String roast = "";
    static String flavor = "";
    static String aroma = "";
    static String acidity = "";
    static String body = "";
    static String smallCharge ="";

    public Coffee(String inicode, String inidescription, Double iniprice,String iniorigin,String iniroast,String iniflavor,String iniaroma,String iniacidity,String inibody,String inismallCharge) {
        super(inicode, inidescription, iniprice);
        this.origin=iniorigin;
        this.roast=iniroast;
        this.flavor=iniflavor;
        this.aroma=iniaroma;
        this.acidity=iniacidity;
        this.body=inibody;
        this.smallCharge=inismallCharge;
    }

    //get
    public static String getOrigin(){
        return origin;
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
        origin = newOrigin;
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
    }

    @Override
    public String toString() {
        return super.toString()+"_"+getOrigin()+"_"+getRoast()+"_"+getFlavor()+"_"+getSmallCharge()+"_"+getAroma()+"_"+getAcidity()+"_"+getBody();
    }
}
