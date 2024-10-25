package com.excitingobject.auth.role;

import com.excitingobject.auth.user.UserEntity;
import com.excitingobject.common.base.EoConstants;
import com.excitingobject.common.base.api.EoEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = EoConstants.TB_ROLE)
public class RoleEntity extends EoEntity {

    @Id
    @Column(name = K_ROLE)
    private String role;

    @ManyToMany(mappedBy = K_ROLE_LIST, cascade = CascadeType.REMOVE)
    private List<UserEntity> userList = new ArrayList<>();

    @Override
    protected void initDefaultDto(Map dto) {
        dto.put(K_ROLE, role);
    }
}
