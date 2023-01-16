
// var x = "Hello"; // 전역변수 - global scope

// // 함수 선언문
// function  foo(){
//     var x = "world"; // 지역변수 - local scope

//     function bar(){
//         var x = " haha "; // 지역변수 - local scope

//         console.log(y); // y를 찾는 과정은 bar에서 찾고 없으면 foo에서 찾고 없으면 전역 scope에서 찾는다.
//         // 변수를 찾을 때 현재 scope로 부터 상위 scope로 올라가면서 변수를 찾는다.
//         // scope는 서로 포함관계에 있을 수 있다.
//     }
//     console.log(x); // x ? 
//     // JavaScript Engine이 이 x는 과연 x인가?
//     // identifier resolution(식별자 결정) => Scope
//     // 두 개의 x는 이름은 같지만 scope가 다르다.
//     // 이 두 개의 x는 서로 다른 변수이다.
//     // scope => namespace(이름을 구분해주는 공간)
//     bar();
// } 

// foo();

// console.log(x);

// var x = 1;

// function foo() {
//     var x = 10;
//     bar();

// }

// function bar() {
//     console.log(x); // x = 1 
// }

// foo();

// 객체 literal
// let 과 const의 차이는 하나만 제외하고 똑같다.
// const는 재 할당이 안된다. constant (상수)
// const obj = {
//     // 이 안에는 property가 들어간다. key와 value형태로
//     myName : '홍길동',
//     myAge : 20
// }
// console.log(obj);
// // console.log(obj.[[__proto__]]); // 에러
// console.log(obj.__proto__); // 가능 



// const person = {
//     name : '홍길동',
//     age : 20
// };

// console.log(person);

// console.log(Object.getOwnPropertyDescriptor(person));

// 객체를 다른 방식으로 만들어 보자.

// const person ={}

// Object.defineProperty(person, 'firstName' , {
//     value : '홍',
//     writable : false, // value 값 변경 가능
//     enumerable : false, // key값 뽑아서 확인 가능
//     configurable : true
// })

// console.log(person.firstName); // 홍
// person.firstName = '최'
// console.log(person.firstName); // 최

// console.log(person);

// for(let key in person) {
//     console.log(key);
// }


// new라는 키워드로 생성자 함수를 호출할 수 있다.
const person = new Object() // {}와 같다. 내부적인 구조는 다르지만 의미적으로는 같다.

person.name = '홍길동';
person.age = 20;

console.log(person);

const strObj = new String('소리없는 아우성');

console.log(typeof strObj); // Object
// 유사배열객체가 만들어진다. 유사배열객체는 진짜배열과 동일한데
// 대신 함수를 가지고 있지 않아서 사용하는데 제약이 있다.
// 대신 index같은 기능은 있어서 배열처럼 사용할 수 있다.
console.log(strObj);

// const strObj1 = {
//     name : '홍길동',
// }

// console.log(typeof strObj1); // Object
// console.log(strObj1);


// const numObj = new Number(100);

// console.log(numObj);

// const dateObj = new Date();
// console.log(dateObj.toLocaleString());

//동일한 형태의객체 만들기
// let obj1 = {
//     name : '홍길동',
//     age : 20
// }
// let obj2 = {
//     name : '신사임당',
//     age : 30
// }
// let obj3 = {
//     name : '최길동',
//     age : 22
// }
//위의 방식은 너무 노동집약적인 방법

//사용자 정의 생성자 함수
//생성자 함수는 관용적으로 첫글자를 대문자로 씀

//함수 선언문
// 2가지 형태로 사용이 가능하다.
// 1번째는 일반 함수로
// 2번째는 생성자 함수로 
// function Person() {

// }

// const person1 = new Person();
// const person2 = {}

// console.log(person1);
// console.log(person2);

// 일반적인 생성자 함수의 형태를 알아보자.
// 1. this keyword가 나온다.
// this의 의미는 이 생성자 함수로 만들어지는 객체를 지칭
// 2. return 구문이 없다.
//  묵시적으로 생성된 객체를 리턴한다. 그래서 리턴을 쓰지 않는다
// function Circle(radius) {
//     this.radius = radius;  // this. 뒤에 나오는 녀석이 property역할을 한다.
//     this.getDiameter = function() {
//         return 2 * 3.14 * radius; 
//     } 
// } // 이놈이 자바의 클래스 역할을 하는 것이다. this의 형태로 property를 만드는 것이다.

// let circle1 = new Circle(5); // 객체 생성
// let circle2 = new Circle(10);  // 객체 생성

// console.log(circle1);
// console.log(circle1.getDiameter());

// 함수 선언문
// function foo(){
//     console.log(this);
// } // 모양으로 생성자 함수인지 일반 함수인지 구분할 수 없다. 뒤에 적어주는 것이 중요하다.

// foo(); // 일반 함수로 호출 => tihs는 전역객체(window)

// const obj = {
//     foo , // <- foo : foo를 축약한 것, <- foo : function (){}를 축약한 것
//     // 객체가 가지고 있는 함수 , ES6의 축약표현, 이렇게 축약표현으로 되어 있는 함수를 메소드라한다.
// }

