package shortener;

import org.springframework.data.annotation.Id;

public class Url {

  @Id
  public String id;

  public String site;
  public String shortKey;

  public Url() {}

  public Url(String site, String shortKey) {
    this.site = site;
    this.shortKey = shortKey;
  }

  @Override
  public String toString() {
    return String.format(
        "Url[id=%s, site='%s', shortKey='%s']",
        id, site, shortKey);
  }

}