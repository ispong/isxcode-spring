package com.isxcode.ispring.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * BaseEntity
 *
 * @author ispong
 * @version v0.1.0
 * @date 2019/10/8
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 对象的uuid
     */
    @Id
    @GeneratedValue(generator = "uuid",strategy = GenerationType.AUTO)
    @GenericGenerator(name = "uuid", strategy = "com.isxcode.ispring.common.BaseUuidGenerator")
    private String uuid;

    /**
     * 创建者
     */
    @JsonIgnore
    @CreatedBy
    private String createdBy;

    /**
     * 创建时间
     */
    @JsonIgnore
    @CreatedDate
    private LocalDateTime createdDate;

    /**
     * 更新者
     */
    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedBy;

    /**
     * 更新时间
     */
    @JsonIgnore
    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    /**
     * 版本号
     */
    @JsonIgnore
    @Version
    private Integer version;
}