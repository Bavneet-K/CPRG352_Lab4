
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit note - Simple note keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
        
        <form action="Note?edit" method="post">
            Title: <input type="text" name="title" value="">
            <br>
            Contents: <input type="textarea" rows="6" cols="50" name="contents" value="">
            <br>
            <input type="submit" value="Save">
        </form>
               
</html>
