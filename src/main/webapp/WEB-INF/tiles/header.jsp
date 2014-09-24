<%-- 
    Document   : header
    Created on : Sep 19, 2014, 1:51:37 PM
    Author     : GMaharjan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div style="margin-top: 3px; margin-bottom: 3px;">
    <div class="col-xs-4 pull-left">
        <img alt="Video house" src="resources/img/videohouse.jpg">

    </div>

    <div class="row pull-right">
        <c:if test="${not empty loginUser}">
            <p class="pull-right"> <span style="color: greenyellow">Welcome</span>  <span style="color: #2aabd2 ;padding-right: 15px">${loginUser}</span>
            </p>     
        </c:if>
        <form action="search" method="post">
            <div class="col-xs-8 inline">
                <input name="query" class="form-control" value="${query}" />
            </div>
            <div class="col-xs-4 inline">
                <input type="submit" class="form-control " value="Search">
            </div>
        </form>
    </div>
</div>
