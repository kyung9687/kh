const keys = document.querySelectorAll(".key");
const display = document.querySelector("#display");
const reset = document.querySelector("#resetBtn");
const addBtn = document.querySelector("#addBtn")
const  number_list = document.querySelector(".number-list")
for (let key of keys) {
  key.addEventListener("click", e => {
    
    if (display.innerText.length < 13) {
      let newText = display.innerText + e.target.innerText;
      if (newText.length === 3 || newText.length === 8) {
        newText += "-";
      }

      display.innerText = newText;
    } else {
      alert("11자 까지만 입력할 수 있습니다");
      return;
    }
  });
}
addBtn.addEventListener("click",e=>{
  if(display.innerText.length == 0){
    alert("전화번호가 입력되지 않았습니다")
  }
  else{
  const li = document.createElement("li");

    const span1 = document.createElement("span");
    span1.textContent = display.textContent;
  
    const span2 =document.createElement("span");
    span2.textContent = "☆"
    span2.addEventListener("click",e =>{
      const parent = e.target.parentElement;
      if(parent.classList.contains("favorites")) {
        parent.classList.remove("favorites");
        e.target.textContent = "☆";

    } else {
        parent.classList.add("favorites");
        e.target.textContent = "★";

    }
    })

    const span3 = document.createElement("span");
    span3.innerHTML = "&times;";
    span3.addEventListener("click", e => {
      e.target.parentElement.remove();
    });

  li.append(span1,span2,span3);
  number_list.append(li)
  }
  display.innerText = ""; 
})

reset.addEventListener("click", e => {
  display.innerText = "";
})