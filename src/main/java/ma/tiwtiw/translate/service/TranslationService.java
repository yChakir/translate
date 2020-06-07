package ma.tiwtiw.translate.service;

import java.util.List;
import ma.tiwtiw.core.service.BaseService;
import ma.tiwtiw.translate.model.Translation;

public interface TranslationService extends BaseService<Translation, String> {

  List<Translation> findAllByLocale(String locale);
}
