/**
 * Created by qiaoyunlai on 12/03/2018.
 */
(function () {
    "use strict";
    angular.module('aoHTML').controller("aoHeaderController", [
            "$rootScope", "$scope", "$element", "$location", "securityService", "rbacService", "$timeout", "systemRequest", "deviceService", "userRequest",
            "securityRequest", "$filter", 'store', "Layout", 'rootManager', "resizeService", "alertService", "HelpLink", "$http",
            function ($scope) {
                $scope.getLogoPath = () => {
                    return "../resources/header/logo.png";
                };
            }
        ]);
}());
