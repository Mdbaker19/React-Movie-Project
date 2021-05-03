import React, {Component} from 'react';

class CreateAndViewComponent extends Component {
    render() {
        return (

            <div className="row">
                <form className="col s12">
                    <div className="row">
                        <div className="input-field col s12">
                            <input id="title" type="text" className="validate" />
                                <label htmlFor="title">Title</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input id="rating" type="number" className="validate" />
                                <label htmlFor="rating">Rating</label>
                        </div>
                    </div>
                    <div className="row">
                        <div className="input-field col s12">
                            <input id="genre" type="text" className="validate" />
                                <label htmlFor="genre">Genre</label>
                        </div>
                    </div>
                    <button className="btn waves-effect waves-light">Submit</button>
                </form>
            </div>
        );
    }
}

export default CreateAndViewComponent;