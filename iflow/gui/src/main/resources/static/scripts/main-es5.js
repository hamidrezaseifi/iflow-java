(window["webpackJsonp"] = window["webpackJsonp"] || []).push([["main"], {
        /***/ "./$$_lazy_route_resource lazy recursive": 
        /*!******************************************************!*\
          !*** ./$$_lazy_route_resource lazy namespace object ***!
          \******************************************************/
        /*! no static exports found */
        /***/ (function (module, exports) {
            function webpackEmptyAsyncContext(req) {
                // Here Promise.resolve().then() is used instead of new Promise() to prevent
                // uncaught exception popping up in devtools
                return Promise.resolve().then(function () {
                    var e = new Error("Cannot find module '" + req + "'");
                    e.code = 'MODULE_NOT_FOUND';
                    throw e;
                });
            }
            webpackEmptyAsyncContext.keys = function () { return []; };
            webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
            module.exports = webpackEmptyAsyncContext;
            webpackEmptyAsyncContext.id = "./$$_lazy_route_resource lazy recursive";
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html": 
        /*!****************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html ***!
          \****************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<div *ngIf=\"message\" [ngClass]=\"message.cssClass\">{{message.text}}</div>");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html": 
        /*!************************************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html ***!
          \************************************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"showError\" id=\"errormessagedialog\" role=\"dialog\" aria-labelledby=\"errorMessagedialogCenterTitle\">\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t\t<div class=\"modal-content\">\n\t\t\t\t<div class=\"modal-header\">\n\t\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.errormessagetitle' | translate:param }}</h5>\n\t\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideModal()\" aria-label=\"Close\">\n\t\t\t\t\t\t<i class=\"material-icons\">close</i>\n\t\t\t\t\t</button>\n\t\t\t</div>\n\t\t\t\t<div class=\"modal-body\">\n\t\t\t\t\n\t\t\t<div class=\"content-container alert alert alert-danger\" style=\"margin-bottom:0;\">\n\t\t\t\n\t\t\t\t<div class=\"errorcontent-message\" [innerHTML]=\"errorMessage\"></div>\n\t\t\t\t<div [hidden]=\"hasErrorDetail === false\">\n\t\t\t\t\t<input style=\"float:right\" type=\"checkbox\" id=\"showerrordetailcheck\" [(ngModel)]=\"showErrorDetail\" >\n\t\t\t\t\t<label style=\"float:right; margin-right: 10px;\" class=\"form-check-label\" for=\"showerrordetailcheck\">{{ 'common.details' | translate:param }}</label>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t<div id=\"errorcontent-detail\" style=\"padding: 10px; background-color:#d9e3ea; \" [hidden]=\"showErrorDetail === false\">\n\t\t\t\t\t<div style=\"height: 300px; width: 100%; overflow: auto;\">\n\t\t\t\t\t\t<pre [innerHTML]=\"errorDetails\"></pre> \n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t\n\t\t\t\n\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t\t<div class=\"modal-footer\">\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideModal()\"><i class=\"material-icons\">close</i></button>\n\t\t\t\t</div>\n\t\t\t</div>\n\t</div>\n\t\t\t\n</div>\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html": 
        /*!****************************************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html ***!
          \****************************************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"showLoading\" id=\"loadingdialog\" role=\"dialog\" style=\"display: block; padding-right: 17px;background-color: #808080D0;\">\n\t<div class=\"loading\" role=\"document\">\n\t\t\t\n\t</div>\n\t\t\t\n</div>\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html": 
        /*!**********************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html ***!
          \**********************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<h1>About!</h1>\r\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html": 
        /*!**************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html ***!
          \**************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<app-top-bar [menus]=\"appMenus\" [currentUser]=\"appCurrentUser\" [isLogged]=\"appIsLogged\" (loggingOut)=\"onLoggingOut($event)\"></app-top-bar>\r\n\r\n<div class=\"container\">\r\n    \r\n\t<router-outlet></router-outlet>\r\n\t\r\n</div>\r\n\r\n<app-message-bar [currentUser]=\"appCurrentUser\" [isLogged]=\"appIsLogged\"></app-message-bar>\r\n\r\n<app-error-dialog></app-error-dialog>\r\n\r\n<app-loading-dialog></app-loading-dialog>\r\n\r\n<app-footer></app-footer>\r\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html": 
        /*!************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/footer/footer.component.html ***!
          \************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<footer class=\"footer\">\r\n    <strong><span>{{ 'site.footer' | translate:param }}</span></strong>\r\n\t<span class=\"footer-title\"></span>\r\n</footer>");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html": 
        /*!********************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html ***!
          \********************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<h1>Home!</h1>\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html": 
        /*!**********************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html ***!
          \**********************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<div class=\"login-container-parent layout-align-center-center layout-row\" layout=\"row\" layout-align=\"center center\">\r\n\t<div class=\"login-container\">\r\n\t\t<form method=\"POST\" [formGroup]=\"loginForm\" id=\"formlogin\" >\r\n          <div class=\"form-group\">\r\n\t          <label>{{ 'common.companyidentificator' | translate:param }}</label> \r\n\t          <input type=\"text\" name=\"companyid\" autofocus=\"\" formControlName=\"companyid\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.companyid.errors }\">          \r\n\t          <div *ngIf=\"submitted && forms.companyid.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.companyid.errors.required\">CopmayId is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.username' | translate:param }}</label> \r\n\t          <input type=\"text\" name=\"username\" autofocus=\"\" formControlName=\"username\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.username.errors }\">\r\n\t          <div *ngIf=\"submitted && forms.username.errors\" class=\"invalid-feedback\">\r\n\t              <div *ngIf=\"forms.username.errors.required\">Username is required</div>\r\n\t          </div>\r\n          </div>\r\n          <div class=\"form-group\">          \r\n\t          <label>{{ 'common.password' | translate:param }}</label> \r\n\t          <input type=\"password\" name=\"password\" formControlName=\"password\" class=\"form-control\" [ngClass]=\"{ 'is-invalid': submitted && forms.password.errors }\"> \r\n\t          <div *ngIf=\"submitted && forms.password.errors\" class=\"invalid-feedback\">\r\n\t            <div *ngIf=\"forms.password.errors.required\">Password is required</div>\r\n\t          </div>\r\n          </div>  \r\n          <div layout=\"row\" class=\"layout-row form-group\">\r\n             \r\n\t\t\t<button (click)=\"onSubmit()\" type=\"button\" [disabled]=\"loading\" class=\"btn btn-primary\">\r\n\t\t\t   <span *ngIf=\"loading\" class=\"spinner-border spinner-border-sm mr-1\"></span>\r\n\t\t\t   {{ 'common.login' | translate:param }}\r\n\t\t\t</button>\r\n            <div *ngIf=\"submitted && failedLogin\" class=\"invalid-message\">\r\n              <div>{{loginResponse.message}}</div>\r\n            </div>\r\n\t\t\t\r\n          </div> \r\n\t\t</form>\r\n\t\t\r\n\t</div>\r\n\r\n</div>\r\n\r\n\r\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html": 
        /*!**********************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/message-bar/message-bar.component.html ***!
          \**********************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<div mwlResizable [enableGhostResize]=\"true\" [resizeEdges]=\"{ bottom: false, right: false, top: true, left: false }\" (resizeEnd)=\"onResizeEnd($event)\" class=\"message-panel-container\" id=\"message-panel-container\" *ngIf=\"isAppLogged\">\n\t<div class=\"message-panel-toolbar\">\n\t\t<span class=\"title\">Meldungen</span>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"closeMessages();\"><i class=\"material-icons\">keyboard_arrow_down</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed == false\" (click)=\"showMessages();\"><i class=\"material-icons\">keyboard_arrow_up</i></button>\n\t\t<button class=\"toolbar-button\" *ngIf=\"messagePanelShowed\" (click)=\"reloadMessages(true);\"><i class=\"material-icons\">refresh</i></button>\n\t\t<img class=\"toolbar-image\" *ngIf=\"isReloadingMessages\" src=\"assets/images/loading200.gif\" />\n\t\n\t</div>\n\t<div class=\"message-panel-items-container\">\n\t\t<div class=\"message-panel-item\" *ngFor=\"let message of messages;\">\n\t\t\t<a href=\"javascript:void(0);\" (click)=\"showWorkflowView(message.workflowIdentity)\">\n\t\t\t\t<div>{{message.message}} ({{message.workflow.workflowType.title}}) ({{message.createdAtString}}) ({{message.remainingDays}}) ({{message.status}})</div>\n\t\t\t</a>\n\t\t</div>\n\t</div>\n\t\t\t\t\t\n</div>\n\n<div class=\"modal fade show\" tabindex=\"-1\" *ngIf=\"viewWorkflow\" id=\"viewworkflowedialog\" role=\"dialog\">\n\n\t<div class=\"modal-dialog modal-dialog-centered\" role=\"document\">\n\t\t<div class=\"modal-content\">\n\t\t\t<div class=\"modal-header\">\n\t\t\t\t<h5 class=\"modal-title dialog-title\" id=\"errorMessagedialogTitle\">{{ 'common.view-workflow' | translate:param }}</h5>\n\t\t\t\t<button class=\"dialog-toolbar-button close\" (click)=\"hideViewModal()\" aria-label=\"Close\">\n\t\t\t\t\t<i class=\"material-icons\">close</i>\n\t\t\t\t</button>\n\t\t\t</div>\n\t\t\t\n\t\t      <div class=\"modal-body\">\n\t\t      \n\t\t\t\t<div class=\"content-container\">\n\t\t\t\t\n\t\t\t\t\t<div class=\"workflowview-dialog-content-container\">\n\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-title' | translate:param }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">{{viewWorkflowModel.workflowType.title}}</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-comments' | translate:param }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">{{viewWorkflowModel.comments}}</div>\t\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-current-step' | translate:param }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t{{viewWorkflowModel.currentStep.title}}\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t<div class=\"item-label\">{{ 'workflow-status' | translate:param }}</div>\n\t\t\t\t\t\t\t\t<div class=\"item-content\">\n\t\t\t\t\t\t\t\t\t{{viewWorkflowModel.status}}\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"padding-top: 10px; padding-left: 10px; border-top: 1px solid gray; margin-top: 10px;\">\n\t\t\t\t\t\t\t\t<div style=\"text-align: center; font-weight: bold;\">Files</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\" *ngFor=\"let file of viewWorkflowModel.files;\" style=\"border-bottom: 1px #9a9a9a dashed\">\n\t\t\t\t\t\t\t\t\t<div>\n\t\t\t\t\t\t\t\t\t\t<a href=\"/workflow/file/view/{{viewWorkflowModel.identity}}/{{file.identity}}\" class=\"workflow-file-view-link\" target=\"_blank\">\n\t\t\t\t\t\t\t\t\t\t\t<strong>{{file.title}}</strong> (Ver: {{file.activeFileVersion}})\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t\t<a href=\"/workflow/file/download/{{viewWorkflowModel.identity}}/{{file.identity}}\" class=\"workflow-file-view-link\" target=\"_blank\">\n\t\t\t\t\t\t\t\t\t\t\t<i class=\"material-icons\">save_alt</i>\n\t\t\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t\t\t\t</div> \n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div style=\"padding-top: 10px; padding-left: 10px; border-top: 1px solid gray; margin-top: 10px;\">\n\t\t\t\t\t\t\t\t<div style=\"text-align: center; font-weight: bold;\">Actions</div>\n\t\t\t\t\t\t\t\t<div class=\"item-row\" *ngFor=\"let action of viewWorkflowModel.actions;\" style=\"border-bottom: 1px #9a9a9a dashed\">\n\t\t\t\t\t\t\t\t\t<div class=\"item-row\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"action-content\">\n\t\t\t\t\t\t\t\t\t\t\t<div><strong>{{action.currentStep.title}}</strong>:</div> \n\t\t\t\t\t\t\t\t\t\t\t<div>({{action.status}}) ({{action.assignToUserName}})</div> \n\t\t\t\t\t\t\t\t\t\t\t<div style=\"\">{{action.action}}</div>\n\t\t\t\t\t\t\t\t\t\t</div>\t\n\t\t\t\t\t\t\t\t\t\t<div class=\"clear\"></div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n\t\t\t\t\t\n\t\t\t\t\n\t\t\t\t</div>\n\t   \t\t\t\t\n\t\t      </div>\n\t      <div class=\"modal-footer\">\n\t\t\t<button type=\"button\" class=\"btn btn-secondary\" (click)=\"hideViewModal()\"><i class=\"material-icons\">close</i></button>\n\n\t\t\t<button type=\"button\" class=\"btn btn-success\"  *ngIf=\"viewWorkflowModel.notAssigned\" (click)=\"assignWorkflowMe(viewWorkflowModel.identity)\"><i class=\"material-icons\">assignment_ind</i></button>\n\n\t        <a type=\"button\" class=\"btn btn-primary\" *ngIf=\"viewWorkflowModel.meAssigned\" href=\"/workflow/edit/{{viewWorkflowModel.identity}}\"><i class=\"material-icons\">pageview</i></a>\n\t      </div>\n\t    </div>\n\t  </div>\t\t    \n\n\n\t\t\t\n</div>\n\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html": 
        /*!**************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/top-bar/top-bar.component.html ***!
          \**************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("<header>\r\n\r\n\t\t<nav class=\"navbar navbar-expand-lg navbar-toggleable-md navbar-light bg-light navbar-fixed-top\">\r\n\t\t\t<div class=\"container-fluid\">\r\n\t\t\t\t<div class=\"navbar-header\">\r\n\t\t\t\t\t<a class=\"navbar-brand\" href=\"/\"><img class=\"logo\" src=\"/images/fbim2.png\"></a>\r\n\t\t\t\t</div>\r\n\t\t\t\t<ul class=\"navbar-nav\" *ngIf=\"isLogged\">\r\n\t\t\t\t\t<li class=\"nav-item\" *ngFor=\"let menu of menus;\" [ngClass]=\"{'dropdown' : menu.children.length > 0}\">\r\n\t\t\t\t\t\t<a class=\"nav-link\" [routerLink]=\"[menu.url]\" *ngIf=\"menu.children.length == 0\">\r\n\t\t\t\t\t\t\t<span class=\"glyphicon glyphicon-home menu-image\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" *ngIf=\"menu.children.length > 0\" href=\"#\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t\t\t\t<span class=\"{{menu.image}}\"></span>\r\n\t\t\t\t\t\t\t<span>{{menu.label}}</span>\r\n\t\t\t\t\t\t\t<span class=\"caret\"></span>\r\n\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t<div class=\"dropdown-menu\" *ngIf=\"menu.children.length > 0\">\r\n\t\t\t\t\t\t\t<a [routerLink]=\"[submenu.url]\" *ngFor=\"let submenu of menu.children;\" class=\"dropdown-item\">\r\n\t\t\t\t\t\t\t\t<span class=\"{{submenu.image}}\"></span>\r\n\t\t\t\t\t\t\t\t<span>{{submenu.label}}</span>\r\n\t\t\t\t\t\t\t</a>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t</ul>\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t\r\n\t\t\t\t<div class=\"btn-group navbar-user-detail\" *ngIf=\"isLogged\" >\r\n\t\t\t\t  <button type=\"button\" class=\"btn user-toggle-button\" data-toggle=\"dropdown\" data-display=\"static\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n\t\t\t\t    <span>{{currentUser.fullName}}</span>\r\n\t\t\t\t  </button>\r\n\t\t\t\t  <div class=\"dropdown-menu dropdown-menu-lg-right\">\r\n\t\t\t\t    <button (click)=\"showProfile()\" class=\"dropdown-item\" type=\"button\">Profile</button>\r\n\t\t\t\t    <div class=\"dropdown-divider\"></div>\r\n\t\t\t\t    <button (click)=\"logout()\"  class=\"dropdown-item\" type=\"button\">Logout</button>\r\n\t\t\t\t  </div>\r\n\t\t\t\t</div>\r\n\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t</nav>    \t\t\t    \r\n\t\t\r\n\t        \r\n</header>\r\n\r\n<div style=\"background-color: #eeeeee;\">\r\n\t<ul class=\"breadcrumb\">\r\n\t\t<li>\r\n\t\t\t<span>Home</span>\r\n\t\t</li>\r\n\t\t<li>\r\n\t\t\t<button (click)=\"test()\" type=\"button\">Test</button>\r\n\t\t</li>\r\n\t</ul>\r\n\t\r\n\t\r\n</div>\r\n\t");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-create/workflow-create.component.html": 
        /*!********************************************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-create/workflow-create.component.html ***!
          \********************************************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\r\n\t\t\t<div class=\"page-toolbar\">\r\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-create' | translate:param }}</div>\r\n\t\t\t\t<a class=\"toolbar-link\" [routerLink]=\"['/workflow/list']\"><i class=\"material-icons\">list</i></a>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t\t<div class=\"workflow-content\">\r\n\t\t\t\t<div class=\"item-row\">\r\n\t\t\t\t\t<div class=\"list-group\">\r\n\t\t\t\t\t  <a class=\"list-group-item list-group-item-action list-group-item-title\">{{ 'workflow-type' | translate:param }}</a>\r\n\t\t\t\t\t  <a *ngFor=\"let type of worlflowTypes;\" [routerLink]=\"['/workflow/' + type.controllerPreffix + '/create']\" class=\"list-group-item list-group-item-action link-out\" >{{type.title}}</a>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div class=\"clear\"></div>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\r\n\t\t</div>\r\n\r\n\r\n\r\n");
            /***/ 
        }),
        /***/ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html": 
        /*!****************************************************************************************************************!*\
          !*** ./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html ***!
          \****************************************************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\t\t<div class=\"content-container\">\r\n\t\t\t<div class=\"page-toolbar\">\r\n\t\t\t\t<div class=\"page-title\">{{ 'menu-workflow-list' | translate:param }}</div>\r\n\t\t\t\t<button class=\"toolbar-button\" (click)=\"reload()\"><i class=\"material-icons\">refresh</i></button>\r\n\t\t\t\t<a class=\"toolbar-link\" href=\"/workflow/create\"><i class=\"material-icons\">playlist_add</i></a>\r\n\t\t\t\t\r\n\t\t\t\t<ul class=\"nav nav-pills search-toolbar\">\r\n\t\t\t\t\t<li class=\"nav-item dropdown\">\r\n\t\t\t\t\t\t<a class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Status</a>\r\n\t\t\t\t\t\t<div class=\"dropdown-menu\">\r\n\t\t\t\t\t\t\t<div *ngFor=\"let wstatus of statusList;\" class=\"dropdown-item\">\r\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"form-check-input\" [checked]=\"isStatusSelected(wstatus)\" (click)=\"toggleStatusSelected(wstatus)\"  id=\"status-check-{{wstatus}}\">\r\n\t\t\t\t\t\t\t\t<label class=\"form-check-label\" for=\"status-check-{{wstatus}}\">{{wstatus}}</label>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</li>\r\n\t\t\t\t  \t<li class=\"nav-item\">\r\n\t\t\t\t  \t\t<div class=\"dropdown-item search-toolbar-item\">\r\n\t\t\t\t\t\t\t<input type=\"checkbox\" class=\"toggle-checkbox form-check-input\" [checked]=\"isMeAssigned\" [(ngModel)]=\"isMeAssigned\"  id=\"me-assigned-check\">\r\n\t\t\t\t\t\t\t<label class=\"form-check-label\" for=\"me-assigned-check\">{{ 'workflow-assigned-me' | translate:param }}</label>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t  \t</li>\r\n\t\t\t\t</ul>\t\t\t\t\r\n\t\t\t\t\t\t\t\t\r\n\t\t\t</div>\r\n\t\t\t<div style=\"border: 1px solid gray; padding: 5px; background-color: #f1f1f1;\">{{debugSearchFilter}}</div>\r\n\t\t\t\r\n\t\t    <table class=\"table table-bordered table-responsive iflow-table\">\r\n\t\t    \t<thead class=\"thead-dark\">\r\n\t\t    \t\t<tr>\r\n\t\t    \t\t\t<th scope=\"col\">{{ 'workflow-type' | translate:param }}</th>\r\n\t\t    \t\t\t<th scope=\"col\">{{ 'workflow-current-step' | translate:param }}</th>\r\n\t\t    \t\t\t<th scope=\"col\">{{ 'workflow-status' | translate:param }}</th>\r\n\t\t    \t\t\t<th scope=\"col\">{{ 'workflow-assignto' | translate:param }}</th>\r\n\t\t    \t\t\t<th scope=\"col\"></th>\r\n\t\t    \t\t</tr>\r\n\t\t    \t</thead>\r\n\t\t    \t<tbody>\r\n\t\t     \t\t<tr *ngFor=\"let item of resultWorlflows;\">\r\n\t\t    \t\t\t<td scope=\"row\">{{item.workflowType.title}}</td>\r\n\t\t    \t\t\t<td>{{item.currentStep.title}}</td>\r\n\t\t    \t\t\t<td>{{item.status}}</td>\r\n\t\t    \t\t\t<td>{{item.assignToUserFullName}}</td>\r\n\t\t    \t\t\t<td><a class=\"tool-link\" [routerLink]=\"['/workflow/edit/' + item.workflowType.identity + '/' + item.identity + '/' + item.currentStep.identity]\"><i class=\"material-icons\">edit</i></a></td>\r\n\t\t    \t\t</tr>\r\n\t\t     \t\t\r\n\t\t    \t\r\n\t\t    \t</tbody>\r\n\t\t    </table>\r\n\t\t    \r\n\t\t    <div style=\"min-height: 20px; border: 1px solid gray; \">\r\n\t\t    {{searchFilter}}\r\n\t\t    </div>\r\n\t\t    \r\n\t\t    <script type=\"text/javascript\">\r\n\t\t\t\tvar loadInitialUrl = \"/workflow/general/data/initsearch\";\r\n\t\t\t\tvar loadUrl = \"/workflow/general/data/search\";\r\n\t\t    </script>\r\n\t\t\r\n\t\t\r\n\t\t</div>\r\n\r\n");
            /***/ 
        }),
        /***/ "./node_modules/tslib/tslib.es6.js": 
        /*!*****************************************!*\
          !*** ./node_modules/tslib/tslib.es6.js ***!
          \*****************************************/
        /*! exports provided: __extends, __assign, __rest, __decorate, __param, __metadata, __awaiter, __generator, __exportStar, __values, __read, __spread, __spreadArrays, __await, __asyncGenerator, __asyncDelegator, __asyncValues, __makeTemplateObject, __importStar, __importDefault */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__extends", function () { return __extends; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__assign", function () { return __assign; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__rest", function () { return __rest; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__decorate", function () { return __decorate; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__param", function () { return __param; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__metadata", function () { return __metadata; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__awaiter", function () { return __awaiter; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__generator", function () { return __generator; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__exportStar", function () { return __exportStar; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__values", function () { return __values; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__read", function () { return __read; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__spread", function () { return __spread; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__spreadArrays", function () { return __spreadArrays; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__await", function () { return __await; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncGenerator", function () { return __asyncGenerator; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncDelegator", function () { return __asyncDelegator; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__asyncValues", function () { return __asyncValues; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__makeTemplateObject", function () { return __makeTemplateObject; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importStar", function () { return __importStar; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "__importDefault", function () { return __importDefault; });
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
            var extendStatics = function (d, b) {
                extendStatics = Object.setPrototypeOf ||
                    ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
                    function (d, b) { for (var p in b)
                        if (b.hasOwnProperty(p))
                            d[p] = b[p]; };
                return extendStatics(d, b);
            };
            function __extends(d, b) {
                extendStatics(d, b);
                function __() { this.constructor = d; }
                d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
            }
            var __assign = function () {
                __assign = Object.assign || function __assign(t) {
                    for (var s, i = 1, n = arguments.length; i < n; i++) {
                        s = arguments[i];
                        for (var p in s)
                            if (Object.prototype.hasOwnProperty.call(s, p))
                                t[p] = s[p];
                    }
                    return t;
                };
                return __assign.apply(this, arguments);
            };
            function __rest(s, e) {
                var t = {};
                for (var p in s)
                    if (Object.prototype.hasOwnProperty.call(s, p) && e.indexOf(p) < 0)
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
                if (typeof Reflect === "object" && typeof Reflect.decorate === "function")
                    r = Reflect.decorate(decorators, target, key, desc);
                else
                    for (var i = decorators.length - 1; i >= 0; i--)
                        if (d = decorators[i])
                            r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
                return c > 3 && r && Object.defineProperty(target, key, r), r;
            }
            function __param(paramIndex, decorator) {
                return function (target, key) { decorator(target, key, paramIndex); };
            }
            function __metadata(metadataKey, metadataValue) {
                if (typeof Reflect === "object" && typeof Reflect.metadata === "function")
                    return Reflect.metadata(metadataKey, metadataValue);
            }
            function __awaiter(thisArg, _arguments, P, generator) {
                return new (P || (P = Promise))(function (resolve, reject) {
                    function fulfilled(value) { try {
                        step(generator.next(value));
                    }
                    catch (e) {
                        reject(e);
                    } }
                    function rejected(value) { try {
                        step(generator["throw"](value));
                    }
                    catch (e) {
                        reject(e);
                    } }
                    function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
                    step((generator = generator.apply(thisArg, _arguments || [])).next());
                });
            }
            function __generator(thisArg, body) {
                var _ = { label: 0, sent: function () { if (t[0] & 1)
                        throw t[1]; return t[1]; }, trys: [], ops: [] }, f, y, t, g;
                return g = { next: verb(0), "throw": verb(1), "return": verb(2) }, typeof Symbol === "function" && (g[Symbol.iterator] = function () { return this; }), g;
                function verb(n) { return function (v) { return step([n, v]); }; }
                function step(op) {
                    if (f)
                        throw new TypeError("Generator is already executing.");
                    while (_)
                        try {
                            if (f = 1, y && (t = op[0] & 2 ? y["return"] : op[0] ? y["throw"] || ((t = y["return"]) && t.call(y), 0) : y.next) && !(t = t.call(y, op[1])).done)
                                return t;
                            if (y = 0, t)
                                op = [op[0] & 2, t.value];
                            switch (op[0]) {
                                case 0:
                                case 1:
                                    t = op;
                                    break;
                                case 4:
                                    _.label++;
                                    return { value: op[1], done: false };
                                case 5:
                                    _.label++;
                                    y = op[1];
                                    op = [0];
                                    continue;
                                case 7:
                                    op = _.ops.pop();
                                    _.trys.pop();
                                    continue;
                                default:
                                    if (!(t = _.trys, t = t.length > 0 && t[t.length - 1]) && (op[0] === 6 || op[0] === 2)) {
                                        _ = 0;
                                        continue;
                                    }
                                    if (op[0] === 3 && (!t || (op[1] > t[0] && op[1] < t[3]))) {
                                        _.label = op[1];
                                        break;
                                    }
                                    if (op[0] === 6 && _.label < t[1]) {
                                        _.label = t[1];
                                        t = op;
                                        break;
                                    }
                                    if (t && _.label < t[2]) {
                                        _.label = t[2];
                                        _.ops.push(op);
                                        break;
                                    }
                                    if (t[2])
                                        _.ops.pop();
                                    _.trys.pop();
                                    continue;
                            }
                            op = body.call(thisArg, _);
                        }
                        catch (e) {
                            op = [6, e];
                            y = 0;
                        }
                        finally {
                            f = t = 0;
                        }
                    if (op[0] & 5)
                        throw op[1];
                    return { value: op[0] ? op[1] : void 0, done: true };
                }
            }
            function __exportStar(m, exports) {
                for (var p in m)
                    if (!exports.hasOwnProperty(p))
                        exports[p] = m[p];
            }
            function __values(o) {
                var m = typeof Symbol === "function" && o[Symbol.iterator], i = 0;
                if (m)
                    return m.call(o);
                return {
                    next: function () {
                        if (o && i >= o.length)
                            o = void 0;
                        return { value: o && o[i++], done: !o };
                    }
                };
            }
            function __read(o, n) {
                var m = typeof Symbol === "function" && o[Symbol.iterator];
                if (!m)
                    return o;
                var i = m.call(o), r, ar = [], e;
                try {
                    while ((n === void 0 || n-- > 0) && !(r = i.next()).done)
                        ar.push(r.value);
                }
                catch (error) {
                    e = { error: error };
                }
                finally {
                    try {
                        if (r && !r.done && (m = i["return"]))
                            m.call(i);
                    }
                    finally {
                        if (e)
                            throw e.error;
                    }
                }
                return ar;
            }
            function __spread() {
                for (var ar = [], i = 0; i < arguments.length; i++)
                    ar = ar.concat(__read(arguments[i]));
                return ar;
            }
            function __spreadArrays() {
                for (var s = 0, i = 0, il = arguments.length; i < il; i++)
                    s += arguments[i].length;
                for (var r = Array(s), k = 0, i = 0; i < il; i++)
                    for (var a = arguments[i], j = 0, jl = a.length; j < jl; j++, k++)
                        r[k] = a[j];
                return r;
            }
            ;
            function __await(v) {
                return this instanceof __await ? (this.v = v, this) : new __await(v);
            }
            function __asyncGenerator(thisArg, _arguments, generator) {
                if (!Symbol.asyncIterator)
                    throw new TypeError("Symbol.asyncIterator is not defined.");
                var g = generator.apply(thisArg, _arguments || []), i, q = [];
                return i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i;
                function verb(n) { if (g[n])
                    i[n] = function (v) { return new Promise(function (a, b) { q.push([n, v, a, b]) > 1 || resume(n, v); }); }; }
                function resume(n, v) { try {
                    step(g[n](v));
                }
                catch (e) {
                    settle(q[0][3], e);
                } }
                function step(r) { r.value instanceof __await ? Promise.resolve(r.value.v).then(fulfill, reject) : settle(q[0][2], r); }
                function fulfill(value) { resume("next", value); }
                function reject(value) { resume("throw", value); }
                function settle(f, v) { if (f(v), q.shift(), q.length)
                    resume(q[0][0], q[0][1]); }
            }
            function __asyncDelegator(o) {
                var i, p;
                return i = {}, verb("next"), verb("throw", function (e) { throw e; }), verb("return"), i[Symbol.iterator] = function () { return this; }, i;
                function verb(n, f) { i[n] = o[n] ? function (v) { return (p = !p) ? { value: __await(o[n](v)), done: n === "return" } : f ? f(v) : v; } : f; }
            }
            function __asyncValues(o) {
                if (!Symbol.asyncIterator)
                    throw new TypeError("Symbol.asyncIterator is not defined.");
                var m = o[Symbol.asyncIterator], i;
                return m ? m.call(o) : (o = typeof __values === "function" ? __values(o) : o[Symbol.iterator](), i = {}, verb("next"), verb("throw"), verb("return"), i[Symbol.asyncIterator] = function () { return this; }, i);
                function verb(n) { i[n] = o[n] && function (v) { return new Promise(function (resolve, reject) { v = o[n](v), settle(resolve, reject, v.done, v.value); }); }; }
                function settle(resolve, reject, d, v) { Promise.resolve(v).then(function (v) { resolve({ value: v, done: d }); }, reject); }
            }
            function __makeTemplateObject(cooked, raw) {
                if (Object.defineProperty) {
                    Object.defineProperty(cooked, "raw", { value: raw });
                }
                else {
                    cooked.raw = raw;
                }
                return cooked;
            }
            ;
            function __importStar(mod) {
                if (mod && mod.__esModule)
                    return mod;
                var result = {};
                if (mod != null)
                    for (var k in mod)
                        if (Object.hasOwnProperty.call(mod, k))
                            result[k] = mod[k];
                result.default = mod;
                return result;
            }
            function __importDefault(mod) {
                return (mod && mod.__esModule) ? mod : { default: mod };
            }
            /***/ 
        }),
        /***/ "./src/app/_components/alert.component.ts": 
        /*!************************************************!*\
          !*** ./src/app/_components/alert.component.ts ***!
          \************************************************/
        /*! exports provided: AlertComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AlertComponent", function () { return AlertComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            var AlertComponent = /** @class */ (function () {
                function AlertComponent() {
                }
                AlertComponent.prototype.ngOnInit = function () {
                };
                AlertComponent.prototype.ngOnDestroy = function () {
                };
                return AlertComponent;
            }());
            AlertComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'alert', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./alert.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/alert.component.html")).default })
            ], AlertComponent);
            /***/ 
        }),
        /***/ "./src/app/_components/error-dialog/error-dialog.component.css": 
        /*!*********************************************************************!*\
          !*** ./src/app/_components/error-dialog/error-dialog.component.css ***!
          \*********************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n[hidden] {\r\n  display: none !important;\r\n}\r\n\r\n\r\n#errormessagedialog .modal-dialog{\r\n\tmin-width: 50vw;\r\n    max-width: 50vw;\r\n    \r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvX2NvbXBvbmVudHMvZXJyb3ItZGlhbG9nL2Vycm9yLWRpYWxvZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtFQUNFLHdCQUF3QjtBQUMxQjs7O0FBR0E7Q0FDQyxlQUFlO0lBQ1osZUFBZTs7QUFFbkIiLCJmaWxlIjoic3JjL2FwcC9fY29tcG9uZW50cy9lcnJvci1kaWFsb2cvZXJyb3ItZGlhbG9nLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuW2hpZGRlbl0ge1xyXG4gIGRpc3BsYXk6IG5vbmUgIWltcG9ydGFudDtcclxufVxyXG5cclxuXHJcbiNlcnJvcm1lc3NhZ2VkaWFsb2cgLm1vZGFsLWRpYWxvZ3tcclxuXHRtaW4td2lkdGg6IDUwdnc7XHJcbiAgICBtYXgtd2lkdGg6IDUwdnc7XHJcbiAgICBcclxufVxyXG5cclxuXHJcbiJdfQ== */");
            /***/ 
        }),
        /***/ "./src/app/_components/error-dialog/error-dialog.component.ts": 
        /*!********************************************************************!*\
          !*** ./src/app/_components/error-dialog/error-dialog.component.ts ***!
          \********************************************************************/
        /*! exports provided: ErrorDialogComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorDialogComponent", function () { return ErrorDialogComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            /* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");
            var ErrorDialogComponent = /** @class */ (function () {
                function ErrorDialogComponent(translate, errorService) {
                    this.errorService = errorService;
                    this.showErrorDetail = false;
                    this.showError = false;
                    this.errorMessage = "";
                    this.errorDetails = "";
                    translate.setDefaultLang('de');
                    translate.use('de');
                }
                ErrorDialogComponent.prototype.ngOnInit = function () {
                    this.subscribeErrorService();
                };
                ErrorDialogComponent.prototype.subscribeErrorService = function () {
                    var _this = this;
                    this.errorService.errorSubject.subscribe(function (data) {
                        if (data && data != null) {
                            _this.errorMessage = data.errorMessage;
                            _this.errorDetails = data.errorDetail;
                            _this.showErrorDetail = false;
                            _this.showError = true;
                            //alert("error coms: " + this.errorMessage + " , show: " + (this.showError === true));
                        }
                        else {
                            _this.showError = false;
                            _this.showErrorDetail = false;
                            //alert("no error");
                        }
                        //this.subscribeErrorService();
                    });
                };
                ErrorDialogComponent.prototype.hideModal = function () {
                    this.showError = false;
                    this.showErrorDetail = false;
                };
                Object.defineProperty(ErrorDialogComponent.prototype, "hasErrorDetail", {
                    get: function () {
                        return this.errorDetails !== null && this.errorDetails !== "";
                    },
                    enumerable: true,
                    configurable: true
                });
                return ErrorDialogComponent;
            }());
            ErrorDialogComponent.ctorParameters = function () { return [
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"] },
                { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__["ErrorServiceService"] }
            ]; };
            ErrorDialogComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
                    selector: 'app-error-dialog',
                    template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./error-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/error-dialog/error-dialog.component.html")).default,
                    styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./error-dialog.component.css */ "./src/app/_components/error-dialog/error-dialog.component.css")).default]
                })
            ], ErrorDialogComponent);
            /***/ 
        }),
        /***/ "./src/app/_components/index.ts": 
        /*!**************************************!*\
          !*** ./src/app/_components/index.ts ***!
          \**************************************/
        /*! exports provided: AlertComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _alert_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./alert.component */ "./src/app/_components/alert.component.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AlertComponent", function () { return _alert_component__WEBPACK_IMPORTED_MODULE_1__["AlertComponent"]; });
            /***/ 
        }),
        /***/ "./src/app/_components/loading-dialog/loading-dialog.component.css": 
        /*!*************************************************************************!*\
          !*** ./src/app/_components/loading-dialog/loading-dialog.component.css ***!
          \*************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n.loading-container\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  \r\n}\r\n\r\n.loading\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  background-color: rgba(100, 100, 100, 0.3);\r\n  background-image: url(/assets/images/loading200.gif);\r\n  background-repeat: no-repeat;\r\n  background-position: center;\r\n}\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvX2NvbXBvbmVudHMvbG9hZGluZy1kaWFsb2cvbG9hZGluZy1kaWFsb2cuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOztBQUVBOztFQUVFLHVCQUF1QjtFQUN2Qix3QkFBd0I7O0FBRTFCOztBQUVBOztFQUVFLHVCQUF1QjtFQUN2Qix3QkFBd0I7RUFDeEIsMENBQTBDO0VBQzFDLG9EQUFvRDtFQUNwRCw0QkFBNEI7RUFDNUIsMkJBQTJCO0FBQzdCIiwiZmlsZSI6InNyYy9hcHAvX2NvbXBvbmVudHMvbG9hZGluZy1kaWFsb2cvbG9hZGluZy1kaWFsb2cuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLmxvYWRpbmctY29udGFpbmVyXHJcbntcclxuICB3aWR0aDogMTAwdncgIWltcG9ydGFudDsgXHJcbiAgaGVpZ2h0OiAxMDB2aCAhaW1wb3J0YW50OyBcclxuICBcclxufVxyXG5cclxuLmxvYWRpbmdcclxue1xyXG4gIHdpZHRoOiAxMDB2dyAhaW1wb3J0YW50OyBcclxuICBoZWlnaHQ6IDEwMHZoICFpbXBvcnRhbnQ7IFxyXG4gIGJhY2tncm91bmQtY29sb3I6IHJnYmEoMTAwLCAxMDAsIDEwMCwgMC4zKTtcclxuICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL2Fzc2V0cy9pbWFnZXMvbG9hZGluZzIwMC5naWYpO1xyXG4gIGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XHJcbiAgYmFja2dyb3VuZC1wb3NpdGlvbjogY2VudGVyO1xyXG59XHJcblxyXG5cclxuIl19 */");
            /***/ 
        }),
        /***/ "./src/app/_components/loading-dialog/loading-dialog.component.ts": 
        /*!************************************************************************!*\
          !*** ./src/app/_components/loading-dialog/loading-dialog.component.ts ***!
          \************************************************************************/
        /*! exports provided: LoadingDialogComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoadingDialogComponent", function () { return LoadingDialogComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
            var LoadingDialogComponent = /** @class */ (function () {
                function LoadingDialogComponent(loadingService) {
                    this.loadingService = loadingService;
                    this._showLoading = false;
                    this.showLoading = false;
                }
                LoadingDialogComponent.prototype.ngOnInit = function () {
                    var _this = this;
                    this.loadingService.loadingSubject.subscribe(function (data) {
                        _this.showLoading = data;
                    });
                };
                return LoadingDialogComponent;
            }());
            LoadingDialogComponent.ctorParameters = function () { return [
                { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_2__["LoadingServiceService"] }
            ]; };
            LoadingDialogComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
                    selector: 'app-loading-dialog',
                    template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./loading-dialog.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/_components/loading-dialog/loading-dialog.component.html")).default,
                    styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./loading-dialog.component.css */ "./src/app/_components/loading-dialog/loading-dialog.component.css")).default]
                })
            ], LoadingDialogComponent);
            /***/ 
        }),
        /***/ "./src/app/about/about.component.ts": 
        /*!******************************************!*\
          !*** ./src/app/about/about.component.ts ***!
          \******************************************/
        /*! exports provided: AboutComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function () { return AboutComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            var AboutComponent = /** @class */ (function () {
                function AboutComponent() {
                }
                AboutComponent.prototype.ngOnInit = function () {
                };
                return AboutComponent;
            }());
            AboutComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'app-root', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./about.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/about/about.component.html")).default })
            ], AboutComponent);
            /***/ 
        }),
        /***/ "./src/app/about/index.ts": 
        /*!********************************!*\
          !*** ./src/app/about/index.ts ***!
          \********************************/
        /*! exports provided: AboutComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _about_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./about.component */ "./src/app/about/about.component.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function () { return _about_component__WEBPACK_IMPORTED_MODULE_1__["AboutComponent"]; });
            /***/ 
        }),
        /***/ "./src/app/app.component.css": 
        /*!***********************************!*\
          !*** ./src/app/app.component.css ***!
          \***********************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7QUFFQTs7OztDQUlDIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi8qXHJcbkNvcHlyaWdodCBHb29nbGUgTExDLiBBbGwgUmlnaHRzIFJlc2VydmVkLlxyXG5Vc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0XHJcbmNhbiBiZSBmb3VuZCBpbiB0aGUgTElDRU5TRSBmaWxlIGF0IGh0dHA6Ly9hbmd1bGFyLmlvL2xpY2Vuc2VcclxuKi8iXX0= */");
            /***/ 
        }),
        /***/ "./src/app/app.component.ts": 
        /*!**********************************!*\
          !*** ./src/app/app.component.ts ***!
          \**********************************/
        /*! exports provided: AppComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppComponent", function () { return AppComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            /* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/fesm2015/platform-browser.js");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./services/global.service */ "./src/app/services/global.service.ts");
            /* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./services */ "./src/app/services/index.ts");
            var AppComponent = /** @class */ (function () {
                function AppComponent(router, autService, global, translate, titleService) {
                    var _this = this;
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
                    translate.get('site.title').subscribe(function (res) {
                        _this.titleService.setTitle(res);
                    });
                    //this.currentSessionDataObs = this.global.currentSessionDataObs;
                    this.router.routeReuseStrategy.shouldReuseRoute = function () {
                        return false;
                    };
                    this.router.events.subscribe(function (evt) {
                        if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                            if (_this.autService.isLoggedIn === true && _this.appCurrentUser === null) {
                                _this.global.loadAllSetting(null);
                            }
                            //alert("app-comp navigate. menus:" + this.appMenus.length);
                        }
                    });
                }
                AppComponent.prototype.ngOnInit = function () {
                    this.subscribeToGeneralData();
                };
                AppComponent.prototype.subscribeToGeneralData = function () {
                    var _this = this;
                    this.global.currentSessionDataSubject.subscribe(function (data) {
                        console.log("set gloabl-data from app-comp. appIsLogged: " + _this.appIsLogged);
                        //alert("from app-comp: \n" + JSON.stringify(data));
                        if (data && data !== null) {
                            var value = data.isLogged + "";
                            if (value === "true" === true) {
                                _this.appMenus = data.app.menus;
                                _this.appCurrentUser = data.user.currentUser;
                                _this.appIsLogged = true;
                            }
                            else {
                                _this.appMenus = [];
                                _this.appCurrentUser = null;
                                _this.appIsLogged = false;
                            }
                        }
                        else {
                            _this.appMenus = [];
                            _this.appCurrentUser = null;
                            _this.appIsLogged = false;
                        }
                    });
                };
                AppComponent.prototype.showLoading = function () {
                    this.appShowLoading = true;
                };
                AppComponent.prototype.onLoggingOut = function (data) {
                    this.autService.logout();
                    this.global.clear();
                    this.router.navigate(['/auth/login']);
                };
                return AppComponent;
            }());
            AppComponent.ctorParameters = function () { return [
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
                { type: _angular_platform_browser__WEBPACK_IMPORTED_MODULE_4__["Title"] }
            ]; };
            AppComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
                    selector: 'app-root',
                    template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./app.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/app.component.html")).default,
                    providers: [_services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"]],
                    styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./app.component.css */ "./src/app/app.component.css")).default]
                })
            ], AppComponent);
            /***/ 
        }),
        /***/ "./src/app/app.module.ts": 
        /*!*******************************!*\
          !*** ./src/app/app.module.ts ***!
          \*******************************/
        /*! exports provided: createTranslateLoader, AppModule */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "createTranslateLoader", function () { return createTranslateLoader; });
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AppModule", function () { return AppModule; });
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
            /* harmony import */ var _wm_components_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! ./wm-components/workflow-create/workflow-create.component */ "./src/app/wm-components/workflow-create/workflow-create.component.ts");
            /* harmony import */ var _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! ./wm-components/workflow-list/workflow-list.component */ "./src/app/wm-components/workflow-list/workflow-list.component.ts");
            function createTranslateLoader(http) {
                return new _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_7__["TranslateHttpLoader"](http, './assets/i18n/', '.json');
            }
            var AppModule = /** @class */ (function () {
                function AppModule() {
                }
                return AppModule;
            }());
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
                        _wm_components_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_23__["WorkflowCreateComponent"],
                        _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_24__["WorkflowListComponent"],
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
            /***/ 
        }),
        /***/ "./src/app/app.routing.ts": 
        /*!********************************!*\
          !*** ./src/app/app.routing.ts ***!
          \********************************/
        /*! exports provided: appRoutingModule */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "appRoutingModule", function () { return appRoutingModule; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
            /* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
            /* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
            /* harmony import */ var _wm_components_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./wm-components/workflow-create/workflow-create.component */ "./src/app/wm-components/workflow-create/workflow-create.component.ts");
            /* harmony import */ var _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./wm-components/workflow-list/workflow-list.component */ "./src/app/wm-components/workflow-list/workflow-list.component.ts");
            /* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
            //import { AuthGuard } from './helper';
            var routes = [
                { path: '', component: _home__WEBPACK_IMPORTED_MODULE_2__["HomeComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"]] },
                { path: 'about', component: _about__WEBPACK_IMPORTED_MODULE_3__["AboutComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"]] },
                { path: 'workflow/list', component: _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_6__["WorkflowListComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"]] },
                { path: 'workflow/create', component: _wm_components_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_5__["WorkflowCreateComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"]] },
                { path: 'auth/login', component: _login__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"] },
                // otherwise redirect to home
                { path: '**', redirectTo: '', canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"]] }
            ];
            var appRoutingModule = _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterModule"].forRoot(routes);
            /***/ 
        }),
        /***/ "./src/app/footer/footer.component.css": 
        /*!*********************************************!*\
          !*** ./src/app/footer/footer.component.css ***!
          \*********************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n/*\r\nCopyright Google LLC. All Rights Reserved.\r\nUse of this source code is governed by an MIT-style license that\r\ncan be found in the LICENSE file at http://angular.io/license\r\n*/\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9vdGVyL2Zvb3Rlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7Ozs7Q0FJQyIsImZpbGUiOiJzcmMvYXBwL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLypcclxuQ29weXJpZ2h0IEdvb2dsZSBMTEMuIEFsbCBSaWdodHMgUmVzZXJ2ZWQuXHJcblVzZSBvZiB0aGlzIHNvdXJjZSBjb2RlIGlzIGdvdmVybmVkIGJ5IGFuIE1JVC1zdHlsZSBsaWNlbnNlIHRoYXRcclxuY2FuIGJlIGZvdW5kIGluIHRoZSBMSUNFTlNFIGZpbGUgYXQgaHR0cDovL2FuZ3VsYXIuaW8vbGljZW5zZVxyXG4qLyJdfQ== */");
            /***/ 
        }),
        /***/ "./src/app/footer/footer.component.ts": 
        /*!********************************************!*\
          !*** ./src/app/footer/footer.component.ts ***!
          \********************************************/
        /*! exports provided: FooterComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FooterComponent", function () { return FooterComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            var FooterComponent = /** @class */ (function () {
                function FooterComponent(translate) {
                    translate.setDefaultLang('de');
                    translate.use('de');
                }
                FooterComponent.prototype.ngOnInit = function () {
                };
                return FooterComponent;
            }());
            FooterComponent.ctorParameters = function () { return [
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"] }
            ]; };
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
            /***/ 
        }),
        /***/ "./src/app/home/home.component.ts": 
        /*!****************************************!*\
          !*** ./src/app/home/home.component.ts ***!
          \****************************************/
        /*! exports provided: HomeComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function () { return HomeComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            var HomeComponent = /** @class */ (function () {
                function HomeComponent() {
                }
                HomeComponent.prototype.ngOnInit = function () {
                };
                return HomeComponent;
            }());
            HomeComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ selector: 'app-root', template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./home.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/home/home.component.html")).default })
            ], HomeComponent);
            /***/ 
        }),
        /***/ "./src/app/home/index.ts": 
        /*!*******************************!*\
          !*** ./src/app/home/index.ts ***!
          \*******************************/
        /*! exports provided: HomeComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _home_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./home.component */ "./src/app/home/home.component.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function () { return _home_component__WEBPACK_IMPORTED_MODULE_1__["HomeComponent"]; });
            /***/ 
        }),
        /***/ "./src/app/login/index.ts": 
        /*!********************************!*\
          !*** ./src/app/login/index.ts ***!
          \********************************/
        /*! exports provided: LoginComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./login.component */ "./src/app/login/login.component.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function () { return _login_component__WEBPACK_IMPORTED_MODULE_1__["LoginComponent"]; });
            /***/ 
        }),
        /***/ "./src/app/login/login.component.ts": 
        /*!******************************************!*\
          !*** ./src/app/login/login.component.ts ***!
          \******************************************/
        /*! exports provided: LoginComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function () { return LoginComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/fesm2015/forms.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            /* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
            /* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services */ "./src/app/services/index.ts");
            var LoginComponent = /** @class */ (function () {
                function LoginComponent(formBuilder, route, router, autService, global, translate) {
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
                LoginComponent.prototype.ngOnInit = function () {
                    this.loginForm = this.formBuilder.group({
                        username: ['admin@iflow.de', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
                        password: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
                        companyid: [localStorage.getItem('companyId'), _angular_forms__WEBPACK_IMPORTED_MODULE_3__["Validators"].required],
                    });
                };
                Object.defineProperty(LoginComponent.prototype, "forms", {
                    get: function () { return this.loginForm.controls; },
                    enumerable: true,
                    configurable: true
                });
                LoginComponent.prototype.onSubmit = function () {
                    this.submitted = true;
                    this.failedLogin = false;
                    if (this.loginForm.invalid) {
                        return;
                    }
                    this.loading = true;
                    this.autService.login(this.loginForm.controls["username"].value, this.loginForm.controls["password"].value, this.loginForm.controls["companyid"].value, this);
                };
                LoginComponent.prototype.processLoginResult = function (loginResponse) {
                    this.loginResponse = loginResponse;
                    if (this.loginResponse.res === 'ok') {
                        localStorage.setItem('companyId', this.loginForm.controls["companyid"].value);
                        this.global.loadAllSetting(this);
                    }
                    else {
                        this.failedLogin = true;
                    }
                };
                LoginComponent.prototype.processFailedResult = function (responseObj) {
                    console.log("GET call in error", responseObj);
                    alert("GET call in error: " + responseObj);
                    this.loginResponse.message = "Error in login!";
                    this.failedLogin = true;
                };
                LoginComponent.prototype.processEndLoading = function () {
                    this.loading = false;
                };
                LoginComponent.prototype.finishGeneralDataLoading = function () {
                    this.router.navigate(['/']);
                };
                return LoginComponent;
            }());
            LoginComponent.ctorParameters = function () { return [
                { type: _angular_forms__WEBPACK_IMPORTED_MODULE_3__["FormBuilder"] },
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["ActivatedRoute"] },
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_6__["GlobalService"] },
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateService"] }
            ]; };
            LoginComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({ template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./login.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/login/login.component.html")).default })
            ], LoginComponent);
            /***/ 
        }),
        /***/ "./src/app/message-bar/message-bar.component.css": 
        /*!*******************************************************!*\
          !*** ./src/app/message-bar/message-bar.component.css ***!
          \*******************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("@charset \"ISO-8859-1\";\r\n\r\n.message-panel-container {\r\n    height: 170px;\r\n    margin-top: 10px;\r\n    border: 1px solid gray;\r\n    background-color: #fbfbe8;\r\n    position: fixed !important;\r\n    width: 100vw;\r\n    bottom: 30px;\r\n}\r\n\r\n.message-panel-toolbar{\r\n\theight: 30px;\r\n\tbackground-color: #dadccf;\t\r\n\tpadding-top: 2px;\r\n\tpadding-right: 10px;\r\n}\r\n\r\n.message-panel-toolbar span.title{\r\n\tpadding-left: 20px;\r\n\tfont-weight: bold;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.message-panel-toolbar .toolbar-button{\r\n\tfloat: right;\t\r\n}\r\n\r\n.message-panel-items-container{\r\n\theight: calc(100% - 30px);\r\n\tpadding: 4px 4px;\r\n\toverflow: auto;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item{\r\n\theight: 22px;\r\n\tline-height: 22px;\r\n\tmargin: 3px 0;\r\n\tbackground-color: #cafff9;\r\n\tpadding-left: 15px;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item:hover{\r\n\tbackground-color: #caffd3;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a{\r\n\tcolor: gray;\r\n}\r\n\r\n.message-panel-items-container .message-panel-item a:hover{\r\n\tcolor: #946b73;\r\n}\r\n\r\n.toolbar-image {\r\n    border: none;\r\n    margin-right: 10px;\r\n    width: 24px;\r\n    height: 24px;\r\n    float: right;\r\n}\r\n\r\ndiv.workflowview-dialog-content-container div.item-row {\r\n    padding: 5px 0;\r\n}\r\n\r\ndiv.workflowview-dialog-content-container div.item-label {\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflowview-dialog-content-container div.item-content {\r\n    float: left;\r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\n\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSxxQkFBcUI7O0FBRXJCO0lBQ0ksYUFBYTtJQUNiLGdCQUFnQjtJQUNoQixzQkFBc0I7SUFDdEIseUJBQXlCO0lBQ3pCLDBCQUEwQjtJQUMxQixZQUFZO0lBQ1osWUFBWTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWix5QkFBeUI7Q0FDekIsZ0JBQWdCO0NBQ2hCLG1CQUFtQjtBQUNwQjs7QUFFQTtDQUNDLGtCQUFrQjtDQUNsQixpQkFBaUI7Q0FDakIsZUFBZTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixnQkFBZ0I7Q0FDaEIsY0FBYztBQUNmOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtDQUNqQixhQUFhO0NBQ2IseUJBQXlCO0NBQ3pCLGtCQUFrQjtBQUNuQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGNBQWM7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixrQkFBa0I7SUFDbEIsV0FBVztJQUNYLFlBQVk7SUFDWixZQUFZO0FBQ2hCOztBQUVBO0lBQ0ksY0FBYztBQUNsQjs7QUFFQTtJQUNJLFdBQVc7SUFDWCxtQkFBbUI7SUFDbkIsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixlQUFlO0lBQ2YsaUJBQWlCO0lBQ2pCLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3QiIsImZpbGUiOiJzcmMvYXBwL21lc3NhZ2UtYmFyL21lc3NhZ2UtYmFyLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJAY2hhcnNldCBcIklTTy04ODU5LTFcIjtcclxuXHJcbi5tZXNzYWdlLXBhbmVsLWNvbnRhaW5lciB7XHJcbiAgICBoZWlnaHQ6IDE3MHB4O1xyXG4gICAgbWFyZ2luLXRvcDogMTBweDtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZmJmYmU4O1xyXG4gICAgcG9zaXRpb246IGZpeGVkICFpbXBvcnRhbnQ7XHJcbiAgICB3aWR0aDogMTAwdnc7XHJcbiAgICBib3R0b206IDMwcHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXJ7XHJcblx0aGVpZ2h0OiAzMHB4O1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNkYWRjY2Y7XHRcclxuXHRwYWRkaW5nLXRvcDogMnB4O1xyXG5cdHBhZGRpbmctcmlnaHQ6IDEwcHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXIgc3Bhbi50aXRsZXtcclxuXHRwYWRkaW5nLWxlZnQ6IDIwcHg7XHJcblx0Zm9udC13ZWlnaHQ6IGJvbGQ7XHJcblx0Zm9udC1zaXplOiAxNHB4O1xyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC10b29sYmFyIC50b29sYmFyLWJ1dHRvbntcclxuXHRmbG9hdDogcmlnaHQ7XHRcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVye1xyXG5cdGhlaWdodDogY2FsYygxMDAlIC0gMzBweCk7XHJcblx0cGFkZGluZzogNHB4IDRweDtcclxuXHRvdmVyZmxvdzogYXV0bztcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW17XHJcblx0aGVpZ2h0OiAyMnB4O1xyXG5cdGxpbmUtaGVpZ2h0OiAyMnB4O1xyXG5cdG1hcmdpbjogM3B4IDA7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2NhZmZmOTtcclxuXHRwYWRkaW5nLWxlZnQ6IDE1cHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtOmhvdmVye1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNjYWZmZDM7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtIGF7XHJcblx0Y29sb3I6IGdyYXk7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLWl0ZW1zLWNvbnRhaW5lciAubWVzc2FnZS1wYW5lbC1pdGVtIGE6aG92ZXJ7XHJcblx0Y29sb3I6ICM5NDZiNzM7XHJcbn1cclxuXHJcbi50b29sYmFyLWltYWdlIHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIG1hcmdpbi1yaWdodDogMTBweDtcclxuICAgIHdpZHRoOiAyNHB4O1xyXG4gICAgaGVpZ2h0OiAyNHB4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3d2aWV3LWRpYWxvZy1jb250ZW50LWNvbnRhaW5lciBkaXYuaXRlbS1yb3cge1xyXG4gICAgcGFkZGluZzogNXB4IDA7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvd3ZpZXctZGlhbG9nLWNvbnRlbnQtY29udGFpbmVyIGRpdi5pdGVtLWxhYmVsIHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIHdpZHRoOiAxMzBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93dmlldy1kaWFsb2ctY29udGVudC1jb250YWluZXIgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDEzNXB4KTtcclxufVxyXG5cclxuXHJcblxyXG4iXX0= */");
            /***/ 
        }),
        /***/ "./src/app/message-bar/message-bar.component.ts": 
        /*!******************************************************!*\
          !*** ./src/app/message-bar/message-bar.component.ts ***!
          \******************************************************/
        /*! exports provided: MessageBarComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MessageBarComponent", function () { return MessageBarComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");
            /* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/error-service.service */ "./src/app/services/error-service.service.ts");
            var MessageBarComponent = /** @class */ (function () {
                function MessageBarComponent(router, messageService, errorService) {
                    this.router = router;
                    this.messageService = messageService;
                    this.errorService = errorService;
                    this.messages = [];
                    this.viewWorkflow = false;
                    this.messageSearchInterval = 60000;
                    this.messageReloadTimeoutId = 0;
                    this.messagePanelHeight = 170;
                    this.messagePanelShowed = true;
                    this._isLogged = false;
                }
                MessageBarComponent.prototype.closeMessages = function () {
                    //$('#message-panel-container').height(25);
                    document.getElementById("message-panel-container").style.height = "25px";
                    this.messagePanelShowed = false;
                };
                ;
                MessageBarComponent.prototype.showMessages = function () {
                    //$('#message-panel-container').height(this.messagePanelHeight);
                    //alert("show pabel");
                    document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
                    this.messagePanelShowed = true;
                };
                ;
                Object.defineProperty(MessageBarComponent.prototype, "isLogged", {
                    set: function (value) {
                        //console.log("change isLogged inside comp. this: " + this._isLogged + ",   app: " + value); 	    
                        this._isLogged = value === 'true';
                        this.reloadMessages(true);
                    },
                    enumerable: true,
                    configurable: true
                });
                Object.defineProperty(MessageBarComponent.prototype, "isAppLogged", {
                    get: function () {
                        return this._isLogged;
                    },
                    enumerable: true,
                    configurable: true
                });
                Object.defineProperty(MessageBarComponent.prototype, "isReloadingMessages", {
                    get: function () {
                        return this.messageService.isReloadingMessages;
                    },
                    enumerable: true,
                    configurable: true
                });
                MessageBarComponent.prototype.ngOnInit = function () {
                    if (this._isLogged == true) {
                        console.log("start read message list from comp.");
                        this.reloadMessages(true);
                    }
                };
                MessageBarComponent.prototype.onResizeEnd = function (event) {
                    this.messagePanelHeight = event.rectangle.height;
                    document.getElementById("message-panel-container").style.height = this.messagePanelHeight + "px";
                    //alert(this.messagePanelHeight);
                };
                MessageBarComponent.prototype.reloadMessages = function (reset) {
                    clearTimeout(this.messageReloadTimeoutId);
                    //console.log("start reloadMessages.  _isLogged:" + (this._isLogged === true));
                    if (this._isLogged === true) {
                        this.subscribeService();
                        this.messageService.loadMessages(reset);
                    }
                };
                MessageBarComponent.prototype.showWorkflowView = function (identity) {
                    for (var index in this.messages) {
                        if (this.messages[index].workflowIdentity == identity) {
                            this.viewWorkflowModel = this.messages[index].workflow;
                            this.viewWorkflow = true;
                            break;
                        }
                    }
                };
                MessageBarComponent.prototype.hideViewModal = function () {
                    this.viewWorkflow = false;
                };
                MessageBarComponent.prototype.assignWorkflowMe = function (workflowIdentity) {
                    var _this = this;
                    this.messageService.assignMe(workflowIdentity).subscribe(function (val) {
                        console.log("Workflow assigned to me");
                        _this.reloadMessages(true);
                    }, function (response) {
                        console.log("Error in assigning workflow", response);
                        _this.errorService.showErrorResponse(response);
                    }, function () {
                        _this.viewWorkflow = false;
                    });
                };
                MessageBarComponent.prototype.subscribeService = function () {
                    var _this = this;
                    this.messageService.workflowMessageListSubject.subscribe(function (x) {
                        if (x != null) {
                            _this.messages = x;
                        }
                        else {
                            _this.messages = [];
                        }
                    }, function (error) {
                        //console.log("Error in read message list.", error);
                        _this.messages = [];
                    }, function () {
                        //this.messageService.workflowMessageListSubject.unsubscribe();
                        //console.log("Compelete read message list from comp. start next timeout");
                        _this.messageReloadTimeoutId = setTimeout(function () {
                            _this.reloadMessages(false);
                        }, _this.messageSearchInterval);
                    });
                };
                return MessageBarComponent;
            }());
            MessageBarComponent.ctorParameters = function () { return [
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_3__["WorkflowMessageService"] },
                { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_4__["ErrorServiceService"] }
            ]; };
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
            /***/ 
        }),
        /***/ "./src/app/services/authentication.service.ts": 
        /*!****************************************************!*\
          !*** ./src/app/services/authentication.service.ts ***!
          \****************************************************/
        /*! exports provided: AuthenticationService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function () { return AuthenticationService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            /* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
            /* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");
            var AuthenticationService = /** @class */ (function () {
                function AuthenticationService(http, global, router, loadingService) {
                    this.http = http;
                    this.global = global;
                    this.router = router;
                    this.loadingService = loadingService;
                    this.isLoggedIn = false;
                    this.authenticateUrl = "/auth/authenticate";
                    this.currentUserSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
                }
                Object.defineProperty(AuthenticationService.prototype, "currentUserValue", {
                    get: function () {
                        return this.currentUserSubject.value;
                    },
                    enumerable: true,
                    configurable: true
                });
                Object.defineProperty(AuthenticationService.prototype, "isLogedIn", {
                    get: function () {
                        return this.currentUserSubject.value != null;
                    },
                    enumerable: true,
                    configurable: true
                });
                AuthenticationService.prototype.login = function (username, password, companyid, loginComponent) {
                    var _this = this;
                    var loginData = new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"]()
                        .set('username', username)
                        .set('password', password)
                        .set('companyid', companyid);
                    var httpOptions = {
                        headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
                            'Content-Type': 'application/x-www-form-urlencoded',
                            'Authorization': 'my-auth-token'
                        })
                    };
                    this.http.post(this.authenticateUrl, loginData, httpOptions).subscribe(function (val) {
                        var loginResponse = val;
                        _this.currentUserSubject.next(loginResponse.user);
                        _this.currentUserSubject.complete();
                        _this.isLoggedIn = true;
                        loginComponent.processLoginResult(val);
                    }, function (response) {
                        _this.currentUserSubject.next(null);
                        _this.currentUserSubject.complete();
                        _this.isLoggedIn = false;
                        loginComponent.processFailedResult(response);
                    }, function () {
                        loginComponent.processEndLoading();
                    });
                };
                AuthenticationService.prototype.checkLoginState = function (returnUrl, router) {
                    var _this = this;
                    this.loadingService.showLoading();
                    this.global.loadAllSettingObserv().subscribe(function (generalData) {
                        console.log("GET call successful generaldata", generalData);
                        var value = generalData.isLogged + "";
                        if (value === "true" && generalData.user) {
                            _this.isLoggedIn = true;
                            _this.currentUserSubject.next(generalData.user.currentUser);
                            _this.currentUserSubject.complete();
                            _this.global.setGeneralData(generalData);
                            //alert("from authentication- redirect to : " + returnUrl + ": \n" + JSON.stringify(generalData));
                            router.navigate([returnUrl]);
                        }
                        else {
                            _this.isLoggedIn = false;
                            _this.currentUserSubject.next(null);
                            _this.currentUserSubject.complete();
                            //alert("from authentication- redirect to login : \n" + JSON.stringify(generalData));
                            router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
                        }
                    }, function (response) {
                        console.log("Error in read menu list", response);
                        _this.isLoggedIn = false;
                        _this.currentUserSubject.next(null);
                        _this.currentUserSubject.complete();
                        router.navigate(['auth/login'], { queryParams: { returnUrl: returnUrl } });
                    }, function () {
                        _this.loadingService.hideLoading();
                    });
                };
                AuthenticationService.prototype.logout = function () {
                    this.global.clear();
                    this.currentUserSubject.next(null);
                    this.currentUserSubject.complete();
                    window.location.assign("/logout");
                };
                AuthenticationService.prototype.canActivate = function (route, state) {
                    //alert("check authentication fo : " + state.url + " : isLoggedIn: " + this.isLoggedIn);
                    if (this.isLoggedIn === true) {
                        return true;
                    }
                    this.checkLoginState(state.url, this.router);
                    // not logged in so redirect to login page with the return url
                    //this.router.navigate(['auth/login'], { queryParams: { returnUrl: state.url } });
                    return false;
                };
                return AuthenticationService;
            }());
            AuthenticationService.ctorParameters = function () { return [
                { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] },
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_4__["Router"] },
                { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }
            ]; };
            AuthenticationService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
            ], AuthenticationService);
            /***/ 
        }),
        /***/ "./src/app/services/error-service.service.ts": 
        /*!***************************************************!*\
          !*** ./src/app/services/error-service.service.ts ***!
          \***************************************************/
        /*! exports provided: ErrorServiceService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorServiceService", function () { return ErrorServiceService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            /* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");
            var ErrorServiceService = /** @class */ (function () {
                function ErrorServiceService() {
                    this.errorSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
                }
                ErrorServiceService.prototype.showError = function (errorMessage, errorDetail) {
                    var err = new _ui_models__WEBPACK_IMPORTED_MODULE_3__["ErrorDetail"](errorMessage, errorDetail);
                    this.errorSubject.next(err);
                };
                ErrorServiceService.prototype.showErrorResponse = function (response) {
                    var errResp = new _ui_models__WEBPACK_IMPORTED_MODULE_3__["ErrorResponse"](response);
                    this.showError(errResp.message, errResp.details);
                };
                return ErrorServiceService;
            }());
            ErrorServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
                    providedIn: 'root'
                })
            ], ErrorServiceService);
            /***/ 
        }),
        /***/ "./src/app/services/global.service.ts": 
        /*!********************************************!*\
          !*** ./src/app/services/global.service.ts ***!
          \********************************************/
        /*! exports provided: GlobalService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GlobalService", function () { return GlobalService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            /* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");
            var GlobalService = /** @class */ (function () {
                function GlobalService(http, loadingService) {
                    this.http = http;
                    this.loadingService = loadingService;
                    this.currentSessionDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
                    //public currentSessionDataObs :Observable<GeneralData>;		
                    this.loadedGeneralData = null;
                    //this.currentSessionDataSubject = new BehaviorSubject<GeneralData>(null);
                    //this.currentSessionDataObs = this.currentSessionDataSubject.asObservable();		
                }
                Object.defineProperty(GlobalService.prototype, "currentSessionDataValue", {
                    get: function () {
                        return this.currentSessionDataSubject.value;
                    },
                    enumerable: true,
                    configurable: true
                });
                GlobalService.prototype.loadAllSetting = function (login) {
                    var _this = this;
                    this.loadingService.showLoading();
                    this.http.get("/general/data/generaldatat").subscribe(function (generalData) {
                        console.log("GET call successful generaldata", generalData);
                        _this.loadedGeneralData = JSON.parse(JSON.stringify(generalData));
                        _this.currentSessionDataSubject.next(generalData);
                    }, function (response) {
                        console.log("Error in read general list", response);
                    }, function () {
                        if (login != null) {
                            login.finishGeneralDataLoading();
                        }
                        _this.currentSessionDataSubject.complete();
                        _this.loadingService.hideLoading();
                    });
                };
                GlobalService.prototype.setGeneralData = function (generalData) {
                    this.currentSessionDataSubject.next(generalData);
                    this.currentSessionDataSubject.complete();
                };
                GlobalService.prototype.loadAllSettingObserv = function () {
                    return this.http.get("/general/data/generaldatat");
                };
                GlobalService.prototype.clear = function () {
                    //alert("clear global");
                    this.currentSessionDataSubject.next(null);
                    this.currentSessionDataSubject.complete();
                };
                return GlobalService;
            }());
            GlobalService.ctorParameters = function () { return [
                { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
                { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }
            ]; };
            GlobalService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
            ], GlobalService);
            /***/ 
        }),
        /***/ "./src/app/services/index.ts": 
        /*!***********************************!*\
          !*** ./src/app/services/index.ts ***!
          \***********************************/
        /*! exports provided: GlobalService, AuthenticationService, UserService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./authentication.service */ "./src/app/services/authentication.service.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function () { return _authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]; });
            /* harmony import */ var _user_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./user.service */ "./src/app/services/user.service.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "UserService", function () { return _user_service__WEBPACK_IMPORTED_MODULE_2__["UserService"]; });
            /* harmony import */ var _global_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./global.service */ "./src/app/services/global.service.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GlobalService", function () { return _global_service__WEBPACK_IMPORTED_MODULE_3__["GlobalService"]; });
            /***/ 
        }),
        /***/ "./src/app/services/loading-service.service.ts": 
        /*!*****************************************************!*\
          !*** ./src/app/services/loading-service.service.ts ***!
          \*****************************************************/
        /*! exports provided: LoadingServiceService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoadingServiceService", function () { return LoadingServiceService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            var LoadingServiceService = /** @class */ (function () {
                function LoadingServiceService() {
                    this.loadingSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](false);
                }
                LoadingServiceService.prototype.showLoading = function () {
                    this.loadingSubject.next(true);
                };
                LoadingServiceService.prototype.hideLoading = function () {
                    this.loadingSubject.next(false);
                };
                return LoadingServiceService;
            }());
            LoadingServiceService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
                    providedIn: 'root'
                })
            ], LoadingServiceService);
            /***/ 
        }),
        /***/ "./src/app/services/user.service.ts": 
        /*!******************************************!*\
          !*** ./src/app/services/user.service.ts ***!
          \******************************************/
        /*! exports provided: UserService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UserService", function () { return UserService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
            var UserService = /** @class */ (function () {
                function UserService(http) {
                    this.http = http;
                }
                UserService.prototype.getAll = function () {
                    return this.http.get("/users");
                };
                UserService.prototype.register = function (user) {
                    return this.http.post("/users/register", user);
                };
                UserService.prototype.delete = function (id) {
                    return this.http.delete("/users/${id}");
                };
                return UserService;
            }());
            UserService.ctorParameters = function () { return [
                { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }
            ]; };
            UserService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({ providedIn: 'root' })
            ], UserService);
            /***/ 
        }),
        /***/ "./src/app/services/workflow/workflow-message.service.ts": 
        /*!***************************************************************!*\
          !*** ./src/app/services/workflow/workflow-message.service.ts ***!
          \***************************************************************/
        /*! exports provided: WorkflowMessageService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessageService", function () { return WorkflowMessageService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            /* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
            /* harmony import */ var _error_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../error-service.service */ "./src/app/services/error-service.service.ts");
            var WorkflowMessageService = /** @class */ (function () {
                function WorkflowMessageService(http, errorService) {
                    this.http = http;
                    this.errorService = errorService;
                    this.loadMessageUrl = "/general/data/workflowmessages";
                    this.assignWorkflowUrl = "/general/data/workflow/assign/";
                    this.isReloadingMessages = false;
                    this.workflowMessageListSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"]([]);
                }
                Object.defineProperty(WorkflowMessageService.prototype, "workflowMessageList", {
                    get: function () {
                        return this.workflowMessageListSubject.value;
                    },
                    enumerable: true,
                    configurable: true
                });
                WorkflowMessageService.prototype.loadMessages = function (resetCach) {
                    var _this = this;
                    this.isReloadingMessages = true;
                    var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
                    var httpOptions = {
                        headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
                            'Content-Type': 'application/json; charset=UTF-8'
                        })
                    };
                    this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"](), httpOptions).subscribe(function (val) {
                        console.log("Read message list", val);
                        var messageList = val;
                        messageList = _this.buildMessageList(messageList);
                        _this.workflowMessageListSubject.next(messageList);
                    }, function (response) {
                        console.log("Error in read message list", response);
                        _this.workflowMessageListSubject.next([]);
                        _this.errorService.showErrorResponse(response);
                    }, function () {
                        _this.workflowMessageListSubject.complete();
                        setTimeout(function () {
                            _this.isReloadingMessages = false;
                        }, 500);
                    });
                };
                WorkflowMessageService.prototype.assignMe = function (workflowIdentity) {
                    this.isReloadingMessages = true;
                    var url = this.assignWorkflowUrl + workflowIdentity;
                    var httpOptions = {
                        headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpHeaders"]({
                            'Content-Type': 'application/json; charset=UTF-8'
                        })
                    };
                    return this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpParams"](), httpOptions);
                };
                WorkflowMessageService.prototype.buildMessageList = function (messages) {
                    var messageList = [];
                    for (var index in messages) {
                        var message = messages[index];
                        messageList.push(message);
                    }
                    return messageList;
                };
                return WorkflowMessageService;
            }());
            WorkflowMessageService.ctorParameters = function () { return [
                { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] },
                { type: _error_service_service__WEBPACK_IMPORTED_MODULE_4__["ErrorServiceService"] }
            ]; };
            WorkflowMessageService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
                    providedIn: 'root'
                })
            ], WorkflowMessageService);
            /***/ 
        }),
        /***/ "./src/app/services/workflow/workflow-search.service.ts": 
        /*!**************************************************************!*\
          !*** ./src/app/services/workflow/workflow-search.service.ts ***!
          \**************************************************************/
        /*! exports provided: WorkflowSearchService */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchService", function () { return WorkflowSearchService; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/fesm2015/http.js");
            /* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
            /* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../loading-service.service */ "./src/app/services/loading-service.service.ts");
            var WorkflowSearchService = /** @class */ (function () {
                function WorkflowSearchService(http, loadingService) {
                    this.http = http;
                    this.loadingService = loadingService;
                    this.searchInitialDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_3__["BehaviorSubject"](null);
                    this.loadInitialUrl = "/workflow/general/data/initsearch";
                    this.loadUrl = "/workflow/general/data/search";
                    this.listInitialData = null;
                }
                WorkflowSearchService.prototype.loadInitialData = function () {
                    var _this = this;
                    this.loadingService.showLoading();
                    var httpOptions = {
                        headers: new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpHeaders"]({
                            'Content-Type': 'application/x-www-form-urlencoded',
                            'Authorization': 'my-auth-token'
                        })
                    };
                    this.http.post(this.loadInitialUrl, new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions).subscribe(function (initialData) {
                        console.log("GET successful search inital data", initialData);
                        _this.listInitialData = JSON.parse(JSON.stringify(initialData));
                        _this.searchInitialDataSubject.next(initialData);
                    }, function (response) {
                        console.log("Error in read search inital data", response);
                    }, function () {
                        _this.searchInitialDataSubject.complete();
                        _this.loadingService.hideLoading();
                    });
                };
                return WorkflowSearchService;
            }());
            WorkflowSearchService.ctorParameters = function () { return [
                { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] },
                { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }
            ]; };
            WorkflowSearchService = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Injectable"])({
                    providedIn: 'root'
                })
            ], WorkflowSearchService);
            /***/ 
        }),
        /***/ "./src/app/top-bar/top-bar.component.css": 
        /*!***********************************************!*\
          !*** ./src/app/top-bar/top-bar.component.css ***!
          \***********************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n.navbar-user-detail {\r\n    float: right;\r\n    margin-right: 30px;\r\n}\r\n\r\nbutton.user-toggle-button {\r\n    background-color: #cecece;\r\n    border: none;\r\n    background-image: url(/scripts/static/md-contact.svg);\r\n    background-position: 140px center;\r\n    background-repeat: no-repeat;\r\n    background-size: 24px;\r\n    width: 170px;\r\n    text-align: left;\r\n    height: 34px;\r\n}   \r\n    \r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdG9wLWJhci90b3AtYmFyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHlCQUF5QjtJQUN6QixZQUFZO0lBQ1oscURBQXFEO0lBQ3JELGlDQUFpQztJQUNqQyw0QkFBNEI7SUFDNUIscUJBQXFCO0lBQ3JCLFlBQVk7SUFDWixnQkFBZ0I7SUFDaEIsWUFBWTtBQUNoQiIsImZpbGUiOiJzcmMvYXBwL3RvcC1iYXIvdG9wLWJhci5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5uYXZiYXItdXNlci1kZXRhaWwge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAzMHB4O1xyXG59XHJcblxyXG5idXR0b24udXNlci10b2dnbGUtYnV0dG9uIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNjZWNlY2U7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL3NjcmlwdHMvc3RhdGljL21kLWNvbnRhY3Quc3ZnKTtcclxuICAgIGJhY2tncm91bmQtcG9zaXRpb246IDE0MHB4IGNlbnRlcjtcclxuICAgIGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XHJcbiAgICBiYWNrZ3JvdW5kLXNpemU6IDI0cHg7XHJcbiAgICB3aWR0aDogMTcwcHg7XHJcbiAgICB0ZXh0LWFsaWduOiBsZWZ0O1xyXG4gICAgaGVpZ2h0OiAzNHB4O1xyXG59ICAgXHJcbiAgICAiXX0= */");
            /***/ 
        }),
        /***/ "./src/app/top-bar/top-bar.component.ts": 
        /*!**********************************************!*\
          !*** ./src/app/top-bar/top-bar.component.ts ***!
          \**********************************************/
        /*! exports provided: TopBarComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "TopBarComponent", function () { return TopBarComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
            var TopBarComponent = /** @class */ (function () {
                function TopBarComponent(router, global) {
                    this.router = router;
                    this.global = global;
                    this.loggingOut = new _angular_core__WEBPACK_IMPORTED_MODULE_1__["EventEmitter"]();
                }
                TopBarComponent.prototype.ngOnInit = function () {
                };
                TopBarComponent.prototype.logout = function () {
                    this.loggingOut.emit(true);
                };
                TopBarComponent.prototype.showProfile = function () {
                };
                TopBarComponent.prototype.test = function () {
                    this.global.loadAllSetting(null);
                };
                return TopBarComponent;
            }());
            TopBarComponent.ctorParameters = function () { return [
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_3__["GlobalService"] }
            ]; };
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
            /***/ 
        }),
        /***/ "./src/app/ui-models/error-detail.ts": 
        /*!*******************************************!*\
          !*** ./src/app/ui-models/error-detail.ts ***!
          \*******************************************/
        /*! exports provided: ErrorDetail */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function () { return ErrorDetail; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var ErrorDetail = /** @class */ (function () {
                function ErrorDetail(errorMessage, errorDetail) {
                    this.errorMessage = errorMessage;
                    this.errorDetail = errorDetail;
                }
                return ErrorDetail;
            }());
            /***/ 
        }),
        /***/ "./src/app/ui-models/error-response.ts": 
        /*!*********************************************!*\
          !*** ./src/app/ui-models/error-response.ts ***!
          \*********************************************/
        /*! exports provided: ErrorResponse */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function () { return ErrorResponse; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var ErrorResponse = /** @class */ (function () {
                function ErrorResponse(response) {
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
                return ErrorResponse;
            }());
            /***/ 
        }),
        /***/ "./src/app/ui-models/generaldata.ts": 
        /*!******************************************!*\
          !*** ./src/app/ui-models/generaldata.ts ***!
          \******************************************/
        /*! exports provided: GeneralData */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "GeneralData", function () { return GeneralData; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var GeneralData = /** @class */ (function () {
                function GeneralData() {
                }
                return GeneralData;
            }());
            /***/ 
        }),
        /***/ "./src/app/ui-models/index.ts": 
        /*!************************************!*\
          !*** ./src/app/ui-models/index.ts ***!
          \************************************/
        /*! exports provided: User, MenuItem, LoginResponse, GeneralData, ErrorDetail, ErrorResponse */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _user__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./user */ "./src/app/ui-models/user.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "User", function () { return _user__WEBPACK_IMPORTED_MODULE_1__["User"]; });
            /* harmony import */ var _menuitem__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./menuitem */ "./src/app/ui-models/menuitem.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "MenuItem", function () { return _menuitem__WEBPACK_IMPORTED_MODULE_2__["MenuItem"]; });
            /* harmony import */ var _loginmessage__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./loginmessage */ "./src/app/ui-models/loginmessage.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginResponse", function () { return _loginmessage__WEBPACK_IMPORTED_MODULE_3__["LoginResponse"]; });
            /* harmony import */ var _generaldata__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./generaldata */ "./src/app/ui-models/generaldata.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GeneralData", function () { return _generaldata__WEBPACK_IMPORTED_MODULE_4__["GeneralData"]; });
            /* harmony import */ var _error_detail__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./error-detail */ "./src/app/ui-models/error-detail.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function () { return _error_detail__WEBPACK_IMPORTED_MODULE_5__["ErrorDetail"]; });
            /* harmony import */ var _error_response__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./error-response */ "./src/app/ui-models/error-response.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function () { return _error_response__WEBPACK_IMPORTED_MODULE_6__["ErrorResponse"]; });
            /***/ 
        }),
        /***/ "./src/app/ui-models/loginmessage.ts": 
        /*!*******************************************!*\
          !*** ./src/app/ui-models/loginmessage.ts ***!
          \*******************************************/
        /*! exports provided: LoginResponse */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "LoginResponse", function () { return LoginResponse; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var LoginResponse = /** @class */ (function () {
                function LoginResponse() {
                }
                return LoginResponse;
            }());
            /***/ 
        }),
        /***/ "./src/app/ui-models/menuitem.ts": 
        /*!***************************************!*\
          !*** ./src/app/ui-models/menuitem.ts ***!
          \***************************************/
        /*! exports provided: MenuItem */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "MenuItem", function () { return MenuItem; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var MenuItem = /** @class */ (function () {
                function MenuItem() {
                    this.children = [];
                }
                return MenuItem;
            }());
            /***/ 
        }),
        /***/ "./src/app/ui-models/user.ts": 
        /*!***********************************!*\
          !*** ./src/app/ui-models/user.ts ***!
          \***********************************/
        /*! exports provided: User */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "User", function () { return User; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var User = /** @class */ (function () {
                function User() {
                }
                return User;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/index.ts": 
        /*!************************************!*\
          !*** ./src/app/wf-models/index.ts ***!
          \************************************/
        /*! exports provided: Workflow, WorkflowMessage, WorkflowType, WorkflowTypeStep, WorkflowAction, WorkflowFile, WorkflowFileVersion, WorkflowSearchFilter, WorkflowListInitialData */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _workflow__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./workflow */ "./src/app/wf-models/workflow.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Workflow", function () { return _workflow__WEBPACK_IMPORTED_MODULE_1__["Workflow"]; });
            /* harmony import */ var _workflowmessage__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./workflowmessage */ "./src/app/wf-models/workflowmessage.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessage", function () { return _workflowmessage__WEBPACK_IMPORTED_MODULE_2__["WorkflowMessage"]; });
            /* harmony import */ var _workflowtype__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./workflowtype */ "./src/app/wf-models/workflowtype.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowType", function () { return _workflowtype__WEBPACK_IMPORTED_MODULE_3__["WorkflowType"]; });
            /* harmony import */ var _workflowtypestep__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./workflowtypestep */ "./src/app/wf-models/workflowtypestep.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowTypeStep", function () { return _workflowtypestep__WEBPACK_IMPORTED_MODULE_4__["WorkflowTypeStep"]; });
            /* harmony import */ var _workflowaction__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./workflowaction */ "./src/app/wf-models/workflowaction.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowAction", function () { return _workflowaction__WEBPACK_IMPORTED_MODULE_5__["WorkflowAction"]; });
            /* harmony import */ var _workflowfile__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./workflowfile */ "./src/app/wf-models/workflowfile.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFile", function () { return _workflowfile__WEBPACK_IMPORTED_MODULE_6__["WorkflowFile"]; });
            /* harmony import */ var _workflowfileversion__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./workflowfileversion */ "./src/app/wf-models/workflowfileversion.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFileVersion", function () { return _workflowfileversion__WEBPACK_IMPORTED_MODULE_7__["WorkflowFileVersion"]; });
            /* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchFilter", function () { return _workflow_search_filter__WEBPACK_IMPORTED_MODULE_8__["WorkflowSearchFilter"]; });
            /* harmony import */ var _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./workflow-list-initialdata */ "./src/app/wf-models/workflow-list-initialdata.ts");
            /* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowListInitialData", function () { return _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_9__["WorkflowListInitialData"]; });
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflow-list-initialdata.ts": 
        /*!********************************************************!*\
          !*** ./src/app/wf-models/workflow-list-initialdata.ts ***!
          \********************************************************/
        /*! exports provided: WorkflowListInitialData */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowListInitialData", function () { return WorkflowListInitialData; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");
            var WorkflowListInitialData = /** @class */ (function () {
                function WorkflowListInitialData() {
                    this.workflowStatusList = [];
                    this.searchFilter = new _workflow_search_filter__WEBPACK_IMPORTED_MODULE_1__["WorkflowSearchFilter"]();
                }
                return WorkflowListInitialData;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflow-search-filter.ts": 
        /*!*****************************************************!*\
          !*** ./src/app/wf-models/workflow-search-filter.ts ***!
          \*****************************************************/
        /*! exports provided: WorkflowSearchFilter */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchFilter", function () { return WorkflowSearchFilter; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowSearchFilter = /** @class */ (function () {
                function WorkflowSearchFilter() {
                    this.meAssigned = true;
                    this.assignedUserIdSet = [];
                    this.statusList = [];
                    this.workflowTypes = [];
                    this.workflowSteps = [];
                }
                return WorkflowSearchFilter;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflow.ts": 
        /*!***************************************!*\
          !*** ./src/app/wf-models/workflow.ts ***!
          \***************************************/
        /*! exports provided: Workflow */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "Workflow", function () { return Workflow; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var Workflow = /** @class */ (function () {
                function Workflow() {
                }
                return Workflow;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowaction.ts": 
        /*!*********************************************!*\
          !*** ./src/app/wf-models/workflowaction.ts ***!
          \*********************************************/
        /*! exports provided: WorkflowAction */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowAction", function () { return WorkflowAction; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowAction = /** @class */ (function () {
                function WorkflowAction() {
                }
                return WorkflowAction;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowfile.ts": 
        /*!*******************************************!*\
          !*** ./src/app/wf-models/workflowfile.ts ***!
          \*******************************************/
        /*! exports provided: WorkflowFile */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowFile", function () { return WorkflowFile; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowFile = /** @class */ (function () {
                function WorkflowFile() {
                }
                return WorkflowFile;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowfileversion.ts": 
        /*!**************************************************!*\
          !*** ./src/app/wf-models/workflowfileversion.ts ***!
          \**************************************************/
        /*! exports provided: WorkflowFileVersion */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowFileVersion", function () { return WorkflowFileVersion; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowFileVersion = /** @class */ (function () {
                function WorkflowFileVersion() {
                }
                return WorkflowFileVersion;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowmessage.ts": 
        /*!**********************************************!*\
          !*** ./src/app/wf-models/workflowmessage.ts ***!
          \**********************************************/
        /*! exports provided: WorkflowMessage */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessage", function () { return WorkflowMessage; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowMessage = /** @class */ (function () {
                function WorkflowMessage() {
                }
                return WorkflowMessage;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowtype.ts": 
        /*!*******************************************!*\
          !*** ./src/app/wf-models/workflowtype.ts ***!
          \*******************************************/
        /*! exports provided: WorkflowType */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowType", function () { return WorkflowType; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowType = /** @class */ (function () {
                function WorkflowType() {
                }
                return WorkflowType;
            }());
            /***/ 
        }),
        /***/ "./src/app/wf-models/workflowtypestep.ts": 
        /*!***********************************************!*\
          !*** ./src/app/wf-models/workflowtypestep.ts ***!
          \***********************************************/
        /*! exports provided: WorkflowTypeStep */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowTypeStep", function () { return WorkflowTypeStep; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            var WorkflowTypeStep = /** @class */ (function () {
                function WorkflowTypeStep() {
                }
                return WorkflowTypeStep;
            }());
            /***/ 
        }),
        /***/ "./src/app/wm-components/workflow-create/workflow-create.component.css": 
        /*!*****************************************************************************!*\
          !*** ./src/app/wm-components/workflow-create/workflow-create.component.css ***!
          \*****************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvd29ya2Zsb3ctY3JlYXRlL3dvcmtmbG93LWNyZWF0ZS5jb21wb25lbnQuY3NzIn0= */");
            /***/ 
        }),
        /***/ "./src/app/wm-components/workflow-create/workflow-create.component.ts": 
        /*!****************************************************************************!*\
          !*** ./src/app/wm-components/workflow-create/workflow-create.component.ts ***!
          \****************************************************************************/
        /*! exports provided: WorkflowCreateComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowCreateComponent", function () { return WorkflowCreateComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/global.service */ "./src/app/services/global.service.ts");
            var WorkflowCreateComponent = /** @class */ (function () {
                function WorkflowCreateComponent(router, global, translate) {
                    var _this = this;
                    this.router = router;
                    this.global = global;
                    this.worlflowTypes = [];
                    this.router.events.subscribe(function (evt) {
                        if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                            _this.loadInitialData();
                        }
                    });
                }
                WorkflowCreateComponent.prototype.ngOnInit = function () {
                    this.loadInitialData();
                };
                WorkflowCreateComponent.prototype.loadInitialData = function () {
                    if (this.global.loadedGeneralData !== null) {
                        this.worlflowTypes = this.global.loadedGeneralData.workflow.worlflowTypes;
                    }
                    else {
                        this.subscribeToGeneralData();
                        this.global.loadAllSetting(null);
                    }
                };
                WorkflowCreateComponent.prototype.subscribeToGeneralData = function () {
                    var _this = this;
                    this.global.currentSessionDataSubject.subscribe(function (data) {
                        console.log("set gloabl-data from workflow-create. appIsLogged: ");
                        //alert("from app-comp: \n" + JSON.stringify(data));
                        if (data && data !== null) {
                            var value = data.isLogged + "";
                            if (value === "true" === true) {
                                _this.worlflowTypes = data.workflow.worlflowTypes;
                            }
                            else {
                                _this.worlflowTypes = [];
                            }
                        }
                        else {
                            _this.worlflowTypes = [];
                        }
                    });
                };
                return WorkflowCreateComponent;
            }());
            WorkflowCreateComponent.ctorParameters = function () { return [
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] },
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }
            ]; };
            WorkflowCreateComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
                    selector: 'app-workflow-create',
                    template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-create.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-create/workflow-create.component.html")).default,
                    styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-create.component.css */ "./src/app/wm-components/workflow-create/workflow-create.component.css")).default]
                })
            ], WorkflowCreateComponent);
            /***/ 
        }),
        /***/ "./src/app/wm-components/workflow-list/workflow-list.component.css": 
        /*!*************************************************************************!*\
          !*** ./src/app/wm-components/workflow-list/workflow-list.component.css ***!
          \*************************************************************************/
        /*! exports provided: default */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony default export */ __webpack_exports__["default"] = ("\r\n.search-toolbar {\r\n    width: calc(100% - 300px);\r\n    float: right;\r\n}\r\n\r\n.search-toolbar .nav-item{\r\n    margin-right: 30px;\r\n    \r\n}\r\n\r\n.search-toolbar .nav-item input.form-check-input[type=checkbox]{\r\n    width: 16px;\r\n    height: 16px;\r\n    \r\n}\r\n\r\n.search-toolbar .nav-item .form-check-label{\r\n\tmargin-bottom: 0;\r\n    padding-left: 10px;\r\n    line-height: 20px;\r\n}\r\n\r\n.search-toolbar-item{\r\n\theight: 100%;\r\n    padding-top: 9px;\r\n}\r\n\r\n.search-toolbar .nav-item {\r\n    background-color: transparent !important;\r\n}\r\n\r\n.search-toolbar .nav-link.active, .search-toolbar .show>.nav-link {\r\n    color: #fff !important;\r\n    background-color: #c7c9cb !important;\r\n}\r\n\r\n\r\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1saXN0L3dvcmtmbG93LWxpc3QuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7SUFDSSx5QkFBeUI7SUFDekIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLGtCQUFrQjs7QUFFdEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsWUFBWTs7QUFFaEI7O0FBRUE7Q0FDQyxnQkFBZ0I7SUFDYixrQkFBa0I7SUFDbEIsaUJBQWlCO0FBQ3JCOztBQUVBO0NBQ0MsWUFBWTtJQUNULGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLHdDQUF3QztBQUM1Qzs7QUFFQTtJQUNJLHNCQUFzQjtJQUN0QixvQ0FBb0M7QUFDeEMiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL3dvcmtmbG93LWxpc3Qvd29ya2Zsb3ctbGlzdC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5zZWFyY2gtdG9vbGJhciB7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMzAwcHgpO1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXIgLm5hdi1pdGVte1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAzMHB4O1xyXG4gICAgXHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWl0ZW0gaW5wdXQuZm9ybS1jaGVjay1pbnB1dFt0eXBlPWNoZWNrYm94XXtcclxuICAgIHdpZHRoOiAxNnB4O1xyXG4gICAgaGVpZ2h0OiAxNnB4O1xyXG4gICAgXHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWl0ZW0gLmZvcm0tY2hlY2stbGFiZWx7XHJcblx0bWFyZ2luLWJvdHRvbTogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMTBweDtcclxuICAgIGxpbmUtaGVpZ2h0OiAyMHB4O1xyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXItaXRlbXtcclxuXHRoZWlnaHQ6IDEwMCU7XHJcbiAgICBwYWRkaW5nLXRvcDogOXB4O1xyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXIgLm5hdi1pdGVtIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50ICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWxpbmsuYWN0aXZlLCAuc2VhcmNoLXRvb2xiYXIgLnNob3c+Lm5hdi1saW5rIHtcclxuICAgIGNvbG9yOiAjZmZmICFpbXBvcnRhbnQ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjYzdjOWNiICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbiJdfQ== */");
            /***/ 
        }),
        /***/ "./src/app/wm-components/workflow-list/workflow-list.component.ts": 
        /*!************************************************************************!*\
          !*** ./src/app/wm-components/workflow-list/workflow-list.component.ts ***!
          \************************************************************************/
        /*! exports provided: WorkflowListComponent */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowListComponent", function () { return WorkflowListComponent; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/fesm2015/core.js");
            /* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/fesm2015/router.js");
            /* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/fesm2015/ngx-translate-core.js");
            /* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/global.service */ "./src/app/services/global.service.ts");
            /* harmony import */ var _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/workflow/workflow-search.service */ "./src/app/services/workflow/workflow-search.service.ts");
            /* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");
            var WorkflowListComponent = /** @class */ (function () {
                function WorkflowListComponent(router, global, translate, searchService) {
                    var _this = this;
                    this.router = router;
                    this.global = global;
                    this.searchService = searchService;
                    this.worlflowTypes = [];
                    this.resultWorlflows = [];
                    this.listInitialData = new _wf_models__WEBPACK_IMPORTED_MODULE_6__["WorkflowListInitialData"]();
                    this.router.events.subscribe(function (evt) {
                        if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_2__["NavigationEnd"]) {
                            _this.loadInitialData();
                        }
                    });
                }
                Object.defineProperty(WorkflowListComponent.prototype, "isMeAssigned", {
                    get: function () {
                        if (this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null) {
                            return this.listInitialData.searchFilter.meAssigned;
                        }
                        return false;
                    },
                    set: function (assigned) {
                        if (this.listInitialData && this.listInitialData != null && this.listInitialData.searchFilter != null) {
                            this.listInitialData.searchFilter.meAssigned = assigned;
                        }
                    },
                    enumerable: true,
                    configurable: true
                });
                Object.defineProperty(WorkflowListComponent.prototype, "statusList", {
                    get: function () {
                        if (this.listInitialData && this.listInitialData != null && this.listInitialData.workflowStatusList != null) {
                            return this.listInitialData.workflowStatusList;
                        }
                        return [];
                    },
                    enumerable: true,
                    configurable: true
                });
                WorkflowListComponent.prototype.ngOnInit = function () {
                    this.loadInitialData();
                };
                WorkflowListComponent.prototype.loadInitialData = function () {
                    if (this.searchService.listInitialData !== null) {
                        this.listInitialData = this.searchService.listInitialData;
                    }
                    else {
                        this.subscribeToSearchInitialData();
                        this.searchService.loadInitialData();
                    }
                };
                WorkflowListComponent.prototype.subscribeToSearchInitialData = function () {
                    var _this = this;
                    this.searchService.searchInitialDataSubject.subscribe(function (data) {
                        console.log("set gloabl-data from workflow-create. : ", data);
                        //alert("from app-comp: \n" + JSON.stringify(data));
                        if (data && data !== null) {
                            _this.listInitialData = data;
                        }
                        else {
                            _this.listInitialData = null;
                        }
                    });
                };
                WorkflowListComponent.prototype.reload = function () {
                };
                WorkflowListComponent.prototype.isStatusSelected = function (wstatus) {
                    if (this.listInitialData &&
                        this.listInitialData != null &&
                        this.listInitialData.searchFilter != null &&
                        this.listInitialData.searchFilter.statusList != null) {
                        return this.listInitialData.searchFilter.statusList.indexOf(wstatus) > -1;
                    }
                    return false;
                };
                WorkflowListComponent.prototype.toggleStatusSelected = function (wstatus) {
                    if (this.listInitialData &&
                        this.listInitialData != null &&
                        this.listInitialData.searchFilter != null &&
                        this.listInitialData.searchFilter.statusList != null) {
                        var index = this.listInitialData.searchFilter.statusList.indexOf(wstatus);
                        if (index !== -1) {
                            this.listInitialData.searchFilter.statusList.splice(index, 1);
                        }
                        else {
                            this.listInitialData.searchFilter.statusList.push(wstatus);
                        }
                    }
                };
                Object.defineProperty(WorkflowListComponent.prototype, "debugSearchFilter", {
                    get: function () {
                        if (this.listInitialData &&
                            this.listInitialData != null &&
                            this.listInitialData.searchFilter != null) {
                            return JSON.stringify(this.listInitialData.searchFilter);
                        }
                        return "";
                    },
                    enumerable: true,
                    configurable: true
                });
                return WorkflowListComponent;
            }());
            WorkflowListComponent.ctorParameters = function () { return [
                { type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] },
                { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] },
                { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] },
                { type: _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_5__["WorkflowSearchService"] }
            ]; };
            WorkflowListComponent = tslib__WEBPACK_IMPORTED_MODULE_0__["__decorate"]([
                Object(_angular_core__WEBPACK_IMPORTED_MODULE_1__["Component"])({
                    selector: 'app-workflow-list',
                    template: tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! raw-loader!./workflow-list.component.html */ "./node_modules/raw-loader/dist/cjs.js!./src/app/wm-components/workflow-list/workflow-list.component.html")).default,
                    styles: [tslib__WEBPACK_IMPORTED_MODULE_0__["__importDefault"](__webpack_require__(/*! ./workflow-list.component.css */ "./src/app/wm-components/workflow-list/workflow-list.component.css")).default]
                })
            ], WorkflowListComponent);
            /***/ 
        }),
        /***/ "./src/environments/environment.ts": 
        /*!*****************************************!*\
          !*** ./src/environments/environment.ts ***!
          \*****************************************/
        /*! exports provided: environment */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "environment", function () { return environment; });
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            // This file can be replaced during build by using the `fileReplacements` array.
            // `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
            // The list of file replacements can be found in `angular.json`.
            var environment = {
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
            /***/ 
        }),
        /***/ "./src/main.ts": 
        /*!*********************!*\
          !*** ./src/main.ts ***!
          \*********************/
        /*! no exports provided */
        /***/ (function (module, __webpack_exports__, __webpack_require__) {
            "use strict";
            __webpack_require__.r(__webpack_exports__);
            /* harmony import */ var tslib__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! tslib */ "./node_modules/tslib/tslib.es6.js");
            /* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! hammerjs */ "./node_modules/hammerjs/hammer.js");
            /* harmony import */ var hammerjs__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/ __webpack_require__.n(hammerjs__WEBPACK_IMPORTED_MODULE_1__);
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
            /***/ 
        }),
        /***/ 0: 
        /*!***************************!*\
          !*** multi ./src/main.ts ***!
          \***************************/
        /*! no static exports found */
        /***/ (function (module, exports, __webpack_require__) {
            module.exports = __webpack_require__(/*! C:\Git\home\iflow\iflow-java\iflow\gui\angular-prj\gui-prj\src\main.ts */ "./src/main.ts");
            /***/ 
        })
    }, [[0, "runtime", "vendor"]]]);
//# sourceMappingURL=main-es2015.js.map
//# sourceMappingURL=main-es5.js.map
//# sourceMappingURL=main-es5.js.map