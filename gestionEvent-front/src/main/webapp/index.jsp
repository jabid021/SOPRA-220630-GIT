
<!DOCTYPE html>
<html>
<head>
<title>Accueil</title>
</head>
<body>


	<h2 align="center">Bienvenue dans Gestion Events</h2>

	<form action="home" method="post">
			<h1>CONNEXION</h1>
			<table>
				<tr>
					<td><label>Login</label></td>
					<td><input type="text" name="login" placeholder="login"
						required></td>
				</tr>
				<tr>
					<td><label>Password</label></td>
					<td><input type="password" name="password"
						placeholder="******" required></td>
				</tr>
			</table>
			<input type="submit" value="Se connecter">
			<div id="error">${error}</div>
	</form>

	<span>Vous n'êtes pas encore inscrit ? <a
		href="inscription.html">S'inscrire</a></span>


</body>
</html>