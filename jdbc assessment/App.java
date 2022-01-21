package com.dxc.assessment;

import java.sql.SQLException;
import java.util.List;
import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.modal.Author;

public class App {
    public static void main(String[] args) {
        findAllAuthors();
    }

    static void findAllAuthors(){
        
        AuthorDao dao = new AuthorDao();
        try {
            List<Author> authors = dao.findAll();
            if (authors.size() == 0) {
                System.out.println("No authors found");
                return;
            }
            authors.forEach(au -> System.out.println(au));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    static void createAuthors() {
        Author GeorgeOrwell = new Author(12, "Thanish", "Remog","action","Thanish@ioq.com");
        Author FrankHerbert = new Author(13, "Stephen" , "Sharma","Timetravel","vdcjsbd@gjks.com");

        List<Author> authors = List.of(ThanishRemog, StephenSharma);
        AuthorDao authorDao = new AuthorDao();

        authors.forEach(a -> {
            try {
                int row = authorDao.save(a);
                System.out.println("Rows affected: " + row);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
    }
}