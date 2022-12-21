// const fun1 = ()=>{
//     console.log("This is Function 1");
// }
// const fun2 = ()=>{
//     setTimeout(()=>{
//         console.log("hey this function was executed in set time out");
//     },5000);
//     console.log("This is Function 2");
// }
// const fun3 = ()=>{
//     console.log("This is Function 3");
// }

// fun1();
// fun2();
// fun3();

const fun1 = ()=>{
    return "This is Function 1";
};
// const fun2 = ()=>{
//     setTimeout(()=>{
//         return "This is Function 2";
//     },5000);
// }
const fun2 = ()=>{
    return new Promise((resolve,reject) => {
        setTimeout(()=>{
            resolve("This is Function 2");
            },2000);
    });
};
const fun3 = ()=>{
    return "This is Function 3";
};

const callFunc = async ()=>{
    let val1=fun1();
    console.log(val1);
    let val2=await fun2();
    console.log(val2);
    let val3=fun3();
    console.log(val3);
}