import React, {Component} from "react";

class ListMoviesComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            movies : []
        }
    }

    componentDidMount() {
        let obj = [{
            title: "first",
            id: 1
        }, {title: "second",
            id: 2},
            {title: "third",
            id: 3}]
        this.setState( {
            movies: obj
        });
    }

    render() {
        return (
            <div>
                {
                    this.state.movies.map((movie, idx) => {
                       return <div key={movie.id}>
                           <p>{movie.title}</p>
                       </div>
                    })
                }
            </div>
        );
    }
}

export default ListMoviesComponent;