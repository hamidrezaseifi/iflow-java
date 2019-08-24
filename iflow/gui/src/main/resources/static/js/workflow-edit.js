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
	$scope.workflowTypeSteps = [];
	$scope.workflow = {};
	$scope.activeAction = getNewAction();
	
	$scope.showSelectAssign = false;
	
	
	$scope.reload = function (){
		
		//alert(JSON.stringify($scope.query)); 

		$scope.workflowType = {};
		$scope.users = [];
		$scope.workflow = {};
		$scope.activeAction = getNewAction();
			
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
	    	
	    	prepareActiveAction();
	    	
	
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
