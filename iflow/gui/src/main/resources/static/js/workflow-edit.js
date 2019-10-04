/**
 * 
 */


iflowApp.controller('WorkflowCreateController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.saveUrl = saveUrl;
	$scope.archiveUrl = archiveUrl;
	$scope.doneUrl = doneUrl;
	$scope.listUrl = listUrl;
	
	$scope.workflowType = {};
	$scope.users = [];
	$scope.workflowTypeSteps = [];
	$scope.workflow = {};
	$scope.activeAction = getNewAction();
	$scope.departments = [];
	
	$scope.showSelectAssign = false;
	
	$scope.workflowCreateRequest = { assigns: []};
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		$scope.workflowType = {};
		$scope.users = [];
		$scope.workflow = {};
		$scope.activeAction = getNewAction();
		$scope.departments = [];
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.workflowType = response.data.workflowType;
	    	$scope.users = response.data.users;
	    	$scope.workflow = initWorkFlow(response.data.workflow);
	    	$scope.workflowTypeSteps = $scope.workflowType.steps;
	    	$scope.departments = response.data.departments;
	    	
	    	prepareActiveAction();
	    	
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
		
	};	

	$scope.applyUserSelect = function(){
		$scope.workflowCreateRequest.assigns = [];
		
		
		$(".assign-checkbox:checked").each(function(index, item){
			var jitem = $(item);
			
			var type = jitem.data("assigntype") == 'user' ? userAssignType : jitem.data("assigntype") == 'department' ? departmentAssignType : departmentGroupAssignType;
			
			$scope.workflowCreateRequest.assigns.push({itemId: jitem.val(),  itemType: type, title: jitem.data("assigntitle")});
		});
    	$('#assignlistdialog').modal('hide');
	};

	$scope.removeAssign = function(id, type){
		
		$scope.workflowCreateRequest.assigns = $scope.workflowCreateRequest.assigns.filter(function(value, index, arr){

		    return value.itemId != id || value.itemType != type;

		});
    	
	};

	$scope.isItemAssigned = function(id, itype){

		var type = itype == 'user' ? userAssignType : itype == 'department' ? departmentAssignType : departmentGroupAssignType;

		for(o in $scope.workflowCreateRequest.assigns){
			var assign = $scope.workflowCreateRequest.assigns[o];
			
		    if(assign.itemId == id && assign.itemType == type){
		    	return true;
		    }
		}
		
		return false;
    	
	};

	
	$scope.saveWorkflow = function(){
		
		var saveData = angular.copy($scope.workflow);
		
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.saveUrl,
	        data: saveData,
	    }).then(function successCallback(response) {
	    	
	    	alert("saved");
	    	
	    	window.location = $scope.listUrl;
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
	};

	$scope.arhiveWorkflow = function(){
		
		var saveData = angular.copy($scope.workflow);
		
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.archiveUrl,
	        data: saveData,
	    }).then(function successCallback(response) {
	    	
	    	alert("saved");
	    	
	    	window.location = $scope.listUrl;
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
	};

	$scope.makeWorkflowDone = function(id){
		
		var saveData = angular.copy($scope.workflow);
		saveData.currentStepId = id;
		
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.doneUrl,
	        data: saveData,
	    }).then(function successCallback(response) {
	    	
	    	alert("saved");
	    	
	    	window.location = $scope.listUrl;
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
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
	
	
	
	
	$scope.getWorkFlowTest = function(){
		return JSON.stringify($scope.workflow);
	};

	
		
	function initWorkFlow(workflow){
		//workflow.assignTo = workflow.assignTo + "";
		
		return workflow;
	};
	
	function prepareActiveAction(){
    	for(index in $scope.workflow.actions){
    		if($scope.workflow.actions[index].isActive){
    			$scope.activeAction = $scope.workflow.actions[index];
    			$scope.activeAction.oldStep = "" + $scope.activeAction.oldStep;
    			$scope.activeAction.newStep = "" + $scope.activeAction.newStep;

    			break;
    		}	    		
    	}		
	}
	
	$scope.listAvaileableSteps = function(){
    	
		var list = []; 
		for(index in $scope.workflowTypeSteps){
			if($scope.workflowTypeSteps[index].stepIndex > $scope.workflow.currentStep.stepIndex){
				list.push($scope.workflowTypeSteps[index]);
			}
		}
		return list;
	}
	
	function getNewAction(){
		return {action: "", oldStep: 0, newStep: 0, comments: "", };
	}
	
	$scope.reload();
});
