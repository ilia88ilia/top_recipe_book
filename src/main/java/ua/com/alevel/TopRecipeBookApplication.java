package ua.com.alevel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.alevel.elastic.document.PostIndex;
import ua.com.alevel.persistence.repository.user.AdminRepository;
import ua.com.alevel.persistence.repository.user.PersonalRepository;

import javax.annotation.PreDestroy;


@EnableScheduling
@SpringBootApplication
public class TopRecipeBookApplication {

    @Value("${initPersonals}")
    private boolean initPersonals;

    private final AdminRepository adminRepository;
    private final PersonalRepository personalRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ElasticsearchOperations elasticsearchOperations;

    public TopRecipeBookApplication(
            AdminRepository adminRepository,
            PersonalRepository personalRepository,
            BCryptPasswordEncoder bCryptPasswordEncoder,
            ElasticsearchOperations elasticsearchOperations) {
        this.adminRepository = adminRepository;
        this.personalRepository = personalRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public static void main(String[] args) {
        SpringApplication.run(TopRecipeBookApplication.class, args);
    }

    @PreDestroy
    public void resetElastic() {
        elasticsearchOperations.indexOps(PostIndex.class).delete();
    }
}
