<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* CSS */
body {
    margin: 0;
    font-family: Roboto, "Helvetica Neue", sans-serif;
    background-color: #2C3333;
    color: white; /* Testo bianco */
}

form {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding-top: 50px;
}

table {
    margin-top: 20px;
    border-collapse: collapse;
    width: 50%;
}

table, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
}

input[type="text"],
input[type="date"],
input[type="number"],
input[type="submit"] {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}

input[type="submit"] {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    width: 100%;
}

input[type="submit"]:hover {
    background-color: #45a049;
}

h1 {
    text-align: center;
}
</style>
</head>
<body>
    <form action="../scuola/webapi/studente/form" method="post">
        <h1>Inserire uno studente</h1>
        <table>
            <tr>
                <td><b>Nome</b></td>
                <td><input type="text" name="nomeStudente"></td>
            </tr>
            <tr>
                <td><b>Cognome</b></td>
                <td><input type="text" name="cognomeStudente"></td>
            </tr>
            <tr>
                <td><b>Codice fiscale</b></td>
                <td><input type="text" name="codFiscale"></td>
            </tr>
            <tr>
                <td><b>Luogo nascita</b></td>
                <td><input type="text" name="luogoNascita"></td>
            </tr>
            <tr>
                <td><b>Data nascita</b></td>
                <td><input type="date" name="dataNascita"></td>
            </tr>
            <tr>
                <td><b>Email</b></td>
                <td><input type="text" name="email"></td>
            </tr>
            <tr>
                <td><b>Numero telefono</b></td>
                <td><input type="text" name="numeroTelefono"></td>
            </tr>
            <tr>
                <td><b>indirizzo</b></td>
                <td><input type="text" name="indirizzo"></td>
            </tr>
            <tr>
                <td><b>cittadinanza</b></td>
                <td><input type="text" name="cittadinanza"></td>
            </tr>
            <tr>
                <td><b>CAP</b></td>
                <td><input type="number" name="CAP"></td>
            </tr>
            <tr>
                <td><input type="submit" value="Salva"></td>
            </tr>
        </table>
    </form>
</body>
</html>
