(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"],{

/***/ "./$$_lazy_route_resource lazy recursive":
/*!******************************************************!*\
  !*** ./$$_lazy_route_resource lazy namespace object ***!
  \******************************************************/
/*! no static exports found */
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncaught exception popping up in devtools
	return Promise.resolve().then(function() {
		var e = new Error("Cannot find module '" + req + "'");
		e.code = 'MODULE_NOT_FOUND';
		throw e;
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html":
/*!**********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html ***!
  \**********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<h1>About!</h1>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html":
/*!**************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html ***!
  \**************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<app-top-bar [menus]=\"(generalDataObs | async)?.app.menus\" [currentUser]=\"(generalDataObs | async)?.user.currentUser\" [isLogged]=\"(generalDataObs | async)?.isLogged\"\r\n  (loggingOut)=\"onLoggingOut($event)\"></app-top-bar>\r\n\r\n<div class=\"container\">\r\n    \r\n\t<router-outlet></router-outlet>\r\n\t\r\n</div>\r\n\r\n<app-message-bar [currentUser]=\"(generalDataObs | async)?.user.currentUser\" [isLogged]=\"(generalDataObs | async)?.isLogged\"></app-message-bar>\r\n\r\n<app-error-dialog></app-error-dialog>\r\n\r\n<app-loading-dialog></app-loading-dialog>\r\n\r\n<app-footer></app-footer>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/error-dialog/error-dialog.component.html":
/*!***********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/error-dialog/error-dialog.component.html ***!
  \***********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade\" [ngClass]=\"{'show' : showError}\" tabindex=\"-1\" *ngIf=\"showError\" id=\"errormessagedialog\" role=\"dialog\" aria-labelledby=\"errorMessagedialogCenterTitle\">\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t\t<div class=\"modal-content\">\n\t\t\t\t<div class=\"modal-header\">\n\t\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.errormessagetitle' | translate }}</h5>\n\t\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideModal()\" aria-label=\"Close\">\n\t\t\t\t\t\t<i class=\"material-icons\">close</i>\n\t\t\t\t\t</button>\n\t\t\t</div>\n\t\t\t\t<div class=\"modal-body\">\n\t\t\t\t\n\t\t\t<div class=\"content-container alert alert alert-danger\" style=\"margin-bottom:0;\">\n\t\t\t\n\t\t\t\t<div class=\"errorcontent-message\" [innerHTML]=\"errorMessage\"></div>\n\t\t\t\t<div [hidden]=\"hasErrorDetail === false\">\n\t\t\t\t\t<input style=\"float:right\" type=\"checkbox\" id=\"showerrordetailcheck\" [(ngModel)]=\"showErrorDetail\" >\n\t\t\t\t\t<label style=\"float:right; margin-right: 10px;\" class=\"form-check-label\" for=\"showerrordetailcheck\">{{ 'common.details' | translate }}</label>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t<div id=\"errorcontent-detail\" style=\"padding: 10px; background-color:#d9e3ea; \" [hidden]=\"showErrorDetail === false\">\n\t\t\t\t\t<div style=\"height: 300px; width: 100%; overflow: auto;\">\n\t\t\t\t\t\t<pre [innerHTML]=\"errorDetails\"></pre> \n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\n\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"modal-footer\">\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideModal()\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t</div>\n\t\t\t</div>\n\t</div>\n\t\t\t\n</div>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/loading-dialog/loading-dialog.component.html":
/*!***************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/loading-dialog/loading-dialog.component.html ***!
  \***************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade\" [ngClass]=\"{'show' : showLoading}\" tabindex=\"-1\" *ngIf=\"showLoading\" id=\"loadingdialog\" role=\"dialog\">\n\t<div class=\"loading\" role=\"document\">\n\t\t\t\n\t</div>\n\t\t\t\n</div>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/select-user/select-user.component.html":
/*!*********************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/components/select-user/select-user.component.html ***!
  \*********************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t    <div class=\"modal fade\" [ngClass]=\"{'show' : showAssignModal}\" tabindex=\"-1\" id=\"assignlistdialog\" role=\"dialog\" aria-labelledby=\"exampleModalCenterTitle\">\n\t\t\t\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t\t\t    <div class=\"modal-content user-select-modal-content\" >\n\t\t\t\t      <div class=\"modal-header\">\n\t\t\t\t        <h5 class=\"modal-title dialog-title\" id=\"exampleModalLongTitle\">{{ 'workflow-select-assign' | translate }}</h5>\n\t\t\t\t        <button class=\"dialog-toolbar-button close\" (click)=\"hideAssignSelect()\">\n\t\t\t\t        \t<i class=\"material-icons\">close</i>\n\t\t\t\t        </button>\n\t\t\t\t      </div>\n\t\t\t\t      <div class=\"modal-body\">\n\t\t\t\t\t\t\t<ul class=\"nav nav-tabs\">\n\t\t\t\t\t\t\t  <li class=\"active\"><a data-toggle=\"tab\" class=\"nav-link active\" href=\"#tabusers\">{{ 'common.users' | translate }}</a></li>\n\t\t\t\t\t\t\t  <li><a data-toggle=\"tab\" class=\"nav-link\" href=\"#tabdepartments\">{{ 'common.departments' | translate }}</a></li>\n\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t<div class=\"tab-content tab-body user-select-tab-content\">\n\t\t\t\t\t\t\t\t<div id=\"tabusers\" class=\"tab-pane fade in active show\">\n\t\t\t\t\t\t\t\t\t<ul class=\"list-item-container\">\n\t\t\t\t\t\t\t\t\t\t<li class=\"list-item\" *ngFor=\"let item of users;\">\n\t\t\t\t\t\t\t\t\t\t\t<input [attr.data-assigntitle]=\"item.fullName\" type=\"checkbox\" #inputEl class=\"assign-checkbox\" [checked]=\"isItemAssigned(item.identity, assignTypeUser)\" (change)=\"toggleAssign(item.identity, assignTypeUser, inputEl.checked)\"  value=\"{{item.identity}}\"/> \n\t\t\t\t\t\t\t\t\t\t\t<span class=\"user-select-item-label\">{{item.fullName}}</span>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div id=\"tabdepartments\" class=\"tab-pane fade\">\n\t\t\t\t\t\t\t\t\t<ul class=\"list-item-container\">\n\t\t\t\t\t\t\t\t\t\t<li *ngFor=\"let dep of departments;\" class=\"list-item\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" [attr.data-assigntitle]=\"dep.title\" #inputEl class=\"assign-checkbox\" [checked]=\"isItemAssigned(dep.identity, assignTypeDepartment)\" (change)=\"toggleAssign(dep.identity, assignTypeDepartment, inputEl.checked)\" value=\"{{dep.identity}}\"/> \n\t\t\t\t\t\t\t\t\t\t\t<span class=\"user-select-item-label\">{{dep.title}}</span>\n\t\t\t\t\t\t\t\t\t\t\t<ul class=\"list-item-container\">\n\t\t\t\t\t\t\t\t\t\t\t\t<li *ngFor=\"let depgrp of dep.departmentGroups;\" class=\"list-item\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"assign-checkbox\" #inputEl [attr.data-assigntitle]=\"depgrp.title\" [checked]=\"isItemAssigned(depgrp.identity, assignTypeDepartmentGroup)\" (change)=\"toggleAssign(depgrp.identity, assignTypeDepartmentGroup, inputEl.checked)\" value=\"{{depgrp.identity}}\"/> \t \n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"user-select-item-label\">{{depgrp.title}}</span>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\t\t\t</ul>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</li>\n\t\t\t\t\t\t\t\t\t</ul>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t      \n\t\t    \t\t\t\t\n\t\t\t\t      </div>\n\t\t\t\t      <div class=\"modal-footer\">\n\t\t\t\t        <button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideAssignSelect()\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t        <button type=\"button\" class=\"btn btn-primary\" (click)=\"applyUserSelect();\"><i class=\"material-icons\">check</i></button>\n\t\t\t\t      </div>\n\t\t\t\t    </div>\n\t\t\t\t  </div>\t\t    \n\t\t    \t\n\t\t    </div>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html":
/*!************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html ***!
  \************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<footer class=\"footer\">\r\n    <strong><span>{{ 'site.footer' | translate }}</span></strong>\r\n\t<span class=\"footer-title\"></span>\r\n</footer>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html":
/*!********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html ***!
  \********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<h1>Home!</h1>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html":
/*!**********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html ***!
  \**********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div class=\"login-container-parent layout-align-center-center layout-row\" layout=\"row\" layout-align=\"center center\">\r\n\t<div class=\"login-container\">\r\n\t\t<form method=\"POST\" [formGroup]=\"loginForm\" id=\"formlogin\" >\r\n          <div class=\"form-group\">\r\n\t          <label>{{ 'common.companyidentificator' | translate }}</label> \r\n\t          <input type=\"text\" name=\"companyid\" autofocus=\"\" formControlName=\"companyid\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.companyid.errors }\">          \r\n\t          <div *ngIf=\"submitted && forms.companyid.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.companyid.errors.required\">CopmayId is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.username' | translate }}</label> \r\n\t          <input type=\"text\" name=\"username\" autofocus=\"\" formControlName=\"username\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.username.errors }\">\r\n\t          <div *ngIf=\"submitted && forms.username.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.username.errors.required\">Username is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.password' | translate }}</label> \r\n\t          <input type=\"password\" name=\"password\" formControlName=\"password\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.password.errors }\"> \r\n\t          <div *ngIf=\"submitted && forms.password.errors\" class=\"invalid-feedback\">\r\n\t            <div *ngIf=\"forms.password.errors.required\">Password is required</div>\r\n\t          </div>\r\n          </div>  \r\n          <div layout=\"row\" class=\"layout-row form-group\">\r\n             \r\n\t\t\t<button (click)=\"onSubmit()\" type=\"button\" [disabled]=\"loading\" class=\"btn btn-primary\">\r\n\t\t\t   <span *ngIf=\"loading\" class=\"spinner-border spinner-border-sm mr-1\"></span>\r\n\t\t\t   {{ 'common.login' | translate }}\r\n\t\t\t</button>\r\n            <div *ngIf=\"submitted && failedLogin\" class=\"invalid-message\">\r\n              <div>{{loginResponse.message}}</div>\r\n            </div>\r\n\t\t\t\r\n          </div> \r\n\t\t</form>\r\n\t\t\r\n\t</div>\r\n\r\n</div>\r\n\r\n\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html":
/*!**********************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html ***!
  \**********************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div mwlResizable [enableGhostResize]=\"true\" [resizeEdges]=\"{ bottom: false, right: false, top: true, left: false }\" (resizeEnd)=\"onResizeEnd($event)\" class=\"message-panel-container\" id=\"message-panel-container\" *ngIf=\"isAppLogged\">\n\t<div class=\"message-panel-toolbar\">\n\t\t<span class=\"title\">Meldungen</span> &nbsp; &nbsp; <span [ngStyle]=\"{'color':subscribed ? 'green' : 'red' }\">{{status}}</span>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"closeMessages();\"><i class=\"material-icons\">keyboard_arrow_down</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed == false\" (click)=\"showMessages();\"><i class=\"material-icons\">keyboard_arrow_up</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"reloadMessages();\"><i class=\"material-icons\">refresh</i></button>\n\t\t<img class=\"toolbar-image\" *ngIf=\"isReloadingMessages\" src=\"assets/images/loading200.gif\" />\n\t\n\t</div>\n\t<div class=\"message-panel-items-container\">\n\t\t<div class=\"message-panel-item\" *ngFor=\"let message of messages;\">\n\t\t\t<a href=\"javascript:void(0);\" (click)=\"showWorkflowView(message.workflowIdentity)\">\n\t\t\t\t<div>{{message.message}} ({{message.workflow.workflowType.title}}) ({{message.createdAtString}}) ({{message.remainingDays}}) ({{message.status}})</div>\n\t\t\t</a>\n\t\t</div>\n\t</div>\n\t\t\t\t\t\n</div>\n\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"viewWorkflow\" id=\"viewworkflowedialog\" role=\"dialog\">\n\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t<div class=\"modal-content\">\n\t\t\t<div class=\"modal-header\">\n\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.view-workflow' | translate }}</h5>\n\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideViewModal()\" aria-label=\"Close\">\n\t\t\t\t\t<i class=\"material-icons\">close</i>\n\t\t\t\t</button>\n\t\t\t</div>\n\t\t\t\n\t\t      <div class=\"modal-body\">\n\t\t      \n\t\t\t\t<app-workflow-inlineview [workflow]=\"viewWorkflowModel\"></app-workflow-inlineview>\n\t   \t\t\t\t\n\t\t      </div>\n\t      <div class=\"modal-footer\">\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideViewModal()\"><i class=\"material-icons\">close</i></button>\n\n\t\t\t<button type=\"button\" class=\"btn btn-success\"  *ngIf=\"viewWorkflowModel.notAssigned\" (click)=\"assignWorkflowMe()\"><i class=\"material-icons\">assignment_ind</i></button>\n\n\t        <button type=\"button\" class=\"btn btn-primary\" *ngIf=\"viewWorkflowModel.meAssigned\" (click)=\"editWorkflow()\" ><i class=\"material-icons\">pageview</i></button>\n\t      </div>\n\t    </div>\n\t  </div>\t\t    \n\n\n\t\t\t\n</div>\n\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/test/test.component.html":
/*!********************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/test/test.component.html ***!
  \********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div class=\"main-content\">\n    <div class=\"\">\n        <div>\n        \t<div class=\"form-group\">\n               <button class=\"btn btn-primary\" (click)=\"subscribe()\" type=\"button\" [disabled]=\"subscribed || sending\">Subscribe</button>&nbsp; &nbsp; \n               <button class=\"btn btn-secondary\" (click)=\"unsubscribe()\" type=\"button\" [disabled]=\"subscribed === false || sending\">Unsubscribe</button>\n               &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; <span>WebSocket connection: {{status}}</span> \n        \t</div>\n        </div>\n        <div>          \n             <div class=\"form-group\">\n                 <label for=\"name\">What is your name?</label>&nbsp; &nbsp; \n                 <input type=\"text\" [(ngModel)]=\"message\" style=\"width: calc(100% - 90px); display: inline-block;\" class=\"form-control\" placeholder=\"Your message here...\">&nbsp; &nbsp; \n                 <button (click)=\"send()\" class=\"btn btn-success\" [disabled]=\"subscribed === false || sending\">Send</button>\n             </div>            \n        </div>\n    </div>\n    \n    <div class=\"responsediv\">\n    \tstate: {{state | json}}\n    </div>\n        \n    <div class=\"responsediv\">\n    \t<div style=\"padding: 5px; border: 1px solid gray; font-weight: bold;\">messageQeue</div>\n    \t<div style=\"padding: 5px; border: 1px solid gray;\" *ngFor=\"let msg of messageQeue; \">{{msg}}</div>\n    </div>\n    \n</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html":
/*!**************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html ***!
  \**************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<header>\r\n\r\n\t\t<nav class=\"navbar navbar-expand-lg navbar-toggleable-md navbar-light bg-light navbar-fixed-top\">\r\n\t\t\t<div class=\"container-fluid\">\r\n\t\t\t\t<div class=\"navbar-header\">\r\n\t\t\t\t\t<a class=\"navbar-brand\" [routerLink]=\"['/']\"><img class=\"logo\" src=\"/assets/images/fbim2.png\"></a>\r\n\t\t\t\t</div>\r\n\t\t\t\t<ul class=\"navbar-nav\" *ngIf=\"isLogged\">\r\n\t\t\t\t\t<li class=\"nav-item\" *ngFor=\"let menu of menus;\" [ngClass]=\"{'dropdown' : menu.children.length > 0}\">\r\n\t\t\t\t\t\t<a class=\"nav-link\" [routerLink]=\"[menu.url]\" *ngIf=\"menu.children.length == 0\">\r\n\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-home menu-image\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" *ngIf=\"menu.children.length > 0\" href=\"#\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t\t\t\t<span class=\"{{menu.image}}\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"dropdown-menu\" *ngIf=\"menu.children.length > 0\">\r\n\t\t\t\t\t\t\t<a [routerLink]=\"[submenu.url]\" *ngFor=\"let submenu of menu.children;\" class=\"dropdown-item\">\r\n\t\t\t\t\t\t\t\t<span class=\"{{submenu.image}}\"></span>\r\n\t\t\t\t\t\t\t\t<span>{{submenu.label}}</span>\r\n\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t</ul>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t<div class=\"btn-group navbar-user-detail\" *ngIf=\"isLogged\" >\r\n\t\t\t\t  <button type=\"button\" class=\"btn user-toggle-button\" data-toggle=\"dropdown\" data-display=\"static\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t    <span>{{currentUser.fullName}}</span>\r\n\t\t\t\t  </button>\r\n\t\t\t\t  <div class=\"dropdown-menu dropdown-menu-lg-right\">\r\n\t\t\t\t    <button (click)=\"showProfile()\" class=\"dropdown-item\" type=\"button\">Profile</button>\r\n\t\t\t\t    <div class=\"dropdown-divider\"></div>\r\n\t\t\t\t    <button (click)=\"logout()\"  class=\"dropdown-item\" type=\"button\">Logout</button>\r\n\t\t\t\t  </div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</nav>    \t\t\t    \r\n\t\t\r\n\t        \r\n</header>\r\n\r\n<div style=\"background-color: #eeeeee;\" *ngIf=\"isLogged\">\r\n\t<ul class=\"breadcrumb\">\r\n\t\t<li>\r\n\t\t\t<span>Home</span>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t\t<button (click)=\"test()\" type=\"button\">Test</button>\r\n\t\t</li>\r\n\t</ul>\r\n\t\r\n\t\r\n</div>\r\n\t");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-invoice/create-invoice.component.html":
/*!*************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-invoice/create-invoice.component.html ***!
  \*************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ pageTitle }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t\t<button class=\"toolbar-button\" (click)=\"reload();\"><i class=\"material-icons\">refresh</i></button>\n\t\t\t\t&nbsp; &nbsp; &nbsp; \n\t\t\t\t\n\t\t\t\t<div class=\"input-group ocrscan-container\">\n\t\t\t\t  <div class=\"input-group-prepend\">\n\t\t\t\t    <span class=\"input-group-text\" id=\"inputGroupFileAddon01\">{{ 'invoice-create-by-file' | translate }}</span>\n\t\t\t\t  </div>\n\t\t\t\t  <div class=\"custom-file\">\n\t\t\t\t    <input type=\"file\" class=\"custom-file-input\" id=\"scrscanfile\" (change)=\"scanOcrProgress($event)\" aria-describedby=\"inputGroupFileAddon01\">\n\t\t\t\t    <label class=\"custom-file-label\" for=\"scrscanfile\">{{ uplaodingFileName }}</label>\n\t\t\t\t    <button class=\"btn btn-primary upload-button\" (click)=\"uploadOcrScanFile();\"><i class=\"material-icons\">cloud_upload</i></button>\n\t\t\t\t  </div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\t\n\t\t\t</div>\n\t\t\t\n\t\t\t<div class=\"workflow-content-container\">\n\t\t\t\t<div class=\"workflow-content\">\n\t\t\t\t\t<form id=\"workflow-form\" name=\"workflowForm\" [formGroup]=\"invoiceEditForm\">\n\t\t\t\t\t\t<div class=\"panel panel-default\">\n\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-invoice' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-sender' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"sender\" formControlName=\"sender\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-label small-label\">{{ 'invoice-trusted' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\"  >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-invoicenumber' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"registerNumber\" formControlName=\"registerNumber\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div  class=\"item-label label-required small-label\">{{ 'invoice-invoicedate' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" (change)=\"invoiceDateChanges()\" (dateInput)=\"invoiceDateChanges()\" matInput [matDatepicker]=\"invocieDatepicker\" placeholder=\"{{ 'invoice-invoicedate-select' | translate }}\" formControlName=\"invocieDate\" >\n\t\t\t\t\t\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"invocieDatepicker\"></mat-datepicker-toggle>\n\t\t\t\t\t\t\t\t\t\t<mat-datepicker #invocieDatepicker startView=\"month\" [startAt]=\"invoiceEditForm.controls.invocieDate.value\"></mat-datepicker>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ paymentamountTitle }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"paymentAmount\" formControlName=\"paymentAmount\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-invoicetype' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\n\t\t\t\t\t\t\t\t\t\t<select required name=\"invoiceType\" formControlName=\"invoiceType\" [ngClass]=\"{'ng-invalid' : invoiceEditForm.controls.invoiceType.errors}\" >\n\t\t\t\t\t\t\t\t\t\t\t<option *ngFor=\"let invoiceType of invoiceTypes;\" value=\"{{invoiceType.value}}\">{{invoiceType.title}}</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"twopannel\">\n\t\t\t\t\t\t\t<div class=\"panel panel-default panel-vendor\">\n\t\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-vendor' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-vendornumber' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"vendorNumber\" formControlName=\"vendorNumber\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-partnercode' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"partnerCode\" formControlName=\"partnerCode\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-vendorname' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"vendorName\" formControlName=\"vendorName\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-isdirectdebitpermission' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"isDirectDebitPermission\" formControlName=\"isDirectDebitPermission\" [checked]=\"forms.isDirectDebitPermission.value\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\n\t\t\n\t\t\t\t\t\t\t<div class=\"panel panel-default panel-discount\" *ngIf=\"isPaymentInvoiceType() === false\">\n\t\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-discount' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountenterdate-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" matInput (change)=\"calcDiscountDate()\" (dateInput)=\"calcDiscountDate()\" [matDatepicker]=\"discountEnterDatepicker\" placeholder=\"{{ 'invoice-discountenterdate' | translate }}\" formControlName=\"discountEnterDate\" >\n\t\t\t\t\t\t\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"discountEnterDatepicker\"></mat-datepicker-toggle>\n\t\t\t\t\t\t\t\t\t\t\t<mat-datepicker #discountEnterDatepicker startView=\"month\" [startAt]=\"invoiceEditForm.controls.discountEnterDate.value\"></mat-datepicker>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountrate-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"discountRate\" class=\"short-input\" formControlName=\"discountRate\" > %\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountdeadline-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"discountDeadline\" (change)=\"calcDiscountDate()\" class=\"short-input\" formControlName=\"discountDeadline\" > <span>{{ 'common.days' | translate }}</span>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountdate' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" readonly placeholder=\"{{ 'invoice-discountdate' | translate }}\" formControlName=\"discountDate\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'workflow-controller' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t<select type=\"text\" class=\"fullrow\" formControlName=\"controllerIdentity\">\n\t\t\t\t\t\t\t\t\t<option value=\"0\">{{ 'workflow-select-controller' | translate }}</option>\n\t\t\t\t\t\t\t\t\t<option *ngFor=\"let user of users;\" value=\"{{user.identity}}\">{{user.fullName}}</option>\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-label label-large\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t<textarea class=\"comments-fullrow\" formControlName=\"comments\"></textarea>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-label label-large\">{{ 'workflow-assignto' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t<div class=\"assign-list\" >\n\t\t\t\t\t\t\t\t\t<button class=\"show-select-dialog\" (click)=\"showAssignSelect()\"><i class=\"material-icons\">playlist_add</i></button>\n\t\t\t\t\t\t\t\t\t<span *ngIf=\"hasNoAssigns\">{{ 'workflow-select-assign' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<div class=\"user-item-box\" *ngFor=\"let item of assignedUsers\">\n\t\t\t\t\t\t\t\t\t\t<span>{{getAssignItemTitle(item)}} </span>\n\t\t\t\t\t\t\t\t\t\t<button (click)=\"removeAssign(item.itemIdentity, item.itemType)\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\n\t\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"workflow-step-button-bar\">\n\t\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save()\" [disabled]=\"invoiceEditForm.invalid\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t\t\t<span>{{ 'common.create' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</form>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\n\t\t\t</div>\n\t\t    \t\t \n\t\t\t<app-select-user [users]=\"(generalDataObs | async)?.company.users\" [departments]=\"(generalDataObs | async)?.company.departments\" \n\t\t\t\t[showAssignModal]=\"showAssignModal\" [selectAssign]=\"selectAssign\" (onUsersSelected)=\"onUsersSelected($event)\"></app-select-user>\t\t    \t\t \t\t\n\n\t\t\n\t\t</div>\n\n\n\t\t<div class=\"modal fade\" [ngClass]=\"{'show' : showUploading}\" tabindex=\"-1\" *ngIf=\"showUploading\" role=\"dialog\">\n\t\t\t<div class=\"modal-dialog uploading-dialog \" role=\"document\">\n\t\t\t\t<div class=\"loading-upload-icon\"></div>\n\t\t\t\t<div class=\"progress uploading-progress\">\n\t\t\t\t\t<div class=\"progress-bar\" role=\"progressbar\" [style.width]=\"intervalValue+'%'\" [attr.aria-valuenow]=\"intervalValue\" aria-valuemin=\"0\" aria-valuemax=\"100\"></div>\n\t\t\t\t  \t<div class=\"uploading-progress-label\"><span>{{ uplaodingMessage }} {{intervalValue}}%</span></div>\t\n\t\t\t\t</div>\t\t\t\n\t\t\t</div>\n\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-singletask/create-singletask.component.html":
/*!*******************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-singletask/create-singletask.component.html ***!
  \*******************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-create' | translate }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t</div>\n\t\t\n\t\t\t<div class=\"workflow-content\">\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'common.expiredays' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\"><input type=\"number\" max=\"999\" min=\"1\" maxlength=\"3\" [(ngModel)]=\"expireDays\" /></div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-controller' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<select [(ngModel)]=\"controllerIdentity\">\n\t\t\t\t\t\t\t<option value=\"0\">{{ 'workflow-select-controller' | translate }}</option>\n\t\t\t\t\t\t\t<option *ngFor=\"let user of users;\" value=\"{{user.identity}}\">{{user.fullName}}</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-assignto' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<div class=\"assign-list\" >\n\t\t\t\t\t\t\t<button class=\"show-select-dialog\" (click)=\"showAssignSelect()\"><i class=\"material-icons\">playlist_add</i></button>\n\t\t\t\t\t\t\t<span *ngIf=\"hasNoAssigns\">{{ 'workflow-select-assign' | translate }}</span>\n\t\t\t\t\t\t\t<div class=\"user-item-box\" *ngFor=\"let item of assignedUsers\">\n\t\t\t\t\t\t\t\t<span>{{getAssignItemTitle(item)}} </span>\n\t\t\t\t\t\t\t\t<button (click)=\"removeAssign(item.itemIdentity, item.itemType)\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<textarea [(ngModel)]=\"comments\"></textarea>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-files' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content file-container\">\n\t\t\t\t\t\t<div *ngFor=\"let file of fileTitles; let fileIndex = index\" class=\"file-row\">\n\t\t\t\t\t\t\t{{fileIndex + 1}}.\n\t\t\t\t\t\t\t<input type=\"text\" class=\"file-item file-title\" placeholder=\"Datei Titel\" [(ngModel)]=\"file.title\"/>\n\t\t\t\t\t\t\t<input type=\"file\" class=\"file-item file-file\" (change)=\"fileTitleProgress($event, file, fileIndex)\"/>\n\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"removeFile(fileIndex)\"><i class=\"material-icons\">delete</i></button>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div style=\"margin-top: 20px;\">\n\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"addFile()\"><i class=\"material-icons\">add</i></button>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"item-content workflow-step-button-bar\">\n\t\t\t\t\t\t<button (click)=\"save()\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t<span>{{ 'common.save' | translate }}</span>\n\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t</button>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t        \t\t\t\t\n\t\t\t\t<div class=\"item-row\" [innerHTML]=\"debugData\">\n\t\t\t\t</div>\n\n\t\t\t</div>\n\t\t    \n\t\t\t<app-select-user [users]=\"(generalDataObs | async)?.company.users\" [departments]=\"(generalDataObs | async)?.company.departments\" \n\t\t\t\t[showAssignModal]=\"showAssignModal\" [selectAssign]=\"selectAssign\" (onUsersSelected)=\"onUsersSelected($event)\"></app-select-user>\t\t    \t\t \t\t\n\n\t\t    \t\t \t\t\n\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.html":
/*!*************************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.html ***!
  \*************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-create' | translate }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t</div>\n\t\t\n\t\t\t<div class=\"workflow-content\">\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'common.expiredays' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\"><input type=\"number\" max=\"999\" min=\"1\" maxlength=\"3\" [(ngModel)]=\"expireDays\" /></div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-controller' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<select type=\"text\" [(ngModel)]=\"controllerIdentity\">\n\t\t\t\t\t\t\t<option value=\"0\">{{ 'workflow-select-controller' | translate }}</option>\n\t\t\t\t\t\t\t<option *ngFor=\"let user of (generalDataObs | async)?.company.users;\" value=\"{{user.identity}}\">{{user.fullName}}</option>\n\t\t\t\t\t\t</select>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-assignto' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<div class=\"assign-list\" >\n\t\t\t\t\t\t\t<button class=\"show-select-dialog\" (click)=\"showAssignSelect()\"><i class=\"material-icons\">playlist_add</i></button>\n\t\t\t\t\t\t\t<span *ngIf=\"hasNoAssigns\">{{ 'workflow-select-assign' | translate }}</span>\n\t\t\t\t\t\t\t<div class=\"user-item-box\" *ngFor=\"let item of assignedUsers\">\n\t\t\t\t\t\t\t\t<span>{{getAssignItemTitle(item)}} </span>\n\t\t\t\t\t\t\t\t<button (click)=\"removeAssign(item.itemIdentity, item.itemType)\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t<textarea [(ngModel)]=\"comments\"></textarea>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-files' | translate }}</div>\n\t\t\t\t\t<div class=\"item-content file-container\">\n\t\t\t\t\t\t<div *ngFor=\"let file of fileTitles; let fileIndex = index\" class=\"file-row\">\n\t\t\t\t\t\t\t{{fileIndex + 1}}.\n\t\t\t\t\t\t\t<input type=\"text\" class=\"file-item file-title\" placeholder=\"Datei Titel\" [(ngModel)]=\"file.title\"/>\n\t\t\t\t\t\t\t<input type=\"file\" class=\"file-item file-file\" (change)=\"fileTitleProgress($event, file, fileIndex)\"/>\n\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"removeFile(fileIndex)\"><i class=\"material-icons\">delete</i></button>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div style=\"margin-top: 20px;\">\n\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"addFile()\"><i class=\"material-icons\">add</i></button>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\n\t\t\t\t\t<div class=\"item-content workflow-step-button-bar\">\n\t\t\t\t\t\t<button (click)=\"save()\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t<span>{{ 'common.save' | translate }}</span>\n\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t</button>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t        \t\t\t\t\n\t\t\t\t<div class=\"item-row\" [innerHTML]=\"debugData\">\n\t\t\t\t</div>\n\n\t\t\t</div>\n\t\t    \n\t\t\t<app-select-user [users]=\"(generalDataObs | async)?.company.users\" [departments]=\"(generalDataObs | async)?.company.departments\" \n\t\t\t\t[showAssignModal]=\"showAssignModal\" [selectAssign]=\"selectAssign\" (onUsersSelected)=\"onUsersSelected($event)\"></app-select-user>\t\t    \t\t \t\t\n\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/workflow-create/workflow-create.component.html":
/*!***************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/workflow-create/workflow-create.component.html ***!
  \***************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\r\n\t\t\t<div class=\"page-toolbar\">\r\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-create' | translate }}</div>\r\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"workflow-content\">\r\n\t\t\t\t<div class=\"item-row\">\r\n\t\t\t\t\t<div class=\"list-group\">\r\n\t\t\t\t\t  <a class=\"list-group-item list-group-item-action list-group-item-title\">{{ 'workflow-type' | translate }}</a>\r\n\t\t\t\t\t  <a *ngFor=\"let type of worlflowTypes;\" [routerLink]=\"['/workflow/create/' , type.controllerPreffix ]\" class=\"list-group-item list-group-item-action link-out\" >{{type.title}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"clear\"></div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t</div>\r\n\r\n\r\n\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-invoice/edit-invoice.component.html":
/*!*******************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-invoice/edit-invoice.component.html ***!
  \*******************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ pageTitle }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t\t<button class=\"toolbar-button\" (click)=\"reload();\"><i class=\"material-icons\">refresh</i></button>\n\t\t\t</div>\n\t\t\t\n\t\t\t<div class=\"workflow-content-container\">\n\t\t\t\t<div class=\"workflow-content\">\n\t\t\t\t\t<form id=\"workflow-form\" name=\"workflowForm\" [formGroup]=\"invoiceEditForm\">\n\t\t\t\t\t\t<div class=\"panel panel-default\">\n\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-invoice' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-sender' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"sender\" formControlName=\"sender\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-label small-label\">{{ 'invoice-trusted' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\"  >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-invoicenumber' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"registerNumber\" formControlName=\"registerNumber\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div  class=\"item-label label-required small-label\">{{ 'invoice-invoicedate' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" (change)=\"invoiceDateChanges()\" (dateInput)=\"invoiceDateChanges()\" matInput [matDatepicker]=\"invocieDatepicker\" placeholder=\"{{ 'invoice-invoicedate-select' | translate }}\" formControlName=\"invocieDate\" >\n\t\t\t\t\t\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"invocieDatepicker\"></mat-datepicker-toggle>\n\t\t\t\t\t\t\t\t\t\t<mat-datepicker #invocieDatepicker startView=\"month\" [startAt]=\"invoiceEditForm.controls.invocieDate.value\"></mat-datepicker>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ paymentamountTitle }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content large-content\" >\n\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"paymentAmount\" formControlName=\"paymentAmount\" >\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-invoicetype' | translate }}</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-content small-content\">\n\t\t\t\t\t\t\t\t\t\t<select required name=\"invoiceType\" formControlName=\"invoiceType\" [ngClass]=\"{'ng-invalid' : invoiceEditForm.controls.invoiceType.errors}\" >\n\t\t\t\t\t\t\t\t\t\t\t<option *ngFor=\"let invoiceType of invoiceTypes;\" value=\"{{invoiceType.value}}\">{{invoiceType.title}}</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"twopannel\">\n\t\t\t\t\t\t\t<div class=\"panel panel-default panel-vendor\">\n\t\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-vendor' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-vendornumber' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"vendorNumber\" formControlName=\"vendorNumber\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-partnercode' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"partnerCode\" formControlName=\"partnerCode\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-vendorname' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" required name=\"vendorName\" formControlName=\"vendorName\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required label-large\">{{ 'invoice-isdirectdebitpermission' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"isDirectDebitPermission\" formControlName=\"isDirectDebitPermission\" [checked]=\"forms.isDirectDebitPermission.value\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\n\t\t\n\t\t\t\t\t\t\t<div class=\"panel panel-default panel-discount\" *ngIf=\"isPaymentInvoiceType() === false\">\n\t\t\t\t\t\t\t\t<div class=\"panel-heading\">{{ 'invoice-discount' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"panel-body\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountenterdate-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" matInput (change)=\"calcDiscountDate()\" (dateInput)=\"calcDiscountDate()\" [matDatepicker]=\"discountEnterDatepicker\" placeholder=\"{{ 'invoice-discountenterdate' | translate }}\" formControlName=\"discountEnterDate\" >\n\t\t\t\t\t\t\t\t\t\t\t<mat-datepicker-toggle matSuffix [for]=\"discountEnterDatepicker\"></mat-datepicker-toggle>\n\t\t\t\t\t\t\t\t\t\t\t<mat-datepicker #discountEnterDatepicker startView=\"month\" [startAt]=\"invoiceEditForm.controls.discountEnterDate.value\"></mat-datepicker>\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountrate-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"discountRate\" class=\"short-input\" formControlName=\"discountRate\" > %\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountdeadline-short' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"number\" required name=\"discountDeadline\" (change)=\"calcDiscountDate()\" class=\"short-input\" formControlName=\"discountDeadline\" > <span>{{ 'common.days' | translate }}</span>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-label label-required small-label\">{{ 'invoice-discountdate' | translate }}</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t\t\t<input required class=\"select-date\" readonly placeholder=\"{{ 'invoice-discountdate' | translate }}\" formControlName=\"discountDate\" >\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-label label-large\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t<textarea class=\"comments-fullrow\" formControlName=\"comments\"></textarea>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"item-row\" *ngIf=\"canAssign\">\n\t\t\t\t\t\t\t<div class=\"item-label label-large\">{{ 'workflow-assignto' | translate }}</div>\n\t\t\t\t\t\t\t<div class=\"item-content fullrowfromlabel\">\n\t\t\t\t\t\t\t\t<div class=\"assign-list\" >\n\t\t\t\t\t\t\t\t\t<button class=\"show-select-dialog\" (click)=\"showAssignSelect()\"><i class=\"material-icons\">playlist_add</i></button>\n\t\t\t\t\t\t\t\t\t<span *ngIf=\"hasNoAssigns\">{{ 'workflow-select-assign' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<div class=\"user-item-box\" *ngFor=\"let item of assignedUsers\">\n\t\t\t\t\t\t\t\t\t\t<span>{{getAssignItemTitle(item)}} </span>\n\t\t\t\t\t\t\t\t\t\t<button (click)=\"removeAssign(item.itemIdentity, item.itemType)\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\n\t\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\"workflow-step-button-bar\">\n\t\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(false)\" *ngIf=\"canSave\" [disabled]=\"invoiceEditForm.invalid\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t\t\t<span>{{ 'common.save' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(true)\" *ngIf=\"canDone\" [disabled]=\"invoiceEditForm.invalid\" class=\"button-bar-button step-button button-done\">\n\t\t\t\t\t\t\t\t\t<span>{{ 'common.savedone' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t\t<button type=\"button\" (click)=\"archive()\" *ngIf=\"canArchive\" [disabled]=\"invoiceEditForm.invalid\" class=\"button-bar-button step-button button-archive\">\n\t\t\t\t\t\t\t\t\t<span>{{ 'workflow-archive' | translate }}</span>\n\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t\t<span *ngIf=\"saveMessage !== ''\" class=\"alert alert-success button-bar-alert\">{{saveMessage}}</span>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</form>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\t<div class=\"workflow-record\">\n\t\t\t\t\t<app-workflow-inlineview [workflow]=\"viewWorkflowModel\"></app-workflow-inlineview>\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\n\t\t\t</div>\n\t\t    \t\t \n\t\t\t<app-select-user [users]=\"(generalDataObs | async)?.company.users\" [departments]=\"(generalDataObs | async)?.company.departments\" \n\t\t\t\t[showAssignModal]=\"showAssignModal\" [selectAssign]=\"selectAssign\" (onUsersSelected)=\"onUsersSelected($event)\"></app-select-user>\t\t    \t\t \t\t\n\n\t\t\n\t\t</div>\n\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-single-task/edit-single-task.component.html":
/*!***************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-single-task/edit-single-task.component.html ***!
  \***************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ 'workflow-editing' | translate }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t</div>\n\t\t\t<form id=\"workflow-form\" name=\"workflowForm\" [formGroup]=\"workflowEditForm\">\n\t\t\t\t<div class=\"workflow-content\">\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t<textarea formControlName=\"comments\"></textarea>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-files' | translate }}</div>\n\t\t\t\t\t\t<div class=\"item-content file-container\">\n\t\t\t\t\t\t\t<div *ngFor=\"let file of fileTitles; let fileIndex = index\" class=\"file-row\">\n\t\t\t\t\t\t\t\t{{fileIndex + 1}}.\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"file-item file-title\" placeholder=\"Datei Titel\" formControlName=\"file.title\"/>\n\t\t\t\t\t\t\t\t<input type=\"file\" class=\"file-item file-file\" (change)=\"fileTitleProgress($event, file, fileIndex)\"/>\n\t\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"removeFile(fileIndex)\"><i class=\"material-icons\">delete</i></button>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"margin-top: 20px;\">\n\t\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"addFile()\"><i class=\"material-icons\">add</i></button>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"workflow-step-button-bar\">\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(false)\" *ngIf=\"canSave\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t\t<span>{{ 'common.save' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(true)\" *ngIf=\"canDone\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-done\">\n\t\t\t\t\t\t\t\t<span>{{ 'common.savedone' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"archive()\" *ngIf=\"canArchive\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-archive\">\n\t\t\t\t\t\t\t\t<span>{{ 'workflow-archive' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<span *ngIf=\"saveMessage !== ''\" class=\"alert alert-success button-bar-alert\">{{saveMessage}}</span>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t        \t\t\t\t\n\t\t\t\t\t<div class=\"item-row\" [innerHTML]=\"debugData\"></div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\t<div class=\"workflow-record\">\n\t\t\t\t\t<app-workflow-inlineview [workflow]=\"viewWorkflowModel\"></app-workflow-inlineview>\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t</form>\n\t\t\t\n\t\t    \t\t \t\t\n\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.html":
/*!*********************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.html ***!
  \*********************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\n\t\t\t<div class=\"page-toolbar\">\n\t\t\t\t<div class=\"page-title\">{{ 'workflow-editing' | translate }}</div>\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\n\t\t\t</div>\n\t\t\t\n\t\t\t<form id=\"workflow-form\" name=\"workflowForm\" [formGroup]=\"workflowEditForm\">\n\t\t\n\t\t\t\t<div class=\"workflow-content\">\n\t\t\t\t\t<div class=\"item-row\" *ngIf=\"canAssign\">\n\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-assignto' | translate }}</div>\n\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t<div class=\"assign-list\" >\n\t\t\t\t\t\t\t\t<button class=\"show-select-dialog\" (click)=\"showAssignSelect()\"><i class=\"material-icons\">playlist_add</i></button>\n\t\t\t\t\t\t\t\t<span *ngIf=\"hasNoAssigns\">{{ 'workflow-select-assign' | translate }}</span>\n\t\t\t\t\t\t\t\t<div class=\"user-item-box\" *ngFor=\"let item of assignedUsers\">\n\t\t\t\t\t\t\t\t\t<span>{{getAssignItemTitle(item)}} </span>\n\t\t\t\t\t\t\t\t\t<button (click)=\"removeAssign(item.itemIdentity, item.itemType)\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t<textarea formControlName=\"comments\"></textarea>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-files' | translate }}</div>\n\t\t\t\t\t\t<div class=\"item-content file-container\">\n\t\t\t\t\t\t\t<div *ngFor=\"let file of fileTitles; let fileIndex = index\" class=\"file-row\">\n\t\t\t\t\t\t\t\t{{fileIndex + 1}}.\n\t\t\t\t\t\t\t\t<input type=\"text\" class=\"file-item file-title\" placeholder=\"Datei Titel\" formControlName=\"file.title\"/>\n\t\t\t\t\t\t\t\t<input type=\"file\" class=\"file-item file-file\" (change)=\"fileTitleProgress($event, file, fileIndex)\"/>\n\t\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"removeFile(fileIndex)\"><i class=\"material-icons\">delete</i></button>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"margin-top: 20px;\">\n\t\t\t\t\t\t\t\t<button class=\"file-action\" (click)=\"addFile()\"><i class=\"material-icons\">add</i></button>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<div class=\"workflow-step-button-bar\">\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(false)\" *ngIf=\"canSave\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-save\">\n\t\t\t\t\t\t\t\t<span>{{ 'common.save' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"save(true)\" *ngIf=\"canDone\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-done\">\n\t\t\t\t\t\t\t\t<span>{{ 'common.savedone' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<button type=\"button\" (click)=\"archive()\" *ngIf=\"canArchive\" [disabled]=\"workflowEditForm.invalid\" class=\"button-bar-button step-button button-archive\">\n\t\t\t\t\t\t\t\t<span>{{ 'workflow-archive' | translate }}</span>\n\t\t\t\t\t\t\t\t<i class=\"material-icons\">save</i>\n\t\t\t\t\t\t\t</button>\n\t\t\t\t\t\t\t<span *ngIf=\"saveMessage !== ''\" class=\"alert alert-success button-bar-alert\">{{saveMessage}}</span>\n\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\n\t\t\t\t\t</div>\n\t\t\t\t\t        \t\t\t\t\n\t\t\t\t\t<div class=\"item-row\" [innerHTML]=\"debugData\"></div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\t<div class=\"workflow-record\">\n\t\t\t\t\t\n\t\t\t\t\t<app-workflow-inlineview [workflow]=\"viewWorkflowModel\"></app-workflow-inlineview>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t    </form>\n\t\t    \n\t\t    <app-select-user [users]=\"(generalDataObs | async)?.company.users\" [departments]=\"(generalDataObs | async)?.company.departments\" \n\t\t\t\t[showAssignModal]=\"showAssignModal\" [selectAssign]=\"selectAssign\" (onUsersSelected)=\"onUsersSelected($event)\"></app-select-user>\t\t    \t\t \t\t\n\n\t\t    \t\t \t\t\n\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.html":
/*!****************************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.html ***!
  \****************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t\t\t<div class=\"workflow-inline-content-container\" *ngIf=\"viewWorkflowModel != null\">\n\t\t\t\t\n\t\t\t\t\t<div class=\"workflowview-dialog-content-container\">\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-title' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">{{viewWorkflowModel.workflowType.title}}</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">{{viewWorkflowModel.comments}}</div>\t\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-current-step' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t{{viewWorkflowModel.currentStep.title}}\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-status' | translate }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t{{viewWorkflowModel.status}}\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"padding-top: 10px; padding-left: 10px; border-top: 1px solid gray; margin-top: 10px;\">\n\t\t\t\t\t\t\t\t<div style=\"text-align: center; font-weight: bold;\">Files</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\" *ngFor=\"let file of viewWorkflowModel.files;\" style=\"border-bottom: 1px #9a9a9a dashed\">\n\t\t\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t\t\t\t<a href=\"/workflow/file/view/{{viewWorkflowModel.identity}}/{{file.identity}}\" class=\"workflow-file-view-link\" target=\"_blank\">\n\t\t\t\t\t\t\t\t\t\t\t<strong>{{file.title}}</strong> (Ver: {{file.activeFileVersion}})\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t\t<a href=\"/workflow/file/download/{{viewWorkflowModel.identity}}/{{file.identity}}\" class=\"workflow-file-view-link\" target=\"_blank\">\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save_alt</i>\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"padding-top: 10px; padding-left: 10px; border-top: 1px solid gray; margin-top: 10px;\">\n\t\t\t\t\t\t\t\t<div style=\"text-align: center; font-weight: bold;\">Actions</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\" *ngFor=\"let action of viewWorkflowModel.actions;\" style=\"border-bottom: 1px #9a9a9a dashed\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"action-content\">\n\t\t\t\t\t\t\t\t\t\t\t<div><strong>{{action.currentStep.title}}</strong>:</div> \n\t\t\t\t\t\t\t\t\t\t\t<div>({{action.status}}) ({{action.assignToUserName}})</div> \n\t\t\t\t\t\t\t\t\t\t\t<div style=\"\">{{action.action}}</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html":
/*!****************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html ***!
  \****************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\r\n\t\t\t<div class=\"page-toolbar\">\r\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-list' | translate }}</div>\r\n\t\t\t\t<button class=\"toolbar-button\" (click)=\"reload()\"><i class=\"material-icons\">refresh</i></button>\r\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/create']\"><i class=\"material-icons\">playlist_add</i></a>\r\n\t\t\t\t\r\n\t\t\t\t<ul class=\"nav nav-pills search-toolbar\">\r\n\t\t\t\t\t<li class=\"nav-item dropdown\">\r\n\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Status</a>\r\n\t\t\t\t\t\t<div class=\"dropdown-menu\">\r\n\t\t\t\t\t\t\t<div *ngFor=\"let wstatus of statusList;\" class=\"dropdown-item\">\r\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"form-check-input\" [checked]=\"isStatusSelected(wstatus)\" (click)=\"toggleStatusSelected(wstatus)\"  id=\"status-check-{{wstatus}}\">\r\n\t\t\t\t\t\t\t\t<label class=\"form-check-label\" for=\"status-check-{{wstatus}}\">{{wstatus}}</label>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t  \t<li class=\"nav-item\">\r\n\t\t\t\t  \t\t<div class=\"dropdown-item search-toolbar-item\">\r\n\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"toggle-checkbox form-check-input\" [checked]=\"isMeAssigned\" [(ngModel)]=\"isMeAssigned\"  id=\"me-assigned-check\">\r\n\t\t\t\t\t\t\t<label class=\"form-check-label\" for=\"me-assigned-check\">{{ 'workflow-assigned-me' | translate }}</label>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t  \t</li>\r\n\t\t\t\t</ul>\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t\t<div *ngIf=\"showDebug\" style=\"border: 1px solid gray; padding: 5px; background-color: #f1f1f1;\">{{debugSearchFilter}}</div>\r\n\t\t\t\r\n\t\t\t<table class=\"table table-striped\" [svData]=\"resultWorlflows\" #sv=\"svDataTable\" [svRowsOnPage]=\"5000\" svSortBy=\"name\" svSortOrder=\"asc\">\r\n\t\t\t    <thead>\r\n\t\t\t    <tr>\r\n\t\t\t        <th><sv-default-sorter by=\"workflowType.title\">{{ 'workflow-type' | translate }}</sv-default-sorter></th>\r\n\t\t\t        <th><sv-default-sorter by=\"currentStep.title\">{{ 'workflow-current-step' | translate }}</sv-default-sorter></th>\r\n\t\t\t        <th><sv-default-sorter by=\"status\">{{ 'workflow-status' | translate }}</sv-default-sorter></th>\r\n\t\t\t        <th><sv-default-sorter by=\"assignToUserFullName\">{{ 'workflow-assignto' | translate }}</sv-default-sorter></th>\r\n\t\t\t        <th>\r\n\t\t\t            <sv-default-sorter by=\"updated\">{{ 'workflow-updated' | translate }}</sv-default-sorter>\r\n\t\t\t        </th>\r\n\t\t\t        <th></th>\r\n\t\t\t    </tr>\r\n\t\t\t    </thead>\r\n\t\t\t    <tbody>\r\n\t\t\t\t    <tr *ngFor=\"let item of sv.data; let idx = index\">\r\n\t\t    \t\t\t<td scope=\"row\">{{item.workflowType.title}}</td>\r\n\t\t    \t\t\t<td>{{item.currentStep.title}}</td>\r\n\t\t    \t\t\t<td>{{item.status}}</td>\r\n\t\t    \t\t\t<td>{{item.assignToUserFullName}}</td>\r\n\t\t    \t\t\t<td></td>\r\n\t\t    \t\t\t<td>\r\n\t\t    \t\t\t\t<a class=\"tool-link\" *ngIf=\"item.canEdit\" (click)=\"editWorkflow(item)\"><i class=\"material-icons\">edit</i></a>\r\n\t\t    \t\t\t\t<a class=\"tool-link\" (click)=\"showWorkflow(item.workflowType.identity, idx)\"><i class=\"material-icons\">pageview</i></a>\r\n\t\t    \t\t\t</td>\r\n\t\t\t\t    </tr>\r\n\t\t\t\t    <tr *ngIf=\"resultWorlflows.length == 0\">\r\n\t\t    \t\t\t<td colspan=\"6\">{{ 'workflow-no-result-found' | translate }}</td>\r\n\t\t\t\t    </tr>\r\n\t\t\t    </tbody>\r\n\t\t\t</table>\r\n\t\t\r\n\t\t\r\n\t\t</div>\r\n\r\n\r\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"viewWorkflowModal\" id=\"viewworkflowedialog\" role=\"dialog\">\r\n\r\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\r\n\t\t<div class=\"modal-content\">\r\n\t\t\t<div class=\"modal-header\">\r\n\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.view-workflow' | translate }}</h5>\r\n\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideViewModal()\" aria-label=\"Close\">\r\n\t\t\t\t\t<i class=\"material-icons\">close</i>\r\n\t\t\t\t</button>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t      <div class=\"modal-body\">\r\n\t\t      \r\n\t\t\t\t<app-workflow-inlineview [workflow]=\"viewWorkflowModel\"></app-workflow-inlineview>\r\n\t   \t\t\t\t\r\n\t\t      </div>\r\n\t      <div class=\"modal-footer\">\r\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideViewModal()\"><i class=\"material-icons\">close</i></button>\r\n\r\n\t        <button type=\"button\" class=\"btn btn-primary\" *ngIf=\"viewWorkflowModel.meAssigned || viewWorkflowModel.loggedUserControllerAndDone\" (click)=\"editWorkflow(viewWorkflowModel)\" ><i class=\"material-icons\">pageview</i></button>\r\n\t      </div>\r\n\t    </div>\r\n\t  </div>\t\t    \r\n\t\t\t\r\n</div>\r\n\r\n");

/***/ }),

/***/ "./node_modules/tslib/tslib.es6.js":
/*!*****************************************!*\
  !*** ./node_modules/tslib/tslib.es6.js ***!
  \*****************************************/
/*! exports provided: __extends, __assign, __rest, __decorate, __param, __metadata, __awaiter, __generator, __exportStar, __values, __read, __spread, __spreadArrays, __await, __asyncGenerator, __asyncDelegator, __asyncValues, __makeTemplateObject, __importStar, __importDefault */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__extends", function() { return __extends; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__assign", function() { return __assign; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__rest", function() { return __rest; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__decorate", function() { return __decorate; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__param", function() { return __param; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__metadata", function() { return __metadata; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__awaiter", function() { return __awaiter; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__generator", function() { return __generator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__exportStar", function() { return __exportStar; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__values", function() { return __values; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__read", function() { return __read; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__spread", function() { return __spread; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__spreadArrays", function() { return __spreadArrays; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__await", function() { return __await; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncGenerator", function() { return __asyncGenerator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncDelegator", function() { return __asyncDelegator; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncValues", function() { return __asyncValues; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__makeTemplateObject", function() { return __makeTemplateObject; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importStar", function() { return __importStar; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importDefault", function() { return __importDefault; });
/*! *****************************************************************************
Copyright (c) Microsoft Corporation. All rights reserved.
Licensed under the Apache License, Version 2.0 (the "License"); you may not use
this file except in compliance with the License. You may obtain a copy of the
License at http://www.apache.org/licenses/LICENSE-2.0

THIS CODE IS PROVIDED ON AN *AS IS* BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
KIND, EITHER EXPRESS OR IMPLIED, INCLUDING WITHOUT LIMITATION ANY IMPLIED
WARRANTIES OR CONDITIONS OF TITLE, FITNESS FOR A PARTICULAR PURPOSE,
MERCHANTABLITY OR NON-INFRINGEMENT.

See the Apache Version 2.0 License for specific language governing permissions
and limitations under the License.
***************************************************************************** */
/* global Reflect, Promise */

var extendStatics = function(d, b) {
    extendStatics = Object.setPrototypeOf ||
        ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
        function (d, b) { for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p]; };
    return extendStatics(d, b);
};

function __extends(d, b) {
    extendStatics(d, b);
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
}

var __assign = function() {
    __assign = Object.assign || function __assign(t) {
        for (var s, i = 1, n = arguments.length; i < n; i++) {
            s = arguments[i];
            for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p)) t[p] = s[p];
        }
        return t;
    }
    return __assign.apply(this, arguments);
}

function __rest(s, e) {
    var t = {};
    for (var p in s) if (Object.prototype.hasOwnProperty.call(s, p) && e.indexOf(p) < 0)
        t[p] = s[p];
    if (s != null && typeof Object.getOwnPropertySymbols === "function")
        for (var i = 0, p = Object.getOwnPropertySymbols(s); i < p.length; i++) {
            if (e.indexOf(p[i]) < 0 && Object.prototype.propertyIsEnumerable.call(s, p[i]))
                t[p[i]] = s[p[i]];
        }
    return t;
}

function __decorate(decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
}

function __param(paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
}

function __metadata(metadataKey, metadataValue) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(metadataKey, metadataValue);
}

function __awaiter(thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
}

function __generator(thisArg, body) {
    var _ = { label: 0, sent: function() { if (t[0] & 1) throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
    return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function() { return this; }), g;
    function verb(n) { return function (v) { return step([n, v]); }; }
    function step(op) {
        if (f) throw new TypeError("Generator is already executing.");
        while (_) try {
            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done) return t;
            if (y = 0, t) op = [op[0] & 2, t.value];
            switch (op[0]) {
                case 0: case 1: t = op; break;
                case 4: _.label++; return { value: op[1], done: false };
                case 5: _.label++; y = op[1]; op = [0]; continue;
                case 7: op = _.ops.pop(); _.trys.pop(); continue;
                default:
                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) { _ = 0; continue; }
                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) { _.label = op[1]; break; }
                    if (op[0] === 6 && _.label < t[1]) { _.label = t[1]; t = op; break; }
                    if (t && _.label < t[2]) { _.label = t[2]; _.ops.push(op); break; }
                    if (t[2]) _.ops.pop();
                    _.trys.pop(); continue;
            }
            op = body.call(thisArg, _);
        } catch (e) { op = [6, e]; y = 0; } finally { f = t = 0; }
        if (op[0] & 5) throw op[1]; return { value: op[0] ? op[1] : void 0, done: true };
    }
}

function __exportStar(m, exports) {
    for (var p in m) if (!exports.hasOwnProperty(p)) exports[p] = m[p];
}

function __values(o) {
    var m = typeof Symbol === "function" && o[Symbol.iterator], i = 0;
    if (m) return m.call(o);
    return {
        next: function () {
            if (o && i >= o.length) o = void 0;
            return { value: o && o[i++], done: !o };
        }
    };
}

function __read(o, n) {
    var m = typeof Symbol === "function" && o[Symbol.iterator];
    if (!m) return o;
    var i = m.call(o), r, ar = [], e;
    try {
        while ((n === void 0 || n-- > 0) && !(r = i.next()).done) ar.push(r.value);
    }
    catch (error) { e = { error: error }; }
    finally {
        try {
            if (r && !r.done && (m = i["return"])) m.call(i);
        }
        finally { if (e) throw e.error; }
    }
    return ar;
}

function __spread() {
    for (var ar = [], i = 0; i < arguments.length; i++)
        ar = ar.concat(__read(arguments[i]));
    return ar;
}

function __spreadArrays() {
    for (var s = 0, i = 0, il = arguments.length; i < il; i++) s += arguments[i].length;
    for (var r = Array(s), k = 0, i = 0; i < il; i++)
        for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
            r[k] = a[j];
    return r;
};

function __await(v) {
    return this instanceof __await ? (this.v = v, this) : new __await(v);
}

function __asyncGenerator(thisArg, _arguments, generator) {
    if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
    var g = generator.apply(thisArg, _arguments || []), i, q = [];
    return i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i;
    function verb(n) { if (g[n]) i[n] = function (v) { return new Promise(function (a, b) { q.push([n, v, a, b]) > 1 || resume(n, v); }); }; }
    function resume(n, v) { try { step(g[n](v)); } catch (e) { settle(q[0][3], e); } }
    function step(r) { r.value instanceof __await ? Promise.resolve(r.value.v).then(fulfill, reject) : settle(q[0][2], r); }
    function fulfill(value) { resume("next", value); }
    function reject(value) { resume("throw", value); }
    function settle(f, v) { if (f(v), q.shift(), q.length) resume(q[0][0], q[0][1]); }
}

function __asyncDelegator(o) {
    var i, p;
    return i = {}, verb("next"), verb("throw", function (e) { throw e; }), verb("return"), i[Symbol.iterator] = function () { return this; }, i;
    function verb(n, f) { i[n] = o[n] ? function (v) { return (p = !p) ? { value: __await(o[n](v)), done: n === "return" } : f ? f(v) : v; } : f; }
}

function __asyncValues(o) {
    if (!Symbol.asyncIterator) throw new TypeError("Symbol.asyncIterator is not defined.");
    var m = o[Symbol.asyncIterator], i;
    return m ? m.call(o) : (o = typeof __values === "function" ? __values(o) : o[Symbol.iterator](), i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i);
    function verb(n) { i[n] = o[n] && function (v) { return new Promise(function (resolve, reject) { v = o[n](v), settle(resolve, reject, v.done, v.value); }); }; }
    function settle(resolve, reject, d, v) { Promise.resolve(v).then(function(v) { resolve({ value: v, done: d }); }, reject); }
}

function __makeTemplateObject(cooked, raw) {
    if (Object.defineProperty) { Object.defineProperty(cooked, "raw", { value: raw }); } else { cooked.raw = raw; }
    return cooked;
};

function __importStar(mod) {
    if (mod && mod.__esModule) return mod;
    var result = {};
    if (mod != null) for (var k in mod) if (Object.hasOwnProperty.call(mod, k)) result[k] = mod[k];
    result.default = mod;
    return result;
}

function __importDefault(mod) {
    return (mod && mod.__esModule) ? mod : { default: mod };
}


/***/ }),

/***/ "./src/app/about/about.component.ts":
/*!******************************************!*\
  !*** ./src/app/about/about.component.ts ***!
  \******************************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return AboutComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");


let AboutComponent = class AboutComponent {
    constructor() {
    }
    ngOnInit() {
    }
};
AboutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'app-root', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./about.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html")).default })
], AboutComponent);



/***/ }),

