import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import org.apache.dubbo.compiler.AbstractGenerator;
import org.apache.dubbo.compiler.DefaultAbstractGenerator;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/19 下午3:26
 */
public class DefaultAbastractGeneratorTest {
    public static void main(String[] args) {
        DefaultAbstractGenerator  defaultAbstractGenerator = new DefaultAbstractGenerator(AbstractGenerator.PROJECT_BASE_PATH,AbstractGenerator.OUTPUT_DIR,DefaultAbstractGenerator.ExportPackageInfoPath);
        defaultAbstractGenerator.generate();
    }
}
