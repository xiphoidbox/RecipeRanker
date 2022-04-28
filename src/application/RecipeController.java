package application;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/*
 * A class to control how the AllRecipe.fxml, BreakfastRecipe.fxml, DinnerRecipe.fxml, and LunchRecipe.fxml files act
 */
public class RecipeController {

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField ratingTextField;
    @FXML
    private TextArea ingredientsTextArea;
    @FXML
    private TextArea directionsTextArea;

    public boolean exceptionCaught = false;
    public int currentIndex = 0;

    ArrayList<Recipe> recipeList = new ArrayList<Recipe>();
    ArrayList<Recipe> breakfastArray  = new ArrayList<Recipe>();
    ArrayList<Recipe> lunchArray  = new ArrayList<Recipe>();
    ArrayList<Recipe> dinnerArray  = new ArrayList<Recipe>();

    //A method used to save recipe objects stored in the BreakfastRecipes.txt file to an ArrayList labeled breakfastArray. This will also
    //initialize the display of the recipe object to the app
    public void breakfastRecipe() throws IOException, ClassNotFoundException {


        Recipe tempRecipe = new Recipe();

        try {
            FileInputStream fi = new FileInputStream(new File("BreakfastRecipes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(!exceptionCaught) {
                try {
                    tempRecipe = (Recipe) oi.readObject();
                    tempRecipe.addToList(breakfastArray);
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

        System.out.println(breakfastArray.isEmpty());

        if(breakfastArray.isEmpty()) {
            nameTextField.setText("No Recipes Found");
            ingredientsTextArea.setText("No Recipes Found");
            directionsTextArea.setText("No Recipes Found");
            ratingTextField.setText("0");
        }else {
            nameTextField.setText(breakfastArray.get(0).getRecipeName());
            ingredientsTextArea.setText(breakfastArray.get(0).getIngredients());
            directionsTextArea.setText(breakfastArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(breakfastArray.get(0).getRating()));
        }
    }


    //A method used to save recipe objects stored in the LunchRecipes.txt file to an ArrayList labeled lunchArray. This will also
    //initialize the display of the recipe object to the app
    public void lunchRecipe() throws IOException, ClassNotFoundException {

        Recipe tempRecipe = new Recipe();

        try {
            FileInputStream fi = new FileInputStream(new File("LunchRecipes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(!exceptionCaught) {
                try {
                    tempRecipe = (Recipe) oi.readObject();
                    tempRecipe.addToList(lunchArray);
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

        System.out.println(lunchArray.isEmpty());

        if(lunchArray.isEmpty()) {
            nameTextField.setText("No Recipes Found");
            ingredientsTextArea.setText("No Recipes Found");
            directionsTextArea.setText("No Recipes Found");
            ratingTextField.setText("0");
        }else {
            nameTextField.setText(lunchArray.get(0).getRecipeName());
            ingredientsTextArea.setText(lunchArray.get(0).getIngredients());
            directionsTextArea.setText(lunchArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(lunchArray.get(0).getRating()));
            currentIndex++;
        }
    }

    //A method used to save recipe objects stored in the DinnerRecipes.txt file to an ArrayList labeled dinnerArray. This will also
    //initialize the display of the recipe object to the app
    public void dinnerRecipe() throws IOException, ClassNotFoundException {

        Recipe tempRecipe = new Recipe();

        try {
            FileInputStream fi = new FileInputStream(new File("DinnerRecipes.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            while(!exceptionCaught) {
                try {
                    tempRecipe = (Recipe) oi.readObject();
                    tempRecipe.addToList(dinnerArray);
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

        System.out.println(dinnerArray.isEmpty());

        if(dinnerArray.isEmpty()) {
            nameTextField.setText("No Recipes Found");
            ingredientsTextArea.setText("No Recipes Found");
            directionsTextArea.setText("No Recipes Found");
            ratingTextField.setText("0");
        }else {
            nameTextField.setText(dinnerArray.get(0).getRecipeName());
            ingredientsTextArea.setText(dinnerArray.get(0).getIngredients());
            directionsTextArea.setText(dinnerArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(dinnerArray.get(0).getRating()));
        }
    }

    //A method used to save recipe objects stored in the AllRecipes.txt file to an ArrayList labeled recipeList. This will also
    //initialize the display of the recipe object to the app
    public void allRecipe() throws IOException, ClassNotFoundException {


        Recipe tempRecipe = new Recipe();

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

        System.out.println(recipeList.isEmpty());

        if(breakfastArray.isEmpty()) {
            nameTextField.setText("No Recipes Found");
            ingredientsTextArea.setText("No Recipes Found");
            directionsTextArea.setText("No Recipes Found");
            ratingTextField.setText("0");
        }else {
            nameTextField.setText(recipeList.get(0).getRecipeName());
            ingredientsTextArea.setText(recipeList.get(0).getIngredients());
            directionsTextArea.setText(recipeList.get(0).getDirections());
            ratingTextField.setText(String.valueOf(recipeList.get(0).getRating()));
        }
    }

    //A method used to switch to the next recipe object stored in the breakfastArray
    public void switchToNextBreakfastRecipe() {

        if(currentIndex<breakfastArray.size()-1) {
            currentIndex++;
            nameTextField.setText(breakfastArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(breakfastArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(breakfastArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(breakfastArray.get(currentIndex).getRating()));
        }else {
            nameTextField.setText(breakfastArray.get(0).getRecipeName());
            ingredientsTextArea.setText(breakfastArray.get(0).getIngredients());
            directionsTextArea.setText(breakfastArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(breakfastArray.get(0).getRating()));
            currentIndex = 0;
        }

    }

    //A method used to switch to the next recipe object stored in the LunchArray
    public void switchToNextLunchRecipe() {

        if(currentIndex<lunchArray.size()-1) {
            currentIndex++;
            nameTextField.setText(lunchArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(lunchArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(lunchArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(lunchArray.get(currentIndex).getRating()));
        }else {
            nameTextField.setText(lunchArray.get(0).getRecipeName());
            ingredientsTextArea.setText(lunchArray.get(0).getIngredients());
            directionsTextArea.setText(lunchArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(lunchArray.get(0).getRating()));
            currentIndex = 0;
        }

    }

    //A method used to switch to the next recipe object stored in the dinnerArray
    public void switchToNextDinnerRecipe() {

        if(currentIndex<dinnerArray.size()-1) {
            currentIndex++;
            nameTextField.setText(dinnerArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(dinnerArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(dinnerArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(dinnerArray.get(currentIndex).getRating()));
        }else {
            nameTextField.setText(dinnerArray.get(0).getRecipeName());
            ingredientsTextArea.setText(dinnerArray.get(0).getIngredients());
            directionsTextArea.setText(dinnerArray.get(0).getDirections());
            ratingTextField.setText(String.valueOf(dinnerArray.get(0).getRating()));
            currentIndex = 0;
        }

    }

    //A method used to switch to the next recipe object stored in the recipeList
    public void switchToNextRecipe() {

        if(currentIndex<breakfastArray.size()-1) {
            currentIndex++;
            nameTextField.setText(recipeList.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(recipeList.get(currentIndex).getIngredients());
            directionsTextArea.setText(recipeList.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(recipeList.get(currentIndex).getRating()));
        }else {
            nameTextField.setText(recipeList.get(0).getRecipeName());
            ingredientsTextArea.setText(recipeList.get(0).getIngredients());
            directionsTextArea.setText(recipeList.get(0).getDirections());
            ratingTextField.setText(String.valueOf(recipeList.get(0).getRating()));
            currentIndex = 0;
        }

    }

    //A method used to switch to the previous recipe object stored in the breakfastArray
    public void backOneBreakfast() {
        if(currentIndex>0) {
            currentIndex--;
            nameTextField.setText(breakfastArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(breakfastArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(breakfastArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(breakfastArray.get(currentIndex).getRating()));
        }else if(currentIndex == 0) {
            currentIndex = breakfastArray.size() - 1;
            nameTextField.setText(breakfastArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(breakfastArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(breakfastArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(breakfastArray.get(currentIndex).getRating()));
        }
    }

    //A method used to switch to the previous recipe object stored in the lunchArray
    public void backOneLunch() {
        if(currentIndex>0) {
            currentIndex--;
            nameTextField.setText(lunchArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(lunchArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(lunchArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(lunchArray.get(currentIndex).getRating()));
        }else if(currentIndex == 0) {
            currentIndex = lunchArray.size() - 1;
            nameTextField.setText(lunchArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(lunchArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(lunchArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(lunchArray.get(currentIndex).getRating()));
        }
    }

    //A method used to switch to the previous recipe object stored in the dinnerArray
    public void backOneDinner() {
        if(currentIndex>0) {
            currentIndex--;
            nameTextField.setText(dinnerArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(dinnerArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(dinnerArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(dinnerArray.get(currentIndex).getRating()));
        }else if(currentIndex == 0) {
            currentIndex = dinnerArray.size() - 1;
            nameTextField.setText(dinnerArray.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(dinnerArray.get(currentIndex).getIngredients());
            directionsTextArea.setText(dinnerArray.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(dinnerArray.get(currentIndex).getRating()));
        }
    }

    //A method used to switch to the previous recipe object stored in the recipeList
    public void backOneRecipe() {
        if(currentIndex>0) {
            currentIndex--;
            nameTextField.setText(recipeList.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(recipeList.get(currentIndex).getIngredients());
            directionsTextArea.setText(recipeList.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(recipeList.get(currentIndex).getRating()));
        }else if(currentIndex == 0) {
            currentIndex = recipeList.size() - 1;
            nameTextField.setText(recipeList.get(currentIndex).getRecipeName());
            ingredientsTextArea.setText(recipeList.get(currentIndex).getIngredients());
            directionsTextArea.setText(recipeList.get(currentIndex).getDirections());
            ratingTextField.setText(String.valueOf(recipeList.get(currentIndex).getRating()));
        }
    }
    //A method used to switch from the current scene to Scene1.fxml
    public void switchToScene1(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Scene1.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}