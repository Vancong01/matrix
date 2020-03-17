function myFunction() {
    var value1 = document.getElementById("number1").value;
    var number1 = parseInt(value1);
    var value2 = document.getElementById("number2").value;
    var number2 = parseInt(value2);
    var bieuthuc = document.getElementById("bieuthuc");
    var pheptinh = bieuthuc.options[bieuthuc.selectedIndex].value;
    if (value1 == "" ) {
        alert("Số thứ 1 không được để trống");
    }
    if (value2 == "" ) {
        alert("Số thứ 2 không được để trống");
    }
    if(isNaN(number1)){
        alert("Số thứ 1 không phải là 1 số");
    }
    if(isNaN(number2)){
        alert("Số thứ 2 không phải là 1 số");
    }
    var result = 0;
    switch (pheptinh) {
        case '+':
            result = number1 + number2;
            break;
        case '-':
            result = number1 - number2;
            break;
        case '*':
            result = number1 * number2;
            break;
        case '/':
            if(value2 == "0"){
                alert("Không được chia cho 0");
            }
            result = number1 / number2;
            break;
    }
    document.getElementById("result").value = result;
}

function reset() {
    document.getElementById('number1').value = "0";
    document.getElementById('number2').value = "0";
    document.getElementById("result").value = "0";
}
