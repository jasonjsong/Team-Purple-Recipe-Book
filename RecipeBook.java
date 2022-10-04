import java.util.*;

public class RecipeBook {

  public static void main(String[] args) {
    Scanner readInput = new Scanner(System.in);

    ArrayList<recipe> book = new ArrayList<recipe>();

    System.out.println("Do you wish to add a new recipe, or search through the existing cookbook?\nPress 'A' to add a new recipe, or 'S' to search: ");
    String addOrSearch = readInput.nextLine();
    if (addOrSearch.equals("A")) {
      System.out.println("Creating new recipe: ");
      //TODO: add more input options for title, description, etc. once Recipe Object is created
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
    ArrayList<String> ingredients = new ArrayList<String>();
    ArrayList<String> steps = new ArrayList<String>();
    
    public recipe(){
    }

    public recipe(String title, String description, ArrayList ingredients, ArrayList steps){
        title = title;
        description = description;
        ingredients = ingredients;
        steps = steps;
    }
}
