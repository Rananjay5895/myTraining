package co.incubyte.co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    private final String name;
    private final String image;
    private final String date;
    private final float rating;
    private final int count;
    private int id;

    public Movie(@JsonProperty("title") String name, @JsonProperty("poster_path") String image, @JsonProperty("release_date") String date, @JsonProperty("vote_average") float rating, @JsonProperty("vote_count") int count ,@JsonProperty("id") int id) {
        this.name = name;
        this.image = image;
        this.date = date;
        this.rating = rating;
        this.count = count;
        this.id = id;
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

    public float getRating() {
        return rating;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }
}
