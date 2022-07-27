var url = '';

$('button[id*="btn_"]').click(function(){
  url = "/" + $(this).attr('id').split("_")[1];
})

$('#ok_confirm').click(function(){
  document.location.href = url;
})

$(function() {
    $('[data-toggle="popover"]').popover();
});

$(document).ready(function(){

    setTimeout(function(){
        $(".alert").fadeOut("slow", function(){
            $(this).alert("close");
        })
    }, 3000)

    $(".navbar-toggle").click(function(){
        $(".sidebar").toggleClass("sidebar-open");
    })
});