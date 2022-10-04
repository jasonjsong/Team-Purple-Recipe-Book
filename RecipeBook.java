import java.util.*;

public class RecipeBook {

  public static void main(String[] args) {
    Scanner readInput = new Scanner(System.in);

    ArrayList<recipe> book = new ArrayList<recipe>();
    
    String[] ingredientsForOmelete = {"eggs", "cheese", "butter"};
    String[] ingredientsForHamburger = {"ground beef", "tomato", "lettuce", "onion", "butter"};
    String[] ingredientsForPizza = {"eggs", "flour", "sauce", "cheese", "basil"};

    String[] stepsForOmelete = {};
    String[] stepsForHamburger = {};
    String[] stepsForPizza = {};

    //Starting 3 recipes for the book
    recipe recipe1 = new recipe("Omelete", "Quick and easy breakfast!", ingredientsForOmelete, stepsForOmelete);
    recipe recipe2 = new recipe("Hamburgers", "Delicious burgers for any time of year.", ingredientsForHamburger, stepsForHamburger);
    recipe recipe3 = new recipe("Pizza", "Great for parties!", ingredientsForPizza, stepsForPizza);

    //adding the recipes to the book
    book.add(recipe1);
    book.add(recipe2);
    book.add(recipe3);

    System.out.println("Do you wish to add a new recipe, or search through the existing cookbook?\nPress 'A' to add a new recipe, or 'S' to search: ");
    String addOrSearch = readInput.nextLine();
    if (addOrSearch.equals("A")) {
      System.out.println("Creating new recipe: ");
      System.out.println("Please enter the recipe title");
      String recipeTitle = readInput.nextLine();
      System.out.println("Please enter the recipe Description");
      String recipeDesc = readInput.nextLine();
      String nextIng;
      while (nextIng != "done"){
        System.out.println("Please enter the next Ingredient or type DONE to move on");
        String nextIng = readInput.nextLine();
             //TODO: add input to add ingredients
      }
      String nextStep;
      while (nextStep != "done"){
        System.out.println("Please enter the next Step, or type DONE to move on");
        String nextIng = readInput.nextLine();
             //TODO: add input to add steps
      }
      //TODO: add input to add these variables to recipe object
    }
    if (addOrSearch.equals("S")) {
      System.out.println("Type in what you want to search for, then press Enter: ");
      String searching = readInput.nextLine();
      System.out.println("Searching for " + searching);
    }
    
    public sortAlphabetically(ArrayList recipes){
        //length = size(recipes);
        //for (i=0; i<recipes; i++){ }
        recipes = Collections.sort(recpies);
    }
  }
}

public class recipe{
    String title;
    String description;
    String[] ingredients;
    String[] steps;
    
    public recipe(){
    }

    public recipe(String title1, String description1, String[] ingredients1, String[] steps1){
        title = title1;
        description = description1;
        ingredients = ingredients1;
        steps = steps1;
    }
}
