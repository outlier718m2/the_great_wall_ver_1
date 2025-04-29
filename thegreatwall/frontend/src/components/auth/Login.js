import React, { useState } from 'react';
import './Login.css';
import { Helmet } from 'react-helmet';

const Login = () => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('로그인 시도:', { username, password });
    // 여기에 로그인 로직 추가
  };

  return (
    <div className="login-container">
      <Helmet>
        <title>중화요리 만리장성 - 로그인</title> {/* 여기 추가 */}
      </Helmet>
      <div className="login-box">
        <h2>로그인</h2>
        <form onSubmit={handleSubmit}>
          <div className="textbox">
            <input
              type="text"
              name="username"
              placeholder="아이디"
              value={username}
              onChange={(e) => setUsername(e.target.value)}
              required
            />
          </div>
          <div className="textbox">
            <input
              type="password"
              name="password"
              placeholder="비밀번호"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
              required
            />
          </div>
          <button type="submit" className="btn">로그인</button>
        </form>
      </div>
    </div>
  );
};

export default Login;
