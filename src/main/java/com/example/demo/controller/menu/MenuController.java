package com.example.demo.controller.menu;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.common.BaseController;
import com.example.demo.domain.menu.Menu;
import com.example.demo.service.menu.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;


    /**
     *进入页面
     */
    @GetMapping()
    public String menu(Model mmap,Menu menu) {
        List<Menu> menus = menuService.selectMenuList(menu);
        mmap.addAttribute("menus", JSON.toJSON(menus));
        return "menu/menu";
    }

    /**
     *列表
     */
    @GetMapping("/list")
    @ResponseBody
    public List<Menu> list(Menu menu)
    {
        List<Menu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }
}
