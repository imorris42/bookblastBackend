module.exports = function ( karma ) {
  karma.set({
    /** 
     * From where to look for files, starting with the location of this file.
     */
    basePath: '../',

    /**
     * This is the list of file patterns to load into the browser during testing.
     */
    files: [
      'vendor/angular/angular.js',
      'vendor/placeholders/angular-placeholders-0.0.1-SNAPSHOT.min.js',
      'vendor/angular-ui-router/release/angular-ui-router.js',
      'vendor/angular-touch/angular-touch.js',
      'vendor/angular-resource/angular-resource.js',
      'vendor/angular-animate/angular-animate.js',
      'vendor/angular-spring-data-rest/dist/angular-spring-data-rest.js',
      'vendor/angular-ui-grid/ui-grid.js',
      'vendor/boomerang/js/jquery.js',
      'vendor/boomerang/assets/bootstrap/js/bootstrap.js',
      'vendor/boomerang/js/wp.app.js',
      'vendor/boomerang/assets/responsive-mobile-nav/js/jquery.dlmenu.js',
      'vendor/boomerang/assets/responsive-mobile-nav/js/jquery.dlmenu.autofill.js',
      'vendor/boomerang/js/modernizr.custom.js',
      'vendor/boomerang/js/jquery.hoverdir.js',
      'vendor/boomerang/js/jquery.hoverup.js',
      'vendor/boomerang/assets/hover-dropdown/bootstrap-hover-dropdown.min.js',
      'vendor/boomerang/assets/owl-carousel/owl.carousel.js',
      'vendor/boomerang/assets/mixitup/jquery.mixitup.js',
      'vendor/boomerang/assets/mixitup/jquery.mixitup.init.js',
      'vendor/boomerang/assets/fancybox/jquery.fancybox.pack.js',
      'vendor/boomerang/js/jquery.stellar.js',
      'vendor/boomerang/assets/milestone-counter/jquery.countTo.js',
      'vendor/boomerang/assets/page-scroller/jquery.ui.totop.js',
      'vendor/boomerang/assets/waypoints/waypoints.min.js',
      'vendor/boomerang/assets/ui-kit/js/jquery.powerful-placeholder.min.js',
      'vendor/boomerang/assets/ui-kit/js/cusel.min.js',
      'vendor/boomerang/assets/sky-forms/js/jquery.form.min.js',
      'vendor/boomerang/assets/sky-forms/js/jquery.validate.min.js',
      'vendor/boomerang/assets/sky-forms/js/jquery.maskedinput.min.js',
      'vendor/boomerang/assets/sky-forms/js/jquery.modal.js',
      'vendor/boomerang/js/jquery.mousewheel-3.0.6.pack.js',
      'vendor/boomerang/js/jquery.easing.js',
      'vendor/boomerang/js/jquery.metadata.js',
      'vendor/boomerang/assets/sky-forms/js/jquery-ui.min.js',
      'vendor/boomerang/assets/easy-pie-chart/js/jquery.easypiechart.js',
      'vendor/boomerang/assets/social-buttons/js/rrssb.min.js',
      'vendor/boomerang/assets/nouislider/js/jquery.nouislider.min.js',
      'vendor/boomerang/assets/bootstrap/js/tooltip.js',
      'vendor/boomerang/assets/bootstrap/js/popover.js',
      'vendor/boomerang/assets/isotope/isotope.min.js',
      'vendor/boomerang/assets/isotope/fit-columns.js',
      'vendor/boomerang/js/jquery-ui.min.js',
      'build/templates-app.js',
      'build/templates-common.js',
      'vendor/angular-mocks/angular-mocks.js',
      
      'src/**/*.js',
      'src/**/*.coffee',
    ],
    exclude: [
      'src/assets/**/*.js'
    ],
    frameworks: [ 'jasmine' ],
    plugins: [ 'karma-jasmine', 'karma-firefox-launcher', 'karma-coffee-preprocessor' ],
    preprocessors: {
      '**/*.coffee': 'coffee',
    },

    /**
     * How to report, by default.
     */
    reporters: 'dots',

    /**
     * On which port should the browser connect, on which port is the test runner
     * operating, and what is the URL path for the browser to use.
     */
    port: 9018,
    runnerPort: 9100,
    urlRoot: '/',

    /** 
     * Disable file watching by default.
     */
    autoWatch: false,

    /**
     * The list of browsers to launch to test on. This includes only "Firefox" by
     * default, but other browser names include:
     * Chrome, ChromeCanary, Firefox, Opera, Safari, PhantomJS
     *
     * Note that you can also use the executable name of the browser, like "chromium"
     * or "firefox", but that these vary based on your operating system.
     *
     * You may also leave this blank and manually navigate your browser to
     * http://localhost:9018/ when you're running tests. The window/tab can be left
     * open and the tests will automatically occur there during the build. This has
     * the aesthetic advantage of not launching a browser every time you save.
     */
    browsers: [
      'Firefox'
    ]
  });
};

