import axios from "axios";

const MOVIE_URL = "http://localhost:8080/movies-api/";

class MovieService {

    getAllMovies() {
        return axios.get(`${MOVIE_URL}movies`);
    }

    getById(id) {
        return axios.get(`${MOVIE_URL}movies/${id}`);
    }

}

export default new MovieService();