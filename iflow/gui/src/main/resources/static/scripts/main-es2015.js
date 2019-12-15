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

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html":
/*!****************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html ***!
  \****************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div *ngIf=\"message\" [ngClass]=\"message.cssClass\">{{message.text}}</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html":
/*!************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html ***!
  \************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"showError\" id=\"errormessagedialog\" role=\"dialog\" aria-labelledby=\"errorMessagedialogCenterTitle\" style=\"display: block; padding-right: 17px;background-color: #808080D0;\">\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t\t<div class=\"modal-content\">\n\t\t\t\t<div class=\"modal-header\">\n\t\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.errormessagetitle' | translate:param }}</h5>\n\t\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideModal()\" aria-label=\"Close\">\n\t\t\t\t\t\t<i class=\"material-icons\">close</i>\n\t\t\t\t\t</button>\n\t\t\t</div>\n\t\t\t\t<div class=\"modal-body\">\n\t\t\t\t\n\t\t\t<div class=\"content-container alert alert alert-danger\" style=\"margin-bottom:0;\">\n\t\t\t\n\t\t\t\t<div class=\"errorcontent-message\" [innerHTML]=\"errorMessage\"></div>\n\t\t\t\t<div [hidden]=\"hasErrorDetail === false\">\n\t\t\t\t\t<input style=\"float:right\" type=\"checkbox\" id=\"showerrordetailcheck\" [(ngModel)]=\"showErrorDetail\" >\n\t\t\t\t\t<label style=\"float:right; margin-right: 10px;\" class=\"form-check-label\" for=\"showerrordetailcheck\">{{ 'common.details' | translate:param }}</label>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t<div id=\"errorcontent-detail\" style=\"padding: 10px; background-color:#d9e3ea; \" [hidden]=\"showErrorDetail === false\">\n\t\t\t\t\t<div style=\"height: 300px; width: 100%; overflow: auto;\">\n\t\t\t\t\t\t<pre [innerHTML]=\"errorDetails\"></pre> \n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\n\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"modal-footer\">\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideModal()\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t</div>\n\t\t\t</div>\n\t</div>\n\t\t\t\n</div>\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html":
/*!****************************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html ***!
  \****************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"showLoading\" id=\"loadingdialog\" role=\"dialog\" style=\"display: block; padding-right: 17px;background-color: #808080D0;\">\n\t<div class=\"loading\" role=\"document\">\n\t\t\t\n\t</div>\n\t\t\t\n</div>\n");

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
/* harmony default export */ __webpack_exports__["default"] = ("<app-top-bar [menus]=\"appMenus\" [currentUser]=\"appCurrentUser\" [isLogged]=\"appIsLogged\" (loggingOut)=\"onLoggingOut($event)\"></app-top-bar>\r\n\r\n<div class=\"container\">\r\n    <div class=\"row\">\r\n        <div class=\"col-sm-6 offset-sm-3\">\r\n            <alert></alert>\r\n            <router-outlet></router-outlet>\r\n        </div>\r\n    </div>\r\n</div>\r\n\r\n<app-message-bar [currentUser]=\"appCurrentUser\" [isLogged]=\"appIsLogged\"></app-message-bar>\r\n\r\n<app-error-dialog></app-error-dialog>\r\n\r\n<app-loading-dialog></app-loading-dialog>\r\n\r\n<app-footer></app-footer>\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html":
/*!************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html ***!
  \************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<footer class=\"footer\">\r\n    <strong><span>{{ 'site.footer' | translate:param }}</span></strong>\r\n\t<span class=\"footer-title\"></span>\r\n</footer>");

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
/* harmony default export */ __webpack_exports__["default"] = ("<div class=\"login-container-parent layout-align-center-center layout-row\" layout=\"row\" layout-align=\"center center\">\r\n\t<div class=\"login-container\">\r\n\t\t<form method=\"POST\" [formGroup]=\"loginForm\" id=\"formlogin\" >\r\n          <div class=\"form-group\">\r\n\t          <label>{{ 'common.companyidentificator' | translate:param }}</label> \r\n\t          <input type=\"text\" name=\"companyid\" autofocus=\"\" formControlName=\"companyid\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.companyid.errors }\">          \r\n\t          <div *ngIf=\"submitted && forms.companyid.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.companyid.errors.required\">CopmayId is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.username' | translate:param }}</label> \r\n\t          <input type=\"text\" name=\"username\" autofocus=\"\" formControlName=\"username\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.username.errors }\">\r\n\t          <div *ngIf=\"submitted && forms.username.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.username.errors.required\">Username is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.password' | translate:param }}</label> \r\n\t          <input type=\"password\" name=\"password\" formControlName=\"password\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.password.errors }\"> \r\n\t          <div *ngIf=\"submitted && forms.password.errors\" class=\"invalid-feedback\">\r\n\t            <div *ngIf=\"forms.password.errors.required\">Password is required</div>\r\n\t          </div>\r\n          </div>  \r\n          <div layout=\"row\" class=\"layout-row form-group\">\r\n             \r\n\t\t\t<button (click)=\"onSubmit()\" type=\"button\" [disabled]=\"loading\" class=\"btn btn-primary\">\r\n\t\t\t   <span *ngIf=\"loading\" class=\"spinner-border spinner-border-sm mr-1\"></span>\r\n\t\t\t   {{ 'common.login' | translate:param }}\r\n\t\t\t</button>\r\n            <div *ngIf=\"submitted && failedLogin\" class=\"invalid-message\">\r\n              <div>{{loginResponse.message}}</div>\r\n            </div>\r\n\t\t\t\r\n          </div> \r\n\t\t</form>\r\n\t\t\r\n\t</div>\r\n\r\n</div>\r\n\r\n\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html":
/*!**********************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html ***!
  \**********************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<div mwlResizable [enableGhostResize]=\"true\" [resizeEdges]=\"{ bottom: false, right: false, top: true, left: false }\" (resizeEnd)=\"onResizeEnd($event)\" class=\"message-panel-container\" id=\"message-panel-container\" *ngIf=\"isAppLogged\">\n\t<div class=\"message-panel-toolbar\">\n\t\t<span class=\"title\">Meldungen</span>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"closeMessages();\"><i class=\"material-icons\">keyboard_arrow_down</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed == false\" (click)=\"showMessages();\"><i class=\"material-icons\">keyboard_arrow_up</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"reloadMessages(true);\"><i class=\"material-icons\">refresh</i></button>\n\t\t<img class=\"toolbar-image\" *ngIf=\"isReloadingMessages\" src=\"assets/images/loading200.gif\" />\n\t\n\t</div>\n\t<div class=\"message-panel-items-container\">\n\t\t<div class=\"message-panel-item\" *ngFor=\"let message of messages;\">\n\t\t\t<a href=\"javascript:void(0);\" (click)=\"showWorkflowView(message.workflowId)\">\n\t\t\t\t<div>{{message.message}} ({{message.workflow.workflowType.title}}) ({{message.createdAtString}}) ({{message.remainingDays}}) ({{message.status}})</div>\n\t\t\t</a>\n\t\t</div>\n\t</div>\n\t\t\t\t\t\n</div>");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html":
/*!**************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html ***!
  \**************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<header>\r\n\r\n\t\t<nav class=\"navbar navbar-expand-lg navbar-toggleable-md navbar-light bg-light navbar-fixed-top\">\r\n\t\t\t<div class=\"container-fluid\">\r\n\t\t\t\t<div class=\"navbar-header\">\r\n\t\t\t\t\t<a class=\"navbar-brand\" href=\"/\"><img class=\"logo\" src=\"/images/fbim2.png\"></a>\r\n\t\t\t\t</div>\r\n\t\t\t\t<ul class=\"navbar-nav\" *ngIf=\"isLogged\">\r\n\t\t\t\t\t<li class=\"nav-item\" *ngFor=\"let menu of menus;\" [ngClass]=\"{'dropdown' : menu.children.length > 0}\">\r\n\t\t\t\t\t\t<a class=\"nav-link\" [routerLink]=\"[menu.url]\" *ngIf=\"menu.children.length == 0\">\r\n\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-home menu-image\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" *ngIf=\"menu.children.length > 0\" href=\"#\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t\t\t\t<span class=\"{{menu.image}}\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"dropdown-menu\" *ngIf=\"menu.children.length > 0\">\r\n\t\t\t\t\t\t\t<a [routerLink]=\"[submenu.url]\" *ngFor=\"let submenu of menu.children;\" class=\"dropdown-item\">\r\n\t\t\t\t\t\t\t\t<span class=\"{{submenu.image}}\"></span>\r\n\t\t\t\t\t\t\t\t<span>{{submenu.label}}</span>\r\n\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t</ul>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t<div class=\"btn-group navbar-user-detail\" *ngIf=\"isLogged\" >\r\n\t\t\t\t  <button type=\"button\" class=\"btn user-toggle-button\" data-toggle=\"dropdown\" data-display=\"static\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t    <span>{{currentUser.fullName}}</span>\r\n\t\t\t\t  </button>\r\n\t\t\t\t  <div class=\"dropdown-menu dropdown-menu-lg-right\">\r\n\t\t\t\t    <button (click)=\"test()\" class=\"dropdown-item\" type=\"button\">Profile</button>\r\n\t\t\t\t    <div class=\"dropdown-divider\"></div>\r\n\t\t\t\t    <button (click)=\"logout()\"  class=\"dropdown-item\" type=\"button\">Logout</button>\r\n\t\t\t\t  </div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</nav>    \t\t\t    \r\n\t\t\r\n\t        \r\n</header>\r\n\r\n<div style=\"background-color: #eeeeee;\">\r\n\t<ul class=\"breadcrumb\">\r\n\t\t<li>\r\n\t\t\t<span>Home</span>\r\n\t\t</li>\r\n\t</ul>\r\n</div>\r\n\t");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-create/workflow-create.component.html":
/*!******************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-create/workflow-create.component.html ***!
  \******************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<h2>Workflow Create</h2>\r\n\r\n\r\n");

/***/ }),

