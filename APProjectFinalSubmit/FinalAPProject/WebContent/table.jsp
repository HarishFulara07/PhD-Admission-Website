<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.2.js"></script>  
	<link href="bootstrap.css" rel="stylesheet">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>  
	<link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/css/bootstrapValidator.min.css"/>
	<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.3/js/bootstrapValidator.min.js"> </script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.form/3.51/jquery.form.min.js"></script>
	<link rel="stylesheet" href="form.css">
	<style type="text/css">
		#form1 .has-error .control-label,
		#form1 .has-error .help-block,
		#form1 .has-error .form-control-feedback {
			color: #8B0000;
		}

		#form1 .has-success .control-label,
		#form1 .has-success .help-block,
		#form1 .has-success .form-control-feedback {
			color: #006400;
		}

		#form2 .has-error .control-label,
		#form2 .has-error .help-block,
		#form2 .has-error .form-control-feedback {
			color: #8B0000;
		}

		#form2 .has-success .control-label,
		#form2 .has-success .help-block,
		#form2 .has-success .form-control-feedback {
			color: #006400;
		}
		</style>
	<title>
		PhD Admission Admin
	</title>
</head>
<body>
    <div class="nav">
		<div class="container" id="custom-link">
			<a href="https://www.iiitd.ac.in/"><img class="pull-left" src="iiitd-logo.jpg" />
			</a>
                        
			<ul class="pull-right">
				
				<li><a href="user_login.html">Log Out</a></li>
				<li><a href="#">FAQ</a></li>
				<li><a href="#">Contact</a></li>
                                
			</ul>
			<ul class="pull-center">
			    <h7 style="color: white">a</h7>
				<h1 style="color: black">Filter Result</h1>
			</ul>
                        <ul class="pull-left">
				
				<li><a href="index.html">BACK</li>
				
                                
			</ul>
                        <table>
                            
                        <TR>
                            <TD>Actor ID: </TD>
                            <TD>${actor.name}</TD>
                        </TR>

                        <TR>
                            <TD>Lastname: </TD>
                            <TD>${actor.enrollmentNumber}</TD>
                        </TR>
                         <TR>
                            <TD>Firstname: </TD>
                            <TD>${actor.link}</TD>
                        </TR>
       
  
                        </table>
                        <br>
                        
			
		</div>
	</div>
</body>
</html>