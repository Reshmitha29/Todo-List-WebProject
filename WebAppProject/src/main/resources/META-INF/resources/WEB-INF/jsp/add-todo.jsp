
<%@include file="common/header.jspf" %>

<body>
	<%@include file="common/navigation.jspf" %>
	<div class="container">
		<h1>Enter the description</h1>
		<form:form method="post" modelAttribute="todo">
			<fieldset class="mb-3">
				<form:label path="description">Description </form:label>
				<form:input type="text" path="description" required="required"
					class="form-control" />
				<form:errors path="description" cssClass="text-warning" />
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDAte">Target Date </form:label>
				<form:input type="text" path="targetDAte" id="targetDAte"
					required="required" class="form-control" />
				<form:errors path="targetDAte" cssClass="text-warning" />
			</fieldset>

			<form:input type="hidden" path="id" />
			<form:input type="hidden" path="done" />

			<input type="submit" class="btn btn-success">
		</form:form>
	</div>

	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
	<script src="webjars/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
	<script
		src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

	<script type="text/javascript">
		$(document).ready(function() {
			$('#targetDAte').datepicker({
				format : 'yyyy-mm-dd',
				autoclose : true, // Close the datepicker when a date is selected
				todayHighlight : true
			// Highlight today's date
			});
		});
	</script>
</body>
</html>