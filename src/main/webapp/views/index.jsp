<%--
  Created by IntelliJ IDEA.
  User: артем
  Date: 03.03.16
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Data Handler</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body bgcolor="#f8f8ff">
<div class="parent">
    <form action="${pageContext.servletContext.contextPath}/ShowFile" method="post">
        <table class="out">
            <tr>
                <td bgcolor="teal" align="center">
                    Data Handler
                </td>
            </tr>
            <tr>
                <td>
                    <table class="inner">
                        <tr>
                            <td>Search:</td>
                            <td><input type="text" name="q"></td>
                        </tr>
                        <tr>
                            <td>Length:</td>
                            <td><input type="text" name="length"></td>
                        </tr>
                        <tr>
                            <td>Limit:</td>
                            <td><input type="text" name="limit"></td>
                        </tr>
                        <tr>
                            <td colspan="2" align="center">
                                <input id="button" type="submit" value="Search">
                            </td>
                        </tr>

                        <tr>
                            <td>Include Meta Data?</td>
                            <td align="center">
                                <select name="includeMetaData" title="">
                                    <option value="false">No</option>
                                    <option value="true">Yes</option>
                                </select>
                            </td>
                        </tr>

                    </table>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>