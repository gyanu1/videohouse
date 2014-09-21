<%-- 
    Document   : login
    Created on : Sep 20, 2014, 11:01:40 AM
    Author     : GMaharjan
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="background: #E8E8E8;">
	<form:form class="form-horizontal" role="form" command="user" action="/register}" method="post">
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" class="form-control" id="email" value="${user.email}" />
			</div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<form:password path="password" class="form-control" id="password" value="${Password}" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Sign in" />
			</div>
		</div>
	</form:form>
</div>
