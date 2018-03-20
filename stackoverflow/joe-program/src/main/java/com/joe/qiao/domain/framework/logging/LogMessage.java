package com.joe.qiao.domain.framework.logging;

/**
 *
 * @author Michael Li <Michael.Li@prospecthills.net>
 */
public enum LogMessage {
    
    /**
     * System status events
     * 
     */
    // Collector Info Events
    //
    PH_COLLECTOR_UP("Collector up"),
    PH_WIN_AGENT_UP("Windows Agent up"),
    PH_SAAS_OP_COLLECTOR_UP("SaaS: collector up"),

    PH_COLLECTOR_DOWN("Collector down"),
    PH_WIN_AGENT_DOWN("Windows Agent down"),
    PH_SAAS_OP_COLLECTOR_DOWN("SaaS: collector down"),
    
    PH_COLLECTOR_EVENT_ARRIVAL_DELAYED("Collector event arrival delayed"),
    PH_COLLECTOR_EVENT_ARRIVAL_OK("Collector event arrival OK"),
    PH_COLLECTOR_EVENT_STORE_DELAYED("Collector event store delayed"),
    PH_COLLECTOR_EVENT_STORE_OK("Collector event store OK"),
    
    PH_COLLECTOR_CLOCK_SKEW("Collector clock skew"),
    
    // Worker
    PH_WORKER_UP("Worker up"),
    PH_WORKER_DOWN("Worker down"),
    
    // Report Server
    PH_REPORT_SERVER_UP("Report Server up"),
    PH_REPORT_SERVER_DOWN("Report Server down"),
    
    /**
     * Audit Events
     * 
     */
    // audit code
    PH_AUDIT_USER_LOGIN_SUCCESS("User login successful"),
    PH_AUDIT_USER_LOGIN_FAILURE("User login failed"),
    PH_AUDIT_USER_LOGOFF("User logged off"),
    PH_AUDIT_USER_SESSION_TIMEOUT("User logged off due to session timeout"),
    PH_AUDIT_ACCOUNT_LOCKED("Account locked due to consecutive login failure"),
    PH_AUDIT_INACTIVE_USER_LOGIN("An inactive user tried to login"),
    PH_AUDIT_SVC_LOGIN_SUCCESS("Service login successful"),
    PH_AUDIT_SVC_LOGIN_FAILURE("Service login failed"),
    PH_AUDIT_SVC_LOGOFF("Service logged off"),
    PH_AUDIT_SVC_SESSION_TIMEOUT("Service logged off due to session timeout"),
    PH_AUDIT_OBJECT_CREATED("Object created"),
    PH_AUDIT_OBJECT_DELETED("Object deleted"),
    PH_AUDIT_OBJECT_UPDATED("Object updated"),
    PH_AUDIT_WS_COMM("Web service communication"),
    PH_AUDIT_DATA_PURGE("Data purge"),
    PH_AUDIT_CI_QUOTE_EXCEEDED("Config item quote exceeded"),
    PH_AUDIT_QUERY_START("Started a query"),
    PH_AUDIT_QUERY_STOP("Stopped a query"),
    PH_AUDIT_QUERY_SCHEDULE("Scheduled a query"),
    PH_AUDIT_REPORT_BUNDLE_SCHEDULE("Scheduled a report bundle"),
    PH_AUDIT_MALWARE_DATA_UPDATED("Malware data updated"),
    PH_AUDIT_MALWARE_DATA_DELETED("Malware data deleted"),
    PH_AUDIT_PASSWORD_CHANGED("User changed password"),
    PH_AUDIT_DEVICE_MERGED_BY_IP_WITH_DIFF_NAME("Device merged by IP with different device name"),
    PH_AUDIT_DEVICE_MAINTENANCE_STARTED("Device maintenance started"),
    PH_AUDIT_DEVICE_MAINTENANCE_ENDED("Device maintenance ended"),
    PH_AUDIT_DEVICE_DISCOVERY_ITEM_CHANGED("Device attribute changed after discovery"),
    PH_AUDIT_DEVICE_ADDED("New device created in CMDB"),
    PH_AUDIT_DEVICE_DELETED("Device deleted from CMDB"),
    
