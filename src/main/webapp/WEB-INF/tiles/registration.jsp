<%-- 
    Document   : registration
    Created on : Sep 20, 2014, 11:21:08 AM
    Author     : GMaharjan
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="width: 90%; margin: 0 auto; background: #E8E8E8; padding:15 10">
    <form:form class="form-horizontal" role="form" command="user" action="register" method="post" modelAttribute="user">
		<div class="form-group">
			<label for="firstName" class="col-sm-2 control-label">Firstname</label>
                        <div class="row">
                            <div class="col-sm-6">
                                    <form:input path="firstName" class="form-control" id="firstName" value="${user.firstName}" />                                                                                               
                            </div>     
                             <form:errors path="firstName" cssclass="alert alert-danger"/>
                         </div>
		</div>
		<div class="form-group">
			<label for="lastName" class="col-sm-2 control-label">Lastname</label>
                        <div class="row">
                            <div class="col-sm-6">
				<form:input path="lastName" class="form-control" id="lastName" value="${user.lastName}" />                                                               
                            </div>
                            <form:errors path="lastName" cssclass="alert alert-danger"/>
                        </div>			
		</div>
		<div class="form-group">
			<label for="email" class="col-sm-2 control-label">Email</label>
                        <div class="row">
                            <div class="col-sm-6">
                                    <form:input path="email" class="form-control" id="email" value="${user.email}" />                                                                
                            </div>
                            <form:errors path="email" cssclass="alert alert-danger"/>
                        </div>
		</div>
		<div class="form-group">
			<label for="password" class="col-sm-2 control-label">Password</label>
			<div class="row">
                            <div class="col-sm-6">
				<form:password path="password" class="form-control" id="password" value="${user.password}" />                                                                
                            </div>
                            <form:errors path="password" cssclass="alert alert-danger"/>  
                        </div>                        
		</div>                
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Register" />
			</div>
		</div>
	</form:form>
</div>
