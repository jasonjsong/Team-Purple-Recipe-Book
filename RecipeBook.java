import java.util.*;

public class RecipeBook extends recipe{

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

    //Welcome user and let them know what actions they can take as of right now
    System.out.println("\nWelcome to Team Purple's Recipe Book! \n===================================");
    System.out.println("Do you wish to: \n1. 'R'ead through all recipes,\n2. 'A'dd a new recipe,\n3. 'S'earch through the existing cookbook,\n4. 'Q'uit the program?");
    System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
    String userInput = "";
    do {
      userInput = readInput.nextLine();

      if (userInput.equalsIgnoreCase("r")){
        System.out.println("===================================");
        for (int i = 0; i < book.size(); i ++){
          System.out.println(book.get(i).title);
        }
        System.out.println("====================================");
        System.out.println("Type the name of a recipe you would like to open, or type 'BACK' to return to the home menu: ");
        String openRecipe = readInput.nextLine();
        for (int i = 0; i < book.size(); i ++){
          if(book.get(i).title.equalsIgnoreCase(openRecipe)){
            System.out.println(book.get(i).title);
            System.out.println("Description: " + book.get(i).description);
            // tried to do this, the ingredients and steps are some weird thing,
            // might need to do a loop for each one to show each individual ingredient and step
            System.out.println("Ingredients: \n" + book.get(i).ingredients);
            System.out.println("Steps: \n" + book.get(i).steps);
          }
          else if (openRecipe.equalsIgnoreCase("back")) {
            System.out.println("Exiting out of Read through all recipes. Returning to the home menu now...\n");
            break;
          }
        }

        System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
      }
      else if (userInput.equalsIgnoreCase("a")) {
        System.out.println("Creating new recipe... ");
        System.out.println("Please enter the recipe title");
        String recipeTitle = readInput.nextLine();
        System.out.println("Please enter the recipe Description");
        String recipeDesc = readInput.nextLine();
        String nextIng = "";
        while (!(nextIng.equalsIgnoreCase("done"))){
          System.out.println("Please enter the next Ingredient or type DONE to move on");
          nextIng = readInput.nextLine();
               //TODO: add input to add ingredients
        }
        String nextStep = "";
        while (!(nextStep.equalsIgnoreCase("done"))){
          System.out.println("Please enter the next Step, or type DONE to move on");
          nextStep = readInput.nextLine();
               //TODO: add input to add steps
        }
        //TODO: add input to add these variables to recipe object

        System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
      }
      else if (userInput.equalsIgnoreCase("s")) {
        System.out.print("\nSearching through existing recipes...\nType in exactly what you want to search for: ");
        String searching = readInput.nextLine();
        System.out.println("Searching for " + searching + "...\nOne moment please...");
        // ADD: search function

        System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
      }
      else if (userInput.equalsIgnoreCase("q")) {
        System.out.println("\nExiting out of Team Purple's Recipe Book. See you soon!");
        System.exit(0);
      }
      else {
        // Go back to beginning if user input anything else besides 'a' 's' or 'q'
        System.out.print("Invalid input. You may:\nType 'r' to read through the recipe book,\nType 'a' to add a recipe,\nType 's' to search the recipe book,\nType 'q' to quit of the program.");
        System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
        continue;
      }
    }
    while (!userInput.equalsIgnoreCase("q"));
    readInput.close();
  }
}
