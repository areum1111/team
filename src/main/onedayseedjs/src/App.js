import React,{Component} from "react";
import Profile from "./components/Profile";
import Cart from "./components/Cart";
import Hello from "./Hello";
import './App.css';
import {Route, Routes} from "react-router-dom";

class App extends Component {
  render() {
    return (
      <div className = "App">
        <Routes>
            <Route exact path='/hello' Component={Hello} />
            <Route exact path='/user' Component={Profile} />
            <Route exact path='/cart' Component={Cart} />
        </Routes>
      </div>
    );
  }
}

export default App;