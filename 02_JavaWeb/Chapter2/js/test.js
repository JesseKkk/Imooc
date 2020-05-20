function initLogo()
{
    var logo = document.getElementById("logo");
    for(i=1;i<=3;i++)
    {
        logo.options.add(new Option(i,i));
    }
}

function selectLogo()
{
    var logo = document.getElementById("logo");
    var n = logo.value;
    var logoImg = document.getElementById("logoImg");
    logoImg.src="Image/" + n + ".jpg";
}


