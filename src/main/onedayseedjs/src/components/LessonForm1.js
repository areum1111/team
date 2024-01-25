import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import Header from './header/Header';
import Footer from './footer/Footer';
import axios from 'axios';

function LessonForm() {
  const [lessonName, setLessonName] = useState("");
  const [lessonCategory, setLessonCategory] = useState("");
  const [lessonPrice, setLessonPrice] = useState();
  const [lessonLimited, setLessonLimited] = useState();
  const [lessonStatus, setLessonStatus] = useState("");

  const baseUrl = "/lesson/test";
  const [data, setData] = useState();

  useEffect(() => {
    getData();
  }, []);

  async function getData() {
    await axios.get(baseUrl)
      .then((response) => {
        console.log(response.data);
        setData(response.data);
      })
      .catch((error) => {
        console.log(error);
      })
    //, console.log(lessonName), console.log(lessonCategory), console.log(lessonPrice), console.log(lessonLimited), console.log(lessonStatus)).catch(function()
  }

  return (
    <div>
      <Header />

      <input onChange={(e) => { setLessonName(e.target.value); }} placeholder='레슨명' /><br />
      <input onChange={(e) => { setLessonCategory(e.target.value); }} placeholder='카테고리' /><br />
      <input onChange={(e) => { setLessonPrice(e.target.value); }} placeholder='가격' /><br />
      <input onChange={(e) => { setLessonLimited(e.target.value); }} placeholder='제한 인원' /><br />
      <input onChange={(e) => { setLessonStatus(e.target.value); }} placeholder='판매 상태' /><br />
      <input placeholder={data}></input>
      <br />
      <button onClick={() => {
        axios.post
          ('/lesson/new', {
            lessonName: lessonName,
            lessonCategory: lessonCategory,
            lessonPrice: lessonPrice,
            lessonLimited: lessonLimited,
            lessonStatus: lessonStatus,
          })
          .then(response => {
            console.log('성공');
          })
          .catch(error => {
            console.error('실패:', error);
          });
      }}>전송</button>
      <Footer />
    </div>

  )

}


export default LessonForm;