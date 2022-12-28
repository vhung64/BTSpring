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
        if (dataUser === []) {
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
        if (dataUser.length === 0) {
            setIndex(-1);
            return;
        } else if ((dataUser.length === 1)) {
            setIndex(0);
            return;
        }
        let count = Math.floor(Math.random() * (dataUser.length));
        while (index === count) {
            count = Math.floor(Math.random() * (dataUser.length));
        }
        setIndex(count);
    }
    if (index === -1) {
        return (
            <p>Không còn user nào trong danh sách</p>
        )
    } else {
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

                <div className="product-item d-flex border mb-4">
                    <div className="image">
                        <img src="https://images.unsplash.com/photo-1523381294911-8d3cead13475?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTh8fGNsb3RoZXN8ZW58MHx8MHx8&auto=format&fit=crop&w=800&q=60" alt="sản phẩm 1" />
                    </div>
                    <div className="info d-flex flex-column justify-content-between px-4 py-3 flex-grow-1">
                        <div>
                            <div className="d-flex justify-content-between align-items-center">
                                <h2 className="text-dark fs-5 fw-normal">
                                    Sản phẩm 1 (M)
                                </h2>
                                <h2 className="text-danger fs-5 fw-normal">
                                    300.000 VND
                                </h2>
                            </div>
                            <div className="text-black-50">
                                <div className="d-inline-block me-3">
                                    <button className="border py-2 px-3 d-inline-block fw-bold bg-light">-</button>
                                    <span className="py-2 px-3 d-inline-block fw-bold">1</span>
                                    <button className="border py-2 px-3 d-inline-block fw-bold bg-light">+</button>
                                </div>
                            </div>
                        </div>
                        <div>
                            <button className="text-primary border-0 bg-transparent fw-light">
                                <span><i className="fa-solid fa-trash-can"></i></span>
                                Xóa
                            </button>
                        </div>
                    </div>
                </div>
            </>
        )
    }

}

export default Use