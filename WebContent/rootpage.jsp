<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@page isELIgnored="false" %> <!-- for Maven generated web.xml -->
<html>
<head>
<meta charset="UTF-8">
<title>File Transfer Box</title>
<link rel="icon" href="${favicon}" />
<style>
body {
	font-family: Tahoma, Geneva, sans-serif;
	background-color: lemonchiffon;
	color: darkred;
}
</style>
</head>
<body>

<h1>File Transfer Box</h1>
<p>Do not use File Transfer Box for confidential or private content.</p>
<hr/>

<h3>Upload Files:</h3>

<form method="post" enctype="multipart/form-data" action="FileUpload">
	<table>
		<tr>
			<td><label for="upload">File upload: </label></td>
			<td><input type="file" id="upload" name="upload" accept="*" /></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="submit" value="Upload Now" />
			Note, the web page will not respond again until the file is uploaded.
  			</td>
  		</tr>
  	</table>
</form>


<hr/>
<h3>Downloadable Files:</h3>

<table>
<c:forEach items="${files}" var="file">
	<tr>
		<td>${file.length()} bytes</td>
		<td><a href="FileDownload?filename=${file.name}">${file.name}</a></td>
	</tr>
</c:forEach>
</table>

<p>${filecount} files.</p>

<hr/>
<p>Local file location: ${fileloc}</p>

</body>
</html>