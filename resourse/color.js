function colorChange()
{
    var r = Math.floor(Math.random()*256);
    var g = Math.floor(Math.random()*256);
    var b = Math.floor(Math.random()*256);
    var rgb = 'rgb(' + r + ',' + g + ',' + b + ')';
    document.body.style.backgroundColor = rgb;
}
function change(){
    setInterval('colorChange()',5000)
}