/***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-list/workflow-list.component.html":
/*!**************************************************************************************************!*\
  !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-list/workflow-list.component.html ***!
  \**************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("<h2>Workflow List</h2>\r\n");

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

/***/ "./src/app/_components/alert.component.ts":
/*!************************************************!*\
  !*** ./src/app/_components/alert.component.ts ***!
  \************************************************/
/*! exports provided: AlertComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AlertComponent", function() { return AlertComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");


let AlertComponent = class AlertComponent {
    constructor() { }
    ngOnInit() {
    }
    ngOnDestroy() {
    }
};
AlertComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'alert', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./alert.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html")).default })
], AlertComponent);



/***/ }),

/***/ "./src/app/_components/error-dialog/error-dialog.component.css":
/*!*********************************************************************!*\
  !*** ./src/app/_components/error-dialog/error-dialog.component.css ***!
  \*********************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n[hidden] {\r\n  display: none !important;\r\n}\r\n\r\n\r\n#errormessagedialog .modal-dialog{\r\n\tmin-width: 50vw;\r\n    max-width: 50vw;\r\n    \r\n}\r\n\r\n\r\n#errormessagedialog .modal-footer{\r\n    padding: 5px !important;\r\n}\r\n\r\n\r\n#errormessagedialog .modal-footer .btn{\r\n    padding: 5px !important;\r\n    line-height: 14px !important;\r\n}\r\n\r\n\r\n.errorcontent-message {\r\n    margin-bottom: 5px;\r\n    padding-left: 5px;\r\n    border-bottom: 1px solid;\r\n    padding-bottom: 15px;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvX2NvbXBvbmVudHMvZXJyb3ItZGlhbG9nL2Vycm9yLWRpYWxvZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtFQUNFLHdCQUF3QjtBQUMxQjs7O0FBR0E7Q0FDQyxlQUFlO0lBQ1osZUFBZTs7QUFFbkI7OztBQUVBO0lBQ0ksdUJBQXVCO0FBQzNCOzs7QUFFQTtJQUNJLHVCQUF1QjtJQUN2Qiw0QkFBNEI7QUFDaEM7OztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLGlCQUFpQjtJQUNqQix3QkFBd0I7SUFDeEIsb0JBQW9CO0FBQ3hCIiwiZmlsZSI6InNyYy9hcHAvX2NvbXBvbmVudHMvZXJyb3ItZGlhbG9nL2Vycm9yLWRpYWxvZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbltoaWRkZW5dIHtcclxuICBkaXNwbGF5OiBub25lICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcblxyXG4jZXJyb3JtZXNzYWdlZGlhbG9nIC5tb2RhbC1kaWFsb2d7XHJcblx0bWluLXdpZHRoOiA1MHZ3O1xyXG4gICAgbWF4LXdpZHRoOiA1MHZ3O1xyXG4gICAgXHJcbn1cclxuXHJcbiNlcnJvcm1lc3NhZ2VkaWFsb2cgLm1vZGFsLWZvb3RlcntcclxuICAgIHBhZGRpbmc6IDVweCAhaW1wb3J0YW50O1xyXG59XHJcblxyXG4jZXJyb3JtZXNzYWdlZGlhbG9nIC5tb2RhbC1mb290ZXIgLmJ0bntcclxuICAgIHBhZGRpbmc6IDVweCAhaW1wb3J0YW50O1xyXG4gICAgbGluZS1oZWlnaHQ6IDE0cHggIWltcG9ydGFudDtcclxufVxyXG5cclxuLmVycm9yY29udGVudC1tZXNzYWdlIHtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxuICAgIHBhZGRpbmctbGVmdDogNXB4O1xyXG4gICAgYm9yZGVyLWJvdHRvbTogMXB4IHNvbGlkO1xyXG4gICAgcGFkZGluZy1ib3R0b206IDE1cHg7XHJcbn1cclxuXHJcblxyXG4iXX0= */");

