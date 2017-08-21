package com.taobao.firstbundle.injection.scope;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.inject.Scope;

/**
 * @ Description:
 *
 * Company:重庆中陆承大科技有限公司
 * @ Author king
 * @ Date 2016/7/12 15:14
 * @ Version V1.0
 */

@Documented
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PreFragment {
}
