/**
 * 
 */


iflowApp.controller('WorkflowTypesController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.items = [];
	
	
	
	$scope.reload = function (){
			
			//alert(JSON.stringify($scope.query)); 
	
		$scope.items = [];
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.items = response.data;
	    	

	    }, function errorCallback(response) {
	        
	    	alert(response);
	        $scope.textDebug = "error search: " + response;
	        alert($scope.textDebug);
	        //$scope.test = response.data;
	    });
			
	};
	
	
	
	
	$scope.reload();
});