/***/ }),

/***/ "./src/app/_components/error-dialog/error-dialog.component.ts":
/*!********************************************************************!*\
  !*** ./src/app/_components/error-dialog/error-dialog.component.ts ***!
  \********************************************************************/
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
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./error-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./error-dialog.component.css */ "./src/app/_components/error-dialog/error-dialog.component.css")).default]
    })
], ErrorDialogComponent);



/***/ }),

/***/ "./src/app/_components/index.ts":
/*!**************************************!*\
  !*** ./src/app/_components/index.ts ***!
  \**************************************/
/*! exports provided: AlertComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _alert_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./alert.component */ "./src/app/_components/alert.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AlertComponent", function() { return _alert_component__WEBPACK_IMPORTED_MODULE_1__["AlertComponent"]; });





/***/ }),

/***/ "./src/app/_components/loading-dialog/loading-dialog.component.css":
/*!*************************************************************************!*\
  !*** ./src/app/_components/loading-dialog/loading-dialog.component.css ***!
  \*************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n.loading-container\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  \r\n}\r\n\r\n.loading\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  background-color: rgba(100, 100, 100, 0.3);\r\n  background-image: url(/assets/images/loading200.gif);\r\n  background-repeat: no-repeat;\r\n  background-position: center;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvX2NvbXBvbmVudHMvbG9hZGluZy1kaWFsb2cvbG9hZGluZy1kaWFsb2cuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOztBQUVBOztFQUVFLHVCQUF1QjtFQUN2Qix3QkFBd0I7O0FBRTFCOztBQUVBOztFQUVFLHVCQUF1QjtFQUN2Qix3QkFBd0I7RUFDeEIsMENBQTBDO0VBQzFDLG9EQUFvRDtFQUNwRCw0QkFBNEI7RUFDNUIsMkJBQTJCO0FBQzdCIiwiZmlsZSI6InNyYy9hcHAvX2NvbXBvbmVudHMvbG9hZGluZy1kaWFsb2cvbG9hZGluZy1kaWFsb2cuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLmxvYWRpbmctY29udGFpbmVyXHJcbntcclxuICB3aWR0aDogMTAwdncgIWltcG9ydGFudDsgXHJcbiAgaGVpZ2h0OiAxMDB2aCAhaW1wb3J0YW50OyBcclxuICBcclxufVxyXG5cclxuLmxvYWRpbmdcclxue1xyXG4gIHdpZHRoOiAxMDB2dyAhaW1wb3J0YW50OyBcclxuICBoZWlnaHQ6IDEwMHZoICFpbXBvcnRhbnQ7IFxyXG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMTAwLCAxMDAsIDEwMCwgMC4zKTtcclxuICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL2Fzc2V0cy9pbWFnZXMvbG9hZGluZzIwMC5naWYpO1xyXG4gIGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XHJcbiAgYmFja2dyb3VuZC1wb3NpdGlvbjogY2VudGVyO1xyXG59XHJcblxyXG5cclxuIl19 */");

