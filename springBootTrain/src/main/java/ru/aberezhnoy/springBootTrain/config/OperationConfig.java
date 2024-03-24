package ru.aberezhnoy.springBootTrain.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "operation.processing")
public class OperationConfig {
    long sleepmilliseconds;

    public long getSleepmilliseconds() {
        return sleepmilliseconds;
    }

    public void setSleepmilliseconds(long sleepmilliseconds) {
        this.sleepmilliseconds = sleepmilliseconds;
    }
}
