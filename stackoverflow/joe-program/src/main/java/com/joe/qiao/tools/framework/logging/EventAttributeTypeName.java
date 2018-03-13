/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joe.qiao.tools.framework.logging;

/**
 *
 * @author Michael Li <Michael.Li@prospecthills.net>
 */
public enum EventAttributeTypeName {
    phEventCategory,
    phRuleId,
    phCustId(12),
    customer,
    phLogDetail,
    phRecvTime,
    phAgentId,
    eventId,
    eventType,
    eventName,
    eventSeverity,
    rawEventMsg,
    eventParsedOk,
    ipProto,
    destIpPort,
    preNATDestIpPort,
    icmpType,
    icmpCode,
    procName,
    sessionId,
    srcIpAddr,
    user,
    reptDevIpAddr,
    srcSnmpIntfIndex,
    destSnmpIntfIndex,
    incidentDetail,
    incidentTicketState,
    hostName,
    intfName,
    hostIpAddr(1005),
    incidentId;

    private Integer attrId;

    EventAttributeTypeName() {
    }

    EventAttributeTypeName(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getAttrId() {
        return attrId;
    }
}
