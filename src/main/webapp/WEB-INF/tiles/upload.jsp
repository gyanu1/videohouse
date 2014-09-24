<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div style="background: #E8E8E8; padding: 15px 10px">
	<form:form class="form-horizontal"  enctype="multipart/form-data" role="form" commandName="video" action="upload" method="post">
		<div class="form-group ">
			<label for="file" class="col-sm-2 control-label">Choose Video File</label>
			<div class="col-sm-5 row">
				<input name="file" type="file" class="form-control" id="file" value="${video.file}" />
                                  
			</div>
                                <form:errors path="file" cssClass="alert alert-danger" />
		</div>
		<div class="form-group">
			<label for="image" class="col-sm-2 control-label">Poster</label>
			<div class="col-sm-5   row">
				<input name="image" type="file" class="form-control" id="image" value="${video.image}" />
			      
                        </div>
                        <form:errors path="image" cssClass="alert alert-danger" />
		</div>
		<div class="form-group">
			<label for="title" class="col-sm-2 control-label">Title</label>
			<div class="col-sm-5   row">
				<form:input path="title" class="form-control" id="title" value="${video.title}" />
			</div>
		</div>
		<div class="form-group">
			<label for="keywords" class="col-sm-2 control-label">Keywords</label>
			<div class="col-sm-5   row">
				<form:input path="keywords" class="form-control" id="keywords" value="${video.keywords}" />
			</div>
		</div>

		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<input type="submit" class="btn btn-default" value="Upload" />
			</div>
		</div>
	</form:form>
</div>
