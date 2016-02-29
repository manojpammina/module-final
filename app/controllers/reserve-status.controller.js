/*
/!**
 * Created by manoj on 2/11/16.
 *!/*/


(function(){
    angular
        .module('rrs')
        .controller('ReserveStatusController',ReserveStatusController);

    ReserveStatusController.$inject=['reserveDataService','$routeParams'];

    function ReserveStatusController(reserveDataService,$routeParams) {

        var reserveStatusListVm = this;
        reserveStatusListVm.status = null;
        console.log("The value od the route params is: " + $routeParams);
        var id=$routeParams.id;
            reserveStatusListVm.show=true;
            reserveDataService
                .getStatusByid(id)
                .then(function (data) {
                    reserveStatusListVm.status = data;
                    console.log('Inside ###' + reserveStatusListVm.status)
                }, function (error) {
                    console.log(error.data);
                })
            console.log('ReserveStatusController');

    }

})();
