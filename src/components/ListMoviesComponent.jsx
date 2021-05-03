import React, {Component} from "react";
import MovieService from "../service/MovieService";

class ListMoviesComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            movies : []
        }

        this.view = this.view.bind(this);
    }

    componentDidMount() {
        MovieService.getAllMovies().then(res => {
            this.setState( {
                movies: res.data
            });
        });
    }

    view(id) {
        this.props.history.push(`movies/${id}`);
    }

    render() {
        return (
            <div>
                {
                    this.state.movies.map((movie, idx) => {
                        return <div className="card" key={movie.id}>
                                 <h3 className="card-title center-align">{movie.title}</h3>
                                 <p className="center-align">{movie.genre}</p>
                                 <p className="center-align">{movie.rating}</p>
                                 <div className="card-action">
                                    <button onClick={ () => this.view(movie.id)}>View More</button>
                                 </div>
                               </div>
                    })
                }
            </div>
        );
    }
}

export default ListMoviesComponent;