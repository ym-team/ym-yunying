package com.hmn.ym.dao.entities.vo.system;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreeModel {
    // 节点ID
    private int id;
    // 父节点ID
    private int pid;
    // 节点名称
    private String name;
    //文件
    private String file;
    //地址
    private String url;
    // 是否折叠，默认为false
    private boolean open;
    //是否父节点
    private boolean isParent;
    //目标
    private String target;
    //标题
    private String title;
    // 组ID
    private int gid;
    //自身引用
    private List<TreeModel> childTrees;
}
