
var iflowApp = angular.module('iflowApp', ['ngMaterial', 'ngTable', 'ngMaterialAccordion', 'ngSanitize']);


iflowApp.config(function($mdDateLocaleProvider) {

    // Example of a French localization.
    $mdDateLocaleProvider.months = ['Januar', 'Februar', 'März', 'April', 'Mai', 'Juni','Juli', 'August', 'September', 'October', 'November', 'Dezember',];
    $mdDateLocaleProvider.shortMonths = ['Jan', 'Feb', 'Mär', 'Apr', 'Mai', 'Jun','Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dez',];
    $mdDateLocaleProvider.days = ['Montag', 'Dienstag', 'Mittwoch', 'Donnerstag', 'Freitag', 'Samstag', 'Sonntag',];
    $mdDateLocaleProvider.shortDays = ['Mo', 'Di', 'Mi', 'Do', 'Fr', 'Sa', 'So',];

    // Example uses moment.js to parse and format dates.
    $mdDateLocaleProvider.parseDate = function(dateString) { 
    	//alert(dateString);

      if(dateString == null || dateString == ""){
    	  return dateString;
      }
      else{
    	  var m = moment(dateString, 'D.M.YYYY', true);
    	  if(!m.isValid()){
         	  return dateString;
          }
          
          return m.isValid() ? m.toDate() : new Date(NaN);
      }
      
      
    };

    $mdDateLocaleProvider.formatDate = function(date) {
      var m = moment(date);
      return m.isValid() ? m.format('DD.MM.YYYY') : '';
    };

});

iflowApp.config(['$httpProvider', function($httpProvider) {
    $httpProvider.defaults.timeout = 10000;
}]);

iflowApp.controller('BodyController', function ($scope, $http, $sce, $element, $compile, $mdSidenav, $mdComponentRegistry) {

	$scope.showloading = false;
	$scope.isShowError = true;
	$scope.isShowMessage = false;

	$scope.errorMessage = "";
	$scope.menulist = [];

  $scope.messageTitle = "";
  $scope.messageContent = "";

	$scope.toggleRight = function(){
		$mdSidenav('rightSidenav').toggle();
    };

	$scope.closeSideRight = function () {
	      $mdSidenav('rightSidenav').close();
	};
	
	$scope.navMenu = function(url){
		window.location = url;
	};
    
	$('[data-toggle="tooltip"]').tooltip();   
  
	$scope.ShowErrorBox = function(message, details, moduleName){
		if(moduleName == undefined){
			moduleName = "GUI";
		}
		if(details == undefined || !details){
			details = "";
		}
		$scope.errorMessage = moduleName + ": " + message;
		$scope.errorHasDetails = details!= "";
		$scope.errorDetails = convertPlainTextToHtml(details);
	    $scope.isShowError = true;
	    $scope.showErrorDetails = false;
	};
	
	$scope.toggleShowErrorDetails = function(){
		$scope.showErrorDetails = !$scope.showErrorDetails;
	}
	
  
	$scope.closeErrorBox = function(){

		$scope.isShowError = false;
	};
  
  $scope.ShowMessageBox = function(message, title){
    if(title == undefined){
      title = "";
    }
    $scope.messageTitle = title;
    $scope.messageContent = message;
    $scope.isShowMessage = true;
  };
  
  $scope.closeMessageBox = function(){

    $scope.isShowMessage = false;
  };
        
    
    if(angular.element("md-sidenav[md-component-id='rightSidenav']").length == 1){
    	$scope.$watch(function(){
  	      return $mdComponentRegistry.get('rightSidenav') ? $mdSidenav('rightSidenav').isOpen() : true;
  	    }, 
  	    function(newVal){
  	    	if($mdSidenav('rightSidenav').isOpen()){ 
  	    		if(!angular.element("body").hasClass("overdialog")){
  	    			angular.element("body").addClass("overdialog");
  	    		}
  	    		
  	    	} 
  	    	else{
  	    		angular.element("body").removeClass("overdialog");
  	    	}
  	});
    }
    
    setTimeout(function(){ 
    	$('button.md-accordion-toggle.md-button').click(function(ev){
    		toggleAll(ev.target);
        });
    }, 1000);
    
    
	function toggleAll(element){
		var button = $(element).parents("button");
		var content = button.next();
		
		$(".md-accordion-group button.md-accordion-toggle.md-button.md-active").removeClass("md-active");
		$(".md-accordion-group div.md-accordion-wrapper.md-active").removeClass("md-active");
	}
    

    

});
