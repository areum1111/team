import React, { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';
import CloseButton from 'react-bootstrap/CloseButton';
import "bootstrap-icons/font/bootstrap-icons.css";
import 'bootstrap/dist/css/bootstrap.min.css';
import './css/cartList.css';

// Cart에서 넘긴 item
function CartList({item}) {

    // 가격
    const totalPrice = item.count * item.price;

    // 인원 변동
    const [personCount, setPersonCount] = useState(item.count);

    const handleIncrease = () => {
        setPersonCount(prevCount => prevCount + 1);
    };

    const handleDecrease = () => {
        if (personCount > 1) {
        setPersonCount(prevCount => prevCount - 1);
        }
    };

    // const fetchData = async () => {
    //     try {
    //       const response = await axios.get('/api/user');
    //       setData(response.data);
    //     } catch (error) {
    //       console.error('Error fetching data:', error);
    //     }
    //   };

    // const handleSubmit = async (event) => {
    //     event.preventDefault(); // 기본 폼 제출 방지

    //     try {
    //         const response = await axios.post('/api/cart', {
    //             cartItemId: item.cartItemId,
    //             personCount: personCount,
    //       });
    
    //         if (response.data.alertMessage) {
    //           // 에러 또는 성공 메시지가 있으면 alert 창 띄우기
    //           alert(response.data.alertMessage);
    //         }
        
    //         if (response.data.successMessage) {
    //           console.log('Form submitted successfully:', response.data.successMessage);
    //           fetchData();
    //         }
    //       } catch (error) {
    //           if (error.response) {
    //             // 서버 응답이 에러인 경우
    //             console.error('Error submitting form:', error.response.data);
    //             // 클라이언트에서 에러 메시지 처리 로직 추가
    //           } else if (error.request) {
    //             // 요청이 전혀 이루어지지 않은 경우
    //             console.error('Request error:', error.request);
    //           } else {
    //             // 기타 에러
    //             console.error('Unexpected error:', error.message);
    //           }
    //       }
    //   };



    return (
        <div className='all'>
            <div className='thumb'>
                <img src="/thumb.jpg" width='300px' height='278px' />
            </div>
            {/* <Form onSubmit={handleSubmit}> */}
            <Form>
                <CloseButton className='closeButton' />
                <Form.Group as={Row} className="mb-3" controlId="formGroupName">
                    <Form.Label column sm="3">클래스</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly value={item.lessonName}/></Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3" controlId="formGroupDate">
                    <Form.Label column sm="3">날짜</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly value={item.lessonSchedule}/></Col>
                </Form.Group>
                <div className='caret'>
                    <i className="bi bi-caret-down-fill" onClick={handleDecrease} />
                    <i className="bi bi-caret-up-fill" onClick={handleIncrease} />
                </div>
                <Form.Group as={Row} className="mb-3" controlId="formGroupPerson">
                    <Form.Label column sm="3">인원</Form.Label>
                    <Col sm="9"><Form.Control value={personCount}/></Col>
                </Form.Group>
                <Form.Group as={Row} className="mb-3" controlId="formGroupPrice">
                    <Form.Label column sm="3">가격</Form.Label>
                    <Col sm="9"><Form.Control plaintext readOnly value={totalPrice}/></Col>
                </Form.Group>
                <Button variant="primary" type="submit">수정</Button>
                <Button variant="success" className="mt-3">결제</Button>
            </Form>
        </div>
    );
}

export default CartList;