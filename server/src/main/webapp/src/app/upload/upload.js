angular.module( 'bookblast.upload', [
  'ui.router',
  'placeholders'
  //'ui.bootstrap'
])

.config(function config( $stateProvider ) {
  $stateProvider.state( 'upload', {
    url: '/upload',
    views: {
      "main": {
        controller: 'UploadCtrl',
        templateUrl: 'upload/upload.tpl.html'
      }
    },
    data:{ pageTitle: 'upload a book' }
  });
})

.controller( 'UploadCtrl', function AboutCtrl( $scope ) {
  // This is simple a demo for UI Boostrap.
  $scope.dropdownDemoItems = [
    "The first choice!",
    "And another choice for you.",
    "but wait! A third!"
  ];
})

;
