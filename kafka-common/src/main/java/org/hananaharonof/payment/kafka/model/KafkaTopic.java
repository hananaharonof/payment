package org.hananaharonof.payment.kafka.model;

public enum  KafkaTopic {

    RISK_ENGINE_IN;

    public String getTopicName() {
        return this.name().toLowerCase();
    }

}
