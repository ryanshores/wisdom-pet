import React from "react";
import {Link} from "react-router-dom";

const Home = () => {
    return(
        <>
            <h3>Home</h3>
            <ul style={{ listStyleType: 'none' }}>
                <li><Link to={'posts'}>Posts</Link></li>
            </ul>
        </>
    );
}

export default Home;