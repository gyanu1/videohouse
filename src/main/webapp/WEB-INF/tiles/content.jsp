<%-- 
    Document   : content
    Created on : Sep 19, 2014, 1:51:50 PM
    Author     : GMaharjan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="video-container" >
	<video id="video" style="width:900;margin:0 auto;"  poster="resources/img/${video.id}.${video.imageType}" controls >
            <c:choose>
                <c:when test="${video.type =='ogv'}">
                      <source src="resources/video/${video.id}.${video.type}" type="video/ogg">
                </c:when>
                <c:otherwise>
                     <source src="resources/video/${video.id}.${video.type}" type="video/${video.type}">
                </c:otherwise>
            </c:choose>
	</video>
</div>

