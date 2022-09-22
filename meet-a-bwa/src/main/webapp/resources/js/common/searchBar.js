/**
 * 
 */
 $(document).ready(function() {
    console.log("search ready");
    
    let category = [];
    $.ajax({
        url : "resources/text/cate.txt",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        success : function(res){
            category = res.split("\r\n");
            console.log(category);
            category_load(category);
        }
    });
 
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