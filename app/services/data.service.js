/**
 * Created by manoj on 2/10/16.
 */
(function(){
    angular.module('rrs').service('reserveDataService',reserveDataService);

    reserveDataService.$inject=['$http','$q'];
    function reserveDataService($http,$q) {
        var self = this;
        self.getAllReservations=getAllReservations;
        self.getReservationByid=getReservationByid;
        self.addReservation=addReservation;
        self.getStatusByid=getStatusByid;
        self.getStatusAll=getStatusAll;
        self.getAllTables = getAllTables;
        self.getAllContacts =getAllContacts;
        self.addReservation=addReservation;
        self.addContact=addContact;



            function getAllReservations() {
            var defer = $q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/reservations/')
                .then(function (response) {
                    defer.resolve(response.data);
                    console.log(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        function getReservationByid(id){
            console.log("Inside data service of specific reservation controller");
            var defer=$q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/reservations/' +id)
                .then(function(response){
                    defer.resolve(response.data);
                    console.log(response.data);
                },function(error){
                    defer.reject(error.data);
                });
            console.log('outside of the function'+ defer.promise);
            return defer.promise;
        }




       function getStatusByid(id){
            console.log("Inside data service of status reservation controller");
            var defer=$q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/status/' +id)
                .then(function(response){
                    defer.resolve(response.data);
                    console.log(response.data);
                },function(error){
                    defer.reject(error.data);
                });
            console.log('outside of the status function'+ defer.promise);
            return defer.promise;
        }

        function getStatusAll () {
            var defer = $q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/status/')
                .then(function (response) {
                    defer.resolve(response.data);
                    console.log(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        function  getAllTables() {
            var defer = $q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/seating/')
                .then(function (response) {
                    defer.resolve(response.data);
                    console.log(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };

        function getAllContacts() {
            var defer = $q.defer();
            $http
                .get('http://localhost:8085/RRS/rrs/contact/')
                .then(function (response) {
                    defer.resolve(response.data);
                    console.log(response.data);
                }, function (error) {
                    defer.reject(error.status);
                });
            return defer.promise;
        };
        function addReservation(data){
            console.log(data);
            $http.post('http://localhost:8085/RRS/rrs/reservations/', data).success(function(data, status) {
                console.log("on click event on add reservation button");
            })

        };
        function addContact(data){
            console.log(data);
            $http.post('http://localhost:8085/RRS/rrs/contact', data).success(function(data, status) {
                console.log("on click event on contact button");
            })

        };
    }
})();
