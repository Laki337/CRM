$(document).ready(function(){
    $(".open-window").click(function(){
        let args= document.getElementById("args1").getAttribute("data-arg");
        alert(args);
      //  $(".window").slideToggle("100").delay(5000).slideUp(300);
    });
});