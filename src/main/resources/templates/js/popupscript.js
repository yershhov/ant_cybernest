
// Get the button that opens the modal
var btn1 = document.getElementById("btn1")
var btn2 = document.getElementById("btn2")

// When the user clicks on the button, open the modal
btn1.onclick = function () {
    // Get the modal
    var modal = document.getElementById("myModal1")

    // Get the <span> element that closes the modal
    // var span = document.getElementsByClassName("close")[0];

    // span.onclick = function () {
    //     modal.style.display = "none";
    // }
    modal.style.display = "block";
    // When the user clicks anywhere outside of the modal, close it
    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
}

btn2.onclick = function () {
    var modal = document.getElementById("myModal2")
    // var span = document.getElementsByClassName("close")[0];
    // span.onclick = function () {
    //     modal.style.display = "none";
    // }
    modal.style.display = "block";

    window.onclick = function (event) {
        if (event.target === modal) {
            modal.style.display = "none";
        }
    }
}






