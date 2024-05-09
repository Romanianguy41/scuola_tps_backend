<html>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/myresource">Jersey resource</a>
    <p>Visit <a href="http://jersey.java.net">Project Jersey website</a>
    for more information on Jersey!
    <hl>
    <h2>API per classe</h2><br>
    <a href="http://localhost:8080/scuola/webapi/classe">getClasses</a><br>
    <p>API che recupera tutte le classi dal DB</p><br>
     <a href="http://localhost:8080/scuola/webapi/classe/filter?search=classe:5">getClassesQuinte</a><br>
    <p>API che recupera le classi che corispondono alla stringa contenuta del querryParma denominato 
    	search</p><br>
    <a href="http://localhost:8080/scuola/webapi/classe/2">elimina classe</a><br>
    <p>API che elimina la classe che posside ID uguale a quello del path</p><br>
    
    <a href="http://localhost:8080/scuola/forum.jsp">createStudentForum</a> <br>
    <p>API che mediante il forum presente al link sopra permette di aggiungere un nuovo studente</p><br>
    
</body>
</html>
