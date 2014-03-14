/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com Source code generated by Celerio, a Jaxio product Want to use Celerio
 * within your company? email us at info@jaxio.com Follow us on twitter: @springfuse Template
 * pack-backend-sd:src/main/java/project/repository/support/Range.p.vm.java
 */
package org.itim.smsgateway.qbe;

import java.io.Serializable;

import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;

/**
 * Range support for {@link Comparable} types.
 */
public class Range<E, D extends Comparable<? super D>> implements Serializable {
    private static final long serialVersionUID = 1L;

    private SingularAttribute<E, D> field;
    private D from;
    private Boolean includeNull;
    private D to;

    /**
     * Constructs a new Range by copy.
     */
    public Range(final Range<E, D> other) {
        this.field = other.getField();
        this.from = other.getFrom();
        this.to = other.getTo();
        this.includeNull = other.getIncludeNull();
    }

    /**
     * Constructs a new {@link Range} with no boundaries and no restrictions on field's nullability.
     * 
     * @param field
     *            the attribute of an existing entity.
     */
    public Range(final SingularAttribute<E, D> field) {
        this.field = field;
    }

    /**
     * Constructs a new Range.
     * 
     * @param field
     *            the property's name of an existing entity.
     * @param from
     *            the lower boundary of this range. Null means no lower boundary.
     * @param to
     *            the upper boundary of this range. Null means no upper boundary.
     */
    public Range(final SingularAttribute<E, D> field, final D from, final D to) {
        this.field = field;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructs a new Range.
     * 
     * @param field
     *            an entity's attribute
     * @param from
     *            the lower boundary of this range. Null means no lower boundary.
     * @param to
     *            the upper boundary of this range. Null means no upper boundary.
     * @param includeNull
     *            tells whether null should be filtered out or not.
     */
    public Range(final SingularAttribute<E, D> field, final D from, final D to, final Boolean includeNull) {
        this.field = field;
        this.from = from;
        this.to = to;
        this.includeNull = includeNull;
    }

    /**
     * @return the entity's attribute this {@link Range} refers to.
     */
    public SingularAttribute<E, D> getField() {
        return field;
    }

    /**
     * @return the lower range boundary or null for unbound lower range.
     */
    public D getFrom() {
        return from;
    }

    public Boolean getIncludeNull() {
        return includeNull;
    }

    /**
     * @return the upper range boundary or null for unbound upper range.
     */
    public D getTo() {
        return to;
    }

    public boolean isBetween() {
        return isFromSet() && isToSet();
    }

    public boolean isFromSet() {
        return getFrom() != null;
    }

    public boolean isIncludeNullSet() {
        return includeNull != null;
    }

    public boolean isSet() {
        return isFromSet() || isToSet() || isIncludeNullSet();
    }

    public boolean isToSet() {
        return getTo() != null;
    }

    public boolean isValid() {
        if (isBetween()) {
            return getFrom().compareTo(getTo()) <= 0;
        }

        return true;
    }

    /**
     * Sets the lower range boundary. Accepts null for unbound lower range.
     */
    public void setFrom(final D from) {
        this.from = from;
    }

    public void setIncludeNull(final boolean includeNull) {
        this.includeNull = includeNull;
    }

    /**
     * Sets the upper range boundary. Accepts null for unbound upper range.
     */
    public void setTo(final D to) {
        this.to = to;
    }

    public Specification<E> toSpecification() {
        return RangeSpecification.toSpecification(this);
    }
}