/***/ }),

/***/ "./src/app/_components/loading-dialog/loading-dialog.component.ts":
/*!************************************************************************!*\
  !*** ./src/app/_components/loading-dialog/loading-dialog.component.ts ***!
  \************************************************************************/
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
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./loading-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./loading-dialog.component.css */ "./src/app/_components/loading-dialog/loading-dialog.component.css")).default]
    })
], LoadingDialogComponent);



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
        this.appMenus = [];
        this.appCurrentUser = null;
        this.appIsLogged = false;
        this.appShowLoading = false;
        // this language will be used as a fallback when a translation isn't found in the current language
        translate.setDefaultLang('de');
        // the lang to use, if the lang isn't available, it will use the current loader to get them
        translate.use('de');
        translate.get('site.title').subscribe((res) => {
            this.titleService.setTitle(res);
        });
        this.router.routeReuseStrategy.shouldReuseRoute = function () {
            return false;
        };
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                // trick the Router into believing it's last link wasn't previously loaded
                this.router.navigated = false;
                if (this.global.currentSessionDataValue && this.global.currentSessionDataValue.isLogged) {
                    this.appMenus = this.global.currentSessionDataValue.app.menus;
                    this.appCurrentUser = this.global.currentSessionDataValue.user.currentUser;
                    this.appIsLogged = this.global.currentSessionDataValue.isLogged;
                    console.log("set gloabl-data from app-comp. appIsLogged: " + this.appIsLogged);
                }
                else {
                    this.appMenus = [];
                    this.appCurrentUser = null;
                    this.appIsLogged = false;
                }
                //alert("app-comp globaldata navigate. menus:" + this.appMenus.length);
            }
        });
    }
    ngOnInit() {
        if (this.global.currentSessionDataValue && this.global.currentSessionDataValue.isLogged) {
            this.appMenus = this.global.currentSessionDataValue.app.menus;
            this.appCurrentUser = this.global.currentSessionDataValue.user.currentUser;
            this.appIsLogged = this.global.currentSessionDataValue.isLogged;
            console.log("set gloabl-data from app-comp. appIsLogged: " + this.appIsLogged);
        }
        else {
            this.appMenus = [];
            this.appCurrentUser = null;
            this.appIsLogged = false;
        }
    }
    showLoading() {
        this.appShowLoading = true;
    }
    onLoggingOut(data) {
        this.autService.logout();
        this.global.clear();
        this.router.navigate(['/auth/login']);
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

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ "./src/app/app.module.ts":
/*!*******************************!*\
  !*** ./src/app/app.module.ts ***!
  \*******************************/
/*! exports provided: createTranslateLoader, AppModule */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "createTranslateLoader", function() { return createTranslateLoader; });
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
/* harmony import */ var _app_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./app.component */ "./src/app/app.component.ts");
/* harmony import */ var _app_routing__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./app.routing */ "./src/app/app.routing.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");
/* harmony import */ var _components__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./_components */ "./src/app/_components/index.ts");
/* harmony import */ var _top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./top-bar/top-bar.component */ "./src/app/top-bar/top-bar.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ./message-bar/message-bar.component */ "./src/app/message-bar/message-bar.component.ts");
/* harmony import */ var _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ./_components/error-dialog/error-dialog.component */ "./src/app/_components/error-dialog/error-dialog.component.ts");
/* harmony import */ var _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ./_components/loading-dialog/loading-dialog.component */ "./src/app/_components/loading-dialog/loading-dialog.component.ts");
/* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
/* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
/* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
/* harmony import */ var _workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./workflow-create/workflow-create.component */ "./src/app/workflow-create/workflow-create.component.ts");
/* harmony import */ var _workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./workflow-list/workflow-list.component */ "./src/app/workflow-list/workflow-list.component.ts");


























