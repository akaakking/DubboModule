import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.Statement;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.google.common.collect.Sets;
import com.sun.org.apache.xerces.internal.dom.ChildNode;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * todo add comment here
 *
 * @Author wfh
 * @Date 2022/8/14 下午2:43
 */
public class JavaParserLearn{



    @Test
    public void tesgg() {
        Set<String> set = new HashSet<>();
        Set<String> set1 = new HashSet<>();
        File file = new File("/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfos");
        File file1 = new File("/home/wfh/DubboModule/compiler/src/main/resources/extraExportInfo.txt");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            BufferedReader bufferedReader1 = new BufferedReader(new FileReader(file1));
            String str = null;
            do {
                str = bufferedReader.readLine();
                set.add(str);
            } while (str != null);

            do {
                str = bufferedReader1.readLine();
                set1.add(str);
            } while (str != null);

            System.out.println(Sets.difference(set, set1));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void fds() {


        JavaProjectBuilder jpb = new JavaProjectBuilder();

        try {
            jpb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/ConfigScopeModelInitializer.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                for (JavaMethod method : aClass.getMethods()) {
//                    System.out.println(method); // 只有方法签名没有函数体
                    for (JavaTypeVariable<JavaGenericDeclaration> typeParameter : method.getTypeParameters()) {
                        typeParameter.getName();
                        typeParameter.getBounds();
                    } // method 泛型

                    for (JavaParameter parameter : method.getParameters()) {
//                        System.out.println(parameter); //FrameworkModel frameworkModel ,ApplicationModel applicationModel,ModuleModel moduleMode, List a
                        JavaType javaType =parameter.getType();
                        System.out.println(dealGenericValue(javaType));
                        System.out.println();
//                        System.out.println(parameter.getCanonicalName()); // java.util.List java.lang.String[]
//                        System.out.println(javaType.getFullyQualifiedName()); //java.util.List java.lang.String[]
//                        System.out.println(javaType.getGenericFullyQualifiedName()); // java.util.List<java.lang.String>  java.lang.String[]
//                        System.out.println(javaType.getGenericValue());  // List<String> String[]
//                        System.out.println(javaType.getGenericCanonicalName()); // java.util.List<java.lang.String> java.lang.String[]
//                        System.out.println(javaType.toGenericString()); //java.util.List<java.lang.String> java.lang.String[]
//                        System.out.println(javaType.getBinaryName()); // java.util.List java.lang.String
//                        System.out.println(javaType.getValue());
//                        System.out.println();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Map<Map<String,? extends String>,Refence<String>>[]

    /**
     * 停止条件
     * 遇到 ， “ ”
     */

    String dealGenericValue(JavaType javaType) {
        StringBuilder result = new StringBuilder();

        // 判断有无泛型
        String genericValue = javaType.getGenericValue();
        if (!genericValue.contains("<")){
            if (checkName(javaType.getBinaryName())) {
                return shortName(genericValue) + "Interface";
            }
            return  shortName(genericValue);
        }

        String genericFullyQualifiedName = javaType.getGenericFullyQualifiedName();

        result.append(javaType.getValue());
        String valueFullName = genericFullyQualifiedName.substring(0,genericFullyQualifiedName.lastIndexOf("<"));
        if (checkName(valueFullName)) {
            result.append("Interface");
        }
        result.append("<");

        String content = genericFullyQualifiedName.substring(genericFullyQualifiedName.indexOf("<") + 1,genericFullyQualifiedName.lastIndexOf(">"));


        if (content.contains(",")) {
            for (String s : content.split(",")) {
                if (s.contains("extends")) {
                    s = s.substring(s.lastIndexOf("extents") + 1);
                }
                if (checkName(s.trim())) {
                    result.append(addInterface(shortName(s.trim())));
                    result.append(",");
                } else {
                    result.append(shortName(s.trim()));
                    result.append(",");
                }
            }
            result.delete(result.length() - 1, result.length()).toString();
        } else {
            if (content.contains("extends")) {
                content = content.substring(content.lastIndexOf("extends") + 7);
            }

            if (checkName(content.trim())) {
                result.append(addInterface(shortName(content)));
            } else {
                result.append(shortName(content));
            }
        }

        result.append(">");
        return result.toString();
    }


    String addInterface(String s) {
        StringBuilder sb = new StringBuilder(s);

        if (s.contains("<")) {
            sb.insert(sb.lastIndexOf("<"),"Interface");
            return sb.toString();
        }

        if (s.contains("[")) {
            sb.insert(sb.lastIndexOf("["),"Interface");
            return sb.toString();
        }

        return s + "Interface";
    }


    String shortName(String oldName) {
        if (!oldName.contains(".")) {
            return oldName;
        }

        return oldName.substring(oldName.lastIndexOf(".") + 1);
    }

    boolean isPrimitive(String name) {
        return "void".equals( name ) || "boolean".equals( name ) || "byte".equals( name ) || "char".equals( name )
                || "short".equals( name ) || "int".equals( name ) || "long".equals( name ) || "float".equals( name )
                || "double".equals( name );
    }

    boolean checkName(String name) {
        if (name == null) {
            return false;
        }

        if (isPrimitive(name) || name.startsWith("java.lang")) {
            return false;
        }

        if (name.startsWith("org.apache.dubbo") || name.startsWith("com.alibab.dubbo")) {
            // 在想要暴露的包中

            if (name.contains("annotation")) {
                return false;
            }

            return true;
        }

        if (name.length() == 1) {
            return false;
        }

        if (!name.contains(".")) {
            return true;
        } else {
            return false;
        }
    }

    @Test
    public void fdsfsdffd() {
        String A = "fdsfextends<dsadsadas>";
        String C = A.substring(A.lastIndexOf("extends") + 7);
        System.out.println(C);
    }

    @Test
    public void gsdfs() {
        CompilationUnit cu = new CompilationUnit();

        NameExpr nameExpr = new NameExpr();
        nameExpr.setName("return method = instance.getClass()");
        MethodCallExpr methodCallExpr = new MethodCallExpr(nameExpr,"getMethod");
    }

    @Test
    public void fsdbnvcf() {
        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat() {} public A(){}}");
        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();
        JavaProjectBuilder  jpb = new JavaProjectBuilder();
        try {
            jpb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-common/src/main/java/org/apache/dubbo/config/AbstractReferenceConfig.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                for (JavaMethod method : aClass.getMethods()) {
                    for (JavaAnnotation annotation : method.getAnnotations()) {
//                        System.out.println(annotation); // @java.lang.Override()   @org.apache.dubbo.config.support.Parameter(excluded=true,attribute=false)
//                        System.out.println(annotation.getType()); //java.lang.Override   org.apache.dubbo.config.support.Parameter
//                        System.out.println(annotation.getType().getName()); //Override    org.apache.dubbo.config.support.Parameter
//                        System.out.println(annotation.getCodeBlock()); //@java.lang.Override   @org.apache.dubbo.config.support.Parameter(excluded=true,attribute=false)
//                        System.out.println();
                    }
                }
            }

            NormalAnnotationExpr normalAnnotationExpr = new NormalAnnotationExpr();
            normalAnnotationExpr.addPair("wang","feihong");

            coid.addAnnotation("java.lang.Override");
            System.out.println(cu.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String deal(String str,StringBuilder sb) {
        if (str.contains(""))
        if (str.contains("<")) {
            String pre = str.substring(0,str.indexOf("<"));
            if (checkName(pre)) {
                sb.append(addInterface(shortName(pre)));
            } else {
                sb.append(shortName(pre));
            }

        }
        List<Map<String,List<String>>> a;
        return  null;
    }


    @Test
    public void fsd() {
//        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat(String name,List<String> ertt) {int i = 0; int c = i++;}}");
//        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();
//
//        MethodDeclaration methodDeclaration = coid.getMethodsBySignature("eat","String","List").get(0);
//
//        System.out.println(methodDeclaration);
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
//        try {
//            javaProjectBuilder.addSource(new File("/home/wfh/tem/dubboTem/dubbo-config/dubbo-config-spring/src/main/java/org/apache/dubbo/config/spring/reference/ReferenceBeanBuilder.java"));
//            for (JavaClass aClass : javaProjectBuilder.getClasses()) {
//                for (JavaMethod method : aClass.getMethods()) {
//                    for (JavaParameter parameter : method.getParameters()) {
//                        System.out.println(parameter.getType().getGenericValue());
//                    }
//                }
//            }

            Parameter parameter = new Parameter();
            parameter.setName("name");
        System.out.println(StaticJavaParser.parseType("Map<String,String>"));;
            parameter.setType("Map<String,String>");
        System.out.println(parameter);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


    }



    @Test
    public void fsdgfg() {
        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat(String name,String ertt) {int i = 0;}}");
        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();

//        CompilationUnit cu1 = StaticJavaParser.parse("public class B{ public void eat(String name) {int i = 0;}}");
//        ClassOrInterfaceDeclaration coid1 = cu.getClassByName("B").get();

        MethodDeclaration  methodDeclaration = coid.getMethodsBySignature("eat","String").get(0);
        CallableDeclaration.Signature si = methodDeclaration.getSignature();
        methodDeclaration.setType("");
        methodDeclaration.getTypeParameters();
        System.out.println(coid.getMethodsBySignature(String.valueOf(si)));

//        System.out.println(methodDeclaration);

//        System.out.println(cu);
    }

    @Test
    public void gfsdf() {
        JavaProjectBuilder jpb = new JavaProjectBuilder();
        try {
            jpb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-rpc/dubbo-rpc-api/src/main/java/org/apache/dubbo/rpc/Invocation.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                for (JavaMethod method : aClass.getMethods()) {
                    for (JavaParameter parameter : method.getParameters()) {
                        System.out.println(parameter.getType().getGenericValue());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @Test
    public void fsdf() {
        JavaProjectBuilder jpb = new JavaProjectBuilder();
        try {
            jpb.addSource(new File("/home/wfh/tem/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/bootstrap/builders/AbstractBuilder.java"));
            for (JavaClass aClass : jpb.getClasses()) {
                System.out.println(aClass.getFullyQualifiedName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    String addOrNot(String name) {
        StringBuilder sb = new StringBuilder();
        String pre = name.substring(0,name.indexOf("<"));
        String content = name.substring(name.indexOf("<") + 1,name.indexOf(">"));
        if (checkName(pre)) {
            sb.append(addInterface(shortName(pre)));
        } else {
            sb.append(shortName(pre));
        }

        sb.append("<");

        if (checkName(content)) {
            sb.append(addInterface(shortName(content)));
        } else {
            sb.append(shortName(content));
        }

        sb.append(">");

        return sb.toString();
    }



    @Test
    public void gener() {
        CompilationUnit compilationUnit = new CompilationUnit();
        compilationUnit.addImport("org.springframework.boot.SpringApplication");
        compilationUnit.setPackageDeclaration("com.abc.def");
        ClassOrInterfaceDeclaration classDeclaration = compilationUnit.addClass("AnyClassName").setPublic(true);
        classDeclaration.addAnnotation("AnyAnnotation");
        compilationUnit.addClass("Wang").setPublic(true);
        System.out.println(compilationUnit);
    }



    public class Mod extends ModifierVisitor {

    }
}

