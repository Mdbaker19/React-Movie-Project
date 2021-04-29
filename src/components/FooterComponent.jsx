import React, {Component} from 'react';

class FooterComponent extends Component {
    render() {
        return (
            <div>
                <footer className="page-footer">
                    <div className="container">
                        <div className="row">
                            <div className="col l6 s12">
                                <h5>Footer Content</h5>
                                <p className="grey-text text-lighten-4">You can use rows and columns here to organize
                                    your footer content.</p>
                            </div>
                            <div className="col l4 offset-l2 s12">
                                <h5>Links</h5>
                                <ul>
                                    <li><a href="#!">Link 1</a></li>
                                    <li><a href="#!">Link 2</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div className="footer-copyright">
                        <div className="container">
                            © 2014 Copyright Text
                            <a className="right" href="#!">More Links</a>
                        </div>
                    </div>
                </footer>
            </div>
        );
    }
}

export default FooterComponent;