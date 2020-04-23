package SWE_Application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Scanner;

public class program extends Application{
/********attributes********/
    ArrayList<MenuItem> cart = new ArrayList<>(); // stores the objects that the customer wanting to purchase
    Scanner scan = new Scanner(System.in);// to read in the users input
    double tax = 0.04;
    double total; // total price of the order
    double subtotal_price;

    // Array of toppings for the customers choices
    String sizes[] = new String []{"Personal","Small","Medium","Large"};
    String crusts[] = new String[]{"Hand Tossed","Stuffed","thin"};

    // declaring the Choice Boxes(drop down menus)
    ChoiceBox<String>pizza_size =  new ChoiceBox<>();
    ChoiceBox<String>crust_type = new ChoiceBox<>();

    //labels for choice Boxes
    Label crustLabel = new Label("Crust: ");
    Label sizeLabel = new Label("Size: ");

    //Menu Items
    MenuItem iPepsi = new MenuItem(2.90,"Pepsi","Drink");
    MenuItem idietPepsi = new MenuItem(2.90,"Diet Pepsi","Drink");
    MenuItem mtnDew = new MenuItem(2.90,"Mountain Dew","Drink");
    MenuItem sierraMist = new MenuItem(2.90,"Sierra Mist","Drink");
    MenuItem aquafina = new MenuItem(1.80,"Aquafina","Drink");
    MenuItem fudge = new MenuItem(4.99,"Fudge Brownies(3)","Extras");
    MenuItem bread = new MenuItem(5.99,"Bread Sticks(8)", "Extras");
    MenuItem wings = new MenuItem(10.99,"Buffalo Wings(12)","Extras");
    MenuItem cookies = new MenuItem(3.49,"Chocolate Chip Cookies(2)","Extras");
    MenuItem sticks = new MenuItem(5.99,"Cinnamon Sticks(8)","Extras");
    MenuItem knots = new MenuItem(6.99,"Garlic Knots(20)", "Extras");

    // Checkboxes for toppings
    CheckBox pepperoni = new CheckBox("Pepperoni");
    CheckBox green_pepper = new CheckBox("Green Pepper");
    CheckBox extra_cheese = new CheckBox("Extra Cheese");
    CheckBox sausage = new CheckBox("Sausage");
    CheckBox bacon = new CheckBox("Bacon");
    CheckBox onion = new CheckBox("Onions");
    CheckBox pineapple = new CheckBox("Pineapple");
    CheckBox mushroom = new CheckBox("Mushrooms");
    CheckBox ground_beef = new CheckBox("Ground Beef");
    CheckBox basil = new CheckBox("Basil");

