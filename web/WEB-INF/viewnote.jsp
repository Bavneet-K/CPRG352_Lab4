
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View note - Simple note keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>View Note</h2>
            <p><b>Title: </b>${title}</p>
            <p><b>Contents: </b><br>
            ${contents}
            </p>
            <p><a href="Note?edit">Edit</a></p>
    </body>
</html>
