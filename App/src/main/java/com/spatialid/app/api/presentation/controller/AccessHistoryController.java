// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app.api.presentation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spatialid.app.api.application.service.IAccessHistoryService;
import com.spatialid.app.api.constants.AccessHistoryConstants;
import com.spatialid.app.api.presentation.dto.GetAccessHistoryRequestDto;
import com.spatialid.app.api.presentation.dto.GetAccessHistoryResponseDto;
import com.spatialid.app.api.presentation.dto.UpsAccessHistoryRequestDto;
import com.spatialid.app.common.exception.subexception.ParamErrorException;
import com.spatialid.app.common.validation.Sequence;

/**
 * アクセス履歴のエンドポイントを定義したコントローラークラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@RestController
@RequestMapping(AccessHistoryConstants.BASE_URI)
public class AccessHistoryController {
    
    /**
     * アクセス履歴に関する操作を行うサービスクラス．
     */
    private final IAccessHistoryService accessHistoryService;
    
    public AccessHistoryController(IAccessHistoryService accessHistoryService) {
        
        this.accessHistoryService = accessHistoryService;
        
    }
    
    /**
     * アクセス履歴登録のエンドポイントを定義する．
     * <p>
     * アクセス履歴登録結果は、ステータスコード204で返却される．
     * </p>
     * 
     * @param requestDto アクセス履歴登録のリクエストDto
     * @param br バリデーション結果を格納したオブジェクト
     * @return アクセス履歴登録結果
     */
    @PostMapping(AccessHistoryConstants.REGIST_ACCESS_HISTORY_URI)
    public ResponseEntity<Void> regAccessHistory(@Validated @RequestBody UpsAccessHistoryRequestDto requestDto,
            BindingResult br) throws Exception{
        
        if (br.hasErrors()) {
            
            throw new ParamErrorException(br);
            
        }
        
        accessHistoryService.registAccessHistory(requestDto);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }
    
    /**
     * アクセス履歴参照のエンドポイントを定義する．
     * 
     * @param requestDto アクセス履歴参照のリクエストDto
     * @param br バリデーション結果を格納したオブジェクト
     * @return アクセス履歴参照結果
     */
    @PostMapping(AccessHistoryConstants.GET_ACCESS_HISTORY_URI)
    public ResponseEntity<GetAccessHistoryResponseDto> getAccessHistory(@Validated(Sequence.class) @RequestBody GetAccessHistoryRequestDto requestDto,
            BindingResult br) {
        
        if (br.hasErrors()) {
            
            throw new ParamErrorException(br);
            
        }
        
        final GetAccessHistoryResponseDto responseDto = GetAccessHistoryResponseDto.builder()
                .axsHistoriesList(accessHistoryService.getAccessHistory(requestDto))
                .build();
        
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
        
    }
    
}
