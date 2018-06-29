<!DOCTYPE html>
<html lang="en">
	
	<head>
		<link
			href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css"
			rel="stylesheet" id="bootstrap-css">
		<script
			src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
		<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	</head>
	
	<body>
		<div class="container">
	<div id="loginbox" style="margin-top: 50px;"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign In</div>
			</div>

			<div style="padding-top: 30px" class="panel-body">

				<form id="loginform" method="post" class="form-horizontal" role="form" action="login">

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-user"></i></span> <input id="txtLogin"
							type="text" class="form-control" name="txtLogin" value=""
							placeholder="Login">
					</div>

					<div style="margin-bottom: 25px" class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> <input id="txtPassword"
							type="password" class="form-control" name="txtPassword"
							placeholder="Password">
					</div>
					
					<div id='txtErrorLogin' class="errorMessage">${txtError}</div>

					<div style="margin-top: 10px" class="form-group">
						<!-- Button -->

						<div class="col-sm-12 controls">
							<button name='btn-login' type='submit' id="btnConnect" class="btn btn-success">Login</button>
						</div>
					</div>


					<div class="form-group">
						<div class="col-md-12 control">
							<div
								style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%">
								Don't have an account! <a href="#"
									onClick="$('#loginbox').hide(); $('#signupbox').show()">
									Sign Up Here </a>
							</div>
						</div>
					</div>
				</form>



			</div>
		</div>
	</div>

	<div id="signupbox" style="display: none; margin-top: 50px"
		class="mainbox col-md-6 col-md-offset-3 col-sm-8 col-sm-offset-2">
		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title">Sign Up</div>
				<div
					style="float: right; font-size: 85%; position: relative; top: -10px">
					<a id="signinlink" href="#"
						onclick="$('#signupbox').hide(); $('#loginbox').show()">Sign
						In</a>
				</div>
			</div>
			<div class="panel-body">
				<form id="signupform" method="post" action ="register" class="form-horizontal" role="form">

					<div id="signupAlert" style="display: none"
						class="alert alert-danger">
						<p>Error:</p>
						<span></span>
					</div>

					<div class="form-group">
						<label for="signupLogin" class="col-md-3 control-label">Login</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="signupLogin"
								placeholder="Login">
							<span class="errorMessage">${error['signupLogin']}</span>
						</div>
					</div>

					<div class="form-group">
						<label for="signupFirstName" class="col-md-3 control-label">First
							Name</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="signupFirstName"
								placeholder="First Name">
							<span class="errorMessage">${error['signupFirstName']}</span>
						</div>
					</div>

					<div class="form-group">
						<label for="signupLastName" class="col-md-3 control-label">Last
							Name</label>
						<div class="col-md-9">
							<input type="text" class="form-control" name="signupLastName"
								placeholder="Last Name">
							<span class="errorMessage">${error['signupLastName']}</span>
						</div>
					</div>

					<div class="form-group">
						<label for="signupPassword" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="signupPassword"
								placeholder="Password">
							<span class="errorMessage">${error['signupPassword']}</span>
						</div>
					</div>

					<div class="form-group">
						<label for="signupRePassword" class="col-md-3 control-label">Password</label>
						<div class="col-md-9">
							<input type="password" class="form-control" name="signupRePassword"
								placeholder="Retype Password">
							<span class="errorMessage">${error['signupRePassword']}</span>
						</div>
					</div>
					
					<div id='txtErrorRegister' class="errorMessage">${txtError}</div>
           			<div id='txtValidRegister' class="validMessage">${txtValid}</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<button id="btn-signup" type="submit" class="btn btn-info">
								<i class="icon-hand-right"></i> Sign Up
							</button>
							<span style="margin-left: 8px;"></span>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
		
	</body>
	
	</html>