package org.apache.dubbo.rpc;

import java.util.SortedSet;
import java.util.stream.Stream;
import java.io.Serializable;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.concurrent.TimeUnit;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class Result implements ResultInterface {

    public Object getValue() {
        return instance.getValue();
    }

    public void setValue(Object value) {
        instance.setValue(value);
    }

    public Throwable getException() {
        return instance.getException();
    }

    public void setException(Throwable t) {
        instance.setException(t);
    }

    public boolean hasException() {
        return instance.hasException();
    }

    public Object recreate() {
        return instance.recreate();
    }

    public Map<String, String> getAttachments() {
        return instance.getAttachments();
    }

    public Map<String, Object> getObjectAttachments() {
        return instance.getObjectAttachments();
    }

    public void addAttachments(Map<String, String> map) {
        instance.addAttachments(map);
    }

    public void addObjectAttachments(Map<String, Object> map) {
        instance.addObjectAttachments(map);
    }

    public void setAttachments(Map<String, String> map) {
        instance.setAttachments(map);
    }

    public void setObjectAttachments(Map<String, Object> map) {
        instance.setObjectAttachments(map);
    }

    public String getAttachment(String key) {
        return instance.getAttachment(key);
    }

    public Object getObjectAttachment(String key) {
        return instance.getObjectAttachment(key);
    }

    public String getAttachment(String key, String defaultValue) {
        return instance.getAttachment(key, defaultValue);
    }

    public Object getObjectAttachment(String key, Object defaultValue) {
        return instance.getObjectAttachment(key, defaultValue);
    }

    public void setAttachment(String key, String value) {
        instance.setAttachment(key, value);
    }

    public void setAttachment(String key, Object value) {
        instance.setAttachment(key, value);
    }

    public void setObjectAttachment(String key, Object value) {
        instance.setObjectAttachment(key, value);
    }

    public ResultInterface whenCompleteWithContext(BiConsumer<Result, Throwable> fn) {
        return instance.whenCompleteWithContext(fn);
    }

    public <U> CompletableFuture<U> thenApply(Function<Result, ? extends U> fn) {
        return instance.thenApply(fn);
    }

    public ResultInterface get() {
        return instance.get();
    }

    public ResultInterface get(long timeout, TimeUnit unit) {
        return instance.get(timeout, unit);
    }
}
