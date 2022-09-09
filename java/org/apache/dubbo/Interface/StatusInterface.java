package org.apache.dubbo.Interface;

import org.apache.dubbo.Interface.Status$LevelInterface;

public interface StatusInterface {

    LevelInterface getLevel();

    String getMessage();

    String getDescription();
}
