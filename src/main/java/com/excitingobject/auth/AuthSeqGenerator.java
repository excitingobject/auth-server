package com.excitingobject.auth;

import com.excitingobject.common.base.EoConstants;
import com.excitingobject.common.base.api.sequences.SeqEntity;
import com.excitingobject.common.base.api.sequences.SeqGenerator;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthSeqGenerator extends SeqGenerator {

    public static final String NAME = "AuthSeqGenerator";
    public static final String STRATEGY = "com.excitingobject.auth.AuthSeqGenerator";

    @Override
    protected void initList(List<SeqEntity> list) {
        list.add(new SeqEntity(EoConstants.TB_ROLE, "RL"));
        list.add(new SeqEntity(EoConstants.TB_USER, "U"));
    }
}
