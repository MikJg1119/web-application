package dao;

import config.Database;
import model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private Database database = new Database();


    // save
    public User save(User user) throws SQLException {
    //insert do dB
        Connection connection = database.getConnection(); //1.pobranie połączenia

        /*String sql = "INSERT INTO user (first_name, last_name, email) " +
                "VALUES (" + user.getFirstName() +", " + user.getLastName()+", "+ user.getEmail()+")"; */ //to spowoduje SQL injection (potencjalnie, wpisaniem np w którąś metodę "; DROP DATABASE;"
        String sql = "INSERT INTO user (first_name, last_name, email) " +
                "Values (?,?,?)";//2.zapytanie

        PreparedStatement statement = connection.prepareStatement(sql); //3.obiekt PreparedStatement pomoże uniknąć SQL injection

        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getEmail()); //4. parametry zapytania

        statement.executeUpdate();
        //5.wykonanie zapytania do dB
        return user;

    }
    // update
    public void update(User user)throws SQLException{
        Connection connection = database.getConnection();
        String sql = "UPDATE user SET first_name=?, last_name=?, email=? WHERE id=?";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,user.getFirstName());
        statement.setString(2,user.getLastName());
        statement.setString(3,user.getEmail());
        statement.setInt(4, user.getId());

        statement.executeUpdate();


    }
    // delete
    public void delete (int id)throws SQLException{
        Connection connection = database.getConnection();
        String sql = "DELETE FROM user WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1,id);
        statement.executeUpdate();

    }
    // findById
    public User findById (int id)throws SQLException{
        Connection connection = database.getConnection();

        String sql = "SELECT id, first_name, last_name, email FROM user WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1,id);
        ResultSet result = statement.executeQuery();
        User user = null;

        while (result.next()){
            id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            user = new User(firstName, lastName, email, id);
        }

        return user;
    }

    // findAll
    public List<User> findAll()throws SQLException{
        Connection connection = database.getConnection();

        String sql = "SELECT id, first_name, last_name, email FROM user";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet result = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (result.next()){
            int id = result.getInt("id");
            String firstName = result.getString("first_name");
            String lastName = result.getString("last_name");
            String email = result.getString("email");
            users.add(new User(firstName,lastName,email,id));
        }

        return users;
    }


}
