$(document).ready(function() {

    $("#plusImg").click(function(){
        $("#fold_tag").removeClass("blind");
        $(this).addClass("blind");
        $("#foldImg").removeClass("blind");
    });
    
    $("#foldImg").click(function(){
        $("#fold_tag").addClass("blind");
        $(this).addClass("blind");
        $("#plusImg").removeClass("blind");
    });

    $(".tagItem").click(function(e){
        $(".tagItem").removeClass("check");
        $(e.target).addClass("check");
    })
    
});