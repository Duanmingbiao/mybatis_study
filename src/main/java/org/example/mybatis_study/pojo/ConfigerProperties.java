package org.example.mybatis_study.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ConfigurationProperties(prefix = "spring.datasource")
@Component
public class ConfigerProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
