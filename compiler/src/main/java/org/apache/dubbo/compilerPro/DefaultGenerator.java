package org.apache.dubbo.compilerPro;

import com.thoughtworks.qdox.model.JavaClass;
import org.apache.dubbo.compiler.FileUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/9 下午12:00
 */
public class DefaultGenerator extends AbstactGenerator{
    private String configPath = "/home/wfh/tem/dubbo/dubbo-compiler/src/main/resources/exportpackage";

    @Override
    protected Set<String> provideExportPackagesInfo() {
        return FileUtils.readConfig(configPath);
    }

    @Override
    protected Set<JavaClass> provideExportClassesInfo() {
        return null;
    }
}
