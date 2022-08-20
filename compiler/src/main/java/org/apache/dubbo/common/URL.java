package org.apache.dubbo.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.Collection;
import java.net.URL;
import java.net.InetSocketAddress;
import org.apache.dubbo.DubboClassLoader;
import org.apache.dubbo.Interface.*;

public class URL implements URLInterface {

    public URLAddressInterface getUrlAddress() {
        return instance.getUrlAddress();
    }

    public URLParamInterface getUrlParam() {
        return instance.getUrlParam();
    }

    public String getProtocol() {
        return instance.getProtocol();
    }

    public URLInterface setProtocol(String protocol) {
        return instance.setProtocol(protocol);
    }

    public String getUsername() {
        return instance.getUsername();
    }

    public URLInterface setUsername(String username) {
        return instance.setUsername(username);
    }

    public String getPassword() {
        return instance.getPassword();
    }

    public URLInterface setPassword(String password) {
        return instance.setPassword(password);
    }

    public String getAuthority() {
        return instance.getAuthority();
    }

    public String getUserInformation() {
        return instance.getUserInformation();
    }

    public String getHost() {
        return instance.getHost();
    }

    public URLInterface setHost(String host) {
        return instance.setHost(host);
    }

    public int getPort() {
        return instance.getPort();
    }

    public URLInterface setPort(int port) {
        return instance.setPort(port);
    }

    public int getPort(int defaultPort) {
        return instance.getPort(defaultPort);
    }

    public String getAddress() {
        return instance.getAddress();
    }

    public URLInterface setAddress(String address) {
        return instance.setAddress(address);
    }

    public String getIp() {
        return instance.getIp();
    }

    public String getBackupAddress() {
        return instance.getBackupAddress();
    }

    public String getBackupAddress(int defaultPort) {
        return instance.getBackupAddress(defaultPort);
    }

    public List<URLInterface> getBackupUrls() {
        return instance.getBackupUrls();
    }

    public String getPath() {
        return instance.getPath();
    }

    public URLInterface setPath(String path) {
        return instance.setPath(path);
    }

    public String getAbsolutePath() {
        return instance.getAbsolutePath();
    }

    public Map<String, String> getParameters() {
        return instance.getParameters();
    }

    public Map<String, String> getAllParameters() {
        return instance.getAllParameters();
    }

    public Map<String, String> getParameters(Predicate<String> nameToSelect) {
        return instance.getParameters(nameToSelect);
    }

    public String getParameterAndDecoded(String key) {
        return instance.getParameterAndDecoded(key);
    }

    public String getParameterAndDecoded(String key, String defaultValue) {
        return instance.getParameterAndDecoded(key, defaultValue);
    }

    public String getParameter(String key) {
        return instance.getParameter(key);
    }

