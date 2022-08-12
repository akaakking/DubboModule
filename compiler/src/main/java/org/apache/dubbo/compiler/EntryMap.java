package org.apache.dubbo.compiler;

import com.thoughtworks.qdox.model.JavaClass;

import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 * //TODO add class commment here
 *
 * @Author wfh
 * @Date 2022/8/12 下午2:17
 */
// <String packageName,Map<Enum ClassType,List<ExportEntry>>>
public class EntryMap {
//    <String packageName,Map<Enum ClassType,List<ExportEntry>> >
    private final static HashMap<String,HashMap<ClassType, List<JavaClass>>> entryMap = new HashMap<>();
    private String BasePath;


    public void initMap(String[] packageNames) {
        initMap(packageNames,null);
    }

    // 先把packageName小一点，粒度大一点之后再变小吧，也就是说现在递归深入到其他目录，将来不递归。
    public void initMap(String[] packageNames,String basePath) {
    }


    public void setBasePath(String basePath) {
        BasePath = basePath;
    }

    // TODO
    public void addExportPackage() {

    }
}
