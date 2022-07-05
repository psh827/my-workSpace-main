$(function(){
  $('.select-email').change(function(){
    $('#back-email').attr('value', $('.select-email option:selected').val());
  })
});
