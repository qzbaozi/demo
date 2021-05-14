package com.sfh.bussiness.lottery.domain.entity;

import lombok.Data;

import java.util.List;

@Data
public class AwardPool {
         int awardPoolId;
    List<Award> awards;
}
