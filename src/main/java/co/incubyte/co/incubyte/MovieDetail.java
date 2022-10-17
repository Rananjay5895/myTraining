package co.incubyte.co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieDetail {

    private final int id;
    private String name;
    private String image;
    private String date;
    private int count;
    private float rating;
    private String description;
    private String backgroundImage;
    private float popularity;
    private String language;

    public MovieDetail(@JsonProperty("id") int id, @JsonProperty("title") String name, @JsonProperty("poster_path") String image, @JsonProperty("release_date") String date, @JsonProperty("vote_average") float rating, @JsonProperty("vote_count") int count, @JsonProperty("overview") String description, @JsonProperty("backdrop_path") String backgroundImage, @JsonProperty("popularity") float popularity, @JsonProperty("original_language") String language) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.date = date;
        this.rating = rating;
        this.count = count;
        this.description = description;
        this.backgroundImage = backgroundImage;
        this.popularity = popularity;
        this.language = language;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDate() {
        return date;
    }

    public int getCount() {
        return count;
    }

    public float getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public String getBackgroundImage() {
        return backgroundImage;
    }

    public float getPopularity() {
        return popularity;
    }

    public String getLanguage() {
        return language;
    }
}
