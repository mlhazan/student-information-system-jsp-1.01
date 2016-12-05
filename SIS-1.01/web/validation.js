function isReady(form){
    
     if(!isEmail(form.EMAIL)){
            alert("Please enter a valid email address");
            form.EMAIL.focus();
            return false;
    }

    if( !isFilled(form.STREET_ADDRESS)){
            alert("Please enter a valid street address");
            form.STREET_ADDRESS.focus();
            return false;
    }
    if(!isFilled(form.CITY)||!isAlpha(form.CITY)){
            alert("Please enter city name");
            form.CITY.focus();
            return false;

    }
    if(!isFilled(form.PROVINCE_STATE)||!isAlpha(form.PROVINCE_STATE)){
            alert("Please enter State name");
            form.PROVINCE_STATE.focus();
            return false;

    }

    if(!isFilled(form.POSTAL_CODE)){
            alert("Please enter Postal code");
            form.POSTAL_CODE.focus();
            return false;

    }

    if(!isFilled(form.COUNTRY)||!isAlpha(form.COUNTRY)){
            alert("Please enter country name");
            form.COUNTRY.focus();
            return false;

    }
    if(!isPhone(form.PHONE_NUMBER)){
            alert("Please enter a valid phone number");
            form.PHONE_NUMBER.focus();
            return false;
    }

    
   
    return true;
}

function canLogin(form)
{
    if(!isFilled(form.id)){
            alert("Please enter user name");
            form.id.focus();
            return false;
    }
    if(!validateUsername(form.id)){
        return false;
    }

    if(!isFilled(form.password)){
            alert("Please enter password");
            form.password.focus();
            return false;
    }
    return true;
}

function isFilled(elm){
    if(elm.value=="" || elm.value==null){
        return false;
    }
    else {
        return true;
    }
}

function isEmail(elm){

    if(elm.value.indexOf("@") !="-1" && elm.value.indexOf(".") !="-1")
    {
        return true;
    }
    else {
        return false;
    }
}

function isAlpha(elm){
    if(elm.value==""){
        return false;
    }
    for(var x=0; x < elm.value.length; x++){
        if ((elm.value.charAt(x) < "a" || elm.value.charAt(x) > "z") &&
            (elm.value.charAt(x) < "A" || elm.value.charAt(x) > "Z")){
            return false;
        }
    }
    return true;
}


function isPhone(elm){
    if(elm.value.length !=12){
        return false;
    }
    for (var x = 0; x <elm.value.length; x++){
            if((x > -1 && x <3) || (x >3 && x < 7) || (x >7 && x< 12))
            {
                if(elm.value.charAt(x) < "0" || elm.value.charAt(x) > "9" ){
                    return false;
                }
            }
            else if(elm.value.charAt(x) !="-"){
                return false;
            }
    }
    return true;
}
function validateUsername(elm) {
    var error = "";

    if (elm.value.length != 9) {
        elm.style.background = 'Yellow';
        error = "The username is the wrong length.\n";
        alert(error);
    } else if (elm.value != parseInt(elm.value) ) {
        elm.style.background = 'Yellow';
        error = "The username contains illegal characters.\n";
        alert(error);
    } else {
        return true;
    }
    return false;
}