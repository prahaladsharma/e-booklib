<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

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

	<form name="bookUpdates" action="bookUpdate" method="post">
	<table class="datatable" align="center">
  			<tr>
  				<th>Title</th>
  				<th>Author</th>
  				<th>Books Quantity</th>		
				<th>Update</th>	
  			</tr>
    		<#list models["bookListUpdate"] as bookUpdate>
	  			<tr>
	  				<td> <input type="text" name="title" value="${bookUpdate.title}"> </td>
	  				<td> <input type="text" value="bookAuthor" value="${bookUpdate.bookAuthor}"> </td>
						  				
	  				<td> <input type="text" name="bookQuantity" value="<#if bookUpdate.bookQuantity?has_content> ${bookUpdate.bookQuantity} </#if>"> 
					</td>
					<td><input type="submit" value="Update" /></td>
	  			</tr>
    		</#list>
  		</table>
	</form>

</body>
</html>