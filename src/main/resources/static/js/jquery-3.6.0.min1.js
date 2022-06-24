(function () {
    let detailBtn = document.querySelectorAll(".detailBtn");
    for (var i = 0; i < detailBtn.length; i++) {
        detailBtn[i].addEventListener("click", function (event) {
            detailBtn = event.target;
//            console.log("click");
            let productId = detailBtn.getAttribute("data-id");
            requestSingleProduct(productId);
        });
    }

    //if close button is clicked
            let span = document.getElementsByClassName("close");
            for (var i = 0; i < span.length; i++) {
                span[i].onclick = function () {
                    modal.style.display = "none";
                }
            }

            let span1 = document.getElementsByClassName("close1");
            for (var i = 0; i < span1.length; i++) {
                span1[i].onclick = function () {
                    modalDetail.style.display = "none";
                }
            }

              // When the user clicks anywhere outside of the modal, close it
              window.onclick = function(event) {
                if (event.target == modal) {
                  modal.style.display = "none";
                }
              }

              window.onclick = function(event) {
                if (event.target == modalDetail) {
                  modalDetail.style.display = "none";
                }
              }
})();


function requestSingleProduct(productId) {
  let actionUrl = `http://localhost:1234/troll-market/api/product/find-by-id/${productId}`;

  let request = new XMLHttpRequest();
  request.open("GET", actionUrl);
  request.send();
  request.onload = function () {
    let product = JSON.parse(request.responseText);
//    console.log(product);
    fillDetailInformation(product);

    let modalDetail = document.getElementById("modalDetail");
    modalDetail.style.display = "block";
  };
}

function fillDetailInformation({
  productName,
  categoryName,
  description,
  unitPrice,
  sellerName,
}) {
  document.querySelector(".modal-content2 .productName").textContent =
    productName;

  document.querySelector(".modal-content2 .categoryName").textContent =
    categoryName;

  document.querySelector(".modal-content2 .description").textContent =
    description;

  document.querySelector(".modal-content2 .unitPrice").textContent =
    unitPrice;

  document.querySelector(".modal-content2 .sellerName").textContent =
    sellerName;
}
