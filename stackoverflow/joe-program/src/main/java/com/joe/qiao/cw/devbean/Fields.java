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
@XmlRootElement(name="fields")
public class Fields {
    private List<Field> field;

    public List<Field> getField() {
        return field;
    }

    public void setField(List<Field> field) {
        this.field = field;
    }
  
    
    
}
