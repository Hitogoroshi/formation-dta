<html>

<head>
    <meta charset="utf-8">
    <title>Accueil - La Florentina - Pizzéria à Saint-Herblain</title>
    <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>

<!-- Bootstrap core CSS -->
<link href="./dist/css/bootstrap.min.css" rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link href="./assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="style.css" rel="stylesheet">


<body>

    <!-- Debut du carrousel -->
    <div class="container-fluid">
        <div class="row">

            <div id="monCarousel" class="carousel slide" data-ride="carousel">
                <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#monCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#monCarousel" data-slide-to="1"></li>
                    <li data-target="#monCarousel" data-slide-to="2"></li>
                </ol>

                <!-- Wrapper for slides -->
                <div class="carousel-inner" role="listbox">

                    <div class="item active">
                        <img src="Images/Carousel/Carousel1.jpg" alt="Pizzeria">
                        <div class="carousel-caption">
                            <h1>La Florentina</h1>
                            <p>L'italie est dans votre pizza !</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="Images/Carousel/Carousel2.jpg" alt="Pizzeria">
                        <div class="carousel-caption">
                            <h1>La Florentina</h1>
                            <p>L'italie est dans votre pizza !</p>
                        </div>
                    </div>
                    <div class="item">
                        <img src="Images/Carousel/Carousel3.jpg" alt="Pizzeria">
                        <div class="carousel-caption">
                            <h1>La Florentina</h1>
                            <p>L'italie est dans votre pizza !</p>
                        </div>
                    </div>

                </div>

                <!-- Flèches de contrôle -->
                <a class="left carousel-control" href="#monCarousel" role="button" data-slide="prev">
                    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                    <span class="sr-only">Précédent</span>
                </a>
                <a class="right carousel-control" href="#monCarousel" role="button" data-slide="next">
                    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                    <span class="sr-only">Suivant</span>
                </a>
            </div>
 		</div>

  <!-- Fin du carrousel -->



            <!-- Début de la barre de navigation -->
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Barre de navigation pour smartphones -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#maNavBar">
                                <span class="icon-bar"></span>
                                <!-- à compléter -->
                            </button>
                    </div>

                    <!-- Barre de navigation pour ordinateurs -->
                    <div class="collapse navbar-collapse" id="maNavBar">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="Accueil.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil</a></li>
                            <li><a href="#"><span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span> La Florentina</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Notre carte<span class="caret"></span></a>
                                <ul class="dropdown-menu" role="menu">
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>Télécharger la carte</a></li>
                                    </li>
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>Voir la carte</a></li>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-fire" aria-hidden="true"></span> Nos pizzas</li>
                                    <li><a href="#">Marguerita <span class="label label-success">Produit de la semaine</span></a></li>
                                    <li><a href="#">Reine</a></li>
                                    <li><a href="#">4 Fromages</a></li>
                                    <li><a href="#">Chorizo</a></li>
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des pizzas</a></li>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-leaf" aria-hidden="true"></span> Nos Salades</li>
                                    <li><a href="#">Salade César</a></li>
                                    <li><a href="#">Salade Feta</a></li>
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des salades</a></li>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-grain" aria-hidden="true"></span> Nos Pâtes</li>
                                    <li><a href="#">pâtes carbonara</a></li>
                                    <li><a href="#">pâtes bolognese</a></li>
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des pâtes</a></li>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li class="dropdown-header"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Nos Viandes</li>
                                    <li><a href="#">Tartare de boeuf coupé au couteau</a></li>
                                    <li><a href="#">Carpaccio de boeuf<span class="label label-danger">En rupture</span></a></li>
                                    <li>
                                        <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des viandes</a></li>
                                    </li>
                                </ul>

                            <li><a href="javascript:chargeHTML('ContactezNous')"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Contactez-nous</a></li>
                        </ul>
                    </div>
                    <!-- /.navbar-collapse -->
                </div>
                <!-- /.container-fluid -->
            </nav>
        </div>
        <!-- Fin de la barre de navigation -->




        <div id="contenu">

            <div class="jumbotron">
                <div class="container">
                    <h1>Bienvenue sur le site de La Florentina !</h1>
                    <p>Notre amour pour les pizzas se ressent jusque dans vos assiettes.</p>
                    <p>En amoureux ou en famille, notre équipe vous accueil 6 jours/7, du lundi au samedi.</p>
                    <p><a class="btn btn-primary btn-lg" href="#" role="button">Acces aux réservations &raquo;</a></p>
                </div>
            </div>

            <br/><br/>

            <!-- Atouts  -->
            <div id="atouts">
                <div class="col-md-3 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-12">
                    <h3>Nous aimons nos clients</h3>
                    <p>Nous sommes reconnu pour notre qualitée et notres esprit de service</p>
                </div>
                <div class="col-md-3 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-12">
                    <h3>Les meilleurs prix</h3>
                    <p>Nous vous garentissons les meilleurs prix, si vous trouvez moins cher ailleurs... Allez y.</p>
                </div>
                <div class="col-md-3 col-md-offset-1 col-sm-5 col-sm-offset-1 col-xs-12">
                    <h3>Satisfaction 100% garantie</h3>
                    <p>En cas d'indigestion, nous vous rembroussons le médecin</p>
                </div>
            </div>

        </div>

        <div class="clearfix"></div>

<br/><br/>

        <!-- Footer -->

        <footer class="footer">
            <div class="enbas">

            </div>
        </footer>

</body>

</html>