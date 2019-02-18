package com.example.demo.mapper.menu;

import com.example.demo.domain.menu.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuMapper {

    public List<Menu> selectAllMenus();

    public List<Menu> selectMenuList(Menu menu);
}
