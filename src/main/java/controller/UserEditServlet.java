package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/users/edit")
public class UserEditServlet extends HttpServlet {

    private UserDao userDao;
    public UserEditServlet (){
        this.userDao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));

        try {
            User user = userDao.findById(id);
            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/editform.jsp");

            rd.forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }







    }
}
