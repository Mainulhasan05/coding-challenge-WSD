import java.util.*;

public class Main {
    static Scanner sc;
    static List<Movie> movieList;
    static List<FavouriteMovies> favouriteMoviesList;
    static User user;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        initializeMovies();


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
            user = new User(email);
            System.out.println("You are logged in!");
            welcomeToDashboard();
        } else if (option == 2) {
            System.out.println("Enter your email:");
            String email = sc.nextLine();
            User user = new User(email);
            System.out.println("You are registered and logged in!");
        }

    }


    public static void welcomeToDashboard() {
        boolean leave = false;
        while (!leave) {
            System.out.println("Welcome to the dashboard!");

            System.out.println("1. View movies");
            System.out.println("2. Add movie");
            System.out.println("3. Search movies");
            System.out.println("4. Add favourite");
            System.out.println("5. Remove favourite");
            System.out.println("6. View favourites");
            System.out.println("7. View profile");
            System.out.println("8. View Movie Details");
            System.out.println("9. Search Movies on Favorites");
            System.out.println("10. Exit");



            System.out.println("Choose an option:");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option) {
                case 1:
                    viewMovies();
                    break;
                case 2:
                    addMovie();
                    break;
                case 3:
                    searchMovies();
                    break;
                case 4:
                    addFavourite();
                    break;
                case 5:
                    removeFavourite();
                    break;
                case 6:
                    viewFavourites();
                    break;
                case 7:
                    viewProfile();
                    break;
                case 8:
                    viewMovieDetails();
                    break;
                case 9:
                    searchFavoutieMovies();
                    break;
                case 10:
                    leave = true;
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        }
    }

    public static void initializeMovies() {
        favouriteMoviesList = new ArrayList<>();
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

    public static void searchMovies() {
        System.out.println("Enter the search term:");
        String searchTerm = sc.nextLine();
        System.out.println("Search results:");

        Collections.sort(movieList, Comparator.comparing(Movie::getTitle));

        for (Movie movie : movieList) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getId().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getCast().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("ID: " + movie.getId());
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("Category: " + movie.getCategory());
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Budget: " + movie.getBudget());
                System.out.println("-------------------------------");
            }
        }
    }
    public static void searchFavoutieMovies() {
        System.out.println("Enter the search term:");
        String searchTerm = sc.nextLine();
//        get all movies information from favouriteMoviesList
        List<Movie> favouriteMovies=new ArrayList<>();
        for (FavouriteMovies favouriteMovies1 : favouriteMoviesList) {
            for (Movie movie : movieList) {
                if (movie.getId().equals(favouriteMovies1.getMovieId())) {
                    favouriteMovies.add(movie);
                }
            }
        }

        System.out.println("Search results:");
        for (Movie movie : favouriteMovies) {
            if (movie.getTitle().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getId().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getCast().toLowerCase().contains(searchTerm.toLowerCase()) ||
                    movie.getCategory().toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("ID: " + movie.getId());
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("Category: " + movie.getCategory());
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Budget: " + movie.getBudget());
                System.out.println("-------------------------------");
            }
        }
    }
    public static void viewMovieDetails(){
        System.out.println("Enter the movie ID:");
        String movieId = sc.nextLine();
        for (Movie movie : movieList) {
            if (movie.getId().equals(movieId)) {
                System.out.println("ID: " + movie.getId());
                System.out.println("Title: " + movie.getTitle());
                System.out.println("Cast: " + movie.getCast());
                System.out.println("Category: " + movie.getCategory());
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Budget: " + movie.getBudget());
                System.out.println("-------------------------------");
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public static void addFavourite() {
        System.out.println("Enter the movie ID:");
        String movieId = sc.nextLine();
//        check if the movie is already in the favourite list
        for (FavouriteMovies favouriteMovies : favouriteMoviesList) {
            if (favouriteMovies.getMovieId().equals(movieId)) {
                System.out.println("Movie already in favourites!");
                return;
            }
        }
        FavouriteMovies favouriteMovies = new FavouriteMovies(user.getEmail(), movieId);
        favouriteMoviesList.add(favouriteMovies);
        System.out.println("Movie added to favourites!");
    }

    public static void removeFavourite() {
        System.out.println("Enter the movie ID:");
        String movieId = sc.nextLine();
        for (FavouriteMovies favouriteMovies : favouriteMoviesList) {
            if (favouriteMovies.getMovieId().equals(movieId)) {
                favouriteMoviesList.remove(favouriteMovies);
                System.out.println("Movie removed from favourites!");
                return;
            }
        }
        System.out.println("Movie not found in favourites!");
    }

    public static void viewFavourites() {
        System.out.println("Favourites:");
        for (FavouriteMovies favouriteMovies : favouriteMoviesList) {
            System.out.println("User Email: " + favouriteMovies.getUserEmail());

            for (Movie movie : movieList) {
                if (movie.getId().equals(favouriteMovies.getMovieId())) {
                    System.out.println("ID: " + movie.getId());
                    System.out.println("Title: " + movie.getTitle());
                    System.out.println("Cast: " + movie.getCast());
                    System.out.println("Category: " + movie.getCategory());
                    System.out.println("Release Date: " + movie.getReleaseDate());
                    System.out.println("Budget: " + movie.getBudget());
                    System.out.println("-------------------------------");
                }
            }
        }
    }

    public static void viewProfile() {
        System.out.println("User Email: " + user.getEmail());
        System.out.println("Favourites:");
        for (FavouriteMovies favouriteMovies : favouriteMoviesList) {
            System.out.println("User Email: " + favouriteMovies.getUserEmail());
            System.out.println("Movie ID: " + favouriteMovies.getMovieId());
            System.out.println("-------------------------------");
        }
    }




}