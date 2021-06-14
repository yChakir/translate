package ma.tiwtiw.savBiomedical.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ma.tiwtiw.core.model.BaseModel;
import org.springframework.data.mongodb.core.index.Indexed;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Translation extends BaseModel<String> {

  @Indexed(unique = true)
  private String code;

  @Default
  private List<Label> labels = new ArrayList<>();

  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  public static class Label {

    private String locale;

    private String value;
  }
}
