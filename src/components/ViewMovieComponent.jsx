import React, {Component} from 'react';
import MovieService from "../service/MovieService";

const posterURL = "https://image.tmdb.org/t/p/w400";


class ViewMovieComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            title: "",
            rating: "",
            genre: "",
            overview: "",
            releaseDate: "",
            image: ""
        }
    }

    componentDidMount() {
        if(this.state.id > 0) {
            MovieService.getById(this.state.id).then( res => {
                let movie = res.data;
                this.setState({
                    title: movie.title,
                    rating: movie.rating,
                    genre: movie.genre,
                    releaseDate: movie.releaseDate,
                    overview: movie.overview,
                    image: posterURL + movie.imageUrl
                });
                console.log(this.state);
            });
        }
    }

    render() {
        return (
            <div key={this.state.id}>
                <img src={this.state.image} alt="movieImage"/>
                <h3>{this.state.title}</h3>
                <p>Genre Id : {this.state.genre} (parsing difficulty)</p>
                <p>{this.state.rating}</p>
                <p>{this.state.releaseDate}</p>
                <p>Partial Desc : {this.state.overview} (parsing difficulty)</p>
            </div>
        );
    }
}

export default ViewMovieComponent;