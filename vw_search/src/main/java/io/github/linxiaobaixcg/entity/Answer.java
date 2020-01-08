package io.github.linxiaobaixcg.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @program: vw
 * @description: 回答实体类
 * @author: LCQ
 * @create: 2020-01-01 13:33
 **/
@Document(indexName = "vw",type = "answer")
public class Answer implements Serializable {
    @Id
    private String id;

    @Field(index= true,type = FieldType.text,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String problemTitle;

    @Field(index= true,type = FieldType.text,analyzer="ik_max_word",searchAnalyzer="ik_max_word")
    private String content;

    /**
     * 是否删除 0否1是
     */
    private Integer isDeleted;
}
