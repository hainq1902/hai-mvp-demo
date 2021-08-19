package com.mvp.product.configuration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mvp.product.repository.AttributeRepository;
import com.mvp.product.repository.AttributeValueRepository;
import com.mvp.product.repository.ProductRepository;
import com.mvp.product.repository.ProductTypeRepository;
import com.mvp.product.repository.model.Attribute;
import com.mvp.product.repository.model.AttributeValue;
import com.mvp.product.repository.model.Product;
import com.mvp.product.repository.model.ProductType;
import com.mvp.product.util.DataUtil;

@Configuration
public class DatabaseConfig {


    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

    @Bean
    public CommandLineRunner initDatabase(ProductRepository productRepository, ProductTypeRepository productTypeRepository,
                                          AttributeRepository attributeRepository,
                                          AttributeValueRepository attributeValueRepository) {

        return args -> {
            final List<AttributeValue> nameValues = DataUtil.buildNameValues();

            final List<AttributeValue> descriptionValues = DataUtil.buildDescriptionalues();

            final List<AttributeValue> categoryValues = DataUtil.buildCategoryValues();

            final List<AttributeValue> priceValues = DataUtil.buildPriceValues();

            final List<AttributeValue> brandValues = DataUtil.buildBrandValues();

            final List<AttributeValue> colourValues = DataUtil.buildColourValues();

            final List<Attribute> attributes = attributeRepository.saveAll(DataUtil.buildAttributes(nameValues,
                    descriptionValues, categoryValues, priceValues, brandValues, colourValues));

            log.info(">>>> Insert attributes");
            attributeRepository.saveAll(attributes);

            final ProductType productType = DataUtil.buildHeadphoneProductType(nameValues,
                    descriptionValues, categoryValues, priceValues, brandValues, colourValues);

            log.info(">>>> Insert productType");
            productTypeRepository.save(productType);

            final List<Product> products = DataUtil.buildHeadphoneProduct(productType, nameValues,
                    descriptionValues, categoryValues, priceValues, brandValues, colourValues);

            log.info(">>>> Insert products");
            productRepository.saveAll(products);
        };
    }
}