/***/ "./src/app/about/index.ts":
/*!********************************!*\
  !*** ./src/app/about/index.ts ***!
  \********************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _about_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./about.component */ "./src/app/about/about.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return _about_component__WEBPACK_IMPORTED_MODULE_1__["AboutComponent"]; });





/***/ }),

/***/ "./src/app/app.component.css":
/*!***********************************!*\
  !*** ./src/app/app.component.css ***!
  \***********************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7QUFFQTs7OztDQUlDIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi8qXHJcbkNvcHlyaWdodCBHb29nbGUgTExDLiBBbGwgUmlnaHRzIFJlc2VydmVkLlxyXG5Vc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0XHJcbmNhbiBiZSBmb3VuZCBpbiB0aGUgTElDRU5TRSBmaWxlIGF0IGh0dHA6Ly9hbmd1bGFyLmlvL2xpY2Vuc2VcclxuKi8iXX0= */");

/***/ }),

/***/ "./src/app/app.component.ts":
/*!**********************************!*\
  !*** ./src/app/app.component.ts ***!
  \**********************************/
/*! exports provided: AppComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function() { return AppComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm2015/platform-browser.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./services */ "./src/app/services/index.ts");







let AppComponent = class AppComponent {
    constructor(router, autService, global, translate, titleService) {
        this.router = router;
        this.autService = autService;
        this.global = global;
        this.titleService = titleService;
        this.generalDataObs = null;
        this.appShowLoading = false;
        translate.setDefaultLang('de');
        translate.use('de');
        translate.get('site.title').subscribe((res) => {
            this.titleService.setTitle(res);
        });
        this.router.routeReuseStrategy.shouldReuseRoute = function () {
            return false;
        };
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                //if(this.autService.isLoggedIn === true && this.appCurrentUser === null){
                //this.subscribeToGeneralData();
                //this.global.loadAllSetting(null);
                //alert("nav end from app-comp");
                //}
            }
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
    }
    ngOnInit() {
        this.global.loadAllSetting(null);
    }
    showLoading() {
        this.appShowLoading = true;
    }
    onLoggingOut(data) {
        this.autService.logout("");
    }
};
AppComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__["Title"] }
];
AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-root',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html")).default,
        providers: [_services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")).default]
    })
], AppComponent);



/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: createTranslateLoader, socketProvider, AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "createTranslateLoader", function() { return createTranslateLoader; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "socketProvider", function() { return socketProvider; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function() { return AppModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm2015/platform-browser.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/fesm2015/animations.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ngx-translate/http-loader */ "./node_modules/@ngx-translate/http-loader/fesm2015/ngx-translate-http-loader.js");
/* harmony import */ var angular_resizable_element__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! angular-resizable-element */ "./node_modules/angular-resizable-element/fesm2015/angular-resizable-element.js");
/* harmony import */ var ng_angular8_datatable__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ng-angular8-datatable */ "./node_modules/ng-angular8-datatable/index.js");
/* harmony import */ var ng_angular8_datatable__WEBPACK_IMPORTED_MODULE_9___default = /*#__PURE__*/__webpack_require__.n(ng_angular8_datatable__WEBPACK_IMPORTED_MODULE_9__);
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/esm2015/core.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! sockjs-client */ "./node_modules/sockjs-client/lib/entry.js");
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_12___default = /*#__PURE__*/__webpack_require__.n(sockjs_client__WEBPACK_IMPORTED_MODULE_12__);
/* harmony import */ var _material_module__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./material-module */ "./src/app/material-module.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./helper */ "./src/app/helper/index.ts");
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _app_routing__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./app.routing */ "./src/app/app.routing.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");
/* harmony import */ var _top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./top-bar/top-bar.component */ "./src/app/top-bar/top-bar.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./message-bar/message-bar.component */ "./src/app/message-bar/message-bar.component.ts");
/* harmony import */ var _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./components/error-dialog/error-dialog.component */ "./src/app/components/error-dialog/error-dialog.component.ts");
/* harmony import */ var _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./components/loading-dialog/loading-dialog.component */ "./src/app/components/loading-dialog/loading-dialog.component.ts");
/* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
/* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
/* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
/* harmony import */ var _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! ./wm-components/workflow-list/workflow-list.component */ "./src/app/wm-components/workflow-list/workflow-list.component.ts");
/* harmony import */ var _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! ./wm-components/create/workflow-create/workflow-create.component */ "./src/app/wm-components/create/workflow-create/workflow-create.component.ts");
/* harmony import */ var _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! ./wm-components/create/create-singletask/create-singletask.component */ "./src/app/wm-components/create/create-singletask/create-singletask.component.ts");
/* harmony import */ var _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! ./wm-components/create/create-invoice/create-invoice.component */ "./src/app/wm-components/create/create-invoice/create-invoice.component.ts");
/* harmony import */ var _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! ./wm-components/create/create-testthreetask/create-testthreetask.component */ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.ts");
/* harmony import */ var _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! ./wm-components/edit/edit-invoice/edit-invoice.component */ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.ts");
/* harmony import */ var _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! ./wm-components/edit/edit-single-task/edit-single-task.component */ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.ts");
/* harmony import */ var _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! ./wm-components/edit/edit-testthree-task/edit-testthree-task.component */ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.ts");
/* harmony import */ var _wm_components_workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! ./wm-components/workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");
/* harmony import */ var _components_select_user_select_user_component__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! ./components/select-user/select-user.component */ "./src/app/components/select-user/select-user.component.ts");
/* harmony import */ var _test_test_component__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! ./test/test.component */ "./src/app/test/test.component.ts");








































