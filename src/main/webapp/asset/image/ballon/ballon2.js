function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem2 = document.getElementById(elementID);
  if (elem2.movement) {
    clearTimeout(elem2.movement);
  }
  if (!elem2.style.left) {
    elem2.style.left = "550px";
  }
  if (!elem2.style.top) {
    elem2.style.top = "900px";
  }
  var xpos = parseInt(elem2.style.left);
  var ypos = parseInt(elem2.style.top);
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
  elem2.style.left = xpos + "px";
  elem2.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem2.movement = setTimeout(repeat,interval);
}
function ballon2(){
	document.getElementById("img2").style.visibility="visible";
  var elem2 = document.getElementById("img2");
  elem2.style.position = "fixed";
  elem2.style.left = "550px";
  elem2.style.top = "900px";
  moveElement("img2",550,-250,20);
}