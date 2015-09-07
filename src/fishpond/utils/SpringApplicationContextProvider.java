package fishpond.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * <b>尽量别用。</b>
 * <br/>
 * <br/>当bean对象不是以spring的IOC形式创建而又不得不使用到部分bean时，
 * <br/>通过此类获取{@link org.springframework.context.ApplicationContext}再使用{@link #org.springframework.context.ApplicationContext.getBean()}
 * @author zweiwei1987@gmail.com
 *
 */
public class SpringApplicationContextProvider implements
ApplicationContextAware {

	private static ApplicationContext context;

	public static ApplicationContext getApplicationContext(){
		return context;
	}

	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
			this.context = context;
	}
}
