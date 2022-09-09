package org.apache.dubbo.Interface;

import java.lang.String;
import io.netty.channel.Channel;
import java.lang.Object;

public interface CommandContextInterface {

    String getCommandName();

    void setCommandName(String commandName);

    String[] getArgs();

    void setArgs(String[] args);

    Channel getRemote();

    void setRemote(Channel remote);

    boolean isHttp();

    void setHttp(boolean http);

    Object getOriginRequest();

    void setOriginRequest(Object originRequest);

    int getHttpCode();

    void setHttpCode(int httpCode);
}
