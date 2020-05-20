var index = 0,
    timer = null,
    dd = 0,
    pics = byId("banner").getElementsByTagName("div"),
    dots = byId("dots").getElementsByTagName("span"),
    prev = byId("prev"),
    next = byId("next"),
    len = pics.length,
    menu = byId("menu-content"),
    subMenu = byId("sub-menu"),
    innerBox = subMenu.getElementsByClassName("inner-box"),
    menuItems = menu.getElementsByClassName("menu-item");

// 封装一个代替getElementById()的方法
function byId(id){
    return typeof(id) === "string"?document.getElementById(id):id;
}

function slideImg(){
    var main = byId("main");
    //滑过清除定时器，离开继续
    main.onmouseover = function(){
        //滑过清除定时器
        if(timer) clearInterval(timer);
    };
    //离开定时器打开
    main.onmouseout = function(){
        timer = setInterval(function(){
            index++;    //len =  3 0 1 2
            if(index >= len){
                index = 0;
            }
            changeImg();
        },3000);
    };
    // 自动在main上触发鼠标离开的时间
    main.onmouseout();

    // 点击圆点来切换图片
    for(var d=0; d<len; d++)
    {
        //给所有span添加一个id的属性，值为d，作为当前span的索引
        dots[d].id = d;
        dots[d].onclick = function(){
            //改变index为当前span的id值
            index = this.id;
            changeImg();
        };
    }

    //下一张
    next.onclick = function(){
        index++;
        if(index >= len) index=0;
        changeImg();
    }

    // 上一张
    prev.onclick = function(){
        index--;
        if(index < 0) index= len-1;
        changeImg();  
    }

    // 导航菜单
    //遍历主菜单，且绑定事件
    for(var m=0;m<menuItems.length;m++)
    {
        // 给每一个menu-item定义data-index属性，作为索引
        menuItems[m].setAttribute("data-index",m);
        menuItems[m].onmouseover = function(){
            subMenu.className = "sub-menu";
            var idx = this.getAttribute("data-index");
            dd = idx;
            // 遍历所有子菜单，将每一个都隐藏
            for(var j=0; j<innerBox.length;j++){
                innerBox[j].style.display = "none";
                menuItems[j].style.background = "none";
            }
            menuItems[dd].style.background = "rgba(0,0,0,0.1)";
            innerBox[idx].style.display = "block";
        };
    }
    menu.onmouseout = function(){
        subMenu.className = "sub-menu hide";
        for(var k=0; k<innerBox.length; k++)
        {
            menuItems[k].style.background = "none";           
        }   
    }

    subMenu.onmouseover = function(){
        this.className = "sub-menu";
        menuItems[dd].style.background = "rgba(0,0,0,0.1)";
    }

    subMenu.onmouseout = function(){
        this.className = "sub-menu hide";
        for(var k=0; k<innerBox.length; k++)
        {
            menuItems[k].style.background = "none";           
        }        
    }
}

function changeImg(){
    //遍历banner下所有的div及dots下所有的span，将div隐藏，将span清除类
    for(var i = 0; i<len; i++){
        pics[i].style.display = "none";
        dots[i].className = "";
    }
    // 根据index索引找到当前div的当前span，将其显示出来和设为当前
    pics[index].style.display = "block";
    dots[index].className = "active";
}
   
slideImg();