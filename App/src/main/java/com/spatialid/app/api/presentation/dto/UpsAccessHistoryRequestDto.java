// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.presentation.dto;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spatialid.app.common.constant.RestApiConstants;
import com.spatialid.app.common.validation.ValidDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

/**
 * アクセス履歴登録へのリクエストDTOを定義したクラス．<br>
 * アクセス履歴登録APIは、登録・更新の処理を一本化しているため本DTOのみで対応する．<br>
 * リクエスト内容はDB上で必須 かつ 登録時にnullのケースも存在するため空のデフォルト値を設定する．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class UpsAccessHistoryRequestDto {
    
    /**
     * リクエストURI．
     */
    @NotBlank
    private String requestUri;
    
    /**
     * 利用者システムID．
     */
    @NotBlank
    @Size(max = 20)
    private String servicerId;
    
    /**
     * アクセス日時．
     */
    @NotBlank
    @ValidDate(pattern = RestApiConstants.HIGH_ACCURACY_DATE_FORMAT)
    private String accessDate;
    
    /**
     * 外部IFの送られたリクエスト内容．
     */
    @Builder.Default
    private JsonNode request = new ObjectMapper().createObjectNode();
    
    /**
     * 外部IFから返却されたエラーレスポンスの詳細．
     */
    private String errorDetail;
    
    /**
     * 外部IFのレスポンスに付与されたHTTPステータスコード．
     */
    private Integer httpStatus;
    
}
