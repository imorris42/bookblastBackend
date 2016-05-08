angular.module('templates-app', ['about/about.tpl.html', 'book/book.tpl.html', 'home/home.tpl.html', 'listing/listing.tpl.html', 'signin/login/login.tpl.html', 'signin/signin.tpl.html', 'upload/upload.tpl.html']);

angular.module("about/about.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("about/about.tpl.html",
    "<section class=\"slice bg-white\">\n" +
    "    <div class=\"wp-section work\">\n" +
    "      The database will function as both a detailed catalogue of a virtual collection and an electronic\n" +
    "      commons for the exchange of detailed information on actual material publications produced by\n" +
    "      artists.\n" +
    "    <h3>Why?</h3>\n" +
    "\n" +
    "      It represents a departure and a novel approach to the circulation and exchange of information\n" +
    "      available on artists' publications, combining an historical record of artists publishing, with\n" +
    "      immediate up-to-date entries, contributed to globally by the unique knowledge of artists,\n" +
    "      publishers, and organisations invested in artists publishing: a community of users.\n" +
    "      The principle of the wiki and user/editor interface applied to the notion of an archive represents a\n" +
    "      radical new approach.\n" +
    "\n" +
    "    <br><br>\n" +
    "      Traditionally the quality and integrity of information contained in archives is guaranteed and\n" +
    "      protected by the institution. The project we are proposing introduces the possibility for users and\n" +
    "      producers to create their own metadata: crucial information that structures a new model in\n" +
    "      retrieving information, to further understand, disseminate and share, creating new possibilities in\n" +
    "      knowledge production. The investment of contributors to the database as a working model, a tool,\n" +
    "      will help to guarantee the quality of information held there.\n" +
    "\n" +
    "        </div>\n" +
    "    </section>\n" +
    "\n" +
    "");
}]);

