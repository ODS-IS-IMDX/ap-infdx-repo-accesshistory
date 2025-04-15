// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.domain.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spatialid.app.api.domain.entity.GetAccessHistoryEntity;
import com.spatialid.app.api.domain.entity.UpsAccessHistoryEntity;
import com.spatialid.app.api.presentation.dto.GetAccessHistoryRequestDto;

/**
 * アクセス履歴のクエリを扱うRepositoryインターフェース．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@Mapper
public interface AccessHistoryRepository {
    
    /**
     * ApiIdの参照を提供する．
     * 
     * @param requestUri 外部APIのリクエストURI
     * @return リクエストURIに対応したApiId
     */
    public String selectApiId(String requestUri);
    
    /**
     * アクセス履歴の登録・更新を提供する．
     * 
     * @param upsAccessHistoryEntity 登録・更新内容を保持したDTO
     * @return 登録・更新件数
     */
    public int upsertAccessHistory(UpsAccessHistoryEntity upsAccessHistoryEntity);
    
    /**
     * アクセス履歴の参照を提供する．
     * 
     * @param getAccessHistoryRequestDto リクエスト内容を保持したDTO
     * @return アクセス履歴参照結果
     */
    public List<GetAccessHistoryEntity> selectAccessHistory(GetAccessHistoryRequestDto getAccessHistoryRequestDto);
    
}
