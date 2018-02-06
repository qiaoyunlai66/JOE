package com.joe.qiao.cw.incbean;


import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Created by Joe Qiao on 2017/5/3.
 */
public class Note {
    private Integer id;
    private Integer ticketId;
    private String text;
    private Boolean detailDescriptionFlag;
    private Boolean internalAnalysisFlag;
    private Boolean resolutionFlag;
    private String dateCreated;
    private String createdBy;
    private Boolean internalFlag;
    private Boolean externalFlag;
    private Note note;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getDetailDescriptionFlag() {
        return detailDescriptionFlag;
    }

    public void setDetailDescriptionFlag(Boolean detailDescriptionFlag) {
        this.detailDescriptionFlag = detailDescriptionFlag;
    }

    public Boolean getInternalAnalysisFlag() {
        return internalAnalysisFlag;
    }

    public void setInternalAnalysisFlag(Boolean internalAnalysisFlag) {
        this.internalAnalysisFlag = internalAnalysisFlag;
    }

    public Boolean getResolutionFlag() {
        return resolutionFlag;
    }

    public void setResolutionFlag(Boolean resolutionFlag) {
        this.resolutionFlag = resolutionFlag;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Boolean getInternalFlag() {
        return internalFlag;
    }

    public void setInternalFlag(Boolean internalFlag) {
        this.internalFlag = internalFlag;
    }

    public Boolean getExternalFlag() {
        return externalFlag;
    }

    public void setExternalFlag(Boolean externalFlag) {
        this.externalFlag = externalFlag;
    }
    @JsonPropertyOrder ("_info")
    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }
}
