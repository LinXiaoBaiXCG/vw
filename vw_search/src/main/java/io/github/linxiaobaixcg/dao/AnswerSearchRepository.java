package io.github.linxiaobaixcg.dao;

import io.github.linxiaobaixcg.entity.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AnswerSearchRepository extends ElasticsearchRepository<Answer,String> {

    Page<Answer> findByProblemTitleOrContent(String title, String content, Pageable pageable);
}