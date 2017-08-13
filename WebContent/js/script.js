function addCliente(cdcln){
        var element = document.getElementById("left-" + cdcln);
        element.style.display = 'none';
        
        element = document.getElementById("right-" + cdcln);
        element.innerHTML = element.innerHTML + "<input type='hidden' name="+cdcln+" value="+cdcln+">";
        element.style.display = 'block';

    return true;
}
function removeCliente(cdcln) {
    
	var element = document.getElementById("left-" + cdcln);
    element.style.display = 'block';
    
    element = document.getElementById("right-" + cdcln);
    element.style.display = 'none';
    element.removeChild(document.getElementsByName(cdcln)[0]);
}
