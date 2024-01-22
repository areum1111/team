import React, { useEffect, useState } from 'react';
import Button from 'react-bootstrap/Button';
import Form from 'react-bootstrap/Form';
import 'bootstrap/dist/css/bootstrap.min.css'
import './css/profile.css';

import axios from "axios";
import { useLocation } from "react-router-dom";

    // const Profile = () => {
        // const [userId, setUserId] = useState("");
        // const [userName, setUserName] = useState("");
        // const [phoneNum, setPhoneNum] = useState("");
        // const [password, setPassword] = useState("");
        // const location = useLocation();
        // const id = location.state.userId; // 상세보기하려는 게시글의 id값

        // useEffect(() => {
        //     const getDetailProfile = async () => {
        //         let response = await axios.get(`/user/${id}}`);
        //         console.log('Detail/response: ', response);
        //         console.log('Detail/response.data: ', response.data);
        //         console.log('Detail/response.data.data: ', response.data.data);
        //         setUserId(response.data.data.userId);
        //         setUserName(response.data.data.userName);
        //         setPhoneNum(response.data.data.phoneNum);
        //         setPassword(response.data.data.password);
                
        //     }
        //     getDetailProfile();
        // }, [])

        // const [users, setUsers] = useState([]);

        // useEffect(({id}) => {
        //     axios({
        //         method : 'get',
        //         url: `https://localhost:8080/user/${id}`
        //     }). then(response => setUsers(response.data))
        // }, );

        function Profile () {
            const [users, setUsers] = useState([]);
          
            useEffect(() => {
                try {
                  // const response = await axios.get(`https://localhost:8080/api/user/${id}`);
                  // const response = await axios.get(`https://localhost:8080/api/user`);
                  axios.get('/api/user')
                  .then((res) => {
                    setUsers(res.data)
                  })
                } catch (error) {
                  console.error('Error fetching user details:', error);
                }
            }, []); 

    return (
        <div>
            <h1>{users}</h1>
            <h1>프로필 관리</h1>
            <img src="/profile.jpg" width='200px' height='200px' />

            <Form>
                <Form.Group controlId="formFileSm" className="mb-3">
                    <Form.Label>사진 수정</Form.Label>
                    <Form.Control type="file" size="sm" />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupEmail">
                    <Form.Label>아이디</Form.Label>
                    <Form.Control type="text" value={users.userId} disabled/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPassword">
                    <Form.Label>비밀번호</Form.Label>
                    <Form.Control type="password" value={users.password} placeholder='Enter New Password'/>
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupName">
                    <Form.Label>이름</Form.Label>
                    <Form.Control type="text" value={users.userName} placeholder='Name' />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formGroupPhone">
                    <Form.Label>핸드폰번호</Form.Label>
                    <Form.Control type="text" value={users.phoneNum} placeholder='- 없이 입력해주세요'/>
                </Form.Group>
                <Button variant="primary" type="submit">수정</Button>
            </Form>
        </div>
    );
}

export default Profile;