    // images in the application
    ImageView pImg = new ImageView(getClass().getResource("pizza.jpg").toExternalForm());
    ImageView eImg = new ImageView(getClass().getResource("Extras_Button.JPG").toExternalForm());
    ImageView dImg = new ImageView(getClass().getResource("Drinks Button.JPG").toExternalForm());
    ImageView cartImg = new ImageView(getClass().getResource("Shopping Cart.JPG").toExternalForm());
    ImageView pImg2 = new ImageView(getClass().getResource("pizza.jpg").toExternalForm());
    ImageView eImg2 = new ImageView(getClass().getResource("Extras_Button.JPG").toExternalForm());
    ImageView dImg2 = new ImageView(getClass().getResource("Drinks Button.JPG").toExternalForm());
    ImageView cartImg2 = new ImageView(getClass().getResource("Shopping Cart.JPG").toExternalForm());
    ImageView pImg3 = new ImageView(getClass().getResource("pizza.jpg").toExternalForm());
    ImageView eImg3 = new ImageView(getClass().getResource("Extras_Button.JPG").toExternalForm());
    ImageView dImg3 = new ImageView(getClass().getResource("Drinks Button.JPG").toExternalForm());
    ImageView cartImg3 = new ImageView(getClass().getResource("Shopping Cart.JPG").toExternalForm());
    ImageView pImg4 = new ImageView(getClass().getResource("pizza.jpg").toExternalForm());
    ImageView eImg4 = new ImageView(getClass().getResource("Extras_Button.JPG").toExternalForm());
    ImageView dImg4 = new ImageView(getClass().getResource("Drinks Button.JPG").toExternalForm());
    ImageView cartImg4 = new ImageView(getClass().getResource("Shopping Cart.JPG").toExternalForm());
    ImageView dpImg = new ImageView(getClass().getResource("Pepsi Button.JPG").toExternalForm());
    ImageView ddImg = new ImageView(getClass().getResource("Diet Pepsi.JPG").toExternalForm());
    ImageView dmImg = new ImageView(getClass().getResource("Mountain Dew.JPG").toExternalForm());
    ImageView dsImg = new ImageView(getClass().getResource("Sierra Mist.JPG").toExternalForm());
    ImageView wImg = new ImageView(getClass().getResource("Water.JPG").toExternalForm());
    ImageView fbImg = new ImageView(getClass().getResource("Fudge Brownies.JPG").toExternalForm());
    ImageView bsImg = new ImageView(getClass().getResource("Breadsticks.JPG").toExternalForm());
    ImageView bwImg = new ImageView(getClass().getResource("Buffalo Wings.JPG").toExternalForm());
    ImageView cccImg = new ImageView(getClass().getResource("Chocolate Chip Cookies.JPG").toExternalForm());
    ImageView csImg = new ImageView(getClass().getResource("Cinnamon Sticks.JPG").toExternalForm());
    ImageView gkImg = new ImageView(getClass().getResource("Garlic Knots.JPG").toExternalForm());
    ImageView mpImg = new ImageView(getClass().getResource("Add Pizza Button.jpg").toExternalForm());
    ImageView logo = new ImageView(getClass().getResource("Cool Pizza shop image.png").toExternalForm());



    // Scenes, stages, and layouts
    Stage window;
    Scene drinks_menu,pizza_menu,extras_menu;

    // Boxes used to organize scenes
    VBox menu_box2 = new VBox();
    HBox top_bar1 = new HBox();
    HBox top_bar2 = new HBox();
    HBox menu_box = new HBox(10);
    HBox top_bar3 = new HBox(10);


    // Buttons being used in the application
    Button pizza = new Button("",pImg);
    Button drinks = new Button("",dImg);
    Button dessert = new Button("",eImg);
    Button pizza2 = new Button("",pImg2);
    Button drinks2= new Button("",dImg2);
    Button dessert2 = new Button("",eImg2);
    Button pizza3 = new Button("",pImg3);
    Button drinks3 = new Button("",dImg3);
    Button dessert3 = new Button("",eImg3);
    Button pizza4 = new Button("",pImg4);
    Button drinks4 = new Button("",dImg4);
    Button dessert4 = new Button("",eImg4);
    Button nPizza = new Button("",mpImg); // Right here you dumb fuck
    Button pepsi = new Button("",dpImg);
    Button dietPepsi= new Button("",ddImg);
    Button mtDew = new Button("",dmImg);
    Button sMist = new Button("",dsImg);
    Button water = new Button("",wImg);
    Button fudge_brownies = new Button("",fbImg);
    Button bread_sticks = new Button("",bsImg);
    Button buffalo_wings = new Button("",bwImg);
    Button chocolate_chip_cookie = new Button("",cccImg);
    Button cinnamon_sticks = new Button("",csImg);
    Button garlic_knots = new Button("",gkImg);
    Button view_cart = new Button("",cartImg);
    Button view_cart2 = new Button("",cartImg2);
    Button view_cart3 = new Button("",cartImg3);



/********Functions*********/
public static void main(String [] args){
    launch(args);
}
// upon start up of the application
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;

        // fills the values into the choice boxes
        fillCB(pizza_size,sizes);
        fillCB(crust_type,crusts);

