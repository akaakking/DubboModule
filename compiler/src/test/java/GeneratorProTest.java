import org.apache.dubbo.compilerPro.DefaultGenerator;
import org.junit.Test;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/9/9 下午12:07
 */
public class GeneratorProTest {
    @Test
    public void proTest() {
        DefaultGenerator defaultGenerator  = new DefaultGenerator();
        try {
            defaultGenerator.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
