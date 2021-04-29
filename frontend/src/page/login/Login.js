import React, {Component} from 'react';
import "../../css/page/login/login.css";

class Login extends Component {
    render() {
        return (
            <React.Fragment>
                <div className="login-css">
                    <div className="form-structor">
                        <div className="signup" id="login">
                            <h2 className="form-title" onClick={() => {
                                const signupButton = document.getElementById('signup');
                                const loginButton = document.getElementById('login');
                                if (signupButton && loginButton) {
                                    signupButton.classList.add("slide-up");
                                    loginButton.classList.remove("slide-up");
                                }
                            }}>
                                Đăng nhập
                            </h2>
                            <div className="form-holder">
                                {/*<input type="email" className="input" placeholder="Tài khoản"/>*/}
                                {/*<input type="password" className="input" placeholder="Mật khẩu"/>*/}
                                <input className="input"/>
                            </div>
                            <button className="submit-btn">Đăng nhập</button>
                        </div>
                        <div className="login slide-up" id="signup">
                            <div className="center">
                                <h2 className="form-title" onClick={() => {
                                    const signupButton = document.getElementById('signup');
                                    const loginButton = document.getElementById('login');
                                    if (signupButton && loginButton) {
                                        signupButton.classList.remove("slide-up");
                                        loginButton.classList.add("slide-up");
                                    }
                                }}>
                                    Đăng ký
                                </h2>
                                <div className="form-holder">
                                    <input type="text" className="input" placeholder="Họ và tên"/>
                                    <input type="email" className="input" placeholder="Email"/>
                                    <input type="account" className="input" placeholder="Tài khoản"/>
                                    <input type="password" className="input" placeholder="Mật khẩu"/>
                                </div>
                                <button className="submit-btn">Đăng ký</button>
                            </div>
                        </div>
                    </div>
                </div>
            </React.Fragment>
        );
    }
}

export default Login;