        // sets the default values to the  ChoiceBoxes
        pizza_size.setValue("Choose size");

      /************** SCENES ************/
        //Start Screen layout
        Button start_button = new Button("Order");
        start_button.setPrefSize(100,100);
        BorderPane welcome = new BorderPane();
        HBox welcome_top = new HBox();
        HBox welcome_Center = new HBox(10);
        welcome_Center.setStyle("-fx-background-color: DAE6F3;");
        welcome_top.setStyle("-fx-background-color: #336699;");
        welcome_Center.getChildren().add(start_button);
        welcome.setCenter(welcome_Center);
        welcome_Center.setAlignment(Pos.CENTER);
        Scene starting = new Scene(welcome,1000,500);

        //creates the drinks_menu scene
        BorderPane base = new BorderPane();
        menu_box.setStyle("-fx-background-color: DAE6F3;");
        top_bar1.setStyle("-fx-background-color: #336699;");
        top_bar1.setSpacing(50);
        top_bar1.getChildren().addAll(pizza,drinks,dessert,view_cart);
        menu_box.getChildren().addAll(pepsi,dietPepsi,mtDew,sMist,water);
        menu_box.setAlignment(Pos.CENTER);
        base.setCenter(menu_box);
        base.setTop(top_bar1);
        top_bar1.setAlignment(Pos.BASELINE_CENTER);
        drinks_menu = new Scene(base,1000,500);

       //Pizza_menu scene
        BorderPane base2 = new BorderPane();
        menu_box2.setStyle("-fx-background-color: DAE6F3;");
        menu_box2.setAlignment(Pos.CENTER_LEFT);
        top_bar2.setStyle(("-fx-background-color: #336699;"));
        top_bar2.setSpacing(50);
        top_bar2.getChildren().addAll(pizza2,drinks2,dessert2,view_cart2);
        top_bar2.setAlignment(Pos.BASELINE_CENTER);
        base2.setCenter(addPizzaLeftGridPane());
        base2.setRight(addPizzaRightGridPane());
        base2.setTop(top_bar2);
        pizza_menu = new Scene(base2,1000,500);

        //extras_menuScene
        BorderPane base3 = new BorderPane();
        top_bar3.setStyle("-fx-background-color: #336699;");
        top_bar3.setSpacing(50);
        top_bar3.getChildren().addAll(pizza3,drinks3,dessert3,view_cart3);
        top_bar3.setAlignment(Pos.BASELINE_CENTER);
        base3.setCenter(addExtrasFlowPane());
        base3.setTop(top_bar3);
        extras_menu = new Scene(base3,1000,500);

        /*********Button actions********/
        start_button.setOnAction(e-> window.setScene(pizza_menu)); // begins the ordering process

        //swaps between scenes
        pizza.setOnAction(e -> window.setScene(pizza_menu));
        pizza2.setOnAction(e-> window.setScene(pizza_menu));
        pizza3.setOnAction(e-> window.setScene(pizza_menu));
        pizza4.setOnAction(e-> window.setScene(pizza_menu));
        drinks.setOnAction(e-> window.setScene(drinks_menu));
        drinks2.setOnAction(e-> window.setScene(drinks_menu));
        drinks3.setOnAction(e-> window.setScene(drinks_menu));
        drinks4.setOnAction(e-> window.setScene(drinks_menu));
        dessert.setOnAction(e-> window.setScene(extras_menu));
        dessert2.setOnAction(e-> window.setScene(extras_menu));
        dessert3.setOnAction(e-> window.setScene(extras_menu));
        dessert4.setOnAction(e-> window.setScene(extras_menu));


        // check box actions

