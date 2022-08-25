package org.apache.dubbo.compiler;

import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaConstructor;
import com.thoughtworks.qdox.model.JavaMethod;
import com.thoughtworks.qdox.model.JavaParameter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 暂时先改静态方法和普通方法，不改构造方法。
 *
 * @Author wfh
 * @Date 2022/8/23 下午7:49
 */
public class SourthCodeChanger {
    private Map<String,String> name2path;
    private Queue<MethodDeclaration> methodDeclarations;
    private Queue<JavaMethod> javaMethods;
    private Queue<JavaConstructor> javaConstructors;
    private Queue<ConstructorDeclaration> constructorDeclarations;
    private ClassOrInterfaceDeclaration newClass;
    private AbstractGenerator generator;

    public SourthCodeChanger(AbstractGenerator generator) {
        this.methodDeclarations = new LinkedList<>();
        this.javaMethods = new LinkedList<>();
        this.constructorDeclarations = new LinkedList<>();
        this.javaConstructors = new LinkedList<>();
        this.generator = generator;
        this.name2path = generator.getName2path();
    }

    public void setNewClass(ClassOrInterfaceDeclaration newClass) {
        this.newClass = newClass;
    }

    // 找方法通过方法名和参数名，现在看修改 重新做等于是
    public void changeSourceCode(JavaClass javaClass) {
        String className = javaClass.getFullyQualifiedName();
        String classPath = name2path.get(className);

        File file = new File(classPath);

        try {
            CompilationUnit cu = StaticJavaParser.parse(file);
            cu.addImport("org.apache.dubbo.Interface.*");
            ClassOrInterfaceDeclaration sourceCoid = cu.getClassByName(javaClass.getName()).get();

            changeClassSignature(sourceCoid);

            changeMethodsSignature(sourceCoid,javaClass);

            saveChange(cu,classPath);
            this.javaMethods.clear();
            this.constructorDeclarations.clear();
            this.javaConstructors.clear();
            this.methodDeclarations.clear();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void changeMethodsSignature(ClassOrInterfaceDeclaration sourthCoid,JavaClass javaClass) {
        int methodNum = this.methodDeclarations.size();

        for (int i = 0; i < methodNum; i++) {
            MethodDeclaration methodDeclaration = this.methodDeclarations.poll();
            JavaMethod javaMethod = this.javaMethods.poll();
            int paraSize = javaMethod.getParameters().size();

            MethodDeclaration sourthMethod;

            if (paraSize > 0) {
                String[] oldTypes = new String[paraSize];
                List<String[]> changedNames = new ArrayList<>();
                stuff(oldTypes,changedNames,javaMethod.getParameters(),methodDeclaration.getParameters());
                sourthMethod = sourthCoid.getMethodsBySignature(javaMethod.getName(),oldTypes).get(0);

                if (!changedNames.isEmpty()) {
                    BlockStmt blockStmt = sourthMethod.getBody().get();
                    changeBlock(blockStmt,changedNames);
                }
            } else {
                sourthMethod = sourthCoid.getMethodsBySignature(javaMethod.getName()).get(0);
            }


            sourthMethod.setType(methodDeclaration.getType());
            sourthMethod.setTypeParameters(methodDeclaration.getTypeParameters());
            sourthMethod.setParameters(methodDeclaration.getParameters());
        }
    }

    void changeBlock(BlockStmt blockStmt,List<String[]> changedNames) {
        for (Statement statement : blockStmt.getStatements()) {
            String statmentstr = statement.toString();
            for (String[] changedName : changedNames) {
                statmentstr = statmentstr.replace(changedName[0],changedName[1]);
            }

            statement.replace(new ExpressionStmt(new NameExpr(statmentstr)));
        }
    }

    void stuff(String[] oldTypes,List<String[]> changedNames,List<JavaParameter> javaParameters,NodeList<Parameter> parameters) {
        for (int i = 0; i < oldTypes.length; i++) {
            JavaParameter javaParameter = javaParameters.get(i);
            Parameter parameter = parameters.get(i);
            String oldType = StaticJavaParser.parseType(javaParameter.getType().getGenericValue()).toString();
            oldTypes[i] = oldType;
            if (!oldType.equals(parameter.getTypeAsString())) {
                // todo 缩小粒度 判断所调用方法的返回值。，判断所调用方法的权限。
                changedNames.add(new String[]{javaParameter.getName(),"((" + oldType +  ")" + javaParameter.getName() + ")"});
            }
        }
    }

    
    public void addMethod(JavaMethod javaMethod,MethodDeclaration methodDeclaration) {
        this.javaMethods.add(javaMethod);
        this.methodDeclarations.add(methodDeclaration);
    }
    
    public void addConstruct(JavaConstructor javaConstructor, ConstructorDeclaration constructorDeclaration) {
        this.javaConstructors.add(javaConstructor);
        this.constructorDeclarations.add(constructorDeclaration);
    }


    private void saveChange(CompilationUnit cu,String path) {
        FileUtils.saveContent(cu.toString(),path);
    }

    private void changeClassSignature(ClassOrInterfaceDeclaration sourthClass) {
        sourthClass.addImplementedType(newClass.getImplementedTypes(0));
    }
}


//if (methodEntries.isEmpty()) {
//            return;
//        }
//
//        for (MethodEntry methodEntry : methodEntries) {
//            List<String[]> changedParaNames = methodEntry.getChangedParaName();
//            if (changedParaNames.isEmpty()) {
//                continue;
//            }
//
//            MethodDeclaration methodDeclaration = sourthClass.getMethodsBySignature(methodEntry.getMethodName(),methodEntry.getOldParam()).get(0);
//            methodDeclaration.setType(methodEntry.getReturnType());
//            methodDeclaration.setTypeParameters(methodEntry.getTypeParameters());
//            methodDeclaration.setParameters(methodEntry.getParameters());
//
//            BlockStmt blockStmt = methodDeclaration.getBody().get();
//
//            for (Statement statement : blockStmt.getStatements()) {
//                String exp = statement.toString();
//
//                // 这里必须是paraName而不是类型名称
//                for (String[] changedParaName : changedParaNames) {
//                    // ((ApplicationConfig)ApplicationConfigInterface)
//                    exp = exp.replace(changedParaName[0],"((" + changedParaName[1] + ")" + changedParaName[0] + ")");
//                }
//            }
//        }
