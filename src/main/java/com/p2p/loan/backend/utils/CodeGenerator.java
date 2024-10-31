package com.p2p.loan.backend.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:postgresql://172.31.0.3:5432/p2p_loan", "postgres", "123456")
                .globalConfig(builder -> {
                    builder.author("chenqilin") // 设置作者
//                            .enableSwagger()// 开启 swagger 模式
                            .outputDir("E:\\tempFile\\generator_code"); // 指定输出目录
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.p2p.loan") // 设置父包名
                                .moduleName("backend") // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, "E:\\tempFile\\generator_code\\xml")) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("launcher") // 设置需要生成的表名
//                                .addTablePrefix("t_", "c_") // 设置过滤表前缀
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}