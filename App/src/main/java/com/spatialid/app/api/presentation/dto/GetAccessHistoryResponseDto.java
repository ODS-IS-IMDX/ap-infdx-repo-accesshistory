// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.presentation.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * アクセス履歴参照のレスポンスDTOを定義したクラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/12/03
 */
@Value
@AllArgsConstructor
@Builder
public class GetAccessHistoryResponseDto {
    
    /**
     * アクセス履歴のリスト．
     */
    private List<AccessHistoryDto> axsHistoriesList;

}
