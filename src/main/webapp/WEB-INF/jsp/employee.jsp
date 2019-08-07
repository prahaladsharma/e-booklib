<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<title>E-BookLibrary</title>
</head>
<body>
	<h2>Employee Details</h2>
	<form:form method="post" commandName="employee">
 
		<table>			
			<tr>
				<td><form:label path="designation">Designation </form:label></td>
				<td>
					<form:select path="designation">
						<form:option value="none" label="Select"/>
						<form:option value="Junior Developer" label="Junior Developer"/>
						<form:option value="Developer" label="Developer"/>
						<form:option value="Senior Developer" label="Senior Developer"/>
						<form:option value="Manager" label="Manager"/>
					</form:select>
				</td>
			</tr>
			<tr>
				<td><form:label path="department">Department</form:label></td>
				<td>
					<form:select path="department">
						<form:options items="${availableDepartments}" />
					</form:select>
				</td>
			</tr>
 
			<tr>
				<td><form:label path="hobbies">Hobbies</form:label></td>
				<td>
					<form:select path="hobbies" multiple="true">
						<form:options items="${availableHobbies}"/>
					</form:select>
				</td>
			</tr>
 
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
 
	</form:form>
</body>
</html>