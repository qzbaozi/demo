package com.sfh.bussiness.lottery.service.impl;


import com.sfh.bussiness.lottery.domain.aggregate.DrawLottery;
import com.sfh.bussiness.lottery.domain.valobj.AwardPool;
import com.sfh.bussiness.lottery.repo.DrawLotteryRepository;
import com.sfh.bussiness.lottery.service.LotteryService;

@Service
public class LotteryServiceImpl implements LotteryService {
    @Autowired
    private DrawLotteryRepository drawLotteryRepo;
    @Autowired
    private com.sfh.bussiness.lottery.facade.UserCityInfoFacade UserCityInfoFacade;
    @Autowired
    private AwardSendService awardSendService;
    @Autowired
    private AwardCounterFacade awardCounterFacade;

    @Override
    public IssueResponse issueLottery(LotteryContext lotteryContext) {
        DrawLottery drawLottery = drawLotteryRepo.getDrawLotteryById(lotteryContext.getLotteryId());//获取抽奖配置聚合根
        awardCounterFacade.incrTryCount(lotteryContext);//增加抽奖计数信息
        AwardPool awardPool = lotteryConfig.chooseAwardPool(bulidDrawLotteryContext(drawLottery, lotteryContext));//选中奖池
        Award award = awardPool.randomChooseAward();//选中奖品
        return buildIssueResponse(awardSendService.sendAward(award, lotteryContext));//发出奖品实体
    }

    private IssueResponse buildIssueResponse(AwardSendResponse awardSendResponse) {...}
}
