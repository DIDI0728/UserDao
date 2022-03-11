package Dao;

import Pojo.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {

    List<User> selectAll() throws Exception;

    void insert(User user) throws Exception;

//    public void update(Student s）{   作业   }
//
//    public void delete(String iD){  作业    }
//
//    public Student findByID(long iD){   作业  }


    void deleteById(int id) throws SQLException;

    User findById(int id) throws SQLException;

    void updata(User user) throws SQLException;

}
