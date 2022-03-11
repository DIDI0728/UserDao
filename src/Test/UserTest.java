package Test;

import Dao.UserDao;
import DaoImpl.UserDaoImpl;
import Pojo.User;

import java.util.List;

public class UserTest {

    public static void main(String[] args) throws  Exception {

       //查询所有
//        UserDao userDao=new UserDaoImpl();
//
//        List<User> userList = userDao.selectAll();
//
//        System.out.println(userList);


       //添加
//        UserDao userDao=new UserDaoImpl();
//        User user = new User(5, "name2", "password1");
//        userDao.insert(user);
//
//        List<User> userList = userDao.selectAll();
//        System.out.println(userList);



        UserDao userDao=new UserDaoImpl();
        User user = new User(1, "zhao", "password1");
        userDao.updata(user);

        List<User> userList = userDao.selectAll();

        System.out.println(userList);


    }
}
