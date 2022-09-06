import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaSource;
import com.thoughtworks.qdox.model.impl.DefaultJavaClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/5 下午3:11
 */
public class JavaParserLearn {
    @Test
    public void importTest() {
        String de = "org.apache.dubbo";
        System.out.println(de.replaceAll("\\.","/"));
//        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
//        try {
//            JavaSource ja = javaProjectBuilder.addSource(new File("/home/wfh/tem/dubbo/dubbo-config/dubbo-config-api/src/main/java/org/apache/dubbo/config/ConfigScopeModelInitializer.java"));
//            JavaClass javaClass = javaProjectBuilder.getClassByName("fd");
//            System.out.println(javaClass.getSource().getURL());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    boolean startsWithDigitOrUpper(String s) {
        return Pattern.compile("^[A-Z]").matcher(s).find();
    }
}
