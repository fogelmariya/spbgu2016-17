<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="WEB-INF/taglib.tld" prefix="rs" %>

<html>
    <head>
        <title>
            Return on Intelligence; Task 03
        </title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        <div id="maindiv">
            <h1>Try to guess the number in [1:100] range.</h1>
            <form action="index.jsp" method="post">
                <input name="tryguesstimate" type="text" placeholder="Enter number here" value="">
                <input name="trysubmit" type="submit" value="Try">
                <rs:generate number="${param.trynumber}"> </rs:generate>
            </form>
            <rs:guess>
                Text field is empty.
            </rs:guess>
        </div>
    </body>
</html>