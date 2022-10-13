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
// Code for reading recipes
      if (userInput.equalsIgnoreCase("r")){
        System.out.println("===================================");
        for (int i = 0; i < book.size(); i ++){
          System.out.println(book.get(i).title);
        }
        System.out.println("====================================");
        System.out.println("Type the name of a recipe you would like to open, or type 'BACK' to return to the home menu: ");
        String openRecipe = readInput.nextLine();
        if (!openRecipe.equalsIgnoreCase("back")){
        int recipeIndex = 0;
        for (int i = 0; i < book.size(); i ++){
          if(book.get(i).title.equalsIgnoreCase(openRecipe)){
              recipeIndex = i;
          }
          else if (i == book.size()){
            System.out.println("No recipe found");
          }
        }
        if (recipeIndex == -1) break;
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
              if (stepsuser.equalsIgnoreCase("all")){
                for(int a = w; a < book.get(recipeIndex).steps.length; a++){
                  System.out.println(book.get(recipeIndex).steps[a]);
                }
                break;
              }
              else
                System.out.println(book.get(recipeIndex).steps[w]);
            
          }
        }
        System.out.println("Do you wish to: \n1. 'R'ead through all recipes,\n2. 'A'dd a new recipe,\n3. 'S'earch through the existing cookbook,\n4. 'Q'uit the program?");
        System.out.print("\nEnter 'r', 'a', 's', or 'q' here: ");
        
// Code for adding Recipes
      }
      else if (userInput.equalsIgnoreCase("a")) {
        System.out.println("Creating new recipe... ");
        System.out.println("Please enter the recipe title");
        String recipeTitle = readInput.nextLine();
        System.out.println("Please enter the recipe Description");
        String recipeDesc = readInput.nextLine();
        String nextIng = "";
        System.out.println("Please enter the number of ingredients (numbers, not words!)");
// Code for adding Ingredients
        int numIng = Integer.parseInt(readInput.nextLine());
        System.out.println("Your recipe has " + numIng + " ingredients");
        String[] recipeIng = new String[numIng];
        int ingredientcount = 0;
          while(ingredientcount != numIng){ 
          System.out.println("Please enter the next Ingredient");
          nextIng = readInput.nextLine();
          recipeIng[ingredientcount] = nextIng;
          ingredientcount++;
        }
// Code for adding Steps
        System.out.println("Please enter the number of steps (numbers, not words!)");
        int numSteps = Integer.parseInt(readInput.nextLine());
        String nextStep = "";
        String[] recipeSteps = new String[numSteps];
        int stepcount = 0;
          while(stepcount != numSteps){ 
          System.out.println("Please enter the next Step");
          nextStep = readInput.nextLine();
          recipeSteps[stepcount] = nextStep;
          stepcount++;
        }
        book.add(new recipe(recipeTitle, recipeDesc, recipeIng, recipeSteps));
        System.out.println("Do you wish to: \n1. 'R'ead through all recipes,\n2. 'A'dd a new recipe,\n3. 'S'earch through the existing cookbook,\n4. 'Q'uit the program?");
      }
      else if (userInput.equalsIgnoreCase("s")) {
//Code for Search Function
        System.out.print("\nSearching through existing recipes...\nType in exactly what you want to search for: ");
        String openRecipe = readInput.nextLine();
        System.out.println("Searching for " + openRecipe + "...\nOne moment please...");
        // ADD: search function
        if (!openRecipe.equalsIgnoreCase("back")){
        int recipeIndex = 0;
        for (int i = 0; i < book.size(); i ++){
          if(book.get(i).title.equalsIgnoreCase(openRecipe)){
              recipeIndex = i;
              break;
          }
          else if (i == book.size()){
            System.out.println("No recipe found");
          }
          else{
            for (String word : book.get(i).description.split(" ")){
              if (word.equalsIgnoreCase(openRecipe)){
                recipeIndex = i;
                break;
              }
            }
            for (String ingredient : book.get(i).ingredients){
                if (ingredient.equalsIgnoreCase(openRecipe)){
                  recipeIndex = i;
                  break;
                }
              
            }
            for (String step : book.get(i).steps){
              for (String word : step.split(" ")){
                if (word.equalsIgnoreCase(openRecipe)){
                  recipeIndex = i;
                  break;
                }
              }
            }
          }
        }
        if (recipeIndex == -1) break;
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
              if (stepsuser.equalsIgnoreCase("all")){
                for(int a = w; a < book.get(recipeIndex).steps.length; a++){
                  System.out.println(book.get(recipeIndex).steps[a]);
                }
                break;
              }
              else
                System.out.println(book.get(recipeIndex).steps[w]);
            
          }
        }
        System.out.println("Do you wish to: \n1. 'R'ead through all recipes,\n2. 'A'dd a new recipe,\n3. 'S'earch through the existing cookbook,\n4. 'Q'uit the program?");
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
