package org.apache.dubbo.compiler;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.File;
import java.io.IOException;

/**
 * 实际上我只需要 list 和 if
 *
 * @Author wfh
 * @Date 2022/8/13 下午2:35
 */
public class FreeMarkerUtil {
    private static final Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

    static {
        try {
            cfg.setDirectoryForTemplateLoading(new File("/home/wfh/DubboModule/compiler/src/main/resources"));
            cfg.setDefaultEncoding("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Template getTemplate(String name) {
        try {
            return cfg.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
