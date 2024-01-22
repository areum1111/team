import React, {Component} from 'react';
//import { Link } from 'react-router-dom';
import './header.css';

class Header extends Component {
    render () {
        return(
  <>
    <nav class="navbar navbar-expand-lg" >
      <div class="container-fluid" id="nav-form">
        <a className="navbar-brand" id='logo' href="#!">OnedaySeed</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <a class="nav-link active" aria-current="page" href="#!">About Us</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#!">My Page</a>
          </li>
          {/* <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
              Dropdown
            </a>
            <ul class="dropdown-menu">
              <li><a class="dropdown-item" href="#">Action</a></li>
              <li><a class="dropdown-item" href="#">Another action</a></li>
          
              <li><a class="dropdown-item" href="#">Something else here</a></li>
            </ul>
          </li> */}
          <li class="nav-item">
            <a class="nav-link disabled" aria-disabled="true">Login</a>
          </li>
        </ul>
        <form class="d-flex" role="search">
          <input className="form-control me-2 " id="search-input" type="search" placeholder="Search" aria-label="Search" />
          <button className="btn btn-outline-success " id='search-btn' type="submit">Search</button>
        </form>
      </div>
    </div>
   </nav> 
   <hr/>
  </>






            // <header className="headerBox">      
            //   <nav> 
           
            //     <div className='nav-right'>
            //       <ul className="nav justify-content-end">
                  
            //         <li className="nav-item">
            //           <a className="nav-link active" aria-current="page" href="#!">About us</a>
            //         </li>
            //         <li className="nav-item">
            //           <a className="nav-link" href="#!">My page</a>
            //         </li>
            //         <li className="nav-item">
            //           <a className="nav-link" href="#!">Category</a>
            //         </li>
            //         <li className="nav-item">
            //           <a className="nav-link disabled" aria-disabled="true" href="#!">Login/Logout</a>
            //         </li>
            //     </ul>
            //     </div>
            //  </nav>
            //   <hr></hr>
            // </header>







              

        );
    }
}

export default Header;