package com.hmn.ym.manager.utils;

import com.google.common.collect.Lists;
import com.hmn.ym.dao.entities.vo.system.MenuVo;
import com.hmn.ym.dao.entities.vo.system.TreeModel;

import java.util.List;

public class TreeUtils {

    public static List<TreeModel> convertTree(List<TreeModel> list, Integer parentId) {
        List<TreeModel> childList = Lists.newArrayList();
        for (TreeModel tree : list) {
            if (null == tree) {
                continue;
            }
            Integer id = tree.getId();
            Integer pid = tree.getPid();
            if (parentId.equals(pid)) {
                List<TreeModel> childs = TreeUtils.convertTree(list, id);
                tree.setChildTrees(childs);
                childList.add(tree);
            }
        }
        return childList;
    }


    public static List<MenuVo> convertMenuTree(List<MenuVo> list, Integer parentId) {
        List<MenuVo> childList = Lists.newArrayList();
        for (MenuVo tree : list) {
            if (null == tree) {
                continue;
            }
            Integer id = tree.getId();
            Integer pid = tree.getParentId();
            if (parentId.equals(pid)) {
                List<MenuVo> childs = TreeUtils.convertMenuTree(list, id);
                tree.setChildMenus(childs);
                childList.add(tree);
            }
        }
        return childList;
    }
}
