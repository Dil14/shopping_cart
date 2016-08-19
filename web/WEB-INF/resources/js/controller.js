/**
 * Created by Dilipan on 6/26/2016.
 */

var cartApp =angular.module("cartApp",[]);




cartApp.controller("cartCtrl",function ($scope,$http) {

    $http.defaults.xsrfHeaderName = 'X-CSRF-TOKEN';
    $http.defaults.xsrfCookieName = 'CSRF-TOKEN';

    $scope.refreshCart=function () {
        $http.get("/eMusicStore/rest/cart/"+$scope.cartId).success(function (data) {

            $scope.cart=data;

            //alert(JSON.stringify(data));

            
        });
    };

    $scope.clearCart=function () {
        
        $http.delete("/eMusicStore/rest/cart/"+$scope.cartId).success(function (data)
        {
            $scope.refreshCart();
        });
    };

    $scope.initCartId=function (cartId) {

        $scope.cartId=cartId;

        $scope.refreshCart();
    };
    $scope.addToCart=function (productId) {

        $http.put("/eMusicStore/rest/cart/add/"+productId ).success(function () {

              

              alert("Product successfully added to the cart");
          })
              .error(function(data,status,header,config){
                  alert(data);
              })
    };
    $scope.removeCart=function(productId){
        $http.put("/eMusicStore/rest/cart/remove/"+productId).success(function(data){
            $scope.refreshCart();
        });
    };

    $scope.calculateGrandTotal=function () {

        var grandtotal=0;
        for(var i=0;i<$scope.cart.cartItems.length;i++){
            grandtotal+=$scope.cart.cartItems[i].totalprice;
        }
        return grandtotal;
    }


});
