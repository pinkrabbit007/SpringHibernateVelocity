function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem3 = document.getElementById(elementID);
  if (elem3.movement) {
    clearTimeout(elem3.movement);
  }
  if (!elem3.style.left) {
    elem3.style.left = "100px";
  }
  if (!elem3.style.top) {
    elem3.style.top = "900px";
  }
  var xpos = parseInt(elem3.style.left);
  var ypos = parseInt(elem3.style.top);
  if (xpos == final_x && ypos == final_y) {
    return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil((final_x - xpos)/100);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil((xpos - final_x)/100);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil((final_y - ypos)/100);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil((ypos - final_y)/100);
    ypos = ypos - dist;
  }
  elem3.style.left = xpos + "px";
  elem3.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem3.movement = setTimeout(repeat,interval);
}
function ballon3(){
	document.getElementById("img3").style.visibility="visible";
  var elem3 = document.getElementById("img3");
  elem3.style.position = "fixed";
  elem3.style.left = "100px";
  elem3.style.top = "900px";
  moveElement("img3",100,-250,20);
}