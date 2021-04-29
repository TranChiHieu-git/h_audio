import React, {Component} from 'react';
import {Link, Switch} from "react-router-dom";
import {PrivateRoute} from "../../constant/common";

class Admin extends Component {
    render() {
        return (
            <div>
                admin
                <ol>
                    <li>
                        <Link to="/admin/singer">singer</Link>
                    </li>
                    <li>
                        <Link to="/admin/album">album</Link>
                    </li>
                    <li>
                        <Link to="/admin/user">user</Link>
                    </li>
                    <li>
                        <Link to="/admin/genre">genre</Link>
                    </li>
                    <li>
                        <Link to="/admin/song">song</Link>
                    </li>
                    <li>
                        <Link to="/admin">admin</Link>
                    </li>
                </ol>
                <Switch>
                    {
                        this.props.routes.map((route, i) => (
                            <PrivateRoute key={i} {...route} route={route}/>
                        ))
                    }
                </Switch>
            </div>
        );
    }
}

export default Admin;
