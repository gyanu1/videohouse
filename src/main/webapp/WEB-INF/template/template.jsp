<%-- 
    Document   : template
    Created on : Sep 19, 2014, 2:08:47 PM
    Author     : GMaharjan
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ include file="/WEB-INF/template/templates.xml"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
<head>
<title>Video House</title>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/layout.css">
<link rel="stylesheet" type="text/css" href="resources/css/player.css">
<link rel="stylesheet" type="text/css" href="resources/bootstrap3.2/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="resources/js/jquery-2.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="resources/bootstrap3.2/js/bootstrap.min.js"></script>
</head>
<body class="wrapper">
	<table class="main">
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="header" /></td>
		</tr>
		<tr>
			<td width="22.51816%"><tiles:insertAttribute name="menu" /></td>
			<td width="77.48184%">
				<div class="content-box">
					<tiles:insertAttribute name="content" />
				</div>
			</td>
		</tr>
		<tr>
			<td height="30" colspan="2"><tiles:insertAttribute name="footer" /></td>
		</tr>
	</table>
</body>
</html>