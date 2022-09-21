$(document).ready(function() {
    console.log("ready");
    let category = [];
    $.ajax({
        url : "../txt/cate.txt",
        success : function(res){
            category = res.split("\r\n");
            console.log(category);
            category_load(category);
        }
    });

    $("#plusImg").click(function(){
        $("#fold_tag").toggleClass("blind");
    });

    $(".tagItem").click(function(e){
        $(".tagItem").removeClass("check");
        $(e.target).addClass("check");
    })


    function category_load(arr){
        let cnt = 0;
        let sample = $("#detailCategory>.sample").clone().removeClass("sample");

        let all = sample.clone();
        all.text('전체');
        all.attr("idx", cnt);
        all.attr("selected", true);
        $("#detailCategory").append(all);
        cnt++;

        for(x of arr){
            let list = sample.clone();
            list.text(x);
            list.attr("idx", cnt++);
            $("#detailCategory").append(list);
        }

        $("#detailCategory>.sample").addClass("blind");
    }
});