package ${package};

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import ${tableClass.fullClassName};
import ${tableClass.packageName?replace("entity.po","mapper")}.${tableClass.shortClassName}Mapper;
import ${package?replace("impl","")}I${tableClass.shortClassName}Service;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
* @description 业务层
* @author  xfz
* @since
*/
@Service
public class ${tableClass.shortClassName}ServiceImpl extends BaseServiceImpl<${tableClass.shortClassName}, ${tableClass.shortClassName}Mapper> implements I${tableClass.shortClassName}Service {
    @Autowired
    private ${tableClass.shortClassName}Mapper ${tableClass.variableName}Mapper;

    @Transactional
    @Override
    public void save(${tableClass.shortClassName} vo) {
        if (vo.getId() != null) {
            ${tableClass.shortClassName} ${tableClass.variableName} = new ${tableClass.shortClassName}();
            BeanUtils.copyProperties(vo, ${tableClass.variableName});

            ${tableClass.variableName}Mapper.updateByPrimaryKeySelective(${tableClass.variableName});
        } else {

            ${tableClass.shortClassName} ${tableClass.variableName} = new ${tableClass.shortClassName}();
            BeanUtils.copyProperties(vo, ${tableClass.variableName});

            ${tableClass.variableName}Mapper.insertSelective(${tableClass.variableName});
        }
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        ${tableClass.variableName}Mapper.deleteByPrimaryKey(id);
    }
}