function createTranslateLoader(http) {
    return new _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_7__["TranslateHttpLoader"](http, './assets/i18n/', '.json');
}
function socketProvider() {
    return new sockjs_client__WEBPACK_IMPORTED_MODULE_12__('/iflow-guide-websocket');
}
const stompConfig = {
    url: socketProvider,
    headers: {
        login: 'guest',
        passcode: 'guest'
    },
    heartbeat_in: 0,
    heartbeat_out: 20000,
    reconnect_delay: 5000,
    debug: true
};
let AppModule = class AppModule {
};
AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["BrowserModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
            _app_routing__WEBPACK_IMPORTED_MODULE_16__["appRoutingModule"],
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__["BrowserAnimationsModule"],
            angular_resizable_element__WEBPACK_IMPORTED_MODULE_8__["ResizableModule"],
            ng_angular8_datatable__WEBPACK_IMPORTED_MODULE_9__["DataTableModule"],
            _angular_material_core__WEBPACK_IMPORTED_MODULE_10__["MatNativeDateModule"],
            _material_module__WEBPACK_IMPORTED_MODULE_13__["IFlowMaterialModules"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormsModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateModule"].forRoot({
                loader: {
                    provide: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateLoader"],
                    useFactory: (createTranslateLoader),
                    deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"]]
                }
            }),
        ],
        declarations: [
            _app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"],
            _top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_20__["TopBarComponent"],
            _footer_footer_component__WEBPACK_IMPORTED_MODULE_21__["FooterComponent"],
            _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_22__["MessageBarComponent"],
            _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_23__["ErrorDialogComponent"],
            _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_24__["LoadingDialogComponent"],
            _home__WEBPACK_IMPORTED_MODULE_25__["HomeComponent"],
            _about__WEBPACK_IMPORTED_MODULE_26__["AboutComponent"],
            _login__WEBPACK_IMPORTED_MODULE_27__["LoginComponent"],
            _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_29__["WorkflowCreateComponent"],
            _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_28__["WorkflowListComponent"],
            _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_30__["CreateSingletaskComponent"],
            _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_31__["CreateInvoiceComponent"],
            _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_32__["CreateTestthreetaskComponent"],
            _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_33__["EditInvoiceComponent"],
            _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_34__["EditSingleTaskComponent"],
            _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_35__["EditTestthreeTaskComponent"],
            _wm_components_workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_36__["WorkflowInlineviewComponent"],
            _components_select_user_select_user_component__WEBPACK_IMPORTED_MODULE_37__["SelectUserComponent"],
            _test_test_component__WEBPACK_IMPORTED_MODULE_38__["TestComponent"],
        ],
        providers: [
            _services_global_service__WEBPACK_IMPORTED_MODULE_17__["GlobalService"],
            _services_authentication_service__WEBPACK_IMPORTED_MODULE_18__["AuthenticationService"],
            _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_19__["WorkflowMessageService"],
            _helper__WEBPACK_IMPORTED_MODULE_14__["fakeBackendProvider"],
            _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_11__["StompService"],
            {
                provide: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_11__["StompConfig"],
                useValue: stompConfig
            }
        ],
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"]]
    })
], AppModule);

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ "./src/app/app.routing.ts":
/*!********************************!*\
  !*** ./src/app/app.routing.ts ***!
  \********************************/
/*! exports provided: appRoutingModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "appRoutingModule", function() { return appRoutingModule; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
/* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
/* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
/* harmony import */ var _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./wm-components/workflow-list/workflow-list.component */ "./src/app/wm-components/workflow-list/workflow-list.component.ts");
/* harmony import */ var _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./wm-components/create/workflow-create/workflow-create.component */ "./src/app/wm-components/create/workflow-create/workflow-create.component.ts");
/* harmony import */ var _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./wm-components/create/create-singletask/create-singletask.component */ "./src/app/wm-components/create/create-singletask/create-singletask.component.ts");
/* harmony import */ var _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./wm-components/create/create-invoice/create-invoice.component */ "./src/app/wm-components/create/create-invoice/create-invoice.component.ts");
/* harmony import */ var _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./wm-components/create/create-testthreetask/create-testthreetask.component */ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.ts");
/* harmony import */ var _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./wm-components/edit/edit-invoice/edit-invoice.component */ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.ts");
/* harmony import */ var _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./wm-components/edit/edit-single-task/edit-single-task.component */ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.ts");
/* harmony import */ var _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./wm-components/edit/edit-testthree-task/edit-testthree-task.component */ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.ts");
/* harmony import */ var _test_test_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./test/test.component */ "./src/app/test/test.component.ts");















const routes = [
    { path: '', component: _home__WEBPACK_IMPORTED_MODULE_3__["HomeComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'about', component: _about__WEBPACK_IMPORTED_MODULE_4__["AboutComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/list', component: _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__["WorkflowListComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/create', component: _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_7__["WorkflowCreateComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/create/singletask', component: _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_8__["CreateSingletaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/create/invoice', component: _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_9__["CreateInvoiceComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/create/testthreetask', component: _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_10__["CreateTestthreetaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/edit/singletaskworkflowtype/:identity', component: _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_12__["EditSingleTaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/edit/threetaskworkflowtype/:identity', component: _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_13__["EditTestthreeTaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'workflow/edit/invoiceworkflowtype/:identity', component: _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_11__["EditInvoiceComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] },
    { path: 'test', component: _test_test_component__WEBPACK_IMPORTED_MODULE_14__["TestComponent"] },
    { path: 'auth/login', component: _login__WEBPACK_IMPORTED_MODULE_5__["LoginComponent"] },
    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"]] }
];
const appRoutingModule = _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes);


/***/ }),

/***/ "./src/app/components/error-dialog/error-dialog.component.css":
/*!********************************************************************!*\
  !*** ./src/app/components/error-dialog/error-dialog.component.css ***!
  \********************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n[hidden] {\r\n  display: none !important;\r\n}\r\n\r\n\r\n#errormessagedialog .modal-dialog{\r\n\tmin-width: 50vw;\r\n    max-width: 50vw;\r\n    \r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9lcnJvci1kaWFsb2cvZXJyb3ItZGlhbG9nLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0VBQ0Usd0JBQXdCO0FBQzFCOzs7QUFHQTtDQUNDLGVBQWU7SUFDWixlQUFlOztBQUVuQiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvZXJyb3ItZGlhbG9nL2Vycm9yLWRpYWxvZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbltoaWRkZW5dIHtcclxuICBkaXNwbGF5OiBub25lICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcblxyXG4jZXJyb3JtZXNzYWdlZGlhbG9nIC5tb2RhbC1kaWFsb2d7XHJcblx0bWluLXdpZHRoOiA1MHZ3O1xyXG4gICAgbWF4LXdpZHRoOiA1MHZ3O1xyXG4gICAgXHJcbn1cclxuXHJcblxyXG4iXX0= */");

/***/ }),

/***/ "./src/app/components/error-dialog/error-dialog.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/components/error-dialog/error-dialog.component.ts ***!
  \*******************************************************************/
/*! exports provided: ErrorDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorDialogComponent", function() { return ErrorDialogComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");




let ErrorDialogComponent = class ErrorDialogComponent {
    constructor(translate, errorService) {
        this.errorService = errorService;
        this.showErrorDetail = false;
        this.showError = false;
        this.errorMessage = "";
        this.errorDetails = "";
        translate.setDefaultLang('de');
        translate.use('de');
    }
    ngOnInit() {
        this.subscribeErrorService();
    }
    subscribeErrorService() {
        this.errorService.errorSubject.subscribe((data) => {
            if (data && data != null) {
                this.errorMessage = data.errorMessage;
                this.errorDetails = data.errorDetail;
                this.showErrorDetail = false;
                this.showError = true;
                //alert("error coms: " + this.errorMessage + " , show: " + (this.showError === true));
            }
            else {
                this.showError = false;
                this.showErrorDetail = false;
                //alert("no error");
            }
            //this.subscribeErrorService();
        });
    }
    hideModal() {
        this.showError = false;
        this.showErrorDetail = false;
    }
    get hasErrorDetail() {
        return this.errorDetails !== null && this.errorDetails !== "";
    }
};
ErrorDialogComponent.ctorParameters = () => [
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__["ErrorServiceService"] }
];
ErrorDialogComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-error-dialog',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./error-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/error-dialog/error-dialog.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./error-dialog.component.css */ "./src/app/components/error-dialog/error-dialog.component.css")).default]
    })
], ErrorDialogComponent);



/***/ }),

/***/ "./src/app/components/loading-dialog/loading-dialog.component.css":
/*!************************************************************************!*\
  !*** ./src/app/components/loading-dialog/loading-dialog.component.css ***!
  \************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n.loading-container\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  \r\n}\r\n\r\n.loading\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  background-color: rgba(100, 100, 100, 0.3);\r\n  background-image: url(/assets/images/loading200.gif);\r\n  background-repeat: no-repeat;\r\n  background-position: center;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9sb2FkaW5nLWRpYWxvZy9sb2FkaW5nLWRpYWxvZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7O0VBRUUsdUJBQXVCO0VBQ3ZCLHdCQUF3Qjs7QUFFMUI7O0FBRUE7O0VBRUUsdUJBQXVCO0VBQ3ZCLHdCQUF3QjtFQUN4QiwwQ0FBMEM7RUFDMUMsb0RBQW9EO0VBQ3BELDRCQUE0QjtFQUM1QiwyQkFBMkI7QUFDN0IiLCJmaWxlIjoic3JjL2FwcC9jb21wb25lbnRzL2xvYWRpbmctZGlhbG9nL2xvYWRpbmctZGlhbG9nLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi5sb2FkaW5nLWNvbnRhaW5lclxyXG57XHJcbiAgd2lkdGg6IDEwMHZ3ICFpbXBvcnRhbnQ7IFxyXG4gIGhlaWdodDogMTAwdmggIWltcG9ydGFudDsgXHJcbiAgXHJcbn1cclxuXHJcbi5sb2FkaW5nXHJcbntcclxuICB3aWR0aDogMTAwdncgIWltcG9ydGFudDsgXHJcbiAgaGVpZ2h0OiAxMDB2aCAhaW1wb3J0YW50OyBcclxuICBiYWNrZ3JvdW5kLWNvbG9yOiByZ2JhKDEwMCwgMTAwLCAxMDAsIDAuMyk7XHJcbiAgYmFja2dyb3VuZC1pbWFnZTogdXJsKC9hc3NldHMvaW1hZ2VzL2xvYWRpbmcyMDAuZ2lmKTtcclxuICBiYWNrZ3JvdW5kLXJlcGVhdDogbm8tcmVwZWF0O1xyXG4gIGJhY2tncm91bmQtcG9zaXRpb246IGNlbnRlcjtcclxufVxyXG5cclxuXHJcbiJdfQ== */");

/***/ }),

/***/ "./src/app/components/loading-dialog/loading-dialog.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/components/loading-dialog/loading-dialog.component.ts ***!
  \***********************************************************************/
/*! exports provided: LoadingDialogComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoadingDialogComponent", function() { return LoadingDialogComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");



let LoadingDialogComponent = class LoadingDialogComponent {
    constructor(loadingService) {
        this.loadingService = loadingService;
        this._showLoading = false;
        this.showLoading = false;
    }
    ngOnInit() {
        this.loadingService.loadingSubject.subscribe((data) => {
            this.showLoading = data;
        });
    }
};
LoadingDialogComponent.ctorParameters = () => [
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_2__["LoadingServiceService"] }
];
LoadingDialogComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-loading-dialog',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./loading-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/loading-dialog/loading-dialog.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./loading-dialog.component.css */ "./src/app/components/loading-dialog/loading-dialog.component.css")).default]
    })
], LoadingDialogComponent);



/***/ }),

/***/ "./src/app/components/select-user/select-user.component.css":
/*!******************************************************************!*\
  !*** ./src/app/components/select-user/select-user.component.css ***!
  \******************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.user-select-modal-content{\r\n\theight: 500px;\r\n}\r\n\r\n.user-select-tab-content{\r\n\theight: calc(100% - 30px);\r\n}\r\n\r\n.user-select-item-label{\r\n\tmargin-left: 10px;\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9zZWxlY3QtdXNlci9zZWxlY3QtdXNlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLGFBQWE7QUFDZDs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLGlCQUFpQjtBQUNsQiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvc2VsZWN0LXVzZXIvc2VsZWN0LXVzZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4udXNlci1zZWxlY3QtbW9kYWwtY29udGVudHtcclxuXHRoZWlnaHQ6IDUwMHB4O1xyXG59XHJcblxyXG4udXNlci1zZWxlY3QtdGFiLWNvbnRlbnR7XHJcblx0aGVpZ2h0OiBjYWxjKDEwMCUgLSAzMHB4KTtcclxufVxyXG5cclxuLnVzZXItc2VsZWN0LWl0ZW0tbGFiZWx7XHJcblx0bWFyZ2luLWxlZnQ6IDEwcHg7XHJcbn1cclxuXHJcbiJdfQ== */");

/***/ }),

/***/ "./src/app/components/select-user/select-user.component.ts":
/*!*****************************************************************!*\
  !*** ./src/app/components/select-user/select-user.component.ts ***!
  \*****************************************************************/
/*! exports provided: SelectUserComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SelectUserComponent", function() { return SelectUserComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");



let SelectUserComponent = class SelectUserComponent {
    constructor() {
        this.showAssignModal = false;
        this.selectAssign = [];
        this.onUsersSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENTGROUP;
    }
    ngOnInit() {
    }
    applyUserSelect() {
        var assigns = [];
        for (var type in this.selectAssign) {
            for (var identity in this.selectAssign[type]) {
                if (this.selectAssign[type][identity]) {
                    var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignItem"];
                    assign.itemIdentity = identity;
                    assign.itemType = type;
                    assigns.push(assign);
                }
            }
        }
        this.onUsersSelected.emit(assigns);
    }
    isItemAssigned(identity, type) {
        if (this.selectAssign[type] === undefined) {
            this.selectAssign[type] = [];
        }
        if (this.selectAssign[type][identity] === undefined) {
            this.selectAssign[type][identity] = false;
        }
        return this.selectAssign[type][identity];
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    toggleAssign(identity, type, isChecked) {
        if (this.selectAssign[type] === undefined) {
            this.selectAssign[type] = [];
        }
        this.selectAssign[type][identity] = isChecked;
    }
};
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('users')
], SelectUserComponent.prototype, "users", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('departments')
], SelectUserComponent.prototype, "departments", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('showAssignModal')
], SelectUserComponent.prototype, "showAssignModal", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('selectAssign')
], SelectUserComponent.prototype, "selectAssign", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])()
], SelectUserComponent.prototype, "onUsersSelected", void 0);
SelectUserComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-select-user',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./select-user.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/components/select-user/select-user.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./select-user.component.css */ "./src/app/components/select-user/select-user.component.css")).default]
    })
], SelectUserComponent);



/***/ }),

/***/ "./src/app/custom-validators/invoice-type-controll-validator.ts":
/*!**********************************************************************!*\
  !*** ./src/app/custom-validators/invoice-type-controll-validator.ts ***!
  \**********************************************************************/
/*! exports provided: InvoiceTypeControllValidator */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceTypeControllValidator", function() { return InvoiceTypeControllValidator; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");


function InvoiceTypeControllValidator(control) {
    let invoiceType = _wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"][control.value];
    if (invoiceType !== undefined && (invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"].SUPPLIER || invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"].WORKER || invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"].PAYMENT)) {
        return null;
    }
    return { invoiceTypeValid: true };
}


/***/ }),

/***/ "./src/app/fake-data/fake-responses.ts":
/*!*********************************************!*\
  !*** ./src/app/fake-data/fake-responses.ts ***!
  \*********************************************/
/*! exports provided: AuthenticationOKResponse, AuthenticationFailedResponse, GeneralDataOkResponse, InitialSearchDataOkResponse, WorkflowSearchResultOkResponse, WorkflowSaveRequestInitOkResponse, InvoiceWorkflowSaveRequestInitOkResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationOKResponse", function() { return AuthenticationOKResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationFailedResponse", function() { return AuthenticationFailedResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GeneralDataOkResponse", function() { return GeneralDataOkResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InitialSearchDataOkResponse", function() { return InitialSearchDataOkResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResultOkResponse", function() { return WorkflowSearchResultOkResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSaveRequestInitOkResponse", function() { return WorkflowSaveRequestInitOkResponse; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflowSaveRequestInitOkResponse", function() { return InvoiceWorkflowSaveRequestInitOkResponse; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

const AuthenticationOKResponse = JSON.parse('{"exception":"","res":"ok","message":"","user":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":{"year":1977,"month":"JANUARY","dayOfMonth":1,"dayOfWeek":"SATURDAY","era":"CE","dayOfYear":1,"leapYear":false,"monthValue":1,"chronology":{"id":"ISO","calendarType":"iso8601"}},"firstName":"AdminFake","lastName":"AdminFake","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"timestamp":1576587571234}');
const AuthenticationFailedResponse = JSON.parse('{"exception":"No AuthenticationProvider found for org.springframework.security.authentication.UsernamePasswordAuthenticationToken","res":"failed","user":null,"message":"ungültiger Benutzername oder Passwort","timestamp":1576589527401}');
const GeneralDataOkResponse = JSON.parse('{"app":{"menus":[{"label":"Home","url":"/","image":"glyphicon glyphicon-home","children":[],"id":"menu-home","status":1,"enabled":true},{"label":"Firma","url":"#","image":"glyphicon glyphicon-tasks","children":[{"label":"Firmen-Liste","url":"/companies/list","image":"glyphicon glyphicon-tasks","children":[],"id":"menu-companylist","status":1,"enabled":true},{"label":"WorkflowType-Liste","url":"/companies/workflowtype","image":"glyphicon glyphicon-tasks","children":[],"id":"menu-workflowtype-list","status":1,"enabled":true}],"id":"menu-company","status":1,"enabled":true},{"label":"Workflow","url":"#","image":"glyphicon glyphicon-tasks","children":[{"label":"Workflow-Liste","url":"/workflow/list","image":"glyphicon glyphicon-tasks","children":[],"id":"menu-workflow-list","status":1,"enabled":true},{"label":"Workflow erstellen","url":"/workflow/create","image":"glyphicon glyphicon-tasks","children":[],"id":"menu-workflow-create","status":1,"enabled":true}],"id":"menu-workflow","status":1,"enabled":true},{"label":"Benuzer","url":"#","image":"glyphicon glyphicon-user","children":[{"label":"Kennwortänderung","url":"/user/changepassword","image":"glyphicon glyphicon-lock","children":[],"id":"menu-changepassword","status":1,"enabled":true}],"id":"menu-user","status":1,"enabled":true},{"label":"Optionen","url":"#","image":"glyphicon glyphicon-wrench","children":[{"label":"Url Einstellungen","url":"/settings/url","image":"glyphicon glyphicon-ok","children":[],"id":"menu-urlsettings","status":1,"enabled":true},{"label":"Test 1","url":"/settings/url","image":"glyphicon glyphicon-certificate","children":[],"id":"menu-urlsettings-test1","status":1,"enabled":true},{"label":"Test 2","url":"/settings/url","image":"glyphicon glyphicon-certificate","children":[],"id":"menu-urlsettings-test2","status":1,"enabled":true}],"id":"menu-options","status":1,"enabled":true},{"label":"Über","url":"/about","image":"glyphicon glyphicon-info-sign","children":[],"id":"menu-about","status":1,"enabled":true}]},"workflow":{"worlflowTypes":[{"identity":"threetaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Drei Schritt Aufgabe","comments":null,"status":1,"sendToController":false,"increaseStepAutomatic":true,"allowAssign":true,"version":1,"steps":[{"identity":"threetasktypestep1","title":"Schritt 1","stepIndex":1,"viewName":"workflow/testthreetask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"threetasktypestep2","title":"Schritt 2","stepIndex":2,"viewName":"workflow/testthreetask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"threetasktypestep3","title":"Schritt 3","stepIndex":3,"viewName":"wworkflow/testthreetask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"threetaskworkflowtype","controllerPreffix":"testthreetask","new":false,"isAssignTypeOffering":true,"isAssignTypeManual":false},{"identity":"invoiceworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Rechnung Wrokflow","comments":null,"status":1,"sendToController":false,"increaseStepAutomatic":true,"allowAssign":true,"version":1,"steps":[{"identity":"invocetasktypestep1","title":"Rechungsverteilung","stepIndex":1,"viewName":"workflow/invoice/invoice_assign","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"invocetasktypestep2","title":"Rechungsprüfung","stepIndex":2,"viewName":"workflow/invoice/invoice_testing","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"invocetasktypestep3","title":"Rechungsfreigabe","stepIndex":3,"viewName":"workflow/invoice/invoice_release","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"invoiceworkflowtype","controllerPreffix":"invoice","new":false,"isAssignTypeOffering":true,"isAssignTypeManual":false},{"identity":"singletaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Einzel Aufgabe","comments":null,"status":1,"sendToController":true,"increaseStepAutomatic":true,"allowAssign":false,"version":1,"steps":[{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"singletaskworkflowtype","controllerPreffix":"singletask","new":false,"isAssignTypeOffering":false,"isAssignTypeManual":true}]},"isLogged":"true","company":{"company":{"identity":"test-company-1","companyName":"Test Fake Firma 1","status":1,"version":1,"new":false},"departments":[{"companyIdentity":null,"identity":"dep1","title":"Dep 1","status":1,"version":1,"departmentGroups":[{"identity":"depgrp11","departmentIdentity":null,"title":"Dep1 Group 1","status":1,"version":1,"new":false},{"identity":"depgrp12","departmentIdentity":null,"title":"Dep1 Group 2","status":1,"version":1,"new":false},{"identity":"depgrp13","departmentIdentity":null,"title":"Dep1 Group 3","status":1,"version":1,"new":false}],"new":false},{"companyIdentity":null,"identity":"dep2","title":"Dep 2","status":1,"version":1,"departmentGroups":[{"identity":"depgrp21","departmentIdentity":null,"title":"Dep2 Group 1","status":1,"version":1,"new":false},{"identity":"depgrp22","departmentIdentity":null,"title":"Dep2 Group 2","status":1,"version":1,"new":false}],"new":false}],"users":[{"companyIdentity":"test-company-1","email":"user2@iflow.de","birthDate":"2000-05-12","firstName":"User 2","lastName":"User 2","status":1,"permission":5,"version":1,"createdAt":null,"updatedAt":null,"groups":[],"departments":[],"departmentGroups":[],"deputies":[],"active":true,"fullName":"User 2, User 2","username":"user2@iflow.de","admin":true,"rolesInt":[],"identity":"user2@iflow.de","userTitle":"User 2, User 2","new":false,"isEnabled":true},{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},{"companyIdentity":"test-company-1","email":"user3@iflow.de","birthDate":"1991-11-23","firstName":"User 3","lastName":"User 3","status":1,"permission":5,"version":1,"createdAt":null,"updatedAt":null,"groups":[],"departments":[],"departmentGroups":[],"deputies":[],"active":true,"fullName":"User 3, User 3","username":"user3@iflow.de","admin":true,"rolesInt":[],"identity":"user3@iflow.de","userTitle":"User 3, User 3","new":false,"isEnabled":true},{"companyIdentity":"test-company-1","email":"user@iflow.de","birthDate":"1980-02-03","firstName":"User","lastName":"User","status":1,"permission":5,"version":1,"createdAt":null,"updatedAt":null,"groups":[],"departments":[],"departmentGroups":[],"deputies":[],"active":true,"fullName":"User, User","username":"user@iflow.de","admin":true,"rolesInt":[],"identity":"user@iflow.de","userTitle":"User, User","new":false,"isEnabled":true}]},"user":{"currentUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true}}}');
const InitialSearchDataOkResponse = JSON.parse('{"workflowStatusList":["INITIALIZE","NOT_ASSIGNED","OFFERING","ASSIGNED","DONE","ARCHIVED","ERROR"],"searchFilter":{"meAssigned":true,"assignedUserIdSet":[],"statusList":["OFFERING","ERROR","NOT_ASSIGNED","INITIALIZE","ASSIGNED","DONE"],"workflowTypes":["invoiceworkflowtype","threetaskworkflowtype","singletaskworkflowtype"],"workflowSteps":[]}}');
const WorkflowSearchResultOkResponse = JSON.parse('{"res":"ok","list":[{"identity":"w1576346190957-259858","workflowTypeIdentity":"singletaskworkflowtype","currentStepIdentity":"singletasktypestep","controllerIdentity":"admin@iflow.de","createdByIdentity":"admin@iflow.de","status":"NOT_ASSIGNED","workflowType":{"identity":"singletaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Einzel Aufgabe","comments":null,"status":1,"sendToController":true,"increaseStepAutomatic":true,"allowAssign":false,"version":1,"steps":[{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"singletaskworkflowtype","controllerPreffix":"singletask","new":false,"isAssignTypeOffering":false,"isAssignTypeManual":true},"currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"files":[{"identity":"wf1576346190958-467680","workflowIdentity":null,"createdByIdentity":"admin@iflow.de","title":"title","extention":"extention","activeFilePath":"filePath","comments":"comments","activeFileVersion":1,"status":1,"fileVersions":[{"createdBy":null,"createdByIdentity":"admin@iflow.de","filePath":"filePath","comments":"comments","fileVersion":1,"status":1}],"new":false}],"actions":[{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"comments","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true}],"currentUserIdentity":"admin@iflow.de","assigned":false,"notAssigned":true,"hasActiveAction":true,"assignToUserFullName":"admin@iflow.de","initializing":false,"activeAction":{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"comments","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true},"meAssigned":false},{"identity":"w1576346115349-171022","workflowTypeIdentity":"singletaskworkflowtype","currentStepIdentity":"singletasktypestep","controllerIdentity":"admin@iflow.de","createdByIdentity":"admin@iflow.de","status":"ASSIGNED","workflowType":{"identity":"singletaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Einzel Aufgabe","comments":null,"status":1,"sendToController":true,"increaseStepAutomatic":true,"allowAssign":false,"version":1,"steps":[{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"singletaskworkflowtype","controllerPreffix":"singletask","new":false,"isAssignTypeOffering":false,"isAssignTypeManual":true},"currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"files":[],"actions":[{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true}],"currentUserIdentity":"admin@iflow.de","assigned":true,"notAssigned":false,"hasActiveAction":true,"assignToUserFullName":"admin@iflow.de","initializing":false,"activeAction":{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true},"meAssigned":true},{"identity":"w1576346138144-600227","workflowTypeIdentity":"singletaskworkflowtype","currentStepIdentity":"singletasktypestep","controllerIdentity":"admin@iflow.de","createdByIdentity":"admin@iflow.de","status":"ASSIGNED","workflowType":{"identity":"singletaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Einzel Aufgabe","comments":null,"status":1,"sendToController":true,"increaseStepAutomatic":true,"allowAssign":false,"version":1,"steps":[{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"singletaskworkflowtype","controllerPreffix":"singletask","new":false,"isAssignTypeOffering":false,"isAssignTypeManual":true},"currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"files":[{"identity":"wf1576346138158-904578","workflowIdentity":null,"createdByIdentity":"admin@iflow.de","title":"title","extention":"extention","activeFilePath":"filePath","comments":"comments","activeFileVersion":1,"status":1,"fileVersions":[{"createdBy":null,"createdByIdentity":"admin@iflow.de","filePath":"filePath","comments":"comments","fileVersion":1,"status":1}],"new":false}],"actions":[{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"comments","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true}],"currentUserIdentity":"admin@iflow.de","assigned":true,"notAssigned":false,"hasActiveAction":true,"assignToUserFullName":"admin@iflow.de","initializing":false,"activeAction":{"workflowIdentity":null,"assignToIdentity":"admin@iflow.de","currentStepIdentity":"singletasktypestep","comments":"comments","status":"OPEN","currentStep":{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false},"assignToUser":{"companyIdentity":"test-company-1","email":"admin@iflow.de","birthDate":"1977-01-01","firstName":"Admin","lastName":"Admin","status":1,"permission":1,"version":1,"createdAt":null,"updatedAt":null,"groups":["Group-1"],"departments":["dep2"],"departmentGroups":[],"deputies":["user3@iflow.de"],"active":true,"fullName":"Admin, Admin","username":"admin@iflow.de","admin":true,"rolesInt":[],"identity":"admin@iflow.de","userTitle":"Admin, Admin","new":false,"isEnabled":true},"assigned":true,"assignToUserName":"admin@iflow.de","isActive":true},"meAssigned":true}]}');
const WorkflowSaveRequestInitOkResponse = JSON.parse('{"workflowSaveRequest":{"workflow":{"identity":"notset","workflowType":{"identity":"singletaskworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Einzel Aufgabe","comments":null,"status":1,"sendToController":true,"increaseStepAutomatic":true,"allowAssign":false,"version":1,"steps":[{"identity":"singletasktypestep","title":"Augabe","stepIndex":1,"viewName":"workflow/singletask/edit","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"singletaskworkflowtype","controllerPreffix":"singletask","new":false,"isAssignTypeOffering":false,"isAssignTypeManual":true},"currentStep":null,"currentStepIdentity":"","controllerIdentity":"","controllerUser":null,"createdByIdentity":"admin@iflow.de","createdByUser":null,"comments":"","status":"INITIALIZE","version":0,"currentUserIdentity":null,"files":[],"actions":[],"workflowTypeEnum":"singletaskworkflowtype","workflowTypeIdentity":"singletaskworkflowtype","statusInt":5,"assigned":false,"hasActiveAction":false,"initializing":true,"activeAction":null,"notAssigned":true,"isOpen":false,"isError":false,"isDone":false,"isArchived":false,"assignToUserFullName":"","meAssigned":false,"new":true},"expireDays":15,"assigns":[],"command":"CREATE","sessionKey":null,"archiveCommand":false,"assignCommand":false,"saveCommand":false,"doneCommand":false,"createCommand":true}}');
const InvoiceWorkflowSaveRequestInitOkResponse = JSON.parse('{"workflowSaveRequest":{"workflow":{"identity":"notset","workflowTypeIdentity":"invoiceworkflowtype","workflowType":{"identity":"invoiceworkflowtype","companyIdentity":"test-company-1","baseTypeIdentity":"","title":"Rechnung Wrokflow","comments":null,"status":1,"sendToController":false,"increaseStepAutomatic":true,"allowAssign":true,"version":1,"steps":[{"identity":"invocetasktypestep1","title":"Rechungsverteilung","stepIndex":1,"viewName":"workflow/invoice/invoice_assign","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"invocetasktypestep2","title":"Rechungsprüfung","stepIndex":2,"viewName":"workflow/invoice/invoice_testing","expireDays":15,"comments":null,"status":1,"version":1,"new":false},{"identity":"invocetasktypestep3","title":"Rechungsfreigabe","stepIndex":3,"viewName":"workflow/invoice/invoice_release","expireDays":15,"comments":null,"status":1,"version":1,"new":false}],"typeEnum":"invoiceworkflowtype","controllerPreffix":"invoice","new":false,"isAssignTypeOffering":true,"isAssignTypeManual":false},"currentStep":null,"currentStepIdentity":"","controllerIdentity":"","controllerUser":null,"createdByIdentity":"admin@iflow.de","createdByUser":null,"comments":"","status":"INITIALIZE","version":0,"currentUserIdentity":null,"files":[],"actions":[],"sender":null,"registerNumber":null,"invocieDate":"22.12.2019","partnerCode":null,"vendorNumber":null,"vendorName":null,"isDirectDebitPermission":false,"invoiceType":null,"discountEnterDate":null,"discountDeadline":null,"discountRate":null,"discountDate":"16.01.2020","paymentAmount":null,"workflowTypeEnum":"invoiceworkflowtype","invoiceDate":"2019-12-22","canSave":true,"canDone":true,"canArchive":false,"statusInt":5,"isLastStep":false,"assigned":false,"canAssign":true,"isDone":false,"hasActiveAction":false,"activeAction":null,"initializing":true,"currentStepIndex":1,"notAssigned":true,"isArchived":false,"isOpen":false,"isError":false,"meAssigned":false,"assignToUserFullName":"","new":true},"expireDays":15,"assigns":[],"command":"CREATE","sessionKey":null,"archiveCommand":false,"doneCommand":false,"createCommand":true,"assignCommand":false,"saveCommand":false}}');


/***/ }),

/***/ "./src/app/fake-data/index.ts":
/*!************************************!*\
  !*** ./src/app/fake-data/index.ts ***!
  \************************************/
/*! exports provided: AuthenticationOKResponse, AuthenticationFailedResponse, GeneralDataOkResponse, InitialSearchDataOkResponse, WorkflowSearchResultOkResponse, WorkflowSaveRequestInitOkResponse, InvoiceWorkflowSaveRequestInitOkResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _fake_responses__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./fake-responses */ "./src/app/fake-data/fake-responses.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationOKResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["AuthenticationOKResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationFailedResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["AuthenticationFailedResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GeneralDataOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["GeneralDataOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InitialSearchDataOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["InitialSearchDataOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResultOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["WorkflowSearchResultOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSaveRequestInitOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["WorkflowSaveRequestInitOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflowSaveRequestInitOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_1__["InvoiceWorkflowSaveRequestInitOkResponse"]; });





/***/ }),

/***/ "./src/app/footer/footer.component.css":
/*!*********************************************!*\
  !*** ./src/app/footer/footer.component.css ***!
  \*********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9vdGVyL2Zvb3Rlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7Ozs7Q0FJQyIsImZpbGUiOiJzcmMvYXBwL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLypcclxuQ29weXJpZ2h0IEdvb2dsZSBMTEMuIEFsbCBSaWdodHMgUmVzZXJ2ZWQuXHJcblVzZSBvZiB0aGlzIHNvdXJjZSBjb2RlIGlzIGdvdmVybmVkIGJ5IGFuIE1JVC1zdHlsZSBsaWNlbnNlIHRoYXRcclxuY2FuIGJlIGZvdW5kIGluIHRoZSBMSUNFTlNFIGZpbGUgYXQgaHR0cDovL2FuZ3VsYXIuaW8vbGljZW5zZVxyXG4qLyJdfQ== */");

/***/ }),

/***/ "./src/app/footer/footer.component.ts":
/*!********************************************!*\
  !*** ./src/app/footer/footer.component.ts ***!
  \********************************************/
/*! exports provided: FooterComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function() { return FooterComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");



let FooterComponent = class FooterComponent {
    constructor(translate) {
        translate.setDefaultLang('de');
        translate.use('de');
    }
    ngOnInit() {
    }
};
FooterComponent.ctorParameters = () => [
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"] }
];
FooterComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-footer',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./footer.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./footer.component.css */ "./src/app/footer/footer.component.css")).default]
    })
], FooterComponent);

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ "./src/app/helper/date-helper.ts":
/*!***************************************!*\
  !*** ./src/app/helper/date-helper.ts ***!
  \***************************************/
