package com.diswares.breakupledger.backend.helper.notice.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.diswares.breakupledger.backend.enums.NoticeEnums;
import com.diswares.breakupledger.backend.helper.notice.NoticeHandler;
import com.diswares.breakupledger.backend.po.friend.Friend;
import com.diswares.breakupledger.backend.po.ledger.LedgerMember;
import com.diswares.breakupledger.backend.po.notice.Notice;
import com.diswares.breakupledger.backend.service.FriendService;
import com.diswares.breakupledger.backend.service.LedgerMemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 账本邀请
 */
@Component
@RequiredArgsConstructor
public class LedgerInviteNoticeHandler implements NoticeHandler {
    private final LedgerMemberService ledgerMemberService;

    @Override
    public NoticeEnums noticeType() {
        return NoticeEnums.LEDGER_INVITE;
    }

    @Override
    public void agreeCall(Notice notice) {
        JSONObject data = JSON.parseObject(notice.getNoticeData());
        Long ledgerId = data.getLong("ledgerId");
        LedgerMember ledgerMember = new LedgerMember();
        ledgerMember.setLedgerId(ledgerId);
        ledgerMember.setMemberId(notice.getHandlerId());
        ledgerMemberService.save(ledgerMember);
    }

    @Override
    public void disagreeCall(Notice notice) {
        // none
    }
}