    PH_AUDIT_USER_ADDED("New user created in CMDB"),
    PH_AUDIT_USER_UPDATED("User updated in CMDB"),
    PH_AUDIT_USER_DELETED("User removed from CMDB"),
    PH_AUDIT_GROUP_DELETED("Group removed from CMDB"),
    PH_AUDIT_GROUP_CREATED("New group created in CMDB"),
    PH_AUDIT_TUNNEL_OPEN("Open tunnel request sent to backend."),
    PH_AUDIT_TUNNEL_CLOSE("Close tunnel request sent to backend."),
    
    PH_AUDIT_EXPORT_REPORT_START("Started report export"),
    PH_AUDIT_EXPORT_REPORT_END("Finished report export"),
    
    PH_AUDIT_INCIDENT_MISSED("An incident was missed"),
    
    PH_AUDIT_DEV_MON_JOB_STATUS_CHANGE("Job status of monitoring device changed"),
    
    PH_AUDIT_DEV_MON_JOB_NOT_STARTED("Job of monitoring device not start"),
    
    PH_AUDIT_DEVICE_STOP_MONITORING("No more event is sent on device"),
    
    PH_AUDIT_DOMAIN_NAME_CHANGED("User changed domain name"),
    
    // notification action result
    PH_INCIDENT_ACTION_STATUS("Record incident notification action result"),
    PH_REPORT_ACTION_STATUS("Record report notification action result"),
    
    //#devices exceed maximum defined in license
    PH_MAX_DEVICES_EXCEEDED("Maximum devices in CMDB exceeded system quota"),
    PH_DEVICE_NOT_ADDED("Unable to add new device since maximum devices in CMDB exceeded system quota"),
    
    PH_AUDIT_DEVICE_STATUS_CHANGE("Audit status of device in CMDB changed"),
    PH_AUDIT_DEVICE_UNMANAGED("Audit unmanaged devices in CMDB"),
    
    //LDAP delete user
    PH_LDAP_MERGE_DELETE_OBSOLETE_USER("Delete obsolete LDAP user from CMDB during LDAP merge"),
    PH_AUDIT_GENERIC("Audit"),

    PH_APP_SERVER_PERF_DATA("Method took longer than 500ms to finish."),
    
    PH_AUDIT_DEFAULT_PWD_MATCH("Default password matches for the same composite key (Vendor, Model, Access method, User Name, Password)  "),
 
    PH_AUDIT_DISCOVERY(" User starts discovery"),
    
    // 
    PH_AUDIT_REPORT_SERVER_LICENSE_EXPIRED("Report server license expired."),
    PH_AUDIT_REPORT_SERVER_LICENSE_TO_EXPIRE("Report server license is about to expire."),
    PH_AUDIT_REPORT_SERVER_LICENSE_REMOVED("Report server license removed."),

    PH_AUDIT_CMDB_EC2_DEVICE_DELETED("Terminated Ec2 device deleted from CMDB."),

    // Performance Events
    //
    PH_DEV_MON_LOG_ALL_DEVICE_DELAY_HIGH("Log receipt delay for all devices from a collection point crossed high water mark"), 
    PH_DEV_MON_LOG_ALL_DEVICE_DELAY_LOW("Log receipt delay for all devices from a collection point fell below low water mark"),
    PH_DEV_MON_LOG_DEVICE_DELAY_HIGH("Log receipt delay for a single device crossed high water mark"), 
    PH_DEV_MON_LOG_DEVICE_DELAY_LOW("Log receipt delay for a single device fell below water mark"), 
    PH_DEV_MON_PERFMON_ALL_DEVICE_DELAY_HIGH("Performance monitoring delay for all devices from a collection point crossed high water mark"), 
    PH_DEV_MON_PERFMON_ALL_DEVICE_DELAY_LOW("Performance monitoring delay for all devices from a collection point fell below low water mark"), 
    PH_DEV_MON_PERFMON_DEVICE_DELAY_HIGH("All performance metrics delay for a single device crossed high water mark"), 
    PH_DEV_MON_PERFMON_DEVICE_DELAY_LOW("Some performance metric delay for a single device fell below water mark"),
    PH_DEV_MON_PERFMON_JOB_DELAY_HIGH("A performance metric delay for a single device crossed high water mark"), 
    PH_DEV_MON_PERFMON_JOB_DELAY_LOW("A performance metric delay for a single device fell below water mark"), 

