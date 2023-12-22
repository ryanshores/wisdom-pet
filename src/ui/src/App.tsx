import {BrowserRouter, Route, Routes} from "react-router-dom";
import Layout from "./pages/Layout";
import Home from "./pages/Home";
import Posts from "./pages/Posts";

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path={'/'} element={<Layout/>}/>
          <Route index element={<Home/>}/>
          <Route path={'/posts'} element={<Posts/>} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
