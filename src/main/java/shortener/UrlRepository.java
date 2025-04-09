package shortener;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UrlRepository extends MongoRepository<Url, String> {

  public Url findBySite(String site);
  public Url findByShortKey(String shortKey);

}