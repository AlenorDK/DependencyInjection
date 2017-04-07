import annotation.Autowired;
import properties_parser.Bean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alenor on 10.03.2017.
 */
public final class BeanFactory {

    private static Map<String, String> beanImplMap = new HashMap<>();
    private static Map<String, Object> beanMap = new HashMap<>();

    public static void registerBeans(List<Bean> beans) {
        for (Bean bean : beans) {
            beanImplMap.put(bean.getClassName(), bean.getBeanClass());
        }
    }

    public static Object createBean(String beanName)
            throws IllegalAccessException, InstantiationException {
        String beanImplClass = beanImplMap.get(beanName);
        Object bean = beanMap.get(beanImplClass);
        if (bean == null) {
            bean = getBean(beanName);
        }
        return bean;
    }

    private static Object getBean(String beanName) throws InstantiationException, IllegalAccessException {
        try {
            Class<?> clazz = Class.forName(beanName);
            Object classInstance = clazz.newInstance();
            inject(clazz, classInstance);
            beanMap.put(beanName, classInstance);
            return classInstance;
        } catch (ClassNotFoundException e) {
            System.err.println("Class with name " + e.getMessage() + " doesn't exist. Check your properties file");
        }
        return null;
    }

    private static void inject(Class<?> clazz, Object classInstance) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);

                String fieldClassName = field.getType().getName();
                String fieldClassImplName = beanImplMap.get(fieldClassName);
                Object bean = getBean(fieldClassImplName);
                field.set(classInstance, bean);
            }
        }
    }
}
