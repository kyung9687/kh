const btn = document.querySelector("#btn");
const sumBtn = document.querySelector("#sumBtn");
const result = document.querySelector("#result");
const container = document.querySelector("#container");
const count = document.querySelector("#count")

btn.addEventListener("click", e=>{
  
  container.innerHTML=""
  for (let i = 0; i < count.value; i++) {
    const input = document.createElement("input");
    input.className = "input-number";
    input.type = "number";
    container.append(input);
  }
})

sumBtn.addEventListener("click",()=>{
  const inputs = document.querySelectorAll(".input-number");
  
  let sum = 0;

  for(let input of inputs){
    sum += Number(input.value);
  }

  result.innerText = sum;
})