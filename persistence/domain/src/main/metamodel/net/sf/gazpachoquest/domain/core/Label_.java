package net.sf.gazpachoquest.domain.core;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import net.sf.gazpachoquest.domain.core.LabelSet;
import net.sf.gazpachoquest.domain.core.embeddables.LabelLanguageSettings;
import net.sf.gazpachoquest.domain.i18.LabelTranslation;
import net.sf.gazpachoquest.domain.support.AbstractLocalizable_;
import net.sf.gazpachoquest.types.Language;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2014-10-20T09:44:39")
@StaticMetamodel(Label.class)
public class Label_ extends AbstractLocalizable_ {

    public static volatile SingularAttribute<Label, LabelLanguageSettings> languageSettings;
    public static volatile SingularAttribute<Label, LabelSet> labelSet;
    public static volatile MapAttribute<Label, Language, LabelTranslation> translations;
    public static volatile SingularAttribute<Label, Language> language;

}