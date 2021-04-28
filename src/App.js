import React from 'react';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import './App.css';
import HeaderComponent from "./components/HeaderComponent";
import ListMoviesComponent from "./components/ListMoviesComponent";
import FooterComponent from "./components/FooterComponent";

function App() {
  return (
    <div className="App">
        <Router>

            <HeaderComponent/>

            <div className="container">

                <Switch>
                    <Route path="/" exact component={ListMoviesComponent}/>
                </Switch>

            </div>

            <FooterComponent/>


        </Router>
    </div>
  );
}

export default App;
