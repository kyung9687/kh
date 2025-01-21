const numbers = document.querySelectorAll(".number");
const reset = document.querySelector("#reset");
const result = document.querySelector("#result");


for (let number of numbers) {
  number.addEventListener("click", e => {
    
    if (result.innerText.length < 10) {
      result.innerText += e.target.innerText;
    } else {
      alert("10자 까지만 입력할 수 있습니다");
      return;
    }
  });
}

reset.addEventListener("click", e => {
  result.innerText = "";
})