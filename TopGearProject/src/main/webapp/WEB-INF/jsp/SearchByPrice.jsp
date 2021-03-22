<!DOCTYPE html>
<html>
    <title></title>
    <head>
    <%@page import="java.sql.*"%>
        <style>
            table, tr, td
            {
                border: 1px solid black;
                margin: auto;
                width: 50%;
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
    
    <%
    
    
    
    try
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "root");
    	Statement st = con.createStatement();
    	
    	String operator = "";
    	if (request.getParameter("less") != null)
    		 operator = "<";
    	else
    		 operator = ">";
    	ResultSet rs = st.executeQuery("Select * from cars where price "+ operator +" 500000");
    
    
    %>
        <form  action="/ConfirmPage" method="POST">
    <table border=1 style="text-align:center">
      <thead>
          <tr>
             <th>Brand</th>
             <th>Model</th>
             <th>Year</th>
             <th>Distance</th>
             <th>Price</th>
             <th>Fuel</th>
          </tr>
      </thead>
      <tbody>
      
      
        <%
        
        while(rs.next())
        {
            %>
            <tr>
                <td>
                	<input type="radio" name="car" id="car" value="<%=rs.getString("brand") %> <%=rs.getString("model") %>" />
                	<%=rs.getString("brand") %>
                </td>
                <td><%=rs.getString("model") %></td>
                <td><%=rs.getInt("year") %></td>
                <td><%=rs.getInt("distance") %></td>
                <td><%=rs.getInt("price") %></td>
                <td><%=rs.getString("fuel") %></td>
            </tr>
            <%}%>
           </tbody>
        </table><br>
    
    
    <%}
    catch (Exception e)
    {
    	e.printStackTrace();
    }
    
    finally
    {
    	//close connection
    }
    
    %>
    
        <br>
        <div class="class1">
        	<a href="/PriceForm">Back</a>
            <a href="/">Home</a> 
                
        </div>
        <input style="margin-left:50%" type="submit" value="submit">
    </form>

    </body>
</html>