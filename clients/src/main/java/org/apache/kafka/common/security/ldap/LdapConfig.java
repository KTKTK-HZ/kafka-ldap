package org.apache.kafka.common.security.ldap;

public class LdapConfig {
    private static final String LDAP_CONFIG_PREFIX = "ldap.";
    public static final String LDAP_SSL_ENABLED = LDAP_CONFIG_PREFIX + "ssl.enabled";
    public static final String LDAP_SSL_TRUST_ALL = LDAP_CONFIG_PREFIX + "ssl.trust.all";
    public static final String LDAP_START_TLS_ENABLED = LDAP_CONFIG_PREFIX + "start.tls.enabled";
    public static final String LDAP_SERVER = LDAP_CONFIG_PREFIX + "server";
    public static final String LDAP_PORT = LDAP_CONFIG_PREFIX + "port";
    public static final String LDAP_SEARCH_BASE = LDAP_CONFIG_PREFIX + "search.base";
    public static final String LDAP_SEARCH_FILTER = LDAP_CONFIG_PREFIX + "search.filter";
    public static final String LDAP_BIND_USER = LDAP_CONFIG_PREFIX + "bind.user";
    public static final String LDAP_BIND_VPN = LDAP_CONFIG_PREFIX + "bind.vpn";
    public static final String LDAP_CONNECTION_POOL_SIZE = LDAP_CONFIG_PREFIX + "connection.pool.size";
}
