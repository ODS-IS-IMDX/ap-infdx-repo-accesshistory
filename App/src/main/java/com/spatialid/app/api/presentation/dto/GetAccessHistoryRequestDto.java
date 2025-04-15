// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.presentation.dto;

import com.spatialid.app.common.constant.RestApiConstants;
import com.spatialid.app.common.validation.CheckAtLeastOneField;
import com.spatialid.app.common.validation.Groups.First;
import com.spatialid.app.common.validation.Groups.Second;
import com.spatialid.app.common.validation.ValidDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * アクセス履歴参照へのリクエストDTOを定義したクラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/12/03
 */
@Value
@AllArgsConstructor
@Builder
@CheckAtLeastOneField(groups = First.class)
public class GetAccessHistoryRequestDto {
    
    /**
     * ApiId．
     */
    private String apiId;
    
    /**
     * 利用者システムID．
     */
    private String servicerId;
    
    /**
     * 履歴参照日時(From)．
     */
    @ValidDate(pattern = RestApiConstants.STRICT_DATE_FORMAT, allowEmpty = false, groups = Second.class)
    private String historyReferenceDateFrom;
    
    /**
     * 履歴参照日時(To)．
     */
    @ValidDate(pattern = RestApiConstants.STRICT_DATE_FORMAT, allowEmpty = false, groups = Second.class)
    private String historyReferenceDateTo;
    
    /**
     * HTTPステータスコード．
     */
    private Integer httpStatus;

}
