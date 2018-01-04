package com.joe.qiao.cw.devbean;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Joe Qiao on 2017/5/9.
 */
@XmlRootElement(name="config")
public class Device {
    private String id;
    private String exOrg;
    private Fields fields;
    private Questions questions;
    private String userForCw;
    private String domainForCw;
    private String boardForCw;
    private String passwordForCw;
    private Integer coIdForCw;
    private Integer vcIdForCw;
    private String src;
    private Map<String,String> fieldMap;
    private Map<String,String> questionMap;

    public Map<String, String> getFieldMap() {
        return fieldMap;
    }

    public void setFieldMap(Map<String, String> fieldMap) {
        this.fieldMap = fieldMap;
    }

    public Map<String, String> getQuestionMap() {
        return questionMap;
    }

    public void setQuestionMap(Map<String, String> questionMap) {
        this.questionMap = questionMap;
    }

    public Fields getFields() {
        return fields;
    }

    public void setFields(Fields fields) {
        this.fields = fields;
    }

    public Questions getQuestions() {
        return questions;
    }

    public void setQuestions(Questions questions) {
        this.questions = questions;
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

    public Integer getCoIdForCw() {
        return coIdForCw;
    }

    public void setCoIdForCw(Integer coIdForCw) {
        this.coIdForCw = coIdForCw;
    }

    public Integer getVcIdForCw() {
        return vcIdForCw;
    }

    public void setVcIdForCw(Integer vcIdForCw) {
        this.vcIdForCw = vcIdForCw;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void putFieldMap(String key,String value){
        if(fieldMap==null){
            fieldMap=new HashMap<>();
        }
        fieldMap.put(key,value);
    }

    public String getId() {
        return id;
    }
@XmlAttribute
    public void setId(String id) {
        this.id = id;
    }
@XmlAttribute
    public String getExOrg() {
        return exOrg;
    }

    public void setExOrg(String exOrg) {
        this.exOrg = exOrg;
    }


    public void putQuestionMap(String id, String value) {
        if(questionMap==null){
            questionMap=new HashMap<>();
        }
        questionMap.put(id,value);
    }
}
