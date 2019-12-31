package io.github.linxiaobaixcg.modules.system.repository;

import io.github.linxiaobaixcg.modules.system.domain.Agree;
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
public interface AgreeRepository extends JpaRepository<Agree, String>, JpaSpecificationExecutor<Agree> {

    Agree findByUserIdAndAnswerId(String userId, String answerId);

    /**
     * 修改状态
     * @param id
     * @param status
     */
    @Modifying
    @Query(value = "update vw_agree set status = :status where id = :id",nativeQuery = true)
    void update(@Param("id")String id, @Param("status")Integer status);
}