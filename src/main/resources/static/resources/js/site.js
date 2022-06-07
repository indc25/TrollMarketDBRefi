var moneyConversions = document.querySelectorAll(".moneyConversion");
for(let element of moneyConversions){
	let convertedValue = Number(element.value).toFixed(2);
	element.value = convertedValue;
}
var numberInputs = document.querySelectorAll("[type=number]");
for(let element of numberInputs){
	if(element.value == ""){
		element.value = 0;
	}
}
var dateInputs = document.querySelectorAll("[type=date]");
for(let element of dateInputs){
	if(element.getAttribute("value") != ""){
		let dateValue = new Date(element.getAttribute("value"));
		let formatted = dateValue.toISOString().split('T')[0];
		element.value = formatted;
	}
}
let alternateAction = document.querySelector(".alternate-action table");
if(alternateAction != null){
	let actionType = alternateAction.getAttribute("data-action");
	document.querySelector(".alternate-action").setAttribute("action", actionType);
	if(actionType === "update"){
		document.querySelector(".readonly-id").setAttribute("readonly", "readonly");
	}
}
let role = document.querySelector(".role");
if(role != null){
	let roleName = role.textContent;
	let formatted = roleName.replace('[', '').replace(']', '').replace('ROLE_', '');
	role.textContent = formatted;
}
let mainBody = document.querySelector(".main-body");
let roleName = mainBody.getAttribute("data-role");
let formatted = roleName.replace('[', '').replace(']', '').replace('ROLE_', '');
mainBody.setAttribute("data-role", formatted);