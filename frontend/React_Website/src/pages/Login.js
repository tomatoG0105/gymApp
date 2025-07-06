import axios from "axios";
import React, { useState } from "react";
import { useEffect } from "react";
import { Link, useNavigate } from "react-router-dom";
import {useLocalState } from "../util/useLocalStorage";

export default function Login() {

    let navigate = useNavigate();

    const[jwt, setJwt] = useLocalState("", "");

    const [user, setUser] = useState({
      user_email: "",
      password: "",
    });

    const { user_email, password} = user;

    const onInputChange = (e) => {
      setUser({ ...user, [e.target.name]: e.target.value });
    };
  
    const onSubmit = async (e) => {
      e.preventDefault();
      const result = await axios.get("http://localhost:8080/api/auth/authenticate?email="+user.user_email+"&password="+user.password);
      console.log(user.user_email); 
      console.log(user.password);
      //setJwt(result.data.token);
      //setUser(result.data);
      navigate("/Admin/"+result.data.token)
    };
  
 
    return (
      <>
      <div className="container">
        <div className="row">
          <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
            <h2 className="text-center m-4">Login</h2>
  
            <form onSubmit={(e) => onSubmit(e)}>
              <div className="mb-3">
                <label htmlFor="Name" className="form-label">
                  Email
                </label>
                <input
                  type="email"
                  className="form-control"
                  placeholder="Enter your email"
                  name="user_email"
                  value={user_email}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="password" className="form-label">
                  Password
                </label>
                <input
                  type={"password"}
                  className="form-control"
                  placeholder="Enter your password"
                  name="password"
                  value={password}
                  onChange={(e) => onInputChange(e)}
                />
              </div>
              <button type="submit" className="btn btn-outline-primary">
                Login
              </button>
              <Link className="btn btn-outline-danger mx-2" to="/">
                Cancel
              </Link>
            </form>
          </div>
        </div>
      </div>
      </>
    );

}