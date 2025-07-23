"use client";

import styles from "./home.module.css";
import UserContext from './context';
import React, { useContext } from 'react';

export default function HomePage() {
    const { username } = useContext(UserContext);

    return (
        <div className={styles.home}>
            <h1>{`Welcome, ${username}`}</h1>
        </div>
    );
};