/*! exports provided: parseDate, formatDate, getStringWithOneLeadingZero */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "parseDate", function() { return parseDate; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "formatDate", function() { return formatDate; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "getStringWithOneLeadingZero", function() { return getStringWithOneLeadingZero; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

function parseDate(input, format) {
    if (input === null || input === undefined) {
        return null;
    }
    format = format || 'yyyy-mm-dd'; // default format
    var stringParts = input.match(/(\d+)/g), i = 0, fmt = {};
    var parts = [Number(stringParts[0]), Number(stringParts[1]), Number(stringParts[2]),];
    format.replace(/(yyyy|dd|mm)/g, function (part) { fmt[part] = i++; return part; });
    return new Date(parts[fmt['yyyy']], parts[fmt['mm']] - 1, parts[fmt['dd']]);
}
function formatDate(input, format) {
    format = format || 'yyyy-mm-dd'; // default format
    var stringDate = format;
    stringDate = stringDate.replace(/(yyyy|dd|mm)/g, function (part) {
        if (part === 'yyyy') {
            return input.getFullYear() + "";
        }
        if (part === 'dd') {
            return getStringWithOneLeadingZero(input.getDate());
        }
        if (part === 'mm') {
            return getStringWithOneLeadingZero(input.getMonth() + 1);
        }
    });
    return stringDate;
}
function getStringWithOneLeadingZero(input) {
    return (input < 10 ? '0' : '') + input + "";
}


/***/ }),

/***/ "./src/app/helper/fake-backend.ts":
/*!****************************************!*\
  !*** ./src/app/helper/fake-backend.ts ***!
  \****************************************/
/*! exports provided: FakeBackendInterceptor, fakeBackendProvider */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FakeBackendInterceptor", function() { return FakeBackendInterceptor; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "fakeBackendProvider", function() { return fakeBackendProvider; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _http_hepler__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _fake_data__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../fake-data */ "./src/app/fake-data/index.ts");







let FakeBackendInterceptor = class FakeBackendInterceptor {
    constructor() { }
    intercept(request, next) {
        // wrap in delayed observable to simulate server api call
        return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(null).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["mergeMap"])(() => {
            if (request.headers == undefined || (request.headers && request.headers.has(_http_hepler__WEBPACK_IMPORTED_MODULE_5__["InterceptorUseHeader"]) === false)) {
                const headers = request.headers;
                return next.handle(request.clone({ headers }));
            }
            // authenticate
            if (request.url.endsWith('/auth/authenticate') && request.method === 'POST') {
                if (request.body == null || request.body.username == null || request.body.username == ""
                    || request.body.password == null || request.body.password == "" || request.body.companyid == null
                    || request.body.companyid == "") {
                    //return throwError({ error: { message: 'Username or password is incorrect' } });
                    return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["AuthenticationFailedResponse"] }));
                }
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["AuthenticationOKResponse"] }));
            }
            // get general data
            if (request.url.endsWith('/general/data/generaldatat') && request.method === 'GET') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["GeneralDataOkResponse"] }));
            }
            // get workflow search init data
            if (request.url.endsWith('/workflow/general/data/initsearch') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["InitialSearchDataOkResponse"] }));
            }
            // get workflow search result
            if (request.url.endsWith('/workflow/general/data/search') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["WorkflowSearchResultOkResponse"] }));
            }
            // get workflow create & edit initial result
            if ((request.url.endsWith('/workflow/singletask/data/initcreate') ||
                request.url.endsWith('/workflow/testthreetask/data/initcreate'))
                && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["WorkflowSaveRequestInitOkResponse"] }));
            }
            // get workflow create & edit initial result
            if (request.url.endsWith('/workflow/invoice/data/initcreate') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_3__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_6__["InvoiceWorkflowSaveRequestInitOkResponse"] }));
            }
            // pass through any requests not handled above
            return next.handle(request);
        }))
            // call materialize and dematerialize to ensure delay even if an error is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["materialize"])())
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["delay"])(500))
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_4__["dematerialize"])());
    }
};
FakeBackendInterceptor = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
], FakeBackendInterceptor);

let fakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HTTP_INTERCEPTORS"],
    useClass: FakeBackendInterceptor,
    multi: true
};


/***/ }),

/***/ "./src/app/helper/german-date-adapter.ts":
/*!***********************************************!*\
  !*** ./src/app/helper/german-date-adapter.ts ***!
  \***********************************************/
/*! exports provided: GermanDateAdapter */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GermanDateAdapter", function() { return GermanDateAdapter; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _date_helper__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./date-helper */ "./src/app/helper/date-helper.ts");




const SUPPORTS_INTL_API = typeof Intl !== 'undefined';
let GermanDateAdapter = class GermanDateAdapter extends _angular_material__WEBPACK_IMPORTED_MODULE_2__["NativeDateAdapter"] {
    constructor() {
        super(...arguments);
        this.useUtcForDisplay = true;
    }
    parse(value) {
        if ((typeof value === 'string') && (value.indexOf('.') > -1)) {
            const str = value.split('.');
            const year = Number(str[2]);
            const month = Number(str[1]) - 1;
            const date = Number(str[0]);
            return new Date(year, month, date);
        }
        const timestamp = typeof value === 'number' ? value : Date.parse(value);
        return isNaN(timestamp) ? null : new Date(timestamp);
    }
    // to be removed when mmalerba merge the mods in the next beta
    format(date, displayFormat) {
        return Object(_date_helper__WEBPACK_IMPORTED_MODULE_3__["formatDate"])(date, "dd.mm.yyyy");
        if (SUPPORTS_INTL_API) {
            if (this.useUtcForDisplay) {
                date = new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), date.getMilliseconds()));
                displayFormat = Object.assign({}, displayFormat, { timeZone: 'utc' });
            }
            const dtf = new Intl.DateTimeFormat(this.locale, displayFormat);
            return dtf.format(date).replace(/[\u200e\u200f]/g, '');
        }
    }
};
GermanDateAdapter = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])()
], GermanDateAdapter);



/***/ }),

/***/ "./src/app/helper/http-error-response-helper.ts":
/*!******************************************************!*\
  !*** ./src/app/helper/http-error-response-helper.ts ***!
  \******************************************************/
/*! exports provided: HttpErrorResponseHelper */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpErrorResponseHelper", function() { return HttpErrorResponseHelper; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services */ "./src/app/services/index.ts");




let HttpErrorResponseHelper = class HttpErrorResponseHelper {
    constructor(router, route, autService) {
        this.router = router;
        this.route = route;
        this.autService = autService;
    }
    processErrorResponse(response) {
        if (response.error && response.error.status) {
            if (response.error.status === "UNAUTHORIZED" || response.error.status === 401) {
                var currentUrl = this.route.snapshot.url.map(f => f.path).join('/');
                this.autService.logout(currentUrl);
                //this.router.navigate(['auth/login'], { queryParams: { returnUrl: currentUrl } });
                return true;
            }
        }
        return false;
    }
};
HttpErrorResponseHelper.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
    { type: _services__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"] }
];
HttpErrorResponseHelper = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], HttpErrorResponseHelper);



/***/ }),

/***/ "./src/app/helper/http-hepler.ts":
/*!***************************************!*\
  !*** ./src/app/helper/http-hepler.ts ***!
  \***************************************/
/*! exports provided: InterceptorUseHeader, HttpHepler */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InterceptorUseHeader", function() { return InterceptorUseHeader; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HttpHepler", function() { return HttpHepler; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");



const InterceptorUseHeader = 'X-Use-Interceptor';
class HttpHepler {
    static generateFormHeader() {
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'my-auth-token',
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'my-auth-token',
                'X-Use-Interceptor': 'user-fake',
                'Cache-Control': 'no-cache',
                'Pragma': 'no-cache',
                'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
            });
        }
        //alert(header.keys());
        return header;
    }
    static generateJsonHeader() {
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
            'Content-Type': 'application/json; charset=UTF-8',
            'Authorization': 'my-auth-token',
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                'Content-Type': 'application/json; charset=UTF-8',
                'Authorization': 'my-auth-token',
                'X-Use-Interceptor': 'user-fake',
                'Cache-Control': 'no-cache',
                'Pragma': 'no-cache',
                'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
            });
        }
        //alert(header.keys());
        return header;
    }
    static generateFileUploadHeader() {
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
            //'Content-Type' : undefined,
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_2__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpHeaders"]({
                //'Content-Type' : undefined,
                'X-Use-Interceptor': 'user-fake',
                'Cache-Control': 'no-cache',
                'Pragma': 'no-cache',
                'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
            });
        }
        //alert(header.keys());
        return header;
    }
}


/***/ }),

/***/ "./src/app/helper/index.ts":
/*!*********************************!*\
  !*** ./src/app/helper/index.ts ***!
  \*********************************/
/*! exports provided: FakeBackendInterceptor, fakeBackendProvider, GermanDateAdapter, parseDate, formatDate, getStringWithOneLeadingZero */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _fake_backend__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./fake-backend */ "./src/app/helper/fake-backend.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "FakeBackendInterceptor", function() { return _fake_backend__WEBPACK_IMPORTED_MODULE_1__["FakeBackendInterceptor"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "fakeBackendProvider", function() { return _fake_backend__WEBPACK_IMPORTED_MODULE_1__["fakeBackendProvider"]; });

/* harmony import */ var _german_date_adapter__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./german-date-adapter */ "./src/app/helper/german-date-adapter.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GermanDateAdapter", function() { return _german_date_adapter__WEBPACK_IMPORTED_MODULE_2__["GermanDateAdapter"]; });

/* harmony import */ var _date_helper__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./date-helper */ "./src/app/helper/date-helper.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "parseDate", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_3__["parseDate"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "formatDate", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_3__["formatDate"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "getStringWithOneLeadingZero", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_3__["getStringWithOneLeadingZero"]; });







/***/ }),

/***/ "./src/app/home/home.component.ts":
/*!****************************************!*\
  !*** ./src/app/home/home.component.ts ***!
  \****************************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return HomeComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");


let HomeComponent = class HomeComponent {
    constructor() {
    }
    ngOnInit() {
    }
};
HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'app-root', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./home.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html")).default })
], HomeComponent);



/***/ }),

/***/ "./src/app/home/index.ts":
/*!*******************************!*\
  !*** ./src/app/home/index.ts ***!
  \*******************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _home_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./home.component */ "./src/app/home/home.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return _home_component__WEBPACK_IMPORTED_MODULE_1__["HomeComponent"]; });





/***/ }),

/***/ "./src/app/login/index.ts":
/*!********************************!*\
  !*** ./src/app/login/index.ts ***!
  \********************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./login.component */ "./src/app/login/login.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return _login_component__WEBPACK_IMPORTED_MODULE_1__["LoginComponent"]; });





/***/ }),

/***/ "./src/app/login/login.component.ts":
/*!******************************************!*\
  !*** ./src/app/login/login.component.ts ***!
  \******************************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return LoginComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services */ "./src/app/services/index.ts");








let LoginComponent = class LoginComponent {
    constructor(formBuilder, route, router, autService, global, translate) {
        this.formBuilder = formBuilder;
        this.route = route;
        this.router = router;
        this.autService = autService;
        this.global = global;
        this.returnUrl = "";
        this.loading = false;
        this.submitted = false;
        this.failedLogin = false;
        this.loginResponse = new _ui_models__WEBPACK_IMPORTED_MODULE_5__["LoginResponse"];
        translate.setDefaultLang('de');
        translate.use('de');
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.global.loadAllSetting(null);
            }
        });
    }
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['admin@iflow.de', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
            password: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
            companyid: [localStorage.getItem('companyId'), _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
        });
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    get forms() { return this.loginForm.controls; }
    onSubmit() {
        this.submitted = true;
        this.failedLogin = false;
        if (this.loginForm.invalid) {
            return;
        }
        this.loading = true;
        this.autService.login(this.loginForm.controls["username"].value, this.loginForm.controls["password"].value, this.loginForm.controls["companyid"].value, this);
    }
    processLoginResult(loginResponse) {
        this.loginResponse = loginResponse;
        if (this.loginResponse.res === 'ok') {
            localStorage.setItem('companyId', this.loginForm.controls["companyid"].value);
            this.global.loadAllSetting(this);
        }
        else {
            this.failedLogin = true;
        }
    }
    processFailedResult(responseObj) {
        console.log("GET call in error", responseObj);
        alert("GET call in error: " + responseObj);
        this.loginResponse.message = "Error in login!";
        this.failedLogin = true;
    }
    processEndLoading() {
        this.loading = false;
    }
    finishGeneralDataLoading() {
        this.router.navigate([this.returnUrl]);
    }
};
LoginComponent.ctorParameters = () => [
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_6__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateService"] }
];
LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./login.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html")).default })
], LoginComponent);



/***/ }),

/***/ "./src/app/material-module.ts":
/*!************************************!*\
  !*** ./src/app/material-module.ts ***!
  \************************************/
/*! exports provided: IFlowMaterialModules */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "IFlowMaterialModules", function() { return IFlowMaterialModules; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/cdk/a11y */ "./node_modules/@angular/cdk/esm2015/a11y.js");
/* harmony import */ var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/cdk/drag-drop */ "./node_modules/@angular/cdk/esm2015/drag-drop.js");
/* harmony import */ var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/cdk/portal */ "./node_modules/@angular/cdk/esm2015/portal.js");
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/esm2015/scrolling.js");
/* harmony import */ var _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/cdk/stepper */ "./node_modules/@angular/cdk/esm2015/stepper.js");
/* harmony import */ var _angular_cdk_table__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/cdk/table */ "./node_modules/@angular/cdk/esm2015/table.js");
/* harmony import */ var _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/cdk/tree */ "./node_modules/@angular/cdk/esm2015/tree.js");
/* harmony import */ var _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/autocomplete */ "./node_modules/@angular/material/esm2015/autocomplete.js");
/* harmony import */ var _angular_material_badge__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/badge */ "./node_modules/@angular/material/esm2015/badge.js");
/* harmony import */ var _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/bottom-sheet */ "./node_modules/@angular/material/esm2015/bottom-sheet.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/esm2015/button.js");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/esm2015/button-toggle.js");
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/card */ "./node_modules/@angular/material/esm2015/card.js");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/esm2015/checkbox.js");
/* harmony import */ var _angular_material_chips__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/chips */ "./node_modules/@angular/material/esm2015/chips.js");
/* harmony import */ var _angular_material_stepper__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/material/stepper */ "./node_modules/@angular/material/esm2015/stepper.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/esm2015/datepicker.js");
/* harmony import */ var _angular_material_dialog__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/material/dialog */ "./node_modules/@angular/material/esm2015/dialog.js");
/* harmony import */ var _angular_material_divider__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/material/divider */ "./node_modules/@angular/material/esm2015/divider.js");
/* harmony import */ var _angular_material_expansion__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/material/expansion */ "./node_modules/@angular/material/esm2015/expansion.js");
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/material/grid-list */ "./node_modules/@angular/material/esm2015/grid-list.js");
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/material/icon */ "./node_modules/@angular/material/esm2015/icon.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/esm2015/input.js");
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/material/list */ "./node_modules/@angular/material/esm2015/list.js");
/* harmony import */ var _angular_material_menu__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! @angular/material/menu */ "./node_modules/@angular/material/esm2015/menu.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/esm2015/core.js");
/* harmony import */ var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! @angular/material/paginator */ "./node_modules/@angular/material/esm2015/paginator.js");
/* harmony import */ var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! @angular/material/progress-bar */ "./node_modules/@angular/material/esm2015/progress-bar.js");
/* harmony import */ var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! @angular/material/progress-spinner */ "./node_modules/@angular/material/esm2015/progress-spinner.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/esm2015/radio.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/esm2015/select.js");
/* harmony import */ var _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! @angular/material/sidenav */ "./node_modules/@angular/material/esm2015/sidenav.js");
/* harmony import */ var _angular_material_slider__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! @angular/material/slider */ "./node_modules/@angular/material/esm2015/slider.js");
/* harmony import */ var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! @angular/material/slide-toggle */ "./node_modules/@angular/material/esm2015/slide-toggle.js");
/* harmony import */ var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! @angular/material/snack-bar */ "./node_modules/@angular/material/esm2015/snack-bar.js");
/* harmony import */ var _angular_material_sort__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! @angular/material/sort */ "./node_modules/@angular/material/esm2015/sort.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/esm2015/table.js");
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! @angular/material/tabs */ "./node_modules/@angular/material/esm2015/tabs.js");
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! @angular/material/toolbar */ "./node_modules/@angular/material/esm2015/toolbar.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/esm2015/tooltip.js");
/* harmony import */ var _angular_material_tree__WEBPACK_IMPORTED_MODULE_42__ = __webpack_require__(/*! @angular/material/tree */ "./node_modules/@angular/material/esm2015/tree.js");











































let IFlowMaterialModules = class IFlowMaterialModules {
};
IFlowMaterialModules = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        exports: [
            _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_2__["A11yModule"],
            _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_6__["CdkStepperModule"],
            _angular_cdk_table__WEBPACK_IMPORTED_MODULE_7__["CdkTableModule"],
            _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_8__["CdkTreeModule"],
            _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_3__["DragDropModule"],
            _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_9__["MatAutocompleteModule"],
            _angular_material_badge__WEBPACK_IMPORTED_MODULE_10__["MatBadgeModule"],
            _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_11__["MatBottomSheetModule"],
            _angular_material_button__WEBPACK_IMPORTED_MODULE_12__["MatButtonModule"],
            _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_13__["MatButtonToggleModule"],
            _angular_material_card__WEBPACK_IMPORTED_MODULE_14__["MatCardModule"],
            _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_15__["MatCheckboxModule"],
            _angular_material_chips__WEBPACK_IMPORTED_MODULE_16__["MatChipsModule"],
            _angular_material_stepper__WEBPACK_IMPORTED_MODULE_17__["MatStepperModule"],
            _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_18__["MatDatepickerModule"],
            _angular_material_dialog__WEBPACK_IMPORTED_MODULE_19__["MatDialogModule"],
            _angular_material_divider__WEBPACK_IMPORTED_MODULE_20__["MatDividerModule"],
            _angular_material_expansion__WEBPACK_IMPORTED_MODULE_21__["MatExpansionModule"],
            _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_22__["MatGridListModule"],
            _angular_material_icon__WEBPACK_IMPORTED_MODULE_23__["MatIconModule"],
            _angular_material_input__WEBPACK_IMPORTED_MODULE_24__["MatInputModule"],
            _angular_material_list__WEBPACK_IMPORTED_MODULE_25__["MatListModule"],
            _angular_material_menu__WEBPACK_IMPORTED_MODULE_26__["MatMenuModule"],
            _angular_material_core__WEBPACK_IMPORTED_MODULE_27__["MatNativeDateModule"],
            _angular_material_paginator__WEBPACK_IMPORTED_MODULE_28__["MatPaginatorModule"],
            _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_29__["MatProgressBarModule"],
            _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_30__["MatProgressSpinnerModule"],
            _angular_material_radio__WEBPACK_IMPORTED_MODULE_31__["MatRadioModule"],
            _angular_material_core__WEBPACK_IMPORTED_MODULE_27__["MatRippleModule"],
            _angular_material_select__WEBPACK_IMPORTED_MODULE_32__["MatSelectModule"],
            _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_33__["MatSidenavModule"],
            _angular_material_slider__WEBPACK_IMPORTED_MODULE_34__["MatSliderModule"],
            _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_35__["MatSlideToggleModule"],
            _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_36__["MatSnackBarModule"],
            _angular_material_sort__WEBPACK_IMPORTED_MODULE_37__["MatSortModule"],
            _angular_material_table__WEBPACK_IMPORTED_MODULE_38__["MatTableModule"],
            _angular_material_tabs__WEBPACK_IMPORTED_MODULE_39__["MatTabsModule"],
            _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_40__["MatToolbarModule"],
            _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_41__["MatTooltipModule"],
            _angular_material_tree__WEBPACK_IMPORTED_MODULE_42__["MatTreeModule"],
            _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_4__["PortalModule"],
            _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_5__["ScrollingModule"],
        ]
    })
], IFlowMaterialModules);



/***/ }),

/***/ "./src/app/message-bar/message-bar.component.css":
/*!*******************************************************!*\
  !*** ./src/app/message-bar/message-bar.component.css ***!
  \*******************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("@charset \"ISO-8859-1\";\r\n\r\n.message-panel-container {\r\n    height: 170px;\r\n    margin-top: 10px;\r\n    border: 1px solid gray;\r\n    background-color: #fbfbe8;\r\n    position: fixed !important;\r\n    width: 100vw;\r\n    bottom: 30px;\r\n}\r\n\r\n.message-panel-toolbar{\r\n\theight: 30px;\r\n\tbackground-color: #dadccf;\t\r\n\tpadding-top: 2px;\r\n\tpadding-right: 10px;\r\n}\r\n\r\n.message-panel-toolbar span.title{\r\n\tpadding-left: 20px;\r\n\tfont-weight: bold;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.message-panel-toolbar .toolbar-button{\r\n\tfloat: right;\t\r\n}\r\n\r\n.message-panel-items-container{\r\n\theight: calc(100% - 30px);\r\n\tpadding: 4px 4px;\r\n\toverflow: auto;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item{\r\n\theight: 22px;\r\n\tline-height: 22px;\r\n\tmargin: 3px 0;\r\n\tbackground-color: #cafff9;\r\n\tpadding-left: 15px;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item:hover{\r\n\tbackground-color: #caffd3;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a{\r\n\tcolor: gray;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a:hover{\r\n\tcolor: #946b73;\r\n}\r\n\r\n.toolbar-image {\r\n    border: none;\r\n    margin-right: 10px;\r\n    width: 24px;\r\n    height: 24px;\r\n    float: right;\r\n}\r\n\r\ndiv.workflowview-dialog-content-container div.item-row {\r\n    padding: 5px 0;\r\n}\r\n\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSxxQkFBcUI7O0FBRXJCO0lBQ0ksYUFBYTtJQUNiLGdCQUFnQjtJQUNoQixzQkFBc0I7SUFDdEIseUJBQXlCO0lBQ3pCLDBCQUEwQjtJQUMxQixZQUFZO0lBQ1osWUFBWTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWix5QkFBeUI7Q0FDekIsZ0JBQWdCO0NBQ2hCLG1CQUFtQjtBQUNwQjs7QUFFQTtDQUNDLGtCQUFrQjtDQUNsQixpQkFBaUI7Q0FDakIsZUFBZTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixnQkFBZ0I7Q0FDaEIsY0FBYztBQUNmOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtDQUNqQixhQUFhO0NBQ2IseUJBQXlCO0NBQ3pCLGtCQUFrQjtBQUNuQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGNBQWM7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixrQkFBa0I7SUFDbEIsV0FBVztJQUNYLFlBQVk7SUFDWixZQUFZO0FBQ2hCOztBQUVBO0lBQ0ksY0FBYztBQUNsQiIsImZpbGUiOiJzcmMvYXBwL21lc3NhZ2UtYmFyL21lc3NhZ2UtYmFyLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJAY2hhcnNldCBcIklTTy04ODU5LTFcIjtcclxuXHJcbi5tZXNzYWdlLXBhbmVsLWNvbnRhaW5lciB7XHJcbiAgICBoZWlnaHQ6IDE3MHB4O1xyXG4gICAgbWFyZ2luLXRvcDogMTBweDtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmJmYmU4O1xyXG4gICAgcG9zaXRpb246IGZpeGVkICFpbXBvcnRhbnQ7XHJcbiAgICB3aWR0aDogMTAwdnc7XHJcbiAgICBib3R0b206IDMwcHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXJ7XHJcblx0aGVpZ2h0OiAzMHB4O1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNkYWRjY2Y7XHRcclxuXHRwYWRkaW5nLXRvcDogMnB4O1xyXG5cdHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXIgc3Bhbi50aXRsZXtcclxuXHRwYWRkaW5nLWxlZnQ6IDIwcHg7XHJcblx0Zm9udC13ZWlnaHQ6IGJvbGQ7XHJcblx0Zm9udC1zaXplOiAxNHB4O1xyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC10b29sYmFyIC50b29sYmFyLWJ1dHRvbntcclxuXHRmbG9hdDogcmlnaHQ7XHRcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVye1xyXG5cdGhlaWdodDogY2FsYygxMDAlIC0gMzBweCk7XHJcblx0cGFkZGluZzogNHB4IDRweDtcclxuXHRvdmVyZmxvdzogYXV0bztcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW17XHJcblx0aGVpZ2h0OiAyMnB4O1xyXG5cdGxpbmUtaGVpZ2h0OiAyMnB4O1xyXG5cdG1hcmdpbjogM3B4IDA7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2NhZmZmOTtcclxuXHRwYWRkaW5nLWxlZnQ6IDE1cHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtOmhvdmVye1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNjYWZmZDM7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtIGF7XHJcblx0Y29sb3I6IGdyYXk7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtIGE6aG92ZXJ7XHJcblx0Y29sb3I6ICM5NDZiNzM7XHJcbn1cclxuXHJcbi50b29sYmFyLWltYWdlIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIG1hcmdpbi1yaWdodDogMTBweDtcclxuICAgIHdpZHRoOiAyNHB4O1xyXG4gICAgaGVpZ2h0OiAyNHB4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3d2aWV3LWRpYWxvZy1jb250ZW50LWNvbnRhaW5lciBkaXYuaXRlbS1yb3cge1xyXG4gICAgcGFkZGluZzogNXB4IDA7XHJcbn1cclxuXHJcblxyXG5cclxuIl19 */");

/***/ }),

/***/ "./src/app/message-bar/message-bar.component.ts":
/*!******************************************************!*\
  !*** ./src/app/message-bar/message-bar.component.ts ***!
  \******************************************************/
/*! exports provided: MessageBarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessageBarComponent", function() { return MessageBarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/error-service.service */ "./src/app/services/error-service.service.ts");






let MessageBarComponent = class MessageBarComponent {
    constructor(router, messageService, errorService, _stompService) {
        this.router = router;
        this.messageService = messageService;
        this.errorService = errorService;
        this._stompService = _stompService;
        this.messages = [];
        this.viewWorkflow = false;
        this.messageSearchInterval = 60000;
        this.messageReloadTimeoutId = 0;
        this.messagePanelHeight = 170;
        this.messagePanelShowed = true;
        this.isReloadingMessages = false;
        this.status = "Not Connected";
        this.requesting = false;
        this.stompClient = null;
        this._isLogged = false;
        this.receiveMessage = (message) => {
            this.requesting = false;
            console.log("Socket Message: ", message.body);
            var parsedMessage = JSON.parse(message.body);
            console.log("Parsed Message: ", parsedMessage);
            if (parsedMessage.command && parsedMessage.command === "message-reload") {
                this.readMessageList(false);
            }
        };
    }
    debugData() {
        return (this.viewWorkflowModel && this.viewWorkflowModel != null) ? JSON.stringify(this.viewWorkflowModel) : 'no data';
    }
    closeMessages() {
        //$('#message-panel-container').height(25);
        document.getElementById("message-panel-container").style.height = "25px";
        this.messagePanelShowed = false;
    }
    ;
    showMessages() {
        //$('#message-panel-container').height(this.messagePanelHeight);
        //alert("show pabel");
        document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
        this.messagePanelShowed = true;
    }
    ;
    set isLogged(value) {
        if (this._isLogged !== value) {
            if (value === true) {
                this.subscribe();
            }
            else {
                this.unsubscribe();
            }
        }
        this._isLogged = value;
    }
    get isAppLogged() {
        return this._isLogged;
    }
    ngOnInit() {
        if (this._isLogged === true) {
            this.subscribe();
        }
    }
    ngOnDestroy() {
        this.unsubscribe();
    }
    onResizeEnd(event) {
        this.messagePanelHeight = event.rectangle.height;
        document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
    }
    readMessageList(reset) {
        //clearTimeout(this.messageReloadTimeoutId);
        console.log("Socket Request Read message list");
        if (this._isLogged === true) {
            this.isReloadingMessages = true;
            this.messageService.loadMessages(reset).subscribe((messageList) => {
                console.log("Read message list", messageList);
                this.messages = messageList;
            }, response => {
                console.log("Error in read message list", response);
                this.messages = [];
                this.isReloadingMessages = false;
            }, () => {
                setTimeout(() => {
                    this.isReloadingMessages = false;
                }, 500);
                /*this.messageReloadTimeoutId = setTimeout(() =>{
                    this.reloadMessages(false);
                }, this.messageSearchInterval);	*/
            });
        }
    }
    showWorkflowView(identity) {
        for (var index in this.messages) {
            if (this.messages[index].workflowIdentity == identity) {
                this.viewWorkflowModel = this.messages[index].workflow;
                this.viewWorkflow = true;
                break;
            }
        }
    }
    hideViewModal() {
        this.viewWorkflow = false;
    }
    assignWorkflowMe() {
        this.messageService.assignMe(this.viewWorkflowModel.identity).subscribe(val => {
            console.log("Workflow assigned to me");
            //this.readMessageList(true);
        }, response => {
            console.log("Error in assigning workflow", response);
            this.errorService.showErrorResponse(response);
        }, () => {
            this.viewWorkflow = false;
        });
    }
    editWorkflow() {
        this.viewWorkflow = false;
        this.router.navigate(['/workflow/edit/' + this.viewWorkflowModel.workflowType.identity + '/' + this.viewWorkflowModel.identity]);
    }
    setConnected(subscribed) {
        this.subscribed = subscribed;
        this.status = subscribed ? "Connected" : "Not Connected";
    }
    subscribe() {
        if (this.subscribed) {
            return;
        }
        this.socketMessages = this._stompService.subscribe('/user/socket/messages');
        console.log("Subscribe Message: ", this.socketMessages);
        this.subscription = this.socketMessages.subscribe(this.receiveMessage);
        this.readMessageList(true);
        this.setConnected(true);
    }
    reloadMessages() {
        this.readMessageList(true);
    }
    unsubscribe() {
        if (!this.subscribed) {
            return;
        }
        this.subscription.unsubscribe();
        this.subscription = null;
        this.messages = null;
        this.messages = [];
        this.setConnected(false);
    }
};
MessageBarComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_3__["Router"] },
    { type: _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_4__["WorkflowMessageService"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_5__["ErrorServiceService"] },
    { type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_2__["StompService"] }
];
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('currentUser')
], MessageBarComponent.prototype, "currentUser", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('isLogged')
], MessageBarComponent.prototype, "isLogged", null);
MessageBarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-message-bar',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./message-bar.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html")).default,
        providers: [_services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_4__["WorkflowMessageService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./message-bar.component.css */ "./src/app/message-bar/message-bar.component.css")).default]
    })
], MessageBarComponent);



/***/ }),

/***/ "./src/app/services/authentication.service.ts":
/*!****************************************************!*\
  !*** ./src/app/services/authentication.service.ts ***!
  \****************************************************/
/*! exports provided: AuthenticationService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return AuthenticationService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../helper/http-hepler */ "./src/app/helper/http-hepler.ts");








let AuthenticationService = class AuthenticationService {
    constructor(http, global, router, loadingService) {
        this.http = http;
        this.global = global;
        this.router = router;
        this.loadingService = loadingService;
        this.isLoggedIn = false;
        this.authenticateUrl = "/auth/authenticate";
        this.logoutUrl = "/auth/logout";
        this.currentUserSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
    }
    get currentUserValue() {
        return this.currentUserSubject.value;
    }
    get isLogedIn() {
        return this.currentUserSubject.value != null;
    }
    login(username, password, companyid, loginComponent) {
        const loginData = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"]()
            .set('username', username)
            .set('password', password)
            .set('companyid', companyid);
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFormHeader() };
        this.http.post(this.authenticateUrl, loginData, httpOptions).subscribe(val => {
            var loginResponse = val;
            this.currentUserSubject.next(loginResponse.user);
            this.currentUserSubject.complete();
            this.isLoggedIn = true;
            loginComponent.processLoginResult(val);
        }, response => {
            this.currentUserSubject.next(null);
            this.currentUserSubject.complete();
            this.isLoggedIn = false;
            loginComponent.processFailedResult(response);
        }, () => {
            loginComponent.processEndLoading();
        });
    }
    checkLoginState(returnUrl) {
        this.loadingService.showLoading();
        this.global.loadAllSettingObserv().subscribe((generalData) => {
            console.log("GET call successful generaldata", generalData);
            var value = generalData.isLogged + "";
            if (value === "true" && generalData.user) {
                this.isLoggedIn = true;
                this.currentUserSubject.next(generalData.user.currentUser);
                //this.currentUserSubject.complete();
                this.global.loadAllSetting(null);
                //this.global.setGeneralData(generalData);
                //alert("from authentication- redirect to : " + returnUrl + ": \n" + JSON.stringify(generalData));
                this.router.navigate([returnUrl]);
            }
            else {
                this.isLoggedIn = false;
                this.currentUserSubject.next(null);
                //this.currentUserSubject.complete();
                //alert("from authentication- redirect to login : \n" + JSON.stringify(generalData));
                this.router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
            }
        }, response => {
            console.log("Error in read menu list", response);
            this.isLoggedIn = false;
            this.currentUserSubject.next(null);
            this.currentUserSubject.complete();
            this.router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
        }, () => {
            //this.loadingService.hideLoading();
        });
    }
    /*clearSessionData() {
        
        this.global.loadAllSetting(null);
        this.currentUserSubject.next(null);
        //this.currentUserSubject.complete();
    }

    resetGeneralSettings() {
        
        this.currentUserSubject.next(null);
        
        //this.global.loadAllSetting(null);
    }*/
    logout(returnUrl) {
        if (!returnUrl || returnUrl === null || returnUrl === undefined) {
            returnUrl = "";
        }
        //this.clearSessionData();
        //window.location.assign("/logout");
        //this.router.navigate(['auth/login']);
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFormHeader() };
        this.http.get(this.logoutUrl, httpOptions).subscribe(val => {
            var loginResponse = val;
            console.log("Is Logged out!");
            this.currentUserSubject.next(null);
            //this.currentUserSubject.complete();
            this.isLoggedIn = false;
            //loginComponent.processLoginResult(<LoginResponse>val);
            this.global.loadAllSetting(null);
            //this.loadingService.hideLoading();
            this.router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
        }, response => {
            this.currentUserSubject.next(null);
            console.log("Error in Logging out!", response);
            //this.currentUserSubject.complete();
            this.isLoggedIn = false;
            //loginComponent.processFailedResult(response);
            this.global.loadAllSetting(null);
            this.loadingService.hideLoading();
            this.router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
        }, () => {
            //loginComponent.processEndLoading();		            
        });
    }
    canActivate(route, state) {
        //alert("check authentication fo : " + state.url + " : isLoggedIn: " + this.isLoggedIn);
        if (this.isLoggedIn === true) {
            return true;
        }
        this.checkLoginState(state.url);
        // not logged in so redirect to login page with the return url
        //this.router.navigate(['auth/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
};
AuthenticationService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }
];
AuthenticationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
], AuthenticationService);



