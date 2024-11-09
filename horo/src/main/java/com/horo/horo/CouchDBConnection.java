package com.horo.horo;

import org.ektorp.CouchDbConnector;
import org.ektorp.CouchDbInstance;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbConnector;
import org.ektorp.impl.StdCouchDbInstance;

import org.lightcouch.CouchDbClient;
import org.lightcouch.CouchDbProperties;

public class CouchDBConnection {

    public static CouchDbClient connect() {
        CouchDbProperties properties = new CouchDbProperties()
                .setDbName("horoscope")
                .setCreateDbIfNotExist(true)
                .setProtocol("http")
                .setHost("127.0.0.1")
                .setPort(5984)
                .setUsername("admin")
                .setPassword("1");

        return new CouchDbClient(properties);
    }
}
