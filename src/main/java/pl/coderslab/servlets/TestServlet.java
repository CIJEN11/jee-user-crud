package pl.coderslab.servlets;

import pl.coderslab.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/plain");
        try (Connection conn = DbUtil.getConnection()) {
            PrintWriter writer = resp.getWriter();
            writer.println("Połączenie działa!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