function createTranslateLoader(http) {
    return new _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_7__["TranslateHttpLoader"](http, './assets/i18n/', '.json');
}
let AppModule = class AppModule {
};
AppModule = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["NgModule"])({
        imports: [
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_2__["BrowserModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_3__["ReactiveFormsModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_4__["HttpClientModule"],
            _app_routing__WEBPACK_IMPORTED_MODULE_10__["appRoutingModule"],
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_5__["BrowserAnimationsModule"],
            angular_resizable_element__WEBPACK_IMPORTED_MODULE_8__["ResizableModule"],
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
            _app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"],
            _top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_15__["TopBarComponent"],
            _footer_footer_component__WEBPACK_IMPORTED_MODULE_16__["FooterComponent"],
            _components__WEBPACK_IMPORTED_MODULE_14__["AlertComponent"],
            _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_17__["MessageBarComponent"],
            _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_18__["ErrorDialogComponent"],
            _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_19__["LoadingDialogComponent"],
            _home__WEBPACK_IMPORTED_MODULE_20__["HomeComponent"],
            _about__WEBPACK_IMPORTED_MODULE_21__["AboutComponent"],
            _login__WEBPACK_IMPORTED_MODULE_22__["LoginComponent"],
            _workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_23__["WorkflowCreateComponent"],
            _workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_24__["WorkflowListComponent"],
        ],
        providers: [_services_global_service__WEBPACK_IMPORTED_MODULE_11__["GlobalService"], _services_authentication_service__WEBPACK_IMPORTED_MODULE_12__["AuthenticationService"], _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_13__["WorkflowMessageService"]],
        bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_9__["AppComponent"]]
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
/* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
/* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
/* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
/* harmony import */ var _workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./workflow-create/workflow-create.component */ "./src/app/workflow-create/workflow-create.component.ts");
/* harmony import */ var _workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./workflow-list/workflow-list.component */ "./src/app/workflow-list/workflow-list.component.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./helper */ "./src/app/helper/index.ts");








const routes = [
    { path: '', component: _home__WEBPACK_IMPORTED_MODULE_2__["HomeComponent"], canActivate: [_helper__WEBPACK_IMPORTED_MODULE_7__["AuthGuard"]] },
    { path: 'about', component: _about__WEBPACK_IMPORTED_MODULE_3__["AboutComponent"], canActivate: [_helper__WEBPACK_IMPORTED_MODULE_7__["AuthGuard"]] },
    { path: 'workflow/list', component: _workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__["WorkflowListComponent"], canActivate: [_helper__WEBPACK_IMPORTED_MODULE_7__["AuthGuard"]] },
    { path: 'workflow/create', component: _workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_5__["WorkflowCreateComponent"], canActivate: [_helper__WEBPACK_IMPORTED_MODULE_7__["AuthGuard"]] },
    { path: 'auth/login', component: _login__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"] },
    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [_helper__WEBPACK_IMPORTED_MODULE_7__["AuthGuard"]] }
];
const appRoutingModule = _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes);


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

/***/ "./src/app/helper/auth.guard.ts":
/*!**************************************!*\
  !*** ./src/app/helper/auth.guard.ts ***!
  \**************************************/
/*! exports provided: AuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthGuard", function() { return AuthGuard; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/authentication.service */ "./src/app/services/authentication.service.ts");




let AuthGuard = class AuthGuard {
    constructor(router, authenticationService) {
        this.router = router;
        this.authenticationService = authenticationService;
    }
    canActivate(route, state) {
        const currentUser = this.authenticationService.currentUserValue;
        if (currentUser) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page with the return url
        this.router.navigate(['auth/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
};
AuthGuard.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_authentication_service__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"] }
];
AuthGuard = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
], AuthGuard);



/***/ }),

/***/ "./src/app/helper/index.ts":
/*!*********************************!*\
  !*** ./src/app/helper/index.ts ***!
  \*********************************/
/*! exports provided: AuthGuard */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _auth_guard__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./auth.guard */ "./src/app/helper/auth.guard.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthGuard", function() { return _auth_guard__WEBPACK_IMPORTED_MODULE_1__["AuthGuard"]; });





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
        this.loading = false;
        this.submitted = false;
        this.failedLogin = false;
        this.loginResponse = new _ui_models__WEBPACK_IMPORTED_MODULE_5__["LoginResponse"];
        translate.setDefaultLang('de');
        translate.use('de');
    }
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['admin@iflow.de', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
            password: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
            companyid: ['test-company-1', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
        });
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
        this.router.navigate(['/']);
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

