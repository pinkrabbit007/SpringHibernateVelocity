function moveElement(elementID,final_x,final_y,interval) {
  if (!document.getElementById) return false;
  if (!document.getElementById(elementID)) return false;
  var elem = document.getElementById(elementID);
  if (elem.movement) {
    clearTimeout(elem.movement);
  }
  if (!elem.style.left) {
    elem.style.left = "0px";
  }
  if (!elem.style.top) {
    elem.style.top = "1300px";
  }
  var xpos = parseInt(elem.style.left);
  var ypos = parseInt(elem.style.top);
  if (xpos == final_x && ypos == final_y) {
    return true;
  }
  if (xpos < final_x) {
    var dist = Math.ceil(5);
    xpos = xpos + dist;
  }
  if (xpos > final_x) {
    var dist = Math.ceil(5);
    xpos = xpos - dist;
  }
  if (ypos < final_y) {
    var dist = Math.ceil(5);
    ypos = ypos + dist;
  }
  if (ypos > final_y) {
    var dist = Math.ceil(5);
    ypos = ypos - dist;
  }
  elem.style.left = xpos + "px";
  elem.style.top = ypos + "px";
  var repeat = "moveElement('"+elementID+"',"+final_x+","+final_y+","+interval+")";
  elem.movement = setTimeout(repeat,interval);
}
function tiaofu(){
	document.getElementById("tiaofu").style.visibility="visible";
  var elem = document.getElementById("tiaofu");
  elem.style.position = "fixed";
  elem.style.left = "0px";
  elem.style.top = "1300px";
  moveElement("tiaofu",0,-700,20);
}