$(function () {
    function readURL(input) {
        if (input.files && input.files[0]) {
           var reader = new FileReader();
           reader.onload = function(e) {
              $('#image').attr('src', e.target.result);
            }
            reader.readAsDataURL(input.files[0]);
            if(input.files[0]!=null){
               console.log($("#image").attr('src'));
               $('#delete-file1').css('display','block');
               $('#delete-file1').css('opacity','1');
               // $('#delete-file2').css('display','block');
            }
        }
     }
     
     $("#input-file").change(function() {
        readURL(this);
     });
     
     $('#delete-file1').click(function(){
      $('#image').attr('src',"/meet-a-bwa/resources/img/placeholder1.webp");
      $('#delete-file1').css('display','none');
      // $('#delete-file1').css('opacity','0');
      });

     
     
});