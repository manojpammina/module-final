/**
 * Created by manoj on 2/11/16.
 */
(function(){
    angular
        .module('rrs')
        .controller('ReserveSpecificController',ReserveSpecificController);

    ReserveSpecificController.$inject=['reserveDataService','$routeParams'];

    function ReserveSpecificController(reserveDataService,$routeParams){

        var reserveSpecificDetailVm=this;
        reserveSpecificDetailVm.data=null;
        console.log("The value od the route params is: "+ $routeParams);
        reserveDataService
            .getReservationByid($routeParams.id)
            .then(function(data){
                reserveSpecificDetailVm.reservation=data;
                console.log('Inside ###'+ reserveSpecificDetailVm.reservation)
            },function(error){
                console.log(error.data);
            })
        console.log('ReserveSpecificController');
    }

})();