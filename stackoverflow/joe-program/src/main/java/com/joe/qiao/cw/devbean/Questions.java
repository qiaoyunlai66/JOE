/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.joe.qiao.cw.devbean;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 *
 * @author Joe Qiao
 */
@XmlRootElement
public class Questions {
    private List<Question> question;

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }
    
}
