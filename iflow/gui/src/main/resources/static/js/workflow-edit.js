/**
 * 
 */


iflowApp.controller('WorkflowCreateController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.saveUrl = saveUrl;
	$scope.listUrl = listUrl;
	
	$scope.workflowType = {};
	$scope.users = [];
	$scope.workflow = {};
	
	$scope.showSelectAssign = false;
	
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		$scope.workflowType = {};
		$scope.users = [];
		$scope.workflow = {};
			
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
	
	$scope.reload();
});