angular.module("book/book.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("book/book.tpl.html",
    "    <!-- MAIN CONTENT -->\n" +
    "    <section class=\"slice bg-white\" >\n" +
    "            <div class=\"wp-section\">\n" +
    "                <div class=\"container\">\n" +
    "                    <div class=\"row\">\n" +
    "                        <div class=\"col-md-8\">\n" +
    "\n" +
    "                            <div class=\"row\">\n" +
    "                                <div class=\"col-md-12\">\n" +
    "                                    <div class=\"wp-block article post\">\n" +
    "                                        <div class=\"figure\">\n" +
    "                                            <!-- Book title -->\n" +
    "                                            <h2 class=\"article-title\">{{theBook.mainTitle}}</h2>\n" +
    "                                            <div class=\"inline-tags mb-20\">\n" +
    "                                                <span class=\"label base\">{{theBook._embedded.categories[0].categoryTitle}}</span>\n" +
    "                                                <span class=\"label base\">{{theBook._embedded.categories[1].categoryTitle}}</span>\n" +
    "                                                <span class=\"label base\">{{theBook._embedded.categories[2].categoryTitle}}</span>\n" +
    "                                                <span class=\"label base\">{{theBook._embedded.categories[3].categoryTitle}}</span>\n" +
    "                                            </div>\n" +
    "                                            <!-- Article image -->\n" +
    "                                            <div class=\"article-image\">\n" +
    "                                                <img src=\"assets/images/covers114.jpg\" alt=\"\" >\n" +
    "                                            </div>\n" +
    "                                            <div>\n" +
    "                                                <!-- Article content -->\n" +
    "                                                <p>\n" +
    "                                                    {{theBook.subTitle}}\n" +
    "                                                </p>\n" +
    "                                                <p>\n" +
    "                                                    {{theBook.briefDescription}}\n" +
    "                                                </p>\n" +
    "                                                <p>\n" +
    "                                                    {{theBook.fullDescription}}\n" +
    "                                                </p>\n" +
    "\n" +
    "                                            </div>\n" +
    "                                            <!-- Meta info -->\n" +
    "                                            <div class=\"meta-info\">\n" +
    "                                            <span>\n" +
    "                                                <strong>Author:</strong> {{theBook.author}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>ISBN13:</strong> {{theBook.isbn13}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Format:</strong> {{theBook.productFormatCode}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Pages:</strong> {{theBook.paginationNumeric}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Published in:</strong> {{theBook.placeOfPublication}} {{theBook.countryOfPublication}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Author:</strong> {{theBook.author}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Author website:</strong>\n" +
    "                                                <a href=\"{{theBook.authorWebsite}}\">{{theBook.authorWebsite}}</a>\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Publisher:</strong> {{theBook.publisherName}}\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>Publisher website:</strong>\n" +
    "                                                <a href=\"{{theBook.publisherWebsite}}\">{{theBook.publisherWebsite}}</a>\n" +
    "                                            </span>\n" +
    "                                            <span>\n" +
    "                                                <strong>publicationDate:</strong>\n" +
    "                                                <a href=\"#\">{{theBook.publicationDate}}</a>\n" +
    "                                            </span>\n" +
    "                                            </div>\n" +
    "                                            <!-- Social buttons -->\n" +
    "                                            <ul class=\"rrssb-buttons clearfix mt-20 mb-20\">\n" +
    "                                                <li class=\"email\">\n" +
    "                                                    <a href=\"mailto:?subject=Check%20out%20how%20this%20incredible%20responsive%20template:%20Boomerang%202&amp;body=https%3A%2F%2Fwrapbootstrap.com/theme/boomerang-multipurpose-template-WB021609D\">\n" +
    "                                                    <span class=\"icon\">\n" +
    "                                                        <svg xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" version=\"1.1\" x=\"0px\" y=\"0px\" width=\"28px\" height=\"28px\" viewBox=\"0 0 28 28\" enable-background=\"new 0 0 28 28\" xml:space=\"preserve\"><g><path d=\"M20.111 26.147c-2.336 1.051-4.361 1.401-7.125 1.401c-6.462 0-12.146-4.633-12.146-12.265 c0-7.94 5.762-14.833 14.561-14.833c6.853 0 11.8 4.7 11.8 11.252c0 5.684-3.194 9.265-7.399 9.3 c-1.829 0-3.153-0.934-3.347-2.997h-0.077c-1.208 1.986-2.96 2.997-5.023 2.997c-2.532 0-4.361-1.868-4.361-5.062 c0-4.749 3.504-9.071 9.111-9.071c1.713 0 3.7 0.4 4.6 0.973l-1.169 7.203c-0.388 2.298-0.116 3.3 1 3.4 c1.673 0 3.773-2.102 3.773-6.58c0-5.061-3.27-8.994-9.303-8.994c-5.957 0-11.175 4.673-11.175 12.1 c0 6.5 4.2 10.2 10 10.201c1.986 0 4.089-0.43 5.646-1.245L20.111 26.147z M16.646 10.1 c-0.311-0.078-0.701-0.155-1.207-0.155c-2.571 0-4.595 2.53-4.595 5.529c0 1.5 0.7 2.4 1.9 2.4 c1.441 0 2.959-1.828 3.311-4.087L16.646 10.068z\"/></g></svg>\n" +
    "                                                    </span>\n" +
    "                                                        <span class=\"text\">email</span>\n" +
    "                                                    </a>\n" +
    "                                                </li>\n" +
    "                                                <li class=\"facebook\">\n" +
    "                                                    <a href=\"https://www.facebook.com/sharer/sharer.php?u=https://wrapbootstrap.com/theme/boomerang-multipurpose-template-WB021609D\" class=\"popup\">\n" +
    "                                                    <span class=\"icon\">\n" +
    "                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" width=\"28px\" height=\"28px\" viewBox=\"0 0 28 28\" enable-background=\"new 0 0 28 28\" xml:space=\"preserve\">\n" +
    "                                                            <path d=\"M27.825,4.783c0-2.427-2.182-4.608-4.608-4.608H4.783c-2.422,0-4.608,2.182-4.608,4.608v18.434\n" +
    "                                                                c0,2.427,2.181,4.608,4.608,4.608H14V17.379h-3.379v-4.608H14v-1.795c0-3.089,2.335-5.885,5.192-5.885h3.718v4.608h-3.726\n" +
    "                                                                c-0.408,0-0.884,0.492-0.884,1.236v1.836h4.609v4.608h-4.609v10.446h4.916c2.422,0,4.608-2.188,4.608-4.608V4.783z\"/>\n" +
    "                                                        </svg>\n" +
    "                                                    </span>\n" +
    "                                                        <span class=\"text\">facebook</span>\n" +
    "                                                    </a>\n" +
    "                                                </li>\n" +
    "                                                <li class=\"twitter\">\n" +
    "                                                    <a href=\"http://twitter.com/home?status=Bookblast\" class=\"popup\">\n" +
    "                                                    <span class=\"icon\">\n" +
    "                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\"\n" +
    "                                                             width=\"28px\" height=\"28px\" viewBox=\"0 0 28 28\" enable-background=\"new 0 0 28 28\" xml:space=\"preserve\">\n" +
    "                                                        <path d=\"M24.253,8.756C24.689,17.08,18.297,24.182,9.97,24.62c-3.122,0.162-6.219-0.646-8.861-2.32\n" +
    "                                                            c2.703,0.179,5.376-0.648,7.508-2.321c-2.072-0.247-3.818-1.661-4.489-3.638c0.801,0.128,1.62,0.076,2.399-0.155\n" +
    "                                                            C4.045,15.72,2.215,13.6,2.115,11.077c0.688,0.275,1.426,0.407,2.168,0.386c-2.135-1.65-2.729-4.621-1.394-6.965\n" +
    "                                                            C5.575,7.816,9.54,9.84,13.803,10.071c-0.842-2.739,0.694-5.64,3.434-6.482c2.018-0.623,4.212,0.044,5.546,1.683\n" +
    "                                                            c1.186-0.213,2.318-0.662,3.329-1.317c-0.385,1.256-1.247,2.312-2.399,2.942c1.048-0.106,2.069-0.394,3.019-0.851\n" +
    "                                                            C26.275,7.229,25.39,8.196,24.253,8.756z\"/>\n" +
    "                                                        </svg>\n" +
    "                                                    </span>\n" +
    "                                                        <span class=\"text\">twitter</span>\n" +
    "                                                    </a>\n" +
    "                                                </li>\n" +
    "                                                <li class=\"googleplus\" data-initwidth=\"14.285714285714286\" data-size=\"52\" style=\"width: 14.285714285714286%;\">\n" +
    "                                                    <!-- Replace href with your meta and URL information.  -->\n" +
    "                                                    <a href=\"https://plus.google.com/share?url=Bookblast\" class=\"popup\">\n" +
    "                                                    <span class=\"icon\">\n" +
    "                                                        <svg version=\"1.1\" id=\"Layer_1\" xmlns=\"http://www.w3.org/2000/svg\" xmlns:xlink=\"http://www.w3.org/1999/xlink\" x=\"0px\" y=\"0px\" width=\"28px\" height=\"28px\" viewBox=\"0 0 28 28\" enable-background=\"new 0 0 28 28\" xml:space=\"preserve\">\n" +
    "                                                            <g>\n" +
    "                                                                <g>\n" +
    "                                                                    <path d=\"M14.703,15.854l-1.219-0.948c-0.372-0.308-0.88-0.715-0.88-1.459c0-0.748,0.508-1.223,0.95-1.663\n" +
    "                                                                        c1.42-1.119,2.839-2.309,2.839-4.817c0-2.58-1.621-3.937-2.399-4.581h2.097l2.202-1.383h-6.67c-1.83,0-4.467,0.433-6.398,2.027\n" +
    "                                                                        C3.768,4.287,3.059,6.018,3.059,7.576c0,2.634,2.022,5.328,5.604,5.328c0.339,0,0.71-0.033,1.083-0.068\n" +
    "                                                                        c-0.167,0.408-0.336,0.748-0.336,1.324c0,1.04,0.551,1.685,1.011,2.297c-1.524,0.104-4.37,0.273-6.467,1.562\n" +
    "                                                                        c-1.998,1.188-2.605,2.916-2.605,4.137c0,2.512,2.358,4.84,7.289,4.84c5.822,0,8.904-3.223,8.904-6.41\n" +
    "                                                                        c0.008-2.327-1.359-3.489-2.829-4.731H14.703z M10.269,11.951c-2.912,0-4.231-3.765-4.231-6.037c0-0.884,0.168-1.797,0.744-2.511\n" +
    "                                                                        c0.543-0.679,1.489-1.12,2.372-1.12c2.807,0,4.256,3.798,4.256,6.242c0,0.612-0.067,1.694-0.845,2.478\n" +
    "                                                                        c-0.537,0.55-1.438,0.948-2.295,0.951V11.951z M10.302,25.609c-3.621,0-5.957-1.732-5.957-4.142c0-2.408,2.165-3.223,2.911-3.492\n" +
    "                                                                        c1.421-0.479,3.25-0.545,3.555-0.545c0.338,0,0.52,0,0.766,0.034c2.574,1.838,3.706,2.757,3.706,4.479\n" +
    "                                                                        c-0.002,2.073-1.736,3.665-4.982,3.649L10.302,25.609z\"></path>\n" +
    "                                                                    <polygon points=\"23.254,11.89 23.254,8.521 21.569,8.521 21.569,11.89 18.202,11.89 18.202,13.604 21.569,13.604 21.569,17.004\n" +
    "                                                                        23.254,17.004 23.254,13.604 26.653,13.604 26.653,11.89\">\n" +
    "                                                                    </polygon>\n" +
    "                                                                </g>\n" +
    "                                                            </g>\n" +
    "                                                        </svg>\n" +
    "                                                    </span>\n" +
    "                                                        <span class=\"text\">google+</span>\n" +
    "                                                    </a>\n" +
    "                                                </li>\n" +
    "                                            </ul>\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </div>\n" +
    "\n" +
    "                            <!-- User comments section -->\n" +
    "                            <div class=\"comment-list clearfix\" id=\"comments\">\n" +
    "                                <h2 class=\"comment-count\">4 Readers Commented</h2>\n" +
    "                                <a href=\"#addcomments\" class=\"link-add-comment anchor\" hidefocus=\"true\">Join Discussion</a>\n" +
    "\n" +
    "                                <ol>\n" +
    "                                    <li class=\"comment\">\n" +
    "                                        <div class=\"comment-body boxed\">\n" +
    "                                            <div class=\"comment-avatar\">\n" +
    "                                                <div class=\"avatar\"><img src=\"assets/images/alma.png\" alt=\"\"></div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"comment-text\">\n" +
    "                                                <div class=\"comment-author clearfix\">\n" +
    "                                                    <a href=\"#\" class=\"link-author\" hidefocus=\"true\">Ian</a>\n" +
    "                                                    <span class=\"comment-meta\"><span class=\"comment-date\">June 26, 2013</span> | <a href=\"#addcomments\" class=\"link-reply anchor\" hidefocus=\"true\">Reply</a></span>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"comment-entry\">\n" +
    "                                                    Tihs is a comment\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                    </li>\n" +
    "\n" +
    "                                    <li class=\"comment\">\n" +
    "                                        <div class=\"comment-body boxed\">\n" +
    "                                            <div class=\"comment-avatar\">\n" +
    "                                                <div class=\"avatar\"><img src=\"assets/images/maud.png\" alt=\"\"></div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"comment-text\">\n" +
    "                                                <div class=\"comment-author clearfix\">\n" +
    "                                                    <a href=\"#\" class=\"link-author\" hidefocus=\"true\">Ari</a>\n" +
    "                                                    <span class=\"comment-meta\"><span class=\"comment-date\">June 25, 2013</span> | <a href=\"#addcomments\" class=\"link-reply anchor\" hidefocus=\"true\">Reply</a></span>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"comment-entry\">\n" +
    "                                                    Comment\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                        <!-- comment reply -->\n" +
    "                                        <ul class=\"children\">\n" +
    "                                            <li class=\"comment\">\n" +
    "                                                <div class=\"comment-body boxed\">\n" +
    "                                                    <div class=\"comment-avatar\">\n" +
    "                                                        <div class=\"avatar\"><img src=\"assets/images/alma.png\" alt=\"\"></div>\n" +
    "                                                    </div>\n" +
    "                                                    <div class=\"comment-text\">\n" +
    "                                                        <div class=\"comment-author clearfix\">\n" +
    "                                                            <a href=\"#\" class=\"link-author\" hidefocus=\"true\">Ami</a>\n" +
    "                                                            <span class=\"comment-meta\"><span class=\"comment-date\">June 24, 2013</span> | <a href=\"#addcomments\" class=\"link-reply anchor\" hidefocus=\"true\">Reply</a></span>\n" +
    "                                                        </div>\n" +
    "                                                        <div class=\"comment-entry\">\n" +
    "                                                            Another comment\n" +
    "                                                        </div>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </li>\n" +
    "                                        </ul>\n" +
    "                                        <!--/ comment reply -->\n" +
    "                                    </li>\n" +
    "\n" +
    "                                    <li class=\"comment\">\n" +
    "                                        <div class=\"comment-body boxed\">\n" +
    "                                            <div class=\"comment-avatar\">\n" +
    "                                                <div class=\"avatar\"><img src=\"assets/images/maud.png\" alt=\"\"></div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"comment-text\">\n" +
    "                                                <div class=\"comment-author clearfix\">\n" +
    "                                                    <a href=\"#\" class=\"link-author\" hidefocus=\"true\">Arnaud</a>\n" +
    "                                                    <span class=\"comment-meta\"><span class=\"comment-date\">June 23, 2013</span> | <a href=\"#addcomments\" class=\"link-reply anchor\" hidefocus=\"true\">Reply</a></span>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"comment-entry\">\n" +
    "                                                    Another comment\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                    </li>\n" +
    "                                </ol>\n" +
    "                            </div>\n" +
    "\n" +
    "                            <!-- Comment box -->\n" +
    "                            <div class=\"section-title-wr\">\n" +
    "                                <h3 class=\"section-title left\"><span>Comment box</span></h3>\n" +
    "                            </div>\n" +
    "\n" +
    "                            <form class=\"form-light\" role=\"form\">\n" +
    "                                <p>\n" +
    "                                    add you comment\n" +
    "                                </p>\n" +
    "\n" +
    "                                <div class=\"row\">\n" +
    "                                    <div class=\"col-md-6\">\n" +
    "                                        <div class=\"form-group form-group-lg\">\n" +
    "                                            <label class=\"\">First name</label>\n" +
    "                                            <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Your first name\" hidefocus=\"true\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"col-md-6\">\n" +
    "                                        <div class=\"form-group form-group-lg\">\n" +
    "                                            <label class=\"\">Last name</label>\n" +
    "                                            <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Your last name\" hidefocus=\"true\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div class=\"row\">\n" +
    "                                    <div class=\"col-md-6\">\n" +
    "                                        <div class=\"form-group form-group-lg\">\n" +
    "                                            <label class=\"\">Email</label>\n" +
    "                                            <input type=\"text\" class=\"form-control input-lg\" placeholder=\"Your name\" hidefocus=\"true\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"col-md-6\">\n" +
    "                                        <div class=\"form-group form-group-lg\">\n" +
    "                                            <label class=\"\">Website</label>\n" +
    "                                            <input type=\"text\" class=\"form-control input-lg\" placeholder=\"name@example.com\" hidefocus=\"true\">\n" +
    "                                        </div>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div class=\"form-group form-group-lg\">\n" +
    "                                    <label class=\"\">Comment</label>\n" +
    "                                    <textarea class=\"form-control\" rows=\"5\" placeholder=\"Type you comment\"></textarea>\n" +
    "                                </div>\n" +
    "\n" +
    "                                <div class=\"row\">\n" +
    "                                    <div class=\"col-md-6 col-md-offset-6\">\n" +
    "                                        <button class=\"btn btn-lg btn-alt btn-icon btn-icon-right btn-comment pull-right\" hidefocus=\"true\">\n" +
    "                                            <span>Send comment</span>\n" +
    "                                        </button>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </form>\n" +
    "                        </div>\n" +
    "\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "    </section>");
}]);

