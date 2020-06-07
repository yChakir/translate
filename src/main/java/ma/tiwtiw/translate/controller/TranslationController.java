package ma.tiwtiw.translate.controller;

import ma.tiwtiw.core.controller.impl.BaseRestController;
import ma.tiwtiw.translate.dto.TranslationDto;
import ma.tiwtiw.translate.model.Translation;
import ma.tiwtiw.translate.service.TranslationService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("translations")
public class TranslationController extends BaseRestController<Translation, TranslationDto, String> {

  private final TranslationService translationService;

  private final ModelMapper modelMapper;

  public TranslationController(TranslationService translationService,
      ModelMapper modelMapper) {
    super(Translation.class, TranslationDto.class);
    this.translationService = translationService;
    this.modelMapper = modelMapper;
  }

  @Override
  protected TranslationService getService() {
    return translationService;
  }

  @Override
  protected ModelMapper getMapper() {
    return modelMapper;
  }
}