    /**
     * Risk Score 
     */
    PH_DEV_MON_RISK_INCREASE_MED("Risk score increased to Medium"),
    PH_DEV_MON_RISK_INCREASE_HIGH("Risk score increased to High"),
    PH_DEV_MON_RISK_DECREASE_LOW("Risk score decreased to Low"),
    PH_DEV_MON_RISK_DECREASE_MED("Risk score decreased to Medium"),

    
    /**
     * Warning Messages
     * 
     * 
     */
    // Data not found
    PH_APPSERVER_OBJECT_NOT_FOUND("Can't find the specified object"),
    
    // Notification Warning
    PH_APPSERVER_NOTIFIER_WARN("Notification warning"),
    
    // JMS size monitor
    PH_APPSERVER_JMS_QUEUE_SIZE_WARNING("Warning: JMS queue is too large "),
    
    PH_APPSERVER_LICENSE_TYPE_WARNING("Warning: license type is not support"),
    
    PH_APPSERVER_RESOURCE_BUNDLE_WARNING("Warning: could not be found in localization resource bundle"),
    
    /**
     * Error Messages
     * 
     */
    // Database error
    //
    PH_APPSERVER_DB_QUERY_ERROR("Error occured in during database query"),
    PH_APPSERVER_DB_DATA_ERROR("Data error found in database"),
    PH_APPSERVER_DB_UPDATE_ERROR("Updating data error found in database"),
    PH_APPSERVER_DB_DELETE_ERROR("Deleting data error found in database"),
    PH_APPSERVER_DB_CONNECTION_CLOSE_ERROR("Error occured in during database connection close"),
    // Query submit / result read error
    PH_APPSERVER_REALTIME_QUERY_ERROR("Cannot start real time query"),
    
    PH_APPSERVER_QUERY_RUN_ERROR("Running Query error"),
    PH_APPSERVER_QUERY_STOP_ERROR("Cannot stop query"),
    PH_APPSERVER_QUERY_RESULT_PARSER_ERROR("Query result parsing error"),
    PH_APPSERVER_QUERY_RESULT_RETRIEVE_ERROR("Query result retrieval error"),

    PH_APPSERVER_QUERY_EXPORT_ERROR("Report exporting error"),
    
    // Collector Error
    //
    PH_APPSERVER_COLLECTOR_LICENSE_ERROR("Collector license error"),
    PH_APPSERVER_COLLECTOR_STATUS_ERROR("Collector status error"),
    PH_APPSERVER_COLLECTOR_INFO_ERROR("Collector information error"),
    
    // Communication error
    PH_APPSERVER_WS_COMM_ERROR("Web service communication error"),
    PH_APPSERVER_SOCKET_COMM_ERROR("Socket communication error"),
    PH_APPSERVER_NOTIFIER_ERROR("Notifier error"),
    
    // File related error
    PH_APPSERVER_FILE_NOT_FOUND("Cannot find the specified file"),
    PH_APPSERVER_FILE_READ_ERROR("Cannot read from the specified file"),
    PH_APPSERVER_FILE_WRITE_ERROR("Cannot write to the specified file"),
    PH_APPSERVER_FILE_SYSTEM_ERROR("File system error"),

    // Rule Error
    PH_APPSERVER_RULE_ACTIVE_ERROR("Rule Activiation Error"),
    PH_APPSERVER_RULE_UPDATE_ERROR("Rule Update Error"),
    PH_APPSERVER_RULE_CLONE_ERROR("Rule Clone Error"),
    
    // Elastic Error
    PH_APPSERVER_ELASTIC_UPDATE_ERROR("Elastic Update Error"),
    
    // XML parsing error
    PH_APPSERVER_XML_PARSE_ERROR("XML parsing error"),

    // import error
    PH_APPSERVER_DATA_IMPORT_ERROR("Data import error"),
    
    // Misc error
    PH_APPSERVER_PDF_BUILDER_ERROR("PDF builder error"),
    
    // Discover Error
    PH_APPSERVER_DISCOVERY_RESULT_ERROR("Discovery result process error"),
    
    PH_APPSERVER_WORKER_PROVISION_FAILED("Phoenix worker provision failed"),
    
    // Notification Error
    PH_APPSERVER_NOTIFICATION_ERROR("Notification Error"),
    PH_APPSERVER_NOTIFICATION_UPDATE_ERROR("Notification Update Error"),
    
    
    // Schedule error
    PH_APPSERVER_SCHEDULE_ERROR("Schedule error"),
    PH_APPSERVER_SCHEDULE_UPDATE_ERROR("Schedule Update Error"),
    
    
    PH_APPSERVER_REMEDY_ERROR("Remedy error"),
    
