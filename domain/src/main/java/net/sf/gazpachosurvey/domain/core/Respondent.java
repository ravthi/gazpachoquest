package net.sf.gazpachosurvey.domain.core;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachosurvey.domain.support.AbstractPersistable;

import org.joda.time.DateTime;
import org.joda.time.contrib.jpa.DateTimeConverter;

@Entity
public class Respondent extends AbstractPersistable {

    private static final long serialVersionUID = -5466079670655149390L;

    @ManyToOne(fetch = FetchType.LAZY)
    private Survey survey;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private SurveyRunning surveyRunning;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime submitDate;

    @Column(columnDefinition = "timestamp")
    @Convert(converter = DateTimeConverter.class)
    private DateTime startDate;

    private String ipAddress;

    public Respondent() {
        super();
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }


    public SurveyRunning getSurveyRunning() {
        return surveyRunning;
    }


    public void setSurveyRunning(SurveyRunning surveyRunning) {
        this.surveyRunning = surveyRunning;
    }


    public DateTime getSubmitDate() {
        return submitDate;
    }


    public void setSubmitDate(DateTime submitDate) {
        this.submitDate = submitDate;
    }


    public DateTime getStartDate() {
        return startDate;
    }


    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }


    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }


}
