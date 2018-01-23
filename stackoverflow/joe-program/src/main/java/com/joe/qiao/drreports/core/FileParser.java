package com.joe.qiao.drreports.core;

import com.joe.qiao.drreports.core.Sectional;

import java.util.List;

/**
 * @author Joe Qiao
 * @Date 22/01/2018.
 */
public interface FileParser {
    boolean parse();
    List<Sectional> getSectionalList();
}