angular.module("home/home.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("home/home.tpl.html",
    "<section class=\"slice bg-white animate-hover-slide\">\n" +
    "    <div class=\"wp-section work\" style=\"!important;min-height: 2400px\">\n" +
    "            <div class=\"row\">\n" +
    "                <div class=\"col-md-9\">\n" +
    "                    <div class=\"sort-list-btn hidden-xs\">\n" +
    "                        <button type=\"button\" class=\"btn btn-base filter active\" data-filter=\"all\"><i class=\"fa fa-th-large\"></i> show all</button>\n" +
    "                        <button type=\"button\" class=\"btn btn-white filter\" data-filter=\"category_1 category_2 category_3\"> {{topTagList[0].categoryTitle}}</button>\n" +
    "                        <button type=\"button\" class=\"btn btn-white filter\" data-filter=\"category_3 category_5 category_6 category_7 category_8\"> {{topTagList[1].categoryTitle}}</button>\n" +
    "                        <button type=\"button\" class=\"btn btn-white filter\" data-filter=\"category_6 category_7 category_9\"> {{topTagList[2].categoryTitle}}</button>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "                <div class=\"col-md-2\">\n" +
    "                    <div class=\"btn-group pull-right hidden-md hidden-lg\">\n" +
    "                        <button type=\"button\" class=\"btn btn-three\">Filter projects</button>\n" +
    "                        <button type=\"button\" class=\"btn btn-three dropdown-toggle\" data-toggle=\"dropdown\">\n" +
    "                            <span class=\"caret\"></span>\n" +
    "                        </button>\n" +
    "                        <ul class=\"dropdown-menu pull-right\" role=\"menu\" id=\"ulFilterMenu\">\n" +
    "                            <li class=\"filter active\" data-filter=\"all\"><a>show all</a></li>\n" +
    "                            <li class=\"filter\" data-filter=\"category_1 category_2 category_3\"><a>{{topTagList[0].categoryTitle}}/></a></li>\n" +
    "                            <li class=\"filter\" data-filter=\"category_3 category_5 category_6 category_7 category_8\"><a>{{topTagList[1].categoryTitle}}</a></li>\n" +
    "                            <li class=\"filter\" data-filter=\"category_6 category_7 category_8\"><a> {{topTagList[2].categoryTitle}}</a></li>\n" +
    "                        </ul>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "\n" +
    "            <div class=\"row\">\n" +
    "\n" +
    "                <div id=\"ulSorList\" style=\"margin:15px 15px;!important;min-height: 2400px;\">\n" +
    "\n" +
    "                    <div class=\"mix category_1 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"1\">\n" +
    "                        <div class=\"wp-block inverse\"  style=\"!important;min-height: 200px\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[0].id})\" style=\"!important;height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\" height=\"200\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[0].author}}</p>\n" +
    "                                    <p>{{bookList[0].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_2 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"2\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[1].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[1].author}}</p>\n" +
    "                                    <p>{{bookList[1].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_3 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"3\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[2].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[2].author}}</p>\n" +
    "                                    <p>{{bookList[2].mainTitle}}</p>\n" +
    "                                 </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_4 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"4\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <div class=\"wp-block inverse\">\n" +
    "                                <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[3].id})\" style=\"height: 200px\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                    <div class=\"caption base\">\n" +
    "                                        <p class=\"title\">{{bookList[3].author}}</p>\n" +
    "                                        <p>{{bookList[3].mainTitle}}</p>\n" +
    "                                    </div>\n" +
    "                                </a>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_5 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"5\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[4].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[4].author}}</p>\n" +
    "                                    <p>{{bookList[4].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_6 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"6\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[5].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[5].author}}</p>\n" +
    "                                    <p>{{bookList[5].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_7 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"7\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[6].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[6].author}}</p>\n" +
    "                                    <p>{{bookList[6].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_8 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"8\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[7].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[7].author}}</p>\n" +
    "                                    <p>{{bookList[7].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_9 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"9\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[8].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[8].author}}</p>\n" +
    "                                    <p>{{bookList[8].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <div class=\"mix category_10 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"10\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" ui-sref=\"book({bookId: bookList[9].id})\" style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <p class=\"title\">{{bookList[9].author}}</p>\n" +
    "                                    <p>{{bookList[9].mainTitle}}</p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                    <!--<div class=\"mix category_11 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"11\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" href=\"#\"  style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <h2 class=\"title\">book title</h2>\n" +
    "                                    <p>\n" +
    "                                        description.\n" +
    "                                    </p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>-->\n" +
    "                    <!--<div class=\"mix category_12 col-lg-4 col-md-4 col-sm-4 mix_all\" data-cat=\"12\">\n" +
    "                        <div class=\"wp-block inverse\">\n" +
    "                            <a class=\"hov {shiftContent:30}\" href=\"#\"  style=\"height: 200px\">\n" +
    "                                <img src=\"assets/images/sampleCover.jpg\" alt=\"\" class=\"img-responsive\">\n" +
    "                                <div class=\"caption base\">\n" +
    "                                    <h2 class=\"title\">book title</h2>\n" +
    "                                    <p>\n" +
    "                                        description.\n" +
    "                                    </p>\n" +
    "                                </div>\n" +
    "                            </a>\n" +
    "                        </div>\n" +
    "                    </div>-->\n" +
    "                    <div class=\"gap\"></div>\n" +
    "                </div>\n" +
    "\n" +
    "            </div>\n" +
    "</div>\n" +
    "    </section>\n" +
    "\n" +
    "");
}]);

