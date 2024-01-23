import React, { useState, useEffect } from 'react';
import CartList from './CartList';
import 'bootstrap/dist/css/bootstrap.min.css';
import Header from './header/Header';
import Footer from './footer/Footer'
import axios from "axios";

function Cart() {

    const [cartItems, setCartItems] = useState([]);

    const fetchData = async () => {
        try {
            const response = await axios.get('/api/cart');
            setCartItems(response.data);
        } catch (error) {
            console.error('Error fetching cart details:', error);
        }
    };
    
      useEffect(() => {
        fetchData();
      }, []);

    return (
        <>
            <Header />
            <h1>장바구니</h1>
            {/* key에는 고유값 */}
            {cartItems.map((item) => (
                <CartList key={item.id} item={item} />
            ))}
            <Footer />
        </>
    );
}

export default Cart;