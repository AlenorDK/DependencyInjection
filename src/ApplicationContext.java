import properties_parser.Bean;
import properties_parser.BeanProperties;
import properties_parser.PropertiesParser;
import java.util.List;

public class ApplicationContext {

    private static ApplicationContext instance;
    private static String PROPERTIES_FILE_PATH = "E:\\Java\\DependencyInjection\\src\\properties.xml";

    public static ApplicationContext getInstance() {
        return instance;
    }

    static {
        instance = new ApplicationContext();
    }

    public Object getBean(String beanName) throws IllegalAccessException, InstantiationException {
        return BeanFactory.createBean(beanName);
    }

    public void loadProperties() {
        PropertiesParser propertiesParser = new PropertiesParser();
        BeanProperties properties = propertiesParser.parseProperties(PROPERTIES_FILE_PATH);
        List<Bean> beanPropertiesList = properties.getBeansProperties();
        BeanFactory.registerBeans(beanPropertiesList);
    }
}
