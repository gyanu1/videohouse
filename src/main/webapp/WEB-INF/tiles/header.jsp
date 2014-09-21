<%-- 
    Document   : header
    Created on : Sep 19, 2014, 1:51:37 PM
    Author     : GMaharjan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div style="margin-top: 3px; margin-bottom: 3px;">
	<div class="col-xs-4 pull-left">
		<img alt="Video house" src="resources/img/videohouse.jpg">
	</div>

	<div class="row pull-right">
		<form action="search" method="post">
			<div class="col-xs-8 ">
				<input name="text" class="form-control" />
			</div>
			<div class="col-xs-4">
				<input type="submit" class="form-control" value="Search">
			</div>
		</form>
	</div>
</div>
