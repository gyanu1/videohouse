<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <c:forEach items="${videoList}" var="video" varStatus="loop"> 
        <div class="video-block">
            <a href="video?id=${video.id}">
                <img alt="" width="449" height="235" src="resources/img/${video.id}.${video.imageType}">
                <p>${video.title}</p>
            </a>
        </div>
    </c:forEach>
</div>