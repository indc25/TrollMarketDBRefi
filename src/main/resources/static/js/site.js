﻿(function () {
  let request = new XMLHttpRequest();
  request.open("GET", "http://localhost:1234/troll-market/api/profile/find-by-id/1");
  request.send();
  request.onload = function () {
    let profile = JSON.parse(request.responseText);
    drawRow(profile);

//    createDetailButtonListener();
  };
//  createCloseButtonListener();
})();

function drawRow({
    fullName,
    role,
    address,
    phone,
    balance
}) {
  document.getElementById("welcome").innerHTML = `${fullName}`;
  document.getElementById("fullName").innerHTML = `: ${fullName}`;
  document.getElementById("role").innerHTML = `: ${role}`;
  document.getElementById("address").innerHTML = `: ${address}`;
  document.getElementById("phone").innerHTML = `: ${phone}`;
  document.getElementById("balance").innerHTML = `: Rp.${balance}`;
//  firstName.innerHTML = `${firstName}`;
//  lastName.innerHTML = `${lastName}`;
//  gender.innerHTML = `${gender}`;
//  phone.innerHTML = `${phone}`;

//  let tableRow = document.createElement("tr");
//  let cellString = `
//  <td>${firstName}</td>
//  <td>${lastName}</td>
//  <td>${gender}</td>
//  <td>${phone}</td>
//    `;
//  tableRow.innerHTML = cellString;

//  let tableBody = document.querySelector(".content table > tbody");
//  tableBody.appendChild(tableRow);
}

//function createCloseButtonListener() {
//  let closeButton = document.querySelector(".close-button");
//  closeButton.addEventListener("click", function (event) {
//    let modal = document.querySelector(".modal");
//    modal.classList.remove("show-modal");
//  });
//}
//
//function createDetailButton(id) {
//  let buttonString = `
//    <a class="detail-button" href="javascript:;" data-id=${id}>
//        <i class="fas fa-address-card"></i>
//        Detail
//    </a>
//    `;
//  return buttonString;
//}
//
//function createDetailButtonListener() {
//  let detailButtons = document.querySelectorAll(".detail-button");
//  for (let button of detailButtons) {
//    button.addEventListener("click", function (event) {
//      let userId = button.getAttribute("data-id");
//      requestSingleUser(userId);
//    });
//  }
//}
//
//function requestSingleUser(productId) {
//  let actionUrl = `https://dummyjson.com/products/${productId}`;
//  let request = new XMLHttpRequest();
//  request.open("GET", actionUrl);
//  request.send();
//  request.onload = function () {
//    let product = JSON.parse(request.responseText);
//    console.log(product);
//    fillDetailInformation(product);
//
//    let modal = document.querySelector(".modal");
//    modal.classList.add("show-modal");
//  };
//}
//
//function fillDetailInformation({
//  title,
//  description,
//  price,
//  discountPercentage,
//  rating,
//  stock,
//  brand,
//  category,
//  thumbnail,
//}) {
//  document.querySelector(".dialog .title").textContent = title;
//  document.querySelector(".dialog .description").textContent = description;
//  document.querySelector(".dialog .price").textContent = price;
//  document.querySelector(".dialog .discountPercentage").textContent =
//    "$" + discountPercentage;
//  document.querySelector(".dialog .rating").textContent = rating;
//  document.querySelector(".dialog .stock").textContent = stock;
//  document.querySelector(".dialog .brand").textContent = brand;
//  document.querySelector(".dialog .category").textContent = category;
//  document.querySelector(".dialog .thumbnail").src = thumbnail;
//}
