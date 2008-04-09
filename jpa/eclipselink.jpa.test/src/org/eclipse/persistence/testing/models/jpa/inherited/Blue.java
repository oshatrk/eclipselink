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
package org.eclipse.persistence.testing.models.jpa.inherited;

import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.eclipse.persistence.indirection.ValueHolderInterface;

@Entity
@Table(name="CMP3_BLUE")
public class Blue extends Beer  {
    public ValueHolderInterface ignoredObject;
    private Integer uniqueKey;
    public Blue() {}
    
    // This class is intentionally left with no annotations to test that
    // it picks us the access type from the mapped superclass.
    
    public boolean equals(Object anotherBlue) {
        if (anotherBlue.getClass() != Blue.class) {
            return false;
        }
        
        return (getId().equals(((Blue)anotherBlue).getId()));
    }
    
    // Mimicking an accessor that was weaved to have value holders ... the 
    // metadata processing should ignore this mapping.
    
    @OneToOne
    public ValueHolderInterface getIgnoredObject() {
        return ignoredObject;
    }
    
    public void setIgnoredObject(ValueHolderInterface ignoredObject) {
        this.ignoredObject = ignoredObject;
    }
    
    public Integer getUniqueKey() {
        return uniqueKey;
    }
    
    public void setUniqueKey(Integer uniqueKey) {
        this.uniqueKey = uniqueKey;
    }
}
