import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from './header/Header';
import Footer from './footer/Footer';
import axios from 'axios';

function LessonForm() {
  const [lessonName, setLessonName] = useState("");
  const [lessonCategory, setLessonCategory] = useState("");
  const [lessonPrice, setLessonPrice] = useState("");
  const [lessonLimited, setLessonLimited] = useState("");
  const [lessonStatus, setLessonStatus] = useState("");

  const handleInputChange = (e, setValue) => {
    // input의 현재 값에 접근
    const inputValue = e.target.value;

    // 상태 업데이트
    setValue(inputValue);
  }

  const handleSubmit = (e) => {
    e.preventDefault(); // 기본 폼 제출 방지
    
    const dataToSend = {
      lessonName,
      lessonCategory,
      lessonPrice,
      lessonLimited,
      lessonStatus
    };

    axios.post('/api/lesson/new', dataToSend)
    .then(response => {
      console.log('서버로부터의 응답:', response.data);
    })
    .catch(error => {
      console.error('에러 발생:', error);
    });
  }

  return (
    <div>
      <Header />

      <form onSubmit={handleSubmit}>

        <input onChange={(e) => handleInputChange(e, setLessonName)} placeholder='레슨명' /><br />
        <input onChange={(e) => handleInputChange(e, setLessonCategory)} placeholder='카테고리' /><br />
        <input onChange={(e) => handleInputChange(e, setLessonPrice)} placeholder='가격' /><br />
        <input onChange={(e) => handleInputChange(e, setLessonLimited)} placeholder='제한 인원' /><br />
        <input onChange={(e) => handleInputChange(e, setLessonStatus)} placeholder='판매 상태' /><br />
        <br />

        <Button type='submit'>저장</Button>

      </form>

      <Footer />
    </div>

  )

}

export default LessonForm;