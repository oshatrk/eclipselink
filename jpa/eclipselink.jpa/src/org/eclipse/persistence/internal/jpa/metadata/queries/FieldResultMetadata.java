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
package org.eclipse.persistence.internal.jpa.metadata.queries;

import java.lang.annotation.Annotation;

/**
 * INTERNAL:
 * Object to hold onto an field result metadata.
 * 
 * @author Guy Pelletier
 * @since TopLink EJB 3.0 Reference Implementation
 */
public class FieldResultMetadata {
	// Both the name and column are required in XML and annotations.
	private String m_name;
	private String m_column;
    
    /**
     * INTERNAL:
     */
    public FieldResultMetadata() {}

    /**
     * INTERNAL:
     */
    public FieldResultMetadata(Annotation fieldResult) {
    	m_name = (String) MetadataHelper.invokeMethod("name", fieldResult);
    	m_column = (String) MetadataHelper.invokeMethod("column", fieldResult);
    }
    
    /**
     * INTERNAL:
     * Used for OX mapping.
     */
    public String getColumn() {
        return m_column;
    }
    
    /**
     * INTERNAL:
     * Used for OX mapping.
     */
    public String getName() {
        return m_name;
    }
    
    /**
     * INTERNAL:
     * Used for OX mapping.
     */
    public void setColumn(String column) {
    	m_column = column;
    }
    
    /**
     * INTERNAL:
     * Used for OX mapping.
     */
    public void setName(String name) {
    	m_name = name;
    }
}
