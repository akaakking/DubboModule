package org.apache.dubbo.common.status;

import org.apache.dubbo.common.status.Status$Level;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Status implements StatusInterface {

    public Level getLevel() {
        return instance.getLevel();
    }

    public String getMessage() {
        return instance.getMessage();
    }

    public String getDescription() {
        return instance.getDescription();
    }

    public Status(LevelInterface level) {
        Class[] params = new Class[]{LevelInterface.class};
        Object[] args = new Object[]{level};
        instance = (StatusInterface) DubboClassLoader.getInstance(Status.class.getName(), params, args);
    }

    public Status(LevelInterface level, String message) {
        Class[] params = new Class[]{LevelInterface.class, String.class};
        Object[] args = new Object[]{level, message};
        instance = (StatusInterface) DubboClassLoader.getInstance(Status.class.getName(), params, args);
    }

    public Status(LevelInterface level, String message, String description) {
        Class[] params = new Class[]{LevelInterface.class, String.class, String.class};
        Object[] args = new Object[]{level, message, description};
        instance = (StatusInterface) DubboClassLoader.getInstance(Status.class.getName(), params, args);
    }
}