    // Incident Error
    PH_APPSERVER_INCIDENT_UPDATE_ERROR("Incident Update Error"),
    PH_APPSERVER_INCIDENT_NOTIFY_ERROR("Incident Notify Error"),
    
    
    // Log Integrity
    PH_APPSERVER_LOG_INTEGRITY_ERROR("Log integrity error"),
    
    // Parser Error
    PH_APPSERVER_PARSER_IMPORT_ERROR("Import parser error"),
    PH_APPSERVER_PARSER_UPDATE_ERROR("Parser update error"),
    
    // Report Error
    PH_APPSERVER_REPORT_UPDATE_ERROR("Report update error"),
    PH_APPSERVER_REPORT_BUNDLE_PRINT_ERROR("Report run error"),

    // Watch List error
    PH_APPSERVER_WATCHLIST_UPDATE_ERROR("Watch List updating Error"),
    PH_APPSERVER_WATCHLIST_IMPORT_ERROR("Error happening on importing watch List"),
    PH_APPSERVER_WATCHLIST_IMPORT_WARN("Importing watch List warn"),
    PH_APPSERVER_NO_WATCHLIST_SELECTED_WARN("No watch list selected for entry warn"),
    // Data Robust error
    PH_APPSERVER_DATA_ROBUST_INFO_ERROR("Data Robust Info Error"),

    // CMDB Report Error
    PH_APPSERVER_CMDB_REPORT_IMPORT_ERROR("Importing CMDB Report Error"),
    PH_APPSERVER_CMDB_REPORT_EXPORT_ERROR("Exporting CMDB Report Error"),
    PH_APPSERVER_CMDB_REPORT_QUERY_ERROR("Querying CMDB Report Error"),
    PH_APPSERVER_CMDB_REPORT_DATA_ERROR("CMDB Report Data Error"),
    PH_APPSERVER_CMDB_REPORT_TYPE_ERROR("CMDB Report Type Error"),

    // Condition Parsing Error
    PH_APPSERVER_PARSING_CONSTRAINT_ERROR("Contraint Parsing Error"),

    // Dashboard Error
    PH_APPSERVER_DASHBOARD_DATA_ERROR("Dashbaord Data Error"),

    PH_APPSERVER_DASHBOARD_WIDGET_ERROR("Dashbaord Widget Error"),

    //Group Error
    PH_APPSERVER_GROUP_DATA_ERROR("Group Data Error"),

    // System Configuration Error
    PH_APPSERVER_SYSCONFIG_GET_ERROR("Error happening on getting system configuration"),
    PH_APPSERVER_PERFMON_TASK_ERROR("Performance Monitoring Task Error"),
    PH_APPSERVER_GET_MAX_CONFIG_ITEM_COUNT_ERROR("Error happening on getting max system configuration iten count"),

    // RBAC Error
    //
    PH_APPSERVER_RBAC_ERROR("RBAC Error"),

    // Testing Rule Error
    PH_APPSERVER_RULE_TEST_ERROR("Error happening on debugging rule"),

    // Sync update config for perf monitoring and event pulling
    PH_APPSERVER_SYNC_UPDATE_CONFIG_ERROR("Error on syncing update config"),

    // Beaconing Service
    PH_APPSERVER_BEACON_WEB_SERVER_ERROR("Beaconing Web Server Error"),
    PH_APPSERVER_BEACON_REGISTER_ERROR("Beaconing Register Error"), 
    PH_APPSERVER_BEACON_SERVER_ERROR("Beaconing Server Error"),
    PH_APPSERVER_BEACON_LIB_ERROR("Beaconing library Error"),

    // Exporting data
    PH_APPSERVER_EXPORT_ERROR(""),
    PH_APPSERVER_NETSEGMENT_EXPORT_ERROR("Error happening on exporting network segment report"),
    PH_APPSERVER_REPORT_EXPORT_ERROR("Error happening on exporting report"),
    PH_APPSERVER_AUDIT_REPORT_EXPORT_ERROR("Error happening on exporting audit data"),
    PH_APPSERVER_EVENTDB_EXPORT_ERROR("Error happening on exporting event DB data"),
    PH_APPSERVER_TICKET_EXPORT_ERROR("Error happening on exporting incident ticket"),
    PH_APPSERVER_OPENPROXY_EXPORT_ERROR("Error happening on exporting open proxy data"),
    PH_APPSERVER_IDENTIYLOCATION_EXPORT_ERROR("Error happening on exporting identity location"),
    PH_APPSERVER_USERAGENT_EXPORT_ERROR("Error happening on exporting user agent"),    
    PH_APPSERVER_WATCHLIST_EXPORT_ERROR("Error happening on exporting watch List"),
    PH_APPSERVER_COMMONPWD_EXPORT_ERROR("Error happening on exporting common password data"),
    
