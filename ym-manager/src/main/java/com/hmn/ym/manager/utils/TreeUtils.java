package com.hmn.ym.manager.utils;

import com.google.common.collect.Lists;

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
}