/***/ "./src/app/message-bar/message-bar.component.css":
/*!*******************************************************!*\
  !*** ./src/app/message-bar/message-bar.component.css ***!
  \*******************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("@charset \"ISO-8859-1\";\r\n\r\n.message-panel-container {\r\n    height: 170px;\r\n    margin-top: 10px;\r\n    border: 1px solid gray;\r\n    background-color: #fbfbe8;\r\n    position: fixed !important;\r\n    width: 100vw;\r\n    bottom: 30px;\r\n}\r\n\r\n.message-panel-toolbar{\r\n\theight: 30px;\r\n\tbackground-color: #dadccf;\t\r\n\tpadding-top: 2px;\r\n\tpadding-right: 10px;\r\n}\r\n\r\n.message-panel-toolbar span.title{\r\n\tpadding-left: 20px;\r\n\tfont-weight: bold;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.message-panel-toolbar .toolbar-button{\r\n\tfloat: right;\t\r\n}\r\n\r\n.message-panel-items-container{\r\n\theight: calc(100% - 30px);\r\n\tpadding: 4px 4px;\r\n\toverflow: auto;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item{\r\n\theight: 22px;\r\n\tline-height: 22px;\r\n\tmargin: 3px 0;\r\n\tbackground-color: #cafff9;\r\n\tpadding-left: 15px;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item:hover{\r\n\tbackground-color: #caffd3;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a{\r\n\tcolor: gray;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a:hover{\r\n\tcolor: #946b73;\r\n}\r\n\r\n.toolbar-image {\r\n    border: none;\r\n    margin-right: 10px;\r\n    width: 24px;\r\n    height: 24px;\r\n    float: right;\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSxxQkFBcUI7O0FBRXJCO0lBQ0ksYUFBYTtJQUNiLGdCQUFnQjtJQUNoQixzQkFBc0I7SUFDdEIseUJBQXlCO0lBQ3pCLDBCQUEwQjtJQUMxQixZQUFZO0lBQ1osWUFBWTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWix5QkFBeUI7Q0FDekIsZ0JBQWdCO0NBQ2hCLG1CQUFtQjtBQUNwQjs7QUFFQTtDQUNDLGtCQUFrQjtDQUNsQixpQkFBaUI7Q0FDakIsZUFBZTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixnQkFBZ0I7Q0FDaEIsY0FBYztBQUNmOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtDQUNqQixhQUFhO0NBQ2IseUJBQXlCO0NBQ3pCLGtCQUFrQjtBQUNuQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGNBQWM7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixrQkFBa0I7SUFDbEIsV0FBVztJQUNYLFlBQVk7SUFDWixZQUFZO0FBQ2hCIiwiZmlsZSI6InNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIkBjaGFyc2V0IFwiSVNPLTg4NTktMVwiO1xyXG5cclxuLm1lc3NhZ2UtcGFuZWwtY29udGFpbmVyIHtcclxuICAgIGhlaWdodDogMTcwcHg7XHJcbiAgICBtYXJnaW4tdG9wOiAxMHB4O1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgZ3JheTtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmYmZiZTg7XHJcbiAgICBwb3NpdGlvbjogZml4ZWQgIWltcG9ydGFudDtcclxuICAgIHdpZHRoOiAxMDB2dztcclxuICAgIGJvdHRvbTogMzBweDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtdG9vbGJhcntcclxuXHRoZWlnaHQ6IDMwcHg7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2RhZGNjZjtcdFxyXG5cdHBhZGRpbmctdG9wOiAycHg7XHJcblx0cGFkZGluZy1yaWdodDogMTBweDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtdG9vbGJhciBzcGFuLnRpdGxle1xyXG5cdHBhZGRpbmctbGVmdDogMjBweDtcclxuXHRmb250LXdlaWdodDogYm9sZDtcclxuXHRmb250LXNpemU6IDE0cHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXIgLnRvb2xiYXItYnV0dG9ue1xyXG5cdGZsb2F0OiByaWdodDtcdFxyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC1pdGVtcy1jb250YWluZXJ7XHJcblx0aGVpZ2h0OiBjYWxjKDEwMCUgLSAzMHB4KTtcclxuXHRwYWRkaW5nOiA0cHggNHB4O1xyXG5cdG92ZXJmbG93OiBhdXRvO1xyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC1pdGVtcy1jb250YWluZXIgLm1lc3NhZ2UtcGFuZWwtaXRlbXtcclxuXHRoZWlnaHQ6IDIycHg7XHJcblx0bGluZS1oZWlnaHQ6IDIycHg7XHJcblx0bWFyZ2luOiAzcHggMDtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjY2FmZmY5O1xyXG5cdHBhZGRpbmctbGVmdDogMTVweDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW06aG92ZXJ7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2NhZmZkMztcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW0gYXtcclxuXHRjb2xvcjogZ3JheTtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW0gYTpob3ZlcntcclxuXHRjb2xvcjogIzk0NmI3MztcclxufVxyXG5cclxuLnRvb2xiYXItaW1hZ2Uge1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAxMHB4O1xyXG4gICAgd2lkdGg6IDI0cHg7XHJcbiAgICBoZWlnaHQ6IDI0cHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbn1cclxuXHJcbiJdfQ== */");

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
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
/* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");




let MessageBarComponent = class MessageBarComponent {
    constructor(router, messageService) {
        this.router = router;
        this.messageService = messageService;
        this.messages = [];
        this.messageSearchInterval = 60000;
        this.messageReloadTimeoutId = 0;
        this.messagePanelHeight = 170;
        this.messagePanelShowed = true;
        this._isLogged = false;
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
        //console.log("change isLogged inside comp. this: " + this._isLogged + ",   app: " + value); 	    
        this._isLogged = value === 'true';
        this.reloadMessages(true);
    }
    get isAppLogged() {
        return this._isLogged;
    }
    get isReloadingMessages() {
        return this.messageService.isReloadingMessages;
    }
    ngOnInit() {
        if (this._isLogged == true) {
            console.log("start read message list from comp.");
            this.reloadMessages(true);
        }
    }
    onResizeEnd(event) {
        this.messagePanelHeight = event.rectangle.height;
        document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
        //alert(this.messagePanelHeight);
    }
    reloadMessages(reset) {
        clearTimeout(this.messageReloadTimeoutId);
        //console.log("start reloadMessages.  _isLogged:" + (this._isLogged === true));
        if (this._isLogged === true) {
            this.subscribeService();
            this.messageService.loadMessages(reset);
        }
    }
    showWorkflowView(id) {
    }
    subscribeService() {
        this.messageService.workflowMessageListSubject.subscribe(x => {
            if (x != null) {
                this.messages = x;
            }
            else {
                this.messages = [];
            }
        }, error => {
            //console.log("Error in read message list.", error);
            this.messages = [];
        }, () => {
            //this.messageService.workflowMessageListSubject.unsubscribe();
            //console.log("Compelete read message list from comp. start next timeout");
            this.messageReloadTimeoutId = setTimeout(() => {
                this.reloadMessages(false);
            }, this.messageSearchInterval);
        });
    }
};
MessageBarComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_3__["WorkflowMessageService"] }
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
        providers: [_services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_3__["WorkflowMessageService"]],
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./message-bar.component.css */ "./src/app/message-bar/message-bar.component.css")).default]
    })
], MessageBarComponent);



/***/ }),

/***/ "./src/app/products.ts":
/*!*****************************!*\
  !*** ./src/app/products.ts ***!
  \*****************************/
