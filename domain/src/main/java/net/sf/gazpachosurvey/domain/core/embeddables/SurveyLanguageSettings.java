package net.sf.gazpachosurvey.domain.core.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Lob;

import net.sf.gazpachosurvey.domain.support.LanguageSettings;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

@Embeddable
public class SurveyLanguageSettings implements LanguageSettings {

    private String title;

    @Lob
    private String description;

    @Lob
    private String welcomeText;

    public SurveyLanguageSettings() {
        super();
    }

    public SurveyLanguageSettings(String title, String description,
            String welcomeText) {
        super();
        this.title = title;
        this.description = description;
        this.welcomeText = welcomeText;
    }

    public SurveyLanguageSettings(Builder builder) {
        super();
        title = builder.title;
        description = builder.description;
        welcomeText = builder.welcomeText;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWelcomeText() {
        return welcomeText;
    }

    public void setWelcomeText(String welcomeText) {
        this.welcomeText = welcomeText;
    }

    public static Builder with() {
        return new Builder();
    }

    public static class Builder {
        private String title;

        private String description;

        private String welcomeText;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder welcomeText(String welcomeText) {
            this.welcomeText = welcomeText;
            return this;
        }

        public SurveyLanguageSettings build() {
            return new SurveyLanguageSettings(this);
        }
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof SurveyLanguageSettings) {
            final SurveyLanguageSettings other = (SurveyLanguageSettings) obj;
            return EqualsBuilder.reflectionEquals(this, other);
        } else {
            return false;
        }
    }
}