/***/ }),

/***/ "./src/app/services/error-service.service.ts":
/*!***************************************************!*\
  !*** ./src/app/services/error-service.service.ts ***!
  \***************************************************/
/*! exports provided: ErrorServiceService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorServiceService", function() { return ErrorServiceService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");




let ErrorServiceService = class ErrorServiceService {
    constructor() {
        this.errorSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
    }
    showError(errorMessage, errorDetail) {
        if (errorDetail === undefined) {
            errorDetail = "";
        }
        var err = new _ui_models__WEBPACK_IMPORTED_MODULE_3__["ErrorDetail"](errorMessage, errorDetail);
        this.errorSubject.next(err);
    }
    showErrorResponse(response) {
        var errResp = new _ui_models__WEBPACK_IMPORTED_MODULE_3__["ErrorResponse"](response);
        this.showError(errResp.message, errResp.details);
    }
};
ErrorServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], ErrorServiceService);



/***/ }),

/***/ "./src/app/services/global.service.ts":
/*!********************************************!*\
  !*** ./src/app/services/global.service.ts ***!
  \********************************************/
/*! exports provided: GlobalService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GlobalService", function() { return GlobalService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../helper/http-hepler */ "./src/app/helper/http-hepler.ts");






let GlobalService = class GlobalService {
    constructor(http, loadingService) {
        this.http = http;
        this.loadingService = loadingService;
        this.loadGeneralDataUrl = "/general/data/generaldatat";
        this.currentSessionDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        //public currentSessionDataObs :Observable<GeneralData>;		
        this.loadedGeneralData = null;
        //this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(null);
        //this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();		
    }
    /* public get currentSessionDataValue(): GeneralData {
         return this.currentSessionDataSubject.value;
     }*/
    loadAllSetting(login) {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateFormHeader() };
        this.http.get(this.loadGeneralDataUrl, httpOptions).subscribe((generalData) => {
            console.log("GET call successful generaldata", generalData);
            var islogged = generalData.isLogged + "";
            generalData.isLogged = islogged === "true";
            this.loadedGeneralData = JSON.parse(JSON.stringify(generalData));
            this.currentSessionDataSubject.next(generalData);
            this.loadingService.hideLoading();
        }, response => {
            console.log("Error in read general list", response);
            this.loadingService.hideLoading();
        }, () => {
            if (login != null) {
                login.finishGeneralDataLoading();
            }
            //this.currentSessionDataSubject.complete();
            this.loadingService.hideLoading();
        });
    }
    /*setGeneralData(generalData :GeneralData){
        this.currentSessionDataSubject.next(generalData);
        //this.currentSessionDataSubject.complete();
    }*/
    loadAllSettingObserv() {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateFormHeader() };
        return this.http.get(this.loadGeneralDataUrl, httpOptions);
    }
};
GlobalService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }
];
GlobalService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
], GlobalService);



/***/ }),

/***/ "./src/app/services/index.ts":
/*!***********************************!*\
  !*** ./src/app/services/index.ts ***!
  \***********************************/
/*! exports provided: AuthenticationService, GlobalService, UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return _authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]; });

/* harmony import */ var _user_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./user.service */ "./src/app/services/user.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return _user_service__WEBPACK_IMPORTED_MODULE_2__["UserService"]; });

/* harmony import */ var _global_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./global.service */ "./src/app/services/global.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GlobalService", function() { return _global_service__WEBPACK_IMPORTED_MODULE_3__["GlobalService"]; });







/***/ }),

/***/ "./src/app/services/loading-service.service.ts":
/*!*****************************************************!*\
  !*** ./src/app/services/loading-service.service.ts ***!
  \*****************************************************/
/*! exports provided: LoadingServiceService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoadingServiceService", function() { return LoadingServiceService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");



let LoadingServiceService = class LoadingServiceService {
    constructor() {
        this.loadingSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](false);
    }
    showLoading() {
        this.loadingSubject.next(true);
    }
    hideLoading() {
        this.loadingSubject.next(false);
    }
};
LoadingServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], LoadingServiceService);



/***/ }),

/***/ "./src/app/services/user.service.ts":
/*!******************************************!*\
  !*** ./src/app/services/user.service.ts ***!
  \******************************************/
/*! exports provided: UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return UserService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");



let UserService = class UserService {
    constructor(http) {
        this.http = http;
    }
    getAll() {
        return this.http.get("/users");
    }
    register(user) {
        return this.http.post("/users/register", user);
    }
    delete(id) {
        return this.http.delete("/users/${id}");
    }
};
UserService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
];
UserService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
], UserService);



/***/ }),

/***/ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts":
/*!****************************************************************************!*\
  !*** ./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts ***!
  \****************************************************************************/
/*! exports provided: InvoiceWorkflowEditService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflowEditService", function() { return InvoiceWorkflowEditService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _error_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");










let InvoiceWorkflowEditService = class InvoiceWorkflowEditService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_8__["HttpErrorResponseHelper"] {
    //userAssignType = /*[[${UserAssign}]]*/ '';
    //departmentAssignType = /*[[${DepartmentAssign}]]*/ '';
    //departmentGroupAssignType = /*[[${DepartmentGroupAssign}]]*/ '';
    constructor(http, loadingService, errorService, router, route, autService) {
        super(router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.errorService = errorService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.workflowSaveRequestInit = null;
    }
    getInitCreateUrl() {
        return "/workflow/invoice/data/initcreate";
    }
    getInitEditUrl(identity) {
        return "/workflow/invoice/data/initedit/" + identity;
    }
    getCreateWorkflowUrl() {
        return "/workflow/invoice/data/create";
    }
    getSaveWorkflowUrl() {
        return "/workflow/invoice/data/save";
    }
    getDoneWorkflowUrl() {
        return "/workflow/invoice/data/done";
    }
    getArchiveWorkflowUrl() {
        return "/workflow/invoice/data/archive";
    }
    getUploadFileUrl() {
        return "/workflow/invoice/data/createfile";
    }
    getUploadOcrScanFileUrl() {
        return "/workflow/invoice/data/uploadinvoicefile";
    }
    loadCreateInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFormHeader() };
        this.http.post(this.getInitCreateUrl(), new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions).subscribe((initialData) => {
            console.log("GET successful edit inital data", initialData);
            this.workflowSaveRequestInit = JSON.parse(JSON.stringify(initialData));
            this.workflowSaveRequestInitSubject.next(initialData);
        }, response => {
            console.log("Error in read edit inital data", response);
            this.errorService.showErrorResponse(response);
        }, () => {
            this.workflowSaveRequestInitSubject.complete();
            this.loadingService.hideLoading();
        });
    }
    loadEditInitialData(identity) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFormHeader() };
        return this.http.post(this.getInitEditUrl(identity), new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions);
    }
    uploadFiles(fileTitles) {
        const formData = new FormData();
        for (var i = 0; i < fileTitles.length; i++) {
            formData.append('files', fileTitles[i].file);
            formData.append('titles', fileTitles[i].title);
            formData.append('wids', i + "");
        }
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadFileUrl(), formData, httpFileUploadOptions);
    }
    uploadOcrScanFiles(ocrScanFile) {
        const formData = new FormData();
        formData.append('file', ocrScanFile);
        formData.append('wids', "0");
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadOcrScanFileUrl(), formData, httpFileUploadOptions);
    }
    createWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getCreateWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    saveWorkflow(workflow) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getSaveWorkflowUrl(), workflow, httpOptions);
    }
    doneWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getDoneWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    archiveWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_7__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getArchiveWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
};
InvoiceWorkflowEditService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] },
    { type: _error_service_service__WEBPACK_IMPORTED_MODULE_6__["ErrorServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] },
    { type: _authentication_service__WEBPACK_IMPORTED_MODULE_9__["AuthenticationService"] }
];
InvoiceWorkflowEditService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], InvoiceWorkflowEditService);



/***/ }),

/***/ "./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts ***!
  \**********************************************************************************/
/*! exports provided: SingleTaskWorkflowEditService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "SingleTaskWorkflowEditService", function() { return SingleTaskWorkflowEditService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../workflow-edit-base.service */ "./src/app/services/workflow/workflow-edit-base.service.ts");








let SingleTaskWorkflowEditService = class SingleTaskWorkflowEditService extends _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_7__["WorkflowEditBaseService"] {
    constructor(http, loadingService, router, route, autService) {
        super(http, loadingService, router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.workflowSaveRequestInit = null;
    }
    getInitCreateUrl() {
        return "/workflow/singletask/data/initcreate";
    }
    getCreateWorkflowUrl() {
        return "/workflow/singletask/data/create";
    }
    getUploadFileUrl() {
        return "/workflow/singletask/data/createfile";
    }
    getSaveWorkflowUrl() {
        return "/workflow/singletask/data/save";
    }
    getDoneWorkflowUrl() {
        return "/workflow/singletask/data/done";
    }
    getArchiveWorkflowUrl() {
        return "/workflow/singletask/data/archive";
    }
    getInitEditUrl(identity) {
        return "/workflow/singletask/data/initedit/" + identity;
    }
};
SingleTaskWorkflowEditService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] },
    { type: _authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] }
];
SingleTaskWorkflowEditService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], SingleTaskWorkflowEditService);



/***/ }),

/***/ "./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts":
/*!****************************************************************************************!*\
  !*** ./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts ***!
  \****************************************************************************************/
/*! exports provided: TestthreetaskWorkflowEditService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TestthreetaskWorkflowEditService", function() { return TestthreetaskWorkflowEditService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../workflow-edit-base.service */ "./src/app/services/workflow/workflow-edit-base.service.ts");








let TestthreetaskWorkflowEditService = class TestthreetaskWorkflowEditService extends _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_7__["WorkflowEditBaseService"] {
    constructor(http, loadingService, router, route, autService) {
        super(http, loadingService, router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.workflowSaveRequestInit = null;
    }
    getInitCreateUrl() {
        return "/workflow/testthreetask/data/initcreate";
    }
    getCreateWorkflowUrl() {
        return "/workflow/testthreetask/data/create";
    }
    getUploadFileUrl() {
        return "/workflow/testthreetask/data/createfile";
    }
    getSaveWorkflowUrl() {
        return "/workflow/testthreetask/data/save";
    }
    getDoneWorkflowUrl() {
        return "/workflow/testthreetask/data/done";
    }
    getArchiveWorkflowUrl() {
        return "/workflow/testthreetask/data/archive";
    }
    getInitEditUrl(identity) {
        return "/workflow/testthreetask/data/initedit/" + identity;
    }
};
TestthreetaskWorkflowEditService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] },
    { type: _authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] }
];
TestthreetaskWorkflowEditService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], TestthreetaskWorkflowEditService);



/***/ }),

/***/ "./src/app/services/workflow/workflow-edit-base.service.ts":
/*!*****************************************************************!*\
  !*** ./src/app/services/workflow/workflow-edit-base.service.ts ***!
  \*****************************************************************/
/*! exports provided: WorkflowEditBaseService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowEditBaseService", function() { return WorkflowEditBaseService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../services */ "./src/app/services/index.ts");









let WorkflowEditBaseService = class WorkflowEditBaseService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_7__["HttpErrorResponseHelper"] {
    //userAssignType = /*[[${UserAssign}]]*/ '';
    //departmentAssignType = /*[[${DepartmentAssign}]]*/ '';
    //departmentGroupAssignType = /*[[${DepartmentGroupAssign}]]*/ '';
    constructor(http, loadingService, router, route, autService) {
        super(router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.workflowSaveRequestInit = null;
    }
    getInitCreateUrl() {
        return "";
    }
    getCreateWorkflowUrl() {
        return "";
    }
    getUploadFileUrl() {
        return "";
    }
    getSaveWorkflowUrl() {
        return "";
    }
    getDoneWorkflowUrl() {
        return "";
    }
    getArchiveWorkflowUrl() {
        return "";
    }
    getInitEditUrl(identity) {
        return "";
    }
    loadCreateInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateFormHeader() };
        this.http.post(this.getInitCreateUrl(), new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions).subscribe((initialData) => {
            console.log("GET successful edit inital data", initialData);
            this.workflowSaveRequestInit = JSON.parse(JSON.stringify(initialData));
            this.workflowSaveRequestInitSubject.next(initialData);
        }, response => {
            console.log("Error in read edit inital data", response);
            this.processErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.workflowSaveRequestInitSubject.complete();
            this.loadingService.hideLoading();
        });
    }
    loadEditInitialData(identity) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateFormHeader() };
        return this.http.post(this.getInitEditUrl(identity), new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions);
    }
    uploadFiles(fileTitles) {
        const formData = new FormData();
        for (var i = 0; i < fileTitles.length; i++) {
            formData.append('files', fileTitles[i].file);
            formData.append('titles', fileTitles[i].title);
            formData.append('wids', i + "");
        }
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadFileUrl(), formData, httpFileUploadOptions);
    }
    createWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getCreateWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    saveWorkflow(workflow) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getSaveWorkflowUrl(), workflow, httpOptions);
    }
    doneWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getDoneWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    archiveWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_6__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getArchiveWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
};
WorkflowEditBaseService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] },
    { type: _services__WEBPACK_IMPORTED_MODULE_8__["AuthenticationService"] }
];
WorkflowEditBaseService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], WorkflowEditBaseService);



/***/ }),

/***/ "./src/app/services/workflow/workflow-message.service.ts":
/*!***************************************************************!*\
  !*** ./src/app/services/workflow/workflow-message.service.ts ***!
  \***************************************************************/
/*! exports provided: WorkflowMessageService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessageService", function() { return WorkflowMessageService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _error_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");






let WorkflowMessageService = class WorkflowMessageService {
    constructor(http, errorService) {
        this.http = http;
        this.errorService = errorService;
        this.loadMessageUrl = "/general/data/workflowmessages";
        this.assignWorkflowUrl = "/general/data/workflow/assign/";
        this.isReloadingMessages = false;
        this.workflowMessageListSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"]([]);
    }
    get workflowMessageList() {
        return this.workflowMessageListSubject.value;
    }
    loadMessages(resetCach) {
        this.isReloadingMessages = true;
        var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateJsonHeader() };
        return this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"](), httpOptions);
    }
    assignMe(workflowIdentity) {
        this.isReloadingMessages = true;
        var url = this.assignWorkflowUrl + workflowIdentity;
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateJsonHeader() };
        return this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"](), httpOptions);
    }
};
WorkflowMessageService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] },
    { type: _error_service_service__WEBPACK_IMPORTED_MODULE_4__["ErrorServiceService"] }
];
WorkflowMessageService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], WorkflowMessageService);



/***/ }),

/***/ "./src/app/services/workflow/workflow-search.service.ts":
/*!**************************************************************!*\
  !*** ./src/app/services/workflow/workflow-search.service.ts ***!
  \**************************************************************/
/*! exports provided: WorkflowSearchService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchService", function() { return WorkflowSearchService; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../services */ "./src/app/services/index.ts");









let WorkflowSearchService = class WorkflowSearchService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_6__["HttpErrorResponseHelper"] {
    constructor(http, loadingService, router, route, autService) {
        super(router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.searchInitialDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
        this.loadInitialUrl = "/workflow/general/data/initsearch";
        this.searchUrl = "/workflow/general/data/search";
        this.listInitialData = null;
    }
    loadInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateFormHeader() };
        this.http.post(this.loadInitialUrl, new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions).subscribe((initialData) => {
            console.log("GET successful search inital data", initialData);
            this.listInitialData = JSON.parse(JSON.stringify(initialData));
            this.searchInitialDataSubject.next(initialData);
        }, response => {
            console.log("Error in read search inital data", response);
            this.processErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.searchInitialDataSubject.complete();
            this.loadingService.hideLoading();
        });
    }
    search(searchFilter) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_5__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.searchUrl, searchFilter, httpOptions);
    }
    ;
};
WorkflowSearchService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
    { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_7__["LoadingServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["ActivatedRoute"] },
    { type: _services__WEBPACK_IMPORTED_MODULE_8__["AuthenticationService"] }
];
WorkflowSearchService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
        providedIn: 'root'
    })
], WorkflowSearchService);



/***/ }),

/***/ "./src/app/test/test.component.css":
/*!*****************************************!*\
  !*** ./src/app/test/test.component.css ***!
  \*****************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.main-content{\r\n    margin-top: 40px;\r\n\t\r\n}\r\n\r\n.responsediv {\r\n    border: 1px solid gray;\r\n    min-height: 30px;\r\n    margin-top: 30px;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n}\r\n\r\n.form-group{\r\n\tmargin-bottom: 30px;\r\n}\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdGVzdC90ZXN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksZ0JBQWdCOztBQUVwQjs7QUFFQTtJQUNJLHNCQUFzQjtJQUN0QixnQkFBZ0I7SUFDaEIsZ0JBQWdCO0lBQ2hCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7Q0FDQyxtQkFBbUI7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC90ZXN0L3Rlc3QuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4ubWFpbi1jb250ZW50e1xyXG4gICAgbWFyZ2luLXRvcDogNDBweDtcclxuXHRcclxufVxyXG5cclxuLnJlc3BvbnNlZGl2IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XHJcbiAgICBtaW4taGVpZ2h0OiAzMHB4O1xyXG4gICAgbWFyZ2luLXRvcDogMzBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbn1cclxuXHJcbi5mb3JtLWdyb3Vwe1xyXG5cdG1hcmdpbi1ib3R0b206IDMwcHg7XHJcbn0iXX0= */");

/***/ }),

/***/ "./src/app/test/test.component.ts":
/*!****************************************!*\
  !*** ./src/app/test/test.component.ts ***!
  \****************************************/
/*! exports provided: TestComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TestComponent", function() { return TestComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/fesm2015/stomp-ng2-stompjs.js");



let TestComponent = class TestComponent {
    constructor(_stompService) {
        this._stompService = _stompService;
        this.sending = false;
        this.status = "Not Connected";
        this.response = "";
        this.message = "";
        this.messageQeue = [];
        this.stompClient = null;
        this.on_next = (message) => {
            console.log("My Message: ", message.body);
            this.messageQeue.push(message.body + '\n');
            this.sending = false;
        };
    }
    ngOnInit() {
        this.setConnected(false);
    }
    ngOnDestroy() {
        this.unsubscribe();
    }
    subscribe() {
        if (this.subscribed) {
            return;
        }
        this.messages = this._stompService.subscribe('/socket/test');
        this.subscription = this.messages.subscribe(this.on_next);
        this.setConnected(true);
    }
    unsubscribe() {
        if (!this.subscribed) {
            return;
        }
        // This will internally unsubscribe from Stomp Broker
        // There are two subscriptions - one created explicitly, the other created in the template by use of 'async'
        this.subscription.unsubscribe();
        this.subscription = null;
        this.messages = null;
        this.setConnected(false);
    }
    send() {
        this.sending = true;
        this._stompService.publish('/socketapp/start', JSON.stringify({ 'sentMessage': this.message }));
        this.message = "";
    }
    setConnected(subscribed) {
        this.subscribed = subscribed;
        this.status = subscribed ? "Connected" : "Not Connected";
        this.response = "";
    }
};
TestComponent.ctorParameters = () => [
    { type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_2__["StompService"] }
];
TestComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-test',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./test.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/test/test.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./test.component.css */ "./src/app/test/test.component.css")).default]
    })
], TestComponent);



/***/ }),

/***/ "./src/app/top-bar/top-bar.component.css":
/*!***********************************************!*\
  !*** ./src/app/top-bar/top-bar.component.css ***!
  \***********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.navbar-user-detail {\r\n    float: right;\r\n    margin-right: 30px;\r\n}\r\n\r\nbutton.user-toggle-button {\r\n    background-color: #cecece;\r\n    border: none;\r\n    background-image: url(/assets/images/md-contact.svg);\r\n    background-position: 140px center;\r\n    background-repeat: no-repeat;\r\n    background-size: 24px;\r\n    width: 170px;\r\n    text-align: left;\r\n    height: 34px;\r\n}   \r\n    \r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdG9wLWJhci90b3AtYmFyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHlCQUF5QjtJQUN6QixZQUFZO0lBQ1osb0RBQW9EO0lBQ3BELGlDQUFpQztJQUNqQyw0QkFBNEI7SUFDNUIscUJBQXFCO0lBQ3JCLFlBQVk7SUFDWixnQkFBZ0I7SUFDaEIsWUFBWTtBQUNoQiIsImZpbGUiOiJzcmMvYXBwL3RvcC1iYXIvdG9wLWJhci5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5uYXZiYXItdXNlci1kZXRhaWwge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAzMHB4O1xyXG59XHJcblxyXG5idXR0b24udXNlci10b2dnbGUtYnV0dG9uIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNjZWNlY2U7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL2Fzc2V0cy9pbWFnZXMvbWQtY29udGFjdC5zdmcpO1xyXG4gICAgYmFja2dyb3VuZC1wb3NpdGlvbjogMTQwcHggY2VudGVyO1xyXG4gICAgYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcclxuICAgIGJhY2tncm91bmQtc2l6ZTogMjRweDtcclxuICAgIHdpZHRoOiAxNzBweDtcclxuICAgIHRleHQtYWxpZ246IGxlZnQ7XHJcbiAgICBoZWlnaHQ6IDM0cHg7XHJcbn0gICBcclxuICAgICJdfQ== */");

/***/ }),

/***/ "./src/app/top-bar/top-bar.component.ts":
/*!**********************************************!*\
  !*** ./src/app/top-bar/top-bar.component.ts ***!
  \**********************************************/
/*! exports provided: TopBarComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TopBarComponent", function() { return TopBarComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");




let TopBarComponent = class TopBarComponent {
    constructor(router, global) {
        this.router = router;
        this.global = global;
        this.menus = [];
        this.loggingOut = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    ngOnInit() {
    }
    logout() {
        this.loggingOut.emit(true);
    }
    showProfile() {
    }
    test() {
        this.global.loadAllSetting(null);
    }
};
TopBarComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_3__["GlobalService"] }
];
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('menus')
], TopBarComponent.prototype, "menus", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('currentUser')
], TopBarComponent.prototype, "currentUser", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('isLogged')
], TopBarComponent.prototype, "isLogged", void 0);
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Output"])()
], TopBarComponent.prototype, "loggingOut", void 0);
TopBarComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-top-bar',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./top-bar.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./top-bar.component.css */ "./src/app/top-bar/top-bar.component.css")).default]
    })
], TopBarComponent);



/***/ }),

/***/ "./src/app/ui-models/error-detail.ts":
/*!*******************************************!*\
  !*** ./src/app/ui-models/error-detail.ts ***!
  \*******************************************/
/*! exports provided: ErrorDetail */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function() { return ErrorDetail; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class ErrorDetail {
    constructor(errorMessage, errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }
}


/***/ }),

/***/ "./src/app/ui-models/error-response.ts":
/*!*********************************************!*\
  !*** ./src/app/ui-models/error-response.ts ***!
  \*********************************************/
/*! exports provided: ErrorResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function() { return ErrorResponse; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class ErrorResponse {
    constructor(response) {
        this.message = "Unknown response error!";
        this.details = "";
        if (response && response != null) {
            if (response.status) {
                if (response.status === 0) {
                    this.message = "Connection Error!";
                    this.details = "";
                }
                else {
                    if (response.error) {
                        if (response.error.message) {
                            this.message = response.error.message;
                            this.details = "";
                            if (response.error.details) {
                                this.details = response.error.details;
                            }
                        }
                        else {
                            if (response.message) {
                                this.message = response.message;
                                this.details = "";
                            }
                        }
                    }
                }
            }
        }
    }
}


/***/ }),

/***/ "./src/app/ui-models/generaldata.ts":
/*!******************************************!*\
  !*** ./src/app/ui-models/generaldata.ts ***!
  \******************************************/
/*! exports provided: GeneralData */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GeneralData", function() { return GeneralData; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class GeneralData {
}


/***/ }),

/***/ "./src/app/ui-models/index.ts":
/*!************************************!*\
  !*** ./src/app/ui-models/index.ts ***!
  \************************************/
/*! exports provided: User, MenuItem, LoginResponse, GeneralData, ErrorDetail, ErrorResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _user__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./user */ "./src/app/ui-models/user.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "User", function() { return _user__WEBPACK_IMPORTED_MODULE_1__["User"]; });

/* harmony import */ var _menuitem__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./menuitem */ "./src/app/ui-models/menuitem.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "MenuItem", function() { return _menuitem__WEBPACK_IMPORTED_MODULE_2__["MenuItem"]; });

/* harmony import */ var _loginmessage__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./loginmessage */ "./src/app/ui-models/loginmessage.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginResponse", function() { return _loginmessage__WEBPACK_IMPORTED_MODULE_3__["LoginResponse"]; });

/* harmony import */ var _generaldata__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./generaldata */ "./src/app/ui-models/generaldata.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GeneralData", function() { return _generaldata__WEBPACK_IMPORTED_MODULE_4__["GeneralData"]; });

/* harmony import */ var _error_detail__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./error-detail */ "./src/app/ui-models/error-detail.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function() { return _error_detail__WEBPACK_IMPORTED_MODULE_5__["ErrorDetail"]; });

/* harmony import */ var _error_response__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./error-response */ "./src/app/ui-models/error-response.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function() { return _error_response__WEBPACK_IMPORTED_MODULE_6__["ErrorResponse"]; });










/***/ }),

/***/ "./src/app/ui-models/loginmessage.ts":
/*!*******************************************!*\
  !*** ./src/app/ui-models/loginmessage.ts ***!
  \*******************************************/
/*! exports provided: LoginResponse */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginResponse", function() { return LoginResponse; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class LoginResponse {
}


/***/ }),

/***/ "./src/app/ui-models/menuitem.ts":
/*!***************************************!*\
  !*** ./src/app/ui-models/menuitem.ts ***!
  \***************************************/
/*! exports provided: MenuItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenuItem", function() { return MenuItem; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class MenuItem {
    constructor() {
        this.children = [];
    }
}


/***/ }),

/***/ "./src/app/ui-models/user.ts":
/*!***********************************!*\
  !*** ./src/app/ui-models/user.ts ***!
  \***********************************/
/*! exports provided: User */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function() { return User; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class User {
}


/***/ }),

/***/ "./src/app/wf-models/assign-item.ts":
/*!******************************************!*\
  !*** ./src/app/wf-models/assign-item.ts ***!
  \******************************************/
/*! exports provided: AssignItem */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AssignItem", function() { return AssignItem; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class AssignItem {
}


/***/ }),

/***/ "./src/app/wf-models/assign-type.ts":
/*!******************************************!*\
  !*** ./src/app/wf-models/assign-type.ts ***!
  \******************************************/
/*! exports provided: AssignType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AssignType", function() { return AssignType; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var AssignType;
(function (AssignType) {
    AssignType["NONE"] = "None";
    AssignType["USER"] = "User";
    AssignType["DEPARTMENT"] = "Department";
    AssignType["DEPARTMENTGROUP"] = "DepartmentGroup";
})(AssignType || (AssignType = {}));


/***/ }),

/***/ "./src/app/wf-models/file-title.ts":
/*!*****************************************!*\
  !*** ./src/app/wf-models/file-title.ts ***!
  \*****************************************/
/*! exports provided: FileTitle */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FileTitle", function() { return FileTitle; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class FileTitle {
}


/***/ }),

/***/ "./src/app/wf-models/index.ts":
/*!************************************!*\
  !*** ./src/app/wf-models/index.ts ***!
  \************************************/
/*! exports provided: Workflow, WorkflowMessage, WorkflowType, WorkflowTypeStep, WorkflowAction, WorkflowFile, WorkflowFileVersion, WorkflowSearchFilter, WorkflowListInitialData, WorkflowSearchResult, AssignItem, AssignType, WorkflowProcessCommand, FileTitle, WorkflowUploadFileResult, InvoiceType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _workflow__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./workflow */ "./src/app/wf-models/workflow.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Workflow", function() { return _workflow__WEBPACK_IMPORTED_MODULE_1__["Workflow"]; });

/* harmony import */ var _workflowmessage__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./workflowmessage */ "./src/app/wf-models/workflowmessage.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessage", function() { return _workflowmessage__WEBPACK_IMPORTED_MODULE_2__["WorkflowMessage"]; });

/* harmony import */ var _workflowtype__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./workflowtype */ "./src/app/wf-models/workflowtype.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowType", function() { return _workflowtype__WEBPACK_IMPORTED_MODULE_3__["WorkflowType"]; });

/* harmony import */ var _workflowtypestep__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./workflowtypestep */ "./src/app/wf-models/workflowtypestep.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowTypeStep", function() { return _workflowtypestep__WEBPACK_IMPORTED_MODULE_4__["WorkflowTypeStep"]; });

/* harmony import */ var _workflowaction__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./workflowaction */ "./src/app/wf-models/workflowaction.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowAction", function() { return _workflowaction__WEBPACK_IMPORTED_MODULE_5__["WorkflowAction"]; });

/* harmony import */ var _workflowfile__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./workflowfile */ "./src/app/wf-models/workflowfile.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFile", function() { return _workflowfile__WEBPACK_IMPORTED_MODULE_6__["WorkflowFile"]; });

/* harmony import */ var _workflowfileversion__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./workflowfileversion */ "./src/app/wf-models/workflowfileversion.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFileVersion", function() { return _workflowfileversion__WEBPACK_IMPORTED_MODULE_7__["WorkflowFileVersion"]; });

/* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchFilter", function() { return _workflow_search_filter__WEBPACK_IMPORTED_MODULE_8__["WorkflowSearchFilter"]; });

/* harmony import */ var _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./workflow-list-initialdata */ "./src/app/wf-models/workflow-list-initialdata.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowListInitialData", function() { return _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_9__["WorkflowListInitialData"]; });

/* harmony import */ var _workflow_search_result__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./workflow-search-result */ "./src/app/wf-models/workflow-search-result.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResult", function() { return _workflow_search_result__WEBPACK_IMPORTED_MODULE_10__["WorkflowSearchResult"]; });

/* harmony import */ var _assign_item__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./assign-item */ "./src/app/wf-models/assign-item.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AssignItem", function() { return _assign_item__WEBPACK_IMPORTED_MODULE_11__["AssignItem"]; });

/* harmony import */ var _assign_type__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./assign-type */ "./src/app/wf-models/assign-type.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AssignType", function() { return _assign_type__WEBPACK_IMPORTED_MODULE_12__["AssignType"]; });

/* harmony import */ var _workflow_process_command__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./workflow-process-command */ "./src/app/wf-models/workflow-process-command.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowProcessCommand", function() { return _workflow_process_command__WEBPACK_IMPORTED_MODULE_13__["WorkflowProcessCommand"]; });

/* harmony import */ var _file_title__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./file-title */ "./src/app/wf-models/file-title.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "FileTitle", function() { return _file_title__WEBPACK_IMPORTED_MODULE_14__["FileTitle"]; });

/* harmony import */ var _workflow_uploadfile_result__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./workflow-uploadfile-result */ "./src/app/wf-models/workflow-uploadfile-result.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowUploadFileResult", function() { return _workflow_uploadfile_result__WEBPACK_IMPORTED_MODULE_15__["WorkflowUploadFileResult"]; });

/* harmony import */ var _invoice_type__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./invoice-type */ "./src/app/wf-models/invoice-type.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InvoiceType", function() { return _invoice_type__WEBPACK_IMPORTED_MODULE_16__["InvoiceType"]; });




















/***/ }),

/***/ "./src/app/wf-models/invoice-type.ts":
/*!*******************************************!*\
  !*** ./src/app/wf-models/invoice-type.ts ***!
  \*******************************************/
/*! exports provided: InvoiceType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceType", function() { return InvoiceType; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var InvoiceType;
(function (InvoiceType) {
    InvoiceType[InvoiceType["NO_TYPE"] = 0] = "NO_TYPE";
    InvoiceType[InvoiceType["SUPPLIER"] = 1] = "SUPPLIER";
    InvoiceType[InvoiceType["WORKER"] = 2] = "WORKER";
    InvoiceType[InvoiceType["PAYMENT"] = 3] = "PAYMENT";
})(InvoiceType || (InvoiceType = {}));


/***/ }),

/***/ "./src/app/wf-models/invoice-workflow-save-request.ts":
/*!************************************************************!*\
  !*** ./src/app/wf-models/invoice-workflow-save-request.ts ***!
  \************************************************************/
/*! exports provided: InvoiceWorkflowSaveRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflowSaveRequest", function() { return InvoiceWorkflowSaveRequest; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _invoice_workflow__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./invoice-workflow */ "./src/app/wf-models/invoice-workflow.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");



class InvoiceWorkflowSaveRequest {
    constructor() {
        this.workflow = new _invoice_workflow__WEBPACK_IMPORTED_MODULE_1__["InvoiceWorkflow"]();
        this.expireDays = 0;
        this.assigns = [];
        this.command = _wf_models__WEBPACK_IMPORTED_MODULE_2__["WorkflowProcessCommand"].NONE;
        this.sessionKey = "";
    }
}


