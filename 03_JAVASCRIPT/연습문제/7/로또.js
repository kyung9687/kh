const createBtn = document.querySelector("#createBtn");
const resetBtn = document.querySelector("#resetBtn");
const randomBtn = document.querySelector("#randomBtn");
const btnContainer = document.querySelector(".btn-container");
const lottoBoard = document.querySelector("#lottoBoard");


createBtn.addEventListener("click", () => {

  lottoBoard.innerHTML = "";

  for(let i=1 ; i<46 ; i++){
    const number = document.createElement("div");
    number.classList.add("number"); 
    number.textContent = i;

    number.addEventListener("click", e => {

      const count = document.querySelectorAll(".active").length;

      if(count <= 5 || e.target.classList.contains("active")){
        e.target.classList.toggle("active");
      }
      else{
        alert("6개 까지만 선택할 수 있습니다");
      }
    });

    lottoBoard.append(number);

    btnContainer.classList.remove("hidden");
    createBtn.classList.add("hidden");
  }
});
// 선택 초기화 함수
function resetFn(){
  const actives = document.querySelectorAll(".active");
  actives.forEach(item => item.classList.remove("active"));
}
// 랜덤 선택 함수
function randomSelectFn(){
  const set = new Set();
  while(set.size < 6){ 
    const ran = Math.floor(Math.random() * 45 + 1);
    set.add(ran);
  }

  const numbers = document.querySelectorAll(".number");

  set.forEach(num => {
    numbers[num-1].classList.add("active");
  });
  
}

// 초기화 버튼 클릭 시
resetBtn.addEventListener("click", resetFn);

// 랜덤 버튼 클릭 시
randomBtn.addEventListener("click", () => {
  randomBtn.disabled = true; // 클릭 못하게 비활성화

  let currentInterval = setInterval(()=>{
    resetFn(); 
    randomSelectFn(); 
  }, 200);
  
  
  const ran = Math.floor(Math.random() * 6 + 5);
  setTimeout(()=>{
    clearInterval(currentInterval);
    randomBtn.disabled = false;
  }, ran * 200);
  
});