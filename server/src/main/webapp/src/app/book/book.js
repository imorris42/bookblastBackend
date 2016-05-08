/**
 * Each section of the site has its own module. It probably also has
 * submodules, though this boilerplate is too simple to demonstrate it. Within
 * `src/app/home`, however, could exist several additional folders representing
 * additional modules that would then be listed as dependencies of this one.
 * For example, a `note` section could have the submodules `note.create`,
 * `note.delete`, `note.edit`, etc.
 *
 * Regardless, so long as dependencies are managed correctly, the build process
 * will automatically take take of the rest.
 *
 * The dependencies block here is also where component dependencies should be
 * specified, as shown below.
 */
angular.module( 'bookblast.book', [
  'ui.router',
  'plusOne',
  'spring-data-rest'
])

/**
 * Each section or module of the site can also have its own routes. AngularJS
 * will handle ensuring they are all available at run-time, but splitting it
 * this way makes each module more "self-contained".
 */
.config(function config( $stateProvider,$httpProvider ) {
        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
  $stateProvider.state( 'book', {
    url: '/book/:bookId',
    views: {
      "main": {
        controller: 'BookCtrl',
        templateUrl: 'book/book.tpl.html'
      }
    },
    data:{ pageTitle: 'Book' }
  });
})

/*.factory('bookApi', ['$resource',
    function($resource) {
        return {
            singleBookResponse: $resource('http://localhost\\:8080/api/book/1?projection=')
        };
    }])*/

/**
 * And of course we define a controller for our route.
 */
    .controller('BookCtrl',function BookCtrl($scope,$http,SpringDataRestAdapter,$stateParams) {
        var bookId =  $stateParams.bookId || 1;

        //var bookPromise = $http.get('/api/book/1?projection=');

        /*        SpringDataRestAdapter.process('/api/book/1?projection=').then(function(processedResponse) {
         $scope.theBook = processedResponse.data.content[0];
         });*/
        $http({
            method: 'GET',
            url: '/api/book/'+bookId+'?projection='
        }).then(function successCallback(response) {
            $scope.theBook = response.data.content[0];
            //console.log("get book in book.js: " + response.data.content);
        }, function errorCallback(response) {
            console.log("Error loading books " + response);
        });
    }
);