/***/ }),

/***/ "./src/app/wf-models/invoice-workflow.ts":
/*!***********************************************!*\
  !*** ./src/app/wf-models/invoice-workflow.ts ***!
  \***********************************************/
/*! exports provided: InvoiceWorkflow */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflow", function() { return InvoiceWorkflow; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");


class InvoiceWorkflow extends _wf_models__WEBPACK_IMPORTED_MODULE_1__["Workflow"] {
}


/***/ }),

/***/ "./src/app/wf-models/workflow-list-initialdata.ts":
/*!********************************************************!*\
  !*** ./src/app/wf-models/workflow-list-initialdata.ts ***!
  \********************************************************/
/*! exports provided: WorkflowListInitialData */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowListInitialData", function() { return WorkflowListInitialData; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");


class WorkflowListInitialData {
    constructor() {
        this.workflowStatusList = [];
        this.searchFilter = new _workflow_search_filter__WEBPACK_IMPORTED_MODULE_1__["WorkflowSearchFilter"]();
    }
}


/***/ }),

/***/ "./src/app/wf-models/workflow-process-command.ts":
/*!*******************************************************!*\
  !*** ./src/app/wf-models/workflow-process-command.ts ***!
  \*******************************************************/
/*! exports provided: WorkflowProcessCommand */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowProcessCommand", function() { return WorkflowProcessCommand; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

var WorkflowProcessCommand;
(function (WorkflowProcessCommand) {
    WorkflowProcessCommand["NONE"] = "None";
    WorkflowProcessCommand["CREATE"] = "Create";
    WorkflowProcessCommand["SAVE"] = "Save";
    WorkflowProcessCommand["DONE"] = "Done";
    WorkflowProcessCommand["ARCHIVE"] = "Archive";
    WorkflowProcessCommand["ASSIGN"] = "Assign";
})(WorkflowProcessCommand || (WorkflowProcessCommand = {}));


/***/ }),

/***/ "./src/app/wf-models/workflow-save-request.ts":
/*!****************************************************!*\
  !*** ./src/app/wf-models/workflow-save-request.ts ***!
  \****************************************************/
/*! exports provided: WorkflowSaveRequest */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSaveRequest", function() { return WorkflowSaveRequest; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");


class WorkflowSaveRequest {
    constructor() {
        this.workflow = null;
        this.expireDays = 0;
        this.assigns = [];
        this.command = _wf_models__WEBPACK_IMPORTED_MODULE_1__["WorkflowProcessCommand"].NONE;
        this.sessionKey = "";
    }
}


/***/ }),

/***/ "./src/app/wf-models/workflow-search-filter.ts":
/*!*****************************************************!*\
  !*** ./src/app/wf-models/workflow-search-filter.ts ***!
  \*****************************************************/
/*! exports provided: WorkflowSearchFilter */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchFilter", function() { return WorkflowSearchFilter; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowSearchFilter {
    constructor() {
        this.meAssigned = true;
        this.assignedUserIdSet = [];
        this.statusList = [];
        this.workflowTypes = [];
        this.workflowSteps = [];
    }
}


/***/ }),

/***/ "./src/app/wf-models/workflow-search-result.ts":
/*!*****************************************************!*\
  !*** ./src/app/wf-models/workflow-search-result.ts ***!
  \*****************************************************/
/*! exports provided: WorkflowSearchResult */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResult", function() { return WorkflowSearchResult; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowSearchResult {
    constructor() {
        this.list = [];
    }
}


/***/ }),

/***/ "./src/app/wf-models/workflow-uploadfile-result.ts":
/*!*********************************************************!*\
  !*** ./src/app/wf-models/workflow-uploadfile-result.ts ***!
  \*********************************************************/
/*! exports provided: WorkflowUploadFileResult */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowUploadFileResult", function() { return WorkflowUploadFileResult; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowUploadFileResult {
    constructor() {
        this.sessionKey = "";
        this.titles = [];
    }
}


/***/ }),

/***/ "./src/app/wf-models/workflow.ts":
/*!***************************************!*\
  !*** ./src/app/wf-models/workflow.ts ***!
  \***************************************/
/*! exports provided: Workflow */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Workflow", function() { return Workflow; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class Workflow {
}


/***/ }),

/***/ "./src/app/wf-models/workflowaction.ts":
/*!*********************************************!*\
  !*** ./src/app/wf-models/workflowaction.ts ***!
  \*********************************************/
/*! exports provided: WorkflowAction */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowAction", function() { return WorkflowAction; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowAction {
}


/***/ }),

/***/ "./src/app/wf-models/workflowfile.ts":
/*!*******************************************!*\
  !*** ./src/app/wf-models/workflowfile.ts ***!
  \*******************************************/
/*! exports provided: WorkflowFile */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowFile", function() { return WorkflowFile; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowFile {
}


/***/ }),

/***/ "./src/app/wf-models/workflowfileversion.ts":
/*!**************************************************!*\
  !*** ./src/app/wf-models/workflowfileversion.ts ***!
  \**************************************************/
/*! exports provided: WorkflowFileVersion */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowFileVersion", function() { return WorkflowFileVersion; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowFileVersion {
}


/***/ }),

/***/ "./src/app/wf-models/workflowmessage.ts":
/*!**********************************************!*\
  !*** ./src/app/wf-models/workflowmessage.ts ***!
  \**********************************************/
/*! exports provided: WorkflowMessage */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessage", function() { return WorkflowMessage; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowMessage {
}


/***/ }),

/***/ "./src/app/wf-models/workflowtype.ts":
/*!*******************************************!*\
  !*** ./src/app/wf-models/workflowtype.ts ***!
  \*******************************************/
/*! exports provided: WorkflowType */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowType", function() { return WorkflowType; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowType {
}


/***/ }),

/***/ "./src/app/wf-models/workflowtypestep.ts":
/*!***********************************************!*\
  !*** ./src/app/wf-models/workflowtypestep.ts ***!
  \***********************************************/
/*! exports provided: WorkflowTypeStep */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowTypeStep", function() { return WorkflowTypeStep; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

class WorkflowTypeStep {
}


/***/ }),

/***/ "./src/app/wm-components/create/create-invoice/create-invoice.component.css":
/*!**********************************************************************************!*\
  !*** ./src/app/wm-components/create/create-invoice/create-invoice.component.css ***!
  \**********************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px 50px 0;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-record{\r\n\tfloat: right;\r\n    background-color: #dad9d9;\r\n    padding: 8px;\r\n    border-radius: 5px;\r\n    width: 25%;\r\n    min-height: 500px;\r\n}\r\n\r\n.workflow-content .panel{\r\n\tbackground-color: #f2f1f1 !important;\r\n\tpadding: 8px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.twopannel .panel{\r\n\t\r\n\theight: 190px;\r\n}\r\n\r\n.twopannel .panel.panel-vendor{\r\n\twidth: calc(100% - 310px);\r\n\tfloat: left;\r\n}\r\n\r\n.twopannel .panel.panel-discount{\r\n\twidth: 300px;\r\n\tfloat: right;\r\n}\r\n\r\n.twopannel .panel.panel-discount input[type=text]{\r\n\twidth: 100px;\r\n}\r\n\r\n.small-content{\r\n\twidth: 120px;\r\n}\r\n\r\n.item-content select{\r\n\theight: 26px;\r\n}\r\n\r\n.item-content select:not(.fullrow), .item-content input[type=text] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content select.fullrow {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content.larg-content{\r\n\twidth: calc(100% - 450px);\r\n}\r\n\r\n.workflow-content .panel .panel-heading{\r\n\tfont-weight: bold;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    background-color: white;\r\n    padding: 6px;\r\n    padding-right: 20px;\r\n   \r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, \r\ndiv.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 25px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    height: 25px;\r\n}\r\n\r\ndiv.workflow-content div.item-row .label-large, \r\ndiv.workflow-content-record div.item-row .label-large{\r\n    width: 150px;\r\n}\r\n\r\n.large-content{\r\n\twidth: calc(100% - 420px);\r\n}\r\n\r\n.large-content input[type=text],\r\n.large-content input[type=number],\r\n.large-content select, \r\n.large-content areatext{\r\n\twidth: calc(100% - 30px);\r\n}\r\n\r\ndiv.workflow-content div.item-row .small-label, \r\ndiv.workflow-content-record div.item-row .small-label{\r\n    width: 122px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    padding-left: 0px;\r\n    float: left;\r\n}\r\n\r\n.item-content input[type=checkbox]{\r\n\twidth: 20px;\r\n\theight: 20px;\t\r\n\tmargin-top: 3px;\r\n}\r\n\r\ndiv.fullrowfromlabel{\r\n\twidth: calc(100% - 150px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel input[type=text]{\r\n\twidth: calc(100% - 10px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel textarea{\r\n\twidth: calc(100% );\t\r\n\theight: 100px;\t\r\n}\r\n\r\ntextarea.comments-fullrow{\r\n\twidth: calc(100% - 100px);\t\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -22px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n.invalid-request-container{\r\n\twidth: 60vw;\r\n    min-height: 100px;\r\n    text-align: center;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    margin-top: 10vh;\r\n    padding: 10px;\r\n\t\r\n}\r\n\r\n.workflow-file-view-link, .workflow-file-view-link:active, .workflow-file-view-link:visited{\r\n\tcolor: #333;\r\n}\r\n\r\n.workflow-file-view-link:hover{\r\n\tcolor: #551113;\r\n}\r\n\r\n.workflow-file-view-link i.material-icons{\r\n\twidth: 24px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n}\r\n\r\ninput.select-date{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\ninput.short-input{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\n.ocrscan-container {\r\n    width: 500px;\r\n    float: right;\r\n    padding-top: 5px;\r\n    margin-right: 10px;\r\n}\r\n\r\n.ocrscan-container .custom-file-input{\r\n    width: calc(100% - 50px);\r\n}\r\n\r\n.ocrscan-container .custom-file-label{\r\n    width: calc(100% - 50px);\r\n}\r\n\r\n.ocrscan-container .upload-button{\r\n    padding: 2px 7px;\r\n    margin-left: 5px;\r\n}\r\n\r\n.uploading-dialog {\r\n    min-height: 100px;\r\n    max-height: 100px;\r\n    padding-top: 0;\r\n    margin-top: 20%;\r\n    background-color: white;\r\n}\r\n\r\n.uploading-progress {\r\n    height: 30px;\r\n    margin: 0px 10px;\r\n}\r\n\r\n.uploading-progress-label {\r\n    width: 100%;\r\n    display: block;\r\n    position: absolute;\r\n    text-align: center;\r\n}\r\n\r\n.uploading-progress-label span {\r\n    padding: 2px 5px;\r\n    background-color: #e4ecf599;\r\n    height: 30px;\r\n    line-height: 30px;\r\n    font-size: 16px;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLWludm9pY2UvY3JlYXRlLWludm9pY2UuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBR0E7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0NBQ0MsWUFBWTtJQUNULHlCQUF5QjtJQUN6QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFVBQVU7SUFDVixpQkFBaUI7QUFDckI7O0FBRUE7Q0FDQyxvQ0FBb0M7Q0FDcEMsWUFBWTtJQUNULG1CQUFtQjtBQUN2Qjs7QUFFQTs7Q0FFQyxhQUFhO0FBQ2Q7O0FBRUE7Q0FDQyx5QkFBeUI7Q0FDekIsV0FBVztBQUNaOztBQUVBO0NBQ0MsWUFBWTtDQUNaLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixpQkFBaUI7QUFDbEI7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osaUJBQWlCO0FBQ2xCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0MsaUJBQWlCO0FBQ2xCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksdUJBQXVCO0lBQ3ZCLFlBQVk7SUFDWixtQkFBbUI7O0FBRXZCOztBQUVBOztJQUVJLFdBQVc7SUFDWCxtQkFBbUI7SUFDbkIsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixlQUFlO0lBQ2YsaUJBQWlCO0lBQ2pCLFlBQVk7QUFDaEI7O0FBRUE7O0lBRUksWUFBWTtBQUNoQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTs7OztDQUlDLHdCQUF3QjtBQUN6Qjs7QUFHQTs7SUFFSSxZQUFZO0FBQ2hCOztBQUVBO0lBQ0ksaUJBQWlCO0lBQ2pCLFdBQVc7QUFDZjs7QUFFQTtDQUNDLFdBQVc7Q0FDWCxZQUFZO0NBQ1osZUFBZTtBQUNoQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLHdCQUF3QjtBQUN6Qjs7QUFFQTtDQUNDLGtCQUFrQjtDQUNsQixhQUFhO0FBQ2Q7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7O0lBRUksd0JBQXdCO0lBQ3hCLFlBQVk7QUFDaEI7O0FBRUE7O0lBRUksVUFBVTtJQUNWLFlBQVk7SUFDWixxQkFBcUI7QUFDekI7O0FBRUE7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0I7O0FBRUE7Q0FDQyxXQUFXO0lBQ1IsaUJBQWlCO0lBQ2pCLGtCQUFrQjtJQUNsQixpQkFBaUI7SUFDakIsa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixhQUFhOztBQUVqQjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGNBQWM7QUFDZjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFHQTtDQUNDLDJCQUEyQjtJQUN4QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLFVBQVU7SUFDVixnQkFBZ0I7SUFDaEIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1oscUJBQXFCO0lBQ3JCLFdBQVc7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0FBQ3JCOztBQUVBO0NBQ0MsWUFBWTtDQUNaLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixZQUFZO0FBQ2I7O0FBRUE7SUFDSSxZQUFZO0lBQ1osWUFBWTtJQUNaLGdCQUFnQjtJQUNoQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSx3QkFBd0I7QUFDNUI7O0FBRUE7SUFDSSx3QkFBd0I7QUFDNUI7O0FBRUE7SUFDSSxnQkFBZ0I7SUFDaEIsZ0JBQWdCO0FBQ3BCOztBQUVBO0lBQ0ksaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixjQUFjO0lBQ2QsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQjs7QUFFQTtJQUNJLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsY0FBYztJQUNkLGtCQUFrQjtJQUNsQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxnQkFBZ0I7SUFDaEIsMkJBQTJCO0lBQzNCLFlBQVk7SUFDWixpQkFBaUI7SUFDakIsZUFBZTtBQUNuQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvY3JlYXRlL2NyZWF0ZS1pbnZvaWNlL2NyZWF0ZS1pbnZvaWNlLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHggNTBweCAwO1xyXG4gICAgYm9yZGVyLXJhZGl1czogMTBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjFmMWYxO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNkYWQ5ZDk7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG59XHJcblxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3Jke1xyXG4gICAgcGFkZGluZzogMTVweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LXJlY29yZHtcclxuXHRmbG9hdDogcmlnaHQ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogOHB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG4gICAgd2lkdGg6IDI1JTtcclxuICAgIG1pbi1oZWlnaHQ6IDUwMHB4O1xyXG59XHJcblxyXG4ud29ya2Zsb3ctY29udGVudCAucGFuZWx7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2YyZjFmMSAhaW1wb3J0YW50O1xyXG5cdHBhZGRpbmc6IDhweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDEwcHg7XHJcbn1cclxuXHJcbi50d29wYW5uZWwgLnBhbmVse1xyXG5cdFxyXG5cdGhlaWdodDogMTkwcHg7XHJcbn1cclxuXHJcbi50d29wYW5uZWwgLnBhbmVsLnBhbmVsLXZlbmRvcntcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMzEwcHgpO1xyXG5cdGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC5wYW5lbC1kaXNjb3VudHtcclxuXHR3aWR0aDogMzAwcHg7XHJcblx0ZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC5wYW5lbC1kaXNjb3VudCBpbnB1dFt0eXBlPXRleHRde1xyXG5cdHdpZHRoOiAxMDBweDtcclxufVxyXG5cclxuLnNtYWxsLWNvbnRlbnR7XHJcblx0d2lkdGg6IDEyMHB4O1xyXG59XHJcblxyXG4uaXRlbS1jb250ZW50IHNlbGVjdHtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn0gXHJcblxyXG4uaXRlbS1jb250ZW50IHNlbGVjdDpub3QoLmZ1bGxyb3cpLCAuaXRlbS1jb250ZW50IGlucHV0W3R5cGU9dGV4dF0ge1xyXG5cdGhlaWdodDogMjZweDtcclxuXHR3aWR0aDogY2FsYygxMDAlKTtcclxufSBcclxuXHJcbi5pdGVtLWNvbnRlbnQgc2VsZWN0LmZ1bGxyb3cge1xyXG5cdGhlaWdodDogMjZweDtcclxuXHR3aWR0aDogY2FsYygxMDAlKTtcclxufSBcclxuXHJcbi5pdGVtLWNvbnRlbnQubGFyZy1jb250ZW50e1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSA0NTBweCk7XHJcbn1cclxuXHJcbi53b3JrZmxvdy1jb250ZW50IC5wYW5lbCAucGFuZWwtaGVhZGluZ3tcclxuXHRmb250LXdlaWdodDogYm9sZDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IHtcclxuICAgIG1hcmdpbjogNXB4IDAgMTBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhciwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXJ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDIwcHg7XHJcbiAgIFxyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWxhYmVse1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAxMHB4O1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBsaW5lLWhlaWdodDogMjVweDtcclxuICAgIGZvbnQtc2l6ZTogMTRweDtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gICAgaGVpZ2h0OiAyNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgLmxhYmVsLWxhcmdlLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyAubGFiZWwtbGFyZ2V7XHJcbiAgICB3aWR0aDogMTUwcHg7XHJcbn1cclxuXHJcbi5sYXJnZS1jb250ZW50e1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSA0MjBweCk7XHJcbn1cclxuXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9dGV4dF0sXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9bnVtYmVyXSxcclxuLmxhcmdlLWNvbnRlbnQgc2VsZWN0LCBcclxuLmxhcmdlLWNvbnRlbnQgYXJlYXRleHR7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDMwcHgpO1xyXG59XHJcblxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IC5zbWFsbC1sYWJlbCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgLnNtYWxsLWxhYmVse1xyXG4gICAgd2lkdGg6IDEyMnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHtcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbi5pdGVtLWNvbnRlbnQgaW5wdXRbdHlwZT1jaGVja2JveF17XHJcblx0d2lkdGg6IDIwcHg7XHJcblx0aGVpZ2h0OiAyMHB4O1x0XHJcblx0bWFyZ2luLXRvcDogM3B4O1xyXG59XHJcblxyXG5kaXYuZnVsbHJvd2Zyb21sYWJlbHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMTUwcHgpO1x0XHJcbn1cclxuXHJcbmRpdi5mdWxscm93ZnJvbWxhYmVsIGlucHV0W3R5cGU9dGV4dF17XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDEwcHgpO1x0XHJcbn1cclxuXHJcbmRpdi5mdWxscm93ZnJvbWxhYmVsIHRleHRhcmVhe1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgKTtcdFxyXG5cdGhlaWdodDogMTAwcHg7XHRcclxufVxyXG5cclxudGV4dGFyZWEuY29tbWVudHMtZnVsbHJvd3tcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMTAwcHgpO1x0XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbi5hc3NpZ24tbGlzdHtcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICB3aWR0aDogMTAwJTtcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgbWF4LWhlaWdodDogMjAwcHg7XHJcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xyXG4gICAgcGFkZGluZy1yaWdodDogMjRweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHBhZGRpbmc6IDJweCA0cHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGJhY2tncm91bmQ6ICNlNmU2ZTY7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDVweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiB7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiBpLm1hdGVyaWFsLWljb25ze1xyXG5cdGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHNwYW4ge1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5zaG93LXNlbGVjdC1kaWFsb2cge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAtMjJweDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcblxyXG4uaW52YWxpZC1yZXF1ZXN0LWNvbnRhaW5lcntcclxuXHR3aWR0aDogNjB2dztcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgbWFyZ2luLWxlZnQ6IGF1dG87XHJcbiAgICBtYXJnaW4tcmlnaHQ6IGF1dG87XHJcbiAgICBtYXJnaW4tdG9wOiAxMHZoO1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuXHRcclxufVxyXG5cclxuLndvcmtmbG93LWZpbGUtdmlldy1saW5rLCAud29ya2Zsb3ctZmlsZS12aWV3LWxpbms6YWN0aXZlLCAud29ya2Zsb3ctZmlsZS12aWV3LWxpbms6dmlzaXRlZHtcclxuXHRjb2xvcjogIzMzMztcclxufVxyXG5cclxuLndvcmtmbG93LWZpbGUtdmlldy1saW5rOmhvdmVye1xyXG5cdGNvbG9yOiAjNTUxMTEzO1xyXG59XHJcblxyXG4ud29ya2Zsb3ctZmlsZS12aWV3LWxpbmsgaS5tYXRlcmlhbC1pY29uc3tcclxuXHR3aWR0aDogMjRweDtcclxufVxyXG5cclxuXHJcbi5hc3NpZ24tbGlzdHtcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICB3aWR0aDogMTAwJTtcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgbWF4LWhlaWdodDogMjAwcHg7XHJcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xyXG4gICAgcGFkZGluZy1yaWdodDogMjRweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHBhZGRpbmc6IDJweCA0cHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGJhY2tncm91bmQ6ICNlNmU2ZTY7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDVweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiB7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiBpLm1hdGVyaWFsLWljb25ze1xyXG5cdGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHNwYW4ge1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5zaG93LXNlbGVjdC1kaWFsb2cge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAtMjBweDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG59XHJcblxyXG5pbnB1dC5zZWxlY3QtZGF0ZXtcclxuXHR3aWR0aDogMTAwcHg7XHJcblx0aGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5pbnB1dC5zaG9ydC1pbnB1dHtcclxuXHR3aWR0aDogMTAwcHg7XHJcblx0aGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG4ub2Nyc2Nhbi1jb250YWluZXIge1xyXG4gICAgd2lkdGg6IDUwMHB4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgcGFkZGluZy10b3A6IDVweDtcclxuICAgIG1hcmdpbi1yaWdodDogMTBweDtcclxufVxyXG5cclxuLm9jcnNjYW4tY29udGFpbmVyIC5jdXN0b20tZmlsZS1pbnB1dHtcclxuICAgIHdpZHRoOiBjYWxjKDEwMCUgLSA1MHB4KTtcclxufVxyXG5cclxuLm9jcnNjYW4tY29udGFpbmVyIC5jdXN0b20tZmlsZS1sYWJlbHtcclxuICAgIHdpZHRoOiBjYWxjKDEwMCUgLSA1MHB4KTtcclxufVxyXG5cclxuLm9jcnNjYW4tY29udGFpbmVyIC51cGxvYWQtYnV0dG9ue1xyXG4gICAgcGFkZGluZzogMnB4IDdweDtcclxuICAgIG1hcmdpbi1sZWZ0OiA1cHg7XHJcbn1cclxuXHJcbi51cGxvYWRpbmctZGlhbG9nIHtcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgbWF4LWhlaWdodDogMTAwcHg7XHJcbiAgICBwYWRkaW5nLXRvcDogMDtcclxuICAgIG1hcmdpbi10b3A6IDIwJTtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG59XHJcblxyXG4udXBsb2FkaW5nLXByb2dyZXNzIHtcclxuICAgIGhlaWdodDogMzBweDtcclxuICAgIG1hcmdpbjogMHB4IDEwcHg7XHJcbn1cclxuXHJcbi51cGxvYWRpbmctcHJvZ3Jlc3MtbGFiZWwge1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIHBvc2l0aW9uOiBhYnNvbHV0ZTtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxufVxyXG5cclxuLnVwbG9hZGluZy1wcm9ncmVzcy1sYWJlbCBzcGFuIHtcclxuICAgIHBhZGRpbmc6IDJweCA1cHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZTRlY2Y1OTk7XHJcbiAgICBoZWlnaHQ6IDMwcHg7XHJcbiAgICBsaW5lLWhlaWdodDogMzBweDtcclxuICAgIGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG4iXX0= */");

/***/ }),

/***/ "./src/app/wm-components/create/create-invoice/create-invoice.component.ts":
/*!*********************************************************************************!*\
  !*** ./src/app/wm-components/create/create-invoice/create-invoice.component.ts ***!
  \*********************************************************************************/
/*! exports provided: CreateInvoiceComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateInvoiceComponent", function() { return CreateInvoiceComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../services/workflow/invoice/invoice-workflow-edit.service */ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _invoice_base_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../invoice-base.component */ "./src/app/wm-components/invoice-base.component.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");














let CreateInvoiceComponent = class CreateInvoiceComponent extends _invoice_base_component__WEBPACK_IMPORTED_MODULE_12__["InvoiceBaseComponent"] {
    constructor(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter, _stompService) {
        super(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter);
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.formBuilder = formBuilder;
        this.dateAdapter = dateAdapter;
        this._stompService = _stompService;
        this.showUploading = false;
        this.uplaodingMessage = "";
        this.uplaodingFileName = "...";
        this.uplaodingMessageUploading = "";
        this.uplaodingMessageFileAnalysing = "";
        this.uplaodingMessageShowResult = "";
        this.intervalId = 0;
        this.intervalValue = 0;
        this.stompClient = null;
        this.onRecevieResponse = (message) => {
            console.log("Message Received: ", message.body);
            var parsedMessage = JSON.parse(message.body);
            if (parsedMessage.status) {
                if (parsedMessage.status === "done") {
                    this.unsubscribe();
                    this.intervalValue += 33;
                    this.uplaodingMessage = this.uplaodingMessageShowResult + " ...";
                }
                if (parsedMessage.status === "error" && parsedMessage.errorMessage) {
                    this.unsubscribe();
                    this.showUploading = false;
                    this.errorService.showError(parsedMessage.errorMessage, parsedMessage.errorDetail);
                }
            }
        };
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
        translate.get('common.uploading').subscribe((res) => {
            this.uplaodingMessageUploading = res;
        });
        translate.get('common.file-analysing').subscribe((res) => {
            this.uplaodingMessageFileAnalysing = res;
        });
        translate.get('common.show-result').subscribe((res) => {
            this.uplaodingMessageShowResult = res;
        });
    }
    get debugData() {
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_13__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_13__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    ngOnInit() {
        super.ngOnInit();
    }
    scanOcrProgress(fileInput) {
        this.ocrScanFile = fileInput.target.files[0];
        this.uplaodingFileName = this.ocrScanFile.name;
    }
    uploadOcrScanFile() {
        this.intervalValue = 0;
        this.showUploading = true;
        this.uplaodingMessage = this.uplaodingMessageUploading + " ...";
        /*this.intervalId = setInterval(() =>{

            this.intervalValue += 10;
            
            if(this.intervalValue >= 70){
                clearInterval(this.intervalId);
                //this.showUploading = false;
            }
            
            
        }, 3000);*/
        this.editService.uploadOcrScanFiles(this.ocrScanFile).subscribe((result) => {
            console.log("upload invoice file result", result);
            this.intervalValue += 33;
            this.uplaodingMessage = this.uplaodingMessageFileAnalysing + " ...";
            this.subscribe();
            this._stompService.publish('/socketapp/ocrprocess', JSON.stringify(result));
        }, response => {
            console.log("Error in upload invoice file", response);
            this.unsubscribe();
            this.showUploading = false;
            this.errorService.showErrorResponse(response);
        }, () => {
            //this.intervalValue = 0;
            //this.showUploading = false;     
        });
    }
    subscribe() {
        if (this.subscribed) {
            this.unsubscribe();
        }
        this.messages = this._stompService.subscribe('/user/socket/ocrprocess');
        this.subscription = this.messages.subscribe(this.onRecevieResponse);
        this.setConnected(true);
    }
    unsubscribe() {
        if (!this.subscribed) {
            return;
        }
        this.subscription.unsubscribe();
        this.subscription = null;
        this.messages = null;
        this.setConnected(false);
    }
    setConnected(subscribed) {
        this.subscribed = subscribed;
    }
    loadInitialData() {
        super.loadInitialData();
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
            this.setToControlValues();
        }
        else {
            this.subscribeToSearchInitialData();
            this.editService.loadCreateInitialData();
        }
    }
    subscribeToSearchInitialData() {
        this.editService.workflowSaveRequestInitSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. : ", data);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (data && data !== null) {
                this.workflowSaveRequest = data.workflowSaveRequest;
                this.setToControlValues();
            }
            else {
                this.workflowSaveRequest = null;
            }
        });
    }
    save() {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.createWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.createWorkflowData();
        }
    }
    createWorkflowData() {
        this.editService.createWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
};
CreateInvoiceComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_8__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_9__["InvoiceWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_11__["ErrorServiceService"] },
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormBuilder"] },
    { type: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"] },
    { type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_7__["StompService"] }
];
CreateInvoiceComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-create-invoice',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./create-invoice.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-invoice/create-invoice.component.html")).default,
        providers: [{ provide: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_13__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_9__["InvoiceWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./create-invoice.component.css */ "./src/app/wm-components/create/create-invoice/create-invoice.component.css")).default]
    })
], CreateInvoiceComponent);



/***/ }),

/***/ "./src/app/wm-components/create/create-singletask/create-singletask.component.css":
/*!****************************************************************************************!*\
  !*** ./src/app/wm-components/create/create-singletask/create-singletask.component.css ***!
  \****************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, div.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input:not(.file-item), \r\ndiv.workflow-content div.item-row div.item-content select,\r\ndiv.workflow-content-record div.item-row div.item-content input, \r\ndiv.workflow-content-record div.item-row div.item-content select\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content textarea,\r\ndiv.workflow-content-record div.item-row div.item-content textarea\r\n{\r\n    width: 100%;\r\n    height: 200px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLXNpbmdsZXRhc2svY3JlYXRlLXNpbmdsZXRhc2suY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTs7O0lBR0ksV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL2NyZWF0ZS9jcmVhdGUtc2luZ2xldGFzay9jcmVhdGUtc2luZ2xldGFzay5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LWNvbnRhaW5lcntcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBtYXJnaW46IDEwcHggMHB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogMTBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjFmMWYxO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNkYWQ5ZDk7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmR7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3csIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cge1xyXG4gICAgbWFyZ2luOiA1cHggMCAxMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFyLCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhcntcclxuICAgIG1hcmdpbi1yaWdodDogMjBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDEzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWx7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyMHB4O1xyXG4gICAgZm9udC1zaXplOiAxNHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgICB3aWR0aDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQge1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDEzNXB4KTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQ6bm90KC5maWxlLWl0ZW0pLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0LFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0XHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLXRpdGxlXHJcbntcclxuICAgIHdpZHRoOiBjYWxjKDUwJSAtIDE3MHB4KTtcclxuICAgIGhlaWdodDogMjZweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS1maWxlXHJcbntcclxuICAgIHdpZHRoOiA1MCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB0ZXh0YXJlYSxcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHRleHRhcmVhXHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyMDBweDtcclxufVxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuYnV0dG9uLmZpbGUtYWN0aW9uIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbWFyZ2luLXRvcDogNHB4O1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/create/create-singletask/create-singletask.component.ts":
/*!***************************************************************************************!*\
  !*** ./src/app/wm-components/create/create-singletask/create-singletask.component.ts ***!
  \***************************************************************************************/
/*! exports provided: CreateSingletaskComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateSingletaskComponent", function() { return CreateSingletaskComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/workflow/singletask/singletask-workflow-edit.service */ "./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");










let CreateSingletaskComponent = class CreateSingletaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService) {
        this.router = router;
        this.global = global;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = null;
        this.users = [];
        this.departments = [];
        this.generalDataObs = null;
        this.fileTitles = [];
        this.showDebug = false;
        this.showAssignModal = false;
        this.selectAssign = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENTGROUP;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
    }
    fileTitleProgress(fileInput, file, fileIndex) {
        if (fileInput.target.files && fileInput.target.files != null && file) {
            file.file = fileInput.target.files[0];
        }
        //this.preview();
    }
    get expireDays() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.expireDays;
        }
        return 0;
    }
    set expireDays(days) {
        if (this.workflowSaveRequest != null) {
            this.workflowSaveRequest.expireDays = days;
        }
    }
    get controllerIdentity() {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            return this.workflowSaveRequest.workflow.controllerIdentity;
        }
        return "";
    }
    set controllerIdentity(value) {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            this.workflowSaveRequest.workflow.controllerIdentity = value;
        }
    }
    get assignedUsers() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.assigns;
        }
        return [];
    }
    get comments() {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            return this.workflowSaveRequest.workflow.comments;
        }
        return "";
    }
    set comments(value) {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            this.workflowSaveRequest.workflow.comments = value;
        }
    }
    get debugData() {
        var ssignstr = (this.workflowSaveRequest && this.workflowSaveRequest.assigns) ? JSON.stringify(this.workflowSaveRequest.assigns) : '--';
        return ssignstr + "<hr>" + JSON.stringify(this.selectAssign);
    }
    ngOnInit() {
        this.loadInitialData();
    }
    loadInitialData() {
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
        }
        else {
            this.subscribeToSearchInitialData();
            this.editService.loadCreateInitialData();
        }
        this.generalDataObs.subscribe((generalData) => {
            this.users = generalData.company.users;
            this.departments = generalData.company.departments;
        });
    }
    subscribeToSearchInitialData() {
        this.editService.workflowSaveRequestInitSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. : ", data);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (data && data !== null) {
                this.workflowSaveRequest = data.workflowSaveRequest;
            }
            else {
                this.workflowSaveRequest = null;
            }
        });
    }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    removeFile(index) {
        this.fileTitles.splice(index, 1);
    }
    addFile() {
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_9__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
    save() {
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.createWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.createWorkflowData();
        }
    }
    createWorkflowData() {
        this.editService.createWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.workflowSaveRequest.assigns) {
            var assign = this.workflowSaveRequest.assigns[index];
            if (this.selectAssign[assign.itemType] === undefined) {
                this.selectAssign[assign.itemType] = [];
            }
            this.selectAssign[assign.itemType][assign.itemIdentity] = true;
        }
        this.showAssignModal = true;
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
        this.hideAssignSelect();
    }
    getAssignItemTitle(item) {
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENTGROUP) {
            for (var index in this.departments) {
                for (var gindex in this.departments[index].departmentGroups) {
                    if (this.departments[index].departmentGroups[gindex].identity === item.itemIdentity) {
                        return this.departments[index].departmentGroups[gindex].title;
                    }
                }
            }
            return 'Unknown!';
        }
    }
};
CreateSingletaskComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__["SingleTaskWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_7__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"] }
];
CreateSingletaskComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-create-singletask',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./create-singletask.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-singletask/create-singletask.component.html")).default,
        providers: [_services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__["SingleTaskWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./create-singletask.component.css */ "./src/app/wm-components/create/create-singletask/create-singletask.component.css")).default]
    })
], CreateSingletaskComponent);



