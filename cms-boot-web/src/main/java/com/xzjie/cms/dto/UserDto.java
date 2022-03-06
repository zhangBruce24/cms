package com.xzjie.cms.dto;

import com.xzjie.cms.model.Account;
import com.xzjie.cms.persistence.annotation.QueryCondition;
import com.xzjie.cms.persistence.enums.ConditionType;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class UserDto extends Dto {
    @NotBlank(groups = {Update.class})
    private String name;
    private String phone;
    private String email;
    private String nickName;
    private String avatar;
    private String sex;
    private LocalDate birtn;
    @NotNull(groups = {Update.class})
    private Integer locked;
    private List<Long> roles;

    public Account toAccount() {
        Account model = new Account();
        BeanUtils.copyProperties(this, model);
        return model;
    }
}
