var monthNames = [
  "Jan", "Feb", "Mar",
  "Apr", "May", "Jun", "Jul",
  "Aug", "Sep", "Oct",
  "Nov", "Dec"
];

function toggleDiv(divName){
	var divToToggle = document.getElementById(divName);
	if(divToToggle.style.display != 'none'){
		divToToggle.style.display = 'none';
	}else{
		divToToggle.style.display = 'block';
	}
}

function toggleCollapse(divName){
	if(divName == 'divcreate'){
		document.getElementById('divcreate').style.display = 'none';
		document.getElementById('collapsedCreate').style.display = 'block';
		document.getElementById('divdisplay').classList.add('tododisplayfull');
	}else if(divName == 'collapsedCreate'){
		document.getElementById('divcreate').style.display = 'block';
		document.getElementById('collapsedCreate').style.display = 'none';
		document.getElementById('divdisplay').classList.remove('tododisplayfull');
	}
	
}

function manualValidate(event){
	 var formData = {};

	 $("#todoform :input").each(function(){	 	 
    	 var input = $(this);
    	 if(input.attr('name') == 'idracktype'){
    	 	formData.rackType = input.val();
    	 }
    	 if(input.attr('name') == 'todotask'){
    	 	formData.taskDesc = input.val();
    	 }
	  });
	 

	 formData.taskStatus = 'Incomplete';
	
	 writeToDB(formData);
	 event.preventDefault(); // Prevent form submission and contact with server
	 resetForm();	 
}

function resetForm(){
	$('#todoform').find('input:text, textarea').val('');
}

function loadToDoItems(results){

	var len = results.rows.length;
 	//alert("Read "+ len + " items");
 	for(i=0;i<len;i++){
 		var id = results.rows.item(i).id;

 		//clear all
 		if(document.getElementById(id) != null){
 			$(document.getElementById(id)).remove();
 		}

 		//redraw again
		var racktype = results.rows.item(i).racktype;
 		var todo_task = results.rows.item(i).taskdesc;
 		var added_on = results.rows.item(i).added_on;
 		var dateForDisplay = formatDate(added_on);

 		//Create a div for date;
 		var dateDiv = createDiv("dateFor"+id, dateForDisplay, 'datefmt',null);
 		
 		 		
 		if(racktype === 'complete'){
 			//Create the main todoDiv
 			var iDiv = createDiv(id, todo_task, 'todoitem wordwrap taskCrossOut',null);

 			iDiv.style.backgroundSize= '0px 0px';
 			
 			var removeDiv = createDiv('Done'+id, null, 'taskRemove','Delete Permanently!!');
 			removeDiv.onclick = removeToDo;
	 		
	 		iDiv.appendChild(removeDiv);
	 		iDiv.appendChild(dateDiv);

	 		document.getElementById('complete').appendChild(iDiv);

 		}else{

			//Create the main todoDiv
 			var iDiv = createDiv(id, todo_task, 'todoitem wordwrap',null);

	 		var doneDiv = createDiv('Done'+id, null, 'taskComplete', 'Mark it done!!');
	 		doneDiv.onclick = updateToDo;
	 		iDiv.appendChild(doneDiv);
	 		iDiv.appendChild(dateDiv);

	 		if( racktype === 'Pipeline'){ 			
	 			document.getElementById('pipe').appendChild(iDiv);
	 		}else if (racktype === 'Work In Progress'){
				document.getElementById('wip').appendChild(iDiv);
	 		}else if(racktype === 'Open Issue Tracker'){
	 			document.getElementById('issuetrack').appendChild(iDiv);
	 		}else{
	 			document.getElementById('complete').appendChild(iDiv);
	 		}	
 		}
  	} 	
}

function createDiv(id, content, cssClass, title){
	var newDiv = document.createElement('div');
	
	newDiv.id = id;
	
	if(content!=null)
		newDiv.innerHTML = content;

	newDiv.className = cssClass;

	if(title !=null)
		newDiv.title = title;

	return newDiv;
}


function updateToDo(){
	var formData = {};
	var this_div = document.getElementById(this.id);
	var parent_div = this_div.parentNode;
	//alert(parent_div.id);
	formData.id = parent_div.id;
	formData.taskStatus = 'complete';
	formData.rackType = 'complete';
	updateDbase(formData);
}

function removeToDo(){
	var formData = {};
	var this_div = document.getElementById(this.id);
	var parent_div = this_div.parentNode;
	formData.id = parent_div.id;
	parent_div.remove();
	deleteFromDbase(formData);
}

function formatDate(added_on){
	var dt = new Date(added_on);
	var day = dt.getDate();
	var monthIndex = dt.getMonth();
	var year = dt.getFullYear();
	return monthNames[monthIndex]+'-'+day;	 
}