/***/ }),

/***/ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.css":
/*!**********************************************************************************************!*\
  !*** ./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.css ***!
  \**********************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, div.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input:not(.file-item), \r\ndiv.workflow-content div.item-row div.item-content select,\r\ndiv.workflow-content-record div.item-row div.item-content input, \r\ndiv.workflow-content-record div.item-row div.item-content select\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content textarea,\r\ndiv.workflow-content-record div.item-row div.item-content textarea\r\n{\r\n    width: 100%;\r\n    height: 200px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLXRlc3R0aHJlZXRhc2svY3JlYXRlLXRlc3R0aHJlZXRhc2suY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTs7O0lBR0ksV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL2NyZWF0ZS9jcmVhdGUtdGVzdHRocmVldGFzay9jcmVhdGUtdGVzdHRocmVldGFzay5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LWNvbnRhaW5lcntcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBtYXJnaW46IDEwcHggMHB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogMTBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjFmMWYxO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNkYWQ5ZDk7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmR7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3csIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cge1xyXG4gICAgbWFyZ2luOiA1cHggMCAxMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFyLCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhcntcclxuICAgIG1hcmdpbi1yaWdodDogMjBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDEzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWx7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyMHB4O1xyXG4gICAgZm9udC1zaXplOiAxNHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgICB3aWR0aDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQge1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDEzNXB4KTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQ6bm90KC5maWxlLWl0ZW0pLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0LFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0XHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLXRpdGxlXHJcbntcclxuICAgIHdpZHRoOiBjYWxjKDUwJSAtIDE3MHB4KTtcclxuICAgIGhlaWdodDogMjZweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS1maWxlXHJcbntcclxuICAgIHdpZHRoOiA1MCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB0ZXh0YXJlYSxcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHRleHRhcmVhXHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyMDBweDtcclxufVxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuYnV0dG9uLmZpbGUtYWN0aW9uIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbWFyZ2luLXRvcDogNHB4O1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.ts":
/*!*********************************************************************************************!*\
  !*** ./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.ts ***!
  \*********************************************************************************************/
/*! exports provided: CreateTestthreetaskComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "CreateTestthreetaskComponent", function() { return CreateTestthreetaskComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/workflow/testthreetask/testthreetask-workflow-edit.service */ "./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");










let CreateTestthreetaskComponent = class CreateTestthreetaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService) {
        this.router = router;
        this.global = global;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = null;
        this.users = [];
        this.departments = [];
        this.generalDataObs = null;
        this.fileTitles = [];
        this.showDebug = false;
        this.showAssignModal = false;
        this.selectAssign = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENTGROUP;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
    }
    fileTitleProgress(fileInput, file, fileIndex) {
        if (fileInput.target.files && fileInput.target.files != null && file) {
            file.file = fileInput.target.files[0];
        }
        //this.preview();
    }
    get expireDays() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.expireDays;
        }
        return 0;
    }
    set expireDays(days) {
        if (this.workflowSaveRequest != null) {
            this.workflowSaveRequest.expireDays = days;
        }
    }
    get controllerIdentity() {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            return this.workflowSaveRequest.workflow.controllerIdentity;
        }
        return "";
    }
    set controllerIdentity(value) {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            this.workflowSaveRequest.workflow.controllerIdentity = value;
        }
    }
    get assignedUsers() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.assigns;
        }
        return [];
    }
    get comments() {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            return this.workflowSaveRequest.workflow.comments;
        }
        return "";
    }
    set comments(value) {
        if (this.workflowSaveRequest != null && this.workflowSaveRequest.workflow != null) {
            this.workflowSaveRequest.workflow.comments = value;
        }
    }
    get debugData() {
        var ssignstr = (this.workflowSaveRequest && this.workflowSaveRequest.assigns) ? JSON.stringify(this.workflowSaveRequest.assigns) : '--';
        return ssignstr + "<hr>" + JSON.stringify(this.selectAssign);
    }
    ngOnInit() {
        this.loadInitialData();
    }
    loadInitialData() {
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
        }
        else {
            this.subscribeToSearchInitialData();
            this.editService.loadCreateInitialData();
        }
        /*if(this.global.loadedGeneralData !== null){
            this.users = this.global.loadedGeneralData.company.users;
            this.departments = this.global.loadedGeneralData.company.departments;
        }
        else{
            this.subscribeToGeneralData();
            this.global.loadAllSetting(null);
        }*/
    }
    subscribeToSearchInitialData() {
        this.editService.workflowSaveRequestInitSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. : ", data);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (data && data !== null) {
                this.workflowSaveRequest = data.workflowSaveRequest;
            }
            else {
                this.workflowSaveRequest = null;
            }
        });
        this.generalDataObs.subscribe((generalData) => {
            this.users = generalData.company.users;
            this.departments = generalData.company.departments;
        });
    }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    removeFile(index) {
        this.fileTitles.splice(index, 1);
    }
    addFile() {
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_9__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
    save() {
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.createWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.createWorkflowData();
        }
    }
    createWorkflowData() {
        this.editService.createWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.workflowSaveRequest.assigns) {
            var assign = this.workflowSaveRequest.assigns[index];
            if (this.selectAssign[assign.itemType] === undefined) {
                this.selectAssign[assign.itemType] = [];
            }
            this.selectAssign[assign.itemType][assign.itemIdentity] = true;
        }
        this.showAssignModal = true;
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
        this.hideAssignSelect();
    }
    getAssignItemTitle(item) {
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_9__["AssignType"].DEPARTMENTGROUP) {
            for (var index in this.departments) {
                for (var gindex in this.departments[index].departmentGroups) {
                    if (this.departments[index].departmentGroups[gindex].identity === item.itemIdentity) {
                        return this.departments[index].departmentGroups[gindex].title;
                    }
                }
            }
            return 'Unknown!';
        }
    }
};
CreateTestthreetaskComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__["TestthreetaskWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_7__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"] }
];
CreateTestthreetaskComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-create-testthreetask',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./create-testthreetask.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.html")).default,
        providers: [_services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_6__["TestthreetaskWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./create-testthreetask.component.css */ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.css")).default]
    })
], CreateTestthreetaskComponent);



/***/ }),

/***/ "./src/app/wm-components/create/workflow-create/workflow-create.component.css":
/*!************************************************************************************!*\
  !*** ./src/app/wm-components/create/workflow-create/workflow-create.component.css ***!
  \************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvY3JlYXRlL3dvcmtmbG93LWNyZWF0ZS93b3JrZmxvdy1jcmVhdGUuY29tcG9uZW50LmNzcyJ9 */");

/***/ }),

/***/ "./src/app/wm-components/create/workflow-create/workflow-create.component.ts":
/*!***********************************************************************************!*\
  !*** ./src/app/wm-components/create/workflow-create/workflow-create.component.ts ***!
  \***********************************************************************************/
/*! exports provided: WorkflowCreateComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowCreateComponent", function() { return WorkflowCreateComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");





let WorkflowCreateComponent = class WorkflowCreateComponent {
    constructor(router, global, translate) {
        this.router = router;
        this.global = global;
        this.worlflowTypes = [];
    }
    ngOnInit() {
        this.worlflowTypes = this.global.loadedGeneralData.workflow.worlflowTypes;
    }
};
WorkflowCreateComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }
];
WorkflowCreateComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-workflow-create',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-create.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/create/workflow-create/workflow-create.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-create.component.css */ "./src/app/wm-components/create/workflow-create/workflow-create.component.css")).default]
    })
], WorkflowCreateComponent);



/***/ }),

/***/ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.css":
/*!****************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-invoice/edit-invoice.component.css ***!
  \****************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px 50px 0;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 690px;\r\n}\r\n\r\ndiv.workflow-record{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 690px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\n.workflow-content .panel{\r\n\tbackground-color: #f2f1f1 !important;\r\n\tpadding: 8px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.twopannel .panel{\r\n\t\r\n\theight: 190px;\r\n}\r\n\r\n.twopannel .panel.panel-vendor{\r\n\twidth: calc(100% - 310px);\r\n\tfloat: left;\r\n}\r\n\r\n.twopannel .panel.panel-discount{\r\n\twidth: 300px;\r\n\tfloat: right;\r\n}\r\n\r\n.twopannel .panel.panel-discount input[type=text]{\r\n\twidth: 100px;\r\n}\r\n\r\n.small-content{\r\n\twidth: 120px;\r\n}\r\n\r\n.item-content select{\r\n\theight: 26px;\r\n}\r\n\r\n.item-content select:not(.fullrow), .item-content input[type=text] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content select.fullrow {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content.larg-content{\r\n\twidth: calc(100% - 450px);\r\n}\r\n\r\n.workflow-content .panel .panel-heading{\r\n\tfont-weight: bold;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    background-color: white;\r\n    padding: 6px;\r\n    padding-right: 20px;\r\n   \r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, \r\ndiv.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 25px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    height: 25px;\r\n}\r\n\r\ndiv.workflow-content div.item-row .label-large, \r\ndiv.workflow-content-record div.item-row .label-large{\r\n    width: 150px;\r\n}\r\n\r\n.large-content{\r\n\twidth: calc(100% - 420px);\r\n}\r\n\r\n.large-content input[type=text],\r\n.large-content input[type=number],\r\n.large-content select, \r\n.large-content areatext{\r\n\twidth: calc(100% - 30px);\r\n}\r\n\r\ndiv.workflow-content div.item-row .small-label, \r\ndiv.workflow-content-record div.item-row .small-label{\r\n    width: 122px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    padding-left: 0px;\r\n    float: left;\r\n}\r\n\r\n.item-content input[type=checkbox]{\r\n\twidth: 20px;\r\n\theight: 20px;\t\r\n\tmargin-top: 3px;\r\n}\r\n\r\ndiv.fullrowfromlabel{\r\n\twidth: calc(100% - 150px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel input[type=text]{\r\n\twidth: calc(100% - 10px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel textarea{\r\n\twidth: calc(100% );\t\r\n\theight: 100px;\t\r\n}\r\n\r\ntextarea.comments-fullrow{\r\n\twidth: calc(100% - 100px);\t\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -22px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n.invalid-request-container{\r\n\twidth: 60vw;\r\n    min-height: 100px;\r\n    text-align: center;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    margin-top: 10vh;\r\n    padding: 10px;\r\n\t\r\n}\r\n\r\n.workflow-file-view-link, .workflow-file-view-link:active, .workflow-file-view-link:visited{\r\n\tcolor: #333;\r\n}\r\n\r\n.workflow-file-view-link:hover{\r\n\tcolor: #551113;\r\n}\r\n\r\n.workflow-file-view-link i.material-icons{\r\n\twidth: 24px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n}\r\n\r\ninput.select-date{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\ninput.short-input{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtaW52b2ljZS9lZGl0LWludm9pY2UuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7SUFDbEIseUJBQXlCO0lBQ3pCLFdBQVc7SUFDWCxhQUFhO0FBQ2pCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7SUFDbEIsWUFBWTtJQUNaLFlBQVk7SUFDWixhQUFhO0FBQ2pCOztBQUdBO0lBQ0ksYUFBYTtBQUNqQjs7QUFFQTtDQUNDLG9DQUFvQztDQUNwQyxZQUFZO0lBQ1QsbUJBQW1CO0FBQ3ZCOztBQUVBOztDQUVDLGFBQWE7QUFDZDs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixXQUFXO0FBQ1o7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtBQUNsQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixpQkFBaUI7QUFDbEI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyxpQkFBaUI7QUFDbEI7O0FBRUE7SUFDSSxrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSx1QkFBdUI7SUFDdkIsWUFBWTtJQUNaLG1CQUFtQjs7QUFFdkI7O0FBRUE7O0lBRUksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxZQUFZO0FBQ2hCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUdBOzs7O0NBSUMsd0JBQXdCO0FBQ3pCOztBQUVBOztJQUVJLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxpQkFBaUI7SUFDakIsV0FBVztBQUNmOztBQUVBO0NBQ0MsV0FBVztDQUNYLFlBQVk7Q0FDWixlQUFlO0FBQ2hCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0Msd0JBQXdCO0FBQ3pCOztBQUVBO0NBQ0Msa0JBQWtCO0NBQ2xCLGFBQWE7QUFDZDs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTtDQUNDLDJCQUEyQjtJQUN4QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLFVBQVU7SUFDVixnQkFBZ0I7SUFDaEIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1oscUJBQXFCO0lBQ3JCLFdBQVc7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLFlBQVk7SUFDWixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQjs7QUFFQTtDQUNDLFdBQVc7SUFDUixpQkFBaUI7SUFDakIsa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQixrQkFBa0I7SUFDbEIsZ0JBQWdCO0lBQ2hCLGFBQWE7O0FBRWpCOztBQUVBO0NBQ0MsV0FBVztBQUNaOztBQUVBO0NBQ0MsY0FBYztBQUNmOztBQUVBO0NBQ0MsV0FBVztBQUNaOztBQUdBO0NBQ0MsMkJBQTJCO0lBQ3hCLFlBQVk7SUFDWixrQkFBa0I7SUFDbEIsV0FBVztJQUNYLGlCQUFpQjtJQUNqQixpQkFBaUI7SUFDakIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtBQUN2Qjs7QUFFQTtJQUNJLDJCQUEyQjtJQUMzQixrQkFBa0I7SUFDbEIsZ0JBQWdCO0lBQ2hCLFdBQVc7SUFDWCxtQkFBbUI7SUFDbkIsaUJBQWlCO0lBQ2pCLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLFlBQVk7SUFDWix1QkFBdUI7SUFDdkIsVUFBVTtJQUNWLGdCQUFnQjtJQUNoQixZQUFZO0lBQ1osZ0JBQWdCO0FBQ3BCOztBQUVBO0NBQ0MsZUFBZTtBQUNoQjs7QUFFQTtJQUNJLFlBQVk7SUFDWixxQkFBcUI7SUFDckIsV0FBVztBQUNmOztBQUVBO0lBQ0ksWUFBWTtJQUNaLG1CQUFtQjtJQUNuQixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7QUFDckI7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtDQUNaLFlBQVk7QUFDYiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvZWRpdC9lZGl0LWludm9pY2UvZWRpdC1pbnZvaWNlLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHggNTBweCAwO1xyXG4gICAgYm9yZGVyLXJhZGl1czogMTBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZjFmMWYxO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNkYWQ5ZDk7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDMxMHB4KTtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgaGVpZ2h0OiA2OTBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LXJlY29yZHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNkYWQ5ZDk7XHJcbiAgICBwYWRkaW5nOiAxMHB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG4gICAgd2lkdGg6IDMwMHB4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgaGVpZ2h0OiA2OTBweDtcclxufVxyXG5cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbi53b3JrZmxvdy1jb250ZW50IC5wYW5lbHtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjZjJmMWYxICFpbXBvcnRhbnQ7XHJcblx0cGFkZGluZzogOHB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogMTBweDtcclxufVxyXG5cclxuLnR3b3Bhbm5lbCAucGFuZWx7XHJcblx0XHJcblx0aGVpZ2h0OiAxOTBweDtcclxufVxyXG5cclxuLnR3b3Bhbm5lbCAucGFuZWwucGFuZWwtdmVuZG9ye1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSAzMTBweCk7XHJcblx0ZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbi50d29wYW5uZWwgLnBhbmVsLnBhbmVsLWRpc2NvdW50e1xyXG5cdHdpZHRoOiAzMDBweDtcclxuXHRmbG9hdDogcmlnaHQ7XHJcbn1cclxuXHJcbi50d29wYW5uZWwgLnBhbmVsLnBhbmVsLWRpc2NvdW50IGlucHV0W3R5cGU9dGV4dF17XHJcblx0d2lkdGg6IDEwMHB4O1xyXG59XHJcblxyXG4uc21hbGwtY29udGVudHtcclxuXHR3aWR0aDogMTIwcHg7XHJcbn1cclxuXHJcbi5pdGVtLWNvbnRlbnQgc2VsZWN0e1xyXG5cdGhlaWdodDogMjZweDtcclxufSBcclxuXHJcbi5pdGVtLWNvbnRlbnQgc2VsZWN0Om5vdCguZnVsbHJvdyksIC5pdGVtLWNvbnRlbnQgaW5wdXRbdHlwZT10ZXh0XSB7XHJcblx0aGVpZ2h0OiAyNnB4O1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUpO1xyXG59IFxyXG5cclxuLml0ZW0tY29udGVudCBzZWxlY3QuZnVsbHJvdyB7XHJcblx0aGVpZ2h0OiAyNnB4O1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUpO1xyXG59IFxyXG5cclxuLml0ZW0tY29udGVudC5sYXJnLWNvbnRlbnR7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDQ1MHB4KTtcclxufVxyXG5cclxuLndvcmtmbG93LWNvbnRlbnQgLnBhbmVsIC5wYW5lbC1oZWFkaW5ne1xyXG5cdGZvbnQtd2VpZ2h0OiBib2xkO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3csIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cge1xyXG4gICAgbWFyZ2luOiA1cHggMCAxMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFyLCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhcntcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgcGFkZGluZy1yaWdodDogMjBweDtcclxuICAgXHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWx7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyNXB4O1xyXG4gICAgZm9udC1zaXplOiAxNHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgICBoZWlnaHQ6IDI1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyAubGFiZWwtbGFyZ2UsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IC5sYWJlbC1sYXJnZXtcclxuICAgIHdpZHRoOiAxNTBweDtcclxufVxyXG5cclxuLmxhcmdlLWNvbnRlbnR7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDQyMHB4KTtcclxufVxyXG5cclxuXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9dGV4dF0sXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9bnVtYmVyXSxcclxuLmxhcmdlLWNvbnRlbnQgc2VsZWN0LCBcclxuLmxhcmdlLWNvbnRlbnQgYXJlYXRleHR7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDMwcHgpO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgLnNtYWxsLWxhYmVsLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyAuc21hbGwtbGFiZWx7XHJcbiAgICB3aWR0aDogMTIycHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQge1xyXG4gICAgcGFkZGluZy1sZWZ0OiAwcHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuLml0ZW0tY29udGVudCBpbnB1dFt0eXBlPWNoZWNrYm94XXtcclxuXHR3aWR0aDogMjBweDtcclxuXHRoZWlnaHQ6IDIwcHg7XHRcclxuXHRtYXJnaW4tdG9wOiAzcHg7XHJcbn1cclxuXHJcbmRpdi5mdWxscm93ZnJvbWxhYmVse1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSAxNTBweCk7XHRcclxufVxyXG5cclxuZGl2LmZ1bGxyb3dmcm9tbGFiZWwgaW5wdXRbdHlwZT10ZXh0XXtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMTBweCk7XHRcclxufVxyXG5cclxuZGl2LmZ1bGxyb3dmcm9tbGFiZWwgdGV4dGFyZWF7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSApO1x0XHJcblx0aGVpZ2h0OiAxMDBweDtcdFxyXG59XHJcblxyXG50ZXh0YXJlYS5jb21tZW50cy1mdWxscm93e1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSAxMDBweCk7XHRcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS10aXRsZVxyXG57XHJcbiAgICB3aWR0aDogY2FsYyg1MCUgLSAxNzBweCk7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtZmlsZVxyXG57XHJcbiAgICB3aWR0aDogNTAlO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrOztcclxufVxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMnB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuYnV0dG9uLmZpbGUtYWN0aW9uIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbWFyZ2luLXRvcDogNHB4O1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbn1cclxuXHJcbi5pbnZhbGlkLXJlcXVlc3QtY29udGFpbmVye1xyXG5cdHdpZHRoOiA2MHZ3O1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbiAgICBtYXJnaW4tbGVmdDogYXV0bztcclxuICAgIG1hcmdpbi1yaWdodDogYXV0bztcclxuICAgIG1hcmdpbi10b3A6IDEwdmg7XHJcbiAgICBwYWRkaW5nOiAxMHB4O1xyXG5cdFxyXG59XHJcblxyXG4ud29ya2Zsb3ctZmlsZS12aWV3LWxpbmssIC53b3JrZmxvdy1maWxlLXZpZXctbGluazphY3RpdmUsIC53b3JrZmxvdy1maWxlLXZpZXctbGluazp2aXNpdGVke1xyXG5cdGNvbG9yOiAjMzMzO1xyXG59XHJcblxyXG4ud29ya2Zsb3ctZmlsZS12aWV3LWxpbms6aG92ZXJ7XHJcblx0Y29sb3I6ICM1NTExMTM7XHJcbn1cclxuXHJcbi53b3JrZmxvdy1maWxlLXZpZXctbGluayBpLm1hdGVyaWFsLWljb25ze1xyXG5cdHdpZHRoOiAyNHB4O1xyXG59XHJcblxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbn1cclxuXHJcbmlucHV0LnNlbGVjdC1kYXRle1xyXG5cdHdpZHRoOiAxMDBweDtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmlucHV0LnNob3J0LWlucHV0e1xyXG5cdHdpZHRoOiAxMDBweDtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcblxyXG4iXX0= */");

/***/ }),

/***/ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.ts":
/*!***************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-invoice/edit-invoice.component.ts ***!
  \***************************************************************************/
/*! exports provided: EditInvoiceComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EditInvoiceComponent", function() { return EditInvoiceComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/workflow/invoice/invoice-workflow-edit.service */ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _invoice_base_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../invoice-base.component */ "./src/app/wm-components/invoice-base.component.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");













let EditInvoiceComponent = class EditInvoiceComponent extends _invoice_base_component__WEBPACK_IMPORTED_MODULE_11__["InvoiceBaseComponent"] {
    constructor(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter, route) {
        super(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter);
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.formBuilder = formBuilder;
        this.dateAdapter = dateAdapter;
        this.route = route;
        this.workflowIdentity = "not-set";
        this.saveMessage = "";
        this.viewWorkflowModel = null;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.workflowIdentity = this.route.snapshot.params['identity'];
                this.loadInitialData();
            }
        });
    }
    get canSave() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canSave;
        }
        return false;
    }
    get canDone() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canDone;
        }
        return false;
    }
    get canArchive() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canArchive;
        }
        return false;
    }
    get canAssign() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canAssign;
        }
        return true;
    }
    get debugData() {
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_12__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_12__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    ngOnInit() {
        super.ngOnInit();
    }
    loadInitialData() {
        super.loadInitialData();
        if (this.workflowIdentity == '') {
            return;
        }
        this.loadWorkflowData();
    }
    loadWorkflowData() {
        this.loadingService.showLoading();
        this.editService.loadEditInitialData(this.workflowIdentity).subscribe((initialData) => {
            console.log("set inital-data from workflow-edit. : ", initialData);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (initialData && initialData !== null) {
                this.workflowSaveRequest = initialData.workflowSaveRequest;
                this.viewWorkflowModel = this.workflowSaveRequest.workflow;
                this.setToControlValues();
            }
            else {
                this.workflowSaveRequest = null;
            }
        }, response => {
            console.log("Error in read edit inital data", response);
            this.errorService.showErrorResponse(response);
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    save(makeDone) {
        this.setFormControlValues();
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                if (makeDone) {
                    this.doneWorkflowData();
                }
                else {
                    this.saveWorkflowData();
                }
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            if (makeDone) {
                this.doneWorkflowData();
            }
            else {
                this.saveWorkflowData();
            }
        }
    }
    archive() {
        this.setFormControlValues();
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.archiveWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.archiveWorkflowData();
        }
    }
    saveWorkflowData() {
        this.saveMessage = "";
        this.editService.saveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.translate.get('common.saved').subscribe((res) => {
                this.saveMessage = res;
            });
            this.loadWorkflowData();
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    doneWorkflowData() {
        this.editService.doneWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    archiveWorkflowData() {
        this.editService.archiveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
};
EditInvoiceComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["InvoiceWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__["ErrorServiceService"] },
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormBuilder"] },
    { type: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] }
];
EditInvoiceComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-edit-invoice',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./edit-invoice.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-invoice/edit-invoice.component.html")).default,
        providers: [{ provide: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_12__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["InvoiceWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./edit-invoice.component.css */ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.css")).default]
    })
], EditInvoiceComponent);



/***/ }),

/***/ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.css":
/*!************************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-single-task/edit-single-task.component.css ***!
  \************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-record{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, div.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input:not(.file-item), \r\ndiv.workflow-content div.item-row div.item-content select,\r\ndiv.workflow-content-record div.item-row div.item-content input, \r\ndiv.workflow-content-record div.item-row div.item-content select\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content textarea,\r\ndiv.workflow-content-record div.item-row div.item-content textarea\r\n{\r\n    width: 100%;\r\n    height: 200px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtc2luZ2xlLXRhc2svZWRpdC1zaW5nbGUtdGFzay5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLDJCQUEyQjtJQUN4QixnQkFBZ0I7SUFDaEIsbUJBQW1CO0lBQ25CLGFBQWE7SUFDYix5QkFBeUI7QUFDN0I7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQix5QkFBeUI7SUFDekIsV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQixZQUFZO0lBQ1osWUFBWTtJQUNaLGFBQWE7QUFDakI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTs7O0lBR0ksV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL2VkaXQvZWRpdC1zaW5nbGUtdGFzay9lZGl0LXNpbmdsZS10YXNrLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMzEwcHgpO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBoZWlnaHQ6IDUzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctcmVjb3Jke1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogMzAwcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBoZWlnaHQ6IDUzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmR7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3csIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cge1xyXG4gICAgbWFyZ2luOiA1cHggMCAxMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFyLCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhcntcclxuICAgIG1hcmdpbi1yaWdodDogMjBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDEzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWx7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyMHB4O1xyXG4gICAgZm9udC1zaXplOiAxNHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgICB3aWR0aDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQge1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDEzNXB4KTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQ6bm90KC5maWxlLWl0ZW0pLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0LFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0XHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLXRpdGxlXHJcbntcclxuICAgIHdpZHRoOiBjYWxjKDUwJSAtIDE3MHB4KTtcclxuICAgIGhlaWdodDogMjZweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS1maWxlXHJcbntcclxuICAgIHdpZHRoOiA1MCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB0ZXh0YXJlYSxcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHRleHRhcmVhXHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyMDBweDtcclxufVxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuYnV0dG9uLmZpbGUtYWN0aW9uIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbWFyZ2luLXRvcDogNHB4O1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.ts":
/*!***********************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-single-task/edit-single-task.component.ts ***!
  \***********************************************************************************/
/*! exports provided: EditSingleTaskComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EditSingleTaskComponent", function() { return EditSingleTaskComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/workflow/singletask/singletask-workflow-edit.service */ "./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../wf-models/workflow-save-request */ "./src/app/wf-models/workflow-save-request.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");














let EditSingleTaskComponent = class EditSingleTaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter, route) {
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.formBuilder = formBuilder;
        this.dateAdapter = dateAdapter;
        this.route = route;
        this.saveMessage = "";
        this.workflowIdentity = "";
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = new _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_12__["WorkflowSaveRequest"]();
        this.viewWorkflowModel = null;
        this.users = [];
        this.departments = [];
        this.fileTitles = [];
        this.showAssignModal = false;
        this.selectAssign = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENTGROUP;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.workflowIdentity = this.route.snapshot.params['identity'];
                this.loadInitialData();
            }
        });
        this.dateAdapter.setLocale('de');
    }
    fileTitleProgress(fileInput, file, fileIndex) {
        if (fileInput.target.files && fileInput.target.files != null && file) {
            file.file = fileInput.target.files[0];
        }
        //this.preview();
    }
    get assignedUsers() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.assigns;
        }
        return [];
    }
    get debugData() {
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_13__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_13__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    get isWorkflowDone() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.isDone;
        }
        return false;
    }
    get isWorkflowInLastStep() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.isLastStep;
        }
        return false;
    }
    get canSave() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canSave;
        }
        return false;
    }
    get canDone() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canDone;
        }
        return false;
    }
    get canArchive() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canArchive;
        }
        return false;
    }
    get canAssign() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canAssign;
        }
        return true;
    }
    ngOnInit() {
        this.workflowEditForm = this.formBuilder.group({
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required],
            controllerIdentity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required],
            comments: [''],
        });
    }
    reload() {
        this.loadInitialData();
    }
    loadInitialData() {
        if (this.workflowIdentity == '') {
            return;
        }
        if (this.global.loadedGeneralData !== null) {
            this.users = this.global.loadedGeneralData.company.users;
            this.departments = this.global.loadedGeneralData.company.departments;
        }
        else {
            this.subscribeToGeneralData();
            this.global.loadAllSetting(null);
        }
        this.loadWorkflowData();
    }
    loadWorkflowData() {
        this.loadingService.showLoading();
        this.editService.loadEditInitialData(this.workflowIdentity).subscribe((initialData) => {
            console.log("set inital-data from workflow-edit. : ", initialData);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (initialData && initialData !== null) {
                this.workflowSaveRequest = initialData.workflowSaveRequest;
                this.viewWorkflowModel = this.workflowSaveRequest.workflow;
                this.setToControlValues();
            }
            else {
                this.workflowSaveRequest = null;
            }
        }, response => {
            console.log("Error in read edit inital data", response);
            this.errorService.showErrorResponse(response);
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    setToControlValues() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.workflow) {
            this.workflowEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
            this.workflowEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
            this.workflowEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
        }
    }
    setFormControlValues() {
        this.workflowSaveRequest.expireDays = this.workflowEditForm.controls["expireDays"].value;
        this.workflowSaveRequest.workflow.controllerIdentity = this.workflowEditForm.controls["controllerIdentity"].value;
        this.workflowSaveRequest.workflow.comments = this.workflowEditForm.controls["comments"].value;
    }
    get forms() { return this.workflowEditForm.controls; }
    subscribeToGeneralData() {
        this.global.currentSessionDataSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. appIsLogged: ");
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (data && data !== null) {
                var value = data.isLogged + "";
                if (value === "true" === true) {
                    this.users = data.company.users;
                    this.departments = data.company.departments;
                }
                else {
                    this.users = [];
                    this.departments = [];
                }
            }
            else {
                this.users = [];
                this.departments = [];
            }
        });
    }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    removeFile(index) {
        this.fileTitles.splice(index, 1);
    }
    addFile() {
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_11__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
    save(makeDone) {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                if (makeDone) {
                    this.doneWorkflowData();
                }
                else {
                    this.saveWorkflowData();
                }
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            if (makeDone) {
                this.doneWorkflowData();
            }
            else {
                this.saveWorkflowData();
            }
        }
    }
    archive() {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.archiveWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.archiveWorkflowData();
        }
    }
    saveWorkflowData() {
        this.editService.saveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.translate.get('common.saved').subscribe((res) => {
                this.saveMessage = res;
            });
            this.loadWorkflowData();
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    doneWorkflowData() {
        this.editService.doneWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    archiveWorkflowData() {
        this.editService.archiveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    isItemAssigned(identity, type) {
        if (this.selectAssign[type] === undefined) {
            this.selectAssign[type] = [];
        }
        if (this.selectAssign[type][identity] === undefined) {
            this.selectAssign[type][identity] = false;
        }
        return this.selectAssign[type][identity];
    }
    applyUserSelect() {
        this.workflowSaveRequest.assigns = [];
        for (var type in this.selectAssign) {
            for (var identity in this.selectAssign[type]) {
                if (this.selectAssign[type][identity]) {
                    var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignItem"];
                    assign.itemIdentity = identity;
                    assign.itemType = type;
                    this.workflowSaveRequest.assigns.push(assign);
                }
            }
        }
        this.hideAssignSelect();
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.workflowSaveRequest.assigns) {
            var assign = this.workflowSaveRequest.assigns[index];
            if (this.selectAssign[assign.itemType] === undefined) {
                this.selectAssign[assign.itemType] = [];
            }
            this.selectAssign[assign.itemType][assign.itemIdentity] = true;
        }
        this.showAssignModal = true;
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    toggleAssign(identity, type, isChecked) {
        if (this.selectAssign[type] === undefined) {
            this.selectAssign[type] = [];
        }
        this.selectAssign[type][identity] = isChecked;
    }
    getAssignItemTitle(item) {
        //assign.itemIdentity = <string>identity;
        //assign.itemType = <AssignType>type;
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENTGROUP) {
            for (var index in this.departments) {
                for (var gindex in this.departments[index].departmentGroups) {
                    if (this.departments[index].departmentGroups[gindex].identity === item.itemIdentity) {
                        return this.departments[index].departmentGroups[gindex].title;
                    }
                }
            }
            return 'Unknown!';
        }
    }
};
EditSingleTaskComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["SingleTaskWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__["ErrorServiceService"] },
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormBuilder"] },
    { type: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] }
];
EditSingleTaskComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-edit-single-task',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./edit-single-task.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-single-task/edit-single-task.component.html")).default,
        providers: [{ provide: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_13__["GermanDateAdapter"] }, _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["SingleTaskWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./edit-single-task.component.css */ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.css")).default]
    })
], EditSingleTaskComponent);



/***/ }),

