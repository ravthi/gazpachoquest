package net.sf.gazpachoquest.questionnair.support;

import java.util.List;

import net.sf.gazpachoquest.domain.core.Breadcrumb;
import net.sf.gazpachoquest.domain.core.Question;
import net.sf.gazpachoquest.domain.core.QuestionBreadcrumb;
import net.sf.gazpachoquest.domain.core.QuestionGroup;
import net.sf.gazpachoquest.domain.core.QuestionGroupBreadcrumb;
import net.sf.gazpachoquest.services.BreadcrumbService;
import net.sf.gazpachoquest.services.QuestionGroupService;
import net.sf.gazpachoquest.services.QuestionService;
import net.sf.gazpachoquest.services.QuestionnaireDefinitionService;
import net.sf.gazpachoquest.types.RandomizationStrategy;
import net.sf.gazpachoquest.types.RenderingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PageMetadataCreatorImpl implements PageMetadataCreator {

    @Autowired
    private QuestionGroupService questionGroupService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private QuestionnaireDefinitionService questionnaireDefinitionService;

    @Autowired
    private BreadcrumbService breadcrumbService;

    @Override
    public PageMetadataStructure create(RandomizationStrategy randomizationStrategy, RenderingMode type,
            Breadcrumb breadcrumb) {
        int position = -1;
        int count = -1;
        if (type.equals(RenderingMode.ALL_IN_ONE)) {
            return PageMetadataStructure.with().count(1).number(1).build();
        }
        if (breadcrumb instanceof QuestionGroupBreadcrumb) {
            QuestionGroup questionGroup = ((QuestionGroupBreadcrumb) breadcrumb).getQuestionGroup();

            if (RandomizationStrategy.NONE.equals(randomizationStrategy)) {
                questionGroup = questionGroupService.findOne(questionGroup.getId());
                position = questionGroupService.positionInQuestionnairDefinition(questionGroup.getId());
                count = questionnaireDefinitionService.questionGroupsCount(questionGroup.getQuestionnairDefinition()
                        .getId());
            } else {
                count = breadcrumbService.countByQuestionnair(breadcrumb.getQuestionnair().getId());
                position = (Integer) breadcrumbService.findLastAndPosition(breadcrumb.getQuestionnair().getId()).get(0)[1];
            }
        } else if (breadcrumb instanceof QuestionBreadcrumb) {
            if (RandomizationStrategy.NONE.equals(randomizationStrategy)) {
                Question question = ((QuestionBreadcrumb) breadcrumb).getQuestion();
                QuestionGroup questionGroup = question.getQuestionGroup();

                Integer questionnairDefinitionId = questionGroup.getQuestionnairDefinition().getId();

                count = questionnaireDefinitionService.questionsCount(questionnairDefinitionId);

                Integer questionGroupId = question.getQuestionGroup().getId();

                Integer positionInQuestionGroup = questionService.findPositionInQuestionGroup(question.getId());

                List<Object[]> counts = questionnaireDefinitionService
                        .questionsCountGroupByQuestionGroups(questionnairDefinitionId);
                Integer positionInQuestionnairDefition = 0;
                for (Object[] objects : counts) {
                    Integer groupId = (Integer) objects[0];
                    if (questionGroupId.equals(groupId)) {
                        break;
                    }
                    positionInQuestionnairDefition += ((Long) objects[1]).intValue();
                }
                position = positionInQuestionnairDefition + positionInQuestionGroup;
            } else {
                count = breadcrumbService.countByQuestionnair(breadcrumb.getQuestionnair().getId());
                position = (Integer) breadcrumbService.findLastAndPosition(breadcrumb.getQuestionnair().getId()).get(0)[1];
            }
        }
        return PageMetadataStructure.with().count(count).number(position + 1).build();
    }

}
