package com.movie.reactspringmovie.controller;

import com.movie.reactspringmovie.exception.NotFound;
import com.movie.reactspringmovie.model.Movie;
import com.movie.reactspringmovie.repository.MovieRepository;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies-api")
public class MovieController {

    private MovieRepository movieDao;

    @Value("${movieKey}")
    private String movieApiKey;


    public MovieController(MovieRepository movieDao){
        this.movieDao = movieDao;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieDao.findAll();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") long id) throws IOException, InterruptedException, JSONException {
        Movie movie = movieDao.findById(id).orElseThrow( () -> new NotFound("No Movie found with id " + id));
        StringBuilder s = new StringBuilder();
        String endPoint = "https://api.themoviedb.org/3/search/movie?api_key="+movieApiKey.substring(1, movieApiKey.length() - 2)+"&query=";
        for(String title : movie.getTitle().split(" ")) {
            s.append(title).append("+");
        }
        String built = s.toString();
        String makeRequest = requestToApi(endPoint + built.substring(0, built.length() - 1));
        List<String> bucket = getJsonData(makeRequest);
        System.out.println(bucket);
        movie.setImageUrl(getPostPathURL(bucket));
        movie.setOverview(getOverview(bucket));
        movie.setReleaseDate(getReleaseDate(bucket));
        movie.setGenre(getGenre(bucket));
        movie.setRating(getRating(bucket));
        movieDao.save(movie);
        return ResponseEntity.ok(movie);
    }

    private String requestToApi(String endPointWithTitle) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endPointWithTitle))
                .build();

        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    private String getOverview(List<String> bucket) {
        String out = "";
        for(String s : bucket) {
            String sub = s.substring(1, s.length() - 1);
            if(sub.startsWith("overview")) out = sub;
        }
        return out.split(":")[1].substring(1);
    }

    private String getGenre(List<String> bucket) {
        String out = "";
        for(String s : bucket) {
            String sub = s.substring(1);
            if(sub.startsWith("genre_ids")) out = sub;
        }
        String res = out.split(":")[1];
        return res.substring(1);
    }

    private String getRating(List<String> bucket) {
        String out = "";
        for(String s : bucket) {
            String sub = s.substring(1);
            if(sub.startsWith("vote_average")) out = sub;
        }
        return out.split(":")[1];
    }

    private String getReleaseDate(List<String> bucket) {
        String out = "";
        for(String s : bucket) {
            String sub = s.substring(1, s.length() - 1);
            if(sub.startsWith("release_date")) out = sub;
        }
        return out.split(":")[1].substring(1);
    }

    private String getPostPathURL(List<String> bucket) {

        String out = "";
        for(String s : bucket) {
            String sub = s.substring(1, s.length() - 1);
            if(sub.startsWith("poster_path")) out = sub;
        }
        return out.split(":")[1].substring(1);
    }


    private List<String> getJsonData(String res) {
        StringBuilder data = new StringBuilder();
        int idxReq = Integer.MAX_VALUE;
        for(int i = 1; i < res.length(); i++) {
            String curr = String.valueOf(res.charAt(i));
            if(curr.equals("{")) idxReq = i;
            if(curr.equals("}")) break;
            if(i > idxReq) {
                data.append(curr);
            }
        }
        String[] arr = data.toString().split(",");
        return new ArrayList<>(Arrays.asList(arr));
    }
}
