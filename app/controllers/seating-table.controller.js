(function(){
    'use strict';
    angular
        .module('rrs')
        .controller('SeatingTableController',SeatingTableController);

    SeatingTableController.$inject=['reserveDataService'];

    function SeatingTableController(reserveDataService){
        var seatingTableListVm=this;

        seatingTableListVm.tables=[];

        reserveDataService
            .getAllTables()
            .then(function(data){
                seatingTableListVm.tables=data;
                console.log(seatingTableListVm.tables);

            },function(error){
                console.log(error);
            });
        console.log("SeatingTableController")
    }

})();