package com.example.generating;

import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.example.generating.config.TempConfig;
import com.example.generating.engine.TemplateEngine;
import org.junit.Test;


public class GeneratingApplicationTests {

    /**
     * beetl模板引擎 代码生成
     */
    @Test
    public void BeetlTemplateEngine() {

        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUsername("");
        dataSourceConfig.setPassword("");
        dataSourceConfig.setUrl("");

        TempConfig config = new TempConfig();// 包前缀
        config.setPrePackageName("com.example.generating");   // 包前缀
        config.setModuleName("sys"); // 模块名称称
        config.setTemplatePath("template/hans2");   // 模板路径
        config.setCover(true);  // 覆盖原有文件
        config.setAuthor("L");

        //生成
        configOrder(config);

        configTemp(config);
        // 配置导入的包
        addImport(config);
        // TODO 需要更换当前项目中的路径
//        config.getServiceImports().add("");

        TemplateEngine templateEngine = new TemplateEngine(dataSourceConfig, config);
        // 开始生成
        templateEngine.doHansGenerating(false);
    }

    /**
     * 配置order模块
     * @param config
     */
    public static void configOrder(TempConfig config) {
        // 代码生成路径
        config.setProjectPath("C:\\file");
        // 配置需要生成的表  若不配置默认生成所有
        config.getTableList().add("表名");
    }


    public static void configTemp(TempConfig config){
        /** 配置生成的模板 */
        config.getTempMap().put("Controller.java.btl", "web");
        config.getTempMap().put("Service.java.btl", "service");
        config.getTempMap().put("ServiceImpl.java.btl", "service");
        config.getTempMap().put("Entity.java.btl", "entity");
        config.getTempMap().put("Vo.java.btl", "dto.vo");
        config.getTempMap().put("Insert.java.btl", "dto.arg");
        config.getTempMap().put("Update.java.btl", "dto.arg");
        config.getTempMap().put("Search.java.btl", "dto.arg");
        config.getTempMap().put("Dao.java.btl", "dao");
        config.getTempMap().put("Dao.xml.btl", "");
    }

    /**
     * 添加需要导入的包
     * @param config
     */
    public static void addImport(TempConfig config) {
        // Controller import配置
        config.getControllerImports().add("hans.common.exception.ParameterMissException");
        config.getControllerImports().add("hans.common.persistence.ResponseVo");
        config.getControllerImports().add("hans.common.persistence.dto.BaseDto");
        config.getControllerImports().add("hans.common.persistence.dto.IdsDto");
        config.getControllerImports().add("hans.common.persistence.web.BaseController");
        config.getControllerImports().add("hans.common.aspect.Log");
        config.getControllerImports().add("hans.common.persistence.entity.PageVo");

        // Service import配置
        config.getServiceImports().add("hans.common.persistence.ResponseVo");
        config.getServiceImports().add("hans.common.persistence.service.CrudService");

        // Entity import配置
        config.getEntityImports().add("hans.common.persistence.entity.DataEntity");

        // Vo import配置
        config.getVoImports().add("hans.common.persistence.dto.BaseVo");
        // insert import配置
        config.getInsertImports().add("javax.validation.constraints.NotBlank");
        config.getInsertImports().add("javax.validation.constraints.NotNull");
        config.getInsertImports().add("org.hibernate.validator.constraints.Length");

        // update import配置
        config.getUpdateImports().add("hans.common.persistence.dto.BaseDto");
        config.getUpdateImports().add("javax.validation.constraints.NotBlank");
        config.getUpdateImports().add("javax.validation.constraints.NotNull");
        config.getUpdateImports().add("org.hibernate.validator.constraints.Length");

        // Search import配置
        config.getSearchImports().add("hans.common.persistence.dto.BasePageDto");

        // Dao import配置
        config.getDaoImports().add("hans.common.persistence.dao.CrudDao");
        config.getDaoImports().add("org.springframework.format.annotation.DateTimeFormat");
    }

}
