package com.joe.qiao.oozinoz.oozinoz.testing;

/*
 * Copyright (c) 2001, 2005. Steven J. Metsker.
 * 
 * Steve Metsker makes no representations or warranties about
 * the fitness of this software for any particular purpose, 
 * including the implied warranty of merchantability.
 *
 * Please use this software as you wish with the sole
 * restriction that you may not claim that you wrote it.
 */

import com.joe.qiao.oozinoz.oozinoz.chemical.ChemicalFactory;
import com.joe.qiao.oozinoz.oozinoz.chemical2.ChemicalFactory2;
import junit.framework.TestCase;

public class ChemicalFactoryTest extends TestCase {
    public void testGetFactory() {
        assertEquals("Carbon(C)[12.0]", ChemicalFactory.getChemical("CARBON").toString());
    }
    
    public void testChemicalFactory2() {
        assertEquals("Carbon(C)[12.0]", ChemicalFactory2.getChemical("CARBON").toString());
    }
}
