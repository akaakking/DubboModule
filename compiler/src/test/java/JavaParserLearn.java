import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Modifier;
import com.github.javaparser.ast.NodeList;
import com.github.javaparser.ast.body.*;
import com.github.javaparser.ast.expr.*;
import com.github.javaparser.ast.stmt.BlockStmt;
import com.github.javaparser.ast.stmt.ExpressionStmt;
import com.github.javaparser.ast.stmt.ReturnStmt;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.type.TypeParameter;
import com.github.javaparser.ast.visitor.ModifierVisitor;
import com.github.javaparser.ast.visitor.Visitable;
import com.google.common.collect.Sets;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.*;
import com.thoughtworks.qdox.model.impl.DefaultJavaParameterizedType;
import com.thoughtworks.qdox.model.impl.DefaultJavaTypeVariable;
import com.thoughtworks.qdox.type.TypeResolver;
import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * 最多看到5点注意搞清楚一件事
 * 能不能帮我们生成代码和改代码
 *
 * @Author wfh
 * @Date 2022/8/14 下午2:43
 */
public class JavaParserLearn {

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
        CompilationUnit cu = StaticJavaParser.parse("public class A{ public void eat() {}}");
        ClassOrInterfaceDeclaration coid =  cu.getClassByName("A").get();
        for (MethodDeclaration method : coid.getMethods()) {
            method.setType("java.util.List<java.util.Map<? extends java.lang.String,java.lang.String>>");
            System.out.println(method.getType().asClassOrInterfaceType().getTypeArguments().get());
        }
        System.out.println(cu);
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
        System.out.println(addOrNot("java.util.Collection<org.apache.dubbo.config.ConfigCenterConfig>"));
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




    private void addClass(CompilationUnit cu, JavaClass javaClass) {
        cu.setPackageDeclaration("org.apache.dubbo.Interface");

        ClassOrInterfaceDeclaration coid = cu.addClass("chilema");
        coid.setInterface(true);

        TypeParameter typeParameter = new TypeParameter();
        typeParameter.setName("T");
        ClassOrInterfaceType classOrInterfaceType = new ClassOrInterfaceType();
        classOrInterfaceType.setName("AbstactConfig");
        NodeList<ClassOrInterfaceType> nodeList = new NodeList<>();
        nodeList.add(classOrInterfaceType);
        typeParameter.setTypeBound(nodeList);

        coid.addTypeParameter(typeParameter);

        MethodDeclaration methodDeclaration = coid.addMethod("chifan");

        methodDeclaration.addParameter("List<String>","strs");
        methodDeclaration.setType("List"); // return type

        System.out.println(methodDeclaration.getBody());

        NodeList<TypeParameter> nodeList1 = new NodeList<>();
        TypeParameter typeParameter1 = new TypeParameter();
        nodeList1.add(typeParameter1);
        typeParameter1.setName("T");
        methodDeclaration.setTypeParameters(nodeList1); // 泛型
        System.out.println(cu);
    }

    String dealType(String genericFullName,String genericValue) {
        String brackets = "";

        if (genericValue.contains("[")) {
            brackets = genericValue.substring(genericValue.indexOf("["),genericValue.lastIndexOf("]")  + 1);
            genericValue = genericValue.substring(0,genericValue.indexOf("["));
            genericFullName = genericFullName.substring(0,genericFullName.indexOf("["));
        }

        Queue<String> suffixs = new LinkedList<>(); // ? extend
        StringBuilder result = new StringBuilder();
        int i = 0;


        while (i < genericFullName.length()) {
            int index1 = genericFullName.indexOf("<",i);
            int index2 = genericFullName.indexOf(">",i);
            int index3 = genericFullName.indexOf(" ",i);
            int index4 = genericFullName.indexOf(",",i);
            int index5 = genericFullName.indexOf("? extends ",i);

            int min = min(index1,index2,index3,index4,index5);

            if (i == min) {
                if (i == index5) {
                    i = i + 10;
                } else {
                    i = i + 1;
                }
            } else {
                String s1 = genericFullName.substring(i, min);
                if (checkName(s1)) {
                    suffixs.add("Interface");
                } else {
                    suffixs.add("");
                }
                i = min;
                if (i == index5) {
                    i = i + 10;
                } else {
                    i = i + 1;
                }
            }
        }

        i = 0;

        while (i < genericValue.length() - 1) {
            int index1 = genericValue.indexOf("<",i);
            int index2 = genericValue.indexOf(">",i);
            int index3 = genericValue.indexOf(" ",i);
            int index4 = genericValue.indexOf(",",i);
            int index5 = genericValue.indexOf("? extends ",i);

            int min = min(index1,index2,index3,index4,index5);

            if (i == min) {
                if (i == index5) {
                    result.append(genericValue.substring(i,i + 10));
                    i = i + 10;
                } else {
                    result.append(genericValue.substring(i,i + 1));
                    i = i + 1;
                }
            } else {
                String s1 = genericValue.substring(i, min);
                result.append(s1).append(suffixs.poll());
                i = min;
            }
        }

        return result.append(">").append(brackets).toString();
    }


