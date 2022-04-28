package application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button viewAllRecipesButton;
    @FXML
    private Button ExitButton;
    @FXML
    private AnchorPane scenePane;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextArea ingredientsTextArea;
    @FXML
    private TextArea directionsTextArea;
    @FXML
    private CheckBox oneStar;
    @FXML
    private CheckBox twoStar;
    @FXML
    private CheckBox threeStar;
    @FXML
    private CheckBox fourStar;
    @FXML
    private CheckBox fiveStar;
    @FXML
    private Button createButton;
    @FXML
    private CheckBox breakfast;
    @FXML
    private CheckBox lunch;
    @FXML
    private CheckBox dinner;
    @FXML
    private ListView<String> listViewOfRecipes;
    public boolean isInBreakfastScene = false;
    public boolean isInLunchScene = false;
    public boolean isInDinnerScene = false;
    public boolean exceptionCaught = false;

    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    ArrayList<Recipe> breakfastArray  = new ArrayList<Recipe>();
    ArrayList<Recipe> lunchArray  = new ArrayList<Recipe>();
    ArrayList<Recipe> dinnerArray  = new ArrayList<Recipe>();

    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene2(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToBreakfastRecipe(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("BreakfastRecipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToLunchRecipe(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("LunchRecipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToDinnerRecipe(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("DinnerRecipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToScene4(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene4.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCredits(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Credits.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToCreateRecipe(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("CreateRecipe.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToAllRecipes(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("AllRecipes.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    public void switchToRecipeCreated(ActionEvent event) throws IOException, ClassNotFoundException {

        Recipe tempRecipe = new Recipe();

        Recipe newRecipe = new Recipe();
        newRecipe.setRecipeName(nameTextField.getText());
        newRecipe.setIngredients(ingredientsTextArea.getText());
        newRecipe.setDirections(directionsTextArea.getText());
        if(oneStar.isSelected()) {
            newRecipe.setRating(1);
        }else if(twoStar.isSelected()) {
            newRecipe.setRating(2);
        }else if(threeStar.isSelected()) {
            newRecipe.setRating(3);
        }else if(fourStar.isSelected()) {
            newRecipe.setRating(4);
        }else if(fiveStar.isSelected()) {
            newRecipe.setRating(5);
        }else {
            newRecipe.setRating(5);
        }

        if(breakfast.isSelected()) {
            newRecipe.addBreakfast();
        }
        if(lunch.isSelected()) {
            newRecipe.addLunch();
        }
        if(dinner.isSelected()) {
            newRecipe.addDinner();
        }

        try {
            FileInputStream fi = new FileInputStream(new File("AllRecipes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(!exceptionCaught) {
                try {
                    tempRecipe = (Recipe) oi.readObject();
                    tempRecipe.addToList(recipeList);
                }catch(EOFException e) {
                    System.out.println("End of File");
                    exceptionCaught = true;
                }
            }
            oi.close();
            fi.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        newRecipe.addToList(recipeList);

        for(int i = 0; i<recipeList.size(); i++) {
            if(recipeList.get(i).isInBreakfast) {
                recipeList.get(i).addToList(breakfastArray);
            }
        }

        for(int i = 0; i<recipeList.size(); i++) {
            if(recipeList.get(i).isInLunch) {
                recipeList.get(i).addToList(lunchArray);
            }
        }

        for(int i = 0; i<recipeList.size(); i++) {
            if(recipeList.get(i).isInDinner) {
                recipeList.get(i).addToList(dinnerArray);
            }
        }

        FileOutputStream f = new FileOutputStream(new File("AllRecipes.txt"));
        ObjectOutputStream o = new ObjectOutputStream(f);

        for(int i = 0; i<recipeList.size(); i++) {
            o.writeObject(recipeList.get(i));
        }

        o.close();
        f.close();
//
        FileOutputStream fb = new FileOutputStream(new File("BreakfastRecipes.txt"));
        ObjectOutputStream ob = new ObjectOutputStream(fb);

        for(int i = 0; i<breakfastArray.size(); i++) {
            ob.writeObject(breakfastArray.get(i));
        }

        ob.close();
        fb.close();
        //
        FileOutputStream fl = new FileOutputStream(new File("LunchRecipes.txt"));
        ObjectOutputStream ol = new ObjectOutputStream(fl);

        for(int i = 0; i<lunchArray.size(); i++) {
            ol.writeObject(lunchArray.get(i));
        }

        ol.close();
        fl.close();
//
        FileOutputStream fd = new FileOutputStream(new File("DinnerRecipes.txt"));
        ObjectOutputStream od = new ObjectOutputStream(fd);

        for(int i = 0; i<dinnerArray.size(); i++) {
            od.writeObject(dinnerArray.get(i));
        }

        od.close();
        fd.close();
//
        for(int i = 0; i<recipeList.size();i++) {
            System.out.println(recipeList.get(i).getRecipeName());
        }
        root = FXMLLoader.load(getClass().getResource("RecipeCreated.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void handleOneStar() {
        if(oneStar.isSelected()) {
            twoStar.setSelected(false);
            threeStar.setSelected(false);
            fourStar.setSelected(false);
            fiveStar.setSelected(false);
        }
    }
    @FXML
    private void handleTwoStar() {
        if(twoStar.isSelected()) {
            oneStar.setSelected(false);
            threeStar.setSelected(false);
            fourStar.setSelected(false);
            fiveStar.setSelected(false);
        }
    }
    @FXML
    private void handleThreeStar() {
        if(threeStar.isSelected()) {
            twoStar.setSelected(false);
            oneStar.setSelected(false);
            fourStar.setSelected(false);
            fiveStar.setSelected(false);
        }
    }
    @FXML
    private void handleFourStar() {
        if(fourStar.isSelected()) {
            twoStar.setSelected(false);
            threeStar.setSelected(false);
            oneStar.setSelected(false);
            fiveStar.setSelected(false);
        }
    }
    @FXML
    private void handleFiveStar() {
        if(fiveStar.isSelected()) {
            twoStar.setSelected(false);
            threeStar.setSelected(false);
            fourStar.setSelected(false);
            oneStar.setSelected(false);
        }
    }
}

