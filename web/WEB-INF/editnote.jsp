<%-- 
    Document   : editnote
    Created on : Oct 3, 2020, 8:01:35 PM
    Author     : 832676
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>edit note Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
        Title:<input type="text" name="title" value="${note.title}"><br>
        Contents:<textarea name="content">${note.contents}</textarea><br>
        <input type="submit" name="saveButton" value="Save"> 
        </form>
    </body>
</html>
