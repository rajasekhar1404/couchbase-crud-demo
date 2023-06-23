package com.couchbase.config;

import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;

public class CouchConfig extends AbstractCouchbaseConfiguration {

    @Override
    public String getConnectionString() {
        return "couchbase://127.0.0.1";
    }

    @Override
    public String getUserName() {
        return "rajasekhar";
    }

    @Override
    public String getPassword() {
        return "rajasekhar";
    }

    @Override
    public String getBucketName() {
        return "users";
    }
}
