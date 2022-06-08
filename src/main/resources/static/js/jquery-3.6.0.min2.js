
  var modal = document.getElementById("modalAdd");

  // Get the button that opens the modal

  //multiple button 1 class implementation
  btns = document.getElementsByClassName("addBtn");
    for (var i = 0; i < btns.length; i++) {
        btns[i].addEventListener("click", function() {
			//Add function here
      modal.style.display = "block";
        });
    }

  // Get the <span> element that closes the modal
  var span = document.getElementsByClassName("close")[0];
  //span detail

  // When the user clicks on <span> (x), close the modal
  span.onclick = function() {
    modal.style.display = "none";
  }
  //close detail
  // When the user clicks anywhere outside of the modal, close it
  window.onclick = function(event) {
    if (event.target == modal) {
      modal.style.display = "none";
    }
  }
