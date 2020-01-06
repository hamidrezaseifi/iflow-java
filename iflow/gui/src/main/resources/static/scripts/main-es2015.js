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

/***/ "./src/app/about/about.component.ts":
/*!******************************************!*\
  !*** ./src/app/about/about.component.ts ***!
  \******************************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return AboutComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");


class AboutComponent {
    constructor() {
    }
    ngOnInit() {
    }
}
AboutComponent.ɵfac = function AboutComponent_Factory(t) { return new (t || AboutComponent)(); };
AboutComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: AboutComponent, selectors: [["app-root"]], decls: 2, vars: 0, template: function AboutComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h1");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "About!");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AboutComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{ selector: 'app-root', templateUrl: 'about.component.html' }]
    }], function () { return []; }, null); })();


/***/ }),

/***/ "./src/app/about/index.ts":
/*!********************************!*\
  !*** ./src/app/about/index.ts ***!
  \********************************/
/*! exports provided: AboutComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _about_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./about.component */ "./src/app/about/about.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AboutComponent", function() { return _about_component__WEBPACK_IMPORTED_MODULE_0__["AboutComponent"]; });




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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./services */ "./src/app/services/index.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");
/* harmony import */ var _top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./top-bar/top-bar.component */ "./src/app/top-bar/top-bar.component.ts");
/* harmony import */ var _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./message-bar/message-bar.component */ "./src/app/message-bar/message-bar.component.ts");
/* harmony import */ var _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./components/error-dialog/error-dialog.component */ "./src/app/components/error-dialog/error-dialog.component.ts");
/* harmony import */ var _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./components/loading-dialog/loading-dialog.component */ "./src/app/components/loading-dialog/loading-dialog.component.ts");
/* harmony import */ var _footer_footer_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./footer/footer.component */ "./src/app/footer/footer.component.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");















class AppComponent {
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
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
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
}
AppComponent.ɵfac = function AppComponent_Factory(t) { return new (t || AppComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_platform_browser__WEBPACK_IMPORTED_MODULE_5__["Title"])); };
AppComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: AppComponent, selectors: [["app-root"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([_services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"]])], decls: 12, vars: 15, consts: [[3, "menus", "currentUser", "isLogged", "loggingOut"], [1, "container"], [3, "currentUser", "isLogged"]], template: function AppComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "app-top-bar", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("loggingOut", function AppComponent_Template_app_top_bar_loggingOut_0_listener($event) { return ctx.onLoggingOut($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](1, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "router-outlet");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "app-message-bar", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "app-error-dialog");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](10, "app-loading-dialog");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "app-footer");
    } if (rf & 2) {
        var tmp_0_0 = null;
        const currVal_0 = (tmp_0_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](1, 5, ctx.generalDataObs)) == null ? null : tmp_0_0.app.menus;
        var tmp_1_0 = null;
        const currVal_1 = (tmp_1_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 7, ctx.generalDataObs)) == null ? null : tmp_1_0.user.currentUser;
        var tmp_2_0 = null;
        const currVal_2 = (tmp_2_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 9, ctx.generalDataObs)) == null ? null : tmp_2_0.isLogged;
        var tmp_3_0 = null;
        const currVal_3 = (tmp_3_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 11, ctx.generalDataObs)) == null ? null : tmp_3_0.user.currentUser;
        var tmp_4_0 = null;
        const currVal_4 = (tmp_4_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 13, ctx.generalDataObs)) == null ? null : tmp_4_0.isLogged;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("menus", currVal_0)("currentUser", currVal_1)("isLogged", currVal_2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("currentUser", currVal_3)("isLogged", currVal_4);
    } }, directives: [_top_bar_top_bar_component__WEBPACK_IMPORTED_MODULE_6__["TopBarComponent"], _angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterOutlet"], _message_bar_message_bar_component__WEBPACK_IMPORTED_MODULE_7__["MessageBarComponent"], _components_error_dialog_error_dialog_component__WEBPACK_IMPORTED_MODULE_8__["ErrorDialogComponent"], _components_loading_dialog_loading_dialog_component__WEBPACK_IMPORTED_MODULE_9__["LoadingDialogComponent"], _footer_footer_component__WEBPACK_IMPORTED_MODULE_10__["FooterComponent"]], pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_11__["AsyncPipe"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7QUFFQTs7OztDQUlDIiwiZmlsZSI6InNyYy9hcHAvYXBwLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuXHJcbi8qXHJcbkNvcHlyaWdodCBHb29nbGUgTExDLiBBbGwgUmlnaHRzIFJlc2VydmVkLlxyXG5Vc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0XHJcbmNhbiBiZSBmb3VuZCBpbiB0aGUgTElDRU5TRSBmaWxlIGF0IGh0dHA6Ly9hbmd1bGFyLmlvL2xpY2Vuc2VcclxuKi8iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-root',
                templateUrl: './app.component.html',
                styleUrls: ['./app.component.css'],
                providers: [_services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services__WEBPACK_IMPORTED_MODULE_3__["AuthenticationService"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_4__["TranslateService"] }, { type: _angular_platform_browser__WEBPACK_IMPORTED_MODULE_5__["Title"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/platform-browser/animations */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/animations.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/http-loader */ "./node_modules/@ngx-translate/http-loader/__ivy_ngcc__/fesm2015/ngx-translate-http-loader.js");
/* harmony import */ var angular_resizable_element__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! angular-resizable-element */ "./node_modules/angular-resizable-element/__ivy_ngcc__/fesm2015/angular-resizable-element.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/__ivy_ngcc__/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! sockjs-client */ "./node_modules/sockjs-client/lib/entry.js");
/* harmony import */ var sockjs_client__WEBPACK_IMPORTED_MODULE_11___default = /*#__PURE__*/__webpack_require__.n(sockjs_client__WEBPACK_IMPORTED_MODULE_11__);
/* harmony import */ var ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ng2-pdf-viewer */ "./node_modules/ng2-pdf-viewer/__ivy_ngcc__/fesm2015/ng2-pdf-viewer.js");
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
/* harmony import */ var _wm_components_invoice_ocr_detail_invoice_ocr_detail_component__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! ./wm-components/invoice-ocr-detail/invoice-ocr-detail.component */ "./src/app/wm-components/invoice-ocr-detail/invoice-ocr-detail.component.ts");
/* harmony import */ var _components_file_preview_file_preview_component__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! ./components/file-preview/file-preview.component */ "./src/app/components/file-preview/file-preview.component.ts");
/* harmony import */ var _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! ./components/wm-file-upload/wm-file-upload.component */ "./src/app/components/wm-file-upload/wm-file-upload.component.ts");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_42__ = __webpack_require__(/*! ./components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_43__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");









//import { DataTableModule } from 'ng-seven-datatable';




//import { NgxExtendedPdfViewerModule } from 'ngx-extended-pdf-viewer';


































function createTranslateLoader(http) {
    return new _ngx_translate_http_loader__WEBPACK_IMPORTED_MODULE_6__["TranslateHttpLoader"](http, './assets/i18n/', '.json');
}
function socketProvider() {
    return new sockjs_client__WEBPACK_IMPORTED_MODULE_11__('/iflow-guide-websocket');
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
class AppModule {
}
AppModule.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: AppModule, bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"]] });
AppModule.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function AppModule_Factory(t) { return new (t || AppModule)(); }, providers: [
        _services_global_service__WEBPACK_IMPORTED_MODULE_17__["GlobalService"],
        _services_authentication_service__WEBPACK_IMPORTED_MODULE_18__["AuthenticationService"],
        _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_19__["WorkflowMessageService"],
        _helper__WEBPACK_IMPORTED_MODULE_14__["fakeBackendProvider"],
        _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_10__["StompService"],
        {
            provide: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_10__["StompConfig"],
            useValue: stompConfig
        }
    ], imports: [[
            _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
            _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"],
            _app_routing__WEBPACK_IMPORTED_MODULE_16__["appRoutingModule"],
            _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
            angular_resizable_element__WEBPACK_IMPORTED_MODULE_7__["ResizableModule"],
            _angular_material_table__WEBPACK_IMPORTED_MODULE_9__["MatTableModule"],
            _angular_material_core__WEBPACK_IMPORTED_MODULE_8__["MatNativeDateModule"],
            _material_module__WEBPACK_IMPORTED_MODULE_13__["IFlowMaterialModules"],
            _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
            //NgxExtendedPdfViewerModule,
            ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_12__["PdfViewerModule"],
            _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateModule"].forRoot({
                loader: {
                    provide: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateLoader"],
                    useFactory: (createTranslateLoader),
                    deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]]
                }
            }),
        ]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](AppModule, { declarations: [_app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"],
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
        _wm_components_invoice_ocr_detail_invoice_ocr_detail_component__WEBPACK_IMPORTED_MODULE_39__["InvoiceOcrDetailComponent"],
        _components_file_preview_file_preview_component__WEBPACK_IMPORTED_MODULE_40__["FilePreviewComponent"],
        _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_41__["WmFileUploadComponent"],
        _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_42__["WmAssignListComponent"]], imports: [_angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
        _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"], _angular_router__WEBPACK_IMPORTED_MODULE_43__["RouterModule"], _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
        angular_resizable_element__WEBPACK_IMPORTED_MODULE_7__["ResizableModule"],
        _angular_material_table__WEBPACK_IMPORTED_MODULE_9__["MatTableModule"],
        _angular_material_core__WEBPACK_IMPORTED_MODULE_8__["MatNativeDateModule"],
        _material_module__WEBPACK_IMPORTED_MODULE_13__["IFlowMaterialModules"],
        _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
        //NgxExtendedPdfViewerModule,
        ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_12__["PdfViewerModule"], _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AppModule, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                imports: [
                    _angular_platform_browser__WEBPACK_IMPORTED_MODULE_1__["BrowserModule"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ReactiveFormsModule"],
                    _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClientModule"],
                    _app_routing__WEBPACK_IMPORTED_MODULE_16__["appRoutingModule"],
                    _angular_platform_browser_animations__WEBPACK_IMPORTED_MODULE_4__["BrowserAnimationsModule"],
                    angular_resizable_element__WEBPACK_IMPORTED_MODULE_7__["ResizableModule"],
                    _angular_material_table__WEBPACK_IMPORTED_MODULE_9__["MatTableModule"],
                    _angular_material_core__WEBPACK_IMPORTED_MODULE_8__["MatNativeDateModule"],
                    _material_module__WEBPACK_IMPORTED_MODULE_13__["IFlowMaterialModules"],
                    _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormsModule"],
                    //NgxExtendedPdfViewerModule,
                    ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_12__["PdfViewerModule"],
                    _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateModule"].forRoot({
                        loader: {
                            provide: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateLoader"],
                            useFactory: (createTranslateLoader),
                            deps: [_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]]
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
                    _wm_components_invoice_ocr_detail_invoice_ocr_detail_component__WEBPACK_IMPORTED_MODULE_39__["InvoiceOcrDetailComponent"],
                    _components_file_preview_file_preview_component__WEBPACK_IMPORTED_MODULE_40__["FilePreviewComponent"],
                    _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_41__["WmFileUploadComponent"],
                    _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_42__["WmAssignListComponent"],
                ],
                providers: [
                    _services_global_service__WEBPACK_IMPORTED_MODULE_17__["GlobalService"],
                    _services_authentication_service__WEBPACK_IMPORTED_MODULE_18__["AuthenticationService"],
                    _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_19__["WorkflowMessageService"],
                    _helper__WEBPACK_IMPORTED_MODULE_14__["fakeBackendProvider"],
                    _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_10__["StompService"],
                    {
                        provide: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_10__["StompConfig"],
                        useValue: stompConfig
                    }
                ],
                bootstrap: [_app_component__WEBPACK_IMPORTED_MODULE_15__["AppComponent"]]
            }]
    }], null, null); })();


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
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_authentication_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./services/authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony import */ var _home__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./home */ "./src/app/home/index.ts");
/* harmony import */ var _about__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./about */ "./src/app/about/index.ts");
/* harmony import */ var _login__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./login */ "./src/app/login/index.ts");
/* harmony import */ var _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./wm-components/workflow-list/workflow-list.component */ "./src/app/wm-components/workflow-list/workflow-list.component.ts");
/* harmony import */ var _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./wm-components/create/workflow-create/workflow-create.component */ "./src/app/wm-components/create/workflow-create/workflow-create.component.ts");
/* harmony import */ var _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./wm-components/create/create-singletask/create-singletask.component */ "./src/app/wm-components/create/create-singletask/create-singletask.component.ts");
/* harmony import */ var _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./wm-components/create/create-invoice/create-invoice.component */ "./src/app/wm-components/create/create-invoice/create-invoice.component.ts");
/* harmony import */ var _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./wm-components/create/create-testthreetask/create-testthreetask.component */ "./src/app/wm-components/create/create-testthreetask/create-testthreetask.component.ts");
/* harmony import */ var _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./wm-components/edit/edit-invoice/edit-invoice.component */ "./src/app/wm-components/edit/edit-invoice/edit-invoice.component.ts");
/* harmony import */ var _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./wm-components/edit/edit-single-task/edit-single-task.component */ "./src/app/wm-components/edit/edit-single-task/edit-single-task.component.ts");
/* harmony import */ var _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./wm-components/edit/edit-testthree-task/edit-testthree-task.component */ "./src/app/wm-components/edit/edit-testthree-task/edit-testthree-task.component.ts");
/* harmony import */ var _test_test_component__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./test/test.component */ "./src/app/test/test.component.ts");














const routes = [
    { path: '', component: _home__WEBPACK_IMPORTED_MODULE_2__["HomeComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'about', component: _about__WEBPACK_IMPORTED_MODULE_3__["AboutComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/list', component: _wm_components_workflow_list_workflow_list_component__WEBPACK_IMPORTED_MODULE_5__["WorkflowListComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/create', component: _wm_components_create_workflow_create_workflow_create_component__WEBPACK_IMPORTED_MODULE_6__["WorkflowCreateComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/create/singletask', component: _wm_components_create_create_singletask_create_singletask_component__WEBPACK_IMPORTED_MODULE_7__["CreateSingletaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/create/invoice', component: _wm_components_create_create_invoice_create_invoice_component__WEBPACK_IMPORTED_MODULE_8__["CreateInvoiceComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/create/testthreetask', component: _wm_components_create_create_testthreetask_create_testthreetask_component__WEBPACK_IMPORTED_MODULE_9__["CreateTestthreetaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/edit/singletaskworkflowtype/:identity', component: _wm_components_edit_edit_single_task_edit_single_task_component__WEBPACK_IMPORTED_MODULE_11__["EditSingleTaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/edit/threetaskworkflowtype/:identity', component: _wm_components_edit_edit_testthree_task_edit_testthree_task_component__WEBPACK_IMPORTED_MODULE_12__["EditTestthreeTaskComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'workflow/edit/invoiceworkflowtype/:identity', component: _wm_components_edit_edit_invoice_edit_invoice_component__WEBPACK_IMPORTED_MODULE_10__["EditInvoiceComponent"], canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] },
    { path: 'test', component: _test_test_component__WEBPACK_IMPORTED_MODULE_13__["TestComponent"] },
    { path: 'auth/login', component: _login__WEBPACK_IMPORTED_MODULE_4__["LoginComponent"] },
    // otherwise redirect to home
    { path: '**', redirectTo: '', canActivate: [_services_authentication_service__WEBPACK_IMPORTED_MODULE_1__["AuthenticationService"]] }
];
const appRoutingModule = _angular_router__WEBPACK_IMPORTED_MODULE_0__["RouterModule"].forRoot(routes);


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");






const _c0 = function (a0) { return { "show": a0 }; };
function ErrorDialogComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    const _r165 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h5", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ErrorDialogComponent_div_0_Template_button_click_7_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r165); const ctx_r164 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r164.hideModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "input", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function ErrorDialogComponent_div_0_Template_input_ngModelChange_14_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r165); const ctx_r166 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r166.showErrorDetail = $event; });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "label", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](17, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](18, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "pre", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "button", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function ErrorDialogComponent_div_0_Template_button_click_23_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r165); const ctx_r167 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r167.hideModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "i", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r163 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](12, _c0, ctx_r163.showError));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 8, "common.errormessagetitle"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx_r163.errorMessage, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("hidden", ctx_r163.hasErrorDetail === false);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx_r163.showErrorDetail);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](17, 10, "common.details"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("hidden", ctx_r163.showErrorDetail === false);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx_r163.errorDetails, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
} }
class ErrorDialogComponent {
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
}
ErrorDialogComponent.ɵfac = function ErrorDialogComponent_Factory(t) { return new (t || ErrorDialogComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_2__["ErrorServiceService"])); };
ErrorDialogComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: ErrorDialogComponent, selectors: [["app-error-dialog"]], decls: 1, vars: 1, consts: [["class", "modal fade", "tabindex", "-1", "id", "errormessagedialog", "role", "dialog", "aria-labelledby", "errorMessagedialogCenterTitle", 3, "ngClass", 4, "ngIf"], ["tabindex", "-1", "id", "errormessagedialog", "role", "dialog", "aria-labelledby", "errorMessagedialogCenterTitle", 1, "modal", "fade", 3, "ngClass"], ["role", "document", 1, "modal-dialog", "modal-dialog-centered"], [1, "modal-content"], [1, "modal-header"], ["id", "errorMessagedialogTitle", 1, "modal-title", "dialog-title"], ["aria-label", "Close", 1, "dialog-toolbar-button", "close", 3, "click"], [1, "material-icons"], [1, "modal-body"], [1, "content-container", "alert", "alert", "alert-danger", 2, "margin-bottom", "0"], [1, "errorcontent-message", 3, "innerHTML"], [3, "hidden"], ["type", "checkbox", "id", "showerrordetailcheck", 2, "float", "right", 3, "ngModel", "ngModelChange"], ["for", "showerrordetailcheck", 1, "form-check-label", 2, "float", "right", "margin-right", "10px"], [1, "clear"], ["id", "errorcontent-detail", 2, "padding", "10px", "background-color", "#d9e3ea", 3, "hidden"], [2, "height", "300px", "width", "100%", "overflow", "auto"], [3, "innerHTML"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"]], template: function ErrorDialogComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, ErrorDialogComponent_div_0_Template, 26, 14, "div", 0);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showError);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgClass"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["CheckboxControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_4__["NgModel"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslatePipe"]], styles: ["[hidden][_ngcontent-%COMP%] {\r\n  display: none !important;\r\n}\r\n\r\n\r\n#errormessagedialog[_ngcontent-%COMP%]   .modal-dialog[_ngcontent-%COMP%]{\r\n\tmin-width: 50vw;\r\n    max-width: 50vw;\r\n    \r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9lcnJvci1kaWFsb2cvZXJyb3ItZGlhbG9nLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0VBQ0Usd0JBQXdCO0FBQzFCOzs7QUFHQTtDQUNDLGVBQWU7SUFDWixlQUFlOztBQUVuQiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvZXJyb3ItZGlhbG9nL2Vycm9yLWRpYWxvZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbltoaWRkZW5dIHtcclxuICBkaXNwbGF5OiBub25lICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcblxyXG4jZXJyb3JtZXNzYWdlZGlhbG9nIC5tb2RhbC1kaWFsb2d7XHJcblx0bWluLXdpZHRoOiA1MHZ3O1xyXG4gICAgbWF4LXdpZHRoOiA1MHZ3O1xyXG4gICAgXHJcbn1cclxuXHJcblxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ErrorDialogComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-error-dialog',
                templateUrl: './error-dialog.component.html',
                styleUrls: ['./error-dialog.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_2__["ErrorServiceService"] }]; }, null); })();


/***/ }),

/***/ "./src/app/components/file-preview/file-preview.component.ts":
/*!*******************************************************************!*\
  !*** ./src/app/components/file-preview/file-preview.component.ts ***!
  \*******************************************************************/
/*! exports provided: FilePreviewComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "FilePreviewComponent", function() { return FilePreviewComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ng2-pdf-viewer */ "./node_modules/ng2-pdf-viewer/__ivy_ngcc__/fesm2015/ng2-pdf-viewer.js");





function FilePreviewComponent_pdf_viewer_13_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "pdf-viewer", 14);
} if (rf & 2) {
    const ctx_r216 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("src", ctx_r216.fileViewUrl)("zoom", ctx_r216.pdfZoom);
} }
function FilePreviewComponent_div_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "div", 15);
} if (rf & 2) {
    const ctx_r217 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleSanitizer"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefaultStyleSanitizer"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleProp"]("width", ctx_r217.previewWidth, "px")("background-image", ctx_r217.imageFileViewUrl);
} }
const _c0 = function (a0) { return { "show": a0 }; };
class FilePreviewComponent {
    constructor(translate) {
        this.translate = translate;
        this.fileUrl = "";
        this.imageSizeX = 300;
        this.imageSizeY = 500;
        this.fileIsPdf = true;
        this.fileIsImage = false;
        this.dialogClosed = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.showDialog = false;
        this.previewWidth = 600;
        this.previewHeight = 1100;
        this.pdfZoom = 'page-fit';
    }
    closeDialog() {
        this.showDialog = false;
        this.dialogClosed.emit(false);
    }
    ngOnInit() {
    }
    ngAfterViewInit() {
        var yScale = this.previewWidth / this.imageSizeX;
        this.previewHeight = yScale * this.imageSizeY;
    }
    get imageFileViewUrl() {
        return 'url(/general/data/file/view/' + this.fileUrl + ')';
        //return 'url()';
    }
    get fileViewUrl() {
        return '/general/data/file/view/' + this.fileUrl;
        //return 'url()';
    }
}
FilePreviewComponent.ɵfac = function FilePreviewComponent_Factory(t) { return new (t || FilePreviewComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"])); };
FilePreviewComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: FilePreviewComponent, selectors: [["app-file-preview"]], inputs: { fileUrl: "fileUrl", imageSizeX: "imageSizeX", imageSizeY: "imageSizeY", fileIsPdf: "fileIsPdf", fileIsImage: "fileIsImage", showDialog: "showDialog" }, outputs: { dialogClosed: "dialogClosed" }, decls: 19, vars: 11, consts: [["tabindex", "-1", "role", "dialog", "id", "imagepreviewdialog", 1, "modal", "fade", 3, "ngClass"], ["role", "document", 1, "modal-dialog", "preview-details-dialog"], [1, "modal-header"], [1, "modal-title"], ["type", "button", "aria-label", "Close", 1, "close", 3, "click"], ["aria-hidden", "true"], [1, "modal-body"], [1, "scanned-result-container"], [1, "scanned-item-preview-container"], ["scannedItemPreviewContainer", ""], [3, "src", "zoom", 4, "ngIf"], ["class", "scanned-item-preview-image", 3, "width", "backgroundImage", 4, "ngIf"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"], [3, "src", "zoom"], [1, "scanned-item-preview-image"]], template: function FilePreviewComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h5", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](5, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function FilePreviewComponent_Template_button_click_6_listener($event) { return ctx.closeDialog(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "span", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\u00D7");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 8, 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, FilePreviewComponent_pdf_viewer_13_Template, 1, 2, "pdf-viewer", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, FilePreviewComponent_div_14_Template, 1, 2, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "button", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function FilePreviewComponent_Template_button_click_16_listener($event) { return ctx.closeDialog(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](18, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](9, _c0, ctx.showDialog));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](5, 5, "common.file-preview"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.fileIsPdf);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.fileIsImage);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](18, 7, "common.close"));
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["NgIf"], ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_3__["PdfViewerComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslatePipe"]], styles: [".preview-details-dialog[_ngcontent-%COMP%]{\r\n\twidth: 700px;\r\n    max-width: 90vw;\r\n    background-color: white;\r\n    pointer-events: all;\r\n}\r\n\r\n.scanned-result-container[_ngcontent-%COMP%]{\r\n\tbackground-color: white;\t\r\n\twidth: 100%;\r\n\tmargin: 0;\r\n\tdisplay: -webkit-box;\r\n\tdisplay: flex;\r\n}\r\n\r\n.scanned-item-preview-container[_ngcontent-%COMP%] {\r\n\tpadding: 10px;\r\n\tmargin: 5px auto;\r\n\tborder-radius: 5px;\r\n\theight: 80vh;\r\n\toverflow-x: hidden;\r\n\toverflow-y: auto;\r\n\tbackground-color: #e0e0e0;\r\n}\r\n\r\n.scanned-item-preview-image[_ngcontent-%COMP%]{\r\n\tbackground-color: white;\r\n\tbackground-image: none;\r\n\tbackground-position: 0 0;\r\n\tbackground-repeat: no-repeat;\r\n\tbackground-size: 100% 100%;\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\t\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9maWxlLXByZXZpZXcvZmlsZS1wcmV2aWV3LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6Ijs7QUFFQTtDQUNDLFlBQVk7SUFDVCxlQUFlO0lBQ2YsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtBQUN2Qjs7QUFFQTtDQUNDLHVCQUF1QjtDQUN2QixXQUFXO0NBQ1gsU0FBUztDQUNULG9CQUFhO0NBQWIsYUFBYTtBQUNkOztBQUVBO0NBQ0MsYUFBYTtDQUNiLGdCQUFnQjtDQUNoQixrQkFBa0I7Q0FDbEIsWUFBWTtDQUNaLGtCQUFrQjtDQUNsQixnQkFBZ0I7Q0FDaEIseUJBQXlCO0FBQzFCOztBQUdBO0NBQ0MsdUJBQXVCO0NBQ3ZCLHNCQUFzQjtDQUN0Qix3QkFBd0I7Q0FDeEIsNEJBQTRCO0NBQzVCLDBCQUEwQjtDQUMxQixXQUFXO0NBQ1gsWUFBWTs7QUFFYiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvZmlsZS1wcmV2aWV3L2ZpbGUtcHJldmlldy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcblxyXG4ucHJldmlldy1kZXRhaWxzLWRpYWxvZ3tcclxuXHR3aWR0aDogNzAwcHg7XHJcbiAgICBtYXgtd2lkdGg6IDkwdnc7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcclxuICAgIHBvaW50ZXItZXZlbnRzOiBhbGw7XHJcbn1cclxuXHJcbi5zY2FubmVkLXJlc3VsdC1jb250YWluZXJ7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHRcclxuXHR3aWR0aDogMTAwJTtcclxuXHRtYXJnaW46IDA7XHJcblx0ZGlzcGxheTogZmxleDtcclxufVxyXG5cclxuLnNjYW5uZWQtaXRlbS1wcmV2aWV3LWNvbnRhaW5lciB7XHJcblx0cGFkZGluZzogMTBweDtcclxuXHRtYXJnaW46IDVweCBhdXRvO1xyXG5cdGJvcmRlci1yYWRpdXM6IDVweDtcclxuXHRoZWlnaHQ6IDgwdmg7XHJcblx0b3ZlcmZsb3cteDogaGlkZGVuO1xyXG5cdG92ZXJmbG93LXk6IGF1dG87XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2UwZTBlMDtcclxufVxyXG5cclxuXHJcbi5zY2FubmVkLWl0ZW0tcHJldmlldy1pbWFnZXtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcclxuXHRiYWNrZ3JvdW5kLWltYWdlOiBub25lO1xyXG5cdGJhY2tncm91bmQtcG9zaXRpb246IDAgMDtcclxuXHRiYWNrZ3JvdW5kLXJlcGVhdDogbm8tcmVwZWF0O1xyXG5cdGJhY2tncm91bmQtc2l6ZTogMTAwJSAxMDAlO1xyXG5cdHdpZHRoOiAxMDAlO1xyXG5cdGhlaWdodDogMTAwJTtcclxuXHRcclxufVxyXG5cclxuXHJcblxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](FilePreviewComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-file-preview',
                templateUrl: './file-preview.component.html',
                styleUrls: ['./file-preview.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"] }]; }, { fileUrl: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['fileUrl']
        }], imageSizeX: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['imageSizeX']
        }], imageSizeY: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['imageSizeY']
        }], fileIsPdf: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['fileIsPdf']
        }], fileIsImage: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['fileIsImage']
        }], dialogClosed: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }], showDialog: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['showDialog']
        }] }); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");




const _c0 = function (a0) { return { "show": a0 }; };
function LoadingDialogComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r168 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](1, _c0, ctx_r168.showLoading));
} }
class LoadingDialogComponent {
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
}
LoadingDialogComponent.ɵfac = function LoadingDialogComponent_Factory(t) { return new (t || LoadingDialogComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_1__["LoadingServiceService"])); };
LoadingDialogComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: LoadingDialogComponent, selectors: [["app-loading-dialog"]], decls: 1, vars: 1, consts: [["class", "modal fade", "tabindex", "-1", "id", "loadingdialog", "role", "dialog", 3, "ngClass", 4, "ngIf"], ["tabindex", "-1", "id", "loadingdialog", "role", "dialog", 1, "modal", "fade", 3, "ngClass"], ["role", "document", 1, "loading"]], template: function LoadingDialogComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, LoadingDialogComponent_div_0_Template, 2, 3, "div", 0);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showLoading);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["NgClass"]], styles: [".loading-container[_ngcontent-%COMP%]\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  \r\n}\r\n\r\n.loading[_ngcontent-%COMP%]\r\n{\r\n  width: 100vw !important; \r\n  height: 100vh !important; \r\n  background-color: rgba(100, 100, 100, 0.3);\r\n  background-image: url(/assets/images/loading200.gif);\r\n  background-repeat: no-repeat;\r\n  background-position: center;\r\n  background-size: 90px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9sb2FkaW5nLWRpYWxvZy9sb2FkaW5nLWRpYWxvZy5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7O0VBRUUsdUJBQXVCO0VBQ3ZCLHdCQUF3Qjs7QUFFMUI7O0FBRUE7O0VBRUUsdUJBQXVCO0VBQ3ZCLHdCQUF3QjtFQUN4QiwwQ0FBMEM7RUFDMUMsb0RBQW9EO0VBQ3BELDRCQUE0QjtFQUM1QiwyQkFBMkI7RUFDM0IscUJBQXFCO0FBQ3ZCIiwiZmlsZSI6InNyYy9hcHAvY29tcG9uZW50cy9sb2FkaW5nLWRpYWxvZy9sb2FkaW5nLWRpYWxvZy5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcblxyXG4ubG9hZGluZy1jb250YWluZXJcclxue1xyXG4gIHdpZHRoOiAxMDB2dyAhaW1wb3J0YW50OyBcclxuICBoZWlnaHQ6IDEwMHZoICFpbXBvcnRhbnQ7IFxyXG4gIFxyXG59XHJcblxyXG4ubG9hZGluZ1xyXG57XHJcbiAgd2lkdGg6IDEwMHZ3ICFpbXBvcnRhbnQ7IFxyXG4gIGhlaWdodDogMTAwdmggIWltcG9ydGFudDsgXHJcbiAgYmFja2dyb3VuZC1jb2xvcjogcmdiYSgxMDAsIDEwMCwgMTAwLCAwLjMpO1xyXG4gIGJhY2tncm91bmQtaW1hZ2U6IHVybCgvYXNzZXRzL2ltYWdlcy9sb2FkaW5nMjAwLmdpZik7XHJcbiAgYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcclxuICBiYWNrZ3JvdW5kLXBvc2l0aW9uOiBjZW50ZXI7XHJcbiAgYmFja2dyb3VuZC1zaXplOiA5MHB4O1xyXG59XHJcblxyXG5cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LoadingDialogComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-loading-dialog',
                templateUrl: './loading-dialog.component.html',
                styleUrls: ['./loading-dialog.component.css']
            }]
    }], function () { return [{ type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_1__["LoadingServiceService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");





function SelectUserComponent_li_23_Template(rf, ctx) { if (rf & 1) {
    const _r179 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "li", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "input", 21, 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function SelectUserComponent_li_23_Template_input_change_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r179); const item_r176 = ctx.$implicit; const _r177 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](2); const ctx_r178 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r178.toggleAssign(item_r176.identity, ctx_r178.assignTypeUser, _r177.checked); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "span", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const item_r176 = ctx.$implicit;
    const ctx_r174 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("value", item_r176.identity);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx_r174.isItemAssigned(item_r176.identity, ctx_r174.assignTypeUser));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵattribute"]("data-assigntitle", item_r176.fullName);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](item_r176.fullName);
} }
function SelectUserComponent_li_26_li_6_Template(rf, ctx) { if (rf & 1) {
    const _r186 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "li", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "input", 21, 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function SelectUserComponent_li_26_li_6_Template_input_change_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r186); const depgrp_r183 = ctx.$implicit; const _r184 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](2); const ctx_r185 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r185.toggleAssign(depgrp_r183.identity, ctx_r185.assignTypeDepartmentGroup, _r184.checked); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "span", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const depgrp_r183 = ctx.$implicit;
    const ctx_r182 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("value", depgrp_r183.identity);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx_r182.isItemAssigned(depgrp_r183.identity, ctx_r182.assignTypeDepartmentGroup));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵattribute"]("data-assigntitle", depgrp_r183.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](depgrp_r183.title);
} }
function SelectUserComponent_li_26_Template(rf, ctx) { if (rf & 1) {
    const _r188 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "li", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "input", 21, 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function SelectUserComponent_li_26_Template_input_change_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r188); const dep_r180 = ctx.$implicit; const _r181 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](2); const ctx_r187 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r187.toggleAssign(dep_r180.identity, ctx_r187.assignTypeDepartment, _r181.checked); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "span", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "ul", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, SelectUserComponent_li_26_li_6_Template, 5, 4, "li", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const dep_r180 = ctx.$implicit;
    const ctx_r175 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("value", dep_r180.identity);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx_r175.isItemAssigned(dep_r180.identity, ctx_r175.assignTypeDepartment));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵattribute"]("data-assigntitle", dep_r180.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](dep_r180.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", dep_r180.departmentGroups);
} }
const _c0 = function (a0) { return { "show": a0 }; };
class SelectUserComponent {
    constructor() {
        this.showAssignModal = false;
        this.selectAssign = [];
        this.onUsersSelected = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].DEPARTMENTGROUP;
    }
    ngOnInit() {
    }
    applyUserSelect() {
        var assigns = [];
        for (var type in this.selectAssign) {
            for (var identity in this.selectAssign[type]) {
                if (this.selectAssign[type][identity]) {
                    var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignItem"];
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
}
SelectUserComponent.ɵfac = function SelectUserComponent_Factory(t) { return new (t || SelectUserComponent)(); };
SelectUserComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: SelectUserComponent, selectors: [["app-select-user"]], inputs: { users: "users", departments: "departments", showAssignModal: "showAssignModal", selectAssign: "selectAssign" }, outputs: { onUsersSelected: "onUsersSelected" }, decls: 34, vars: 14, consts: [["tabindex", "-1", "id", "assignlistdialog", "role", "dialog", "aria-labelledby", "exampleModalCenterTitle", 1, "modal", "fade", 3, "ngClass"], ["role", "document", 1, "modal-dialog", "modal-dialog-centered"], [1, "modal-content", "user-select-modal-content"], [1, "modal-header"], ["id", "exampleModalLongTitle", 1, "modal-title", "dialog-title"], [1, "dialog-toolbar-button", "close", 3, "click"], [1, "material-icons"], [1, "modal-body"], [1, "nav", "nav-tabs"], [1, "active"], ["data-toggle", "tab", "href", "#tabusers", 1, "nav-link", "active"], ["data-toggle", "tab", "href", "#tabdepartments", 1, "nav-link"], [1, "tab-content", "tab-body", "user-select-tab-content"], ["id", "tabusers", 1, "tab-pane", "fade", "in", "active", "show"], [1, "list-item-container"], ["class", "list-item", 4, "ngFor", "ngForOf"], ["id", "tabdepartments", 1, "tab-pane", "fade"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"], ["type", "button", 1, "btn", "btn-primary", 3, "click"], [1, "list-item"], ["type", "checkbox", 1, "assign-checkbox", 3, "checked", "value", "change"], ["inputEl", ""], [1, "user-select-item-label"]], template: function SelectUserComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h5", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function SelectUserComponent_Template_button_click_7_listener($event) { return ctx.hideAssignSelect(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "close");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "ul", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "li", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "a", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](15, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "li");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "a", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](19, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "ul", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](23, SelectUserComponent_li_23_Template, 5, 4, "li", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "ul", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](26, SelectUserComponent_li_26_Template, 7, 5, "li", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "button", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function SelectUserComponent_Template_button_click_28_listener($event) { return ctx.hideAssignSelect(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "i", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](30, "close");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "button", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function SelectUserComponent_Template_button_click_31_listener($event) { return ctx.applyUserSelect(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "i", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](33, "check");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](12, _c0, ctx.showAssignModal));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 6, "workflow-select-assign"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](15, 8, "common.users"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](19, 10, "common.departments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.users);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.departments);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_2__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_2__["NgForOf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslatePipe"]], styles: [".user-select-modal-content[_ngcontent-%COMP%]{\r\n\theight: 500px;\r\n}\r\n\r\n.user-select-tab-content[_ngcontent-%COMP%]{\r\n\theight: calc(100% - 30px);\r\n}\r\n\r\n.user-select-item-label[_ngcontent-%COMP%]{\r\n\tmargin-left: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy9zZWxlY3QtdXNlci9zZWxlY3QtdXNlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLGFBQWE7QUFDZDs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLGlCQUFpQjtBQUNsQiIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvc2VsZWN0LXVzZXIvc2VsZWN0LXVzZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4udXNlci1zZWxlY3QtbW9kYWwtY29udGVudHtcclxuXHRoZWlnaHQ6IDUwMHB4O1xyXG59XHJcblxyXG4udXNlci1zZWxlY3QtdGFiLWNvbnRlbnR7XHJcblx0aGVpZ2h0OiBjYWxjKDEwMCUgLSAzMHB4KTtcclxufVxyXG5cclxuLnVzZXItc2VsZWN0LWl0ZW0tbGFiZWx7XHJcblx0bWFyZ2luLWxlZnQ6IDEwcHg7XHJcbn1cclxuXHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SelectUserComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-select-user',
                templateUrl: './select-user.component.html',
                styleUrls: ['./select-user.component.css']
            }]
    }], function () { return []; }, { users: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['users']
        }], departments: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['departments']
        }], showAssignModal: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['showAssignModal']
        }], selectAssign: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['selectAssign']
        }], onUsersSelected: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }] }); })();


/***/ }),

/***/ "./src/app/components/wm-assign-list/wm-assign-list.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/components/wm-assign-list/wm-assign-list.component.ts ***!
  \***********************************************************************/
/*! exports provided: WmAssignListComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WmAssignListComponent", function() { return WmAssignListComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _select_user_select_user_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../select-user/select-user.component */ "./src/app/components/select-user/select-user.component.ts");






function WmAssignListComponent_span_4_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-select-assign"));
} }
function WmAssignListComponent_div_5_Template(rf, ctx) { if (rf & 1) {
    const _r235 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmAssignListComponent_div_5_Template_button_click_3_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r235); const item_r233 = ctx.$implicit; const ctx_r234 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r234.removeAssign(item_r233.itemIdentity, item_r233.itemType); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const item_r233 = ctx.$implicit;
    const ctx_r232 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("", ctx_r232.getAssignItemTitle(item_r233), " ");
} }
class WmAssignListComponent {
    constructor(translate) {
        this.translate = translate;
        this.assignedUsers = [];
        this.onSelectedAssignChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.selectAssign = [];
        this.showAssignModal = false;
    }
    ngOnInit() {
    }
    onUsersSelected(assigns) {
        this.assignedUsers = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.assignedUsers.push(assign);
        }
        this.hideAssignSelect();
        this.onSelectedAssignChanged.emit(this.assignedUsers);
    }
    showAssignSelect() {
        this.selectAssign = [];
        for (var index in this.assignedUsers) {
            var assign = this.assignedUsers[index];
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
    get hasNoAssigns() {
        if (this.assignedUsers) {
            return this.assignedUsers.length == 0;
        }
        return false;
    }
    removeAssign(identity, type) {
        this.assignedUsers = this.assignedUsers.filter(function (value, index, arr) {
            return value.itemIdentity != identity || value.itemType != type;
        });
    }
    getAssignItemTitle(item) {
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignType"].DEPARTMENTGROUP) {
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
}
WmAssignListComponent.ɵfac = function WmAssignListComponent_Factory(t) { return new (t || WmAssignListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"])); };
WmAssignListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WmAssignListComponent, selectors: [["app-wm-assign-list"]], inputs: { users: "users", departments: "departments", assignedUsers: "assignedUsers" }, outputs: { onSelectedAssignChanged: "onSelectedAssignChanged" }, decls: 8, vars: 6, consts: [[1, "assign-list"], [1, "show-select-dialog", 3, "click"], [1, "material-icons"], [4, "ngIf"], ["class", "user-item-box", 4, "ngFor", "ngForOf"], [1, "clear"], [3, "users", "departments", "showAssignModal", "selectAssign", "onUsersSelected"], [1, "user-item-box"], [3, "click"]], template: function WmAssignListComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmAssignListComponent_Template_button_click_1_listener($event) { return ctx.showAssignSelect(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "i", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "playlist_add");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, WmAssignListComponent_span_4_Template, 3, 3, "span", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, WmAssignListComponent_div_5_Template, 6, 1, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "app-select-user", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onUsersSelected", function WmAssignListComponent_Template_app_select_user_onUsersSelected_7_listener($event) { return ctx.onUsersSelected($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.hasNoAssigns);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.assignedUsers);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", ctx.users)("departments", ctx.departments)("showAssignModal", ctx.showAssignModal)("selectAssign", ctx.selectAssign);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _select_user_select_user_component__WEBPACK_IMPORTED_MODULE_4__["SelectUserComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslatePipe"]], styles: [".assign-list[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 50px;\r\n    max-height: 100px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%] {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy93bS1hc3NpZ24tbGlzdC93bS1hc3NpZ24tbGlzdC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLDJCQUEyQjtJQUN4QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxnQkFBZ0I7SUFDaEIsaUJBQWlCO0lBQ2pCLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLFVBQVU7SUFDVixnQkFBZ0I7SUFDaEIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1oscUJBQXFCO0lBQ3JCLFdBQVc7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLDZCQUE2QjtBQUNqQyIsImZpbGUiOiJzcmMvYXBwL2NvbXBvbmVudHMvd20tYXNzaWduLWxpc3Qvd20tYXNzaWduLWxpc3QuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4uYXNzaWduLWxpc3R7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBtaW4taGVpZ2h0OiA1MHB4O1xyXG4gICAgbWF4LWhlaWdodDogMTAwcHg7XHJcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xyXG4gICAgcGFkZGluZy1yaWdodDogMjRweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHBhZGRpbmc6IDJweCA0cHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGJhY2tncm91bmQ6ICNlNmU2ZTY7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDVweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiB7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiBpLm1hdGVyaWFsLWljb25ze1xyXG5cdGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHNwYW4ge1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5zaG93LXNlbGVjdC1kaWFsb2cge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAtMjBweDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbn1cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WmAssignListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-wm-assign-list',
                templateUrl: './wm-assign-list.component.html',
                styleUrls: ['./wm-assign-list.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslateService"] }]; }, { users: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['users']
        }], departments: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['departments']
        }], assignedUsers: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['assignedUsers']
        }], onSelectedAssignChanged: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }] }); })();


/***/ }),

/***/ "./src/app/components/wm-file-upload/wm-file-upload.component.ts":
/*!***********************************************************************!*\
  !*** ./src/app/components/wm-file-upload/wm-file-upload.component.ts ***!
  \***********************************************************************/
/*! exports provided: WmFileUploadComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WmFileUploadComponent", function() { return WmFileUploadComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! jquery */ "./node_modules/jquery/dist/jquery.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(jquery__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../ui-models */ "./src/app/ui-models/index.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _file_preview_file_preview_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../file-preview/file-preview.component */ "./src/app/components/file-preview/file-preview.component.ts");









function WmFileUploadComponent_div_8_button_13_Template(rf, ctx) { if (rf & 1) {
    const _r224 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmFileUploadComponent_div_8_button_13_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r224); const uploaded_r219 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit; const ctx_r222 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r222.ocrUploadedFile(uploaded_r219); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "play_for_work");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function WmFileUploadComponent_div_8_button_14_Template(rf, ctx) { if (rf & 1) {
    const _r227 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmFileUploadComponent_div_8_button_14_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r227); const uploaded_r219 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit; const ctx_r225 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r225.showScanResults(uploaded_r219); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "details");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function WmFileUploadComponent_div_8_Template(rf, ctx) { if (rf & 1) {
    const _r229 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "more_horiz");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "a", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "cloud_download");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "button", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmFileUploadComponent_div_8_Template_button_click_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r229); const uploaded_r219 = ctx.$implicit; const ctx_r228 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r228.showFilePreview(uploaded_r219); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12, "pageview");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, WmFileUploadComponent_div_8_button_13_Template, 3, 0, "button", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, WmFileUploadComponent_div_8_button_14_Template, 3, 0, "button", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "button", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WmFileUploadComponent_div_8_Template_button_click_15_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r229); const uploaded_r219 = ctx.$implicit; const ctx_r230 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r230.removeUploadedFile(uploaded_r219); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17, "delete");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const uploaded_r219 = ctx.$implicit;
    const ctx_r218 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](uploaded_r219.fileName);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("href", "/general/data/file/view/", uploaded_r219.scanedPdfPath, "", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeUrl"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r218.canshowOcrUploadButton(uploaded_r219) && ctx_r218.ocrScanningEnabled);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r218.canShowScanResultsButton(uploaded_r219) && ctx_r218.ocrScanningEnabled);
} }
const _c0 = function (a0) { return { "noDisplay": a0 }; };
const _c1 = function (a0) { return { "uploaded-file-item-container-border": a0 }; };
class WmFileUploadComponent {
    constructor(translate, loadingService, errorService) {
        this.translate = translate;
        this.loadingService = loadingService;
        this.errorService = errorService;
        this.ocrScanningEnabled = false;
        this.showHeaderTitle = true;
        this.drawBorder = false;
        this.editService = null;
        this.onOcrUploadedFile = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.onShowUploadedFileScannDetail = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.onUploadedFilesChanged = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.uploadedFiles = [];
        this.previewFile = new _ui_models__WEBPACK_IMPORTED_MODULE_2__["UploadedFile"];
        this.showFilePreviewDialog = false;
        this.fileExistsMessage = "common.file-exists";
        translate.get('common.file-exists').subscribe((res) => {
            this.fileExistsMessage = res;
        });
    }
    ngOnInit() {
    }
    canShowScanResultsButton(uploaded) {
        return uploaded.isScanned === true;
    }
    canshowOcrUploadButton(uploaded) {
        return uploaded.isScanned === false;
    }
    uploadFile(fileInput) {
        var file = fileInput.target.files[0];
        console.log("file: ", file);
        //alert(file.name);
        if (this.existsUploadedByFileName(file.name)) {
            jquery__WEBPACK_IMPORTED_MODULE_1___default()("#inlineuploadfile")[0].type = "text";
            jquery__WEBPACK_IMPORTED_MODULE_1___default()("#inlineuploadfile")[0].type = "file";
            this.errorService.showError(this.fileExistsMessage, "");
            return;
        }
        jquery__WEBPACK_IMPORTED_MODULE_1___default()("#inlineuploadfile")[0].type = "text";
        jquery__WEBPACK_IMPORTED_MODULE_1___default()("#inlineuploadfile")[0].type = "file";
        this.loadingService.showLoading();
        this.editService.uploadTempFiles(file).subscribe((result) => {
            console.log("upload invoice file result", result);
            this.loadingService.hideLoading();
            if (result.status) {
                if (result.status === "done") {
                    var uploaded = new _ui_models__WEBPACK_IMPORTED_MODULE_2__["UploadedFile"];
                    uploaded.fileName = result.fileName;
                    uploaded.scanedPdfPath = result.fileHash;
                    uploaded.scanedHocrPath = result.hocrFileHash;
                    uploaded.fileIsPdf = result.isFilePdf;
                    uploaded.fileIsImage = result.isFileImage;
                    //uploaded.imageSizeX = result.imageWidth;
                    //uploaded.imageSizeY = result.imageHeight;
                    uploaded.uploadResult = result;
                    this.uploadedFiles.push(uploaded);
                    this.onUploadedFilesChanged.emit(this.uploadedFiles);
                }
                if (result.status === "error" && result.errorMessage) {
                    this.errorService.showError(result.errorMessage, result.errorDetail);
                }
            }
        }, response => {
            console.log("Error in upload invoice file", response);
            this.loadingService.hideLoading();
        }, () => {
        });
    }
    removeUploadedFile(uploaded) {
        var index = this.uploadedFiles.indexOf(uploaded);
        if (index > -1) {
            this.uploadedFiles.splice(index, 1);
            this.onUploadedFilesChanged.emit(this.uploadedFiles);
        }
    }
    ocrUploadedFile(uploaded) {
        var index = this.uploadedFiles.indexOf(uploaded);
        if (index > -1) {
            this.onOcrUploadedFile.emit(this.uploadedFiles[index]);
        }
    }
    showScanResults(uploaded) {
        var index = this.uploadedFiles.indexOf(uploaded);
        if (index > -1) {
            this.onShowUploadedFileScannDetail.emit(this.uploadedFiles[index]);
        }
    }
    showFilePreview(uploaded) {
        this.showFilePreviewDialog = false;
        var index = this.uploadedFiles.indexOf(uploaded);
        if (index > -1) {
            this.previewFile = this.uploadedFiles[index];
            this.showFilePreviewDialog = true;
            console.log("preview file : ", this.previewFile);
        }
    }
    onFilePreviewDialogClosed(closed) {
        this.showFilePreviewDialog = false;
    }
    findUploadedByFileName(fileName) {
        for (var index in this.uploadedFiles) {
            if (this.uploadedFiles[index].fileName === fileName) {
                return this.uploadedFiles[index];
            }
        }
        return null;
    }
    existsUploadedByFileName(fileName) {
        return this.findUploadedByFileName(fileName) !== null;
    }
}
WmFileUploadComponent.ɵfac = function WmFileUploadComponent_Factory(t) { return new (t || WmFileUploadComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_5__["ErrorServiceService"])); };
WmFileUploadComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WmFileUploadComponent, selectors: [["app-wm-file-upload"]], inputs: { ocrScanningEnabled: "ocrScanningEnabled", showHeaderTitle: "showHeaderTitle", drawBorder: "drawBorder", editService: "editService" }, outputs: { onOcrUploadedFile: "onOcrUploadedFile", onShowUploadedFileScannDetail: "onShowUploadedFileScannDetail", onUploadedFilesChanged: "onUploadedFilesChanged" }, decls: 10, vars: 16, consts: [[1, "panel-heading", "uploaded-file-header", 3, "ngClass"], [1, "uploaded-file-item-container", 3, "ngClass"], [1, "upload-file-container"], ["type", "file", "id", "inlineuploadfile", "accept", ".pdf,.jpg, .png, .tiff, .bmp", 1, "hide-file-input", 3, "change"], ["for", "inlineuploadfile", 1, "hide-file-label"], [1, "clear"], ["class", "uploaded-file-item list-group-item", 4, "ngFor", "ngForOf"], [3, "showDialog", "fileUrl", "fileIsPdf", "fileIsImage", "imageSizeX", "imageSizeY", "dialogClosed"], [1, "uploaded-file-item", "list-group-item"], [1, "filename"], ["type", "button", "data-toggle", "dropdown", "aria-haspopup", "true", "aria-expanded", "false", 1, "btn", "btn-light", "upload-button", 2, "float", "right"], [1, "material-icons"], ["aria-labelledby", "dropdownMenuButton", 1, "dropdown-menu"], ["target", "_blank", 1, "btn", "btn-primary", "upload-button", 3, "href"], [1, "btn", "btn-primary", "upload-button", 3, "click"], ["class", "btn btn-primary upload-button", 3, "click", 4, "ngIf"], ["class", "btn btn-success upload-button", 3, "click", 4, "ngIf"], [1, "btn", "btn-dark", "upload-button", 3, "click"], [1, "btn", "btn-success", "upload-button", 3, "click"]], template: function WmFileUploadComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "input", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function WmFileUploadComponent_Template_input_change_5_listener($event) { return ctx.uploadFile($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "label", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, WmFileUploadComponent_div_8_Template, 18, 4, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "app-file-preview", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("dialogClosed", function WmFileUploadComponent_Template_app_file_preview_dialogClosed_9_listener($event) { return ctx.onFilePreviewDialogClosed($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](12, _c0, ctx.showHeaderTitle === false));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 10, "common.attachments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](14, _c1, ctx.drawBorder));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.uploadedFiles);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("showDialog", ctx.showFilePreviewDialog)("fileUrl", ctx.previewFile.scanedPdfPath)("fileIsPdf", ctx.previewFile.fileIsPdf)("fileIsImage", ctx.previewFile.fileIsImage)("imageSizeX", ctx.previewFile.imageSizeX)("imageSizeY", ctx.previewFile.imageSizeY);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_6__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_6__["NgForOf"], _file_preview_file_preview_component__WEBPACK_IMPORTED_MODULE_7__["FilePreviewComponent"], _angular_common__WEBPACK_IMPORTED_MODULE_6__["NgIf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslatePipe"]], styles: [".panel-heading[_ngcontent-%COMP%]{\r\n\tfont-weight: bold;\t\r\n\tmargin-bottom: 10px;\r\n}\r\n\r\n.uploaded-file-item-container[_ngcontent-%COMP%]{\r\n\tmin-height: 70px;\r\n    overflow-y: auto;\r\n    max-height: 200px;\r\n    overflow-x: hidden;\r\n    padding-right: 40px;\r\n}\r\n\r\n.uploaded-file-item-container-border[_ngcontent-%COMP%]{\r\n\tborder: 1px solid gray;\r\n    border-radius: 5px;\r\n    padding: 4px;\r\n    padding-right: 40px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%] {\r\n\tpadding: 5px 4px 0 10px;\r\n\tmargin-bottom: 3px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]:hover {\r\n\tbackground-color: #feffea;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .filename[_ngcontent-%COMP%] {\r\n\twidth: calc(100% - 54px);\r\n    display: inline-block;\r\n    overflow: hidden;\r\n    overflow-y: hidden;\r\n    height: 30px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .upload-button[_ngcontent-%COMP%]{\r\n    padding: 0px 4px;\r\n    margin-left: 5px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .upload-button[_ngcontent-%COMP%]   .material-icons[_ngcontent-%COMP%]{\r\n    font-size: 16px;\r\n}\r\n\r\n.upload-file-container[_ngcontent-%COMP%]{\r\n\tfloat: right;\r\n\twidth: 24px;\r\n\theight: 24px;\r\n\tmargin-right: -37px;\r\n}\r\n\r\n.hide-file-input[_ngcontent-%COMP%] {\r\n    position: relative;\r\n    z-index: 2;\r\n    width: 0;\r\n    height: 0;\r\n    margin: 0;\r\n    opacity: 0;\r\n}\r\n\r\n.hide-file-label[_ngcontent-%COMP%] {\r\n    position: relative;\r\n    padding: 0;\r\n    margin-top: 0;\r\n    top: auto;\r\n    left: auto;\r\n    right: auto;\r\n    float: right;\r\n    z-index: 1;\r\n    height: 20px;\r\n    font-weight: 400;\r\n    line-height: 1.5;\r\n    color: #495057;\r\n    \r\n}\r\n\r\n.hide-file-label[_ngcontent-%COMP%]::after {\r\n\tcontent: \"\";\r\n    display: block;\r\n    background-image: url(/assets/images/cloud_upload.png);\r\n    background-repeat: no-repeat;\r\n    background-position: center;\r\n    background-size: 24px;\r\n    height: 24px;\r\n    width: 24px;\r\n    \r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvY29tcG9uZW50cy93bS1maWxlLXVwbG9hZC93bS1maWxlLXVwbG9hZC5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLGlCQUFpQjtDQUNqQixtQkFBbUI7QUFDcEI7O0FBRUE7Q0FDQyxnQkFBZ0I7SUFDYixnQkFBZ0I7SUFDaEIsaUJBQWlCO0lBQ2pCLGtCQUFrQjtJQUNsQixtQkFBbUI7QUFDdkI7O0FBRUE7Q0FDQyxzQkFBc0I7SUFDbkIsa0JBQWtCO0lBQ2xCLFlBQVk7SUFDWixtQkFBbUI7QUFDdkI7O0FBRUE7Q0FDQyx1QkFBdUI7Q0FDdkIsa0JBQWtCO0FBQ25COztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0Msd0JBQXdCO0lBQ3JCLHFCQUFxQjtJQUNyQixnQkFBZ0I7SUFDaEIsa0JBQWtCO0lBQ2xCLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxnQkFBZ0I7SUFDaEIsZ0JBQWdCO0FBQ3BCOztBQUVBO0lBQ0ksZUFBZTtBQUNuQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixXQUFXO0NBQ1gsWUFBWTtDQUNaLG1CQUFtQjtBQUNwQjs7QUFHQTtJQUNJLGtCQUFrQjtJQUNsQixVQUFVO0lBQ1YsUUFBUTtJQUNSLFNBQVM7SUFDVCxTQUFTO0lBQ1QsVUFBVTtBQUNkOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLFVBQVU7SUFDVixhQUFhO0lBQ2IsU0FBUztJQUNULFVBQVU7SUFDVixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixZQUFZO0lBQ1osZ0JBQWdCO0lBQ2hCLGdCQUFnQjtJQUNoQixjQUFjOztBQUVsQjs7QUFFQTtDQUNDLFdBQVc7SUFDUixjQUFjO0lBQ2Qsc0RBQXNEO0lBQ3RELDRCQUE0QjtJQUM1QiwyQkFBMkI7SUFDM0IscUJBQXFCO0lBQ3JCLFlBQVk7SUFDWixXQUFXOztBQUVmIiwiZmlsZSI6InNyYy9hcHAvY29tcG9uZW50cy93bS1maWxlLXVwbG9hZC93bS1maWxlLXVwbG9hZC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5wYW5lbC1oZWFkaW5ne1xyXG5cdGZvbnQtd2VpZ2h0OiBib2xkO1x0XHJcblx0bWFyZ2luLWJvdHRvbTogMTBweDtcclxufVxyXG5cclxuLnVwbG9hZGVkLWZpbGUtaXRlbS1jb250YWluZXJ7XHJcblx0bWluLWhlaWdodDogNzBweDtcclxuICAgIG92ZXJmbG93LXk6IGF1dG87XHJcbiAgICBtYXgtaGVpZ2h0OiAyMDBweDtcclxuICAgIG92ZXJmbG93LXg6IGhpZGRlbjtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDQwcHg7XHJcbn1cclxuXHJcbi51cGxvYWRlZC1maWxlLWl0ZW0tY29udGFpbmVyLWJvcmRlcntcclxuXHRib3JkZXI6IDFweCBzb2xpZCBncmF5O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNXB4O1xyXG4gICAgcGFkZGluZzogNHB4O1xyXG4gICAgcGFkZGluZy1yaWdodDogNDBweDtcclxufVxyXG5cclxuLnVwbG9hZGVkLWZpbGUtaXRlbSB7XHJcblx0cGFkZGluZzogNXB4IDRweCAwIDEwcHg7XHJcblx0bWFyZ2luLWJvdHRvbTogM3B4O1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtOmhvdmVyIHtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjZmVmZmVhO1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtIC5maWxlbmFtZSB7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDU0cHgpO1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgb3ZlcmZsb3c6IGhpZGRlbjtcclxuICAgIG92ZXJmbG93LXk6IGhpZGRlbjtcclxuICAgIGhlaWdodDogMzBweDtcclxufVxyXG5cclxuLnVwbG9hZGVkLWZpbGUtaXRlbSAudXBsb2FkLWJ1dHRvbntcclxuICAgIHBhZGRpbmc6IDBweCA0cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtIC51cGxvYWQtYnV0dG9uIC5tYXRlcmlhbC1pY29uc3tcclxuICAgIGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuLnVwbG9hZC1maWxlLWNvbnRhaW5lcntcclxuXHRmbG9hdDogcmlnaHQ7XHJcblx0d2lkdGg6IDI0cHg7XHJcblx0aGVpZ2h0OiAyNHB4O1xyXG5cdG1hcmdpbi1yaWdodDogLTM3cHg7XHJcbn1cclxuXHJcblxyXG4uaGlkZS1maWxlLWlucHV0IHtcclxuICAgIHBvc2l0aW9uOiByZWxhdGl2ZTtcclxuICAgIHotaW5kZXg6IDI7XHJcbiAgICB3aWR0aDogMDtcclxuICAgIGhlaWdodDogMDtcclxuICAgIG1hcmdpbjogMDtcclxuICAgIG9wYWNpdHk6IDA7XHJcbn1cclxuXHJcbi5oaWRlLWZpbGUtbGFiZWwge1xyXG4gICAgcG9zaXRpb246IHJlbGF0aXZlO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIG1hcmdpbi10b3A6IDA7XHJcbiAgICB0b3A6IGF1dG87XHJcbiAgICBsZWZ0OiBhdXRvO1xyXG4gICAgcmlnaHQ6IGF1dG87XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB6LWluZGV4OiAxO1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZm9udC13ZWlnaHQ6IDQwMDtcclxuICAgIGxpbmUtaGVpZ2h0OiAxLjU7XHJcbiAgICBjb2xvcjogIzQ5NTA1NztcclxuICAgIFxyXG59XHJcblxyXG4uaGlkZS1maWxlLWxhYmVsOjphZnRlciB7XHJcblx0Y29udGVudDogXCJcIjtcclxuICAgIGRpc3BsYXk6IGJsb2NrO1xyXG4gICAgYmFja2dyb3VuZC1pbWFnZTogdXJsKC9hc3NldHMvaW1hZ2VzL2Nsb3VkX3VwbG9hZC5wbmcpO1xyXG4gICAgYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcclxuICAgIGJhY2tncm91bmQtcG9zaXRpb246IGNlbnRlcjtcclxuICAgIGJhY2tncm91bmQtc2l6ZTogMjRweDtcclxuICAgIGhlaWdodDogMjRweDtcclxuICAgIHdpZHRoOiAyNHB4O1xyXG4gICAgXHJcbn1cclxuXHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WmFileUploadComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-wm-file-upload',
                templateUrl: './wm-file-upload.component.html',
                styleUrls: ['./wm-file-upload.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_5__["ErrorServiceService"] }]; }, { ocrScanningEnabled: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['ocrScanningEnabled']
        }], showHeaderTitle: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['showHeaderTitle']
        }], drawBorder: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['drawBorder']
        }], editService: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['editService']
        }], onOcrUploadedFile: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }], onShowUploadedFileScannDetail: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }], onUploadedFilesChanged: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }] }); })();


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
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");

function InvoiceTypeControllValidator(control) {
    let invoiceType = _wf_models__WEBPACK_IMPORTED_MODULE_0__["InvoiceType"][control.value];
    if (invoiceType !== undefined && (invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_0__["InvoiceType"].SUPPLIER || invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_0__["InvoiceType"].WORKER || invoiceType === _wf_models__WEBPACK_IMPORTED_MODULE_0__["InvoiceType"].PAYMENT)) {
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
/* harmony import */ var _fake_responses__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./fake-responses */ "./src/app/fake-data/fake-responses.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationOKResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["AuthenticationOKResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationFailedResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["AuthenticationFailedResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GeneralDataOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["GeneralDataOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InitialSearchDataOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["InitialSearchDataOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResultOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["WorkflowSearchResultOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSaveRequestInitOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["WorkflowSaveRequestInitOkResponse"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InvoiceWorkflowSaveRequestInitOkResponse", function() { return _fake_responses__WEBPACK_IMPORTED_MODULE_0__["InvoiceWorkflowSaveRequestInitOkResponse"]; });




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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");



class FooterComponent {
    constructor(translate) {
        translate.setDefaultLang('de');
        translate.use('de');
    }
    ngOnInit() {
    }
}
FooterComponent.ɵfac = function FooterComponent_Factory(t) { return new (t || FooterComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"])); };
FooterComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: FooterComponent, selectors: [["app-footer"]], decls: 6, vars: 3, consts: [[1, "footer"], [1, "footer-title"]], template: function FooterComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "footer", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "strong");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "span", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 1, "site.footer"));
    } }, pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslatePipe"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvZm9vdGVyL2Zvb3Rlci5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7O0FBRUE7Ozs7Q0FJQyIsImZpbGUiOiJzcmMvYXBwL2Zvb3Rlci9mb290ZXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5cclxuLypcclxuQ29weXJpZ2h0IEdvb2dsZSBMTEMuIEFsbCBSaWdodHMgUmVzZXJ2ZWQuXHJcblVzZSBvZiB0aGlzIHNvdXJjZSBjb2RlIGlzIGdvdmVybmVkIGJ5IGFuIE1JVC1zdHlsZSBsaWNlbnNlIHRoYXRcclxuY2FuIGJlIGZvdW5kIGluIHRoZSBMSUNFTlNFIGZpbGUgYXQgaHR0cDovL2FuZ3VsYXIuaW8vbGljZW5zZVxyXG4qLyJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](FooterComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-footer',
                templateUrl: './footer.component.html',
                styleUrls: ['./footer.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_1__["TranslateService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var rxjs_operators__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! rxjs/operators */ "./node_modules/rxjs/_esm2015/operators/index.js");
/* harmony import */ var _http_hepler__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _fake_data__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../fake-data */ "./src/app/fake-data/index.ts");







class FakeBackendInterceptor {
    constructor() {
    }
    intercept(request, next) {
        // wrap in delayed observable to simulate server api call
        return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(null).pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["mergeMap"])(() => {
            if (request.headers == undefined || (request.headers && request.headers.has(_http_hepler__WEBPACK_IMPORTED_MODULE_4__["InterceptorUseHeader"]) === false)) {
                const headers = request.headers;
                return next.handle(request.clone({ headers }));
            }
            // authenticate
            if (request.url.endsWith('/auth/authenticate') && request.method === 'POST') {
                if (request.body == null || request.body.username == null || request.body.username == ""
                    || request.body.password == null || request.body.password == "" || request.body.companyid == null
                    || request.body.companyid == "") {
                    //return throwError({ error: { message: 'Username or password is incorrect' } });
                    return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["AuthenticationFailedResponse"] }));
                }
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["AuthenticationOKResponse"] }));
            }
            // get general data
            if (request.url.endsWith('/general/data/generaldatat') && request.method === 'GET') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["GeneralDataOkResponse"] }));
            }
            // get workflow search init data
            if (request.url.endsWith('/workflow/general/data/initsearch') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["InitialSearchDataOkResponse"] }));
            }
            // get workflow search result
            if (request.url.endsWith('/workflow/general/data/search') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["WorkflowSearchResultOkResponse"] }));
            }
            // get workflow create & edit initial result
            if ((request.url.endsWith('/workflow/singletask/data/initcreate') ||
                request.url.endsWith('/workflow/testthreetask/data/initcreate'))
                && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["WorkflowSaveRequestInitOkResponse"] }));
            }
            // get workflow create & edit initial result
            if (request.url.endsWith('/workflow/invoice/data/initcreate') && request.method === 'POST') {
                return Object(rxjs__WEBPACK_IMPORTED_MODULE_2__["of"])(new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpResponse"]({ status: 200, body: _fake_data__WEBPACK_IMPORTED_MODULE_5__["InvoiceWorkflowSaveRequestInitOkResponse"] }));
            }
            // pass through any requests not handled above
            return next.handle(request);
        }))
            // call materialize and dematerialize to ensure delay even if an error is thrown (https://github.com/Reactive-Extensions/RxJS/issues/648)
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["materialize"])())
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["delay"])(500))
            .pipe(Object(rxjs_operators__WEBPACK_IMPORTED_MODULE_3__["dematerialize"])());
    }
}
FakeBackendInterceptor.ɵfac = function FakeBackendInterceptor_Factory(t) { return new (t || FakeBackendInterceptor)(); };
FakeBackendInterceptor.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: FakeBackendInterceptor, factory: FakeBackendInterceptor.ɵfac });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](FakeBackendInterceptor, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"]
    }], function () { return []; }, null); })();
let fakeBackendProvider = {
    // use fake backend in place of Http service for backend-less development
    provide: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HTTP_INTERCEPTORS"],
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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _date_helper__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./date-helper */ "./src/app/helper/date-helper.ts");




const SUPPORTS_INTL_API = typeof Intl !== 'undefined';
class GermanDateAdapter extends _angular_material_core__WEBPACK_IMPORTED_MODULE_1__["NativeDateAdapter"] {
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
        return Object(_date_helper__WEBPACK_IMPORTED_MODULE_2__["formatDate"])(date, "dd.mm.yyyy");
        if (SUPPORTS_INTL_API) {
            if (this.useUtcForDisplay) {
                date = new Date(Date.UTC(date.getFullYear(), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), date.getMilliseconds()));
                displayFormat = Object.assign({}, displayFormat, { timeZone: 'utc' });
            }
            const dtf = new Intl.DateTimeFormat(this.locale, displayFormat);
            return dtf.format(date).replace(/[\u200e\u200f]/g, '');
        }
    }
}
GermanDateAdapter.ɵfac = function GermanDateAdapter_Factory(t) { return ɵGermanDateAdapter_BaseFactory(t || GermanDateAdapter); };
GermanDateAdapter.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: GermanDateAdapter, factory: GermanDateAdapter.ɵfac });
const ɵGermanDateAdapter_BaseFactory = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetInheritedFactory"](GermanDateAdapter);
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GermanDateAdapter, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"]
    }], null, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services */ "./src/app/services/index.ts");




class HttpErrorResponseHelper {
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
}
HttpErrorResponseHelper.ɵfac = function HttpErrorResponseHelper_Factory(t) { return new (t || HttpErrorResponseHelper)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_services__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"])); };
HttpErrorResponseHelper.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: HttpErrorResponseHelper, factory: HttpErrorResponseHelper.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](HttpErrorResponseHelper, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }, { type: _services__WEBPACK_IMPORTED_MODULE_2__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../../environments/environment */ "./src/environments/environment.ts");


const InterceptorUseHeader = 'X-Use-Interceptor';
class HttpHepler {
    static generateFormHeader() {
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
            'Content-Type': 'application/x-www-form-urlencoded',
            'Authorization': 'my-auth-token',
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
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
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
            'Content-Type': 'application/json; charset=UTF-8',
            'Authorization': 'my-auth-token',
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
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
        var header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
            //'Content-Type' : undefined,
            'Cache-Control': 'no-cache',
            'Pragma': 'no-cache',
            'Expires': 'Sat, 01 Jan 2000 00:00:00 GMT'
        });
        if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].fake === true) {
            header = new _angular_common_http__WEBPACK_IMPORTED_MODULE_0__["HttpHeaders"]({
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
/* harmony import */ var _fake_backend__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./fake-backend */ "./src/app/helper/fake-backend.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "FakeBackendInterceptor", function() { return _fake_backend__WEBPACK_IMPORTED_MODULE_0__["FakeBackendInterceptor"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "fakeBackendProvider", function() { return _fake_backend__WEBPACK_IMPORTED_MODULE_0__["fakeBackendProvider"]; });

/* harmony import */ var _german_date_adapter__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./german-date-adapter */ "./src/app/helper/german-date-adapter.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GermanDateAdapter", function() { return _german_date_adapter__WEBPACK_IMPORTED_MODULE_1__["GermanDateAdapter"]; });

/* harmony import */ var _date_helper__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./date-helper */ "./src/app/helper/date-helper.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "parseDate", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_2__["parseDate"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "formatDate", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_2__["formatDate"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "getStringWithOneLeadingZero", function() { return _date_helper__WEBPACK_IMPORTED_MODULE_2__["getStringWithOneLeadingZero"]; });






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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");


class HomeComponent {
    constructor() {
    }
    ngOnInit() {
    }
}
HomeComponent.ɵfac = function HomeComponent_Factory(t) { return new (t || HomeComponent)(); };
HomeComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: HomeComponent, selectors: [["app-root"]], decls: 2, vars: 0, template: function HomeComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "h1");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Home!");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } }, encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](HomeComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{ selector: 'app-root', templateUrl: 'home.component.html' }]
    }], function () { return []; }, null); })();


/***/ }),

/***/ "./src/app/home/index.ts":
/*!*******************************!*\
  !*** ./src/app/home/index.ts ***!
  \*******************************/
/*! exports provided: HomeComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _home_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./home.component */ "./src/app/home/home.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "HomeComponent", function() { return _home_component__WEBPACK_IMPORTED_MODULE_0__["HomeComponent"]; });




/***/ }),

/***/ "./src/app/login/index.ts":
/*!********************************!*\
  !*** ./src/app/login/index.ts ***!
  \********************************/
/*! exports provided: LoginComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _login_component__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./login.component */ "./src/app/login/login.component.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginComponent", function() { return _login_component__WEBPACK_IMPORTED_MODULE_0__["LoginComponent"]; });




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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services */ "./src/app/services/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");











function LoginComponent_div_8_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "CopmayId is required");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function LoginComponent_div_8_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, LoginComponent_div_8_div_1_Template, 2, 0, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r18 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r18.forms.companyid.errors.required);
} }
function LoginComponent_div_14_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Username is required");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function LoginComponent_div_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, LoginComponent_div_14_div_1_Template, 2, 0, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r19 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r19.forms.username.errors.required);
} }
function LoginComponent_div_20_div_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, "Password is required");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function LoginComponent_div_20_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, LoginComponent_div_20_div_1_Template, 2, 0, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r20 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r20.forms.password.errors.required);
} }
function LoginComponent_span_23_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "span", 14);
} }
function LoginComponent_div_26_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r22 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r22.loginResponse.message);
} }
const _c0 = function (a0) { return { "is-invalid": a0 }; };
class LoginComponent {
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
        this.loginResponse = new _ui_models__WEBPACK_IMPORTED_MODULE_3__["LoginResponse"];
        translate.setDefaultLang('de');
        translate.use('de');
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
                this.global.loadAllSetting(null);
            }
        });
    }
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['admin@iflow.de', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            password: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            companyid: [localStorage.getItem('companyId'), _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
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
}
LoginComponent.ɵfac = function LoginComponent_Factory(t) { return new (t || LoginComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services__WEBPACK_IMPORTED_MODULE_4__["AuthenticationService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateService"])); };
LoginComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: LoginComponent, selectors: [["ng-component"]], decls: 27, vars: 28, consts: [["layout", "row", "layout-align", "center center", 1, "login-container-parent", "layout-align-center-center", "layout-row"], [1, "login-container"], ["method", "POST", "id", "formlogin", 3, "formGroup"], [1, "form-group"], ["type", "text", "name", "companyid", "autofocus", "", "formControlName", "companyid", 1, "form-control", 3, "ngClass"], ["class", "invalid-feedback", 4, "ngIf"], ["type", "text", "name", "username", "autofocus", "", "formControlName", "username", 1, "form-control", 3, "ngClass"], ["type", "password", "name", "password", "formControlName", "password", 1, "form-control", 3, "ngClass"], ["layout", "row", 1, "layout-row", "form-group"], ["type", "button", 1, "btn", "btn-primary", 3, "disabled", "click"], ["class", "spinner-border spinner-border-sm mr-1", 4, "ngIf"], ["class", "invalid-message", 4, "ngIf"], [1, "invalid-feedback"], [4, "ngIf"], [1, "spinner-border", "spinner-border-sm", "mr-1"], [1, "invalid-message"]], template: function LoginComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "form", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "input", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, LoginComponent_div_8_Template, 2, 1, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](12, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](13, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, LoginComponent_div_14_Template, 2, 1, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "label");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](18, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](19, "input", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](20, LoginComponent_div_20_Template, 2, 1, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "button", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function LoginComponent_Template_button_click_22_listener($event) { return ctx.onSubmit(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](23, LoginComponent_span_23_Template, 1, 0, "span", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](25, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](26, LoginComponent_div_26_Template, 3, 1, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.loginForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 14, "common.companyidentificator"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](22, _c0, ctx.submitted && ctx.forms.companyid.errors));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.submitted && ctx.forms.companyid.errors);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](12, 16, "common.username"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](24, _c0, ctx.submitted && ctx.forms.username.errors));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.submitted && ctx.forms.username.errors);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](18, 18, "common.password"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](26, _c0, ctx.submitted && ctx.forms.password.errors));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.submitted && ctx.forms.password.errors);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.loading);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.loading);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](25, 20, "common.login"), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.submitted && ctx.failedLogin);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControlName"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_7__["NgIf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslatePipe"]], encapsulation: 2 });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LoginComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{ templateUrl: 'login.component.html' }]
    }], function () { return [{ type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services__WEBPACK_IMPORTED_MODULE_4__["AuthenticationService"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_5__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_6__["TranslateService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/cdk/a11y */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/a11y.js");
/* harmony import */ var _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/cdk/drag-drop */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/drag-drop.js");
/* harmony import */ var _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/cdk/portal */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/portal.js");
/* harmony import */ var _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/cdk/scrolling */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/scrolling.js");
/* harmony import */ var _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/cdk/stepper */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/stepper.js");
/* harmony import */ var _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/cdk/table */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/table.js");
/* harmony import */ var _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/cdk/tree */ "./node_modules/@angular/cdk/__ivy_ngcc__/fesm2015/tree.js");
/* harmony import */ var _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/material/autocomplete */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/autocomplete.js");
/* harmony import */ var _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/material/badge */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/badge.js");
/* harmony import */ var _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/bottom-sheet */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/bottom-sheet.js");
/* harmony import */ var _angular_material_button__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/material/button */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button.js");
/* harmony import */ var _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/button-toggle */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/button-toggle.js");
/* harmony import */ var _angular_material_card__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/card */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/card.js");
/* harmony import */ var _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/checkbox */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/checkbox.js");
/* harmony import */ var _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/chips */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/chips.js");
/* harmony import */ var _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/stepper */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/stepper.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/datepicker.js");
/* harmony import */ var _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! @angular/material/dialog */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/dialog.js");
/* harmony import */ var _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! @angular/material/divider */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/divider.js");
/* harmony import */ var _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! @angular/material/expansion */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/expansion.js");
/* harmony import */ var _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__ = __webpack_require__(/*! @angular/material/grid-list */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/grid-list.js");
/* harmony import */ var _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__ = __webpack_require__(/*! @angular/material/icon */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/icon.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_23__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_list__WEBPACK_IMPORTED_MODULE_24__ = __webpack_require__(/*! @angular/material/list */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/list.js");
/* harmony import */ var _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__ = __webpack_require__(/*! @angular/material/menu */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/menu.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_26__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__ = __webpack_require__(/*! @angular/material/paginator */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/paginator.js");
/* harmony import */ var _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__ = __webpack_require__(/*! @angular/material/progress-bar */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-bar.js");
/* harmony import */ var _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__ = __webpack_require__(/*! @angular/material/progress-spinner */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/progress-spinner.js");
/* harmony import */ var _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__ = __webpack_require__(/*! @angular/material/radio */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/radio.js");
/* harmony import */ var _angular_material_select__WEBPACK_IMPORTED_MODULE_31__ = __webpack_require__(/*! @angular/material/select */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/select.js");
/* harmony import */ var _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__ = __webpack_require__(/*! @angular/material/sidenav */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sidenav.js");
/* harmony import */ var _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__ = __webpack_require__(/*! @angular/material/slider */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slider.js");
/* harmony import */ var _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__ = __webpack_require__(/*! @angular/material/slide-toggle */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/slide-toggle.js");
/* harmony import */ var _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__ = __webpack_require__(/*! @angular/material/snack-bar */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/snack-bar.js");
/* harmony import */ var _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__ = __webpack_require__(/*! @angular/material/sort */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/sort.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_37__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
/* harmony import */ var _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__ = __webpack_require__(/*! @angular/material/tabs */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tabs.js");
/* harmony import */ var _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__ = __webpack_require__(/*! @angular/material/toolbar */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/toolbar.js");
/* harmony import */ var _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__ = __webpack_require__(/*! @angular/material/tooltip */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tooltip.js");
/* harmony import */ var _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__ = __webpack_require__(/*! @angular/material/tree */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/tree.js");











































class IFlowMaterialModules {
}
IFlowMaterialModules.ɵmod = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineNgModule"]({ type: IFlowMaterialModules });
IFlowMaterialModules.ɵinj = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjector"]({ factory: function IFlowMaterialModules_Factory(t) { return new (t || IFlowMaterialModules)(); }, imports: [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"],
        _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__["CdkStepperModule"],
        _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__["CdkTableModule"],
        _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__["CdkTreeModule"],
        _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__["DragDropModule"],
        _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__["MatAutocompleteModule"],
        _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__["MatBadgeModule"],
        _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__["MatBottomSheetModule"],
        _angular_material_button__WEBPACK_IMPORTED_MODULE_11__["MatButtonModule"],
        _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__["MatButtonToggleModule"],
        _angular_material_card__WEBPACK_IMPORTED_MODULE_13__["MatCardModule"],
        _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__["MatCheckboxModule"],
        _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__["MatChipsModule"],
        _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__["MatStepperModule"],
        _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__["MatDatepickerModule"],
        _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__["MatDialogModule"],
        _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__["MatDividerModule"],
        _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__["MatExpansionModule"],
        _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__["MatGridListModule"],
        _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__["MatIconModule"],
        _angular_material_input__WEBPACK_IMPORTED_MODULE_23__["MatInputModule"],
        _angular_material_list__WEBPACK_IMPORTED_MODULE_24__["MatListModule"],
        _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__["MatMenuModule"],
        _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatNativeDateModule"],
        _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__["MatPaginatorModule"],
        _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__["MatProgressBarModule"],
        _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__["MatProgressSpinnerModule"],
        _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__["MatRadioModule"],
        _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatRippleModule"],
        _angular_material_select__WEBPACK_IMPORTED_MODULE_31__["MatSelectModule"],
        _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__["MatSidenavModule"],
        _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__["MatSliderModule"],
        _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__["MatSlideToggleModule"],
        _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__["MatSnackBarModule"],
        _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__["MatSortModule"],
        _angular_material_table__WEBPACK_IMPORTED_MODULE_37__["MatTableModule"],
        _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__["MatTabsModule"],
        _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__["MatToolbarModule"],
        _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__["MatTooltipModule"],
        _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__["MatTreeModule"],
        _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__["PortalModule"],
        _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__["ScrollingModule"]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsetNgModuleScope"](IFlowMaterialModules, { exports: [_angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"],
        _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__["CdkStepperModule"],
        _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__["CdkTableModule"],
        _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__["CdkTreeModule"],
        _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__["DragDropModule"],
        _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__["MatAutocompleteModule"],
        _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__["MatBadgeModule"],
        _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__["MatBottomSheetModule"],
        _angular_material_button__WEBPACK_IMPORTED_MODULE_11__["MatButtonModule"],
        _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__["MatButtonToggleModule"],
        _angular_material_card__WEBPACK_IMPORTED_MODULE_13__["MatCardModule"],
        _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__["MatCheckboxModule"],
        _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__["MatChipsModule"],
        _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__["MatStepperModule"],
        _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__["MatDatepickerModule"],
        _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__["MatDialogModule"],
        _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__["MatDividerModule"],
        _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__["MatExpansionModule"],
        _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__["MatGridListModule"],
        _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__["MatIconModule"],
        _angular_material_input__WEBPACK_IMPORTED_MODULE_23__["MatInputModule"],
        _angular_material_list__WEBPACK_IMPORTED_MODULE_24__["MatListModule"],
        _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__["MatMenuModule"],
        _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatNativeDateModule"],
        _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__["MatPaginatorModule"],
        _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__["MatProgressBarModule"],
        _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__["MatProgressSpinnerModule"],
        _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__["MatRadioModule"],
        _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatRippleModule"],
        _angular_material_select__WEBPACK_IMPORTED_MODULE_31__["MatSelectModule"],
        _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__["MatSidenavModule"],
        _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__["MatSliderModule"],
        _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__["MatSlideToggleModule"],
        _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__["MatSnackBarModule"],
        _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__["MatSortModule"],
        _angular_material_table__WEBPACK_IMPORTED_MODULE_37__["MatTableModule"],
        _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__["MatTabsModule"],
        _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__["MatToolbarModule"],
        _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__["MatTooltipModule"],
        _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__["MatTreeModule"],
        _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__["PortalModule"],
        _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__["ScrollingModule"]] }); })();
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](IFlowMaterialModules, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["NgModule"],
        args: [{
                exports: [
                    _angular_cdk_a11y__WEBPACK_IMPORTED_MODULE_1__["A11yModule"],
                    _angular_cdk_stepper__WEBPACK_IMPORTED_MODULE_5__["CdkStepperModule"],
                    _angular_cdk_table__WEBPACK_IMPORTED_MODULE_6__["CdkTableModule"],
                    _angular_cdk_tree__WEBPACK_IMPORTED_MODULE_7__["CdkTreeModule"],
                    _angular_cdk_drag_drop__WEBPACK_IMPORTED_MODULE_2__["DragDropModule"],
                    _angular_material_autocomplete__WEBPACK_IMPORTED_MODULE_8__["MatAutocompleteModule"],
                    _angular_material_badge__WEBPACK_IMPORTED_MODULE_9__["MatBadgeModule"],
                    _angular_material_bottom_sheet__WEBPACK_IMPORTED_MODULE_10__["MatBottomSheetModule"],
                    _angular_material_button__WEBPACK_IMPORTED_MODULE_11__["MatButtonModule"],
                    _angular_material_button_toggle__WEBPACK_IMPORTED_MODULE_12__["MatButtonToggleModule"],
                    _angular_material_card__WEBPACK_IMPORTED_MODULE_13__["MatCardModule"],
                    _angular_material_checkbox__WEBPACK_IMPORTED_MODULE_14__["MatCheckboxModule"],
                    _angular_material_chips__WEBPACK_IMPORTED_MODULE_15__["MatChipsModule"],
                    _angular_material_stepper__WEBPACK_IMPORTED_MODULE_16__["MatStepperModule"],
                    _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_17__["MatDatepickerModule"],
                    _angular_material_dialog__WEBPACK_IMPORTED_MODULE_18__["MatDialogModule"],
                    _angular_material_divider__WEBPACK_IMPORTED_MODULE_19__["MatDividerModule"],
                    _angular_material_expansion__WEBPACK_IMPORTED_MODULE_20__["MatExpansionModule"],
                    _angular_material_grid_list__WEBPACK_IMPORTED_MODULE_21__["MatGridListModule"],
                    _angular_material_icon__WEBPACK_IMPORTED_MODULE_22__["MatIconModule"],
                    _angular_material_input__WEBPACK_IMPORTED_MODULE_23__["MatInputModule"],
                    _angular_material_list__WEBPACK_IMPORTED_MODULE_24__["MatListModule"],
                    _angular_material_menu__WEBPACK_IMPORTED_MODULE_25__["MatMenuModule"],
                    _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatNativeDateModule"],
                    _angular_material_paginator__WEBPACK_IMPORTED_MODULE_27__["MatPaginatorModule"],
                    _angular_material_progress_bar__WEBPACK_IMPORTED_MODULE_28__["MatProgressBarModule"],
                    _angular_material_progress_spinner__WEBPACK_IMPORTED_MODULE_29__["MatProgressSpinnerModule"],
                    _angular_material_radio__WEBPACK_IMPORTED_MODULE_30__["MatRadioModule"],
                    _angular_material_core__WEBPACK_IMPORTED_MODULE_26__["MatRippleModule"],
                    _angular_material_select__WEBPACK_IMPORTED_MODULE_31__["MatSelectModule"],
                    _angular_material_sidenav__WEBPACK_IMPORTED_MODULE_32__["MatSidenavModule"],
                    _angular_material_slider__WEBPACK_IMPORTED_MODULE_33__["MatSliderModule"],
                    _angular_material_slide_toggle__WEBPACK_IMPORTED_MODULE_34__["MatSlideToggleModule"],
                    _angular_material_snack_bar__WEBPACK_IMPORTED_MODULE_35__["MatSnackBarModule"],
                    _angular_material_sort__WEBPACK_IMPORTED_MODULE_36__["MatSortModule"],
                    _angular_material_table__WEBPACK_IMPORTED_MODULE_37__["MatTableModule"],
                    _angular_material_tabs__WEBPACK_IMPORTED_MODULE_38__["MatTabsModule"],
                    _angular_material_toolbar__WEBPACK_IMPORTED_MODULE_39__["MatToolbarModule"],
                    _angular_material_tooltip__WEBPACK_IMPORTED_MODULE_40__["MatTooltipModule"],
                    _angular_material_tree__WEBPACK_IMPORTED_MODULE_41__["MatTreeModule"],
                    _angular_cdk_portal__WEBPACK_IMPORTED_MODULE_3__["PortalModule"],
                    _angular_cdk_scrolling__WEBPACK_IMPORTED_MODULE_4__["ScrollingModule"],
                ]
            }]
    }], null, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../services/workflow/workflow-message.service */ "./src/app/services/workflow/workflow-message.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/__ivy_ngcc__/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var angular_resizable_element__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! angular-resizable-element */ "./node_modules/angular-resizable-element/__ivy_ngcc__/fesm2015/angular-resizable-element.js");
/* harmony import */ var _wm_components_workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../wm-components/workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");











function MessageBarComponent_div_0_button_7_Template(rf, ctx) { if (rf & 1) {
    const _r144 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_0_button_7_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r144); const ctx_r143 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r143.closeMessages(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "keyboard_arrow_down");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function MessageBarComponent_div_0_button_8_Template(rf, ctx) { if (rf & 1) {
    const _r146 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_0_button_8_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r146); const ctx_r145 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r145.showMessages(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "keyboard_arrow_up");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function MessageBarComponent_div_0_button_9_Template(rf, ctx) { if (rf & 1) {
    const _r148 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_0_button_9_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r148); const ctx_r147 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r147.reloadMessages(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "refresh");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function MessageBarComponent_div_0_img_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "img", 12);
} }
function MessageBarComponent_div_0_div_12_Template(rf, ctx) { if (rf & 1) {
    const _r151 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_0_div_12_Template_a_click_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r151); const message_r149 = ctx.$implicit; const ctx_r150 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r150.showWorkflowView(message_r149.workflowIdentity); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const message_r149 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate5"]("", message_r149.message, " (", message_r149.workflow.workflowType.title, ") (", message_r149.createdAtString, ") (", message_r149.remainingDays, ") (", message_r149.status, ")");
} }
const _c0 = function () { return { bottom: false, right: false, top: true, left: false }; };
const _c1 = function (a0) { return { "color": a0 }; };
function MessageBarComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    const _r153 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("resizeEnd", function MessageBarComponent_div_0_Template_div_resizeEnd_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r153); const ctx_r152 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r152.onResizeEnd($event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3, "Meldungen");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, " \u00A0 \u00A0 ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "span", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, MessageBarComponent_div_0_button_7_Template, 3, 0, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, MessageBarComponent_div_0_button_8_Template, 3, 0, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](9, MessageBarComponent_div_0_button_9_Template, 3, 0, "button", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, MessageBarComponent_div_0_img_10_Template, 1, 0, "img", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](12, MessageBarComponent_div_0_div_12_Template, 4, 5, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r136 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("enableGhostResize", true)("resizeEdges", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](9, _c0));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngStyle", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](10, _c1, ctx_r136.subscribed ? "green" : "red"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r136.status);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r136.messagePanelShowed);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r136.messagePanelShowed == false);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r136.messagePanelShowed);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r136.isReloadingMessages);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r136.messages);
} }
function MessageBarComponent_div_1_button_16_Template(rf, ctx) { if (rf & 1) {
    const _r157 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_1_button_16_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r157); const ctx_r156 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r156.assignWorkflowMe(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "assignment_ind");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function MessageBarComponent_div_1_button_17_Template(rf, ctx) { if (rf & 1) {
    const _r159 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_1_button_17_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r159); const ctx_r158 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r158.editWorkflow(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "pageview");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function MessageBarComponent_div_1_Template(rf, ctx) { if (rf & 1) {
    const _r161 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h5", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_1_Template_button_click_7_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r161); const ctx_r160 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r160.hideViewModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "app-workflow-inlineview", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "button", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function MessageBarComponent_div_1_Template_button_click_13_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r161); const ctx_r162 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r162.hideViewModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "i", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, MessageBarComponent_div_1_button_16_Template, 3, 0, "button", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](17, MessageBarComponent_div_1_button_17_Template, 3, 0, "button", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r137 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 4, "common.view-workflow"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("workflow", ctx_r137.viewWorkflowModel);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r137.viewWorkflowModel.notAssigned);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r137.viewWorkflowModel.meAssigned);
} }
class MessageBarComponent {
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
}
MessageBarComponent.ɵfac = function MessageBarComponent_Factory(t) { return new (t || MessageBarComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_1__["WorkflowMessageService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_3__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_4__["StompService"])); };
MessageBarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: MessageBarComponent, selectors: [["app-message-bar"]], inputs: { currentUser: "currentUser", isLogged: "isLogged" }, features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([_services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_1__["WorkflowMessageService"]])], decls: 2, vars: 2, consts: [["mwlResizable", "", "class", "message-panel-container", "id", "message-panel-container", 3, "enableGhostResize", "resizeEdges", "resizeEnd", 4, "ngIf"], ["class", "modal fade show", "tabindex", "-1", "id", "viewworkflowedialog", "role", "dialog", 4, "ngIf"], ["mwlResizable", "", "id", "message-panel-container", 1, "message-panel-container", 3, "enableGhostResize", "resizeEdges", "resizeEnd"], [1, "message-panel-toolbar"], [1, "title"], [3, "ngStyle"], ["class", "toolbar-button", 3, "click", 4, "ngIf"], ["class", "toolbar-image", "src", "assets/images/loading200.gif", 4, "ngIf"], [1, "message-panel-items-container"], ["class", "message-panel-item", 4, "ngFor", "ngForOf"], [1, "toolbar-button", 3, "click"], [1, "material-icons"], ["src", "assets/images/loading200.gif", 1, "toolbar-image"], [1, "message-panel-item"], ["href", "javascript:void(0);", 3, "click"], ["tabindex", "-1", "id", "viewworkflowedialog", "role", "dialog", 1, "modal", "fade", "show"], ["role", "document", 1, "modal-dialog", "modal-dialog-centered"], [1, "modal-content"], [1, "modal-header"], ["id", "errorMessagedialogTitle", 1, "modal-title", "dialog-title"], ["aria-label", "Close", 1, "dialog-toolbar-button", "close", 3, "click"], [1, "modal-body"], [3, "workflow"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"], ["type", "button", "class", "btn btn-success", 3, "click", 4, "ngIf"], ["type", "button", "class", "btn btn-primary", 3, "click", 4, "ngIf"], ["type", "button", 1, "btn", "btn-success", 3, "click"], ["type", "button", 1, "btn", "btn-primary", 3, "click"]], template: function MessageBarComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, MessageBarComponent_div_0_Template, 13, 12, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, MessageBarComponent_div_1_Template, 18, 6, "div", 1);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isAppLogged);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.viewWorkflow);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_5__["NgIf"], angular_resizable_element__WEBPACK_IMPORTED_MODULE_6__["ResizableDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgStyle"], _angular_common__WEBPACK_IMPORTED_MODULE_5__["NgForOf"], _wm_components_workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_7__["WorkflowInlineviewComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__["TranslatePipe"]], styles: ["@charset \"ISO-8859-1\";\r\n\r\n.message-panel-container[_ngcontent-%COMP%] {\r\n    height: 170px;\r\n    margin-top: 10px;\r\n    border: 1px solid gray;\r\n    background-color: #fbfbfb;\r\n    position: fixed !important;\r\n    width: 100vw;\r\n    bottom: 30px;\r\n}\r\n\r\n.message-panel-toolbar[_ngcontent-%COMP%]{\r\n\theight: 30px;\r\n\tbackground-color: #dddddd;\t\r\n\tpadding-top: 2px;\r\n\tpadding-right: 10px;\r\n}\r\n\r\n.message-panel-toolbar[_ngcontent-%COMP%]   span.title[_ngcontent-%COMP%]{\r\n\tpadding-left: 20px;\r\n\tfont-weight: bold;\r\n\tfont-size: 14px;\r\n}\r\n\r\n.message-panel-toolbar[_ngcontent-%COMP%]   .toolbar-button[_ngcontent-%COMP%]{\r\n\tfloat: right;\t\r\n}\r\n\r\n.message-panel-items-container[_ngcontent-%COMP%]{\r\n\theight: calc(100% - 30px);\r\n\tpadding: 4px 4px;\r\n\toverflow: auto;\r\n}\r\n\r\n.message-panel-items-container[_ngcontent-%COMP%]   .message-panel-item[_ngcontent-%COMP%]{\r\n\theight: 33px;\r\n\tline-height: 22px;\r\n\tmargin: 3px 0;\r\n\tbackground-color: #dceefa;\r\n\tpadding: 5px;\r\n\tpadding-left: 15px;\r\n\tborder: 1px solid #d0cfcf;\r\n}\r\n\r\n.message-panel-items-container[_ngcontent-%COMP%]   .message-panel-item[_ngcontent-%COMP%]:hover{\r\n\tbackground-color: #dbfbf0;\r\n}\r\n\r\n.message-panel-items-container[_ngcontent-%COMP%]   .message-panel-item[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]{\r\n\tcolor: gray;\r\n}\r\n\r\n.message-panel-items-container[_ngcontent-%COMP%]   .message-panel-item[_ngcontent-%COMP%]   a[_ngcontent-%COMP%]:hover{\r\n\tcolor: #946b73;\r\n}\r\n\r\n.toolbar-image[_ngcontent-%COMP%] {\r\n    border: none;\r\n    margin-right: 10px;\r\n    width: 24px;\r\n    height: 24px;\r\n    float: right;\r\n}\r\n\r\ndiv.workflowview-dialog-content-container[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    padding: 5px 0;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQSxxQkFBcUI7O0FBRXJCO0lBQ0ksYUFBYTtJQUNiLGdCQUFnQjtJQUNoQixzQkFBc0I7SUFDdEIseUJBQXlCO0lBQ3pCLDBCQUEwQjtJQUMxQixZQUFZO0lBQ1osWUFBWTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWix5QkFBeUI7Q0FDekIsZ0JBQWdCO0NBQ2hCLG1CQUFtQjtBQUNwQjs7QUFFQTtDQUNDLGtCQUFrQjtDQUNsQixpQkFBaUI7Q0FDakIsZUFBZTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7QUFDYjs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixnQkFBZ0I7Q0FDaEIsY0FBYztBQUNmOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtDQUNqQixhQUFhO0NBQ2IseUJBQXlCO0NBQ3pCLFlBQVk7Q0FDWixrQkFBa0I7Q0FDbEIseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0MsV0FBVztBQUNaOztBQUVBO0NBQ0MsY0FBYztBQUNmOztBQUVBO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsWUFBWTtJQUNaLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxjQUFjO0FBQ2xCIiwiZmlsZSI6InNyYy9hcHAvbWVzc2FnZS1iYXIvbWVzc2FnZS1iYXIuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIkBjaGFyc2V0IFwiSVNPLTg4NTktMVwiO1xyXG5cclxuLm1lc3NhZ2UtcGFuZWwtY29udGFpbmVyIHtcclxuICAgIGhlaWdodDogMTcwcHg7XHJcbiAgICBtYXJnaW4tdG9wOiAxMHB4O1xyXG4gICAgYm9yZGVyOiAxcHggc29saWQgZ3JheTtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmYmZiZmI7XHJcbiAgICBwb3NpdGlvbjogZml4ZWQgIWltcG9ydGFudDtcclxuICAgIHdpZHRoOiAxMDB2dztcclxuICAgIGJvdHRvbTogMzBweDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtdG9vbGJhcntcclxuXHRoZWlnaHQ6IDMwcHg7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2RkZGRkZDtcdFxyXG5cdHBhZGRpbmctdG9wOiAycHg7XHJcblx0cGFkZGluZy1yaWdodDogMTBweDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtdG9vbGJhciBzcGFuLnRpdGxle1xyXG5cdHBhZGRpbmctbGVmdDogMjBweDtcclxuXHRmb250LXdlaWdodDogYm9sZDtcclxuXHRmb250LXNpemU6IDE0cHg7XHJcbn1cclxuXHJcbi5tZXNzYWdlLXBhbmVsLXRvb2xiYXIgLnRvb2xiYXItYnV0dG9ue1xyXG5cdGZsb2F0OiByaWdodDtcdFxyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC1pdGVtcy1jb250YWluZXJ7XHJcblx0aGVpZ2h0OiBjYWxjKDEwMCUgLSAzMHB4KTtcclxuXHRwYWRkaW5nOiA0cHggNHB4O1xyXG5cdG92ZXJmbG93OiBhdXRvO1xyXG59XHJcblxyXG4ubWVzc2FnZS1wYW5lbC1pdGVtcy1jb250YWluZXIgLm1lc3NhZ2UtcGFuZWwtaXRlbXtcclxuXHRoZWlnaHQ6IDMzcHg7XHJcblx0bGluZS1oZWlnaHQ6IDIycHg7XHJcblx0bWFyZ2luOiAzcHggMDtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjZGNlZWZhO1xyXG5cdHBhZGRpbmc6IDVweDtcclxuXHRwYWRkaW5nLWxlZnQ6IDE1cHg7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgI2QwY2ZjZjtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW06aG92ZXJ7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2RiZmJmMDtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW0gYXtcclxuXHRjb2xvcjogZ3JheTtcclxufVxyXG5cclxuLm1lc3NhZ2UtcGFuZWwtaXRlbXMtY29udGFpbmVyIC5tZXNzYWdlLXBhbmVsLWl0ZW0gYTpob3ZlcntcclxuXHRjb2xvcjogIzk0NmI3MztcclxufVxyXG5cclxuLnRvb2xiYXItaW1hZ2Uge1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAxMHB4O1xyXG4gICAgd2lkdGg6IDI0cHg7XHJcbiAgICBoZWlnaHQ6IDI0cHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvd3ZpZXctZGlhbG9nLWNvbnRlbnQtY29udGFpbmVyIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBwYWRkaW5nOiA1cHggMDtcclxufVxyXG5cclxuXHJcblxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](MessageBarComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-message-bar',
                templateUrl: './message-bar.component.html',
                styleUrls: ['./message-bar.component.css'],
                providers: [_services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_1__["WorkflowMessageService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_2__["Router"] }, { type: _services_workflow_workflow_message_service__WEBPACK_IMPORTED_MODULE_1__["WorkflowMessageService"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_3__["ErrorServiceService"] }, { type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_4__["StompService"] }]; }, { currentUser: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['currentUser']
        }], isLogged: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['isLogged']
        }] }); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");









class AuthenticationService {
    constructor(http, global, router, loadingService) {
        this.http = http;
        this.global = global;
        this.router = router;
        this.loadingService = loadingService;
        this.isLoggedIn = false;
        this.authenticateUrl = "/auth/authenticate";
        this.logoutUrl = "/auth/logout";
        this.currentUserSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
    }
    get currentUserValue() {
        return this.currentUserSubject.value;
    }
    get isLogedIn() {
        return this.currentUserSubject.value != null;
    }
    login(username, password, companyid, loginComponent) {
        const loginData = new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"]()
            .set('username', username)
            .set('password', password)
            .set('companyid', companyid);
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
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
}
AuthenticationService.ɵfac = function AuthenticationService_Factory(t) { return new (t || AuthenticationService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"])); };
AuthenticationService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: AuthenticationService, factory: AuthenticationService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](AuthenticationService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{ providedIn: 'root' }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../ui-models */ "./src/app/ui-models/index.ts");




class ErrorServiceService {
    constructor() {
        this.errorSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
    }
    showError(errorMessage, errorDetail) {
        if (errorDetail === undefined) {
            errorDetail = "";
        }
        var err = new _ui_models__WEBPACK_IMPORTED_MODULE_2__["ErrorDetail"](errorMessage, errorDetail);
        this.errorSubject.next(err);
    }
    showErrorResponse(response) {
        var errResp = new _ui_models__WEBPACK_IMPORTED_MODULE_2__["ErrorResponse"](response);
        this.showError(errResp.message, errResp.details);
    }
}
ErrorServiceService.ɵfac = function ErrorServiceService_Factory(t) { return new (t || ErrorServiceService)(); };
ErrorServiceService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: ErrorServiceService, factory: ErrorServiceService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](ErrorServiceService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return []; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./loading-service.service */ "./src/app/services/loading-service.service.ts");






class GlobalService {
    constructor(http, loadingService) {
        this.http = http;
        this.loadingService = loadingService;
        this.loadGeneralDataUrl = "/general/data/generaldatat";
        this.currentSessionDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_2__["HttpHepler"].generateFormHeader() };
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_2__["HttpHepler"].generateFormHeader() };
        return this.http.get(this.loadGeneralDataUrl, httpOptions);
    }
}
GlobalService.ɵfac = function GlobalService_Factory(t) { return new (t || GlobalService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"])); };
GlobalService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: GlobalService, factory: GlobalService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](GlobalService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{ providedIn: 'root' }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }]; }, null); })();


/***/ }),

/***/ "./src/app/services/index.ts":
/*!***********************************!*\
  !*** ./src/app/services/index.ts ***!
  \***********************************/
/*! exports provided: AuthenticationService, GlobalService, UserService */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./authentication.service */ "./src/app/services/authentication.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AuthenticationService", function() { return _authentication_service__WEBPACK_IMPORTED_MODULE_0__["AuthenticationService"]; });

/* harmony import */ var _user_service__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./user.service */ "./src/app/services/user.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "UserService", function() { return _user_service__WEBPACK_IMPORTED_MODULE_1__["UserService"]; });

/* harmony import */ var _global_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./global.service */ "./src/app/services/global.service.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GlobalService", function() { return _global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"]; });






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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");



class LoadingServiceService {
    constructor() {
        this.loadingSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](false);
    }
    showLoading() {
        this.loadingSubject.next(true);
    }
    hideLoading() {
        this.loadingSubject.next(false);
    }
}
LoadingServiceService.ɵfac = function LoadingServiceService_Factory(t) { return new (t || LoadingServiceService)(); };
LoadingServiceService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: LoadingServiceService, factory: LoadingServiceService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](LoadingServiceService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return []; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");



class UserService {
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
}
UserService.ɵfac = function UserService_Factory(t) { return new (t || UserService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"])); };
UserService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: UserService, factory: UserService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](UserService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{ providedIn: 'root' }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _error_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");











class InvoiceWorkflowEditService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__["HttpErrorResponseHelper"] {
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
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
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
        return "/general/data/uploadtempfile";
    }
    loadCreateInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
        this.http.post(this.getInitCreateUrl(), new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"](), httpOptions).subscribe((initialData) => {
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
        return this.http.post(this.getInitEditUrl(identity), new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"](), httpOptions);
    }
    uploadFiles(fileTitles) {
        const formData = new FormData();
        for (var i = 0; i < fileTitles.length; i++) {
            formData.append('files', fileTitles[i].file);
            formData.append('titles', fileTitles[i].title);
            formData.append('wids', i + "");
        }
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadFileUrl(), formData, httpFileUploadOptions);
    }
    uploadTempFiles(ocrScanFile) {
        const formData = new FormData();
        formData.append('file', ocrScanFile);
        formData.append('wids', "0");
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadOcrScanFileUrl(), formData, httpFileUploadOptions);
    }
    createWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getCreateWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    saveWorkflow(workflow) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getSaveWorkflowUrl(), workflow, httpOptions);
    }
    doneWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getDoneWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    archiveWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getArchiveWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
}
InvoiceWorkflowEditService.ɵfac = function InvoiceWorkflowEditService_Factory(t) { return new (t || InvoiceWorkflowEditService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_error_service_service__WEBPACK_IMPORTED_MODULE_6__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_7__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_authentication_service__WEBPACK_IMPORTED_MODULE_8__["AuthenticationService"])); };
InvoiceWorkflowEditService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: InvoiceWorkflowEditService, factory: InvoiceWorkflowEditService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](InvoiceWorkflowEditService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] }, { type: _error_service_service__WEBPACK_IMPORTED_MODULE_6__["ErrorServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_7__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_7__["ActivatedRoute"] }, { type: _authentication_service__WEBPACK_IMPORTED_MODULE_8__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../workflow-edit-base.service */ "./src/app/services/workflow/workflow-edit-base.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");








class SingleTaskWorkflowEditService extends _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowEditBaseService"] {
    constructor(http, loadingService, router, route, autService) {
        super(http, loadingService, router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
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
}
SingleTaskWorkflowEditService.ɵfac = function SingleTaskWorkflowEditService_Factory(t) { return new (t || SingleTaskWorkflowEditService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"])); };
SingleTaskWorkflowEditService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: SingleTaskWorkflowEditService, factory: SingleTaskWorkflowEditService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](SingleTaskWorkflowEditService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"] }, { type: _authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../workflow-edit-base.service */ "./src/app/services/workflow/workflow-edit-base.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _authentication_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../authentication.service */ "./src/app/services/authentication.service.ts");








class TestthreetaskWorkflowEditService extends _workflow_edit_base_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowEditBaseService"] {
    constructor(http, loadingService, router, route, autService) {
        super(http, loadingService, router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"](null);
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
}
TestthreetaskWorkflowEditService.ɵfac = function TestthreetaskWorkflowEditService_Factory(t) { return new (t || TestthreetaskWorkflowEditService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"])); };
TestthreetaskWorkflowEditService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: TestthreetaskWorkflowEditService, factory: TestthreetaskWorkflowEditService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TestthreetaskWorkflowEditService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_3__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_4__["LoadingServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_5__["ActivatedRoute"] }, { type: _authentication_service__WEBPACK_IMPORTED_MODULE_6__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../services */ "./src/app/services/index.ts");










class WorkflowEditBaseService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__["HttpErrorResponseHelper"] {
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
        this.workflowSaveRequestInitSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
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
    getUploadOcrScanFileUrl() {
        return "/general/data/uploadtempfile";
    }
    getInitEditUrl(identity) {
        return "";
    }
    uploadTempFiles(ocrScanFile) {
        const formData = new FormData();
        formData.append('file', ocrScanFile);
        formData.append('wids', "0");
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadOcrScanFileUrl(), formData, httpFileUploadOptions);
    }
    loadCreateInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
        this.http.post(this.getInitCreateUrl(), new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"](), httpOptions).subscribe((initialData) => {
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
        return this.http.post(this.getInitEditUrl(identity), new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"](), httpOptions);
    }
    uploadFiles(fileTitles) {
        const formData = new FormData();
        for (var i = 0; i < fileTitles.length; i++) {
            formData.append('files', fileTitles[i].file);
            formData.append('titles', fileTitles[i].title);
            formData.append('wids', i + "");
        }
        const httpFileUploadOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFileUploadHeader() };
        return this.http.post(this.getUploadFileUrl(), formData, httpFileUploadOptions);
    }
    createWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getCreateWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    saveWorkflow(workflow) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getSaveWorkflowUrl(), workflow, httpOptions);
    }
    doneWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getDoneWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
    archiveWorkflow(workflowSaveRequest) {
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.getArchiveWorkflowUrl(), workflowSaveRequest, httpOptions);
    }
}
WorkflowEditBaseService.ɵfac = function WorkflowEditBaseService_Factory(t) { return new (t || WorkflowEditBaseService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"])); };
WorkflowEditBaseService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: WorkflowEditBaseService, factory: WorkflowEditBaseService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowEditBaseService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"] }, { type: _services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _error_service_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../error-service.service */ "./src/app/services/error-service.service.ts");







class WorkflowMessageService {
    constructor(http, errorService) {
        this.http = http;
        this.errorService = errorService;
        this.loadMessageUrl = "/general/data/workflowmessages";
        this.assignWorkflowUrl = "/general/data/workflow/assign/";
        this.isReloadingMessages = false;
        this.workflowMessageListSubject = new rxjs__WEBPACK_IMPORTED_MODULE_1__["BehaviorSubject"]([]);
    }
    get workflowMessageList() {
        return this.workflowMessageListSubject.value;
    }
    loadMessages(resetCach) {
        this.isReloadingMessages = true;
        var url = this.loadMessageUrl + "?reset=" + (resetCach ? "1" : "0");
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions);
    }
    assignMe(workflowIdentity) {
        this.isReloadingMessages = true;
        var url = this.assignWorkflowUrl + workflowIdentity;
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(url, new _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpParams"](), httpOptions);
    }
}
WorkflowMessageService.ɵfac = function WorkflowMessageService_Factory(t) { return new (t || WorkflowMessageService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_error_service_service__WEBPACK_IMPORTED_MODULE_4__["ErrorServiceService"])); };
WorkflowMessageService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: WorkflowMessageService, factory: WorkflowMessageService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowMessageService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_2__["HttpClient"] }, { type: _error_service_service__WEBPACK_IMPORTED_MODULE_4__["ErrorServiceService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var rxjs__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! rxjs */ "./node_modules/rxjs/_esm2015/index.js");
/* harmony import */ var _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../helper/http-hepler */ "./src/app/helper/http-hepler.ts");
/* harmony import */ var _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../helper/http-error-response-helper */ "./src/app/helper/http-error-response-helper.ts");
/* harmony import */ var _loading_service_service__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../services */ "./src/app/services/index.ts");










class WorkflowSearchService extends _helper_http_error_response_helper__WEBPACK_IMPORTED_MODULE_4__["HttpErrorResponseHelper"] {
    constructor(http, loadingService, router, route, autService) {
        super(router, route, autService);
        this.http = http;
        this.loadingService = loadingService;
        this.router = router;
        this.route = route;
        this.autService = autService;
        this.searchInitialDataSubject = new rxjs__WEBPACK_IMPORTED_MODULE_2__["BehaviorSubject"](null);
        this.loadInitialUrl = "/workflow/general/data/initsearch";
        this.searchUrl = "/workflow/general/data/search";
        this.listInitialData = null;
    }
    loadInitialData() {
        this.loadingService.showLoading();
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateFormHeader() };
        this.http.post(this.loadInitialUrl, new _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpParams"](), httpOptions).subscribe((initialData) => {
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
        const httpOptions = { headers: _helper_http_hepler__WEBPACK_IMPORTED_MODULE_3__["HttpHepler"].generateJsonHeader() };
        return this.http.post(this.searchUrl, searchFilter, httpOptions);
    }
    ;
}
WorkflowSearchService.ɵfac = function WorkflowSearchService_Factory(t) { return new (t || WorkflowSearchService)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵinject"](_services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"])); };
WorkflowSearchService.ɵprov = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineInjectable"]({ token: WorkflowSearchService, factory: WorkflowSearchService.ɵfac, providedIn: 'root' });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowSearchService, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Injectable"],
        args: [{
                providedIn: 'root'
            }]
    }], function () { return [{ type: _angular_common_http__WEBPACK_IMPORTED_MODULE_1__["HttpClient"] }, { type: _loading_service_service__WEBPACK_IMPORTED_MODULE_5__["LoadingServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_6__["ActivatedRoute"] }, { type: _services__WEBPACK_IMPORTED_MODULE_7__["AuthenticationService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/__ivy_ngcc__/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");





function TestComponent_div_27_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const msg_r135 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](msg_r135);
} }
class TestComponent {
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
}
TestComponent.ɵfac = function TestComponent_Factory(t) { return new (t || TestComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__["StompService"])); };
TestComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TestComponent, selectors: [["app-test"]], decls: 28, vars: 9, consts: [[1, "main-content"], [1, ""], [1, "form-group"], ["type", "button", 1, "btn", "btn-primary", 3, "disabled", "click"], ["type", "button", 1, "btn", "btn-secondary", 3, "disabled", "click"], ["for", "name"], ["type", "text", "placeholder", "Your message here...", 1, "form-control", 2, "width", "calc(100% - 90px)", "display", "inline-block", 3, "ngModel", "ngModelChange"], [1, "btn", "btn-success", 3, "disabled", "click"], [1, "responsediv"], [2, "padding", "5px", "border", "1px solid gray", "font-weight", "bold"], ["style", "padding: 5px; border: 1px solid gray;", 4, "ngFor", "ngForOf"], [2, "padding", "5px", "border", "1px solid gray"]], template: function TestComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TestComponent_Template_button_click_4_listener($event) { return ctx.subscribe(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "Subscribe");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "\u00A0 \u00A0 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TestComponent_Template_button_click_7_listener($event) { return ctx.unsubscribe(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "Unsubscribe");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, " \u00A0 \u00A0 \u00A0 \u00A0 \u00A0 \u00A0 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "label", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "What is your name?");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16, "\u00A0 \u00A0 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "input", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function TestComponent_Template_input_ngModelChange_17_listener($event) { return ctx.message = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18, "\u00A0 \u00A0 ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "button", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TestComponent_Template_button_click_19_listener($event) { return ctx.send(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20, "Send");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](23, "json");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "messageQeue");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](27, TestComponent_div_27_Template, 2, 1, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.subscribed || ctx.sending);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.subscribed === false || ctx.sending);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"]("WebSocket connection: ", ctx.status, "");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.message);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.subscribed === false || ctx.sending);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" state: ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](23, 7, ctx.state), " ");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.messageQeue);
    } }, directives: [_angular_forms__WEBPACK_IMPORTED_MODULE_2__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgModel"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"]], pipes: [_angular_common__WEBPACK_IMPORTED_MODULE_3__["JsonPipe"]], styles: [".main-content[_ngcontent-%COMP%]{\r\n    margin-top: 40px;\r\n\t\r\n}\r\n\r\n.responsediv[_ngcontent-%COMP%] {\r\n    border: 1px solid gray;\r\n    min-height: 30px;\r\n    margin-top: 30px;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n}\r\n\r\n.form-group[_ngcontent-%COMP%]{\r\n\tmargin-bottom: 30px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdGVzdC90ZXN0LmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksZ0JBQWdCOztBQUVwQjs7QUFFQTtJQUNJLHNCQUFzQjtJQUN0QixnQkFBZ0I7SUFDaEIsZ0JBQWdCO0lBQ2hCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7Q0FDQyxtQkFBbUI7QUFDcEIiLCJmaWxlIjoic3JjL2FwcC90ZXN0L3Rlc3QuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4ubWFpbi1jb250ZW50e1xyXG4gICAgbWFyZ2luLXRvcDogNDBweDtcclxuXHRcclxufVxyXG5cclxuLnJlc3BvbnNlZGl2IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XHJcbiAgICBtaW4taGVpZ2h0OiAzMHB4O1xyXG4gICAgbWFyZ2luLXRvcDogMzBweDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbn1cclxuXHJcbi5mb3JtLWdyb3Vwe1xyXG5cdG1hcmdpbi1ib3R0b206IDMwcHg7XHJcbn0iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TestComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-test',
                templateUrl: './test.component.html',
                styleUrls: ['./test.component.css']
            }]
    }], function () { return [{ type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_1__["StompService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");





const _c0 = function (a0) { return [a0]; };
function TopBarComponent_ul_6_li_1_a_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "a", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "span", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const menu_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](2, _c0, menu_r4.url));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](menu_r4.label);
} }
function TopBarComponent_ul_6_li_1_a_2_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "a", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](4, "span", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const menu_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassMap"](menu_r4.image);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](menu_r4.label);
} }
function TopBarComponent_ul_6_li_1_div_3_a_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "a", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const submenu_r11 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](5, _c0, submenu_r11.url));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵclassMap"](submenu_r11.image);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](submenu_r11.label);
} }
function TopBarComponent_ul_6_li_1_div_3_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TopBarComponent_ul_6_li_1_div_3_a_1_Template, 4, 7, "a", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const menu_r4 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", menu_r4.children);
} }
const _c1 = function (a0) { return { "dropdown": a0 }; };
function TopBarComponent_ul_6_li_1_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "li", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TopBarComponent_ul_6_li_1_a_1_Template, 4, 4, "a", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](2, TopBarComponent_ul_6_li_1_a_2_Template, 5, 4, "a", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](3, TopBarComponent_ul_6_li_1_div_3_Template, 2, 1, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const menu_r4 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](4, _c1, menu_r4.children.length > 0));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", menu_r4.children.length == 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", menu_r4.children.length > 0);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", menu_r4.children.length > 0);
} }
function TopBarComponent_ul_6_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "ul", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, TopBarComponent_ul_6_li_1_Template, 4, 6, "li", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r0.menus);
} }
function TopBarComponent_div_7_Template(rf, ctx) { if (rf & 1) {
    const _r14 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "button", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "button", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TopBarComponent_div_7_Template_button_click_5_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r14); const ctx_r13 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r13.showProfile(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "Profile");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "div", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "button", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TopBarComponent_div_7_Template_button_click_8_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r14); const ctx_r15 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r15.logout(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "Logout");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r1 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r1.currentUser.fullName);
} }
function TopBarComponent_div_8_Template(rf, ctx) { if (rf & 1) {
    const _r17 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "ul", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "li");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "Home");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "li");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function TopBarComponent_div_8_Template_button_click_6_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r17); const ctx_r16 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r16.test(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "Test");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
const _c2 = function () { return ["/"]; };
class TopBarComponent {
    constructor(router, global) {
        this.router = router;
        this.global = global;
        this.menus = [];
        this.loggingOut = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
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
}
TopBarComponent.ɵfac = function TopBarComponent_Factory(t) { return new (t || TopBarComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"])); };
TopBarComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: TopBarComponent, selectors: [["app-top-bar"]], inputs: { menus: "menus", currentUser: "currentUser", isLogged: "isLogged" }, outputs: { loggingOut: "loggingOut" }, decls: 9, vars: 5, consts: [[1, "navbar", "navbar-expand-lg", "navbar-toggleable-md", "navbar-light", "bg-light", "navbar-fixed-top"], [1, "container-fluid"], [1, "navbar-header"], [1, "navbar-brand", 3, "routerLink"], ["src", "/assets/images/fbim2.png", 1, "logo"], ["class", "navbar-nav", 4, "ngIf"], ["class", "btn-group navbar-user-detail", 4, "ngIf"], ["style", "background-color: #eeeeee;", 4, "ngIf"], [1, "navbar-nav"], ["class", "nav-item", 3, "ngClass", 4, "ngFor", "ngForOf"], [1, "nav-item", 3, "ngClass"], ["class", "nav-link", 3, "routerLink", 4, "ngIf"], ["class", "nav-link dropdown-toggle", "href", "#", "data-toggle", "dropdown", "role", "button", "aria-haspopup", "true", "aria-expanded", "false", 4, "ngIf"], ["class", "dropdown-menu", 4, "ngIf"], [1, "nav-link", 3, "routerLink"], [1, "glyphicon", "glyphicon-home", "menu-image"], ["href", "#", "data-toggle", "dropdown", "role", "button", "aria-haspopup", "true", "aria-expanded", "false", 1, "nav-link", "dropdown-toggle"], [1, "caret"], [1, "dropdown-menu"], ["class", "dropdown-item", 3, "routerLink", 4, "ngFor", "ngForOf"], [1, "dropdown-item", 3, "routerLink"], [1, "btn-group", "navbar-user-detail"], ["type", "button", "data-toggle", "dropdown", "data-display", "static", "aria-haspopup", "true", "aria-expanded", "false", 1, "btn", "user-toggle-button"], [1, "dropdown-menu", "dropdown-menu-lg-right"], ["type", "button", 1, "dropdown-item", 3, "click"], [1, "dropdown-divider"], [2, "background-color", "#eeeeee"], [1, "breadcrumb"], ["type", "button", 3, "click"]], template: function TopBarComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "header");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "nav", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](5, "img", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, TopBarComponent_ul_6_Template, 2, 1, "ul", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](7, TopBarComponent_div_7_Template, 10, 1, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](8, TopBarComponent_div_8_Template, 8, 0, "div", 7);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](4, _c2));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isLogged);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isLogged);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isLogged);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_3__["NgClass"]], styles: [".navbar-user-detail[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: 30px;\r\n}\r\n\r\nbutton.user-toggle-button[_ngcontent-%COMP%] {\r\n    background-color: #cecece;\r\n    border: none;\r\n    background-image: url(/assets/images/md-contact.svg);\r\n    background-position: 140px center;\r\n    background-repeat: no-repeat;\r\n    background-size: 24px;\r\n    width: 170px;\r\n    text-align: left;\r\n    height: 34px;\r\n}\r\n\r\n.navbar-nav[_ngcontent-%COMP%]   a.nav-link[_ngcontent-%COMP%]{\r\n\tcolor: black;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvdG9wLWJhci90b3AtYmFyLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0lBQ0ksWUFBWTtJQUNaLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHlCQUF5QjtJQUN6QixZQUFZO0lBQ1osb0RBQW9EO0lBQ3BELGlDQUFpQztJQUNqQyw0QkFBNEI7SUFDNUIscUJBQXFCO0lBQ3JCLFlBQVk7SUFDWixnQkFBZ0I7SUFDaEIsWUFBWTtBQUNoQjs7QUFFQTtDQUNDLFlBQVk7QUFDYiIsImZpbGUiOiJzcmMvYXBwL3RvcC1iYXIvdG9wLWJhci5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5uYXZiYXItdXNlci1kZXRhaWwge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAzMHB4O1xyXG59XHJcblxyXG5idXR0b24udXNlci10b2dnbGUtYnV0dG9uIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNjZWNlY2U7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kLWltYWdlOiB1cmwoL2Fzc2V0cy9pbWFnZXMvbWQtY29udGFjdC5zdmcpO1xyXG4gICAgYmFja2dyb3VuZC1wb3NpdGlvbjogMTQwcHggY2VudGVyO1xyXG4gICAgYmFja2dyb3VuZC1yZXBlYXQ6IG5vLXJlcGVhdDtcclxuICAgIGJhY2tncm91bmQtc2l6ZTogMjRweDtcclxuICAgIHdpZHRoOiAxNzBweDtcclxuICAgIHRleHQtYWxpZ246IGxlZnQ7XHJcbiAgICBoZWlnaHQ6IDM0cHg7XHJcbn0gICBcclxuICAgIFxyXG4ubmF2YmFyLW5hdiBhLm5hdi1saW5re1xyXG5cdGNvbG9yOiBibGFjaztcclxufSAgICAiXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](TopBarComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-top-bar',
                templateUrl: './top-bar.component.html',
                styleUrls: ['./top-bar.component.css'],
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"] }]; }, { menus: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['menus']
        }], currentUser: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['currentUser']
        }], isLogged: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['isLogged']
        }], loggingOut: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }] }); })();


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
class GeneralData {
}


/***/ }),

/***/ "./src/app/ui-models/index.ts":
/*!************************************!*\
  !*** ./src/app/ui-models/index.ts ***!
  \************************************/
/*! exports provided: User, MenuItem, LoginResponse, GeneralData, ErrorDetail, ErrorResponse, OcrWord, OcrBox, UploadedFile, UploadedResult */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _user__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./user */ "./src/app/ui-models/user.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "User", function() { return _user__WEBPACK_IMPORTED_MODULE_0__["User"]; });

/* harmony import */ var _menuitem__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./menuitem */ "./src/app/ui-models/menuitem.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "MenuItem", function() { return _menuitem__WEBPACK_IMPORTED_MODULE_1__["MenuItem"]; });

/* harmony import */ var _loginmessage__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./loginmessage */ "./src/app/ui-models/loginmessage.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "LoginResponse", function() { return _loginmessage__WEBPACK_IMPORTED_MODULE_2__["LoginResponse"]; });

/* harmony import */ var _generaldata__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./generaldata */ "./src/app/ui-models/generaldata.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "GeneralData", function() { return _generaldata__WEBPACK_IMPORTED_MODULE_3__["GeneralData"]; });

/* harmony import */ var _error_detail__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./error-detail */ "./src/app/ui-models/error-detail.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorDetail", function() { return _error_detail__WEBPACK_IMPORTED_MODULE_4__["ErrorDetail"]; });

/* harmony import */ var _error_response__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./error-response */ "./src/app/ui-models/error-response.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "ErrorResponse", function() { return _error_response__WEBPACK_IMPORTED_MODULE_5__["ErrorResponse"]; });

/* harmony import */ var _ocr_word__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./ocr-word */ "./src/app/ui-models/ocr-word.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "OcrWord", function() { return _ocr_word__WEBPACK_IMPORTED_MODULE_6__["OcrWord"]; });

/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "OcrBox", function() { return _ocr_word__WEBPACK_IMPORTED_MODULE_6__["OcrBox"]; });

/* harmony import */ var _uploaded_file__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./uploaded-file */ "./src/app/ui-models/uploaded-file.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "UploadedFile", function() { return _uploaded_file__WEBPACK_IMPORTED_MODULE_7__["UploadedFile"]; });

/* harmony import */ var _uploaded_result__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./uploaded-result */ "./src/app/ui-models/uploaded-result.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "UploadedResult", function() { return _uploaded_result__WEBPACK_IMPORTED_MODULE_8__["UploadedResult"]; });












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
class MenuItem {
    constructor() {
        this.children = [];
    }
}


/***/ }),

/***/ "./src/app/ui-models/ocr-word.ts":
/*!***************************************!*\
  !*** ./src/app/ui-models/ocr-word.ts ***!
  \***************************************/
/*! exports provided: OcrWord, OcrBox */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OcrWord", function() { return OcrWord; });
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "OcrBox", function() { return OcrBox; });
class OcrWord {
}
class OcrBox {
}


/***/ }),

/***/ "./src/app/ui-models/uploaded-file.ts":
/*!********************************************!*\
  !*** ./src/app/ui-models/uploaded-file.ts ***!
  \********************************************/
/*! exports provided: UploadedFile */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadedFile", function() { return UploadedFile; });
class UploadedFile {
    constructor() {
        this.fileName = "";
        this.scanedPdfPath = "";
        this.scanedHocrPath = "";
        this.fileIsPdf = false;
        this.fileIsImage = false;
        this.imageSizeX = 0;
        this.imageSizeY = 0;
        this.uploadResult = null;
        this.foundWords = [];
        this.isScanned = false;
    }
}


/***/ }),

/***/ "./src/app/ui-models/uploaded-result.ts":
/*!**********************************************!*\
  !*** ./src/app/ui-models/uploaded-result.ts ***!
  \**********************************************/
/*! exports provided: UploadedResult */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "UploadedResult", function() { return UploadedResult; });
class UploadedResult {
    constructor() {
        this.status = "";
        this.fileName = "";
        this.fileHash = "";
        this.hocrFileHash = "";
        this.isFilePdf = false;
        this.isFileImage = false;
        this.imageWidth = 0;
        this.imageHeight = 0;
        this.errorMessage = "";
        this.errorDetail = "";
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
class FileTitle {
}


/***/ }),

/***/ "./src/app/wf-models/index.ts":
/*!************************************!*\
  !*** ./src/app/wf-models/index.ts ***!
  \************************************/
/*! exports provided: Workflow, WorkflowMessage, WorkflowType, WorkflowTypeStep, WorkflowAction, WorkflowFile, WorkflowFileVersion, WorkflowSearchFilter, WorkflowListInitialData, WorkflowSearchResult, AssignItem, AssignType, WorkflowProcessCommand, FileTitle, WorkflowUploadFileResult, InvoiceType, WorkflowUploadedFile */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony import */ var _workflow__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./workflow */ "./src/app/wf-models/workflow.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "Workflow", function() { return _workflow__WEBPACK_IMPORTED_MODULE_0__["Workflow"]; });

/* harmony import */ var _workflowmessage__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./workflowmessage */ "./src/app/wf-models/workflowmessage.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowMessage", function() { return _workflowmessage__WEBPACK_IMPORTED_MODULE_1__["WorkflowMessage"]; });

/* harmony import */ var _workflowtype__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./workflowtype */ "./src/app/wf-models/workflowtype.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowType", function() { return _workflowtype__WEBPACK_IMPORTED_MODULE_2__["WorkflowType"]; });

/* harmony import */ var _workflowtypestep__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./workflowtypestep */ "./src/app/wf-models/workflowtypestep.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowTypeStep", function() { return _workflowtypestep__WEBPACK_IMPORTED_MODULE_3__["WorkflowTypeStep"]; });

/* harmony import */ var _workflowaction__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ./workflowaction */ "./src/app/wf-models/workflowaction.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowAction", function() { return _workflowaction__WEBPACK_IMPORTED_MODULE_4__["WorkflowAction"]; });

/* harmony import */ var _workflowfile__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ./workflowfile */ "./src/app/wf-models/workflowfile.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFile", function() { return _workflowfile__WEBPACK_IMPORTED_MODULE_5__["WorkflowFile"]; });

/* harmony import */ var _workflowfileversion__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ./workflowfileversion */ "./src/app/wf-models/workflowfileversion.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowFileVersion", function() { return _workflowfileversion__WEBPACK_IMPORTED_MODULE_6__["WorkflowFileVersion"]; });

/* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchFilter", function() { return _workflow_search_filter__WEBPACK_IMPORTED_MODULE_7__["WorkflowSearchFilter"]; });

/* harmony import */ var _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ./workflow-list-initialdata */ "./src/app/wf-models/workflow-list-initialdata.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowListInitialData", function() { return _workflow_list_initialdata__WEBPACK_IMPORTED_MODULE_8__["WorkflowListInitialData"]; });

/* harmony import */ var _workflow_search_result__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ./workflow-search-result */ "./src/app/wf-models/workflow-search-result.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowSearchResult", function() { return _workflow_search_result__WEBPACK_IMPORTED_MODULE_9__["WorkflowSearchResult"]; });

/* harmony import */ var _assign_item__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ./assign-item */ "./src/app/wf-models/assign-item.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AssignItem", function() { return _assign_item__WEBPACK_IMPORTED_MODULE_10__["AssignItem"]; });

/* harmony import */ var _assign_type__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ./assign-type */ "./src/app/wf-models/assign-type.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "AssignType", function() { return _assign_type__WEBPACK_IMPORTED_MODULE_11__["AssignType"]; });

/* harmony import */ var _workflow_process_command__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ./workflow-process-command */ "./src/app/wf-models/workflow-process-command.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowProcessCommand", function() { return _workflow_process_command__WEBPACK_IMPORTED_MODULE_12__["WorkflowProcessCommand"]; });

/* harmony import */ var _file_title__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! ./file-title */ "./src/app/wf-models/file-title.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "FileTitle", function() { return _file_title__WEBPACK_IMPORTED_MODULE_13__["FileTitle"]; });

/* harmony import */ var _workflow_uploadfile_result__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ./workflow-uploadfile-result */ "./src/app/wf-models/workflow-uploadfile-result.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowUploadFileResult", function() { return _workflow_uploadfile_result__WEBPACK_IMPORTED_MODULE_14__["WorkflowUploadFileResult"]; });

/* harmony import */ var _invoice_type__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ./invoice-type */ "./src/app/wf-models/invoice-type.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "InvoiceType", function() { return _invoice_type__WEBPACK_IMPORTED_MODULE_15__["InvoiceType"]; });

/* harmony import */ var _ws_uploaded_file__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ./ws-uploaded-file */ "./src/app/wf-models/ws-uploaded-file.ts");
/* harmony reexport (safe) */ __webpack_require__.d(__webpack_exports__, "WorkflowUploadedFile", function() { return _ws_uploaded_file__WEBPACK_IMPORTED_MODULE_16__["WorkflowUploadedFile"]; });




















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
/* harmony import */ var _invoice_workflow__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./invoice-workflow */ "./src/app/wf-models/invoice-workflow.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");


class InvoiceWorkflowSaveRequest {
    constructor() {
        this.workflow = new _invoice_workflow__WEBPACK_IMPORTED_MODULE_0__["InvoiceWorkflow"]();
        this.expireDays = 0;
        this.assigns = [];
        this.command = _wf_models__WEBPACK_IMPORTED_MODULE_1__["WorkflowProcessCommand"].NONE;
        this.uploadedFiles = [];
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
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");

class InvoiceWorkflow extends _wf_models__WEBPACK_IMPORTED_MODULE_0__["Workflow"] {
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
/* harmony import */ var _workflow_search_filter__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./workflow-search-filter */ "./src/app/wf-models/workflow-search-filter.ts");

class WorkflowListInitialData {
    constructor() {
        this.workflowStatusList = [];
        this.searchFilter = new _workflow_search_filter__WEBPACK_IMPORTED_MODULE_0__["WorkflowSearchFilter"]();
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
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");

class WorkflowSaveRequest {
    constructor() {
        this.workflow = null;
        this.expireDays = 0;
        this.assigns = [];
        this.command = _wf_models__WEBPACK_IMPORTED_MODULE_0__["WorkflowProcessCommand"].NONE;
        this.uploadedFiles = [];
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
class WorkflowTypeStep {
}


/***/ }),

/***/ "./src/app/wf-models/ws-uploaded-file.ts":
/*!***********************************************!*\
  !*** ./src/app/wf-models/ws-uploaded-file.ts ***!
  \***********************************************/
/*! exports provided: WorkflowUploadedFile */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "WorkflowUploadedFile", function() { return WorkflowUploadedFile; });
class WorkflowUploadedFile {
    constructor(uploadedFile) {
        this.fileName = "";
        this.filePathHashed = "";
        if (uploadedFile) {
            this.fileName = uploadedFile.fileName;
            this.filePathHashed = uploadedFile.scanedPdfPath;
        }
    }
    static loadUploadedFiles(uploadedFiles) {
        var wUploadedFiles = [];
        for (var index in uploadedFiles) {
            var wUploadedFile = new WorkflowUploadedFile(uploadedFiles[index]);
            wUploadedFiles.push(wUploadedFile);
        }
        return wUploadedFiles;
    }
}


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../services/workflow/invoice/invoice-workflow-edit.service */ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts");
/* harmony import */ var _invoice_base_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../invoice-base.component */ "./src/app/wm-components/invoice-base.component.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @stomp/ng2-stompjs */ "./node_modules/@stomp/ng2-stompjs/__ivy_ngcc__/fesm2015/stomp-ng2-stompjs.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/datepicker.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_18__ = __webpack_require__(/*! ../../../components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");
/* harmony import */ var _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_19__ = __webpack_require__(/*! ../../../components/wm-file-upload/wm-file-upload.component */ "./src/app/components/wm-file-upload/wm-file-upload.component.ts");
/* harmony import */ var _invoice_ocr_detail_invoice_ocr_detail_component__WEBPACK_IMPORTED_MODULE_20__ = __webpack_require__(/*! ../../invoice-ocr-detail/invoice-ocr-detail.component */ "./src/app/wm-components/invoice-ocr-detail/invoice-ocr-detail.component.ts");

























function CreateInvoiceComponent_option_57_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 46);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const invoiceType_r72 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("value", invoiceType_r72.value);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](invoiceType_r72.title);
} }
function CreateInvoiceComponent_div_93_Template(rf, ctx) { if (rf & 1) {
    const _r75 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 47);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "input", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function CreateInvoiceComponent_div_93_Template_input_change_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r75); const ctx_r74 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r74.calcDiscountDate(); })("dateInput", function CreateInvoiceComponent_div_93_Template_input_dateInput_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r75); const ctx_r76 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r76.calcDiscountDate(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](11, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "mat-datepicker-toggle", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](13, "mat-datepicker", 24, 50);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](19, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "input", 51);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, " % ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](23, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](27, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "input", 52);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function CreateInvoiceComponent_div_93_Template_input_change_29_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r75); const ctx_r77 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r77.calcDiscountDate(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](31);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](32, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](33, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](36);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](37, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](39, "input", 53);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](40, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](41, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const _r73 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](14);
    const ctx_r70 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 11, "invoice-discount"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 13, "invoice-discountenterdate-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](11, 15, "invoice-discountenterdate"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matDatepicker", _r73);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("for", _r73);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("startAt", ctx_r70.invoiceEditForm.controls.discountEnterDate.value);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](19, 17, "invoice-discountrate-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](27, 19, "invoice-discountdeadline-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](32, 21, "common.days"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](37, 23, "invoice-discountdate"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](40, 25, "invoice-discountdate"));
} }
function CreateInvoiceComponent_div_127_Template(rf, ctx) { if (rf & 1) {
    const _r79 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 55);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 56);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "h5", 57);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](5, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "button", 58);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateInvoiceComponent_div_127_Template_button_click_6_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r79); const ctx_r78 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r78.hideOcrDetails(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "span", 59);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "\u00D7");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 60);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "app-invoice-ocr-detail", 61);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("editedValuesChange", function CreateInvoiceComponent_div_127_Template_app_invoice_ocr_detail_editedValuesChange_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r79); const ctx_r80 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r80.scannedSelectedValues = $event; });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 62);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "button", 63);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateInvoiceComponent_div_127_Template_button_click_12_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r79); const ctx_r81 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r81.onApplyScannedValues(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](14, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "button", 64);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateInvoiceComponent_div_127_Template_button_click_15_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r79); const ctx_r82 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r82.hideOcrDetails(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](17, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r71 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](5, 11, "common.scann-document-result"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("foundWords", ctx_r71.scanningFile.foundWords)("scanedPdfPath", ctx_r71.scanningFile.scanedPdfPath)("scanedHocrPath", ctx_r71.scanningFile.scanedHocrPath)("fileIsPdf", ctx_r71.scanningFile.fileIsPdf)("fileIsImage", ctx_r71.scanningFile.fileIsImage)("imageSizeX", ctx_r71.scanningFile.imageSizeX)("imageSizeY", ctx_r71.scanningFile.imageSizeY)("editedValues", ctx_r71.scannedSelectedValues);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](14, 13, "common.apply"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](17, 15, "common.close"));
} }
const _c0 = function () { return ["/workflow/list"]; };
const _c1 = function (a0) { return { "ng-invalid": a0 }; };
class CreateInvoiceComponent extends _invoice_base_component__WEBPACK_IMPORTED_MODULE_4__["InvoiceBaseComponent"] {
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
        this.listening = false;
        this.stompClient = null;
        this.uploadedFiles = [];
        this.scanningFileIndex = -1;
        this.scanningFile = null;
        this.showOcrDetailsDialog = false;
        this.scannedSelectedValues = [];
        this.onRecevieResponse = (message) => {
            if (this.listening === false) {
                return;
            }
            var uploaded = this.uploadedFiles[this.scanningFileIndex];
            this.loadingService.hideLoading();
            console.log("Message Received: ", message.body);
            var parsedMessage = JSON.parse(message.body);
            if (parsedMessage.status) {
                if (parsedMessage.status === "done") {
                    this.unsubscribe();
                    if (parsedMessage.words) {
                        this.showOcrDetailsDialog = true;
                        this.uploadedFiles[this.scanningFileIndex].foundWords = parsedMessage.words;
                        this.uploadedFiles[this.scanningFileIndex].isScanned = true;
                        this.uploadedFiles[this.scanningFileIndex].imageSizeX = parsedMessage.imageWidth;
                        this.uploadedFiles[this.scanningFileIndex].imageSizeY = parsedMessage.imageHeight;
                        console.log("Received Words: ", this.uploadedFiles[this.scanningFileIndex].foundWords);
                    }
                }
                if (parsedMessage.status === "error" && parsedMessage.errorMessage) {
                    this.unsubscribe();
                    this.errorService.showError(parsedMessage.errorMessage, parsedMessage.errorDetail);
                }
            }
        };
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
    }
    get debugData() {
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_6__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_6__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    ngOnInit() {
        super.ngOnInit();
    }
    onOcrUploadedFile(uploadedFile) {
        var index = this.uploadedFiles.indexOf(uploadedFile);
        if (index > -1) {
            this.scanningFileIndex = index;
            this.scanningFile = this.uploadedFiles[index];
            this.loadingService.showLoading();
            this.subscribe();
            console.log("ocrUploadedFile : ", this.scanningFile);
            this._stompService.publish('/socketapp/ocrprocess', JSON.stringify(uploadedFile.uploadResult));
        }
    }
    onShowUploadedFileScannDetail(uploadedFile) {
        var index = this.uploadedFiles.indexOf(uploadedFile);
        if (index > -1) {
            this.scanningFileIndex = index;
            this.scanningFile = this.uploadedFiles[index];
            this.showOcrDetailsDialog = true;
            console.log("showScanResults : ", this.scanningFile);
        }
    }
    onUploadedFilesChanged(uploadedFileList) {
        this.uploadedFiles = uploadedFileList;
    }
    subscribe() {
        if (this.subscribed) {
            this.unsubscribe();
        }
        this.messages = this._stompService.subscribe('/user/socket/ocrprocess');
        this.subscription = this.messages.subscribe(this.onRecevieResponse);
        this.setConnected(true);
        this.listening = true;
    }
    unsubscribe() {
        this.listening = false;
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
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
            this.setToControlValues();
        }
        else {
            this.subscribeToSearchInitialData();
            this.editService.loadCreateInitialData();
        }
    }
    reload() {
        this.loadInitialData();
    }
    subscribeToSearchInitialData() {
        this.editService.workflowSaveRequestInitSubject.subscribe((data) => {
            console.log("set gloabl-data from workflow-create. : ", data);
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
        this.workflowSaveRequest.uploadedFiles = _wf_models__WEBPACK_IMPORTED_MODULE_5__["WorkflowUploadedFile"].loadUploadedFiles(this.uploadedFiles);
        this.loadingService.showLoading();
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
    hideOcrDetails() {
        this.showOcrDetailsDialog = false;
    }
    onApplyScannedValues() {
        if (this.scannedSelectedValues["invoice-invoicedate"] && this.scannedSelectedValues["invoice-invoicedate"] != "") {
            this.invoiceEditForm.controls["invocieDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_6__["parseDate"])(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
            this.invoiceEditForm.controls["discountEnterDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_6__["parseDate"])(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
            //this.invoiceEditForm.controls["discountDate"].setValue(parseDate(this.scannedSelectedValues["invoice-invoicedate"], 'dd.mm.yyyy'));
        }
        if (this.scannedSelectedValues["invoice-invoicenumber"] && this.scannedSelectedValues["invoice-invoicenumber"] != "") {
            this.invoiceEditForm.controls["registerNumber"].setValue(this.scannedSelectedValues["invoice-invoicenumber"]);
        }
        if (this.scannedSelectedValues["invoice-paymentamount"] && this.scannedSelectedValues["invoice-paymentamount"] != "") {
            var foundPayment = this.scannedSelectedValues["invoice-paymentamount"].replace(/\./g, "").replace(",", ".");
            if (isNaN(foundPayment) === false) {
                var foundPaymentFloat = parseFloat(foundPayment);
                this.invoiceEditForm.controls["paymentAmount"].setValue(foundPaymentFloat);
            }
        }
        if (this.scannedSelectedValues["invoice-sender"] && this.scannedSelectedValues["invoice-sender"] != "") {
            this.invoiceEditForm.controls["sender"].setValue(this.scannedSelectedValues["invoice-sender"]);
        }
        this.showOcrDetailsDialog = false;
    }
    findUploadedByFileName(fileName) {
        for (var index in this.uploadedFiles) {
            if (this.uploadedFiles[index].fileName === fileName) {
                return this.uploadedFiles[index];
            }
        }
        return null;
    }
    existsUploadedByFileName(fileName) {
        return this.findUploadedByFileName(fileName) !== null;
    }
}
CreateInvoiceComponent.ɵfac = function CreateInvoiceComponent_Factory(t) { return new (t || CreateInvoiceComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_10__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_11__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_13__["StompService"])); };
CreateInvoiceComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: CreateInvoiceComponent, selectors: [["app-create-invoice"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_6__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵInheritDefinitionFeature"]], decls: 128, vars: 70, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], [1, "toolbar-button", 3, "click"], [1, "workflow-content-container"], [1, "workflow-content"], ["id", "workflow-form", "name", "workflowForm", 3, "formGroup"], [1, "panel", "panel-default"], [1, "panel-heading"], [1, "panel-body"], [1, "item-row"], [1, "item-label", "label-required", "label-large"], [1, "item-content", "large-content"], ["type", "text", "required", "", "name", "sender", "formControlName", "sender"], [1, "item-label", "small-label"], [1, "item-content", "small-content"], ["type", "checkbox"], [1, "clear"], ["type", "text", "required", "", "name", "registerNumber", "formControlName", "registerNumber"], [1, "item-label", "label-required", "small-label"], ["required", "", "matInput", "", "formControlName", "invocieDate", 1, "select-date", 3, "matDatepicker", "placeholder", "change", "dateInput"], ["matSuffix", "", 3, "for"], ["startView", "month", 3, "startAt"], ["invocieDatepicker", ""], ["type", "number", "required", "", "name", "paymentAmount", "formControlName", "paymentAmount"], ["required", "", "name", "invoiceType", "formControlName", "invoiceType", 3, "ngClass"], [3, "value", 4, "ngFor", "ngForOf"], [1, "twopannel"], [1, "panel", "panel-1", "panel-default", "panel-twopannelleft"], [1, "item-content", "fullrowfromlabel"], ["type", "text", "required", "", "name", "vendorNumber", "formControlName", "vendorNumber"], ["type", "text", "required", "", "name", "partnerCode", "formControlName", "partnerCode"], ["type", "text", "required", "", "name", "vendorName", "formControlName", "vendorName"], ["type", "checkbox", "name", "isDirectDebitPermission", "formControlName", "isDirectDebitPermission", 3, "checked"], ["class", "panel panel-1 panel-default panel-twopannelright", 4, "ngIf"], [1, "panel", "panel-2", "panel-default", "panel-twopannelleft"], [1, "item-label", "label-large"], ["formControlName", "comments", 1, "comments-fullrow", "wm-comments-textarea"], [3, "users", "departments", "assignedUsers", "onSelectedAssignChanged"], [1, "panel", "panel-2", "panel-default", "panel-twopannelright"], [3, "ocrScanningEnabled", "editService", "onOcrUploadedFile", "onUploadedFilesChanged", "onShowUploadedFileScannDetail"], [1, "workflow-step-button-bar"], ["type", "button", 1, "button-bar-button", "step-button", "button-save", 3, "disabled", "click"], ["class", "modal fade show", "tabindex", "-1", "role", "dialog", "id", "scanneddetailsdialog", 4, "ngIf"], [3, "value"], [1, "panel", "panel-1", "panel-default", "panel-twopannelright"], [1, "item-content"], ["required", "", "matInput", "", "formControlName", "discountEnterDate", 1, "select-date", 3, "matDatepicker", "placeholder", "change", "dateInput"], ["discountEnterDatepicker", ""], ["type", "number", "required", "", "name", "discountRate", "formControlName", "discountRate", 1, "short-input"], ["type", "number", "required", "", "name", "discountDeadline", "formControlName", "discountDeadline", 1, "short-input", 3, "change"], ["required", "", "readonly", "", "formControlName", "discountDate", 1, "select-date", 3, "placeholder"], ["tabindex", "-1", "role", "dialog", "id", "scanneddetailsdialog", 1, "modal", "fade", "show"], ["role", "document", 1, "modal-dialog", "scanned-details-dialog"], [1, "modal-header"], [1, "modal-title"], ["type", "button", "aria-label", "Close", 1, "close", 3, "click"], ["aria-hidden", "true"], [1, "modal-body"], [3, "foundWords", "scanedPdfPath", "scanedHocrPath", "fileIsPdf", "fileIsImage", "imageSizeX", "imageSizeY", "editedValues", "editedValuesChange"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-primary", 3, "click"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"]], template: function CreateInvoiceComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateInvoiceComponent_Template_button_click_7_listener($event) { return ctx.reload(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "refresh");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "form", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](16, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](21, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](23, "input", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](26, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "input", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](29, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](32);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](33, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](35, "input", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](38, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "input", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function CreateInvoiceComponent_Template_input_change_40_listener($event) { return ctx.invoiceDateChanges(); })("dateInput", function CreateInvoiceComponent_Template_input_dateInput_40_listener($event) { return ctx.invoiceDateChanges(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](41, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](42, "mat-datepicker-toggle", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](43, "mat-datepicker", 24, 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](45, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](46, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](47, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](48, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](49);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](50, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](51, "input", 26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](52, "div", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](53);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](54, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](55, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](56, "select", 27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](57, CreateInvoiceComponent_option_57_Template, 2, 2, "option", 28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](58, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](59, "div", 29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](60, "div", 30);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](61, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](62);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](63, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](64, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](65, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](66, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](67);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](68, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](69, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](70, "input", 32);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](71, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](72, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](73, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](74);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](75, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](76, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](77, "input", 33);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](78, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](79, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](80, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](81);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](82, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](83, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](84, "input", 34);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](85, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](86, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](87, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](88);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](89, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](90, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](91, "input", 35);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](92, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](93, CreateInvoiceComponent_div_93_Template, 42, 27, "div", 36);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](94, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](95, "div", 29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](96, "div", 37);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](97, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](98, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](99, "div", 38);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](100);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](101, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](102, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](103, "textarea", 39);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](104, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](105, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](106, "div", 38);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](107);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](108, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](109, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](110, "app-wm-assign-list", 40);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onSelectedAssignChanged", function CreateInvoiceComponent_Template_app_wm_assign_list_onSelectedAssignChanged_110_listener($event) { return ctx.onUsersSelected($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](111, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](112, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](113, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](114, "div", 41);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](115, "app-wm-file-upload", 42);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onOcrUploadedFile", function CreateInvoiceComponent_Template_app_wm_file_upload_onOcrUploadedFile_115_listener($event) { return ctx.onOcrUploadedFile($event); })("onUploadedFilesChanged", function CreateInvoiceComponent_Template_app_wm_file_upload_onUploadedFilesChanged_115_listener($event) { return ctx.onUploadedFilesChanged($event); })("onShowUploadedFileScannDetail", function CreateInvoiceComponent_Template_app_wm_file_upload_onShowUploadedFileScannDetail_115_listener($event) { return ctx.onShowUploadedFileScannDetail($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](116, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](117, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](118, "div", 43);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](119, "button", 44);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateInvoiceComponent_Template_button_click_119_listener($event) { return ctx.save(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](120, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](121);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](122, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](123, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](124, "save");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](125, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](126, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](127, CreateInvoiceComponent_div_127_Template, 18, 17, "div", 45);
    } if (rf & 2) {
        const _r68 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](44);
        var tmp_25_0 = null;
        const currVal_25 = (tmp_25_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](111, 61, ctx.generalDataObs)) == null ? null : tmp_25_0.company.users;
        var tmp_26_0 = null;
        const currVal_26 = (tmp_26_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](112, 63, ctx.generalDataObs)) == null ? null : tmp_26_0.company.departments;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.pageTitle);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](67, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.invoiceEditForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](16, 33, "invoice-invoice"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](21, 35, "invoice-sender"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](26, 37, "invoice-trusted"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](33, 39, "invoice-invoicenumber"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](38, 41, "invoice-invoicedate"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](41, 43, "invoice-invoicedate-select"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matDatepicker", _r68);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("for", _r68);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("startAt", ctx.invoiceEditForm.controls.invocieDate.value);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.paymentamountTitle);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](54, 45, "invoice-invoicetype"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](68, _c1, ctx.invoiceEditForm.controls.invoiceType.errors));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.invoiceTypes);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](63, 47, "invoice-vendor"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](68, 49, "invoice-vendornumber"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](75, 51, "invoice-partnercode"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](82, 53, "invoice-vendorname"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](89, 55, "invoice-isdirectdebitpermission"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx.forms.isDirectDebitPermission.value);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isPaymentInvoiceType() === false);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](101, 57, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](108, 59, "workflow-assignto"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", currVal_25)("departments", currVal_26)("assignedUsers", ctx.assignedUsers);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ocrScanningEnabled", true)("editService", ctx.editService);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx.invoiceEditForm.invalid);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](122, 65, "common.create"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showOcrDetailsDialog);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["RequiredValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormControlName"], _angular_material_input__WEBPACK_IMPORTED_MODULE_14__["MatInput"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_15__["MatDatepickerInput"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_15__["MatDatepickerToggle"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_16__["MatSuffix"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_15__["MatDatepicker"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["NumberValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["SelectControlValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_17__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_17__["NgForOf"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["CheckboxControlValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_17__["NgIf"], _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_18__["WmAssignListComponent"], _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_19__["WmFileUploadComponent"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_12__["ɵangular_packages_forms_forms_x"], _invoice_ocr_detail_invoice_ocr_detail_component__WEBPACK_IMPORTED_MODULE_20__["InvoiceOcrDetailComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__["TranslatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_17__["AsyncPipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px 50px 0;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-record[_ngcontent-%COMP%]{\r\n\tfloat: right;\r\n    background-color: #dad9d9;\r\n    padding: 8px;\r\n    border-radius: 5px;\r\n    width: 25%;\r\n    min-height: 500px;\r\n}\r\n\r\n.workflow-content[_ngcontent-%COMP%]   .panel[_ngcontent-%COMP%]{\r\n\tbackground-color: #f2f1f1 !important;\r\n\tpadding: 8px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel-1[_ngcontent-%COMP%]{\r\n\t\r\n\theight: 190px;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel-2[_ngcontent-%COMP%]{\r\n\t\r\n\theight: 300px;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel-twopannelleft[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 310px);\r\n\tfloat: left;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel-twopannelright[_ngcontent-%COMP%]{\r\n\twidth: 300px;\r\n\tfloat: right;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel-twopannelright[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n}\r\n\r\n.small-content[_ngcontent-%COMP%]{\r\n\twidth: 120px;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]{\r\n\theight: 26px;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]:not(.fullrow), .item-content[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select.fullrow[_ngcontent-%COMP%] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content.larg-content[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 450px);\r\n}\r\n\r\n.workflow-content[_ngcontent-%COMP%]   .panel[_ngcontent-%COMP%]   .panel-heading[_ngcontent-%COMP%]{\r\n\tfont-weight: bold;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    background-color: white;\r\n    padding: 6px;\r\n    padding-right: 20px;\r\n   \r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 25px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    height: 25px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .label-large[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .label-large[_ngcontent-%COMP%]{\r\n    width: 150px;\r\n}\r\n\r\n.large-content[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 420px);\r\n}\r\n\r\n.large-content[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   input[type=number][_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   areatext[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 30px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .small-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .small-label[_ngcontent-%COMP%]{\r\n    width: 122px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    padding-left: 0px;\r\n    float: left;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   input[type=checkbox][_ngcontent-%COMP%]{\r\n\twidth: 20px;\r\n\theight: 20px;\t\r\n\tmargin-top: 3px;\r\n}\r\n\r\ndiv.fullrowfromlabel[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 150px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 10px);\t\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n.invalid-request-container[_ngcontent-%COMP%]{\r\n\twidth: 60vw;\r\n    min-height: 100px;\r\n    text-align: center;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    margin-top: 10vh;\r\n    padding: 10px;\r\n\t\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%], .workflow-file-view-link[_ngcontent-%COMP%]:active, .workflow-file-view-link[_ngcontent-%COMP%]:visited{\r\n\tcolor: #333;\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%]:hover{\r\n\tcolor: #551113;\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\twidth: 24px;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n}\r\n\r\ninput.select-date[_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\ninput.short-input[_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\n.ocrscan-container[_ngcontent-%COMP%] {\r\n    width: 500px;\r\n    float: right;\r\n    padding-top: 5px;\r\n    margin-right: 10px;\r\n}\r\n\r\n.ocrscan-container[_ngcontent-%COMP%]   .custom-file-input[_ngcontent-%COMP%]{\r\n    width: calc(100% - 50px);\r\n}\r\n\r\n.ocrscan-container[_ngcontent-%COMP%]   .custom-file-label[_ngcontent-%COMP%]{\r\n    width: calc(100% - 50px);\r\n}\r\n\r\n.ocrscan-container[_ngcontent-%COMP%]   .upload-button[_ngcontent-%COMP%]{\r\n    padding: 2px 7px;\r\n    margin-left: 5px;\r\n}\r\n\r\n.uploading-dialog[_ngcontent-%COMP%] {\r\n    min-height: 100px;\r\n    max-height: 100px;\r\n    padding-top: 0;\r\n    margin-top: 20%;\r\n    background-color: white;\r\n}\r\n\r\n.scanned-details-dialog[_ngcontent-%COMP%]{\r\n\twidth: 90vw;\r\n    max-width: 90vw;\r\n    min-width: 90vw;\r\n    background-color: white;\r\n    pointer-events: all;\r\n}\r\n\r\n.uploading-progress[_ngcontent-%COMP%] {\r\n    height: 30px;\r\n    margin: 0px 10px;\r\n}\r\n\r\n.uploading-progress-label[_ngcontent-%COMP%] {\r\n    width: 100%;\r\n    display: block;\r\n    position: absolute;\r\n    text-align: center;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%] {\r\n\tpadding: 5px 4px 0 10px;\r\n\tmargin-bottom: 3px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]:hover {\r\n\tbackground-color: #feffea;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .filename[_ngcontent-%COMP%] {\r\n\twidth: 230px;\r\n    display: inline-block;\r\n    overflow: hidden;\r\n    overflow-y: hidden;\r\n    height: 30px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .upload-button[_ngcontent-%COMP%]{\r\n    padding: 0px 4px;\r\n    margin-left: 5px;\r\n}\r\n\r\n.uploaded-file-item[_ngcontent-%COMP%]   .upload-button[_ngcontent-%COMP%]   .material-icons[_ngcontent-%COMP%]{\r\n    font-size: 16px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLWludm9pY2UvY3JlYXRlLWludm9pY2UuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBR0E7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0NBQ0MsWUFBWTtJQUNULHlCQUF5QjtJQUN6QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFVBQVU7SUFDVixpQkFBaUI7QUFDckI7O0FBRUE7Q0FDQyxvQ0FBb0M7Q0FDcEMsWUFBWTtJQUNULG1CQUFtQjtBQUN2Qjs7QUFFQTs7Q0FFQyxhQUFhO0FBQ2Q7O0FBRUE7O0NBRUMsYUFBYTtBQUNkOztBQUVBO0NBQ0MseUJBQXlCO0NBQ3pCLFdBQVc7QUFDWjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osaUJBQWlCO0FBQ2xCOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtBQUNsQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLGlCQUFpQjtBQUNsQjs7QUFFQTtJQUNJLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osbUJBQW1COztBQUV2Qjs7QUFFQTs7SUFFSSxXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLGlCQUFpQjtJQUNqQixZQUFZO0FBQ2hCOztBQUVBOztJQUVJLFlBQVk7QUFDaEI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Ozs7Q0FJQyx3QkFBd0I7QUFDekI7O0FBR0E7O0lBRUksWUFBWTtBQUNoQjs7QUFFQTtJQUNJLGlCQUFpQjtJQUNqQixXQUFXO0FBQ2Y7O0FBRUE7Q0FDQyxXQUFXO0NBQ1gsWUFBWTtDQUNaLGVBQWU7QUFDaEI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyx3QkFBd0I7QUFDekI7O0FBRUE7O0lBRUksd0JBQXdCO0lBQ3hCLFlBQVk7QUFDaEI7O0FBRUE7O0lBRUksVUFBVTtJQUNWLFlBQVk7SUFDWixxQkFBcUI7QUFDekI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZix1QkFBdUI7QUFDM0I7O0FBRUE7Q0FDQyxXQUFXO0lBQ1IsaUJBQWlCO0lBQ2pCLGtCQUFrQjtJQUNsQixpQkFBaUI7SUFDakIsa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixhQUFhOztBQUVqQjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGNBQWM7QUFDZjs7QUFFQTtDQUNDLFdBQVc7QUFDWjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0FBQ3JCOztBQUVBO0NBQ0MsWUFBWTtDQUNaLFlBQVk7QUFDYjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixZQUFZO0FBQ2I7O0FBRUE7SUFDSSxZQUFZO0lBQ1osWUFBWTtJQUNaLGdCQUFnQjtJQUNoQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSx3QkFBd0I7QUFDNUI7O0FBRUE7SUFDSSx3QkFBd0I7QUFDNUI7O0FBRUE7SUFDSSxnQkFBZ0I7SUFDaEIsZ0JBQWdCO0FBQ3BCOztBQUVBO0lBQ0ksaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixjQUFjO0lBQ2QsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQjs7QUFFQTtDQUNDLFdBQVc7SUFDUixlQUFlO0lBQ2YsZUFBZTtJQUNmLHVCQUF1QjtJQUN2QixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osZ0JBQWdCO0FBQ3BCOztBQUVBO0lBQ0ksV0FBVztJQUNYLGNBQWM7SUFDZCxrQkFBa0I7SUFDbEIsa0JBQWtCO0FBQ3RCOztBQUVBO0NBQ0MsdUJBQXVCO0NBQ3ZCLGtCQUFrQjtBQUNuQjs7QUFFQTtDQUNDLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLFlBQVk7SUFDVCxxQkFBcUI7SUFDckIsZ0JBQWdCO0lBQ2hCLGtCQUFrQjtJQUNsQixZQUFZO0FBQ2hCOztBQUVBO0lBQ0ksZ0JBQWdCO0lBQ2hCLGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLGVBQWU7QUFDbkIiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL2NyZWF0ZS9jcmVhdGUtaW52b2ljZS9jcmVhdGUtaW52b2ljZS5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LWNvbnRhaW5lcntcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBtYXJnaW46IDEwcHggMHB4IDUwcHggMDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDEwcHg7XHJcbiAgICBwYWRkaW5nOiAxMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2YxZjFmMTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnR7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogMTVweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxufVxyXG5cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1yZWNvcmR7XHJcblx0ZmxvYXQ6IHJpZ2h0O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDhweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxuICAgIHdpZHRoOiAyNSU7XHJcbiAgICBtaW4taGVpZ2h0OiA1MDBweDtcclxufVxyXG5cclxuLndvcmtmbG93LWNvbnRlbnQgLnBhbmVse1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNmMmYxZjEgIWltcG9ydGFudDtcclxuXHRwYWRkaW5nOiA4cHg7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAxMHB4O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC0xe1xyXG5cdFxyXG5cdGhlaWdodDogMTkwcHg7XHJcbn1cclxuXHJcbi50d29wYW5uZWwgLnBhbmVsLTJ7XHJcblx0XHJcblx0aGVpZ2h0OiAzMDBweDtcclxufVxyXG5cclxuLnR3b3Bhbm5lbCAucGFuZWwtdHdvcGFubmVsbGVmdHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMzEwcHgpO1xyXG5cdGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC10d29wYW5uZWxyaWdodHtcclxuXHR3aWR0aDogMzAwcHg7XHJcblx0ZmxvYXQ6IHJpZ2h0O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC10d29wYW5uZWxyaWdodCBpbnB1dFt0eXBlPXRleHRde1xyXG5cdHdpZHRoOiAxMDBweDtcclxufVxyXG5cclxuLnNtYWxsLWNvbnRlbnR7XHJcblx0d2lkdGg6IDEyMHB4O1xyXG59XHJcblxyXG4uaXRlbS1jb250ZW50IHNlbGVjdHtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn0gXHJcblxyXG4uaXRlbS1jb250ZW50IHNlbGVjdDpub3QoLmZ1bGxyb3cpLCAuaXRlbS1jb250ZW50IGlucHV0W3R5cGU9dGV4dF0ge1xyXG5cdGhlaWdodDogMjZweDtcclxuXHR3aWR0aDogY2FsYygxMDAlKTtcclxufSBcclxuXHJcbi5pdGVtLWNvbnRlbnQgc2VsZWN0LmZ1bGxyb3cge1xyXG5cdGhlaWdodDogMjZweDtcclxuXHR3aWR0aDogY2FsYygxMDAlKTtcclxufSBcclxuXHJcbi5pdGVtLWNvbnRlbnQubGFyZy1jb250ZW50e1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSA0NTBweCk7XHJcbn1cclxuXHJcbi53b3JrZmxvdy1jb250ZW50IC5wYW5lbCAucGFuZWwtaGVhZGluZ3tcclxuXHRmb250LXdlaWdodDogYm9sZDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93LCBkaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IHtcclxuICAgIG1hcmdpbjogNXB4IDAgMTBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2LndvcmtmbG93LXN0ZXAtYnV0dG9uLWJhciwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXJ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcclxuICAgIHBhZGRpbmc6IDZweDtcclxuICAgIHBhZGRpbmctcmlnaHQ6IDIwcHg7XHJcbiAgIFxyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tbGFiZWwsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWxhYmVse1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAxMHB4O1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBsaW5lLWhlaWdodDogMjVweDtcclxuICAgIGZvbnQtc2l6ZTogMTRweDtcclxuICAgIGZvbnQtd2VpZ2h0OiBib2xkO1xyXG4gICAgaGVpZ2h0OiAyNXB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgLmxhYmVsLWxhcmdlLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyAubGFiZWwtbGFyZ2V7XHJcbiAgICB3aWR0aDogMTUwcHg7XHJcbn1cclxuXHJcbi5sYXJnZS1jb250ZW50e1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSA0MjBweCk7XHJcbn1cclxuXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9dGV4dF0sXHJcbi5sYXJnZS1jb250ZW50IGlucHV0W3R5cGU9bnVtYmVyXSxcclxuLmxhcmdlLWNvbnRlbnQgc2VsZWN0LCBcclxuLmxhcmdlLWNvbnRlbnQgYXJlYXRleHR7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDMwcHgpO1xyXG59XHJcblxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IC5zbWFsbC1sYWJlbCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgLnNtYWxsLWxhYmVse1xyXG4gICAgd2lkdGg6IDEyMnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IHtcclxuICAgIHBhZGRpbmctbGVmdDogMHB4O1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbi5pdGVtLWNvbnRlbnQgaW5wdXRbdHlwZT1jaGVja2JveF17XHJcblx0d2lkdGg6IDIwcHg7XHJcblx0aGVpZ2h0OiAyMHB4O1x0XHJcblx0bWFyZ2luLXRvcDogM3B4O1xyXG59XHJcblxyXG5kaXYuZnVsbHJvd2Zyb21sYWJlbHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMTUwcHgpO1x0XHJcbn1cclxuXHJcbmRpdi5mdWxscm93ZnJvbWxhYmVsIGlucHV0W3R5cGU9dGV4dF17XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDEwcHgpO1x0XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcblxyXG4uaW52YWxpZC1yZXF1ZXN0LWNvbnRhaW5lcntcclxuXHR3aWR0aDogNjB2dztcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG4gICAgbWFyZ2luLWxlZnQ6IGF1dG87XHJcbiAgICBtYXJnaW4tcmlnaHQ6IGF1dG87XHJcbiAgICBtYXJnaW4tdG9wOiAxMHZoO1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuXHRcclxufVxyXG5cclxuLndvcmtmbG93LWZpbGUtdmlldy1saW5rLCAud29ya2Zsb3ctZmlsZS12aWV3LWxpbms6YWN0aXZlLCAud29ya2Zsb3ctZmlsZS12aWV3LWxpbms6dmlzaXRlZHtcclxuXHRjb2xvcjogIzMzMztcclxufVxyXG5cclxuLndvcmtmbG93LWZpbGUtdmlldy1saW5rOmhvdmVye1xyXG5cdGNvbG9yOiAjNTUxMTEzO1xyXG59XHJcblxyXG4ud29ya2Zsb3ctZmlsZS12aWV3LWxpbmsgaS5tYXRlcmlhbC1pY29uc3tcclxuXHR3aWR0aDogMjRweDtcclxufVxyXG5cclxuYnV0dG9uLnNob3ctc2VsZWN0LWRpYWxvZyB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IC0yMHB4O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbn1cclxuXHJcbmlucHV0LnNlbGVjdC1kYXRle1xyXG5cdHdpZHRoOiAxMDBweDtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmlucHV0LnNob3J0LWlucHV0e1xyXG5cdHdpZHRoOiAxMDBweDtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbi5vY3JzY2FuLWNvbnRhaW5lciB7XHJcbiAgICB3aWR0aDogNTAwcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBwYWRkaW5nLXRvcDogNXB4O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAxMHB4O1xyXG59XHJcblxyXG4ub2Nyc2Nhbi1jb250YWluZXIgLmN1c3RvbS1maWxlLWlucHV0e1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDUwcHgpO1xyXG59XHJcblxyXG4ub2Nyc2Nhbi1jb250YWluZXIgLmN1c3RvbS1maWxlLWxhYmVse1xyXG4gICAgd2lkdGg6IGNhbGMoMTAwJSAtIDUwcHgpO1xyXG59XHJcblxyXG4ub2Nyc2Nhbi1jb250YWluZXIgLnVwbG9hZC1idXR0b257XHJcbiAgICBwYWRkaW5nOiAycHggN3B4O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuLnVwbG9hZGluZy1kaWFsb2cge1xyXG4gICAgbWluLWhlaWdodDogMTAwcHg7XHJcbiAgICBtYXgtaGVpZ2h0OiAxMDBweDtcclxuICAgIHBhZGRpbmctdG9wOiAwO1xyXG4gICAgbWFyZ2luLXRvcDogMjAlO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbn1cclxuXHJcbi5zY2FubmVkLWRldGFpbHMtZGlhbG9ne1xyXG5cdHdpZHRoOiA5MHZ3O1xyXG4gICAgbWF4LXdpZHRoOiA5MHZ3O1xyXG4gICAgbWluLXdpZHRoOiA5MHZ3O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwb2ludGVyLWV2ZW50czogYWxsO1xyXG59XHJcblxyXG4udXBsb2FkaW5nLXByb2dyZXNzIHtcclxuICAgIGhlaWdodDogMzBweDtcclxuICAgIG1hcmdpbjogMHB4IDEwcHg7XHJcbn1cclxuXHJcbi51cGxvYWRpbmctcHJvZ3Jlc3MtbGFiZWwge1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIHBvc2l0aW9uOiBhYnNvbHV0ZTtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxufVxyXG5cclxuLnVwbG9hZGVkLWZpbGUtaXRlbSB7XHJcblx0cGFkZGluZzogNXB4IDRweCAwIDEwcHg7XHJcblx0bWFyZ2luLWJvdHRvbTogM3B4O1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtOmhvdmVyIHtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjZmVmZmVhO1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtIC5maWxlbmFtZSB7XHJcblx0d2lkdGg6IDIzMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgb3ZlcmZsb3c6IGhpZGRlbjtcclxuICAgIG92ZXJmbG93LXk6IGhpZGRlbjtcclxuICAgIGhlaWdodDogMzBweDtcclxufVxyXG5cclxuLnVwbG9hZGVkLWZpbGUtaXRlbSAudXBsb2FkLWJ1dHRvbntcclxuICAgIHBhZGRpbmc6IDBweCA0cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogNXB4O1xyXG59XHJcblxyXG4udXBsb2FkZWQtZmlsZS1pdGVtIC51cGxvYWQtYnV0dG9uIC5tYXRlcmlhbC1pY29uc3tcclxuICAgIGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CreateInvoiceComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-create-invoice',
                templateUrl: './create-invoice.component.html',
                styleUrls: ['./create-invoice.component.css'],
                providers: [{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_6__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__["TranslateService"] }, { type: _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_9__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_10__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_11__["ErrorServiceService"] }, { type: _angular_forms__WEBPACK_IMPORTED_MODULE_12__["FormBuilder"] }, { type: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"] }, { type: _stomp_ng2_stompjs__WEBPACK_IMPORTED_MODULE_13__["StompService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../services/workflow/singletask/singletask-workflow-edit.service */ "./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");
/* harmony import */ var _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../components/wm-file-upload/wm-file-upload.component */ "./src/app/components/wm-file-upload/wm-file-upload.component.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
















const _c0 = function () { return ["/workflow/list"]; };
class CreateSingletaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService) {
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = null;
        this.generalDataObs = null;
        this.showDebug = false;
        this.uploadedFiles = [];
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
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
        return ssignstr;
    }
    ngOnInit() {
        this.loadInitialData();
    }
    onUploadedFilesChanged(uploadedFileList) {
        this.uploadedFiles = uploadedFileList;
    }
    loadInitialData() {
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
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
            }
            else {
                this.workflowSaveRequest = null;
            }
        });
    }
    save() {
        this.workflowSaveRequest.uploadedFiles = _wf_models__WEBPACK_IMPORTED_MODULE_3__["WorkflowUploadedFile"].loadUploadedFiles(this.uploadedFiles);
        this.loadingService.showLoading();
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
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_3__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
    }
}
CreateSingletaskComponent.ɵfac = function CreateSingletaskComponent_Factory(t) { return new (t || CreateSingletaskComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["SingleTaskWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"])); };
CreateSingletaskComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: CreateSingletaskComponent, selectors: [["app-create-singletask"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([_services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["SingleTaskWorkflowEditService"]])], decls: 49, vars: 34, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], [1, "workflow-content"], [1, "item-row"], [1, "item-label"], [1, "item-content"], ["type", "number", "max", "999", "min", "1", "maxlength", "3", 3, "ngModel", "ngModelChange"], [1, "clear"], [3, "users", "departments", "assignedUsers", "onSelectedAssignChanged"], [1, "wm-comments-textarea", 3, "ngModel", "ngModelChange"], [3, "ocrScanningEnabled", "editService", "showHeaderTitle", "drawBorder", "onUploadedFilesChanged"], [1, "item-content", "workflow-step-button-bar"], [1, "button-bar-button", "step-button", "button-save", 3, "click"], [1, "item-row", 3, "innerHTML"]], template: function CreateSingletaskComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](12, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "input", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CreateSingletaskComponent_Template_input_ngModelChange_14_listener($event) { return ctx.expireDays = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](19, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "app-wm-assign-list", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onSelectedAssignChanged", function CreateSingletaskComponent_Template_app_wm_assign_list_onSelectedAssignChanged_21_listener($event) { return ctx.onUsersSelected($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](22, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](23, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](24, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](28, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "textarea", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CreateSingletaskComponent_Template_textarea_ngModelChange_30_listener($event) { return ctx.comments = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](31, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](34);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](35, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "app-wm-file-upload", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onUploadedFilesChanged", function CreateSingletaskComponent_Template_app_wm_file_upload_onUploadedFilesChanged_37_listener($event) { return ctx.onUploadedFilesChanged($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](38, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "button", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateSingletaskComponent_Template_button_click_41_listener($event) { return ctx.save(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](42, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](43);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](44, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](45, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](46, "save");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](47, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](48, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        var tmp_5_0 = null;
        const currVal_5 = (tmp_5_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](22, 23, ctx.generalDataObs)) == null ? null : tmp_5_0.company.users;
        var tmp_6_0 = null;
        const currVal_6 = (tmp_6_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](23, 25, ctx.generalDataObs)) == null ? null : tmp_6_0.company.departments;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 17, "menu-workflow-create"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](33, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](12, 19, "common.expiredays"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.expireDays);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](19, 21, "workflow-assignto"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", currVal_5)("departments", currVal_6)("assignedUsers", ctx.assignedUsers);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](28, 27, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.comments);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](35, 29, "common.attachments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ocrScanningEnabled", false)("editService", ctx.editService)("showHeaderTitle", false)("drawBorder", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](44, 31, "common.save"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx.debugData, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NumberValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["MaxLengthValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgModel"], _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_10__["WmAssignListComponent"], _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_11__["WmFileUploadComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_12__["AsyncPipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]:not(.file-item), div.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLXNpbmdsZXRhc2svY3JlYXRlLXNpbmdsZXRhc2suY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTtJQUNJLFlBQVk7SUFDWixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvY3JlYXRlL2NyZWF0ZS1zaW5nbGV0YXNrL2NyZWF0ZS1zaW5nbGV0YXNrLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdywgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBtYXJnaW46IDVweCAwIDEwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXIsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFye1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAyMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIHdpZHRoOiAxMzBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIFxyXG4gICAgcGFkZGluZy1sZWZ0OiAwcHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMTM1cHgpO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dDpub3QoLmZpbGUtaXRlbSksIFxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3QsXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3Rcclxue1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CreateSingletaskComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-create-singletask',
                templateUrl: './create-singletask.component.html',
                styleUrls: ['./create-singletask.component.css'],
                providers: [_services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["SingleTaskWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"] }, { type: _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["SingleTaskWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../services/workflow/testthreetask/testthreetask-workflow-edit.service */ "./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");
/* harmony import */ var _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../../../components/wm-file-upload/wm-file-upload.component */ "./src/app/components/wm-file-upload/wm-file-upload.component.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
















const _c0 = function () { return ["/workflow/list"]; };
class CreateTestthreetaskComponent {
    constructor(router, global, translate, editService, loadingService, http, errorService) {
        this.router = router;
        this.global = global;
        this.translate = translate;
        this.editService = editService;
        this.loadingService = loadingService;
        this.http = http;
        this.errorService = errorService;
        this.workflowListUrl = "/workflow/list";
        this.workflowSaveRequest = null;
        this.generalDataObs = null;
        this.showDebug = false;
        this.uploadedFiles = [];
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
                this.loadInitialData();
            }
        });
        this.generalDataObs = this.global.currentSessionDataSubject.asObservable();
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
        return ssignstr;
    }
    ngOnInit() {
        this.loadInitialData();
    }
    onUploadedFilesChanged(uploadedFileList) {
        this.uploadedFiles = uploadedFileList;
    }
    loadInitialData() {
        if (this.editService.workflowSaveRequestInit !== null) {
            this.workflowSaveRequest = this.editService.workflowSaveRequestInit.workflowSaveRequest;
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
            }
            else {
                this.workflowSaveRequest = null;
            }
        });
    }
    save() {
        this.workflowSaveRequest.uploadedFiles = _wf_models__WEBPACK_IMPORTED_MODULE_3__["WorkflowUploadedFile"].loadUploadedFiles(this.uploadedFiles);
        this.loadingService.showLoading();
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
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_3__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
    }
}
CreateTestthreetaskComponent.ɵfac = function CreateTestthreetaskComponent_Factory(t) { return new (t || CreateTestthreetaskComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["TestthreetaskWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"])); };
CreateTestthreetaskComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: CreateTestthreetaskComponent, selectors: [["app-create-testthreetask"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([_services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["TestthreetaskWorkflowEditService"]])], decls: 49, vars: 34, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], [1, "workflow-content"], [1, "item-row"], [1, "item-label"], [1, "item-content"], ["type", "number", "max", "999", "min", "1", "maxlength", "3", 3, "ngModel", "ngModelChange"], [1, "clear"], [3, "users", "departments", "assignedUsers", "onSelectedAssignChanged"], [1, "wm-comments-textarea", 3, "ngModel", "ngModelChange"], [3, "ocrScanningEnabled", "editService", "showHeaderTitle", "drawBorder", "onUploadedFilesChanged"], [1, "item-content", "workflow-step-button-bar"], [1, "button-bar-button", "step-button", "button-save", 3, "click"], [1, "item-row", 3, "innerHTML"]], template: function CreateTestthreetaskComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](12, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "input", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CreateTestthreetaskComponent_Template_input_ngModelChange_14_listener($event) { return ctx.expireDays = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](19, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "app-wm-assign-list", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onSelectedAssignChanged", function CreateTestthreetaskComponent_Template_app_wm_assign_list_onSelectedAssignChanged_21_listener($event) { return ctx.onUsersSelected($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](22, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](23, "async");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](24, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](28, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "textarea", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function CreateTestthreetaskComponent_Template_textarea_ngModelChange_30_listener($event) { return ctx.comments = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](31, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](34);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](35, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "app-wm-file-upload", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onUploadedFilesChanged", function CreateTestthreetaskComponent_Template_app_wm_file_upload_onUploadedFilesChanged_37_listener($event) { return ctx.onUploadedFilesChanged($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](38, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](41, "button", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function CreateTestthreetaskComponent_Template_button_click_41_listener($event) { return ctx.save(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](42, "span");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](43);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](44, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](45, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](46, "save");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](47, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](48, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        var tmp_5_0 = null;
        const currVal_5 = (tmp_5_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](22, 23, ctx.generalDataObs)) == null ? null : tmp_5_0.company.users;
        var tmp_6_0 = null;
        const currVal_6 = (tmp_6_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](23, 25, ctx.generalDataObs)) == null ? null : tmp_6_0.company.departments;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 17, "menu-workflow-create"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](33, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](12, 19, "common.expiredays"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.expireDays);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](19, 21, "workflow-assignto"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", currVal_5)("departments", currVal_6)("assignedUsers", ctx.assignedUsers);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](28, 27, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx.comments);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](35, 29, "common.attachments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ocrScanningEnabled", false)("editService", ctx.editService)("showHeaderTitle", false)("drawBorder", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](44, 31, "common.save"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx.debugData, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NumberValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["MaxLengthValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgModel"], _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_10__["WmAssignListComponent"], _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_11__["WmFileUploadComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_12__["AsyncPipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]:not(.file-item), div.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9jcmVhdGUvY3JlYXRlLXRlc3R0aHJlZXRhc2svY3JlYXRlLXRlc3R0aHJlZXRhc2suY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTtJQUNJLFlBQVk7SUFDWixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvY3JlYXRlL2NyZWF0ZS10ZXN0dGhyZWV0YXNrL2NyZWF0ZS10ZXN0dGhyZWV0YXNrLmNvbXBvbmVudC5jc3MiLCJzb3VyY2VzQ29udGVudCI6WyJcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtY29udGFpbmVye1xyXG5cdGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIG1hcmdpbjogMTBweCAwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdywgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBtYXJnaW46IDVweCAwIDEwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXIsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFye1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAyMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIHdpZHRoOiAxMzBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIFxyXG4gICAgcGFkZGluZy1sZWZ0OiAwcHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMTM1cHgpO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dDpub3QoLmZpbGUtaXRlbSksIFxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3QsXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3Rcclxue1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](CreateTestthreetaskComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-create-testthreetask',
                templateUrl: './create-testthreetask.component.html',
                styleUrls: ['./create-testthreetask.component.css'],
                providers: [_services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["TestthreetaskWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"] }, { type: _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_2__["TestthreetaskWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_7__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_8__["ErrorServiceService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");






const _c0 = function (a1) { return ["/workflow/create/", a1]; };
function WorkflowCreateComponent_a_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "a", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const type_r67 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](2, _c0, type_r67.controllerPreffix));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](type_r67.title);
} }
const _c1 = function () { return ["/workflow/list"]; };
class WorkflowCreateComponent {
    constructor(router, global, translate) {
        this.router = router;
        this.global = global;
        this.worlflowTypes = [];
    }
    ngOnInit() {
        this.worlflowTypes = this.global.loadedGeneralData.workflow.worlflowTypes;
    }
}
WorkflowCreateComponent.ɵfac = function WorkflowCreateComponent_Factory(t) { return new (t || WorkflowCreateComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"])); };
WorkflowCreateComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WorkflowCreateComponent, selectors: [["app-workflow-create"]], decls: 16, vars: 9, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], [1, "workflow-content"], [1, "item-row"], [1, "list-group"], [1, "list-group-item", "list-group-item-action", "list-group-item-title"], ["class", "list-group-item list-group-item-action link-out", 3, "routerLink", 4, "ngFor", "ngForOf"], [1, "clear"], [1, "list-group-item", "list-group-item-action", "link-out", 3, "routerLink"]], template: function WorkflowCreateComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "a", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](13, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, WorkflowCreateComponent_a_14_Template, 2, 4, "a", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 4, "menu-workflow-create"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](8, _c1));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](13, 6, "workflow-type"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.worlflowTypes);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslatePipe"]], styles: ["\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvY3JlYXRlL3dvcmtmbG93LWNyZWF0ZS93b3JrZmxvdy1jcmVhdGUuY29tcG9uZW50LmNzcyJ9 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowCreateComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-workflow-create',
                templateUrl: './workflow-create.component.html',
                styleUrls: ['./workflow-create.component.css']
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_2__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../../services/workflow/invoice/invoice-workflow-edit.service */ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts");
/* harmony import */ var _invoice_base_component__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../invoice-base.component */ "./src/app/wm-components/invoice-base.component.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_input__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! @angular/material/input */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/input.js");
/* harmony import */ var _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/datepicker */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/datepicker.js");
/* harmony import */ var _angular_material_form_field__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! @angular/material/form-field */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/form-field.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_17__ = __webpack_require__(/*! ../../../components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");






















function EditInvoiceComponent_option_57_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "option", 47);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const invoiceType_r91 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("value", invoiceType_r91.value);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](invoiceType_r91.title);
} }
function EditInvoiceComponent_div_93_Template(rf, ctx) { if (rf & 1) {
    const _r94 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](8, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "input", 50);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function EditInvoiceComponent_div_93_Template_input_change_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r94); const ctx_r93 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r93.calcDiscountDate(); })("dateInput", function EditInvoiceComponent_div_93_Template_input_dateInput_10_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r94); const ctx_r95 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r95.calcDiscountDate(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](11, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](12, "mat-datepicker-toggle", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](13, "mat-datepicker", 24, 51);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](16, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](19, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](21, "input", 52);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22, " % ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](23, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](27, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "input", 53);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function EditInvoiceComponent_div_93_Template_input_change_29_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r94); const ctx_r96 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r96.calcDiscountDate(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](31);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](32, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](33, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "div", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](36);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](37, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](38, "div", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](39, "input", 54);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](40, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](41, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const _r92 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](14);
    const ctx_r85 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 11, "invoice-discount"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](8, 13, "invoice-discountenterdate-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](11, 15, "invoice-discountenterdate"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matDatepicker", _r92);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("for", _r92);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("startAt", ctx_r85.invoiceEditForm.controls.discountEnterDate.value);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](19, 17, "invoice-discountrate-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](27, 19, "invoice-discountdeadline-short"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](32, 21, "common.days"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](37, 23, "invoice-discountdate"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](40, 25, "invoice-discountdate"));
} }
function EditInvoiceComponent_div_102_Template(rf, ctx) { if (rf & 1) {
    const _r98 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 37);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "app-wm-assign-list", 55);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onSelectedAssignChanged", function EditInvoiceComponent_div_102_Template_app_wm_assign_list_onSelectedAssignChanged_5_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r98); const ctx_r97 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r97.onUsersSelected($event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "async");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "async");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "div", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r86 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    var tmp_1_0 = null;
    const currVal_1 = (tmp_1_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 6, ctx_r86.generalDataObs)) == null ? null : tmp_1_0.company.users;
    var tmp_2_0 = null;
    const currVal_2 = (tmp_2_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 8, ctx_r86.generalDataObs)) == null ? null : tmp_2_0.company.departments;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 4, "workflow-assignto"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", currVal_1)("departments", currVal_2)("assignedUsers", ctx_r86.assignedUsers);
} }
function EditInvoiceComponent_button_105_Template(rf, ctx) { if (rf & 1) {
    const _r100 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 56);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditInvoiceComponent_button_105_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r100); const ctx_r99 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r99.save(false); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r87 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r87.invoiceEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.save"));
} }
function EditInvoiceComponent_button_106_Template(rf, ctx) { if (rf & 1) {
    const _r102 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 57);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditInvoiceComponent_button_106_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r102); const ctx_r101 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r101.save(true); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r88 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r88.invoiceEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.savedone"));
} }
function EditInvoiceComponent_button_107_Template(rf, ctx) { if (rf & 1) {
    const _r104 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 58);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditInvoiceComponent_button_107_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r104); const ctx_r103 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r103.archive(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r89 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r89.invoiceEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "workflow-archive"));
} }
function EditInvoiceComponent_span_108_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 59);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r90 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r90.saveMessage);
} }
const _c0 = function () { return ["/workflow/list"]; };
const _c1 = function (a0) { return { "ng-invalid": a0 }; };
class EditInvoiceComponent extends _invoice_base_component__WEBPACK_IMPORTED_MODULE_4__["InvoiceBaseComponent"] {
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
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
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
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_5__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_5__["parseDate"])(ss, 'dd.mm.yyyy');
        return ss;
    }
    ngOnInit() {
        super.ngOnInit();
    }
    loadInitialData() {
        if (this.workflowIdentity == '') {
            return;
        }
        this.loadWorkflowData();
    }
    reload() {
        this.loadInitialData();
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
        if (makeDone) {
            this.doneWorkflowData();
        }
        else {
            this.saveWorkflowData();
        }
    }
    archive() {
        this.setFormControlValues();
        this.loadingService.showLoading();
        this.archiveWorkflowData();
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
}
EditInvoiceComponent.ɵfac = function EditInvoiceComponent_Factory(t) { return new (t || EditInvoiceComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_6__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_8__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_10__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"])); };
EditInvoiceComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: EditInvoiceComponent, selectors: [["app-edit-invoice"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_5__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵInheritDefinitionFeature"]], decls: 113, vars: 59, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], [1, "toolbar-button", 3, "click"], [1, "workflow-content-container"], [1, "workflow-content"], ["id", "workflow-form", "name", "workflowForm", 3, "formGroup"], [1, "panel", "panel-default"], [1, "panel-heading"], [1, "panel-body"], [1, "item-row"], [1, "item-label", "label-required", "label-large"], [1, "item-content", "large-content"], ["type", "text", "required", "", "name", "sender", "formControlName", "sender"], [1, "item-label", "small-label"], [1, "item-content", "small-content"], ["type", "checkbox"], [1, "clear"], ["type", "text", "required", "", "name", "registerNumber", "formControlName", "registerNumber"], [1, "item-label", "label-required", "small-label"], ["required", "", "matInput", "", "formControlName", "invocieDate", 1, "select-date", 3, "matDatepicker", "placeholder", "change", "dateInput"], ["matSuffix", "", 3, "for"], ["startView", "month", 3, "startAt"], ["invocieDatepicker", ""], ["type", "number", "required", "", "name", "paymentAmount", "formControlName", "paymentAmount"], ["required", "", "name", "invoiceType", "formControlName", "invoiceType", 3, "ngClass"], [3, "value", 4, "ngFor", "ngForOf"], [1, "twopannel"], [1, "panel", "panel-default", "panel-vendor"], [1, "item-content", "fullrowfromlabel"], ["type", "text", "required", "", "name", "vendorNumber", "formControlName", "vendorNumber"], ["type", "text", "required", "", "name", "partnerCode", "formControlName", "partnerCode"], ["type", "text", "required", "", "name", "vendorName", "formControlName", "vendorName"], ["type", "checkbox", "name", "isDirectDebitPermission", "formControlName", "isDirectDebitPermission", 3, "checked"], ["class", "panel panel-default panel-discount", 4, "ngIf"], [1, "item-label", "label-large"], ["formControlName", "comments", 1, "comments-fullrow", "wm-comments-textarea"], ["class", "item-row", 4, "ngIf"], [1, "workflow-step-button-bar"], ["type", "button", "class", "button-bar-button step-button button-save", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-done", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-archive", 3, "disabled", "click", 4, "ngIf"], ["class", "alert alert-success button-bar-alert", 4, "ngIf"], [1, "workflow-record"], [3, "workflow"], [3, "value"], [1, "panel", "panel-default", "panel-discount"], [1, "item-content"], ["required", "", "matInput", "", "formControlName", "discountEnterDate", 1, "select-date", 3, "matDatepicker", "placeholder", "change", "dateInput"], ["discountEnterDatepicker", ""], ["type", "number", "required", "", "name", "discountRate", "formControlName", "discountRate", 1, "short-input"], ["type", "number", "required", "", "name", "discountDeadline", "formControlName", "discountDeadline", 1, "short-input", 3, "change"], ["required", "", "readonly", "", "formControlName", "discountDate", 1, "select-date", 3, "placeholder"], [3, "users", "departments", "assignedUsers", "onSelectedAssignChanged"], ["type", "button", 1, "button-bar-button", "step-button", "button-save", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-done", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-archive", 3, "disabled", "click"], [1, "alert", "alert-success", "button-bar-alert"]], template: function EditInvoiceComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditInvoiceComponent_Template_button_click_7_listener($event) { return ctx.reload(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "refresh");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "form", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](16, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](21, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](23, "input", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](26, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](27, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "input", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](29, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](32);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](33, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](34, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](35, "input", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](38, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](39, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](40, "input", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function EditInvoiceComponent_Template_input_change_40_listener($event) { return ctx.invoiceDateChanges(); })("dateInput", function EditInvoiceComponent_Template_input_dateInput_40_listener($event) { return ctx.invoiceDateChanges(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](41, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](42, "mat-datepicker-toggle", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](43, "mat-datepicker", 24, 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](45, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](46, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](47, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](48, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](49);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](50, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](51, "input", 26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](52, "div", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](53);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](54, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](55, "div", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](56, "select", 27);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](57, EditInvoiceComponent_option_57_Template, 2, 2, "option", 28);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](58, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](59, "div", 29);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](60, "div", 30);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](61, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](62);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](63, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](64, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](65, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](66, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](67);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](68, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](69, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](70, "input", 32);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](71, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](72, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](73, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](74);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](75, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](76, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](77, "input", 33);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](78, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](79, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](80, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](81);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](82, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](83, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](84, "input", 34);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](85, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](86, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](87, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](88);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](89, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](90, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](91, "input", 35);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](92, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](93, EditInvoiceComponent_div_93_Template, 42, 27, "div", 36);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](94, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](95, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](96, "div", 37);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](97);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](98, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](99, "div", 31);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](100, "textarea", 38);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](101, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](102, EditInvoiceComponent_div_102_Template, 9, 10, "div", 39);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](103, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](104, "div", 40);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](105, EditInvoiceComponent_button_105_Template, 6, 4, "button", 41);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](106, EditInvoiceComponent_button_106_Template, 6, 4, "button", 42);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](107, EditInvoiceComponent_button_107_Template, 6, 4, "button", 43);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](108, EditInvoiceComponent_span_108_Template, 2, 1, "span", 44);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](109, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](110, "div", 45);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](111, "app-workflow-inlineview", 46);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](112, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        const _r83 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵreference"](44);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.pageTitle);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](56, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.invoiceEditForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](16, 30, "invoice-invoice"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](21, 32, "invoice-sender"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](26, 34, "invoice-trusted"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](33, 36, "invoice-invoicenumber"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](38, 38, "invoice-invoicedate"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate"]("placeholder", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](41, 40, "invoice-invoicedate-select"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matDatepicker", _r83);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("for", _r83);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("startAt", ctx.invoiceEditForm.controls.invocieDate.value);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.paymentamountTitle);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](54, 42, "invoice-invoicetype"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](57, _c1, ctx.invoiceEditForm.controls.invoiceType.errors));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.invoiceTypes);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](63, 44, "invoice-vendor"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](68, 46, "invoice-vendornumber"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](75, 48, "invoice-partnercode"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](82, 50, "invoice-vendorname"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](89, 52, "invoice-isdirectdebitpermission"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx.forms.isDirectDebitPermission.value);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.isPaymentInvoiceType() === false);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](98, 54, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canAssign);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canSave);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canDone);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canArchive);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.saveMessage !== "");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("workflow", ctx.viewWorkflowModel);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["RequiredValidator"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormControlName"], _angular_material_input__WEBPACK_IMPORTED_MODULE_12__["MatInput"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_13__["MatDatepickerInput"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_13__["MatDatepickerToggle"], _angular_material_form_field__WEBPACK_IMPORTED_MODULE_14__["MatSuffix"], _angular_material_datepicker__WEBPACK_IMPORTED_MODULE_13__["MatDatepicker"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NumberValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["SelectControlValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_15__["NgClass"], _angular_common__WEBPACK_IMPORTED_MODULE_15__["NgForOf"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["CheckboxControlValueAccessor"], _angular_common__WEBPACK_IMPORTED_MODULE_15__["NgIf"], _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_16__["WorkflowInlineviewComponent"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["NgSelectOption"], _angular_forms__WEBPACK_IMPORTED_MODULE_11__["ɵangular_packages_forms_forms_x"], _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_17__["WmAssignListComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_15__["AsyncPipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px 50px 0;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 690px;\r\n}\r\n\r\ndiv.workflow-record[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 690px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\n.workflow-content[_ngcontent-%COMP%]   .panel[_ngcontent-%COMP%]{\r\n\tbackground-color: #f2f1f1 !important;\r\n\tpadding: 8px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel[_ngcontent-%COMP%]{\r\n\t\r\n\theight: 190px;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel.panel-vendor[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 310px);\r\n\tfloat: left;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel.panel-discount[_ngcontent-%COMP%]{\r\n\twidth: 300px;\r\n\tfloat: right;\r\n}\r\n\r\n.twopannel[_ngcontent-%COMP%]   .panel.panel-discount[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n}\r\n\r\n.small-content[_ngcontent-%COMP%]{\r\n\twidth: 120px;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]{\r\n\theight: 26px;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]:not(.fullrow), .item-content[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   select.fullrow[_ngcontent-%COMP%] {\r\n\theight: 26px;\r\n\twidth: calc(100%);\r\n}\r\n\r\n.item-content.larg-content[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 450px);\r\n}\r\n\r\n.workflow-content[_ngcontent-%COMP%]   .panel[_ngcontent-%COMP%]   .panel-heading[_ngcontent-%COMP%]{\r\n\tfont-weight: bold;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    background-color: white;\r\n    padding: 6px;\r\n    padding-right: 20px;\r\n   \r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 25px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    height: 25px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .label-large[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .label-large[_ngcontent-%COMP%]{\r\n    width: 150px;\r\n}\r\n\r\n.large-content[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 420px);\r\n}\r\n\r\n.large-content[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   input[type=number][_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], .large-content[_ngcontent-%COMP%]   areatext[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 30px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .small-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   .small-label[_ngcontent-%COMP%]{\r\n    width: 122px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    padding-left: 0px;\r\n    float: left;\r\n}\r\n\r\n.item-content[_ngcontent-%COMP%]   input[type=checkbox][_ngcontent-%COMP%]{\r\n\twidth: 20px;\r\n\theight: 20px;\t\r\n\tmargin-top: 3px;\r\n}\r\n\r\ndiv.fullrowfromlabel[_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 150px);\t\r\n}\r\n\r\ndiv.fullrowfromlabel[_ngcontent-%COMP%]   input[type=text][_ngcontent-%COMP%]{\r\n\twidth: calc(100% - 10px);\t\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\n.assign-list[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%] {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -22px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\r\n\r\n.invalid-request-container[_ngcontent-%COMP%]{\r\n\twidth: 60vw;\r\n    min-height: 100px;\r\n    text-align: center;\r\n    margin-left: auto;\r\n    margin-right: auto;\r\n    margin-top: 10vh;\r\n    padding: 10px;\r\n\t\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%], .workflow-file-view-link[_ngcontent-%COMP%]:active, .workflow-file-view-link[_ngcontent-%COMP%]:visited{\r\n\tcolor: #333;\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%]:hover{\r\n\tcolor: #551113;\r\n}\r\n\r\n.workflow-file-view-link[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\twidth: 24px;\r\n}\r\n\r\n.assign-list[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%] {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n}\r\n\r\ninput.select-date[_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\r\n\r\ninput.short-input[_ngcontent-%COMP%]{\r\n\twidth: 100px;\r\n\theight: 26px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtaW52b2ljZS9lZGl0LWludm9pY2UuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7Q0FDQywyQkFBMkI7SUFDeEIsdUJBQXVCO0lBQ3ZCLG1CQUFtQjtJQUNuQixhQUFhO0lBQ2IseUJBQXlCO0FBQzdCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7SUFDbEIseUJBQXlCO0lBQ3pCLFdBQVc7SUFDWCxhQUFhO0FBQ2pCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGFBQWE7SUFDYixrQkFBa0I7SUFDbEIsWUFBWTtJQUNaLFlBQVk7SUFDWixhQUFhO0FBQ2pCOztBQUdBO0lBQ0ksYUFBYTtBQUNqQjs7QUFFQTtDQUNDLG9DQUFvQztDQUNwQyxZQUFZO0lBQ1QsbUJBQW1CO0FBQ3ZCOztBQUVBOztDQUVDLGFBQWE7QUFDZDs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixXQUFXO0FBQ1o7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtBQUNiOztBQUVBO0NBQ0MsWUFBWTtDQUNaLGlCQUFpQjtBQUNsQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixpQkFBaUI7QUFDbEI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyxpQkFBaUI7QUFDbEI7O0FBRUE7SUFDSSxrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSx1QkFBdUI7SUFDdkIsWUFBWTtJQUNaLG1CQUFtQjs7QUFFdkI7O0FBRUE7O0lBRUksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxZQUFZO0FBQ2hCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUdBOzs7O0NBSUMsd0JBQXdCO0FBQ3pCOztBQUVBOztJQUVJLFlBQVk7QUFDaEI7O0FBRUE7SUFDSSxpQkFBaUI7SUFDakIsV0FBVztBQUNmOztBQUVBO0NBQ0MsV0FBVztDQUNYLFlBQVk7Q0FDWixlQUFlO0FBQ2hCOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0Msd0JBQXdCO0FBQ3pCOztBQUVBOztJQUVJLHdCQUF3QjtJQUN4QixZQUFZO0FBQ2hCOztBQUVBOztJQUVJLFVBQVU7SUFDVixZQUFZO0lBQ1oscUJBQXFCO0FBQ3pCOztBQUVBO0NBQ0MsMkJBQTJCO0lBQ3hCLFlBQVk7SUFDWixrQkFBa0I7SUFDbEIsV0FBVztJQUNYLGlCQUFpQjtJQUNqQixpQkFBaUI7SUFDakIsZ0JBQWdCO0lBQ2hCLG1CQUFtQjtBQUN2Qjs7QUFFQTtJQUNJLDJCQUEyQjtJQUMzQixrQkFBa0I7SUFDbEIsZ0JBQWdCO0lBQ2hCLFdBQVc7SUFDWCxtQkFBbUI7SUFDbkIsaUJBQWlCO0lBQ2pCLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLFlBQVk7SUFDWix1QkFBdUI7SUFDdkIsVUFBVTtJQUNWLGdCQUFnQjtJQUNoQixZQUFZO0lBQ1osZ0JBQWdCO0FBQ3BCOztBQUVBO0NBQ0MsZUFBZTtBQUNoQjs7QUFFQTtJQUNJLFlBQVk7SUFDWixxQkFBcUI7SUFDckIsV0FBVztBQUNmOztBQUVBO0lBQ0ksWUFBWTtJQUNaLG1CQUFtQjtJQUNuQixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsNkJBQTZCO0FBQ2pDOztBQUVBO0lBQ0ksWUFBWTtJQUNaLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtJQUNqQixlQUFlO0lBQ2YsdUJBQXVCO0FBQzNCOztBQUVBO0NBQ0MsV0FBVztJQUNSLGlCQUFpQjtJQUNqQixrQkFBa0I7SUFDbEIsaUJBQWlCO0lBQ2pCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsYUFBYTs7QUFFakI7O0FBRUE7Q0FDQyxXQUFXO0FBQ1o7O0FBRUE7Q0FDQyxjQUFjO0FBQ2Y7O0FBRUE7Q0FDQyxXQUFXO0FBQ1o7O0FBR0E7Q0FDQywyQkFBMkI7SUFDeEIsWUFBWTtJQUNaLGtCQUFrQjtJQUNsQixXQUFXO0lBQ1gsaUJBQWlCO0lBQ2pCLGlCQUFpQjtJQUNqQixnQkFBZ0I7SUFDaEIsbUJBQW1CO0FBQ3ZCOztBQUVBO0lBQ0ksMkJBQTJCO0lBQzNCLGtCQUFrQjtJQUNsQixnQkFBZ0I7SUFDaEIsV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHVCQUF1QjtJQUN2QixVQUFVO0lBQ1YsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixnQkFBZ0I7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLHFCQUFxQjtJQUNyQixXQUFXO0FBQ2Y7O0FBRUE7SUFDSSxZQUFZO0lBQ1osbUJBQW1CO0lBQ25CLFdBQVc7SUFDWCxZQUFZO0lBQ1osVUFBVTtJQUNWLGlCQUFpQjtBQUNyQjs7QUFFQTtDQUNDLFlBQVk7Q0FDWixZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxZQUFZO0NBQ1osWUFBWTtBQUNiIiwiZmlsZSI6InNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtaW52b2ljZS9lZGl0LWludm9pY2UuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5kaXYud29ya2Zsb3ctY29udGVudC1jb250YWluZXJ7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgbWFyZ2luOiAxMHB4IDBweCA1MHB4IDA7XHJcbiAgICBib3JkZXItcmFkaXVzOiAxMHB4O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6ICNmMWYxZjE7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50e1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMzEwcHgpO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBoZWlnaHQ6IDY5MHB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctcmVjb3Jke1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2RhZDlkOTtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA1cHg7XHJcbiAgICB3aWR0aDogMzAwcHg7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICBoZWlnaHQ6IDY5MHB4O1xyXG59XHJcblxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3Jke1xyXG4gICAgcGFkZGluZzogMTVweDtcclxufVxyXG5cclxuLndvcmtmbG93LWNvbnRlbnQgLnBhbmVse1xyXG5cdGJhY2tncm91bmQtY29sb3I6ICNmMmYxZjEgIWltcG9ydGFudDtcclxuXHRwYWRkaW5nOiA4cHg7XHJcbiAgICBtYXJnaW4tYm90dG9tOiAxMHB4O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbHtcclxuXHRcclxuXHRoZWlnaHQ6IDE5MHB4O1xyXG59XHJcblxyXG4udHdvcGFubmVsIC5wYW5lbC5wYW5lbC12ZW5kb3J7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDMxMHB4KTtcclxuXHRmbG9hdDogbGVmdDtcclxufVxyXG5cclxuLnR3b3Bhbm5lbCAucGFuZWwucGFuZWwtZGlzY291bnR7XHJcblx0d2lkdGg6IDMwMHB4O1xyXG5cdGZsb2F0OiByaWdodDtcclxufVxyXG5cclxuLnR3b3Bhbm5lbCAucGFuZWwucGFuZWwtZGlzY291bnQgaW5wdXRbdHlwZT10ZXh0XXtcclxuXHR3aWR0aDogMTAwcHg7XHJcbn1cclxuXHJcbi5zbWFsbC1jb250ZW50e1xyXG5cdHdpZHRoOiAxMjBweDtcclxufVxyXG5cclxuLml0ZW0tY29udGVudCBzZWxlY3R7XHJcblx0aGVpZ2h0OiAyNnB4O1xyXG59IFxyXG5cclxuLml0ZW0tY29udGVudCBzZWxlY3Q6bm90KC5mdWxscm93KSwgLml0ZW0tY29udGVudCBpbnB1dFt0eXBlPXRleHRdIHtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSk7XHJcbn0gXHJcblxyXG4uaXRlbS1jb250ZW50IHNlbGVjdC5mdWxscm93IHtcclxuXHRoZWlnaHQ6IDI2cHg7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSk7XHJcbn0gXHJcblxyXG4uaXRlbS1jb250ZW50LmxhcmctY29udGVudHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gNDUwcHgpO1xyXG59XHJcblxyXG4ud29ya2Zsb3ctY29udGVudCAucGFuZWwgLnBhbmVsLWhlYWRpbmd7XHJcblx0Zm9udC13ZWlnaHQ6IGJvbGQ7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdywgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBtYXJnaW46IDVweCAwIDEwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXIsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFye1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBwYWRkaW5nLXJpZ2h0OiAyMHB4O1xyXG4gICBcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWxhYmVsLCBcclxuZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDI1cHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIGhlaWdodDogMjVweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IC5sYWJlbC1sYXJnZSwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgLmxhYmVsLWxhcmdle1xyXG4gICAgd2lkdGg6IDE1MHB4O1xyXG59XHJcblxyXG4ubGFyZ2UtY29udGVudHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gNDIwcHgpO1xyXG59XHJcblxyXG5cclxuLmxhcmdlLWNvbnRlbnQgaW5wdXRbdHlwZT10ZXh0XSxcclxuLmxhcmdlLWNvbnRlbnQgaW5wdXRbdHlwZT1udW1iZXJdLFxyXG4ubGFyZ2UtY29udGVudCBzZWxlY3QsIFxyXG4ubGFyZ2UtY29udGVudCBhcmVhdGV4dHtcclxuXHR3aWR0aDogY2FsYygxMDAlIC0gMzBweCk7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyAuc21hbGwtbGFiZWwsIFxyXG5kaXYud29ya2Zsb3ctY29udGVudC1yZWNvcmQgZGl2Lml0ZW0tcm93IC5zbWFsbC1sYWJlbHtcclxuICAgIHdpZHRoOiAxMjJweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDBweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG4uaXRlbS1jb250ZW50IGlucHV0W3R5cGU9Y2hlY2tib3hde1xyXG5cdHdpZHRoOiAyMHB4O1xyXG5cdGhlaWdodDogMjBweDtcdFxyXG5cdG1hcmdpbi10b3A6IDNweDtcclxufVxyXG5cclxuZGl2LmZ1bGxyb3dmcm9tbGFiZWx7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDE1MHB4KTtcdFxyXG59XHJcblxyXG5kaXYuZnVsbHJvd2Zyb21sYWJlbCBpbnB1dFt0eXBlPXRleHRde1xyXG5cdHdpZHRoOiBjYWxjKDEwMCUgLSAxMHB4KTtcdFxyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLXRpdGxlXHJcbntcclxuICAgIHdpZHRoOiBjYWxjKDUwJSAtIDE3MHB4KTtcclxuICAgIGhlaWdodDogMjZweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQgaW5wdXQuZmlsZS1maWxlXHJcbntcclxuICAgIHdpZHRoOiA1MCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbiAgICBkaXNwbGF5OiBpbmxpbmUtYmxvY2s7O1xyXG59XHJcblxyXG4uYXNzaWduLWxpc3R7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBtaW4taGVpZ2h0OiAxMDBweDtcclxuICAgIG1heC1oZWlnaHQ6IDIwMHB4O1xyXG4gICAgb3ZlcmZsb3cteTogYXV0bztcclxuICAgIHBhZGRpbmctcmlnaHQ6IDI0cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCB7XHJcbiAgICBib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICBwYWRkaW5nOiAycHggNHB4O1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBiYWNrZ3JvdW5kOiAjZTZlNmU2O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiA1cHg7XHJcbiAgICBtYXJnaW4tYm90dG9tOiA1cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBidXR0b24ge1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy10b3A6IDNweDtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIG1hcmdpbi1sZWZ0OiA1cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBidXR0b24gaS5tYXRlcmlhbC1pY29uc3tcclxuXHRmb250LXNpemU6IDE2cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBzcGFuIHtcclxuICAgIGhlaWdodDogMjBweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG5idXR0b24uc2hvdy1zZWxlY3QtZGlhbG9nIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIG1hcmdpbi1yaWdodDogLTIycHg7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50O1xyXG59XHJcblxyXG5idXR0b24uZmlsZS1hY3Rpb24ge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgd2lkdGg6IDIycHg7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy1sZWZ0OiAycHg7XHJcbiAgICBtYXJnaW4tdG9wOiA0cHg7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxufVxyXG5cclxuLmludmFsaWQtcmVxdWVzdC1jb250YWluZXJ7XHJcblx0d2lkdGg6IDYwdnc7XHJcbiAgICBtaW4taGVpZ2h0OiAxMDBweDtcclxuICAgIHRleHQtYWxpZ246IGNlbnRlcjtcclxuICAgIG1hcmdpbi1sZWZ0OiBhdXRvO1xyXG4gICAgbWFyZ2luLXJpZ2h0OiBhdXRvO1xyXG4gICAgbWFyZ2luLXRvcDogMTB2aDtcclxuICAgIHBhZGRpbmc6IDEwcHg7XHJcblx0XHJcbn1cclxuXHJcbi53b3JrZmxvdy1maWxlLXZpZXctbGluaywgLndvcmtmbG93LWZpbGUtdmlldy1saW5rOmFjdGl2ZSwgLndvcmtmbG93LWZpbGUtdmlldy1saW5rOnZpc2l0ZWR7XHJcblx0Y29sb3I6ICMzMzM7XHJcbn1cclxuXHJcbi53b3JrZmxvdy1maWxlLXZpZXctbGluazpob3ZlcntcclxuXHRjb2xvcjogIzU1MTExMztcclxufVxyXG5cclxuLndvcmtmbG93LWZpbGUtdmlldy1saW5rIGkubWF0ZXJpYWwtaWNvbnN7XHJcblx0d2lkdGg6IDI0cHg7XHJcbn1cclxuXHJcblxyXG4uYXNzaWduLWxpc3R7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgcGFkZGluZzogNnB4O1xyXG4gICAgYm9yZGVyLXJhZGl1czogNHB4O1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBtaW4taGVpZ2h0OiAxMDBweDtcclxuICAgIG1heC1oZWlnaHQ6IDIwMHB4O1xyXG4gICAgb3ZlcmZsb3cteTogYXV0bztcclxuICAgIHBhZGRpbmctcmlnaHQ6IDI0cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCB7XHJcbiAgICBib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICBwYWRkaW5nOiAycHggNHB4O1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICBiYWNrZ3JvdW5kOiAjZTZlNmU2O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiA1cHg7XHJcbiAgICBtYXJnaW4tYm90dG9tOiA1cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBidXR0b24ge1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgYmFja2dyb3VuZDogdHJhbnNwYXJlbnQ7XHJcbiAgICBwYWRkaW5nOiAwO1xyXG4gICAgcGFkZGluZy10b3A6IDNweDtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIG1hcmdpbi1sZWZ0OiA1cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBidXR0b24gaS5tYXRlcmlhbC1pY29uc3tcclxuXHRmb250LXNpemU6IDE2cHg7XHJcbn1cclxuXHJcbmRpdi5hc3NpZ24tbGlzdCBkaXYudXNlci1pdGVtLWJveCBzcGFuIHtcclxuICAgIGhlaWdodDogMjBweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jaztcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG5idXR0b24uc2hvdy1zZWxlY3QtZGlhbG9nIHtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIG1hcmdpbi1yaWdodDogLTIwcHg7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxufVxyXG5cclxuaW5wdXQuc2VsZWN0LWRhdGV7XHJcblx0d2lkdGg6IDEwMHB4O1xyXG5cdGhlaWdodDogMjZweDtcclxufVxyXG5cclxuaW5wdXQuc2hvcnQtaW5wdXR7XHJcblx0d2lkdGg6IDEwMHB4O1xyXG5cdGhlaWdodDogMjZweDtcclxufVxyXG5cclxuXHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](EditInvoiceComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-edit-invoice',
                templateUrl: './edit-invoice.component.html',
                styleUrls: ['./edit-invoice.component.css'],
                providers: [{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_5__["GermanDateAdapter"] }, _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_6__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_7__["TranslateService"] }, { type: _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_3__["InvoiceWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_8__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_9__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_10__["ErrorServiceService"] }, { type: _angular_forms__WEBPACK_IMPORTED_MODULE_11__["FormBuilder"] }, { type: _angular_material_core__WEBPACK_IMPORTED_MODULE_2__["DateAdapter"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/workflow/singletask/singletask-workflow-edit.service */ "./src/app/services/workflow/singletask/singletask-workflow-edit.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../wf-models/workflow-save-request */ "./src/app/wf-models/workflow-save-request.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");




















function EditSingleTaskComponent_div_22_Template(rf, ctx) { if (rf & 1) {
    const _r113 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](2, "input", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "input", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("change", function EditSingleTaskComponent_div_22_Template_input_change_3_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r113); const file_r110 = ctx.$implicit; const fileIndex_r111 = ctx.index; const ctx_r112 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r112.fileTitleProgress($event, file_r110, fileIndex_r111); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "button", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditSingleTaskComponent_div_22_Template_button_click_4_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r113); const fileIndex_r111 = ctx.index; const ctx_r114 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r114.removeFile(fileIndex_r111); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, "delete");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "div", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const fileIndex_r111 = ctx.index;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", fileIndex_r111 + 1, ". ");
} }
function EditSingleTaskComponent_button_31_Template(rf, ctx) { if (rf & 1) {
    const _r116 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditSingleTaskComponent_button_31_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r116); const ctx_r115 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r115.save(false); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r106 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r106.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.save"));
} }
function EditSingleTaskComponent_button_32_Template(rf, ctx) { if (rf & 1) {
    const _r118 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditSingleTaskComponent_button_32_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r118); const ctx_r117 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r117.save(true); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r107 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r107.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.savedone"));
} }
function EditSingleTaskComponent_button_33_Template(rf, ctx) { if (rf & 1) {
    const _r120 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditSingleTaskComponent_button_33_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r120); const ctx_r119 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r119.archive(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r108 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r108.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "workflow-archive"));
} }
function EditSingleTaskComponent_span_34_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r109 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r109.saveMessage);
} }
const _c0 = function () { return ["/workflow/list"]; };
class EditSingleTaskComponent {
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
        this.workflowSaveRequest = new _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_6__["WorkflowSaveRequest"]();
        this.viewWorkflowModel = null;
        this.users = [];
        this.departments = [];
        this.fileTitles = [];
        this.showAssignModal = false;
        this.selectAssign = [];
        this.assignTypeUser = _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].USER;
        this.assignTypeDepartment = _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].DEPARTMENT;
        this.assignTypeDepartmentGroup = _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].DEPARTMENTGROUP;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
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
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_7__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_7__["parseDate"])(ss, 'dd.mm.yyyy');
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
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            controllerIdentity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
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
        var ft = new _wf_models__WEBPACK_IMPORTED_MODULE_5__["FileTitle"]();
        ft.title = "";
        ft.file = null;
        this.fileTitles.push(ft);
    }
    save(makeDone) {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (makeDone) {
            this.doneWorkflowData();
        }
        else {
            this.saveWorkflowData();
        }
    }
    archive() {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        this.archiveWorkflowData();
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
                    var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignItem"];
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
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].USER) {
            for (var index in this.users) {
                if (this.users[index].identity === item.itemIdentity) {
                    return this.users[index].fullName;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].DEPARTMENT) {
            for (var index in this.departments) {
                if (this.departments[index].identity === item.itemIdentity) {
                    return this.departments[index].title;
                }
            }
            return 'Unknown!';
        }
        if (item.itemType === _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignType"].DEPARTMENTGROUP) {
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
}
EditSingleTaskComponent.ɵfac = function EditSingleTaskComponent_Factory(t) { return new (t || EditSingleTaskComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_8__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["SingleTaskWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_12__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"])); };
EditSingleTaskComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: EditSingleTaskComponent, selectors: [["app-edit-single-task"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_7__["GermanDateAdapter"] }, _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["SingleTaskWorkflowEditService"]])], decls: 40, vars: 19, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], ["id", "workflow-form", "name", "workflowForm", 3, "formGroup"], [1, "workflow-content"], [1, "item-row"], [1, "item-label"], [1, "item-content"], ["formControlName", "comments", 1, "wm-comments-textarea"], [1, "clear"], [1, "item-content", "file-container"], ["class", "file-row", 4, "ngFor", "ngForOf"], [2, "margin-top", "20px"], [1, "file-action", 3, "click"], [1, "workflow-step-button-bar"], ["type", "button", "class", "button-bar-button step-button button-save", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-done", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-archive", 3, "disabled", "click", 4, "ngIf"], ["class", "alert alert-success button-bar-alert", 4, "ngIf"], [1, "item-row", 3, "innerHTML"], [1, "workflow-record"], [3, "workflow"], [1, "file-row"], ["type", "text", "placeholder", "Datei Titel", "formControlName", "file.title", 1, "file-item", "file-title"], ["type", "file", 1, "file-item", "file-file", 3, "change"], ["type", "button", 1, "button-bar-button", "step-button", "button-save", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-done", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-archive", 3, "disabled", "click"], [1, "alert", "alert-success", "button-bar-alert"]], template: function EditSingleTaskComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "form", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](13, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](15, "textarea", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](20, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](22, EditSingleTaskComponent_div_22_Template, 8, 1, "div", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "button", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditSingleTaskComponent_Template_button_click_24_listener($event) { return ctx.addFile(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26, "add");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](27, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](28, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](29, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](30, "div", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](31, EditSingleTaskComponent_button_31_Template, 6, 4, "button", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](32, EditSingleTaskComponent_button_32_Template, 6, 4, "button", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](33, EditSingleTaskComponent_button_33_Template, 6, 4, "button", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](34, EditSingleTaskComponent_span_34_Template, 2, 1, "span", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](35, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](36, "div", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](37, "div", 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](38, "app-workflow-inlineview", 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](39, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 12, "workflow-editing"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](18, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.workflowEditForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](13, 14, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](20, 16, "workflow-files"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.fileTitles);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canSave);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canDone);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canArchive);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.saveMessage !== "");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx.debugData, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("workflow", ctx.viewWorkflowModel);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroupDirective"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControlName"], _angular_common__WEBPACK_IMPORTED_MODULE_13__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_13__["NgIf"], _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_14__["WorkflowInlineviewComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslatePipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-record[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]:not(.file-item), div.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\n.assign-list[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%] {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtc2luZ2xlLXRhc2svZWRpdC1zaW5nbGUtdGFzay5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLDJCQUEyQjtJQUN4QixnQkFBZ0I7SUFDaEIsbUJBQW1CO0lBQ25CLGFBQWE7SUFDYix5QkFBeUI7QUFDN0I7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQix5QkFBeUI7SUFDekIsV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQixZQUFZO0lBQ1osWUFBWTtJQUNaLGFBQWE7QUFDakI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTtDQUNDLDJCQUEyQjtJQUN4QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLFVBQVU7SUFDVixnQkFBZ0I7SUFDaEIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1oscUJBQXFCO0lBQ3JCLFdBQVc7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLFlBQVk7SUFDWixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvZWRpdC9lZGl0LXNpbmdsZS10YXNrL2VkaXQtc2luZ2xlLXRhc2suY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5kaXYud29ya2Zsb3ctY29udGVudC1jb250YWluZXJ7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgbWFyZ2luOiAxMHB4IDBweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDEwcHg7XHJcbiAgICBwYWRkaW5nOiAxMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2YxZjFmMTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnR7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogMTVweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxuICAgIHdpZHRoOiBjYWxjKDEwMCUgLSAzMTBweCk7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGhlaWdodDogNTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1yZWNvcmR7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxuICAgIHdpZHRoOiAzMDBweDtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIGhlaWdodDogNTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdywgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBtYXJnaW46IDVweCAwIDEwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXIsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFye1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAyMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIHdpZHRoOiAxMzBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIFxyXG4gICAgcGFkZGluZy1sZWZ0OiAwcHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMTM1cHgpO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dDpub3QoLmZpbGUtaXRlbSksIFxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3QsXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3Rcclxue1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbi5hc3NpZ24tbGlzdHtcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICB3aWR0aDogMTAwJTtcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgbWF4LWhlaWdodDogMjAwcHg7XHJcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xyXG4gICAgcGFkZGluZy1yaWdodDogMjRweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHBhZGRpbmc6IDJweCA0cHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGJhY2tncm91bmQ6ICNlNmU2ZTY7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDVweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiB7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiBpLm1hdGVyaWFsLWljb25ze1xyXG5cdGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHNwYW4ge1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5zaG93LXNlbGVjdC1kaWFsb2cge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAtMjBweDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](EditSingleTaskComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-edit-single-task',
                templateUrl: './edit-single-task.component.html',
                styleUrls: ['./edit-single-task.component.css'],
                providers: [{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_7__["GermanDateAdapter"] }, _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["SingleTaskWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_8__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"] }, { type: _services_workflow_singletask_singletask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["SingleTaskWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_12__["ErrorServiceService"] }, { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] }, { type: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../../services/workflow/testthreetask/testthreetask-workflow-edit.service */ "./src/app/services/workflow/testthreetask/testthreetask-workflow-edit.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../../wf-models/workflow-save-request */ "./src/app/wf-models/workflow-save-request.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../../helper */ "./src/app/helper/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! ../../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_14__ = __webpack_require__(/*! ../../../components/wm-file-upload/wm-file-upload.component */ "./src/app/components/wm-file-upload/wm-file-upload.component.ts");
/* harmony import */ var _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_15__ = __webpack_require__(/*! ../../workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");
/* harmony import */ var _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_16__ = __webpack_require__(/*! ../../../components/wm-assign-list/wm-assign-list.component */ "./src/app/components/wm-assign-list/wm-assign-list.component.ts");






















function EditTestthreeTaskComponent_div_10_Template(rf, ctx) { if (rf & 1) {
    const _r127 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "app-wm-assign-list", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onSelectedAssignChanged", function EditTestthreeTaskComponent_div_10_Template_app_wm_assign_list_onSelectedAssignChanged_5_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r127); const ctx_r126 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r126.onUsersSelected($event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "async");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](7, "async");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r121 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    var tmp_1_0 = null;
    const currVal_1 = (tmp_1_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 6, ctx_r121.generalDataObs)) == null ? null : tmp_1_0.company.users;
    var tmp_2_0 = null;
    const currVal_2 = (tmp_2_0 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](7, 8, ctx_r121.generalDataObs)) == null ? null : tmp_2_0.company.departments;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 4, "workflow-assignto"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("users", currVal_1)("departments", currVal_2)("assignedUsers", ctx_r121.assignedUsers);
} }
function EditTestthreeTaskComponent_button_27_Template(rf, ctx) { if (rf & 1) {
    const _r129 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditTestthreeTaskComponent_button_27_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r129); const ctx_r128 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r128.save(false); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r122 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r122.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.save"));
} }
function EditTestthreeTaskComponent_button_28_Template(rf, ctx) { if (rf & 1) {
    const _r131 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditTestthreeTaskComponent_button_28_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r131); const ctx_r130 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r130.save(true); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r123 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r123.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "common.savedone"));
} }
function EditTestthreeTaskComponent_button_29_Template(rf, ctx) { if (rf & 1) {
    const _r133 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function EditTestthreeTaskComponent_button_29_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r133); const ctx_r132 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r132.archive(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "span");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](3, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "save");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r124 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("disabled", ctx_r124.workflowEditForm.invalid);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](3, 2, "workflow-archive"));
} }
function EditTestthreeTaskComponent_span_30_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "span", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r125 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r125.saveMessage);
} }
const _c0 = function () { return ["/workflow/list"]; };
class EditTestthreeTaskComponent {
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
        this.workflowSaveRequest = new _wf_models_workflow_save_request__WEBPACK_IMPORTED_MODULE_6__["WorkflowSaveRequest"]();
        this.viewWorkflowModel = null;
        this.generalDataObs = null;
        this.uploadedFiles = [];
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
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
        var ss = Object(_helper__WEBPACK_IMPORTED_MODULE_7__["formatDate"])(new Date(), 'dd.mm.yyyy');
        ss += " -- " + Object(_helper__WEBPACK_IMPORTED_MODULE_7__["parseDate"])(ss, 'dd.mm.yyyy');
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
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
            controllerIdentity: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_2__["Validators"].required],
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
        this.workflowSaveRequest.uploadedFiles = _wf_models__WEBPACK_IMPORTED_MODULE_5__["WorkflowUploadedFile"].loadUploadedFiles(this.uploadedFiles);
    }
    get forms() { return this.workflowEditForm.controls; }
    get hasNoAssigns() {
        if (this.workflowSaveRequest && this.workflowSaveRequest.assigns) {
            return this.workflowSaveRequest.assigns.length == 0;
        }
        return false;
    }
    save(makeDone) {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        if (makeDone) {
            this.doneWorkflowData();
        }
        else {
            this.saveWorkflowData();
        }
    }
    archive() {
        this.setFormControlValues();
        //return;
        this.loadingService.showLoading();
        this.archiveWorkflowData();
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
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_5__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
    }
    onUploadedFilesChanged(uploadedFileList) {
        this.uploadedFiles = uploadedFileList;
    }
}
EditTestthreeTaskComponent.ɵfac = function EditTestthreeTaskComponent_Factory(t) { return new (t || EditTestthreeTaskComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_8__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["TestthreetaskWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_12__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"])); };
EditTestthreeTaskComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: EditTestthreeTaskComponent, selectors: [["app-edit-testthree-task"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_7__["GermanDateAdapter"] }, _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["TestthreetaskWorkflowEditService"]])], decls: 36, vars: 23, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-link", 3, "routerLink"], [1, "material-icons"], ["id", "workflow-form", "name", "workflowForm", 3, "formGroup"], [1, "workflow-content"], ["class", "item-row", 4, "ngIf"], [1, "item-row"], [1, "item-label"], [1, "item-content"], ["formControlName", "comments", 1, "wm-comments-textarea"], [1, "clear"], [3, "ocrScanningEnabled", "editService", "showHeaderTitle", "drawBorder", "onUploadedFilesChanged"], [1, "workflow-step-button-bar"], ["type", "button", "class", "button-bar-button step-button button-save", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-done", 3, "disabled", "click", 4, "ngIf"], ["type", "button", "class", "button-bar-button step-button button-archive", 3, "disabled", "click", 4, "ngIf"], ["class", "alert alert-success button-bar-alert", 4, "ngIf"], [1, "item-row", 3, "innerHTML"], [1, "workflow-record"], [3, "workflow"], [3, "users", "departments", "assignedUsers", "onSelectedAssignChanged"], ["type", "button", 1, "button-bar-button", "step-button", "button-save", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-done", 3, "disabled", "click"], ["type", "button", 1, "button-bar-button", "step-button", "button-archive", 3, "disabled", "click"], [1, "alert", "alert-success", "button-bar-alert"]], template: function EditTestthreeTaskComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "a", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "list");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "form", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, EditTestthreeTaskComponent_div_10_Template, 9, 10, "div", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](14, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "textarea", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](17, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](21, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](22, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](23, "app-wm-file-upload", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("onUploadedFilesChanged", function EditTestthreeTaskComponent_Template_app_wm_file_upload_onUploadedFilesChanged_23_listener($event) { return ctx.onUploadedFilesChanged($event); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](24, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](26, "div", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](27, EditTestthreeTaskComponent_button_27_Template, 6, 4, "button", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](28, EditTestthreeTaskComponent_button_28_Template, 6, 4, "button", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](29, EditTestthreeTaskComponent_button_29_Template, 6, 4, "button", 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](30, EditTestthreeTaskComponent_span_30_Template, 2, 1, "span", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](31, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](32, "div", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](33, "div", 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](34, "app-workflow-inlineview", 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](35, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 16, "workflow-editing"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](22, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("formGroup", ctx.workflowEditForm);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canAssign);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](14, 18, "workflow-comments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](21, 20, "common.attachments"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ocrScanningEnabled", false)("editService", ctx.editService)("showHeaderTitle", false)("drawBorder", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canSave);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canDone);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.canArchive);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.saveMessage !== "");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("innerHTML", ctx.debugData, _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeHtml"]);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("workflow", ctx.viewWorkflowModel);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["ɵangular_packages_forms_forms_y"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatusGroup"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormGroupDirective"], _angular_common__WEBPACK_IMPORTED_MODULE_13__["NgIf"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormControlName"], _components_wm_file_upload_wm_file_upload_component__WEBPACK_IMPORTED_MODULE_14__["WmFileUploadComponent"], _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_15__["WorkflowInlineviewComponent"], _components_wm_assign_list_wm_assign_list_component__WEBPACK_IMPORTED_MODULE_16__["WmAssignListComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslatePipe"], _angular_common__WEBPACK_IMPORTED_MODULE_13__["AsyncPipe"]], styles: ["div.workflow-content-container[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    margin: 10px 0px;\r\n    border-radius: 10px;\r\n    padding: 10px;\r\n    background-color: #f1f1f1;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 15px;\r\n    border-radius: 5px;\r\n    width: calc(100% - 310px);\r\n    float: left;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-record[_ngcontent-%COMP%]{\r\n    background-color: #dad9d9;\r\n    padding: 10px;\r\n    border-radius: 5px;\r\n    width: 300px;\r\n    float: right;\r\n    height: 530px;\r\n}\r\n\r\ndiv.workflow-content-record[_ngcontent-%COMP%]{\r\n    padding: 15px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%] {\r\n    margin: 5px 0 10px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.workflow-step-button-bar[_ngcontent-%COMP%]{\r\n    margin-right: 20px;\r\n    background-color: white;\r\n    padding: 6px;\r\n    margin-left: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-label[_ngcontent-%COMP%]{\r\n    float: left;\r\n    padding-right: 10px;\r\n    padding-left: 2px;\r\n    line-height: 20px;\r\n    font-size: 14px;\r\n    font-weight: bold;\r\n    width: 130px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%] {\r\n    float: left;\r\n    \r\n    padding-left: 0px;\r\n    width: calc(100% - 135px);\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%]:not(.file-item), div.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input[_ngcontent-%COMP%], div.workflow-content-record[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   select[_ngcontent-%COMP%]\r\n{\r\n    width: 100%;\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-title[_ngcontent-%COMP%]\r\n{\r\n    width: calc(50% - 170px);\r\n    height: 26px;\r\n}\r\n\r\ndiv.workflow-content[_ngcontent-%COMP%]   div.item-row[_ngcontent-%COMP%]   div.item-content[_ngcontent-%COMP%]   input.file-file[_ngcontent-%COMP%]\r\n{\r\n    width: 50%;\r\n    height: 26px;\r\n    display: inline-block;;\r\n}\r\n\r\n.assign-list[_ngcontent-%COMP%]{\r\n\tborder: 1px solid lightgray;\r\n    padding: 6px;\r\n    border-radius: 4px;\r\n    width: 100%;\r\n    min-height: 100px;\r\n    max-height: 200px;\r\n    overflow-y: auto;\r\n    padding-right: 24px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%] {\r\n    border: 1px solid lightgray;\r\n    border-radius: 4px;\r\n    padding: 2px 4px;\r\n    float: left;\r\n    background: #e6e6e6;\r\n    margin-right: 5px;\r\n    margin-bottom: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background: transparent;\r\n    padding: 0;\r\n    padding-top: 3px;\r\n    float: right;\r\n    margin-left: 5px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   button[_ngcontent-%COMP%]   i.material-icons[_ngcontent-%COMP%]{\r\n\tfont-size: 16px;\r\n}\r\n\r\ndiv.assign-list[_ngcontent-%COMP%]   div.user-item-box[_ngcontent-%COMP%]   span[_ngcontent-%COMP%] {\r\n    height: 20px;\r\n    display: inline-block;\r\n    float: left;\r\n}\r\n\r\nbutton.show-select-dialog[_ngcontent-%COMP%] {\r\n    float: right;\r\n    margin-right: -20px;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    background-color: transparent;\r\n}\r\n\r\nbutton.file-action[_ngcontent-%COMP%] {\r\n    float: right;\r\n    width: 22px;\r\n    border: none;\r\n    padding: 0;\r\n    padding-left: 2px;\r\n    margin-top: 4px;\r\n    background: transparent;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9lZGl0L2VkaXQtdGVzdHRocmVlLXRhc2svZWRpdC10ZXN0dGhyZWUtdGFzay5jb21wb25lbnQuY3NzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiI7QUFDQTtDQUNDLDJCQUEyQjtJQUN4QixnQkFBZ0I7SUFDaEIsbUJBQW1CO0lBQ25CLGFBQWE7SUFDYix5QkFBeUI7QUFDN0I7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQix5QkFBeUI7SUFDekIsV0FBVztJQUNYLGFBQWE7QUFDakI7O0FBRUE7SUFDSSx5QkFBeUI7SUFDekIsYUFBYTtJQUNiLGtCQUFrQjtJQUNsQixZQUFZO0lBQ1osWUFBWTtJQUNaLGFBQWE7QUFDakI7O0FBRUE7SUFDSSxhQUFhO0FBQ2pCOztBQUVBO0lBQ0ksa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksa0JBQWtCO0lBQ2xCLHVCQUF1QjtJQUN2QixZQUFZO0lBQ1osa0JBQWtCO0FBQ3RCOztBQUVBO0lBQ0ksV0FBVztJQUNYLG1CQUFtQjtJQUNuQixpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGVBQWU7SUFDZixpQkFBaUI7SUFDakIsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7O0lBRVgsaUJBQWlCO0lBQ2pCLHlCQUF5QjtBQUM3Qjs7QUFFQTs7Ozs7SUFLSSxXQUFXO0lBQ1gsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSx3QkFBd0I7SUFDeEIsWUFBWTtBQUNoQjs7QUFFQTs7SUFFSSxVQUFVO0lBQ1YsWUFBWTtJQUNaLHFCQUFxQjtBQUN6Qjs7QUFFQTtDQUNDLDJCQUEyQjtJQUN4QixZQUFZO0lBQ1osa0JBQWtCO0lBQ2xCLFdBQVc7SUFDWCxpQkFBaUI7SUFDakIsaUJBQWlCO0lBQ2pCLGdCQUFnQjtJQUNoQixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSwyQkFBMkI7SUFDM0Isa0JBQWtCO0lBQ2xCLGdCQUFnQjtJQUNoQixXQUFXO0lBQ1gsbUJBQW1CO0lBQ25CLGlCQUFpQjtJQUNqQixrQkFBa0I7QUFDdEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osdUJBQXVCO0lBQ3ZCLFVBQVU7SUFDVixnQkFBZ0I7SUFDaEIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1oscUJBQXFCO0lBQ3JCLFdBQVc7QUFDZjs7QUFFQTtJQUNJLFlBQVk7SUFDWixtQkFBbUI7SUFDbkIsV0FBVztJQUNYLFlBQVk7SUFDWixVQUFVO0lBQ1YsaUJBQWlCO0lBQ2pCLDZCQUE2QjtBQUNqQzs7QUFFQTtJQUNJLFlBQVk7SUFDWixXQUFXO0lBQ1gsWUFBWTtJQUNaLFVBQVU7SUFDVixpQkFBaUI7SUFDakIsZUFBZTtJQUNmLHVCQUF1QjtBQUMzQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvZWRpdC9lZGl0LXRlc3R0aHJlZS10YXNrL2VkaXQtdGVzdHRocmVlLXRhc2suY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG5kaXYud29ya2Zsb3ctY29udGVudC1jb250YWluZXJ7XHJcblx0Ym9yZGVyOiAxcHggc29saWQgbGlnaHRncmF5O1xyXG4gICAgbWFyZ2luOiAxMHB4IDBweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDEwcHg7XHJcbiAgICBwYWRkaW5nOiAxMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogI2YxZjFmMTtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnR7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogMTVweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxuICAgIHdpZHRoOiBjYWxjKDEwMCUgLSAzMTBweCk7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGhlaWdodDogNTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1yZWNvcmR7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjZGFkOWQ5O1xyXG4gICAgcGFkZGluZzogMTBweDtcclxuICAgIGJvcmRlci1yYWRpdXM6IDVweDtcclxuICAgIHdpZHRoOiAzMDBweDtcclxuICAgIGZsb2F0OiByaWdodDtcclxuICAgIGhlaWdodDogNTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZHtcclxuICAgIHBhZGRpbmc6IDE1cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdywgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyB7XHJcbiAgICBtYXJnaW46IDVweCAwIDEwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi53b3JrZmxvdy1zdGVwLWJ1dHRvbi1iYXIsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYud29ya2Zsb3ctc3RlcC1idXR0b24tYmFye1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAyMHB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBtYXJnaW4tbGVmdDogMTMwcHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbCwgZGl2LndvcmtmbG93LWNvbnRlbnQtcmVjb3JkIGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1sYWJlbHtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgcGFkZGluZy1yaWdodDogMTBweDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgbGluZS1oZWlnaHQ6IDIwcHg7XHJcbiAgICBmb250LXNpemU6IDE0cHg7XHJcbiAgICBmb250LXdlaWdodDogYm9sZDtcclxuICAgIHdpZHRoOiAxMzBweDtcclxufVxyXG5cclxuZGl2LndvcmtmbG93LWNvbnRlbnQgZGl2Lml0ZW0tcm93IGRpdi5pdGVtLWNvbnRlbnQsIGRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCB7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIFxyXG4gICAgcGFkZGluZy1sZWZ0OiAwcHg7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMTM1cHgpO1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dDpub3QoLmZpbGUtaXRlbSksIFxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3QsXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dCwgXHJcbmRpdi53b3JrZmxvdy1jb250ZW50LXJlY29yZCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBzZWxlY3Rcclxue1xyXG4gICAgd2lkdGg6IDEwMCU7XHJcbiAgICBoZWlnaHQ6IDI2cHg7XHJcbn1cclxuXHJcbmRpdi53b3JrZmxvdy1jb250ZW50IGRpdi5pdGVtLXJvdyBkaXYuaXRlbS1jb250ZW50IGlucHV0LmZpbGUtdGl0bGVcclxue1xyXG4gICAgd2lkdGg6IGNhbGMoNTAlIC0gMTcwcHgpO1xyXG4gICAgaGVpZ2h0OiAyNnB4O1xyXG59XHJcblxyXG5kaXYud29ya2Zsb3ctY29udGVudCBkaXYuaXRlbS1yb3cgZGl2Lml0ZW0tY29udGVudCBpbnB1dC5maWxlLWZpbGVcclxue1xyXG4gICAgd2lkdGg6IDUwJTtcclxuICAgIGhlaWdodDogMjZweDtcclxuICAgIGRpc3BsYXk6IGlubGluZS1ibG9jazs7XHJcbn1cclxuXHJcbi5hc3NpZ24tbGlzdHtcclxuXHRib3JkZXI6IDFweCBzb2xpZCBsaWdodGdyYXk7XHJcbiAgICBwYWRkaW5nOiA2cHg7XHJcbiAgICBib3JkZXItcmFkaXVzOiA0cHg7XHJcbiAgICB3aWR0aDogMTAwJTtcclxuICAgIG1pbi1oZWlnaHQ6IDEwMHB4O1xyXG4gICAgbWF4LWhlaWdodDogMjAwcHg7XHJcbiAgICBvdmVyZmxvdy15OiBhdXRvO1xyXG4gICAgcGFkZGluZy1yaWdodDogMjRweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGxpZ2h0Z3JheTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDRweDtcclxuICAgIHBhZGRpbmc6IDJweCA0cHg7XHJcbiAgICBmbG9hdDogbGVmdDtcclxuICAgIGJhY2tncm91bmQ6ICNlNmU2ZTY7XHJcbiAgICBtYXJnaW4tcmlnaHQ6IDVweDtcclxuICAgIG1hcmdpbi1ib3R0b206IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiB7XHJcbiAgICBib3JkZXI6IG5vbmU7XHJcbiAgICBiYWNrZ3JvdW5kOiB0cmFuc3BhcmVudDtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLXRvcDogM3B4O1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLWxlZnQ6IDVweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IGJ1dHRvbiBpLm1hdGVyaWFsLWljb25ze1xyXG5cdGZvbnQtc2l6ZTogMTZweDtcclxufVxyXG5cclxuZGl2LmFzc2lnbi1saXN0IGRpdi51c2VyLWl0ZW0tYm94IHNwYW4ge1xyXG4gICAgaGVpZ2h0OiAyMHB4O1xyXG4gICAgZGlzcGxheTogaW5saW5lLWJsb2NrO1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5zaG93LXNlbGVjdC1kaWFsb2cge1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgbWFyZ2luLXJpZ2h0OiAtMjBweDtcclxuICAgIHdpZHRoOiAyMnB4O1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgcGFkZGluZzogMDtcclxuICAgIHBhZGRpbmctbGVmdDogMnB4O1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbn1cclxuXHJcbmJ1dHRvbi5maWxlLWFjdGlvbiB7XHJcbiAgICBmbG9hdDogcmlnaHQ7XHJcbiAgICB3aWR0aDogMjJweDtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIHBhZGRpbmc6IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDJweDtcclxuICAgIG1hcmdpbi10b3A6IDRweDtcclxuICAgIGJhY2tncm91bmQ6IHRyYW5zcGFyZW50O1xyXG59XHJcbiJdfQ== */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](EditTestthreeTaskComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-edit-testthree-task',
                templateUrl: './edit-testthree-task.component.html',
                styleUrls: ['./edit-testthree-task.component.css'],
                providers: [{ provide: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"], useClass: _helper__WEBPACK_IMPORTED_MODULE_7__["GermanDateAdapter"] }, _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["TestthreetaskWorkflowEditService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_8__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_9__["TranslateService"] }, { type: _services_workflow_testthreetask_testthreetask_workflow_edit_service__WEBPACK_IMPORTED_MODULE_4__["TestthreetaskWorkflowEditService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"] }, { type: _angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_12__["ErrorServiceService"] }, { type: _angular_forms__WEBPACK_IMPORTED_MODULE_2__["FormBuilder"] }, { type: _angular_material_core__WEBPACK_IMPORTED_MODULE_3__["DateAdapter"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }]; }, null); })();


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
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _wf_models_invoice_workflow_save_request__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../wf-models/invoice-workflow-save-request */ "./src/app/wf-models/invoice-workflow-save-request.ts");
/* harmony import */ var _custom_validators_invoice_type_controll_validator__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../custom-validators/invoice-type-controll-validator */ "./src/app/custom-validators/invoice-type-controll-validator.ts");
/* harmony import */ var _helper__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../helper */ "./src/app/helper/index.ts");
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! ../services/workflow/invoice/invoice-workflow-edit.service */ "./src/app/services/workflow/invoice/invoice-workflow-edit.service.ts");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! ../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _angular_common_http__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! @angular/common/http */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/http.js");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_12__ = __webpack_require__(/*! ../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_material_core__WEBPACK_IMPORTED_MODULE_13__ = __webpack_require__(/*! @angular/material/core */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/core.js");















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
        this.workflowSaveRequest = new _wf_models_invoice_workflow_save_request__WEBPACK_IMPORTED_MODULE_2__["InvoiceWorkflowSaveRequest"]();
        this.generalDataObs = null;
        this.fileTitles = [];
        this.selectAssign = [];
        this.invoiceTypes = [];
        this.dateAdapter.setLocale('de');
        for (var o in _wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"]) {
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
            this.invoiceEditForm.controls["discountDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_4__["formatDate"])(date, 'dd.mm.yyyy'));
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
            expireDays: [10, _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            comments: [''],
            sender: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            registerNumber: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            invocieDate: [new Date(), _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            partnerCode: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            vendorNumber: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            vendorName: ['', _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            isDirectDebitPermission: [false],
            invoiceType: [_wf_models__WEBPACK_IMPORTED_MODULE_1__["InvoiceType"].NO_TYPE, [_custom_validators_invoice_type_controll_validator__WEBPACK_IMPORTED_MODULE_3__["InvoiceTypeControllValidator"]]],
            discountEnterDate: [new Date(), _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            discountDeadline: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            discountRate: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            discountDate: ["", _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
            paymentAmount: [0, _angular_forms__WEBPACK_IMPORTED_MODULE_0__["Validators"].required],
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
            this.invoiceEditForm.controls["comments"].setValue(this.workflowSaveRequest.workflow.comments);
            this.invoiceEditForm.controls["sender"].setValue(this.workflowSaveRequest.workflow.sender);
            this.invoiceEditForm.controls["registerNumber"].setValue(this.workflowSaveRequest.workflow.registerNumber);
            this.invoiceEditForm.controls["invocieDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_4__["parseDate"])(this.workflowSaveRequest.workflow.invocieDate, 'dd.mm.yyyy'));
            this.invoiceEditForm.controls["partnerCode"].setValue(this.workflowSaveRequest.workflow.partnerCode);
            this.invoiceEditForm.controls["vendorNumber"].setValue(this.workflowSaveRequest.workflow.vendorNumber);
            this.invoiceEditForm.controls["vendorName"].setValue(this.workflowSaveRequest.workflow.vendorName);
            this.invoiceEditForm.controls["isDirectDebitPermission"].setValue(this.workflowSaveRequest.workflow.isDirectDebitPermission);
            this.invoiceEditForm.controls["invoiceType"].setValue(this.workflowSaveRequest.workflow.invoiceType);
            this.invoiceEditForm.controls["discountEnterDate"].setValue(Object(_helper__WEBPACK_IMPORTED_MODULE_4__["parseDate"])(this.workflowSaveRequest.workflow.discountEnterDate, 'dd.mm.yyyy'));
            this.invoiceEditForm.controls["discountDeadline"].setValue(this.workflowSaveRequest.workflow.discountDeadline);
            this.invoiceEditForm.controls["discountRate"].setValue(this.workflowSaveRequest.workflow.discountRate);
            this.invoiceEditForm.controls["discountDate"].setValue(this.workflowSaveRequest.workflow.discountDate);
            this.invoiceEditForm.controls["paymentAmount"].setValue(this.workflowSaveRequest.workflow.paymentAmount);
        }
    }
    setFormControlValues() {
        this.workflowSaveRequest.expireDays = this.invoiceEditForm.controls["expireDays"].value;
        this.workflowSaveRequest.workflow.comments = this.invoiceEditForm.controls["comments"].value;
        this.workflowSaveRequest.workflow.sender = this.invoiceEditForm.controls["sender"].value;
        this.workflowSaveRequest.workflow.registerNumber = this.invoiceEditForm.controls["registerNumber"].value;
        this.workflowSaveRequest.workflow.invocieDate = Object(_helper__WEBPACK_IMPORTED_MODULE_4__["formatDate"])(this.invoiceEditForm.controls["invocieDate"].value, 'dd.mm.yyyy');
        this.workflowSaveRequest.workflow.partnerCode = this.invoiceEditForm.controls["partnerCode"].value;
        this.workflowSaveRequest.workflow.vendorNumber = this.invoiceEditForm.controls["vendorNumber"].value;
        this.workflowSaveRequest.workflow.vendorName = this.invoiceEditForm.controls["vendorName"].value;
        this.workflowSaveRequest.workflow.isDirectDebitPermission = this.invoiceEditForm.controls["isDirectDebitPermission"].value;
        this.workflowSaveRequest.workflow.invoiceType = this.invoiceEditForm.controls["invoiceType"].value;
        this.workflowSaveRequest.workflow.discountEnterDate = Object(_helper__WEBPACK_IMPORTED_MODULE_4__["formatDate"])(this.invoiceEditForm.controls["discountEnterDate"].value, 'dd.mm.yyyy');
        this.workflowSaveRequest.workflow.discountDeadline = this.invoiceEditForm.controls["discountDeadline"].value;
        this.workflowSaveRequest.workflow.discountRate = this.invoiceEditForm.controls["discountRate"].value;
        this.workflowSaveRequest.workflow.discountDate = this.invoiceEditForm.controls["discountDate"].value;
        this.workflowSaveRequest.workflow.paymentAmount = this.invoiceEditForm.controls["paymentAmount"].value;
    }
    get forms() { return this.invoiceEditForm.controls; }
    onUsersSelected(assigns) {
        this.workflowSaveRequest.assigns = [];
        for (var item in assigns) {
            var assign = new _wf_models__WEBPACK_IMPORTED_MODULE_1__["AssignItem"];
            assign.itemIdentity = assigns[item].itemIdentity;
            assign.itemType = assigns[item].itemType;
            this.workflowSaveRequest.assigns.push(assign);
        }
    }
}
InvoiceBaseComponent.ɵfac = function InvoiceBaseComponent_Factory(t) { return new (t || InvoiceBaseComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_6__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_7__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_8__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_services_workflow_invoice_invoice_workflow_edit_service__WEBPACK_IMPORTED_MODULE_9__["InvoiceWorkflowEditService"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_10__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_common_http__WEBPACK_IMPORTED_MODULE_11__["HttpClient"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_12__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_forms__WEBPACK_IMPORTED_MODULE_0__["FormBuilder"]), _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdirectiveInject"](_angular_material_core__WEBPACK_IMPORTED_MODULE_13__["DateAdapter"])); };
InvoiceBaseComponent.ɵdir = _angular_core__WEBPACK_IMPORTED_MODULE_5__["ɵɵdefineDirective"]({ type: InvoiceBaseComponent });


/***/ }),

/***/ "./src/app/wm-components/invoice-ocr-detail/invoice-ocr-detail.component.ts":
/*!**********************************************************************************!*\
  !*** ./src/app/wm-components/invoice-ocr-detail/invoice-ocr-detail.component.ts ***!
  \**********************************************************************************/
/*! exports provided: InvoiceOcrDetailComponent */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
__webpack_require__.r(__webpack_exports__);
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "InvoiceOcrDetailComponent", function() { return InvoiceOcrDetailComponent; });
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! jquery */ "./node_modules/jquery/dist/jquery.js");
/* harmony import */ var jquery__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(jquery__WEBPACK_IMPORTED_MODULE_1__);
/* harmony import */ var _ui_models__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../ui-models */ "./src/app/ui-models/index.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ng2-pdf-viewer */ "./node_modules/ng2-pdf-viewer/__ivy_ngcc__/fesm2015/ng2-pdf-viewer.js");








const _c0 = ["scannedItemPreviewContainer"];
function InvoiceOcrDetailComponent_div_6_button_5_Template(rf, ctx) { if (rf & 1) {
    const _r200 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function InvoiceOcrDetailComponent_div_6_button_5_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r200); const key_r195 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit; const ctx_r198 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r198.startEditKey(key_r195); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "edit");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function InvoiceOcrDetailComponent_div_6_button_6_Template(rf, ctx) { if (rf & 1) {
    const _r202 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 21);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function InvoiceOcrDetailComponent_div_6_button_6_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r202); const key_r195 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit; const ctx_r201 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return (ctx_r201.isEditing[key_r195] = false); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 20);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "done");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
const _c1 = function (a0) { return { "active": a0 }; };
function InvoiceOcrDetailComponent_div_6_Template(rf, ctx) { if (rf & 1) {
    const _r205 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function InvoiceOcrDetailComponent_div_6_Template_a_click_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r205); const key_r195 = ctx.$implicit; const ctx_r204 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r204.selectDetailItem(key_r195); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 14);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "input", 15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("blur", function InvoiceOcrDetailComponent_div_6_Template_input_blur_4_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r205); const key_r195 = ctx.$implicit; const ctx_r206 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return (ctx_r206.isEditing[key_r195] = false); })("keyup.enter", function InvoiceOcrDetailComponent_div_6_Template_input_keyup_enter_4_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r205); const key_r195 = ctx.$implicit; const ctx_r207 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return (ctx_r207.isEditing[key_r195] = false); })("ngModelChange", function InvoiceOcrDetailComponent_div_6_Template_input_ngModelChange_4_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r205); const key_r195 = ctx.$implicit; const ctx_r208 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return (ctx_r208.editedValues[key_r195] = $event); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](5, InvoiceOcrDetailComponent_div_6_button_5_Template, 3, 0, "button", 16);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, InvoiceOcrDetailComponent_div_6_button_6_Template, 3, 0, "button", 17);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](7, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](8, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const key_r195 = ctx.$implicit;
    const ctx_r189 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](9, _c1, ctx_r189.selectedKey === key_r195));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](11, _c1, ctx_r189.selectedKey === key_r195));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r189.propertyLabels[key_r195]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](13, _c1, ctx_r189.selectedKey === key_r195));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("id", "valueeditbox", key_r195, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngModel", ctx_r189.editedValues[key_r195])("readonly", ctx_r189.isEditing[key_r195] === false);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r189.isEditing[key_r195] === false);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r189.isEditing[key_r195] === true);
} }
function InvoiceOcrDetailComponent_div_10_div_4_Template(rf, ctx) { if (rf & 1) {
    const _r213 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 24);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "a", 25);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function InvoiceOcrDetailComponent_div_10_div_4_Template_a_click_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r213); const foundWord_r211 = ctx.$implicit; const ctx_r212 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r212.selectFoundWord(foundWord_r211); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "button", 26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function InvoiceOcrDetailComponent_div_10_div_4_Template_button_click_3_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r213); const foundWord_r211 = ctx.$implicit; const ctx_r214 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r214.useFoundWord(foundWord_r211); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "i", 27);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5, "arrow_back_ios");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](6, "div", 18);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const foundWord_r211 = ctx.$implicit;
    const ctx_r210 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](3, _c1, ctx_r210.isWordSelected(foundWord_r211)));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate2"]("", foundWord_r211.text, " : ", foundWord_r211.value.text, "");
} }
const _c2 = function (a0) { return { "show": a0 }; };
function InvoiceOcrDetailComponent_div_10_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "h3");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](4, InvoiceOcrDetailComponent_div_10_div_4_Template, 7, 5, "div", 23);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const wordKey_r209 = ctx.$implicit;
    const ctx_r190 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngClass", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction1"](3, _c2, ctx_r190.selectedKey === wordKey_r209));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r190.propertyLabels[wordKey_r209]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r190.foundWords[wordKey_r209]);
} }
function InvoiceOcrDetailComponent_pdf_viewer_13_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "pdf-viewer", 28);
} if (rf & 2) {
    const ctx_r192 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("src", ctx_r192.fileViewUrl)("zoom", ctx_r192.pdfZoom)("show-all", ctx_r192.showAllPages)("page", ctx_r192.pdfPageIndex);
} }
function InvoiceOcrDetailComponent_div_14_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "div", 29);
} if (rf & 2) {
    const ctx_r193 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleSanitizer"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefaultStyleSanitizer"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleProp"]("width", ctx_r193.previewWidth, "px")("background-image", ctx_r193.imageFileViewUrl);
} }
function InvoiceOcrDetailComponent_div_15_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "div", 30);
} if (rf & 2) {
    const ctx_r194 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵstyleProp"]("width", ctx_r194.selectedAreaWidth, "px")("height", ctx_r194.selectedAreaHeight, "px")("left", ctx_r194.selectedAreaLeft, "px")("top", ctx_r194.selectedAreaTop, "px");
} }
class InvoiceOcrDetailComponent {
    constructor(translate) {
        this.translate = translate;
        this._foundWords = [];
        this.propertyLabels = [];
        this.isEditing = [];
        this.selectedKey = "";
        this.selectedWord = null;
        this.showOcrDetails = false;
        this.scanedPdfPath = "";
        this.scanedHocrPath = "";
        this.fileIsPdf = true;
        this.fileIsImage = false;
        this.imageSizeX = 300;
        this.imageSizeY = 500;
        this.editedValues = [];
        this.onApplyValues = new _angular_core__WEBPACK_IMPORTED_MODULE_0__["EventEmitter"]();
        this.pdfZoom = 'page-fit';
        this.showAllPages = true;
        this.pdfPageIndex = 1;
        this.showSelectedArea = false;
        this.selectedAreaWidth = 200;
        this.selectedAreaHeight = 100;
        this.selectedAreaLeft = 400;
        this.selectedAreaTop = 200;
        this.previewWidth = 600;
        this.previewHeight = 1100;
        this.yScale = 1;
    }
    set foundWords(foundWordsInput) {
        this._foundWords = foundWordsInput;
        this.propertyLabels = [];
        if (this._foundWords) {
            for (var key in this._foundWords) {
                this.translate.get(key).subscribe((res) => {
                    this.propertyLabels[key] = res;
                    this.isEditing[key] = false;
                    this.editedValues[key] = "";
                });
            }
        }
    }
    get foundWords() {
        return this._foundWords;
    }
    get keys() {
        return Object.keys(this._foundWords);
    }
    get imageFileViewUrl() {
        return 'url(/general/data/file/view/' + this.scanedPdfPath + ')';
        //return 'url()';
    }
    get fileViewUrl() {
        return '/general/data/file/view/' + this.scanedPdfPath;
        //return 'url()';
    }
    isWordSelected(foundWord) {
        if (this.selectedWord != null && foundWord != null && this.selectedWord.id === foundWord.id) {
            return true;
        }
        return false;
    }
    get debugData() {
        return this.editedValues;
    }
    ngOnInit() {
    }
    ngAfterViewInit() {
        this.yScale = this.previewWidth / this.imageSizeX;
        this.previewHeight = this.yScale * this.imageSizeY;
        setTimeout(() => {
        }, 100);
    }
    selectFoundWord(foundWord) {
        this.selectedWord = foundWord;
        this.pdfPageIndex = foundWord.pageIndex + 1;
        var previewLeft = this.previewContainer.nativeElement.offsetLeft + 10;
        var previewTop = this.previewContainer.nativeElement.offsetTop + 10;
        var pdfPage = null;
        var pdfPageWidth = null;
        var pdfPageHeight = null;
        var xscale = (this.previewContainer.nativeElement.offsetWidth - 20) / this.imageSizeX;
        var yscale = (this.previewContainer.nativeElement.offsetHeight - 20) / this.imageSizeY;
        if (this.fileIsPdf) {
            pdfPage = jquery__WEBPACK_IMPORTED_MODULE_1___default()("div.scanned-item-preview-container div.page");
            if (pdfPage.length > foundWord.pageIndex) {
                pdfPage = pdfPage[foundWord.pageIndex];
                pdfPageWidth = pdfPage.offsetWidth;
                pdfPageHeight = pdfPage.offsetHeight;
                previewLeft += pdfPage.offsetLeft;
                //previewTop = pdfPage.offsetTop;
                xscale = pdfPageWidth / foundWord.pageWidth;
                yscale = pdfPageHeight / foundWord.pageHeight;
                var scalestr = "page scale    : " + xscale + " : " + yscale + "\n";
                scalestr += "page dimention: " + pdfPageWidth + " : " + pdfPageHeight + "\n";
                scalestr += "page position : " + previewLeft + " : " + previewTop + "\n";
                scalestr += "foundWord dim : " + foundWord.pageWidth + " : " + foundWord.pageHeight + "\n";
                console.log("pdfPage found:", pdfPage);
                console.log(scalestr);
            }
        }
        var wordBox = foundWord.box;
        var valueBox = foundWord.value.box;
        var selectBox = this.getSelectBox(foundWord);
        this.selectedAreaWidth = selectBox.width * xscale + 8;
        this.selectedAreaHeight = selectBox.height * yscale + 8;
        this.selectedAreaLeft = previewLeft + (selectBox.left * xscale) - 4;
        this.selectedAreaTop = previewTop + (selectBox.top * yscale) - 4;
        var scalestr = "scale         : " + xscale + " : " + yscale + "\n";
        scalestr += "wordBox       : " + wordBox.left + " : " + wordBox.top + " : " + wordBox.width + " : " + wordBox.height + "\n";
        scalestr += "valueBox      : " + valueBox.left + " : " + valueBox.top + " : " + valueBox.width + " : " + valueBox.height + " : " + foundWord.value.text + "\n";
        scalestr += "selectBox     : " + selectBox.left + " : " + selectBox.top + " : " + selectBox.width + " : " + selectBox.height + "\n";
        scalestr += "calc dimention: " + this.selectedAreaWidth + " : " + this.selectedAreaHeight + "\n";
        scalestr += "calc position : " + this.selectedAreaLeft + " : " + this.selectedAreaTop + "\n";
        console.log(scalestr);
        this.showSelectedArea = true;
    }
    selectDetailItem(key) {
        this.selectedKey = key;
        this.showSelectedArea = false;
    }
    getSelectBox(foundWord) {
        var wordBox = foundWord.box;
        var valueBox = foundWord.value.box;
        var box = new _ui_models__WEBPACK_IMPORTED_MODULE_2__["OcrBox"];
        box.width = Math.abs(valueBox.right - wordBox.left);
        box.height = Math.abs(valueBox.bottom - wordBox.top);
        box.left = Math.min(wordBox.left, valueBox.left);
        box.top = Math.min(wordBox.top, valueBox.top);
        box.right = box.left + box.width;
        box.bottom = box.top + box.height;
        return box;
    }
    startEditKey(key) {
        this.isEditing[key] = true;
        document.getElementById("valueeditbox" + key).focus();
    }
    useFoundWord(foundWord) {
        this.editedValues[this.selectedKey] = foundWord.value.text;
    }
}
InvoiceOcrDetailComponent.ɵfac = function InvoiceOcrDetailComponent_Factory(t) { return new (t || InvoiceOcrDetailComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"])); };
InvoiceOcrDetailComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: InvoiceOcrDetailComponent, selectors: [["app-invoice-ocr-detail"]], viewQuery: function InvoiceOcrDetailComponent_Query(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵviewQuery"](_c0, true);
    } if (rf & 2) {
        var _t;
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵqueryRefresh"](_t = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵloadQuery"]()) && (ctx.previewContainer = _t.first);
    } }, inputs: { showOcrDetails: "showOcrDetails", scanedPdfPath: "scanedPdfPath", scanedHocrPath: "scanedHocrPath", fileIsPdf: "fileIsPdf", fileIsImage: "fileIsImage", imageSizeX: "imageSizeX", imageSizeY: "imageSizeY", foundWords: "foundWords", editedValues: "editedValues" }, outputs: { onApplyValues: "onApplyValues" }, decls: 16, vars: 9, consts: [[1, "row", "scanned-result-container"], [1, "scanned-item-list-container"], ["id", "list-tab", "role", "tablist", 1, "list-group"], [1, "list-group-item", "disabled"], ["class", "list-group-item list-group-item-action", 3, "ngClass", 4, "ngFor", "ngForOf"], [1, "scanned-item-detail-container"], ["class", "tab-pane word-list-item fade", 3, "ngClass", 4, "ngFor", "ngForOf"], [1, "scanned-item-preview-container"], ["scannedItemPreviewContainer", ""], ["useBrowserLocale", "true", "height", "99%", 3, "src", "zoom", "show-all", "page", 4, "ngIf"], ["class", "scanned-item-preview-image", 3, "width", "backgroundImage", 4, "ngIf"], ["class", "selected-word-area", 3, "width", "height", "left", "top", 4, "ngIf"], [1, "list-group-item", "list-group-item-action", 3, "ngClass"], [1, "scanned-item", 3, "ngClass", "click"], [1, "item-value-container", 3, "ngClass"], ["type", "text", "autofocus", "", "value", "", 1, "item-value", 3, "ngModel", "id", "readonly", "blur", "keyup.enter", "ngModelChange"], ["class", "inline-edit-button-edit", 3, "click", 4, "ngIf"], ["class", "inline-edit-button-apply", 3, "click", 4, "ngIf"], [1, "clear"], [1, "inline-edit-button-edit", 3, "click"], [1, "material-icons", "edit-value-icon"], [1, "inline-edit-button-apply", 3, "click"], [1, "tab-pane", "word-list-item", "fade", 3, "ngClass"], ["class", "list-group-item list-group-item-action scanned-item-detail-item", 3, "ngClass", 4, "ngFor", "ngForOf"], [1, "list-group-item", "list-group-item-action", "scanned-item-detail-item", 3, "ngClass"], [1, "scanned-item", "found-item", 3, "click"], [1, "inline-edit-button-use", 3, "click"], [1, "material-icons"], ["useBrowserLocale", "true", "height", "99%", 3, "src", "zoom", "show-all", "page"], [1, "scanned-item-preview-image"], [1, "selected-word-area"]], template: function InvoiceOcrDetailComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](5, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](6, InvoiceOcrDetailComponent_div_6_Template, 9, 15, "div", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](10, InvoiceOcrDetailComponent_div_10_Template, 5, 5, "div", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 7, 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](13, InvoiceOcrDetailComponent_pdf_viewer_13_Template, 1, 4, "pdf-viewer", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](14, InvoiceOcrDetailComponent_div_14_Template, 1, 2, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](15, InvoiceOcrDetailComponent_div_15_Template, 1, 4, "div", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](5, 7, "invoice-scanned-properties"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.keys);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx.debugData);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.keys);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.fileIsPdf);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.fileIsImage);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showSelectedArea);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_4__["NgForOf"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_4__["NgClass"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["DefaultValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_5__["NgModel"], ng2_pdf_viewer__WEBPACK_IMPORTED_MODULE_6__["PdfViewerComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslatePipe"]], styles: [".scanned-result-container[_ngcontent-%COMP%]{\r\n\tbackground-color: white;\t\r\n\twidth: 100%;\r\n\tmargin: 0;\r\n}\r\n\r\n.scanned-item-container[_ngcontent-%COMP%]{\r\n\tbackground: #fff;\t\r\n}\r\n\r\n.scanned-item[_ngcontent-%COMP%]:not(:disabled){\r\n\tcursor: pointer;\r\n}\r\n\r\n.scanned-item-list-container[_ngcontent-%COMP%]   .scanned-item[_ngcontent-%COMP%]:not(:disabled){\r\n\twidth: calc(50% - 10px);\r\n\tfloat: left;\t\r\n\tborder: none;\r\n    border-radius: 0;\r\n    display: block;\r\n    color: #495057;\r\n    height: 28px;\r\n}\r\n\r\n.scanned-item-list-container[_ngcontent-%COMP%]   .scanned-item.active[_ngcontent-%COMP%]:not(:disabled){\r\n    color: #fff;\r\n}\r\n\r\n.item-value-container[_ngcontent-%COMP%]{\r\n\twidth: calc(50% + 8px);\r\n\tfloat: left;\r\n\tborder: none;\r\n    border-radius: 0;\r\n}\r\n\r\n.item-value[_ngcontent-%COMP%] {\r\n    border: 1px solid gray;\r\n    background: #ffffff;\r\n    box-shadow: none;\r\n    float: left;\r\n    width: 195px;\r\n}\r\n\r\n.item-value[_ngcontent-%COMP%]:-moz-read-only {\r\n    border-color: #bebebe;\r\n\tbackground: #eeeeee;\r\n}\r\n\r\n.item-value[_ngcontent-%COMP%]:read-only {\r\n    border-color: #bebebe;\r\n\tbackground: #eeeeee;\r\n}\r\n\r\n.edit-value-icon[_ngcontent-%COMP%]{\r\n\tfont-size: 18px; \r\n}\r\n\r\n.inline-edit-button-edit[_ngcontent-%COMP%], .inline-edit-button-apply[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background-color: transparent;\r\n    color: #5f5f5f;\r\n    padding: 0 3px;\r\n    padding-top: 3px;\r\n    height: 30px;\r\n    width: 24px;\r\n    float: left;\r\n}\r\n\r\n.inline-edit-button-apply[_ngcontent-%COMP%]   i[_ngcontent-%COMP%] {\r\n    color: #008200;\r\n}\r\n\r\n.scanned-item-list-container[_ngcontent-%COMP%], .scanned-item-detail-container[_ngcontent-%COMP%], .scanned-item-preview-container[_ngcontent-%COMP%] {\r\n\tpadding: 10px;\r\n\tmargin: 5px;\r\n\tborder-radius: 5px;\r\n\theight: 80vh;\r\n\toverflow-x: hidden;\r\n\toverflow-y: auto;\r\n\tbackground-color: #e0e0e0;\r\n}\r\n\r\n.scanned-item-list-container[_ngcontent-%COMP%] {\r\n\tmax-width: calc(50% - 325px);\r\n    -webkit-box-flex: 0;\r\n            flex: 0 0 calc(50% - 325px);\r\n}\r\n\r\n.scanned-item-detail-container[_ngcontent-%COMP%] {\r\n\tmax-width: calc(50% - 325px);\r\n    -webkit-box-flex: 0;\r\n            flex: 0 0 calc(50% - 325px);\r\n}\r\n\r\n.scanned-item-preview-container[_ngcontent-%COMP%] {\r\n\tmax-width: 620px;\r\n\t-webkit-box-flex: 0;\r\n\t        flex: 0 0 620px;\r\n}\r\n\r\n.found-item[_ngcontent-%COMP%] {\r\n    \r\n}\r\n\r\n.word-list-item.fade[_ngcontent-%COMP%]:not(.show) {\r\n    display: none;\r\n}\r\n\r\n.scanned-item-preview-image[_ngcontent-%COMP%]{\r\n\tbackground-color: white;\r\n\tbackground-image: none;\r\n\tbackground-position: 0 0;\r\n\tbackground-repeat: no-repeat;\r\n\tbackground-size: 100% 100%;\r\n\twidth: 100%;\r\n\theight: 100%;\r\n\t\r\n}\r\n\r\n.selected-word-area[_ngcontent-%COMP%]{\r\n\tposition: absolute;\r\n\tbackground-color: #add5ef3d;\r\n\tborder: 1px dashed #5873bae0;\t\r\n\twidth: 300px;\r\n\theight: 100px;\r\n}\r\n\r\n.scanned-item-detail-container[_ngcontent-%COMP%]   .scanned-item[_ngcontent-%COMP%]:not(:disabled){\r\n\twidth: calc(100% - 40px);\r\n\tfloat: left;\t\r\n}\r\n\r\n.edit-value-icon[_ngcontent-%COMP%]{\r\n\tfont-size: 18px; \r\n}\r\n\r\n.inline-edit-button-use[_ngcontent-%COMP%] {\r\n    border: none;\r\n    background-color: transparent;\r\n    color: #5f5f5f;\r\n    padding: 0 3px;\r\n    padding-top: 3px;\r\n    height: 30px;\r\n    width: 24px;\r\n    float: left;\r\n    width: 24px;\r\n    float: right;\r\n}\r\n\r\n.inline-edit-button-use[_ngcontent-%COMP%]   i[_ngcontent-%COMP%] {\r\n\tfont-size: 30px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy9pbnZvaWNlLW9jci1kZXRhaWwvaW52b2ljZS1vY3ItZGV0YWlsLmNvbXBvbmVudC5jc3MiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUNBO0NBQ0MsdUJBQXVCO0NBQ3ZCLFdBQVc7Q0FDWCxTQUFTO0FBQ1Y7O0FBRUE7Q0FDQyxnQkFBZ0I7QUFDakI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0NBQ0MsdUJBQXVCO0NBQ3ZCLFdBQVc7Q0FDWCxZQUFZO0lBQ1QsZ0JBQWdCO0lBQ2hCLGNBQWM7SUFDZCxjQUFjO0lBQ2QsWUFBWTtBQUNoQjs7QUFFQTtJQUNJLFdBQVc7QUFDZjs7QUFFQTtDQUNDLHNCQUFzQjtDQUN0QixXQUFXO0NBQ1gsWUFBWTtJQUNULGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLHNCQUFzQjtJQUN0QixtQkFBbUI7SUFDbkIsZ0JBQWdCO0lBQ2hCLFdBQVc7SUFDWCxZQUFZO0FBQ2hCOztBQUVBO0lBQ0kscUJBQXFCO0NBQ3hCLG1CQUFtQjtBQUNwQjs7QUFIQTtJQUNJLHFCQUFxQjtDQUN4QixtQkFBbUI7QUFDcEI7O0FBRUE7Q0FDQyxlQUFlO0FBQ2hCOztBQUVBO0lBQ0ksWUFBWTtJQUNaLDZCQUE2QjtJQUM3QixjQUFjO0lBQ2QsY0FBYztJQUNkLGdCQUFnQjtJQUNoQixZQUFZO0lBQ1osV0FBVztJQUNYLFdBQVc7QUFDZjs7QUFFQTtJQUNJLGNBQWM7QUFDbEI7O0FBR0E7OztDQUdDLGFBQWE7Q0FDYixXQUFXO0NBQ1gsa0JBQWtCO0NBQ2xCLFlBQVk7Q0FDWixrQkFBa0I7Q0FDbEIsZ0JBQWdCO0NBQ2hCLHlCQUF5QjtBQUMxQjs7QUFFQTtDQUNDLDRCQUE0QjtJQUN6QixtQkFBMkI7WUFBM0IsMkJBQTJCO0FBQy9COztBQUVBO0NBQ0MsNEJBQTRCO0lBQ3pCLG1CQUEyQjtZQUEzQiwyQkFBMkI7QUFDL0I7O0FBRUE7Q0FDQyxnQkFBZ0I7Q0FDaEIsbUJBQWU7U0FBZixlQUFlO0FBQ2hCOztBQUVBOztBQUVBOztBQUVBO0lBQ0ksYUFBYTtBQUNqQjs7QUFFQTtDQUNDLHVCQUF1QjtDQUN2QixzQkFBc0I7Q0FDdEIsd0JBQXdCO0NBQ3hCLDRCQUE0QjtDQUM1QiwwQkFBMEI7Q0FDMUIsV0FBVztDQUNYLFlBQVk7O0FBRWI7O0FBRUE7Q0FDQyxrQkFBa0I7Q0FDbEIsMkJBQTJCO0NBQzNCLDRCQUE0QjtDQUM1QixZQUFZO0NBQ1osYUFBYTtBQUNkOztBQUdBO0NBQ0Msd0JBQXdCO0NBQ3hCLFdBQVc7QUFDWjs7QUFFQTtDQUNDLGVBQWU7QUFDaEI7O0FBRUE7SUFDSSxZQUFZO0lBQ1osNkJBQTZCO0lBQzdCLGNBQWM7SUFDZCxjQUFjO0lBQ2QsZ0JBQWdCO0lBQ2hCLFlBQVk7SUFDWixXQUFXO0lBQ1gsV0FBVztJQUNYLFdBQVc7SUFDWCxZQUFZO0FBQ2hCOztBQUVBO0NBQ0MsZUFBZTtBQUNoQiIsImZpbGUiOiJzcmMvYXBwL3dtLWNvbXBvbmVudHMvaW52b2ljZS1vY3ItZGV0YWlsL2ludm9pY2Utb2NyLWRldGFpbC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbi5zY2FubmVkLXJlc3VsdC1jb250YWluZXJ7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogd2hpdGU7XHRcclxuXHR3aWR0aDogMTAwJTtcclxuXHRtYXJnaW46IDA7XHJcbn1cclxuXHJcbi5zY2FubmVkLWl0ZW0tY29udGFpbmVye1xyXG5cdGJhY2tncm91bmQ6ICNmZmY7XHRcclxufVxyXG5cclxuLnNjYW5uZWQtaXRlbTpub3QoOmRpc2FibGVkKXtcclxuXHRjdXJzb3I6IHBvaW50ZXI7XHJcbn1cclxuXHJcbi5zY2FubmVkLWl0ZW0tbGlzdC1jb250YWluZXIgLnNjYW5uZWQtaXRlbTpub3QoOmRpc2FibGVkKXtcclxuXHR3aWR0aDogY2FsYyg1MCUgLSAxMHB4KTtcclxuXHRmbG9hdDogbGVmdDtcdFxyXG5cdGJvcmRlcjogbm9uZTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDA7XHJcbiAgICBkaXNwbGF5OiBibG9jaztcclxuICAgIGNvbG9yOiAjNDk1MDU3O1xyXG4gICAgaGVpZ2h0OiAyOHB4O1xyXG59XHJcblxyXG4uc2Nhbm5lZC1pdGVtLWxpc3QtY29udGFpbmVyIC5zY2FubmVkLWl0ZW0uYWN0aXZlOm5vdCg6ZGlzYWJsZWQpe1xyXG4gICAgY29sb3I6ICNmZmY7XHJcbn1cclxuXHJcbi5pdGVtLXZhbHVlLWNvbnRhaW5lcntcclxuXHR3aWR0aDogY2FsYyg1MCUgKyA4cHgpO1xyXG5cdGZsb2F0OiBsZWZ0O1xyXG5cdGJvcmRlcjogbm9uZTtcclxuICAgIGJvcmRlci1yYWRpdXM6IDA7XHJcbn1cclxuXHJcbi5pdGVtLXZhbHVlIHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkIGdyYXk7XHJcbiAgICBiYWNrZ3JvdW5kOiAjZmZmZmZmO1xyXG4gICAgYm94LXNoYWRvdzogbm9uZTtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG4gICAgd2lkdGg6IDE5NXB4O1xyXG59XHJcblxyXG4uaXRlbS12YWx1ZTpyZWFkLW9ubHkge1xyXG4gICAgYm9yZGVyLWNvbG9yOiAjYmViZWJlO1xyXG5cdGJhY2tncm91bmQ6ICNlZWVlZWU7XHJcbn1cclxuXHJcbi5lZGl0LXZhbHVlLWljb257XHJcblx0Zm9udC1zaXplOiAxOHB4OyBcclxufVxyXG5cclxuLmlubGluZS1lZGl0LWJ1dHRvbi1lZGl0LCAuaW5saW5lLWVkaXQtYnV0dG9uLWFwcGx5IHtcclxuICAgIGJvcmRlcjogbm9uZTtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50O1xyXG4gICAgY29sb3I6ICM1ZjVmNWY7XHJcbiAgICBwYWRkaW5nOiAwIDNweDtcclxuICAgIHBhZGRpbmctdG9wOiAzcHg7XHJcbiAgICBoZWlnaHQ6IDMwcHg7XHJcbiAgICB3aWR0aDogMjRweDtcclxuICAgIGZsb2F0OiBsZWZ0O1xyXG59XHJcblxyXG4uaW5saW5lLWVkaXQtYnV0dG9uLWFwcGx5IGkge1xyXG4gICAgY29sb3I6ICMwMDgyMDA7XHJcbn1cclxuXHJcblxyXG4uc2Nhbm5lZC1pdGVtLWxpc3QtY29udGFpbmVyLCBcclxuLnNjYW5uZWQtaXRlbS1kZXRhaWwtY29udGFpbmVyLFxyXG4uc2Nhbm5lZC1pdGVtLXByZXZpZXctY29udGFpbmVyIHtcclxuXHRwYWRkaW5nOiAxMHB4O1xyXG5cdG1hcmdpbjogNXB4O1xyXG5cdGJvcmRlci1yYWRpdXM6IDVweDtcclxuXHRoZWlnaHQ6IDgwdmg7XHJcblx0b3ZlcmZsb3cteDogaGlkZGVuO1xyXG5cdG92ZXJmbG93LXk6IGF1dG87XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2UwZTBlMDtcclxufVxyXG5cclxuLnNjYW5uZWQtaXRlbS1saXN0LWNvbnRhaW5lciB7XHJcblx0bWF4LXdpZHRoOiBjYWxjKDUwJSAtIDMyNXB4KTtcclxuICAgIGZsZXg6IDAgMCBjYWxjKDUwJSAtIDMyNXB4KTtcclxufVxyXG5cclxuLnNjYW5uZWQtaXRlbS1kZXRhaWwtY29udGFpbmVyIHtcclxuXHRtYXgtd2lkdGg6IGNhbGMoNTAlIC0gMzI1cHgpO1xyXG4gICAgZmxleDogMCAwIGNhbGMoNTAlIC0gMzI1cHgpO1xyXG59XHJcblxyXG4uc2Nhbm5lZC1pdGVtLXByZXZpZXctY29udGFpbmVyIHtcclxuXHRtYXgtd2lkdGg6IDYyMHB4O1xyXG5cdGZsZXg6IDAgMCA2MjBweDtcclxufVxyXG5cclxuLmZvdW5kLWl0ZW0ge1xyXG4gICAgXHJcbn1cclxuXHJcbi53b3JkLWxpc3QtaXRlbS5mYWRlOm5vdCguc2hvdykge1xyXG4gICAgZGlzcGxheTogbm9uZTtcclxufVxyXG5cclxuLnNjYW5uZWQtaXRlbS1wcmV2aWV3LWltYWdle1xyXG5cdGJhY2tncm91bmQtY29sb3I6IHdoaXRlO1xyXG5cdGJhY2tncm91bmQtaW1hZ2U6IG5vbmU7XHJcblx0YmFja2dyb3VuZC1wb3NpdGlvbjogMCAwO1xyXG5cdGJhY2tncm91bmQtcmVwZWF0OiBuby1yZXBlYXQ7XHJcblx0YmFja2dyb3VuZC1zaXplOiAxMDAlIDEwMCU7XHJcblx0d2lkdGg6IDEwMCU7XHJcblx0aGVpZ2h0OiAxMDAlO1xyXG5cdFxyXG59XHJcblxyXG4uc2VsZWN0ZWQtd29yZC1hcmVhe1xyXG5cdHBvc2l0aW9uOiBhYnNvbHV0ZTtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjYWRkNWVmM2Q7XHJcblx0Ym9yZGVyOiAxcHggZGFzaGVkICM1ODczYmFlMDtcdFxyXG5cdHdpZHRoOiAzMDBweDtcclxuXHRoZWlnaHQ6IDEwMHB4O1xyXG59XHJcblxyXG5cclxuLnNjYW5uZWQtaXRlbS1kZXRhaWwtY29udGFpbmVyIC5zY2FubmVkLWl0ZW06bm90KDpkaXNhYmxlZCl7XHJcblx0d2lkdGg6IGNhbGMoMTAwJSAtIDQwcHgpO1xyXG5cdGZsb2F0OiBsZWZ0O1x0XHJcbn1cclxuXHJcbi5lZGl0LXZhbHVlLWljb257XHJcblx0Zm9udC1zaXplOiAxOHB4OyBcclxufVxyXG5cclxuLmlubGluZS1lZGl0LWJ1dHRvbi11c2Uge1xyXG4gICAgYm9yZGVyOiBub25lO1xyXG4gICAgYmFja2dyb3VuZC1jb2xvcjogdHJhbnNwYXJlbnQ7XHJcbiAgICBjb2xvcjogIzVmNWY1ZjtcclxuICAgIHBhZGRpbmc6IDAgM3B4O1xyXG4gICAgcGFkZGluZy10b3A6IDNweDtcclxuICAgIGhlaWdodDogMzBweDtcclxuICAgIHdpZHRoOiAyNHB4O1xyXG4gICAgZmxvYXQ6IGxlZnQ7XHJcbiAgICB3aWR0aDogMjRweDtcclxuICAgIGZsb2F0OiByaWdodDtcclxufVxyXG5cclxuLmlubGluZS1lZGl0LWJ1dHRvbi11c2UgaSB7XHJcblx0Zm9udC1zaXplOiAzMHB4O1xyXG59XHJcblxyXG5cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](InvoiceOcrDetailComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-invoice-ocr-detail',
                templateUrl: './invoice-ocr-detail.component.html',
                styleUrls: ['./invoice-ocr-detail.component.css']
            }]
    }], function () { return [{ type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_3__["TranslateService"] }]; }, { previewContainer: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["ViewChild"],
            args: ['scannedItemPreviewContainer']
        }], showOcrDetails: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['showOcrDetails']
        }], scanedPdfPath: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['scanedPdfPath']
        }], scanedHocrPath: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['scanedHocrPath']
        }], fileIsPdf: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['fileIsPdf']
        }], fileIsImage: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['fileIsImage']
        }], imageSizeX: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['imageSizeX']
        }], imageSizeY: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['imageSizeY']
        }], foundWords: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['foundWords']
        }], editedValues: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['editedValues']
        }], onApplyValues: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Output"]
        }] }); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");




function WorkflowInlineviewComponent_div_0_div_34_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "a", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "strong");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "a", 11);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "i", 12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8, "save_alt");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const file_r172 = ctx.$implicit;
    const ctx_r170 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate2"]("href", "/workflow/file/view/", ctx_r170.viewWorkflowModel.identity, "/", file_r172.identity, "", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeUrl"]);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](file_r172.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" (Ver: ", file_r172.activeFileVersion, ") ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate2"]("href", "/workflow/file/download/", ctx_r170.viewWorkflowModel.identity, "/", file_r172.identity, "", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵsanitizeUrl"]);
} }
function WorkflowInlineviewComponent_div_0_div_38_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 13);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "strong");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](6, ":");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "div");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const action_r173 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](action_r173.currentStep.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate2"]("(", action_r173.status, ") (", action_r173.assignToUserName, ")");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](action_r173.action);
} }
function WorkflowInlineviewComponent_div_0_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 2);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](9, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](12);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](13, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](16, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](19);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](20, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](21, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](22);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](23, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "div", 3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](25, "div", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](26);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](27, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](28, "div", 5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](30, "div", 6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](31, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](32, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](33, "Files");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](34, WorkflowInlineviewComponent_div_0_div_34_Template, 9, 6, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](35, "div", 7);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](36, "div", 8);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](37, "Actions");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](38, WorkflowInlineviewComponent_div_0_div_38_Template, 12, 4, "div", 9);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r169 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 10, "workflow-title"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r169.viewWorkflowModel.workflowType.title);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](13, 12, "workflow-comments"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r169.viewWorkflowModel.comments);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](20, 14, "workflow-current-step"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", ctx_r169.viewWorkflowModel.currentStep.title, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](27, 16, "workflow-status"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", ctx_r169.viewWorkflowModel.status, " ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r169.viewWorkflowModel.files);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx_r169.viewWorkflowModel.actions);
} }
class WorkflowInlineviewComponent {
    constructor() {
    }
    ngOnInit() {
    }
}
WorkflowInlineviewComponent.ɵfac = function WorkflowInlineviewComponent_Factory(t) { return new (t || WorkflowInlineviewComponent)(); };
WorkflowInlineviewComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WorkflowInlineviewComponent, selectors: [["app-workflow-inlineview"]], inputs: { viewWorkflowModel: ["workflow", "viewWorkflowModel"] }, decls: 1, vars: 1, consts: [["class", "workflow-inline-content-container", 4, "ngIf"], [1, "workflow-inline-content-container"], [1, "workflowview-dialog-content-container"], [1, "item-row"], [1, "item-label"], [1, "item-content"], [1, "clear"], [2, "padding-top", "10px", "padding-left", "10px", "border-top", "1px solid gray", "margin-top", "10px"], [2, "text-align", "center", "font-weight", "bold"], ["class", "item-row", "style", "border-bottom: 1px #9a9a9a dashed", 4, "ngFor", "ngForOf"], [1, "item-row", 2, "border-bottom", "1px #9a9a9a dashed"], ["target", "_blank", 1, "workflow-file-view-link", 3, "href"], [1, "material-icons"], [1, "action-content"]], template: function WorkflowInlineviewComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](0, WorkflowInlineviewComponent_div_0_Template, 39, 18, "div", 0);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.viewWorkflowModel != null);
    } }, directives: [_angular_common__WEBPACK_IMPORTED_MODULE_1__["NgIf"], _angular_common__WEBPACK_IMPORTED_MODULE_1__["NgForOf"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_2__["TranslatePipe"]], styles: [".workflow-inline-content-container[_ngcontent-%COMP%]{\r\n\t\r\n}\r\n\r\n.workflowview-dialog-content-container[_ngcontent-%COMP%]{\r\n\tbackground-color: white;\t\r\n\tpadding: 10px;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1pbmxpbmV2aWV3L3dvcmtmbG93LWlubGluZXZpZXcuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7O0FBRUE7O0FBRUE7Q0FDQyx1QkFBdUI7Q0FDdkIsYUFBYTtBQUNkIiwiZmlsZSI6InNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1pbmxpbmV2aWV3L3dvcmtmbG93LWlubGluZXZpZXcuY29tcG9uZW50LmNzcyIsInNvdXJjZXNDb250ZW50IjpbIlxyXG4ud29ya2Zsb3ctaW5saW5lLWNvbnRlbnQtY29udGFpbmVye1xyXG5cdFxyXG59XHJcblxyXG4ud29ya2Zsb3d2aWV3LWRpYWxvZy1jb250ZW50LWNvbnRhaW5lcntcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiB3aGl0ZTtcdFxyXG5cdHBhZGRpbmc6IDEwcHg7XHJcbn1cclxuIl19 */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowInlineviewComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-workflow-inlineview',
                templateUrl: './workflow-inlineview.component.html',
                styleUrls: ['./workflow-inlineview.component.css']
            }]
    }], function () { return []; }, { viewWorkflowModel: [{
            type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Input"],
            args: ['workflow']
        }] }); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _angular_router__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! @angular/router */ "./node_modules/@angular/router/__ivy_ngcc__/fesm2015/router.js");
/* harmony import */ var _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ../../services/workflow/workflow-search.service */ "./src/app/services/workflow/workflow-search.service.ts");
/* harmony import */ var _wf_models__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ../../wf-models */ "./src/app/wf-models/index.ts");
/* harmony import */ var _services_global_service__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../../services/global.service */ "./src/app/services/global.service.ts");
/* harmony import */ var _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! @ngx-translate/core */ "./node_modules/@ngx-translate/core/__ivy_ngcc__/fesm2015/ngx-translate-core.js");
/* harmony import */ var _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../../services/loading-service.service */ "./src/app/services/loading-service.service.ts");
/* harmony import */ var _services_error_service_service__WEBPACK_IMPORTED_MODULE_7__ = __webpack_require__(/*! ../../services/error-service.service */ "./src/app/services/error-service.service.ts");
/* harmony import */ var _angular_common__WEBPACK_IMPORTED_MODULE_8__ = __webpack_require__(/*! @angular/common */ "./node_modules/@angular/common/__ivy_ngcc__/fesm2015/common.js");
/* harmony import */ var _angular_forms__WEBPACK_IMPORTED_MODULE_9__ = __webpack_require__(/*! @angular/forms */ "./node_modules/@angular/forms/__ivy_ngcc__/fesm2015/forms.js");
/* harmony import */ var _angular_material_table__WEBPACK_IMPORTED_MODULE_10__ = __webpack_require__(/*! @angular/material/table */ "./node_modules/@angular/material/__ivy_ngcc__/fesm2015/table.js");
/* harmony import */ var _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_11__ = __webpack_require__(/*! ../workflow-inlineview/workflow-inlineview.component */ "./src/app/wm-components/workflow-inlineview/workflow-inlineview.component.ts");















function WorkflowListComponent_div_16_Template(rf, ctx) { if (rf & 1) {
    const _r45 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 28);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "input", 29);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_div_16_Template_input_click_1_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r45); const wstatus_r43 = ctx.$implicit; const ctx_r44 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r44.toggleStatusSelected(wstatus_r43); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "label", 30);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const wstatus_r43 = ctx.$implicit;
    const ctx_r26 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("id", "status-check-", wstatus_r43, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx_r26.isStatusSelected(wstatus_r43));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpropertyInterpolate1"]("for", "status-check-", wstatus_r43, "");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](wstatus_r43);
} }
function WorkflowListComponent_div_23_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 31);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r27 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](ctx_r27.debugSearchFilter);
} }
function WorkflowListComponent_th_26_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-type"), " ");
} }
function WorkflowListComponent_td_27_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const element_r46 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r46.workflowType.title, " ");
} }
function WorkflowListComponent_th_29_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-current-step"), " ");
} }
function WorkflowListComponent_td_30_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const element_r47 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r47.currentStep.title, " ");
} }
function WorkflowListComponent_th_32_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-status"), " ");
} }
function WorkflowListComponent_td_33_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const element_r48 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r48.status, " ");
} }
function WorkflowListComponent_th_35_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-assignto"), " ");
} }
function WorkflowListComponent_td_36_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const element_r49 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", element_r49.assignToUserFullName, " ");
} }
function WorkflowListComponent_th_38_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](2, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](2, 1, "workflow-updated"), " ");
} }
function WorkflowListComponent_td_39_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate1"](" ", "not impelemented!!", " ");
} }
function WorkflowListComponent_th_41_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "th", 32);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](1, " ... ");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function WorkflowListComponent_td_42_a_1_Template(rf, ctx) { if (rf & 1) {
    const _r56 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "a", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_td_42_a_1_Template_a_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r56); const element_r51 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]().$implicit; const ctx_r54 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r54.editWorkflow(element_r51); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "edit");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function WorkflowListComponent_td_42_Template(rf, ctx) { if (rf & 1) {
    const _r58 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "td", 33);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](1, WorkflowListComponent_td_42_a_1_Template, 3, 0, "a", 34);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "a", 35);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_td_42_Template_a_click_2_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r58); const idx_r52 = ctx.index; const ctx_r57 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r57.showWorkflow(idx_r52); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](4, "pageview");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const element_r51 = ctx.$implicit;
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", element_r51.canEdit);
} }
function WorkflowListComponent_tr_43_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 36);
} }
function WorkflowListComponent_tr_44_Template(rf, ctx) { if (rf & 1) {
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](0, "tr", 37);
} }
function WorkflowListComponent_div_45_button_16_Template(rf, ctx) { if (rf & 1) {
    const _r62 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "button", 49);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_div_45_button_16_Template_button_click_0_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r62); const ctx_r61 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](2); return ctx_r61.editWorkflow(ctx_r61.viewWorkflowModel); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](2, "pageview");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} }
function WorkflowListComponent_div_45_Template(rf, ctx) { if (rf & 1) {
    const _r64 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵgetCurrentView"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 38);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 39);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 40);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](3, "div", 41);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](4, "h5", 42);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](6, "translate");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](7, "button", 43);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_div_45_Template_button_click_7_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r64); const ctx_r63 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r63.hideViewModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](9, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](10, "div", 44);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelement"](11, "app-workflow-inlineview", 45);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "div", 46);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "button", 47);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_div_45_Template_button_click_13_listener($event) { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵrestoreView"](_r64); const ctx_r65 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"](); return ctx_r65.hideViewModal(); });
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](14, "i", 4);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](15, "close");
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, WorkflowListComponent_div_45_button_16_Template, 3, 0, "button", 48);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
} if (rf & 2) {
    const ctx_r42 = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵnextContext"]();
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](6, 3, "common.view-workflow"));
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](6);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("workflow", ctx_r42.viewWorkflowModel);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
    _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx_r42.viewWorkflowModel.meAssigned || ctx_r42.viewWorkflowModel.loggedUserControllerAndDone);
} }
const _c0 = function () { return ["/workflow/create"]; };
class WorkflowListComponent {
    constructor(router, global, translate, searchService, loadingService, errorService, route) {
        this.router = router;
        this.global = global;
        this.searchService = searchService;
        this.loadingService = loadingService;
        this.errorService = errorService;
        this.route = route;
        this.worlflowTypes = [];
        this.resultWorlflows = [];
        this.listInitialData = new _wf_models__WEBPACK_IMPORTED_MODULE_3__["WorkflowListInitialData"]();
        this.displayedColumns = ['workflow-type', 'workflow-current-step', 'workflow-status', 'workflow-assignto', 'workflow-updated', 'actions'];
        this.showDebug = false;
        this.viewWorkflowModal = false;
        this.viewWorkflowModel = null;
        this.router.events.subscribe((evt) => {
            if (evt instanceof _angular_router__WEBPACK_IMPORTED_MODULE_1__["NavigationEnd"]) {
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
    showWorkflow(index) {
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
}
WorkflowListComponent.ɵfac = function WorkflowListComponent_Factory(t) { return new (t || WorkflowListComponent)(_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowSearchService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_services_error_service_service__WEBPACK_IMPORTED_MODULE_7__["ErrorServiceService"]), _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdirectiveInject"](_angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"])); };
WorkflowListComponent.ɵcmp = _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵdefineComponent"]({ type: WorkflowListComponent, selectors: [["app-workflow-list"]], features: [_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵProvidersFeature"]([_services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowSearchService"]])], decls: 46, vars: 17, consts: [[1, "content-container"], [1, "page-toolbar"], [1, "page-title"], [1, "toolbar-button", 3, "click"], [1, "material-icons"], [1, "toolbar-link", 3, "routerLink"], [1, "nav", "nav-pills", "search-toolbar"], [1, "nav-item", "dropdown"], ["data-toggle", "dropdown", "href", "#", "role", "button", "aria-haspopup", "true", "aria-expanded", "false", 1, "nav-link", "dropdown-toggle"], [1, "dropdown-menu"], ["class", "dropdown-item", 4, "ngFor", "ngForOf"], [1, "nav-item"], [1, "search-toolbar-item"], ["type", "checkbox", "id", "me-assigned-check", 1, "toggle-checkbox", "form-check-input", 3, "checked", "ngModel", "ngModelChange"], ["for", "me-assigned-check", 1, "form-check-label"], ["style", "border: 1px solid gray; padding: 5px; background-color: #f1f1f1;", 4, "ngIf"], ["mat-table", "", 3, "dataSource"], ["matColumnDef", "workflow-type"], ["mat-header-cell", "", 4, "matHeaderCellDef"], ["mat-cell", "", 4, "matCellDef"], ["matColumnDef", "workflow-current-step"], ["matColumnDef", "workflow-status"], ["matColumnDef", "workflow-assignto"], ["matColumnDef", "workflow-updated"], ["matColumnDef", "actions"], ["mat-header-row", "", 4, "matHeaderRowDef", "matHeaderRowDefSticky"], ["mat-row", "", 4, "matRowDef", "matRowDefColumns"], ["class", "modal fade show", "tabindex", "-1", "id", "viewworkflowedialog", "role", "dialog", 4, "ngIf"], [1, "dropdown-item"], ["type", "checkbox", 1, "form-check-input", 3, "checked", "id", "click"], [1, "form-check-label", 3, "for"], [2, "border", "1px solid gray", "padding", "5px", "background-color", "#f1f1f1"], ["mat-header-cell", ""], ["mat-cell", ""], ["class", "tool-link", 3, "click", 4, "ngIf"], [1, "tool-link", 3, "click"], ["mat-header-row", ""], ["mat-row", ""], ["tabindex", "-1", "id", "viewworkflowedialog", "role", "dialog", 1, "modal", "fade", "show"], ["role", "document", 1, "modal-dialog", "modal-dialog-centered"], [1, "modal-content"], [1, "modal-header"], ["id", "errorMessagedialogTitle", 1, "modal-title", "dialog-title"], ["aria-label", "Close", 1, "dialog-toolbar-button", "close", 3, "click"], [1, "modal-body"], [3, "workflow"], [1, "modal-footer"], ["type", "button", 1, "btn", "btn-secondary", 3, "click"], ["type", "button", "class", "btn btn-primary", 3, "click", 4, "ngIf"], ["type", "button", 1, "btn", "btn-primary", 3, "click"]], template: function WorkflowListComponent_Template(rf, ctx) { if (rf & 1) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](0, "div", 0);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](1, "div", 1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](2, "div", 2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](4, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](5, "button", 3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("click", function WorkflowListComponent_Template_button_click_5_listener($event) { return ctx.reload(); });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](6, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](7, "refresh");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](8, "a", 5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](9, "i", 4);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](10, "playlist_add");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](11, "ul", 6);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](12, "li", 7);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](13, "a", 8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](14, "Status");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](15, "div", 9);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](16, WorkflowListComponent_div_16_Template, 4, 4, "div", 10);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](17, "li", 11);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](18, "div", 12);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](19, "input", 13);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵlistener"]("ngModelChange", function WorkflowListComponent_Template_input_ngModelChange_19_listener($event) { return ctx.isMeAssigned = $event; });
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](20, "label", 14);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtext"](21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipe"](22, "translate");
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](23, WorkflowListComponent_div_23_Template, 2, 1, "div", 15);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementStart"](24, "table", 16);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](25, 17);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](26, WorkflowListComponent_th_26_Template, 3, 3, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](27, WorkflowListComponent_td_27_Template, 2, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](28, 20);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](29, WorkflowListComponent_th_29_Template, 3, 3, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](30, WorkflowListComponent_td_30_Template, 2, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](31, 21);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](32, WorkflowListComponent_th_32_Template, 3, 3, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](33, WorkflowListComponent_td_33_Template, 2, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](34, 22);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](35, WorkflowListComponent_th_35_Template, 3, 3, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](36, WorkflowListComponent_td_36_Template, 2, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](37, 23);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](38, WorkflowListComponent_th_38_Template, 3, 3, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](39, WorkflowListComponent_td_39_Template, 2, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerStart"](40, 24);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](41, WorkflowListComponent_th_41_Template, 2, 0, "th", 18);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](42, WorkflowListComponent_td_42_Template, 5, 1, "td", 19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementContainerEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](43, WorkflowListComponent_tr_43_Template, 1, 0, "tr", 25);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](44, WorkflowListComponent_tr_44_Template, 1, 0, "tr", 26);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵelementEnd"]();
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtemplate"](45, WorkflowListComponent_div_45_Template, 17, 5, "div", 27);
    } if (rf & 2) {
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](4, 12, "menu-workflow-list"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](5);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("routerLink", _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpureFunction0"](16, _c0));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](8);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngForOf", ctx.statusList);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](3);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("checked", ctx.isMeAssigned)("ngModel", ctx.isMeAssigned);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵtextInterpolate"](_angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵpipeBind1"](22, 14, "workflow-assigned-me"));
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](2);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.showDebug);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("dataSource", ctx.resultWorlflows);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](19);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matHeaderRowDef", ctx.displayedColumns)("matHeaderRowDefSticky", true);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("matRowDefColumns", ctx.displayedColumns);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵadvance"](1);
        _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵɵproperty"]("ngIf", ctx.viewWorkflowModal);
    } }, directives: [_angular_router__WEBPACK_IMPORTED_MODULE_1__["RouterLinkWithHref"], _angular_common__WEBPACK_IMPORTED_MODULE_8__["NgForOf"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["CheckboxControlValueAccessor"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgControlStatus"], _angular_forms__WEBPACK_IMPORTED_MODULE_9__["NgModel"], _angular_common__WEBPACK_IMPORTED_MODULE_8__["NgIf"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatTable"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatColumnDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatHeaderCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatCellDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatHeaderRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatRowDef"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatHeaderCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatCell"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatHeaderRow"], _angular_material_table__WEBPACK_IMPORTED_MODULE_10__["MatRow"], _workflow_inlineview_workflow_inlineview_component__WEBPACK_IMPORTED_MODULE_11__["WorkflowInlineviewComponent"]], pipes: [_ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslatePipe"]], styles: ["table[_ngcontent-%COMP%] {\r\n  width: 100%;\r\n  background: #ffffff;\r\n  margin-top: 30px;\r\n}\r\n\r\ntable[_ngcontent-%COMP%]   a.tool-link[_ngcontent-%COMP%] {\r\n    color: #828282;\r\n    cursor: pointer;\r\n}\r\n\r\n.mat-header-cell[_ngcontent-%COMP%] {\r\n    color: white;\r\n    font-size: 16px;\r\n    font-weight: notmal;\r\n}\r\n\r\n.mat-cell[_ngcontent-%COMP%], .mat-footer-cell[_ngcontent-%COMP%] {\r\n    color: #0f0f0f;\r\n}\r\n\r\nth.mat-header-cell[_ngcontent-%COMP%], td.mat-cell[_ngcontent-%COMP%], td.mat-footer-cell[_ngcontent-%COMP%] {\r\n    border: 1px solid #d7d5d5;\r\n    text-align: center;\r\n}\r\n\r\nth.mat-header-cell[_ngcontent-%COMP%] {\r\n    border: 1px solid #acaaaa;\r\n    text-align: center;\r\n}\r\n\r\n.mat-header-row[_ngcontent-%COMP%]{\r\n\tbackground-color: #374373;\r\n}\r\n\r\n.mat-row[_ngcontent-%COMP%]{\r\n\theight: 40px;\r\n}\r\n\r\n.mat-row[_ngcontent-%COMP%]:nth-child(odd){\t\r\n\tbackground-color: #fff;\r\n}\r\n\r\n.mat-row[_ngcontent-%COMP%]:nth-child(even){\t\r\n\tbackground-color: #f2f2f2;\r\n}\r\n\r\n.mat-row[_ngcontent-%COMP%]:hover{\t\r\n\tbackground-color: #feffec;\r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%] {\r\n    width: calc(100% - 350px);\r\n    float: right;\r\n    padding-top: 8px;\r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%]   .nav-item[_ngcontent-%COMP%]{\r\n    margin-right: 30px;\r\n    \r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%]   .nav-item[_ngcontent-%COMP%]   input.form-check-input[type=checkbox][_ngcontent-%COMP%]{\r\n    width: 16px;\r\n    height: 16px;\r\n    \r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%]   .nav-item[_ngcontent-%COMP%]   .form-check-label[_ngcontent-%COMP%]{\r\n\tmargin-bottom: 0;\r\n    padding-left: 10px;\r\n    line-height: 20px;\r\n}\r\n\r\n.search-toolbar-item[_ngcontent-%COMP%]{\r\n\theight: 100%;\r\n    padding-top: 9px;\r\n    margin-left: 20px;\r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%]   .nav-item[_ngcontent-%COMP%] {\r\n    background-color: transparent !important;\r\n}\r\n\r\n.search-toolbar[_ngcontent-%COMP%]   .nav-link.active[_ngcontent-%COMP%], .search-toolbar[_ngcontent-%COMP%]   .show[_ngcontent-%COMP%] > .nav-link[_ngcontent-%COMP%] {\r\n    color: #fff !important;\r\n    background-color: #c7c9cb !important;\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]{\r\n\t\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]   thead[_ngcontent-%COMP%]{\r\n\tbackground-color: #c1c4c4;\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]   thead[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]   th[_ngcontent-%COMP%], .table-striped[_ngcontent-%COMP%]   thead[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{\t\r\n\tborder: 2px solid #dee2e6;\r\n\tpadding: 4px 6px;\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]   th[_ngcontent-%COMP%], .table-striped[_ngcontent-%COMP%]   td[_ngcontent-%COMP%]{\t\r\n\tborder: 2px solid #dee2e6;\r\n\tpadding: 4px 6px;\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]   tbody[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]{\t\r\n\tborder: 2px solid #dee2e6;\r\n}\r\n\r\n.table-striped[_ngcontent-%COMP%]   tbody[_ngcontent-%COMP%]   tr[_ngcontent-%COMP%]:hove{\t\r\n\tbackground-color: #dff7ff;\r\n}\n/*# sourceMappingURL=data:application/json;base64,eyJ2ZXJzaW9uIjozLCJzb3VyY2VzIjpbInNyYy9hcHAvd20tY29tcG9uZW50cy93b3JrZmxvdy1saXN0L3dvcmtmbG93LWxpc3QuY29tcG9uZW50LmNzcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiO0FBQ0E7RUFDRSxXQUFXO0VBQ1gsbUJBQW1CO0VBQ25CLGdCQUFnQjtBQUNsQjs7QUFFQTtJQUNJLGNBQWM7SUFDZCxlQUFlO0FBQ25COztBQUVBO0lBQ0ksWUFBWTtJQUNaLGVBQWU7SUFDZixtQkFBbUI7QUFDdkI7O0FBRUE7SUFDSSxjQUFjO0FBQ2xCOztBQUVBO0lBQ0kseUJBQXlCO0lBQ3pCLGtCQUFrQjtBQUN0Qjs7QUFFQTtJQUNJLHlCQUF5QjtJQUN6QixrQkFBa0I7QUFDdEI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyxZQUFZO0FBQ2I7O0FBRUE7Q0FDQyxzQkFBc0I7QUFDdkI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBR0E7SUFDSSx5QkFBeUI7SUFDekIsWUFBWTtJQUNaLGdCQUFnQjtBQUNwQjs7QUFFQTtJQUNJLGtCQUFrQjs7QUFFdEI7O0FBRUE7SUFDSSxXQUFXO0lBQ1gsWUFBWTs7QUFFaEI7O0FBRUE7Q0FDQyxnQkFBZ0I7SUFDYixrQkFBa0I7SUFDbEIsaUJBQWlCO0FBQ3JCOztBQUVBO0NBQ0MsWUFBWTtJQUNULGdCQUFnQjtJQUNoQixpQkFBaUI7QUFDckI7O0FBRUE7SUFDSSx3Q0FBd0M7QUFDNUM7O0FBRUE7SUFDSSxzQkFBc0I7SUFDdEIsb0NBQW9DO0FBQ3hDOztBQUVBOztBQUVBOztBQUVBO0NBQ0MseUJBQXlCO0FBQzFCOztBQUVBO0NBQ0MseUJBQXlCO0NBQ3pCLGdCQUFnQjtBQUNqQjs7QUFFQTtDQUNDLHlCQUF5QjtDQUN6QixnQkFBZ0I7QUFDakI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUI7O0FBRUE7Q0FDQyx5QkFBeUI7QUFDMUIiLCJmaWxlIjoic3JjL2FwcC93bS1jb21wb25lbnRzL3dvcmtmbG93LWxpc3Qvd29ya2Zsb3ctbGlzdC5jb21wb25lbnQuY3NzIiwic291cmNlc0NvbnRlbnQiOlsiXHJcbnRhYmxlIHtcclxuICB3aWR0aDogMTAwJTtcclxuICBiYWNrZ3JvdW5kOiAjZmZmZmZmO1xyXG4gIG1hcmdpbi10b3A6IDMwcHg7XHJcbn1cclxuXHJcbnRhYmxlIGEudG9vbC1saW5rIHtcclxuICAgIGNvbG9yOiAjODI4MjgyO1xyXG4gICAgY3Vyc29yOiBwb2ludGVyO1xyXG59XHJcblxyXG4ubWF0LWhlYWRlci1jZWxsIHtcclxuICAgIGNvbG9yOiB3aGl0ZTtcclxuICAgIGZvbnQtc2l6ZTogMTZweDtcclxuICAgIGZvbnQtd2VpZ2h0OiBub3RtYWw7XHJcbn1cclxuXHJcbi5tYXQtY2VsbCwgLm1hdC1mb290ZXItY2VsbCB7XHJcbiAgICBjb2xvcjogIzBmMGYwZjtcclxufVxyXG5cclxudGgubWF0LWhlYWRlci1jZWxsLCB0ZC5tYXQtY2VsbCwgdGQubWF0LWZvb3Rlci1jZWxsIHtcclxuICAgIGJvcmRlcjogMXB4IHNvbGlkICNkN2Q1ZDU7XHJcbiAgICB0ZXh0LWFsaWduOiBjZW50ZXI7XHJcbn1cclxuXHJcbnRoLm1hdC1oZWFkZXItY2VsbCB7XHJcbiAgICBib3JkZXI6IDFweCBzb2xpZCAjYWNhYWFhO1xyXG4gICAgdGV4dC1hbGlnbjogY2VudGVyO1xyXG59XHJcblxyXG4ubWF0LWhlYWRlci1yb3d7XHJcblx0YmFja2dyb3VuZC1jb2xvcjogIzM3NDM3MztcclxufVxyXG5cclxuLm1hdC1yb3d7XHJcblx0aGVpZ2h0OiA0MHB4O1xyXG59XHJcblxyXG4ubWF0LXJvdzpudGgtY2hpbGQob2RkKXtcdFxyXG5cdGJhY2tncm91bmQtY29sb3I6ICNmZmY7XHJcbn1cclxuXHJcbi5tYXQtcm93Om50aC1jaGlsZChldmVuKXtcdFxyXG5cdGJhY2tncm91bmQtY29sb3I6ICNmMmYyZjI7XHJcbn1cclxuXHJcbi5tYXQtcm93OmhvdmVye1x0XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2ZlZmZlYztcclxufVxyXG5cclxuXHJcbi5zZWFyY2gtdG9vbGJhciB7XHJcbiAgICB3aWR0aDogY2FsYygxMDAlIC0gMzUwcHgpO1xyXG4gICAgZmxvYXQ6IHJpZ2h0O1xyXG4gICAgcGFkZGluZy10b3A6IDhweDtcclxufVxyXG5cclxuLnNlYXJjaC10b29sYmFyIC5uYXYtaXRlbXtcclxuICAgIG1hcmdpbi1yaWdodDogMzBweDtcclxuICAgIFxyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXIgLm5hdi1pdGVtIGlucHV0LmZvcm0tY2hlY2staW5wdXRbdHlwZT1jaGVja2JveF17XHJcbiAgICB3aWR0aDogMTZweDtcclxuICAgIGhlaWdodDogMTZweDtcclxuICAgIFxyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXIgLm5hdi1pdGVtIC5mb3JtLWNoZWNrLWxhYmVse1xyXG5cdG1hcmdpbi1ib3R0b206IDA7XHJcbiAgICBwYWRkaW5nLWxlZnQ6IDEwcHg7XHJcbiAgICBsaW5lLWhlaWdodDogMjBweDtcclxufVxyXG5cclxuLnNlYXJjaC10b29sYmFyLWl0ZW17XHJcblx0aGVpZ2h0OiAxMDAlO1xyXG4gICAgcGFkZGluZy10b3A6IDlweDtcclxuICAgIG1hcmdpbi1sZWZ0OiAyMHB4O1xyXG59XHJcblxyXG4uc2VhcmNoLXRvb2xiYXIgLm5hdi1pdGVtIHtcclxuICAgIGJhY2tncm91bmQtY29sb3I6IHRyYW5zcGFyZW50ICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbi5zZWFyY2gtdG9vbGJhciAubmF2LWxpbmsuYWN0aXZlLCAuc2VhcmNoLXRvb2xiYXIgLnNob3c+Lm5hdi1saW5rIHtcclxuICAgIGNvbG9yOiAjZmZmICFpbXBvcnRhbnQ7XHJcbiAgICBiYWNrZ3JvdW5kLWNvbG9yOiAjYzdjOWNiICFpbXBvcnRhbnQ7XHJcbn1cclxuXHJcbi50YWJsZS1zdHJpcGVke1xyXG5cdFxyXG59XHJcblxyXG4udGFibGUtc3RyaXBlZCB0aGVhZHtcclxuXHRiYWNrZ3JvdW5kLWNvbG9yOiAjYzFjNGM0O1xyXG59XHJcblxyXG4udGFibGUtc3RyaXBlZCB0aGVhZCB0ciB0aCwgLnRhYmxlLXN0cmlwZWQgdGhlYWQgdHIgdGR7XHRcclxuXHRib3JkZXI6IDJweCBzb2xpZCAjZGVlMmU2O1xyXG5cdHBhZGRpbmc6IDRweCA2cHg7XHJcbn1cclxuXHJcbi50YWJsZS1zdHJpcGVkIHRoLCAudGFibGUtc3RyaXBlZCB0ZHtcdFxyXG5cdGJvcmRlcjogMnB4IHNvbGlkICNkZWUyZTY7XHJcblx0cGFkZGluZzogNHB4IDZweDtcclxufVxyXG5cclxuLnRhYmxlLXN0cmlwZWQgdGJvZHkgdHJ7XHRcclxuXHRib3JkZXI6IDJweCBzb2xpZCAjZGVlMmU2O1xyXG59XHJcblxyXG4udGFibGUtc3RyaXBlZCB0Ym9keSB0cjpob3Zle1x0XHJcblx0YmFja2dyb3VuZC1jb2xvcjogI2RmZjdmZjtcclxufVxyXG4iXX0= */"] });
/*@__PURE__*/ (function () { _angular_core__WEBPACK_IMPORTED_MODULE_0__["ɵsetClassMetadata"](WorkflowListComponent, [{
        type: _angular_core__WEBPACK_IMPORTED_MODULE_0__["Component"],
        args: [{
                selector: 'app-workflow-list',
                templateUrl: './workflow-list.component.html',
                styleUrls: ['./workflow-list.component.css'],
                providers: [_services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowSearchService"]]
            }]
    }], function () { return [{ type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["Router"] }, { type: _services_global_service__WEBPACK_IMPORTED_MODULE_4__["GlobalService"] }, { type: _ngx_translate_core__WEBPACK_IMPORTED_MODULE_5__["TranslateService"] }, { type: _services_workflow_workflow_search_service__WEBPACK_IMPORTED_MODULE_2__["WorkflowSearchService"] }, { type: _services_loading_service_service__WEBPACK_IMPORTED_MODULE_6__["LoadingServiceService"] }, { type: _services_error_service_service__WEBPACK_IMPORTED_MODULE_7__["ErrorServiceService"] }, { type: _angular_router__WEBPACK_IMPORTED_MODULE_1__["ActivatedRoute"] }]; }, null); })();


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
/* harmony import */ var _angular_core__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! @angular/core */ "./node_modules/@angular/core/__ivy_ngcc__/fesm2015/core.js");
/* harmony import */ var _environments_environment__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! ./environments/environment */ "./src/environments/environment.ts");
/* harmony import */ var _app_app_module__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! ./app/app.module */ "./src/app/app.module.ts");
/* harmony import */ var _angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! @angular/platform-browser */ "./node_modules/@angular/platform-browser/__ivy_ngcc__/fesm2015/platform-browser.js");




if (_environments_environment__WEBPACK_IMPORTED_MODULE_1__["environment"].production) {
    Object(_angular_core__WEBPACK_IMPORTED_MODULE_0__["enableProdMode"])();
}
_angular_platform_browser__WEBPACK_IMPORTED_MODULE_3__["platformBrowser"]().bootstrapModule(_app_app_module__WEBPACK_IMPORTED_MODULE_2__["AppModule"]);
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


/***/ }),

/***/ 1:
/*!**********************!*\
  !*** zlib (ignored) ***!
  \**********************/
/*! no static exports found */
/***/ (function(module, exports) {

/* (ignored) */

/***/ }),

/***/ 2:
/*!********************!*\
  !*** fs (ignored) ***!
  \********************/
/*! no static exports found */
/***/ (function(module, exports) {

/* (ignored) */

/***/ }),

/***/ 3:
/*!**********************!*\
  !*** http (ignored) ***!
  \**********************/
/*! no static exports found */
/***/ (function(module, exports) {

/* (ignored) */

/***/ }),

/***/ 4:
/*!***********************!*\
  !*** https (ignored) ***!
  \***********************/
/*! no static exports found */
/***/ (function(module, exports) {

/* (ignored) */

/***/ })

},[[0,"runtime","vendor"]]]);