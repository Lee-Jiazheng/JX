            var index=0;

            var image_num=$('.image_hidden').children().length;

            //预加载图片数组
            var images=new Array(image_num);
            //保存图片信息
            var images_src=new Array(image_num);
            //保存图片链接地址
            var images_link=new Array(image_num);

            for(i=0;i<image_num;i++){
                images_src[i]=$('.image_hidden').children().eq(i).attr("src");
                images_link[i]=$('.image_hidden').children().eq(i).attr("alt");
                images[i]=new Image();
                images[i].src=images_src[i];
            }

            function show(i)
			{
                index=(index+i)%image_num;
                $('#roll_images').attr('src',images_src[index]);   
                $('#roll_images').parent().attr('href',images_link[index]);
			}

            
            var interval=setInterval('show(1)',3500);

            $('.product_img').mouseover(function(){
                $(this).animate({height:"163px"},100);
            });
            
            $('.product_img').mouseout(function(){
                $(this).animate({height:"160px"},100);
            });

            $('.roll_main .icon-zuo').click(function(){
                clearInterval(interval);
                show(image_num-1);
                interval=setInterval('show(1)',3500);
            });

            $('.roll_main .icon-you').click(function(){
                clearInterval(interval);
                show(1);
                interval=setInterval('show(1)',3500);
            });
                
            $('.roll_main').mouseover(function(){
                $('.roll_button').show();
            });

            $('.roll_main').mouseout(function(){
                $('.roll_button').hide();
            });