// obj.foo();

// const obj1 = new foo();

// 생성자 함수는 new keyword와 함께 사용되고  그리고 생성자 함수는 그 안에 return구문이 없다.,
// 그럼에도 불구하고 만들어진 객체가 묵시적으로 리턴된다.

// function Circle(radius) {
//     this.radius = radius;
//     return 100; // 리턴값이 primitive type이냐 객체 타입이냐에 따라 달라지는데 생성자 함수로 호출할 경우 
//     //primitive type을 주어지면 무시하고 this가 리턴되고 일반함수로 호출 할 경우 100이 리턴된다.
// }

// const circle1 = new Circle(10); //  일반함수로 호출
// // 함수가 호출 되있는데 리턴값이 없으면 묵시적으로 undefined가 리턴된다. 
// console.log(circle1); // undefined  

// var myName = '홍길동' // 전역객체는 최상위 객체인 window의 property값으로 붙는다. window객체의 property등록
// let myAge = 20; // window 객체에 등록은 안된다.

// console.log(myName);
// console.log(window.myName); // 홍길동
// console.log(window.myAge); // undefined

// function foo() {
//     console.log(this);
// }
// foo();



// function Circle(radius) {
//     this.radius = radius;
// }

// const circle1 = Circle(10); 

// console.log(radius); // window.radius 에서 window가 생략되어 작성가능

// 함수 선언문
// function foo() {

// }

// // 첫번째 phase에서 foo라는 변수가 생성(묵시적으로)
// foo.myName = '홍길동';
// foo.myFunc = function() {
//     console.log(this);
// }

// console.log(foo.myName);
// foo.myFunc();

// function foo() {

// }

// foo는 일반함수로 호출이 가능하기 때문에 기본적으로 [[Call]]을 가지고 있는 함수이다. 
// 그러므로 foo는 Callable이다.

// foo(); // 이렇게 호출하면 .. 내부적으로 [[Call]]이 호출된다.

// var myVar = {};

// myVar(); // error가 발생하는데 이유는 [[Call]]이 없기 때문이다.

// [[Construct]] => 함수 객체에 붙을 수 있다.
// 1. [[Construct]] 내부 메소드가 붙은 경우 
// => 함수 선언문,함수표현식,클래스 / [[Construct]] 가 무조건 붙는다.
// => 객체를 생성할 수 있는 함수형태.. new를 사용할 수 있는 함수들
// => 함수 선언문,함수표현식,클래스는 constructor 라고 불른다. 
// function myFunc() {

// }

// myFunc(); // [[Call]] 호출 , 일반함수
// new myFunc(); // [[Construct]] 호출

// 2. [[Construct]] 내부 메소드가 없는 경우 
// => 메소드인 경우(ES6의 메소드표현식) 
// => Arrow-Function 
// => non-constructor

// 함수 선언문 , callable([[Call]]을 가지고 있다.)
// constructor ([[Construct]]를 가지고 있다.)
// function foo() {

// }
// foo();
// new foo();

// 함수 표현식
// const bar = function() {
    
// }
// bar();
// new bar();

// 함수 표현식
// const obj = {
//     x : function() {}  // method라고 하지 않는다.
// }

// new obj.x();  // method가 아니기때문에 객체생성이 가능
//               // constructor

// const myFunc = (a,b) => {return a+b}
// myFunc();  // 가능 [[Call]]이 있다.
// new myFunc(); // error!

// var obj = {
//     // myFunc : function() {}
//     // 이 형태가 축약형이고 메소드라고 불른다.
//     myFunc() {
        
//     },
//     name : '홍길동'
// }

// new obj.myFunc();

// 함수 선언문 - constructor 
// function add(x,y) {
//     return x + y;
// }

// let instance = new add();  // OK

// console.log(instance); // add {}

// // 함수 선언문
// function createUser(name, age) {
//     // this.name = name; // 생성자 함수를 쓸때는 this를 쓰고 return값이 없는게 정석적이긴 하다.
//     // this.age = age;
//     return {name , age}
//     return {name : name ,
//             age : age } 
// }

// let inst = new createUser('홍길동',20);

// console.log(inst);

// 함수 선언문  
// function Circle(radius) {  // 일반적인 함수는 이름이 소문자 , 생성자함수는 대문자
//     this.radius = radius;
//     this.getDiameter = function() {
//         console.log('haha');
//     }
// }

// const circle1 = Circle(10);
// // console.log(circle1); // 일반함수 이기 때문에 리턴값도 없고 해서 undefined가 나온다.

// // console.log(radius); // 10
// circle1.getDiameter(); // 위에서 undefined가 떴기 때문에 error가 나온다. '.' 찍고 뭔가 바로 나온다고 좋아하지 말자.

////////////////////////////////////////////////////////////////////////////////////////////////////////

// var obj = {
//     name : '홍길동'
// }
// console.log(obj);
// console.dir(obj);

// function sqaure(number) {
//     return number * number
// }

// console.log(sqaure);
// console.dir(sqaure);