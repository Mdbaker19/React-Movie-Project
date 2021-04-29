import React, {Component} from 'react';
import MovieService from "../service/MovieService";

class ViewMovieComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: this.props.match.params.id,
            title: "",
            rating: "",
            genre: ""
        }
    }

    componentDidMount() {
        if(this.state.id) {
            MovieService.getById(this.state.id).then( res => {
                let movie = res.data;
                this.setState({
                    title: movie.title,
                    rating: movie.rating,
                    genre: movie.genre
                });
            });
        }
    }

    render() {
        return (
            <div key={this.state.id}>
                <h3>{this.state.title}</h3>
                <p>{this.state.genre}</p>
                <p>{this.state.rating}</p>
            </div>
        );
    }
}

export default ViewMovieComponent;