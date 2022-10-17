package co.incubyte.co.incubyte;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TmdbResponse {
    private int page;

    private List<Movie> results;

    public TmdbResponse(@JsonProperty("page") int page,@JsonProperty("results") List<Movie> results) {
        this.page = page;
        this.results = results;
    }

    public int getPage() {
        return page;
    }

    public List<Movie> getResults() {
        return results;
    }
}