    @Test
    public void gengg() {
        CompilationUnit cu = StaticJavaParser.parse("public class A {public void add(String a){}}");
        ClassOrInterfaceDeclaration coid = cu.getClassByName("A").get();

        for (MethodDeclaration method : coid.getMethods()) {
            BlockStmt blockStmt = new BlockStmt();
            method.setBody(blockStmt);
            MethodCallExpr methodCallExpr = new MethodCallExpr(new NameExpr("instance"),"get");
            methodCallExpr.addArgument("name.getInstance()");
            methodCallExpr.addArgument("\"fds\"");


            AssignExpr assignExpr = new AssignExpr(new NameExpr("super.instance"),new NameExpr("instance"), AssignExpr.Operator.ASSIGN);
            blockStmt.addStatement(new ExpressionStmt(assignExpr));
            blockStmt.addStatement(new ExpressionStmt(methodCallExpr));
        }

        System.out.println(cu);
    }

    @Test
    public void gene() {
//        String geneFull = "java.util.Map<? extends java.lang.String,java.uitl.Map<java.lang.String,java.lang.List<org.apache.dubbo.String>>>";
//        String geneValue = "Map<String,Map<? extends String,List<String>>>";
        String geneFull = "java.util.Map<java.lang.Class<?>,org.apache.dubbo.String>";
        String geneValue = "Map<Class<?>,Map.String>";
        System.out.println(dealType(geneFull, geneValue));

//
//        String kuohao = "";
//
//
//        if (geneValue.contains("[")) {
//            kuohao = geneValue.substring(geneValue.indexOf("["),geneValue.lastIndexOf("]")  + 1);
//            geneValue = geneValue.substring(0,geneValue.indexOf("["));
//            geneFull = geneFull.substring(0,geneFull.indexOf("["));
//        }
//
//
//        Queue<String> list1 = new LinkedList<>(); // ? extend
//        Queue<String> list2 = new LinkedList<>();
//        StringBuilder result = new StringBuilder();
//        int i = 0;
//
//        while (i < geneFull.length()) {
//            int index1 = geneFull.indexOf("<",i);
//            int index2 = geneFull.indexOf(">",i);
//            int index3 = geneFull.indexOf(" ",i);
//            int index4 = geneFull.indexOf(",",i);
//            int index5 = geneFull.indexOf("? extends ",i);
//
//            int min = min(index1,index2,index3,index4,index5);
//
//            if (i == min) {
//                if (i == index5) {
//                    i = i + 10;
//                } else {
//                    i = i + 1;
//                }
//            } else {
//                String s1 = geneFull.substring(i, min);
//                if (checkName(s1)) {
//                    list1.add("Interface");
//                } else {
//                    list1.add("");
//                }
//                i = min;
//                if (i == index5) {
//                    i = i + 10;
//                } else {
//                    i = i + 1;
//                }
//            }
//        }
//
//        i = 0;
//
//        while (i < geneValue.length() - 1) {
//            int index1 = geneValue.indexOf("<",i);
//            int index2 = geneValue.indexOf(">",i);
//            int index3 = geneValue.indexOf(" ",i);
//            int index4 = geneValue.indexOf(",",i);
//            int index5 = geneValue.indexOf("? extends ",i);
//
//            int min = min(index1,index2,index3,index4,index5);
//
//            if (i == min) {
//                if (i == index5) {
//                    result.append(geneValue.substring(i,i + 10));
//                    i = i + 10;
//                } else {
//                    result.append(geneValue.substring(i,i + 1));
//                    i = i + 1;
//                }
//            } else {
//                String s1 = geneValue.substring(i, min);
//                result.append(s1).append(list1.poll());
//                i = min;
//            }
//        }
//
//        System.out.println(result.append(">").append(kuohao));
    }

    // 求出最小非负
    private int min(int... nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i<nums.length; i++) {
            if (nums[i] >= 0  && nums[i] < min) {
                min = nums[i];
            }
        }

        return min;
    }

    @Test
    public void fdsfsdfsdf() {
        String a = ".fsdfdsfds";
        System.out.println(a.indexOf(".f", 0));

    }


    @Test
    public void gengdsf() {
        JavaProjectBuilder jdb = new JavaProjectBuilder();
        try {
            jdb.addSource(new File("/home/wfh/DubboModule/dubbo/dubbo-rpc/dubbo-rpc-api/src/main/java/org/apache/dubbo/rpc/Invocation.java"));
            for (JavaClass javaclass : jdb.getClasses()) {
                for (JavaMethod method : javaclass.getMethods()) {
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
    public void gener() {
        CompilationUnit compilationUnit = new CompilationUnit();
        compilationUnit.addImport("org.springframework.boot.SpringApplication");
        compilationUnit.setPackageDeclaration("com.abc.def");
        ClassOrInterfaceDeclaration classDeclaration = compilationUnit.addClass("AnyClassName").setPublic(true);
        classDeclaration.addAnnotation("AnyAnnotation");
        compilationUnit.addClass("Wang").setPublic(true);
        System.out.println(compilationUnit);
    }

    private class RemoveFileds extends ModifierVisitor<Void> {
        @Override
        public Visitable visit(FieldDeclaration n, Void arg) {
            super.visit(n, arg);
            n.remove();
            return n;
        }
    }

    private class InterfaceMethod extends ModifierVisitor<Void> {

        @Override
        public Visitable visit(MethodDeclaration n, Void arg) {
            super.visit(n, arg);
            if (n.isPublic()) {
                n.removeBody();
            } else {
                n.remove();
            }
            return n;
        }
    }

}

// 今天看能不能重新做一下，顺便把class也一搞，生成代码用模板，实在不是个好办法。