    public String getParameter(String key, String defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public String[] getParameter(String key, String[] defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public List<String> getParameter(String key, List<String> defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public <T> T getParameter(String key, Class<T> valueType) {
        return instance.getParameter(key, valueType);
    }

    public <T> T getParameter(String key, Class<T> valueType, T defaultValue) {
        return instance.getParameter(key, valueType, defaultValue);
    }

    public URLInterface setScopeModel(ScopeModelInterface scopeModel) {
        return instance.setScopeModel(scopeModel.getInternalInstance(), scopeModel);
    }

    public ScopeModelInterface getScopeModel() {
        return instance.getScopeModel();
    }

    public FrameworkModelInterface getOrDefaultFrameworkModel() {
        return instance.getOrDefaultFrameworkModel();
    }

    public ApplicationModelInterface getOrDefaultApplicationModel() {
        return instance.getOrDefaultApplicationModel();
    }

    public ApplicationModelInterface getApplicationModel() {
        return instance.getApplicationModel();
    }

    public ModuleModelInterface getOrDefaultModuleModel() {
        return instance.getOrDefaultModuleModel();
    }

    public URLInterface setServiceModel(ServiceModelInterface serviceModel) {
        return instance.setServiceModel(serviceModel.getInternalInstance(), serviceModel);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public URLInterface getUrlParameter(String key) {
        return instance.getUrlParameter(key);
    }

    public double getParameter(String key, double defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public float getParameter(String key, float defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public long getParameter(String key, long defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public int getParameter(String key, int defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public short getParameter(String key, short defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public byte getParameter(String key, byte defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public float getPositiveParameter(String key, float defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public double getPositiveParameter(String key, double defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public long getPositiveParameter(String key, long defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public int getPositiveParameter(String key, int defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public short getPositiveParameter(String key, short defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public byte getPositiveParameter(String key, byte defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public char getParameter(String key, char defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public boolean getParameter(String key, boolean defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public boolean hasParameter(String key) {
        return instance.hasParameter(key);
    }

    public String getMethodParameterAndDecoded(String method, String key) {
        return instance.getMethodParameterAndDecoded(method, key);
    }

    public String getMethodParameterAndDecoded(String method, String key, String defaultValue) {
        return instance.getMethodParameterAndDecoded(method, key, defaultValue);
    }

    public String getMethodParameter(String method, String key) {
        return instance.getMethodParameter(method, key);
    }

    public String getMethodParameterStrict(String method, String key) {
        return instance.getMethodParameterStrict(method, key);
    }

    public String getMethodParameter(String method, String key, String defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public double getMethodParameter(String method, String key, double defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public float getMethodParameter(String method, String key, float defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public long getMethodParameter(String method, String key, long defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public int getMethodParameter(String method, String key, int defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public short getMethodParameter(String method, String key, short defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public byte getMethodParameter(String method, String key, byte defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public double getMethodPositiveParameter(String method, String key, double defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public float getMethodPositiveParameter(String method, String key, float defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public long getMethodPositiveParameter(String method, String key, long defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public int getMethodPositiveParameter(String method, String key, int defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public short getMethodPositiveParameter(String method, String key, short defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public byte getMethodPositiveParameter(String method, String key, byte defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public char getMethodParameter(String method, String key, char defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public boolean getMethodParameter(String method, String key, boolean defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public boolean hasMethodParameter(String method, String key) {
        return instance.hasMethodParameter(method, key);
    }

    public String getAnyMethodParameter(String key) {
        return instance.getAnyMethodParameter(key);
    }

    public boolean hasMethodParameter(String method) {
        return instance.hasMethodParameter(method);
    }

    public boolean isLocalHost() {
        return instance.isLocalHost();
    }

    public boolean isAnyHost() {
        return instance.isAnyHost();
    }

    public URLInterface addParameterAndEncoded(String key, String value) {
        return instance.addParameterAndEncoded(key, value);
    }

    public URLInterface addParameter(String key, boolean value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, char value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, byte value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, short value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, int value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, long value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, float value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, double value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, Enum<?> value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, Number value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, CharSequence value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(String key, String value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameterIfAbsent(String key, String value) {
        return instance.addParameterIfAbsent(key, value);
    }

    public URLInterface addParameters(Map<String, String> parameters) {
        return instance.addParameters(parameters);
    }

    public URLInterface addParametersIfAbsent(Map<String, String> parameters) {
        return instance.addParametersIfAbsent(parameters);
    }

    public URLInterface addParameters(String pairs) {
        return instance.addParameters(pairs);
    }

    public URLInterface addParameterString(String query) {
        return instance.addParameterString(query);
    }

    public URLInterface removeParameter(String key) {
        return instance.removeParameter(key);
    }

    public URLInterface removeParameters(Collection<String> keys) {
        return instance.removeParameters(keys);
    }

    public URLInterface removeParameters(String keys) {
        return instance.removeParameters(keys);
    }

    public URLInterface clearParameters() {
        return instance.clearParameters();
    }

    public String getRawParameter(String key) {
        return instance.getRawParameter(key);
    }

    public Map<String, String> toMap() {
        return instance.toMap();
    }

    public String toString() {
        return instance.toString();
    }

    public String toString(String parameters) {
        return instance.toString(parameters);
    }

    public String toIdentityString() {
        return instance.toIdentityString();
    }

    public String toIdentityString(String parameters) {
        return instance.toIdentityString(parameters);
    }

    public String toFullString() {
        return instance.toFullString();
    }

    public String toFullString(String parameters) {
        return instance.toFullString(parameters);
    }

    public String toParameterString() {
        return instance.toParameterString();
    }

    public String toParameterString(String parameters) {
        return instance.toParameterString(parameters);
    }

    public URL toJavaURL() {
        return instance.toJavaURL();
    }

    public InetSocketAddress toInetSocketAddress() {
        return instance.toInetSocketAddress();
    }

    public String getColonSeparatedKey() {
        return instance.getColonSeparatedKey();
    }

    public String getServiceKey() {
        return instance.getServiceKey();
    }

    public String getDisplayServiceKey() {
        return instance.getDisplayServiceKey();
    }

    public String getPathKey() {
        return instance.getPathKey();
    }

    public String getProtocolServiceKey() {
        return instance.getProtocolServiceKey();
    }

    public String toServiceStringWithoutResolving() {
        return instance.toServiceStringWithoutResolving();
    }

    public String toServiceString() {
        return instance.toServiceString();
    }

    public String getServiceName() {
        return instance.getServiceName();
    }

    public String getServiceInterface() {
        return instance.getServiceInterface();
    }

    public URLInterface setServiceInterface(String service) {
        return instance.setServiceInterface(service);
    }

    public int getIntParameter(String key) {
        return instance.getIntParameter(key);
    }

    public int getIntParameter(String key, int defaultValue) {
        return instance.getIntParameter(key, defaultValue);
    }

    public int getPositiveIntParameter(String key, int defaultValue) {
        return instance.getPositiveIntParameter(key, defaultValue);
    }

    public boolean getBooleanParameter(String key) {
        return instance.getBooleanParameter(key);
    }

    public boolean getBooleanParameter(String key, boolean defaultValue) {
        return instance.getBooleanParameter(key, defaultValue);
    }

    public int getMethodIntParameter(String method, String key) {
        return instance.getMethodIntParameter(method, key);
    }

    public int getMethodIntParameter(String method, String key, int defaultValue) {
        return instance.getMethodIntParameter(method, key, defaultValue);
    }

    public int getMethodPositiveIntParameter(String method, String key, int defaultValue) {
        return instance.getMethodPositiveIntParameter(method, key, defaultValue);
    }

    public boolean getMethodBooleanParameter(String method, String key) {
        return instance.getMethodBooleanParameter(method, key);
    }

    public boolean getMethodBooleanParameter(String method, String key, boolean defaultValue) {
        return instance.getMethodBooleanParameter(method, key, defaultValue);
    }

    public ConfigurationInterface toConfiguration() {
        return instance.toConfiguration();
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public boolean equals(Object obj) {
        return instance.equals(obj);
    }

    public String getApplication(String defaultValue) {
        return instance.getApplication(defaultValue);
    }

    public String getApplication() {
        return instance.getApplication();
    }

    public String getRemoteApplication() {
        return instance.getRemoteApplication();
    }

    public String getGroup() {
        return instance.getGroup();
    }

    public String getGroup(String defaultValue) {
        return instance.getGroup(defaultValue);
    }

    public String getVersion() {
        return instance.getVersion();
    }

    public String getVersion(String defaultValue) {
        return instance.getVersion(defaultValue);
    }

    public String getConcatenatedParameter(String key) {
        return instance.getConcatenatedParameter(key);
    }

    public String getCategory(String defaultValue) {
        return instance.getCategory(defaultValue);
    }

    public String[] getCategory(String[] defaultValue) {
        return instance.getCategory(defaultValue);
    }

    public String getCategory() {
        return instance.getCategory();
    }

    public String getSide(String defaultValue) {
        return instance.getSide(defaultValue);
    }

    public String getSide() {
        return instance.getSide();
    }

    public Map<String, Object> getAttributes() {
        return instance.getAttributes();
    }

    public URLInterface addAttributes(Map<String, Object> attributes) {
        return instance.addAttributes(attributes);
    }

    public Object getAttribute(String key) {
        return instance.getAttribute(key);
    }

    public Object getAttribute(String key, Object defaultValue) {
        return instance.getAttribute(key, defaultValue);
    }

    public URLInterface putAttribute(String key, Object obj) {
        return instance.putAttribute(key, obj);
    }

    public URLInterface removeAttribute(String key) {
        return instance.removeAttribute(key);
    }

    public boolean hasAttribute(String key) {
        return instance.hasAttribute(key);
    }

    public Map<String, String> getServiceParameters(String service) {
        return instance.getServiceParameters(service);
    }

    public String getServiceParameter(String service, String key) {
        return instance.getServiceParameter(service, key);
    }

    public String getServiceParameter(String service, String key, String defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public int getServiceParameter(String service, String key, int defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public double getServiceParameter(String service, String key, double defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public float getServiceParameter(String service, String key, float defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public long getServiceParameter(String service, String key, long defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public short getServiceParameter(String service, String key, short defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public byte getServiceParameter(String service, String key, byte defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public char getServiceParameter(String service, String key, char defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public boolean getServiceParameter(String service, String key, boolean defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public boolean hasServiceParameter(String service, String key) {
        return instance.hasServiceParameter(service, key);
    }

    public float getPositiveServiceParameter(String service, String key, float defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public double getPositiveServiceParameter(String service, String key, double defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public long getPositiveServiceParameter(String service, String key, long defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public int getPositiveServiceParameter(String service, String key, int defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public short getPositiveServiceParameter(String service, String key, short defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public byte getPositiveServiceParameter(String service, String key, byte defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public String getServiceMethodParameterAndDecoded(String service, String method, String key) {
        return instance.getServiceMethodParameterAndDecoded(service, method, key);
    }

    public String getServiceMethodParameterAndDecoded(String service, String method, String key, String defaultValue) {
        return instance.getServiceMethodParameterAndDecoded(service, method, key, defaultValue);
    }

    public String getServiceMethodParameterStrict(String service, String method, String key) {
        return instance.getServiceMethodParameterStrict(service, method, key);
    }

    public String getServiceMethodParameter(String service, String method, String key) {
        return instance.getServiceMethodParameter(service, method, key);
    }

    public String getServiceMethodParameter(String service, String method, String key, String defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public double getServiceMethodParameter(String service, String method, String key, double defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public float getServiceMethodParameter(String service, String method, String key, float defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public long getServiceMethodParameter(String service, String method, String key, long defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public int getServiceMethodParameter(String service, String method, String key, int defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public short getMethodParameter(String service, String method, String key, short defaultValue) {
        return instance.getMethodParameter(service, method, key, defaultValue);
    }

    public byte getServiceMethodParameter(String service, String method, String key, byte defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public boolean hasServiceMethodParameter(String service, String method, String key) {
        return instance.hasServiceMethodParameter(service, method, key);
    }

    public boolean hasServiceMethodParameter(String service, String method) {
        return instance.hasServiceMethodParameter(service, method);
    }

    public URLInterface toSerializableURL() {
        return instance.toSerializableURL();
    }

    protected URLInterface instance;

    public static URLInterface cacheableValueOf(String url) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(cacheableValueOf, String.class);
        return method.invoke(url);
    }

    public static URLInterface valueOf(String url) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class);
        return method.invoke(url);
    }

    public static URLInterface valueOf(String url, ScopeModelInterface scopeModel) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, ScopeModelInterface.class);
        return method.invoke(url, scopeModel);
    }

    public static URLInterface valueOf(String url, boolean encoded) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, boolean.class);
        return method.invoke(url, encoded);
    }

    public static URLInterface valueOf(String url, String reserveParams) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, String.class);
        return method.invoke(url, reserveParams);
    }

    public static URLInterface valueOf(URLInterface url, String[] reserveParams, String[] reserveParamPrefixes) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, URLInterface.class, String[].class, String[].class);
        return method.invoke(url, reserveParams, reserveParamPrefixes);
    }

    public static String encode(String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(encode, String.class);
        return method.invoke(value);
    }

    public static String decode(String value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(decode, String.class);
        return method.invoke(value);
    }

    public static String buildKey(String path, String group, String version) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(buildKey, String.class, String.class, String.class);
        return method.invoke(path, group, version);
    }

    public static void putMethodParameter(String method, String key, String value, Map<String, Map<String, String>> methodParameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(putMethodParameter, String.class, String.class, String.class, Map.class);
        method.invoke(method, key, value, methodParameters);
    }

    public URLInterface getInternalInstance() {
        return instance;
    }

    public URLInterface getInternalInstance() {
        return instance;
    }

    public URL(URLAddressInterface urlAddress, URLParamInterface urlParam) {
        Class[] params = new Class[]{URLAddressInterface.class, URLParamInterface.class};
        Object[] args = new Object[]{urlAddress, urlParam};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(URLAddressInterface urlAddress, URLParamInterface urlParam, Map<String, Object> attributes) {
        Class[] params = new Class[]{URLAddressInterface.class, URLParamInterface.class, MapMap<String,Object>.class};
        Object[] args = new Object[]{urlAddress, urlParam, attributes};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port) {
        Class[] params = new Class[]{String.class, String.class, int.class};
        Object[] args = new Object[]{protocol, host, port};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port, String[] pairs) {
        Class[] params = new Class[]{String.class, String.class, int.class, String{}.class};
        Object[] args = new Object[]{protocol, host, port, pairs};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port, Map<String, String> parameters) {
        Class[] params = new Class[]{String.class, String.class, int.class, MapMap<String,String>.class};
        Object[] args = new Object[]{protocol, host, port, parameters};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port, String path) {
        Class[] params = new Class[]{String.class, String.class, int.class, String.class};
        Object[] args = new Object[]{protocol, host, port, path};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port, String path, String pairs) {
        Class[] params = new Class[]{String.class, String.class, int.class, String.class, String.class};
        Object[] args = new Object[]{protocol, host, port, path, pairs};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String host, int port, String path, Map<String, String> parameters) {
        Class[] params = new Class[]{String.class, String.class, int.class, String.class, MapMap<String,String>.class};
        Object[] args = new Object[]{protocol, host, port, path, parameters};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String username, String password, String host, int port, String path) {
        Class[] params = new Class[]{String.class, String.class, String.class, String.class, int.class, String.class};
        Object[] args = new Object[]{protocol, username, password, host, port, path};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String username, String password, String host, int port, String path, String pairs) {
        Class[] params = new Class[]{String.class, String.class, String.class, String.class, int.class, String.class, String.class};
        Object[] args = new Object[]{protocol, username, password, host, port, path, pairs};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }

    public URL(String protocol, String username, String password, String host, int port, String path, Map<String, String> parameters) {
        Class[] params = new Class[]{String.class, String.class, String.class, String.class, int.class, String.class, MapMap<String,String>.class};
        Object[] args = new Object[]{protocol, username, password, host, port, path, parameters};
        instance = (URLInterface) DubboClassLoader.getInstance(URL.class.getName(), params, args);
    }
}
