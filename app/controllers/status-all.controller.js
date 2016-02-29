(function(){
    'use strict';
    angular
        .module('rrs')
        .controller('StatusAllController',StatusAllController);

    StatusAllController.$inject=['reserveDataService'];

    function StatusAllController(reserveDataService){
        var statusListVm=this;

        statusListVm.status=[];

        reserveDataService
            .getStatusAll()
            .then(function(data){
                statusListVm.status=data;
                console.log(statusListVm.status);

            },function(error){
                console.log(error);
            });
        console.log("StatusAllController")
    }

})();