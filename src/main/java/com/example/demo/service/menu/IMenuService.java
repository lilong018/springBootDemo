package com.example.demo.service.menu;

import com.example.demo.domain.menu.Menu;

import java.util.List;
import java.util.Map;

public interface IMenuService {

    public List<Menu> selectAllMenus();

    public List<Menu> selectMenuList(Menu menu);

    public Menu selectMenuById(Long pid);

    public String checkMenuNameUnique(Menu menu);

    public int insertMenu(Menu menu);

    public int updateMenu(Menu menu);

    public List<Map<String, Object>> menuTreeData();

    public int selectCountMenuByParentId(Long pid);

    public int deleteMenuById(Long menuId);
}
