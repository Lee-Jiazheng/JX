            $('.new_address').click(function(){
                $('.address_form_title').text('新建地址');
                $('.widgetcontainer').show();
                $('#address_detail').val('');
                $('#address_receiver_name').val('');
                $('#address_contact').val('');
                $('.address_state').val('new_address');
                $('.address_input').val(0);
            });
            $('.close_form').click(function(){
                $('.widgetcontainer').hide();
                $('.icon_widgetcontainer').hide();
                $('.password_widgetcontainer').hide();
            });
            $('.cancel_button').click(function(){
                $('.widgetcontainer').hide();
                $('.icon_widgetcontainer').hide();
                $('.password_widgetcontainer').hide();
            });
            $('table tr .add_address').click(function(){
                var row = $(this).parent().parent().index();
                var receiver=$(".address_list_item tr:eq("+row+") td:nth-child(1)").html();
                var address=$(".address_list_item tr:eq("+row+") td:nth-child(2)").html();
                var contact=$(".address_list_item tr:eq("+row+") td:nth-child(3)").html();
                var addressid=$(this).parent().children().eq(2).html();
                $('.address_form_title').text('编辑地址');
                $('.address_state').val('edit_address');
                $('#address_detail').val(address);
                $('#address_receiver_name').val(receiver);
                $('#address_contact').val(contact);
                $('.widgetcontainer').show();
                $('.address_input').val(addressid);
                console.log(addressid);
            });
            
            $('.product_img').mouseover(function(){
                $(this).animate({height:"162px"},100);
            });
            
            $('.product_img').mouseout(function(){
                $(this).animate({height:"160px"},100);
            });

            $('.favorite_item .product_info').mouseover(function(){
                $(this).children(":first").show();
            });
            $('.favorite_item .product_info').mouseout(function(){
                $(this).children(":first").hide();
            });
                        
            var image_reg = new RegExp("^.*(jpg|jpeg|png)$");
            $('.user_icon').click(function(){
                $('.file_tip').text('点击此处上传图片');
                $('.filename').html('&nbsp;');
                $('.file_input').val('');
                $('.icon_widgetcontainer').show();
            });

            $('.password_link').click(function(){
                $('.password_widgetcontainer').show();
            });

            $('.file_input').change(function(){
                if($(this).val().match(image_reg)){
                    $('.filename').removeClass('alert');
                    $('.file_tip').text('重新选择');
                    $('.filename').text("您已选择："+$(this).val());
                }
                else{
                    $('.filename').addClass('alert');
                    $('.filename').text('上传失败');
                }
            });