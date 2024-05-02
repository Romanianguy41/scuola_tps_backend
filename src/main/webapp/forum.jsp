<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="../scuola/webapi/studente/form" method="get">
	<h1>Inserire uno studente</h1>
			<table>
			<tr>
				<td><b>Nome</b></td><br>
				<td><input type="text" name="nomeStudente"></td>
			</tr>
			<tr>
			<td><b>Cognome</b></td><br>
				<td><input type="text" name="cognomeStudente"></td>
			</tr>
			<tr>
			<td><b>Codice fiscale</b></td><br>
				<td><input type="text" name="codFiscale"></td>
			</tr>
			<tr>
			<td><b>Luogo nascita</b></td><br>
				<td><input type="text" name="luogoNascita"></td>
			</tr>
			<tr>
			<td><b>Data nascita</b></td><br>
				<td><input type="date" name="dataNascita"></td>
			</tr>
			<tr>
			<td><b>Email</b></td><br>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
			<td><b>Numero telefono</b></td><br>
				<td><input type="text" name="numeroTelefono"></td>
			</tr>
			<tr>
			<td><b>indirizzo</b></td><br>
				<td><input type="text" name="indirizzo"></td>
			</tr>
			<tr>
			<td><b>cittadinanza</b></td><br>
				<td><input type="text" name="cittadinanza"></td>
			</tr>
			<tr>
			<td><b>CAP</b></td><br>
				<td><input type="number" name="CAP"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Salva"></td>
			</tr>
		</table>
	</form>
</body>
</html>