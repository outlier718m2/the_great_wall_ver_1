import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Login from './components/auth/Login';

// WildFly 배포 기본 경로 설정
const BASE_PATH = '/thegreatwall';

const App = () => {
  return (
    <Router basename={BASE_PATH}>
      <div className="App">
        <Routes>
          {/* 기본 URL redirects to login */}
          <Route path="/" element={<Navigate to="/auth/login" />} />
          
          {/* 로그인 페이지 */}
          <Route path="/auth/login" element={<Login />} />
          
          {/* 404 페이지 */}
          <Route path="*" element={<div>페이지를 찾을 수 없습니다</div>} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;