<%-- 
    Document   : template
    Created on : Sep 19, 2014, 2:08:47 PM
    Author     : GMaharjan
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ include file="/WEB-INF/template/templates.xml" %>
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
        <link rel="stylesheet" type="text/css" href="/videohouse/resources/css/reset.css">
        <link rel="stylesheet" type="text/css" href="/videohouse/resources/css/layout.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body class="wrapper">
            <table class="main" >
                <tr>
                    <td height="30" colspan="2">
                        <tiles:insertAttribute name="header" />
                    </td>
                </tr>
                <tr>
                    <td width="800">
                       <tiles:insertAttribute name="body" />
                    </td>
                </tr>
                <tr>
                    <td height="30" colspan="2">
                        <tiles:insertAttribute name="footer" />
                    </td>
                </tr>
            </table>
    </body>
</html>