package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/DisplayContact", loadOnStartup=1)
public class DisplayContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection c = null;
        try {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
            String username = "cs3220stu10";
            String password = "d5rdIO5us6Ec";

            c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("select * from contacts");
            
            List<Contacts> contacts = new ArrayList<Contacts>();
            while(rs.next()) {
            	Contacts contact = new Contacts();
            	contact.setId(rs.getInt("id"));
            	contact.setName(rs.getString("name"));
            	contact.setPhone(rs.getString("phone"));
            	contacts.add(contact);
            }
            request.setAttribute("contacts", contacts);
        }
        catch(SQLException e) {
        	throw new ServletException(e);
        }
        finally {
        	try {
        		if(c != null) {
        			c.close();
                }
            }
        	catch(SQLException e) {
        		throw new ServletException(e);
            }
        }
        request.getRequestDispatcher("/WEB-INF/DisplayContact.jsp").forward(request, response);
	}
}