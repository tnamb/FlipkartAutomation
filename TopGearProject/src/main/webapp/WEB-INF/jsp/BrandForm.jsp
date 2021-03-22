<!DOCTYPE html>
<html>
    <title></title>
    <head>
        <style>
            table, tr, td
            {
                border: 1px solid black;
                margin: auto;
                width: 30%;
                border-radius: 3px;
                height: 10%;
                background-color: antiquewhite;
                
            }

            .class1
            {
                margin: auto;
                width: 50%;
            }

        </style>
    </head>

    <body>
    	<h3>BestChoice Cars</h3>
    	<h2>Choose brand to find available models</h2>
    	
    	<form action="/brand" method = "POST">
    	
    	<table>
    		<tr>
    			<th>
    				Brand:
    			</th>
    			
    			<th>
    				<select name = "selectByBrand" id = "selectByBrand">
    					<option value="Hyundai">Hyundai</option>
    					<option value="Honda">Honda</option>
    					<option value="Tata">Tata</option>
    					<option value="Maruti Suzuki">Maruti Suzuki</option>
    				</select>
    			</th>
    		</tr>
    		
    		<tr>
    			<td>
    				<input type="submit" value="submit">
    			</td>
    			
    			<td>
    				<a href=""></a>
    			</td>
    		</tr>
    	</table>
    	</form>
    </body>
</html>