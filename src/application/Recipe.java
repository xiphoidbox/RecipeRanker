package application;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * Recipe class is a class that will store and hold all data for a recipe object.
 * String recipeName-holds the name of the recipe object
 * String ingredients - holds a string with all ingredients for a recipe
 * String directions - holds a string with the directions to create the recipe
 * Integer rating - holds an integer between 1 and 5 that rates the recipe
 * Boolean isInBreakfast - boolean statement to say if the recipe is a breakfast recipe
 * Boolean isInLunch - boolean statement to say if the recipe is a lunch recipe
 * Boolean isInDinner - boolean statement to say if the recipe is a dinner recipe
 */
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    String recipeName;
    String ingredients;
    String directions;
    int rating;
    boolean isInBreakfast;
    boolean isInLunch;
    boolean isInDinner;
    /*
     * A constructor to initialize a blank recipe object.
     */
    public Recipe() {
        recipeName = "No Name Given";
        ingredients = "No Ingredients Given";
        directions = "No Directions Given";
        rating = 1;
        isInBreakfast = false;
        isInLunch = false;
        isInDinner = false;
    }

    //A method used to return the name of a recipe object.
    public String getRecipeName() {
        return recipeName;
    }

    //A method used to set the name of a recipe object
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    //A method used to return the ingredients of a recipe object
    public String getIngredients() {
        return ingredients;
    }

    //A method used to set the ingredients of a recipe object
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    //A method used to get the directions of a recipe object
    public String getDirections() {
        return directions;
    }

    //A method used to set the directions of a recipe object
    public void setDirections(String directions) {
        this.directions = directions;
    }

    //A method used to get the rating of a recipe object
    public int getRating() {
        return rating;
    }

    //A method used to set the rating of a of a recipe object
    public void setRating(int rating) {
        this.rating = rating;
    }

    //A method used to see if the recipe object is a breakfast recipe
    public boolean getBreakfast() {
        return isInBreakfast;
    }

    //A method used to set the recipe object to breakfast
    public void setBreakfast(boolean x) {
        this.isInBreakfast = x;
    }

    //A method used to see if the recipe object is a lunch recipe
    public boolean getLunch() {
        return isInLunch;
    }

    //A method used to set the recipe object to breakfast
    public void setLunch(boolean x) {
        this.isInLunch = x;
    }

    //A method used to see if the recipe object is a lunch recipe
    public boolean getDinner() {
        return isInDinner;
    }

    //A method used to set the recipe object to dinner
    public void setDinner(boolean x) {
        this.isInDinner = x;
    }

    /*
     * A method used to add a recipe object to a recipe ArrayList object-n in alphabetical order,
     * sorted by name of the recipe object
     */
    public void addToList(ArrayList<Recipe> n) {

        int list = n.size();

        if(n.isEmpty()) {
            n.add(this);
        }else{
            for(int i = 0; i<list; i++) {
                if(n.get(i).getRecipeName().compareTo(this.getRecipeName()) > 0) {
                    n.add(i,this);
                    break;
                }else if(i == list-1) {
                    n.add(this);
                }
            }
        }
    }

    //A method to change the isInBreakfast boolean to true
    public void addBreakfast() {
        this.setBreakfast(true);
    }

    //A method to change the isInLunch boolean to true
    public void addLunch() {
        this.setLunch(true);
    }

    //A method to change the isInDinner boolean to true
    public void addDinner() {
        this.setDinner(true);
    }

    //A method to change the isInBreakfast boolean to false
    public void removeBreakfast(ArrayList<Recipe> n, int positionInList) {
        n.get(positionInList).setBreakfast(false);
    }

    //A method to change the isInLunch boolean to false
    public void removeLunch(ArrayList<Recipe> n, int positionInList) {
        n.get(positionInList).setLunch(false);
    }

    //A method to change the isInDinner boolean to false
    public void removeDinner(ArrayList<Recipe> n, int positionInList) {
        n.get(positionInList).setDinner(false);
    }

}