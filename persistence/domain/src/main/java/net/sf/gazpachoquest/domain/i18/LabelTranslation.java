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
package net.sf.gazpachoquest.domain.i18;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import net.sf.gazpachoquest.domain.core.Label;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.support.AbstractPersistable;
import net.sf.gazpachoquest.domain.support.Translation;
import net.sf.gazpachoquest.domain.support.TranslationBuilder;
import net.sf.gazpachoquest.types.Language;

@Entity
public class LabelTranslation extends AbstractPersistable implements Translation<LabelLanguageSettings> {

    private static final long serialVersionUID = -7571602125652099550L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Label label;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = true, updatable = true)
    private Language language;

    @Embedded
    private LabelLanguageSettings languageSettings;

    public LabelTranslation() {
        super();
    }

    public Label getLabel() {
        if (label == null) {
            label = new Label();
        }
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    @Override
    public Language getLanguage() {
        return language;
    }

    @Override
    public void setLanguage(Language language) {
        this.language = language;
    }

    @Override
    public LabelLanguageSettings getLanguageSettings() {
        return languageSettings;
    }

    @Override
    public void setLanguageSettings(LabelLanguageSettings languageSettings) {
        this.languageSettings = languageSettings;
    }

    @Override
    public Integer getTranslatedEntityId() {
        return getLabel().getId();
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder implements TranslationBuilder<LabelTranslation, LabelLanguageSettings> {
        private Label label;
        private Language language;
        private LabelLanguageSettings languageSettings;

        public Builder label(Label label) {
            this.label = label;
            return this;
        }

        @Override
        public Builder language(Language language) {
            this.language = language;
            return this;
        }

        @Override
        public Builder languageSettings(LabelLanguageSettings languageSettings) {
            this.languageSettings = languageSettings;
            return this;
        }

        @Override
        public LabelTranslation build() {
            LabelTranslation labelTranslation = new LabelTranslation();
            labelTranslation.label = label;
            labelTranslation.language = language;
            labelTranslation.languageSettings = languageSettings;
            return labelTranslation;
        }

        @Override
        public TranslationBuilder<LabelTranslation, LabelLanguageSettings> translatedEntityId(Integer entityId) {
            return label(Label.with().id(entityId).build());
        }
    }
}
