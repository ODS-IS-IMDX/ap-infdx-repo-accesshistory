// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.presentation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * アクセス履歴を保持するDTO．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/12/03
 */
@Value
@AllArgsConstructor
@Builder
@JsonInclude(Include.ALWAYS)
public class AccessHistoryDto {
    
    /**
     * ApiId．．
     */
    private String apiId;
    
    /**
     * 利用者システムID．
     */
    private String servicerId;
    
    /**
     * アクセス日時．
     */
    private String accessDate;
    
    /**
     * リクエスト内容．
     */
    private JsonNode request;
    
    /**
     * エラー内容．
     */
    private String errorDetail;
    
    /**
     * HTTPステータスコード．
     */
    private Integer httpStatus;
    
}
