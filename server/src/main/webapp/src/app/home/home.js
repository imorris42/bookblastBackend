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
angular.module( 'bookblast.home', [
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
  $stateProvider.state( 'home', {
    url: '/home',
    views: {
      "main": {
        controller: 'HomeCtrl',
        templateUrl: 'home/home.tpl.html'
      }
    },
    data:{ pageTitle: 'Home' }
  });
})

/**
 * And of course we define a controller for our route.
 */
.factory('api', ['$resource',
    function($resource) {
        //return {
          //  singleBookResponse: $resource('http://localhost\\:8080/api/book/4?projection='),
           // allBooksResponse: $resource('http://localhost\\:8080/api/pagedBooks?page=0&size=20/')
          //  topTagsResponse: $resource('http://localhost\\:8080/api/toptentags/?projection=summary')
       // };
    }])


/*    .factory('bookResponse', function($resource) {
        return $resource('http://localhost\\:8080/books/3?projection=');
    })*/


    .controller('HomeCtrl',function HomeCtrl($scope,$resource,SpringDataRestAdapter,api,$http) {


/*        var bookCarouselPromise = $http.get('/api/pagedBooks?page=0&size=20');

        SpringDataRestAdapter.process(bookCarouselPromise).then(function(processedResponse) {
            $scope.bookList = processedResponse.data.content;
        });*/
        $http({
            method: 'GET',
            url: '/api/pagedBooks?page=0&size=20'
        }).then(function successCallback(response) {
            $scope.bookList = response.data.content;
            //console.log("get booklist in home.js: " + response.data.content);
        }, function errorCallback(response) {
            console.log("Error loading books: " + response);
        });
    }
);

