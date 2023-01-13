// Primitive type

// 1. number type
// 정수와 실수를 구분하지 않는다.
// let myVar = 1.0 // 실수 -> number
// console.log(myVar == 1); // true
// console.log(3/2);  // 1.5
// console.log(10 / 0 ); // infinity(무한대)
// console.log(10 * 'Hello'); // NaN (Not a Number -> 숫자가 아니다. 산술 연산을 할 수 없다는 의미)

// 2. String type
//  문자열 타입
// var myStr = '아우성' // 일반적인 형태
// myStr = " 소리없는 " // 이것도 사용이 가능
// myStr = `이것은 소리없는 아우성!` // 이것도 가능
// myStr = '이것은 \n소리없는 \n아우성!'  // \n은 줄바꿈 기호
// myStr = `이것은
// 소리없는
// 아우성`  // 백틱의 경우 바로 엔터처서 여러줄로 표현이 가능하다. \n을 추가하지 않고서

// let test = 100;
// myStr = `현재 test의 값은 ${test} 입니다.` // 이미 만들어진 값을 문자열에 넣어줄 수 있다. ${}를 통해
// myStr = '현재 test의 값은' + test + '입니다' // 백틱 쓰지 않은 원래 문자

// console.log(myStr);

// 3. boolean type - true, false 두개의 값만 제공

// var test1 = true

// console.log(test1);

// 4. undefined type - 사용할 수 있는 값이 undefined만 있다.
// 이 값은 우리가 사용하는 값이 아니다.
// javascript Engine에 의해서 사용이 된다.

// 5. Null type - 사용할 수 있는 값이 Null 밖에 없다. 
// 이것은 우리가 사용하는 값이다.

// test = null;

 // 6. Symbol type  
 // ES6(ECMAScript 2015)에 추가된 타입이다.
 // 다른값과 중복되지 않는 unique환 값을 표현.

// let mySymbol = Symbol();
// console.log(mySymbol); // Symbol(); , unique한 값은 맞는데 진짜 그 값이 어떤 값인지를 확인할 수 없다.
// let mySymbol1 = Symbol("소리없는 아우성!");
// let mySymbol2 = Symbol("소리없는 아우성!");

// console.log(mySymbol1 == mySymbol2); // false 

// Reference type(함수, 객체, 배열) 은 따로 나중에 하자


// let str = 'hello';

// console.log(str[0]); // 문자열의 0번째 자리의 문자인 h가 출력 , str[0]은 배열인데 어떻게 이게 가능할까? 
// console.log(str.length); // 5 -> 
// console.log(str.toUpperCase()); // 소문자를 대문자로 변경해서 출력 
// 자바스크립트는 내가 가지고 있는 primitive value에 대해 객체처럼 사용하면 
// primitive value를 감싸는 wrapper object가 생성된다!

// let str = 'hello';

// str[0] = 'H'; // 배열을 만들어서 임시로 변경됬다가 str[0]이 끝났기 때문에 다시 원본으로 변하게 된다.

// console.log(str); // Hello가 나올 것을 예상했지만 hello가 나온다. str은 불변이기 때문이다.

// let myObj = {
//     'name' : '홍길동',
//     'age' : 20,
//     'address' : '서울',
//     'myInfo' : function() {
//         console.log('소리없는 아우성');
//     } // 익명함수 
// }
// console.log(myObj.myInfo); 
// myObj.myInfo();

// 객체 literal로 객체를 살펴보고 있다.
// let Obj = {
//     name : '홍길동',
//     10 : 200
// }
// Obj.address = '서울'; //자바에서는 필드로 선언을 해주지 않아서 오류가 나지만 스크립트는 객체안에 추가로 넣어줄 수 있다. 단점은 이렇게 계속 쓰면 에러가 나면 감당이 안된다.
//                      // 왜냐하면 에러가 안나기 때문이다. 실수로 추가할려고 하다가 문자를 잘못 입력해도 에러가 안나고 새롭게 추가로 작성을 해버린다.
// // console.log(Obj); // { name: '홍길동' } key는 문자열로 나온다. 그렇기 때문에 name에 '' 가 빠져서 출력된다. 또 key값을 적을 때 '' 없이 적어도 출력이 된다.
//                   // Key에 숫자를 넣어주면 문자열로 바뀌기 때문에 '' 가 생성되서 '10': 200 로 출력된다.
// console.log(Obj.name); // name 만 출력하고 싶을때 / 객체 사용하는 방식 1
// // 배열 형태로 출력하고 싶으면 
// console.log(Obj['name']); // 객체 사용하는 방식 2
// console.log(Obj['10']);  // [] 안에 10만 넣어도 정상출력 가능
// // 배열형태와 .name 형태 둘다 많이 사용되므로 알고 있자.
// console.log(Obj);

// 연산자 typeof : + - *
// 해당 값의 데이터 타입을 알려주는 역할을 한다.  
// console.log(typeof 100); // number
// console.log(typeof 'hello'); // string
// console.log(typeof undefined); // undefined
// console.log(typeof true); // boolean
// console.log(typeof Symbol()); //symbol
// console.log(typeof [1,2,3]); // object 

// console.log(typeof null); //null이 나와야되는데 object가 나온다. 이것이 바로 자바스크랩트의 대표적인 오류 중에 하나다. 

// // let myFunc = function () {
    
