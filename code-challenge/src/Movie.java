public class Movie {
//   id, title, cast, category, release date, budget.
    private String id;
    private String title;
    private String cast;
    private String category;
    private String releaseDate;
    private String budget;

    public Movie(String id, String title, String cast, String category, String releaseDate, String budget) {
        this.id = id;
        this.title = title;
        this.cast = cast;
        this.category = category;
        this.releaseDate = releaseDate;
        this.budget = budget;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCast() {
        return cast;
    }

    public String getCategory() {
        return category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getBudget() {
        return budget;
    }
}
