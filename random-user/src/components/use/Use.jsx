import React, { useState } from 'react'

function Use() {
    let data = [
        {
            id: 1,
            name: "Bùi Hiên",
            email: "hien@gmail.com",
            address: "Thái Bình",
        },
        {
            id: 2,
            name: "Thu Hằng",
            email: "hang@gmail.com",
            address: "Hải Dương",
        },
        {
            id: 3,
            name: "Minh Duy",
            email: "duy@gmail.com",
            address: "Hưng Yên",
        },
    ];
    const [dataUser, setDataUser] = useState(data);
    // setIndex(Math.floor(Math.random() * 11));
    const [index, setIndex] = useState(Math.floor(Math.random() * (dataUser.length)));
    const deleteUser = (index) => {
        if(dataUser === []){
            return (
                <p>...........</p>
            );
        }
        let list = dataUser;
        list.splice(index, 1);
        setDataUser(list);
        randomUser();
    }
    const randomUser = () => {
        if(dataUser.length === 0){
            setIndex(-1);
            return;
        }else if ((dataUser.length === 1)){
            setIndex(0);
            return;
        }
        let count = Math.floor(Math.random() * (dataUser.length));
        while (index === count) {
            count = Math.floor(Math.random() * (dataUser.length));
        }
        setIndex(count);
    }
    if(index===-1){
        return(
            <p>Không còn user nào trong danh sách</p>
        )
    }else{
        return (
            <>
                <h1 style={{ color: "red" }}>Name : {dataUser[index].name}</h1>
                <ul>
                    <li>Email : {dataUser[index].email}</li>
                    <li>Address : {dataUser[index].address}</li>
                </ul>
                <button
                    onClick={randomUser}
                >Random user</button>
                <button
                onClick={() => deleteUser(index)}
                >Delete user</button>
            </>
        )
    }
    
}

export default Use