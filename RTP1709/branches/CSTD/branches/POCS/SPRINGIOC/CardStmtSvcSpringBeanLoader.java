package org.barclays.process.cardstmtsvc.util;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public final class CardStmtSvcSpringBeanLoader {
    private static ApplicationContext context;
    static {
        try {
            context = new ClassPathXmlApplicationContext("xml/settlement_spring_context.xml");
        } catch (final Exception e) {
        }
    }

    public static Object getBean(final String beanName) {
        return context.getBean(beanName);
    }
}
