// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.domain.entity;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

/**
 * アクセス履歴登録における登録内容を保持するエンティティ．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@Value
@AllArgsConstructor
@Builder
public class UpsAccessHistoryEntity {
    
    /**
     * ApiId．
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
     * 外部IFの送られたリクエスト内容．
     */
    private JsonNode request;
    
    /**
     * 外部IFから返却されたエラーレスポンスの詳細．
     */
    private String errorDetail;
    
    /**
     * 外部IFのレスポンスに付与されたHTTPステータスコード．
     */
    private Integer httpStatus;
    
    /**
     * 更新日時．
     */
    private String updateTime;
    
}
