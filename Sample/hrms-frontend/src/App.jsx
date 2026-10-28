
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import './App.css'
import Navbar from './demo_component/Navbar'
import Home from './component/Home'
import Dashboard from './component/Dashboard'
import Login from './component/Login'
import Registration from './component/Registration'


function App() {
//   const employee=[
//   {  ename:"Rahul", empid:"120"},
//   {  ename:"sahul", empid:"121"},
//   {  ename:"menon", empid:"122"},
//   {  ename:"rakes", empid:"123"},
//   ]


  return (
    <>
      <BrowserRouter>
       <Navbar/>
       <Routes>
         <Route path="/" element={<Home/>}/>
         <Route path="/login" element={<Login/>}/>
         <Route path="/register" element={<Registration/>}/>
         <Route path="/dashboard" element={<Dashboard/>}/>
       </Routes>
      </BrowserRouter>
    
    </>
  );
}


export default App