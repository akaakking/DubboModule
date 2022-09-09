package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.model.JavaClass;

import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/8 下午4:34
 */
public class DefautGenerator extends AbstractGenerator{
    @Override
    public void generate() {

    }

    @Override
    protected Set<String> provideExportClasses() {
        return null;
    }

    @Override
    protected Set<String> provideExportPackages() {
        return null;
    }

    @Override
    protected void dealInnerClass(JavaClass javaClass) {
    }

    @Override
    protected void dealAnnotation(JavaClass javaClass) {
    }

    @Override
    protected void dealEnum(JavaClass javaClass) {
    }

    @Override
    protected void dealPublicClass(JavaClass javaClass) {
    }

    @Override
    protected void dealPublicInterface(JavaClass javaClass) {
    }
}
