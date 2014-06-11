/*******************************************************************************
 * Copyright (c) 2014 antoniomariasanchez at gmail.com.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors:
 *     antoniomaria - initial API and implementation
 ******************************************************************************/
/*
 * ; * Copyright 2012 JAXIO http://www.jaxio.com Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions and limitations under the
 * License.
 */
package net.sf.gazpachoquest.qbe.support;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

/**
 * Used to construct OR predicate for a property value. In other words you can
 * search all entities E having a given
 * property set to one of the selected values.
 */
public class PropertySelector<E, F> {

    /**
     * {@link PropertySelector} builder
     */
    static public <E, F> PropertySelector<E, F> property(final SingularAttribute<E, F> field, final F... values) {
        return new PropertySelector<E, F>(field, values);
    }

    private final SingularAttribute<E, F> field;

    private List<F> selected = new ArrayList<F>();

    /**
     * @param field
     *            the property that should match one of the selected value.
     */
    public PropertySelector(final SingularAttribute<E, F> field, final F... values) {
        this.field = field;
        for (F value : values) {
            selected.add(value);
        }
    }

    public void clearSelected() {
        if (selected != null) {
            selected.clear();
        }
    }

    public SingularAttribute<E, F> getField() {
        return field;
    }

    /**
     * Get the possible candidates for property.
     */
    public List<F> getSelected() {
        return selected;
    }

    public boolean isBoolean() {
        return field != null && field.getJavaType().isAssignableFrom(Boolean.class);
    }

    public boolean isNotEmpty() {
        return selected != null && !selected.isEmpty();
    }

    /**
     * Set the possible candidates for property.
     */
    public void setSelected(final List<F> selected) {
        this.selected = selected;
    }

    public PropertySelector<E, F> value(final F v) {
        selected.add(v);
        return this;
    }
}