angular.module("listing/listing.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("listing/listing.tpl.html",
    "    <!-- MAIN CONTENT -->\n" +
    "    <section class=\"slice bg-white\" style=\"min-height: 1900px; min-width: 760px;\" >\n" +
    "                    <div class=\"col-md-10\">\n" +
    "                        <div class=\"wp-block default product-list-filters light-gray\">\n" +
    "                            <ul class=\"pagination pagination pull-left\">\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">«</a></li>\n" +
    "                                <li class=\"active\"><a href=\"#\" hidefocus=\"true\">1</a></li>\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">2</a></li>\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">3</a></li>\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">4</a></li>\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">5</a></li>\n" +
    "                                <li><a href=\"#\" hidefocus=\"true\">»</a></li>\n" +
    "                            </ul>\n" +
    "                            <div class=\"filter sort-filter pull-right\">\n" +
    "                                <label>Sort by</label>\n" +
    "                                <select>\n" +
    "                                    <option>Author</option>\n" +
    "                                    <option>Title</option>\n" +
    "                                    <option>Publisher</option>\n" +
    "                                </select>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                        <ul class=\"list-listings-2\">\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[0].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[0].id})\">{{bookList[0].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[0].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[0].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[0].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[0].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[0].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div> \n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[1].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[1].id})\">{{bookList[1].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[1].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[1].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[1].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[1].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[1].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[2].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[2].id})\">{{bookList[2].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[2].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[2].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[2].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[2].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[2].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[3].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[3].id})\">{{bookList[3].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[3].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[3].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[3].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[3].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[3].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[4].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[4].id})\">{{bookList[4].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[4].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[4].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[4].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[4].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[4].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[5].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[5].id})\">{{bookList[5].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[5].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[5].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[5].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[5].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[5].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                            <li class=\"\">\n" +
    "                                <div class=\"listing-image\">\n" +
    "                                    <img src=\"assets/images/sampleCover.jpg\" class=\"img-responsive\" alt=\"\">\n" +
    "                                    <a ui-sref=\"book({bookId: bookList[6].id})\" class=\"btn btn-lg btn-square btn-light btn-block-bm btn-icon btn-icon-go\"> comment</a>\n" +
    "                                </div>\n" +
    "                                <div class=\"cell\">\n" +
    "                                    <div class=\"listing-body clearfix\">\n" +
    "                                        <h3><a ui-sref=\"book({bookId: bookList[6].id})\">{{bookList[6].mainTitle}}</a></h3>\n" +
    "                                        <h4>{{bookList[6].subTitle}}</h4>\n" +
    "                                        <p>\n" +
    "                                            {{bookList[6].briefDescription}}\n" +
    "                                        </p>\n" +
    "                                    </div>\n" +
    "                                    <div class=\"listing-footer\">\n" +
    "                                        <ul class=\"aux-info\">\n" +
    "                                            <li><i class=\"fa fa-calendar\"></i><strong>Date:</strong> {{bookList[6].publicationDate}}</li>\n" +
    "                                            <li><i class=\"fa fa-user\"></i><strong>Author:</strong> {{bookList[6].author}}</li>\n" +
    "                                            <li><i class=\"fa fa-globe\"></i><strong>Publisher name:</strong> {{bookList[6].publisherName}}</li>\n" +
    "                                        </ul>\n" +
    "                                    </div>\n" +
    "                                </div>\n" +
    "                            </li>\n" +
    "                        </ul>\n" +
    "                    </div>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "\n" +
    "        </ul>\n" +
    "        </div>\n" +
    "    </section>");
}]);

