// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.application.service;

import java.util.List;

import com.spatialid.app.api.presentation.dto.AccessHistoryDto;
import com.spatialid.app.api.presentation.dto.GetAccessHistoryRequestDto;
import com.spatialid.app.api.presentation.dto.UpsAccessHistoryRequestDto;

/**
 * アクセス履歴の操作を提供するインターフェース．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
public interface IAccessHistoryService {
    
    /**
     * アクセス履歴の登録を提供する．
     * 
     * @param requestDto アクセス履歴登録へのリクエスト
     */
    public void registAccessHistory(UpsAccessHistoryRequestDto requestDto);
    
    /**
     * アクセス履歴の参照を提供する．
     * 
     * @param requestDto アクセス履歴参照へのリクエスト
     * @return アクセス履歴参照結果
     */
    public List<AccessHistoryDto> getAccessHistory(GetAccessHistoryRequestDto requestDto);
    
}
