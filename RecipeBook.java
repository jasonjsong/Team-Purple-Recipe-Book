import java.util.*;

public class RecipeBook extends recipe{

  public static void main(String[] args) {
    Scanner readInput = new Scanner(System.in);
    Scanner inputFromUser = new Scanner(System.in);

    ArrayList<recipe> book = new ArrayList<recipe>();

    String[] ingredientsForOmelete = {"eggs", "cheese", "butter"};
    String[] ingredientsForHamburger = {"ground beef", "tomato", "lettuce", "onion", "butter"};
    String[] ingredientsForPizza = {"eggs", "flour", "sauce", "cheese", "basil"};

    String[] stepsForOmelete = {"Crack eggs into bowl", "Whisk eggs", "Pour into hot pan", "Wait"};
    String[] stepsForHamburger = {"Place bottom bun", "Place lettuce", "Place tomato", "Place burger", "Place cheese", "Top bun"};
    String[] stepsForPizza = {"Stretch dough", "Spread sauce", "Sprinkle cheese", "Bake in oven"};

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
        int recipeIndex = 0;
        for (int i = 0; i < book.size(); i ++){
          if(book.get(i).title.equalsIgnoreCase(openRecipe)){
              recipeIndex = i;
          }
          else{
            System.out.println("No recipe found");
          }
        }
        System.out.println(book.get(recipeIndex).title);
        System.out.println("Description: " + book.get(recipeIndex).description + "\n");
        System.out.println("Ingredients: \n");
          for(int q = 0; q < book.get(recipeIndex).ingredients.length; q++){
              System.out.println(book.get(recipeIndex).ingredients[q]);
          }
          System.out.println("\nPress enter to see the next step. Or type 'All' to see all of the steps");
          String stepsuser = "";
          for(int w = 0; w < book.get(recipeIndex).steps.length; w++){
              stepsuser = inputFromUser.nextLine();    
              if (stepsuser == "All"){
                for(int a = w; a < book.get(recipeIndex).steps.length; a++){
                  System.out.println(book.get(recipeIndex).steps[a]);
                }
                break;
              }
              else
                System.out.println(book.get(recipeIndex).steps[w]);
            
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
    }
    while (!userInput.equalsIgnoreCase("q"));
    readInput.close();
    inputFromUser.close();
  }
}
