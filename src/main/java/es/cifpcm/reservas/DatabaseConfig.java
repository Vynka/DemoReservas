package es.cifpcm.reservas;

/**
 *
 * @author Fer
 */
public class DatabaseConfig {
    
    private static final int DEFAULT_DB_PAGESIZE = 20;
    
    private String driverClassName;
    private String databaseUrl;
    private String databaseUser;
    private String databasePassword;
    private Integer databasePageSize;

    public DatabaseConfig() {
    }

    public DatabaseConfig(String driverClassName, String databaseUrl, String databaseUser, String databasePassword) {
        this.driverClassName = driverClassName;
        this.databaseUrl = databaseUrl;
        this.databaseUser = databaseUser;
        this.databasePassword = databasePassword;
        this.databasePageSize = DEFAULT_DB_PAGESIZE;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseUser() {
        return databaseUser;
    }

    public void setDatabaseUser(String databaseUser) {
        this.databaseUser = databaseUser;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public Integer getDatabasePageSize() {
        return databasePageSize;
    }

    public void setDatabasePageSize(Integer databasePageSize) {
        this.databasePageSize = databasePageSize;
    }
    
    
    
    
    
    
}
