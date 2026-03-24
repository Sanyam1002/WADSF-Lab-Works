import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class StudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String course = request.getParameter("course");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db","root","password");

            PreparedStatement ps = con.prepareStatement(
            "insert into student(name,email,course) values(?,?,?)");

            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,course);

            ps.executeUpdate();

            response.sendRedirect("display.jsp");

            con.close();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}