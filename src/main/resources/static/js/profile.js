let a;
let b;
function show_hide(id) {
    if (a == 1) {
        document.getElementById("change" + id).style.display = "none";
        return a = 0;
    } else {
        document.getElementById("change" + id).style.display = "inline";
        return a = 1;
    }
}
function show_hide_user(id) {
    if (b == 1) {
        document.getElementById("change" + id).style.display = "none";
        return b = 0;
    } else {
        document.getElementById("change" + id).style.display = "inline";
        return b = 1;
    }
}