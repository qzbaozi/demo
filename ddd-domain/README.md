# 项目简介
##领域驱动设计 DDD（Domain-Driven Design）

理论地址：[美团实践理论](https://tech.meituan.com/2017/12/22/ddd-in-practice.html)



##场景：抽奖

模块：

    import com.company.team.com.sfh.bussiness.lottery.*;//抽奖上下文
    import com.company.team.com.sfh.bussiness.riskcontrol.*;//风控上下文
    import com.company.team.com.sfh.bussiness.counter.*;//计数上下文
    import com.company.team.com.sfh.bussiness.condition.*;//活动准入上下文
    import com.company.team.com.sfh.bussiness.stock.*;//库存上下文

模块内结构：

    import com.company.team.com.sfh.bussiness.lottery.domain.valobj.*;//领域对象-值对象
    import com.company.team.com.sfh.bussiness.lottery.domain.entity.*;//领域对象-实体
    import com.company.team.com.sfh.bussiness.lottery.domain.aggregate.*;//领域对象-聚合根
    import com.company.team.com.sfh.bussiness.lottery.service.*;//领域服务
    import com.company.team.com.sfh.bussiness.lottery.repo.*;//领域资源库
    import com.company.team.com.sfh.bussiness.lottery.facade.*;//领域防腐层