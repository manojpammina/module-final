/**
 * Created by manoj on 2/10/16.
 */
(function(){

    'use strict';
    angular
        .module('rrs')
        .controller('ContactListController',ContactListController);

    ContactListController.$inject=['reserveDataService'];
    console.log('Inside Contact controller');
    function ContactListController(reserveDataService){
        var contactListVm=this;
        console.log('inside ContactListController function');
        contactListVm.addContact=function(){
            console.log(contactListVm.contact);
            reserveDataService.addContact(contactListVm.contact);
        }
    }
        console.log('ContactListController');
})();