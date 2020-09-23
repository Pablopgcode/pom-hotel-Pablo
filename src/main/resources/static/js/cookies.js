let selectorGuest = document.getElementById("guests");

//on load getCookies !!!
//getCookies();


//Function for save session cookies
function saveCookies(){
    var d = new Date();
    d.setTime(d.getTime() + (31 * 24 * 60* 60* 1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = "Checkin=" + document.getElementById("checkin").value + expires;
    document.cookie = "Checkout=" + document.getElementById("checkout").value + expires;
    document.cookie = "Guests=" + selectorGuest.options[selectorGuest.selectedIndex].text + expires;
    

    //document.cookie = "MinPrice=" + document.getElementById("pricefrom").value;
    //document.cookie = "MaxPrice=" + document.getElementById("priceto").value;
    //document.cookie = "Type=" + document.getElementById("roomtype").value;
}

//Function for read saved cookies
function getCookies() {
    document.getElementById("checkin").value = getCookie("Checkin");
    document.getElementById("checkout").value = getCookie("Checkout");
    selectorGuest.options[selectorGuest.selectedIndex].text = getCookie("Guests");


    //document.getElementById("MinPrice").value = getCookie("pricefrom");
    //document.getElementById("MaxPrice").value = getCookie("priceto");
    //document.getElementById("Type").value = getCookie("roomtype");
}

//Function for get every cookies' values
function getCookie(cname) {
    var name = cname + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var ca = decodedCookie.split(';');
    for(var i = 0; i <ca.length; i++) {
        var c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
        }
        if (c.indexOf(name) == 0) {
            return c.substring(name.length, c.length);
        }
    }
    return "";
}