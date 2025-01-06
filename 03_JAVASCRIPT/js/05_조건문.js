/* if 예제 - 양수인지 검사 */
function check1(){
  // id가 "input1"인 요소를 얻어와 in1 상수에 저장
  const in1 = document.getElementById("input1");
  // id가 "input1"인 요소에 작성된 값을 얻어와 숫자로 변환하여
  // val 변수에 저장
  const val = Number(in1.value);

  // d양수가 맞는지 검사
  if(val > 0){
    // 조건식이 true인 경우 수행할 코드
    alert(`${val}은/는 양수입니다`);
  }
  if(val<=0){
    alert(`${val}은 양수가 아닙니다.`)
  }
}

function check2(){
  const randomNumber= Math.floor(Math.random()*100+1);

  if(randomNumber%2 ===1){
    alert(`${randomNumber}은/는 [홀수]입니다`)
  }
  else{
    alert(`${randomNumber}은/는 [짝수]입니다`)
  }
}

function check3(){
  const input3 = document.getElementById("input3");
  const val = Number(input3.value);
  let result;

  if(val >0) {
    result="양수"
  }
  else if(val<0){
    result="음수"
  }
  else{
    result="0"
  }
  alert(`${val}은/는 ${result}입니다.`)
}


function ageCheck(){
  const inputAge = document.getElementById("inputAge");
  const val = Number(inputAge.value)
  let result;
  if(val>=0 && val<=13) {
    result="어린이"
  }
  else if(val>=14 && val<=19){
    result="청소년"
  }
  else if(val>=19 && val<=120){
    result="성인"
  }
  else{
    result="잘못 입력하셧습니다 "
  }
  alert(`${val}살은 ${result}`)
}