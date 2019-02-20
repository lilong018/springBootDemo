package com.example.demo.controller.common;


import com.example.demo.domain.menu.Menu;
import com.example.demo.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 首页 业务处理
 * 
 * @author
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    private IMenuService menuService;

    // 系统首页
    @GetMapping( value = {"","/index"})
    public String index(ModelMap mmap) {
        List<Menu> menus = menuService.selectAllMenus();
        mmap.put("menus", menus);
        return "index";
    }


    // 系统介绍
    @GetMapping("/main")
    public String main(ModelMap mmap) {
        return "main";
    }
}
