import React from "react";
import Index from "./../page/common/index";
import Login from "./../page/login/Login";
import Admin from "./../page/admin/admin";
import Singer from "../component/admin/singer";
import Album from "../component/admin/album";
import User from "../component/admin/user";
import Genre from "../component/admin/genre";
import Song from "../component/admin/song";

export const routes = [
    {
        path: "/login",
        component: Login,
        auth: false
    },
    {
        path: "/admin",
        component: Admin,
        auth: true,
        routes: [
            {
                path: "/admin/singer",
                component: Singer,
                auth: true,

            },
            {
                path: "/admin/album",
                component: Album,
                auth: true,
            },
            {
                path: "/admin/user",
                component: User,
                auth: true,
            },
            {
                path: "/admin/genre",
                component: Genre,
                auth: true,
            },
            {
                path: "/admin/song",
                component: Song,
                auth: true,
            }
        ]
    },
    {
        path: "/",
        component: Index,
        auth: false
    },
];
