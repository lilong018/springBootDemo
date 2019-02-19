package com.example.demo.controller.menu;

import com.alibaba.fastjson.JSON;
import com.example.demo.controller.common.BaseController;
import com.example.demo.domain.menu.Menu;
import com.example.demo.service.menu.IMenuService;
import com.example.demo.utils.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
     *menu菜单列表
     */
    @GetMapping("/list")
    @ResponseBody
    public List<Menu> list(Menu menu)
    {
        List<Menu> menuList = menuService.selectMenuList(menu);
        return menuList;
    }

    /**
     * 新增
     */
    @GetMapping("/add/{pid}")
    public String add(@PathVariable("pid") Long pid, ModelMap mmap) {
        Menu menu = null;
        if (0L != pid){
            menu = menuService.selectMenuById(pid);
        }else{
            menu = new Menu();
            menu.setId(0L);
            menu.setMenuName("主目录");
        }
        mmap.put("menu", menu);
        return "menu/add";
    }

    /**
     * 添加数据
     */
    @PutMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Menu menu) {
        return AjaxResult.successUrl(toAjax(menuService.insertMenu(menu)),"menu");
    }

    /**
     * 修改界面
     */
    @GetMapping("/edit/{menuId}")
    public String edit(@PathVariable("menuId") Long menuId, ModelMap mmap) {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return  "menu/edit";
    }


    /**
     * 修改保存
     */
    @PutMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Menu menu) {
        return AjaxResult.successUrl(toAjax(menuService.updateMenu(menu)),"menu");
    }

    /**
     * 删除
     */
    @PostMapping("/remove/{id}")
    @ResponseBody
    public AjaxResult remove(@PathVariable("id") Long id) {
        if (menuService.selectCountMenuByParentId(id) > 0) {
            return error(1, "存在子菜单,不允许删除");
        }
        return toAjax(menuService.deleteMenuById(id));
    }

    /**
     * 选择菜单树
     */
    @GetMapping("/selectMenuTree/{menuId}")
    public String selectMenuTree(@PathVariable("menuId") Long menuId, ModelMap mmap) {
        mmap.put("menu", menuService.selectMenuById(menuId));
        return   "menu/tree";
    }

    /**
     * 加载所有菜单列表树
     */
    @GetMapping("/menuTreeData")
    @ResponseBody
    public List<Map<String, Object>> menuTreeData() {
        List<Map<String, Object>> tree = menuService.menuTreeData();
        return tree;
    }

    /**
     * 校验名称
     */
    @PostMapping("/checkMenuNameUnique")
    @ResponseBody
    public String checkMenuNameUnique(Menu menu) {
        return menuService.checkMenuNameUnique(menu);
    }
}
