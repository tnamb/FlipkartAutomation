<!DOCTYPE html>
<html>
    <title></title>
    <head>
        <style>


            .class1
            {
                margin: auto;
                width: 50%;
            }

        </style>
    </head>

    <body>
        <div class="class1">
    	<h3>BestChoice Cars</h3>
    	<h2>Choose Price to find available models</h2>
    	

    	<form action="/price" method = "POST">
			
			<input type="radio" id="less" name="less" value="less"> <label for="less">"Less than 5 Lakh"</label>
				<br>
			<input type="radio" id="more" name="more" value="more"> <label for="more">"More than 5 Lakh"</label>
				<br>
				
		<input type="submit" value="submit">
		<a href="/">Back</a>
    	</form>
    	</div>
    </body>
</html>