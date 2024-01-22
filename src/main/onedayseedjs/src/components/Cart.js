import React from 'react';
import CartList from './CartList';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './header/Header';
import Footer from './footer/Footer'

function Cart() {
    return (
        <>
            <Header />
            <h1>장바구니</h1>
            <CartList />
            <Footer />
        </>
    );
}

export default Cart;