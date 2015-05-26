/**
 * 
 */
package relationship.building.interceptor;

import org.aopalliance.intercept.MethodInvocation;
import org.apache.log4j.Logger;
import org.seasar.framework.aop.interceptors.AbstractInterceptor;

/**
 * エラー時にエラー画面を出力するインターセプター
 * 
 * @author furuhashitomoki
 *
 */
public class ExceptionInterceptor extends AbstractInterceptor {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger
			.getLogger(ExceptionInterceptor.class);

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		try {
			return invocation.proceed();

		} catch (Exception e) {

			logger.error("エラーが発生しました", e);
			return "/error.jsp";
		}

	}

}
