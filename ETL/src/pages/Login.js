import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";

const Login = () => {
  const [login, setLogin] = useState({
    username: "",
    password: "",
  });
  const navigate = useNavigate();

  const [loginMessage, setLoginMessage] = useState("");
  const [token, setToken] = useState(localStorage.getItem("jwtToken") || ""); // Retrieve token from localStorage
  const [showFileUpload, setShowFileUpload] = useState(false); // Control the display of FileUpload

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setLogin((prevLogin) => ({
      ...prevLogin,
      [name]: value,
    }));
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    if (!login.username || !login.password) {
      setLoginMessage("Please enter both username and password");
      return;
    }

    try {
      const response = await axios.post(
        "http://localhost:8282/authenticate",
        {
          username: login.username,
          password: login.password,
        }
      );

      if (response.data.token) {
        // Successful authentication; store the token securely in localStorage
        const newToken = response.data.token;
        localStorage.setItem("jwtToken", newToken); // Store the token in localStorage
        setToken(newToken); // Update the token state

        // Navigate to the desired page after successful login
        setTimeout(() => {
          navigate(`/FileUpload`);
        }, 1000);
      } else {
        setLoginMessage("Login failed");
      }
    } catch (error) {
      console.error("Error during login:", error);
      window.alert("An error occurred during login");
      setLoginMessage("An error occurred during login");
    }
  };

  return (
    <div>
      <div className="vh-100 d-flex justify-content-center align-items-center">
        <div
          className="col-md-4 p-5 shadow-sm border rounded-3 bg-light"
          style={{ marginTop: "50px" }}
        >
          <div className="card-body">
            <form onSubmit={handleLogin}>
              <h2 className="card-title text-center fs-2 fw-800 text-uppercase text-black mb-4">
                Login
              </h2>
              <div className="mb-3">
                <label htmlFor="username" className="form-label text-start">
                  Username
                </label>
                <input
                  type="text"
                  className="form-control border-primary"
                  placeholder="Username"
                  name="username"
                  value={login.username}
                  onChange={handleInputChange}
                  required
                />
              </div>
              <div className="mb-3">
                <label htmlFor="password" className="form-label text-start">
                  Password
                </label>
                <input
                  type="password"
                  className="form-control border-black"
                  placeholder="Password"
                  name="password"
                  value={login.password}
                  onChange={handleInputChange}
                  required
                />
              </div>

              <div className="d-grid">
                <button type="submit" className="btn btn-primary">
                  Login
                </button>
              </div>

              <p className="text-center ">{loginMessage}</p>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
