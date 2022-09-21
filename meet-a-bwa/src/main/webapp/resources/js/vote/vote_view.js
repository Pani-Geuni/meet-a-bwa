$(function(){

    $("#delete").click(function(){
        $("#confirmWrap").removeClass("blind");
        $("#dropdown").removeClass("select_custom");
        $("#dropdown").addClass("blind");
    });

    $("#noBtn").click(function(){
        $("#confirmWrap").addClass("blind");
    });

    $("#more_vertival").click(function(){
        if($("#dropdown").hasClass("blind")){
            $("#dropdown").addClass("select_custom");
            $("#dropdown").removeClass("blind");
        }else{
            $("#dropdown").removeClass("select_custom");
            $("#dropdown").addClass("blind");

        }
    });
});