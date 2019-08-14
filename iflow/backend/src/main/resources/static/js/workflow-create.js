/**
 * 
 */


iflowApp.controller('WorkflowCreateController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	
	$scope.workflowTypes = [];
	$scope.users = [];
	$scope.userAssigned = {};
	$scope.workflowCreateRequest = {};
	
	$scope.showSelectAssign = true;
	
	
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
	        
	    	//alert(response);
	        $scope.textDebug = "error search: " + response;
	        alert($scope.textDebug);
	        //$scope.test = response.data;
	    });
			
	};
	
	$scope.closeUserSelectDialog = function(){
		$scope.showSelectAssign = false;
	};

	$scope.applyUserSelect = function(){
		$scope.showSelectAssign = false;
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
		return $scope.workflowCreateRequest.assigns.length == 0;
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