    // IOC Integration Error
    //
    PH_APPSERVER_FORTIGUARD_IOC_INTEGRATION_ERROR("FortiGuard IOC Integration Error"),

    // Malware Update Error
    PH_APPSERVER_EXT_THREAT_INTEL_UPDATE_ERROR("Updating Malware Data Error"),
    PH_APPSERVER_EXT_THREAT_INTEL_DOWNLOAD_ERROR("Downloading Malware Data Error"),
    PH_APPSERVER_EXT_THREAT_INTEL_PARSE_ERROR("Error happening on parsing Malware Data"),

    // Integration Error
    PH_APPSERVER_INTEGRATION_WARN("Integration Error"),
    PH_APPSERVER_INTEGRATION_ERROR("Integration Error"),
    PH_APPSERVER_OUT_INTEGRATION_ERROR("Outbound Integration Error"),
    PH_APPSERVER_IN_INTEGRATION_ERROR("Inbound Integration Error"),

    // License Error
    PH_APPSERVER_LICENSE_EXPIRY_ERROR("License Expiration Error"),
    PH_APPSERVER_LICENSE_VALIDATION_ERROR("Error happening on validating license expiration"),

    // Calculation of Risk Score
    //
    PH_APPSERVER_RISKSCORE_CALCULATE_ERROR("Error happening on calculation of risk score"),

    // Servlet Error
    PH_APPSERVER_SERVLET_ERROR("Servlet error"),
    PH_APPSERVER_REST_ERROR("REST error"),
    PH_APPSERVER_REST_H5_ERROR("HTML5 REST error"),

    // SVN Error
    //
    PH_APPSERVER_SVN_ERROR("SVN Repository Error"),

    // System Error
    PH_APPSERVER_SYS_APPLICATION_ERROR("System Application Server Error"),
    PH_APPSERVER_SYS_DATA_UPDATE_ERROR("System Data Update Error"),


    // Security Error
    PH_APPSERVER_SECURITY_ERROR("System Security Data Error"),

    PH_APPSERVER_JOB_DISTRIBUTE_ERROR("Error happened when run distributing performance monitoring jobs to workers"),

    // Generic error
    PH_APPSERVER_GENERIC_ERROR("Unknown Error"),
    PH_APPSERVER_GENERIC_WARN("Generic Warn"),
    PH_APPSERVER_GENERIC_INFO("Generic Info"),

    /**
     *  PDF customize error record
     *  @Author Joe Qiao
     */
    PH_APPSERVER_CUSTOMIZE_BUILD_CHART_ERROR("Customize Build Chart Error"),
    PH_APPSERVER_CUSTOMIZE_BUILD_TABLE_ERROR("Customize Build Table Error"),
    PH_APPSERVER_CUSTOMIZE_BUILD_SVG_ERROR("Customize Build SVG Error"),

    /**
     * Log normal
     * @Author Joe Qiao
     */
    PH_APPSERVER_JOE_PROGRAM_NORMAL_ERROR("Joe Program normal Error"),
    PH_APPSERVER_JOE_PROGRAM_NORMAL_WARN("Joe Program normal Warn"),
    PH_APPSERVER_JOE_PROGRAM_NORMAL_INFO("Joe Program normal Info"),