angular.module("signin/login/login.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("signin/login/login.tpl.html",
    "    <section class=\" slice-lg bg-image\" style=\"background-image:url(assets/images/ec1.JPG)\">\n" +
    "        <div class=\"wp-section\">\n" +
    "            <div class=\"container\">\n" +
    "                <div class=\"row\">\n" +
    "                    <div class=\"col-md-5 col-md-offset-2 col-sm-6 col-sm-offset-3\">\n" +
    "                        <div class=\"wp-block default user-form user-form-alpha no-margin\">\n" +
    "                            <div class=\"form-header\">\n" +
    "                                <h6>login and contribute to bookblast</h6>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-body\">\n" +
    "                                <form action=\"\" id=\"frmRegister\" class=\"sky-form\">\n" +
    "                                    <fieldset class=\"no-padding\">\n" +
    "                                        <section class=\"\">\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-xs-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                            <input type=\"text\" name=\"username\" placeholder=\"Username\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to enter the website</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-xs-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <div class=\"form-group\">\n" +
    "                                                            <label class=\"input\">\n" +
    "                                                                <i class=\"icon-append fa fa-envelope-o\"></i>\n" +
    "                                                                <input type=\"email\" name=\"email\" placeholder=\"E-mail\">\n" +
    "                                                                <b class=\"tooltip tooltip-bottom-right\">Needed to verify your account</b>\n" +
    "                                                            </label>\n" +
    "                                                        </div>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-md-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                            <input type=\"text\" name=\"username\" placeholder=\"Password\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to enter the website</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-md-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                            <input type=\"email\" name=\"email\" placeholder=\"Password\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to verify your account</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section class=\"no-margin\">\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                        <input type=\"text\" name=\"fname\" placeholder=\"First name\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                        <input type=\"text\" name=\"lname\" placeholder=\"Last name\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-building\"></i>\n" +
    "                                                        <input type=\"email\" name=\"email\" placeholder=\"Company\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-phone\"></i>\n" +
    "                                                        <input type=\"tel\" name=\"phone\" placeholder=\"Phone\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                            </div>\n" +
    "                                        </section>\n" +
    "                                    </fieldset>\n" +
    "\n" +
    "                                    <fieldset>\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <section class=\"col-xs-5\">\n" +
    "                                                <label class=\"select\">\n" +
    "                                                    <select name=\"country\">\n" +
    "                                                        <option value=\"0\" selected=\"\" disabled=\"\">Country</option>\n" +
    "                                                        <option value=\"244\">Aaland Islands</option>\n" +
    "                                                        <option value=\"1\">Afghanistan</option>\n" +
    "                                                        <option value=\"2\">Albania</option>\n" +
    "                                                        <option value=\"3\">Algeria</option>\n" +
    "                                                        <option value=\"4\">American Samoa</option>\n" +
    "                                                        <option value=\"5\">Andorra</option>\n" +
    "                                                        <option value=\"6\">Angola</option>\n" +
    "                                                        <option value=\"7\">Anguilla</option>\n" +
    "                                                        <option value=\"8\">Antarctica</option>\n" +
    "                                                        <option value=\"9\">Antigua and Barbuda</option>\n" +
    "                                                        <option value=\"10\">Argentina</option>\n" +
    "                                                    </select>\n" +
    "                                                    <i></i>\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "\n" +
    "                                            <section class=\"col-xs-4\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <input type=\"text\" name=\"city\" placeholder=\"City\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "\n" +
    "                                            <section class=\"col-xs-3\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <input type=\"text\" name=\"code\" placeholder=\"Post code\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                        </div>\n" +
    "\n" +
    "                                        <section>\n" +
    "                                            <label for=\"file\" class=\"input\">\n" +
    "                                                <input type=\"text\" name=\"address\" placeholder=\"Address\">\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section>\n" +
    "                                            <label class=\"textarea\">\n" +
    "                                                <textarea rows=\"3\" name=\"info\" placeholder=\"Additional info\"></textarea>\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "                                        <section>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-md-8\">\n" +
    "                                                    <label class=\"checkbox\">\n" +
    "                                                        <input type=\"checkbox\" name=\"subscription\" id=\"subscription\">\n" +
    "                                                        <i></i> I accept the <a href=\"#\">terms and conditions</a> of this website.\n" +
    "                                                    </label>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-md-4\">\n" +
    "                                                    <button class=\"btn btn-alt btn-icon btn-icon-right btn-icon-go pull-right\" type=\"submit\">\n" +
    "                                                        <span>Register now</span>\n" +
    "                                                    </button>\n" +
    "                                                </div>\n" +
    "                                        </section>\n" +
    "                                    </fieldset>\n" +
    "                                </form>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-footer\">\n" +
    "                                <p>Already have an account? <a href=\"sign-in-1.html\">Click here to sign in.</a></p>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </section>\n" +
    "\n" +
    "\n" +
    "");
}]);

