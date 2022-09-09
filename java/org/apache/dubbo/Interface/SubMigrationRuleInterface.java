package org.apache.dubbo.Interface;

import java.lang.String;
import org.apache.dubbo.registry.client.migration.model.MigrationStep;
import java.lang.Float;
import java.lang.Integer;
import java.lang.Boolean;

public interface SubMigrationRuleInterface {

    String getServiceKey();

    void setServiceKey(String serviceKey);

    MigrationStep getStep();

    void setStep(MigrationStep step);

    Float getThreshold();

    void setThreshold(Float threshold);

    Integer getProportion();

    void setProportion(Integer proportion);

    Integer getDelay();

    void setDelay(Integer delay);

    Boolean getForce();

    void setForce(Boolean force);
}
