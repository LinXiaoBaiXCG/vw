package io.github.linxiaobaixcg.service;

import io.github.linxiaobaixcg.dao.AnswerSearchRepository;
import io.github.linxiaobaixcg.entity.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @program: vw
 * @description:
 * @author: LCQ
 * @create: 2020-01-01 13:44
 **/
@Service
public class AnswerSearchService {

    @Autowired
    private AnswerSearchRepository answerSearchRepository;

    public Page<Answer> findByTitleLike(String keywords, Pageable pageable)
    {
        return answerSearchRepository.findByProblemTitleOrContent(keywords,keywords, pageable);
    }
}
