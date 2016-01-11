 var db = null;
 
 function openDB(){
 	db = openDatabase('todoDatabase', '1.0', 'ToDoDB', 2 * 1024 * 1024);
 	//cleanUpDB();
 }

 function readDB(callback){
 	db.transaction(function(tx){
 		tx.executeSql('SELECT * FROM todo',[], function(tx,results){
  			callback(results);		
 		}, null);
 	});
 }

 function writeToDB(formData){
 	//alert(formData.rackType+" "+ formData.taskDesc+" "+ formData.taskStatus);
 	db.transaction(function (tx){
 		var addedOn = new Date();
 		tx.executeSql('CREATE TABLE IF NOT EXISTS todo (id integer primary key asc, racktype, taskdesc, taskstatus, added_on DATETIME)');
 		 var insertStatement="INSERT INTO todo(racktype, taskdesc, taskstatus, added_on) VALUES(?,?,?,?)";
         tx.executeSql(insertStatement, [formData.rackType, formData.taskDesc, formData.taskStatus, addedOn],onSuccess);        
 	});
 }

 function updateDbase(formData){
 	db.transaction(function (tx){
 		 var updateStmt="UPDATE todo SET taskstatus = 'complete', racktype = 'complete' WHERE id = "+formData.id;
 		// alert(updateStmt);
         tx.executeSql(updateStmt, [],onSuccess, onError);        
 	});
 }

 function deleteFromDbase(formData){
 	db.transaction(function (tx){
 		 var updateStmt="DELETE FROM todo WHERE id = "+formData.id;
 		// alert(updateStmt);
         tx.executeSql(updateStmt, [],onSuccess, onError);        
 	});
 }

function onSuccess(){
	//alert("post is successful");
	readDB(loadToDoItems);
}

function onError(){
	alert('post in error');
}

 function cleanUpDB(){
 	db.transaction(function(tx){
 		tx.executeSql('DELETE FROM todo',[], function(tx,results){
 			var len = results.rows.length, i;
 			alert("Deleted "+ len + " items");
 		}, null);
 	});

 	db.transaction(function(tx){
 		tx.executeSql('DROP TABLE todo',[], function(tx){
 			alert('table dropped');
 		}, null);
 	});
 }

