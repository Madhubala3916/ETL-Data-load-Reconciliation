import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Navbar from './component/Navbar.js';
import Login from './pages/Login.js';
import FileUpload from './pages/FileUpload.js';
import Home from './component/Home.js';
import ErrorReport from './pages/ErrorReport.js';
import Contact from './pages/Contact.js';

function App() {
  return (
    <Router>
        <Navbar />
        <Routes>
          <Route path="/login" element={<Login />} />
          <Route path="/FileUpload" element={<FileUpload />} />
          <Route path="/home" element={<Home />} />
          <Route path="/errorreport" element={<ErrorReport />} />
          <Route path="/contact" element={<Contact />} />



        </Routes>
    </Router>
  );
}

export default App;
