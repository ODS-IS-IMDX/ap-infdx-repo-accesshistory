// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.domain.entity;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

/**
 * アクセス履歴参照の結果を保持するエンティティ．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/12/03
 */
@Data
public class GetAccessHistoryEntity {
    
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
