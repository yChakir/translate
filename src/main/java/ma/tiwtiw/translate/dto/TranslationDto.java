package ma.tiwtiw.translate.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.tiwtiw.core.dto.BaseDto;
import ma.tiwtiw.translate.model.Translation;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class TranslationDto extends BaseDto<Translation, String> {

  private String code;

  private List<LabelDto> labels;

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class LabelDto {

    private String locale;

    private String value;
  }
}
