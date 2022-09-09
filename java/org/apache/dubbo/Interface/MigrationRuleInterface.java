package org.apache.dubbo.Interface;

import java.lang.String;
import org.apache.dubbo.registry.client.migration.model.MigrationStep;
import org.apache.dubbo.common.URL;
import org.apache.dubbo.Interface.URLInterface;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Boolean;
import java.util.List;
import org.apache.dubbo.Interface.SubMigrationRuleInterface;
import java.lang.Object;

public interface MigrationRuleInterface {

    String getKey();

    void setKey(String key);

    MigrationStep getStep(URLInterface consumerURL);

    MigrationStep getStep();

    float getThreshold(URLInterface consumerURL);

    Float getThreshold();

    void setThreshold(Float threshold);

    Integer getProportion();

    int getProportion(URLInterface consumerURL);

    void setProportion(Integer proportion);

    Integer getDelay();

    int getDelay(URLInterface consumerURL);

    void setDelay(Integer delay);

    void setStep(MigrationStep step);

    Boolean getForce();

    boolean getForce(URLInterface consumerURL);

    void setForce(Boolean force);

    List<SubMigrationRuleInterface> getInterfaces();

    void setInterfaces(List<SubMigrationRuleInterface> interfaces);

    List<SubMigrationRuleInterface> getApplications();

    void setApplications(List<SubMigrationRuleInterface> applications);

    boolean equals(Object o);

    int hashCode();
}
