const resName = document.querySelector("#resName");
const resNameInput = document.querySelector("#resNameInput");


resName.addEventListener("click",e=>{

  resName.classList.add("res-name-hidden");
  
  resNameInput.classList.remove("res-name-hidden")

})

resNameInput.addEventListener("blur", e => {

  resNameInput.classList.add("res-name-hidden");
  resName.classList.remove("res-name-hidden");


  if(resNameInput.value.trim() === ""){
    resName.textContent = "식당명을 입력하세요";
    return;
  }
  resName.textContent = resNameInput.value;
});

const updateBtn = document.querySelector("#updateBtn");
const addMenu = document.querySelector("#addMenu");
const deleteMenu = document.querySelector("#deleteMenu");
const exitBtn = document.querySelector("#exitBtn");

const normalContainer = document.querySelector(".normal-container");
const editContainer = document.querySelector(".edit-container");
const menuContainer = document.querySelector(".menu-container");


updateBtn.addEventListener("click",()=>{
  normalContainer.classList.toggle("b-hidden")
  editContainer.classList.toggle("b-hidden")
  const menus =document.querySelectorAll(".menu")

  menus.forEach(item=>{
    const menuName =item.children[0].innerText;
    const menuPrice =item.children[1].innerText.replace('원','');

    const menuContent =createMenuContent();

    menuContent.menuNameInput.value
      =(menuName ==="미입력") ?"": menuName;

    menuContent.menuPriceInput.value
     =(menuPrice === "0")? "" : menuPrice;
    
     item.innerHTML ="";
    for(let key in menuContent){
      item.append(menuContent[key])
    }
  })
})


exitBtn.addEventListener("click",()=>{
  normalContainer.classList.toggle("b-hidden")
  editContainer.classList.toggle("b-hidden")

  const menus =document.querySelectorAll(".menu")
  menus.forEach(item =>{
    const menuName = item.children[1].value;
    const menuPrice = item.children[2].value;

    const span1 = newEl("span",{},["menu-name"])
    span1.innerText
      = (menuName.trim() ==="" ?"미입력" : menuName);
  
    const span2 = newEl("span",{},["menu-price"]);
    span2.innerText
      = (menuName.trim() ==="" ?"미입력" : menuPrice);

      item.innerHTML ="";
      item.append(span1, span2);
  })
  
})


addMenu.addEventListener("click",()=>{

  if(document.querySelectorAll(".menu").length >= 15){
    alert("더 이상 메뉴를 추가할 수 없습니다");
    return;
  }


  const li = newEl("li",{},["menu"]);

  const menuContent = createMenuContent();

  for(let key in menuContent){
    li.append(menuContent[key]);
  }
  menuContainer.append(li);
})


deleteMenu.addEventListener("click", e => {
  const checkMenu = document.querySelectorAll(".menu-check:checked");
  checkMenu.forEach(item => {
    item.parentElement.remove();
  });
});




function newEl(tag, attr,cls) {
  const el =document.createElement(tag);

  for(let key in attr){
    el.setAttribute(key,attr[key])
  }
  for(let className of cls){
    el.classList.add(className)
  }
  return el;
}

function createMenuContent() {
  const check = newEl("input",{type:"checkbox"},["menu-check"]);
  const menuNameInput
    = newEl("input",
      {type:"text",placehoder:"메뉴명"},
      ["menu-name-input"]
    );

  const menuPriceInput
    = newEl("input",
      {type:"text",placehoder:"가격"},
      ["menu-price-input"]
    );

  return {
    "check" : check,
    "menuNameInput" : menuNameInput,
    "menuPriceInput" : menuPriceInput
  }
}