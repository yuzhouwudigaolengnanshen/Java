package com.westos.rbac.test;

import com.westos.rbac.dao.impl.ModuleDaoImpl2;
import com.westos.rbac.domain.Module;
import com.westos.rbac.dao.ModuleDao;
import com.westos.rbac.dao.impl.ModuleDaoImpl;

import java.util.List;

/**
 * @author yihang
 */
public class TestModuleDao {

    public static void main(String[] args) {
        ModuleDao dao = new ModuleDaoImpl2();
        System.out.println("测试查询所有的模块...");
        List<Module> all = dao.findAll();
        System.out.println("模块总数：" + all.size());
        for (Module module : all) {
            System.out.println(module);
            for (Module child : module.getChildren()) {
                System.out.println("\t" +child);
            }
        }


    }
}
