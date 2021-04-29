import {Redirect, Route} from "react-router-dom";
import React from "react";

export const PrivateRoute = ({component: Component, ...rest}) => (
    <Route {...rest} render={(props) => {
        return rest.route.auth ?
            (
                (localStorage.getItem("Authorization") &&
                    localStorage.getItem("Authorization") !== "")
                    ?
                    <Component {...props} routes={rest.route.routes}/>
                    :
                    <Redirect to='/login'/>
            ) :
            <Component {...props} routes={rest.route.routes}/>
    }

    }/>
)
