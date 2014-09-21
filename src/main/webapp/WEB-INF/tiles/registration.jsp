<%-- 
    Document   : registration
    Created on : Sep 20, 2014, 11:21:08 AM
    Author     : GMaharjan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="width: 80%; margin: 0 auto; background: #E8E8E8;">
	<form:form class="form-horizontal" role="form" command="user" action="/register}" method="post">
		<div class="form-group">
			<label for="firstname" class="col-sm-2 control-label">Firstname</label>
			<div class="col-sm-10">
				<form:input path="firstname" class="form-control" id="firstname" value="${user.firstname}" />
			</div>
		</div>
		<div class="form-group">
			<label for="lastname" class="col-sm-2 control-label">Lastname</label>
			<div class="col-sm-10">
				<form:input path="lastname" class="form-control" id="lastname" value="${user.lastname}" />
			</div>
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<form:input path="email" class="form-control" id="email" value="${user.email}" />
			</div>
		</div>
		<div class="form-group">
			<label for="facebookId" class="col-sm-2 control-label">Facebook_Id</label>
			<div class="col-sm-10">
				<form:password path="facebookId" class="form-control" id="facebookId" value="${user.facebookId}" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Register" />
			</div>
		</div>
	</form:form>
</div>
