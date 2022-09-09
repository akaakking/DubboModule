package org.apache.dubbo.Interface;

import java.io.Serializable;
import org.apache.dubbo.Interface.URLAddressInterface;
import org.apache.dubbo.Interface.URLParamInterface;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.lang.Class;
import T;
import org.apache.dubbo.rpc.model.ScopeModel;
import org.apache.dubbo.Interface.ScopeModelInterface;
import org.apache.dubbo.Interface.FrameworkModelInterface;
import org.apache.dubbo.Interface.ApplicationModelInterface;
import org.apache.dubbo.Interface.ModuleModelInterface;
import org.apache.dubbo.rpc.model.ServiceModel;
import org.apache.dubbo.Interface.ServiceModelInterface;
import java.lang.Enum;
import java.lang.Number;
import java.lang.CharSequence;
import java.util.Collection;
import java.net.URL;
import java.net.InetSocketAddress;
import org.apache.dubbo.common.config.Configuration;
import java.lang.Object;

public interface URLInterface extends Serializable {

    URLAddressInterface getUrlAddress();

    URLParamInterface getUrlParam();

    String getProtocol();

    URLInterface setProtocol(String protocol);

    String getUsername();

    URLInterface setUsername(String username);

    String getPassword();

    URLInterface setPassword(String password);

    String getAuthority();

    String getUserInformation();

    String getHost();

    URLInterface setHost(String host);

    int getPort();

    URLInterface setPort(int port);

    int getPort(int defaultPort);

    String getAddress();

    URLInterface setAddress(String address);

    String getIp();

    String getBackupAddress();

    String getBackupAddress(int defaultPort);

    List<URLInterface> getBackupUrls();

    String getPath();

    URLInterface setPath(String path);

    String getAbsolutePath();

    Map<String, String> getParameters();

    Map<String, String> getAllParameters();

    Map<String, String> getParameters(Predicate<String> nameToSelect);

    String getParameterAndDecoded(String key);

    String getParameterAndDecoded(String key, String defaultValue);

    String getParameter(String key);

    String getParameter(String key, String defaultValue);

    String[] getParameter(String key, String[] defaultValue);

    List<String> getParameter(String key, List<String> defaultValue);

    <T> T getParameter(String key, Class<T> valueType);

    <T> T getParameter(String key, Class<T> valueType, T defaultValue);

    URLInterface setScopeModel(ScopeModelInterface scopeModel);

    ScopeModelInterface getScopeModel();

    FrameworkModelInterface getOrDefaultFrameworkModel();

    ApplicationModelInterface getOrDefaultApplicationModel();

    ApplicationModelInterface getApplicationModel();

    ModuleModelInterface getOrDefaultModuleModel();

    URLInterface setServiceModel(ServiceModelInterface serviceModel);

    ServiceModelInterface getServiceModel();

    URLInterface getUrlParameter(String key);

    double getParameter(String key, double defaultValue);

    float getParameter(String key, float defaultValue);

    long getParameter(String key, long defaultValue);

    int getParameter(String key, int defaultValue);

    short getParameter(String key, short defaultValue);

    byte getParameter(String key, byte defaultValue);

    float getPositiveParameter(String key, float defaultValue);

    double getPositiveParameter(String key, double defaultValue);

    long getPositiveParameter(String key, long defaultValue);

    int getPositiveParameter(String key, int defaultValue);

    short getPositiveParameter(String key, short defaultValue);

    byte getPositiveParameter(String key, byte defaultValue);

    char getParameter(String key, char defaultValue);

    boolean getParameter(String key, boolean defaultValue);

    boolean hasParameter(String key);

    String getMethodParameterAndDecoded(String method, String key);

    String getMethodParameterAndDecoded(String method, String key, String defaultValue);

    String getMethodParameter(String method, String key);

    String getMethodParameterStrict(String method, String key);

    String getMethodParameter(String method, String key, String defaultValue);

    double getMethodParameter(String method, String key, double defaultValue);

    float getMethodParameter(String method, String key, float defaultValue);

    long getMethodParameter(String method, String key, long defaultValue);

    int getMethodParameter(String method, String key, int defaultValue);

    short getMethodParameter(String method, String key, short defaultValue);

    byte getMethodParameter(String method, String key, byte defaultValue);

    double getMethodPositiveParameter(String method, String key, double defaultValue);

    float getMethodPositiveParameter(String method, String key, float defaultValue);

    long getMethodPositiveParameter(String method, String key, long defaultValue);

    int getMethodPositiveParameter(String method, String key, int defaultValue);

    short getMethodPositiveParameter(String method, String key, short defaultValue);

    byte getMethodPositiveParameter(String method, String key, byte defaultValue);

    char getMethodParameter(String method, String key, char defaultValue);

    boolean getMethodParameter(String method, String key, boolean defaultValue);

    boolean hasMethodParameter(String method, String key);

    String getAnyMethodParameter(String key);

    boolean hasMethodParameter(String method);

    boolean isLocalHost();

    boolean isAnyHost();

    URLInterface addParameterAndEncoded(String key, String value);

    URLInterface addParameter(String key, boolean value);

