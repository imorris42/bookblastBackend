angular.module( 'bookblast', [
  'templates-app',
  'templates-common',
    'spring-data-rest',
  'bookblast',
  'bookblast.home',
  'bookblast.about',
  'bookblast.upload',
  'bookblast.signin',
  'bookblast.signin.login',
  'bookblast.listing',
  'ui.router'
])

.config( function myAppConfig ( $stateProvider,$httpProvider, $urlRouterProvider ) {
    $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
    $urlRouterProvider.otherwise( '/home' );
       // console.log("Route provider in app.js");
})
/*    .factory('indexapi', ['$resource',
        function($resource) {
            return {
                topCategoryResponse: $resource('http://localhost\\:8080/api/toptentags?projection=summary')
            };
        }])*/
    .run( function run () {
    })
.controller( 'AppCtrl', function AppCtrl ( $scope, $location,$http,SpringDataRestAdapter ){

        $http({
            method: 'GET',
            url: '/api/toptentags?projection=summary'
        }).then(function successCallback(response) {
            $scope.topTagList = response.data.content;
            //console.log("get categories in app.js: " + response.data.content);
        }, function errorCallback(response) {
            console.log("Error loading books: " + response);
        });

  $scope.$on('$stateChangeSuccess', function(event, toState, toParams, fromState, fromParams){
    if ( angular.isDefined( toState.data.pageTitle ) ) {
      $scope.pageTitle = toState.data.pageTitle + ' | bookblast' ;
    }
  });
        //var categoriesPromise = $http.get('/api/toptentags?projection=summary');

       // SpringDataRestAdapter.process(categoriesPromise).then(function(processedResponse) {
         //   $scope.topTagList = processedResponse.data.content;

/*            angular.forEach($scope.topTagList, function (category, key) {
                console.log("Category name in app.js: " + category.categoryTitle);
            });*/
        //});

});


