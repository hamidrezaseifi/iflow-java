/**
 * 
 */


iflowApp.controller('WorkflowTypesController', function WorkflowTypesController($scope, $http, $sce, $element, $mdSidenav) {
	  //$scope.phones = [];
	
	$scope.loadUrl = loadUrl;
	$scope.loadInitialUrl = loadInitialUrl;
	$scope.items = [];
	
	$scope.workflowTypes = [];
	$scope.searchFilter = {};

	
	$scope.reloadInitial = function (){
			
			//alert(JSON.stringify($scope.query)); 
	
		$scope.items = [];
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadInitialUrl,
	    }).then(function successCallback(response) {
	    	
	    	$scope.workflowTypes = response.data.workflowTypes;
	    	$scope.searchFilter = response.data.newSearchFilter;

	    	//$scope.items = response.data.workflowTypes;
	    	
	    	initialSearchFilter();
	    	
	    	$scope.reload();

	    }, function errorCallback(response) {
	        
	    	alert(response);
	        $scope.textDebug = "error search: " + response;
	        alert($scope.textDebug);
	        //$scope.test = response.data;
	    });
			
	};
	
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		query = angular.copy($scope.searchFilter);
		$scope.items = [];
			
		$http({
	        method : "POST",
	        headers: {
	        	'Content-type': 'application/json; charset=UTF-8',
	        },
	        url : $scope.loadUrl,
	        data : query,
	    }).then(function successCallback(response) {
	
	    	$scope.items = prepareWorkflowList(response.data);
	    	
	
	    }, function errorCallback(response) {
	        
	    	alert(response);
	        $scope.textDebug = "error search: " + response;
	        alert($scope.textDebug);
	        //$scope.test = response.data;
	    });
		
	};
	
	
	
	$scope.hasNoArhiveStatus = function(){		
		if($scope.searchFilter.statusList){
			//alert($scope.searchFilter.statusList.indexOf(25));
			return $scope.searchFilter.statusList.indexOf(25) == -1;
		}	
		return false;	
	};
	
	$scope.toggleIsArchive = function(){	
		
		var index = $scope.searchFilter.statusList.indexOf(25);
		if(index == -1){
			//alert($scope.searchFilter.statusList.indexOf(25));
			$scope.searchFilter.statusList.push(25);
		}
		else{
			$scope.searchFilter.statusList.splice(index, 1);
		}
	};
	
	$scope.getDebugStatusList = function(){
		
		return JSON.stringify($scope.searchFilter.statusList);
		
	};

	
	function initialSearchFilter(){

		var temp = $scope.workflowTypes;
		$scope.workflowTypes = {};
		for(index in temp){
			$scope.workflowTypes[temp[index].id] = temp[index];
		}

		$scope.searchFilter.workflowTypeIdList = []; 
		for(index in temp){
			$scope.searchFilter.workflowTypeIdList.push(temp[index].id);
		}
	}
	
	function prepareWorkflowList(items){
		
		var newItems = [];
		for(index in items){
			var workflow = items[index];
			//workflow.workflowType = $scope.workflowTypes[workflow.workflowTypeId];
			newItems.push(workflow);
		}
		
		return newItems;
	}
	
	
	
	$scope.reloadInitial();
});
