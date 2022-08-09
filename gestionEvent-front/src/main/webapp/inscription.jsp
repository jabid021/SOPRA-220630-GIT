
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


 <form action="users" method="post">
   <input type="hidden" value="inscription" name="tache">

     <legend>INSCRIPTION</legend>
     <table>
       <tr>
         <td><label for="login">Login</label></td>
         <td><input type="text" name="login" placeholder="login" required></td>
       </tr>
       <tr>
         <td><label for="password">Password</label></td>
         <td><input type="password" name="password" placeholder="******" required></td>
       </tr>
       <tr>
         <td><label for="nom">Nom</label></td>
         <td><input type="text" name="nom" placeholder="nom" required></td>
       </tr>
       <tr>
         <td><label for="prenom">Prénom</label></td>
         <td><input type="text" name="prenom" placeholder="prénom" required></td>
       </tr>
       <tr>
         <td><label>Date de naissance</label></td>
         <td><input type="date" name="dateNaissance" placeholder="date de naissance" required></td>
       </tr>
       <tr>
         <td><label for="tel">Téléphone</label></td>
         <td><input type="tel" name="tel" pattern="[0-9]{10}" placeholder="0XXXXXXX" required></td>
       </tr>
       <tr>
         <td><label for="numVoie">Numéro de voie</label></td>
         <td><input type="text" name="numVoie" placeholder="N° de voie" required></td>
       </tr>
       <tr>
         <td><label for="nomVoie">Nom de voie</label></td>
         <td><input type="text" name="nomVoie" placeholder="nom de voie" required></td>
       </tr>
       <tr>
         <td><label for="cp">Code postal</label></td>
         <td><input type="text" name="cp" placeholder="XXXX" required></td>
       </tr>
       <tr>
         <td><label for="ville">Ville</label></td>
         <td><input type="text" name="ville" placeholder="nom de ville" required></td>
       </tr>
    </table>
    <input type="submit" name="submit" value="S'inscrire">
    <a href="home"><button type="button">Annuler</button></a>
</form>

</body>
</html>