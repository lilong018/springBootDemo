package com.example.demo.service.menu;

import com.example.demo.domain.menu.Menu;
import com.example.demo.mapper.menu.MenuMapper;
import com.example.demo.utils.TreeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> selectAllMenus() {
        List<Menu> menus = menuMapper.selectAllMenus();
        return TreeUtils.getChildPerms(menus, 0);
    }

    @Override
    public List<Menu> selectMenuList(Menu menu) {
        List<Menu> menus = menuMapper.selectMenuList(menu);
        return menus;
    }
}
