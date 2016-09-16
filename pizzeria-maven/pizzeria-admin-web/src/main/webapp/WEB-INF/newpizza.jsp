<%@page import="java.util.Collection"%>
<%@page import="fr.pizzeria.model.Pizza"%>
    <%@page import="java.util.List"%>
        <html>

        <head>
            <meta charset="utf-8">
            <title>Ajouter Pizza - La Florentina - Pizzï¿½ria ï¿½ Saint-Herblain</title>
            <link rel="icon" type="image/png" sizes="32x32" href="favicon-32x32.png">
            <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
            <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            
            <!-- Bootstrap core CSS -->
	        <link href="<%= request.getContextPath() %>/dist/css/bootstrap.min.css" rel="stylesheet">
	
	        <!-- Custom styles for this template -->
	        <link href="style.css" rel="stylesheet">
            
        </head>

        
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

                        <!-- Flï¿½ches de contrï¿½le -->
                        <a class="left carousel-control" href="#monCarousel" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Prï¿½cï¿½dent</span>
                        </a>
                        <a class="right carousel-control" href="#monCarousel" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Suivant</span>
                        </a>
                    </div>
                    <!-- Fin du carrousel -->



                    <!-- Dï¿½but de la barre de navigation -->
                    <nav class="navbar navbar-default">
                        <div class="container-fluid">
                            <!-- Barre de navigation pour smartphones -->
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#maNavBar">
                                <span class="icon-bar"></span>
                                <!-- ï¿½ complï¿½ter -->
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
                                                <li><a href="Menu.html"><span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>Tï¿½lï¿½charger la carte</a></li>
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
                                            <li><a href="#">Salade Cï¿½sar</a></li>
                                            <li><a href="#">Salade Feta</a></li>
                                            <li>
                                                <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des salades</a></li>
                                            </li>
                                            <li role="separator" class="divider"></li>
                                            <li class="dropdown-header"><span class="glyphicon glyphicon-grain" aria-hidden="true"></span> Nos Pï¿½tes</li>
                                            <li><a href="#">pï¿½tes carbonara</a></li>
                                            <li><a href="#">pï¿½tes bolognese</a></li>
                                            <li>
                                                <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des pï¿½tes</a></li>
                                            </li>
                                            <li role="separator" class="divider"></li>
                                            <li class="dropdown-header"><span class="glyphicon glyphicon-heart" aria-hidden="true"></span> Nos Viandes</li>
                                            <li><a href="#">Tartare de boeuf coupï¿½ au couteau</a></li>
                                            <li><a href="#">Carpaccio de boeuf<span class="label label-danger">En rupture</span></a></li>
                                            <li>
                                                <li><a href="Menu.html"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>Voir la carte des viandes</a></li>
                                            </li>
                                        </ul>
                                    </li>
                                    <li><a href="javascript:chargeHTML('ContactezNous')"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Contactez-nous</a></li>
                                </ul>
                            </div>
                            <!-- /.navbar-collapse -->
                        </div>
                        <!-- /.container-fluid -->
                    </nav>
                </div>
                <!-- Fin de la barre de navigation -->
				<br/><br/>
				
				
				<form id ="formulaire" class="form-horizontal" method="post">
					<fieldset>
					
						<!-- Form Name -->
						<legend>Ajouter une pizza</legend>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="textinput">Code Pizza</label>  
						  <div class="col-md-4">
						  <input id="textinput" name="code" type="text" placeholder="code en trois lettre" class="form-control input-md" required="">
						    
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="textinput">Nom Pizza</label>  
						  <div class="col-md-4">
						  <input id="textinput" name="nom" type="text" placeholder="nom" class="form-control input-md" required="">
						    
						  </div>
						</div>
						
						<!-- Text input-->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="textinput">Prix Pizza</label>  
						  <div class="col-md-4">
						  <input id="textinput" name="prix" type="text" placeholder="prix" class="form-control input-md" required="">
						    
						  </div>
						</div>
						
						<!-- Select Basic -->
						<div class="form-group">
						  <label class="col-md-4 control-label" for="categorie">Catégorie</label>
						  <div class="col-md-4">
						    <select id="categorie" name="categorie" class="form-control">
						      <option value="VIANDE">Viande</option>
						      <option value="SANS_VIANDE">Sans viande</option>
						      <option value="POISSON">Poisson</option>
						    </select>
						  </div>
						</div>
						
						<div class="col-md-4">
					   	 <button type="submit" id="singlebutton" name="singlebutton" class="btn btn-info">Ajouter</button>
					  	</div>
					
					</fieldset>
				</form>

                <br/><br/><br/>




                <!-- Footer -->

                <footer class="footer">
                    <div class="enbas">
						@Taki
                    </div>
                </footer>

        </body>

        </html>