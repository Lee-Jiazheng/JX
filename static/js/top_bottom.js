        $(document).ready(function() {  
             var scrollPos=$(window).scrollTop();  
                if(scrollPos >=120){  
                    change_navbar();
                }else{  
                    reset_navbar();
                }  

            $(window).scroll(function(){  
                var scrollPos=$(window).scrollTop();  
                if(scrollPos >=120){ 
                     change_navbar(); 
                    if(scrollPos>=300){
                        $('#return_top').fadeIn(200);
                    } 
                    else{
                        $('#return_top').fadeOut(200);
                    }           
                }else{  
                    reset_navbar();
                }  
            });  

       });  
        function rotate_arrow(i){
            if(i==0){
                $("#dropdown").removeClass("fa-angle-up"); 
                $("#dropdown").addClass("fa-angle-down"); 
                $(".drop_down_block").css('display',"block");
            }
            else if(i==1){
                $(".drop_down_block_s").css('display',"block");
            }

        }
        function reset_arrow(i){
            if(i==0){
                $("#dropdown").removeClass("fa-angle-down");
                $("#dropdown").addClass("fa-angle-up");  
                $(".drop_down_block").css('display',"none");
            }
            else if(i==1){
                $(".drop_down_block_s").css('display',"none");
            }
        }
        function change_navbar(){
                $(".fixed_nav").attr('id',"fixed"); 
                $(".smalllogo").show();
                $(".nav_li").css('padding','6px 30px 0');
                $(".first").css('margin-left','165px');
                $(".user_info").css('display',"block");
        }
        function reset_navbar(){
                $(".fixed_nav").removeAttr("id"); 
                $(".smalllogo").hide();
                $(".nav_li").css('padding','6px 50px 0');
                $(".first").css('margin-left','50px');
                $(".user_info").css('display',"none");   
        }
        
        $('.go_to_top').click(function(){
            $('body,html').animate({scrollTop:0},1200);
        });

