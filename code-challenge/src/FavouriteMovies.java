public class FavouriteMovies {
    private String userEmail;
    private String movieId;

    public FavouriteMovies(String userEmail, String movieId) {
        this.userEmail = userEmail;
        this.movieId = movieId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getMovieId() {
        return movieId;
    }
}
