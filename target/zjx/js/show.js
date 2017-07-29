
            var min_product_num=1;
            var reg = new RegExp("^[0-9]*");
            if($('.review_item').length!=0){
                $('#product_review').html("评价 ( "+$('.review_item').length+" )");
            }


            $('.icon-minus').css('cursor','not-allowed');

            $('.small_button').mouseover(function(){
                $('.icon-shoucang').css('color','white');
                $('.icon_description').css('color','white');
                $(this).css('background-color','#15a8e0');
            });
            $('.small_button').mouseout(function(){
                $('.icon-shoucang').css('color','#15a8e0');
                $('.icon_description').css('color','#15a8e0');
                $(this).css('background-color','white');
            });
            $('.num_input').change(function(){
                $(this).val($(this).val().match(reg));
                
                if($(this).val()==max_product_num){
                    $('.icon-plus').css('cursor','not-allowed');
                }
                else if($(this).val()>max_product_num){
                    $('.icon-plus').css('cursor','not-allowed');
                    $(this).val(max_product_num);
                    product_num_max();
                }
                else if($(this).val()==min_product_num){
                    $('.icon-minus').css('cursor','not-allowed');
                }
                else if($(this).val()<min_product_num){
                    $('.icon-minus').css('cursor','not-allowed');
                    $(this).val(min_product_num);
                    product_num_min();
                }
                else{
                    $('.icon-plus').css('cursor','pointer');
                    $('.icon-minus').css('cursor','pointer');
                }
            });

            $('.icon-plus').click(function(){
                if($('.num_input').val()>=max_product_num){
                    product_num_max();
                    $('.icon-plus').css('cursor','not-allowed');   
                }
                else{
                    $('.num_input').val(parseInt($('.num_input').val())+1);
                    if($('.num_input').val()>=max_product_num){
                        $('.icon-plus').css('cursor','not-allowed');   
                    }
                    if($('.num_input').val()!=min_product_num){
                        $('.icon-minus').css('cursor','pointer');
                    }
                }
            });
            

            $('.icon-minus').click(function(){
                if($('.num_input').val()<=min_product_num){
                    product_num_min();
                    $('.icon-minus').css('cursor','not-allowed');  
                }
                else{
                    $('.num_input').val(parseInt($('.num_input').val())-1);
                    if($('.num_input').val()<=min_product_num){
                        $('.icon-minus').css('cursor','not-allowed');   
                    }
                    if($('.num_input').val()!=max_product_num){
                        $('.icon-plus').css('cursor','pointer');   
                    }
                }
            });

            function product_num_max(){
                $('.max_tip').show();
                $('.max_tip').animate({opacity:1},200,function(){
                    $('.max_tip').delay(1700).animate({opacity:0},2000,function(){
                            $('.max_tip').delay(2400).hide();
                    });
                });
            };

            function product_num_min(){
                $('.min_tip').show();
                $('.min_tip').animate({opacity:1},200,function(){
                    $('.min_tip').delay(1700).animate({opacity:0},2000,function(){
                            $('.min_tip').delay(2400).hide();
                    });
                });
            }

            $('.product_img').mouseover(function(){
                $(this).animate({height:"162px"},100);
            });
            
            $('.product_img').mouseout(function(){
                $(this).animate({height:"160px"},100);
            });

            $('#product_detail').click(function(){
                $('.product_review').hide();
                $('.product_info_content').show();
                $('#product_detail').addClass('active');
                $('#product_review').removeClass('active');
                $('#product_detail').css('border-right','1px solid #e8e8e8');
            });

            $('#product_review').click(function(){
                $('.product_info_content').hide();
                $('.product_review').show();
                $('#product_review').addClass('active');
                $('#product_detail').removeClass('active');
                $('#product_detail').css('border-right','none');
            });