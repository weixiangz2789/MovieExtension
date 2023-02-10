import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<SimpleMovie> movies = MovieDatabaseBuilder.getMovieDB("src/movie_data");
//        for (SimpleMovie movie : movies) {
//            System.out.println(movie);
//        }
//        System.out.println("Number of movies: " + movies.size());
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> baconIdxList = new ArrayList<>();
        for (int i = 0; i < movies.size(); i ++){
            if (movies.get(i).getActors().contains("Kevin Bacon")){
                baconIdxList.add(i);
            }
        }
        String actor = "";
        while (!(actor.equals("q"))){
            System.out.print("Enter an actor's name or (q) to quit: ");
            actor = scan.nextLine();
            ArrayList<Integer> actorIdxList = new ArrayList<>();
            for (int i = 0; i < movies.size(); i ++){
                if (movies.get(i).getActors().contains(actor)){
                    actorIdxList.add(i);
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < actorIdxList.size(); i ++){
                for (int x = 0; x < baconIdxList.size(); x ++){
                    int diff1 = baconIdxList.get(x) - actorIdxList.get(i);
                    int diff2 = actorIdxList.get(i) - baconIdxList.get(x);
                    if (diff1 < min && diff1 > 0){
                        min = diff1;
                    }
                    if (diff2 < min && diff2 > 0){
                        min = diff2;
                    }
                }
            }
            System.out.println(baconIdxList);
            System.out.println(actorIdxList);
            if (min == Integer.MAX_VALUE){
                System.out.println("No Results Found");
            }
            else{
                System.out.println("Bacon Number of " + min);
            }
        }
    }
}