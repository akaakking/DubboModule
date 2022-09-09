package org.apache.dubbo.compilerPro;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.PackageDeclaration;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import org.apache.dubbo.compiler.FileUtils;
import org.checkerframework.checker.units.qual.C;

import java.io.File;
import java.util.Set;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/9 下午12:43
 */
public class InterfaceGenerator {
    private AbstactGenerator abstactGenerator;
    private String interfaceOutPutDir;

    public InterfaceGenerator(AbstactGenerator abstactGenerator) {
        this.abstactGenerator = abstactGenerator;
        this.interfaceOutPutDir = abstactGenerator.getTargetPath() + "/dubbo-common/src/main/java/org/apache/dubbo/Interface/";
        File file = new File(this.interfaceOutPutDir);
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public void generateInterface(CompilationUnit cu,String className) {
        cu.findAll(FieldDeclaration.class).forEach(fieldDeclaration -> {
            fieldDeclaration.remove();
        });

        cu.findAll(ConstructorDeclaration.class).forEach(constructorDeclaration -> {
            constructorDeclaration.remove();
        });

        cu.findAll(BlockStmt.class).forEach(blockStmt -> {
            blockStmt.remove();
        });

        cu.findAll(MethodDeclaration.class).forEach(md -> {
            // 返回值 参数 泛型
            if (!md.isPublic() || md.isStatic()) {
                md.remove();
                return;
            }

            dealReturnType(md);
        });

        cu.setPackageDeclaration("org.apache.dubbo.Interface");

        cu.findAll(ClassOrInterfaceDeclaration.class).forEach(coid -> {
            coid.setName(coid.getNameAsString() + "Interface");
        });

        saveInterface(cu,className);
    }

    public void dealReturnType(MethodDeclaration md) {
        String genericValue = md.getTypeAsString();
        String genericString = null;
        try {
             genericString = md.getType().resolve().describe();
        } catch (Exception e) {
        }


        String  type = abstactGenerator.dealType(genericString,genericValue);
        if (type == null) {
            md.remove();
            return;
        }
        md.setType(new ClassOrInterfaceType(type));
    }

    public void saveInterface(CompilationUnit cu,String className) {
        FileUtils.saveContent(cu.toString(),this.interfaceOutPutDir + className + "Interface.java");
    }
}
