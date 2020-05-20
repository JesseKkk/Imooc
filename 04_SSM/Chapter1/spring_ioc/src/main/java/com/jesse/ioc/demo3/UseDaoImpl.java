package com.jesse.ioc.demo3;

public class UseDaoImpl implements UseDao {
    @Override
    public void findAll() {
        System.out.println("查询用户...");
    }

    @Override
    public void save() {
        System.out.println("保存用户...");

    }

    @Override
    public void update() {
        System.out.println("修改用户...");

    }

    @Override
    public void delete() {
        System.out.println("删除用户...");

    }
}
