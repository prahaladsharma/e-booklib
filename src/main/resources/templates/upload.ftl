<html xmlns:th="https://thymeleaf.org">
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
		<H2>Upload Book</H2>
	</div>

    <div id="content" align="center">
        <h1>Upload E-Book</h1>
        <form method="post" action="doUpload" enctype="multipart/form-data">
            <table border="0" align="center">
                <tr>
                    <td>Pick file </td>
                    <td><input type="file" name="fileUpload" size="50" required /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" /></td>
                </tr>
            </table>
        </form>


		<br/>
  		<table class="datatable" align="center">
  			<tr>
  				<th>Book Name</th>
  				<th>Delete</th>				
  			</tr>
    		<#list models["uploadBookList"] as uploadedBook>
	  			<tr>
	  				<td>${uploadedBook.fileName}</td>

					<td width="60" align="center"><a href="deleteUploadedBook/${uploadedBook.id}">Delete</a></td>
	  			</tr>
    		</#list>
  		</table>

	
    </div>
</body>
</html>