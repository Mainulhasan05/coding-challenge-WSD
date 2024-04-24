import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        show a menu to login or register

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

    }
// write a function to show a welcoming with menu for Search all the movies in the app. Users can search for either title, cast or category and all
//matching movies
    public static void searchMovies() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the search term:");
        String searchTerm = sc.nextLine();
        System.out.println("Search results for " + searchTerm + ":");
        // search for movies
    }
// write a function to show a welcoming with menu for Search all the movies in the app. Users can search for either title, cast or category and all
    public static void welcomeToDashboard() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the dashboard!");
        System.out.println("1. Search all movies");
        System.out.println("2. Search movies by category");
        System.out.println("3. Search movies by cast");
        System.out.println("Choose an option:");
        int option = sc.nextInt();
        sc.nextLine();
        if (option == 1) {
            searchMovies();
        } else if (option == 2) {
//            searchMoviesByCategory();
        } else if (option == 3) {
//            searchMoviesByCast();
        }
    }

}