    URLInterface addParameter(String key, char value);

    URLInterface addParameter(String key, byte value);

    URLInterface addParameter(String key, short value);

    URLInterface addParameter(String key, int value);

    URLInterface addParameter(String key, long value);

    URLInterface addParameter(String key, float value);

    URLInterface addParameter(String key, double value);

    URLInterface addParameter(String key, Enum<?> value);

    URLInterface addParameter(String key, Number value);

    URLInterface addParameter(String key, CharSequence value);

    URLInterface addParameter(String key, String value);

    URLInterface addParameterIfAbsent(String key, String value);

    URLInterface addParameters(Map<String, String> parameters);

    URLInterface addParametersIfAbsent(Map<String, String> parameters);

    URLInterface addParameters(String pairs);

    URLInterface addParameterString(String query);

    URLInterface removeParameter(String key);

    URLInterface removeParameters(Collection<String> keys);

    URLInterface removeParameters(String keys);

    URLInterface clearParameters();

    String getRawParameter(String key);

    Map<String, String> toMap();

    String toString();

    String toString(String parameters);

    String toIdentityString();

    String toIdentityString(String parameters);

    String toFullString();

    String toFullString(String parameters);

    String toParameterString();

    String toParameterString(String parameters);

    URL toJavaURL();

    InetSocketAddress toInetSocketAddress();

    String getColonSeparatedKey();

    String getServiceKey();

    String getDisplayServiceKey();

    String getPathKey();

    String getProtocolServiceKey();

    String toServiceStringWithoutResolving();

    String toServiceString();

    String getServiceName();

    String getServiceInterface();

    URLInterface setServiceInterface(String service);

    int getIntParameter(String key);

    int getIntParameter(String key, int defaultValue);

    int getPositiveIntParameter(String key, int defaultValue);

    boolean getBooleanParameter(String key);

    boolean getBooleanParameter(String key, boolean defaultValue);

    int getMethodIntParameter(String method, String key);

    int getMethodIntParameter(String method, String key, int defaultValue);

    int getMethodPositiveIntParameter(String method, String key, int defaultValue);

    boolean getMethodBooleanParameter(String method, String key);

    boolean getMethodBooleanParameter(String method, String key, boolean defaultValue);

    Configuration toConfiguration();

    int hashCode();

    boolean equals(Object obj);

    String getApplication(String defaultValue);

    String getApplication();

    String getRemoteApplication();

    String getGroup();

    String getGroup(String defaultValue);

    String getVersion();

    String getVersion(String defaultValue);

    String getConcatenatedParameter(String key);

    String getCategory(String defaultValue);

    String[] getCategory(String[] defaultValue);

    String getCategory();

    String getSide(String defaultValue);

    String getSide();

    Map<String, Object> getAttributes();

    URLInterface addAttributes(Map<String, Object> attributes);

    Object getAttribute(String key);

    Object getAttribute(String key, Object defaultValue);

    URLInterface putAttribute(String key, Object obj);

    URLInterface removeAttribute(String key);

    boolean hasAttribute(String key);

    Map<String, String> getServiceParameters(String service);

    String getServiceParameter(String service, String key);

    String getServiceParameter(String service, String key, String defaultValue);

    int getServiceParameter(String service, String key, int defaultValue);

    double getServiceParameter(String service, String key, double defaultValue);

    float getServiceParameter(String service, String key, float defaultValue);

    long getServiceParameter(String service, String key, long defaultValue);

    short getServiceParameter(String service, String key, short defaultValue);

    byte getServiceParameter(String service, String key, byte defaultValue);

    char getServiceParameter(String service, String key, char defaultValue);

    boolean getServiceParameter(String service, String key, boolean defaultValue);

    boolean hasServiceParameter(String service, String key);

    float getPositiveServiceParameter(String service, String key, float defaultValue);

    double getPositiveServiceParameter(String service, String key, double defaultValue);

    long getPositiveServiceParameter(String service, String key, long defaultValue);

    int getPositiveServiceParameter(String service, String key, int defaultValue);

    short getPositiveServiceParameter(String service, String key, short defaultValue);

    byte getPositiveServiceParameter(String service, String key, byte defaultValue);

    String getServiceMethodParameterAndDecoded(String service, String method, String key);

    String getServiceMethodParameterAndDecoded(String service, String method, String key, String defaultValue);

    String getServiceMethodParameterStrict(String service, String method, String key);

    String getServiceMethodParameter(String service, String method, String key);

    String getServiceMethodParameter(String service, String method, String key, String defaultValue);

    double getServiceMethodParameter(String service, String method, String key, double defaultValue);

    float getServiceMethodParameter(String service, String method, String key, float defaultValue);

    long getServiceMethodParameter(String service, String method, String key, long defaultValue);

    int getServiceMethodParameter(String service, String method, String key, int defaultValue);

    short getMethodParameter(String service, String method, String key, short defaultValue);

    byte getServiceMethodParameter(String service, String method, String key, byte defaultValue);

    boolean hasServiceMethodParameter(String service, String method, String key);

    boolean hasServiceMethodParameter(String service, String method);

    URLInterface toSerializableURL();
}
