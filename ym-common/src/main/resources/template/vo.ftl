package ${package};

import com.hmn.ym.dao.entity.BaseEntity;
import lombok.Data;

import java.util.List;
import java.util.Date;

/**
* <p>
*
* </p>
*
* @author xfz
* @since 2018-05-28
*/
@Data
public class ${tableClass.shortClassName}Vo extends BaseEntity {

<#if tableClass.baseFields??>
<#list tableClass.baseFields as field>

	/**
	* ${field.remarks}
	*/
	private ${field.shortTypeName} ${field.fieldName};
</#list>
</#if>
}
