/*******************************************************************************
 * Copyright (c) 1998, 2008 Oracle. All rights reserved.
 * This program and the accompanying materials are made available under the 
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0 
 * which accompanies this distribution. 
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at 
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/  
package org.eclipse.persistence.testing.tests.performance.java;

import java.util.*;
import org.eclipse.persistence.testing.framework.*;

/**
 * Measure the concurrency of Hashtable.
 */
public class HashtableGetConcurrentTest extends ConcurrentPerformanceComparisonTest {
    protected Hashtable map;
    
    public HashtableGetConcurrentTest() {
        setDescription("Measure the concurrency of Hashtable.");
    }
    
    public void setup() {
        super.setup();
        map = new Hashtable(10);
        for (int index = 0; index < 10; index++) {
            map.put(new Integer(index), new Integer(index));
        }
    }
    
    public void runTask() throws Exception {
        Integer value = (Integer)this.map.get(new Integer(5));
    }
}