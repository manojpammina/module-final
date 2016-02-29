/**
 * Created by manoj on 2/9/16.
 */

(function() {
    'use strict';

    angular
        .module('rrs', ['ngRoute','angular-loading-bar'])
        .config(moduleConfig);

    moduleConfig.$inject=['$routeProvider'];

    function moduleConfig($routeProvider){
        $routeProvider
            .when('/home',{
                templateUrl:'home.tmpl.html',
                controller:'HomeListController',
                controllerAs:'HomeListVm'
            })

            .when('/login',{
                templateUrl:'login.tmpl.html',
                controller:'LoginListController',
                controllerAs:'LoginListVm'
            })
           .when('/reserve',{
                templateUrl:'reserve.tmpl.html',
                controller:'ReserveListController',
                controllerAs:'reserveAllListVm'
            })
            .when('/reserveAll',{
                templateUrl:'reserve-all.tmpl.html',
                controller:'ReserveAllListController',
                controllerAs:'reserveListVm'
            })


            .when('/reserve/:id',{
                templateUrl:'reserve-specific.tmpl.html',
                controller:'ReserveSpecificController',
                controllerAs:'reserveSpecificDetailVm'
            })
            .when('/about',{
                templateUrl:'about.tmpl.html',
                controller:'AboutListController',
                controllerAs:'aboutListVm'
            })
            .when('/status',{
                templateUrl:'status-all.tmpl.html',
                controller:'StatusAllController',
                controllerAs:'statusListVm'
            })
            .when('/status/:id',{
                templateUrl:'reserve-status.tmpl.html',
                controller:'ReserveStatusController',
                controllerAs:'reserveStatusListVm'
            })
            .when('/seatingTable',{
                templateUrl:'seating-table.tmpl.html',
                controller:'SeatingTableController',
                controllerAs:'seatingTableListVm'
            })
            .when('/contact',{
                templateUrl:'contact.tmpl.html',
                controller:'ContactListController',
                controllerAs:'contactListVm'
            })
            .when('/contactAll',{
                templateUrl:'contact-all.tmpl.html',
                controller:'ContactAllListController',
                controllerAs:'contacAlltListVm'
            })
            .otherwise({
                redirectTo:'/home'
            })
    }

})();