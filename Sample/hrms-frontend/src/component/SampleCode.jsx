import React, { useEffect, useState } from 'react'

function SampleCode() {
    const[counter,setCounter]=useState(20);
    const[pointer,setPointer]=useState(100);
    useEffect(()=>{
        console.log("useEffect method..");
        console.log("counter is "+counter);
        console.log("Pointer is "+pointer);
    },[counter,pointer]);
    function ChangeCounter(){
        setCounter(counter+2);
    }
    function ChangePointer(){
        setPointer(pointer-2);
    }
  return (
   <div>
    <h1 >Counter:{counter}</h1>
    <h1 >Pointer:{pointer}</h1>
    <button onClick={ChangeCounter} style={{backgroundColor:"yellow",color:"red",scale:2,margin:"20px 20px 20px"}}>+</button>
    <button onClick={ChangePointer} style={{backgroundColor:"pink",color:"red",scale:2}}>-</button>

   </div>
  )
}

export default SampleCode