    /**
     * Next is what Xin does. 
     * 
     */
    //escape string Error
    PH_APPSERVER_QUERY_STRING_ESCAPE_ERROR("Can't find close escape string"),
    // report Error
    PH_APPSERVER_REPORT_DEVICE_COMPONENT_SN_ERROR("Device component serial number report Error"),
    PH_APPSERVER_REPORT_DEVICE_SN_ERROR("Device server serial number report Error"),
    PH_APPSERVER_REPORT_DEVICE_DETAIL_ERROR("Device detail report Error"),
    PH_APPSERVER_REPORT_DEVICE_SUMMARY_ERROR("Device summary report Error"),
    PH_APPSERVER_REPORT_IDENTITY_AND_LOCATION_ERROR("Identity and location report Error"),
    PH_APPSERVER_REPORT_COMPILE_ERROR("Compile report to file error"),
    PH_APPSERVER_REPORT_FAILED_BLOCK_SUMMARY_ERROR("Get failed blocks error"),
    PH_APPSERVER_REPORT_LOG_FILE_SUMMARY_ERROR("Get log files error"),
    PH_APPSERVER_REPORT_TICKET_SUMMARY_ERROR("Get tickets error"),
    PH_APPSERVER_REPORT_USER_SUMMARY_ERROR("Get users error"),
    PH_APPSERVER_REPORT_FIRE_TRIGGER_EVENT_ERROR("Fire trigger events error"),
    //task Error
    PH_APPSERVER_TASK_UPDATE_ERROR("Update task Error"),
    PH_APPSERVER_TASK_GET_ERROR("Get task Error"),
    PH_APPSERVER_TASK_CREATE_ERROR("Create task Error"),

    //report template
    PH_APPSERVER_REPORT_TEMPLATE_GENERATE_PDF_ERROR("Report template generate PDF Error"),
    PH_APPSERVER_REPORT_TEMPLATE_PDF_SUMMARY_ERROR("Report template create PDF summary Error"),
    PH_APPSERVER_REPORT_TEMPLATE_INIT_IMAGE_ERROR("Report template init image Error"),
    PH_APPSERVER_REPORT_TEMPLATE_INIT_PARM_ERROR("Report template init parameter Error"),
    //jms Error
    PH_APPSERVER_NOTIFICATION_JMS_CONNECTION_ERROR("Create JMS connection Error"),

    //bean helper Error
    PH_APPSERVER_BEAN_REF_CHECK_WARN("Check entity bean reference Warn"),
    PH_APPSERVER_BEAN_TO_VALUE_ERROR("Entity bean to property value map Error"),
    PH_APPSERVER_BEAN_TO_XML_ERROR("Generating XML from Entity Error"),
    PH_APPSERVER_BEAN_VALUE_TO_BEAN_ERROR("Set value for Entity bean Error"),
    PH_APPSERVER_BEAN_SYNC_PROPERTIES_ERROR("Entity bean sync properties Error"),

    //service starter Error
    PH_APPSERVER_FRAMEWORK_SHUTDOWN_SERVICE_STARTER_WARN("Cannot shutdown service starter Warn"),
    PH_APPSERVER_FRAMEWORK_RUN_THREAD_ERROR("Run thread Error"),
    PH_APPSERVER_FRAMEWORK_SERVICE_MISSED_WARN("Can not find service Warn"),
    PH_APPSERVER_FRAMEWORK_SECURITY_CHECK_LICENSE_WARN("Check license warn"),
    PH_APPSERVER_FRAMEWORK_SECURITY_INIT_SYSTEM_ERROR("Initializing Phoenix Caching system failed"),
    PH_APPSERVER_FRAMEWORK_REGISTER_ERROR("Register error"),
    PH_APPSERVER_FRAMEWORK_SECURITY_GET_RS_EXPIRATION_ERROR("Get rs expiration error"),
    PH_APPSERVER_FRAMEWORK_SECURITY_GET_ENTITY_MANAGER_ERROR("Cannot get EntityManager error"),

    //find exist user
    PH_APPSERVER_UPDATER_FIND_EXIST_USER_BY_NOTHING_ERROR("Finding existing user by nothing"),

    //phoenix configuration
    PH_APPSERVER_REPORT_GET_PH_CONFIG_ERROR("Get phoenix configuration error"),

    //task
    PH_APPSERVER_ADMIN_AGENT_UNKOWN_TASK_ID_ERROR("Unkown task ID"),
    PH_APPSERVER_DISCOVERY_RESULT_UNKOWN_TASK_ID_ERROR("Unkown task ID"),

