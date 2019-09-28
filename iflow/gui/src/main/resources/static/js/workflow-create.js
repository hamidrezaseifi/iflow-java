/**
 * 
 */

iflowApp.directive('fileModel', [ '$parse', function($parse) {
    return {
        restrict : 'A',
        link : function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function() {
                scope.$apply(function() {
                   	
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
} ]);

iflowApp.controller('WorkflowCreateController', function WorkflowCreateController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.loadWorkflowTypeDataUrl = loadWorkflowTypeDataUrl;
	$scope.saveUrl = saveUrl;
	$scope.saveFileUrl = saveFileUrl;
	$scope.listUrl = listUrl;
	
	$scope.workflowTypes = [];
	$scope.users = [];
	$scope.departments = [];
	$scope.assigned = {};
	$scope.workflowCreateRequest = {};
	$scope.fileTitles = [];
	
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		$scope.workflowTypes = [];
		$scope.users = [];
		$scope.departments = [];
		$scope.workflowCreateRequest = {};
		$scope.assigned = {};
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.workflowTypes = response.data.workflowTypes;
	    	$scope.workflowCreateRequest = initWorkFlow(response.data.workflowCreateRequest);
	    	
	    	resetAssignedList();
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
		
	};

	$scope.reloadWorkflowTypeData = function (){
		
		//alert($scope.loadWorkflowTypeDataUrl + $scope.workflowCreateRequest.workflow.workflowTypeId); 

		$scope.users = [];
		$scope.departments = [];
		$scope.assigned = {};
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadWorkflowTypeDataUrl + $scope.workflowCreateRequest.workflow.workflowTypeId,
	    }).then(function successCallback(response) {
	    	
	    	$scope.users = response.data.users;
	    	$scope.departments = response.data.departments;

	    	resetAssignedList();
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
		
	};

	$scope.save = function (){
		
		//alert(JSON.stringify($scope.workflowCreateRequest)); 

		var formData = new FormData();
		
		for (var i = 0; i < $scope.fileTitles.length; i++) {
		    formData.append('files', $scope.fileTitles[i].file);
		    formData.append('titles', $scope.fileTitles[i].title);
		    formData.append('wids', i);
		}
		
		//formData.append('file', file);
        //formData.append('data', JSON.stringify($scope.workflowCreateRequest));
     
		//alert(JSON.stringify(formData));
		
		$http.post($scope.saveFileUrl, formData,{
            transformRequest : angular.identity,
            headers : {
                'Content-Type' : undefined
            }})
            .then(
                function (response) {
                	//alert( response.data.sessionKey);
                	//alert( response.data.titles);
                	
                	$scope.workflowCreateRequest.sessionKey = response.data.sessionKey;
                	
                	$http({
            	        method : "POST",
            	        headers: {
            	        	'Content-type': 'application/json; charset=UTF-8',
            	        },
            	        url : $scope.saveUrl,
            	        data: $scope.workflowCreateRequest,
            	    }).then(function successCallback(response) {
            	    	
            	    	alert("saved");
            	    	
            	    	window.location = $scope.listUrl;
            	
            	    }, function errorCallback(response) {
            	        
            	        alert(response.data);
            	    });
                	
                },
                function (errResponse) {
                	alert( errResponse.data);
                }
            );

		
			
		
		
	};
	
	$scope.addFile = function (){
		
		$scope.fileTitles.push({title:'', file:false});
		
	};
	
	$scope.removeFile = function (index){
		
		$scope.fileTitles.splice(index, 1);
		
	};

	$scope.applyUserSelect = function(){
		$scope.workflowCreateRequest.assigns = [];
		
		//alert($(".assign-checkbox:checked").length);
		$(".assign-checkbox:checked").each(function(index, item){
			var jitem = $(item);
			//alert(jitem.val() + " : " + jitem.data("assigntype"));
			$scope.workflowCreateRequest.assigns.push({itemId: jitem.val(),  itemType: jitem.data("assigntype"), title: jitem.data("assigntitle")});
		});
    	/*for(id in $scope.assigned){
    		if($scope.assigned[id]){
    			$scope.workflowCreateRequest.assigns.push(id);
    		}
    	}*/
    	$('#assignlistdialog').modal('hide');
	};

	$scope.removeAssign = function(id, type){
		$scope.assigned[id] = false;
		
		$scope.workflowCreateRequest.assigns = $scope.workflowCreateRequest.assigns.filter(function(value, index, arr){

		    return value.itemId != id || value.itemType != type;

		});
    	
	};

	$scope.getAssignedUsers = function(){
		var assigned = new Array();
		for(id in $scope.assigned){
    		if($scope.assigned[id]){
    		}
    	}
		
		return assigned;
	};
	
	$scope.getWorkflowTypeSteps = function(){
				
		if($scope.workflowCreateRequest.workflow && $scope.workflowCreateRequest.workflow.workflowTypeId != 0){
			for(index in $scope.workflowTypes){
				if($scope.workflowTypes[index].id == $scope.workflowCreateRequest.workflow.workflowTypeId){
					return $scope.workflowTypes[index].steps;
				}
			}
		}
		
		return [];
	};
	
	$scope.isWorkflowTypeSelected = function(){
		
		return $scope.workflowCreateRequest.workflow && $scope.workflowCreateRequest.workflow.workflowTypeId != 0;
	};

	function findUser(id){
		
	}
	
	function resetAssignedList(){
		$scope.assigned = {};
    	for(o in $scope.users){
    		var user =$scope.users[o];
    		$scope.assigned[user.id] = false;
    	}
	}
	
	$scope.hasNoAssigns = function(){
		if($scope.workflowCreateRequest && $scope.workflowCreateRequest.assigns){
			return $scope.workflowCreateRequest.assigns.length == 0;
		}
		return false;
		
	};

	$scope.getUserById = function(id){
		for(o in $scope.users){
    		var user =$scope.users[o];
    		if(user.id == id){
    			return user;
    		}
    	}
		return null;
	};

	
	$scope.testUpload = function (){
		
		//var file = $("#myFile")[0];
		//var file = $scope.myfile;
		
		var formData = new FormData();
		
		for (var i = 0; i < $scope.fileTitles.length; i++) {
		    formData.append('files', $scope.fileTitles[i].file);
		    formData.append('titles', $scope.fileTitles[i].title);
		    formData.append('wids', i);
		}
		
		//formData.append('file', file);
        //formData.append('data', JSON.stringify($scope.workflowCreateRequest));
     
		//alert(JSON.stringify(formData));
		
		$http.post($scope.saveFileUrl, formData,{
            transformRequest : angular.identity,
            headers : {
                'Content-Type' : undefined
            }})
            .then(
                function (response) {
                	alert( response.data.sessionKey);
                	alert( response.data.titles);
                },
                function (errResponse) {
                	alert( errResponse.data);
                }
            );
		
        /*$http({
            url: $scope.saveFileUrl,
            method: "POST",
            data: formData,
            headers: {'Content-Type': 'multipart/form-data'}
        }).then(function successCallback(response) {
	    	
	    	alert( response);
	    	
	
	    }, function errorCallback(response) {
	        
	        alert(response);
	    });*/
 		
		
	};
	
	
	
	$scope.getWorkFlowTest = function(){
		return JSON.stringify($scope.workflowCreateRequest);
	};

	$scope.getAssignedTest = function(){
		return JSON.stringify($scope.assigned);
	};
		
	function initWorkFlow(workflowReq){
		workflowReq.workflow.workflowTypeId = workflowReq.workflow.workflowTypeId + "";
		workflowReq.workflow.controller = workflowReq.workflow.controller + "";
		workflowReq.workflow.assignTo = workflowReq.workflow.assignTo + "";
		workflowReq.workflow.workflowTypeId = workflowReq.workflow.workflowTypeId + "";
		workflowReq.workflow.currentStepId = workflowReq.workflow.currentStepId + "";
		workflowReq.assigns = [];
		
		return workflowReq;
	};
	
	$scope.addFile();
	$scope.reload();
});
