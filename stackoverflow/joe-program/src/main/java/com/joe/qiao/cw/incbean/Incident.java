package com.joe.qiao.cw.incbean;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Incident {
    private String userForCw;
    private String domainForCw;
    private String boardForCw;
    private String passwordForCw;
    private String sumForCw;
    private String src;
    private String id;


    private long incidentId;
    private int severity;
    private String severityCat;

    private String incidentDetail;
    private long ruleId;
    private int incidentStatus;
    private int incidentCount;
    private String incidentEt;
    private String incidentSrc;

    private String incidentTarget;

    private String origDevIp;
    private String origDevName;
    private String cacheIndex;
    private long firstSeenTime;
    private long lastSeenTime;
    private String clearedUser;
    private long clearedTime;

    private String clearedReason;
    private int viewStatus;
    private String viewUsers;
    private String ticketId;
    private String comments;
    private String externalTicketType;
    private String externalTicketId;
    private String externalTicketState;
    private String externalAssignedUser;
    private Long externalClearTime;
    
    private String notificationActionStatus;
    private String phIncidentCategory;
    
    private String ruleName;
    private String ruleDesc;
    private String ruleRemediation;

    private String triggeringAttr;

    private String externalId;

    private String externalOrg;

    String srcIpAddr;
    String destIpAddr;
    String hostIpAddr;
    String srcName;
    String destName;

    String hostName;
    String vmName;

    String user;
    

    String targetUser;
    
    String sourceUser;
    
    String computer;
    String domain;
    String targetComputer;

    
    private String externalDeviceId;
    private String devAnnotation;
    private Integer devImportance;
    private String deviceType;

    private String intergrationComments;

    @XmlAttribute
    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getRuleRemediation() {
        return ruleRemediation;
    }

    public void setRuleRemediation(String ruleRemediation) {
        this.ruleRemediation = ruleRemediation;
    }

    public String getDevAnnotation() {
        return devAnnotation;
    }

    public void setDevAnnotation(String devAnnotation) {
        this.devAnnotation = devAnnotation;
    }

    public Integer getDevImportance() {
        return devImportance;
    }

    public void setDevImportance(Integer devImportance) {
        this.devImportance = devImportance;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternalOrg() {
        return externalOrg;
    }

    public void setExternalOrg(String externalOrg) {
        this.externalOrg = externalOrg;
    }

    public String getTriggeringAttr() {
        return triggeringAttr;
    }

    public void setTriggeringAttr(String triggeringAttr) {
        this.triggeringAttr = triggeringAttr;
    }

    public long getIncidentId() {
        return incidentId;
    }

    public void setIncidentId(long incidentId) {
        this.incidentId = incidentId;
    }

    public long getRuleId() {
        return ruleId;
    }

    public void setRuleId(long ruleId) {
        this.ruleId = ruleId;
    }

    public int getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(int incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public int getIncidentCount() {
        return incidentCount;
    }

    public void setIncidentCount(int incidentCount) {
        this.incidentCount = incidentCount;
    }

    public String getIncidentEt() {
        return incidentEt;
    }

    public void setIncidentEt(String incidentEt) {
        this.incidentEt = incidentEt;
    }

    public String getIncidentSrc() {
        return incidentSrc;
    }

    public void setIncidentSrc(String incidentSrc) {
        this.incidentSrc = incidentSrc;
    }

    public String getIncidentTarget() {
        return incidentTarget;
    }

    public void setIncidentTarget(String incidentTarget) {
        this.incidentTarget = incidentTarget;
    }

    public String getCacheIndex() {
        return cacheIndex;
    }

    public void setCacheIndex(String cacheIndex) {
        this.cacheIndex = cacheIndex;
    }

    public long getFirstSeenTime() {
        return firstSeenTime;
    }

    public void setFirstSeenTime(long firstSeenTime) {
        this.firstSeenTime = firstSeenTime;
    }

    public String getFormatedFirstSeenTime(){
        if (firstSeenTime > 0)
        {
            Date date = new Date(firstSeenTime);
            SimpleDateFormat dateF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
            return dateF.format(date);
        }
        return null;
    }
    
    public String getFormatedLastSeenTime(){
        if (lastSeenTime > 0)
        {
            Date date = new Date(lastSeenTime);
            SimpleDateFormat dateF = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss z");
            return dateF.format(date);
        }
        return null;
    }

    public long getLastSeenTime() {
        return lastSeenTime;
    }

    public void setLastSeenTime(long lastSeenTime) {
        this.lastSeenTime = lastSeenTime;
    }

    public long getClearedTime() {
        return clearedTime;
    }

    public void setClearedTime(long clearedTime) {
        this.clearedTime = clearedTime;
    }

    public void setViewStatus(int viewStatus) {
        this.viewStatus = viewStatus;
    }

    public int getViewStatus() {
        return viewStatus;
    }
    
    public void setViewUsers(String viewUsers) {
        this.viewUsers = viewUsers;
    }

    public String getViewUsers() {
        return viewUsers;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public String getSeverityCat() {
        return severityCat;
    }

    public void setSeverityCat(String severityCat) {
        this.severityCat = severityCat;
    }

    public String getIncidentDetail() {
        return incidentDetail;
    }

    public void setIncidentDetail(String incidentDetail) {
        this.incidentDetail = incidentDetail;
    }

    public String getClearedUser() {
        return clearedUser;
    }

    public void setClearedUser(String clearedUser) {
        this.clearedUser = clearedUser;
    }

    public String getClearedReason() {
        return clearedReason;
    }

    public void setClearedReason(String clearedReason) {
        this.clearedReason = clearedReason;
    }

    public String getOrigDevIp() {
        return origDevIp;
    }

    public void setOrigDevIp(String ip) {
        this.origDevIp = ip;
    }

    public String getExternalTicketType() {
        return externalTicketType;
    }

    public void setExternalTicketType(String externalTicketType) {
        this.externalTicketType = externalTicketType;
    }

    public String getExternalTicketId() {
        return externalTicketId;
    }

    public void setExternalTicketId(String externalTicketId) {
        this.externalTicketId = externalTicketId;
    }

    public String getExternalTicketState() {
        return externalTicketState;
    }

    public void setExternalTicketState(String externalTicketState) {
        this.externalTicketState = externalTicketState;
    }

    public String getExternalAssignedUser() {
        return externalAssignedUser;
    }

    public void setExternalAssignedUser(String externalAssignedUser) {
        this.externalAssignedUser = externalAssignedUser;
    }

    public Long getExternalClearTime() {
        return externalClearTime;
    }

    public void setExternalClearTime(Long externalClearTime) {
        this.externalClearTime = externalClearTime;
    }

    public String getNotificationActionStatus() {
        return notificationActionStatus;
    }

    public void setNotificationActionStatus(String notificationActionStatus) {
        this.notificationActionStatus = notificationActionStatus;
    }

    public String getPhIncidentCategory() {
        return phIncidentCategory;
    }

    public void setPhIncidentCategory(String phIncidentCategory) {
        this.phIncidentCategory = phIncidentCategory;
    }

    public String getRuleDesc() {
        return ruleDesc;
    }

    public void setRuleDesc(String ruleDesc) {
        this.ruleDesc = ruleDesc;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    
    public String getSrcIpAddr() {
        return srcIpAddr;
    }

    public void setSrcIpAddr(String srcIpAddr) {
        this.srcIpAddr = srcIpAddr;
    }
    
    public String getDestIpAddr() {
        return destIpAddr;
    }

    public void setDestIpAddr(String destIpAddr) {
        this.destIpAddr = destIpAddr;
    }
    
    public String getHostIpAddr() {
        return hostIpAddr;
    }

    public void setHostIpAddr(String hostIpAddr) {
        this.hostIpAddr = hostIpAddr;
    }
    
    public String getSrcName() {
        return srcName;
    }

    public void setSrcName(String srcName) {
        this.srcName = srcName;
    }
    
    public String getDestName() {
        return destName;
    }

    public void setDestName(String destName) {
        this.destName = destName;
    }
    
    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
    
    public String getVmName() {
        return vmName;
    }

    public void setVmName(String vmName) {
        this.vmName =vmName;
    }
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public String getTargetUser() {
        return targetUser;
    }

    public void setTargetUser(String targetUser) {
        this.targetUser = targetUser;
    }
    
    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }
    
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
    
    public String getTargetComputer() {
        return targetComputer;
    }

    public void setTargetComputer(String targetComputer) {
        this.targetComputer = targetComputer;
    }

    public String getUserForCw() {
        return userForCw;
    }

    public void setUserForCw(String userForCw) {
        this.userForCw = userForCw;
    }

    public String getDomainForCw() {
        return domainForCw;
    }

    public void setDomainForCw(String domainForCw) {
        this.domainForCw = domainForCw;
    }

    public String getBoardForCw() {
        return boardForCw;
    }

    public void setBoardForCw(String boardForCw) {
        this.boardForCw = boardForCw;
    }

    public String getPasswordForCw() {
        return passwordForCw;
    }

    public void setPasswordForCw(String passwordForCw) {
        this.passwordForCw = passwordForCw;
    }

    public String getSumForCw() {
        return sumForCw;
    }

    public void setSumForCw(String sumForCw) {
        this.sumForCw = sumForCw;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    /**
     * @return the externalDeviceId
     */
    public String getExternalDeviceId() {
        return externalDeviceId;
    }

    /**
     * @param externalDeviceId the externalDeviceId to set
     */
    public void setExternalDeviceId(String externalDeviceId) {
        this.externalDeviceId = externalDeviceId;
    }

    public String getIntergrationComments() {
        return intergrationComments;
    }

    public void setIntergrationComments(String intergrationComments) {
        this.intergrationComments = intergrationComments;
    }
    
    public String getOrigDevName() {
		return origDevName;
	}

	public void setOrigDevName(String origDevName) {
		this.origDevName = origDevName;
	}

    /**
     * @return the sourceUser
     */
    public String getSourceUser() {
        return sourceUser;
    }

    /**
     * @param sourceUser the sourceUser to set
     */
    public void setSourceUser(String sourceUser) {
        this.sourceUser = sourceUser;
    }
}
