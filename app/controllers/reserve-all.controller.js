/**
 * Created by manoj on 2/10/16.
 */

(function(){
    'use strict';
    angular
        .module('rrs')
        .controller('ReserveAllListController',ReserveAllListController);

    ReserveAllListController.$inject=['reserveDataService'];

    function ReserveAllListController(reserveDataService){
        var reserveListVm=this;
        reserveListVm.reservations=[];


        reserveDataService
            .getAllReservations()
            .then(function(data){
                reserveListVm.reservations=data;
                console.log(reserveListVm.reservations);

            },function(error){
                console.log(error);
            });
        console.log("ReserveAllListController")
    }


})();



