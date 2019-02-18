package com.example.demo.service.menu;

import com.example.demo.domain.menu.Menu;

import java.util.List;

public interface IMenuService {

    public List<Menu> selectAllMenus();

    public List<Menu> selectMenuList(Menu menu);
}