// // }
// // console.log(typeof myFunc); //Object가 나와야되는데 function이 나온다.

// // 함수 선언문
// function myFunc(a,b) {
//     return a + b;
// }

// // 함수 표현식
// let aa = function () {
    
// }

// // Function 생성자함수를 이용한 함수 생성방식
// let bb = new Function('x','y','return x + y');

// // Arrow Function (화살표 함수)
// let cc = (x,y) => {
//     return x + y
// }

// 함수 선언문
// function myFunc(a,b) {
//     return a+b;
// }
// console.log(myFunc(10,20)); // 30

// (function myFunc2(a,b) {
//     return a+b;
// }) // 이렇게 작성하면 () 안에 있는 내용이 literal이 된다는 뜻이다. 


// console.log(myFunc1(10,20)); // 첫바퀴 creation phase에서 실행이 되고
// console.log(myFunc2(10,20)); // 첫바퀴 creation phase에서 myFunc2 선언만 해놓고 내용물이 없고 
// 두바퀴 execution phase 를 돌아야되늗네 두바퀴를 못돌기 때문에 error가 나온다.


// // 함수 선언문

// function myFunc1(a,b) {
//     return a+b;
// }

// // 함수 표현식
// let myFunc2 =function(a,b) {
//     return a+b;
// }

// function add(x,y) {
//    // 모든 함수는  눈에 보이지 않는 내장 배열이 하나 가지고 있는데
//    // 그 이름이 arguments -> 넘어온 인자를 모조리 저장해주는 역할 
//    // arguments[] => [10,20,30,40]
//      return arguments[0]+arguments[1];
// }
// // console.log(add(10)); // javascript는 함수의 이름만 맞으면 인자의 개수에 상관없이 무조건 호출한다. 결과값으로 NaN이 나오게 된다.
// console.log(add(10,20,30,40)); //30

 // IIFE (즉시 실행 함수)
// 일반적으로 anonymous로 만든다. 함수를 선언하면서 바로 실행하는 용도
// 이 함수는 한번 사용되고 바로 버려진다. 다시 이 함수를 사용할 수 없다. 이름을 붙이고 밑에서 따로 호출을 해줘도 사용불가하다.
//  (function() {
//     let x = 10;
//     let y = 20;

//     console.log(x+y);
 
// }()); // 이렇게 만들면 즉시 실행 함수가 된다. 
// 생각해보면 이걸 왜 쓰는 건지 궁금해진다. 
// 즉시 실행 함수는 변수의 스코프를 제어할 수 있다. 
// 자바스크립트의 특성인 전역 scope의 공유 문제를 해결할 수 있습니다.

// 중첩함수
// 선언적 함수
// function outer() {
//     let x = 1;

//     function inner(){
//         let y = 2;
//         console.log(x+y);
//     }
//     inner();
// }
// outer();

// 프로그램을 하나 만들꺼다.
// 숫자를 하나 입력으로 줘서 0~ 해당 숫자까지 
// console에 출력하는 아주 간단한 프로그램을 작성

// function repeat(n) {
//     for(let i =0; i<n; i++){
//         console.log(i);
//     }
// }

// repeat(3);

// 자 다만들었다. 
// 시간이 흐르고 .... 새로운 기능이 필요하게 되었다.
// 숫자를 하나 입력으로 줘서 0~해당 숫자까지 console에 홀수만 출력하는 기능을 추가해야된다.

// function repeat_odd(n) {
//     for(let i =0; i<n; i++){
//         if(i % 2 == 1){
//             console.log(i);
//         }
//     }
// }

// repeat_odd(10);

// 프로그래밍 언어에서 일급시민이라는 용어가 있다. 
// first - class citizen 이 용어보다는
// 일급객체라는 표현을 더 많이 사용한다.
// first-class object
// 4가지 특성을 만족하는 객체를 우리는 일급객체라고 한다. 
// 1. 익명의 literal로 생성이 가능해야 된다.
// 2. 변수에 저장될 수 있어야한다. (값으로 판단될 수 있어야한다.)
// 3. 함수의 인자로 전달 될 수 있어야 한다.
// 4. 함수의 리턴값으로 사용할 수 있어야 한다.
 
// Javascript 함수는 
// 1. 익명으로 리터럴을 만들 수 있다.
// 2. 변수에 저장도 가능하다.(값으로 사용)
// 3. 인자로 전달이 가능.(값이니깐)
// 4. 함수의 리턴값으로 사용이 가능하다.

// 아하! 일급객체의 특성을 이용해서 위의 공통된 요소를 많이 가지고 있는 2개의 함수 구현을 하나로 합쳐보자

//함수를 인자로 받는다.
// 공통된 로직을 작성하고 경우에 따라서 변화되는 로직을 추상화해서 외부함수로 대체한다.
function repeat(n,f){
    for(let i = 0; i<n; i++){
        f(1);
    }
} // Higher-Order Function(고차함수) 

let printAll = function(i) {
    console.log(i);
}   // callback function
let printOdd = function(i) {
    if(i%2 == 1) console.log(i);
}   // callback function
let printEven = function(i) {
    if(i%2 == 0) console.log(i);
}   // callback function - 특별한 일을 하기 위해서 끼워넣은 함수
repeat(10 , printOdd);

// var myArr = [1,2,3]

// myArr.forEach(function(){})