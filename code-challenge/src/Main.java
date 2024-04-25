import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc;
    static List<Movie> movieList;
    public static void main(String[] args) {
        sc = new Scanner(System.in);


        doLogin();
        welcomeToDashboard();
    }

    public static void doLogin(){
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("Choose an option:");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            User user = new User(email);
            System.out.println("You are logged in!");
            welcomeToDashboard();
        } else if (option == 2) {
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            User user = new User(email);
            System.out.println("You are registered and logged in!");
        }
        initializeMovies();
    }
    public static void searchMovies() {

        System.out.println("Enter the search term:");
        String searchTerm = sc.nextLine();
        System.out.println("Search results for " + searchTerm + ":");
        // search for movies
    }

    public static void welcomeToDashboard() {
        boolean leave = false;
        while (!leave) {
            System.out.println("Welcome to the dashboard!");
            System.out.println("1. Search movies");
            System.out.println("2. View movies");
            System.out.println("3. Add movie");
            System.out.println("4. Logout");
            System.out.println("Choose an option:");
            int option = sc.nextInt();
            sc.nextLine();
            if (option == 1) {
                searchMovies();
            } else if (option == 2) {
                 viewMovies();
            } else if (option == 3) {
                 addMovie();
            } else if (option == 4) {
                leave = true;
            }
        }
    }

    public static void initializeMovies() {
        movieList = new ArrayList<>();
        movieList.add(new Movie("1", "The Shawshank Redemption", "Tim Robbins, Morgan Freeman", "Drama", "14/10/1994", "$25 million"));
        movieList.add(new Movie("2", "The Godfather", "Marlon Brando, Al Pacino", "Crime", "24/03/1972", "$6 million"));
        movieList.add(new Movie("3", "The Dark Knight", "Christian Bale, Heath Ledger", "Action", "18/07/2008", "$185 million"));
        movieList.add(new Movie("4", "The Lord of the Rings: The Return of the King", "Elijah Wood, Viggo Mortensen", "Fantasy", "17/12/2003", "$94 million"));
        movieList.add(new Movie("5", "Pulp Fiction", "John Travolta, Uma Thurman", "Crime", "14/10/1994", "$8 million"));
    }
    public static void viewMovies() {
        System.out.println("Movies:");
        for (Movie movie : movieList) {
            System.out.println("ID: " + movie.getId());
            System.out.println("Title: " + movie.getTitle());
            System.out.println("Cast: " + movie.getCast());
            System.out.println("Category: " + movie.getCategory());
            System.out.println("Release Date: " + movie.getReleaseDate());
            System.out.println("Budget: " + movie.getBudget());
            System.out.println("-------------------------------");
        }
    }
    public static void addMovie() {
        System.out.println("Enter the movie title:");
        String title = sc.nextLine();
        System.out.println("Enter the cast:");
        String cast = sc.nextLine();
        System.out.println("Enter the category:");
        String category = sc.nextLine();
        System.out.println("Enter the release date:");
        String releaseDate = sc.nextLine();
        System.out.println("Enter the budget:");
        String budget = sc.nextLine();
        Movie movie = new Movie(String.valueOf(movieList.size() + 1), title, cast, category, releaseDate, budget);
        movieList.add(movie);
        System.out.println("Movie added successfully!");
    }

}