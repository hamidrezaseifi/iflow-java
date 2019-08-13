/**
 * 
 */


iflowApp.controller('WorkflowCreateController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.workflowTypes = [];
	$scope.users = [];
	
	
	
	$scope.reload = function (){
			
			//alert(JSON.stringify($scope.query)); 
	
		$scope.workflowTypes = [];
		$scope.users = [];
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.workflowTypes = response.data.workflowTypes;
	    	$scope.users = response.data.users;
	    	

	    }, function errorCallback(response) {
	        
	    	alert(response);
	        $scope.textDebug = "error search: " + response;
	        alert($scope.textDebug);
	        //$scope.test = response.data;
	    });
			
	};
	
	
	
	
	$scope.reload();
});
