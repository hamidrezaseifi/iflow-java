/**
 * 
 */


iflowApp.controller('WorkflowCreateController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.saveUrl = saveUrl;
	$scope.listUrl = listUrl;
	
	$scope.workflowTypes = [];
	$scope.users = [];
	$scope.userAssigned = {};
	$scope.workflowCreateRequest = {};
	
	$scope.showSelectAssign = false;
	
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		$scope.workflowTypes = [];
		$scope.users = [];
		$scope.workflowCreateRequest = {};
		$scope.userAssigned = {};
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.workflowTypes = response.data.workflowTypes;
	    	$scope.users = response.data.users;
	    	$scope.workflowCreateRequest = initWorkFlow(response.data.workflowCreateRequest);
	    	
	    	resetAssignedList();
	
	    }, function errorCallback(response) {
	        
	        alert(response.data);
	    });
		
	};

	$scope.save = function (){
		
		//alert(JSON.stringify($scope.workflowCreateRequest)); 

			
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
		
	};
	
	
	$scope.showAssignSelectDialog = function(){
		$scope.showSelectAssign = true;
	};
	
	$scope.closeAssignSelectDialog = function(){
		$scope.showSelectAssign = false;
	};

	$scope.applyUserSelect = function(){
		$scope.workflowCreateRequest.assigns = [];
    	for(id in $scope.userAssigned){
    		if($scope.userAssigned[id]){
    			$scope.workflowCreateRequest.assigns.push(id);
    		}
    	}
    	
		$scope.showSelectAssign = false;
	};

	$scope.removeAssign = function(id){
		$scope.userAssigned[id] = false;
		
		$scope.workflowCreateRequest.assigns = $scope.workflowCreateRequest.assigns.filter(function(value, index, arr){

		    return value != id;

		});
    	
	};

	$scope.getAssignedUsers = function(){
		var assigned = new Array();
		for(id in $scope.userAssigned){
    		if($scope.userAssigned[id]){
    		}
    	}
		
		return assigned;
	};

	function findUser(id){
		
	}
	
	function resetAssignedList(){
		$scope.userAssigned = {};
    	for(o in $scope.users){
    		var user =$scope.users[o];
    		$scope.userAssigned[user.id] = false;
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

	
	
	
	
	$scope.getWorkFlowTest = function(){
		return JSON.stringify($scope.workflowCreateRequest);
	};

	$scope.getAssignedTest = function(){
		return JSON.stringify($scope.userAssigned);
	};
		
	function initWorkFlow(workflowReq){
		workflowReq.workflow.workflowTypeId = workflowReq.workflow.workflowTypeId + "";
		workflowReq.workflow.controller = workflowReq.workflow.controller + "";
		workflowReq.workflow.assignTo = workflowReq.workflow.assignTo + "";
		workflowReq.workflow.workflowTypeId = workflowReq.workflow.workflowTypeId + "";
		workflowReq.workflow.workflowTypeId = workflowReq.workflow.workflowTypeId + "";
		workflowReq.assigns = [];
		
		return workflowReq;
	};
	
	$scope.reload();
});
