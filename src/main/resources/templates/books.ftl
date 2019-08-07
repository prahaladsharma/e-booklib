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
		<H2>Add Book</H2>
	</div>

	<div id="content">
  		<fieldset>
  			<legend>Add Book</legend>
  				<form name="emp" action="addBook" method="post">
  					Title : <input type="text" name="title" />	<br/>
  					Author: <input type="text" name="bookAuthor" />	<br/>
  					Available: <input type="text" name="isAvaiable" />	<br/> 
  					Qunatity: <input type="text" name="bookQuantity" /> <br/>  
  					<input type="submit" value="   Save   " />
  				</form>
  		</fieldset>
  
  		<br/>
  		<table class="datatable">
  			<tr>
  				<th>Title</th>
  				<th>Author</th>
  				<th>Books Quantity</th>
  				<th>Edit/Delete</th>				
  			</tr>
    		<#list models["bookList"] as emp>
	  			<tr>
	  				<td>${emp.title}</td>
	  				<td>${emp.bookAuthor}</td>
						  				
	  				<td> <#if emp.bookQuantity?has_content>
    					   ${emp.bookQuantity}
						 </#if> 
					</td>
					<td width="60" align="center"><a href="adminbookupdate/${emp.id}">Edit</a>/<a href="deleteemp/${emp.id}">Delete</a></td>
	  			</tr>
    		</#list>
  		</table>
	</div>  
</body>
</html>  