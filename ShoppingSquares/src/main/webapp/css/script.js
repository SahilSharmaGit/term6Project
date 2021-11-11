
function changeAColor(ele)
{
  ele.style.color='blue';
}
  function forwardImage()
  {
//   css\shopping0.jpg
    var element = document.getElementById('nature');
    let name = element.getAttribute('src');
    let n = name[12];
    let val = 'shopping';
    let ext = '.jpg';
    if(n == 4)
    {
        n=-1;
    }
      n++;
      name[12] = n;
      let value = val+n+ext;
      let path = "css//";
      element.setAttribute('src',path+value);
      //alert(path+value);
}

function reverseImage()
{
  var element =    document.getElementById('nature');
  let name = element.getAttribute('src');
  let n = name[12];
  let val = 'shopping';
  let ext = '.jpg'
  if(n == 0)
  {
    n = 4;
  }
  else {
  n--;
  }
    name[12] = n;
    let value = val+n+ext;
    let path = "css\\";
  element.setAttribute('src',path+value);
//alert(path+value);
}

