window.onload = function (){
    document.getElementById("form").onsubmit = function (){
        checkusername();
        checkpassword();
        return checkusername() && checkpassword();
    }
    onbulrMouse();
}
function onbulrMouse(){
    document.getElementById("username").onblur = function (){
        checkusername();
    }
    document.getElementById("password").onblur = function (){
        checkpassword();
    }
}

function checkusername(){
    //获取用户名输入框内的值
    var username = document.getElementById("username").value;
    //定义正则表达式
    var reg = /^\w{6,12}$/;
    //是否匹配
    var flag = reg.test(username);
    //获取span控件
    var checkusername = document.getElementById("checkusername");
    if(flag){
        checkusername.innerHTML = "<img src='./img/checked.png' width='20px' height='20px' align='center'>"
    }else {
        checkusername.innerHTML = "用户名格式不正确！";
    }
}

function checkpassword(){
    //获取密码输入框内的值
    var password = document.getElementById("password").value;
    //定义正则表达式
    var reg = /^\w{6,12}$/;
    //是否匹配
    var flag = reg.test(password);
    //获取span控件
    var checkpassword = document.getElementById("checkpassword");
    if(flag){
        checkpassword.innerHTML = "<img src='./img/checked.png' width='20px' height='20px' align='center'>"
    }else {
        checkpassword.innerHTML = "密码格式不正确！";
    }
}