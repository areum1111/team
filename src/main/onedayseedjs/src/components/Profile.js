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
  
    useEffect(() => {
      const fetchData = async () => {
        try {
          const response = await axios.get('/api/user');
          setUsers(response.data);
        } catch (error) {
          console.error('Error fetching user details:', error);
        }
      };
  
      fetchData();
    }, []);
  
    const handleInputChange = (e) => {
      const { name, value } = e.target;
      setUsers((prevUsers) => ({
        ...prevUsers,
        [name]: value,
      }));
    };
  
    const handleSubmit = (e) => {
      e.preventDefault();
      // 수정 버튼을 눌렀을 때의 동작 추가
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