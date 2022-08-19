package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.model.JavaClass;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/19 下午12:30
 */
public class DefaultAbstractGenerator extends AbstractGenerator{
    public static final String ExportPackageInfoPath = "/home/wfh/DubboModule/compiler/src/main/resources/exportpackage";

    private String exportPackageInfoPath;

    /**
     * sourthCodeBasePath        /x/x/x/dubbo
     * classOutPutDir            /x/x/x/src/main/java/
     * exportPackageInfoPath     /x/x/x/src/resources/exportPackageInfo
     *
     * @param sorthCodeBasePath
     * @param classOutPutDir
     */
    public DefaultAbstractGenerator(String sorthCodeBasePath, String classOutPutDir,String exportPackageInfoPath) {
        super(sorthCodeBasePath, classOutPutDir);
        this.exportPackageInfoPath = exportPackageInfoPath;
    }

    // 提供不方便用包表示的javaclasses
    @Override
    protected Set<String> provideExportClasses() {
        return null;
    }

    @Override
    protected Set<String> provideExportPackages() {
        return readConfig(this.exportPackageInfoPath);
    }

    @Override
    protected void dealInnerClass(JavaClass javaClass) {
    }

    @Override
    protected void dealAnnotation(JavaClass javaClass) {
        directExport(javaClass);
    }

    @Override
    protected void dealEnum(JavaClass javaClass) {
        directExport(javaClass);
    }
}
