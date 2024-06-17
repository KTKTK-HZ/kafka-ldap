package org.apache.kafka.common.security.ldap;

import org.apache.kafka.common.security.auth.AuthenticateCallbackHandler;
import org.apache.kafka.common.security.plain.PlainAuthenticateCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.AppConfigurationEntry;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class LdapServerCallbackHandler implements AuthenticateCallbackHandler {
    private static final String JAAS_USER_PREFIX = "user_";
    private List<AppConfigurationEntry> jaasConfigEntries;
    private Map<String, ?> kafkaConfig;
    private static final Logger log = LoggerFactory.getLogger(LdapServerCallbackHandler.class);

    @Override
    public void configure(Map<String, ?> configs, String saslMechanism, List<AppConfigurationEntry> jaasConfigEntries) {
        log.info("configure LdapServerCallbackHandler.");
        this.jaasConfigEntries = jaasConfigEntries;
        this.kafkaConfig = configs;


    }

    @Override
    public void close() {

    }

    @Override
    public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {
        String username = null;
        for (Callback callback: callbacks) {
            if (callback instanceof NameCallback) {
                username = ((NameCallback)callback).getDefaultName();
            } else if (callback instanceof PlainAuthenticateCallback) {
                PlainAuthenticateCallback plainCallback = (PlainAuthenticateCallback) callback;
                boolean authenticated = false;
                authenticated = authenticate(username, plainCallback.password());
                plainCallback.authenticated(authenticated);
                } else
                throw new UnsupportedCallbackException(callback);
            }
        }
    // TODO
    private boolean authenticate(String username, char[] password) {
        return true;
    }
}

