package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddContact")
public class AddContact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddContact() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/AddContact.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		Connection c = null;
        try {
            String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu10";
            String username = "cs3220stu10";
            String password = "d5rdIO5us6Ec";

            c = DriverManager.getConnection(url, username, password);
            Statement stmt = c.createStatement();
            String sql = "insert into contacts (name, phone) values ('" + name + "', '" + phone + "');";
            stmt.executeUpdate(sql);
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
        response.sendRedirect("DisplayContact");
	}
}