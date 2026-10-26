import React, { useEffect, useState } from 'react'

function Products() {
    const[serverData,setserverData]=useState([]);
    useEffect(()=>{
       async function getData(){
        try{
            const serverData=await fetch('http://localhost:8080/');
            const JSONServerData=await serverData.text();
            console.log(JSONServerData)
            setserverData(JSONServerData);
        }
        catch(error){
            console.log(error);
        }
       }
       getData();
    },[])
  return (
    <div>

        {/* {
           serverData.map((data)=>(
            <div key={data.id} style={{border:"2px solid red",backgroundColor:"yellow",margin:"20px"}}>
                <img src={data.image} style={{width:"140px",border:"2px black"}}/>
                <h5>{data.title}</h5>
                <h5>{data.description}</h5>
                <h5>{data.price}</h5>

            </div>
           ))
        } */}

    </div>
  )
}

export default Products