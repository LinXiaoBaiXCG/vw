package io.github.linxiaobaixcg.modules.system.repository;

import io.github.linxiaobaixcg.modules.system.domain.Agree;
import io.github.linxiaobaixcg.modules.system.domain.Answer;
import io.github.linxiaobaixcg.modules.system.domain.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
public interface AnswerRepository extends JpaRepository<Answer, String>, JpaSpecificationExecutor<Answer> {

    /**
     * 修改回答点赞数
     * @param id
     * @param agreeCount
     */
    @Modifying
    @Query(value = "update vw_answer set agree_count = :agreeCount where id = :id",nativeQuery = true)
    void updateAgreeCount(@Param("id") String id,@Param("agreeCount") Long agreeCount);
}