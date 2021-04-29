import React, {Component} from 'react';
import {Link} from "react-router-dom";

class Index extends Component {
    render() {
        return (
            <div>
                <ul>
                    <li>
                        <Link to="/">home</Link>
                    </li>
                    <li>
                        <Link to="/login">Login</Link>
                    </li>
                    <li>
                        <Link to="/admin">admin</Link>
                    </li>
                </ul>
            </div>
        );
    }
}

export default Index;
