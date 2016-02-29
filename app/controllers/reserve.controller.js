/**
 * Created by manoj on 2/10/16.
 */

(function(){
    'use strict';
    angular
        .module('rrs')
        .controller('ReserveListController',ReserveListController);

   ReserveListController.$inject=['reserveDataService'];

    function ReserveListController(reserveDataService){
        var reserveAllListVm=this;
        reserveAllListVm.addReservation=function(){
            console.log(reserveAllListVm.reservation);
            reserveDataService.addReservation(reserveAllListVm.reservation);
        }
    }

})();



