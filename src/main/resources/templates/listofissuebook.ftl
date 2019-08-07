<html>
<head><title> E-BookLibrary </title>

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
</style>

<body>
	<div id="header">
		<H2>Issued Books Details</H2>
	</div>

	<div id="content">
  		
  
  		<br/>

			<table class="datatable">
  			<tr>
  				<th>User</th>
  				<th>Book Name</th>
				<th>Issue Date</th>
 				<th>Submit Date</th>
 				<th>Email</th>
  			</tr>
    		<#list models["listofissuebook"] as issueBookModel>
	  			<tr>
	  				<td>${issueBookModel.userId}</td>
	  				<td>${issueBookModel.bookName}</td>
					<td>${issueBookModel.bookIssueDate}</td>
					<td>${issueBookModel.bookSubmitDate}</td>
					<td width="60" align="center"> <a href="sendemail/${issueBookModel.userId}">Email</a> </td>
	  			</tr>
    		</#list>
  		</table>
  		
	</div>  
</body>
</html>  