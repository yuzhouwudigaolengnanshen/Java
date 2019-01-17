package com.westos.rbac.dao.impl;

import com.westos.rbac.dao.ModuleDao;
import com.westos.rbac.domain.Module;
import com.westos.rbac.util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yihang
 */
public class ModuleDaoImpl implements ModuleDao {
    @Override
    public List<Module> findAll() {

        try (Connection conn = JdbcUtil.getConnection()) {
            String sql = "select * from rbac_module where pid=?";
            // 查询所有一级的权限
            try(PreparedStatement s1 = conn.prepareStatement(sql)) {
                s1.setInt(1, 0);
                List<Module> list = new ArrayList<>();
                ResultSet rs = s1.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("id"); // 1, 2, 3
                    Module parent = rsToModule(rs);
                    list.add(parent);
                    // 根据 一级权限编号，查询 二级权限
                    try(PreparedStatement s2 = conn.prepareStatement(sql)) {
                        s2.setInt(1, id);
                        ResultSet rs2 = s2.executeQuery();
                        while (rs2.next()) {
                            Module child = rsToModule(rs2);
                            parent.getChildren().add(child);
                        }
                    }
                }
                return list;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    private Module rsToModule(ResultSet rs) throws SQLException {
        Module parent = new Module();
        parent.setId(rs.getInt("id"));
        parent.setName(rs.getString("name"));
        parent.setCode(rs.getString("code"));
        parent.setPid(rs.getInt("pid"));
        return parent;
    }

    @Override
    public List<Module> findByRoleId(int roleId) {
        return null;
    }

}
