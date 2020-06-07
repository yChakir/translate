package ma.tiwtiw.translate.service.impl;

import ma.tiwtiw.core.service.impl.BaseMongoTemplateServiceImpl;
import ma.tiwtiw.translate.model.Translation;
import ma.tiwtiw.translate.service.TranslationService;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class TranslationServiceImpl extends
    BaseMongoTemplateServiceImpl<Translation, String> implements TranslationService {

  private final MongoTemplate mongoTemplate;

  public TranslationServiceImpl(MongoTemplate mongoTemplate) {
    super(Translation.class);
    this.mongoTemplate = mongoTemplate;
  }

  @Override
  protected MongoTemplate getMongoTemplate() {
    return mongoTemplate;
  }
}
