  var modal = document.getElementById("myModal");
  var modalDetail = document.getElementById("modalDetail");

  // Get the button that opens the modal

  //multiple button 1 class implementation
  btns = document.getElementsByClassName("");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
			//Add function here
      modal.style.display = "block";
        });
    }

    detailBtns = document.getElementsByClassName("infoBtn");
    for (var i = 0; i < detailBtns.length; i++) {
        detailBtns[i].addEventListener("click", function() {
			//Add function here
      modalDetail.style.display = "block";
        });
    }
  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];
  //span detail
  var span1 = document.getElementsByClassName("close1")[0];

  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }
  //close detail
  span1.onclick = function() {
    modalDetail.style.display = "none";
  }



  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }

  window.onclick = function(event) {
    if (event.target == detailModal) {
      modalDetail.style.display = "none";
    }
  }
