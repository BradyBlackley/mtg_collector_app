'use client';

import Banner from "./banner/banner";
import Navigation from "./navigation/navigation";
import Footer from "./footer/footer";
import  "bootstrap/dist/css/bootstrap.min.css";
import { useState } from 'react';
import UserContext from './context';

export default function RootLayout({ children }) {
    const [user, setUser] = useState({userId: "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454", username: "Guest", authenticated: false, isAdmin: false});

    return (
        <html lang="en">
          <body>
            <UserContext.Provider value={user}>
              <Banner headerText = "Magic The Gathering Collector&apos;s App"/>
              <Navigation />
              <main>{children}</main>
              <Footer />
            </UserContext.Provider>
          </body>
        </html>
      
    )
  }