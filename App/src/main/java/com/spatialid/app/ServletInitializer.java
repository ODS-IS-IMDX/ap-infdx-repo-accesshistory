// © 2025 NTT DATA Japan Co., Ltd. & NTT InfraNet All Rights Reserved.

package com.spatialid.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * {@link SpringBootServletInitializer}の実装クラス．
 * 
 * @author matsumoto kentaro
 * @version 1.1 2024/11/27
 */
public class ServletInitializer extends SpringBootServletInitializer {

    public ServletInitializer() {
    }

    /**
     * 外部Tomcatからエントリーポイントを起動する．
     * 
     * @param application {@link SpringApplicationBuilder}
     * @return SpringApplicationBuilder {@link SpringApplicationBuilder}
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(InfraAccessHistoryApplication.class);
    }

}