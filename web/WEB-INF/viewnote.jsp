<%-- 
    Document   : viewnote
    Created on : Oct 3, 2020, 8:01:57 PM
    Author     : 832676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>view note Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>   
        <label style="font-weight: bold;">Title:</label> <div>${note.title}</div>
        <br>
        <label style="font-weight: bold;">Contents:</label> 
        <div>${note.contents}</div>
        <p><a href="note?edit=editnote">Edit</a></p>

    </body>
</html>
