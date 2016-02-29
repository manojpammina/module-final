/*
(function(){
    angular.module('rrs').directive('StatusDirective',StatusDirective);

    function StatusDirective(){
        var ddo= {
            restrict: 'E',
            scope: {
                info: '=',
                greet: '@',
                callback: '&'
            },
            templateUrl: 'reserve-status.tmpl.html',
            link: function (scope, elem, attrs) {
                scope.callback();
                elem.bind('click',function(){
                    console.log(scope.info);
                });
            }
        }
    };
})();*/
