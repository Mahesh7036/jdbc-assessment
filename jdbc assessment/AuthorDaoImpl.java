package com.dxc.assessment.dao;

import java.util.List;
import com.dxc.assessment.modal.Author;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class AuthorDaoImpl implements AuthorDao{

    private DataSource dataSource;

    private static final String INSERT_ONE_AUTHOR;

    private static final String SELECT_ALL_AUTHOR;

    private static final String USER_NAME;
    private static final String PASSWORD;
    private static final String URL;


    static {
        INSERT_ONE_AUTHOR = "INSERT INTO authors (id, first_name, last_name, genre, email) VALUES (?, ?, ?)";
        SELECT_ALL_AUTHOR = "SELECT * FROM authors";

        USER_NAME = "root";
        PASSWORD = "password";

        URL = "jdbc:mysql://localhost:3306/dxc";
    }


    @Override
    public int save(Author author) throws SQLException {
        Connection connection = dataSource.getConnection(URL, USER_NAME, PASSWORD);
        PreparedStatement d = connection.prepareStatement(INSERT_ONE_AUTHOR);
        d.setString(1, author.getId());
        d.setString(2, author.getFirst_Name());
        d.setString(3, author.getLast_Name());
        d.setString(3, author.getGenre());
        d.setString(3, author.getEmail());
        int row = 0;
        row = d.executeUpdate();

        d.close();
        connection.close();
        return row;
        return null;
    }

        @Override
        public List<Author> findAll() throws SQLException {
    
            Connection connection = dataSource.getConnection(URL, USER_NAME, PASSWORD);
            List<Author> authors;
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SELECT_ALL_AUTHOR);
            authors = new ArrayList();
            while (rs.next()) {
                authors.add(new Author(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
            rs.close();
            statement.close();
            connection.close();
            return authors;
        }
        return null;
    }