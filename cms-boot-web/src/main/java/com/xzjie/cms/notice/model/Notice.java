package com.xzjie.cms.notice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.xzjie.cms.core.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * @author vito
 * @date : 2022/9/23 1:13 AM
 */
@Data
@Entity
@Where(clause = "state = 1")
@Table(name = "sys_notice")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Notice extends BaseEntity<Notice> {

    @ApiModelProperty("标题")
    private String title;
    @ApiModelProperty("类型(1通知 2公告)")
    private String type;
    @ApiModelProperty("'公告内容'")
    private String content;
    @ApiModelProperty("'状态 1正常，0失败''")
    private Integer state;

    @ApiModelProperty("开始时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @ApiModelProperty("结束时间")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @ApiModelProperty("'创建者'")
    private Long author;

    @ApiModelProperty("修改者")
    private Long modAuthor;

    @ApiModelProperty("创建时间")
    @CreationTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createDate;

    @ApiModelProperty("修改时间")
    @UpdateTimestamp
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;

    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("是否启动")
    private Boolean enabled;

    @Override
    public void copy(Notice obj) {
    }
}
