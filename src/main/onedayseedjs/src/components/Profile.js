import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import 'bootstrap/dist/css/bootstrap.min.css'
import './css/profile.css';
import Header from './header/Header';
import Footer from './footer/Footer'

import axios from "axios";

function Profile() {
    const [users, setUsers] = useState({});

    const fetchData = async () => {
      try {
          const response = await axios.get('/api/user');
          setUsers(response.data);
      } catch (error) {
          console.error('Error fetching user details:', error);
      }
    };
  
    useEffect(() => {
      fetchData();
    }, []);
  
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setUsers((prevUsers) => ({
        ...prevUsers,
        [name]: value,
      }));
    };
  
    const handleSubmit = async (e) => {
      e.preventDefault(); // 기본 폼 제출 방지
      
      try {
        const response = await axios.post('/api/user', {
        userId: users.userId,
        userName: users.userName,
        password: users.password,
        phoneNum: users.phoneNum,
      });

        if (response.data.alertMessage) {
          // 에러 또는 성공 메시지가 있으면 alert 창 띄우기
          alert(response.data.alertMessage);
        }
    
        if (response.data.successMessage) {
          console.log('Form submitted successfully:', response.data.successMessage);
          fetchData();
        }
      } catch (error) {
          if (error.response) {
            // 서버 응답이 에러인 경우
            console.error('Error submitting form:', error.response.data);
            // 클라이언트에서 에러 메시지 처리 로직 추가
          } else if (error.request) {
            // 요청이 전혀 이루어지지 않은 경우
            console.error('Request error:', error.request);
          } else {
            // 기타 에러
            console.error('Unexpected error:', error.message);
          }
      }
    };
  
    return (
      <div>
        <Header />
        <h1>프로필 관리</h1>
        <img src="/profile.jpg" width="200px" height="200px" alt="프로필 이미지" />
  
        <Form onSubmit={handleSubmit}>
          <Form.Group controlId="formFileSm" className="mb-3">
            <Form.Label>사진 수정</Form.Label>
            <Form.Control type="file" size="sm" />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formGroupEmail">
            <Form.Label>아이디</Form.Label>
            <Form.Control type="text" name="userId" value={users.userId} disabled />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formGroupPassword">
            <Form.Label>비밀번호</Form.Label>
            <Form.Control
              type="password"
              name="password"
              value={users.password || ''}
              placeholder="Enter New Password"
              onChange={handleInputChange}
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formGroupName">
            <Form.Label>이름</Form.Label>
            <Form.Control
              type="text"
              name="userName"
              value={users.userName || ''}
              placeholder="Name"
              onChange={handleInputChange}
            />
          </Form.Group>
          <Form.Group className="mb-3" controlId="formGroupPhone">
            <Form.Label>핸드폰번호</Form.Label>
            <Form.Control
              type="text"
              name="phoneNum"
              value={users.phoneNum || ''}
              placeholder="- 없이 입력해주세요"
              onChange={handleInputChange}
            />
          </Form.Group>
          <Button variant="primary" type="submit">
            수정
          </Button>
        </Form>
        <Footer />
      </div>
    );
  }
  
  export default Profile;