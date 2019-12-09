export const menus = [
	{"id":"menu-home", "label":"menu-home","url":"/","image":"glyphicon glyphicon-home", "status": 1, "children":[]},
	{"id":"menu-company", "label":"menu-company","url":"#","image":"glyphicon glyphicon-tasks", "status": 1,"children":
		[
			{"id":"menu-companylist", "label":"menu-companylist","url":"/companies/list","image":"glyphicon glyphicon-tasks", "status": 1,"children":[]},
			{"id":"menu-workflowtype-list", "label":"menu-workflowtype-list","url":"/companies/workflowtype","image":"glyphicon glyphicon-tasks", "status": 1,"children":[]}
		]
	},
	{"id":"menu-workflow", "label":"menu-workflow","url":"#","image":"glyphicon glyphicon-tasks", "status": 1,"children":
		[
			{"id":"menu-workflow-list", "label":"menu-workflow-list","url":"/workflow/list","image":"glyphicon glyphicon-tasks", "status": 1,"children":[]},
			{"id":"menu-workflow-create", "label":"menu-workflowtype-list","url":"/workflow/create","image":"glyphicon glyphicon-tasks", "status": 1,"children":[]}
		]
	},
	{"id":"menu-user", "label":"menu-user","url":"#","image":"glyphicon glyphicon-user", "status": 1,"children":
		[
			{"id":"menu-changepassword", "label":"menu-changepassword","url":"/user/changepassword","image":"glyphicon glyphicon-lock", "status": 1,"children":[]}
		]
	},
	{"id":"menu-options", "label":"menu-options","url":"#","image":"glyphicon glyphicon-wrench", "status": 1,"children":
		[
			{"id":"menu-urlsettings", "label":"menu-urlsettings","url":"/settings/url","image":"glyphicon glyphicon-ok", "status": 1,"children":[]},
			{"id":"menu-urlsettings-test1", "label":"menu-urlsettings-test1","url":"/settings/url","image":"glyphicon glyphicon-certificate", "status": 1,"children":[]},
			{"id":"menu-urlsettings-test2", "label":"menu-urlsettings-test2","url":"/settings/url","image":"glyphicon glyphicon-certificate", "status": 1,"children":[]}
		]
	},
	{"id":"menu-about", "label":"menu-about","url":"/about","image":"glyphicon glyphicon-info-sign", "status": 1,"children":[]}
];


/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/