package com.example.demo.utils;


import com.example.demo.domain.menu.Menu;

import java.util.ArrayList;
import java.util.List;


public class TreeUtils
{
    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list 分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<Menu> getChildPerms(List<Menu> list, int parentId) {
        List<Menu> returnList = new ArrayList<Menu>();
        for(Menu menu : list){
            if(menu.getPid() == parentId){
                recursionFn(list, menu);
                returnList.add(menu);
            }
        }
        return returnList;
    }


    /**
     * 递归列表
     *
     * @param list
     * @param
     */
    private static void recursionFn(List<Menu> list, Menu t)
    {
        // 得到子节点列表
        List<Menu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (Menu tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                for (Menu it: childList){
                    recursionFn(list, it);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<Menu> getChildList(List<Menu> list, Menu t)
    {
        List<Menu> tlist = new ArrayList<Menu>();

        for (Menu menu : list){
            if (menu.getPid().longValue() == t.getId().longValue()) {
                tlist.add(menu);
            }
        }
        return tlist;
    }


    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<Menu> list, Menu t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