angular.module("signin/signin.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("signin/signin.tpl.html",
    "    <section class=\" slice-lg bg-image\" ui-view=\"formSection\"> <!--style=\"background-image:url(assets/images/ec1.JPG)\"-->\n" +
    "        <div class=\"wp-section\">\n" +
    "            <div class=\"container\">\n" +
    "                <div class=\"row\">\n" +
    "                    <div class=\"col-md-5 col-md-offset-2 col-sm-6 col-sm-offset-3\">\n" +
    "                        <div class=\"wp-block default user-form user-form-alpha no-margin\">\n" +
    "                            <div class=\"form-header\">\n" +
    "                                <h6>register and contribute to bookblast</h6>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-body\">\n" +
    "                                <form action=\"\" id=\"frmRegister\" class=\"sky-form\">\n" +
    "                                    <fieldset class=\"no-padding\">\n" +
    "                                        <section class=\"\">\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-xs-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                            <input type=\"text\" name=\"username\" placeholder=\"Username\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to enter the website</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-xs-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <div class=\"form-group\">\n" +
    "                                                            <label class=\"input\">\n" +
    "                                                                <i class=\"icon-append fa fa-envelope-o\"></i>\n" +
    "                                                                <input type=\"email\" name=\"email\" placeholder=\"E-mail\">\n" +
    "                                                                <b class=\"tooltip tooltip-bottom-right\">Needed to verify your account</b>\n" +
    "                                                            </label>\n" +
    "                                                        </div>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-md-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                            <input type=\"text\" name=\"username\" placeholder=\"Password\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to enter the website</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-md-6\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                            <input type=\"email\" name=\"email\" placeholder=\"Password\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">Needed to verify your account</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section class=\"no-margin\">\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                        <input type=\"text\" name=\"fname\" placeholder=\"First name\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                        <input type=\"text\" name=\"lname\" placeholder=\"Last name\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-building\"></i>\n" +
    "                                                        <input type=\"email\" name=\"email\" placeholder=\"Company\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                                <section class=\"col-xs-6\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-phone\"></i>\n" +
    "                                                        <input type=\"tel\" name=\"phone\" placeholder=\"Phone\">\n" +
    "                                                    </label>\n" +
    "                                                </section>\n" +
    "                                            </div>\n" +
    "                                        </section>\n" +
    "                                    </fieldset>\n" +
    "\n" +
    "                                    <fieldset>\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <section class=\"col-xs-5\">\n" +
    "                                                <label class=\"select\">\n" +
    "                                                    <select name=\"country\">\n" +
    "                                                        <option value=\"0\" selected=\"\" disabled=\"\">Country</option>\n" +
    "                                                        <option value=\"244\">Aaland Islands</option>\n" +
    "                                                        <option value=\"1\">Afghanistan</option>\n" +
    "                                                        <option value=\"2\">Albania</option>\n" +
    "                                                        <option value=\"3\">Algeria</option>\n" +
    "                                                        <option value=\"4\">American Samoa</option>\n" +
    "                                                        <option value=\"5\">Andorra</option>\n" +
    "                                                        <option value=\"6\">Angola</option>\n" +
    "                                                        <option value=\"7\">Anguilla</option>\n" +
    "                                                        <option value=\"8\">Antarctica</option>\n" +
    "                                                        <option value=\"9\">Antigua and Barbuda</option>\n" +
    "                                                        <option value=\"10\">Argentina</option>\n" +
    "                                                    </select>\n" +
    "                                                    <i></i>\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "\n" +
    "                                            <section class=\"col-xs-4\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <input type=\"text\" name=\"city\" placeholder=\"City\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "\n" +
    "                                            <section class=\"col-xs-3\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <input type=\"text\" name=\"code\" placeholder=\"Post code\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                        </div>\n" +
    "\n" +
    "                                        <section>\n" +
    "                                            <label for=\"file\" class=\"input\">\n" +
    "                                                <input type=\"text\" name=\"address\" placeholder=\"Address\">\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section>\n" +
    "                                            <label class=\"textarea\">\n" +
    "                                                <textarea rows=\"3\" name=\"info\" placeholder=\"Additional info\"></textarea>\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "                                        <section>\n" +
    "                                            <div class=\"row\">\n" +
    "                                                <div class=\"col-md-8\">\n" +
    "                                                    <label class=\"checkbox\">\n" +
    "                                                        <input type=\"checkbox\" name=\"subscription\" id=\"subscription\">\n" +
    "                                                        <i></i> I accept the <a href=\"#\">terms and conditions</a> of this website.\n" +
    "                                                    </label>\n" +
    "                                                </div>\n" +
    "                                                <div class=\"col-md-4\">\n" +
    "                                                    <button class=\"btn btn-alt btn-icon btn-icon-right btn-icon-go pull-right\" type=\"submit\">\n" +
    "                                                        <span>Register now</span>\n" +
    "                                                    </button>\n" +
    "                                                </div>\n" +
    "                                        </section>\n" +
    "                                    </fieldset>\n" +
    "                                </form>\n" +
    "                            </div>\n" +
    "                            <div class=\"form-footer\">\n" +
    "                                <p>Already have an account? <a ui-sref=\"login\">Click here to sign in.</a></p>\n" +
    "                            </div>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </section>\n" +
    "\n" +
    "\n" +
    "");
}]);

