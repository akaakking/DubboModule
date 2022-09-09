package org.apache.dubbo.Interface;

import java.io.Serializable;
import java.lang.Object;
import java.lang.Throwable;
import java.util.Map;
import java.lang.String;
import org.apache.dubbo.rpc.Result;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;

public interface ResultInterface extends Serializable {

    Object getValue();

    void setValue(Object value);

    Throwable getException();

    void setException(Throwable t);

    boolean hasException();

    Object recreate();

    Map<String, String> getAttachments();

    Map<String, Object> getObjectAttachments();

    void addAttachments(Map<String, String> map);

    void addObjectAttachments(Map<String, Object> map);

    void setAttachments(Map<String, String> map);

    void setObjectAttachments(Map<String, Object> map);

    String getAttachment(String key);

    Object getObjectAttachment(String key);

    String getAttachment(String key, String defaultValue);

    Object getObjectAttachment(String key, Object defaultValue);

    void setAttachment(String key, String value);

    void setAttachment(String key, Object value);

    void setObjectAttachment(String key, Object value);

    Result whenCompleteWithContext(BiConsumer<Result, Throwable> fn);

    <U> CompletableFuture<U> thenApply(Function<Result, ? extends U> fn);

    Result get();

    Result get(long timeout, TimeUnit unit);
}
