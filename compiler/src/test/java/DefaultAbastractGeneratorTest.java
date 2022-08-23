import org.apache.dubbo.compiler.AbstractGenerator;
import org.apache.dubbo.compiler.DefaultAbstractGenerator;
import org.junit.Test;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/19 下午3:26
 */
public class DefaultAbastractGeneratorTest {

    @Test
    public void testforDefaultGenerator() {
        String sourthCodePath = "/home/wfh/tem/dubbo";
        String OutPutBaseDir = "/home/wfh/tem/dubboTem";
        String ExportPackagesInfo = OutPutBaseDir + "/dubbo-compiler/src/main/resources/exportpackage";
        String classOutPutDir   = OutPutBaseDir + "/dubbo-compiler/src/main/java/";
        String interfaceOutDir = OutPutBaseDir + "/dubbo-common/src/main/java/";
        String ExtraExportInfoPath  = OutPutBaseDir + "/dubbo-compiler/src/main/resources/directExportClasses";
        String DirectExportClassPath = OutPutBaseDir + "/dubbo-compiler/src/main/resources/extraExportInfos";

        DefaultAbstractGenerator defaultAbstractGenerator = new DefaultAbstractGenerator();
        defaultAbstractGenerator.setSourthCodePath(sourthCodePath);
        defaultAbstractGenerator.setOutputBaseDir(OutPutBaseDir);
        defaultAbstractGenerator.setExportPackageInfoPath(ExportPackagesInfo);
        defaultAbstractGenerator.setClassOutPutDir(classOutPutDir);
        defaultAbstractGenerator.setInterfaceOutPutDir(interfaceOutDir);
        defaultAbstractGenerator.setExtraExportInfoPath(ExtraExportInfoPath);
        defaultAbstractGenerator.setDirectExportClassPath(DirectExportClassPath);

        defaultAbstractGenerator.generate();
    }

    // option<Referengce<Applia>>
}
