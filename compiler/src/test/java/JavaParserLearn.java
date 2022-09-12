import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.BinaryExpr;
import com.github.javaparser.ast.expr.CastExpr;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.type.ClassOrInterfaceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.resolution.types.ResolvedType;
import com.github.javaparser.symbolsolver.JavaSymbolSolver;
import com.github.javaparser.symbolsolver.model.resolution.TypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.CombinedTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.JavaParserTypeSolver;
import com.github.javaparser.symbolsolver.resolution.typesolvers.ReflectionTypeSolver;
import org.apache.dubbo.compiler.FileUtils;
import org.junit.Test;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/5 下午3:11
 */
public class JavaParserLearn {
    private List<String> javafiles = new ArrayList<>();

    @Test
    public void castTest() {
        CompilationUnit cu = StaticJavaParser.parse("public class A{public void clean(){" +
                "b.a();}}");
        cu.findAll(MethodCallExpr.class).forEach(mce -> {
            CastExpr castExpr = new CastExpr();
            castExpr.setExpression(mce.toString());
            castExpr.setType("P");
            mce.replace(castExpr);
            System.out.println(castExpr);
        });

        System.out.println(cu);
    }

    //        ResolvedReferenceTypeDeclaration resolvedReferenceTypeDeclaration = typeSolver.solveType(Object.class.getName());
//        resolvedReferenceTypeDeclaration.getAllMethods().forEach(con -> {
//        });
//        CompilationUnit cu;
//        JavaProjectBuilder jpb = new JavaProjectBuilder();
//        try {
//            jpb.addSource(new File("/home/wfh/tem/dubbo/dubbo-metadata/dubbo-metadata-api/src/main/java/org/apache/dubbo/metadata/MetadataInfo.java"));
//
//            JavaClass javaClass = jpb.getClassByName("org.apache.dubbo.metadata.MetadataInfo");
//            for (JavaMethod method : javaClass.getMethods()) {
//                System.out.println(method.getCodeBlock());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    //new File("/home/wfh/tem/dubbo/dubbo-metadata/dubbo-metadata-api/src/main/java/org/apache/dubbo/metadata/MetadataInfo.java")
//        CompilationUnit cu = StaticJavaParser.parse("public class A{public void clean(){" +
//                    "String b = null;" +
//                "if (a == b) {return;}" +
//                    "c = b;" +
//                "b.a();}}");
//        cu.findAll(AssignExpr.class).stream().forEach(con ->{
//            System.out.println(con);
//        });

//        ClassOrInterfaceDeclaration cd = cu.getClassByName("A").get();
//        for (MethodDeclaration method : cd.getMethods()) {
//            BlockStmt blockStmt = method.getBody().get();
//            for (Statement statement : blockStmt.getStatements()) {
//                if (statement.isExpressionStmt()) {
//                    ExpressionStmt expressionStmt = statement.asExpressionStmt();
//                }
//            }
//        }
    // 为什么当初觉得不可以。因为可能调用了某些接口接口的返回值是带有Interface的。而不是那个东西本身。
    // 也就是说得这样排查，每个快都得查，警惕可能出现Interface的情况
    // 主要是这几个情况会带有Interface
    // 1. 方法的参数。这种直接出现的地方全做强制类型转换。
    // 2. 对象调用的方法返回值可能是带有Interface的。这就很麻烦因为没有办法确定某个对象的类型。
    //    注意接受赋值会出错。
    //    直接调用返回值会出错。

    @Test
    public void groupTest() {
        CombinedTypeSolver combinedTypeSolver = new CombinedTypeSolver();
        combinedTypeSolver.add(new ReflectionTypeSolver());

        // Configure JavaParser to use type resolution
        JavaSymbolSolver symbolSolver = new JavaSymbolSolver(combinedTypeSolver);
        StaticJavaParser.getConfiguration().setSymbolResolver(symbolSolver);

        // Parse some code
        CompilationUnit cu = StaticJavaParser.parse("class X { int x() { return 1 + 1.0 - 5; } }");

        // Find all the calculations with two sides:
        cu.findAll(BinaryExpr.class).forEach(be -> {
            // Find out what type it has:
            ResolvedType resolvedType = be.calculateResolvedType();
            System.out.println(be.toCastExpr().get());

            // Show that it's "double" in every case:
            System.out.println(be.toString() + " is a: " + resolvedType);
        });
    }

    public String group(String projectBasePath) {
        String path = "/home/wfh/DubboModule/java";

        inOrNot(new File(projectBasePath));

        for (String javafile : javafiles) {
            try {
                FileUtils.copyFolder(javafile,path);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return path;
    }

    public void inOrNot(File file) {
        if (file.getName().equals("java")) {
            this.javafiles.add(file.getAbsolutePath());
            return;
        } else if (file.getName().equals("test") || file.getName().equals("resources")) {
            return;
        }

        for (File f : file.listFiles()) {
            if (f.isDirectory()) {
                inOrNot(f);
            }
        }
    }



    @Test
    public void min() {
        String ste = "fsdfdsfdsf";
        ste = ste.substring(0,4);
        Re(ste);
        System.out.println(ste);
    }

    public void Re(String str) {
        str = str.substring(0,3);
    }

    @Test
    public void importTest() {
        String src = group("/home/wfh/tem/dubbo");
        String path = "/home/wfh/tem/dubboTem/dubbo-common/src/main/java/org/apache/dubbo/config/ApplicationConfig.java";
        TypeSolver solver = new JavaParserTypeSolver(src);
        TypeSolver typeSolvers = new CombinedTypeSolver();
        TypeSolver typeSolver = new ReflectionTypeSolver();
        TypeSolver combine = new CombinedTypeSolver(solver,typeSolver);

        StaticJavaParser.getConfiguration().setSymbolResolver(new JavaSymbolSolver(combine));

        CompilationUnit cu = null;

        try {
            cu = StaticJavaParser.parse(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        cu.findAll(MethodDeclaration.class).forEach(md -> {
            Type type = md.getType().getElementType();
            type.resolve();

            System.out.println(md.getType().resolve().describe());
        });

//   todo     cu.findAll(FieldDeclaration.class).forEach(fd -> {
//            System.out.println(fd.getElementType().resolve().describe());
//        });

//        cu.findAll(MethodCallExpr.class).stream().forEach(mc -> {
//            // 首先获取调用的类。 org.apache.dubbo.common.logger.LoggerFactory.getErrorTypeAwareLogger
//            String callMethod  = mc.resolve().getQualifiedName();
//
//            // 判断这个类的调用的这个方法是不是暴露的
//            String sig = mc.resolve().getSignature();
//
//            // 如果是的话，做出做强制类型转换
//        });
//
//
//        cu.findAll(FieldDeclaration.class).stream().forEach(fd -> {
//            fd.remove();
//        });
//
//        // 对于method要完成这些东西，含有dubbo的要能辨别出来。
//        cu.findAll(MethodDeclaration.class).stream().forEach(md -> {
//            if (md.isPrivate()) {
//                md.remove();
//            }
//            md.removeBody();
//        });
    }
}
//  todo the most nice               System.out.println(md.getType().resolve().describe());
// System.out.println(mce.resolve().getReturnType().isTypeVariable());  是否是泛型类似于T这些