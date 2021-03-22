<%@ page import="java.util.*, project.bed2.model.*,org.hibernate.*,org.hibernate.cfg.*"%>
<%!int id;
        double sal;
        String name;
        int year;
        int price, sno;
        int distance;
        String fuel;
        String model;
        Session session1 = null;%>
<body>
	<table width="220" border="1">
		<tr>
			<th>ID</th>
			<th>brand</th>
			<th>model</th>
			<th>year</th>
			<th>distance</th>
			<th>price</th>
			<th>fuel</th>
			<th>sno</th>
		</tr>
		<%
		    Configuration cf = new Configuration();
		                cf.configure();
		                SessionFactory sf = cf.buildSessionFactory();
		                session1 = sf.openSession();
		                //Using from Clause  
		                String SQL_QUERY = "from Cars";
		                Query query = session1.createQuery(SQL_QUERY);
		                Iterator it = query.iterate();
		                while (it.hasNext())
		                    {
		                        Cars e = (Cars) it.next();
		                        id = e.getFileName();

		                                
		%>
		<tr>
			<td><%=id%></td>
		</tr>
		<%
		    }
		                session1.close();
		%>
	</table>
</body>
</html>