    PH_APPSERVER_DISCOVERY_RESULT_ENCRYPT_XML_ELEMENT_ERROR("Encrypt element in xml Error"),
    PH_APPSERVER_ADMIN_AGENT_GET_UPDATE_FAILED_ERROR("Failed to get update"),
    PH_APPSERVER_ADMIN_CUST_GENERATE_KEY_ERROR("Error happend during generate key"),
//    PH_APPSERVER_WEB_RUN_THREAD_ERROR("Run thread Error"),
    PH_APPSERVER_NOTIFICATION_EMAIL_GET_RESOURCE_FAILED("Get resource failed in email notification"),
    PH_APPSERVER_ADMIN_GET_RESOURCE_FAILED("Get resource failed"),
    PH_APPSERVER_ADMIN_LOCATE_KEY_FAILED("Could not locate key"),
    PH_APPSERVER_ADMIN_RESET_FIELD_FAILED_ERROR("Failed to reset field"),
    PH_APPSERVER_DISCOVERY_CREDENTIAL_DECRYPT_PASSWORD_WARN("Cannot decrypt password warn"),
    PH_APPSERVER_QUERY_CHECK_POLICY_ACTION_WARN("Checking policy actions warn"),
    PH_APPSERVER_EVENT_ATTRIBUTE_BUILD_XML_ERROR("Error happened during build XML content"),
    PH_APPSERVER_DASHBOARD_HTML_BUILD_XML_ERROR("Error happened during build XML content"),
    PH_APPSERVER_TASK_FLEX_RESULT_BUILD_XML_ERROR("Error happened during build XML content"),
    PH_APPSERVER_IOC_TASK_CREATE_FAILED_ERROR("Error happened when create ioc task"),
    PH_APPSERVER_IOC_LICENSE_CHECK_FAILED_WARN("Warn when checking IOC Serice license"),
    PH_APPSERVER_WATCHLIST_ADD_TO_DISTIRBUTED_QUEUE("Error happened when add watch list to distirbuted queue"),
    PH_APPSERVER_RULE_DEBUG_INVALID_EVENT_DB_ID_ERROR("Event DB Id missed"),
    PH_APPSERVER_RULE_DEBUG_WORKERS_SETTING_ERROR("Workers settings error for rule"),
    PH_APPSERVER_INTEGRATION_UPDATE_POLICY_WARN("Update policy warn"),
    PH_APPSERVER_INTEGRATION_UPDATE_POLICY_ERROR("Error happened when update policy"),
    PH_APPSERVER_EAMIL_GENERATE_EVENT_ERROR("Error happened when generate raw event"),
    PH_APPSERVER_EMAIL_PREPARE_DATA_ERROR("Error happened when prepare data"),
    PH_APPSERVER_MONITOR_HEALTH_CONFIG_SET_ERROR("Error happened when set event receive time of eventPulling config"),
    PH_APPSERVER_MONITOR_AUDIT_PERF_ERROR("Exception while audit perfmance monitor"),
    PH_APPSERVER_LOGIN_ERROR("Login error"),
    PH_APPSERVER_FLEX_INTERCEPTOR_NO_LOGIN_EXCEPTION_ERROR("No or login out exception error"),
    PH_APPSERVER_SYSTEM_WINAGENT_REGISTER_WARN("WinAgent not found or not registered warn"),
    PH_APPSERVER_SERVLET_NO_ACCESS_TO_URI_WARN("Has no access to uri warn"),
    PH_APPSERVER_VULNERABILITY_IGNORE_WARN("Vulnerability result was ignored warn"),
    PH_APPSERVER_RBAC_NO_PERMISSION_WARN("No permission warn"),
    PH_APPSERVER_WEBSERVICE_UPDATE_TASK_ERROR("Error happened when update task"),

    //java query server
    PH_JAVA_QUERYSERVER_ERROR("Error occurred in Java Query Server."),
    PH_JAVA_QUERYSERVER_ELASTIC_ERROR("Error occurred in Elasticsearch."),
    PH_JAVA_QUERYSERVER_REDIS_ERROR("Error occurred in Redis."),
    PH_JAVA_QUERYSERVER_QUERYID_ERROR("Unknown or expired Query ID."),
    PH_JAVA_QUERYSERVER_ACTION_UNSUPPORTED_ERROR("Not supported action."),
    PH_JAVA_QUERYSERVER_QUERY_SYNTAX_ERROR("Query syntax error."),
    PH_JAVA_QUERYSERVER_WARN("Warning from Java Query Server."),
    PH_JAVA_QUERYSERVER_INFO("Generic Info");

    private String message;

    public String getMessage() {
        return message;
    }

    private LogMessage(String message) {
        this.message = message;
    }
}