/*! exports provided: products */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "products", function() { return products; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");

const products = [
    {
        name: 'Phone XL',
        price: 799,
        description: 'A large phone with one of the best screens'
    },
    {
        name: 'Phone Mini',
        price: 699,
        description: 'A great phone with one of the best cameras'
    },
    {
        name: 'Phone Standard',
        price: 299,
        description: ''
    }
];
/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


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
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");





let AuthenticationService = class AuthenticationService {
    constructor(http, global) {
        this.http = http;
        this.global = global;
        this.currentUserSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](JSON.parse(localStorage.getItem('currentUser')));
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
        const httpOptions = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
                'Content-Type': 'application/x-www-form-urlencoded',
                'Authorization': 'my-auth-token'
            })
        };
        this.http.post("/auth/authenticate", loginData, httpOptions).subscribe(val => {
            var loginResponse = val;
            localStorage.setItem('currentUser', JSON.stringify(loginResponse.user));
            this.currentUserSubject.next(loginResponse.user);
            this.currentUserSubject.complete();
            loginComponent.processLoginResult(val);
        }, response => {
            this.currentUserSubject.next(null);
            this.currentUserSubject.complete();
            loginComponent.processFailedResult(response);
        }, () => {
            loginComponent.processEndLoading();
        });
    }
    logout() {
        localStorage.removeItem('currentUser');
        this.global.clear();
        this.currentUserSubject.next(null);
        this.currentUserSubject.complete();
    }
};
AuthenticationService.ctorParameters = () => [
    { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] },
    { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] }
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





let GlobalService = class GlobalService {
    constructor(http, loadingService) {
        this.http = http;
        this.loadingService = loadingService;
        this.currentSessionDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](JSON.parse(localStorage.getItem('currentSessionData')));
        this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();
    }
    get currentSessionDataValue() {
        return this.currentSessionDataSubject.value;
    }
    loadAllSetting(login) {
        this.loadingService.showLoading();
        this.http.get("/general/data/generaldatat").subscribe(val => {
            console.log("GET call successful generaldata", val);
            //alert("GET call generaldata");
            var generalData = val;
            localStorage.setItem('currentSessionData', JSON.stringify(generalData));
            this.currentSessionDataSubject.next(generalData);
        }, response => {
            console.log("Error in read menu list", response);
            //alert("Error in read menu list: "+ response);
        }, () => {
            if (login != null) {
                login.finishGeneralDataLoading();
            }
            //alert("Finish call successful generaldata");
            this.currentSessionDataSubject.complete();
            this.loadingService.hideLoading();
        });
    }
    clear() {
        localStorage.removeItem('currentSessionData');
        this.currentSessionDataSubject.next(null);
        this.currentSessionDataSubject.complete();
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
/*! exports provided: GlobalService, AuthenticationService, UserService */
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





let WorkflowMessageService = class WorkflowMessageService {
    constructor(http, errorService) {
        this.http = http;
        this.errorService = errorService;
        this.loadMessageUrl = "/general/data/workflowmessages";
        this.assignWorkflowUrl = "/workflow/data/assignworkflow/";
        this.isReloadingMessages = false;
        this.workflowMessageListSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"]([]);
    }
    get workflowMessageList() {
        return this.workflowMessageListSubject.value;
    }
    loadMessages(resetCach) {
        this.isReloadingMessages = true;
        var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
        const httpOptions = {
            headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
                'Content-Type': 'application/json; charset=UTF-8'
            })
        };
        this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"](), httpOptions).subscribe(val => {
            console.log("Read message list", val);
            var messageList = val;
            messageList = this.buildMessageList(messageList);
            this.workflowMessageListSubject.next(messageList);
        }, response => {
            console.log("Error in read message list", response);
            this.workflowMessageListSubject.next([]);
            //this.errorService.showError("Error in read message list.", "Error in read message list.\nError in read message list.\nError in read message list.");
            //alert(JSON.stringify(response));
            this.errorService.showErrorResponse(response);
        }, () => {
            this.workflowMessageListSubject.complete();
            setTimeout(() => {
                this.isReloadingMessages = false;
            }, 3000);
        });
    }
    buildMessageList(messages) {
        var messageList = [];
        for (var index in messages) {
            var message = messages[index];
            messageList.push(message);
        }
        return messageList;
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

/***/ "./src/app/top-bar/top-bar.component.css":
/*!***********************************************!*\
  !*** ./src/app/top-bar/top-bar.component.css ***!
  \***********************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n.navbar-user-detail {\r\n    float: right;\r\n    margin-right: 30px;\r\n}\r\n\r\nbutton.user-toggle-button {\r\n    background-color: #cecece;\r\n    border: none;\r\n    background-image: url(/scripts/static/md-contact.svg);\r\n    background-position: 140px center;\r\n    background-repeat: no-repeat;\r\n    background-size: 24px;\r\n    width: 170px;\r\n    text-align: left;\r\n    height: 34px;\r\n}   \r\n    \r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdG9wLWJhci90b3AtYmFyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHlCQUF5QjtJQUN6QixZQUFZO0lBQ1oscURBQXFEO0lBQ3JELGlDQUFpQztJQUNqQyw0QkFBNEI7SUFDNUIscUJBQXFCO0lBQ3JCLFlBQVk7SUFDWixnQkFBZ0I7SUFDaEIsWUFBWTtBQUNoQiIsImZpbGUiOiJzcmMvYXBwL3RvcC1iYXIvdG9wLWJhci5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5uYXZiYXItdXNlci1kZXRhaWwge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAzMHB4O1xyXG59XHJcblxyXG5idXR0b24udXNlci10b2dnbGUtYnV0dG9uIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNjZWNlY2U7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL3NjcmlwdHMvc3RhdGljL21kLWNvbnRhY3Quc3ZnKTtcclxuICAgIGJhY2tncm91bmQtcG9zaXRpb246IDE0MHB4IGNlbnRlcjtcclxuICAgIGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XHJcbiAgICBiYWNrZ3JvdW5kLXNpemU6IDI0cHg7XHJcbiAgICB3aWR0aDogMTcwcHg7XHJcbiAgICB0ZXh0LWFsaWduOiBsZWZ0O1xyXG4gICAgaGVpZ2h0OiAzNHB4O1xyXG59ICAgXHJcbiAgICAiXX0= */");

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
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/loading-service.service */ "./src/app/services/loading-service.service.ts");




