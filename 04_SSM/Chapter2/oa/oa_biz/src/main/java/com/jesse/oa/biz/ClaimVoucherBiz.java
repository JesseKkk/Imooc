package com.jesse.oa.biz;

import com.jesse.oa.entity.ClaimVoucher;
import com.jesse.oa.entity.ClaimVoucherItem;
import com.jesse.oa.entity.DealRecord;

import java.util.List;

/**
 * Created by Kong on 2020/6/6.
 */
public interface ClaimVoucherBiz {

    void save(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    ClaimVoucher get(int id);
    List<ClaimVoucherItem> getItems(int cvid);
    List<DealRecord> getRecords(int civd);

    List<ClaimVoucher> getForSelf(String sn);
    List<ClaimVoucher> getForDeal(String sn);

    void update(ClaimVoucher claimVoucher, List<ClaimVoucherItem> items);

    void submit(int id);

    void deal(DealRecord dealRecord);
}