angular.module("upload/upload.tpl.html", []).run(["$templateCache", function($templateCache) {
  $templateCache.put("upload/upload.tpl.html",
    "<section class=\" slice-lg bg-image\" ui-view=\"formSection\"> <!--style=\"background-image:url(assets/images/ec1.JPG)\"-->\n" +
    "    <div class=\"wp-section\">\n" +
    "        <div class=\"container\">\n" +
    "            <div class=\"row\">\n" +
    "                <div class=\"col-md-6 col-sm-6\">\n" +
    "                <div class=\"wp-block default user-form user-form-alpha no-margin\">\n" +
    "                        <div class=\"form-header\">\n" +
    "                            <h6>upload a book to bookblast</h6>\n" +
    "                        </div>\n" +
    "                        <div class=\"form-body\">\n" +
    "                            <form action=\"\" id=\"frmRegister\" class=\"sky-form\">\n" +
    "                                <fieldset class=\"no-padding\">\n" +
    "                                    <section class=\"\">\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <div class=\"col-xs-6\">\n" +
    "                                                <div class=\"form-group\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-search\"></i>\n" +
    "                                                        <input type=\"text\" name=\"categories\" placeholder=\"categories\">\n" +
    "                                                        <b class=\"tooltip tooltip-bottom-right\">category list</b>\n" +
    "                                                    </label>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"col-xs-6\">\n" +
    "                                                <div class=\"form-group\">\n" +
    "                                                    <div class=\"form-group\">\n" +
    "                                                        <label class=\"input\">\n" +
    "                                                            <i class=\"icon-append fa fa-envelope-o\"></i>\n" +
    "                                                            <input type=\"text\" name=\"title\" placeholder=\"title\">\n" +
    "                                                            <b class=\"tooltip tooltip-bottom-right\">the title of the book</b>\n" +
    "                                                        </label>\n" +
    "                                                    </div>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <div class=\"col-md-6\">\n" +
    "                                                <div class=\"form-group\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                        <input type=\"text\" name=\"subtitle\" placeholder=\"subtitle\">\n" +
    "                                                        <b class=\"tooltip tooltip-bottom-right\">the subtitle of the book</b>\n" +
    "                                                    </label>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                            <div class=\"col-md-6\">\n" +
    "                                                <div class=\"form-group\">\n" +
    "                                                    <label class=\"input\">\n" +
    "                                                        <i class=\"icon-append fa fa-lock\"></i>\n" +
    "                                                        <input type=\"text\" name=\"isbn13\" placeholder=\"isbn13\">\n" +
    "                                                        <b class=\"tooltip tooltip-bottom-right\">the isbn of the book</b>\n" +
    "                                                    </label>\n" +
    "                                                </div>\n" +
    "                                            </div>\n" +
    "                                        </div>\n" +
    "                                    </section>\n" +
    "\n" +
    "                                    <section class=\"no-margin\">\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <section class=\"col-xs-6\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                    <input type=\"text\" name=\"publiserName\" placeholder=\"publisher name\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                            <section class=\"col-xs-6\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <i class=\"icon-append fa fa-user\"></i>\n" +
    "                                                    <input type=\"text\" name=\"authorame\" placeholder=\"author name\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                        </div>\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <section class=\"col-xs-6\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <i class=\"icon-append fa fa-building\"></i>\n" +
    "                                                    <input type=\"text\" name=\"seriestitle\" placeholder=\"series title\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                            <section class=\"col-xs-6\">\n" +
    "                                                <label class=\"input\">\n" +
    "                                                    <i class=\"icon-append fa fa-phone\"></i>\n" +
    "                                                    <input type=\"tel\" name=\"phone\" placeholder=\"Phone\">\n" +
    "                                                </label>\n" +
    "                                            </section>\n" +
    "                                        </div>\n" +
    "                                    </section>\n" +
    "                                </fieldset>\n" +
    "\n" +
    "                                <fieldset>\n" +
    "                                    <div class=\"row\">\n" +
    "                                        <section class=\"col-xs-5\">\n" +
    "                                            <label class=\"select\">\n" +
    "                                                <select name=\"country\">\n" +
    "                                                    <option value=\"0\" selected=\"\" disabled=\"\">Country of publication</option>\n" +
    "                                                    <option value=\"244\">Aaland Islands</option>\n" +
    "                                                    <option value=\"1\">Afghanistan</option>\n" +
    "                                                    <option value=\"2\">Albania</option>\n" +
    "                                                    <option value=\"3\">Algeria</option>\n" +
    "                                                    <option value=\"4\">American Samoa</option>\n" +
    "                                                    <option value=\"5\">Andorra</option>\n" +
    "                                                    <option value=\"6\">Angola</option>\n" +
    "                                                    <option value=\"7\">Anguilla</option>\n" +
    "                                                    <option value=\"8\">Antarctica</option>\n" +
    "                                                    <option value=\"9\">Antigua and Barbuda</option>\n" +
    "                                                    <option value=\"10\">Argentina</option>\n" +
    "                                                </select>\n" +
    "                                                <i></i>\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section class=\"col-xs-4\">\n" +
    "                                            <label class=\"input\">\n" +
    "                                                <input type=\"text\" name=\"imprint\" placeholder=\"imprint\">\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "\n" +
    "                                        <section class=\"col-xs-3\">\n" +
    "                                            <label class=\"input\">\n" +
    "                                                <input type=\"text\" name=\"briefdescription\" placeholder=\"brief description\">\n" +
    "                                            </label>\n" +
    "                                        </section>\n" +
    "                                    </div>\n" +
    "\n" +
    "                                    <section>\n" +
    "                                        <label class=\"input\">\n" +
    "                                            <input type=\"text\" name=\"fulldescription\" placeholder=\"Address\">\n" +
    "                                        </label>\n" +
    "                                    </section>\n" +
    "\n" +
    "                                    <section>\n" +
    "                                        <label class=\"textarea\">\n" +
    "                                            <textarea rows=\"3\" name=\"info\" placeholder=\"Additional info\"></textarea>\n" +
    "                                        </label>\n" +
    "                                    </section>\n" +
    "                                    <section>\n" +
    "                                        <div class=\"row\">\n" +
    "                                            <div class=\"col-md-8\">\n" +
    "\n" +
    "                                            </div>\n" +
    "                                            <div class=\"col-md-4\">\n" +
    "                                                <button class=\"btn btn-alt btn-icon btn-icon-right btn-icon-go pull-right\" type=\"submit\">\n" +
    "                                                    <span>save now</span>\n" +
    "                                                </button>\n" +
    "                                            </div>\n" +
    "                                    </section>\n" +
    "                                </fieldset>\n" +
    "                            </form>\n" +
    "                        </div>\n" +
    "                        <div class=\"form-footer\">\n" +
    "                            <p>Already have an spreadsheet? <a ui-sref=\"login\">Click here to upload it.</a></p>\n" +
    "                        </div>\n" +
    "                    </div>\n" +
    "                </div>\n" +
    "            </div>\n" +
    "        </div>\n" +
    "    </div>\n" +
    "</section>");
}]);
