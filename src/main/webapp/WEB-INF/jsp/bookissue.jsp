<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<title> E-BookLibrary </title>

<style>
	body, input {
		font-family: Calibri, Arial;
		margin: 0px;
		padding: 0px;
	}
	#header h2 {
		color: white;
		background-color: #3275A8;
		height: 50px;
		padding: 5px 0 0 5px;
		font-size: 20px;
	}
	
	.datatable {margin-bottom:5px;border:1px solid #eee;border-collapse:collapse;width:400px;max-width:100%;font-family:Calibri}
	.datatable th {padding:3px;border:1px solid #888;height:30px;background-color:#B2D487;text-align:center;vertical-align:middle;color:#444444}
	.datatable tr {border:1px solid #888}
	.datatable tr.odd {background-color:#eee}
	.datatable td {padding:2px;border:1px solid #888}
	#content { padding 5px; margin: 5px; text-align: center}
	fieldset { width: 300px; padding: 5px; margin-bottom: 0px; }
	legend { font-weight: bold; }
	
	error {
		color: red;
	}


</style>

<body>
	<div id="header">
		<H2>Book Issue Form</H2>
	</div>

	<div id="content">
  		<fieldset>
  			<legend>Issue Book</legend>
  				<form:form method="post" modelAttribute="employee">
					<table>			
						<tr>
							<td><form:label path="bookName"><b>Book Name</b></form:label></td>
							<td><form:select path="bookName">
							<form:option value = "NONE" label = "Select Book"/>
								<form:options items="${bookList}" /></form:select>
							</td>
						</tr>
						<tr>
							<td><label for="bookIssueDate"><b>Book Issue Date</b></label></td>
							<td><input type="date" name="bookIssueDate" required></td>
						</tr>
 						<tr>
 							<td><label for="bookSubmitDate"><b>Book Submit Date</b></label></td>
 							<td><input type="date" name="bookSubmitDate" required></td>
 						</tr>
	 					<tr>
	 						<td colspan="2"><input type="submit" value="Submit" /></td>		
	 					</tr>
					</table> 
			</form:form>
  					<%-- <label for="Select Book"><b>Select Book</b></label>
					<form:select path = "bookName" id="Select Book">
                     	<form:option value = "NONE" label = "Select Book"/>
                     	<form:options items = "${bookList}" />
                   </form:select>  </br> </br>
				
					<label for="bookIssueDate"><b>Book Issue Date</b></label>
	 				<input type="date" name="bookIssueDate" required>  </br> </br>
	 				
	 				<label for="bookSubmitDate"><b>Book Submit Date</b></label>
	 				<input type="date" name="bookSubmitDate" required>   </br> </br>
 
	 				<button type="submit" value="Validate" onclick="return Validate()">Book Issue</button> 
  				</form:form>--%>
  		</fieldset>
  
  		
	</div> 
	
	<script href="https://code.jquery.com/jquery-3.4.1.slim.min.js" type="text/javascript"/>
	<script type="text/javascript">
    function Validate() {
        var ddlFruits = document.getElementById("Select Book");
        if (ddlFruits.value == "") {
            //If the "Please Select" option is selected display error.
            alert("Please select an option!");
            return false;
        }
        return true;
    }
</script> 


</body>
</html>  