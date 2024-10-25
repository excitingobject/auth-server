package com.excitingobject.auth.user.account;

import com.excitingobject.auth.user.UserEntity;
import com.excitingobject.common.base.EoConstants;
import com.excitingobject.common.base.api.EoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

@Data
@Entity
@Table(name = EoConstants.TB_USER_ACCOUNT)
public class UserAccountEntity extends EoEntity {

    @Id
    @Column(name = K_EMAIL)
    private String email;

    @ManyToOne
    @JoinColumn(name = K_USER_ID, nullable = false)
    private UserEntity user;

    @Override
    protected void initDefaultDto(Map dto) {

    }
}
