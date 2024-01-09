import React from 'react';
import {BrowserRouter, redirect, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Posts from "./pages/Posts";
import {Provider} from "react-redux";
import {store} from './redux/store';
import Post from "./pages/Post";
import {useAppSelector} from "./redux/hooks";

const loader = () => {
    const {account} = useAppSelector(state => state.app);

    if (account === null) return redirect("/login");
}

function App() {
    return (
        <Provider store={store}>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Layout/>} loader={loader}>
                        <Route index element={<Home/>} />
                        <Route path='posts'>
                            <Route index element={<Posts/>} />
                            <Route path={':id'} element={<Post/>} />
                        </Route>
                    </Route>
                </Routes>
            </BrowserRouter>
        </Provider>
      );
}

export default App;
