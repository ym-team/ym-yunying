package ${package};

import ${tableClass.fullClassName};

/**
* @description 业务层
* @author  xfz
* @since
*/
public interface I${tableClass.shortClassName}Service extends BaseService<${tableClass.shortClassName}> {
    /**
    * 保存
    *
    * @param vo
    */
    void save(${tableClass.shortClassName} vo);

    /**
    * 删除
    *
    * @param id
    */
    void delete(Integer id);
}




