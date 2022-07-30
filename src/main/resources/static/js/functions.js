var url = '';

$('button[id*="btn_"]').click(function(){
  url = "/" + $(this).attr('id').split("_")[1];
})

$('#ok_confirm').click(function(){
  document.location.href = url;
})

$(function() {
    $('[data-bs-toggle="popover"]').popover({
        html: true,
        title : '<a href="#" class="close" data-bs-dismiss="alert" align="right">X</a>'
    });
});

$(document).on("click", ".popover .close" , function(){
    $(this).parents(".popover").popover('hide');
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