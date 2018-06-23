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
            req.setAttribute("user",user);

            RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/editform.jsp");

            rd.forward(req,resp);

        } catch (SQLException e) {
            e.printStackTrace();
        }





    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt( req.getParameter("id"));
        String firstName = req.getParameter("imie");
        String lastName = req.getParameter("nazwisko");
        String email = req.getParameter("email");


        User user = new User(firstName,lastName,email,id);

        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        resp.sendRedirect("/users");

    }



}

