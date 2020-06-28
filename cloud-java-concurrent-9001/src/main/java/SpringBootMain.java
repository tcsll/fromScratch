import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ：shill
 * @date ：Created in 2020/6/28 16:32
 * @description :
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class,args);
    }
}
