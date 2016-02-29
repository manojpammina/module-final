(function(){
    'use strict';
    angular
        .module('rrs')
        .controller('ContactAllListController',ContactAllListController);

    ContactAllListController.$inject=['reserveDataService'];

    function ContactAllListController(reserveDataService){
        var contacAlltListVm=this;

        contacAlltListVm.contacts=[];

        reserveDataService
            .getAllContacts()
            .then(function(data){
                contacAlltListVm.contacts=data;
                console.log(contacAlltListVm.contacts);

            },function(error){
                console.log(error);
            });
        console.log("StatusAllController")
    }

})();