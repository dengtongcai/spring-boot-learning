package me.datoucai.external.config.converter;

/**
 * ??????????
 * @author cc
 * @date 2019/1/17
 */
public class ExternalConfigConverter {
   /* @Bean
    public ConversionService getConverterService() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        HashSet<Converter> converters = new HashSet<>();
        converters.add(new ConfigConverter());
        bean.setConverters(converters); //add converters
        bean.afterPropertiesSet();
        return bean.getObject();

    }

    @Component
    class ConfigConverter implements Converter<String, Integer> {
        @Override
        public Integer convert(String s) {
            return Integer.parseInt(s);
        }
    }*/
    /*
    方法二
    @Bean
    public ConversionService conversionService() {
        FormattingConversionServiceFactoryBean factory = new FormattingConversionServiceFactoryBean();
        DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
        registrar.setUseIsoFormat(true);
        factory.setFormatterRegistrars(Collections.singleton(registrar));
        factory.afterPropertiesSet();
        return factory.getObject();
    }
    */
}
