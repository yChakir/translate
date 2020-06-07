package ma.tiwtiw.translate.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import ma.tiwtiw.core.controller.impl.BaseRestController;
import ma.tiwtiw.translate.dto.TranslationDto;
import ma.tiwtiw.translate.model.Translation;
import ma.tiwtiw.translate.service.TranslationService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("labels/{locale}")
  public ResponseEntity<Map<String, String>> find(@PathVariable String locale) {
    Map<String, String> response = new HashMap<>();

    final List<Translation> translations = translationService.findAllByLocale(locale);

    translations.forEach(translation -> translation.getLabels().forEach(label -> {
      if (label.getLocale().equals(locale)) {
        response.put(translation.getCode(), label.getValue());
      }
    }));

    return ResponseEntity.ok(response);
  }
}
