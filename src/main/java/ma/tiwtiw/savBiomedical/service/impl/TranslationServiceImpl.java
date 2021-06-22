package ma.tiwtiw.savBiomedical.service.impl;

import java.util.List;
import ma.tiwtiw.core.service.impl.BaseMongoTemplateServiceImpl;
import ma.tiwtiw.savBiomedical.model.Translation;
import ma.tiwtiw.savBiomedical.service.TranslationService;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
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
    mongoTemplate.indexOps("translation").ensureIndex(new Index("code", Direction.ASC).unique());
    return mongoTemplate;
  }

  @Override
  public List<Translation> findAllByLocale(String locale) {
    Query query = new Query();
    query.addCriteria(new Criteria("labels.locale").is(locale));

    return getMongoTemplate().find(query, Translation.class);
  }
}
