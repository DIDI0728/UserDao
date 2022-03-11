package DaoImpl;

import Dao.UserDao;
import Pojo.User;
import Utils.DataBaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> selectAll() throws Exception {
        Connection connection = DataBaseConnection.getConnection();
        String sql="select * from tb_user";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();

        List<User> userList =new ArrayList<User>();
        while(rs.next()){
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password")
            );

            userList.add(user);
        }

        preparedStatement.close();
        connection.close();
        rs.close();

        return userList;
    }

    @Override
    public void insert(User user)  throws Exception{

        Connection connection = DataBaseConnection.getConnection();
        String sql="insert into tb_user(id,username,password) values(?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,null);
        preparedStatement.setString(2,user.getUsername());
        preparedStatement.setString(3,user.getPassword());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();

    }

    @Override
    public void deleteById( int id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        String sql="delete from tb_user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,id);
        
        
        preparedStatement.executeUpdate();
        
        
        preparedStatement.close();
        connection.close();

    }

    @Override
    public User findById(int id) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        String sql="select * from tb_user where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1,id);

        ResultSet resultSet = preparedStatement.executeQuery();
        
        User user=new User(resultSet.getInt("id"),resultSet.getString("username"),resultSet.getString("password"));
        
        return user;
    }

    @Override
    public void updata(User user) throws SQLException {

        Connection connection = DataBaseConnection.getConnection();
        
        String sql="update tb_user  set username=?,password=? where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);


        preparedStatement.setString(1,user.getUsername());

        preparedStatement.setString(2,user.getPassword());

        preparedStatement.setInt(3,user.getId());

        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();


    }
}
