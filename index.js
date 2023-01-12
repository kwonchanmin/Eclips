// 일단 먼저 Node.js를 설치해서 이걸 이용해서 실행해보자
// 자바스크립트는 ArrayList가 없다.
// javascript의 기본 자료구조는 Array(배열)이다.

// const myArray = [1,2,3,4]

// // 기본 for구문 대신에 forEach구문을 사용
// myArray.forEach(function(data){ // data는 Array의 자료들이 하나 씩 들어가는거다. foreach로 인해 
//     console.log('결과 : ' + data) //console.log = java의 sysout
//     console.log();
    
// })

// 경고창을 띄운다.
// alert()은 browser가 가지고 있는 API
// alert('소리없는 아우성')
// blocking 함수

// node.js를 이용해서 그냥 javascript code를 실행시킬꺼다.

//변수를 선언해보자
// var result  

// 자바스크립트 변수는 특이한 성질을 가지고 있다.
// hoisting 이라는 특성이 있다.

// console.log(result); // error가 아니다.
// 당얀히 error가 나와야 정상인데 아니다.
// 그 이유는 Hoisting 때문이다
// javaScript 의 실행은 2개의 phase로 실행이 된다.
// 1번째 phase는 -> Creating Phase라고 한다.
// 위에서부터 싹 보면서 선언구문을 다 찾아서  식별자를 메모리에 맵핑(변수화)시킨다.
// 이 과정이 다 끝나면
// 처음으로 다시 돌아가서 코드를 실행한다.
// 2번째 Phase는 Execution Phase라고 한다.

// var result = 100;

//var keyword는 같은 scope내에서 중복선언이 가능하다.

//var x = 100;
// var y = 200;

// var x = 300;  // var 키워드가 없는 걸로 간주된다.
// x = 300;
// var y;  // 이런 경우는 무시!

// var keyword는 function level scope만을
// local scope로 인정한다.

// var x = 1;

// if(true) {
    // var x = 100;
// }

// console.log(x); // 100 function level scope라서

// var x = 1;

// java는 함수가 없다. 대신 메소드가 있다.
// 자바의 메소드는는 클레스 안에 위치.

//자바스크립트는 함수형 언어 그래서 이놈은 ... 함수가 존재
// 메소드와 같은 기능을 한다. 그런데 이놈은 독랩적인 존재
// 함수를 만들때는 function keyword를 이용
// 당연히 함수이름이 있어야 하나 식별자를 붙여준다.
// 인자와 실행코드가 block으로 표현

// function myFunc() {

//     var x = 200;
//     console.log(x);
// }

// console.log(x); // 1이 찍힌다 myFunc위에 선언해 놓은 x의 값을 가져오기 때문
// myFunc(); // myFunc의 코드를 찾아서 ()안의 있는 문장을 실행하라는 의미다. x의 값이 임시로 찍히는 변수로 선언되므로 그러므로 200 이 찍힌다. 
// console.log(x); // 위에 것을 가져오는게 아니다. 왜냐면 myFunc문장안에서만 끝이났기 때문에 myFunc위에 선언된 값을 가져온다.     

// console.log(x);

// x = 100;

// console.log(x);

// var x;
// // 처음 컨솔이 실행되면서 선언구문을 찾는다 맨 밑에 있는거를 확인되므로 x의 값은 undefined가 나오게 되고 변수 선언된 x 가 2바퀴 째에 위에 x = 100 이라고 설정되어있으므로 
// // 두번 째 x는 100이 나온다.

// console.log(x); // 실행문 , 이 문장은 error다. error인 이유는 두바퀴를 돌아도 선언구문이 없기 때문에 x를 찾을 수가 없다.

// x = 100; // 실행문 , 암묵적 전역 ! 

// console.log(x); 

// function myFunc() {  // 함수를 선언하고 myfunc 라는 변수 선언 후 실행은 안하고 넘어간다.
//     console.log(x);
//     var x;
// }

// myFunc();

// 3)
// 이번에는 let에 대해 알아보자
// let은 var와 똑같이 변수를 선언하기 위한 키워드
// ES6에서 도입되었다.
// 이놈은 Block level scope이고 우리가 알고 있는 변수 선언방식을 이용한다.

// let은 같은 스코프 내에서 중복 선언이 안된다.
// let result = 100;
// let result = 50;

// block level scope
// let score = 50; // 이 let의 영역은 전체이다. 그러므로 이 문장들은 중복 선언이 아니다.

// {
//     let scroe = 100; // 이 let 변수의 영역은 {} 안에만 이다. 
//     let myVar = 10;
// } // {}안에 있는 문장들은 {가 생겼을 때 변수가 생성되었다가 } 가 끝이나면 변수도 없어진다. let은 자기가 선언된 문장안에서만 생존가능

// console.log(score); // 50
// console.log(myVar); // error

// let i = 100; // i에 대한 scope는 처음부터 끝까지 이다. 처음부터 끝까지 살아있기 때문이다. 그렇기 때문에 i를 전역변수(전체영역변수) 라고 한다.

// function myFunc() {
//     let i = 10;  // 여기서 i는 지역변수(local variable)이다. {}안에서만 살아있기 때문이다.
    
//     for(let i = 0; i <3; i++){ // for문에 있는 i와 위에 있는 i는 서로 다른 지역변수이다.
//         console.log(i); // 012
//     }
//     console.log(i); // 10
// }

// myFunc(); // 이렇게 myFunc를 선언해주지 않으면 실행되지 않는다.

// console.log(i); // 100

// console.log(x); //undefined 일줄 알았으나 error가 발생한다. 
// // 자바스크립트에서 hoisting은 어디에서나 일어나고 let을 선언된 경우에도 일어나지만
// // 실제 x를 사용할 수 있게되는 시점은 
// // x를 초기화한 이후부터 사용할 수 있다.
// // 이 영역을 Temporal Dead Zone(TDZ)라고 부른다. 
// // 첫바퀴에 x가 선언되고 두번째 바퀴에서 x가 100이라고 들어가기 까지 의 그 공간을 TDZ라고 한다. 

// let x = 100;

// 4)
// Hoisting은 var,let,const 몽땅 일어나는 현상.

let myVar = 1; // 전역변수(global variable)

{
    console.log(myVar);
    let myVar = 100;
}

console.log("test");