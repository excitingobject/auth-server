package com.excitingobject.auth.user;

import com.excitingobject.auth.AuthSeqGenerator;
import com.excitingobject.auth.role.RoleEntity;
import com.excitingobject.auth.user.account.UserAccountEntity;
import com.excitingobject.common.base.EoConstants;
import com.excitingobject.common.base.api.EoEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = EoConstants.TB_USER)
public class UserEntity extends EoEntity {

    @Id
    @Column(name = K_USER_ID)
    @GenericGenerator(name = AuthSeqGenerator.NAME, strategy = AuthSeqGenerator.STRATEGY, parameters = @Parameter(name = K_TABLE_NAME, value = TB_USER))
    @GeneratedValue(generator = AuthSeqGenerator.NAME)
    private String userId;

    @Column(name = K_ENCODED_PW, columnDefinition = "text", nullable = false)
    private String encodedPw;

    @Column(name = K_CREATE_TIME, nullable = false)
    private Timestamp createTime;

    @ManyToMany
    @JoinTable(name = TB_USER_ROLE,
            joinColumns = @JoinColumn(name = K_USER_ID),
            inverseJoinColumns = @JoinColumn(name = K_ROLE))
    private List<RoleEntity> roleList = new ArrayList<>();

    @OneToMany(mappedBy = K_USER, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserAccountEntity> userAccountList = new ArrayList<>();

    @Override
    protected void initDefaultDto(Map dto) {
        dto.put(K_USER_ID, userId);
    }

}
