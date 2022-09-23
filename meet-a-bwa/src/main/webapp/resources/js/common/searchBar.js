/**
 * 
 */
 $(document).ready(function() {
    let category = [];
    
    $("#detailCategory").click(function(){
    	$.getJSON("/meet-a-bwa/resources/json/cate.json", function(data) {
            category = data.category;
            console.log(category);
            category_load(category);
        });
    });
 
    function category_load(arr){
        let cnt = 1;
        let sample = $(".detailCate_list:eq(0)").clone();

        /* prop-flag */
        for(x of arr){
            let list = sample.clone();
            list.text(x);
            list.val(x);
            list.attr("idx", cnt++);
            $("#detailCategory").append(list);
        }
    }
    
 });