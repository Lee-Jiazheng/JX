        $(".nav_ul .nav_li").mouseover(function(){
            $(this).addClass('active');
            $(this).find(".nav_dropdown").show();	
        });
        $(".nav_ul .nav_li").mouseout(function(){
            $(this).removeClass('active');
            $(this).find(".nav_dropdown").hide();	
        });
        $(".nav_ul .nav_li .nav_dropdown").mouseover(function(){
            $(this).show();	
        });
        $(".nav_ul .nav_li .nav_dropdown").mouseout(function(){
            $(this).hide();	
        });