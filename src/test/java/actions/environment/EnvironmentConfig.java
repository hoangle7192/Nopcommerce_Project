package actions.environment;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:${env}.properties"})
public interface EnvironmentConfig extends Config {

    //@Key("url")
    String url();

    @Key("db.url")
    String getDBHostName();

    @Key("db.username")
    String getDBUserName();

    @Key("db.password")
    String getDBPassword();
}
