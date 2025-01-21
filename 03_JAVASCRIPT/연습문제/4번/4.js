const user = document.querySelector("#user");
const com = document.querySelector("#com");   

const userBtn = document.querySelectorAll(".user-btn > button"); 

const startBtn = document.querySelector("#startBtn");

const score = document.querySelectorAll("#score > th");


const gameHistory = document.querySelector("#gameHistory");


let gameCount = 1;


let maxCount;

const choice = ["가위", "바위", "보"];




startBtn.addEventListener("click", () => {

  maxCount = prompt("진행할 판 수를 입력하세요");

  if(maxCount === null || isNaN(Number(maxCount))){
    alert("숫자 입력 후 확인을 눌러주세요");
    return;
  }

  gameCount = 0;
  

  user.src = "";
  com.src = "";
  gameHistory.innerHTML = "";
  for(let i = 0; i < score.length; i++) score[i].innerHTML = "0";
});




for(let i = 0 ; i < userBtn.length; i++){

  userBtn[i].addEventListener("click", () => {

    if(maxCount === null || maxCount === undefined){
      alert("GAME START 버튼을 눌러 게임을 시작해 주세요!!!");
      return;
    }

    if(gameCount >= maxCount){
      alert("게임이 종료 되었습니다. 다시 하시려면 GAME START 버튼을 눌러주세요");
      return;
    }

    gameCount++;


    const userChoice = choice[i]; 

 
    const cNum = Math.floor(Math.random() * 3);
    const comChoice = choice[cNum]; 



    user.src = `images/${userChoice}L.png`;
    com.src = `images/${comChoice}R.png`;


    const str = `<span>${userChoice}</span> VS <span>${comChoice}</span>`

    if(userChoice === comChoice){ 
      score[1].innerHTML = Number(score[1].innerHTML) + 1;
      
      gameHistory.innerHTML
        += `<li> <span class="draw">DRAW</span> ${str} </li>`;
    }

    else if((userChoice === '가위' && comChoice === '보')
        ||  (userChoice === '바위' && comChoice === '가위')
        ||  (userChoice === '보'   && comChoice === '바위') ){

        score[0].innerHTML = Number(score[0].innerHTML) + 1; 

      gameHistory.innerHTML
        += `<li> <span class="win">WIN</span> ${str} </li>`;  
        
    } else{ 

      score[2].innerHTML = Number(score[2].innerHTML) + 1; 

      gameHistory.innerHTML
        += `<li> <span class="lose">LOSE</span> ${str} </li>`;  
    }

    const resultBoard = document.querySelector(".result-board");

    resultBoard.scrollTop = resultBoard.scrollHeight;
  });


}
