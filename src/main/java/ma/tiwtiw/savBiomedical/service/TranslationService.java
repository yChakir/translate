package ma.tiwtiw.savBiomedical.service;

import java.util.List;
import ma.tiwtiw.core.service.BaseService;
import ma.tiwtiw.savBiomedical.model.Translation;

public interface TranslationService extends BaseService<Translation, String> {

  List<Translation> findAllByLocale(String locale);
}
