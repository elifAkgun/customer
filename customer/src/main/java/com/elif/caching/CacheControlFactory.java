package com.elif.caching;

import javax.enterprise.inject.spi.InjectionPoint;
import javax.enterprise.inject.Produces;
import javax.ws.rs.core.CacheControl;

public class CacheControlFactory {

	@Produces
    public CacheControl get(InjectionPoint ip) {
 
        CachControlConfig ccConfig = ip.getAnnotated().getAnnotation(CachControlConfig.class);
        CacheControl cc = null;
        if (ccConfig != null) {
            cc = new CacheControl();
            cc.setMaxAge(ccConfig.maxAge());
            cc.setMustRevalidate(ccConfig.mustRevalidate());
            cc.setNoCache(ccConfig.noCache());
            cc.setNoStore(ccConfig.noStore());
            cc.setNoTransform(ccConfig.noTransform());
            cc.setPrivate(ccConfig.isPrivate());
            cc.setProxyRevalidate(ccConfig.proxyRevalidate());
            cc.setSMaxAge(ccConfig.sMaxAge());
        }
 
        return cc;
    }
}