/***/ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.css":
/*!******************************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.css ***!
  \******************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\ndiv.workflow-content-container{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-record{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-content-record{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content div.item-row, div.workflow-content-record div.item-row {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content div.workflow-step-button-bar, div.workflow-content-record div.workflow-step-button-bar{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-label, div.workflow-content-record div.item-row div.item-label{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content, div.workflow-content-record div.item-row div.item-content {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input:not(.file-item), \r\ndiv.workflow-content div.item-row div.item-content select,\r\ndiv.workflow-content-record div.item-row div.item-content input, \r\ndiv.workflow-content-record div.item-row div.item-content select\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-title\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content input.file-file\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\ndiv.workflow-content div.item-row div.item-content textarea,\r\ndiv.workflow-content-record div.item-row div.item-content textarea\r\n{\r\n    width: 100%;\r\n    height: 200px;\r\n}\r\n\r\n.assign-list{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box button i.material-icons{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list div.user-item-box span {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtdGVzdHRocmVlLXRhc2svZWRpdC10ZXN0dGhyZWUtdGFzay5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLDJCQUEyQjtJQUN4QixnQkFBZ0I7SUFDaEIsbUJBQW1CO0lBQ25CLGFBQWE7SUFDYix5QkFBeUI7QUFDN0I7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQix5QkFBeUI7SUFDekIsV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQixZQUFZO0lBQ1osWUFBWTtJQUNaLGFBQWE7QUFDakI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTs7O0lBR0ksV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQiw2QkFBNkI7QUFDakM7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0IiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL2VkaXQvZWRpdC10ZXN0dGhyZWUtdGFzay9lZGl0LXRlc3R0aHJlZS10YXNrLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMzEwcHgpO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBoZWlnaHQ6IDUzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctcmVjb3Jke1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogMzAwcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBoZWlnaHQ6IDUzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmR7XHJcbiAgICBwYWRkaW5nOiAxNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3csIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cge1xyXG4gICAgbWFyZ2luOiA1cHggMCAxMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFyLCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhcntcclxuICAgIG1hcmdpbi1yaWdodDogMjBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDEzMHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWx7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyMHB4O1xyXG4gICAgZm9udC1zaXplOiAxNHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IGJvbGQ7XHJcbiAgICB3aWR0aDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQge1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDEzNXB4KTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQ6bm90KC5maWxlLWl0ZW0pLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0LFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgc2VsZWN0XHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLXRpdGxlXHJcbntcclxuICAgIHdpZHRoOiBjYWxjKDUwJSAtIDE3MHB4KTtcclxuICAgIGhlaWdodDogMjZweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS1maWxlXHJcbntcclxuICAgIHdpZHRoOiA1MCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB0ZXh0YXJlYSxcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHRleHRhcmVhXHJcbntcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgaGVpZ2h0OiAyMDBweDtcclxufVxyXG5cclxuLmFzc2lnbi1saXN0e1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHdpZHRoOiAxMDAlO1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyNHB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3gge1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgcGFkZGluZzogMnB4IDRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgYmFja2dyb3VuZDogI2U2ZTZlNjtcclxuICAgIG1hcmdpbi1yaWdodDogNXB4O1xyXG4gICAgbWFyZ2luLWJvdHRvbTogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggYnV0dG9uIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0Zm9udC1zaXplOiAxNnB4O1xyXG59XHJcblxyXG5kaXYuYXNzaWduLWxpc3QgZGl2LnVzZXItaXRlbS1ib3ggc3BhbiB7XHJcbiAgICBoZWlnaHQ6IDIwcHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7XHJcbiAgICBmbG9hdDogbGVmdDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuYnV0dG9uLmZpbGUtYWN0aW9uIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbWFyZ2luLXRvcDogNHB4O1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.ts":
/*!*****************************************************************************************!*\
  !*** ./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.ts ***!
  \*****************************************************************************************/
/*! exports provided: EditTestthreeTaskComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "EditTestthreeTaskComponent", function() { return EditTestthreeTaskComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _angular_material__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/material */ "./node_modules/@angular/material/esm2015/material.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/workflow/testthreetask/testthreetask-workflow-edit.service */ "./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../wf-models/workflow-save-request */ "./src/app/wf-models/workflow-save-request.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");














let EditTestthreeTaskComponent = class EditTestthreeTaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter, route) {
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.formBuilder = formBuilder;
        this.dateAdapter = dateAdapter;
        this.route = route;
        this.saveMessage = "";
        this.workflowIdentity = "";
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = new _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_12__["WorkflowSaveRequest"]();
        this.viewWorkflowModel = null;
        this.users = [];
        this.departments = [];
        this.generalDataObs = null;
        this.fileTitles = [];
        this.showAssignModal = false;
        this.selectAssign = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENTGROUP;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.workflowIdentity = this.route.snapshot.params['identity'];
                this.loadInitialData();
            }
        });
        this.dateAdapter.setLocale('de');
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
    }
    fileTitleProgress(fileInput, file, fileIndex) {
        if (fileInput.target.files && fileInput.target.files != null && file) {
            file.file = fileInput.target.files[0];
        }
        //this.preview();
    }
    get assignedUsers() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.assigns;
        }
        return [];
    }
    get debugData() {
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_13__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_13__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    get isWorkflowDone() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.isDone;
        }
        return false;
    }
    get isWorkflowInLastStep() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.isLastStep;
        }
        return false;
    }
    get canSave() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canSave;
        }
        return false;
    }
    get canDone() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canDone;
        }
        return false;
    }
    get canArchive() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canArchive;
        }
        return false;
    }
    get canAssign() {
        if (this.workflowSaveRequest.workflow) {
            return this.workflowSaveRequest.workflow.canAssign;
        }
        return true;
    }
    ngOnInit() {
        this.workflowEditForm = this.formBuilder.group({
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required],
            controllerIdentity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_5__["Validators"].required],
            comments: [''],
        });
    }
    reload() {
        this.loadInitialData();
    }
    loadInitialData() {
        if (this.workflowIdentity == '') {
            return;
        }
        this.generalDataObs.subscribe((generalData) => {
            this.users = generalData.company.users;
            this.departments = generalData.company.departments;
        });
        this.loadWorkflowData();
    }
    loadWorkflowData() {
        this.loadingService.showLoading();
        this.editService.loadEditInitialData(this.workflowIdentity).subscribe((initialData) => {
            console.log("set inital-data from workflow-edit. : ", initialData);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (initialData && initialData !== null) {
                this.workflowSaveRequest = initialData.workflowSaveRequest;
                this.viewWorkflowModel = this.workflowSaveRequest.workflow;
                this.setToControlValues();
            }
            else {
                this.workflowSaveRequest = null;
            }
        }, response => {
            console.log("Error in read edit inital data", response);
            this.errorService.showErrorResponse(response);
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    setToControlValues() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.workflow) {
            this.workflowEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
            this.workflowEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
            this.workflowEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
        }
    }
    setFormControlValues() {
        this.workflowSaveRequest.expireDays = this.workflowEditForm.controls["expireDays"].value;
        this.workflowSaveRequest.workflow.controllerIdentity = this.workflowEditForm.controls["controllerIdentity"].value;
        this.workflowSaveRequest.workflow.comments = this.workflowEditForm.controls["comments"].value;
    }
    get forms() { return this.workflowEditForm.controls; }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    removeFile(index) {
        this.fileTitles.splice(index, 1);
    }
    addFile() {
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_11__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
    save(makeDone) {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                if (makeDone) {
                    this.doneWorkflowData();
                }
                else {
                    this.saveWorkflowData();
                }
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            if (makeDone) {
                this.doneWorkflowData();
            }
            else {
                this.saveWorkflowData();
            }
        }
    }
    archive() {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (this.fileTitles.length > 0) {
            this.editService.uploadFiles(this.fileTitles).subscribe((result) => {
                console.log("Create workflow upload file result", result);
                this.workflowSaveRequest.sessionKey = result.sessionKey;
                this.archiveWorkflowData();
            }, response => {
                console.log("Error in create workflow upload file", response);
                this.loadingService.hideLoading();
                this.errorService.showErrorResponse(response);
            }, () => {
            });
        }
        else {
            this.workflowSaveRequest.sessionKey = 'not-set';
            this.archiveWorkflowData();
        }
    }
    saveWorkflowData() {
        this.editService.saveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.translate.get('common.saved').subscribe((res) => {
                this.saveMessage = res;
            });
            this.loadWorkflowData();
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    doneWorkflowData() {
        this.editService.doneWorkflow(this.workflowSaveRequest).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    archiveWorkflowData() {
        this.editService.archiveWorkflow(this.workflowSaveRequest.workflow).subscribe((result) => {
            console.log("Create workflow result", result);
            this.router.navigate([this.workflowListUrl]);
        }, response => {
            console.log("Error in create workflow", response);
            this.errorService.showErrorResponse(response);
            this.loadingService.hideLoading();
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.workflowSaveRequest.assigns) {
            var assign = this.workflowSaveRequest.assigns[index];
            if (this.selectAssign[assign.itemType] === undefined) {
                this.selectAssign[assign.itemType] = [];
            }
            this.selectAssign[assign.itemType][assign.itemIdentity] = true;
        }
        this.showAssignModal = true;
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
        this.hideAssignSelect();
    }
    getAssignItemTitle(item) {
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_11__["AssignType"].DEPARTMENTGROUP) {
            for (var index in this.departments) {
                for (var gindex in this.departments[index].departmentGroups) {
                    if (this.departments[index].departmentGroups[gindex].identity === item.itemIdentity) {
                        return this.departments[index].departmentGroups[gindex].title;
                    }
                }
            }
            return 'Unknown!';
        }
    }
};
EditTestthreeTaskComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["TestthreetaskWorkflowEditService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__["LoadingServiceService"] },
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClient"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__["ErrorServiceService"] },
    { type: _angular_forms__WEBPACK_IMPORTED_MODULE_5__["FormBuilder"] },
    { type: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] }
];
EditTestthreeTaskComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-edit-testthree-task',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./edit-testthree-task.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.html")).default,
        providers: [{ provide: _angular_material__WEBPACK_IMPORTED_MODULE_6__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_13__["GermanDateAdapter"] }, _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_8__["TestthreetaskWorkflowEditService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./edit-testthree-task.component.css */ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.css")).default]
    })
], EditTestthreeTaskComponent);



/***/ }),

/***/ "./src/app/wm-components/invoice-base.component.ts":
/*!*********************************************************!*\
  !*** ./src/app/wm-components/invoice-base.component.ts ***!
  \*********************************************************/
/*! exports provided: InvoiceBaseComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceBaseComponent", function() { return InvoiceBaseComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_invoice_workflow_save_request__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../wf-models/invoice-workflow-save-request */ "./src/app/wf-models/invoice-workflow-save-request.ts");
/* harmony import */ var _custom_validators_invoice_type_controll_validator__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../custom-validators/invoice-type-controll-validator */ "./src/app/custom-validators/invoice-type-controll-validator.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../helper */ "./src/app/helper/index.ts");






class InvoiceBaseComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService, formBuilder, dateAdapter) {
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.formBuilder = formBuilder;
        this.dateAdapter = dateAdapter;
        this.pageTitle = "not-initialized!";
        this.paymentamountOtherTypesTitle = "";
        this.paymentamountTypePaymentTitle = "";
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = new _wf_models_invoice_workflow_save_request__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowSaveRequest"]();
        this.users = [];
        this.departments = [];
        this.generalDataObs = null;
        this.fileTitles = [];
        this.showAssignModal = false;
        this.selectAssign = [];
        this.invoiceTypes = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENTGROUP;
        this.dateAdapter.setLocale('de');
        for (var o in _wf_models__WEBPACK_IMPORTED_MODULE_2__["InvoiceType"]) {
            var str = o + "";
            var num = new Number(o);
            if (isNaN(num)) {
                translate.get('invoice-invoicetype-' + str.toLowerCase()).subscribe((res) => {
                    this.invoiceTypes.push({ value: o, title: res });
                });
            }
        }
        this.translate.get('invoice-paymentamount').subscribe((res) => {
            this.paymentamountOtherTypesTitle = res;
        });
        this.translate.get('invoice-paymentamount-payment').subscribe((res) => {
            this.paymentamountTypePaymentTitle = res;
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
    }
    calcDiscountDate() {
        //alert("calcDiscountDate ---");
        var enterDate = this.invoiceEditForm.controls["discountEnterDate"].value;
        var deadline = this.invoiceEditForm.controls["discountDeadline"].value;
        if (enterDate != null && deadline != null && deadline > 0) {
            var date = new Date(enterDate.getFullYear(), enterDate.getMonth(), enterDate.getDate() + deadline);
            this.invoiceEditForm.controls["discountDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_5__["formatDate"])(date, 'dd.mm.yyyy'));
        }
    }
    invoiceDateChanges() {
        var enterDate = this.invoiceEditForm.controls["discountEnterDate"].value;
        if (enterDate === null && this.invoiceEditForm.controls["invocieDate"].value !== null) {
            this.invoiceEditForm.controls["discountEnterDate"].setValue(this.invoiceEditForm.controls["invocieDate"].value);
        }
    }
    fileTitleProgress(fileInput, file, fileIndex) {
        if (fileInput.target.files && fileInput.target.files != null && file) {
            file.file = fileInput.target.files[0];
        }
    }
    get assignedUsers() {
        if (this.workflowSaveRequest != null) {
            return this.workflowSaveRequest.assigns;
        }
        return [];
    }
    get paymentamountTitle() {
        return this.isPaymentInvoiceType() ? this.paymentamountTypePaymentTitle : this.paymentamountOtherTypesTitle;
    }
    isPaymentInvoiceType() {
        return this.invoiceEditForm.controls["invoiceType"].value === "PAYMENT";
    }
    ngOnInit() {
        this.invoiceEditForm = this.formBuilder.group({
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            controllerIdentity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            comments: [''],
            sender: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            registerNumber: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            invocieDate: [new Date(), _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            partnerCode: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            vendorNumber: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            vendorName: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            isDirectDebitPermission: [false],
            invoiceType: [_wf_models__WEBPACK_IMPORTED_MODULE_2__["InvoiceType"].NO_TYPE, [_custom_validators_invoice_type_controll_validator__WEBPACK_IMPORTED_MODULE_4__["InvoiceTypeControllValidator"]]],
            discountEnterDate: [new Date(), _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            discountDeadline: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            discountRate: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            discountDate: ["", _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
            paymentAmount: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_1__["Validators"].required],
        });
    }
    reload() {
        this.loadInitialData();
    }
    loadInitialData() {
        this.generalDataObs.subscribe((generalData) => {
            this.users = generalData.company.users;
            this.departments = generalData.company.departments;
        });
    }
    setPageTitle() {
        var pageLabelId = "invoice-assignview-title";
        if (this.workflowSaveRequest.workflow.currentStepIndex === 1) {
            pageLabelId = "invoice-assignview-title";
        }
        if (this.workflowSaveRequest.workflow.currentStepIndex === 2) {
            pageLabelId = "invoice-testingview-title";
        }
        if (this.workflowSaveRequest.workflow.currentStepIndex === 3) {
            pageLabelId = "invoice-releaseview-title";
        }
        this.translate.get(pageLabelId).subscribe((res) => {
            this.pageTitle = res;
        });
    }
    setToControlValues() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.workflow) {
            this.setPageTitle();
            if ((this.workflowSaveRequest.workflow.discountEnterDate === null || this.workflowSaveRequest.workflow.discountEnterDate === '')
                && this.workflowSaveRequest.workflow.invocieDate !== null) {
                this.workflowSaveRequest.workflow.discountEnterDate = this.workflowSaveRequest.workflow.invocieDate;
            }
            this.invoiceEditForm.controls["expireDays"].setValue(this.workflowSaveRequest.expireDays);
            this.invoiceEditForm.controls["controllerIdentity"].setValue(this.workflowSaveRequest.workflow.controllerIdentity);
            this.invoiceEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
            this.invoiceEditForm.controls["sender"].setValue(this.workflowSaveRequest.workflow.sender);
            this.invoiceEditForm.controls["registerNumber"].setValue(this.workflowSaveRequest.workflow.registerNumber);
            this.invoiceEditForm.controls["invocieDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_5__["parseDate"])(this.workflowSaveRequest.workflow.invocieDate, 'dd.mm.yyyy'));
            this.invoiceEditForm.controls["partnerCode"].setValue(this.workflowSaveRequest.workflow.partnerCode);
            this.invoiceEditForm.controls["vendorNumber"].setValue(this.workflowSaveRequest.workflow.vendorNumber);
            this.invoiceEditForm.controls["vendorName"].setValue(this.workflowSaveRequest.workflow.vendorName);
            this.invoiceEditForm.controls["isDirectDebitPermission"].setValue(this.workflowSaveRequest.workflow.isDirectDebitPermission);
            this.invoiceEditForm.controls["invoiceType"].setValue(this.workflowSaveRequest.workflow.invoiceType);
            this.invoiceEditForm.controls["discountEnterDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_5__["parseDate"])(this.workflowSaveRequest.workflow.discountEnterDate, 'dd.mm.yyyy'));
            this.invoiceEditForm.controls["discountDeadline"].setValue(this.workflowSaveRequest.workflow.discountDeadline);
            this.invoiceEditForm.controls["discountRate"].setValue(this.workflowSaveRequest.workflow.discountRate);
            this.invoiceEditForm.controls["discountDate"].setValue(this.workflowSaveRequest.workflow.discountDate);
            this.invoiceEditForm.controls["paymentAmount"].setValue(this.workflowSaveRequest.workflow.paymentAmount);
        }
    }
    setFormControlValues() {
        this.workflowSaveRequest.expireDays = this.invoiceEditForm.controls["expireDays"].value;
        this.workflowSaveRequest.workflow.controllerIdentity = this.invoiceEditForm.controls["controllerIdentity"].value;
        this.workflowSaveRequest.workflow.comments = this.invoiceEditForm.controls["comments"].value;
        this.workflowSaveRequest.workflow.sender = this.invoiceEditForm.controls["sender"].value;
        this.workflowSaveRequest.workflow.registerNumber = this.invoiceEditForm.controls["registerNumber"].value;
        this.workflowSaveRequest.workflow.invocieDate = Object(_helper__WEBPACK_IMPORTED_MODULE_5__["formatDate"])(this.invoiceEditForm.controls["invocieDate"].value, 'dd.mm.yyyy');
        this.workflowSaveRequest.workflow.partnerCode = this.invoiceEditForm.controls["partnerCode"].value;
        this.workflowSaveRequest.workflow.vendorNumber = this.invoiceEditForm.controls["vendorNumber"].value;
        this.workflowSaveRequest.workflow.vendorName = this.invoiceEditForm.controls["vendorName"].value;
        this.workflowSaveRequest.workflow.isDirectDebitPermission = this.invoiceEditForm.controls["isDirectDebitPermission"].value;
        this.workflowSaveRequest.workflow.invoiceType = this.invoiceEditForm.controls["invoiceType"].value;
        this.workflowSaveRequest.workflow.discountEnterDate = Object(_helper__WEBPACK_IMPORTED_MODULE_5__["formatDate"])(this.invoiceEditForm.controls["discountEnterDate"].value, 'dd.mm.yyyy');
        this.workflowSaveRequest.workflow.discountDeadline = this.invoiceEditForm.controls["discountDeadline"].value;
        this.workflowSaveRequest.workflow.discountRate = this.invoiceEditForm.controls["discountRate"].value;
        this.workflowSaveRequest.workflow.discountDate = this.invoiceEditForm.controls["discountDate"].value;
        this.workflowSaveRequest.workflow.paymentAmount = this.invoiceEditForm.controls["paymentAmount"].value;
    }
    get forms() { return this.invoiceEditForm.controls; }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.workflowSaveRequest.assigns = this.workflowSaveRequest.assigns.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.workflowSaveRequest.assigns) {
            var assign = this.workflowSaveRequest.assigns[index];
            if (this.selectAssign[assign.itemType] === undefined) {
                this.selectAssign[assign.itemType] = [];
            }
            this.selectAssign[assign.itemType][assign.itemIdentity] = true;
        }
        this.showAssignModal = true;
    }
    hideAssignSelect() {
        this.showAssignModal = false;
    }
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
        this.hideAssignSelect();
    }
    getAssignItemTitle(item) {
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_2__["AssignType"].DEPARTMENTGROUP) {
            for (var index in this.departments) {
                for (var gindex in this.departments[index].departmentGroups) {
                    if (this.departments[index].departmentGroups[gindex].identity === item.itemIdentity) {
                        return this.departments[index].departmentGroups[gindex].title;
                    }
                }
            }
            return 'Unknown!';
        }
    }
    removeFile(index) {
        this.fileTitles.splice(index, 1);
    }
    addFile() {
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_2__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
}


/***/ }),

/***/ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.css":
/*!*************************************************************************************!*\
  !*** ./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.css ***!
  \*************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.workflow-inline-content-container{\r\n\t\r\n}\r\n\r\n.workflowview-dialog-content-container{\r\n\tbackground-color: white;\t\r\n\tpadding: 10px;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1pbmxpbmV2aWV3L3dvcmtmbG93LWlubGluZXZpZXcuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7O0FBRUE7O0FBRUE7Q0FDQyx1QkFBdUI7Q0FDdkIsYUFBYTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1pbmxpbmV2aWV3L3dvcmtmbG93LWlubGluZXZpZXcuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4ud29ya2Zsb3ctaW5saW5lLWNvbnRlbnQtY29udGFpbmVye1xyXG5cdFxyXG59XHJcblxyXG4ud29ya2Zsb3d2aWV3LWRpYWxvZy1jb250ZW50LWNvbnRhaW5lcntcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcdFxyXG5cdHBhZGRpbmc6IDEwcHg7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts":
/*!************************************************************************************!*\
  !*** ./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts ***!
  \************************************************************************************/
/*! exports provided: WorkflowInlineviewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowInlineviewComponent", function() { return WorkflowInlineviewComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");


let WorkflowInlineviewComponent = class WorkflowInlineviewComponent {
    constructor() { }
    ngOnInit() {
    }
};
tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Input"])('workflow')
], WorkflowInlineviewComponent.prototype, "viewWorkflowModel", void 0);
WorkflowInlineviewComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-workflow-inlineview',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-inlineview.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-inlineview.component.css */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.css")).default]
    })
], WorkflowInlineviewComponent);



/***/ }),

/***/ "./src/app/wm-components/workflow-list/workflow-list.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/wm-components/workflow-list/workflow-list.component.css ***!
  \*************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.search-toolbar {\r\n    width: calc(100% - 350px);\r\n    float: right;\r\n}\r\n\r\n.search-toolbar .nav-item{\r\n    margin-right: 30px;\r\n    \r\n}\r\n\r\n.search-toolbar .nav-item input.form-check-input[type=checkbox]{\r\n    width: 16px;\r\n    height: 16px;\r\n    \r\n}\r\n\r\n.search-toolbar .nav-item .form-check-label{\r\n\tmargin-bottom: 0;\r\n    padding-left: 10px;\r\n    line-height: 20px;\r\n}\r\n\r\n.search-toolbar-item{\r\n\theight: 100%;\r\n    padding-top: 9px;\r\n}\r\n\r\n.search-toolbar .nav-item {\r\n    background-color: transparent !important;\r\n}\r\n\r\n.search-toolbar .nav-link.active, .search-toolbar .show>.nav-link {\r\n    color: #fff !important;\r\n    background-color: #c7c9cb !important;\r\n}\r\n\r\n.table-striped{\r\n\t\r\n}\r\n\r\n.table-striped thead{\r\n\tbackground-color: #c1c4c4;\r\n}\r\n\r\n.table-striped thead tr th, .table-striped thead tr td{\t\r\n\tborder: 2px solid #dee2e6;\r\n\tpadding: 4px 6px;\r\n}\r\n\r\n.table-striped th, .table-striped td{\t\r\n\tborder: 2px solid #dee2e6;\r\n\tpadding: 4px 6px;\r\n}\r\n\r\n.table-striped tbody tr{\t\r\n\tborder: 2px solid #dee2e6;\r\n}\r\n\r\n.table-striped tbody tr:nth-child(odd){\t\r\n\tbackground-color: #fdffd9;\r\n}\r\n\r\n.table-striped tbody tr:nth-child(even){\t\r\n\tbackground-color: #dfe1ff;\r\n}\r\n\r\n.table-striped tbody tr:hove{\t\r\n\tbackground-color: #dff7ff;\r\n}\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1saXN0L3dvcmtmbG93LWxpc3QuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7SUFDSSx5QkFBeUI7SUFDekIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLGtCQUFrQjs7QUFFdEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsWUFBWTs7QUFFaEI7O0FBRUE7Q0FDQyxnQkFBZ0I7SUFDYixrQkFBa0I7SUFDbEIsaUJBQWlCO0FBQ3JCOztBQUVBO0NBQ0MsWUFBWTtJQUNULGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLHdDQUF3QztBQUM1Qzs7QUFFQTtJQUNJLHNCQUFzQjtJQUN0QixvQ0FBb0M7QUFDeEM7O0FBRUE7O0FBRUE7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyx5QkFBeUI7Q0FDekIsZ0JBQWdCO0FBQ2pCOztBQUVBO0NBQ0MseUJBQXlCO0NBQ3pCLGdCQUFnQjtBQUNqQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvd29ya2Zsb3ctbGlzdC93b3JrZmxvdy1saXN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuLnNlYXJjaC10b29sYmFyIHtcclxuICAgIHdpZHRoOiBjYWxjKDEwMCUgLSAzNTBweCk7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWl0ZW17XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDMwcHg7XHJcbiAgICBcclxufVxyXG5cclxuLnNlYXJjaC10b29sYmFyIC5uYXYtaXRlbSBpbnB1dC5mb3JtLWNoZWNrLWlucHV0W3R5cGU9Y2hlY2tib3hde1xyXG4gICAgd2lkdGg6IDE2cHg7XHJcbiAgICBoZWlnaHQ6IDE2cHg7XHJcbiAgICBcclxufVxyXG5cclxuLnNlYXJjaC10b29sYmFyIC5uYXYtaXRlbSAuZm9ybS1jaGVjay1sYWJlbHtcclxuXHRtYXJnaW4tYm90dG9tOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAxMHB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhci1pdGVte1xyXG5cdGhlaWdodDogMTAwJTtcclxuICAgIHBhZGRpbmctdG9wOiA5cHg7XHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWl0ZW0ge1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQgIWltcG9ydGFudDtcclxufVxyXG5cclxuLnNlYXJjaC10b29sYmFyIC5uYXYtbGluay5hY3RpdmUsIC5zZWFyY2gtdG9vbGJhciAuc2hvdz4ubmF2LWxpbmsge1xyXG4gICAgY29sb3I6ICNmZmYgIWltcG9ydGFudDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNjN2M5Y2IgIWltcG9ydGFudDtcclxufVxyXG5cclxuLnRhYmxlLXN0cmlwZWR7XHJcblx0XHJcbn1cclxuXHJcbi50YWJsZS1zdHJpcGVkIHRoZWFke1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNjMWM0YzQ7XHJcbn1cclxuXHJcbi50YWJsZS1zdHJpcGVkIHRoZWFkIHRyIHRoLCAudGFibGUtc3RyaXBlZCB0aGVhZCB0ciB0ZHtcdFxyXG5cdGJvcmRlcjogMnB4IHNvbGlkICNkZWUyZTY7XHJcblx0cGFkZGluZzogNHB4IDZweDtcclxufVxyXG5cclxuLnRhYmxlLXN0cmlwZWQgdGgsIC50YWJsZS1zdHJpcGVkIHRke1x0XHJcblx0Ym9yZGVyOiAycHggc29saWQgI2RlZTJlNjtcclxuXHRwYWRkaW5nOiA0cHggNnB4O1xyXG59XHJcblxyXG4udGFibGUtc3RyaXBlZCB0Ym9keSB0cntcdFxyXG5cdGJvcmRlcjogMnB4IHNvbGlkICNkZWUyZTY7XHJcbn1cclxuXHJcbi50YWJsZS1zdHJpcGVkIHRib2R5IHRyOm50aC1jaGlsZChvZGQpe1x0XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2ZkZmZkOTtcclxufVxyXG5cclxuLnRhYmxlLXN0cmlwZWQgdGJvZHkgdHI6bnRoLWNoaWxkKGV2ZW4pe1x0XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2RmZTFmZjtcclxufVxyXG5cclxuLnRhYmxlLXN0cmlwZWQgdGJvZHkgdHI6aG92ZXtcdFxyXG5cdGJhY2tncm91bmQtY29sb3I6ICNkZmY3ZmY7XHJcbn1cclxuIl19 */");

/***/ }),

/***/ "./src/app/wm-components/workflow-list/workflow-list.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/wm-components/workflow-list/workflow-list.component.ts ***!
  \************************************************************************/
/*! exports provided: WorkflowListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowListComponent", function() { return WorkflowListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/workflow/workflow-search.service */ "./src/app/services/workflow/workflow-search.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");









let WorkflowListComponent = class WorkflowListComponent {
    constructor(router, global, translate, searchService, loadingService, errorService, route) {
        this.router = router;
        this.global = global;
        this.searchService = searchService;
        this.loadingService = loadingService;
        this.errorService = errorService;
        this.route = route;
        this.worlflowTypes = [];
        this.resultWorlflows = [];
        this.listInitialData = new _wf_models__WEBPACK_IMPORTED_MODULE_8__["WorkflowListInitialData"]();
        this.showDebug = false;
        this.viewWorkflowModal = false;
        this.viewWorkflowModel = null;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
    }
    get isMeAssigned() {
        if (this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null) {
            return this.listInitialData.searchFilter.meAssigned;
        }
        return false;
    }
    set isMeAssigned(assigned) {
        if (this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null) {
            this.listInitialData.searchFilter.meAssigned = assigned;
        }
    }
    get statusList() {
        if (this.listInitialData && this.listInitialData != null && this.listInitialData.workflowStatusList != null) {
            return this.listInitialData.workflowStatusList;
        }
        return [];
    }
    ngOnInit() {
        this.loadInitialData();
    }
    loadInitialData() {
        if (this.searchService.listInitialData !== null) {
            this.listInitialData = this.searchService.listInitialData;
        }
        else {
            this.subscribeToSearchInitialData();
            this.searchService.loadInitialData();
        }
    }
    subscribeToSearchInitialData() {
        this.searchService.searchInitialDataSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. : ", data);
            //alert("from app-comp: \n" + JSON.stringify(data));
            if (data && data !== null) {
                this.listInitialData = data;
            }
            else {
                this.listInitialData = null;
            }
        });
    }
    reload() {
        this.loadingService.showLoading();
        this.searchService.search(this.listInitialData.searchFilter).subscribe((result) => {
            console.log("search successful workflow", result);
            this.resultWorlflows = result.list;
        }, response => {
            console.log("Error in search workflow", response);
            this.loadingService.hideLoading();
            this.errorService.showErrorResponse(response);
        }, () => {
            this.loadingService.hideLoading();
        });
    }
    isStatusSelected(wstatus) {
        if (this.listInitialData &&
            this.listInitialData != null &&
            this.listInitialData.searchFilter != null &&
            this.listInitialData.searchFilter.statusList != null) {
            return this.listInitialData.searchFilter.statusList.indexOf(wstatus) > -1;
        }
        return false;
    }
    toggleStatusSelected(wstatus) {
        if (this.listInitialData &&
            this.listInitialData != null &&
            this.listInitialData.searchFilter != null &&
            this.listInitialData.searchFilter.statusList != null) {
            const index = this.listInitialData.searchFilter.statusList.indexOf(wstatus);
            if (index !== -1) {
                this.listInitialData.searchFilter.statusList.splice(index, 1);
            }
            else {
                this.listInitialData.searchFilter.statusList.push(wstatus);
            }
        }
    }
    get debugSearchFilter() {
        if (this.listInitialData &&
            this.listInitialData != null &&
            this.listInitialData.searchFilter != null) {
            return JSON.stringify(this.listInitialData.searchFilter);
        }
        return "";
    }
    showWorkflow(typeIdentity, index) {
        this.viewWorkflowModel = this.resultWorlflows[index];
        this.viewWorkflowModal = true;
    }
    hideViewModal() {
        this.viewWorkflowModal = false;
    }
    editWorkflow(workflow) {
        this.hideViewModal();
        this.router.navigate(['/workflow/edit/' + workflow.workflowType.identity + '/' + workflow.identity]);
    }
};
WorkflowListComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] },
    { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
    { type: _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_5__["WorkflowSearchService"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] },
    { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_7__["ErrorServiceService"] },
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] }
];
WorkflowListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-workflow-list',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html")).default,
        providers: [_services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_5__["WorkflowSearchService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-list.component.css */ "./src/app/wm-components/workflow-list/workflow-list.component.css")).default]
    })
], WorkflowListComponent);



/***/ }),

/***/ "./src/environments/environment.ts":
/*!*****************************************!*\
  !*** ./src/environments/environment.ts ***!
  \*****************************************/
/*! exports provided: environment */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function() { return environment; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

const environment = {
    production: false,
    fake: false
};
/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ "./src/main.ts":
/*!*********************!*\
  !*** ./src/main.ts ***!
  \*********************/
/*! no exports provided */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! hammerjs */ "./node_modules/hammerjs/hammer.js");
/* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser-dynamic */ "./node_modules/@angular/platform-browser-dynamic/fesm2015/platform-browser-dynamic.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");






if (_environments_environment__WEBPACK_IMPORTED_MODULE_4__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_2__["enableProdMode"])();
}
Object(_angular_platform_browser_dynamic__WEBPACK_IMPORTED_MODULE_3__["platformBrowserDynamic"])().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_5__["AppModule"]);
/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ 0:
/*!***************************!*\
  !*** multi ./src/main.ts ***!
  \***************************/
/*! no static exports found */
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__(/*! C:\Git\home\iflow\iflow-java\iflow\gui\angular-prj\gui-prj\src\main.ts */"./src/main.ts");


/***/ })

},[[0,"runtime","vendor"]]]);
//# sourceMappingURL=main-es2015.js.map