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

    public StringInterface getProtocol() {
        return instance.getProtocol();
    }

    public URLInterface setProtocol(StringInterface protocol) {
        return instance.setProtocol(protocol);
    }

    public StringInterface getUsername() {
        return instance.getUsername();
    }

    public URLInterface setUsername(StringInterface username) {
        return instance.setUsername(username);
    }

    public StringInterface getPassword() {
        return instance.getPassword();
    }

    public URLInterface setPassword(StringInterface password) {
        return instance.setPassword(password);
    }

    public StringInterface getAuthority() {
        return instance.getAuthority();
    }

    public StringInterface getUserInformation() {
        return instance.getUserInformation();
    }

    public StringInterface getHost() {
        return instance.getHost();
    }

    public URLInterface setHost(StringInterface host) {
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

    public StringInterface getAddress() {
        return instance.getAddress();
    }

    public URLInterface setAddress(StringInterface address) {
        return instance.setAddress(address);
    }

    public StringInterface getIp() {
        return instance.getIp();
    }

    public StringInterface getBackupAddress() {
        return instance.getBackupAddress();
    }

    public StringInterface getBackupAddress(int defaultPort) {
        return instance.getBackupAddress(defaultPort);
    }

    public List<URLInterface> getBackupUrls() {
        return instance.getBackupUrls();
    }

    public StringInterface getPath() {
        return instance.getPath();
    }

    public URLInterface setPath(StringInterface path) {
        return instance.setPath(path);
    }

    public StringInterface getAbsolutePath() {
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

    public StringInterface getParameterAndDecoded(StringInterface key) {
        return instance.getParameterAndDecoded(key);
    }

    public StringInterface getParameterAndDecoded(StringInterface key, StringInterface defaultValue) {
        return instance.getParameterAndDecoded(key, defaultValue);
    }

    public StringInterface getParameter(StringInterface key) {
        return instance.getParameter(key);
    }

    public StringInterface getParameter(StringInterface key, StringInterface defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public StringInterface[] getParameter(StringInterface key, StringInterface[] defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public List<String> getParameter(StringInterface key, List<String> defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public <T> T getParameter(StringInterface key, Class<T> valueType) {
        return instance.getParameter(key, valueType);
    }

    public <T> T getParameter(StringInterface key, Class<T> valueType, T defaultValue) {
        return instance.getParameter(key, valueType, defaultValue);
    }

    public URLInterface setScopeModel(ScopeModelInterface scopeModel) {
        return instance.setScopeModel(scopeModel);
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
        return instance.setServiceModel(serviceModel);
    }

    public ServiceModelInterface getServiceModel() {
        return instance.getServiceModel();
    }

    public URLInterface getUrlParameter(StringInterface key) {
        return instance.getUrlParameter(key);
    }

    public double getParameter(StringInterface key, double defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public float getParameter(StringInterface key, float defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public long getParameter(StringInterface key, long defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public int getParameter(StringInterface key, int defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public short getParameter(StringInterface key, short defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public byte getParameter(StringInterface key, byte defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public float getPositiveParameter(StringInterface key, float defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public double getPositiveParameter(StringInterface key, double defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public long getPositiveParameter(StringInterface key, long defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public int getPositiveParameter(StringInterface key, int defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public short getPositiveParameter(StringInterface key, short defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public byte getPositiveParameter(StringInterface key, byte defaultValue) {
        return instance.getPositiveParameter(key, defaultValue);
    }

    public char getParameter(StringInterface key, char defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public boolean getParameter(StringInterface key, boolean defaultValue) {
        return instance.getParameter(key, defaultValue);
    }

    public boolean hasParameter(StringInterface key) {
        return instance.hasParameter(key);
    }

    public StringInterface getMethodParameterAndDecoded(StringInterface method, StringInterface key) {
        return instance.getMethodParameterAndDecoded(method, key);
    }

    public StringInterface getMethodParameterAndDecoded(StringInterface method, StringInterface key, StringInterface defaultValue) {
        return instance.getMethodParameterAndDecoded(method, key, defaultValue);
    }

    public StringInterface getMethodParameter(StringInterface method, StringInterface key) {
        return instance.getMethodParameter(method, key);
    }

    public StringInterface getMethodParameterStrict(StringInterface method, StringInterface key) {
        return instance.getMethodParameterStrict(method, key);
    }

    public StringInterface getMethodParameter(StringInterface method, StringInterface key, StringInterface defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public double getMethodParameter(StringInterface method, StringInterface key, double defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public float getMethodParameter(StringInterface method, StringInterface key, float defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public long getMethodParameter(StringInterface method, StringInterface key, long defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public int getMethodParameter(StringInterface method, StringInterface key, int defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public short getMethodParameter(StringInterface method, StringInterface key, short defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public byte getMethodParameter(StringInterface method, StringInterface key, byte defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public double getMethodPositiveParameter(StringInterface method, StringInterface key, double defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public float getMethodPositiveParameter(StringInterface method, StringInterface key, float defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public long getMethodPositiveParameter(StringInterface method, StringInterface key, long defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public int getMethodPositiveParameter(StringInterface method, StringInterface key, int defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public short getMethodPositiveParameter(StringInterface method, StringInterface key, short defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public byte getMethodPositiveParameter(StringInterface method, StringInterface key, byte defaultValue) {
        return instance.getMethodPositiveParameter(method, key, defaultValue);
    }

    public char getMethodParameter(StringInterface method, StringInterface key, char defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public boolean getMethodParameter(StringInterface method, StringInterface key, boolean defaultValue) {
        return instance.getMethodParameter(method, key, defaultValue);
    }

    public boolean hasMethodParameter(StringInterface method, StringInterface key) {
        return instance.hasMethodParameter(method, key);
    }

    public StringInterface getAnyMethodParameter(StringInterface key) {
        return instance.getAnyMethodParameter(key);
    }

    public boolean hasMethodParameter(StringInterface method) {
        return instance.hasMethodParameter(method);
    }

    public boolean isLocalHost() {
        return instance.isLocalHost();
    }

    public boolean isAnyHost() {
        return instance.isAnyHost();
    }

    public URLInterface addParameterAndEncoded(StringInterface key, StringInterface value) {
        return instance.addParameterAndEncoded(key, value);
    }

    public URLInterface addParameter(StringInterface key, boolean value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, char value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, byte value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, short value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, int value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, long value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, float value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, double value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, Enum<?> value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, NumberInterface value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, CharSequenceInterface value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameter(StringInterface key, StringInterface value) {
        return instance.addParameter(key, value);
    }

    public URLInterface addParameterIfAbsent(StringInterface key, StringInterface value) {
        return instance.addParameterIfAbsent(key, value);
    }

    public URLInterface addParameters(Map<String, String> parameters) {
        return instance.addParameters(parameters);
    }

    public URLInterface addParametersIfAbsent(Map<String, String> parameters) {
        return instance.addParametersIfAbsent(parameters);
    }

    public URLInterface addParameters(StringInterface pairs) {
        return instance.addParameters(pairs);
    }

    public URLInterface addParameterString(StringInterface query) {
        return instance.addParameterString(query);
    }

    public URLInterface removeParameter(StringInterface key) {
        return instance.removeParameter(key);
    }

    public URLInterface removeParameters(Collection<String> keys) {
        return instance.removeParameters(keys);
    }

    public URLInterface removeParameters(StringInterface keys) {
        return instance.removeParameters(keys);
    }

    public URLInterface clearParameters() {
        return instance.clearParameters();
    }

    public StringInterface getRawParameter(StringInterface key) {
        return instance.getRawParameter(key);
    }

    public Map<String, String> toMap() {
        return instance.toMap();
    }

    public StringInterface toString() {
        return instance.toString();
    }

    public StringInterface toString(StringInterface parameters) {
        return instance.toString(parameters);
    }

    public StringInterface toIdentityString() {
        return instance.toIdentityString();
    }

    public StringInterface toIdentityString(StringInterface parameters) {
        return instance.toIdentityString(parameters);
    }

    public StringInterface toFullString() {
        return instance.toFullString();
    }

    public StringInterface toFullString(StringInterface parameters) {
        return instance.toFullString(parameters);
    }

    public StringInterface toParameterString() {
        return instance.toParameterString();
    }

    public StringInterface toParameterString(StringInterface parameters) {
        return instance.toParameterString(parameters);
    }

    public URL toJavaURL() {
        return instance.toJavaURL();
    }

    public InetSocketAddressInterface toInetSocketAddress() {
        return instance.toInetSocketAddress();
    }

    public StringInterface getColonSeparatedKey() {
        return instance.getColonSeparatedKey();
    }

    public StringInterface getServiceKey() {
        return instance.getServiceKey();
    }

    public StringInterface getDisplayServiceKey() {
        return instance.getDisplayServiceKey();
    }

    public StringInterface getPathKey() {
        return instance.getPathKey();
    }

    public StringInterface getProtocolServiceKey() {
        return instance.getProtocolServiceKey();
    }

    public StringInterface toServiceStringWithoutResolving() {
        return instance.toServiceStringWithoutResolving();
    }

    public StringInterface toServiceString() {
        return instance.toServiceString();
    }

    public StringInterface getServiceName() {
        return instance.getServiceName();
    }

    public StringInterface getServiceInterface() {
        return instance.getServiceInterface();
    }

    public URLInterface setServiceInterface(StringInterface service) {
        return instance.setServiceInterface(service);
    }

    public int getIntParameter(StringInterface key) {
        return instance.getIntParameter(key);
    }

    public int getIntParameter(StringInterface key, int defaultValue) {
        return instance.getIntParameter(key, defaultValue);
    }

    public int getPositiveIntParameter(StringInterface key, int defaultValue) {
        return instance.getPositiveIntParameter(key, defaultValue);
    }

    public boolean getBooleanParameter(StringInterface key) {
        return instance.getBooleanParameter(key);
    }

    public boolean getBooleanParameter(StringInterface key, boolean defaultValue) {
        return instance.getBooleanParameter(key, defaultValue);
    }

    public int getMethodIntParameter(StringInterface method, StringInterface key) {
        return instance.getMethodIntParameter(method, key);
    }

    public int getMethodIntParameter(StringInterface method, StringInterface key, int defaultValue) {
        return instance.getMethodIntParameter(method, key, defaultValue);
    }

    public int getMethodPositiveIntParameter(StringInterface method, StringInterface key, int defaultValue) {
        return instance.getMethodPositiveIntParameter(method, key, defaultValue);
    }

    public boolean getMethodBooleanParameter(StringInterface method, StringInterface key) {
        return instance.getMethodBooleanParameter(method, key);
    }

    public boolean getMethodBooleanParameter(StringInterface method, StringInterface key, boolean defaultValue) {
        return instance.getMethodBooleanParameter(method, key, defaultValue);
    }

    public ConfigurationInterface toConfiguration() {
        return instance.toConfiguration();
    }

    public int hashCode() {
        return instance.hashCode();
    }

    public boolean equals(ObjectInterface obj) {
        return instance.equals(obj);
    }

    public StringInterface getApplication(StringInterface defaultValue) {
        return instance.getApplication(defaultValue);
    }

    public StringInterface getApplication() {
        return instance.getApplication();
    }

    public StringInterface getRemoteApplication() {
        return instance.getRemoteApplication();
    }

    public StringInterface getGroup() {
        return instance.getGroup();
    }

    public StringInterface getGroup(StringInterface defaultValue) {
        return instance.getGroup(defaultValue);
    }

    public StringInterface getVersion() {
        return instance.getVersion();
    }

    public StringInterface getVersion(StringInterface defaultValue) {
        return instance.getVersion(defaultValue);
    }

    public StringInterface getConcatenatedParameter(StringInterface key) {
        return instance.getConcatenatedParameter(key);
    }

    public StringInterface getCategory(StringInterface defaultValue) {
        return instance.getCategory(defaultValue);
    }

    public StringInterface[] getCategory(StringInterface[] defaultValue) {
        return instance.getCategory(defaultValue);
    }

    public StringInterface getCategory() {
        return instance.getCategory();
    }

    public StringInterface getSide(StringInterface defaultValue) {
        return instance.getSide(defaultValue);
    }

    public StringInterface getSide() {
        return instance.getSide();
    }

    public Map<String, Object> getAttributes() {
        return instance.getAttributes();
    }

    public URLInterface addAttributes(Map<String, Object> attributes) {
        return instance.addAttributes(attributes);
    }

    public ObjectInterface getAttribute(StringInterface key) {
        return instance.getAttribute(key);
    }

    public ObjectInterface getAttribute(StringInterface key, ObjectInterface defaultValue) {
        return instance.getAttribute(key, defaultValue);
    }

    public URLInterface putAttribute(StringInterface key, ObjectInterface obj) {
        return instance.putAttribute(key, obj);
    }

    public URLInterface removeAttribute(StringInterface key) {
        return instance.removeAttribute(key);
    }

    public boolean hasAttribute(StringInterface key) {
        return instance.hasAttribute(key);
    }

    public Map<String, String> getServiceParameters(StringInterface service) {
        return instance.getServiceParameters(service);
    }

    public StringInterface getServiceParameter(StringInterface service, StringInterface key) {
        return instance.getServiceParameter(service, key);
    }

    public StringInterface getServiceParameter(StringInterface service, StringInterface key, StringInterface defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public int getServiceParameter(StringInterface service, StringInterface key, int defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public double getServiceParameter(StringInterface service, StringInterface key, double defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public float getServiceParameter(StringInterface service, StringInterface key, float defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public long getServiceParameter(StringInterface service, StringInterface key, long defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public short getServiceParameter(StringInterface service, StringInterface key, short defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public byte getServiceParameter(StringInterface service, StringInterface key, byte defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public char getServiceParameter(StringInterface service, StringInterface key, char defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public boolean getServiceParameter(StringInterface service, StringInterface key, boolean defaultValue) {
        return instance.getServiceParameter(service, key, defaultValue);
    }

    public boolean hasServiceParameter(StringInterface service, StringInterface key) {
        return instance.hasServiceParameter(service, key);
    }

    public float getPositiveServiceParameter(StringInterface service, StringInterface key, float defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public double getPositiveServiceParameter(StringInterface service, StringInterface key, double defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public long getPositiveServiceParameter(StringInterface service, StringInterface key, long defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public int getPositiveServiceParameter(StringInterface service, StringInterface key, int defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public short getPositiveServiceParameter(StringInterface service, StringInterface key, short defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public byte getPositiveServiceParameter(StringInterface service, StringInterface key, byte defaultValue) {
        return instance.getPositiveServiceParameter(service, key, defaultValue);
    }

    public StringInterface getServiceMethodParameterAndDecoded(StringInterface service, StringInterface method, StringInterface key) {
        return instance.getServiceMethodParameterAndDecoded(service, method, key);
    }

    public StringInterface getServiceMethodParameterAndDecoded(StringInterface service, StringInterface method, StringInterface key, StringInterface defaultValue) {
        return instance.getServiceMethodParameterAndDecoded(service, method, key, defaultValue);
    }

    public StringInterface getServiceMethodParameterStrict(StringInterface service, StringInterface method, StringInterface key) {
        return instance.getServiceMethodParameterStrict(service, method, key);
    }

    public StringInterface getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key) {
        return instance.getServiceMethodParameter(service, method, key);
    }

    public StringInterface getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, StringInterface defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public double getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, double defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public float getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, float defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public long getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, long defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public int getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, int defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public short getMethodParameter(StringInterface service, StringInterface method, StringInterface key, short defaultValue) {
        return instance.getMethodParameter(service, method, key, defaultValue);
    }

    public byte getServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key, byte defaultValue) {
        return instance.getServiceMethodParameter(service, method, key, defaultValue);
    }

    public boolean hasServiceMethodParameter(StringInterface service, StringInterface method, StringInterface key) {
        return instance.hasServiceMethodParameter(service, method, key);
    }

    public boolean hasServiceMethodParameter(StringInterface service, StringInterface method) {
        return instance.hasServiceMethodParameter(service, method);
    }

    public URLInterface toSerializableURL() {
        return instance.toSerializableURL();
    }

    protected URLInterface instance;

    public static URLInterface cacheableValueOf(StringInterface url) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(cacheableValueOf, String.class);
        return method.invoke(url);
    }

    public static URLInterface valueOf(StringInterface url) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class);
        return method.invoke(url);
    }

    public static URLInterface valueOf(StringInterface url, ScopeModelInterface scopeModel) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, ScopeModelInterface.class);
        return method.invoke(url, scopeModel);
    }

    public static URLInterface valueOf(StringInterface url, boolean encoded) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, boolean.class);
        return method.invoke(url, encoded);
    }

    public static URLInterface valueOf(StringInterface url, StringInterface reserveParams) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, String.class, String.class);
        return method.invoke(url, reserveParams);
    }

    public static URLInterface valueOf(URLInterface url, StringInterface[] reserveParams, StringInterface[] reserveParamPrefixes) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(valueOf, URLInterface.class, String[].class, String[].class);
        return method.invoke(url, reserveParams, reserveParamPrefixes);
    }

    public static StringInterface encode(StringInterface value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(encode, String.class);
        return method.invoke(value);
    }

    public static StringInterface decode(StringInterface value) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(decode, String.class);
        return method.invoke(value);
    }

    public static StringInterface buildKey(StringInterface path, StringInterface group, StringInterface version) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(buildKey, String.class, String.class, String.class);
        return method.invoke(path, group, version);
    }

    public static void putMethodParameter(StringInterface method, StringInterface key, StringInterface value, Map<String, Map<String, String>> methodParameters) {
        Class klass = DubboClassLoader;
        Method method = klass.getMethod(putMethodParameter, String.class, String.class, String.class, Map.class);
        method.invoke(method, key, value, methodParameters);
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
