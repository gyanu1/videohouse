<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container">
    <c:forEach items="${videoList}" var="video" varStatus="loop"> 
        <div class="video-block">
            <a href="video?id=${video.id}">
                <img alt="" width="449" height="235" src="resources/img/${video.id}.${video.imageType}">
                <p>${video.title}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${video.viewCount}&nbsp;views</p>
            </a>
        </div>
    </c:forEach>
    <div class="col-xs-4 pull-center">
    <label for="name" class="col-xs-2 control-label"><%= cs544.videohouse.util.Welcome.recentUpload %>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="video?id=<%= cs544.videohouse.util.Welcome.rId %>">Checkout</a>       
    </label>
    </div>
</div>