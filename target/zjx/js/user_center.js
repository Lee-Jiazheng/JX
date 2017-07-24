            $('.new_address').click(function(){
                $('.widgetcontainer').show();
                $('#address_detail').val('');
                $('#address_receiver_name').val('');
                $('#address_contact').val('');
            });
            $('.close_address_form').click(function(){
                $('.widgetcontainer').hide();
            });
            $('.cancel_button').click(function(){
                $('.widgetcontainer').hide();
            });
            $('table tr .add_address').click(function(){
                var row = $(this).parent().parent().index();
                var receiver=$(".address_list_item tr:eq("+row+") td:nth-child(1)").html();
                var address=$(".address_list_item tr:eq("+row+") td:nth-child(2)").html();
                var contact=$(".address_list_item tr:eq("+row+") td:nth-child(3)").html();
                $('.address_form_title').text('编辑地址');
                $('#address_detail').val(address);
                $('#address_receiver_name').val(receiver);
                $('#address_contact').val(contact);
                $('.widgetcontainer').show();
            });
            $('.product_img').mouseover(function(){
                $(this).animate({height:"165px"},550);
            });
            $('.product_img').mouseout(function(){
                $(this).animate({height:"160px"},300);
            });
            $('.favorite_item .product_info').mouseover(function(){
                $(this).children(":first").show();
            });
            $('.favorite_item .product_info').mouseout(function(){
                $(this).children(":first").hide();
            });