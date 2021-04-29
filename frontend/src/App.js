import './App.css';
import React, {useEffect} from "react";
import * as fetch from "./constant/fetch_api";
import {routes} from "./constant/router";
import {checklogin} from "./constant/api";
import {
    BrowserRouter as Router, useHistory, Link, Switch
} from "react-router-dom";
import {useDispatch} from "react-redux";
import {account} from "./action/core/account";
import {PrivateRoute} from "./constant/common";

function App() {
    const history = useHistory();
    const dispatch = useDispatch();
    useEffect(() => {
        fetch.post(checklogin, localStorage.getItem("Authorization")).then(res => {
            if (res) {
                if (res.status && res.result) {
                    dispatch(account(res.result));
                } else {
                    localStorage.setItem("Authorization", "");
                    dispatch(account({}));
                    history.push("/");
                }
            }
        });
    }, []);
    return (
        <Router>
            <Switch>
                {
                    routes.map((route, i) => (
                        <PrivateRoute key={i} {...route} route={route}/>
                    ))
                }
            </Switch>
        </Router>
    );
}

export default App;
