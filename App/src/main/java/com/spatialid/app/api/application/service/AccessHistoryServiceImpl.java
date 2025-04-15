// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.application.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spatialid.app.api.domain.entity.GetAccessHistoryEntity;
import com.spatialid.app.api.domain.entity.UpsAccessHistoryEntity;
import com.spatialid.app.api.domain.repository.AccessHistoryRepository;
import com.spatialid.app.api.presentation.dto.AccessHistoryDto;
import com.spatialid.app.api.presentation.dto.GetAccessHistoryRequestDto;
import com.spatialid.app.api.presentation.dto.UpsAccessHistoryRequestDto;
import com.spatialid.app.common.constant.RestApiConstants;
import com.spatialid.app.common.exception.subexception.UriNotFoundException;

/**
 * アクセス履歴の操作を実装するサービスクラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@Service
public class AccessHistoryServiceImpl implements IAccessHistoryService {
    
    /**
     * アクセス履歴の操作を提供するリポジトリクラス．
     */
    private final AccessHistoryRepository accessHistoryRepository;
    
    public AccessHistoryServiceImpl(AccessHistoryRepository accessHistoryRepository) {
        
        this.accessHistoryRepository = accessHistoryRepository;
        
    }
    
    /**
     * アクセス履歴の登録を行う．
     * <p>
     * 登録・更新を1本化するため、アクセス履歴テーブルに対してInsertではなくUpsertを行う．
     * </p>
     * 
     * @param requestDto アクセス履歴登録へのリクエスト
     */
    @Override
    public void registAccessHistory(UpsAccessHistoryRequestDto requestDto) {
        
        final String apiId = accessHistoryRepository.selectApiId(requestDto.getRequestUri());
        
        if (apiId == null) {
            
            throw new UriNotFoundException();
            
        }
        
        final UpsAccessHistoryEntity upsAccessHistoryEntity = UpsAccessHistoryEntity.builder()
                .apiId(apiId)
                .servicerId(requestDto.getServicerId())
                .accessDate(requestDto.getAccessDate())
                .request(requestDto.getRequest())
                .errorDetail(requestDto.getErrorDetail())
                .httpStatus(requestDto.getHttpStatus())
                .updateTime(getNowAsString())
                .build();
        
        accessHistoryRepository.upsertAccessHistory(upsAccessHistoryEntity);
        
    }
    
    /**
     * アクセス履歴の参照を行う．
     * 
     * @param requestDto アクセス履歴参照へのリクエスト
     * @return アクセス履歴参照結果
     */
    @Override
    public List<AccessHistoryDto> getAccessHistory(GetAccessHistoryRequestDto requestDto) {
        
        final List<GetAccessHistoryEntity> getAccessHistoryEntityList = accessHistoryRepository.selectAccessHistory(requestDto);
        
        return getAccessHistoryEntityList.stream()
                .map(accessHistoryEntity -> AccessHistoryDto.builder()
                        .apiId(accessHistoryEntity.getApiId())
                        .servicerId(accessHistoryEntity.getServicerId())
                        .accessDate(accessHistoryEntity.getAccessDate())
                        .request(accessHistoryEntity.getRequest())
                        .errorDetail(accessHistoryEntity.getErrorDetail())
                        .httpStatus(accessHistoryEntity.getHttpStatus())
                        .build())
                .collect(Collectors.toList());
        
    }
    
    /**
     * 現在時刻を文字列型で返却する．
     * <p>
     * フォーマットは{@link RestApiConstants#STRICT_DATE_FORMAT}を使用する．
     * </p>
     * 
     * @return 文字列型の現在時刻
     */
    private String getNowAsString() {
        
        final LocalDateTime now = LocalDateTime.now();
        
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(RestApiConstants.STRICT_DATE_FORMAT);
        
        return now.format(formatter);
        
    }
    
}
