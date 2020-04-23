package SWE_Application;

public class MenuItem {
    double price;
    String item_name;
    String item_type;
    boolean iscustom;
    String [] toppings = new String[10];
    String size;
    int topping_count;

    public MenuItem(double p, String in, String it){
        price = p;
        item_name = in;
        item_type = it;
    }
    public MenuItem(String in, String it,String s, String[] t){
        item_name = in;
        item_type = it;
        size = s;
        for (int i = 0; i< t.length;i++){
            t[i] = toppings[i];
            topping_count++;
        }
    }
    //returns the price of a pizza
    public double getPrice() {
        return price;
    }
    // Calculates the prize of a Pizza
    private void calcPizzaPrice(){
       if(size == "Personal")
           price+= 3.99 ;
        else if(size == "Small")
            price+=4.79;
        else if(size == "Medium")
            price+= 11.99;
        else if(size == "Large")
            price+= 14.99;
        price+=(topping_count*0.48);
    }

    public String getItem_name() {
        return item_name;
    }
    public String getItem_type(){
        return item_type;
    }
    //if the item is a pizza then
    public String[] getToppings(MenuItem m){
        if(m.getItem_type()== "Pizza"){
            return m.toppings;
        }else
            return null;
    }
    // if the menu Item is a custom pizza then returns true if not the returns false
    public boolean isCustom(MenuItem m){
        if(m.iscustom == true && m.getItem_type() == "Pizza"){
            return true;
        }
        else
            return false;
    }
}