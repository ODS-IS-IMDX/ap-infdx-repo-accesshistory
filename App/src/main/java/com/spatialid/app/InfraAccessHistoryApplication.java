// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import lombok.extern.log4j.Log4j2;

/**
 * SpringBootのエントリーポイントを定義したクラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
@SpringBootApplication
@Log4j2
public class InfraAccessHistoryApplication {

    /**
     * メインクラス．
     * 
     * @param args 起動引数
     */
    public static void main(String[] args) {
        SpringApplication.run(InfraAccessHistoryApplication.class, args);
        log.info(InfraAccessHistoryApplication.buildStartLog());
    }
    
    /**
     * ログ出力処理<br>
     * <p>
     * 文字コード、クラスパスなどの情報をログ出力するメソッド.<br>
     * <p>
     * 
     * @return String 文字列
     */
    private static String buildStartLog() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
        messageSource.addBasenames("classpath:messages", "classpath:logging");
        return messageSource.getMessage("API_LOG_INFO0001", new Object[] { "アクセス履歴API" }, Locale.JAPAN);
    }
    
}
