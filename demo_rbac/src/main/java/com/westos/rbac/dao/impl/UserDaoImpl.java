package com.westos.rbac.dao.impl;

import com.westos.rbac.dao.RoleDao;
import com.westos.rbac.dao.UserDao;
import com.westos.rbac.domain.Role;
import com.westos.rbac.domain.User;
import com.westos.rbac.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author yihang
 */
public class UserDaoImpl implements UserDao {
    private RoleDao roleDao = new RoleDaoImpl();
    @Override
    public User findByUsername(String username) {
        try(Connection conn = JdbcUtil.getConnection()) {
            try(PreparedStatement psmt = conn.prepareStatement("select * from rbac_user where username = ?")) {
                psmt.setString(1, username);
                ResultSet rs = psmt.executeQuery();
                if(rs.next()) {
                    User user = new User();
                    user.setId(rs.getInt("id"));
                    user.setUsername(rs.getString("username"));
                    user.setPassword(rs.getString("password"));
                    List<Role> roles = roleDao.findByUserId(user.getId());
                    user.setRoles(roles);
                    return user;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }


    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByPage(int page, int rows) {
        return null;
    }

    @Override
    public int findCount() {
        return 0;
    }

    @Override
    public void insert(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int userId) {

    }

}
