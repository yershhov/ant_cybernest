let a;

function show_hide(id) {
    if (a == 1) {
        document.getElementById("change" + id).style.display = "none";
        return a = 0;
    } else {
        document.getElementById("change" + id).style.display = "inline";
        return a = 1;
    }
}