import React from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import CloseButton from 'react-bootstrap/CloseButton';
import "bootstrap-icons/font/bootstrap-icons.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/cartList.css';

function CartList() {
    return (
        <div className='all'>
            <div className='thumb'>
                <img src="/thumb.jpg" width='300px' height='278px' />
            </div>
            <Form>
                <CloseButton className='closeButton' />
                <Form.Group as={Row} className="mb-3" controlId="formGroupName">
                    <Form.Label column sm="3">클래스</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly defaultValue="베이킹"/></Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3" controlId="formGroupDate">
                    <Form.Label column sm="3">날짜</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly defaultValue="2024-01-11"/></Col>
                </Form.Group>
                <div className='caret'>
                    <i className="bi bi-caret-down-fill" />
                    <i className="bi bi-caret-up-fill" />
                </div>
                <Form.Group as={Row} className="mb-3" controlId="formGroupPerson">
                    <Form.Label column sm="3">인원</Form.Label>
                    <Col sm="9"><Form.Control placeholder='1'/></Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3" controlId="formGroupPrice">
                    <Form.Label column sm="3">가격</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly defaultValue="10,000"/></Col>
                </Form.Group>
                <Button variant="primary" type="submit">수정</Button>
            </Form>
        </div>
    );
}

export default CartList;