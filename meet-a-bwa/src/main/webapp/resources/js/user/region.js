$(function () {

  let countryArr = [];

  $("#city").on("change", function (e) {
    const state = $(this).val();
    console.log(state);

    $.ajax({
      url: "/meet-a-bwa/resources/js/user/city.json",
      type: "get",
      dataType: "json",
      success: function (responseTxt, status, obj) {
        countryArr = responseTxt.slice();

        let arr = countryArr.filter(function (value, index) {
          if (value.city == state) {
            return true;
          }
        }).slice();
        arr = arr[0].arr;

        let opt = $(".country_option").clone();
        for (property of arr) {
          opt = opt.clone();
          opt.text(property);
          $("#country").append(opt);
        }
      },
      error: function (xhr, status, error) {
        console.log("error:function....", xhr);
        console.log("error:function....", status);
        console.log("error:function....", error);
      }
    });

  });

  $("#country").on("change", function () {
    console.log($(this).val());
  });

});