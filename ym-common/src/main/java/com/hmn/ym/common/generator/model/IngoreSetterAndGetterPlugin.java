package com.hmn.ym.common.generator.model;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class IngoreSetterAndGetterPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> warnings) {

        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
                                                 IntrospectedTable introspectedTable) {
        topLevelClass.addJavaDocLine("import lombok.Getter;");
       topLevelClass.addJavaDocLine("import lombok.Setter;");
        //topLevelClass.addJavaDocLine("import lombok.Data;");
        // topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModelProperty;");
        //topLevelClass.addJavaDocLine("import io.swagger.annotations.ApiModel;");
        //该代码表示在生成class的时候，向topLevelClass添加一个@Setter和@Getter注解
       topLevelClass.addAnnotation("@Getter@Setter");
        // topLevelClass.addAnnotation("@Data");
        // topLevelClass.addJavaDocLine("@ApiModel(value =\""+ introspectedTable.getFullyQualifiedTable() + "\")");
        return super.modelBaseRecordClassGenerated(topLevelClass,
                introspectedTable);
    }

    //该方法在生成每一个属性的getter方法时候调用，如果我们不想生成getter，直接返回false即可；
    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }

    //该方法在生成每一个属性的setter方法时候调用，如果我们不想生成setter，直接返回false即可；
    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable,
                                              ModelClassType modelClassType) {
        return false;
    }


    @Override
    public boolean modelFieldGenerated(Field field, TopLevelClass topLevelClass,
                                       IntrospectedColumn introspectedColumn, IntrospectedTable introspectedTable,
                                       ModelClassType modelClassType) {
        String remark = introspectedColumn.getRemarks();
        //field.addJavaDocLine("/**111 " + remark + " */");
        //field.addJavaDocLine("@ApiModelProperty(\""+remark+"\")");
        if (field.getName().equals("uuid")) {
            field.addJavaDocLine("@Column(name = \"uuid\")");
        }
        return true;
    }


}