let TopBarComponent = class TopBarComponent {
    constructor(router, loadingService) {
        this.router = router;
        this.loadingService = loadingService;
        this.loggingOut = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
    }
    ngOnInit() {
    }
    logout() {
        this.loggingOut.emit(true);
    }
    test() {
        this.loadingService.showLoading();
    }
};
TopBarComponent.ctorParameters = () => [
    { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
    { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_3__["LoadingServiceService"] }
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
                if (response.status === 0 || response.name === "HttpErrorResponse") {
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

/***/ "./src/app/ui-models/index.ts":
/*!************************************!*\
  !*** ./src/app/ui-models/index.ts ***!
  \************************************/
/*! exports provided: User, MenuItem, LoginResponse, ErrorDetail, ErrorResponse */
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

/* harmony import */ var _error_detail__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./error-detail */ "./src/app/ui-models/error-detail.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function() { return _error_detail__WEBPACK_IMPORTED_MODULE_4__["ErrorDetail"]; });

/* harmony import */ var _error_response__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./error-response */ "./src/app/ui-models/error-response.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function() { return _error_response__WEBPACK_IMPORTED_MODULE_5__["ErrorResponse"]; });









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

/***/ "./src/app/workflow-create/workflow-create.component.css":
/*!***************************************************************!*\
  !*** ./src/app/workflow-create/workflow-create.component.css ***!
  \***************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd29ya2Zsb3ctY3JlYXRlL3dvcmtmbG93LWNyZWF0ZS5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7Ozs7Q0FJQyIsImZpbGUiOiJzcmMvYXBwL3dvcmtmbG93LWNyZWF0ZS93b3JrZmxvdy1jcmVhdGUuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLypcclxuQ29weXJpZ2h0IEdvb2dsZSBMTEMuIEFsbCBSaWdodHMgUmVzZXJ2ZWQuXHJcblVzZSBvZiB0aGlzIHNvdXJjZSBjb2RlIGlzIGdvdmVybmVkIGJ5IGFuIE1JVC1zdHlsZSBsaWNlbnNlIHRoYXRcclxuY2FuIGJlIGZvdW5kIGluIHRoZSBMSUNFTlNFIGZpbGUgYXQgaHR0cDovL2FuZ3VsYXIuaW8vbGljZW5zZVxyXG4qLyJdfQ== */");

/***/ }),

/***/ "./src/app/workflow-create/workflow-create.component.ts":
/*!**************************************************************!*\
  !*** ./src/app/workflow-create/workflow-create.component.ts ***!
  \**************************************************************/
/*! exports provided: WorkflowCreateComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowCreateComponent", function() { return WorkflowCreateComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _products__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../products */ "./src/app/products.ts");



let WorkflowCreateComponent = class WorkflowCreateComponent {
    constructor() {
        this.products = _products__WEBPACK_IMPORTED_MODULE_2__["products"];
    }
    share() {
        window.alert('The product has been shared!');
    }
    onNotify() {
        window.alert('You will be notified when the product goes on sale');
    }
};
WorkflowCreateComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-workflow-create',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-create.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-create/workflow-create.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-create.component.css */ "./src/app/workflow-create/workflow-create.component.css")).default]
    })
], WorkflowCreateComponent);

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


/***/ }),

/***/ "./src/app/workflow-list/workflow-list.component.css":
/*!***********************************************************!*\
  !*** ./src/app/workflow-list/workflow-list.component.css ***!
  \***********************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd29ya2Zsb3ctbGlzdC93b3JrZmxvdy1saXN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7QUFFQTs7OztDQUlDIiwiZmlsZSI6InNyYy9hcHAvd29ya2Zsb3ctbGlzdC93b3JrZmxvdy1saXN0LmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi8qXHJcbkNvcHlyaWdodCBHb29nbGUgTExDLiBBbGwgUmlnaHRzIFJlc2VydmVkLlxyXG5Vc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0XHJcbmNhbiBiZSBmb3VuZCBpbiB0aGUgTElDRU5TRSBmaWxlIGF0IGh0dHA6Ly9hbmd1bGFyLmlvL2xpY2Vuc2VcclxuKi8iXX0= */");

/***/ }),

/***/ "./src/app/workflow-list/workflow-list.component.ts":
/*!**********************************************************!*\
  !*** ./src/app/workflow-list/workflow-list.component.ts ***!
  \**********************************************************/
/*! exports provided: WorkflowListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowListComponent", function() { return WorkflowListComponent; });
/* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
/* harmony import */ var _products__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../products */ "./src/app/products.ts");



let WorkflowListComponent = class WorkflowListComponent {
    constructor() {
        this.products = _products__WEBPACK_IMPORTED_MODULE_2__["products"];
    }
    share() {
        window.alert('The product has been shared!');
    }
    onNotify() {
        window.alert('You will be notified when the product goes on sale');
    }
};
WorkflowListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
        selector: 'app-workflow-list',
        template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/workflow-list/workflow-list.component.html")).default,
        styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-list.component.css */ "./src/app/workflow-list/workflow-list.component.css")).default]
    })
], WorkflowListComponent);

/*
Copyright Google LLC. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/ 


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
    production: false
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