        // adds Items to the cart
        pepsi.setOnAction(e-> cart.add(iPepsi));
        dietPepsi.setOnAction(e-> cart.add(idietPepsi));
        mtDew.setOnAction(e-> cart.add(mtnDew));
        sMist.setOnAction(e-> cart.add(sierraMist));
        water.setOnAction(e-> cart.add(aquafina));
        fudge_brownies.setOnAction(e-> cart.add(fudge));
        bread_sticks.setOnAction(e-> cart.add(bread));
        buffalo_wings.setOnAction(e-> cart.add(wings));
        chocolate_chip_cookie.setOnAction(e-> cart.add(cookies));
        cinnamon_sticks.setOnAction(e-> cart.add(sticks));
        garlic_knots.setOnAction(e-> cart.add(knots));
        nPizza.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ArrayList<String> toppings = new ArrayList<>();
                if(pepperoni.isSelected() == true)
                    toppings.add("Pepperoni");
                if(extra_cheese.isSelected() == true)
                    toppings.add("Extra Cheese");
                if(mushroom.isSelected() == true)
                    toppings.add("Mushrooms");
                if(green_pepper.isSelected() == true)
                    toppings.add("Green Pepper");
                if(basil.isSelected() == true)
                    toppings.add("Basil");
                if(bacon.isSelected() == true)
                    toppings.add("Bacon");
                if(sausage.isSelected() == true)
                    toppings.add("Sausage");
                if(onion.isSelected() == true)
                    toppings.add("Onions");
                if(ground_beef.isSelected() == true)
                    toppings.add("Ground Beef");
                if(pineapple.isSelected() == true)
                    toppings.add("Pineapple");
                toppings.trimToSize();
                String [] t = new String[toppings.size()];
                for(int i  = 0; i< toppings.size();i++)
                    t[i] = toppings.get(i);
                MenuItem pizza = new MenuItem("User Made Pizza","Pizza",pizza_size.getValue(),t);
                cart.add(pizza);
            }
        });

        /**************Starts the GUI*********/
        //starts the first scene of the program
        window.setScene(starting);
        window.setTitle("testing application");
        window.show();

    }
    /*
    this methods populates the choice boxes with items
    @Param: choiceBox ,items
    this takes a Choice Box and populates the options with items
     */
    private void fillCB(ChoiceBox<String>choiceBox, String @NotNull [] items){
        for (int i = 0; i < items.length;i++)
            choiceBox.getItems().add(items[i]);
    }
    // creates the Flow Pane needed for extras_menu
    public FlowPane addExtrasFlowPane(){
        FlowPane flow = new FlowPane();
        flow.setPrefWrapLength(100);
        flow.setHgap(10);
        flow.setStyle("-fx-background-color: DAE6F3;");
        flow.getChildren().addAll(fudge_brownies,bread_sticks,buffalo_wings,chocolate_chip_cookie,cinnamon_sticks,garlic_knots);
        flow.setAlignment(Pos.CENTER);
        return flow;
    }
    public GridPane addPizzaLeftGridPane(){
        GridPane grid = new GridPane();
        grid.setHgap(10);// horizontal Spacing
        grid.setVgap(10);// Vertical spacing
       // grid.setGridLinesVisible(true);
        grid.setStyle("-fx-background-color: DAE6F3;");// sets the color to a light blue
        Label topping  = new Label("Select Toppings:"); //  prompts user selection
        grid.addColumn(0,topping,pepperoni,extra_cheese,mushroom,green_pepper,basil,bacon,sausage,onion,ground_beef,pineapple);
        grid.add(crust_type, 4,4);
        grid.add(crustLabel,4,3);
        grid.add(sizeLabel, 4,6);
        grid.add(pizza_size,4,7);
        grid.add(nPizza,6,6);
        return grid;
    }
    public GridPane addPizzaRightGridPane(){
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-color: DAE6F3;");
        grid.add(logo,6,6);
        return grid;
    }
}
/*
THIS CODE IS ABSOLUTELY DISGUSTING AND I HATE IT. GET THE MARINARA SAUCE AND MOZZARELLA
CAUSE THIS CODE IS SPAGHETTI
 */